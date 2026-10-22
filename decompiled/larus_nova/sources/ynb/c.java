package ynb;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f568597a;

    public c(a r100) {
        this.f568597a = r100;
    }

    public final void a() {
        View r100 = this.f568597a.f568582d;
        View r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r100 = null;
    L6:
        if (r100.getVisibility() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        View r103 = this.f568597a.f568582d;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r103 = null;
    L14:
        int r104 = r103.getHeight();
        if (r104 > 0) goto L18;
        r104 = UIHelper.dp2px(24.0f);
    L18:
        float r105 = r104;
        View r106 = this.f568597a.f568582d;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r106 = null;
    L21:
        r106.setTranslationY(r105);
        View r107 = this.f568597a.f568582d;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L25:
        r101.animate().translationY(0.0f).alpha(1.0f).setDuration(220).setInterpolator(new DecelerateInterpolator()).start();
        return;
    L24:
        r101 = r107;
        goto L25
    L8:
        r102 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
