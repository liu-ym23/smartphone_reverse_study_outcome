package sh3;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f541959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f541960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WindowManager f541961c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Function0 r101 = this.f541960b;
        if (r101 == null) goto L14;
        Unit r102 = (Unit) r101.invoke();
    L14:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        WindowManager r104 = this.f541961c;     // Catch: Throwable -> L11
        if (r104 == null) goto L8;
        r104.removeView(this.f541959a);     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
        return;
    L8:
        r105 = null;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f541959a.setVisibility(8);
        Function0 r101 = this.f541960b;
        if (r101 == null) goto L14;
        Unit r102 = (Unit) r101.invoke();
    L14:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        WindowManager r104 = this.f541961c;     // Catch: Throwable -> L11
        if (r104 == null) goto L8;
        r104.removeView(this.f541959a);     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
        return;
    L8:
        r105 = null;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public b(View r100, Function0 r101, WindowManager r102) {
        this.f541959a = r100;
        this.f541960b = r101;
        this.f541961c = r102;
    }
}
