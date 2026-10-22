package oo2;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.ss.android.agilelogger.ALog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f524573i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animator f524574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f524575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f524576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f524577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f524578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f524579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f524580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ILivePlayerClient f524581h;

    public static final class a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            ALog.i("FadeAudioController", r100);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f524582a;

        public b(c r100) {
            this.f524582a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "anim");
            Object r101 = r100.getAnimatedValue();
            ILivePlayerClient r102 = this.f524582a.f524581h;
            if (r101 == null) goto L7;
            r102.setPlayerVolumeWithAnim(((Float) r101).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public c(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f524581h = r100;
    }

    public final void a(float r100, float r101, int r102, String r103, boolean r104, boolean r105) {
        a.a("minVolume=" + r100 + ", duration=" + r102 + ", hasFirstFrame=" + r105);
        Animator r106 = this.f524574a;
        if (r106 == null) goto L9;
        if (r106.isRunning() != true) goto L9;
        a.a("return for duplicated call");
        return;
    L9:
        if (this.f524581h.isMute() == true) goto L11;
        a.a("player is not mute");
    L11:
        if (r105 == true) goto L14;
        this.f524580g = true;
        this.f524575b = r100;
        this.f524576c = r101;
        this.f524577d = r102;
        this.f524578e = r103;
        this.f524579f = r104;
        return;
    L14:
        this.f524580g = false;
        if (r104 == false) goto L18;
        r101 = this.f524581h.curPlayerVolume();
    L18:
        if (r100 < r101) goto L20;
        return;
    L20:
        if (r103 != null) goto L23;
    L37:
        TimeInterpolator r107 = null;
    L38:
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{r100, r101});
        r108.setDuration(r102);
        r108.addUpdateListener(new b(this));
        Unit r109 = Unit.INSTANCE;
        this.f524574a = r108;
        if (r107 == null) goto L41;
        r108.setInterpolator(r107);
    L41:
        Animator r110 = this.f524574a;
        if (r110 == null) goto L44;
        r110.start();
    L44:
        a.a("fade in animator start");
        return;
    L23:
        switch(r103.hashCode()) {
            case -1177812156: goto L35;
            case -1102672091: goto L32;
            case 96385: goto L29;
            case 99330: goto L26;
            default: goto L37;
        };
    L26:
        if (r103.equals("dec") == false) goto L37;
        r107 = new DecelerateInterpolator();
        goto L38
    L29:
        if (r103.equals("acc") == false) goto L37;
        r107 = new AccelerateInterpolator();
        goto L38
    L32:
        if (r103.equals("linear") == false) goto L37;
        r107 = new LinearInterpolator();
        goto L38
    L35:
        if (r103.equals("acc_dec") == false) goto L37;
        r107 = new AccelerateDecelerateInterpolator();
        goto L38
    }
}
