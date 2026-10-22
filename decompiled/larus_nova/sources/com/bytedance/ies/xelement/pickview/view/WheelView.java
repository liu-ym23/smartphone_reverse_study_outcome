package com.bytedance.ies.xelement.pickview.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
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
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import j86.c;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import l86.b;
import y76.a;

/* JADX INFO: loaded from: classes19.dex */
public class WheelView extends View {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String[] f250309p0 = null;
    public float A;
    public boolean B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f250310J;
    public int K;
    public int L;
    public int M;
    public int N;
    public float O;
    public long P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public final float U;
    public boolean V;
    public a W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DividerType f250311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f250312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f250313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GestureDetector f250314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k86.b f250315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f250316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f250317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f250318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScheduledFuture<?> f250319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f250320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f250321k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Handler f250322k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f250323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f250324m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f250325n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f250326o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f250327p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f250328q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f250329r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f250330s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f250331t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f250332u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Typeface f250333v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f250334w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f250335x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f250336y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f250337z;

    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ACTION[] f250338a = null;

        static {
            ACTION r100 = new ACTION("CLICK", 0);
            CLICK = r100;
            ACTION r101 = new ACTION("FLING", 1);
            FLING = r101;
            ACTION r102 = new ACTION("DAGGLE", 2);
            DAGGLE = r102;
            f250338a = new ACTION[]{r100, r101, r102};
        }

        public static ACTION[] values() {
            return (ACTION[]) f250338a.clone();
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
        public static final /* synthetic */ DividerType[] f250339a = null;

        static {
            DividerType r100 = new DividerType("FILL", 0);
            FILL = r100;
            DividerType r101 = new DividerType("WRAP", 1);
            WRAP = r101;
            DividerType r102 = new DividerType("CIRCLE", 2);
            CIRCLE = r102;
            f250339a = new DividerType[]{r100, r101, r102};
        }

        public static DividerType[] values() {
            return (DividerType[]) f250339a.clone();
        }

        public static DividerType valueOf(String r100) {
            return (DividerType) r27.a.a(DividerType.class, r100);
        }

        public DividerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f250309p0 = new String[]{CustomAlbumViewModel.DEFAULT_TAB_ID, HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09"};
    }

    public final void a() {
        ScheduledFuture<?> r100 = this.f250319i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCancelled() == true) goto L9;
        this.f250319i.cancel(true);
        this.f250319i = null;
        return;
    }

    public final void d() {
        if (this.f250325n != null) goto L5;
        return;
    L5:
        Rect r100 = new Rect();
        int r101 = 0;
    L7:
        if (r101 >= this.f250325n.getItemsCount()) goto L12;
        String r102 = b(this.f250325n.getItem(r101));
        this.f250321k.getTextBounds(r102, 0, r102.length(), r100);
        int r103 = r100.width();
        if (r103 <= this.f250328q) goto L11;
        this.f250328q = r103;
    L11:
        r101 = r101 + 1;
        goto L7
    L12:
        a r104 = this.W;
        if (r104 == null) goto L18;
        String r105 = r104.a().get("wheel_text_bound_text");
        if (r105 == null) goto L18;
        if (r105.isEmpty() == true) goto L18;
    L19:
        this.f250321k.getTextBounds(r105, 0, 2, r100);
        int r106 = r100.height() + 2;
        this.f250329r = r106;
        this.f250331t = this.A * r106;
        float r107 = this.f250332u;
        if (r107 <= 0.0f) goto L22;
        this.f250331t = r107;
    L22:
        int r108 = (int) (this.f250331t * (this.f250310J - 1));
        this.K = (int) (((double) (r108 * 2)) / 3.141592653589793d);
        this.M = (int) (((double) r108) / 3.141592653589793d);
        this.L = View.MeasureSpec.getSize(this.Q);
        float r109 = this.K;
        float r110 = this.f250331t;
        this.C = (r109 - r110) / 2.0f;
        float r111 = (r109 + r110) / 2.0f;
        this.D = r111;
        this.E = (r111 - ((r110 - this.f250329r) / 2.0f)) - this.U;
        if (this.G == (-1)) goto L25;
    L28:
        this.I = this.G;
        return;
    L25:
        if (this.B == false) goto L27;
        this.G = (this.f250325n.getItemsCount() + 1) / 2;
        goto L28
    L27:
        this.G = 0;
    L18:
        r105 = "Week";
        goto L19
    }

    public final int getCurrentItem() {
        c r100 = this.f250325n;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (this.B == false) goto L14;
        int r101 = this.H;
        if (r101 < 0) goto L12;
        if (r101 < r100.getItemsCount()) goto L14;
    L12:
        return Math.max(0, Math.min(Math.abs(Math.abs(this.H) - this.f250325n.getItemsCount()), this.f250325n.getItemsCount() - 1));
    L14:
        return Math.max(0, Math.min(this.H, this.f250325n.getItemsCount() - 1));
    }

    public int getItemDefaultOrUserHeight() {
        float r100 = this.f250332u;
        if (r100 <= 0.0f) goto L7;
        return (int) r100;
    L7:
        return (int) this.f250331t;
    }

    public int getItemsCount() {
        c r100 = this.f250325n;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getItemsCount();
    }

    public final c getAdapter() {
        return this.f250325n;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f250313c;
    }

    public int getInitPosition() {
        return this.G;
    }

    public float getItemHeight() {
        return this.f250331t;
    }

    public float getTotalScrollY() {
        return this.F;
    }

    public WheelView(Context r100) {
        this(r100, null);
    }

    public static String b(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof j86.b) == false) goto L10;
        return ((j86.b) r100).a();
    L10:
        if ((r100 instanceof Integer) == false) goto L19;
        int r101 = ((Integer) r100).intValue();
        if (r101 < 0) goto L17;
        if (r101 >= 10) goto L17;
        return f250309p0[r101];
    L17:
        return String.valueOf(r101);
    L19:
        return r100.toString();
    }

    public final int c(int r100) {
        if (r100 >= 0) goto L5;
        return c(r100 + this.f250325n.getItemsCount());
    L5:
        if (r100 > (this.f250325n.getItemsCount() - 1)) goto L7;
        return r100;
    L7:
        return c(r100 - this.f250325n.getItemsCount());
    }

    public final void f(ACTION r100) {
        a();
        if (r100 != ACTION.FLING) goto L5;
    L6:
        float r101 = this.F;
        float r102 = this.f250331t;
        int r103 = (int) (((r101 % r102) + r102) % r102);
        this.N = r103;
        if (r103 <= (r102 / 2.0f)) goto L9;
        this.N = (int) (r102 - r103);
    L10:
        this.f250319i = this.f250318h.scheduleWithFixedDelay(new l86.c(this, this.N), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        this.N = -r103;
        goto L10
    L5:
        if (r100 != ACTION.DAGGLE) goto L10;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        if (this.f250325n != null) goto L5;
        return;
    L5:
        int r100 = 0;
        int r101 = Math.min(Math.max(0, this.G), this.f250325n.getItemsCount() - 1);
        this.G = r101;
        this.I = r101 + (((int) (this.F / this.f250331t)) % this.f250325n.getItemsCount());     // Catch: ArithmeticException -> L8
    L10:
        if (this.B == true) goto L18;
        if (this.I >= 0) goto L15;
        this.I = 0;
    L15:
        if (this.I <= (this.f250325n.getItemsCount() - 1)) goto L23;
        this.I = this.f250325n.getItemsCount() - 1;
    L23:
        float r102 = this.F % this.f250331t;
        DividerType r103 = this.f250311a;
        float r104 = 10.0f;
        if (r103 != DividerType.WRAP) goto L35;
        if (TextUtils.isEmpty(this.f250326o) == false) goto L28;
        int r105 = (this.L - this.f250328q) / 2;
    L29:
        float r106 = r105 - 12;
        if (r106 > 0.0f) goto L32;
        float r110 = 10.0f;
    L33:
        float r111 = this.L - r110;
        float r107 = this.C;
        float r108 = r110;
        r210.drawLine(r108, r107, r111, r107, this.f250323l);
        float r109 = this.D;
        r210.drawLine(r108, r109, r111, r109, this.f250323l);
    L47:
        if (TextUtils.isEmpty(this.f250326o) == false) goto L49;
    L59:
        int r112 = 0;
    L60:
        int r113 = this.f250310J;
        if (r112 >= r113) goto L146;
        int r114 = this.I - ((r113 / 2) - r112);
        if (this.B == false) goto L65;
        Object r115 = this.f250325n.getItem(c(r114));
    L71:
        r210.save();
        double r116 = ((this.f250331t * r112) - r102) / this.M;
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
        if (this.f250317g == false) goto L79;
    L83:
        String r118 = b(r115);
    L84:
        float r119 = (float) Math.pow(Math.abs(r117) / 90.0f, 2.2d);
        Rect r120 = new Rect();
        this.f250321k.getTextBounds(r118, r100, r118.length(), r120);
        int r121 = r120.width();
        int r122 = this.f250327p;
    L86:
        if (r121 <= this.L) goto L88;
        r122 = r122 - 1;
        this.f250321k.setTextSize(r122);
        this.f250321k.getTextBounds(r118, r100, r118.length(), r120);
        r121 = r120.width();
        goto L86
    L88:
        this.f250320j.setTextSize(r122);
        Rect r123 = new Rect();
        this.f250321k.getTextBounds(r118, r100, r118.length(), r123);
        int r124 = this.R;
        if (r124 == 3) goto L106;
        if (r124 == 5) goto L104;
        if (r124 == 17) goto L94;
    L105:
        int r125 = 0;
    L107:
        Rect r126 = new Rect();
        this.f250320j.getTextBounds(r118, r125, r118.length(), r126);
        int r127 = this.R;
        if (r127 == 3) goto L125;
        if (r127 != 5) goto L111;
        this.T = (this.L - r126.width()) - ((int) this.U);
    L126:
        float r128 = (float) ((((double) this.M) - (Math.cos(r116) * ((double) this.M))) - ((Math.sin(r116) * ((double) this.f250329r)) / 2.0d));
        r210.translate(0.0f, r128);
        float r129 = this.C;
        if (r128 <= r129) goto L129;
    L131:
        float r130 = this.D;
        if (r128 > r130) goto L137;
        if ((this.f250329r + r128) < r130) goto L137;
        r210.save();
        r210.clipRect(0.0f, 0.0f, this.L, this.D - r128);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 1.0f);
        r210.drawText(r118, this.S, this.f250329r - this.U, this.f250321k);
        r210.restore();
        r210.save();
        r210.clipRect(0.0f, this.D - r128, this.L, (int) this.f250331t);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 0.8f);
        e(r119, r117);
        r210.drawText(r118, this.T, this.f250329r, this.f250320j);
        r210.restore();
    L143:
        r210.restore();
        this.f250321k.setTextSize(this.f250327p);
    L137:
        if (r128 < r129) goto L142;
        float r131 = this.f250329r;
        if ((r128 + r131) > r130) goto L142;
        r210.drawText(r118, this.S, r131 - this.U, this.f250321k);
        this.H = this.I - ((this.f250310J / 2) - r112);
    L142:
        r210.save();
        r210.clipRect(0, 0, this.L, (int) this.f250331t);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 0.8f);
        e(r119, r117);
        r210.drawText(r118, this.T + (this.f250330s * r119), this.f250329r, this.f250320j);
        r210.restore();
        goto L143
    L129:
        if ((this.f250329r + r128) < r129) goto L131;
        r210.save();
        r210.clipRect(0.0f, 0.0f, this.L, this.C - r128);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 0.8f);
        e(r119, r117);
        r210.drawText(r118, this.T, this.f250329r, this.f250320j);
        r210.restore();
        r210.save();
        r210.clipRect(0.0f, this.C - r128, this.L, (int) this.f250331t);
        r210.scale(1.0f, ((float) Math.sin(r116)) * 1.0f);
        r210.drawText(r118, this.S, this.f250329r - this.U, this.f250321k);
        r210.restore();
        goto L143
    L111:
        if (r127 != 17) goto L126;
        if (this.f250316f == true) goto L123;
        String r132 = this.f250326o;
        if (r132 == null) goto L123;
        if (r132.equals("") == true) goto L123;
        if (this.f250317g == false) goto L123;
        this.T = (int) (((double) (this.L - r126.width())) * 0.25d);
    L123:
        this.T = (int) (((double) (this.L - r126.width())) * 0.5d);
        goto L126
    L125:
        this.T = 0;
        goto L126
    L94:
        if (this.f250316f == true) goto L103;
        String r133 = this.f250326o;
        if (r133 == null) goto L103;
        if (r133.equals("") == true) goto L103;
        if (this.f250317g == false) goto L103;
        this.S = (int) (((double) (this.L - r123.width())) * 0.25d);
    L103:
        this.S = (int) (((double) (this.L - r123.width())) * 0.5d);
        goto L105
    L104:
        this.S = (this.L - r123.width()) - ((int) this.U);
        goto L105
    L106:
        r125 = 0;
        this.S = 0;
        goto L107
    L79:
        if (TextUtils.isEmpty(this.f250326o) == true) goto L83;
        if (TextUtils.isEmpty(b(r115)) == true) goto L83;
        r118 = b(r115) + this.f250326o;
        goto L84
    L65:
        if (r114 >= 0) goto L68;
    L69:
        r115 = "";
        goto L71
    L68:
        if (r114 > (this.f250325n.getItemsCount() - 1)) goto L69;
        r115 = this.f250325n.getItem(r114);
        goto L71
    L146:
        Paint r134 = this.f250324m;
        if (r134 == null) goto L157;
        r210.drawRect(0.0f, 0.0f, this.L, this.C, r134);
        r210.drawRect(0.0f, this.D, this.L, this.K, this.f250324m);
        return;
    L157:
        return;
    L49:
        if (this.f250317g == false) goto L59;
        int r135 = this.L;
        Paint r136 = this.f250321k;
        String r137 = this.f250326o;
        if (r137 != null) goto L53;
    L57:
        int r138 = 0;
    L58:
        r210.drawText(this.f250326o, (r135 - r138) - this.U, this.E, this.f250321k);
        goto L59
    L53:
        if (r137.length() <= 0) goto L57;
        int r139 = r137.length();
        float[] r140 = new float[r139];
        r136.getTextWidths(r137, r140);
        int r141 = 0;
        r138 = 0;
    L55:
        if (r141 >= r139) goto L58;
        r138 = r138 + ((int) Math.ceil(r140[r141]));
        r141 = r141 + 1;
        goto L55
    L32:
        r110 = r106;
        goto L33
    L28:
        r105 = (this.L - this.f250328q) / 4;
        goto L29
    L35:
        if (r103 != DividerType.CIRCLE) goto L45;
        this.f250323l.setStyle(Paint.Style.STROKE);
        this.f250323l.setStrokeWidth(this.f250337z);
        if (TextUtils.isEmpty(this.f250326o) == false) goto L39;
        float r142 = (this.L - this.f250328q) / 2.0f;
    L40:
        float r143 = r142 - 12.0f;
        if (r143 <= 0.0f) goto L44;
        r104 = r143;
    L44:
        r210.drawCircle(this.L / 2.0f, this.K / 2.0f, Math.max((this.L - r104) - r104, this.f250331t) / 1.8f, this.f250323l);
        goto L47
    L39:
        r142 = (this.L - this.f250328q) / 4.0f;
        goto L40
    L45:
        float r144 = this.C;
        r210.drawLine(0.0f, r144, this.L, r144, this.f250323l);
        float r145 = this.D;
        r210.drawLine(0.0f, r145, this.L, r145, this.f250323l);
        goto L47
    L18:
        if (this.I >= 0) goto L21;
        this.I = this.f250325n.getItemsCount() + this.I;
    L21:
        if (this.I <= (this.f250325n.getItemsCount() - 1)) goto L23;
        this.I -= this.f250325n.getItemsCount();
    L8:
        LLog.e("WheelView", "Error！adapter.getItemsCount() == 0，adapter data doesn't match");
        goto L10
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = false;
        if (this.f250325n != null) goto L5;
        return false;
    L5:
        boolean r101 = this.f250314d.onTouchEvent(r110);
        float r102 = (-this.G) * this.f250331t;
        float r103 = ((this.f250325n.getItemsCount() - 1) - this.G) * this.f250331t;
        int r104 = r110.getAction();
        if (r104 != 0) goto L8;
        this.P = System.currentTimeMillis();
        a();
        this.O = r110.getRawY();
    L26:
        if (r100 == false) goto L28;
    L30:
        return true;
    L28:
        if (r110.getAction() == 0) goto L30;
        invalidate();
        goto L30
    L8:
        if (r104 == 2) goto L14;
        if (r101 == true) goto L26;
        float r105 = r110.getY();
        int r106 = this.M;
        double r107 = Math.acos((r106 - r105) / r106) * ((double) this.M);
        float r108 = this.f250331t;
        this.N = (int) (((((int) ((r107 + ((double) (r108 / 2.0f))) / ((double) r108))) - (this.f250310J / 2)) * r108) - (((this.F % r108) + r108) % r108));
        if ((System.currentTimeMillis() - this.P) <= 120) goto L13;
        f(ACTION.DAGGLE);
        goto L26
    L13:
        f(ACTION.CLICK);
        goto L26
    L14:
        float r109 = this.O - r110.getRawY();
        this.O = r110.getRawY();
        float r111 = this.F + r109;
        this.F = r111;
        if (this.B == true) goto L26;
        float r112 = this.f250331t;
        if ((r111 - (r112 * 0.25f)) >= r102) goto L21;
        if (r109 >= 0.0f) goto L21;
    L24:
        this.F = r111 - r109;
        r100 = true;
    L21:
        if (((r112 * 0.25f) + r111) <= r103) goto L26;
        if (r109 <= 0.0f) goto L26;
        goto L24
    }

    public final void setAdapter(c r100) {
        this.f250325n = r100;
        int r101 = r100.getItemsCount();
        if (r101 != 0) goto L5;
        setCurrentIndex(0);
    L10:
        d();
        invalidate();
        return;
    L5:
        int r102 = this.H;
        int r103 = r101 - 1;
        if (r102 <= r103) goto L8;
        setCurrentIndex(r103);
        goto L10
    L8:
        if (r102 >= 0) goto L10;
        setCurrentIndex(0);
        goto L10
    }

    public void setAlphaGradient(boolean r100) {
        this.V = r100;
    }

    public final void setCenterWeight(String r100) {
        if (r100.contains(CommodityText.BOLD) == false) goto L6;
        this.f250321k.setFakeBoldText(true);
        return;
    }

    public final void setCurrentIndex(int r100) {
        this.H = r100;
        this.G = r100;
        this.F = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r100) {
        this.B = r100;
    }

    public void setDividerColor(int r100) {
        this.f250336y = r100;
        this.f250323l.setColor(r100);
    }

    public void setDividerType(DividerType r100) {
        this.f250311a = r100;
    }

    public void setDividerWidth(int r100) {
        this.f250337z = r100;
        this.f250323l.setStrokeWidth(r100);
    }

    public void setGravity(int r100) {
        this.R = r100;
    }

    public void setIsOptions(boolean r100) {
        this.f250316f = r100;
    }

    public void setItemsVisibleCount(int r100) {
        if ((r100 % 2) != 0) goto L5;
        r100 = r100 + 1;
    L5:
        int r101 = r100 + 2;
        if (this.f250310J == r101) goto L9;
        this.f250310J = r101;
        d();
        invalidate();
        return;
    }

    public void setLabel(String r100) {
        this.f250326o = r100;
    }

    public void setLineSpacingMultiplier(float r100) {
        if (r100 == 0.0f) goto L11;
        this.A = r100;
        if (r100 >= 1.0f) goto L8;
        this.A = 1.0f;
        return;
    L8:
        if (r100 <= 4.0f) goto L13;
        this.A = 4.0f;
        return;
    L13:
        return;
    }

    public void setLocalizeAdapter(a r100) {
        this.W = r100;
    }

    public void setMaskColor(int r100) {
        if (this.f250324m != null) goto L5;
        this.f250324m = new Paint();
    L5:
        this.f250324m.setColor(r100);
    }

    public final void setOnItemSelectedListener(k86.b r100) {
        this.f250315e = r100;
    }

    public void setTextColorCenter(int r100) {
        this.f250335x = r100;
        this.f250321k.setColor(r100);
    }

    public void setTextColorOut(int r100) {
        this.f250334w = r100;
        this.f250320j.setColor(r100);
    }

    public final void setTextSize(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = this.f250312b.getResources();
        int r102 = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        this.f250327p = r102;
        this.f250320j.setTextSize(r102);
        this.f250321k.setTextSize(this.f250327p);
        return;
    }

    public final void setTextSizePx(int r100) {
        if (r100 <= 0.0f) goto L6;
        this.f250327p = r100;
        this.f250320j.setTextSize(r100);
        this.f250321k.setTextSize(this.f250327p);
        return;
    }

    public void setTextXOffset(int r100) {
        this.f250330s = r100;
        if (r100 == 0) goto L6;
        this.f250321k.setTextScaleX(1.0f);
        return;
    }

    public void setTotalScrollY(float r100) {
        this.F = r100;
    }

    public final void setTypeface(Typeface r100) {
        this.f250333v = r100;
        this.f250320j.setTypeface(r100);
        this.f250321k.setTypeface(this.f250333v);
    }

    public void setUserItemHeight(int r100) {
        this.f250332u = r100;
    }

    public WheelView(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.f250316f = false;
        this.f250317g = true;
        this.f250318h = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("iew/WheelView"));
        this.f250333v = Typeface.MONOSPACE;
        this.A = 1.6f;
        this.f250310J = 0;
        this.N = 0;
        this.O = 0.0f;
        this.P = 0;
        this.R = 17;
        this.S = 0;
        this.T = 0;
        this.V = false;
        this.f250322k0 = new Handler(Looper.getMainLooper());
        this.f250327p = getResources().getDimensionPixelSize(R.dimen.lynx_pickerview_textsize);
        Resources r100 = getResources();
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        if (r101 >= 1.0f) goto L6;
        this.U = 2.4f;
    L19:
        if (r111 == null) goto L21;
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.lynx_wheelview_dividerColor, R.attr.lynx_wheelview_dividerWidth, R.attr.lynx_wheelview_gravity, R.attr.lynx_wheelview_lineSpacingMultiplier, R.attr.lynx_wheelview_textColorCenter, R.attr.lynx_wheelview_textColorOut, R.attr.lynx_wheelview_textSize}, 0, 0);
        this.R = r112.getInt(2, 17);
        this.f250334w = r112.getColor(5, -16777216);
        this.f250335x = r112.getColor(4, -16777216);
        this.f250336y = r112.getColor(0, -16777216);
        this.f250337z = r112.getDimensionPixelSize(1, 2);
        this.f250327p = r112.getDimensionPixelOffset(6, this.f250327p);
        this.A = r112.getFloat(3, this.A);
        r112.recycle();
    L22:
        float r113 = this.A;
        if (r113 >= 1.0f) goto L26;
        this.A = 1.0f;
    L28:
        this.f250312b = r110;
        this.f250313c = new b(this);
        GestureDetector r114 = new GestureDetector(r110, new k86.a(this), new Handler(Looper.getMainLooper()));
        this.f250314d = r114;
        r114.setIsLongpressEnabled(false);
        this.B = true;
        this.F = 0.0f;
        this.G = -1;
        Paint r115 = new Paint();
        this.f250320j = r115;
        r115.setColor(this.f250334w);
        this.f250320j.setAntiAlias(true);
        this.f250320j.setTypeface(this.f250333v);
        this.f250320j.setTextSize(this.f250327p);
        Paint r116 = new Paint();
        this.f250321k = r116;
        r116.setColor(this.f250335x);
        this.f250321k.setAntiAlias(true);
        this.f250321k.setTextScaleX(1.1f);
        this.f250321k.setTypeface(this.f250333v);
        this.f250321k.setTextSize(this.f250327p);
        Paint r117 = new Paint();
        this.f250323l = r117;
        r117.setColor(this.f250336y);
        this.f250323l.setAntiAlias(true);
        Paint r118 = new Paint();
        this.f250324m = r118;
        r118.setColor(Integer.MAX_VALUE);
        setLayerType(1, null);
        return;
    L26:
        if (r113 <= 4.0f) goto L28;
        this.A = 4.0f;
        goto L28
    L21:
        this.R = 17;
        this.f250334w = -16777216;
        this.f250335x = -16777216;
        this.f250336y = -16777216;
        this.f250337z = 2;
        this.f250332u = r110.getResources().getDimension(R.dimen.lynx_pickerview_default_itemheight);
        goto L22
    L6:
        if (1.0f > r101) goto L11;
        if (r101 >= 2.0f) goto L11;
        this.U = 4.0f;
    L11:
        if (2.0f > r101) goto L16;
        if (r101 >= 3.0f) goto L16;
        this.U = 6.0f;
    L16:
        if (r101 < 3.0f) goto L19;
        this.U = r101 * 2.5f;
        goto L19
    }

    public final void e(float r100, float r101) {
        int r102 = this.f250330s;
        int r103 = -1;
        if (r102 <= 0) goto L5;
        int r104 = 1;
    L8:
        Paint r105 = this.f250320j;
        if (r101 > 0.0f) goto L12;
        r103 = 1;
    L12:
        r105.setTextSkewX(((r104 * r103) * 0.5f) * r100);
        if (this.V == false) goto L15;
        int r106 = (int) (((90.0f - Math.abs(r101)) / 90.0f) * 255.0f);
    L16:
        this.f250320j.setAlpha(r106);
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
        this.Q = r100;
        d();
        setMeasuredDimension(this.L, this.K);
    }
}
