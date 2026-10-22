package com.ss.videoarch.strategy.strategy.mpdPreload;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.wallet.model.OrderParamsKey;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttvideoengine.net.DNSParser;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import el9.a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class MpdPreloadManager {
    static final String TAG = "MpdPreloadManager";
    private Context mContext;
    private Boolean mInitialized;

    /* JADX INFO: renamed from: com.ss.videoarch.strategy.strategy.mpdPreload.MpdPreloadManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MpdPreloadManagerInstance {
        private static final MpdPreloadManager mInstance = null;

        private MpdPreloadManagerInstance() {
        }

        static {
            mInstance = new MpdPreloadManager(null);
        }

        public static /* synthetic */ MpdPreloadManager access$100() {
            return mInstance;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private native void nativeInit();

    public static synchronized MpdPreloadManager getInstance() {
        monitor-enter(MpdPreloadManager.class);
        MpdPreloadManager r100 = MpdPreloadManagerInstance.access$100();     // Catch: Throwable -> L7
        monitor-exit(MpdPreloadManager.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private void loadNative() {
        if (this.mInitialized.booleanValue() == false) goto L6;
        return;
    L6:
        if (VeLSUtils.isLoadSoSuccess() == true) goto L8;
        return;
    L8:
        SettingsManager.getInstance();
        nativeInit();
        this.mInitialized = Boolean.TRUE;
    }

    private MpdPreloadManager() {
        this.mContext = null;
        this.mInitialized = Boolean.FALSE;
    }

    public /* synthetic */ MpdPreloadManager(AnonymousClass1 r100) {
        this();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_strategy_strategy_mpdPreload_MpdPreloadManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public String GetPreloadInfo(String r110) {
        if (this.mInitialized.booleanValue() == true) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L9;
        return "";
    L9:
        if (this.mContext == null) goto L11;
        String r100 = this.mContext.getFilesDir().getAbsolutePath() + "/lspullstream.scfg";
    L84:
        JSONObject r111 = new JSONObject(r110);     // Catch: MalformedURLException -> L77 JSONException -> L79
        JSONObject r112 = new JSONObject(r111.optString("stream_info"));     // Catch: MalformedURLException -> L77 JSONException -> L79
        boolean r113 = r111.has("options");     // Catch: MalformedURLException -> L77 JSONException -> L79
        String r114 = PlayerResolution.SDKKEY.ORIGIN;
        int r115 = 0;
        if (r113 == false) goto L36;
        JSONObject r116 = new JSONObject(r111.optString("options"));     // Catch: MalformedURLException -> L77 JSONException -> L79
        if (r116.has("default_quality") == false) goto L22;
        JSONObject r101 = r116.optJSONObject("default_quality");     // Catch: MalformedURLException -> L77 JSONException -> L79
        if (r101 == null) goto L22;
        if (r101.optString("sdk_key").isEmpty() == true) goto L22;
        String r102 = r101.optString("sdk_key");     // Catch: MalformedURLException -> L77 JSONException -> L79
    L24:
        if (TextUtils.equals(r102, "auto") == true) goto L82;
    L35:
        r114 = r102;
        goto L36
    L82:
        String r103 = (String) INVOKESTATIC_com_ss_videoarch_strategy_strategy_mpdPreload_MpdPreloadManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.videoarch.liveplayer.VideoLiveManager").getMethod("getABRResolution", new Class[]{JSONObject.class}).invoke(null, new Object[]{r112});     // Catch: Exception -> L27
    L30:
        if (r103.isEmpty() == true) goto L33;
        r102 = r103;
    L33:
        if (TextUtils.equals(r102, "auto") == false) goto L35;
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: MalformedURLException -> L77 JSONException -> L79
        r103 = "";
    L22:
        r102 = PlayerResolution.SDKKEY.ORIGIN;
    L36:
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r112, "data"), r114), PullConfiguration.PROCESS_NAME_MAIN);     // Catch: MalformedURLException -> L77 JSONException -> L79
        JSONObject r105 = new JSONObject(r104.optString(OrderParamsKey.KEY_SDK_PARAM));     // Catch: MalformedURLException -> L77 JSONException -> L79
        String r106 = r105.optString("SuggestFormat");     // Catch: MalformedURLException -> L77 JSONException -> L79
        String r107 = r105.optString("SuggestProtocol");     // Catch: MalformedURLException -> L77 JSONException -> L79
        if (r105.has("cmaf") == false) goto L39;
        JSONObject r117 = r105.optJSONObject("cmaf");     // Catch: MalformedURLException -> L77 JSONException -> L79
    L40:
        if (r117 == null) goto L45;
        if (r117.has("CmafEnablePreload") == false) goto L45;
        r115 = r117.optInt("CmafEnablePreload", 0);     // Catch: MalformedURLException -> L77 JSONException -> L79
    L45:
        if (TextUtils.equals(r106, "cmaf") == false) goto L76;
        if (TextUtils.equals(r107, "h2q") == false) goto L76;
        if (r115 != 1) goto L76;
        String r108 = r104.optString(r106);     // Catch: MalformedURLException -> L77 JSONException -> L79
        String r109 = new URL(r108).getHost();     // Catch: MalformedURLException -> L77 JSONException -> L79
        JSONObject r118 = new JSONObject();     // Catch: MalformedURLException -> L77 JSONException -> L79
        r118 = r118.put("host", r109);     // Catch: JSONException -> L53 MalformedURLException -> L77
    L55:
        JSONObject r119 = DnsOptimizer.inst().getNodeOptimizerInfos(r118, null);     // Catch: MalformedURLException -> L77 JSONException -> L79
        if (r119 == null) goto L60;
        r119.toString();     // Catch: MalformedURLException -> L77 JSONException -> L79
        if (r119.has("Ip") == false) goto L60;
        String r120 = r119.optString("Ip");     // Catch: MalformedURLException -> L77 JSONException -> L79
    L62:
        if (TextUtils.isEmpty(r120) == true) goto L64;
    L64:
        JSONObject r121 = new JSONObject();     // Catch: MalformedURLException -> L77 JSONException -> L79
        r121.put("url", r108);     // Catch: JSONException -> L72 MalformedURLException -> L77
        if (TextUtils.isEmpty(r120) == true) goto L69;
        r121.put(DNSParser.DNS_RESULT_IP, r120);     // Catch: JSONException -> L72 MalformedURLException -> L77
    L69:
        if (TextUtils.isEmpty(r100) == true) goto L89;
        r121.put("scfg", r100);     // Catch: JSONException -> L72 MalformedURLException -> L77
    L89:
        return r121.toString();
    L72:
        e = move-exception;
        e.printStackTrace();     // Catch: MalformedURLException -> L77 JSONException -> L79
    L60:
        r120 = "";
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: MalformedURLException -> L77 JSONException -> L79
    L76:
        return "";
    L39:
        r117 = null;
    L79:
        e = e;
    L80:
        e.toString();
        e.printStackTrace();
        return "";
    L77:
        e = e;
        goto L80
    L11:
        r100 = "";
        goto L84
    }

    public synchronized void init(Context r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mContext == r100) goto L6;
        this.mContext = r100;     // Catch: Throwable -> L9
    L6:
        loadNative();     // Catch: Throwable -> L9
        monitor-exit(this);
    }
}
