package vd2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl.MvLyricSurfaceView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MvLyricSurfaceView f554183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f554184b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MvLyricSurfaceView r101 = this.f554183a;
        int r102 = MvLyricSurfaceView.L;
        r101.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MvLyricSurfaceView r101 = this.f554183a;
        int r102 = MvLyricSurfaceView.L;
        r101.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MvLyricSurfaceView r101 = this.f554183a;
        int r102 = MvLyricSurfaceView.L;
        r101.getClass();
        int r103 = this.f554183a.f143181p.size();
        int r104 = this.f554184b;
        if ((r104 % 2) != 0) goto L14;
        MvLyricSurfaceView r105 = this.f554183a;
        if (r105.f143177l == false) goto L14;
        if (r104 < 0) goto L14;
        if (r104 >= (r103 - 1)) goto L14;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r105.f143181p, r104)).f203036i == false) goto L14;
        int r106 = this.f554183a.f143181p.size();
        int r107 = this.f554184b;
        if (r107 >= (r106 - 1)) goto L14;
        com.bytedance.component.lyric.model.b r108 = new com.bytedance.component.lyric.model.b();
        r108.f203028a = 1;
        Unit r109 = Unit.INSTANCE;
        ListProtector.add(this.f554183a.f143181p, r107 + 1, r108);
    L14:
        MvLyricSurfaceView r110 = this.f554183a;
        r110.f143190y = this.f554184b;
        MvLyricSurfaceView r111 = this.f554183a;
        if (r111.f143177l == false) goto L18;
        r111.getClass();
        return;
    }

    public c(MvLyricSurfaceView r100, int r101) {
        this.f554183a = r100;
        this.f554184b = r101;
    }
}
