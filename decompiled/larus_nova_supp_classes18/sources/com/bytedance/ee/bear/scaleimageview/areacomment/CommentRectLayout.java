package com.bytedance.ee.bear.scaleimageview.areacomment;

import am5.d;
import am5.e;
import am5.f;
import am5.g;
import am5.h;
import am5.i;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentRectLayout extends FrameLayout {
    public static final int P = 0;
    public static final int Q = 0;
    public static final int R = 0;
    public static final int S = 0;
    public float A;
    public String B;
    public final PorterDuffXfermode C;
    public c D;
    public SubsamplingScaleImageView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public UDShadowLayout I;
    public b J;
    public boolean K;
    public final boolean L;
    public final boolean M;
    public boolean N;
    public boolean O;
    public final List<CommentRectF> a;
    public final List<CommentRectF> b;
    public RectF c;
    public RectF d;
    public final Paint e;
    public final Paint f;
    public final int g;
    public ViewDragHelper h;
    public boolean i;
    public Drawable j;
    public Drawable k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public float q;
    public float r;
    public int s;
    public boolean t;
    public final RectF u;
    public RectF v;
    public final RectF w;
    public final RectF x;
    public am5.a y;
    public final RectF z;

    public class a extends ViewDragHelper.Callback {
        public final /* synthetic */ CommentRectLayout a;

        public a(CommentRectLayout r1) {
            this.a = r1;
        }

        public final boolean tryCaptureView(View r1, int r2) {
            if (r1 != this.a.y) goto L5;
            return true;
        L5:
            return false;
        }

        public final int clampViewPositionHorizontal(View r3, int r4, int r5) {
            RectF r6 = CommentRectLayout.b(this.a);
            float r7 = r4;
            float r0 = r6.left;
            if (r7 >= r0) goto L5;
            r4 = (int) r0;
        L8:
            float r8 = this.a.z.width();
            CommentRectLayout r9 = this.a;
            RectF r1 = r9.z;
            float r2 = r4;
            r1.left = r2;
            r1.right = r2 + r8;
            r9.J.invalidate();
            return r4;
        L5:
            float r10 = this.a.y.getWidth() + r4;
            float r11 = r6.right;
            if (r10 <= r11) goto L8;
            r4 = (int) (r11 - this.a.y.getWidth());
            goto L8
        }

        public final int clampViewPositionVertical(View r3, int r4, int r5) {
            RectF r6 = CommentRectLayout.b(this.a);
            float r7 = r4;
            float r0 = r6.top;
            if (r7 >= r0) goto L5;
            r4 = (int) r0;
        L8:
            float r8 = this.a.z.height();
            CommentRectLayout r9 = this.a;
            RectF r1 = r9.z;
            float r2 = r4;
            r1.top = r2;
            r1.bottom = r2 + r8;
            r9.J.invalidate();
            return r4;
        L5:
            float r10 = this.a.y.getHeight() + r4;
            float r11 = r6.bottom;
            if (r10 <= r11) goto L8;
            r4 = (int) (r11 - this.a.y.getHeight());
            goto L8
        }

        public final void onViewReleased(View r1, float r2, float r3) {
            super.onViewReleased(r1, r2, r3);
        }

        public final void onViewPositionChanged(View r1, int r2, int r3, int r4, int r5) {
            super.onViewPositionChanged(r1, r2, r3, r4, r5);
            CommentRectLayout r6 = this.a;
            int r7 = CommentRectLayout.P;
            r6.s();
            this.a.J.invalidate();
        }
    }

    public class b extends View {
        public final /* synthetic */ CommentRectLayout a;

        @Override // android.view.View
        public void onDraw(Canvas r10) {
            CommentRectLayout r0 = this.a;
            if (r0.n == true) goto L5;
        L47:
            CommentRectLayout r1 = this.a;
            if (r1.o == true) goto L50;
            return;
        L50:
            if (r1.y.getVisibility() != 0) goto L81;
            RectF r2 = new RectF(this.a.z);
            CommentRectLayout r3 = this.a;
            r3.h(r10, r2, r3.y.getSidePadding() + this.a.y.getTouchSideSize());
            return;
        L81:
            return;
        L5:
            if (r0.p == true) goto L47;
            Iterator<CommentRectF> r4 = r0.b.iterator();
            boolean r5 = false;
            boolean r6 = false;
        L8:
            if (r4.hasNext() == false) goto L34;
            CommentRectF r7 = r4.next();
            CommentRectLayout r8 = this.a;
            r8.e.setColor(r8.l);
            if (TextUtils.equals(this.a.B, r7.b) == false) goto L16;
            int r9 = 255;
            if (r7.getType() != 3) goto L14;
        L15:
            r5 = true;
        L17:
            this.a.e.setAlpha(r9);
            if (r7.getType() == 1) goto L19;
            if (r7.getType() == 3) goto L25;
            if (r7.getType() != 2) goto L8;
        L25:
            if (TextUtils.equals(this.a.B, r7.b) == false) goto L8;
            RectF r11 = CommentRectLayout.c(this.a);
            if (r5 == false) goto L8;
            if (r6 == true) goto L8;
            if (r11.width() <= 0.0f) goto L8;
            if (r11.height() <= 0.0f) goto L8;
            r10.drawRect(r11, this.a.e);
            r6 = true;
            goto L8
        L19:
            r10.drawRect(r7, this.a.e);
            goto L8
        L14:
            if (r7.getType() != 2) goto L17;
        L16:
            r9 = 127;
            goto L17
        L34:
            Iterator<CommentRectF> r12 = this.a.b.iterator();
            CommentRectF r13 = null;
        L36:
            if (r12.hasNext() == false) goto L43;
            CommentRectF r14 = r12.next();
            if (TextUtils.equals(this.a.B, r14.b) == true) goto L39;
            if (r14.getType() != 1) goto L36;
            CommentRectLayout r15 = this.a;
            CommentRectLayout.d(r15, r14, r10, r15.k);
            goto L36
        L39:
            r13 = r14;
            goto L36
        L43:
            if (r13 == null) goto L47;
            if (r13.getType() != 1) goto L47;
            CommentRectLayout r16 = this.a;
            CommentRectLayout.d(r16, r13, r10, r16.j);
            goto L47
        }

        public b(CommentRectLayout r1, Context r2) {
            this.a = r1;
            super(r2);
        }
    }

    public interface c {
        void a();

        void b();

        void c();

        void d(boolean r1);

        void e();

        void onTouchEvent(MotionEvent r1);
    }

    public static float l(float r2) {
        if (r2 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r2 <= 1.0f) goto L8;
        return 1.0f;
    L8:
        return r2;
    }

    public final void k() {
        setClickable(false);
        setCommentRectVisible(true);
        this.o = false;
        this.y.setVisibility(8);
        this.I.setVisibility(8);
        this.J.invalidate();
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.G.setVisibility(8);
        this.I.setVisibility(8);
        this.z.set(0.0f, 0.0f, 0.0f, 0.0f);
        c r1 = this.D;
        if (r1 == null) goto L6;
        r1.d(false);
        this.D.b();
        return;
    }

    public final void p() {
        setWillNotDraw(false);
        this.j = ContextCompat.getDrawable(getContext(), 2131231717);
        this.k = ContextCompat.getDrawable(getContext(), 2131231718);
        this.m = ContextCompat.getColor(getContext(), 2131106521);
        this.l = ContextCompat.getColor(getContext(), 2131102365);
        ContextCompat.getColor(getContext(), 2131108861);
        this.e.setColor(getResources().getColor(2131101124));
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.g);
        this.f.setAntiAlias(true);
        this.f.setColor(j08.b.b(getResources().getColor(2131106500), 0.3f));
        this.f.setStyle(Paint.Style.FILL);
        SubsamplingScaleImageView r1 = new SubsamplingScaleImageView(getContext());
        this.E = r1;
        r1.setBackground(null);
        this.E.setVisibility(8);
        addView(this.E, new FrameLayout.LayoutParams(-1, -1));
        this.E.setOnMatrixChangeListener(new am5.b(this));
        this.E.setOnClickListener(new am5.c(this));
        b r2 = new b(this, getContext());
        this.J = r2;
        r2.setEnabled(false);
        addView(this.J);
        this.y = new am5.a(getContext());
        int r6 = P;
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(r6, r6);
        r3.gravity = 17;
        this.y.setLayoutParams(r3);
        this.y.setVisibility(8);
        addView(this.y);
        TextView r4 = new TextView(getContext());
        this.F = r4;
        r4.setText(2131887716);
        this.F.setTextSize(2, 16.0f);
        this.F.setEllipsize(TextUtils.TruncateAt.END);
        this.F.setSingleLine(true);
        this.F.setTextColor(this.m);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.leftMargin = n.d(16);
        r5.topMargin = n.d(34);
        this.F.setLayoutParams(r5);
        this.F.setVisibility(8);
        this.F.setOnClickListener(new d(this));
        addView(this.F);
        TextView r7 = new TextView(getContext());
        this.G = r7;
        r7.setText(getResources().getString(2131888433));
        this.G.setTextColor(-1);
        this.G.setTextSize(16.0f);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.gravity = 81;
        r8.bottomMargin = n.d(128);
        this.G.setLayoutParams(r8);
        this.G.setBackgroundDrawable(getResources().getDrawable(2131234006));
        this.G.setVisibility(8);
        this.G.setElevation(n.d(8));
        this.G.setOnClickListener(new e(this));
        addView(this.G);
        setOnClickListener(new f(this));
        this.I = new UDShadowLayout(getContext());
        FrameLayout r9 = new FrameLayout(getContext());
        UDShadowLayout.LayoutParams r10 = new UDShadowLayout.LayoutParams(-2, -2);
        this.I.c(2131953887);
        this.I.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        TextView r11 = new TextView(getContext());
        this.H = r11;
        r9.addView(r11);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -2);
        r12.gravity = 81;
        r12.bottomMargin = n.d(6);
        this.H.setLayoutParams(r12);
        this.H.setText(getResources().getString(2131888367));
        Drawable r13 = l.a(getContext(), 2131253538, 2131102418);
        if (r13 == null) goto L5;
        r13.setBounds(0, 0, n.d(18), n.d(18));
        this.H.setCompoundDrawables(r13, null, null, null);
    L5:
        this.H.setPadding(n.d(10), n.d(9), n.d(9), n.d(10));
        this.H.setCompoundDrawablePadding(8);
        TextView r14 = this.H;
        r14.setBackgroundDrawable(l.a(r14.getContext(), 2131235313, 2131100557));
        this.H.setTextColor(ContextCompat.getColor(getContext(), 2131106622));
        this.H.setTextSize(16.0f);
        this.H.setGravity(17);
        this.H.setOnClickListener(new g(this));
        this.I.setVisibility(8);
        this.I.addView(r9, r10);
        addView(this.I);
        setClickable(false);
        this.h = ViewDragHelper.create(this, 5.0f, new a(this));
    }

    public void setEnableCommentRectClickable(boolean r1) {
    }

    static {
        P = n.d(100);
        Q = n.d(24);
        R = n.d(4);
        S = n.d(8);
    }

    private CommentRectF getCreateCommentRect() {
        if (this.y.getVisibility() == 0) goto L5;
        return null;
    L5:
        float r2 = 0.0f;
        if (this.u.width() > 0.0f) goto L8;
    L32:
        tt5.a.d("CommentRectLayout", "getCreateCommentRect but whole width or height is zero");
        return null;
    L8:
        if (this.u.height() <= 0.0f) goto L32;
        CommentRectF r0 = new CommentRectF();
        float r1 = (this.y.getTop() - this.u.top) + this.y.getSideOffsetValue();
        float r3 = (this.y.getLeft() - this.u.left) + this.y.getSideOffsetValue();
        float r4 = (this.y.getRight() - this.u.left) - this.y.getSideOffsetValue();
        float r5 = (this.y.getBottom() - this.u.top) - this.y.getSideOffsetValue();
        if (r1 >= 0.0f) goto L14;
        r1 = 0.0f;
    L14:
        if (r3 >= 0.0f) goto L17;
        r3 = 0.0f;
    L17:
        if (r4 >= 0.0f) goto L20;
        r4 = 0.0f;
    L20:
        if (r5 < 0.0f) goto L23;
        r2 = r5;
    L23:
        r0.set(l(r3 / this.u.width()), l(r1 / this.u.height()), l(r4 / this.u.width()), l(r2 / this.u.height()));
        RectF r6 = this.v;
        if (r6 == null) goto L31;
        ((RectF) r0).left = Math.max(((RectF) r0).left, r6.left);
        ((RectF) r0).top = Math.max(((RectF) r0).top, this.v.top);
        ((RectF) r0).right = Math.min(((RectF) r0).right, this.v.right);
        float r7 = Math.min(((RectF) r0).bottom, this.v.bottom);
        ((RectF) r0).bottom = r7;
        float r8 = ((RectF) r0).left;
        float r9 = ((RectF) r0).right;
        if (r8 <= r9) goto L29;
        ((RectF) r0).left = r9;
    L29:
        if (((RectF) r0).top <= r7) goto L31;
        ((RectF) r0).top = r7;
    L31:
        return r0;
    }

    private RectF getCreateContentBoundsInView() {
        if (this.v == null) goto L10;
        if (this.w.isEmpty() == true) goto L10;
        return this.w;
    L10:
        return this.u;
    }

    private RectF getWholePageRectF() {
        RectF r0 = this.d;
        if (r0 == null) goto L9;
        if (r0.isEmpty() == true) goto L9;
        return this.d;
    L9:
        return this.u;
    }

    public final void g() {
        if (this.y.getVisibility() == 0) goto L5;
        return;
    L5:
        RectF r0 = this.z;
        float r1 = r0.left;
        float r2 = r0.top;
        float r3 = r0.right;
        float r4 = r0.bottom;
        RectF r5 = getCreateOuterBoundsInView();
        float r6 = r5.left;
        boolean r7 = true;
        if (r1 >= r6) goto L8;
        r1 = r6;
        boolean r8 = true;
    L9:
        float r9 = r5.top;
        if (r2 >= r9) goto L12;
        r2 = r9;
        r8 = true;
    L12:
        float r10 = r5.right;
        if (r3 <= r10) goto L15;
        r3 = r10;
        r8 = true;
    L15:
        float r11 = r5.bottom;
        if (r4 <= r11) goto L18;
        r4 = r11;
    L19:
        if (r7 == false) goto L22;
        this.z.set(r1, r2, r3, r4);
        return;
    L22:
        return;
    L18:
        r7 = r8;
        goto L19
    L8:
        r8 = false;
        goto L9
    }

    public final CommentRectF j() {
        if (this.o == true) goto L5;
    L7:
        CommentRectF r0 = null;
    L8:
        k();
        setCommentRectVisible(true);
        this.o = false;
        this.y.setVisibility(8);
        this.I.setVisibility(8);
        this.J.invalidate();
        tt5.a.h("CommentRectLayout", "CommentRectLayout create rect=" + r0);
        return r0;
    L5:
        if (this.y.getVisibility() != 0) goto L7;
        r0 = getCreateCommentRect();
        goto L8
    }

    public final boolean q() {
        if (this.o == true) goto L5;
        return false;
    L5:
        return true;
    }

    public final void s() {
        if (this.I.getVisibility() == 0) goto L5;
        return;
    L5:
        int r0 = this.I.getMeasuredWidth();
        int r1 = this.I.getMeasuredHeight();
        int r2 = getWidth();
        int r3 = getHeight();
        RectF r4 = this.z;
        float r6 = r0;
        float r5 = r4.left + ((r4.width() - r6) / 2.0f);
        if (this.O == false) goto L15;
        RectF r7 = this.z;
        float r9 = r7.top;
        float r10 = r1;
        if ((r9 - r10) < 0.0f) goto L10;
        float r11 = r9 - r10;
    L14:
        float r12 = r11 + S;
    L23:
        float r8 = Math.max(0.0f, Math.min(r5, r2 - r0));
        float r13 = Math.max(0.0f, Math.min(r12, r3 - r1));
        this.I.layout(Math.round(r8), Math.round(r13), Math.round(r8 + r6), Math.round(r13 + r1));
        return;
    L10:
        r11 = r7.bottom;
        if ((r10 + r11) > r3) goto L13;
        this.O = false;
        goto L14
    L13:
        r11 = Math.max(0, r3 - r1);
        this.O = false;
        goto L14
    L15:
        RectF r14 = this.z;
        float r15 = r14.bottom;
        float r16 = r1;
        if ((r15 + r16) <= r3) goto L22;
        float r17 = r14.top;
        if ((r17 - r16) < 0.0f) goto L21;
        r15 = r17 - r16;
        this.O = true;
        goto L22
    L21:
        r15 = Math.max(0, r3 - r1);
        this.O = false;
    L22:
        r12 = r15 - R;
        goto L23
    }

    public final void x() {
        if (this.v != null) goto L5;
    L11:
        this.w.setEmpty();
        return;
    L5:
        if (this.u.width() <= 0.0f) goto L11;
        if (this.u.height() <= 0.0f) goto L11;
        float r0 = this.u.width();
        float r1 = this.u.height();
        RectF r2 = this.w;
        RectF r3 = this.u;
        float r4 = r3.left;
        RectF r5 = this.v;
        float r6 = (r5.left * r0) + r4;
        float r7 = r3.top;
        r2.set(r6, (r5.top * r1) + r7, r4 + (r5.right * r0), r7 + (r5.bottom * r1));
    }

    private RectF getCreateOuterBoundsInView() {
        RectF r0 = getCreateContentBoundsInView();
        am5.a r1 = this.y;
        if (r1 == null) goto L5;
        float r2 = r1.getSideOffsetValue();
    L6:
        this.x.set(r0.left - r2, r0.top - r2, r0.right + r2, r0.bottom + r2);
        return this.x;
    L5:
        r2 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public final boolean callOnClick() {
        return super.callOnClick();
    }

    public CommentRectF getCurrentAreaRect() {
        return getCreateCommentRect();
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        b r0 = this.J;
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public final void u() {
        v(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public boolean getCommentRectVisible() {
        return this.n;
    }

    public String getHighLightCommentId() {
        return this.B;
    }

    public RectF getHostWholeRectF() {
        return this.u;
    }

    public CommentRectLayout(Context r3) {
        super(r3);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = new Paint();
        this.f = new Paint();
        this.g = n.d(4);
        this.i = false;
        this.n = false;
        this.o = false;
        this.u = new RectF();
        this.w = new RectF();
        this.x = new RectF();
        this.z = new RectF();
        this.A = 1.0f;
        this.C = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.K = true;
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.L = r0.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.M = r0.h("ccm.mobile.area_comment_polish_for_ms");
        this.N = false;
        this.O = false;
        p();
    }

    public static /* synthetic */ RectF b(CommentRectLayout r0) {
        return r0.getCreateOuterBoundsInView();
    }

    public static /* synthetic */ RectF c(CommentRectLayout r0) {
        return r0.getWholePageRectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r21) {
        float r2 = r21.getX();
        float r3 = r21.getY();
        if (r(r2, r3, this.F) == true) goto L168;
        if (r(r2, r3, this.G) == true) goto L168;
        if (r(r2, r3, this.I) == true) goto L168;
        c r4 = this.D;
        if (r4 == null) goto L13;
        r4.onTouchEvent(r21);
    L13:
        if (this.L == true) goto L15;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L22;
    L24:
        boolean r6 = r(r2, r3, this.y);
        int r7 = r21.getAction();
        if (r7 == 0) goto L102;
        if (r7 == 1) goto L101;
        if (r7 == 2) goto L30;
        if (r7 == 3) goto L101;
    L149:
        if (this.t == false) goto L152;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.h.processTouchEvent(r21);
    L158:
        if (this.s <= 0) goto L160;
        return true;
    L160:
        if (this.t == true) goto L170;
        if (r6 == false) goto L163;
        return true;
    L163:
        if (super.dispatchTouchEvent(r21) == true) goto L172;
        return false;
    L172:
        return true;
    L170:
        return true;
    L152:
        if (this.s <= 0) goto L154;
    L156:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L158
    L154:
        if (this.o == true) goto L156;
    L30:
        int r8 = this.s;
        if (r8 <= 0) goto L100;
        int r15 = am5.a.g;
        float r16 = this.A;
        if (r16 > 1.0f) goto L35;
        int r17 = am5.a.i;
    L36:
        int r9 = (int) (r2 - this.q);
        int r10 = (int) (r3 - this.r);
        if (r8 != 1) goto L44;
        float r11 = r9 + this.y.getLeft();
        float r12 = r10 + this.y.getTop();
        float r13 = this.y.getRight();
        float r14 = this.y.getBottom();
        float r18 = r17;
        if ((r13 - r11) >= r18) goto L42;
        r11 = r13 - r18;
    L42:
        if ((r14 - r12) < r18) goto L71;
    L87:
        RectF r19 = getCreateOuterBoundsInView();
        float r110 = r19.top;
        if (r12 >= r110) goto L90;
        r12 = r110;
    L90:
        float r111 = r19.left;
        if (r11 >= r111) goto L93;
        r11 = r111;
    L93:
        float r112 = r19.right;
        if (r13 <= r112) goto L96;
        r13 = r112;
    L96:
        float r113 = r19.bottom;
        if (r14 <= r113) goto L99;
        r14 = r113;
    L99:
        this.z.set(r11, r12, r13, r14);
        requestLayout();
    L71:
        r12 = r14 - r18;
        goto L87
    L44:
        if (r8 != 2) goto L52;
        float r20 = this.y.getLeft();
        float r22 = r10 + this.y.getTop();
        float r23 = r9 + this.y.getRight();
        r14 = this.y.getBottom();
        float r114 = r17;
        if ((r23 - r20) >= r114) goto L49;
        r23 = r20 + r114;
    L49:
        if ((r14 - r22) >= r114) goto L51;
        r22 = r14 - r114;
    L51:
        float r115 = r22;
        r13 = r23;
        r11 = r20;
        r12 = r115;
        goto L87
    L52:
        if (r8 != 3) goto L60;
        r11 = r9 + this.y.getLeft();
        r12 = this.y.getTop();
        float r24 = this.y.getRight();
        float r25 = r10 + this.y.getBottom();
        float r116 = r17;
        if ((r24 - r11) >= r116) goto L57;
        r11 = r24 - r116;
    L57:
        if ((r25 - r12) < r116) goto L75;
    L59:
        float r117 = r24;
        r14 = r25;
        r13 = r117;
    L75:
        r13 = r24;
    L76:
        r14 = r116 + r12;
        goto L87
    L60:
        if (r8 != 4) goto L68;
        float r26 = this.y.getLeft();
        float r27 = this.y.getTop();
        float r28 = r9 + this.y.getRight();
        float r29 = r10 + this.y.getBottom();
        r116 = r17;
        if ((r28 - r26) >= r116) goto L65;
        r28 = r26 + r116;
    L65:
        if ((r29 - r27) >= r116) goto L67;
        r13 = r28;
        r11 = r26;
        r12 = r27;
        goto L76
    L67:
        r13 = r28;
        r11 = r26;
        r12 = r27;
        r14 = r29;
        goto L87
    L68:
        if (r8 != 5) goto L72;
        r11 = this.y.getLeft();
        r12 = r10 + this.y.getTop();
        r13 = this.y.getRight();
        r14 = this.y.getBottom();
        r18 = r17;
        if ((r14 - r12) >= r18) goto L87;
    L72:
        if (r8 != 6) goto L77;
        r11 = this.y.getLeft();
        r12 = this.y.getTop();
        r24 = this.y.getRight();
        r25 = r10 + this.y.getBottom();
        r116 = r17;
        if ((r25 - r12) >= r116) goto L59;
    L77:
        if (r8 != 7) goto L82;
        r11 = r9 + this.y.getLeft();
        r12 = this.y.getTop();
        r13 = this.y.getRight();
        r14 = this.y.getBottom();
        float r118 = r17;
        if ((r13 - r11) >= r118) goto L87;
        r11 = r13 - r118;
        goto L87
    L82:
        if (r8 != 8) goto L86;
        r20 = this.y.getLeft();
        r22 = this.y.getTop();
        r23 = r9 + this.y.getRight();
        r14 = this.y.getBottom();
        float r119 = r17;
        if ((r23 - r20) >= r119) goto L51;
        r23 = r119 + r20;
        goto L51
    L86:
        r12 = 0.0f;
        r11 = 0.0f;
        r13 = 0.0f;
        r14 = 0.0f;
        goto L87
    L35:
        r17 = (int) ((am5.a.g * 2) + (r16 * am5.a.h));
    L100:
        this.q = r2;
        this.r = r3;
    L101:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.s = 0;
        this.t = false;
        goto L149
    L102:
        this.q = r2;
        this.r = r3;
        this.t = false;
        if (r6 == false) goto L149;
        am5.a r30 = this.y;
        float r31 = r2 - r30.getLeft();
        float r32 = r3 - this.y.getTop();
        int r120 = r30.e * 2;
        float r33 = r30.getWidth() / 2.0f;
        float r34 = r30.getHeight() / 2.0f;
        float r35 = r120;
        if (r31 > r35) goto L110;
        if (r32 > r35) goto L110;
        int r36 = 1;
    L143:
        this.s = r36;
        if (r36 > 0) goto L146;
        boolean r37 = true;
    L147:
        this.t = r37;
        goto L149
    L146:
        r37 = false;
    L110:
        if (r31 >= (r30.getWidth() - r120)) goto L112;
    L114:
        if (r31 > r35) goto L119;
        if (r32 < (r30.getHeight() - r120)) goto L119;
        r36 = 3;
    L119:
        if (r31 >= (r30.getWidth() - r120)) goto L121;
    L123:
        float r38 = r31 - r33;
        if (Math.abs(r38) > r35) goto L129;
        if (r32 > r35) goto L129;
        r36 = 5;
    L129:
        if (Math.abs(r38) <= r35) goto L131;
    L133:
        if (r31 > r35) goto L138;
        if (Math.abs(r32 - r34) > r35) goto L138;
        r36 = 7;
    L138:
        if (r31 >= (r30.getWidth() - r120)) goto L140;
    L142:
        r36 = 0;
        goto L143
    L140:
        if (Math.abs(r32 - r34) > r35) goto L142;
        r36 = 8;
        goto L143
    L131:
        if (r32 < (r30.getHeight() - r120)) goto L133;
        r36 = 6;
        goto L143
    L121:
        if (r32 < (r30.getHeight() - r120)) goto L123;
        r36 = 4;
        goto L143
    L112:
        if (r32 > r35) goto L114;
        r36 = 2;
        goto L143
    L22:
        if (this.i == false) goto L24;
        return true;
    L15:
        if (this.N == true) goto L17;
    L18:
        r5 = true;
        goto L20
    L17:
        if (this.M == false) goto L19;
    L168:
        return super.dispatchTouchEvent(r21);
    }

    public final void f(RectF r11) {
        RectF r0 = new RectF();
        float r1 = r11.width();
        float r2 = r11.height();
        int r3 = 0;
    L4:
        if (r3 >= ((ArrayList) this.a).size()) goto L17;
        CommentRectF r4 = (CommentRectF) ListProtector.get(this.a, r3);
        if (r4.getType() != 1) goto L8;
    L15:
        n(r4, r11, r1, r2, r0);
        CommentRectF r5 = (CommentRectF) ListProtector.get(this.b, r3);
        String r6 = r4.b;
        float r7 = r0.left;
        float r8 = r0.top;
        float r9 = r0.right;
        float r10 = r0.bottom;
        r5.b = r6;
        r5.set(r7, r8, r9, r10);
    L16:
        r3 = r3 + 1;
        goto L4
    L8:
        if (r4.getType() == 5) goto L15;
        if (r4.getType() != 2) goto L13;
    L14:
        CommentRectF r12 = (CommentRectF) ListProtector.get(this.b, r3);
        r12.b = r4.b;
        r12.set(0.0f, 0.0f, 0.0f, 0.0f);
        goto L16
    L13:
        if (r4.getType() != 3) goto L16;
    }

    public final RectF m(CommentRectF r5) {
        float r0 = Q;
        float r1 = ((RectF) r5).top - r0;
        if (r1 < this.u.top) goto L5;
    L13:
        float r2 = ((RectF) r5).left + ((r5.width() - r0) / 2.0f);
        float r6 = ((RectF) r5).top - r0;
        return new RectF(r2, r6, r0 + r2, r0 + r6);
    L5:
        if (r1 > 0.0f) goto L13;
        if ((getHeight() - ((RectF) r5).bottom) < r0) goto L11;
        float r3 = ((RectF) r5).left + ((r5.width() - r0) / 2.0f);
        float r7 = ((RectF) r5).bottom;
        return new RectF(r3, r7, r0 + r3, r0 + r7);
    L11:
        float r4 = ((RectF) r5).left + ((r5.width() - r0) / 2.0f);
        float r8 = ((RectF) r5).top;
        return new RectF(r4, r8, r0 + r4, r0 + r8);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    public void setCloseButtonColor(int r2) {
        TextView r0 = this.F;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    public void setCommentClickListener(c r1) {
        this.D = r1;
    }

    public void setCommentRectLayoutDrawDelegate(b r1) {
        this.J = r1;
    }

    public void setCommentRectVisible(boolean r1) {
        this.n = r1;
        this.J.invalidate();
    }

    public void setCommentableAreaPercent(RectF r6) {
        if (r6 != null) goto L4;
        this.v = null;
        this.w.setEmpty();
    L15:
        if (this.o == true) goto L17;
    L19:
        b r7 = this.J;
        if (r7 == null) goto L24;
        r7.invalidate();
        return;
    L24:
        return;
    L17:
        if (this.y.getVisibility() != 0) goto L19;
        g();
        requestLayout();
        return;
    L4:
        float r0 = l(r6.left);
        float r1 = l(r6.top);
        float r2 = l(r6.right);
        float r8 = l(r6.bottom);
        if (r0 <= r2) goto L8;
        r2 = r0;
        r0 = r2;
    L8:
        if (r1 <= r8) goto L10;
        r1 = r8;
        r8 = r1;
    L10:
        RectF r3 = new RectF(r0, r1, r2, r8);
        if (this.v != null) goto L13;
        this.v = new RectF();
    L13:
        this.v.set(r3);
        x();
        goto L15
    }

    public void setCustomImageScale(float r2) {
        if (this.E.getBackground() == null) goto L5;
    L6:
        this.E.setScale(r2);
        return;
    L5:
        if (this.E.u() == true) goto L6;
    }

    public void setDisableShowCommentRect(boolean r1) {
        this.p = r1;
        this.J.invalidate();
    }

    public void setEnableCorrectMatrix(boolean r1) {
        this.K = r1;
    }

    public void setIsVC(boolean r3) {
        this.N = r3;
        tt5.a.h("CommentRectLayout", "setIsVC: isVC:" + r3);
    }

    public CommentRectLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = new Paint();
        this.f = new Paint();
        this.g = n.d(4);
        this.i = false;
        this.n = false;
        this.o = false;
        this.u = new RectF();
        this.w = new RectF();
        this.x = new RectF();
        this.z = new RectF();
        this.A = 1.0f;
        this.C = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.K = true;
        com.bytedance.ee.bear.appsetting.c r4 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.L = r4.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.M = r4.h("ccm.mobile.area_comment_polish_for_ms");
        this.N = false;
        this.O = false;
        p();
    }

    public final void e(RectF r8, float r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.equals(this.u) == true) goto L45;
        this.A = r9;
        tt5.a.b("CommentRectLayout", "onMatrixChanged() called with: rect = [" + r8 + "]");
        RectF r10 = new RectF(this.u);
        this.u.set(r8.left, r8.top, r8.right, r8.bottom);
        x();
        if (this.y.getVisibility() == 0) goto L9;
    L29:
        f(this.u);
        if (this.d == null) goto L35;
        RectF r11 = this.c;
        if (r11 == null) goto L35;
        RectF r12 = this.u;
        n(r11, r12, r12.width(), this.u.height(), this.d);
    L35:
        if (this.n == false) goto L37;
    L40:
        this.J.invalidate();
        return;
    L37:
        if (this.o == true) goto L39;
        return;
    L39:
        if (this.y.getVisibility() == 0) goto L40;
        return;
    L9:
        if (r10.left <= 0.0f) goto L11;
    L16:
        RectF r0 = this.z;
        if (r0.left <= 0.0f) goto L19;
    L25:
        float r1 = this.y.getSideOffsetValue();
        RectF r2 = this.z;
        float r3 = r2.left + r1;
        float r4 = r2.top + r1;
        float r5 = r2.right - r1;
        float r6 = r2.bottom - r1;
        float r7 = (r3 - r10.left) / r10.width();
        float r13 = (r4 - r10.top) / r10.height();
        float r14 = (r5 - r10.left) / r10.width();
        float r15 = (r6 - r10.top) / r10.height();
        float r16 = Math.min(r7, 1.0f);
        float r17 = Math.min(r13, 1.0f);
        float r18 = Math.min(r14, 1.0f);
        float r19 = Math.min(r15, 1.0f);
        float r20 = Math.max(r16, 0.0f);
        float r21 = Math.max(r17, 0.0f);
        float r22 = Math.max(r18, 0.0f);
        float r23 = Math.max(r19, 0.0f);
        float r24 = r8.left + (r20 * r8.width());
        float r25 = r8.top + (r21 * r8.height());
        float r26 = r8.left + (r22 * r8.width());
        float r27 = r8.top + (r23 * r8.height());
        float r28 = Math.max(r8.left, r24) - r1;
        float r29 = Math.max(r8.top, r25) - r1;
        float r30 = Math.min(r8.right, r26) + r1;
        float r31 = Math.min(r8.bottom, r27) + r1;
        boolean r32 = this.K;
        this.z.set(r28, r29, r30, r31);
        if (r32 == false) goto L28;
        g();
    L28:
        requestLayout();
        goto L29
    L19:
        if (r0.top > 0.0f) goto L25;
        if (r0.right > 0.0f) goto L25;
        if (r0.bottom > 0.0f) goto L25;
    L11:
        if (r10.top > 0.0f) goto L16;
        if (r10.right > 0.0f) goto L16;
        if (r10.bottom <= 0.0f) goto L29;
    }

    public final void i(boolean r5, boolean r6) {
        if (this.i != r5) goto L5;
        return;
    L5:
        this.i = r5;
        am5.a r0 = this.y;
        r0.f = !r5;
        r0.invalidate();
        this.I.clearAnimation();
        int r1 = 0;
        if (r6 == true) goto L14;
        this.I.setAlpha(1.0f);
        UDShadowLayout r7 = this.I;
        if (r5 == false) goto L11;
        r1 = 8;
    L11:
        r7.setVisibility(r1);
        return;
    L14:
        if (r5 == true) goto L16;
        this.I.setAlpha(0.0f);
        this.I.setVisibility(0);
        this.I.animate().alpha(1.0f).setDuration(200).start();
        return;
    L16:
        this.I.animate().alpha(0.0f).setDuration(200).withEndAction(new i(this)).start();
    }

    public final CommentRectF o(float r7, float r8) {
        if (this.n == true) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r2 = ((ArrayList) this.b).size() - 1;
    L6:
        if (r2 < 0) goto L17;
        CommentRectF r4 = (CommentRectF) ListProtector.get(this.b, r2);
        if (r4.getType() != 1) goto L13;
        if (m(r4).contains(r7, r8) == false) goto L13;
        return r4;
    L13:
        if (r4.contains(r7, r8) == false) goto L15;
        r0.add(r4);
    L15:
        r2 = r2 - 1;
        goto L6
    L17:
        if (hu5.a.d(r0) == false) goto L19;
        return null;
    L19:
        int r9 = 0;
        if (r0.size() == 1) goto L22;
        CommentRectF r10 = (CommentRectF) ListProtector.get(r0, 0);
        float r1 = Float.MAX_VALUE;
    L25:
        if (r9 >= r0.size()) goto L30;
        CommentRectF r3 = (CommentRectF) ListProtector.get(r0, r9);
        float r5 = (((RectF) r3).right - ((RectF) r3).left) * (((RectF) r3).bottom - ((RectF) r3).top);
        if (r5 >= r1) goto L29;
        r10 = r3;
        r1 = r5;
    L29:
        r9 = r9 + 1;
        goto L25
    L30:
        return r10;
    L22:
        return (CommentRectF) ListProtector.get(r0, 0);
    }

    public final void t(int r3, Bitmap r4) {
        this.E.setBackgroundColor(r3);
        if (r4 == null) goto L6;
        this.E.setImage(new qlb.a(r4, false));
        return;
    }

    public final void v(final float r4, final float r5) {
        this.O = false;
        setClickable(false);
        if (this.E.u() == false) goto L5;
    L6:
        this.E.setVisibility(0);
    L7:
        this.G.setVisibility(8);
        setCommentRectVisible(false);
        ((FrameLayout.LayoutParams) this.y.getLayoutParams()).gravity = 17;
        this.F.setVisibility(0);
        this.o = true;
        final int r1 = n.d(188);
        postDelayed(new h(this, r1, r4, r5), 300);
        c r6 = this.D;
        if (r6 == null) goto L11;
        r6.d(true);
        return;
    L11:
        return;
    L5:
        if (this.E.getBackground() == null) goto L7;
        goto L6
    }

    public final void w(List<CommentRectF> r5, RectF r6) {
        if (r5 != null) goto L4;
        r5 = new ArrayList();
    L4:
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        Iterator<CommentRectF> r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        CommentRectF r0 = r7.next();
        ((ArrayList) this.a).add(r0);
        r0.getClass();
        CommentRectF r1 = new CommentRectF();
        r1.set(r0);
        r1.a = r0.a;
        r1.b = r0.b;
        r1.c = r0.c;
        r1.d = r0.d;
        r1.f = r0.f;
        r1.g = r0.g;
        r1.h = r0.h;
        ((RectF) r1).left = l(((RectF) r1).left);
        ((RectF) r1).top = l(((RectF) r1).top);
        ((RectF) r1).right = l(((RectF) r1).right);
        ((RectF) r1).bottom = l(((RectF) r1).bottom);
        ((ArrayList) this.b).add(r1);
        goto L6
    L8:
        tt5.a.b("CommentRectLayout", "comment rect layout target list=" + this.b);
        f(this.u);
        tt5.a.b("CommentRectLayout", "comment rect layout target list after=" + this.b);
        if (r6 != null) goto L11;
    L14:
        this.c = null;
        this.d = null;
    L16:
        if (this.n == false) goto L20;
        this.J.invalidate();
        return;
    L20:
        return;
    L11:
        if (r6.isEmpty() == true) goto L14;
        this.c = r6;
        this.d = new RectF();
        RectF r8 = this.c;
        RectF r9 = this.u;
        n(r8, r9, r9.width(), this.u.height(), this.d);
        goto L16
    }

    public CommentRectLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = new Paint();
        this.f = new Paint();
        this.g = n.d(4);
        this.i = false;
        this.n = false;
        this.o = false;
        this.u = new RectF();
        this.w = new RectF();
        this.x = new RectF();
        this.z = new RectF();
        this.A = 1.0f;
        this.C = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.K = true;
        com.bytedance.ee.bear.appsetting.c r4 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.L = r4.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.M = r4.h("ccm.mobile.area_comment_polish_for_ms");
        this.N = false;
        this.O = false;
        p();
    }

    public static boolean r(float r1, float r2, View r3) {
        if (r3.getVisibility() == 0) goto L5;
    L13:
        return false;
    L5:
        if (r1 < r3.getLeft()) goto L13;
        if (r1 > r3.getRight()) goto L13;
        if (r2 < r3.getTop()) goto L13;
        if (r2 > r3.getBottom()) goto L13;
        return true;
    }

    public final void h(Canvas r17, RectF r18, int r19) {
        float r2 = Math.round(r18.left);
        float r3 = Math.round(r18.top);
        float r4 = Math.round(r18.right);
        float r1 = Math.round(r18.bottom);
        int r5 = r17.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.f.setXfermode(null);
        RectF r6 = this.u;
        float r7 = r6.left;
        if (r7 >= 0.0f) goto L5;
        float r11 = 0.0f;
    L6:
        float r8 = r6.top;
        if (r8 >= 0.0f) goto L9;
        float r12 = 0.0f;
    L11:
        if (r6.right <= getWidth()) goto L13;
        float r9 = getWidth();
    L14:
        float r13 = r9;
        if (this.u.bottom <= getBottom()) goto L17;
        float r10 = getBottom();
    L18:
        r17.drawRect(r11, r12, r13, r10, this.f);
        this.f.setXfermode(this.C);
        float r14 = r19;
        r17.drawRect(r2 + r14, r3 + r14, r4 - r14, r1 - r14, this.f);
        r17.restoreToCount(r5);
        return;
    L17:
        r10 = this.u.bottom;
        goto L18
    L13:
        r9 = this.u.right;
        goto L14
    L9:
        r12 = r8;
        goto L11
    L5:
        r11 = r7;
        goto L6
    }

    public static void a(CommentRectLayout r5, int r6, float r7, float r8) {
        r5.I.setVisibility(0);
        r5.y.setVisibility(0);
        RectF r0 = r5.getCreateOuterBoundsInView();
        int r1 = (int) Math.floor(Math.min(r0.width(), r0.height()));
        float r2 = r5.A;
        if (r2 > 1.0f) goto L5;
        int r3 = am5.a.i;
    L6:
        if (r1 <= 0) goto L10;
        r6 = Math.min(r6, r1);
        if (r6 >= r3) goto L10;
        r6 = Math.min(r3, r1);
    L10:
        float r4 = 0.0f;
        if (r6 > 0) goto L13;
        r5.z.set(0.0f, 0.0f, 0.0f, 0.0f);
        r5.y.setVisibility(8);
        r5.I.setVisibility(8);
        return;
    L13:
        float r9 = r6;
        float r10 = r9 / 2.0f;
        float r11 = (int) (r7 - r10);
        float r12 = (int) (r8 - r10);
        float r13 = r11 + r9;
        float r14 = r12 + r9;
        if (r11 >= 0.0f) goto L17;
        r13 = r9;
        r11 = 0.0f;
    L17:
        if (r13 <= r5.getWidth()) goto L20;
        r13 = r5.getWidth();
        r11 = r13 - r9;
    L20:
        if (r12 >= 0.0f) goto L22;
        r14 = r9;
    L24:
        if (r14 <= r5.getHeight()) goto L26;
        r14 = r5.getHeight();
        r4 = r14 - r9;
    L26:
        float r15 = r0.left;
        if (r11 >= r15) goto L29;
        r13 = r15 + r9;
        r11 = r15;
    L29:
        float r16 = r0.top;
        if (r4 >= r16) goto L32;
        r14 = r16 + r9;
        r4 = r16;
    L32:
        float r17 = r0.right;
        if (r13 <= r17) goto L35;
        r11 = r17 - r9;
        r13 = r17;
    L35:
        float r18 = r0.bottom;
        if (r14 <= r18) goto L38;
        r4 = r18 - r9;
        r14 = r18;
    L38:
        r5.z.set(r11, r4, r13, r14);
        r5.g();
        r5.requestLayout();
        return;
    L22:
        r4 = r12;
        goto L24
    L5:
        r3 = (int) ((am5.a.g * 2) + (r2 * am5.a.h));
        goto L6
    }

    public static void d(CommentRectLayout r3, CommentRectF r4, Canvas r5, Drawable r6) {
        RectF r7 = r3.m(r4);
        float r0 = r7.top;
        if (r0 < ((RectF) r4).bottom) goto L5;
        r6.setBounds((int) r7.left, (int) r0, (int) r7.right, (int) r7.bottom);
        r5.save();
        float r8 = r7.left;
        float r1 = Q / 2;
        r5.rotate(180.0f, r8 + r1, r7.top + r1);
        r6.draw(r5);
        r5.restore();
        return;
    L5:
        r6.setBounds((int) r7.left, (int) r0, (int) r7.right, (int) r7.bottom);
        r6.draw(r5);
    }

    public static void n(RectF r3, RectF r4, float r5, float r6, RectF r7) {
        float r0 = r4.left + (l(r3.left) * r5);
        float r1 = r4.left + (l(r3.right) * r5);
        r7.set(r0, r4.top + (l(r3.top) * r6), r1, r4.top + (l(r3.bottom) * r6));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.y.getVisibility() != 0) goto L6;
        this.y.layout(Math.round(this.z.left), Math.round(this.z.top), Math.round(this.z.right), Math.round(this.z.bottom));
        s();
        return;
    }
}
