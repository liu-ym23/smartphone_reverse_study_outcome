package fe0;

import android.view.animation.Animation;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkDialog f476558a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public h(LinkDialog r100) {
        this.f476558a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f476558a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
