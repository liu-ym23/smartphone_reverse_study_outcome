package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TCTypedAction extends URLDispatchAction {
    public static final int DEFAULT_DROP_CODE = -555;
    private static final int MAX_USER_DEFINED_DROP_CODE = -5551;
    private static final int MIN_USER_DEFINED_DROP_CODE = -5559;
    private static final String TAG = null;
    private int mDropCode;
    private String mHostReplace;
    private boolean mIsDrop;
    private boolean mIsInvalid;
    private String mPathReplace;
    private int mPossibility;
    private String mReplaceRegex;
    private String mReplaceValue;
    private String mSchemeReplace;

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getDispatchStrategyType() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public void onRequestCompleted(String r100, boolean r101, int r102) {
    }

    static {
        TAG = "TCTypedAction";
    }

    private boolean isPossibilityHit() {
        int r100 = this.mPossibility;
        if (r100 < 100) goto L6;
        return true;
    L6:
        if (r100 > 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(100) >= this.mPossibility) goto L12;
        return true;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "tc drop action was probabilistic discard");
    L14:
        return false;
    }

    public TCTypedAction() {
        this.mIsDrop = false;
        this.mDropCode = -555;
        this.mPossibility = 100;
        this.mIsInvalid = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getTcTypedDropCode() {
        return this.mDropCode;
    }

    private boolean canReplceScheme(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return false;
    L6:
        if (r100.equals(r101) == false) goto L9;
        return true;
    L9:
        if (r100.equals("http") == true) goto L13;
        if (r100.equals("https") == true) goto L13;
    L18:
        if (r100.equals("ws") == true) goto L22;
        if (r100.equals("wss") == true) goto L22;
    L26:
        return false;
    L22:
        if (r101.equals("ws") == false) goto L24;
    L27:
        return true;
    L24:
        if (r101.equals("wss") == false) goto L26;
    L13:
        if (r101.equals("http") == true) goto L27;
        if (r101.equals("https") == false) goto L18;
        goto L27
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public BaseDispatchAction.DispatchResultEnum dispatch(URLRequest r100, String r101, List<String> r102) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "tc action");
    L5:
        Uri r103 = UriProtector.parse(r101);
        if (this.mIsInvalid == false) goto L8;
    L53:
        ListProtector.set(r102, 0, r101);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L8:
        if (isMatchRules(r103) == false) goto L53;
        ListProtector.set(r102, 0, r101);
        if (this.mIsDrop == false) goto L22;
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "drop action");
    L16:
        if (isPossibilityHit() == false) goto L20;
        ListProtector.set(r102, 0, "");
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP;
    L20:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L22:
        if (this.mHostReplace.isEmpty() == false) goto L37;
        if (this.mSchemeReplace.isEmpty() == false) goto L37;
        if (this.mPathReplace.isEmpty() == false) goto L37;
        if (TextUtils.isEmpty(this.mReplaceValue) == true) goto L35;
        if (TextUtils.isEmpty(this.mReplaceRegex) == true) goto L35;
        ListProtector.set(r102, 0, r101.replaceAll(this.mReplaceRegex, this.mReplaceValue));
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L35:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L37:
        if (r103.getScheme() == null) goto L42;
        if (canReplceScheme(r103.getScheme(), this.mSchemeReplace) == false) goto L42;
        r101 = r101.replaceFirst(r103.getScheme(), this.mSchemeReplace);
    L42:
        if (r103.getHost() == null) goto L47;
        if (TextUtils.isEmpty(this.mHostReplace) == true) goto L47;
        r101 = r101.replaceFirst(r103.getHost(), this.mHostReplace);
    L47:
        if (r103.getPath() != null) goto L49;
    L51:
        ListProtector.set(r102, 0, r101);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L49:
        if (TextUtils.isEmpty(this.mPathReplace) == true) goto L51;
        r101 = r101.replaceFirst(r103.getPath(), this.mPathReplace);
        goto L51
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public boolean loadActionParam(JSONObject r100, List<Boolean> r101, String r102, long r103) {
        loadMatchRules(r100);
        this.mServiceName = r100.optString("service_name");
        this.mSchemeReplace = r100.optString("scheme_replace");
        this.mHostReplace = r100.optString("host_replace");
        this.mPathReplace = r100.optString("path_replace");
        String r104 = r100.optString("replace");
        this.mReplaceValue = r104;
        if (TextUtils.isEmpty(r104) == true) goto L10;
        String r105 = r100.optString("regex");
        if (BaseDispatchAction.isPatternStringValid(r105) == false) goto L7;
        this.mReplaceRegex = r105;
        goto L10
    L7:
        this.mIsInvalid = true;
        return true;
    L10:
        if (r100.optInt("drop") != 1) goto L12;
        boolean r106 = true;
    L13:
        this.mIsDrop = r106;
        int r107 = r100.optInt("drop_code", -1);
        if (r107 != (-555)) goto L16;
    L19:
        this.mDropCode = r107;
    L20:
        int r108 = r100.optInt("possibility", 100);
        if (r108 < 0) goto L25;
        if (r108 > 100) goto L25;
        this.mPossibility = r108;
    L25:
        if (this.mEqualGroup.isEmpty() == false) goto L35;
        if (this.mPrefixGroup.isEmpty() == false) goto L35;
        if (this.mContainGroup.isEmpty() == false) goto L35;
        if (this.mPatternGroup.isEmpty() == false) goto L35;
        if (this.mFullUrlGroup.isEmpty() == false) goto L35;
    L44:
        this.mIsInvalid = true;
    L45:
        ListProtector.set(r101, 0, Boolean.FALSE);
        return true;
    L35:
        if (this.mIsDrop == true) goto L45;
        if (this.mSchemeReplace.isEmpty() == false) goto L45;
        if (this.mHostReplace.isEmpty() == false) goto L45;
        if (this.mPathReplace.isEmpty() == false) goto L45;
        if (this.mReplaceValue.isEmpty() == false) goto L45;
    L16:
        if (r107 < (-5559)) goto L20;
        if (r107 > (-5551)) goto L20;
    L12:
        r106 = false;
        goto L13
    }
}
