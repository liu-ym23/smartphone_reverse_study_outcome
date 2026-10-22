package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.http.util.h;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ttnet.tnc.TNCManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class URLDispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = null;
    private static final String TNC_SP_NAME = "ttnet_tnc_config";
    private static volatile URLDispatcher mInstance;
    private static AtomicBoolean mLocalConfigLoaded;
    private Context mContext;
    private List<DelayTypedAction> mDelayActions;
    private final ReentrantReadWriteLock mDelayActionslock;
    private AtomicLong mDispatchActionEpoch;
    private List<URLDispatchAction> mDispatchActions;
    private final ReentrantReadWriteLock mDispatchActionslock;
    private AtomicBoolean mDispatcherEnabled;
    private ConcurrentMap<String, String> mHostReplaceMap;
    private String mTncAbTest;
    private String mTncEtag;
    private AtomicInteger mTncUpdateSource;
    private AtomicLong mTncUpdateTime;

    public static class ActionComparator implements Comparator<BaseDispatchAction> {
        public ActionComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(BaseDispatchAction r100, BaseDispatchAction r101) {
            return r100.getPriority() - r101.getPriority();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(BaseDispatchAction r100, BaseDispatchAction r101) {
            return compare2(r100, r101);
        }
    }

    static {
        TAG = "URLDispatcher";
        mLocalConfigLoaded = new AtomicBoolean(false);
    }

    public static URLDispatcher inst() {
        if (mInstance != null) goto L15;
        monitor-enter(URLDispatcher.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new URLDispatcher();     // Catch: Throwable -> L11
    L9:
        monitor-exit(URLDispatcher.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public long getEpoch() {
        return this.mDispatchActionEpoch.get();
    }

    public int getTncUpdateSource() {
        return this.mTncUpdateSource.get();
    }

    public long getTncUpdateTime() {
        return this.mTncUpdateTime.get();
    }

    public boolean isDispatchActionsEmpty() {
        return this.mDispatchActions.isEmpty();
    }

    public boolean isDispatchDelayEnabled() {
        return !this.mDelayActions.isEmpty();
    }

    public URLDispatcher() {
        this.mContext = null;
        this.mDispatcherEnabled = new AtomicBoolean(true);
        this.mDispatchActionEpoch = new AtomicLong(0);
        this.mDispatchActions = new ArrayList();
        this.mDispatchActionslock = new ReentrantReadWriteLock();
        this.mDelayActions = new ArrayList();
        this.mDelayActionslock = new ReentrantReadWriteLock();
        this.mTncUpdateSource = new AtomicInteger(0);
        this.mTncUpdateTime = new AtomicLong(0);
        this.mHostReplaceMap = new ConcurrentHashMap();
    }

    public Context getContext() {
        return this.mContext;
    }

    public ConcurrentMap<String, String> getHostReplaceMap() {
        return this.mHostReplaceMap;
    }

    public String getTncAbTest() {
        return this.mTncAbTest;
    }

    public String getTncEtag() {
        return this.mTncEtag;
    }

    private DispatchResult doDispatch(URLRequest r110) {
        String r100 = r110.getOriginUrl();
        DispatchResult r101 = new DispatchResult();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ListProtector.add(r103, 0, r100);
        this.mDispatchActionslock.readLock().lock();
        Iterator<URLDispatchAction> r104 = this.mDispatchActions.iterator();
        String r105 = r100;
    L4:
        if (r104.hasNext() == false) goto L15;
        URLDispatchAction r106 = r104.next();
        if (Logger.debug() == false) goto L8;
        String r107 = TAG;
        Logger.d(r107, "action url = " + r103);
        Logger.d(r107, "current action priority is " + r106.getPriority());
    L8:
        BaseDispatchAction.DispatchResultEnum r108 = r106.takeAction(r110, r105, r103, r102);
        String r109 = (String) ListProtector.get(r103, 0);
        if (r108 == BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP) goto L11;
        r105 = r109;
        goto L4
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "the url has been dropped by urldispatcher, skip follow-up actions");
    L13:
        r101.mDropCode = r106.getTcTypedDropCode();
    L15:
        String r111 = (String) ListProtector.get(r103, 0);
        this.mDispatchActionslock.readLock().unlock();
        ArrayList r112 = new ArrayList();
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L25
        r113.put("origin_url", r100);     // Catch: JSONException -> L25
        r113.put("dispatched_url", r111);     // Catch: JSONException -> L25
        JSONArray r114 = new JSONArray();     // Catch: JSONException -> L25
        Iterator r115 = r102.iterator();     // Catch: JSONException -> L25
    L18:
        if (r115.hasNext() == false) goto L23;
        DispatchActionInfo r116 = (DispatchActionInfo) r115.next();     // Catch: JSONException -> L25
        if (r116.mActionHit == false) goto L18;
        JSONObject r117 = new JSONObject();     // Catch: JSONException -> L25
        r112.add(Long.valueOf(r116.mRuleid));     // Catch: JSONException -> L25
        r117.put("rule_id", r116.mRuleid);     // Catch: JSONException -> L25
        r117.put("service_name", r116.mServiceName);     // Catch: JSONException -> L25
        r117.put("priority", r116.mPriority);     // Catch: JSONException -> L25
        r114.put(r117);     // Catch: JSONException -> L25
        goto L18
    L23:
        r113.put("action_info_list", r114);     // Catch: JSONException -> L25
        JSONObject r118 = new JSONObject();     // Catch: JSONException -> L25
        r118.put("dispatch", r113);     // Catch: JSONException -> L25
        new JSONObject().put("dispatchersdk", r118);     // Catch: JSONException -> L25
    L27:
        r101.mActionRuleIdList = r112;
        r101.mDispatchedURL = r111;
        r101.mDispatchActionChain = r102;
        return r101;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    private void parseAction(JSONObject r210) {
        String r100 = r210.optString("action");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r101 = r210.optInt("act_priority", -1);
        if (r101 >= 0) goto L8;
        return;
    L8:
        JSONObject r102 = r210.optJSONObject("param");
        if (r102 != null) goto L11;
        return;
    L11:
        String r103 = r210.optString(NewBroadcastMonitor.STAGE.LIFECYCLE);
        int r104 = 0;
        if ("".equals(r103) == false) goto L14;
        long r105 = 0;
    L20:
        long r110 = r105;
    L21:
        long r111 = r210.optInt("rule_id");
        String r106 = r210.optString("sign");
        ArrayList r112 = new ArrayList();
        JSONArray r107 = r210.optJSONArray("request_method");
        if (r107 != null) goto L24;
    L29:
        long r108 = r105;
        long r109 = r110;
        BaseDispatchAction r113 = BaseDispatchAction.factory(r100, r102, r101, r108, r109, r111, r106, this.mDispatchActionEpoch.get(), r112, r210.optInt("set_req_priority", r101));
        if ((r113 instanceof URLDispatchAction) == false) goto L36;
        this.mDispatchActions.add((URLDispatchAction) r113);
        return;
    L36:
        return;
    L24:
        if (r104 >= r107.length()) goto L29;
        String r114 = r107.optString(r104);
        if (TextUtils.isEmpty(r114) == true) goto L28;
        r112.add(r114);
    L28:
        r104 = r104 + 1;
        goto L24
    L14:
        ArrayList r115 = new ArrayList();
        if (h.d(r103, r115) == true) goto L17;
    L19:
        r105 = -1;
        goto L20
    L17:
        if (r115.size() != 2) goto L19;
        long r116 = ((Long) ListProtector.get(r115, 0)).longValue();
        r110 = ((Long) ListProtector.get(r115, 1)).longValue();
        r105 = r116;
        goto L21
    }

    private void parseDelayAction(JSONObject r110) {
        int r100 = r110.optInt("act_priority", -1);
        if (r100 >= 0) goto L5;
        return;
    L5:
        JSONObject r101 = r110.optJSONObject("param");
        if (r101 != null) goto L8;
        return;
    L8:
        String r102 = r110.optString(NewBroadcastMonitor.STAGE.LIFECYCLE);
        if ("".equals(r102) == false) goto L11;
        long r103 = 0;
    L17:
        long r104 = r103;
        long r105 = r104;
    L18:
        BaseDispatchAction r106 = BaseDispatchAction.factory("delay", r101, r100, r104, r105, 0, "", this.mDispatchActionEpoch.get(), null, 0);
        if ((r106 instanceof DelayTypedAction) == false) goto L22;
        this.mDelayActions.add((DelayTypedAction) r106);
        return;
    L22:
        return;
    L11:
        ArrayList r107 = new ArrayList();
        if (h.d(r102, r107) == true) goto L14;
    L16:
        r103 = -1;
        goto L17
    L14:
        if (r107.size() != 2) goto L16;
        r104 = ((Long) ListProtector.get(r107, 0)).longValue();
        r105 = ((Long) ListProtector.get(r107, 1)).longValue();
        goto L18
    }

    public DispatchResult getDispatchResultForUrl(URLRequest r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getDispatchResultForUrl: " + r100.getOriginUrl());
    L6:
        if (UrlUtils.isValidUrl(r100.getOriginUrl()) == true) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "illegal url");
    L10:
        return null;
    L12:
        if (this.mDispatcherEnabled.get() == true) goto L18;
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "dispatch is unabled by tnc");
    L16:
        return null;
    L18:
        return doDispatch(r100);
    }

    public String handleHostMapping(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L50:
        return r100;
    L5:
        if (r100.contains("/network/get_network") == true) goto L50;
        if (r100.contains("/get_domains/v5") == true) goto L50;
        if (r100.contains("/ies/speed") == true) goto L50;
        String r101 = null;
        URL r102 = new URL(r100);     // Catch: Throwable -> L17
        String r103 = r102.getProtocol();     // Catch: Throwable -> L17
        r101 = r102.getHost();     // Catch: Throwable -> L15
    L21:
        if (TextUtils.isEmpty(r103) == true) goto L50;
        if ("http".equals(r103) == true) goto L27;
        if ("https".equals(r103) == false) goto L50;
    L27:
        if (TextUtils.isEmpty(r101) == true) goto L50;
        ConcurrentMap<String, String> r104 = this.mHostReplaceMap;
        if (r104 == null) goto L48;
        if (r104.containsKey(r101) == false) goto L48;
        String r105 = this.mHostReplaceMap.get(r101);
        if (TextUtils.isEmpty(r105) == false) goto L38;
        return r100;
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "handleHostMapping, match, origin: ".concat(r100));
    L40:
        String r106 = r103 + "://" + r101;
        String r107 = r103 + "://" + r105;
        if (r100.startsWith(r106) == false) goto L44;
        r100 = r100.replaceFirst(r106, r107);
    L44:
        if (Logger.debug() == false) goto L46;
        Logger.d(TAG, "handleHostMapping, target: " + r100);
    L46:
        return r100;
    L48:
        if (Logger.debug() == false) goto L50;
        Logger.d(TAG, "handleHostMapping, nomatch: " + r101);
    L15:
        th = th;
    L19:
        th.printStackTrace();
    L17:
        th = th;
        r103 = null;
        goto L19
    }

    public void loadLocalConfig(Context r110) {
        if (i.d(r110) == true) goto L5;
        return;
    L5:
        if (mLocalConfigLoaded.get() == true) goto L23;
        SharedPreferences r111 = r110.getSharedPreferences("ttnet_tnc_config", 0);
        boolean r100 = r111.getBoolean("is_full_config", false);
        String r101 = r111.getString(TNCManager.TNC_CONFIG_STR, null);
        String r102 = r111.getString(TNCManager.TNC_ETAG_NAME, null);
        String r103 = r111.getString(TNCManager.TNC_ABTEST_NAME, null);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        mLocalConfigLoaded.set(true);
        return;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        JSONObject r112 = new JSONObject(r101);     // Catch: JSONException -> L16
        if (r100 == false) goto L14;
        JSONObject r104 = r112.optJSONObject("data");     // Catch: JSONException -> L16
        if (r104 == null) goto L14;
        r112 = r104;
    L14:
        URLDispatcher r105 = inst();     // Catch: JSONException -> L16
        r105.onServerConfigChanged(r112, 0, r102, r103, System.currentTimeMillis());     // Catch: JSONException -> L16
        goto L18
    }

    public void setContext(Context r100) {
        this.mContext = r100;
    }

    public void setTncAbTest(String r100) {
        this.mTncAbTest = r100;
    }

    public int getDelayResult(String r100, String r101) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getDelayResultForUrl: " + r100);
    L6:
        if (UrlUtils.isValidUrl(r100) == false) goto L8;
        this.mDelayActionslock.readLock().lock();
        ArrayList r102 = new ArrayList();
        ListProtector.add(r102, 0, 0);
        Iterator<DelayTypedAction> r103 = this.mDelayActions.iterator();
    L13:
        if (r103.hasNext() == false) goto L22;
        DelayTypedAction r104 = r103.next();
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "current action priority is " + r104.getPriority());
    L18:
        if (r104.takeDelayAction(r100, r101, r102) != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L13;
        if (Logger.debug() == false) goto L22;
        Logger.d(TAG, "the url has been delayed by delay action, skip follow-up actions");
    L22:
        this.mDelayActionslock.readLock().unlock();
        return ((Integer) ListProtector.get(r102, 0)).intValue();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "illegal url");
    L10:
        return 0;
    }

    public void onServerConfigChanged(JSONObject r100, int r101, String r102, String r103, long r110) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "URLDispatcher::onServerConfigChanged, tnc source is " + r101 + "etag is " + r102);
    L5:
        this.mTncUpdateSource.set(r101);
        this.mTncEtag = r102;
        this.mTncAbTest = r103;
        this.mTncUpdateTime.set(r110);
        int r104 = r100.optInt("ignore_retrofit_slash_enabled_v2", -1);
        int r105 = 0;
        boolean r111 = true;
        if (r104 < (-1)) goto L11;
        if (r104 != 1) goto L9;
        boolean r106 = true;
    L10:
        TTConfigManager.setIgnoreSlashEnabledV2(r106);
        goto L11
    L9:
        r106 = false;
    L11:
        JSONArray r107 = r100.optJSONArray("request_delay_actions");
        this.mDelayActionslock.writeLock().lock();     // Catch: Throwable -> L62
        this.mDelayActions.clear();     // Catch: Throwable -> L62
        if (r107 == null) goto L22;
        int r112 = 0;
    L16:
        if (r112 >= r107.length()) goto L22;
        JSONObject r108 = r107.optJSONObject(r112);     // Catch: Throwable -> L62
        if (r108 == null) goto L20;
        parseDelayAction(r108);     // Catch: Throwable -> L62
    L20:
        r112 = r112 + 1;     // Catch: Throwable -> L62
    L22:
        if (this.mDelayActions.isEmpty() == true) goto L24;
        Collections.sort(this.mDelayActions, new ActionComparator());     // Catch: Throwable -> L62
    L24:
        this.mDelayActionslock.writeLock().unlock();
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "parse delay actions completed, actions size is " + this.mDelayActions.size());
    L27:
        int r109 = r100.optInt("ttnet_url_dispatcher_enabled", -1);
        if (r109 < 0) goto L34;
        AtomicBoolean r113 = this.mDispatcherEnabled;
        if (r109 == 1) goto L33;
        r111 = false;
    L33:
        r113.set(r111);
    L34:
        long r114 = r100.optInt("ttnet_dispatch_actions_epoch", -1);
        if (r114 == this.mDispatchActionEpoch.get()) goto L37;
        this.mDispatchActionEpoch.set(r114);
        JSONArray r115 = r100.optJSONArray("ttnet_dispatch_actions");
        if (r115 != null) goto L67;
        return;
    L67:
        this.mDispatchActionslock.writeLock().lock();     // Catch: Throwable -> L57
        this.mDispatchActions.clear();     // Catch: Throwable -> L57
    L45:
        if (r105 >= r115.length()) goto L51;
        JSONObject r116 = r115.optJSONObject(r105);     // Catch: Throwable -> L57
        if (r116 == null) goto L49;
        parseAction(r116);     // Catch: Throwable -> L57
    L49:
        r105 = r105 + 1;     // Catch: Throwable -> L57
        goto L45
    L51:
        if (this.mDispatchActions.isEmpty() == true) goto L53;
        Collections.sort(this.mDispatchActions, new ActionComparator());     // Catch: Throwable -> L57
    L53:
        this.mDispatchActionslock.writeLock().unlock();
        if (Logger.debug() == false) goto L78;
        Logger.d(TAG, "parse dispatch actions completed, actions size is " + this.mDispatchActions.size());
        return;
    L78:
        return;
    L57:
        th = move-exception;
        this.mDispatchActionslock.writeLock().unlock();
        if (Logger.debug() == false) goto L61;
        Logger.d(TAG, "parse dispatch actions completed, actions size is " + this.mDispatchActions.size());
    L61:
        throw th;
    L37:
        if (Logger.debug() == false) goto L77;
        Logger.d(TAG, "dispatch action epoch not changed");
        return;
    L77:
        return;
    L62:
        th = move-exception;
        this.mDelayActionslock.writeLock().unlock();
        if (Logger.debug() == false) goto L66;
        Logger.d(TAG, "parse delay actions completed, actions size is " + this.mDelayActions.size());
    L66:
        throw th;
    }
}
