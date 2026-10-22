package kk0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f503745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PointF f503746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PointF f503747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HSImageView f503748d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ALogger.i("BaseMultiLinkWindowManager", "icon move anim end. startPoint " + this.f503746b + ", endPoint " + this.f503747c);
        this.f503745a.f503739c.removeView(this.f503748d);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ALogger.i("BaseMultiLinkWindowManager", "icon move anim start. startPoint " + this.f503746b + ", endPoint " + this.f503747c);
    }

    public e(a r100, PointF r101, PointF r102, HSImageView r103) {
        this.f503745a = r100;
        this.f503746b = r101;
        this.f503747c = r102;
        this.f503748d = r103;
    }
}
