package jv2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.widget.crop.PreviewBoxViewV2;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewBoxViewV2 f500551a;

    public h(PreviewBoxViewV2 r100) {
        this.f500551a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        PreviewBoxViewV2 r101 = this.f500551a;
        r101.f161675n = r101.f161676o;
        r101.invalidate();
        this.f500551a.f161666e = false;
    }
}
