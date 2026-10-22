package com.bytedance.ies.xelement.picker.view;

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
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.lynx.tasm.base.LLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public class WheelView extends View {
    public static final String[] V = null;
    public float A;
    public float B;
    public float C;
    public float D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f250232J;
    public int K;
    public int L;
    public float M;
    public long N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public final float S;
    public boolean T;
    public y76.a U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DividerType f250233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f250234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g86.b f250235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GestureDetector f250236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f86.d f250237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f250238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f250239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f250240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScheduledFuture<?> f250241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f250242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f250243k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f250244l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b86.d f250245m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f250246n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f250247o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f250248p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f250249q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f250250r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f250251s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f250252t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f250253u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f250254v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f250255w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f250256x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f250257y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f250258z;

    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ACTION[] f250259a = null;

        static {
            ACTION r100 = new ACTION("CLICK", 0);
            CLICK = r100;
            ACTION r101 = new ACTION("FLING", 1);
            FLING = r101;
            ACTION r102 = new ACTION("DAGGLE", 2);
            DAGGLE = r102;
            f250259a = new ACTION[]{r100, r101, r102};
        }

        public static ACTION[] values() {
            return (ACTION[]) f250259a.clone();
        }

        public static ACTION valueOf(String r100) {
            return (ACTION) r27.a.a(ACTION.class, r100);
        }

        public ACTION(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum DividerType extends Enum<DividerType> {
        public static final DividerType CIRCLE = null;
        public static final DividerType FILL = null;
        public static final DividerType WRAP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DividerType[] f250260a = null;

        static {
            DividerType r100 = new DividerType("FILL", 0);
            FILL = r100;
            DividerType r101 = new DividerType("WRAP", 1);
            WRAP = r101;
            DividerType r102 = new DividerType("CIRCLE", 2);
            CIRCLE = r102;
            f250260a = new DividerType[]{r100, r101, r102};
        }

        public static DividerType[] values() {
            return (DividerType[]) f250260a.clone();
        }

        public static DividerType valueOf(String r100) {
            return (DividerType) r27.a.a(DividerType.class, r100);
        }

        public DividerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        V = new String[]{CustomAlbumViewModel.DEFAULT_TAB_ID, HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09"};
    }

    public final void a() {
        ScheduledFuture<?> r100 = this.f250241i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCancelled() == true) goto L9;
        this.f250241i.cancel(true);
        this.f250241i = null;
        return;
    }

    public final void d() {
        if (this.f250245m != null) goto L5;
        return;
    L5:
        Rect r100 = new Rect();
        int r101 = 0;
    L7:
        if (r101 >= this.f250245m.getItemsCount()) goto L12;
        String r102 = b(this.f250245m.getItem(r101));
        this.f250243k.getTextBounds(r102, 0, r102.length(), r100);
        int r103 = r100.width();
        if (r103 <= this.f250248p) goto L11;
        this.f250248p = r103;
    L11:
        r101 = r101 + 1;
        goto L7
    L12:
        y76.a r104 = this.U;
        if (r104 == null) goto L18;
        String r105 = r104.a().get("wheel_text_bound_text");
        if (r105 == null) goto L18;
        if (r105.isEmpty() == true) goto L18;
    L19:
        this.f250243k.getTextBounds(r105, 0, 2, r100);
        int r106 = r100.height() + 2;
        this.f250249q = r106;
        float r107 = this.f250257y * r106;
        this.f250251s = r107;
        int r108 = (int) (r107 * (this.H - 1));
        this.I = (int) (((double) (r108 * 2)) / 3.141592653589793d);
        this.K = (int) (((double) r108) / 3.141592653589793d);
        this.f250232J = View.MeasureSpec.getSize(this.O);
        float r109 = this.I;
        float r110 = this.f250251s;
        this.A = (r109 - r110) / 2.0f;
        float r111 = (r109 + r110) / 2.0f;
        this.B = r111;
        this.C = (r111 - ((r110 - this.f250249q) / 2.0f)) - this.S;
        if (this.E == (-1)) goto L22;
    L25:
        this.G = this.E;
        return;
    L22:
        if (this.f250258z == false) goto L24;
        this.E = (this.f250245m.getItemsCount() + 1) / 2;
        goto L25
    L24:
        this.E = 0;
    L18:
        r105 = "Week";
        goto L19
    }

    public final int getCurrentItem() {
        b86.d r100 = this.f250245m;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (this.f250258z == false) goto L14;
        int r101 = this.F;
        if (r101 < 0) goto L12;
        if (r101 < r100.getItemsCount()) goto L14;
    L12:
        return Math.max(0, Math.min(Math.abs(Math.abs(this.F) - this.f250245m.getItemsCount()), this.f250245m.getItemsCount() - 1));
    L14:
        return Math.max(0, Math.min(this.F, this.f250245m.getItemsCount() - 1));
    }

    public int getItemsCount() {
        b86.d r100 = this.f250245m;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getItemsCount();
    }

    public final b86.d getAdapter() {
        return this.f250245m;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f250235c;
    }

    public int getInitPosition() {
        return this.E;
    }

    public float getItemHeight() {
        return this.f250251s;
    }

    public float getTotalScrollY() {
        return this.D;
    }

    public WheelView(Context r100) {
        this(r100, null);
    }

    public static String b(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof e86.a) == false) goto L10;
        return ((e86.a) r100).a();
    L10:
        if ((r100 instanceof Integer) == false) goto L19;
        int r101 = ((Integer) r100).intValue();
        if (r101 < 0) goto L17;
        if (r101 >= 10) goto L17;
        return V[r101];
    L17:
        return String.valueOf(r101);
    L19:
        return r100.toString();
    }

    public final int c(int r100) {
        if (r100 >= 0) goto L5;
        return c(r100 + this.f250245m.getItemsCount());
    L5:
        if (r100 > (this.f250245m.getItemsCount() - 1)) goto L7;
        return r100;
    L7:
        return c(r100 - this.f250245m.getItemsCount());
    }

    public final void f(ACTION r100) {
        a();
        if (r100 != ACTION.FLING) goto L5;
    L6:
        float r101 = this.D;
        float r102 = this.f250251s;
        int r103 = (int) (((r101 % r102) + r102) % r102);
        this.L = r103;
        if (r103 <= (r102 / 2.0f)) goto L9;
        this.L = (int) (r102 - r103);
    L10:
        this.f250241i = this.f250240h.scheduleWithFixedDelay(new g86.c(this, this.L), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        this.L = -r103;
        goto L10
    L5:
        if (r100 != ACTION.DAGGLE) goto L10;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        if (this.f250245m != null) goto L5;
        return;
    L5:
        int r100 = 0;
        int r101 = Math.min(Math.max(0, this.E), this.f250245m.getItemsCount() - 1);
        this.E = r101;
        this.G = r101 + (((int) (this.D / this.f250251s)) % this.f250245m.getItemsCount());     // Catch: ArithmeticException -> L8
    L10:
        if (this.f250258z == true) goto L18;
        if (this.G >= 0) goto L15;
        this.G = 0;
    L15:
        if (this.G <= (this.f250245m.getItemsCount() - 1)) goto L23;
        this.G = this.f250245m.getItemsCount() - 1;
    L23:
        float r102 = this.D % this.f250251s;
        DividerType r103 = this.f250233a;
        float r104 = 10.0f;
        if (r103 != DividerType.WRAP) goto L35;
        if (TextUtils.isEmpty(this.f250246n) == false) goto L28;
        int r105 = (this.f250232J - this.f250248p) / 2;
    L29:
        float r106 = r105 - 12;
        if (r106 > 0.0f) goto L32;
        float r110 = 10.0f;
    L33:
        float r111 = this.f250232J - r110;
        float r107 = this.A;
        float r108 = r110;
        r210.drawLine(r108, r107, r111, r107, this.f250244l);
        float r109 = this.B;
        r210.drawLine(r108, r109, r111, r109, this.f250244l);
    L47:
        if (TextUtils.isEmpty(this.f250246n) == false) goto L49;
    L59:
        int r112 = 0;
    L60:
        int r113 = this.H;
        if (r112 >= r113) goto L146;
        int r114 = this.G - ((r113 / 2) - r112);
        if (this.f250258z == false) goto L65;
        Object r115 = this.f250245m.getItem(c(r114));
    L71:
        r210.save();
        double r116 = ((this.f250251s * r112) - r102) / this.K;
        float r117 = (float) (90.0d - ((r116 / 3.141592653589793d) * 180.0d));
        if (r117 <= 90.0f) goto L74;
    L144:
        r210.restore();
    L145:
        r112 = r112 + 1;
        r102 = r102;
        r100 = 0;
        goto L60
    L74:
        if (r117 < (-90.0f)) goto L144;
        if (this.f250239g == false) goto L79;
    L83:
        String r118 = b(r115);
    L84:
        float r119 = (float) Math.pow(Math.abs(r117) / 90.0f, 2.2d);
        Rect r120 = new Rect();
        this.f250243k.getTextBounds(r118, r100, r118.length(), r120);
        int r121 = r120.width();
        int r122 = this.f250247o;
    L86:
        if (r121 <= this.f250232J) goto L88;
        r122 = r122 - 1;
        this.f250243k.setTextSize(r122);
        this.f250243k.getTextBounds(r118, r100, r118.length(), r120);
        r121 = r120.width();
        goto L86
    L88:
        this.f250242j.setTextSize(r122);
        Rect r123 = new Rect();
        this.f250243k.getTextBounds(r118, r100, r118.length(), r123);
        int r124 = this.P;
        if (r124 == 3) goto L106;
        if (r124 == 5) goto L104;
        if (r124 == 17) goto L94;
    L105:
        int r125 = 0;
    L107:
        Rect r126 = new Rect();
        this.f250242j.getTextBounds(r118, r125, r118.length(), r126);
        int r127 = this.P;
        if (r127 == 3) goto L125;
        if (r127 != 5) goto L111;
        this.R = (this.f250232J - r126.width()) - ((int) this.S);
    L126:
        float r128 = (float) ((((double) this.K) - (Math.cos(r116) * ((double) this.K))) - ((Math.sin(r116) * ((double) this.f250249q)) / 2.0d));
        r210.translate(0.0f, r128);
        float r129 = this.A;
        if (r128 <= r129) goto L129;
    L131:
        float r130 = this.B;
        if (r128 > r130) goto L137;
        if ((this.f250249q + r128) < r130) goto L137;
        r210.save();
        r210.clipRect(0.0f, 0.0f, this.f250232J, this.B - r128);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 1.0f);
        r210.drawText(r118, this.Q, this.f250249q - this.S, this.f250243k);
        r210.restore();
        r210.save();
        r210.clipRect(0.0f, this.B - r128, this.f250232J, (int) this.f250251s);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 0.8f);
        e(r119, r117);
        r210.drawText(r118, this.R, this.f250249q, this.f250242j);
        r210.restore();
    L143:
        r210.restore();
        this.f250243k.setTextSize(this.f250247o);
    L137:
        if (r128 < r129) goto L142;
        float r131 = this.f250249q;
        if ((r128 + r131) > r130) goto L142;
        r210.drawText(r118, this.Q, r131 - this.S, this.f250243k);
        this.F = this.G - ((this.H / 2) - r112);
    L142:
        r210.save();
        r210.clipRect(0, 0, this.f250232J, (int) this.f250251s);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 0.8f);
        e(r119, r117);
        r210.drawText(r118, this.R + (this.f250250r * r119), this.f250249q, this.f250242j);
        r210.restore();
        goto L143
    L129:
        if ((this.f250249q + r128) < r129) goto L131;
        r210.save();
        r210.clipRect(0.0f, 0.0f, this.f250232J, this.A - r128);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 0.8f);
        e(r119, r117);
        r210.drawText(r118, this.R, this.f250249q, this.f250242j);
        r210.restore();
        r210.save();
        r210.clipRect(0.0f, this.A - r128, this.f250232J, (int) this.f250251s);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 1.0f);
        r210.drawText(r118, this.Q, this.f250249q - this.S, this.f250243k);
        r210.restore();
        goto L143
    L111:
        if (r127 != 17) goto L126;
        if (this.f250238f == true) goto L123;
        String r132 = this.f250246n;
        if (r132 == null) goto L123;
        if (r132.equals("") == true) goto L123;
        if (this.f250239g == false) goto L123;
        this.R = (int) (((double) (this.f250232J - r126.width())) * 0.25d);
    L123:
        this.R = (int) (((double) (this.f250232J - r126.width())) * 0.5d);
        goto L126
    L125:
        this.R = 0;
        goto L126
    L94:
        if (this.f250238f == true) goto L103;
        String r133 = this.f250246n;
        if (r133 == null) goto L103;
        if (r133.equals("") == true) goto L103;
        if (this.f250239g == false) goto L103;
        this.Q = (int) (((double) (this.f250232J - r123.width())) * 0.25d);
    L103:
        this.Q = (int) (((double) (this.f250232J - r123.width())) * 0.5d);
        goto L105
    L104:
        this.Q = (this.f250232J - r123.width()) - ((int) this.S);
        goto L105
    L106:
        r125 = 0;
        this.Q = 0;
        goto L107
    L79:
        if (TextUtils.isEmpty(this.f250246n) == true) goto L83;
        if (TextUtils.isEmpty(b(r115)) == true) goto L83;
        r118 = b(r115) + this.f250246n;
        goto L84
    L65:
        if (r114 >= 0) goto L68;
    L69:
        r115 = "";
        goto L71
    L68:
        if (r114 > (this.f250245m.getItemsCount() - 1)) goto L69;
        r115 = this.f250245m.getItem(r114);
        goto L71
    L146:
        return;
    L49:
        if (this.f250239g == false) goto L59;
        int r134 = this.f250232J;
        Paint r135 = this.f250243k;
        String r136 = this.f250246n;
        if (r136 != null) goto L53;
    L57:
        int r137 = 0;
    L58:
        r210.drawText(this.f250246n, (r134 - r137) - this.S, this.C, this.f250243k);
        goto L59
    L53:
        if (r136.length() <= 0) goto L57;
        int r138 = r136.length();
        float[] r139 = new float[r138];
        r135.getTextWidths(r136, r139);
        int r140 = 0;
        r137 = 0;
    L55:
        if (r140 >= r138) goto L58;
        r137 = r137 + ((int) Math.ceil(r139[r140]));
        r140 = r140 + 1;
        goto L55
    L32:
        r110 = r106;
        goto L33
    L28:
        r105 = (this.f250232J - this.f250248p) / 4;
        goto L29
    L35:
        if (r103 != DividerType.CIRCLE) goto L45;
        this.f250244l.setStyle(Paint.Style.STROKE);
        this.f250244l.setStrokeWidth(this.f250256x);
        if (TextUtils.isEmpty(this.f250246n) == false) goto L39;
        float r141 = (this.f250232J - this.f250248p) / 2.0f;
    L40:
        float r142 = r141 - 12.0f;
        if (r142 <= 0.0f) goto L44;
        r104 = r142;
    L44:
        r210.drawCircle(this.f250232J / 2.0f, this.I / 2.0f, Math.max((this.f250232J - r104) - r104, this.f250251s) / 1.8f, this.f250244l);
        goto L47
    L39:
        r141 = (this.f250232J - this.f250248p) / 4.0f;
        goto L40
    L45:
        float r143 = this.A;
        r210.drawLine(0.0f, r143, this.f250232J, r143, this.f250244l);
        float r144 = this.B;
        r210.drawLine(0.0f, r144, this.f250232J, r144, this.f250244l);
        goto L47
    L18:
        if (this.G >= 0) goto L21;
        this.G = this.f250245m.getItemsCount() + this.G;
    L21:
        if (this.G <= (this.f250245m.getItemsCount() - 1)) goto L23;
        this.G -= this.f250245m.getItemsCount();
    L8:
        LLog.e("WheelView", "Error！adapter.getItemsCount() == 0，adapter data doesn't match");
        goto L10
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = this.f250236d.onTouchEvent(r110);
        float r101 = (-this.E) * this.f250251s;
        float r102 = ((this.f250245m.getItemsCount() - 1) - this.E) * this.f250251s;
        int r103 = r110.getAction();
        boolean r104 = false;
        if (r103 != 0) goto L5;
        this.N = System.currentTimeMillis();
        a();
        this.M = r110.getRawY();
    L23:
        if (r104 == false) goto L25;
    L27:
        return true;
    L25:
        if (r110.getAction() == 0) goto L27;
        invalidate();
        goto L27
    L5:
        if (r103 == 2) goto L11;
        if (r100 == true) goto L23;
        float r105 = r110.getY();
        int r106 = this.K;
        double r107 = Math.acos((r106 - r105) / r106) * ((double) this.K);
        float r108 = this.f250251s;
        this.L = (int) (((((int) ((r107 + ((double) (r108 / 2.0f))) / ((double) r108))) - (this.H / 2)) * r108) - (((this.D % r108) + r108) % r108));
        if ((System.currentTimeMillis() - this.N) <= 120) goto L10;
        f(ACTION.DAGGLE);
        goto L23
    L10:
        f(ACTION.CLICK);
        goto L23
    L11:
        float r109 = this.M - r110.getRawY();
        this.M = r110.getRawY();
        float r111 = this.D + r109;
        this.D = r111;
        if (this.f250258z == true) goto L23;
        float r112 = this.f250251s;
        if ((r111 - (r112 * 0.25f)) >= r101) goto L18;
        if (r109 >= 0.0f) goto L18;
    L21:
        this.D = r111 - r109;
        r104 = true;
    L18:
        if (((r112 * 0.25f) + r111) <= r102) goto L23;
        if (r109 <= 0.0f) goto L23;
        goto L21
    }

    public final void setAdapter(b86.d r100) {
        this.f250245m = r100;
        d();
        invalidate();
    }

    public void setAlphaGradient(boolean r100) {
        this.T = r100;
    }

    public final void setCurrentIndex(int r100) {
        this.F = r100;
        this.E = r100;
        this.D = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r100) {
        this.f250258z = r100;
    }

    public void setDividerColor(int r100) {
        this.f250255w = r100;
        this.f250244l.setColor(r100);
    }

    public void setDividerType(DividerType r100) {
        this.f250233a = r100;
    }

    public void setDividerWidth(int r100) {
        this.f250256x = r100;
        this.f250244l.setStrokeWidth(r100);
    }

    public void setGravity(int r100) {
        this.P = r100;
    }

    public void setIsOptions(boolean r100) {
        this.f250238f = r100;
    }

    public void setItemsVisibleCount(int r100) {
        if ((r100 % 2) != 0) goto L5;
        r100 = r100 + 1;
    L5:
        this.H = r100 + 2;
    }

    public void setLabel(String r100) {
        this.f250246n = r100;
    }

    public void setLineSpacingMultiplier(float r100) {
        if (r100 == 0.0f) goto L11;
        this.f250257y = r100;
        if (r100 >= 1.0f) goto L8;
        this.f250257y = 1.0f;
        return;
    L8:
        if (r100 <= 4.0f) goto L13;
        this.f250257y = 4.0f;
        return;
    L13:
        return;
    }

    public void setLocalizeAdapter(y76.a r100) {
        this.U = r100;
    }

    public final void setOnItemSelectedListener(f86.d r100) {
        this.f250237e = r100;
    }

    public void setTextColorCenter(int r100) {
        this.f250254v = r100;
        this.f250243k.setColor(r100);
    }

    public void setTextColorOut(int r100) {
        this.f250253u = r100;
        this.f250242j.setColor(r100);
    }

    public final void setTextSize(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = this.f250234b.getResources();
        int r102 = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        this.f250247o = r102;
        this.f250242j.setTextSize(r102);
        this.f250243k.setTextSize(this.f250247o);
        return;
    }

    public void setTextXOffset(int r100) {
        this.f250250r = r100;
        if (r100 == 0) goto L6;
        this.f250243k.setTextScaleX(1.0f);
        return;
    }

    public void setTotalScrollY(float r100) {
        this.D = r100;
    }

    public final void setTypeface(Typeface r100) {
        this.f250252t = r100;
        this.f250242j.setTypeface(r100);
        this.f250243k.setTypeface(this.f250252t);
    }

    public WheelView(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.f250238f = false;
        this.f250239g = true;
        this.f250240h = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("iew/WheelView"));
        this.f250252t = Typeface.MONOSPACE;
        this.f250257y = 1.6f;
        this.H = 11;
        this.L = 0;
        this.M = 0.0f;
        this.N = 0;
        this.P = 17;
        this.Q = 0;
        this.R = 0;
        this.T = false;
        this.f250247o = getResources().getDimensionPixelSize(R.dimen.lynx_picker_textsize);
        Resources r100 = getResources();
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        if (r101 >= 1.0f) goto L6;
        this.S = 2.4f;
    L18:
        if (r111 == null) goto L20;
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.picker_dividerColor, R.attr.picker_dividerWidth, R.attr.picker_gravity, R.attr.picker_lineSpacingMultiplier, R.attr.picker_textColorCenter, R.attr.picker_textColorOut, R.attr.picker_textSize}, 0, 0);
        this.P = r112.getInt(2, 17);
        this.f250253u = r112.getColor(5, -5723992);
        this.f250254v = r112.getColor(4, -14013910);
        this.f250255w = r112.getColor(0, -2763307);
        this.f250256x = r112.getDimensionPixelSize(1, 2);
        this.f250247o = r112.getDimensionPixelOffset(6, this.f250247o);
        this.f250257y = r112.getFloat(3, this.f250257y);
        r112.recycle();
    L20:
        float r113 = this.f250257y;
        if (r113 >= 1.0f) goto L24;
        this.f250257y = 1.0f;
    L26:
        this.f250234b = r110;
        this.f250235c = new g86.b(this);
        GestureDetector r114 = new GestureDetector(r110, new f86.b(this));
        this.f250236d = r114;
        r114.setIsLongpressEnabled(false);
        this.f250258z = true;
        this.D = 0.0f;
        this.E = -1;
        Paint r115 = new Paint();
        this.f250242j = r115;
        r115.setColor(this.f250253u);
        this.f250242j.setAntiAlias(true);
        this.f250242j.setTypeface(this.f250252t);
        this.f250242j.setTextSize(this.f250247o);
        Paint r116 = new Paint();
        this.f250243k = r116;
        r116.setColor(this.f250254v);
        this.f250243k.setAntiAlias(true);
        this.f250243k.setTextScaleX(1.1f);
        this.f250243k.setTypeface(this.f250252t);
        this.f250243k.setTextSize(this.f250247o);
        Paint r117 = new Paint();
        this.f250244l = r117;
        r117.setColor(this.f250255w);
        this.f250244l.setAntiAlias(true);
        setLayerType(1, null);
        return;
    L24:
        if (r113 <= 4.0f) goto L26;
        this.f250257y = 4.0f;
        goto L26
    L6:
        if (1.0f > r101) goto L11;
        if (r101 >= 2.0f) goto L11;
        this.S = 4.0f;
    L11:
        if (2.0f > r101) goto L16;
        if (r101 >= 3.0f) goto L16;
        this.S = 6.0f;
    L16:
        if (r101 < 3.0f) goto L18;
        this.S = r101 * 2.5f;
        goto L18
    }

    public final void e(float r100, float r101) {
        int r102 = this.f250250r;
        int r103 = -1;
        if (r102 <= 0) goto L5;
        int r104 = 1;
    L8:
        Paint r105 = this.f250242j;
        if (r101 > 0.0f) goto L12;
        r103 = 1;
    L12:
        r105.setTextSkewX(((r104 * r103) * 0.5f) * r100);
        if (this.T == false) goto L15;
        int r106 = (int) (((90.0f - Math.abs(r101)) / 90.0f) * 255.0f);
    L16:
        this.f250242j.setAlpha(r106);
        return;
    L15:
        r106 = 255;
        goto L16
    L5:
        if (r102 >= 0) goto L7;
        r104 = -1;
        goto L8
    L7:
        r104 = 0;
        goto L8
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        this.O = r100;
        d();
        setMeasuredDimension(this.f250232J, this.I);
    }
}
