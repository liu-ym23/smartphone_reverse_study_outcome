package com.bytedance.ee.bear.widgets.wheelview.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import h18.e;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import sp5.b;
import sp5.c;

/* JADX INFO: loaded from: classes18.dex */
public class WheelView extends View {
    public static final /* synthetic */ int H0 = 0;
    public int A;
    public int B;
    public float C;
    public boolean D;
    public float E;
    public float F;
    public float G;
    public float H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f240425J;
    public int K;
    public final int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public long R;
    public int S;
    public int T;
    public int U;
    public int V;
    public final float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f240426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DividerType f240427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f240428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f240429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f240430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GestureDetector f240431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public rp5.b f240432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f240433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ScheduledExecutorService f240434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ScheduledFuture<?> f240435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f240436k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final float f240437k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f240438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f240439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public pp5.a f240440n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f240441o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f240442p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public float f240443p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f240444q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f240445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f240446s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f240447t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f240448u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f240449v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f240450w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f240451x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f240452y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f240453z;

    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ACTION[] f240454a = null;

        static {
            ACTION r100 = new ACTION("CLICK", 0);
            CLICK = r100;
            ACTION r101 = new ACTION("FLING", 1);
            FLING = r101;
            ACTION r102 = new ACTION("DAGGLE", 2);
            DAGGLE = r102;
            f240454a = new ACTION[]{r100, r101, r102};
        }

        public static ACTION[] values() {
            return (ACTION[]) f240454a.clone();
        }

        public static ACTION valueOf(String r100) {
            return (ACTION) r27.a.a(ACTION.class, r100);
        }

        public ACTION(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum DividerType extends Enum<DividerType> {
        public static final DividerType FILL = null;
        public static final DividerType WRAP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DividerType[] f240455a = null;

        static {
            DividerType r100 = new DividerType("FILL", 0);
            FILL = r100;
            DividerType r101 = new DividerType("WRAP", 1);
            WRAP = r101;
            f240455a = new DividerType[]{r100, r101};
        }

        public static DividerType[] values() {
            return (DividerType[]) f240455a.clone();
        }

        public static DividerType valueOf(String r100) {
            return (DividerType) r27.a.a(DividerType.class, r100);
        }

        public DividerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public void setOnItemScrollListener(a r100) {
    }

    public final void a() {
        ScheduledFuture<?> r100 = this.f240435j;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCancelled() == true) goto L9;
        this.f240435j.cancel(true);
        this.f240435j = null;
        return;
    }

    public final void e() {
        if (this.f240440n != null) goto L5;
        return;
    L5:
        Rect r100 = new Rect();
        Paint r101 = this.f240438l;
        String r102 = this.f240451x;
        r101.getTextBounds(r102, 0, r102.length(), r100);
        this.f240447t = r100.width();
        this.f240438l.getTextBounds("星期", 0, 2, r100);
        int r103 = r100.height() + 2;
        this.f240448u = r103;
        float r104 = this.C * r103;
        this.f240450w = r104;
        int r105 = (int) (r104 * (this.L - 1));
        this.M = (int) (((double) (r105 * 2)) / 3.141592653589793d);
        this.O = (int) (((double) r105) / 3.141592653589793d);
        this.N = View.MeasureSpec.getSize(this.S);
        int r106 = this.M;
        float r107 = this.f240450w;
        this.E = (r106 - r107) / 2.0f;
        float r108 = (r106 + r107) / 2.0f;
        this.F = r108;
        this.G = (r108 - ((r107 - this.f240448u) / 2.0f)) - this.W;
        if (this.I == (-1)) goto L8;
    L11:
        this.K = this.I;
        return;
    L8:
        if (this.D == false) goto L10;
        this.I = (((sl5.a) this.f240440n).b() + 1) / 2;
        goto L11
    L10:
        this.I = 0;
        goto L11
    }

    public final int getCurrentItem() {
        pp5.a r100 = this.f240440n;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (this.D == false) goto L14;
        int r101 = this.f240425J;
        if (r101 < 0) goto L12;
        if (r101 < ((sl5.a) r100).b()) goto L14;
    L12:
        return Math.max(0, Math.min(Math.abs(Math.abs(this.f240425J) - ((sl5.a) this.f240440n).b()), ((sl5.a) this.f240440n).b() - 1));
    L14:
        return Math.max(0, Math.min(this.f240425J, ((sl5.a) this.f240440n).b() - 1));
    }

    public final Object getCurrentObject() {
        if (this.f240440n != null) goto L6;
        return null;
    L6:
        int r100 = getCurrentItem();
        return ((sl5.a) this.f240440n).a(r100);
    }

    public int getItemsCount() {
        pp5.a r100 = this.f240440n;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return ((sl5.a) r100).b();
    }

    public final pp5.a getAdapter() {
        return this.f240440n;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f240430e;
    }

    public int getInitPosition() {
        return this.I;
    }

    public float getItemHeight() {
        return this.f240450w;
    }

    public float getResistance() {
        return this.f240443p0;
    }

    public float getTotalScrollY() {
        return this.H;
    }

    public WheelView(Context r100) {
        this(r100, null);
    }

    public static String b(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof qp5.a) == false) goto L10;
        return ((qp5.a) r100).a();
    L10:
        if ((r100 instanceof Integer) == false) goto L14;
        return String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(((Integer) r100).intValue())});
    L14:
        return r100.toString();
    }

    public final int c(int r100) {
        if (r100 >= 0) goto L5;
        return c(r100 + ((sl5.a) this.f240440n).b());
    L5:
        if (r100 > (((sl5.a) this.f240440n).b() - 1)) goto L7;
        return r100;
    L7:
        return c(r100 - ((sl5.a) this.f240440n).b());
    }

    public final void d(String r100) {
        Rect r101 = new Rect();
        this.f240438l.getTextBounds(r100, 0, r100.length(), r101);
        int r102 = this.T;
        if (r102 != 3) goto L5;
        this.U = 0;
        return;
    L5:
        if (r102 != 5) goto L7;
        this.U = (this.N - r101.width()) - ((int) this.W);
        return;
    L7:
        if (r102 != 17) goto L15;
        this.U = (int) ((this.N - r101.width()) * 0.5f);
        return;
    }

    public final void f(ACTION r100) {
        a();
        if (r100 != ACTION.FLING) goto L5;
    L6:
        float r101 = this.H;
        float r102 = this.f240450w;
        int r103 = (int) (((r101 % r102) + r102) % r102);
        this.P = r103;
        if (r103 <= (r102 / 2.0f)) goto L9;
        this.P = (int) (r102 - r103);
    L10:
        this.f240435j = this.f240434i.scheduleWithFixedDelay(new c(this, this.P), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        this.P = -r103;
        goto L10
    L5:
        if (r100 != ACTION.DAGGLE) goto L10;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        if (this.f240440n != null) goto L5;
        return;
    L5:
        int r100 = 0;
        int r101 = Math.min(Math.max(0, this.I), ((sl5.a) this.f240440n).b() - 1);
        this.I = r101;
        Object[] r110 = new Object[this.L];
        this.K = r101 + (((int) (this.H / this.f240450w)) % ((sl5.a) this.f240440n).b());     // Catch: ArithmeticException -> L8
    L11:
        if (this.D == true) goto L19;
        if (this.K >= 0) goto L16;
        this.K = 0;
    L16:
        if (this.K <= (((sl5.a) this.f240440n).b() - 1)) goto L24;
        this.K = ((sl5.a) this.f240440n).b() - 1;
    L24:
        float r102 = this.H % this.f240450w;
        int r103 = 0;
    L25:
        int r104 = this.L;
        String r111 = "";
        if (r103 >= r104) goto L38;
        int r105 = this.K - ((r104 / 2) - r103);
        if (this.D == false) goto L30;
        r110[r103] = ((sl5.a) this.f240440n).a(c(r105));
    L36:
        r103 = r103 + 1;
        goto L25
    L30:
        if (r105 >= 0) goto L33;
        r110[r103] = "";
        goto L36
    L33:
        if (r105 <= (((sl5.a) this.f240440n).b() - 1)) goto L35;
        r110[r103] = "";
        goto L36
    L35:
        r110[r103] = ((sl5.a) this.f240440n).a(r105);
        goto L36
    L38:
        if (this.f240427b == DividerType.WRAP) goto L40;
        float r106 = this.E;
        r210.drawLine(0.0f, r106, this.N, r106, this.f240439m);
        if (this.f240428c == false) goto L54;
        float r107 = this.F;
        r210.drawLine(0.0f, r107, this.N, r107, this.f240439m);
    L54:
        if (TextUtils.isEmpty(this.f240442p) == false) goto L56;
    L66:
        int r108 = 0;
    L68:
        if (r108 >= this.L) goto L135;
        r210.save();
        double r109 = ((this.f240450w * r108) - r102) / this.O;
        float r112 = (float) (90.0d - ((r109 / 3.141592653589793d) * 180.0d));
        if (r112 < 90.0f) goto L72;
    L133:
        String r113 = r111;
        r210.restore();
    L134:
        r108 = r108 + 1;
        r111 = r113;
        r110 = r110;
        r100 = 0;
        goto L68
    L72:
        if (r112 <= (-90.0f)) goto L133;
        float r114 = (float) Math.pow(Math.abs(r112) / 90.0f, 2.2d);
        if (TextUtils.isEmpty(this.f240442p) == false) goto L77;
    L83:
        StringBuilder r115 = new StringBuilder();
        r115.append(b(r110[r108]));
        if (TextUtils.isEmpty(this.f240441o) == false) goto L86;
        String r116 = r111;
    L87:
        r115.append(r116);
        String r117 = r115.toString();
    L88:
        Rect r118 = new Rect();
        this.f240438l.getTextBounds(r117, r100, r117.length(), r118);
        int r119 = r118.width();
        int r120 = this.f240444q;
        int r121 = this.f240446s;
    L89:
        int r122 = -1;
        if (r119 <= this.N) goto L92;
        r120 = r120 - 1;
        r121 = r121 - 1;
        this.f240438l.setTextSize(r120);
        this.f240438l.getTextBounds(r117, 0, r117.length(), r118);
        r119 = r118.width();
        r111 = r111;
        goto L89
    L92:
        r113 = r111;
        this.f240436k.setTextSize(r121);
        d(r117);
        Rect r123 = new Rect();
        this.f240436k.getTextBounds(r117, 0, r117.length(), r123);
        int r124 = this.T;
        if (r124 != 3) goto L95;
        this.V = 0;
    L103:
        if (TextUtils.isEmpty(this.f240442p) == false) goto L105;
    L111:
        float r125 = (float) ((((double) this.O) - (Math.cos(r109) * ((double) this.O))) - ((Math.sin(r109) * ((double) this.f240448u)) / 2.0d));
        r210.translate(0.0f, r125);
        float r126 = this.E;
        if (r125 <= r126) goto L114;
    L116:
        float r127 = this.F;
        if (r125 > r127) goto L122;
        if ((this.f240448u + r125) < r127) goto L122;
        r210.save();
        r210.clipRect(0.0f, 0.0f, this.N, this.F - r125);
        r210.scale(1.0f, ((float) Math.sin(r109)) * 1.0f);
        r210.drawText(r117, this.U, this.f240448u - this.W, this.f240438l);
        r210.restore();
        r210.save();
        r210.clipRect(0.0f, this.F - r125, this.N, (int) this.f240450w);
        r210.scale(1.0f, ((float) Math.sin(r109)) * this.f240437k0);
        r210.drawText(r117, this.V, this.f240448u, this.f240436k);
        r210.restore();
    L132:
        r210.restore();
        this.f240438l.setTextSize(this.f240444q);
    L122:
        if (r125 < r126) goto L127;
        float r128 = this.f240448u;
        if ((r125 + r128) > r127) goto L127;
        r210.drawText(r117, this.U, r128 - this.W, this.f240438l);
        this.f240425J = this.K - ((this.L / 2) - r108);
    L127:
        r210.save();
        r210.clipRect(0, 0, this.N, (int) this.f240450w);
        r210.scale(1.0f, ((float) Math.sin(r109)) * this.f240437k0);
        Paint r129 = this.f240436k;
        int r130 = Integer.compare(this.f240449v, 0);
        if (r112 > 0.0f) goto L131;
        r122 = 1;
    L131:
        r129.setTextSkewX(((r130 * r122) * 0.5f) * r114);
        this.f240436k.setAlpha((int) ((1.0f - r114) * 255.0f));
        r210.drawText(r117, this.V + (this.f240449v * r114), this.f240448u, this.f240436k);
        r210.restore();
        goto L132
    L114:
        if ((this.f240448u + r125) < r126) goto L116;
        r210.save();
        r210.clipRect(0.0f, 0.0f, this.N, this.E - r125);
        r210.scale(1.0f, ((float) Math.sin(r109)) * this.f240437k0);
        r210.drawText(r117, this.V, this.f240448u, this.f240436k);
        r210.restore();
        r210.save();
        r210.clipRect(0.0f, this.E - r125, this.N, (int) this.f240450w);
        r210.scale(1.0f, ((float) Math.sin(r109)) * 1.0f);
        r210.drawText(r117, this.U, this.f240448u - this.W, this.f240438l);
        r210.restore();
        goto L132
    L105:
        if (this.f240433h == false) goto L111;
        StringBuilder r131 = new StringBuilder();
        r131.append(b(r110[r108]));
        if (TextUtils.isEmpty(this.f240441o) == false) goto L109;
        String r132 = r113;
    L110:
        r131.append(r132);
        r117 = r131.toString();
        goto L111
    L109:
        r132 = this.f240441o;
        goto L110
    L95:
        if (r124 != 5) goto L97;
        this.V = (this.N - r123.width()) - ((int) this.W);
        goto L103
    L97:
        if (r124 != 17) goto L103;
        this.V = (int) ((this.N - r123.width()) * 0.5f);
        goto L103
    L86:
        r116 = this.f240441o;
        goto L87
    L77:
        if (TextUtils.isEmpty(b(r110[r108])) == true) goto L83;
        StringBuilder r133 = new StringBuilder();
        r133.append(b(r110[r108]));
        if (TextUtils.isEmpty(this.f240441o) == false) goto L81;
        String r134 = r111;
    L82:
        r133.append(r134);
        r133.append(this.f240442p);
        r117 = r133.toString();
        goto L88
    L81:
        r134 = this.f240441o;
        goto L82
    L135:
        return;
    L56:
        if (this.f240433h == false) goto L66;
        d(this.f240451x);
        int r135 = this.U + this.f240447t;
        Paint r136 = this.f240438l;
        int r137 = this.f240445r;
        if (r137 != 0) goto L61;
        r137 = this.f240444q;
    L61:
        r136.setTextSize(r137);
        Paint r138 = this.f240438l;
        int r139 = this.A;
        if (r139 != 0) goto L65;
        r139 = this.f240453z;
    L65:
        r138.setColor(r139);
        r210.drawText(this.f240442p, r135 - this.W, this.G, this.f240438l);
        this.f240438l.setTextSize(this.f240444q);
        this.f240438l.setColor(this.f240453z);
        goto L66
    L40:
        if (TextUtils.isEmpty(this.f240442p) == false) goto L42;
        int r140 = (this.N - this.f240447t) / 2;
    L43:
        float r141 = r140 - 12;
        if (r141 > 0.0f) goto L46;
        float r142 = 10.0f;
    L47:
        float r143 = this.N - r142;
        float r144 = this.E;
        r210.drawLine(r142, r144, r143, r144, this.f240439m);
        if (this.f240428c == false) goto L54;
        float r145 = this.F;
        r210.drawLine(r142, r145, r143, r145, this.f240439m);
        goto L54
    L46:
        r142 = r141;
        goto L47
    L42:
        r140 = (this.N - this.f240447t) / 4;
        goto L43
    L19:
        if (this.K >= 0) goto L22;
        this.K = ((sl5.a) this.f240440n).b() + this.K;
    L22:
        if (this.K <= (((sl5.a) this.f240440n).b() - 1)) goto L24;
        this.K -= ((sl5.a) this.f240440n).b();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (this.f240426a == false) goto L34;
        boolean r100 = this.f240431f.onTouchEvent(r110);
        float r101 = (-this.I) * this.f240450w;
        float r102 = ((((sl5.a) this.f240440n).b() - 1) - this.I) * this.f240450w;
        int r103 = r110.getAction();
        boolean r104 = false;
        if (r103 != 0) goto L7;
        this.R = System.currentTimeMillis();
        a();
        this.Q = r110.getRawY();
    L30:
        if (r104 == true) goto L34;
        if (r110.getAction() == 0) goto L34;
        invalidate();
        goto L34
    L7:
        if (r103 == 1) goto L23;
        if (r103 != 2) goto L10;
        getParent().requestDisallowInterceptTouchEvent(true);
        float r105 = this.Q - r110.getRawY();
        this.Q = r110.getRawY();
        float r106 = this.H + r105;
        this.H = r106;
        if (this.D == true) goto L30;
        float r107 = this.f240450w * 0.25f;
        if ((r106 - r107) >= r101) goto L19;
        if (r105 >= 0.0f) goto L19;
    L22:
        this.H = r106 - r105;
        r104 = true;
    L19:
        if ((r107 + r106) <= r102) goto L30;
        if (r105 <= 0.0f) goto L30;
    L10:
        if (r103 == 3) goto L23;
    L24:
        if (r100 == true) goto L30;
        float r108 = r110.getY();
        float r109 = this.O;
        double r111 = Math.acos((r109 - r108) / r109) * ((double) this.O);
        float r112 = this.f240450w;
        this.P = (int) (((((int) ((r111 + ((double) (r112 / 2.0f))) / ((double) r112))) - (this.L / 2)) * r112) - (((this.H % r112) + r112) % r112));
        if ((System.currentTimeMillis() - this.R) <= 120) goto L28;
        f(ACTION.DAGGLE);
        goto L30
    L28:
        f(ACTION.CLICK);
    L23:
        getParent().requestDisallowInterceptTouchEvent(false);
    L34:
        return true;
    }

    public final void setAdapter(pp5.a r100) {
        this.f240440n = r100;
        e();
        requestLayout();
    }

    public final void setCurrentItem(int r100) {
        this.f240425J = r100;
        this.I = r100;
        this.H = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r100) {
        this.D = r100;
    }

    public void setDefaultContent(String r100) {
        this.f240441o = r100;
    }

    public void setDividerColor(int r100) {
        this.B = r100;
        this.f240439m.setColor(r100);
    }

    public void setDividerType(DividerType r100) {
        this.f240427b = r100;
    }

    public void setGravity(int r100) {
        this.T = r100;
    }

    public void setLabel(String r100) {
        this.f240442p = r100;
    }

    public void setLineSpacingMultiplier(float r100) {
        if (r100 == 0.0f) goto L11;
        this.C = r100;
        if (r100 >= 1.0f) goto L8;
        this.C = 1.0f;
        return;
    L8:
        if (r100 <= 4.0f) goto L13;
        this.C = 4.0f;
        return;
    L13:
        return;
    }

    public final void setMaxWidthText(String r100) {
        this.f240451x = r100;
    }

    public final void setOnItemSelectedListener(rp5.b r100) {
        this.f240432g = r100;
    }

    public void setResistance(float r100) {
        this.f240443p0 = r100;
    }

    public void setScroll(boolean r100) {
        this.f240426a = r100;
    }

    public void setTextColorCenter(int r100) {
        this.f240453z = r100;
        this.f240438l.setColor(r100);
    }

    public void setTextColorLabel(int r100) {
        this.A = r100;
    }

    public void setTextColorOut(int r100) {
        this.f240452y = r100;
        this.f240436k.setColor(r100);
    }

    public final void setTextSizeCenter(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = this.f240429d.getResources();
        int r102 = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        this.f240444q = r102;
        this.f240438l.setTextSize(r102);
        return;
    }

    public final void setTextSizeLabel(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = this.f240429d.getResources();
        this.f240445r = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        return;
    }

    public final void setTextSizeOut(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = this.f240429d.getResources();
        int r102 = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        this.f240446s = r102;
        this.f240436k.setTextSize(r102);
        return;
    }

    public void setTextXOffset(int r100) {
        this.f240449v = r100;
        if (r100 == 0) goto L6;
        this.f240438l.setTextScaleX(1.0f);
        return;
    }

    public void setTotalScrollY(float r100) {
        this.H = r100;
    }

    public final void setTypeface(Typeface r100) {
        int r101 = e.f483540a;
        Typeface r102 = e.b(this.f240429d, r100.getStyle());
        this.f240436k.setTypeface(r102);
        this.f240438l.setTypeface(r102);
    }

    public WheelView(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.f240426a = true;
        this.f240428c = true;
        this.f240433h = true;
        this.f240434i = BearExecutors.e();
        this.f240451x = "";
        Typeface r100 = Typeface.MONOSPACE;
        this.C = 1.6f;
        this.L = 11;
        this.P = 0;
        this.Q = 0.0f;
        this.R = 0;
        this.T = 17;
        this.U = 0;
        this.V = 0;
        this.f240437k0 = 0.8f;
        this.f240443p0 = 20.0f;
        int r101 = getResources().getDimensionPixelSize(R.dimen.widget_wheelview_textsize);
        Resources r102 = getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        if (r103 >= 1.0f) goto L6;
        this.W = 2.4f;
    L22:
        if (r111 == null) goto L24;
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.wheelCyclic, R.attr.wheelEntries, R.attr.wheelHighlightColor, R.attr.wheelHighlightConorRadius, R.attr.wheelItemCount, R.attr.wheelItemHeight, R.attr.wheelItemWidth, R.attr.wheelSelectedTextColor, R.attr.wheelSelectedTextSize, R.attr.wheelShowDivider, R.attr.wheelStartIndex, R.attr.wheelTextColor, R.attr.wheelTextSize, R.attr.wheelView_cyclic, R.attr.wheelView_dividerColor, R.attr.wheelView_gravity, R.attr.wheelView_lineSpacingMultiplier, R.attr.wheelView_resistance, R.attr.wheelView_textColorCenter, R.attr.wheelView_textColorOut, R.attr.wheelView_textScaleOut, R.attr.wheelView_textSizeCenter, R.attr.wheelView_textSizeOut}, 0, 0);
        this.T = r112.getInt(15, 17);
        this.f240452y = r112.getColor(19, r110.getResources().getColor(R.color.text_placeholder));
        this.f240453z = r112.getColor(18, r110.getResources().getColor(R.color.text_title));
        this.B = r112.getColor(14, r110.getResources().getColor(R.color.line_divider_default));
        this.f240444q = r112.getDimensionPixelOffset(21, r101);
        this.f240446s = r112.getDimensionPixelOffset(22, r101);
        this.f240437k0 = r112.getFloat(20, 0.8f);
        this.C = r112.getFloat(16, this.C);
        this.D = r112.getBoolean(13, true);
        this.f240443p0 = r112.getFloat(17, this.f240443p0);
        r112.recycle();
    L24:
        float r113 = this.C;
        if (r113 >= 1.0f) goto L28;
        this.C = 1.0f;
    L30:
        this.f240429d = r110;
        this.f240430e = new b(this);
        GestureDetector r114 = new GestureDetector(r110, new rp5.a(this));
        this.f240431f = r114;
        r114.setIsLongpressEnabled(false);
        this.H = 0.0f;
        this.I = -1;
        Paint r115 = new Paint();
        this.f240436k = r115;
        r115.setColor(this.f240452y);
        this.f240436k.setAntiAlias(true);
        this.f240436k.setTextSize(this.f240446s);
        Paint r116 = new Paint();
        this.f240438l = r116;
        r116.setColor(this.f240453z);
        this.f240438l.setAntiAlias(true);
        this.f240438l.setTextScaleX(1.1f);
        this.f240438l.setTextSize(this.f240444q);
        Paint r117 = new Paint();
        this.f240439m = r117;
        r117.setColor(this.B);
        this.f240439m.setAntiAlias(true);
        setLayerType(1, null);
        return;
    L28:
        if (r113 <= 4.0f) goto L30;
        this.C = 4.0f;
        goto L30
    L6:
        if (1.0f <= r103) goto L8;
    L10:
        if (1.0f > r103) goto L15;
        if (r103 >= 2.0f) goto L15;
        this.W = 4.5f;
    L15:
        if (2.0f > r103) goto L20;
        if (r103 >= 3.0f) goto L20;
        this.W = 6.0f;
    L20:
        if (r103 < 3.0f) goto L22;
        this.W = r103 * 2.5f;
        goto L22
    L8:
        if (r103 >= 2.0f) goto L10;
        this.W = 3.6f;
        goto L22
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 != Integer.MIN_VALUE) goto L5;
        r103 = (int) this.f240438l.measureText(this.f240451x);
        r102 = 1073741824;
    L5:
        this.S = View.MeasureSpec.makeMeasureSpec(r103, r102);
        e();
        setMeasuredDimension(this.N, this.M);
    }
}
