package com.obric.oui.material;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.VectorDrawable;
import android.provider.Settings;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.color.i0;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.layout.OUIFrameLayout;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class OMaterialHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Integer f401446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Method> f401447b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f401448c = null;

    /* JADX INFO: loaded from: classes34.dex */
    public static final enum LEGACY_BLEND_MODE extends Enum<LEGACY_BLEND_MODE> {
        public static final LEGACY_BLEND_MODE COLOR_BURN = null;
        public static final LEGACY_BLEND_MODE COLOR_DODGE = null;
        public static final LEGACY_BLEND_MODE DEFAULT = null;
        public static final LEGACY_BLEND_MODE LUMINOSITY = null;
        public static final LEGACY_BLEND_MODE OVERLAY = null;
        public static final LEGACY_BLEND_MODE PLUS_DARKER = null;
        public static final LEGACY_BLEND_MODE PLUS_LIGHTER = null;
        public static final LEGACY_BLEND_MODE SOFT_LIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LEGACY_BLEND_MODE[] f401449a = null;

        static {
            LEGACY_BLEND_MODE r100 = new LEGACY_BLEND_MODE("DEFAULT", 0);
            DEFAULT = r100;
            LEGACY_BLEND_MODE r101 = new LEGACY_BLEND_MODE("COLOR_BURN", 1);
            COLOR_BURN = r101;
            LEGACY_BLEND_MODE r102 = new LEGACY_BLEND_MODE("COLOR_DODGE", 2);
            COLOR_DODGE = r102;
            LEGACY_BLEND_MODE r103 = new LEGACY_BLEND_MODE("PLUS_DARKER", 3);
            PLUS_DARKER = r103;
            LEGACY_BLEND_MODE r104 = new LEGACY_BLEND_MODE("PLUS_LIGHTER", 4);
            PLUS_LIGHTER = r104;
            LEGACY_BLEND_MODE r105 = new LEGACY_BLEND_MODE("LUMINOSITY", 5);
            LUMINOSITY = r105;
            LEGACY_BLEND_MODE r110 = new LEGACY_BLEND_MODE("OVERLAY", 6);
            OVERLAY = r110;
            LEGACY_BLEND_MODE r111 = new LEGACY_BLEND_MODE("SOFT_LIGHT", 7);
            SOFT_LIGHT = r111;
            f401449a = new LEGACY_BLEND_MODE[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static LEGACY_BLEND_MODE[] values() {
            return (LEGACY_BLEND_MODE[]) f401449a.clone();
        }

        public static LEGACY_BLEND_MODE valueOf(String r100) {
            return (LEGACY_BLEND_MODE) r27.a.a(LEGACY_BLEND_MODE.class, r100);
        }

        public LEGACY_BLEND_MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f401447b = new HashMap();
        new HashMap();
        f401448c = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static int c() {
        Map<String, Method> r100 = f401447b;
        Method r101 = (Method) ((HashMap) r100).get("getEffectApi");
        if (r101 == null) goto L12;
    L5:
        Object r102 = r101.invoke(null, new Object[0]);     // Catch: Exception -> L9
        if ((r102 instanceof Integer) == false) goto L14;
        return ((Integer) r102).intValue();
    L9:
        e = move-exception;
        e.toString();
        return 0;
    L14:
        return 0;
    L12:
        int r103 = NativeReflect.f401411a;     // Catch: Exception -> L9
        r101 = a("android.view.IExtEffect").getDeclaredMethod("getEffectApi", new Class[0]);     // Catch: Exception -> L9
        r101.setAccessible(true);     // Catch: Exception -> L9
        ((HashMap) r100).put("getEffectApi", r101);     // Catch: Exception -> L9
        goto L5
    }

    public static int f() {
        if (f401446a != null) goto L6;
        f401446a = Integer.valueOf(c());
    L6:
        return f401446a.intValue();
    }

    public static boolean k() {
        if (f() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean l() {
        if (f() < 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static Object e(Object r100) {
        if ((r100 instanceof View) == false) goto L7;
        return i((View) r100, "view_getExtEffect", View.class);
    L7:
        if ((r100 instanceof Paint) == false) goto L11;
        return i((Paint) r100, "paint_getExtEffect", Paint.class);
    L11:
        if ((r100 instanceof VectorDrawable) == true) goto L13;
        return r100;
    L13:
        return i((VectorDrawable) r100, "vectorDrawable_getExtEffect", VectorDrawable.class);
    }

    public static int g(Context r100) {
        return Settings.Global.getInt(r100.getContentResolver(), "obric_current_effect_id", 2);
    }

    public static boolean j(Context r100) {
        if (k() == true) goto L6;
        return false;
    L6:
        if (g(r100) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int[] z(com.obric.oui.color.a[] r100) {
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.length * 2;
        int[] r103 = new int[r102];
    L7:
        if (r101 >= r102) goto L13;
        com.obric.oui.color.a r104 = r100[r101 / 2];
        if ((r101 % 2) != 0) goto L11;
        int r105 = r104.f399488a;
    L12:
        r103[r101] = r105;
        r101 = r101 + 1;
        goto L7
    L11:
        r105 = r104.f399489b;
        goto L12
    L13:
        return r103;
    L5:
        return new int[0];
    }

    public static i h(Object r100, int r101) {
        Object r102 = e(r100);
        Map<String, Method> r103 = f401447b;
        Method r104 = (Method) ((HashMap) r103).get("getEffectParas");
        if (r104 == null) goto L14;
    L5:
        Object r105 = r104.invoke(r102, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L11
        if (r105 == null) goto L16;
        return new i(r105);
    L11:
        e = move-exception;
        e.toString();
        return null;
    L16:
        return null;
    L14:
        Class r106 = a("android.view.IExtEffect");     // Catch: Exception -> L11
        Class<?>[] r107 = {Integer.TYPE};     // Catch: Exception -> L11
        int r108 = NativeReflect.f401411a;     // Catch: Exception -> L11
        r104 = r106.getDeclaredMethod("getEffectParas", r107);     // Catch: Exception -> L11
        r104.setAccessible(true);     // Catch: Exception -> L11
        ((HashMap) r103).put("getEffectParas", r104);     // Catch: Exception -> L11
        goto L5
    }

    public static void m(Object r110, int... r111) {
        if (k() == false) goto L15;
        Object r112 = e(r110);
        Map<String, Method> r100 = f401447b;
        Method r101 = (Method) ((HashMap) r100).get("setObricBlendEffect_curve");
        if (r101 == null) goto L13;
    L8:
        r101.invoke(r112, new Object[]{4, Float.valueOf(1.0f), r111});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.toString();
        return;
    L13:
        Class r102 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?>[] r103 = {Integer.TYPE, Float.TYPE, int[].class};     // Catch: Exception -> L10
        int r104 = NativeReflect.f401411a;     // Catch: Exception -> L10
        r101 = r102.getDeclaredMethod("setObricBlendEffect", r103);     // Catch: Exception -> L10
        r101.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r100).put("setObricBlendEffect_curve", r101);     // Catch: Exception -> L10
        goto L8
    }

    public static void n(Object r100, int... r101) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r102 = e(r100);
        Map<String, Method> r103 = f401447b;
        Method r104 = (Method) ((HashMap) r103).get("setObricBlendEffectToShadow");
        if (r104 == null) goto L15;
    L10:
        if (r102 == null) goto L17;
        r104.invoke(r102, new Object[]{r101});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.toString();
        return;
    L17:
        return;
    L15:
        int r105 = NativeReflect.f401411a;     // Catch: Exception -> L8
        r104 = a("android.view.IExtEffect").getDeclaredMethod("setObricBlendEffectToShadow", new Class[]{int[].class});     // Catch: Exception -> L8
        r104.setAccessible(true);     // Catch: Exception -> L8
        ((HashMap) r103).put("setObricBlendEffectToShadow", r104);     // Catch: Exception -> L8
        goto L10
    }

    public static void q(Object r100, int r101) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r102 = e(r100);
        Map<String, Method> r103 = f401447b;
        Method r104 = (Method) ((HashMap) r103).get("setObricEffectSource_1");
        if (r104 == null) goto L13;
    L8:
        r104.invoke(r102, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.toString();
        return;
    L13:
        Class r105 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?>[] r106 = {Integer.TYPE};     // Catch: Exception -> L10
        int r107 = NativeReflect.f401411a;     // Catch: Exception -> L10
        r104 = r105.getDeclaredMethod("setObricEffectSource", r106);     // Catch: Exception -> L10
        r104.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r103).put("setObricEffectSource_1", r104);     // Catch: Exception -> L10
        goto L8
    }

    public static void r(OUIFrameLayout r110, OUIFrameLayout r111) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r112 = e(r110);
        Map<String, Method> r100 = f401447b;
        Method r101 = (Method) ((HashMap) r100).get("setObricEffectSource_3");
        if (r101 == null) goto L13;
    L8:
        r101.invoke(r112, new Object[]{1, 0, r111});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        Class r102 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r103 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r104 = {r103, r103, View.class};     // Catch: Exception -> L10
        int r105 = NativeReflect.f401411a;     // Catch: Exception -> L10
        r101 = r102.getDeclaredMethod("setObricEffectSource", r104);     // Catch: Exception -> L10
        r101.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r100).put("setObricEffectSource_3", r101);     // Catch: Exception -> L10
        goto L8
    }

    public static void t(Object r100, View r101) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r102 = e(r100);
        Map<String, Method> r103 = f401447b;
        Method r104 = (Method) ((HashMap) r103).get("setObricEffectSourceTarget");
        if (r104 == null) goto L13;
    L8:
        r104.invoke(r102, new Object[]{r101});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        int r105 = NativeReflect.f401411a;     // Catch: Exception -> L10
        r104 = a("android.view.IExtEffect").getDeclaredMethod("setObricEffectSourceTarget", new Class[]{View.class});     // Catch: Exception -> L10
        r104.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r103).put("setObricEffectSourceTarget", r104);     // Catch: Exception -> L10
        goto L8
    }

    public static void b(Object r110, c r111, float r112) {
        kma.a r100 = r111.f401453b;
        if (r100 == null) goto L5;
        m(r110, z(com.obric.oui.color.c.a(r100.f504113a.f504118c)));
    L18:
        com.obric.oui.blur.a r101 = r111.f401458g;
        if (r101 == null) goto L21;
        o(r110, r101.f398866a, r101.f398868c, r101.f398867b, r101.f398869d, r101.f398870e);
    L25:
        i0 r102 = r111.f401456e;
        if (r102 == null) goto L35;
        float r103 = r102.f399493a;
        if (r103 != 0.0f) goto L30;
        boolean r104 = true;
    L31:
        if (r104 == false) goto L33;
        int r105 = 0;
    L34:
        y(r110, r105, r102.f399494b);
    L36:
        com.obric.oui.fluid.a r106 = r111.f401461j;
        if (r106 == null) goto L39;
        u(r110, true, r106.f400848a);
        return;
    L39:
        u(r110, false, f401448c);
        return;
    L33:
        r105 = (int) ((r103 * r112) + 0.5f);
        goto L34
    L30:
        r104 = false;
        goto L31
    L35:
        y(r110, 0.0f, 0);
        goto L36
    L21:
        Float r107 = r111.f401459h;
        if (r107 == null) goto L24;
        o(r110, r107.floatValue(), 1.0f, 0, 0, 1.0f);
        goto L25
    L24:
        o(r110, 0.0f, 1.0f, 0, 0, 1.0f);
        goto L25
    L5:
        com.obric.oui.color.a[] r108 = r111.f401454c;
        if (r108 == null) goto L9;
        m(r110, z(r108));
        goto L18
    L9:
        if (k() == false) goto L18;
        Object r109 = e(r110);
        Map<String, Method> r113 = f401447b;
        Method r114 = (Method) ((HashMap) r113).get("setObricBlendEffect_curve");
        if (r114 == null) goto L41;
    L14:
        r114.invoke(r109, new Object[]{0, Float.valueOf(1.0f), new int[]{0, 0}});     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        goto L18
    L41:
        Class r115 = a("android.view.IExtEffect");     // Catch: Exception -> L16
        Class<?>[] r116 = {Integer.TYPE, Float.TYPE, int[].class};     // Catch: Exception -> L16
        int r117 = NativeReflect.f401411a;     // Catch: Exception -> L16
        r114 = r115.getDeclaredMethod("setObricBlendEffect", r116);     // Catch: Exception -> L16
        r114.setAccessible(true);     // Catch: Exception -> L16
        ((HashMap) r113).put("setObricBlendEffect_curve", r114);     // Catch: Exception -> L16
        goto L14
    }

    public static com.obric.oui.color.a[] d(Resources r100, int r101, int r102) {
        if (r101 == 0) goto L10;
        if (r102 == 0) goto L13;
        int[] r103 = r100.getIntArray(r101);
        int[] r104 = r100.getIntArray(r102);
        com.obric.oui.color.a[] r105 = new com.obric.oui.color.a[r103.length];
        int r106 = 0;
    L7:
        if (r106 >= r103.length) goto L9;
        r105[r106] = new com.obric.oui.color.a(r103[r106], BlendMode.mapToLegacyObricBlend(r104[r106]));
        r106 = r106 + 1;
        goto L7
    L9:
        return r105;
    L13:
        return null;
    L10:
        return null;
    }

    public static Object i(Object r100, String r101, Class r102) {
        Map<String, Method> r103 = f401447b;
        Method r104 = (Method) ((HashMap) r103).get(r101);
        if (r104 == null) goto L10;
    L5:
        return r104.invoke(r100, new Object[0]);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        int r105 = NativeReflect.f401411a;     // Catch: Exception -> L7
        r104 = r102.getDeclaredMethod("getExtEffect", new Class[0]);     // Catch: Exception -> L7
        r104.setAccessible(true);     // Catch: Exception -> L7
        ((HashMap) r103).put(r101, r104);     // Catch: Exception -> L7
        goto L5
    }

    public static void p(View r110, c r111, int r112) {
        if (r110 == null) goto L50;
        if (r111 != null) goto L6;
        return;
    L6:
        if (k() == false) goto L8;
        s(r110, r112, 1);
        com.obric.oui.color.a[] r113 = r111.f401454c;
        if (r113 == null) goto L36;
        m(r110, z(r113));
    L36:
        com.obric.oui.blur.a r114 = r111.f401458g;
        if (r114 == null) goto L51;
        o(r110, r114.f398866a, r114.f398868c, r114.f398867b, r114.f398869d, r114.f398870e);
        return;
    L51:
        return;
    L8:
        if (r111.f401458g == null) goto L47;
        com.obric.oui.color.a[] r115 = r111.f401454c;
        if (r115 == null) goto L48;
        int[] r116 = z(r115);
        int r100 = j.f401474a;
        int r101 = 0;
    L13:
        if (r101 >= r116.length) goto L18;
        if ((r101 % 2) == 0) goto L17;
        r116[r101] = BlendMode.mapToLegacyObricBlend(r116[r101], true);
    L17:
        r101 = r101 + 1;
        goto L13
    L18:
        com.obric.oui.blur.a r117 = r111.f401458g;
        int r102 = r117.f398867b;
        float r118 = r117.f398866a;
        Map<String, Method> r103 = f401447b;
        Method r104 = (Method) ((HashMap) r103).get("view_getExtView");
        if (r104 == null) goto L40;
    L21:
        Object r119 = r104.invoke(r110, new Object[0]);     // Catch: Exception -> L23
    L25:
        Map<String, Method> r105 = f401447b;
        Method r106 = (Method) ((HashMap) r105).get("legacy_setBackdropBlurEffectExt");
        if (r106 == null) goto L42;
    L28:
        r106.invoke(r119, new Object[]{Integer.valueOf(r102), Float.valueOf(r118), r116});     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        e.toString();
        return;
    L42:
        Class r107 = a("android.view.IExtView");     // Catch: Exception -> L30
        Class<?>[] r108 = {Integer.TYPE, Float.TYPE, int[].class};     // Catch: Exception -> L30
        int r120 = NativeReflect.f401411a;     // Catch: Exception -> L30
        r106 = r107.getDeclaredMethod("setBackdropBlurEffectExt", r108);     // Catch: Exception -> L30
        r106.setAccessible(true);     // Catch: Exception -> L30
        ((HashMap) r105).put("legacy_setBackdropBlurEffectExt", r106);     // Catch: Exception -> L30
    L23:
        e = move-exception;
        e.printStackTrace();
        r119 = null;
        goto L25
    L40:
        int r109 = NativeReflect.f401411a;     // Catch: Exception -> L23
        r104 = View.class.getDeclaredMethod("getExt", new Class[0]);     // Catch: Exception -> L23
        r104.setAccessible(true);     // Catch: Exception -> L23
        ((HashMap) r103).put("view_getExtView", r104);     // Catch: Exception -> L23
        goto L21
    L48:
        return;
    L47:
        return;
    }

    public static void s(Object r100, int r110, int r111) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r101 = e(r100);
        Map<String, Method> r102 = f401447b;
        Method r103 = (Method) ((HashMap) r102).get("setObricEffectSource_2");
        if (r103 == null) goto L13;
    L8:
        r103.invoke(r101, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        Class r104 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r105 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r106 = {r105, r105};     // Catch: Exception -> L10
        int r107 = NativeReflect.f401411a;     // Catch: Exception -> L10
        r103 = r104.getDeclaredMethod("setObricEffectSource", r106);     // Catch: Exception -> L10
        r103.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r102).put("setObricEffectSource_2", r103);     // Catch: Exception -> L10
        goto L8
    }

    public static void u(Object r100, boolean r101, float[] r102) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r103 = e(r100);
        Map<String, Method> r104 = f401447b;
        Method r105 = (Method) ((HashMap) r104).get("setObricLiquidGlassEffectRR");
        if (r105 == null) goto L17;
    L8:
        Object[] r106 = new Object[1];     // Catch: Exception -> L14
        if (r101 == true) goto L12;
        r102 = new float[0];     // Catch: Exception -> L14
    L12:
        r106[0] = r102;     // Catch: Exception -> L14
        r105.invoke(r103, r106);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.toString();
        return;
    L17:
        int r107 = NativeReflect.f401411a;     // Catch: Exception -> L14
        r105 = a("android.view.IExtEffect").getDeclaredMethod("setObricLiquidGlassEffectRR", new Class[]{float[].class});     // Catch: Exception -> L14
        r105.setAccessible(true);     // Catch: Exception -> L14
        ((HashMap) r104).put("setObricLiquidGlassEffectRR", r105);     // Catch: Exception -> L14
        goto L8
    }

    public static void x(Object r110, int r111, int r112) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r113 = e(r110);
        Map<String, Method> r100 = f401447b;
        Method r101 = (Method) ((HashMap) r100).get("setObricOverlayBlendEffect_3");
        if (r101 == null) goto L13;
    L8:
        r101.invoke(r113, new Object[]{Integer.valueOf(r111), Float.valueOf(1.0f), Integer.valueOf(r112)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.toString();
        return;
    L13:
        Class r102 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r103 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r104 = {r103, Float.TYPE, r103};     // Catch: Exception -> L10
        int r105 = NativeReflect.f401411a;     // Catch: Exception -> L10
        r101 = r102.getDeclaredMethod("setObricOverlayBlendEffect", r104);     // Catch: Exception -> L10
        r101.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r100).put("setObricOverlayBlendEffect_3", r101);     // Catch: Exception -> L10
        goto L8
    }

    public static void y(Object r110, float r111, int r112) {
        int r100 = BlendMode.SRC_OVER.getPorterDuffMode();
        if (k() == false) goto L13;
        Object r113 = e(r110);
        Map<String, Method> r101 = f401447b;
        Method r102 = (Method) ((HashMap) r101).get("setObricBlurStroke");
        if (r102 == null) goto L11;
    L8:
        r102.invoke(r113, new Object[]{Float.valueOf(r111), Integer.valueOf(r112), Integer.valueOf(r100)});     // Catch: Exception -> L10
        return;
    L14:
        return;
    L11:
        Class r103 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r104 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r105 = {Float.TYPE, r104, r104};     // Catch: Exception -> L10
        int r106 = NativeReflect.f401411a;     // Catch: Exception -> L10
        r102 = r103.getDeclaredMethod("setObricBlurStroke", r105);     // Catch: Exception -> L10
        r102.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r101).put("setObricBlurStroke", r102);     // Catch: Exception -> L10
        goto L8
    }

    public static void v(Object r100, int r101, c r102, float r103) {
        if (r100 == null) goto L21;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f401454c == null) goto L8;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L19;
        s(r100, 0, 1);
        return;
    L19:
        s(r100, r101, 1);
        b(r100, r102, r103);
        return;
    L8:
        if (r102.f401458g != null) goto L15;
        if (r102.f401459h != null) goto L15;
        if (r102.f401461j != null) goto L15;
        r104 = false;
        goto L16
    }

    public static void w(Object r100, int r101, c[] r102, float r103) {
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length != 1) goto L7;
        c r104 = r102[0];
        Resources r105 = Resources.getSystem();
        v(r100, r101, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density);
        return;
    L7:
        int r106 = 0;
    L9:
        if (r106 >= r102.length) goto L39;
        if (r106 != 0) goto L12;
        int r107 = 1;
    L13:
        c r108 = r102[r106];
        i r109 = h(r100, r107);
        if (r109 == null) goto L31;
        if (r108 == null) goto L31;
        Object r110 = r109.f401473a;
        if (r108.f401454c == null) goto L20;
    L27:
        boolean r111 = true;
    L28:
        if (r111 == true) goto L30;
        s(r110, 0, 1);
        goto L31
    L30:
        s(r110, r101, 1);
        b(r110, r108, r103);
        goto L31
    L20:
        if (r108.f401458g != null) goto L27;
        if (r108.f401459h != null) goto L27;
        if (r108.f401461j != null) goto L27;
        r111 = false;
    L31:
        r106 = r106 + 1;
        goto L9
    L12:
        r107 = 2;
        goto L13
    }

    public static void o(Object r110, float r111, float r112, int r113, int r114, float r115) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r100 = e(r110);
        Map<String, Method> r101 = f401447b;
        Method r102 = (Method) ((HashMap) r101).get("setObricBlurEffect_5");
        if (r102 == null) goto L13;
    L8:
        r102.invoke(r100, new Object[]{Float.valueOf(r111), Float.valueOf(r112), Integer.valueOf(r113), Integer.valueOf(r114), Float.valueOf(r115)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        Class r103 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r116 = Float.TYPE;     // Catch: Exception -> L10
        Class<?> r117 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r118 = {r116, r116, r117, r117, r116};     // Catch: Exception -> L10
        int r119 = NativeReflect.f401411a;     // Catch: Exception -> L10
        r102 = r103.getDeclaredMethod("setObricBlurEffect", r118);     // Catch: Exception -> L10
        r102.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r101).put("setObricBlurEffect_5", r102);     // Catch: Exception -> L10
        goto L8
    }
}
