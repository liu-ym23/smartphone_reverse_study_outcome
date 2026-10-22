package k56;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.common.utility.StringUtils;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends Handler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f501871d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<b> f501872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f501873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f501874c;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f501875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f501876b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f501875a.getClass();
            this.f501875a.b();
            c r101 = this.f501876b;
            r101.f501873b = false;
            r101.removeMessages(1110);
            this.f501876b.sendEmptyMessage(1929);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f501875a.getClass();
        }

        public a(c r100, b r101) {
            this.f501876b = r100;
            this.f501875a = r101;
        }
    }

    public static synchronized c b() {
        monitor-enter(c.class);
        c r100 = f501871d;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        monitor-exit(c.class);
        return r100;
    L8:
        c r101 = new c(Looper.getMainLooper());     // Catch: Throwable -> L11
        f501871d = r101;     // Catch: Throwable -> L11
        monitor-exit(c.class);
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e() {
        if (((ConcurrentLinkedQueue) this.f501872a).isEmpty() == false) goto L5;
        return;
    L5:
        b r100 = (b) ((ConcurrentLinkedQueue) this.f501872a).peek();
        if (r100 != null) goto L8;
    L11:
        if (r100 == null) goto L21;
        View r101 = r100.f501851e;
        if (r101 != null) goto L15;
    L17:
        boolean r102 = false;
    L18:
        if (r102 == true) goto L22;
        Message r103 = Message.obtain();
        r103.what = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT;
        r103.obj = r100;
        sendMessage(r103);
        return;
    L22:
        return;
    L15:
        if (r101.isShown() == false) goto L17;
        r102 = true;
        goto L18
    L21:
        return;
    L8:
        if (r100.f() == false) goto L11;
        r100.b();
        ((ConcurrentLinkedQueue) this.f501872a).poll();
        e();
    }

    public c(Looper r100) {
        super(r100);
        this.f501873b = false;
        this.f501874c = 5;
        this.f501872a = new ConcurrentLinkedQueue();
    }

    public final void a(b r100) {
        if (((ConcurrentLinkedQueue) this.f501872a).contains(r100) == false) goto L5;
        return;
    L5:
        if (((ConcurrentLinkedQueue) this.f501872a).size() > this.f501874c) goto L13;
        ((ConcurrentLinkedQueue) this.f501872a).offer(r100);
        if (this.f501873b == true) goto L12;
        sendEmptyMessage(1929);
        return;
    L12:
        return;
    }

    public final void c(b r100) {
        View r101 = r100.f501851e;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L11;
    L22:
        r100.b();
        this.f501873b = false;
        ((ConcurrentLinkedQueue) this.f501872a).remove(r100);
        sendEmptyMessage(1929);
        return;
    L11:
        if (r100.f() == true) goto L22;
        if (((ConcurrentLinkedQueue) this.f501872a).contains(r100) == true) goto L18;
        this.f501873b = false;
        removeMessages(1110);
        sendEmptyMessage(1929);
        return;
    L18:
        if (r100.f501854h != null) goto L20;
        AnimatorSet r103 = new AnimatorSet();
        r100.f501854h = r103;
        r103.playTogether(new Animator[]{ObjectAnimator.ofFloat(r100.f501848b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -r100.f501870x}), ObjectAnimator.ofFloat(r100.f501848b, "alpha", new float[]{1.0f, 0.0f})});
        r100.f501854h.setInterpolator(new AccelerateDecelerateInterpolator());
        r100.f501854h.setDuration(320);
    L20:
        AnimatorSet r104 = r100.f501854h;
        r104.addListener(new a(this, r100));
        r104.start();
        ((ConcurrentLinkedQueue) this.f501872a).poll();
        return;
    L5:
        if (r101.isShown() == false) goto L7;
        r102 = true;
        goto L9
    }

    public final void d(Context r100) {
        Iterator r101 = ((ConcurrentLinkedQueue) this.f501872a).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        b r102 = (b) r101.next();
        if (r102 == null) goto L4;
        if (r102.getContext() != r100) goto L4;
        r102.f501857k = false;
        goto L4
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r110) {
        b r100 = (b) r110.obj;
        int r111 = r110.what;
        if (r111 == 291) goto L10;
        if (r111 != 1110) goto L6;
        c(r100);
        return;
    L6:
        if (r111 != 1929) goto L51;
        e();
        return;
    L51:
        return;
    L10:
        View r112 = r100.f501851e;
        if (r112 != null) goto L13;
    L15:
        boolean r113 = false;
    L16:
        if (r113 == false) goto L19;
        return;
    L19:
        if (r100.f() == false) goto L22;
    L42:
        this.f501873b = true;
        if (r100.f501853g != null) goto L45;
        AnimatorSet r114 = new AnimatorSet();
        r100.f501853g = r114;
        r114.playTogether(new Animator[]{ObjectAnimator.ofFloat(r100.f501848b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{-r100.f501870x, 0.0f}), ObjectAnimator.ofFloat(r100.f501848b, "alpha", new float[]{0.0f, 1.0f})});
        r100.f501853g.setInterpolator(new AccelerateDecelerateInterpolator());
        r100.f501853g.setDuration(320);
    L45:
        r100.f501853g.start();
        Message r115 = Message.obtain();
        r115.what = 1110;
        r115.obj = r100;
        sendMessageDelayed(r115, r100.f501855i);
        return;
    L22:
        if (r100.f501852f != null) goto L24;
    L26:
        r100.f501858l = true;
        r100.f501848b.removeAllViews();
        if (r100.f501851e.getParent() != null) goto L29;
        r100.f501848b.addView(r100.f501851e);
    L31:
        if (r100.f501862p != null) goto L36;
        WindowManager.LayoutParams r116 = new WindowManager.LayoutParams(-1, -2, 2, 262280, -2);
        r116.flags = 262280;
        int r101 = r100.f501849c;
        r116.gravity = r101;
        if (r101 != 48) goto L35;
        r116.y = r100.f501850d[0];
    L35:
        r100.f501862p = r116;
    L36:
        r100.f501861o = (WindowManager) r100.f501847a.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r100.f501848b.getParent() == null) goto L47;
        r100.f501861o.removeView(r100.f501848b);
    L47:
        WindowManager r117 = r100.f501861o;     // Catch: Exception -> L41
        ViewGroup r102 = r100.f501848b;     // Catch: Exception -> L41
        WindowManager.LayoutParams r103 = r100.f501862p;     // Catch: Exception -> L41
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r102, r103);     // Catch: Exception -> L41
        r117.addView(r102, r103);     // Catch: Exception -> L41
        goto L42
    L29:
        ((ViewGroup) r100.f501851e.getParent()).removeView(r100.f501851e);
        r100.f501848b.addView(r100.f501851e);
        goto L31
    L24:
        if (StringUtils.isEmpty(r100.f501859m) == true) goto L26;
        r100.f501852f.setText(r100.f501859m);
        goto L26
    L13:
        if (r112.isShown() == false) goto L15;
        r113 = true;
        goto L16
    }
}
