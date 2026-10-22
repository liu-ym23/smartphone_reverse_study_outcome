package z08;

import android.animation.ValueAnimator;
import com.larksuite.component.universe_design.progress.UDProgress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDProgress f569637a;

    public a(UDProgress r100) {
        this.f569637a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        UDProgress r101 = this.f569637a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        r101.setProgress(((Integer) r102).intValue());
    }
}
