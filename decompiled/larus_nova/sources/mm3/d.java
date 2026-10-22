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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends View {
    public static final /* synthetic */ int D = 0;
    public InterfaceC6831d A;
    public float B;
    public int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f514433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f514434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextPaint f514435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f514436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f514437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f514438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f514439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f514440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f514441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearGradient f514442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearGradient f514443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f514444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f514445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Scroller f514446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GestureDetector f514447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<CharSequence> f514448p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<c> f514449q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f514450r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f514451s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f514452t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f514453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f514454v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f514455w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f514456x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f514457y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f514458z;

    public static final class a {
    }

    public final class b extends sm3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f514459a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return true;
        }

        public b(d r100) {
            this.f514459a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r110, MotionEvent r111, float r112, float r113) {
            Intrinsics.checkNotNullParameter(r111, "e2");
            d r114 = this.f514459a;
            r114.f514458z = true;
            Scroller r100 = r114.f514446n;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
        L5:
            Scroller r101 = this.f514459a.f514446n;
            if (r101 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
        L8:
            r100.fling(r101.getCurrX(), (int) this.f514459a.B, (int) r112, -((int) (((double) r113) / 1.7d)), 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r110) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            d r103 = this.f514459a;
            r103.f514458z = true;
            Scroller r104 = r103.f514446n;
            if (r104 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
        L5:
            Scroller r105 = this.f514459a.f514446n;
            if (r105 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
        L8:
            r104.startScroll(r105.getCurrX(), (int) this.f514459a.B, (int) r102, (int) r110, 0);
            this.f514459a.invalidate();
            return true;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f514460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f514461b;

        public c() {
            this.f514460a = "";
        }
    }

    /* JADX INFO: renamed from: mm3.d$d, reason: collision with other inner class name */
    public interface InterfaceC6831d {
        void a(int r100);
    }

    static {
    }

    private final int getDistanceNeedToMove() {
        float r100 = this.B;
        float r101 = this.f514452t;
        float r102 = r100 % r101;
        if (r102 >= 0) goto L8;
        float r103 = Math.abs(r102);
        float r104 = this.f514452t;
        if (r103 <= (r104 / 2)) goto L10;
        int r105 = (int) (r104 - Math.abs(r102));
    L12:
        return -r105;
    L10:
        r105 = (int) r102;
        goto L12
    L8:
        if (r102 <= (r101 / 2)) goto L10;
        return (int) (r101 - r102);
    }

    public final void b() {
        if (this.f514456x == true) goto L5;
        return;
    L5:
        if (this.f514455w == false) goto L17;
        int r100 = getDistanceNeedToMove();
        Scroller r101 = this.f514446n;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("scroller");
    L9:
        Scroller r102 = this.f514446n;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("scroller");
    L12:
        r101.startScroll(r102.getCurrX(), (int) this.B, 0, r100, this.f514434b);
        invalidate();
        this.f514455w = false;
        this.f514458z = false;
        setSelectedIndex(MathKt.roundToInt(((this.B + r100) / this.f514452t) + 2));
        InterfaceC6831d r103 = this.A;
        if (r103 == null) goto L18;
        r103.a(this.C);
        return;
    L18:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller r100 = this.f514446n;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("scroller");
    L6:
        if (r100.computeScrollOffset() == false) goto L18;
        this.f514455w = true;
        Scroller r101 = this.f514446n;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("scroller");
    L10:
        float r102 = r101.getCurrY();
        float r103 = this.f514450r;
        if (r102 >= r103) goto L13;
    L12:
        r102 = r103;
    L16:
        this.B = r102;
        setSelectedIndex(MathKt.roundToInt(((r102 + getDistanceNeedToMove()) / this.f514452t) + 2));
        invalidate();
        return;
    L13:
        r103 = this.f514451s;
        if (r102 <= r103) goto L16;
    L18:
        if (this.f514458z == false) goto L22;
        b();
        return;
    }

    public final int getCurrentSelectedValue() {
        return this.C;
    }

    public final InterfaceC6831d getOnChangeListener() {
        return this.A;
    }

    private final void setSelectedIndex(int r100) {
        if (r100 >= 0) goto L4;
    L5:
        r100 = 0;
    L6:
        this.C = r100;
        return;
    L4:
        if (r100 < ((ArrayList) this.f514448p).size()) goto L6;
        goto L5
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (((ArrayList) this.f514448p).isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = this.f514448p.size();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L12;
        if (r101 != this.C) goto L10;
        a(r101, r110, this.f514435c);
    L11:
        r101 = r101 + 1;
        goto L6
    L10:
        a(r101, r110, this.f514436d);
        goto L11
    L12:
        r110.drawLine(0.0f, this.f514453u, getWidth(), this.f514453u, this.f514438f);
        r110.drawLine(0.0f, this.f514454v, getWidth(), this.f514454v, this.f514438f);
        if (this.f514457y == true) goto L15;
        Rect r102 = this.f514440h;
        r102.left = 0;
        r102.right = getWidth();
        Rect r103 = this.f514440h;
        r103.top = 0;
        r103.bottom = (int) (2 * this.f514452t);
        Rect r104 = this.f514440h;
        this.f514442j = new LinearGradient(0.0f, r104.top, 0.0f, r104.bottom, this.f514444l, this.f514445m, Shader.TileMode.MIRROR);
        Rect r105 = this.f514441i;
        r105.left = 0;
        r105.right = getWidth();
        Rect r106 = this.f514441i;
        float r107 = this.f514452t;
        r106.top = (int) (3 * r107);
        r106.bottom = (int) (5 * r107);
        Rect r108 = this.f514441i;
        this.f514443k = new LinearGradient(0.0f, r108.bottom, 0.0f, r108.top, this.f514444l, this.f514445m, Shader.TileMode.MIRROR);
        this.f514457y = true;
    L15:
        this.f514437e.setShader(this.f514442j);
        r110.drawRect(this.f514440h, this.f514437e);
        this.f514437e.setShader(this.f514443k);
        r110.drawRect(this.f514441i, this.f514437e);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = true;
        if (r100.getAction() == 1) goto L6;
        r101 = false;
    L6:
        this.f514456x = r101;
        if (r101 == false) goto L9;
        b();
    L9:
        GestureDetector r102 = this.f514447o;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L13:
        return r102.onTouchEvent(r100);
    }

    public final void setOnChangeListener(InterfaceC6831d r100) {
        this.A = r100;
    }

    public final void setSelectedValue(int r100) {
        setSelectedIndex(r100);
        this.B = (this.C - 2) * this.f514452t;
    }

    public d(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f514433a = 5;
        this.f514434b = 100;
        TextPaint r102 = new TextPaint();
        this.f514435c = r102;
        TextPaint r103 = new TextPaint();
        this.f514436d = r103;
        Paint r104 = new Paint();
        this.f514437e = r104;
        Paint r105 = new Paint();
        this.f514438f = r105;
        this.f514439g = new Rect();
        this.f514440h = new Rect();
        this.f514441i = new Rect();
        this.f514448p = new ArrayList();
        this.f514449q = new ArrayList();
        r102.setTextSize(getContext().getResources().getDimension(R.dimen.uicomponent_picker_selected_text_size));
        r103.setTextSize(getContext().getResources().getDimension(R.dimen.uicomponent_picker_unselected_text_size));
        r105.setStrokeWidth(getContext().getResources().getDimension(R.dimen.uicomponent_picker_divider_line_width));
        r102.setFlags(1);
        r103.setFlags(1);
        if (r101 == true) goto L5;
        r102.setColor(getContext().getResources().getColor(R.color.ttlive_std_text_black_1));
        r103.setColor(getContext().getResources().getColor(R.color.ttlive_std_text_black_3));
        r105.setColor(getContext().getResources().getColor(R.color.ttlive_std_line_modal));
        r104.setColor(getContext().getResources().getColor(R.color.ttlive_std_mask_7));
        this.f514444l = getContext().getResources().getColor(R.color.ttlive_std_bg_overlay);
        this.f514445m = getContext().getResources().getColor(R.color.uicomponent_transparent);
    L6:
        float r106 = getContext().getResources().getDimension(R.dimen.uicomponent_picker_item_height);
        this.f514452t = r106;
        float r107 = 2 * r106;
        this.f514453u = r107;
        this.f514454v = r107 + r106;
        this.f514447o = new GestureDetector(getContext(), new b(this));
        this.f514446n = new Scroller(getContext(), new DecelerateInterpolator(0.604f));
        return;
    L5:
        r102.setColor(getContext().getResources().getColor(R.color.ttlive_std_text_white_1));
        r103.setColor(getContext().getResources().getColor(R.color.ttlive_std_text_white_5));
        r105.setColor(getContext().getResources().getColor(R.color.ttlive_std_line_2));
        r104.setColor(getContext().getResources().getColor(R.color.ttlive_std_mask_7));
        this.f514444l = getContext().getResources().getColor(R.color.ttlive_std_bg_live_wall);
        this.f514445m = getContext().getResources().getColor(R.color.uicomponent_transparent);
        goto L6
    }

    public final void c(List<? extends CharSequence> r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        ((ArrayList) this.f514448p).clear();
        ((ArrayList) this.f514448p).addAll(r100);
        int r102 = 0;
        if (r101 >= 0) goto L9;
    L10:
        r101 = 0;
    L11:
        setSelectedIndex(r101);
        ((ArrayList) this.f514449q).clear();
        this.B = (this.C - 2) * this.f514452t;
        int r103 = ((ArrayList) this.f514448p).size();
    L12:
        if (r102 >= r103) goto L14;
        c r104 = new c();
        CharSequence r105 = (CharSequence) ListProtector.get(this.f514448p, r102);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f514460a = r105;
        r102 = r102 + 1;
        r104.f514461b = r102 * this.f514452t;
        ((ArrayList) this.f514449q).add(r104);
        goto L12
    L14:
        float r106 = ((ArrayList) this.f514448p).size() - 3;
        float r107 = this.f514452t;
        this.f514451s = r106 * r107;
        this.f514450r = (-2) * r107;
        invalidate();
        return;
    L9:
        if (r101 < r100.size()) goto L11;
        goto L10
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(r100, (int) (this.f514433a * this.f514452t));
    }

    public final void a(int r110, Canvas r111, TextPaint r112) {
        c r113 = (c) ListProtector.get(this.f514449q, r110);
        float r100 = r113.f514461b - this.B;
        int r101 = 0;
        if (r100 > 0) goto L5;
        return;
    L5:
        if ((r100 - this.f514452t) >= getMeasuredHeight()) goto L26;
        CharSequence r102 = r113.f514460a;
        r112.getTextBounds(r102.toString(), 0, r102.length(), this.f514439g);
        int r114 = getMeasuredWidth() - this.f514439g.width();
        if (r114 < 0) goto L12;
        r101 = r114;
    L12:
        if ((r102 instanceof String) == false) goto L15;
        r111.drawText((String) r102, r101 / 2, r100 - ((this.f514452t - this.f514439g.height()) / 2), r112);
        return;
    L15:
        if ((r102 instanceof SpannableString) == false) goto L25;
        r111.save();
        r111.translate(r101 / 2, (r100 - ((this.f514452t - this.f514439g.height()) / 2)) - this.f514439g.height());
        new DynamicLayout(r102, r112, getWidth(), Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false).draw(r111);     // Catch: Exception -> L20
    L18:
        r111.restore();
        return;
    L25:
        return;
    }
}
