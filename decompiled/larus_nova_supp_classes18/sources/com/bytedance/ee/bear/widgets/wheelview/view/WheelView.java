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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import h18.e;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import sp5.b;
import sp5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public int J;
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
    public boolean a;
    public DividerType b;
    public final boolean c;
    public Context d;
    public b e;
    public GestureDetector f;
    public rp5.b g;
    public final boolean h;
    public final ScheduledExecutorService i;
    public ScheduledFuture<?> j;
    public Paint k;
    public final float k0;
    public Paint l;
    public Paint m;
    public pp5.a n;
    public String o;
    public String p;
    public float p0;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public String x;
    public int y;
    public int z;

    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;
        public static final /* synthetic */ ACTION[] a = null;

        static {
            ACTION r0 = new ACTION("CLICK", 0);
            CLICK = r0;
            ACTION r1 = new ACTION("FLING", 1);
            FLING = r1;
            ACTION r3 = new ACTION("DAGGLE", 2);
            DAGGLE = r3;
            a = new ACTION[]{r0, r1, r3};
        }

        public static ACTION[] values() {
            return (ACTION[]) a.clone();
        }

        public static ACTION valueOf(String r1) {
            return (ACTION) r27.a.a(ACTION.class, r1);
        }

        public ACTION(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum DividerType extends Enum<DividerType> {
        public static final DividerType FILL = null;
        public static final DividerType WRAP = null;
        public static final /* synthetic */ DividerType[] a = null;

        static {
            DividerType r0 = new DividerType("FILL", 0);
            FILL = r0;
            DividerType r1 = new DividerType("WRAP", 1);
            WRAP = r1;
            a = new DividerType[]{r0, r1};
        }

        public static DividerType[] values() {
            return (DividerType[]) a.clone();
        }

        public static DividerType valueOf(String r1) {
            return (DividerType) r27.a.a(DividerType.class, r1);
        }

        public DividerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
    }

    public void setOnItemScrollListener(a r1) {
    }

    public final void a() {
        ScheduledFuture<?> r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isCancelled() == true) goto L9;
        this.j.cancel(true);
        this.j = null;
        return;
    }

    public final void e() {
        if (this.n != null) goto L5;
        return;
    L5:
        Rect r0 = new Rect();
        Paint r1 = this.l;
        String r2 = this.x;
        r1.getTextBounds(r2, 0, r2.length(), r0);
        this.t = r0.width();
        this.l.getTextBounds("星期", 0, 2, r0);
        int r3 = r0.height() + 2;
        this.u = r3;
        float r4 = this.C * r3;
        this.w = r4;
        int r5 = (int) (r4 * (this.L - 1));
        this.M = (int) (((double) (r5 * 2)) / 3.141592653589793d);
        this.O = (int) (((double) r5) / 3.141592653589793d);
        this.N = View.MeasureSpec.getSize(this.S);
        int r6 = this.M;
        float r7 = this.w;
        this.E = (r6 - r7) / 2.0f;
        float r8 = (r6 + r7) / 2.0f;
        this.F = r8;
        this.G = (r8 - ((r7 - this.u) / 2.0f)) - this.W;
        if (this.I == (-1)) goto L8;
    L11:
        this.K = this.I;
        return;
    L8:
        if (this.D == false) goto L10;
        this.I = (((sl5.a) this.n).b() + 1) / 2;
        goto L11
    L10:
        this.I = 0;
        goto L11
    }

    public final int getCurrentItem() {
        pp5.a r0 = this.n;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (this.D == false) goto L14;
        int r2 = this.J;
        if (r2 < 0) goto L12;
        if (r2 < ((sl5.a) r0).b()) goto L14;
    L12:
        return Math.max(0, Math.min(Math.abs(Math.abs(this.J) - ((sl5.a) this.n).b()), ((sl5.a) this.n).b() - 1));
    L14:
        return Math.max(0, Math.min(this.J, ((sl5.a) this.n).b() - 1));
    }

    public final Object getCurrentObject() {
        if (this.n != null) goto L6;
        return null;
    L6:
        int r0 = getCurrentItem();
        return ((sl5.a) this.n).a(r0);
    }

    public int getItemsCount() {
        pp5.a r0 = this.n;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return ((sl5.a) r0).b();
    }

    public final pp5.a getAdapter() {
        return this.n;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.e;
    }

    public int getInitPosition() {
        return this.I;
    }

    public float getItemHeight() {
        return this.w;
    }

    public float getResistance() {
        return this.p0;
    }

    public float getTotalScrollY() {
        return this.H;
    }

    public WheelView(Context r2) {
        this(r2, null);
    }

    public static String b(Object r3) {
        if (r3 != null) goto L6;
        return "";
    L6:
        if ((r3 instanceof qp5.a) == false) goto L10;
        return ((qp5.a) r3).a();
    L10:
        if ((r3 instanceof Integer) == false) goto L14;
        return String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(((Integer) r3).intValue())});
    L14:
        return r3.toString();
    }

    public final int c(int r2) {
        if (r2 >= 0) goto L5;
        return c(r2 + ((sl5.a) this.n).b());
    L5:
        if (r2 > (((sl5.a) this.n).b() - 1)) goto L7;
        return r2;
    L7:
        return c(r2 - ((sl5.a) this.n).b());
    }

    public final void d(String r5) {
        Rect r0 = new Rect();
        this.l.getTextBounds(r5, 0, r5.length(), r0);
        int r6 = this.T;
        if (r6 != 3) goto L5;
        this.U = 0;
        return;
    L5:
        if (r6 != 5) goto L7;
        this.U = (this.N - r0.width()) - ((int) this.W);
        return;
    L7:
        if (r6 != 17) goto L15;
        this.U = (int) ((this.N - r0.width()) * 0.5f);
        return;
    }

    public final void f(ACTION r8) {
        a();
        if (r8 != ACTION.FLING) goto L5;
    L6:
        float r9 = this.H;
        float r0 = this.w;
        int r10 = (int) (((r9 % r0) + r0) % r0);
        this.P = r10;
        if (r10 <= (r0 / 2.0f)) goto L9;
        this.P = (int) (r0 - r10);
    L10:
        this.j = this.i.scheduleWithFixedDelay(new c(this, this.P), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        this.P = -r10;
        goto L10
    L5:
        if (r8 != ACTION.DAGGLE) goto L10;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r20) {
        if (this.n != null) goto L5;
        return;
    L5:
        int r9 = 0;
        int r0 = Math.min(Math.max(0, this.I), ((sl5.a) this.n).b() - 1);
        this.I = r0;
        Object[] r11 = new Object[this.L];
        this.K = r0 + (((int) (this.H / this.w)) % ((sl5.a) this.n).b());     // Catch: ArithmeticException -> L8
    L11:
        if (this.D == true) goto L19;
        if (this.K >= 0) goto L16;
        this.K = 0;
    L16:
        if (this.K <= (((sl5.a) this.n).b() - 1)) goto L24;
        this.K = ((sl5.a) this.n).b() - 1;
    L24:
        float r1 = this.H % this.w;
        int r2 = 0;
    L25:
        int r3 = this.L;
        String r12 = "";
        if (r2 >= r3) goto L38;
        int r4 = this.K - ((r3 / 2) - r2);
        if (this.D == false) goto L30;
        r11[r2] = ((sl5.a) this.n).a(c(r4));
    L36:
        r2 = r2 + 1;
        goto L25
    L30:
        if (r4 >= 0) goto L33;
        r11[r2] = "";
        goto L36
    L33:
        if (r4 <= (((sl5.a) this.n).b() - 1)) goto L35;
        r11[r2] = "";
        goto L36
    L35:
        r11[r2] = ((sl5.a) this.n).a(r4);
        goto L36
    L38:
        if (this.b == DividerType.WRAP) goto L40;
        float r6 = this.E;
        r20.drawLine(0.0f, r6, this.N, r6, this.m);
        if (this.c == false) goto L54;
        float r7 = this.F;
        r20.drawLine(0.0f, r7, this.N, r7, this.m);
    L54:
        if (TextUtils.isEmpty(this.p) == false) goto L56;
    L66:
        int r5 = 0;
    L68:
        if (r5 >= this.L) goto L135;
        r20.save();
        double r8 = ((this.w * r5) - r1) / this.O;
        float r10 = (float) (90.0d - ((r8 / 3.141592653589793d) * 180.0d));
        if (r10 < 90.0f) goto L72;
    L133:
        String r17 = r12;
        r20.restore();
    L134:
        r5 = r5 + 1;
        r12 = r17;
        r11 = r11;
        r9 = 0;
        goto L68
    L72:
        if (r10 <= (-90.0f)) goto L133;
        float r13 = (float) Math.pow(Math.abs(r10) / 90.0f, 2.2d);
        if (TextUtils.isEmpty(this.p) == false) goto L77;
    L83:
        StringBuilder r14 = new StringBuilder();
        r14.append(b(r11[r5]));
        if (TextUtils.isEmpty(this.o) == false) goto L86;
        String r15 = r12;
    L87:
        r14.append(r15);
        String r16 = r14.toString();
    L88:
        Rect r18 = new Rect();
        this.l.getTextBounds(r16, r9, r16.length(), r18);
        int r19 = r18.width();
        int r110 = this.q;
        int r111 = this.s;
    L89:
        int r112 = -1;
        if (r19 <= this.N) goto L92;
        r110 = r110 - 1;
        r111 = r111 - 1;
        this.l.setTextSize(r110);
        this.l.getTextBounds(r16, 0, r16.length(), r18);
        r19 = r18.width();
        r12 = r12;
        goto L89
    L92:
        r17 = r12;
        this.k.setTextSize(r111);
        d(r16);
        Rect r21 = new Rect();
        this.k.getTextBounds(r16, 0, r16.length(), r21);
        int r113 = this.T;
        if (r113 != 3) goto L95;
        this.V = 0;
    L103:
        if (TextUtils.isEmpty(this.p) == false) goto L105;
    L111:
        float r22 = (float) ((((double) this.O) - (Math.cos(r8) * ((double) this.O))) - ((Math.sin(r8) * ((double) this.u)) / 2.0d));
        r20.translate(0.0f, r22);
        float r114 = this.E;
        if (r22 <= r114) goto L114;
    L116:
        float r115 = this.F;
        if (r22 > r115) goto L122;
        if ((this.u + r22) < r115) goto L122;
        r20.save();
        r20.clipRect(0.0f, 0.0f, this.N, this.F - r22);
        r20.scale(1.0f, ((float) Math.sin(r8)) * 1.0f);
        r20.drawText(r16, this.U, this.u - this.W, this.l);
        r20.restore();
        r20.save();
        r20.clipRect(0.0f, this.F - r22, this.N, (int) this.w);
        r20.scale(1.0f, ((float) Math.sin(r8)) * this.k0);
        r20.drawText(r16, this.V, this.u, this.k);
        r20.restore();
    L132:
        r20.restore();
        this.l.setTextSize(this.q);
    L122:
        if (r22 < r114) goto L127;
        float r116 = this.u;
        if ((r22 + r116) > r115) goto L127;
        r20.drawText(r16, this.U, r116 - this.W, this.l);
        this.J = this.K - ((this.L / 2) - r5);
    L127:
        r20.save();
        r20.clipRect(0, 0, this.N, (int) this.w);
        r20.scale(1.0f, ((float) Math.sin(r8)) * this.k0);
        Paint r23 = this.k;
        int r24 = Integer.compare(this.v, 0);
        if (r10 > 0.0f) goto L131;
        r112 = 1;
    L131:
        r23.setTextSkewX(((r24 * r112) * 0.5f) * r13);
        this.k.setAlpha((int) ((1.0f - r13) * 255.0f));
        r20.drawText(r16, this.V + (this.v * r13), this.u, this.k);
        r20.restore();
        goto L132
    L114:
        if ((this.u + r22) < r114) goto L116;
        r20.save();
        r20.clipRect(0.0f, 0.0f, this.N, this.E - r22);
        r20.scale(1.0f, ((float) Math.sin(r8)) * this.k0);
        r20.drawText(r16, this.V, this.u, this.k);
        r20.restore();
        r20.save();
        r20.clipRect(0.0f, this.E - r22, this.N, (int) this.w);
        r20.scale(1.0f, ((float) Math.sin(r8)) * 1.0f);
        r20.drawText(r16, this.U, this.u - this.W, this.l);
        r20.restore();
        goto L132
    L105:
        if (this.h == false) goto L111;
        StringBuilder r25 = new StringBuilder();
        r25.append(b(r11[r5]));
        if (TextUtils.isEmpty(this.o) == false) goto L109;
        String r26 = r17;
    L110:
        r25.append(r26);
        r16 = r25.toString();
        goto L111
    L109:
        r26 = this.o;
        goto L110
    L95:
        if (r113 != 5) goto L97;
        this.V = (this.N - r21.width()) - ((int) this.W);
        goto L103
    L97:
        if (r113 != 17) goto L103;
        this.V = (int) ((this.N - r21.width()) * 0.5f);
        goto L103
    L86:
        r15 = this.o;
        goto L87
    L77:
        if (TextUtils.isEmpty(b(r11[r5])) == true) goto L83;
        StringBuilder r27 = new StringBuilder();
        r27.append(b(r11[r5]));
        if (TextUtils.isEmpty(this.o) == false) goto L81;
        String r117 = r12;
    L82:
        r27.append(r117);
        r27.append(this.p);
        r16 = r27.toString();
        goto L88
    L81:
        r117 = this.o;
        goto L82
    L135:
        return;
    L56:
        if (this.h == false) goto L66;
        d(this.x);
        int r28 = this.U + this.t;
        Paint r29 = this.l;
        int r30 = this.r;
        if (r30 != 0) goto L61;
        r30 = this.q;
    L61:
        r29.setTextSize(r30);
        Paint r31 = this.l;
        int r32 = this.A;
        if (r32 != 0) goto L65;
        r32 = this.z;
    L65:
        r31.setColor(r32);
        r20.drawText(this.p, r28 - this.W, this.G, this.l);
        this.l.setTextSize(this.q);
        this.l.setColor(this.z);
        goto L66
    L40:
        if (TextUtils.isEmpty(this.p) == false) goto L42;
        int r33 = (this.N - this.t) / 2;
    L43:
        float r34 = r33 - 12;
        if (r34 > 0.0f) goto L46;
        float r118 = 10.0f;
    L47:
        float r119 = this.N - r118;
        float r35 = this.E;
        r20.drawLine(r118, r35, r119, r35, this.m);
        if (this.c == false) goto L54;
        float r36 = this.F;
        r20.drawLine(r118, r36, r119, r36, this.m);
        goto L54
    L46:
        r118 = r34;
        goto L47
    L42:
        r33 = (this.N - this.t) / 4;
        goto L43
    L19:
        if (this.K >= 0) goto L22;
        this.K = ((sl5.a) this.n).b() + this.K;
    L22:
        if (this.K <= (((sl5.a) this.n).b() - 1)) goto L24;
        this.K -= ((sl5.a) this.n).b();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        if (this.a == false) goto L34;
        boolean r0 = this.f.onTouchEvent(r10);
        float r2 = (-this.I) * this.w;
        float r3 = ((((sl5.a) this.n).b() - 1) - this.I) * this.w;
        int r4 = r10.getAction();
        boolean r5 = false;
        if (r4 != 0) goto L7;
        this.R = System.currentTimeMillis();
        a();
        this.Q = r10.getRawY();
    L30:
        if (r5 == true) goto L34;
        if (r10.getAction() == 0) goto L34;
        invalidate();
        goto L34
    L7:
        if (r4 == 1) goto L23;
        if (r4 != 2) goto L10;
        getParent().requestDisallowInterceptTouchEvent(true);
        float r1 = this.Q - r10.getRawY();
        this.Q = r10.getRawY();
        float r6 = this.H + r1;
        this.H = r6;
        if (this.D == true) goto L30;
        float r7 = this.w * 0.25f;
        if ((r6 - r7) >= r2) goto L19;
        if (r1 >= 0.0f) goto L19;
    L22:
        this.H = r6 - r1;
        r5 = true;
    L19:
        if ((r7 + r6) <= r3) goto L30;
        if (r1 <= 0.0f) goto L30;
    L10:
        if (r4 == 3) goto L23;
    L24:
        if (r0 == true) goto L30;
        float r8 = r10.getY();
        float r9 = this.O;
        double r11 = Math.acos((r9 - r8) / r9) * ((double) this.O);
        float r12 = this.w;
        this.P = (int) (((((int) ((r11 + ((double) (r12 / 2.0f))) / ((double) r12))) - (this.L / 2)) * r12) - (((this.H % r12) + r12) % r12));
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

    public final void setAdapter(pp5.a r1) {
        this.n = r1;
        e();
        requestLayout();
    }

    public final void setCurrentItem(int r1) {
        this.J = r1;
        this.I = r1;
        this.H = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r1) {
        this.D = r1;
    }

    public void setDefaultContent(String r1) {
        this.o = r1;
    }

    public void setDividerColor(int r2) {
        this.B = r2;
        this.m.setColor(r2);
    }

    public void setDividerType(DividerType r1) {
        this.b = r1;
    }

    public void setGravity(int r1) {
        this.T = r1;
    }

    public void setLabel(String r1) {
        this.p = r1;
    }

    public void setLineSpacingMultiplier(float r3) {
        if (r3 == 0.0f) goto L11;
        this.C = r3;
        if (r3 >= 1.0f) goto L8;
        this.C = 1.0f;
        return;
    L8:
        if (r3 <= 4.0f) goto L13;
        this.C = 4.0f;
        return;
    L13:
        return;
    }

    public final void setMaxWidthText(String r1) {
        this.x = r1;
    }

    public final void setOnItemSelectedListener(rp5.b r1) {
        this.g = r1;
    }

    public void setResistance(float r1) {
        this.p0 = r1;
    }

    public void setScroll(boolean r1) {
        this.a = r1;
    }

    public void setTextColorCenter(int r2) {
        this.z = r2;
        this.l.setColor(r2);
    }

    public void setTextColorLabel(int r1) {
        this.A = r1;
    }

    public void setTextColorOut(int r2) {
        this.y = r2;
        this.k.setColor(r2);
    }

    public final void setTextSizeCenter(float r3) {
        if (r3 <= 0.0f) goto L6;
        Resources r0 = this.d.getResources();
        int r4 = (int) (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3);
        this.q = r4;
        this.l.setTextSize(r4);
        return;
    }

    public final void setTextSizeLabel(float r3) {
        if (r3 <= 0.0f) goto L6;
        Resources r0 = this.d.getResources();
        this.r = (int) (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3);
        return;
    }

    public final void setTextSizeOut(float r3) {
        if (r3 <= 0.0f) goto L6;
        Resources r0 = this.d.getResources();
        int r4 = (int) (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3);
        this.s = r4;
        this.k.setTextSize(r4);
        return;
    }

    public void setTextXOffset(int r2) {
        this.v = r2;
        if (r2 == 0) goto L6;
        this.l.setTextScaleX(1.0f);
        return;
    }

    public void setTotalScrollY(float r1) {
        this.H = r1;
    }

    public final void setTypeface(Typeface r2) {
        int r0 = e.a;
        Typeface r3 = e.b(this.d, r2.getStyle());
        this.k.setTypeface(r3);
        this.l.setTypeface(r3);
    }

    public WheelView(Context r12, AttributeSet r13) {
        super(r12, r13);
        this.a = true;
        this.c = true;
        this.h = true;
        this.i = BearExecutors.e();
        this.x = "";
        Typeface r1 = Typeface.MONOSPACE;
        this.C = 1.6f;
        this.L = 11;
        this.P = 0;
        this.Q = 0.0f;
        this.R = 0;
        this.T = 17;
        this.U = 0;
        this.V = 0;
        this.k0 = 0.8f;
        this.p0 = 20.0f;
        int r5 = getResources().getDimensionPixelSize(2131169535);
        Resources r6 = getResources();
        float r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density;
        if (r7 >= 1.0f) goto L6;
        this.W = 2.4f;
    L22:
        if (r13 == null) goto L24;
        TypedArray r14 = r12.obtainStyledAttributes(r13, new int[]{2130975087, 2130975088, 2130975089, 2130975090, 2130975091, 2130975092, 2130975093, 2130975094, 2130975095, 2130975096, 2130975097, 2130975098, 2130975099, 2130975100, 2130975101, 2130975102, 2130975103, 2130975104, 2130975105, 2130975106, 2130975107, 2130975108, 2130975109}, 0, 0);
        this.T = r14.getInt(15, 17);
        this.y = r14.getColor(19, r12.getResources().getColor(2131106620));
        this.z = r14.getColor(18, r12.getResources().getColor(2131106622));
        this.B = r14.getColor(14, r12.getResources().getColor(2131103353));
        this.q = r14.getDimensionPixelOffset(21, r5);
        this.s = r14.getDimensionPixelOffset(22, r5);
        this.k0 = r14.getFloat(20, 0.8f);
        this.C = r14.getFloat(16, this.C);
        this.D = r14.getBoolean(13, true);
        this.p0 = r14.getFloat(17, this.p0);
        r14.recycle();
    L24:
        float r15 = this.C;
        if (r15 >= 1.0f) goto L28;
        this.C = 1.0f;
    L30:
        this.d = r12;
        this.e = new b(this);
        GestureDetector r16 = new GestureDetector(r12, new rp5.a(this));
        this.f = r16;
        r16.setIsLongpressEnabled(false);
        this.H = 0.0f;
        this.I = -1;
        Paint r17 = new Paint();
        this.k = r17;
        r17.setColor(this.y);
        this.k.setAntiAlias(true);
        this.k.setTextSize(this.s);
        Paint r18 = new Paint();
        this.l = r18;
        r18.setColor(this.z);
        this.l.setAntiAlias(true);
        this.l.setTextScaleX(1.1f);
        this.l.setTextSize(this.q);
        Paint r19 = new Paint();
        this.m = r19;
        r19.setColor(this.B);
        this.m.setAntiAlias(true);
        setLayerType(1, null);
        return;
    L28:
        if (r15 <= 4.0f) goto L30;
        this.C = 4.0f;
        goto L30
    L6:
        if (1.0f <= r7) goto L8;
    L10:
        if (1.0f > r7) goto L15;
        if (r7 >= 2.0f) goto L15;
        this.W = 4.5f;
    L15:
        if (2.0f > r7) goto L20;
        if (r7 >= 3.0f) goto L20;
        this.W = 6.0f;
    L20:
        if (r7 < 3.0f) goto L22;
        this.W = r7 * 2.5f;
        goto L22
    L8:
        if (r7 >= 2.0f) goto L10;
        this.W = 3.6f;
        goto L22
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        int r4 = View.MeasureSpec.getMode(r2);
        int r5 = View.MeasureSpec.getSize(r2);
        if (r4 != Integer.MIN_VALUE) goto L5;
        r5 = (int) this.l.measureText(this.x);
        r4 = 1073741824;
    L5:
        this.S = View.MeasureSpec.makeMeasureSpec(r5, r4);
        e();
        setMeasuredDimension(this.N, this.M);
    }
}
