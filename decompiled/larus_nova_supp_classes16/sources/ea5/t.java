package ea5;

import android.animation.Animator;
import com.bytedance.ee.bear.drive.view.preview.video.VideoPlayerControllerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t extends com.bytedance.ee.util.ui.g.a {
    public final /* synthetic */ VideoPlayerControllerView a;

    public t(VideoPlayerControllerView r1) {
        this.a = r1;
    }

    public final void onAnimationEnd(Animator r2) {
        VideoPlayerControllerView r3 = this.a;
        r3.u = 1;
        r3.F.enterImmersive();
    }

    public final void onAnimationStart(Animator r2) {
        this.a.u = -1;
    }
}
