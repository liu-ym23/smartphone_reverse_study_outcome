package mm3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends View {
    public static final /* synthetic */ int D = 0;
    public InterfaceC0146d A;
    public float B;
    public int C;
    public final int a;
    public final int b;
    public final TextPaint c;
    public final TextPaint d;
    public final Paint e;
    public final Paint f;
    public final Rect g;
    public final Rect h;
    public final Rect i;
    public LinearGradient j;
    public LinearGradient k;
    public int l;
    public int m;
    public Scroller n;
    public GestureDetector o;
    public final List<CharSequence> p;
    public final List<c> q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public final class b extends sm3.b {
        public final /* synthetic */ d a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return true;
        }

        public b(d r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r10, MotionEvent r11, float r12, float r13) {
            Intrinsics.checkNotNullParameter(r11, "e2");
            d r14 = this.a;
            r14.z = true;
            Scroller r0 = r14.n;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
        L5:
            Scroller r1 = this.a.n;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
        L8:
            r0.fling(r1.getCurrX(), (int) this.a.B, (int) r12, -((int) (((double) r13) / 1.7d)), 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r7, MotionEvent r8, float r9, float r10) {
            Intrinsics.checkNotNullParameter(r8, "e2");
            d r11 = this.a;
            r11.z = true;
            Scroller r0 = r11.n;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
        L5:
            Scroller r1 = this.a.n;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
        L8:
            r0.startScroll(r1.getCurrX(), (int) this.a.B, (int) r9, (int) r10, 0);
            this.a.invalidate();
            return true;
        }
    }

    public static final class c {
        public CharSequence a;
        public float b;

        public c() {
            this.a = "";
        }
    }

    /* JADX INFO: renamed from: mm3.d$d, reason: collision with other inner class name */
    public interface InterfaceC0146d {
        void a(int r1);
    }

    static {
    }

    private final int getDistanceNeedToMove() {
        float r0 = this.B;
        float r1 = this.t;
        float r2 = r0 % r1;
        if (r2 >= 0) goto L8;
        float r3 = Math.abs(r2);
        float r4 = this.t;
        if (r3 <= (r4 / 2)) goto L10;
        int r5 = (int) (r4 - Math.abs(r2));
    L12:
        return -r5;
    L10:
        r5 = (int) r2;
        goto L12
    L8:
        if (r2 <= (r1 / 2)) goto L10;
        return (int) (r1 - r2);
    }

    public final void b() {
        if (this.x == true) goto L5;
        return;
    L5:
        if (this.w == false) goto L17;
        int r0 = getDistanceNeedToMove();
        Scroller r1 = this.n;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("scroller");
    L9:
        Scroller r3 = this.n;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("scroller");
    L12:
        r1.startScroll(r3.getCurrX(), (int) this.B, 0, r0, this.b);
        invalidate();
        this.w = false;
        this.z = false;
        setSelectedIndex(MathKt.roundToInt(((this.B + r0) / this.t) + 2));
        InterfaceC0146d r2 = this.A;
        if (r2 == null) goto L18;
        r2.a(this.C);
        return;
    L18:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller r0 = this.n;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("scroller");
    L6:
        if (r0.computeScrollOffset() == false) goto L18;
        this.w = true;
        Scroller r1 = this.n;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("scroller");
    L10:
        float r2 = r1.getCurrY();
        float r3 = this.r;
        if (r2 >= r3) goto L13;
    L12:
        r2 = r3;
    L16:
        this.B = r2;
        setSelectedIndex(MathKt.roundToInt(((r2 + getDistanceNeedToMove()) / this.t) + 2));
        invalidate();
        return;
    L13:
        r3 = this.s;
        if (r2 <= r3) goto L16;
    L18:
        if (this.z == false) goto L22;
        b();
        return;
    }

    public final int getCurrentSelectedValue() {
        return this.C;
    }

    public final InterfaceC0146d getOnChangeListener() {
        return this.A;
    }

    private final void setSelectedIndex(int r2) {
        if (r2 >= 0) goto L4;
    L5:
        r2 = 0;
    L6:
        this.C = r2;
        return;
    L4:
        if (r2 < ((ArrayList) this.p).size()) goto L6;
        goto L5
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        super.onDraw(r18);
        if (((ArrayList) this.p).isEmpty() == false) goto L5;
        return;
    L5:
        int r1 = this.p.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r2 != this.C) goto L10;
        a(r2, r18, this.c);
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        a(r2, r18, this.d);
        goto L11
    L12:
        r18.drawLine(0.0f, this.u, getWidth(), this.u, this.f);
        r18.drawLine(0.0f, this.v, getWidth(), this.v, this.f);
        if (this.y == true) goto L15;
        Rect r3 = this.h;
        r3.left = 0;
        r3.right = getWidth();
        Rect r4 = this.h;
        r4.top = 0;
        r4.bottom = (int) (2 * this.t);
        Rect r5 = this.h;
        this.j = new LinearGradient(0.0f, r5.top, 0.0f, r5.bottom, this.l, this.m, Shader.TileMode.MIRROR);
        Rect r6 = this.i;
        r6.left = 0;
        r6.right = getWidth();
        Rect r7 = this.i;
        float r8 = this.t;
        r7.top = (int) (3 * r8);
        r7.bottom = (int) (5 * r8);
        Rect r9 = this.i;
        this.k = new LinearGradient(0.0f, r9.bottom, 0.0f, r9.top, this.l, this.m, Shader.TileMode.MIRROR);
        this.y = true;
    L15:
        this.e.setShader(this.j);
        r18.drawRect(this.h, this.e);
        this.e.setShader(this.k);
        r18.drawRect(this.i, this.e);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        boolean r1 = true;
        if (r3.getAction() == 1) goto L6;
        r1 = false;
    L6:
        this.x = r1;
        if (r1 == false) goto L9;
        b();
    L9:
        GestureDetector r0 = this.o;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L13:
        return r0.onTouchEvent(r3);
    }

    public final void setOnChangeListener(InterfaceC0146d r1) {
        this.A = r1;
    }

    public final void setSelectedValue(int r2) {
        setSelectedIndex(r2);
        this.B = (this.C - 2) * this.t;
    }

    public d(Context r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        this.a = 5;
        this.b = 100;
        TextPaint r9 = new TextPaint();
        this.c = r9;
        TextPaint r0 = new TextPaint();
        this.d = r0;
        Paint r1 = new Paint();
        this.e = r1;
        Paint r2 = new Paint();
        this.f = r2;
        this.g = new Rect();
        this.h = new Rect();
        this.i = new Rect();
        this.p = new ArrayList();
        this.q = new ArrayList();
        r9.setTextSize(getContext().getResources().getDimension(2131169475));
        r0.setTextSize(getContext().getResources().getDimension(2131169479));
        r2.setStrokeWidth(getContext().getResources().getDimension(2131169472));
        r9.setFlags(1);
        r0.setFlags(1);
        if (r8 == true) goto L5;
        r9.setColor(getContext().getResources().getColor(2131108403));
        r0.setColor(getContext().getResources().getColor(2131108405));
        r2.setColor(getContext().getResources().getColor(2131108362));
        r1.setColor(getContext().getResources().getColor(2131108376));
        this.l = getContext().getResources().getColor(2131108338);
        this.m = getContext().getResources().getColor(2131109150);
    L6:
        float r10 = getContext().getResources().getDimension(2131169473);
        this.t = r10;
        float r11 = 2 * r10;
        this.u = r11;
        this.v = r11 + r10;
        this.o = new GestureDetector(getContext(), new b(this));
        this.n = new Scroller(getContext(), new DecelerateInterpolator(0.604f));
        return;
    L5:
        r9.setColor(getContext().getResources().getColor(2131108414));
        r0.setColor(getContext().getResources().getColor(2131108418));
        r2.setColor(getContext().getResources().getColor(2131108354));
        r1.setColor(getContext().getResources().getColor(2131108376));
        this.l = getContext().getResources().getColor(2131108337);
        this.m = getContext().getResources().getColor(2131109150);
        goto L6
    }

    public final void c(List<? extends CharSequence> r5, int r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        ((ArrayList) this.p).clear();
        ((ArrayList) this.p).addAll(r5);
        int r0 = 0;
        if (r6 >= 0) goto L9;
    L10:
        r6 = 0;
    L11:
        setSelectedIndex(r6);
        ((ArrayList) this.q).clear();
        this.B = (this.C - 2) * this.t;
        int r7 = ((ArrayList) this.p).size();
    L12:
        if (r0 >= r7) goto L14;
        c r1 = new c();
        CharSequence r2 = (CharSequence) ListProtector.get(this.p, r0);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.a = r2;
        r0 = r0 + 1;
        r1.b = r0 * this.t;
        ((ArrayList) this.q).add(r1);
        goto L12
    L14:
        float r8 = ((ArrayList) this.p).size() - 3;
        float r3 = this.t;
        this.s = r8 * r3;
        this.r = (-2) * r3;
        invalidate();
        return;
    L9:
        if (r6 < r5.size()) goto L11;
        goto L10
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        setMeasuredDimension(r2, (int) (this.a * this.t));
    }

    public final void a(int r12, Canvas r13, TextPaint r14) {
        c r15 = (c) ListProtector.get(this.q, r12);
        float r0 = r15.b - this.B;
        int r1 = 0;
        if (r0 > 0) goto L5;
        return;
    L5:
        if ((r0 - this.t) >= getMeasuredHeight()) goto L26;
        CharSequence r4 = r15.a;
        r14.getTextBounds(r4.toString(), 0, r4.length(), this.g);
        int r16 = getMeasuredWidth() - this.g.width();
        if (r16 < 0) goto L12;
        r1 = r16;
    L12:
        if ((r4 instanceof String) == false) goto L15;
        r13.drawText((String) r4, r1 / 2, r0 - ((this.t - this.g.height()) / 2), r14);
        return;
    L15:
        if ((r4 instanceof SpannableString) == false) goto L25;
        r13.save();
        r13.translate(r1 / 2, (r0 - ((this.t - this.g.height()) / 2)) - this.g.height());
        new DynamicLayout(r4, r14, getWidth(), Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false).draw(r13);     // Catch: Exception -> L20
    L18:
        r13.restore();
        return;
    L25:
        return;
    }
}
