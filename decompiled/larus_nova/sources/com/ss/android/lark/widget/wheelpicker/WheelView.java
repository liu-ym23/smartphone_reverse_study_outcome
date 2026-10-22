package com.ss.android.lark.widget.wheelpicker;

import afc.b;
import afc.c;
import afc.d;
import afc.e;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes38.dex */
public class WheelView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f449089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f449090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f449091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f449092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f449093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f449094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f449095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Typeface f449096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f449097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f449098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f449099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f449100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f449101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f449102n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f449103o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f449104p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f449105q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public GestureDetector f449106r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ScheduledFuture<?> f449107s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f449108t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f449109u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f449110v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object[] f449111w;

    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ACTION[] f449112a = null;

        static {
            ACTION r100 = new ACTION("CLICK", 0);
            CLICK = r100;
            ACTION r101 = new ACTION("FLING", 1);
            FLING = r101;
            ACTION r102 = new ACTION("DAGGLE", 2);
            DAGGLE = r102;
            f449112a = new ACTION[]{r100, r101, r102};
        }

        public static ACTION[] values() {
            return (ACTION[]) f449112a.clone();
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
        public static final /* synthetic */ DividerType[] f449113a = null;

        static {
            DividerType r100 = new DividerType("FILL", 0);
            FILL = r100;
            DividerType r101 = new DividerType("WRAP", 1);
            WRAP = r101;
            f449113a = new DividerType[]{r100, r101};
        }

        public static DividerType[] values() {
            return (DividerType[]) f449113a.clone();
        }

        public static DividerType valueOf(String r100) {
            return (DividerType) r27.a.a(DividerType.class, r100);
        }

        public DividerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final e getAdapter() {
        return null;
    }

    public int getItemsCount() {
        return 0;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
    }

    public void setDividerType(DividerType r100) {
    }

    public void setGravity(int r100) {
    }

    public void setIsOptions(boolean r100) {
    }

    public void setLabel(String r100) {
    }

    public final void setOnItemSelectedListener(c r100) {
    }

    public final void a() {
        ScheduledFuture<?> r100 = this.f449107s;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCancelled() == true) goto L9;
        this.f449107s.cancel(true);
        this.f449107s = null;
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public final int getCurrentItem() {
        return this.f449108t;
    }

    public WheelView(Context r100) {
        this(r100, null);
    }

    public final void b(ACTION r100) {
        a();
        if (r100 != ACTION.FLING) goto L5;
    L6:
        int r101 = (int) (((this.f449102n % 0.0f) + 0.0f) % 0.0f);
        this.f449109u = r101;
        if (r101 <= 0.0f) goto L9;
        this.f449109u = (int) (0.0f - r101);
    L10:
        this.f449107s = this.f449091c.scheduleWithFixedDelay(new d(this, this.f449109u), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        this.f449109u = -r101;
        goto L10
    L5:
        if (r100 != ACTION.DAGGLE) goto L10;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = this.f449106r.onTouchEvent(r100);
        int r102 = r100.getAction();
        if (r102 != 0) goto L5;
        this.f449105q = System.currentTimeMillis();
        a();
        this.f449110v = r100.getRawY();
    L17:
        invalidate();
        return true;
    L5:
        if (r102 == 2) goto L11;
        if (r101 == true) goto L17;
        float r103 = 0;
        int r104 = (int) (((Math.acos((r103 - r100.getY()) / r103) * ((double) 0)) + ((double) 0.0f)) / ((double) 0.0f));
        this.f449109u = (int) (((r104 - (this.f449104p / 2)) * 0.0f) - (((this.f449102n % 0.0f) + 0.0f) % 0.0f));
        if ((System.currentTimeMillis() - this.f449105q) <= 120) goto L10;
        b(ACTION.DAGGLE);
        goto L17
    L10:
        b(ACTION.CLICK);
        goto L17
    L11:
        float r105 = this.f449110v - r100.getRawY();
        this.f449110v = r100.getRawY();
        this.f449102n += r105;
        if (this.f449101m == true) goto L17;
        throw null;
    }

    public final void setAdapter(e r100) {
        invalidate();
    }

    public void setCurrentItem(int r100) {
        this.f449108t = r100;
        this.f449103o = r100;
        this.f449102n = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r100) {
        this.f449101m = r100;
    }

    public void setDividerColor(int r100) {
        this.f449099k = r100;
        this.f449094f.setColor(r100);
    }

    public void setItemVisible(int r100) {
        if (r100 == this.f449104p) goto L5;
        this.f449111w = new Object[r100];
    L5:
        this.f449104p = r100;
    }

    public void setLineSpacingMultiplier(float r100) {
        if (r100 == 0.0f) goto L11;
        this.f449100l = r100;
        if (r100 >= 1.2f) goto L8;
        this.f449100l = 1.2f;
        return;
    L8:
        if (r100 <= 2.0f) goto L13;
        this.f449100l = 2.0f;
        return;
    L13:
        return;
    }

    public void setTextColorCenter(int r100) {
        if (r100 == 0) goto L5;
        this.f449098j = r100;
        this.f449093e.setColor(r100);
        return;
    }

    public void setTextColorOut(int r100) {
        if (r100 == 0) goto L5;
        this.f449097i = r100;
        this.f449092d.setColor(r100);
        return;
    }

    public final void setTextSize(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = this.f449089a.getResources();
        int r102 = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        this.f449095g = r102;
        this.f449092d.setTextSize(r102);
        this.f449093e.setTextSize(this.f449095g);
        return;
    }

    public final void setTypeface(Typeface r100) {
        this.f449096h = r100;
        this.f449092d.setTypeface(r100);
        this.f449093e.setTypeface(this.f449096h);
    }

    public WheelView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449091c = CoreThreadPool.getDefault().getScheduleThreadPool();
        this.f449096h = Typeface.MONOSPACE;
        this.f449097i = -5723992;
        this.f449098j = -14013910;
        this.f449099k = -2763307;
        this.f449100l = 1.6f;
        this.f449104p = 11;
        this.f449105q = 0;
        this.f449109u = 0;
        this.f449110v = 0.0f;
        this.f449111w = new Object[11];
        this.f449095g = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        Resources r102 = getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        if (r103 < 1.0f) goto L18;
        if (1.0f <= r103) goto L8;
    L10:
        if (1.0f > r103) goto L15;
        if (r103 < 2.0f) goto L18;
    L15:
        if (2.0f > r103) goto L18;
        int r104 = (r103 > 3.0f ? 1 : (r103 == 3.0f ? 0 : -1));
        goto L18
    L8:
        if (r103 >= 2.0f) goto L10;
    L18:
        if (r101 == null) goto L20;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.pickerview_dividerColor, R.attr.pickerview_gravity, R.attr.pickerview_lineSpacingMultiplier, R.attr.pickerview_textColorCenter, R.attr.pickerview_textColorOut, R.attr.pickerview_textSize}, 0, 0);
        r105.getInt(1, 17);
        this.f449097i = r105.getColor(4, this.f449097i);
        this.f449098j = r105.getColor(3, this.f449098j);
        this.f449099k = r105.getColor(0, this.f449099k);
        this.f449095g = r105.getDimensionPixelOffset(5, this.f449095g);
        this.f449100l = r105.getFloat(2, this.f449100l);
        r105.recycle();
    L20:
        float r106 = this.f449100l;
        if (r106 >= 1.2f) goto L24;
        this.f449100l = 1.2f;
    L26:
        this.f449089a = r100;
        this.f449090b = new a(this);
        GestureDetector r107 = new GestureDetector(r100, new b(this));
        this.f449106r = r107;
        r107.setIsLongpressEnabled(false);
        this.f449101m = true;
        this.f449102n = 0.0f;
        this.f449103o = -1;
        Paint r108 = new Paint();
        this.f449092d = r108;
        r108.setColor(this.f449097i);
        this.f449092d.setAntiAlias(true);
        this.f449092d.setTextSize(this.f449095g);
        Paint r109 = new Paint();
        this.f449093e = r109;
        r109.setColor(this.f449098j);
        this.f449093e.setAntiAlias(true);
        this.f449093e.setTextScaleX(1.1f);
        this.f449093e.setTypeface(this.f449096h);
        this.f449093e.setTextSize(this.f449095g);
        Paint r110 = new Paint();
        this.f449094f = r110;
        r110.setColor(this.f449099k);
        this.f449094f.setAntiAlias(true);
        setLayerType(1, null);
        return;
    L24:
        if (r106 <= 2.0f) goto L26;
        this.f449100l = 2.0f;
        goto L26
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }
}
