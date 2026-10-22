package com.ss.android.lark.custom.repeat.widget.wheelview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import h18.e;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import oab.f;
import sab.b;

/* JADX INFO: loaded from: classes35.dex */
public class WheelView extends View {
    public int A;
    public int B;
    public long C;
    public int D;
    public DividerType E;
    public GestureDetector F;
    public boolean G;
    public final boolean H;
    public ScheduledFuture<?> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f420359J;
    public int K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public final float R;
    public boolean S;
    public final Float T;
    public Object[] U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f420360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f420361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f420362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f420363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f420364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f420365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f420366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mab.a f420367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f420368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f420369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f420370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f420371l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Typeface f420372m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f420373n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f420374o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f420375p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f420376q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f420377r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f420378s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f420379t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f420380u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f420381v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f420382w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f420383x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f420384y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f420385z;

    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ACTION[] f420386a = null;

        static {
            ACTION r100 = new ACTION("CLICK", 0);
            CLICK = r100;
            ACTION r101 = new ACTION("FLING", 1);
            FLING = r101;
            ACTION r102 = new ACTION("DAGGLE", 2);
            DAGGLE = r102;
            f420386a = new ACTION[]{r100, r101, r102};
        }

        public static ACTION[] values() {
            return (ACTION[]) f420386a.clone();
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
        public static final DividerType NONE = null;
        public static final DividerType WRAP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DividerType[] f420387a = null;

        static {
            DividerType r100 = new DividerType("FILL", 0);
            FILL = r100;
            DividerType r101 = new DividerType("WRAP", 1);
            WRAP = r101;
            DividerType r102 = new DividerType(UserProfileEvent.POSITION_NONE, 2);
            NONE = r102;
            f420387a = new DividerType[]{r100, r101, r102};
        }

        public static DividerType[] values() {
            return (DividerType[]) f420387a.clone();
        }

        public static DividerType valueOf(String r100) {
            return (DividerType) r27.a.a(DividerType.class, r100);
        }

        public DividerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        ScheduledFuture<?> r100 = this.I;     // Catch: Throwable -> L10
        if (r100 != null) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r100.isCancelled() == true) goto L8;
        this.I.cancel(true);     // Catch: Throwable -> L10
        this.I = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setLoopChangeListener(tab.a r100) {
    }

    public int getItemsCount() {
        mab.a r100 = this.f420367h;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getItemsCount();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public final mab.a getAdapter() {
        return this.f420367h;
    }

    public final int getCurrentItem() {
        return this.L;
    }

    public WheelView(Context r100) {
        this(r100, null);
    }

    public final String b(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof uab.a) == false) goto L10;
        return ((uab.a) r100).a();
    L10:
        if ((r100 instanceof Integer) == false) goto L16;
        if (this.S == false) goto L16;
        return String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(((Integer) r100).intValue())});
    L16:
        return r100.toString();
    }

    public final int c(int r100) {
        if (this.f420367h.getItemsCount() > 0) goto L6;
        return 0;
    L6:
        if (r100 >= 0) goto L9;
        return c(r100 + this.f420367h.getItemsCount());
    L9:
        if (r100 > (this.f420367h.getItemsCount() - 1)) goto L11;
        return r100;
    L11:
        return c(r100 - this.f420367h.getItemsCount());
    }

    public final void d(ACTION r100) {
        a();
        if (r100 != ACTION.FLING) goto L5;
    L6:
        float r101 = this.f420381v;
        float r102 = this.f420371l;
        int r103 = (int) (((r101 % r102) + r102) % r102);
        this.M = r103;
        if (r103 <= (r102 / 2.0f)) goto L9;
        this.M = (int) (r102 - r103);
    L10:
        this.I = this.f420363d.scheduleWithFixedDelay(new b(this, this.M), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        this.M = -r103;
        goto L10
    L5:
        if (r100 != ACTION.DAGGLE) goto L10;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        mab.a r100 = this.f420367h;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
        if (this.f420382w >= 0) goto L9;
        this.f420382w = 0;
    L9:
        if (this.f420382w < r100.getItemsCount()) goto L11;
        this.f420382w = this.f420367h.getItemsCount() - 1;
    L11:
        Object[] r111 = this.U;
        this.f420383x = this.f420382w + (((int) (this.f420381v / this.f420371l)) % this.f420367h.getItemsCount());     // Catch: ArithmeticException -> L14
    L15:
        float r102 = this.f420381v % this.f420371l;
        if (Math.abs(r102) > (this.f420371l - 10.0f)) goto L18;
        float r112 = r102;
    L24:
        if (this.f420377r == true) goto L32;
        if (this.f420383x >= 0) goto L29;
        this.f420383x = 0;
    L29:
        if (this.f420383x <= (this.f420367h.getItemsCount() - 1)) goto L37;
        this.f420383x = this.f420367h.getItemsCount() - 1;
    L37:
        int r103 = 0;
    L38:
        int r104 = this.f420384y;
        if (r103 >= r104) goto L50;
        int r105 = this.f420383x - ((r104 / 2) - r103);
        if (this.f420377r == false) goto L43;
        r111[r103] = this.f420367h.getItem(c(r105));
    L49:
        r103 = r103 + 1;
        goto L38
    L43:
        if (r105 >= 0) goto L46;
        r111[r103] = "";
        goto L49
    L46:
        if (r105 <= (this.f420367h.getItemsCount() - 1)) goto L48;
        r111[r103] = "";
        goto L49
    L48:
        r111[r103] = this.f420367h.getItem(r105);
        goto L49
    L50:
        DividerType r106 = this.E;
        if (r106 != DividerType.WRAP) goto L62;
        if (TextUtils.isEmpty(this.f420359J) == false) goto L55;
        int r107 = (this.A - this.f420369j) / 2;
    L56:
        float r108 = r107 - 12;
        if (r108 > 0.0f) goto L59;
        float r113 = 10.0f;
    L60:
        float r114 = this.A - r113;
        float r109 = this.f420378s;
        float r115 = r113;
        r110.drawLine(r115, r109, r114, r109, this.f420366g);
        float r116 = this.f420379t;
        r110.drawLine(r115, r116, r114, r116, this.f420366g);
    L65:
        if (TextUtils.isEmpty(this.f420359J) == false) goto L67;
    L77:
        int r117 = 0;
    L79:
        if (r117 >= this.f420384y) goto L170;
        r110.save();
        double r118 = ((this.f420371l * r117) - r112) / this.B;
        float r119 = (float) (90.0d - ((r118 / 3.141592653589793d) * 180.0d));
        if (r119 < 90.0f) goto L83;
    L168:
        r110.restore();
    L169:
        r117 = r117 + 1;
        r112 = r112;
        goto L79
    L83:
        if (r119 <= (-90.0f)) goto L168;
        float r120 = (float) Math.pow(Math.abs(r119) / 90.0f, 2.2d);
        if (this.H == false) goto L88;
    L92:
        String r121 = b(r111[r117]);
    L93:
        Rect r122 = new Rect();
        this.f420365f.getTextBounds(r121, r101, r121.length(), r122);
        int r123 = r122.width();
        int r124 = this.f420368i;
    L95:
        if (r123 <= this.A) goto L97;
        r124 = r124 - 1;
        this.f420365f.setTextSize(r124);
        this.f420365f.getTextBounds(r121, r101, r121.length(), r122);
        r123 = r122.width();
        goto L95
    L97:
        this.f420364e.setTextSize(r124);
        Rect r125 = new Rect();
        this.f420365f.getTextBounds(r121, r101, r121.length(), r125);
        int r126 = this.O;
        if (r126 == 3) goto L115;
        if (r126 == 5) goto L113;
        if (r126 == 17) goto L103;
    L114:
        int r127 = 0;
    L116:
        Rect r128 = new Rect();
        this.f420364e.getTextBounds(r121, r127, r121.length(), r128);
        int r129 = this.O;
        if (r129 != 3) goto L119;
        this.Q = 0;
    L136:
        float r130 = (float) (((((double) this.B) - (Math.cos(r118) * ((double) this.B))) - ((Math.sin(r118) * ((double) this.f420370k)) / 2.0d)) + ((Math.sin(r118) - 1.0d) * ((double) this.f420370k)));
        r110.translate(0.0f, r130);
        float r131 = this.f420378s;
        if (r130 <= r131) goto L139;
    L143:
        float r132 = this.f420379t;
        if (r130 > r132) goto L151;
        if ((this.f420370k + r130) < r132) goto L151;
        r110.save();
        r110.clipRect(0.0f, 0.0f, this.A, this.f420379t - r130);
        r110.drawText(r121, this.P, this.f420370k - this.R, this.f420365f);
        r110.restore();
        r110.save();
        r110.clipRect(0.0f, this.f420379t - r130, this.A, (int) this.f420371l);
        r110.drawText(r121, this.Q, this.f420370k, this.f420364e);
        r110.restore();
        float r133 = this.f420379t;
        if ((r133 - r130) <= ((r130 + this.f420370k) - r133)) goto L155;
        this.L = this.f420367h.indexOf(r111[r117]);
    L155:
        r101 = 0;
    L167:
        r110.restore();
        this.f420365f.setTextSize(this.f420368i);
    L151:
        if (r130 >= r131) goto L153;
    L156:
        r110.save();
        r101 = 0;
        r110.clipRect(0, 0, this.A, (int) this.f420371l);
        Paint r134 = this.f420364e;
        int r135 = this.K;
        int r136 = -1;
        if (r135 != 0) goto L159;
        int r137 = 0;
    L163:
        if (r119 > 0.0f) goto L166;
        r136 = 1;
    L166:
        r134.setTextSkewX(((r137 * r136) * 0.5f) * r120);
        this.f420364e.setAlpha((int) ((1.0f - r120) * 255.0f));
        r110.drawText(r121, this.Q + (this.K * r120), this.f420370k, this.f420364e);
        r110.restore();
        goto L167
    L159:
        if (r135 <= 0) goto L161;
        r137 = 1;
        goto L163
    L161:
        r137 = -1;
        goto L163
    L153:
        if ((this.f420370k + r130) > r132) goto L156;
        r110.scale(1.0f, 1.176f);
        r110.drawText(r121, this.P, (this.f420370k * 0.916f) - this.R, this.f420365f);
        this.L = this.f420367h.indexOf(r111[r117]);
        goto L155
    L139:
        if ((this.f420370k + r130) < r131) goto L143;
        r110.save();
        r110.clipRect(0.0f, 0.0f, this.A, this.f420378s - r130);
        r110.drawText(r121, this.Q, this.f420370k, this.f420364e);
        r110.restore();
        r110.save();
        r110.clipRect(0.0f, this.f420378s - r130, this.A, (int) this.f420371l);
        r110.drawText(r121, this.P, this.f420370k - this.R, this.f420365f);
        r110.restore();
        float r138 = this.f420378s;
        if ((r138 - r130) >= ((r130 + this.f420370k) - r138)) goto L155;
        this.L = this.f420367h.indexOf(r111[r117]);
        goto L155
    L119:
        if (r129 != 5) goto L121;
        this.Q = (this.A - r128.width()) - ((int) this.R);
        goto L136
    L121:
        if (r129 != 17) goto L136;
        if (this.G == true) goto L133;
        String r139 = this.f420359J;
        if (r139 == null) goto L133;
        if (r139.equals("") == true) goto L133;
        if (this.H == false) goto L133;
        this.Q = (int) ((this.A - r128.width()) * 0.25f);
    L133:
        this.Q = (int) ((this.A - r128.width()) * 0.5f);
        goto L136
    L103:
        if (this.G == true) goto L112;
        String r140 = this.f420359J;
        if (r140 == null) goto L112;
        if (r140.equals("") == true) goto L112;
        if (this.H == false) goto L112;
        this.P = (int) ((this.A - r125.width()) * 0.25f);
    L112:
        this.P = (int) ((this.A - r125.width()) * 0.5f);
        goto L114
    L113:
        this.P = (this.A - r125.width()) - ((int) this.R);
        goto L114
    L115:
        r127 = 0;
        this.P = 0;
        goto L116
    L88:
        if (TextUtils.isEmpty(this.f420359J) == true) goto L92;
        if (TextUtils.isEmpty(b(r111[r117])) == true) goto L92;
        r121 = b(r111[r117]) + this.f420359J;
        goto L93
    L170:
        return;
    L67:
        if (this.H == false) goto L77;
        int r141 = this.A;
        Paint r142 = this.f420365f;
        String r143 = this.f420359J;
        if (r143 != null) goto L71;
    L75:
        int r144 = 0;
    L76:
        r110.drawText(this.f420359J, (r141 - r144) - this.R, this.f420380u, this.f420365f);
        goto L77
    L71:
        if (r143.length() <= 0) goto L75;
        int r145 = r143.length();
        float[] r146 = new float[r145];
        r142.getTextWidths(r143, r146);
        int r147 = 0;
        r144 = 0;
    L73:
        if (r147 >= r145) goto L76;
        r144 = r144 + ((int) Math.ceil(r146[r147]));
        r147 = r147 + 1;
        goto L73
    L59:
        r113 = r108;
        goto L60
    L55:
        r107 = (this.A - this.f420369j) / 4;
        goto L56
    L62:
        if (r106 != DividerType.FILL) goto L65;
        float r148 = this.f420378s;
        r110.drawLine(0.0f, r148, this.A, r148, this.f420366g);
        float r149 = this.f420379t;
        r110.drawLine(0.0f, r149, this.A, r149, this.f420366g);
        goto L65
    L32:
        if (this.f420383x >= 0) goto L35;
        this.f420383x = this.f420367h.getItemsCount() + this.f420383x;
    L35:
        if (this.f420383x <= (this.f420367h.getItemsCount() - 1)) goto L37;
        this.f420383x -= this.f420367h.getItemsCount();
        goto L37
    L18:
        if (r102 <= 0.0f) goto L20;
        this.f420383x++;
    L21:
        r112 = 0.0f;
        goto L24
    L20:
        this.f420383x--;
    L14:
        Log.e("WheelView", "adapter.getItemsCount == 0");
        goto L15
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r110) {
        boolean r100 = this.F.onTouchEvent(r110);
        if (r110.isFromSource(2) == true) goto L5;
    L23:
        invalidate();
        return super.onGenericMotionEvent(r110);
    L5:
        if (r110.getAction() != 8) goto L23;
        float r101 = (-r110.getAxisValue(9)) * this.T.floatValue();
        this.f420381v += r101;
        if (this.f420377r == true) goto L20;
        float r102 = (-this.f420382w) * this.f420371l;
        float r103 = (this.f420367h.getItemsCount() - 1) - this.f420382w;
        float r104 = this.f420371l;
        float r105 = r103 * r104;
        float r106 = this.f420381v;
        if ((r106 - (r104 * 0.25f)) >= r102) goto L12;
        r102 = r106 - r101;
    L15:
        if (r106 >= r102) goto L18;
        this.f420381v = (int) r102;
        goto L20
    L18:
        if (r106 <= r105) goto L20;
        this.f420381v = (int) r105;
        goto L20
    L12:
        if (((r104 * 0.25f) + r106) <= r105) goto L15;
        r105 = r106 - r101;
    L20:
        if (r100 == true) goto L23;
        float r111 = r110.getY();
        int r107 = this.B;
        double r108 = Math.acos((r107 - r111) / r107) * ((double) this.B);
        float r112 = this.f420371l;
        int r109 = (int) ((r108 + ((double) (r112 / 2.0f))) / ((double) r112));
        this.M = (int) (((r109 - (this.f420384y / 2)) * r112) - (((this.f420381v % r112) + r112) % r112));
        d(ACTION.DAGGLE);
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = this.F.onTouchEvent(r100);
        int r102 = r100.getAction();
        if (r102 != 0) goto L5;
        this.C = System.currentTimeMillis();
        a();
        this.N = r100.getRawY();
    L26:
        invalidate();
        if (getParent() == null) goto L29;
        getParent().requestDisallowInterceptTouchEvent(true);
    L29:
        return true;
    L5:
        if (r102 == 2) goto L11;
        if (r101 == true) goto L26;
        float r103 = r100.getY();
        int r104 = this.B;
        double r105 = Math.acos((r104 - r103) / r104) * ((double) this.B);
        float r106 = this.f420371l;
        this.M = (int) (((((int) ((r105 + ((double) (r106 / 2.0f))) / ((double) r106))) - (this.f420384y / 2)) * r106) - (((this.f420381v % r106) + r106) % r106));
        if ((System.currentTimeMillis() - this.C) <= 120) goto L10;
        d(ACTION.DAGGLE);
        goto L26
    L10:
        d(ACTION.CLICK);
        goto L26
    L11:
        float r107 = this.N - r100.getRawY();
        this.N = r100.getRawY();
        this.f420381v += r107;
        if (this.f420377r == true) goto L26;
        float r108 = (-this.f420382w) * this.f420371l;
        float r109 = (this.f420367h.getItemsCount() - 1) - this.f420382w;
        float r110 = this.f420371l;
        float r111 = r109 * r110;
        float r112 = this.f420381v;
        if ((r112 - (r110 * 0.25f)) >= r108) goto L17;
        r108 = r112 - r107;
    L20:
        if (r112 >= r108) goto L23;
        this.f420381v = (int) r108;
        goto L26
    L23:
        if (r112 <= r111) goto L26;
        this.f420381v = (int) r111;
        goto L26
    L17:
        if (((r110 * 0.25f) + r112) <= r111) goto L20;
        r111 = r112 - r107;
        goto L20
    }

    public final void setAdapter(mab.a r100) {
        this.f420367h = r100;
        invalidate();
    }

    public final void setCurrentItem(int r100) {
        this.L = r100;
        this.f420382w = r100;
        this.f420381v = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r100) {
        this.f420377r = r100;
    }

    public void setDividerColor(int r100) {
        if (r100 == 0) goto L5;
        this.f420375p = r100;
        this.f420366g.setColor(r100);
        return;
    }

    public void setDividerType(DividerType r100) {
        this.E = r100;
    }

    public void setGravity(int r100) {
        this.O = r100;
    }

    public void setIsOptions(boolean r100) {
        this.G = r100;
    }

    public void setItemVisible(int r100) {
        if (r100 == this.f420384y) goto L5;
        this.U = new Object[r100];
    L5:
        this.f420384y = r100;
    }

    public void setLabel(String r100) {
        this.f420359J = r100;
    }

    public void setLineSpacingMultiplier(float r100) {
        if (r100 == 0.0f) goto L11;
        this.f420376q = r100;
        if (r100 >= 1.0f) goto L8;
        this.f420376q = 1.0f;
        return;
    L8:
        if (r100 <= 4.0f) goto L13;
        this.f420376q = 4.0f;
        return;
    L13:
        return;
    }

    public final void setOnItemSelectedListener(f r100) {
        this.f420362c = r100;
    }

    public void setShowTwoFigure(boolean r100) {
        this.S = r100;
    }

    public void setTextColorCenter(int r100) {
        if (r100 == 0) goto L5;
        this.f420374o = r100;
        this.f420365f.setColor(r100);
        return;
    }

    public void setTextColorOut(int r100) {
        if (r100 == 0) goto L5;
        this.f420373n = r100;
        this.f420364e.setColor(r100);
        return;
    }

    public final void setTextSize(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = this.f420360a.getResources();
        int r102 = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        this.f420368i = r102;
        this.f420364e.setTextSize(r102);
        this.f420365f.setTextSize(this.f420368i);
        return;
    }

    public void setTextXOffset(int r100) {
        this.K = r100;
        if (r100 == 0) goto L6;
        this.f420365f.setTextScaleX(1.0f);
        return;
    }

    public final void setTypeface(Typeface r100) {
        this.f420372m = r100;
        this.f420364e.setTypeface(r100);
        this.f420365f.setTypeface(this.f420372m);
    }

    public WheelView(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.f420363d = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("iew/WheelView"));
        this.f420373n = -5723992;
        this.f420374o = -14013910;
        this.f420375p = -2763307;
        this.f420376q = 2.5f;
        this.f420384y = 5;
        this.C = 0;
        this.G = false;
        this.H = true;
        this.M = 0;
        this.N = 0.0f;
        this.O = 17;
        this.P = 0;
        this.Q = 0;
        this.U = new Object[5];
        this.T = Float.valueOf(ViewConfigurationCompat.getScaledVerticalScrollFactor(ViewConfiguration.get(r110), r110));
        this.f420368i = (int) getResources().getDimension(R.dimen.sp_17);
        this.f420374o = r110.getResources().getColor(R.color.text_title);
        this.f420372m = e.a(r110);
        Resources r100 = getResources();
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        if (r101 >= 1.0f) goto L6;
        this.R = 2.4f;
    L22:
        if (r111 == null) goto L24;
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.pickerview_dividerColor, R.attr.pickerview_gravity, R.attr.pickerview_lineSpacingMultiplier, R.attr.pickerview_textColorCenter, R.attr.pickerview_textColorOut, R.attr.pickerview_textSize}, 0, 0);
        this.O = r112.getInt(1, 17);
        this.f420373n = r112.getColor(4, this.f420373n);
        this.f420374o = r112.getColor(3, this.f420374o);
        this.f420375p = r112.getColor(0, this.f420375p);
        this.f420368i = r112.getDimensionPixelOffset(5, this.f420368i);
        this.f420376q = r112.getFloat(2, this.f420376q);
        r112.recycle();
    L24:
        float r113 = this.f420376q;
        if (r113 >= 1.0f) goto L28;
        this.f420376q = 1.0f;
    L30:
        this.f420360a = r110;
        this.f420361b = new a(this);
        GestureDetector r114 = new GestureDetector(r110, new tab.b(this));
        this.F = r114;
        r114.setIsLongpressEnabled(false);
        this.f420377r = true;
        this.f420381v = 0.0f;
        this.f420382w = -1;
        Paint r115 = new Paint();
        this.f420364e = r115;
        r115.setColor(this.f420373n);
        this.f420364e.setAntiAlias(true);
        this.f420364e.setTypeface(this.f420372m);
        this.f420364e.setTextSize(this.f420368i);
        Paint r116 = new Paint();
        this.f420365f = r116;
        r116.setColor(this.f420374o);
        this.f420365f.setAntiAlias(true);
        this.f420365f.setTextScaleX(1.176f);
        this.f420365f.setTypeface(this.f420372m);
        this.f420365f.setTextSize(this.f420368i * 1.176f);
        Paint r117 = new Paint();
        this.f420366g = r117;
        r117.setColor(this.f420375p);
        this.f420366g.setAntiAlias(true);
        setLayerType(1, null);
        return;
    L28:
        if (r113 <= 4.0f) goto L30;
        this.f420376q = 4.0f;
        goto L30
    L6:
        if (1.0f <= r101) goto L8;
    L10:
        if (1.0f > r101) goto L15;
        if (r101 >= 2.0f) goto L15;
        this.R = 4.5f;
    L15:
        if (2.0f > r101) goto L20;
        if (r101 >= 3.0f) goto L20;
        this.R = 6.0f;
    L20:
        if (r101 < 3.0f) goto L22;
        this.R = r101 * 2.5f;
        goto L22
    L8:
        if (r101 >= 2.0f) goto L10;
        this.R = 3.6f;
        goto L22
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        this.D = r100;
        if (this.f420367h == null) goto L22;
        this.f420365f.setTextScaleX(1.176f);
        this.f420365f.setTextSize(this.f420368i * 1.176f);
        Rect r102 = new Rect();
        if (TextUtils.isEmpty(this.f420367h.a()) == true) goto L8;
        this.f420365f.getTextBounds(this.f420367h.a(), 0, this.f420367h.a().length(), r102);
        this.f420369j = r102.width();
    L15:
        this.f420365f.getTextBounds("星期", 0, 2, r102);
        int r103 = r102.height() + 2;
        this.f420370k = r103;
        float r104 = this.f420376q * r103;
        this.f420371l = r104;
        int r105 = (int) (r104 * (this.f420384y - 1));
        this.f420385z = (int) (((double) (r105 * 2)) / 3.141592653589793d);
        this.B = (int) (((double) r105) / 3.141592653589793d);
        this.A = View.MeasureSpec.getSize(this.D);
        float r106 = this.f420385z;
        float r107 = this.f420371l;
        this.f420378s = (r106 - r107) / 2.0f;
        float r108 = (r106 + r107) / 2.0f;
        this.f420379t = r108;
        this.f420380u = (r108 - ((r107 - this.f420370k) / 2.0f)) - this.R;
        if (this.f420382w != (-1)) goto L22;
        if (this.f420377r == false) goto L20;
        this.f420382w = (this.f420367h.getItemsCount() + 1) / 2;
    L21:
        this.f420383x = this.f420382w;
        goto L22
    L20:
        this.f420382w = 0;
        goto L21
    L8:
        int r109 = 0;
    L10:
        if (r109 >= this.f420367h.getItemsCount()) goto L15;
        String r110 = b(this.f420367h.getItem(r109));
        this.f420365f.getTextBounds(r110, 0, r110.length(), r102);
        int r111 = r102.width();
        if (r111 <= this.f420369j) goto L14;
        this.f420369j = r111;
    L14:
        r109 = r109 + 1;
    L22:
        setMeasuredDimension(this.A, this.f420385z);
    }
}
