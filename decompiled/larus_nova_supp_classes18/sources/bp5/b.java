package bp5;

import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final c a = null;

    public class a extends e {
        public final d a;

        public a() {
            this.a = new d();
        }

        @Override // bp5.b.e, bp5.b.c
        public final void a(Window r2, boolean r3) {
            super.a(r2, r3);
            this.a.a(r2, r3);
        }
    }

    /* JADX INFO: renamed from: bp5.b$b, reason: collision with other inner class name */
    public class C0007b implements c {
        public C0007b() {
        }

        @Override // bp5.b.c
        public final void a(Window r1, boolean r2) {
        }
    }

    public interface c {
        void a(Window r1, boolean r2);
    }

    public static class d implements c {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class b() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("android.view.MiuiWindowManager$LayoutParams");
        }

        public d() {
        }

        @Override // bp5.b.c
        public final void a(Window r9, boolean r10) {
            Class<?> r0 = r9.getClass();
            Class r1 = b();     // Catch: Exception -> L9
            int r2 = r1.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r1);     // Catch: Exception -> L9
            Class<?> r5 = Integer.TYPE;     // Catch: Exception -> L9
            Method r3 = r0.getMethod("setExtraFlags", new Class[]{r5, r5});     // Catch: Exception -> L9
            Object[] r4 = new Object[2];     // Catch: Exception -> L9
            if (r10 == false) goto L6;
            int r11 = r2;
        L7:
            r4[0] = Integer.valueOf(r11);     // Catch: Exception -> L9
            r4[1] = Integer.valueOf(r2);     // Catch: Exception -> L9
            r3.invoke(r9, r4);     // Catch: Exception -> L9
            return;
        L6:
            r11 = 0;
        L9:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class e implements c {
        public e() {
        }

        @Override // bp5.b.c
        public void a(Window r4, boolean r5) {
            View r6 = r4.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r0, "getDecorView");
        L7:
            int r1 = r6.getSystemUiVisibility();
            if (r5 == false) goto L10;
            int r7 = r1 | 8192;
        L11:
            r6.setSystemUiVisibility(r7);
            return;
        L10:
            r7 = r1 & (-8193);
            goto L11
        }
    }

    public static class f implements c {
        public f() {
        }

        @Override // bp5.b.c
        public final void a(Window r6, boolean r7) {
            WindowManager.LayoutParams r0 = r6.getAttributes();
            Field r1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Exception -> L9
            Field r2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Exception -> L9
            r1.setAccessible(true);     // Catch: Exception -> L9
            r2.setAccessible(true);     // Catch: Exception -> L9
            int r3 = r1.getInt(null);     // Catch: Exception -> L9
            int r4 = r2.getInt(r0);     // Catch: Exception -> L9
            if (r7 == false) goto L6;
            int r8 = r4 | r3;     // Catch: Exception -> L9
        L7:
            r2.setInt(r0, r8);     // Catch: Exception -> L9
            r6.setAttributes(r0);     // Catch: Exception -> L9
            r1.setAccessible(false);     // Catch: Exception -> L9
            r2.setAccessible(false);     // Catch: Exception -> L9
            return;
        L6:
            r8 = (~r3) & r4;     // Catch: Exception -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
        FileInputStream r0 = null;
        boolean r1 = false;
        FileInputStream r2 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(Environment.getRootDirectory(), "build.prop"));     // Catch: Throwable -> L14 IOException -> L18
        Properties r3 = new Properties();     // Catch: Throwable -> L11 IOException -> L13
        r3.load(r2);     // Catch: Throwable -> L11 IOException -> L13
        if (r3.getProperty("ro.miui.ui.version.code") == null) goto L7;
    L10:
        r1 = true;
    L41:
        r2.close();     // Catch: IOException -> L23
    L25:
        if (r1 == false) goto L31;
        if (Build.VERSION.SDK_INT < 23) goto L29;
        a = new a();
        return;
    L29:
        a = new d();
        return;
    L31:
        if (Build.VERSION.SDK_INT < 23) goto L34;
        a = new e();
        return;
    L34:
        if (Build.DISPLAY.startsWith("Flyme") == false) goto L36;
        a = new f();
        return;
    L36:
        a = new C0007b();
        return;
    L7:
        if (r3.getProperty("ro.miui.ui.version.name") != null) goto L10;
        if (r3.getProperty("ro.miui.internal.storage") == null) goto L41;
    L13:
        r0 = r2;
    L11:
        th = move-exception;
        th = th;
        r0 = r2;
    L15:
        if (r0 != null) goto L39;
    L17:
        throw th;
    L39:
        r0.close();     // Catch: IOException -> L38
        goto L17
    L14:
        th = th;
    L19:
        if (r0 == null) goto L25;
        r2 = r0;
        goto L41
    }

    public static void a(Window r1, boolean r2) {
        a.a(r1, r2);
    }
}
