package iwb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatSide;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iwb.a f496279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f496280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f496281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f496282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f496283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f496284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f496285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f496286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f496287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public hwb.d f496288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f496289k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f496290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f496291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f496292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f496293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f496294e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f496295f;

        public a(FrameLayout.LayoutParams r100, int r101, int r102, int r103, int r104, FrameLayout r105) {
            this.f496290a = r100;
            this.f496291b = r101;
            this.f496292c = r102;
            this.f496293d = r103;
            this.f496294e = r104;
            this.f496295f = r105;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            float r101 = r100.getAnimatedFraction();
            FrameLayout.LayoutParams r102 = this.f496290a;
            r102.gravity = 0;
            int r103 = this.f496291b;
            r102.leftMargin = (int) (r103 + ((this.f496292c - r103) * r101));
            int r104 = this.f496293d;
            r102.topMargin = (int) (r104 + ((this.f496294e - r104) * r101));
            this.f496295f.setLayoutParams(r102);
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f496296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f496297b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f496296a;
            r101.f496281c = false;
            boolean r102 = r101.f496282d;
            r101.f496283e = r102;
            r101.f496279a.c(r102, r101.f496284f);
            d r103 = this.f496296a;
            r103.f496279a.b(r103.c());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f496296a;
            r101.f496281c = false;
            boolean r102 = r101.f496282d;
            r101.f496283e = r102;
            if (r102 == true) goto L5;
            FrameLayout.LayoutParams r103 = this.f496297b;
            r101.f(r103.leftMargin, r103.topMargin);
        L5:
            d r104 = this.f496296a;
            r104.f496279a.c(r104.f496283e, r104.f496284f);
            d r105 = this.f496296a;
            r105.f496279a.b(r105.c());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f496296a;
            r101.f496281c = true;
            r101.f496283e = false;
            r101.f496279a.c(false, false);
        }

        public b(d r100, FrameLayout.LayoutParams r101) {
            this.f496296a = r100;
            this.f496297b = r101;
        }
    }

    public final void b() {
        ValueAnimator r100 = this.f496287i;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f496287i = null;
        this.f496281c = false;
    }

    public final hwb.d c() {
        ViewGroup.LayoutParams r100 = this.f496279a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100;
        boolean r102 = !this.f496282d;
        if (this.f496284f == false) goto L5;
        MmRecordingFloatSide r103 = MmRecordingFloatSide.RIGHT;
    L7:
        return new hwb.d(r102, r103, Integer.valueOf(r101.leftMargin), Integer.valueOf(r101.topMargin), this.f496279a.f496270l, this.f496285g, this.f496286h);
    L5:
        r103 = MmRecordingFloatSide.LEFT;
        goto L7
    }

    public final void d(boolean r100) {
        boolean r101 = this.f496282d;
        int r102 = 0;
        this.f496282d = false;
        this.f496283e = false;
        ViewGroup.LayoutParams r103 = this.f496279a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        int r105 = this.f496279a.getFloatView$officesdk_minutes_base_ui_release().getWidth();
        if (r101 == true) goto L7;
        int r106 = this.f496279a.getFloatView$officesdk_minutes_base_ui_release().getWidth();
        if (r106 <= this.f496289k) goto L7;
        this.f496289k = r106;
    L7:
        Integer r107 = Integer.valueOf(this.f496289k);
        if (r107.intValue() <= 0) goto L10;
        boolean r108 = true;
    L12:
        if (r108 == true) goto L15;
        r107 = null;
    L15:
        if (r107 == null) goto L17;
        int r109 = r107.intValue();
    L19:
        if ((r104.leftMargin + (r105 / 2)) >= (this.f496279a.getWidth() / 2)) goto L21;
        this.f496284f = false;
    L22:
        int r110 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "sideAnim", "currentLeft=" + r104.leftMargin + ", currentWidth=" + r105 + ", containerWidth=" + this.f496279a.getWidth() + ", expandedWidth=" + r109 + ", targetLeft=" + r102 + ", right=" + this.f496284f + ", needAnim=" + r100, null, 8);
        a(r102, r104.topMargin, r100);
        return;
    L21:
        this.f496284f = true;
        r102 = RangesKt.coerceAtLeast(this.f496279a.getWidth() - r109, 0);
        goto L22
    L17:
        r109 = r105;
        goto L19
    L10:
        r108 = false;
        goto L12
    }

    public final void e(boolean r100) {
        boolean r101 = this.f496282d;
        this.f496282d = true;
        int r102 = this.f496279a.getFloatView$officesdk_minutes_base_ui_release().getWidth();
        if (r102 <= this.f496289k) goto L5;
        this.f496289k = r102;
    L5:
        ViewGroup.LayoutParams r103 = this.f496279a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        int r105 = 0;
        if ((r104.leftMargin + (this.f496279a.getFloatView$officesdk_minutes_base_ui_release().getWidth() / 2)) >= (this.f496279a.getWidth() / 2)) goto L8;
        this.f496284f = false;
        int r106 = this.f496280b.d();
    L9:
        if (r101 == true) goto L12;
        f(r104.leftMargin, r104.topMargin);
    L15:
        a(r106, r104.topMargin, r100);
        return;
    L12:
        if (this.f496284f == false) goto L14;
        r105 = this.f496280b.a();
    L14:
        f(r105, r104.topMargin);
        goto L15
    L8:
        this.f496284f = true;
        r106 = this.f496280b.e();
        goto L9
    }

    public d(iwb.a r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "restrictHelper");
        this.f496279a = r100;
        this.f496280b = r101;
        this.f496284f = true;
    }

    public final void f(int r100, int r101) {
        e r102 = this.f496280b;
        r102.getClass();
        this.f496285g = Integer.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r100, 0), r102.a()));
        this.f496286h = Integer.valueOf(this.f496280b.c(r101));
    }

    public final void a(int r110, int r111, boolean r112) {
        b();
        FrameLayout r100 = this.f496279a.getFloatView$officesdk_minutes_base_ui_release();
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        int r103 = r102.leftMargin;
        int r104 = r102.topMargin;
        int r105 = this.f496280b.c(r111);
        int r113 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "animateTo", "left=" + r110 + ", top=" + r105 + ", hidden=" + this.f496282d + ", right=" + this.f496284f, null, 8);
        if (r112 == true) goto L9;
        r102.gravity = 0;
        r102.leftMargin = r110;
        r102.topMargin = r105;
        r100.setLayoutParams(r102);
        boolean r114 = this.f496282d;
        this.f496283e = r114;
        if (r114 == true) goto L7;
        f(r102.leftMargin, r102.topMargin);
    L7:
        this.f496279a.c(this.f496283e, this.f496284f);
        this.f496279a.b(c());
        return;
    L9:
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r115.setDuration(300);
        r115.addUpdateListener(new a(r102, r103, r110, r104, r105, r100));
        r115.addListener(new b(this, r102));
        this.f496287i = r115;
        r115.start();
    }
}
