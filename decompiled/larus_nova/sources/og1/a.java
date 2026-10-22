package og1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.setting.w4;
import com.bytedance.android.live.core.setting.x4;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f523179a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f523180b = false;

    static {
        f523179a = w4.f65447a.getValue().booleanValue();
        f523180b = x4.f65455a.getValue().booleanValue();
    }

    public static boolean a(Context r100, int r101, boolean r102) {
        if (r102 == false) goto L4;
        boolean r103 = f523180b;
    L5:
        if (r103 == false) goto L34;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L27
        View r105 = null;
        if ((r100 instanceof Activity) == true) goto L9;
        r100 = null;
    L9:
        Activity r106 = (Activity) r100;     // Catch: Throwable -> L27
        if (r106 == null) goto L20;
        Window r107 = r106.getWindow();     // Catch: Throwable -> L27
        if (r107 == null) goto L20;
        View r108 = r107.getDecorView();     // Catch: Throwable -> L27
        if (com.larus.home.impl.utils.c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L27
        Thread r109 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L27
        if (r109 == com.larus.home.impl.utils.c.f346341a) goto L18;
        com.larus.home.impl.utils.c.a(r109, "getDecorView");     // Catch: Throwable -> L27
    L18:
        if (r108 == null) goto L20;
        r105 = r108.findViewById(r101);     // Catch: Throwable -> L27
    L20:
        if (r105 == null) goto L25;
        if (r101 <= 0) goto L33;
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        return true;
    L33:
        return false;
    L25:
        return false;
    L27:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return true;
    L34:
        return true;
    L4:
        r103 = f523179a;
        goto L5
    }
}
