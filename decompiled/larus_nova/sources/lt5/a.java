package lt5;

import com.bytedance.ee.larkwebview.quality.HangDetectConfig;
import com.bytedance.ee.larkwebview.quality.WebViewOptimizeConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebViewOptimizeConfig f510672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f510673b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f510674c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f510675d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f510676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f510677f;

    static {
        WebViewOptimizeConfig r100 = (WebViewOptimizeConfig) SettingManager.getInstance().get(WebViewOptimizeConfig.class);
        f510672a = r100;
        IFeatureGatingService r101 = FeatureGatingModule.getFeatureGatingService();
        if (r101 == null) goto L5;
        r101.isEnable("chameleon.webview.blank.detection.enable");
    L5:
        IFeatureGatingService r102 = FeatureGatingModule.getFeatureGatingService();
        if (r102 == null) goto L8;
        boolean r103 = r102.isEnable("chameleon.webview.freezescreen.detection.enable");
    L9:
        f510673b = r103;
        if (r100 == null) goto L14;
        HangDetectConfig r104 = r100.getHangDetect();
        if (r104 == null) goto L14;
        int r105 = r104.getMaxKillCount();
    L15:
        f510674c = r105;
        if (r100 == null) goto L20;
        HangDetectConfig r106 = r100.getHangDetect();
        if (r106 == null) goto L20;
        long r107 = r106.getMinKillInterval();
    L21:
        f510675d = r107 * 1000;
        return;
    L20:
        r107 = 120;
    L14:
        r105 = 3;
        goto L15
    L8:
        r103 = false;
        goto L9
    }

    public static boolean a() {
        long r100 = System.currentTimeMillis();
        long r101 = r100 - f510677f;
        long r102 = f510675d;
        if (r101 >= r102) goto L6;
        Log.i("WebViewOptimizeUtil", "can't kill, time too short, minKillIntervalMs = " + r102);
        return false;
    L6:
        int r103 = f510676e;
        int r104 = f510674c;
        if (r103 < r104) goto L10;
        Log.i("WebViewOptimizeUtil", "can't kill, count limit max = " + r104);
        return false;
    L10:
        f510677f = r100;
        f510676e = r103 + 1;
        return true;
    }
}
