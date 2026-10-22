package sk3;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.shopping.store.utils.screenAdapt.unit.Subunits;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final e s = null;
    public static final boolean t = false;
    public static final e u = null;
    public Application a;
    public final tk3.a b;
    public final vk3.a c;
    public float d;
    public int e;
    public float f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public sk3.a n;
    public boolean o;
    public boolean p;
    public Field q;
    public uk3.b r;

    public static final class a {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static void a() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class.forName("androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
            FastClassNotFoundHandler.a("androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L8
            return;
        L36:
            return;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("androidx.fragment.app.FragmentActivity");
        L12:
            throw th;
        L34:
            Class.forName("androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
            FastClassNotFoundHandler.a("androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L17
            return;
        L37:
            return;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("androidx.fragment.app.FragmentActivity");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == false) goto L26;
        L29:
            MiraPluginFix.forName("androidx.fragment.app.FragmentActivity");
            return;
        L26:
            if ((th instanceof NoClassDefFoundError) == true) goto L29;
            throw th;
        }
    }

    static {
        s = new e();
        a.a();     // Catch: ClassNotFoundException -> L5
        boolean r0 = true;
    L6:
        t = r0;
        u = s;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final int a() {
        if (this.m == false) goto L6;
        return this.k;
    L6:
        return this.k - this.l;
    }

    public e() {
        this.b = new tk3.a();
        this.c = new vk3.a();
        this.d = -1.0f;
        this.m = true;
    }

    public final void b(Application r11) {
        Intrinsics.checkNotNullParameter(r11, "application");
        Intrinsics.checkNotNullParameter(r11, "application");
        int r3 = 0;
        if (this.d == (-1.0f)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L46;
        this.a = r11;
        Resources r1 = Resources.getSystem();
        DisplayMetrics r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        Configuration r4 = Resources.getSystem().getConfiguration();
        if (u.c.a != Subunits.NONE) goto L11;
        this.h = 360;
        this.i = 640;
    L12:
        int r5 = r11.getResources().getConfiguration().orientation;
        int r6 = wk3.c.a;
        Intrinsics.checkNotNullParameter(r11, "context");
        int[] r7 = new int[2];
        Object r8 = r11.getSystemService("window");
        if ((r8 instanceof WindowManager) == true) goto L15;
        r8 = null;
    L15:
        WindowManager r9 = (WindowManager) r8;
        if (r9 == null) goto L18;
        Display r10 = r9.getDefaultDisplay();
    L19:
        DisplayMetrics r12 = new DisplayMetrics();
        if (r10 == null) goto L22;
        r10.getMetrics(r12);
    L22:
        int r13 = r12.widthPixels;
        r7[0] = r13;
        int r14 = r12.heightPixels;
        r7[1] = r14;
        this.j = r13;
        this.k = r14;
        int r15 = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");     // Catch: Resources.NotFoundException -> L27
        if (r15 <= 0) goto L29;
        r3 = Resources.getSystem().getDimensionPixelSize(r15);     // Catch: Resources.NotFoundException -> L27
    L29:
        this.l = r3;
        this.d = r2.density;
        this.e = r2.densityDpi;
        this.f = r2.scaledDensity;
        this.g = r2.xdpi;
        int r16 = r4.screenWidthDp;
        int r17 = r4.screenHeightDp;
        r11.registerComponentCallbacks(new f(this, r7));
        sk3.a r18 = new sk3.a(new h(new g()));
        this.n = r18;
        r11.registerActivityLifecycleCallbacks(r18);
        int r19 = wk3.a.a;
        wk3.a.a("initDensity = " + this.d + ", initScaledDensity = " + this.f + ",callback:" + this.n);
        if (Intrinsics.areEqual("MiuiResources", r11.getResources().getClass().getSimpleName()) == false) goto L32;
    L33:
        this.p = true;
        Field r110 = Resources.class.getDeclaredField("mTmpMetrics");     // Catch: Exception -> L38
        this.q = r110;     // Catch: Exception -> L38
        if (r110 == null) goto L45;
        r110.setAccessible(true);     // Catch: Exception -> L38
        return;
    L45:
        return;
    L38:
        this.q = null;
        return;
    L32:
        if (Intrinsics.areEqual("XResources", r11.getResources().getClass().getSimpleName()) == true) goto L33;
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L18:
        r10 = null;
        goto L19
    L11:
        this.h = 1080;
        this.i = 1920;
        goto L12
    L46:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
