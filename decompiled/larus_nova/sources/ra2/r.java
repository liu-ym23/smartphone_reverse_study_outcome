package ra2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.bytedance.android.livesdk.utils.q4;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchHotMsgView f536831a;

    public r(MatchHotMsgView r100) {
        this.f536831a = r100;
    }

    public final void a() {
        MatchHotMsgView r100 = this.f536831a;
        int r101 = MatchHotMsgView.P;
        r100.getClass();
        AnimatorSet r102 = new AnimatorSet();
        Animator[] r103 = new Animator[3];
        int r104 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r105 = r100.f140122d;
        if (r105 == null) goto L16;
        Intrinsics.checkNotNullParameter(r105, "view");
        q4.f159129j.getClass();
        ValueAnimator r106 = q4.a.b(r105, "alpha", new float[]{0.0f, 1.0f});
        r106.setDuration(500);
        r103[0] = r106;
        ViewGroup r107 = r100.f140122d;
        if (r107 == null) goto L17;
        r103[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.c(r107, LiveDegradeFpsAnimator.SCALE_X);
        ViewGroup r108 = r100.f140122d;
        if (r108 == null) goto L18;
        r103[2] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.c(r108, LiveDegradeFpsAnimator.SCALE_Y);
        r102.playTogether(r103);
        Unit r109 = Unit.INSTANCE;
        r100.B = r102;
        r102.addListener(new o(r100));
        AnimatorSet r110 = r100.B;
        if (r110 == null) goto L15;
        r110.start();
        return;
    L15:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
