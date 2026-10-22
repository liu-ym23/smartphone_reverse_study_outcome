package ea5;

import android.animation.Animator;
import com.bytedance.ee.bear.drive.view.preview.video.VideoPlayerControllerView;

/* JADX INFO: loaded from: classes16.dex */
public final class t extends com.bytedance.ee.util.ui.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoPlayerControllerView f471616a;

    public t(VideoPlayerControllerView r100) {
        this.f471616a = r100;
    }

    @Override // com.bytedance.ee.util.ui.g.a, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        VideoPlayerControllerView r101 = this.f471616a;
        r101.f225491u = 1;
        r101.F.enterImmersive();
    }

    @Override // com.bytedance.ee.util.ui.g.a, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f471616a.f225491u = -1;
    }
}
