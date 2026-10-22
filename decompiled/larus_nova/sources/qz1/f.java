package qz1;

import android.animation.Animator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveGiftGroupComboViewNew;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f535227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveGiftGroupComboViewNew f535228b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        LiveGiftGroupComboViewNew r101 = this.f535228b;
        Runnable r102 = this.f535227a;
        int r103 = LiveGiftGroupComboViewNew.f126678g;
        r101.c(r102);
    }

    public f(LiveGiftGroupComboViewNew r100, Runnable r101) {
        this.f535228b = r100;
        this.f535227a = r101;
    }
}
