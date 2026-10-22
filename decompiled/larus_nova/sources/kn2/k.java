package kn2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.overscroll.adapters.ViewPagerOverScrollDecorAdapter;
import com.bytedance.android.livesdk.overscroll.view.OverScrollFooterView;
import com.bytedance.android.livesdk.overscroll.view.OverScrollHeaderRefreshView;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;

/* JADX INFO: loaded from: classes11.dex */
public abstract class k implements kn2.b, View.OnTouchListener {
    public static final float B = 0.0f;
    public static final float C = 0.0f;
    public static final float D = 0.0f;
    public final View A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f504157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ln2.b f504158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f504159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f504160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f504161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f504162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f504163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f504164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f504165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f504166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f504167k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f504168l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public kn2.e f504169m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public kn2.f f504170n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public kn2.d f504171o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public kn2.c f504172p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f504173q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f504174r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f504175s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f504176t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f504177u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f504178v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public VelocityTracker f504179w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f504180x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f504181y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final View f504182z;

    public class a implements LiveVerticalViewPager.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f504183a;

        public a(k r100) {
            this.f504183a = r100;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveVerticalViewPager.j
        public final void a(MotionEvent r100) {
            this.f504183a.f504164h.e();
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Property<View, Float> f504184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f504185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f504186c;

        public b() {
        }

        public abstract void a(View r100);
    }

    public class c implements d, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Interpolator f504187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f504188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f504189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f504190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f504191e;

        @Override // kn2.k.d
        public final int a() {
            return 3;
        }

        @Override // kn2.k.d
        public final boolean b(MotionEvent r100) {
            return true;
        }

        @Override // kn2.k.d
        public final boolean e() {
            return true;
        }

        @Override // kn2.k.d
        public final boolean f(float r100) {
            return true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public c(k r100) {
            this.f504191e = r100;
            this.f504187a = new DecelerateInterpolator();
            this.f504188b = -2.0f;
            this.f504189c = -4.0f;
            this.f504190d = r100.b();
        }

        @Override // kn2.k.d
        public final void d(d r100) {
            k r101 = this.f504191e;
            r101.f504169m.a(r101, r100.a(), 3);
            k r102 = this.f504191e;
            if (r102.f504166j == false) goto L18;
            View r103 = r102.f504158b.getView();
            this.f504190d.a(r103);
            ObjectAnimator r104 = h(r103, 400, this.f504191e.f504157a.f504202b);
            k r105 = this.f504191e;
            View r106 = r105.f504182z;
            if (r106 != null) goto L7;
        L9:
            ObjectAnimator r107 = null;
        L10:
            k r108 = this.f504191e;
            View r109 = r108.A;
            if (r109 != null) goto L13;
        L15:
            AnimatorSet r110 = new AnimatorSet();
            r110.play(r104);
            Animator r111 = r110;
            if (r107 == null) goto L34;
            r110.play(r107).with(r104);
            r111 = r110;
        L34:
            r111.addListener(this);
            r111.start();
            return;
        L13:
            if (r108.f504157a.f504203c == true) goto L15;
            r107 = h(r109, 400, r103.getBottom());
            goto L15
        L7:
            if (r105.f504157a.f504203c == false) goto L9;
            r107 = h(r106, 400, -r106.getHeight());
            goto L10
        L18:
            View r112 = r102.f504158b.getView();
            this.f504190d.a(r112);
            k r113 = this.f504191e;
            float r114 = r113.f504173q;
            float r115 = 0.0f;
            if (r114 != 0.0f) goto L21;
        L33:
            r111 = g(r112, this.f504190d.f504185b);
            goto L34
        L21:
            if (r114 < 0.0f) goto L23;
        L24:
            if (r114 > 0.0f) goto L26;
        L28:
            float r116 = -r114;
            float r117 = r116 / this.f504188b;
            if (r117 < 0.0f) goto L32;
            r115 = r117;
        L32:
            float r118 = (r116 * r114) / this.f504189c;
            b r119 = this.f504190d;
            float r120 = r119.f504185b + r118;
            ObjectAnimator r121 = ObjectAnimator.ofFloat(r112, r119.f504184a, new float[]{r120});
            r121.setDuration((int) r115);
            r121.setInterpolator(this.f504187a);
            r121.addUpdateListener(this);
            ObjectAnimator r122 = g(r112, r120);
            AnimatorSet r123 = new AnimatorSet();
            r123.playSequentially(new Animator[]{r121, r122});
            r111 = r123;
            goto L34
        L26:
            if (r113.f504157a.f504203c == true) goto L28;
        L23:
            if (r113.f504157a.f504203c == true) goto L33;
            goto L24
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            k r101 = this.f504191e;
            r101.e(r101.f504159c);
            this.f504191e.f504170n.b();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            kn2.f r101 = this.f504191e.f504170n;
            ((Float) r100.getAnimatedValue()).floatValue();
            r101.a();
        }

        public final ObjectAnimator g(View r100, float r101) {
            float r102 = Math.abs(r101);
            b r103 = this.f504190d;
            float r104 = (r102 / r103.f504186c) * 800.0f;
            ObjectAnimator r105 = ObjectAnimator.ofFloat(r100, r103.f504184a, new float[]{this.f504191e.f504157a.f504202b});
            r105.setDuration(Math.max((int) r104, 200));
            r105.setInterpolator(this.f504187a);
            r105.addUpdateListener(this);
            return r105;
        }

        public final ObjectAnimator h(View r100, int r101, float r102) {
            ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, this.f504190d.f504184a, new float[]{r102});
            r103.setDuration(Math.max(400, 200));
            r103.setInterpolator(this.f504187a);
            r103.addUpdateListener(this);
            return r103;
        }
    }

    public interface d {
        int a();

        boolean b(MotionEvent r100);

        void d(d r100);

        boolean e();

        boolean f(float r100);
    }

    public class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f504192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f504193b;

        @Override // kn2.k.d
        public final int a() {
            return 0;
        }

        @Override // kn2.k.d
        public final boolean e() {
            return false;
        }

        @Override // kn2.k.d
        public final boolean f(float r100) {
            return false;
        }

        public e(k r100) {
            this.f504193b = r100;
            this.f504192a = r100.c();
        }

        @Override // kn2.k.d
        public final boolean b(MotionEvent r100) {
            View r101 = this.f504193b.f504158b.getView();
            if (this.f504192a.a(r101, r100) == true) goto L6;
            return false;
        L6:
            if (this.f504193b.f504158b.a() == false) goto L10;
            if (this.f504192a.f504200c == false) goto L10;
        L13:
            k r102 = this.f504193b;
            if (r102.f504174r == true) goto L16;
        L26:
            h r103 = this.f504193b.f504157a;
            r103.f504201a = r100.getPointerId(0);
            k r104 = this.f504193b;
            h r105 = r104.f504157a;
            g r106 = this.f504192a;
            r105.f504202b = r106.f504198a;
            r105.f504203c = r106.f504200c;
            r104.e(r104.f504160d);
            this.f504193b.f504160d.b(r100);
            return true;
        L16:
            if (r102.f504182z != null) goto L26;
            if (this.f504192a.f504200c == false) goto L24;
            if (r102.d().getOverScrollMode() == 0) goto L22;
            this.f504193b.d().setOverScrollMode(0);
        L22:
            return false;
        L24:
            if (r102.d().getOverScrollMode() == 2) goto L26;
            this.f504193b.d().setOverScrollMode(2);
        L10:
            if (this.f504193b.f504158b.b() == true) goto L12;
        L28:
            return false;
        L12:
            if (this.f504192a.f504200c == true) goto L28;
            goto L13
        }

        @Override // kn2.k.d
        public final void d(d r100) {
            k r101 = this.f504193b;
            r101.f504169m.a(r101, r100.a(), 0);
            this.f504193b.f504167k = false;
        }
    }

    public class f implements d, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f504194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f504195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f504196c;

        public class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f504197a;

            public a(f r100) {
                this.f504197a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                ALogger.i("OverScrollDecor", "LoadMoreLoadingState back to bottom anim end");
                View r101 = this.f504197a.f504196c.A;
                if (r101 != null) goto L5;
            L7:
                k r102 = this.f504197a.f504196c;
                r102.e(r102.f504159c);
                return;
            L5:
                if ((r101 instanceof OverScrollFooterView) == false) goto L7;
                ((OverScrollFooterView) r101).setLoading(false);
                goto L7
            }
        }

        @Override // kn2.k.d
        public final int a() {
            return 5;
        }

        @Override // kn2.k.d
        public final boolean f(float r100) {
            return false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public final void h() {
            ALogger.i("OverScrollDecor", "LoadMoreLoadingState onTouchEvent, stop loadmore, back to bottom anim start offset = " + this.f504196c.f504157a.f504202b);
            View r100 = this.f504196c.f504158b.getView();
            this.f504194a.a(r100);
            ObjectAnimator r101 = g(r100, 100, 0.0f);
            k r102 = this.f504196c;
            View r103 = r102.A;
            if (r103 != null) goto L5;
        L7:
            ObjectAnimator r104 = null;
        L8:
            AnimatorSet r105 = new AnimatorSet();
            r105.play(r101);
            if (r104 == null) goto L11;
            r105.play(r104).with(r101);
        L11:
            r105.addListener(new a(this));
            r105.start();
            return;
        L5:
            if (r102.f504157a.f504203c == true) goto L7;
            r104 = g(r103, 100, r100.getBottom());
            goto L8
        }

        @Override // kn2.k.d
        public final boolean e() {
            h();
            return true;
        }

        public f(k r100) {
            this.f504196c = r100;
            this.f504195b = false;
            this.f504194a = r100.b();
        }

        @Override // kn2.k.d
        public final boolean b(MotionEvent r100) {
            h();
            return true;
        }

        @Override // kn2.k.d
        public final void d(d r100) {
            ALogger.i("OverScrollDecor", "LoadMoreLoadingState handleEntryTransition from state: " + r100 + "offset = " + this.f504196c.f504157a.f504202b);
            k r101 = this.f504196c;
            r101.f504165i = r101.f504163g;
            r101.f504169m.a(r101, r100.a(), 5);
            View r102 = this.f504196c.f504158b.getView();
            this.f504194a.a(r102);
            float r103 = k.C;
            ObjectAnimator r104 = g(r102, 100, -r103);
            k r105 = this.f504196c;
            View r106 = r105.A;
            if (r106 != null) goto L5;
        L7:
            ObjectAnimator r107 = null;
        L8:
            AnimatorSet r108 = new AnimatorSet();
            r108.play(r104);
            if (r107 == null) goto L11;
            r108.play(r107).with(r104);
        L11:
            r108.addListener(this);
            r108.start();
            return;
        L5:
            if (r105.f504157a.f504203c == true) goto L7;
            r107 = g(r106, 100, r102.getBottom() - r103);
            goto L8
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            ALogger.i("OverScrollDecor", "back to loadmore anim end, start loadmore ");
            View r101 = this.f504196c.A;
            if (r101 != null) goto L5;
        L7:
            k r102 = this.f504196c;
            r102.f504164h = r102.f504163g;
            kn2.c r103 = r102.f504172p;
            if (r103 == null) goto L11;
            r103.a(r102.f504168l);
            return;
        L11:
            return;
        L5:
            if ((r101 instanceof OverScrollFooterView) == false) goto L7;
            ((OverScrollFooterView) r101).setLoading(true);
            goto L7
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            kn2.f r101 = this.f504196c.f504170n;
            ((Float) r100.getAnimatedValue()).floatValue();
            r101.a();
        }

        public final ObjectAnimator g(View r100, int r101, float r102) {
            ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, this.f504194a.f504184a, new float[]{r102});
            r103.setDuration(Math.max(100, 200));
            r103.setInterpolator(new DecelerateInterpolator());
            r103.addUpdateListener(this);
            return r103;
        }
    }

    public static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f504198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f504199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f504200c;

        public g() {
        }

        public abstract boolean a(View r100, MotionEvent r101);
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f504201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f504202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f504203c;

        public h() {
        }
    }

    public class i implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f504204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f504205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g f504206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f504207d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f504208e;

        @Override // kn2.k.d
        public final boolean e() {
            return false;
        }

        @Override // kn2.k.d
        public final int a() {
            return this.f504207d;
        }

        public i(k r100) {
            this.f504208e = r100;
            this.f504206c = r100.c();
            this.f504204a = 3.0f;
            this.f504205b = 1.0f;
        }

        @Override // kn2.k.d
        public final boolean b(MotionEvent r110) {
            if (this.f504208e.f504157a.f504201a == r110.getPointerId(0)) goto L6;
            k r111 = this.f504208e;
            r111.e(r111.f504161e);
            return true;
        L6:
            View r100 = this.f504208e.f504158b.getView();
            if (this.f504206c.a(r100, r110) == true) goto L9;
            return true;
        L9:
            g r101 = this.f504206c;
            float r102 = r101.f504199b;
            boolean r103 = r101.f504200c;
            k r104 = this.f504208e;
            h r105 = r104.f504157a;
            boolean r106 = r105.f504203c;
            if (r103 != r106) goto L12;
            float r107 = this.f504204a;
        L13:
            float r108 = r102 / r107;
            float r109 = r101.f504198a + r108;
            if (r106 == false) goto L18;
            if (r103 == true) goto L18;
            if (r109 > r105.f504202b) goto L18;
        L22:
            r104.k(r100, r105.f504202b, r110);
            this.f504208e.f504170n.a();
            k r112 = this.f504208e;
            r112.e(r112.f504159c);
            return true;
        L18:
            if (r106 == true) goto L25;
            if (r103 == false) goto L25;
            if (r109 >= r105.f504202b) goto L22;
        L25:
            if (r100.getParent() == null) goto L27;
            r100.getParent().requestDisallowInterceptTouchEvent(true);
        L27:
            long r113 = r110.getEventTime() - r110.getHistoricalEventTime(0);
            if (r113 <= 0) goto L30;
            this.f504208e.f504173q = r108 / r113;
        L30:
            this.f504208e.j(r100, r109);
            this.f504208e.f504170n.a();
            return true;
        L12:
            r107 = this.f504205b;
            goto L13
        }

        @Override // kn2.k.d
        public final void d(d r100) {
            k r101 = this.f504208e;
            if (r101.f504157a.f504203c == false) goto L5;
            int r102 = 1;
        L6:
            this.f504207d = r102;
            r101.f504169m.a(r101, r100.a(), this.f504207d);
            return;
        L5:
            r102 = 2;
            goto L6
        }

        @Override // kn2.k.d
        public final boolean f(float r100) {
            float r101 = this.f504208e.d().getTranslationY();
            if (r101 <= k.B) goto L9;
            k r102 = this.f504208e;
            if (r102.f504182z == null) goto L9;
            if (r102.f504180x == false) goto L9;
            r102.e(r102.f504162f);
            return false;
        L9:
            k r103 = this.f504208e;
            if (r103.f504178v == false) goto L21;
            if (r101 < (-r103.f504176t)) goto L16;
            if (r100 >= (-r103.f504177u)) goto L21;
        L16:
            if ((r103.A instanceof OverScrollFooterView) == false) goto L21;
            if (r103.f504168l == false) goto L21;
            f r104 = r103.f504163g;
            r104.f504195b = true;
            r103.e(r104);
            return false;
        L21:
            if (r101 < (-r103.f504175s)) goto L23;
        L27:
            r103.e(r103.f504161e);
            return false;
        L23:
            if ((r103.A instanceof OverScrollFooterView) == false) goto L27;
            if (r103.f504168l == false) goto L27;
            r103.e(r103.f504163g);
            return false;
        }
    }

    public class j implements d, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f504209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f504210b;

        public class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f504211a;

            public a(j r100) {
                this.f504211a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                ALogger.i("OverScrollDecor", "back to top anim end");
                View r101 = this.f504211a.f504210b.f504182z;
                if (r101 != null) goto L5;
            L7:
                k r102 = this.f504211a.f504210b;
                r102.e(r102.f504159c);
                return;
            L5:
                if ((r101 instanceof OverScrollHeaderRefreshView) == false) goto L7;
                ((OverScrollHeaderRefreshView) r101).setRefreshing(false);
                goto L7
            }
        }

        @Override // kn2.k.d
        public final int a() {
            return 4;
        }

        @Override // kn2.k.d
        public final boolean f(float r100) {
            return false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public final void h() {
            ALogger.i("OverScrollDecor", "onTouchEvent, stop refresh, back to top anim start");
            View r100 = this.f504210b.f504158b.getView();
            this.f504209a.a(r100);
            ObjectAnimator r101 = g(r100, 100, this.f504210b.f504157a.f504202b);
            k r102 = this.f504210b;
            View r103 = r102.f504182z;
            if (r103 != null) goto L5;
        L7:
            ObjectAnimator r104 = null;
        L8:
            AnimatorSet r105 = new AnimatorSet();
            r105.play(r101);
            if (r104 == null) goto L11;
            r105.play(r104).with(r101);
        L11:
            r105.addListener(new a(this));
            r105.start();
            return;
        L5:
            if (r102.f504157a.f504203c == false) goto L7;
            r104 = g(r103, 100, -r103.getHeight());
            goto L8
        }

        @Override // kn2.k.d
        public final boolean e() {
            h();
            return true;
        }

        public j(k r100) {
            this.f504210b = r100;
            this.f504209a = r100.b();
        }

        @Override // kn2.k.d
        public final boolean b(MotionEvent r100) {
            h();
            return true;
        }

        @Override // kn2.k.d
        public final void d(d r100) {
            ALogger.i("OverScrollDecor", "handleEntryTransition from state: " + r100);
            k r101 = this.f504210b;
            r101.f504169m.a(r101, r100.a(), 4);
            View r102 = this.f504210b.f504158b.getView();
            this.f504209a.a(r102);
            float r103 = k.B;
            ObjectAnimator r104 = g(r102, 200, r103);
            k r105 = this.f504210b;
            View r106 = r105.f504182z;
            if (r106 != null) goto L5;
        L7:
            ObjectAnimator r107 = null;
        L8:
            AnimatorSet r108 = new AnimatorSet();
            r108.play(r104);
            if (r107 == null) goto L11;
            r108.play(r107).with(r104);
        L11:
            r108.addListener(this);
            r108.start();
            return;
        L5:
            if (r105.f504157a.f504203c == false) goto L7;
            r107 = g(r106, 200, (-r106.getHeight()) + r103);
            goto L8
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            ALogger.i("OverScrollDecor", "back to refresh anim end, start refreshing");
            View r101 = this.f504210b.f504182z;
            if (r101 != null) goto L5;
        L7:
            kn2.d r102 = this.f504210b.f504171o;
            if (r102 == null) goto L11;
            r102.onRefresh();
            return;
        L11:
            return;
        L5:
            if ((r101 instanceof OverScrollHeaderRefreshView) == false) goto L7;
            ((OverScrollHeaderRefreshView) r101).setRefreshing(true);
            goto L7
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            kn2.f r101 = this.f504210b.f504170n;
            ((Float) r100.getAnimatedValue()).floatValue();
            r101.a();
        }

        public final ObjectAnimator g(View r100, int r101, float r102) {
            ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, this.f504209a.f504184a, new float[]{r102});
            r103.setDuration(Math.max(r101, 200));
            r103.setInterpolator(new DecelerateInterpolator());
            r103.addUpdateListener(this);
            return r103;
        }
    }

    public abstract b b();

    public abstract g c();

    public abstract void j(View r100, float r101);

    public abstract void k(View r100, float r101, MotionEvent r102);

    static {
        B = s1.f(60.0f);
        C = s1.f(60.0f);
        D = s1.f(180.0f);
    }

    public final View d() {
        return this.f504158b.getView();
    }

    public final boolean f() {
        ALogger.i("OverScrollDecor", "setLoading: false, currentState: " + this.f504164h);
        d r100 = this.f504164h;
        f r101 = this.f504163g;
        if (r100 != r101) goto L6;
        this.f504165i = this.f504159c;
        r101.h();
        return true;
    L6:
        return false;
    }

    public final void i() {
        ALogger.i("OverScrollDecor", "setRefreshing: false, currentState: " + this.f504164h);
        d r100 = this.f504164h;
        j r101 = this.f504162f;
        if (r100 != r101) goto L6;
        r101.h();
        return;
    }

    public final void a() {
        d().setOnTouchListener(this);
        d().setOverScrollMode(2);
        if ((d() instanceof LiveVerticalViewPager) == false) goto L9;
        LiveVerticalViewPager r100 = (LiveVerticalViewPager) d();
        a r101 = this.f504181y;
        if (r101 == null) goto L7;
        r100.f161140e3.add(r101);
        return;
    L7:
        r100.getClass();
        return;
    }

    public k(ln2.b r100) {
        this.f504157a = new h();
        this.f504166j = false;
        this.f504167k = false;
        this.f504168l = true;
        this.f504169m = new kn2.i();
        this.f504170n = new kn2.j();
        this.f504171o = new kn2.h();
        this.f504172p = new kn2.g();
        float r101 = C;
        this.f504175s = r101;
        this.f504176t = r101;
        this.f504177u = D;
        this.f504178v = false;
        this.f504179w = null;
        this.f504181y = new a(this);
        this.f504158b = r100;
        this.f504161e = new c(this);
        this.f504160d = new i(this);
        e r102 = new e(this);
        this.f504159c = r102;
        this.f504162f = new j(this);
        this.f504163g = new f(this);
        this.f504164h = r102;
        this.f504166j = false;
        a();
    }

    public final void e(d r100) {
        d r101 = this.f504164h;
        this.f504164h = r100;
        r100.d(r101);
    }

    public final void g(boolean r100) {
        ALogger.i("OverScrollDecor", "setLoadingEnable: hasMore = " + r100);
        this.f504168l = r100;
        View r101 = this.A;
        if ((r101 instanceof OverScrollFooterView) == false) goto L19;
        OverScrollFooterView r102 = (OverScrollFooterView) r101;
        r102.f154184e = r100;
        if (r100 == false) goto L12;
        LinearLayout r103 = r102.f154180a;
        if (r103 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r103);
    L9:
        TextView r104 = r102.f154182c;
        if (r104 == null) goto L20;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    L20:
        return;
    L12:
        TextView r105 = r102.f154182c;
        if (r105 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r105);
    L15:
        LinearLayout r106 = r102.f154180a;
        if (r106 == null) goto L22;
        UtilityKotlinExtentionsKt.t(r106);
        return;
    L22:
        return;
    }

    public final void h(boolean r100) {
        ALogger.i("OverScrollDecor", "setRefreshEnable: " + r100);
        this.f504180x = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (this.f504179w != null) goto L5;
        this.f504179w = VelocityTracker.obtain();
    L5:
        this.f504179w.addMovement(r101);
        int r102 = r101.getAction();
        if (r102 != 1) goto L8;
    L15:
        VelocityTracker r103 = this.f504179w;
        if (r103 == null) goto L18;
        r103.computeCurrentVelocity(1000);
        float r104 = this.f504179w.getYVelocity();
        this.f504179w.recycle();
        this.f504179w = null;
    L20:
        return this.f504164h.f(r104);
    L18:
        r104 = 0.0f;
        goto L20
    L8:
        if (r102 == 2) goto L14;
        if (r102 == 3) goto L15;
        return false;
    L14:
        return this.f504164h.b(r101);
    }

    public k(ViewPagerOverScrollDecorAdapter r100, View r101, View r102) {
        this.f504157a = new h();
        this.f504166j = false;
        this.f504167k = false;
        this.f504168l = true;
        this.f504169m = new kn2.i();
        this.f504170n = new kn2.j();
        this.f504171o = new kn2.h();
        this.f504172p = new kn2.g();
        float r103 = C;
        this.f504175s = r103;
        this.f504176t = r103;
        this.f504177u = D;
        this.f504178v = false;
        this.f504179w = null;
        this.f504181y = new a(this);
        this.f504158b = r100;
        this.f504182z = r101;
        this.A = r102;
        this.f504161e = new c(this);
        this.f504160d = new i(this);
        e r104 = new e(this);
        this.f504159c = r104;
        this.f504162f = new j(this);
        this.f504163g = new f(this);
        this.f504164h = r104;
        this.f504166j = true;
        a();
    }
}
