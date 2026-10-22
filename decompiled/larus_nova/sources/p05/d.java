package p05;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final boolean a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r100, "activity");
        if ((r100.getWindow().getAttributes().flags & 1024) != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L18;
        Intrinsics.checkNotNullParameter(r100, "activity");
        View r102 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L13:
        if ((r102.getSystemUiVisibility() & 1024) != 1024) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L18;
        return true;
    L15:
        r104 = false;
    L18:
        return false;
    L5:
        r101 = false;
        goto L6
    }
}
