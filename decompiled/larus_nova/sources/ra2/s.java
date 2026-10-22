package ra2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes9.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchHotMsgView f536832a;

    public s(MatchHotMsgView r100) {
        this.f536832a = r100;
    }

    public final void a() {
        MatchHotMsgView r100 = this.f536832a;
        PriorityBlockingQueue<g3> r101 = r100.f140144z;
        if (r101 != null) goto L5;
    L37:
        MatchHotMsgView r102 = this.f536832a;
        r102.postDelayed(r102.f140130l, r102.f140142x);
        return;
    L5:
        if ((!r101.isEmpty()) != true) goto L37;
        PriorityBlockingQueue<g3> r103 = r100.f140144z;
        String r104 = null;
        if (r103 == null) goto L9;
        g3 r105 = r103.poll();
    L10:
        r100.A = r105;
        if (r105 == null) goto L13;
        Long r106 = Long.valueOf(r105.getCount());
    L14:
        TextView r107 = r100.f140127i;
        if (r107 == null) goto L19;
        if (r106 == null) goto L18;
        r104 = String.valueOf(r106.longValue());
    L18:
        r107.setText(r104);
    L19:
        r100.E = new AnimatorSet();
        AnimatorSet r108 = new AnimatorSet();
        Animator[] r109 = new Animator[2];
        int r110 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r111 = r100.f140125g;
        if (r111 == null) goto L37;
        r109[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r111, LiveDegradeFpsAnimator.SCALE_X, 1.0f, 1.15f, 50, 0.0f, 0.0f, 1.0f, 1.0f);
        ViewGroup r112 = r100.f140125g;
        if (r112 == null) goto L37;
        r109[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r112, LiveDegradeFpsAnimator.SCALE_Y, 1.0f, 1.15f, 50, 0.0f, 0.0f, 1.0f, 1.0f);
        r108.playTogether(r109);
        AnimatorSet r113 = new AnimatorSet();
        Animator[] r114 = new Animator[2];
        ViewGroup r115 = r100.f140125g;
        if (r115 == null) goto L37;
        r114[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r115, LiveDegradeFpsAnimator.SCALE_X, 1.15f, 1.0f, 350, 0.0f, 0.0f, 1.0f, 1.0f);
        ViewGroup r116 = r100.f140125g;
        if (r116 == null) goto L37;
        r114[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r116, LiveDegradeFpsAnimator.SCALE_Y, 1.15f, 1.0f, 350, 0.0f, 0.0f, 1.0f, 1.0f);
        r113.playTogether(r114);
        AnimatorSet r117 = r100.E;
        if (r117 == null) goto L34;
        r117.playSequentially(new Animator[]{r108, r113});
    L34:
        AnimatorSet r118 = r100.E;
        if (r118 == null) goto L37;
        r118.start();
        goto L37
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
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
