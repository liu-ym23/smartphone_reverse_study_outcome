package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDispatchAction {
    private static final String TAG = null;
    protected List<String> mContainGroup;
    protected List<String> mEqualGroup;
    protected List<String> mFullUrlGroup;
    protected List<String> mFullUrlGroupPathContain;
    protected List<String> mHostGroup;
    private long mLifetimeBegin;
    private long mLifetimeEnd;
    protected List<String> mPatternGroup;
    protected List<String> mPrefixGroup;
    private int mPriority;
    private long mRuleId;
    protected String mServiceName;
    protected int mSetReqPriority;
    private List<String> mSupportedMethods;

    public static final enum DispatchResultEnum extends Enum<DispatchResultEnum> {
        private static final /* synthetic */ DispatchResultEnum[] $VALUES = null;
        public static final DispatchResultEnum DISPATCH_DELAY = null;
        public static final DispatchResultEnum DISPATCH_DROP = null;
        public static final DispatchResultEnum DISPATCH_HIT = null;
        public static final DispatchResultEnum DISPATCH_NONE = null;

        static {
            DispatchResultEnum r100 = new DispatchResultEnum("DISPATCH_NONE", 0);
            DISPATCH_NONE = r100;
            DispatchResultEnum r101 = new DispatchResultEnum("DISPATCH_HIT", 1);
            DISPATCH_HIT = r101;
            DispatchResultEnum r102 = new DispatchResultEnum("DISPATCH_DROP", 2);
            DISPATCH_DROP = r102;
            DispatchResultEnum r103 = new DispatchResultEnum("DISPATCH_DELAY", 3);
            DISPATCH_DELAY = r103;
            $VALUES = new DispatchResultEnum[]{r100, r101, r102, r103};
        }

        public static DispatchResultEnum[] values() {
            return (DispatchResultEnum[]) $VALUES.clone();
        }

        public static DispatchResultEnum valueOf(String r100) {
            return (DispatchResultEnum) a.a(DispatchResultEnum.class, r100);
        }

        private DispatchResultEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract boolean initWithActionParam(JSONObject r100, String r101, long r102);

    static {
        TAG = "BaseDispatchAction";
    }

    private boolean isLifeTimeEffective() {
        long r100 = this.mLifetimeBegin;
        if (r100 != 0) goto L8;
        if (this.mLifetimeEnd != 0) goto L8;
        return true;
    L8:
        if (r100 != (-1)) goto L10;
    L20:
        return false;
    L10:
        if (this.mLifetimeEnd == (-1)) goto L20;
        long r101 = System.currentTimeMillis();
        if (r101 <= this.mLifetimeBegin) goto L18;
        if (r101 >= this.mLifetimeEnd) goto L18;
        return true;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "current time is out action lifecycle");
        goto L20
    }

    public BaseDispatchAction() {
        this.mHostGroup = new ArrayList();
        this.mEqualGroup = new ArrayList();
        this.mPrefixGroup = new ArrayList();
        this.mContainGroup = new ArrayList();
        this.mPatternGroup = new ArrayList();
        this.mFullUrlGroup = new ArrayList();
        this.mFullUrlGroupPathContain = new ArrayList();
        this.mSupportedMethods = new ArrayList();
    }

    public boolean isDelayActionEffective() {
        return isLifeTimeEffective();
    }

    public int getPriority() {
        return this.mPriority;
    }

    public long getRuleId() {
        return this.mRuleId;
    }

    public String getServiceName() {
        return this.mServiceName;
    }

    public static boolean isPatternStringValid(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return false;
    L9:
        PatternProtector.compile(r100);     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }

    private void setPriority(int r100) {
        this.mPriority = r100;
    }

    private void setRuleId(long r100) {
        this.mRuleId = r100;
    }

    private void setSetRequestPriority(int r100) {
        if (r100 >= 0) goto L4;
        this.mSetReqPriority = Integer.MAX_VALUE;
        return;
    L4:
        this.mSetReqPriority = r100;
    }

    private void setSupportedMethods(List<String> r100) {
        this.mSupportedMethods = r100;
    }

    public boolean isActionEffective(URLRequest r100) {
        if (r100.getDispatchPriority() <= this.mPriority) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "jump action: " + this.mServiceName + ", dispatchPriority: " + r100.getDispatchPriority() + ", actionPriority: " + this.mPriority);
    L7:
        return false;
    L9:
        if (this.mSupportedMethods.isEmpty() == true) goto L19;
        if (TextUtils.isEmpty(r100.getMethod()) == true) goto L19;
        if (this.mSupportedMethods.contains(r100.getMethod()) == true) goto L19;
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "request method not support: " + r100.getMethod());
    L17:
        return false;
    L19:
        return isLifeTimeEffective();
    }

    public boolean isMatchRules(Uri r100) {
        if (this.mHostGroup.isEmpty() == false) goto L5;
    L4:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        String r102 = r100.getPath();
        if (TextUtils.isEmpty(r102) == false) goto L21;
        return false;
    L21:
        if (this.mEqualGroup.isEmpty() == true) goto L32;
        Iterator<String> r103 = this.mEqualGroup.iterator();
    L24:
        if (r103.hasNext() == false) goto L32;
        String r104 = r103.next();
        if (r102.equals(r104) == false) goto L24;
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "path equal hit: " + r104);
    L30:
        return true;
    L32:
        if (this.mPrefixGroup.isEmpty() == true) goto L43;
        Iterator<String> r105 = this.mPrefixGroup.iterator();
    L35:
        if (r105.hasNext() == false) goto L43;
        String r106 = r105.next();
        if (r102.startsWith(r106) == false) goto L35;
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "path prefix hit: " + r106);
    L41:
        return true;
    L43:
        if (this.mContainGroup.isEmpty() == true) goto L54;
        Iterator<String> r107 = this.mContainGroup.iterator();
    L46:
        if (r107.hasNext() == false) goto L54;
        String r108 = r107.next();
        if (r102.contains(r108) == false) goto L46;
        if (Logger.debug() == false) goto L52;
        Logger.d(TAG, "path contain hit: " + r108);
    L52:
        return true;
    L54:
        if (this.mPatternGroup.isEmpty() == true) goto L65;
        Iterator<String> r109 = this.mPatternGroup.iterator();
    L57:
        if (r109.hasNext() == false) goto L65;
        String r110 = r109.next();
        if (r102.matches(r110) == false) goto L57;
        if (Logger.debug() == false) goto L63;
        Logger.d(TAG, "path pattern hit: " + r110);
    L63:
        return true;
    L65:
        if (this.mFullUrlGroup.isEmpty() == false) goto L67;
    L86:
        return false;
    L67:
        if (this.mFullUrlGroupPathContain.isEmpty() == true) goto L77;
        Iterator<String> r111 = this.mFullUrlGroupPathContain.iterator();
    L70:
        if (r111.hasNext() == false) goto L74;
        if (r102.contains(r111.next()) == false) goto L70;
        boolean r112 = true;
    L75:
        if (r112 == true) goto L77;
        return false;
    L74:
        r112 = false;
    L77:
        Iterator<String> r113 = this.mFullUrlGroup.iterator();
    L79:
        if (r113.hasNext() == false) goto L86;
        String r114 = r113.next();
        if (r100.toString().matches(r114) == false) goto L79;
        if (Logger.debug() == false) goto L85;
        Logger.d(TAG, "full url hit: " + r114);
    L85:
        return true;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "host group is not match");
    L16:
        return false;
    L5:
        Iterator<String> r115 = this.mHostGroup.iterator();
    L7:
        if (r115.hasNext() == false) goto L11;
        if (UrlUtils.matchPattern(r100.getHost(), r115.next()) == false) goto L7;
    L11:
        r101 = false;
        goto L12
    }

    public void loadMatchRules(JSONObject r100) {
        loadParamList(r100, "host_group", this.mHostGroup, false);
        loadParamList(r100, "equal_group", this.mEqualGroup, false);
        loadParamList(r100, "prefixes_group", this.mPrefixGroup, false);
        loadParamList(r100, "contain_group", this.mContainGroup, false);
        loadParamList(r100, "pattern_group", this.mPatternGroup, true);
        loadParamList(r100, "url_group", this.mFullUrlGroup, true);
        loadParamList(r100, "path_contain", this.mFullUrlGroupPathContain, false);
    }

    private void setLifeCycle(long r100, long r101) {
        this.mLifetimeBegin = r100;
        this.mLifetimeEnd = r101;
    }

    private void loadParamList(JSONObject r100, String r101, List<String> r102, boolean r103) {
        JSONArray r104 = r100.optJSONArray(r101);
        if (r104 == null) goto L15;
        int r105 = 0;
    L6:
        if (r105 >= r104.length()) goto L21;
        String r106 = r104.optString(r105);
        if (TextUtils.isEmpty(r106) == true) goto L14;
        if (r103 == true) goto L11;
        r102.add(r106);
        goto L14
    L11:
        if (isPatternStringValid(r106) == false) goto L14;
        r102.add(r106);
    L14:
        r105 = r105 + 1;
        goto L6
    L21:
        return;
    }

    public static BaseDispatchAction factory(String r100, JSONObject r101, int r102, long r110, long r111, long r112, String r113, long r114, List<String> r115, int r210) {
        if (r100.equals("tc") == false) goto L5;
        BaseDispatchAction r103 = new TCTypedAction();
    L7:
        if (r100.equals("dispatch") == false) goto L10;
        r103 = new DispatchTypedAction();
    L10:
        if (r100.equals("delay") == false) goto L12;
        r103 = new DelayTypedAction();
    L12:
        if (r103 != null) goto L14;
        return null;
    L14:
        r103.setPriority(r102);
        r103.setLifeCycle(r110, r111);
        r103.setRuleId(r112);
        r103.setSupportedMethods(r115);
        r103.setSetRequestPriority(r210);
        if (r103.initWithActionParam(r101, r113, r114) == false) goto L17;
        return r103;
    L17:
        return null;
    L5:
        r103 = null;
        goto L7
    }
}
