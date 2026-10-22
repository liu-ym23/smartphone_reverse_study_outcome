package bp5;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final bp5.a a = null;
    public static final Map<Integer, List<a>> b = null;

    public interface a {
        boolean interceptSetStatusBarColor(Activity r1, int r2, boolean r3);

        boolean interceptSetSystemUiVisibility(Activity r1, int r2);
    }

    static {
        b = new HashMap();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        a = new g();
        return;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getRootDirectory(), "build.prop");
        if (r0.exists() == false) goto L34;
        Properties r1 = new Properties();
        FileInputStream r2 = null;
        FileInputStream r3 = new PolarisFileInputStreamWrapper(r0);     // Catch: Throwable -> L18 Exception -> L20
        r1.load(r3);     // Catch: Throwable -> L14 Exception -> L16
        r3.close();     // Catch: Throwable -> L12
    L39:
    L26:
        boolean r4 = r1.containsKey("ro.build.hw_emui_api_level");
    L35:
        if (r4 == true) goto L37;
        a = new f();
        return;
    L37:
        a = new e();
        return;
    L16:
        e = e;
        r2 = r3;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r2 == null) goto L26;
        r2.close();     // Catch: Throwable -> L12
    L14:
        th = th;
    L28:
        if (r3 != null) goto L42;
    L33:
        throw th;
    L42:
        r3.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();
    L12:
        th = move-exception;
        th.printStackTrace();
    L20:
        e = e;
    L18:
        th = th;
        r3 = r2;
        goto L28
    L34:
        r4 = false;
        goto L35
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void b(FragmentActivity r2, a r3) {
        if (r2 == null) goto L8;
        int r4 = r2.hashCode();
        Map<Integer, List<a>> r0 = b;
        HashMap r1 = (HashMap) r0;
        List r5 = (List) r1.get(Integer.valueOf(r4));
        if (r5 != null) goto L6;
        r5 = new ArrayList();
        r1.put(Integer.valueOf(r4), r5);
    L6:
        r5.add(r3);
        return;
    }

    public static void c(FragmentActivity r2, a r3) {
        if (r2 == null) goto L9;
        int r4 = r2.hashCode();
        Map<Integer, List<a>> r0 = b;
        HashMap r1 = (HashMap) r0;
        List r5 = (List) r1.get(Integer.valueOf(r4));
        if (r5 == null) goto L10;
        r5.remove(r3);
        if (r5.isEmpty() == false) goto L11;
        r1.remove(Integer.valueOf(r4));
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void d(Activity r3, Fragment r4, int r5) {
        int r0 = Color.blue(r5);
        int r1 = Color.green(r5);
        if (((((Color.red(r5) * 38) + (r1 * 75)) + (r0 * 15)) >> 7) <= 225) goto L5;
        boolean r2 = true;
    L6:
        e(r3, r4, r5, r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static void f(Window r1, int r2, boolean r3) {
        a.a(r1, r2);
        b.a(r1, r3);
    }

    public static void e(Activity r3, Fragment r4, int r5, boolean r6) {
        List r0 = (List) ((HashMap) b).get(Integer.valueOf(r3.hashCode()));
        if (r0 != null) goto L5;
    L12:
        if (r4 != null) goto L14;
    L16:
        WindowInsetsUtils.c(r3).b(r5);
        return;
    L14:
        if (com.suite.lark.component.navroute.forseti.f.b(r4) == null) goto L16;
        WindowInsetsUtils.b(r4).b(r5);
        return;
    L5:
        if (r0.isEmpty() == true) goto L12;
        int r1 = r0.size();
    L7:
        r1 = r1 - 1;
        if (r1 < 0) goto L12;
        if (((a) ListProtector.get(r0, r1)).interceptSetStatusBarColor(r3, r5, r6) == false) goto L7;
    }
}
