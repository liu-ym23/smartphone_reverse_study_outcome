package ctc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import kotlin.collections.ArraysKt;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements MovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f465387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ctc.a f465388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VelocityTracker f465389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f465390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f465391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f465392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f465393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f465394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f465395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f465396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f465397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MovementMethod f465398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f465399m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueAnimator f465400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OverScroller f465401b;

        /* JADX INFO: renamed from: ctc.d$a$a, reason: collision with other inner class name */
        public static final class InterpolatorC5586a implements Interpolator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final InterpolatorC5586a f465402a = null;

            static {
                f465402a = new InterpolatorC5586a();
            }

            public InterpolatorC5586a() {
            }

            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float r100) {
                float r101 = r100 - 1.0f;
                return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
            }
        }

        public a(Context r100) {
            this.f465401b = new OverScroller(r100, InterpolatorC5586a.f465402a);
        }
    }

    @Override // android.text.method.MovementMethod
    public final boolean canSelectArbitrarily() {
        return this.f465398l.canSelectArbitrarily();
    }

    @Override // android.text.method.MovementMethod
    public final void initialize(TextView r100, Spannable r101) {
        this.f465398l.initialize(r100, r101);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onGenericMotionEvent(TextView r100, Spannable r101, MotionEvent r102) {
        return this.f465398l.onGenericMotionEvent(r100, r101, r102);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyDown(TextView r100, Spannable r101, int r102, KeyEvent r103) {
        return this.f465398l.onKeyDown(r100, r101, r102, r103);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyOther(TextView r100, Spannable r101, KeyEvent r102) {
        return this.f465398l.onKeyOther(r100, r101, r102);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyUp(TextView r100, Spannable r101, int r102, KeyEvent r103) {
        return this.f465398l.onKeyUp(r100, r101, r102, r103);
    }

    @Override // android.text.method.MovementMethod
    public final void onTakeFocus(TextView r100, Spannable r101, int r102) {
        this.f465398l.onTakeFocus(r100, r101, r102);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onTrackballEvent(TextView r100, Spannable r101, MotionEvent r102) {
        return this.f465398l.onTrackballEvent(r100, r101, r102);
    }

    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.VelocityTracker, ctc.a] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final void a(TextView r110, MotionEvent r210) {
        int r100 = r210.getActionMasked();
        int r101 = 0;
        if (r100 != 0) goto L42;
        this.f465393g = true;
        this.f465394h = r210.getX();
        this.f465395i = r210.getY();
        a r102 = this.f465390d;
        if (r102 == null) goto L10;
        ValueAnimator r103 = r102.f465400a;
        if (r103 == null) goto L9;
        r103.cancel();
    L9:
        r102.f465400a = null;
        r102.f465401b.abortAnimation();
    L10:
        int r104 = b.f465383a;
        ctc.a[] r105 = (ctc.a[]) b.a.a(r210, r110, ctc.a.class);
        if (r105 == null) goto L13;
        ctc.a r106 = (ctc.a) ArraysKt.firstOrNull(r105);
    L14:
        this.f465388b = r106;
        if (r106 != null) goto L17;
    L79:
        if (r100 != 1) goto L81;
    L82:
        ctc.a r107 = this.f465388b;
        if (r107 == null) goto L99;
        VelocityTracker r108 = this.f465389c;
        if (r108 == null) goto L106;
        r108.computeCurrentVelocity(1000, this.f465391e);
    L106:
        VelocityTracker r109 = this.f465389c;     // Catch: Exception -> L92
        if (r109 == null) goto L91;
        r101 = MathKt.roundToInt(r109.getXVelocity());     // Catch: Exception -> L92
    L91:
        int r111 = r101;
    L93:
        a r112 = this.f465390d;
        if (r112 == null) goto L99;
        OverScroller r113 = r112.f465401b;
        int r114 = (int) r107.f465380a;
        float r115 = r107.f465381b;
        r113.fling(r114, 0, r111, 0, -((int) r115), 0, 0, 0, (int) (Math.abs(r115) * r107.f465382c), 0);
        ValueAnimator r116 = r112.f465400a;
        if (r116 == null) goto L98;
        r116.cancel();
    L98:
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r117.setDuration(Long.MAX_VALUE);
        r117.addUpdateListener(new c(r112, r107, r110));
        r117.start();
        r112.f465400a = r117;
        ?? r118 = 0;
    L100:
        this.f465388b = r118;
        VelocityTracker r119 = this.f465389c;
        if (r119 == null) goto L103;
        r119.recycle();
    L103:
        this.f465389c = r118;
    L104:
        this.f465387a = r210.getX();
        return;
    L92:
        r111 = 0;
    L99:
        r118 = 0;
        goto L100
    L81:
        if (r100 != 3) goto L104;
    L17:
        if (r106.a() == false) goto L22;
        ViewParent r120 = r110.getParent();
        if (r120 == null) goto L22;
        r120.requestDisallowInterceptTouchEvent(true);
    L22:
        if (Math.abs(r106.f465380a) >= r106.f465381b) goto L24;
    L27:
        boolean r121 = true;
    L28:
        this.f465396j = r121;
        if (r106.f465380a >= 0) goto L31;
    L34:
        boolean r122 = true;
    L35:
        this.f465397k = r122;
        VelocityTracker r123 = this.f465389c;
        if (r123 == null) goto L38;
        r123.clear();
    L39:
        VelocityTracker r124 = this.f465389c;
        if (r124 == null) goto L79;
        r124.addMovement(r210);
        goto L79
    L38:
        this.f465389c = VelocityTracker.obtain();
        goto L39
    L31:
        if (r106.f465382c != 0.0f) goto L34;
        r122 = false;
        goto L35
    L24:
        if (r106.f465382c != 0.0f) goto L27;
        r121 = false;
        goto L28
    L13:
        r106 = null;
        goto L14
    L42:
        ctc.a r125 = this.f465388b;
        if (r125 == null) goto L79;
        if (r125.a() == false) goto L79;
        float r126 = Math.abs(r210.getX() - this.f465394h);
        if (this.f465393g == true) goto L49;
    L51:
        float r127 = Math.abs(r210.getY() - this.f465395i);
        if (r127 <= r126) goto L59;
        if (r127 <= this.f465392f) goto L59;
        ViewParent r128 = r110.getParent();
        if (r128 == null) goto L59;
        r128.requestDisallowInterceptTouchEvent(false);
    L59:
        if (r126 > r127) goto L61;
    L76:
        VelocityTracker r129 = this.f465389c;
        if (r129 == null) goto L79;
        r129.addMovement(r210);
        goto L79
    L61:
        if (r126 <= this.f465392f) goto L76;
        if (this.f465399m == true) goto L65;
    L75:
        r125.b(r125.f465380a + (r210.getX() - this.f465387a));
        ViewCompat.postInvalidateOnAnimation(r110);
        goto L76
    L65:
        if (r210.getX() <= this.f465394h) goto L69;
        if (this.f465397k == true) goto L69;
    L72:
        ViewParent r130 = r110.getParent();
        if (r130 == null) goto L75;
        r130.requestDisallowInterceptTouchEvent(false);
    L69:
        if (r210.getX() >= this.f465394h) goto L75;
        if (this.f465396j == true) goto L75;
    L49:
        if (r126 <= this.f465392f) goto L51;
        r110.cancelLongPress();
        this.f465393g = false;
        goto L51
    }

    public d(Context r100, io.noties.markwon.ext.tables.d r101, boolean r102) {
        this.f465398l = r101;
        this.f465399m = r102;
        int r103 = ftc.b.f478828a;
        String r104 = Build.MANUFACTURER;
        String r105 = Build.BRAND;
        String r106 = Build.MODEL;
        boolean r107 = true;
        if (StringsKt.equals(r104, "Xiaomi", true) == false) goto L5;
    L14:
        if (r107 == false) goto L21;
    L17:
        a r108 = null;
    L18:
        this.f465390d = r108;
        this.f465391e = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        this.f465392f = ViewConfiguration.get(r100).getScaledTouchSlop();
        return;
    L21:
        r108 = new a(r100);     // Catch: Exception -> L20
    L5:
        if (StringsKt.equals(r105, "Xiaomi", true) == true) goto L14;
        if (StringsKt.equals(r105, "Redmi", true) == true) goto L14;
        if (StringsKt.startsWith(r106, "Mi", true) == true) goto L14;
        if (StringsKt.startsWith(r106, "Redmi", true) == true) goto L14;
        r107 = false;
        goto L14
    }

    @Override // android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r102) {
        a(r100, r102);     // Catch: Exception -> L4
    L7:
        return this.f465398l.onTouchEvent(r100, r101, r102);
    L4:
        e = move-exception;
        e.toString();
        goto L7
    }
}
