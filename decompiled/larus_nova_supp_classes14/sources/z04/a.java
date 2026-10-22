package z04;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    static {
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

    @JvmStatic
    public static final void b(Activity r9, int r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Window r12 = r9.getWindow();
        if (r12 == null) goto L29;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L27;
        r12.setNavigationBarColor(r10);
        if (r11 == null) goto L9;
        boolean r13 = r11.booleanValue();
    L13:
        Intrinsics.checkNotNullParameter(r12, "window");
        if (r0 < 26) goto L27;
        int r14 = a(r12).getSystemUiVisibility();
        if (r13 == false) goto L24;
        WindowManager.LayoutParams r15 = r12.getAttributes();
        if ((r15.flags & 134217728) == 0) goto L21;
        r12.clearFlags(134217728);
    L21:
        if ((r15.flags & Integer.MIN_VALUE) != 0) goto L23;
        r12.addFlags(Integer.MIN_VALUE);
    L23:
        int r16 = r14 | 16;
    L25:
        if (r16 == r14) goto L27;
        a(r12).setSystemUiVisibility(r16);
        goto L27
    L24:
        r16 = r14 & (-17);
        goto L25
    L9:
        int r17 = Color.red(r10);
        int r2 = Color.green(r10);
        if ((((((double) r17) * 0.299d) + (((double) r2) * 0.587d)) + (((double) Color.blue(r10)) * 0.114d)) < 192.0d) goto L12;
        r13 = true;
        goto L13
    L12:
        r13 = false;
    L27:
        Unit r18 = Unit.INSTANCE;
        return;
    }
}
