package s12;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import com.bytedance.android.livesdk.gift.platform.format.panel.view.FormatGiftListWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormatGiftListWidget f540149a;

    public e(FormatGiftListWidget r100) {
        this.f540149a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L9;
        float r102 = ((Float) r101).floatValue();
        ImageView r103 = this.f540149a.f132181f;
        if (r103 == null) goto L10;
        r103.setAlpha(r102);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
