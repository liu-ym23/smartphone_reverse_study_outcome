package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.view.SurfaceView;
import android.view.View;
import androidx.core.util.Pair;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
final class TTPlayerViewHelper {
    public static final float TT_PLAYER_VIEW_ASPECT_PRECISION = 0.001f;
    public static final String TT_PLAYER_VIEW_TAG = "TTPlayerView";
    private static boolean sDeviceEnableSurfaceView;
    private static boolean sFetchedDeviceEnableSurfaceView;

    public static class Size {
        private int height;
        private int width;

        public String toString() {
            return "size{w=" + this.width + ", h=" + this.height + '}';
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public Size(int r100, int r101) {
            this.width = r100;
            this.height = r101;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static boolean isOppoPropertyEnableSurfaceView() {
        Method r100 = INVOKESTATIC_com_ss_ttm_player_TTPlayerViewHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L9
        r100.setAccessible(true);     // Catch: Exception -> L9
        Object r101 = r100.invoke(null, new Object[]{"ro.oplus.display.reset_two_pq_layer", -1});     // Catch: Exception -> L9
        if ((r101 instanceof Integer) == false) goto L11;
        if (((Integer) r101).intValue() != 1) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    L9:
        e = move-exception;
        com.ss.vcbkit.a.b(TT_PLAYER_VIEW_TAG, "ttmn isSurfaceViewEnableByOppoProperty failed: " + e);
        goto L11
    }

    private static boolean isDeviceOppoRealmeBrand() {
        String r100 = Build.BRAND.toLowerCase();
        if (r100.equals(AppConstants.CHANNEL_OPPO) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100.equals("realme") == true) goto L10;
        if (r100.equals("oneplus") == true) goto L10;
        return false;
    }

    private static boolean isMediaTekChipset() {
        String r100 = Build.HARDWARE;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.matches("mt[0-9]*");
    }

    private TTPlayerViewHelper() {
        throw new UnsupportedOperationException("Don't instantiate");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttm_player_TTPlayerViewHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static Rect getSurfaceRenderPosition(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof SurfaceView) == true) goto L15;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        int r103 = r101[1];
        return new Rect(r102, r103, r100.getWidth() + r102, r100.getHeight() + r103);
    L15:
        Method r104 = SurfaceView.class.getDeclaredMethod("getSurfaceRenderPosition", new Class[0]);     // Catch: Exception -> L14
        r104.setAccessible(true);     // Catch: Exception -> L14
        Object r105 = r104.invoke(r100, new Object[0]);     // Catch: Exception -> L14
        if ((r105 instanceof Rect) == false) goto L11;
        return (Rect) r105;
    L11:
        return null;
    }

    public static boolean isEnableSurfaceView(Context r100) {
        if (sFetchedDeviceEnableSurfaceView == true) goto L17;
        if (isDeviceOppoRealmeBrand() == true) goto L7;
    L14:
        boolean r101 = true;
    L15:
        sDeviceEnableSurfaceView = r101;
        sFetchedDeviceEnableSurfaceView = true;
        goto L17
    L7:
        if (isMediaTekChipset() == false) goto L14;
        if (isOppoPropertyEnableSurfaceView() == true) goto L14;
        if (isOSIESwitchOffForOppoRealme(r100) == false) goto L14;
        r101 = false;
    L17:
        return sDeviceEnableSurfaceView;
    }

    private static boolean isOSIESwitchOffForOppoRealme(Context r100) {
        if (r100 != null) goto L15;
        return false;
    L15:
        int r101 = Settings.Secure.getInt(r100.getContentResolver(), "osie_iris5_switch", -1);     // Catch: Exception -> L12
        int r102 = Settings.Secure.getInt(r100.getContentResolver(), "customize_multimedia_osie", -1);     // Catch: Exception -> L12
        int r103 = Settings.Secure.getInt(r100.getContentResolver(), "osie_video_display_switch", -1);     // Catch: Exception -> L12
        if (r101 == 1) goto L17;
        if (r102 == 1) goto L18;
        if (r103 == 1) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    L12:
        e = move-exception;
        com.ss.vcbkit.a.b(TT_PLAYER_VIEW_TAG, "ttmn failed to read OSIE settings: " + e);
        return false;
    }

    public static String objectToString(Object r100) {
        if (r100 != null) goto L5;
        return "Null";
    L5:
        String r101 = r100.getClass().getSimpleName();
        if (r101.isEmpty() == false) goto L11;
        r101 = r100.getClass().getName();
        int r102 = r101.lastIndexOf(46);
        if (r102 < 0) goto L11;
        r101 = r101.substring(r102 + 1);
    L11:
        return r101 + "@" + Integer.toHexString(System.identityHashCode(r100));
    }

    public static Pair<Size, Boolean> calculatePlayerViewSize(int r100, float r101, int r102, int r110, float r111, float r112) {
        if (r101 == 0.0f) goto L5;
        boolean r103 = false;
        if (r100 != 0) goto L9;
        float r104 = r102;
        float r105 = r110;
        if (r101 <= (r104 / r105)) goto L36;
        int r106 = (int) (r104 / r101);
        int r107 = r102;
    L37:
        int r108 = r106;
    L27:
        int r109 = r108;
        r102 = r107;
    L38:
        if (r103 == false) goto L50;
        if (r111 <= 0.0f) goto L50;
        if (r112 <= 0.0f) goto L50;
        int r113 = r108 - r109;
        float r114 = (r107 - r102) / r102;
        if (r114 <= r111) goto L46;
    L47:
        com.ss.vcbkit.a.e(TT_PLAYER_VIEW_TAG, "ttmn calculate crop w_aspect: " + r114 + ", h_aspect: " + (r113 / r110) + ", scale: " + r100 + " fallback to fit");
        return calculatePlayerViewSize(0, r101, r102, r110, r111, r112);
    L46:
        if ((r113 / r110) > r112) goto L47;
    L50:
        return new Pair(new Size(r102, r109), Boolean.valueOf(r103));
    L36:
        r107 = (int) (r105 * r101);
        r106 = r110;
        goto L37
    L9:
        if (r100 != 1) goto L11;
        int r115 = (int) (r102 / r101);
        if (r115 <= r110) goto L31;
    L30:
        r109 = r110;
        r108 = r115;
        r103 = true;
    L32:
        r107 = r102;
    L31:
        r108 = r115;
        r109 = r108;
        goto L32
    L11:
        if (r100 != 2) goto L13;
        r107 = (int) (r110 * r101);
        if (r107 <= r102) goto L26;
    L25:
        r102 = r102;
        r108 = r110;
        r109 = r108;
        r103 = true;
    L26:
        r108 = r110;
        goto L27
    L13:
        if (r100 == 3) goto L15;
        r102 = r102;
        r107 = r102;
        r108 = r110;
        r109 = r108;
        goto L38
    L15:
        float r116 = r102;
        float r117 = r110;
        if (r101 <= (r116 / r117)) goto L20;
        r107 = (int) (r117 * r101);
        if (r107 <= r102) goto L26;
    L20:
        r115 = (int) (r116 / r101);
        if (r115 <= r110) goto L31;
    L5:
        return new Pair(null, Boolean.FALSE);
    }
}
