package p88;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.avatar.impl.scan.view.ScanCameraBeautyButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f528206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f528207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScanCameraBeautyButton f528208c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationCancel(r100);
        this.f528206a.removeView(this.f528207b);
        this.f528208c.f291185e = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f528206a.removeView(this.f528207b);
        this.f528208c.f291185e = false;
    }

    public g(ViewGroup r100, ImageView r101, ScanCameraBeautyButton r102) {
        this.f528206a = r100;
        this.f528207b = r101;
        this.f528208c = r102;
    }
}
