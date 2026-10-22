package oh1;

import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f523243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f523244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f523245c;

    public c(View r100, int r101, int r102) {
        this.f523243a = r100;
        this.f523244b = r101;
        this.f523245c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        int r102 = ((Integer) r101).intValue();
        int r103 = this.f523243a.getWidth();
        int r104 = this.f523243a.getHeight();
        View r105 = this.f523243a;
        int r106 = this.f523244b;
        int r107 = this.f523245c;
        r105.layout(r106, r107 + r102, r103 + r106, (r107 + r102) + r104);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
