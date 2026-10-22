package oh1;

import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f523240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f523241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f523242c;

    public b(View r100, int r101, int r102) {
        this.f523240a = r100;
        this.f523241b = r101;
        this.f523242c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        int r102 = ((Integer) r101).intValue();
        int r103 = this.f523240a.getWidth();
        int r104 = this.f523240a.getHeight();
        View r105 = this.f523240a;
        int r106 = this.f523241b;
        int r107 = this.f523242c;
        r105.layout(r106 + r102, r107, (r106 + r102) + r103, r104 + r107);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
