package qz1;

import android.animation.Animator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveSendGiftAnimationView;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends com.bytedance.android.live.revenue.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSendGiftAnimationView f535238a;

    public q(LiveSendGiftAnimationView r100) {
        this.f535238a = r100;
    }

    @Override // com.bytedance.android.live.revenue.common.f, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f535238a.f126705h.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        this.f535238a.f126705h.setVisibility(0);
    }
}
