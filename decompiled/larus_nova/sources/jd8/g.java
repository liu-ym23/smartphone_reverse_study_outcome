package jd8;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.input.swipe.InputContentMode;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class g {
    public boolean A;
    public boolean B;
    public int C;
    public long D;
    public int E;
    public int F;
    public u G;
    public View H;
    public s I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ze8.d f498672J;
    public d K;
    public int L;
    public ValueAnimator M;
    public float N;
    public float O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    public final int[] Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f498673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f498674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ICoreInputAbility f498675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final va8.o f498676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f498677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f498678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public jd8.a f498679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jd8.a f498680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ze8.d f498681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f498682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f498683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ze8.d f498684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f498685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f498686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f498687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f498688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f498689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f498690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HashMap<String, Integer> f498691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashMap<String, Boolean> f498692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap<String, Boolean> f498693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f498694v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f498695w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ze8.d f498696x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public jd8.c f498697y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewTreeObserver f498698z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f498699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f498700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f498701c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f498699a, r101.f498699a) == true) goto L12;
            return false;
        L12:
            if (this.f498700b == r101.f498700b) goto L15;
            return false;
        L15:
            if (this.f498701c == r101.f498701c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f498699a.hashCode() * 31) + this.f498700b) * 31) + this.f498701c;
        }

        public final String toString() {
            return "SnapshotAlignmentState(view=" + this.f498699a + ", topToTop=" + this.f498700b + ", bottomToBottom=" + this.f498701c + ')';
        }

        public b(View r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f498699a = r100;
            this.f498700b = r101;
            this.f498701c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f498702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f498703b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f498702a, r101.f498702a) == true) goto L12;
            return false;
        L12:
            if (this.f498703b == r101.f498703b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f498702a.hashCode() * 31) + this.f498703b;
        }

        public final String toString() {
            return "SnapshotVisibilityState(view=" + this.f498702a + ", visibility=" + this.f498703b + ')';
        }

        public c(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f498702a = r100;
            this.f498703b = r101;
        }
    }

    static {
    }

    public static int u(boolean r100) {
        if (r100 == false) goto L4;
        return 0;
    L4:
        return 8;
    }

    public final void m() {
        ViewTreeObserver r100 = null;
        this.f498672J = null;
        this.L = 0;
        d r101 = this.K;
        if (r101 != null) goto L5;
        return;
    L5:
        this.K = null;
        View r102 = this.H;
        if (r102 == null) goto L15;
        ViewTreeObserver r103 = r102.getViewTreeObserver();
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.isAlive() == false) goto L12;
        r100 = r103;
    L12:
        if (r100 == null) goto L17;
        r100.removeOnPreDrawListener(r101);
        return;
    L17:
        return;
    }

    public final void f() {
        jd8.a r100 = this.f498679g;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        jd8.a r101 = this.f498679g;
        if (r101 == null) goto L8;
        r101.a(null);
    L8:
        jd8.a r102 = this.f498679g;
        if (r102 == null) goto L11;
        r102.setClipBounds(null);
    L11:
        jd8.a r103 = this.f498680h;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        jd8.a r104 = this.f498680h;
        if (r104 == null) goto L17;
        r104.a(null);
    L17:
        jd8.a r105 = this.f498680h;
        if (r105 == null) goto L21;
        r105.setClipBounds(null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.ViewTreeObserver$OnPreDrawListener, jd8.d] */
    public final void g() {
        ze8.d r100 = this.f498696x;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f498696x = null;
        l();
        o();
        s r101 = this.I;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        View r102 = this.f498678f;
        if (r102 == null) goto L12;
        r102.getLocationInWindow(this.Z);
        this.P = MathKt.roundToInt(this.Z[0] - r102.getTranslationX());
        this.Q = MathKt.roundToInt(this.Z[1] - r102.getTranslationY());
        this.R = r102.getWidth();
        this.S = r102.getHeight();
    L12:
        TextView r103 = j();
        if (r103 == null) goto L15;
        r103.scrollTo(0, t(r103));
    L15:
        Integer r104 = this.f498687o;
        if (r104 == null) goto L20;
        int r105 = r104.intValue();
        View r106 = this.f498678f;
        if (r106 == null) goto L20;
        r106.setVisibility(r105);
    L20:
        this.f498687o = null;
        Integer r107 = this.f498685m;
        if (r107 == null) goto L25;
        int r108 = r107.intValue();
        View r109 = this.f498686n;
        if (r109 == null) goto L25;
        r109.setVisibility(r108);
    L25:
        this.f498685m = null;
        this.f498686n = null;
        if (this.f498689q == false) goto L29;
        this.f498689q = false;
        this.f498674b.setBackground(this.f498688p);
        this.f498688p = null;
    L29:
        jd8.a r110 = this.f498679g;
        if (r110 == null) goto L32;
        r110.setVisibility(8);
    L32:
        jd8.a r111 = this.f498679g;
        if (r111 == null) goto L35;
        r111.a(null);
    L35:
        jd8.a r112 = this.f498679g;
        if (r112 == null) goto L38;
        r112.setClipBounds(null);
    L38:
        jd8.a r113 = this.f498680h;
        if (r113 != null) goto L41;
    L44:
        f();
    L45:
        View r114 = this.H;
        if (r114 != null) goto L48;
    L55:
        ValueAnimator r115 = this.M;
        if (r115 == null) goto L58;
        this.M = null;
        r115.removeAllListeners();
        r115.cancel();
    L58:
        f();
        s r116 = this.I;
        if (r116 == null) goto L61;
        r116.e();
    L61:
        this.f498682j = null;
        this.f498683k = null;
        this.f498681i = null;
        this.f498691s.clear();
        this.f498692t.clear();
        this.f498693u.clear();
        return;
    L48:
        if (this.G == null) goto L55;
        this.f498672J = r100;
        this.L = 0;
        q();
        if (this.f498672J == null) goto L61;
        if (this.K != null) goto L61;
        ?? r117 = new d(this);
        this.K = r117;
        r114.getViewTreeObserver().addOnPreDrawListener(r117);
        goto L61
    L41:
        if (r113.getVisibility() != 0) goto L44;
        r113.a(null);
        r113.setBorderFadeFraction(1.0f);
        goto L45
    }

    public final TextView j() {
        g9.b r100 = new g9.b(this.f498674b);
        Intrinsics.checkNotNullParameter(r100, "finder");
        Object r101 = new h9(r100, R.id.input_text).f298553a;
        if ((r101 instanceof TextView) == true) goto L7;
        return null;
    L7:
        return (TextView) r101;
    }

    public final void l() {
        jd8.c r100 = this.f498697y;
        ViewTreeObserver r101 = this.f498698z;
        this.f498697y = null;
        this.f498698z = null;
        if (r100 == null) goto L11;
        if (r101 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L11;
        r101.removeOnPreDrawListener(r100);
        goto L11
    L6:
        if (r101.isAlive() != true) goto L8;
        r102 = true;
    L11:
        this.A = false;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E++;
        this.F = -1;
    }

    public final void o() {
        Integer r100 = this.f498690r;
        if (r100 == null) goto L11;
        int r101 = r100.intValue();
        this.f498690r = null;
        View r102 = this.f498678f;
        if (r102 != null) goto L7;
        return;
    L7:
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L12;
        r103.height = r101;
        r102.setLayoutParams(r103);
        return;
    L12:
        return;
    }

    public final void q() {
        final u r100 = this.G;
        View r101 = this.H;
        ze8.d r102 = this.f498672J;
        if (r100 == null) goto L38;
        if (r101 == null) goto L38;
        if (r102 == null) goto L38;
        r101.getLocationInWindow(this.Z);
        float r103 = this.P;
        s r104 = this.I;
        if (r104 == null) goto L10;
        int r105 = r104.b(r102);
    L11:
        int r106 = MathKt.roundToInt(r103);
        int[] r107 = this.Z;
        int r108 = r106 - r107[0];
        int r109 = r107[1];
        Rect r110 = new Rect(r108 - r101.getPaddingLeft(), (r105 - r109) - r101.getPaddingTop(), (r108 + this.R) + r101.getPaddingRight(), ((this.Q + this.S) - r109) + r101.getPaddingBottom());
        if (r110.left <= 1) goto L14;
    L20:
        boolean r111 = false;
    L21:
        if (r111 == true) goto L25;
        int r112 = this.L + 1;
        this.L = r112;
        if (r112 >= 60) goto L25;
        return;
    L25:
        if (r100.f498746b == false) goto L27;
    L29:
        ValueAnimator r113 = r100.f498748d;
        if (r113 == null) goto L32;
        r100.f498748d = null;
        r113.cancel();
    L32:
        r100.f498746b = false;
        r100.f498747c = 0;
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{0, 255});
        r114.setDuration(300);
        r114.setInterpolator(new LinearInterpolator());
        r114.addUpdateListener(new t(r100));
        r114.addListener(new v(r100));
        r114.start();
        r100.f498748d = r114;
    L33:
        ValueAnimator r115 = this.M;
        if (r115 == null) goto L36;
        this.M = null;
        r115.removeAllListeners();
        r115.cancel();
    L36:
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r116.setDuration(300);
        r116.setInterpolator(new LinearInterpolator());
        r116.addUpdateListener(new f(this));
        r116.addListener(new h(this));
        r116.start();
        this.M = r116;
        m();
        return;
    L27:
        if (r100.f498748d != null) goto L29;
    L14:
        if (r110.top > 1) goto L20;
        if (r110.right < (r101.getWidth() - 1)) goto L20;
        if (r110.bottom < (r101.getHeight() - 1)) goto L20;
        r111 = true;
        goto L21
    L10:
        r105 = this.Q;
    L38:
        ValueAnimator r117 = this.M;
        if (r117 == null) goto L41;
        this.M = null;
        r117.removeAllListeners();
        r117.cancel();
    L41:
        f();
        s r118 = this.I;
        if (r118 == null) goto L44;
        r118.e();
    L44:
        m();
    }

    public static void p(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        c r102 = (c) r101.next();
        r102.f498702a.setVisibility(r102.f498703b);
        goto L4
    }

    public static Bitmap r(View r100) {
        if (r100.getWidth() > 0) goto L5;
    L9:
        return null;
    L5:
        if (r100.getHeight() <= 0) goto L9;
        Bitmap r101 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L11
        r100.draw(new Canvas(r101));     // Catch: Throwable -> L11
        return r101;
    }

    public static int t(TextView r100) {
        Layout r101 = r100.getLayout();
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = (r100.getHeight() - r100.getCompoundPaddingTop()) - r100.getCompoundPaddingBottom();
        if (r102 > 0) goto L9;
        return 0;
    L9:
        return RangesKt.coerceAtLeast(r101.getHeight() - r102, 0);
    }

    public final void a(ze8.d r110) {
        Intrinsics.checkNotNullParameter(r110, "spec");
        this.f498677e = true;
        String r100 = r110.f571564c;
        if (r100 == null) goto L17;
        TextView r101 = j();
        if (r101 == null) goto L14;
        CharSequence r102 = r101.getHint();
        if (r102 == null) goto L10;
        String r103 = r102.toString();
    L12:
        if (Intrinsics.areEqual(r103, r100) == false) goto L14;
    L10:
        r103 = null;
    L14:
        ICoreInputAbility r104 = this.f498675c;
        if (r104 == null) goto L17;
        r104.Yk(r100);
    L17:
        va8.o r105 = this.f498676d;
        if (r105 == null) goto L20;
        r105.Fn(r110.f571568g);
    L20:
        ICoreInputAbility r106 = this.f498675c;
        if (r106 == null) goto L23;
        ICoreInputAbility.b.d(r106, r110.f571563b, false, false, Integer.valueOf(r110.f571565d), Integer.valueOf(r110.f571566e), false, 32);
    L23:
        ICoreInputAbility r107 = this.f498675c;
        if (r107 != null) goto L26;
    L33:
        this.f498684l = r110;
        this.f498674b.post(new jd8.b(this));
        if (this.f498696x == null) goto L47;
        View r108 = this.f498678f;
        if (r108 == null) goto L48;
        jd8.c r109 = this.f498697y;
        if (r109 == null) goto L49;
        this.f498696x = r110;
        if (this.B == false) goto L45;
        i(r108);
    L45:
        this.A = false;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.F = -1;
        int r111 = this.E + 1;
        this.E = r111;
        r108.post(new e(this, r109, r111, r108));
        r108.requestLayout();
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L26:
        if (r110.f571570i != InputContentMode.SPEAK) goto L29;
        int r112 = 2;
    L32:
        r107.g2(r112, true);
        goto L33
    L29:
        if (r110.f571567f == false) goto L31;
        r112 = 3;
        goto L32
    L31:
        r112 = 1;
        goto L32
    }

    public final void c(jd8.a r100) {
        Integer r101 = null;
        if (this.Y == true) goto L6;
        r100.setClipBounds(null);
        return;
    L6:
        float r102 = this.V + r100.getTranslationX();
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L16;
        Integer r104 = Integer.valueOf(r103.height);
        if (r104.intValue() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        r101 = r104;
    L14:
        if (r101 == null) goto L16;
        int r106 = r101.intValue();
    L17:
        r100.setClipBounds(new Rect(MathKt.roundToInt(this.W - r102), 0, MathKt.roundToInt(this.X - r102), r106));
        return;
    L11:
        r105 = false;
    L16:
        r106 = this.S;
        goto L17
    }

    public final void i(View r100) {
        if (this.f498690r == null) goto L5;
        return;
    L5:
        if (r100.getHeight() <= 0) goto L13;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L12;
        this.f498690r = Integer.valueOf(r101.height);
        r101.height = r100.getHeight();
        r100.setLayoutParams(r101);
        return;
    L12:
        return;
    }

    public final void n(ze8.d r110) {
        this.f498677e = true;
        ICoreInputAbility r100 = this.f498675c;
        if (r100 == null) goto L5;
        ICoreInputAbility.b.d(r100, r110.f571563b, false, false, Integer.valueOf(r110.f571565d), Integer.valueOf(r110.f571566e), false, 32);
    L5:
        this.f498677e = false;
    }

    public static List e(g9.c r100, InputContentMode r101) {
        if (r101 == null) goto L4;
        int r102 = 0;
        if (r101 != InputContentMode.SPEAK) goto L8;
        boolean r103 = true;
    L9:
        Pair[] r104 = new Pair[3];
        Object r105 = r100.d().f298553a;
        Pair r106 = null;
        if (r105 == null) goto L12;
        Pair r107 = TuplesKt.to(r105, Integer.valueOf(u(r103)));
    L13:
        r104[0] = r107;
        Object r108 = r100.k().f298553a;
        if (r108 == null) goto L19;
        if (r103 == true) goto L18;
        r102 = 4;
    L18:
        Pair r109 = TuplesKt.to(r108, Integer.valueOf(r102));
    L20:
        r104[1] = r109;
        Object r110 = r100.j().f298553a;
        if (r110 == null) goto L23;
        r106 = TuplesKt.to(r110, Integer.valueOf(u(!r103)));
    L23:
        r104[2] = r106;
        List r111 = CollectionsKt.listOfNotNull(r104);
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
    L25:
        if (r113.hasNext() == false) goto L27;
        Pair r114 = (Pair) r113.next();
        View r115 = (View) r114.component1();
        int r116 = ((Number) r114.component2()).intValue();
        c r117 = new c(r115, r115.getVisibility());
        r115.setVisibility(r116);
        r112.add(r117);
        goto L25
    L27:
        return r112;
    L19:
        r109 = null;
        goto L20
    L12:
        r107 = null;
        goto L13
    L8:
        r103 = false;
        goto L9
    L4:
        return CollectionsKt.emptyList();
    }

    public final void b(TextView r100, boolean r101) {
        if (r101 == false) goto L5;
        r100.setMaxLines(1);
        return;
    L5:
        Integer r102 = Integer.valueOf(r100.getMaxHeight());
        if (r102.intValue() < 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L14;
        int r104 = r102.intValue();
    L15:
        r100.setMaxHeight(r104);
        return;
    L14:
        Resources r105 = this.f498674b.getResources();
        r104 = (int) TypedValue.applyDimension(1, 122.0f, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()));
        goto L15
    L8:
        r103 = false;
        goto L9
    }

    public final jd8.a h(boolean r100, int r101) {
        if (r100 == false) goto L4;
        jd8.a r102 = this.f498679g;
    L5:
        if (r102 == null) goto L14;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L13;
        int r104 = r103.width;
        int r105 = this.R;
        if (r104 == r105) goto L11;
    L12:
        r103.width = r105;
        r103.height = r101;
        r102.setLayoutParams(r103);
        goto L13
    L11:
        if (r103.height != r101) goto L12;
    L13:
        return r102;
    L14:
        jd8.a r106 = new jd8.a(this.f498673a.getContext());
        r106.setVisibility(8);
        ViewGroup r107 = this.f498673a;
        if ((r107 instanceof ConstraintLayout) == false) goto L17;
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(this.R, r101);
        r108.topToTop = 0;
        r108.startToStart = 0;
        ViewGroup.LayoutParams r109 = r108;
    L18:
        r107.addView(r106, r109);
        if (r100 == false) goto L21;
        this.f498679g = r106;
    L22:
        return r106;
    L21:
        this.f498680h = r106;
        goto L22
    L17:
        r109 = new ViewGroup.LayoutParams(this.R, r101);
        goto L18
    L4:
        r102 = this.f498680h;
        goto L5
    }

    public final int k(jd8.a r110, ze8.d r210) {
        View r100 = this.f498678f;
        if (r100 == null) goto L5;
        ze8.d r101 = this.f498684l;
        if (r101 != null) goto L12;
        r101 = this.f498681i;
        if (r101 != null) goto L12;
        return this.S;
    L12:
        ze8.d r111 = r101;
        Integer r102 = this.f498691s.get(r210.f571562a);
        if (r102 == null) goto L15;
        int r103 = r102.intValue();
    L23:
        View r112 = r100;
        int r104 = r103;
    L88:
        TextView r113 = j();
        if (r113 == null) goto L91;
        CharSequence r114 = r113.getHint();
    L92:
        if (r113 == null) goto L94;
        int r115 = r113.getMaxLines();
    L95:
        if (r113 == null) goto L97;
        int r116 = r113.getMaxHeight();
    L98:
        String r105 = r210.f571564c;
        if (r105 == null) goto L102;
        if (r113 == null) goto L102;
        r113.setHint(r105);
    L102:
        n(r210);
        if (r113 != null) goto L105;
    L109:
        va8.o r106 = this.f498676d;
        if (r106 == null) goto L112;
        r106.Fn(r210.f571568g);
    L112:
        boolean r107 = r210.f571567f;
        Boolean r108 = this.f498692t.get(r210.f571562a);
        if (r108 == null) goto L115;
        boolean r109 = r108.booleanValue();
    L116:
        View r117 = r112;
        int r118 = r104;
        Bitmap r119 = s(r117, r107, r118, Boolean.valueOf(r109), this.f498693u.get(r210.f571562a), r210.f571569h, r210.f571570i);
        va8.o r120 = this.f498676d;
        if (r120 == null) goto L119;
        r120.Fn(r111.f571568g);
    L119:
        n(r111);
        if (r113 == null) goto L125;
        if (r116 < 0) goto L123;
        r113.setMaxHeight(r116);
        goto L125
    L123:
        if (r115 < 0) goto L125;
        r113.setMaxLines(r115);
    L125:
        if (r113 == null) goto L127;
        r113.setHint(r114);
    L127:
        ViewGroup.LayoutParams r121 = r110.getLayoutParams();
        if (r121 == null) goto L130;
        r121.width = this.R;
        r121.height = r104;
        jd8.a r122 = r110;
        r122.setLayoutParams(r121);
    L131:
        r122.a(r119);
        return r104;
    L130:
        r122 = r110;
        goto L131
    L115:
        r109 = false;
        goto L116
    L105:
        if (r210.f571563b.length() != 0) goto L107;
        boolean r123 = true;
    L108:
        b(r113, r123);
        goto L109
    L107:
        r123 = false;
        goto L108
    L97:
        r116 = -1;
        goto L98
    L94:
        r115 = -1;
        goto L95
    L91:
        r114 = null;
        goto L92
    L15:
        View r124 = this.f498678f;
        if (r124 != null) goto L18;
        r103 = this.S;
        goto L23
    L18:
        ze8.d r125 = this.f498684l;
        if (r125 != null) goto L25;
        r125 = this.f498681i;
        if (r125 != null) goto L25;
        r103 = this.S;
    L25:
        if (this.R > 0) goto L27;
    L87:
        r112 = r100;
        r104 = this.S;
        goto L88
    L27:
        if (this.S <= 0) goto L87;
        TextView r126 = j();
        if (r126 == null) goto L32;
        CharSequence r127 = r126.getHint();
    L33:
        if (r126 == null) goto L35;
        int r128 = r126.getMaxLines();
    L36:
        if (r126 == null) goto L38;
        int r129 = r126.getMaxHeight();
    L39:
        String r130 = r210.f571564c;
        if (r130 == null) goto L43;
        if (r126 == null) goto L43;
        r126.setHint(r130);
    L43:
        g9.c r131 = new g9.c(new g9.b(this.f498674b));
        List r132 = e(r131, r210.f571570i);
        List r133 = d(r131, r210.f571567f, r210.f571569h, r210.f571570i);
        n(r210);
        if (r126 != null) goto L46;
    L50:
        r124.measure(View.MeasureSpec.makeMeasureSpec(this.R, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r134 = RangesKt.coerceAtLeast(r124.getMeasuredHeight(), 1);
        HashMap<String, Boolean> r135 = this.f498692t;
        String r136 = r210.f571562a;
        InputContentMode r137 = r210.f571570i;
        InputContentMode r138 = InputContentMode.SPEAK;
        if (r137 == r138) goto L58;
        if (r126 == null) goto L58;
        if (r126.getVisibility() != 0) goto L58;
        r112 = r100;
        if (r126.getLineCount() <= 2) goto L59;
        boolean r139 = true;
    L60:
        r135.put(r136, Boolean.valueOf(r139));
        HashMap<String, Boolean> r140 = this.f498693u;
        String r141 = r210.f571562a;
        if (r210.f571570i == r138) goto L71;
        if (r126 == null) goto L67;
        if (r126.getLineCount() <= 1) goto L67;
        boolean r142 = true;
    L68:
        if (r142 == false) goto L71;
        boolean r143 = true;
    L72:
        r140.put(r141, Boolean.valueOf(r143));
        n(r125);
        if (r126 == null) goto L78;
        if (r129 < 0) goto L76;
        r126.setMaxHeight(r129);
        goto L78
    L76:
        if (r128 < 0) goto L78;
        r126.setMaxLines(r128);
    L78:
        if (r126 == null) goto L80;
        r126.setHint(r127);
    L80:
        p(r133);
        p(r132);
        if (r124.getWidth() > 0) goto L83;
    L86:
        Integer r144 = Integer.valueOf(r134);
        this.f498691s.put(r210.f571562a, r144);
        r104 = r134;
        goto L88
    L83:
        if (r124.getHeight() <= 0) goto L86;
        r124.measure(View.MeasureSpec.makeMeasureSpec(r124.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r124.getHeight(), 1073741824));
        r124.layout(r124.getLeft(), r124.getTop(), r124.getRight(), r124.getBottom());
    L67:
        r142 = false;
    L71:
        r143 = false;
    L59:
        r139 = false;
    L58:
        r112 = r100;
        goto L59
    L46:
        if (r210.f571563b.length() != 0) goto L48;
        boolean r145 = true;
    L49:
        b(r126, r145);
        goto L50
    L48:
        r145 = false;
        goto L49
    L38:
        r129 = -1;
        goto L39
    L35:
        r128 = -1;
        goto L36
    L32:
        r127 = null;
        goto L33
    L5:
        return this.S;
    }

    public final void update(float r100, ze8.d r101, ze8.d r102) {
        Intrinsics.checkNotNullParameter(r101, "lower");
        if (Intrinsics.areEqual(this.f498682j, r101.f571562a) == true) goto L9;
        if (Intrinsics.areEqual(this.f498683k, r101.f571562a) == false) goto L7;
        jd8.a r103 = this.f498679g;
        this.f498679g = this.f498680h;
        this.f498680h = r103;
        this.f498682j = this.f498683k;
        this.f498683k = null;
        int r104 = this.f498694v;
        this.f498694v = this.f498695w;
        this.f498695w = r104;
        goto L9
    L7:
        this.f498694v = k(h(true, this.S), r101);
        this.f498682j = r101.f571562a;
    L9:
        if (r102 != null) goto L12;
        this.f498683k = null;
    L14:
        jd8.a r105 = this.f498679g;
        if (r105 == null) goto L17;
        r105.setTranslationX(this.N - ((this.T * r100) * this.U));
        r105.setTranslationY(this.O + (this.S - this.f498694v));
        c(r105);
        r105.setVisibility(0);
    L17:
        if (r102 != null) goto L22;
        jd8.a r106 = this.f498680h;
        if (r106 == null) goto L47;
        r106.setVisibility(8);
        return;
    L47:
        return;
    L22:
        jd8.a r107 = this.f498680h;
        if (r107 == null) goto L26;
        r107.setTranslationX(this.N + (((1.0f - r100) * this.T) * this.U));
        r107.setTranslationY(this.O + (this.S - this.f498695w));
        c(r107);
        r107.setVisibility(0);
    L26:
        if (this.f498690r == null) goto L51;
        View r108 = this.f498678f;
        if (r108 == null) goto L52;
        Integer r109 = this.f498691s.get(r101.f571562a);
        if (r109 == null) goto L48;
        int r110 = r109.intValue();
        Integer r111 = this.f498691s.get(r102.f571562a);
        if (r111 == null) goto L49;
        int r112 = r111.intValue();
        int r113 = Math.min(r110, r112);
        ViewGroup.LayoutParams r114 = r108.getLayoutParams();
        if (r114 != null) goto L38;
    L40:
        s r115 = this.I;
        if (r115 == null) goto L43;
        r115.d(r101, r113 - r110);
    L43:
        s r116 = this.I;
        if (r116 == null) goto L50;
        r116.d(r102, r113 - r112);
        return;
    L50:
        return;
    L38:
        if (r114.height == r113) goto L40;
        r114.height = r113;
        r108.setLayoutParams(r114);
        goto L40
    L49:
        return;
    L48:
        return;
    L52:
        return;
    L51:
        return;
    L12:
        if (Intrinsics.areEqual(this.f498683k, r102.f571562a) == true) goto L14;
        this.f498695w = k(h(false, this.S), r102);
        this.f498683k = r102.f571562a;
        goto L14
    }

    public g(ViewGroup r100, View r101, ICoreInputAbility r102, va8.o r103) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "realInputView");
        this.f498673a = r100;
        this.f498674b = r101;
        this.f498675c = r102;
        this.f498676d = r103;
        this.f498691s = new HashMap();
        this.f498692t = new HashMap();
        this.f498693u = new HashMap();
        this.F = -1;
        this.U = 1.0f;
        this.Z = new int[2];
    }

    public static List d(g9.c r100, boolean r101, ze8.c r102, InputContentMode r103) {
        boolean r104 = true;
        boolean r105 = false;
        Pair r106 = null;
        if (r102 == null) goto L26;
        Pair[] r107 = new Pair[4];
        Object r108 = r100.a().f298553a;
        if (r108 == null) goto L7;
        Pair r109 = TuplesKt.to(r108, Integer.valueOf(u(r102.f571558a)));
    L8:
        r107[0] = r109;
        Object r110 = r100.h().f298553a;
        if (r110 == null) goto L11;
        Pair r111 = TuplesKt.to(r110, Integer.valueOf(u(r102.f571560c)));
    L12:
        r107[1] = r111;
        Object r112 = r100.i().f298553a;
        if (r112 != null) goto L15;
        Pair r113 = null;
    L22:
        r107[2] = r113;
        Object r114 = r100.e().f298553a;
        if (r114 == null) goto L25;
        r106 = TuplesKt.to(r114, Integer.valueOf(u(r102.f571561d)));
    L25:
        r107[3] = r106;
        List r115 = CollectionsKt.listOfNotNull(r107);
    L38:
        List r116 = r115;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r118 = r116.iterator();
    L40:
        if (r118.hasNext() == false) goto L42;
        Pair r119 = (Pair) r118.next();
        View r120 = (View) r119.component1();
        int r121 = ((Number) r119.component2()).intValue();
        c r122 = new c(r120, r120.getVisibility());
        r120.setVisibility(r121);
        r117.add(r122);
        goto L40
    L42:
        return r117;
    L15:
        if (r102.f571559b == true) goto L17;
    L19:
        r104 = false;
    L20:
        r113 = TuplesKt.to(r112, Integer.valueOf(u(r104)));
        goto L22
    L17:
        if (r103 == InputContentMode.SPEAK) goto L19;
    L11:
        r111 = null;
        goto L12
    L7:
        r109 = null;
        goto L8
    L26:
        Pair[] r123 = new Pair[2];
        Object r124 = r100.h().f298553a;
        if (r124 == null) goto L29;
        Pair r125 = TuplesKt.to(r124, Integer.valueOf(u(r101)));
    L30:
        r123[0] = r125;
        Object r126 = r100.i().f298553a;
        if (r126 == null) goto L37;
        if (r101 == false) goto L34;
    L36:
        r106 = TuplesKt.to(r126, Integer.valueOf(u(r105)));
        goto L37
    L34:
        if (r103 == InputContentMode.SPEAK) goto L36;
        r105 = true;
    L37:
        r123[1] = r106;
        r115 = CollectionsKt.listOfNotNull(r123);
        goto L38
    L29:
        r125 = null;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.view.View[], java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View, java.lang.Object] */
    public final Bitmap s(View r210, boolean r211, int r212, Boolean r213, Boolean r214, ze8.c r215, InputContentMode r216) {
        g9.c r100 = new g9.c(new g9.b(this.f498674b));
        List r101 = e(r100, r216);
        ?? r102 = r100.h().f298553a;
        ?? r103 = r100.i().f298553a;
        g9.b r104 = r100.f298535a;
        r104.getClass();
        View r105 = r104.f298534a;
        if (r105 == null) goto L5;
        View r106 = r105.findViewById(R.id.action_full_screen);
    L7:
        if (r214 != null) goto L10;
        List r110 = CollectionsKt.emptyList();
    L39:
        List r107 = d(r100, r211, r215, r216);
        if (r102 == 0) goto L42;
        Boolean r108 = Boolean.valueOf(r102.isEnabled());
    L43:
        if (r102 == 0) goto L45;
        Float r111 = Float.valueOf(r102.getAlpha());
    L46:
        if (r103 == 0) goto L48;
        Boolean r112 = Boolean.valueOf(r103.isEnabled());
    L49:
        if (r103 == 0) goto L51;
        Float r113 = Float.valueOf(r103.getAlpha());
    L52:
        if (r106 == null) goto L54;
        Integer r114 = Integer.valueOf(r106.getVisibility());
    L55:
        if (r215 == null) goto L67;
        Float r217 = r113;
        if (r102 == 0) goto L59;
        r102.setEnabled(r215.f571560c);
        r102.setAlpha(1.0f);
    L59:
        if (r103 != 0) goto L61;
    L68:
        if (r213 == null) goto L75;
        if (r106 == null) goto L75;
        if (r213.booleanValue() == false) goto L73;
        int r109 = 0;
    L74:
        r106.setVisibility(r109);
        goto L75
    L73:
        r109 = 8;
    L75:
        int r115 = r210.getLeft();
        int r116 = r210.getTop();
        int r117 = r210.getRight();
        int r118 = r210.getBottom();
        Integer r119 = Integer.valueOf(r212);
        if (r119.intValue() <= 0) goto L78;
        boolean r120 = true;
    L79:
        if (r120 == true) goto L82;
        r119 = null;
    L82:
        if (r119 == null) goto L84;
        int r121 = r119.intValue();
    L85:
        Boolean r218 = r112;
        r210.measure(View.MeasureSpec.makeMeasureSpec(this.R, 1073741824), View.MeasureSpec.makeMeasureSpec(r121, 1073741824));
        r210.layout(r115, r118 - r121, r117, r118);
        TextView r122 = j();
        if (r122 == null) goto L88;
        int r123 = r122.getScrollX();
    L89:
        if (r122 == null) goto L91;
        int r124 = r122.getScrollY();
    L92:
        if (r122 == null) goto L95;
        r122.scrollTo(0, t(r122));
    L95:
        Bitmap r125 = r(r210);
        if (r122 == null) goto L98;
        r122.scrollTo(r123, r124);
    L98:
        p(r101);
        Iterator r126 = r110.iterator();
    L100:
        if (r126.hasNext() == false) goto L108;
        b r127 = (b) r126.next();
        ViewGroup.LayoutParams r128 = r127.f498699a.getLayoutParams();
        if ((r128 instanceof ConstraintLayout.LayoutParams) == false) goto L104;
        ConstraintLayout.LayoutParams r129 = (ConstraintLayout.LayoutParams) r128;
    L105:
        if (r129 == null) goto L100;
        r129.topToTop = r127.f498700b;
        r129.bottomToBottom = r127.f498701c;
        r127.f498699a.setLayoutParams(r129);
        goto L100
    L104:
        r129 = null;
        goto L105
    L108:
        if (r114 == null) goto L112;
        int r130 = r114.intValue();
        if (r106 == null) goto L112;
        r106.setVisibility(r130);
    L112:
        p(r107);
        if (r108 == null) goto L117;
        boolean r131 = r108.booleanValue();
        if (r102 == 0) goto L117;
        r102.setEnabled(r131);
    L117:
        if (r111 == null) goto L121;
        float r132 = r111.floatValue();
        if (r102 == 0) goto L121;
        r102.setAlpha(r132);
    L121:
        if (r218 == null) goto L125;
        boolean r133 = r218.booleanValue();
        if (r103 == 0) goto L125;
        ?? r134 = r103;
        r134.setEnabled(r133);
        ?? r135 = r134;
    L126:
        if (r217 == null) goto L130;
        float r136 = r217.floatValue();
        if (r135 == 0) goto L130;
        r135.setAlpha(r136);
    L130:
        r210.measure(View.MeasureSpec.makeMeasureSpec(this.R, 1073741824), View.MeasureSpec.makeMeasureSpec(r118 - r116, 1073741824));
        r210.layout(r115, r116, r117, r118);
        return r125;
    L125:
        r135 = r103;
        goto L126
    L91:
        r124 = 0;
        goto L92
    L88:
        r123 = 0;
        goto L89
    L84:
        r121 = this.S;
        goto L85
    L78:
        r120 = false;
        goto L79
    L61:
        if (r215.f571559b == true) goto L63;
    L65:
        boolean r137 = false;
    L66:
        r103.setEnabled(r137);
        r103.setAlpha(1.0f);
        goto L68
    L63:
        if (r216 == InputContentMode.SPEAK) goto L65;
        r137 = true;
        goto L66
    L67:
        r217 = r113;
        goto L68
    L54:
        r114 = null;
        goto L55
    L51:
        r113 = null;
        goto L52
    L48:
        r112 = null;
        goto L49
    L45:
        r111 = null;
        goto L46
    L42:
        r108 = null;
        goto L43
    L10:
        View r138 = this.f498674b.findViewById(R.id.input_center_anchor);
        if (r138 != null) goto L13;
        r110 = CollectionsKt.emptyList();
        goto L39
    L13:
        ?? r139 = new View[3];
        r139[0] = j();
        g9.b r140 = r100.f298535a;
        r140.getClass();
        View r141 = r140.f298534a;
        if (r141 == null) goto L16;
        View r142 = r141.findViewById(R.id.action_area);
    L17:
        r139[1] = r142;
        r139[2] = r100.a().f298553a;
        List r143 = CollectionsKt.listOfNotNull(r139);
        ArrayList r144 = new ArrayList();
        Iterator r145 = r143.iterator();
    L19:
        if (r145.hasNext() == false) goto L38;
        View r146 = (View) r145.next();
        ViewGroup.LayoutParams r147 = r146.getLayoutParams();
        if ((r147 instanceof ConstraintLayout.LayoutParams) == false) goto L23;
        ConstraintLayout.LayoutParams r148 = (ConstraintLayout.LayoutParams) r147;
    L24:
        if (r148 != null) goto L26;
        b r149 = null;
    L35:
        if (r149 == null) goto L37;
        r144.add(r149);
    L37:
        r145 = r145;
        goto L19
    L26:
        r149 = new b(r146, r148.topToTop, r148.bottomToBottom);
        if (r214.booleanValue() == false) goto L29;
        int r150 = -1;
    L30:
        r148.topToTop = r150;
        if (r214.booleanValue() == false) goto L33;
        int r151 = 0;
    L34:
        r148.bottomToBottom = r151;
        r146.setLayoutParams(r148);
        goto L35
    L33:
        r151 = r138.getId();
        goto L34
    L29:
        r150 = r138.getId();
        goto L30
    L23:
        r148 = null;
        goto L24
    L38:
        r110 = r144;
        goto L39
    L16:
        r142 = null;
        goto L17
    L5:
        r106 = null;
        goto L7
    }
}
