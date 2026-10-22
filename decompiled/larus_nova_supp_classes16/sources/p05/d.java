package p05;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final boolean a(FragmentActivity r6) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r6, "activity");
        if ((r6.getWindow().getAttributes().flags & 1024) != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L18;
        Intrinsics.checkNotNullParameter(r6, "activity");
        View r7 = r6.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L13:
        if ((r7.getSystemUiVisibility() & 1024) != 1024) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L18;
        return true;
    L15:
        r8 = false;
    L18:
        return false;
    L5:
        r1 = false;
        goto L6
    }
}
