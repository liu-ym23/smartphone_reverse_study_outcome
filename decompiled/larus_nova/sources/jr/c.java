package jr;

import android.animation.ValueAnimator;
import com.bytedance.android.ecom.live.adapter.impl.views.CircularProgressView;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f500110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f500111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f500112c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f500112c;
        r101.f51203q = ((Float) r100.getAnimatedValue()).floatValue();
        CircularProgressView r102 = this.f500112c;
        r102.f51194h = (this.f500110a - r102.f51203q) + this.f500111b;
        r102.invalidate();
    }

    public c(CircularProgressView r100, float r101, float r102) {
        this.f500112c = r100;
        this.f500110a = r101;
        this.f500111b = r102;
    }
}
