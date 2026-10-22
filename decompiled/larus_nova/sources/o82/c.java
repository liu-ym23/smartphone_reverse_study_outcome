package o82;

import android.animation.ValueAnimator;
import android.view.Window;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f522343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Window f522344b;

    public c(Ref.IntRef r100, Window r101) {
        this.f522343a = r100;
        this.f522344b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = f.f522349a;
        if (f.a(this.f522344b) == false) goto L24;
        Window r102 = this.f522344b;
        if (r102 == null) goto L10;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        if (r103 == null) goto L10;
        r103.x = f.f522351c - ((int) (this.f522343a.element * r100.getAnimatedFraction()));
    L10:
        if (r100.getAnimatedFraction() != 1.0f) goto L20;
        f.f522351c = f.f522349a;
        Window r104 = this.f522344b;
        if (r104 == null) goto L16;
        WindowManager.LayoutParams r105 = r104.getAttributes();
        if (r105 == null) goto L16;
        r105.x = f.f522351c;
    L16:
        Window r106 = this.f522344b;
        if (r106 == null) goto L19;
        r106.setAttributes(r106.getAttributes());
    L19:
        f.f522353e.cancel();
    L20:
        Window r107 = this.f522344b;
        if (r107 == null) goto L25;
        r107.setAttributes(r107.getAttributes());
        return;
    L25:
        return;
    }
}
