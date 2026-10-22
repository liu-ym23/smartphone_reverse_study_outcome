package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.wallet.model.OrderParamsKey;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.network.ThreadPoolApi;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public class LSPreconnManager {
    static final int DEFAULT_QUIC_PORT = 80;
    static final String TAG = "LSPreconnManager";
    private LSPreconnDataHandle dataHandle;
    private boolean mAccessPermission;
    private Context mContext;
    private boolean mDidPreconnSucced;
    private OnPreconnMessageListener mListener;
    private PreconnResultCallBack mPreconnResultCallBack;
    private String mScfgPath;
    private final ThreadPoolApi mThreadPoolApi;
    private LSPreconnTask.LSPreconnTaskHandler preconnTaskHandler;

    public class ConnectionInfo {
        private String domain;

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        private String f459725ip;
        PROTOCOL protocol;
        final /* synthetic */ LSPreconnManager this$0;

        public ConnectionInfo(LSPreconnManager r100) {
            this.this$0 = r100;
            this.domain = "";
            this.f459725ip = "";
        }

        public static /* synthetic */ String access$300(ConnectionInfo r100) {
            return r100.domain;
        }

        public static /* synthetic */ String access$400(ConnectionInfo r100) {
            return r100.f459725ip;
        }

        public static /* synthetic */ String access$302(ConnectionInfo r100, String r101) {
            r100.domain = r101;
            return r101;
        }

        public static /* synthetic */ String access$402(ConnectionInfo r100, String r101) {
            r100.f459725ip = r101;
            return r101;
        }
    }

    public static class LSPreconnManagerInstance {
        private static final LSPreconnManager mInstance = null;

        private LSPreconnManagerInstance() {
        }

        static {
            mInstance = new LSPreconnManager();
        }

        public static /* synthetic */ LSPreconnManager access$200() {
            return mInstance;
        }
    }

    public interface OnPreconnMessageListener {
        String onPreconnMessageListener(String r100);
    }

    public static final enum PROTOCOL extends Enum<PROTOCOL> {
        private static final /* synthetic */ PROTOCOL[] $VALUES = null;
        public static final PROTOCOL H2Q = null;
        public static final PROTOCOL QUIC = null;

        static {
            PROTOCOL r100 = new PROTOCOL("QUIC", 0);
            QUIC = r100;
            PROTOCOL r101 = new PROTOCOL("H2Q", 1);
            H2Q = r101;
            $VALUES = new PROTOCOL[]{r100, r101};
        }

        public static PROTOCOL[] values() {
            return (PROTOCOL[]) $VALUES.clone();
        }

        public static PROTOCOL valueOf(String r100) {
            return (PROTOCOL) a.a(PROTOCOL.class, r100);
        }

        private PROTOCOL(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class PreconnInfo {

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        private String f459726ip;
        private long mLastUpdateTs;
        final /* synthetic */ LSPreconnManager this$0;

        public PreconnInfo(LSPreconnManager r100) {
            this.this$0 = r100;
            this.f459726ip = "0.0.0.0";
            this.mLastUpdateTs = -1;
        }

        public void updateResult(String r100, int r101) {
            this.f459726ip = r100;
            this.mLastUpdateTs = System.currentTimeMillis();
        }
    }

    public interface PreconnResultCallBack {

        public static class PreconnResult {
            public String host;

            /* JADX INFO: renamed from: ip, reason: collision with root package name */
            public String f459727ip;
            public int ret;

            public PreconnResult(String r100, String r101, int r102) {
                this.ret = r102;
                this.f459727ip = r101;
                this.host = r100;
            }
        }

        void onConnected(PreconnResult r100);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private boolean __aquireReflectionAccessPermission() {
        Boolean r100 = Boolean.TRUE;
        Class r101 = INVOKESTATIC_com_ss_videoarch_strategy_strategy_networkStrategy_LSPreconnManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.videoarch.live.ttquic.ContextUtils");     // Catch: Throwable -> L10
        if (r101 == null) goto L6;
        Method r102 = r101.getMethod("initApplicationContext", new Class[]{Context.class});     // Catch: Throwable -> L10
        r102.setAccessible(true);     // Catch: Throwable -> L10
        r102.invoke(null, new Object[]{this.mContext.getApplicationContext()});     // Catch: Throwable -> L10
    L6:
        Class r103 = INVOKESTATIC_com_ss_videoarch_strategy_strategy_networkStrategy_LSPreconnManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.videoarch.live.ttquic.JNIUtils");     // Catch: Throwable -> L10
        if (r103 == null) goto L12;
        Method r104 = r103.getMethod("setClassLoader", new Class[]{ClassLoader.class});     // Catch: Throwable -> L10
        r104.setAccessible(true);     // Catch: Throwable -> L10
        r104.invoke(null, new Object[]{this.mContext.getClassLoader()});     // Catch: Throwable -> L10
    L12:
        boolean r105 = r100.booleanValue();
        this.mAccessPermission = r105;
        return r105;
    L10:
        th = move-exception;
        Boolean r106 = Boolean.FALSE;
        th.toString();
        r100 = r106;
        goto L12
    }

    public LSPreconnManager() {
        this.mScfgPath = null;
        this.mContext = null;
        this.mAccessPermission = false;
        this.mDidPreconnSucced = false;
        this.dataHandle = new LSPreconnDataHandle();
        this.mThreadPoolApi = new ThreadPoolApi();
        this.preconnTaskHandler = new AnonymousClass1(this);
    }

    public static LSPreconnManager inst() {
        return LSPreconnManagerInstance.access$200();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_strategy_strategy_networkStrategy_LSPreconnManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private ConnectionInfo __getConnectionInfoFromStreamInfo(JSONObject r100) {
        ConnectionInfo r101 = new ConnectionInfo(this);
        JSONObject r102 = null;
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r100, "data");     // Catch: Throwable -> L28 JSONException -> L30
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r103, PlayerResolution.SDKKEY.ORIGIN), PullConfiguration.PROCESS_NAME_MAIN);     // Catch: Throwable -> L28 JSONException -> L30
        JSONObject r105 = new JSONObject(r104.optString(OrderParamsKey.KEY_SDK_PARAM));     // Catch: MalformedURLException -> L24 JSONException -> L26
        String r106 = r105.optString("SuggestFormat");     // Catch: MalformedURLException -> L20 Throwable -> L22
        String r107 = r105.optString("SuggestProtocol");     // Catch: MalformedURLException -> L20 Throwable -> L22
        Objects.toString(r103);     // Catch: MalformedURLException -> L20 Throwable -> L22
        r104.toString();     // Catch: MalformedURLException -> L20 Throwable -> L22
        r105.toString();     // Catch: MalformedURLException -> L20 Throwable -> L22
        if (TextUtils.isEmpty(r107) == false) goto L12;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mUseH2QByDefault != 1) goto L12;
        r107 = "h2q";
    L12:
        if (r107.equals("quic") == false) goto L15;
        r101.protocol = PROTOCOL.QUIC;     // Catch: MalformedURLException -> L20 Throwable -> L22
    L17:
        ConnectionInfo.access$302(r101, new URL(r104.optString(r106)).getHost());     // Catch: MalformedURLException -> L20 Throwable -> L22
        startIPRace(ConnectionInfo.access$300(r101));     // Catch: MalformedURLException -> L20 Throwable -> L22
    L33:
        return r101;
    L15:
        if (r107.equals("h2q") == false) goto L18;
        r101.protocol = PROTOCOL.H2Q;     // Catch: MalformedURLException -> L20 Throwable -> L22
        goto L17
    L18:
        Objects.toString(r101.protocol);     // Catch: MalformedURLException -> L20 Throwable -> L22
        return r101;
    L22:
        e = e;
        r102 = r105;
    L32:
        Objects.toString(r102);
        Objects.toString(r104);
        e.printStackTrace();
        goto L33
    L24:
        e = e;
    L26:
        e = e;
    L28:
        e = e;
        r104 = null;
        goto L32
    }

    public static /* synthetic */ boolean access$000(LSPreconnManager r100) {
        return r100.mDidPreconnSucced;
    }

    public static /* synthetic */ PreconnResultCallBack access$100(LSPreconnManager r100) {
        return r100.mPreconnResultCallBack;
    }

    private void startIPRace(String r100) {
        DnsOptimizer.inst().startIPRace(r100);
    }

    public String getPreconnIp(String r100) {
        return this.dataHandle.getPreconnIp(r100);
    }

    public void preconnect(String r100) {
        r100.length();
        if (TextUtils.isEmpty(r100) == false) goto L20;
        return;
    L20:
        ConnectionInfo r101 = __getConnectionInfoFromStreamInfo(new JSONObject(new JSONObject(r100).optString("stream_info")));     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(ConnectionInfo.access$300(r101)) == false) goto L8;
        return;
    L8:
        ConnectionInfo.access$300(r101);     // Catch: JSONException -> L17
        OnPreconnMessageListener r102 = this.mListener;     // Catch: JSONException -> L17
        if (r102 != null) goto L11;
        return;
    L11:
        ConnectionInfo.access$402(r101, r102.onPreconnMessageListener(ConnectionInfo.access$300(r101)));     // Catch: JSONException -> L17
        String r103 = ConnectionInfo.access$300(r101);     // Catch: JSONException -> L17
        String r104 = ConnectionInfo.access$400(r101);     // Catch: JSONException -> L17
        if (r101.protocol != PROTOCOL.QUIC) goto L14;
        boolean r105 = true;
    L15:
        __dopreconnect(r103, r104, r105);     // Catch: JSONException -> L17
        return;
    L14:
        r105 = false;
    L17:
        e = move-exception;
        e.toString();
    }

    public void setAppInfoBundle(Context r100) {
        this.mContext = r100;
        __aquireReflectionAccessPermission();
        this.mScfgPath = this.mContext.getFilesDir().getAbsolutePath() + "/pullstream.scfg";
    }

    public void setLSConnectToggles(LSPreconnDataHandle.PreconnToggles r100) {
        this.dataHandle.setLSConnectToggles(r100);
    }

    public void setListener(OnPreconnMessageListener r100) {
        this.mListener = r100;
    }

    public void setPreconnResultCallBack(PreconnResultCallBack r100) {
        this.mPreconnResultCallBack = r100;
    }

    public static /* synthetic */ boolean access$002(LSPreconnManager r100, boolean r101) {
        r100.mDidPreconnSucced = r101;
        return r101;
    }

    public void preconnect(String r100, String r101) {
        __dopreconnect(r100, r101, true);
    }

    private int __dopreconnect(String r110, String r111, boolean r112) {
        if (this.mAccessPermission == true) goto L9;
        if (__aquireReflectionAccessPermission() == false) goto L9;
        toString();
        return 0;
    L9:
        if (TextUtils.isEmpty(r111) == true) goto L16;
        if (TextUtils.isEmpty(r110) == true) goto L16;
        String r100 = this.mScfgPath;
        LSPreconnTask r101 = new LSPreconnTask(this.preconnTaskHandler, r110, r111, 80, r100, r112);
        this.mThreadPoolApi.execute(r101);
        return 0;
    L16:
        return -1;
    }

    public void setliveStartingTogglesFromStreamInfo(String r110, int r111, String r112) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        LSPreconnDataHandle.LiveStartOptToggles r100 = new LSPreconnDataHandle.LiveStartOptToggles();
        r100.suggestSendingRate = r111;
        r100.networkType = r112;
        JSONObject r113 = null;
        JSONObject r114 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(new JSONObject(new JSONObject(r110).optString("stream_info")), "data"), PlayerResolution.SDKKEY.ORIGIN), PullConfiguration.PROCESS_NAME_MAIN);     // Catch: JSONException -> L46
        JSONObject r101 = new JSONObject(r114.optString(OrderParamsKey.KEY_SDK_PARAM));     // Catch: JSONException -> L44
    L42:
        JSONException e100 = e;
    L48:
        Objects.toString(r101);
        Objects.toString(r114);
        e100.printStackTrace();
        return;
    L9:
        if (r101.has("EnableLiveStartingOpt") == false) goto L14;
        boolean r102 = true;
        if (r101.optInt("EnableLiveStartingOpt") == 1) goto L15;
        r102 = false;
    L15:
        r100.enableLiveStartingOpt = r102;     // Catch: JSONException -> L42
        if (r101.has("EnableNetworkClass") == false) goto L18;
        String r115 = r101.optString("EnableNetworkClass");     // Catch: JSONException -> L42
    L19:
        r100.enableNetworkClass = r115;     // Catch: JSONException -> L42
        if (r101.has("EnableSuggestSendingRate") == false) goto L22;
        int r116 = r101.optInt("EnableSuggestSendingRate");     // Catch: JSONException -> L42
    L23:
        r100.enableSuggestSendingRate = r116;     // Catch: JSONException -> L42
        if (r101.has("httpx") == false) goto L26;
        r113 = r101.optJSONObject("httpx");     // Catch: JSONException -> L42
    L26:
        if (r113 != null) goto L28;
    L40:
        this.dataHandle.setLiveStartOptToggles(r100);     // Catch: JSONException -> L42
        return;
    L28:
        if (r113.has("HttpConfigJson") == false) goto L30;
        String r117 = r113.optString("HttpConfigJson");     // Catch: JSONException -> L42
    L31:
        r100.httpConfigJson = r117;     // Catch: JSONException -> L42
        if (r113.has("UseLSQUIC") == false) goto L34;
        int r118 = r113.optInt("UseLSQUIC");     // Catch: JSONException -> L42
    L35:
        r100.UseLSQUIC = r118;     // Catch: JSONException -> L42
        if (r113.has("LSEngineParamJson") == false) goto L38;
        String r119 = r113.optString("LSEngineParamJson");     // Catch: JSONException -> L42
    L39:
        r100.LSEngineParamJson = r119;     // Catch: JSONException -> L42
        goto L40
    L38:
        r119 = r100.LSEngineParamJson;     // Catch: JSONException -> L42
        goto L39
    L34:
        r118 = r100.UseLSQUIC;     // Catch: JSONException -> L42
        goto L35
    L30:
        r117 = r100.httpConfigJson;     // Catch: JSONException -> L42
        goto L31
    L22:
        r116 = r100.enableSuggestSendingRate;     // Catch: JSONException -> L42
        goto L23
    L18:
        r115 = r100.enableNetworkClass;     // Catch: JSONException -> L42
        goto L19
    L14:
        r102 = r100.enableLiveStartingOpt;     // Catch: JSONException -> L42
    L44:
        e = move-exception;
        r101 = null;
        e100 = e;
    L46:
        e = move-exception;
        r101 = null;
        e100 = e;
        r114 = null;
        goto L48
    }
}
