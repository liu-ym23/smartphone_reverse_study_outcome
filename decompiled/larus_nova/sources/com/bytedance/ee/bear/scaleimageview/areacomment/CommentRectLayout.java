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
import com.larus.nova.R;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public b f236784J;
    public boolean K;
    public final boolean L;
    public final boolean M;
    public boolean N;
    public boolean O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CommentRectF> f236785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CommentRectF> f236786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f236787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f236788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f236789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f236790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f236791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewDragHelper f236792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f236793i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f236794j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f236795k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f236796l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f236797m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f236798n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f236799o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f236800p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f236801q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f236802r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f236803s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f236804t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f236805u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RectF f236806v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f236807w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f236808x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public am5.a f236809y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f236810z;

    public class a extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentRectLayout f236811a;

        public a(CommentRectLayout r100) {
            this.f236811a = r100;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            if (r100 != this.f236811a.f236809y) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View r100, int r101, int r102) {
            RectF r103 = CommentRectLayout.b(this.f236811a);
            float r104 = r101;
            float r105 = r103.left;
            if (r104 >= r105) goto L5;
            r101 = (int) r105;
        L8:
            float r106 = this.f236811a.f236810z.width();
            CommentRectLayout r107 = this.f236811a;
            RectF r108 = r107.f236810z;
            float r109 = r101;
            r108.left = r109;
            r108.right = r109 + r106;
            r107.f236784J.invalidate();
            return r101;
        L5:
            float r110 = this.f236811a.f236809y.getWidth() + r101;
            float r111 = r103.right;
            if (r110 <= r111) goto L8;
            r101 = (int) (r111 - this.f236811a.f236809y.getWidth());
            goto L8
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            RectF r103 = CommentRectLayout.b(this.f236811a);
            float r104 = r101;
            float r105 = r103.top;
            if (r104 >= r105) goto L5;
            r101 = (int) r105;
        L8:
            float r106 = this.f236811a.f236810z.height();
            CommentRectLayout r107 = this.f236811a;
            RectF r108 = r107.f236810z;
            float r109 = r101;
            r108.top = r109;
            r108.bottom = r109 + r106;
            r107.f236784J.invalidate();
            return r101;
        L5:
            float r110 = this.f236811a.f236809y.getHeight() + r101;
            float r111 = r103.bottom;
            if (r110 <= r111) goto L8;
            r101 = (int) (r111 - this.f236811a.f236809y.getHeight());
            goto L8
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            super.onViewReleased(r100, r101, r102);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
            super.onViewPositionChanged(r100, r101, r102, r103, r104);
            CommentRectLayout r105 = this.f236811a;
            int r106 = CommentRectLayout.P;
            r105.s();
            this.f236811a.f236784J.invalidate();
        }
    }

    public class b extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentRectLayout f236812a;

        @Override // android.view.View
        public void onDraw(Canvas r110) {
            CommentRectLayout r100 = this.f236812a;
            if (r100.f236798n == true) goto L5;
        L47:
            CommentRectLayout r101 = this.f236812a;
            if (r101.f236799o == true) goto L50;
            return;
        L50:
            if (r101.f236809y.getVisibility() != 0) goto L81;
            RectF r102 = new RectF(this.f236812a.f236810z);
            CommentRectLayout r103 = this.f236812a;
            r103.h(r110, r102, r103.f236809y.getSidePadding() + this.f236812a.f236809y.getTouchSideSize());
            return;
        L81:
            return;
        L5:
            if (r100.f236800p == true) goto L47;
            Iterator<CommentRectF> r104 = r100.f236786b.iterator();
            boolean r105 = false;
            boolean r106 = false;
        L8:
            if (r104.hasNext() == false) goto L34;
            CommentRectF r107 = r104.next();
            CommentRectLayout r108 = this.f236812a;
            r108.f236789e.setColor(r108.f236796l);
            if (TextUtils.equals(this.f236812a.B, r107.f236775b) == false) goto L16;
            int r109 = 255;
            if (r107.getType() != 3) goto L14;
        L15:
            r105 = true;
        L17:
            this.f236812a.f236789e.setAlpha(r109);
            if (r107.getType() == 1) goto L19;
            if (r107.getType() == 3) goto L25;
            if (r107.getType() != 2) goto L8;
        L25:
            if (TextUtils.equals(this.f236812a.B, r107.f236775b) == false) goto L8;
            RectF r111 = CommentRectLayout.c(this.f236812a);
            if (r105 == false) goto L8;
            if (r106 == true) goto L8;
            if (r111.width() <= 0.0f) goto L8;
            if (r111.height() <= 0.0f) goto L8;
            r110.drawRect(r111, this.f236812a.f236789e);
            r106 = true;
            goto L8
        L19:
            r110.drawRect(r107, this.f236812a.f236789e);
            goto L8
        L14:
            if (r107.getType() != 2) goto L17;
        L16:
            r109 = 127;
            goto L17
        L34:
            Iterator<CommentRectF> r112 = this.f236812a.f236786b.iterator();
            CommentRectF r113 = null;
        L36:
            if (r112.hasNext() == false) goto L43;
            CommentRectF r114 = r112.next();
            if (TextUtils.equals(this.f236812a.B, r114.f236775b) == true) goto L39;
            if (r114.getType() != 1) goto L36;
            CommentRectLayout r115 = this.f236812a;
            CommentRectLayout.d(r115, r114, r110, r115.f236795k);
            goto L36
        L39:
            r113 = r114;
            goto L36
        L43:
            if (r113 == null) goto L47;
            if (r113.getType() != 1) goto L47;
            CommentRectLayout r116 = this.f236812a;
            CommentRectLayout.d(r116, r113, r110, r116.f236794j);
            goto L47
        }

        public b(CommentRectLayout r100, Context r101) {
            this.f236812a = r100;
            super(r101);
        }
    }

    public interface c {
        void a();

        void b();

        void c();

        void d(boolean r100);

        void e();

        void onTouchEvent(MotionEvent r100);
    }

    public static float l(float r100) {
        if (r100 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r100 <= 1.0f) goto L8;
        return 1.0f;
    L8:
        return r100;
    }

    public final void k() {
        setClickable(false);
        setCommentRectVisible(true);
        this.f236799o = false;
        this.f236809y.setVisibility(8);
        this.I.setVisibility(8);
        this.f236784J.invalidate();
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.G.setVisibility(8);
        this.I.setVisibility(8);
        this.f236810z.set(0.0f, 0.0f, 0.0f, 0.0f);
        c r100 = this.D;
        if (r100 == null) goto L6;
        r100.d(false);
        this.D.b();
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void p() {
        setWillNotDraw(false);
        this.f236794j = ContextCompat.getDrawable(getContext(), R.drawable.areacomment_actived);
        this.f236795k = ContextCompat.getDrawable(getContext(), R.drawable.areacomment_display);
        this.f236797m = ContextCompat.getColor(getContext(), R.color.static_white);
        this.f236796l = ContextCompat.getColor(getContext(), R.color.gradient_yellow_0);
        ContextCompat.getColor(getContext(), R.color.ud_Y200);
        this.f236789e.setColor(getResources().getColor(R.color.colorful_yellow));
        this.f236789e.setAntiAlias(true);
        this.f236789e.setStyle(Paint.Style.STROKE);
        this.f236789e.setStrokeWidth(this.f236791g);
        this.f236790f.setAntiAlias(true);
        this.f236790f.setColor(j08.b.b(getResources().getColor(R.color.static_black), 0.3f));
        this.f236790f.setStyle(Paint.Style.FILL);
        SubsamplingScaleImageView r100 = new SubsamplingScaleImageView(getContext());
        this.E = r100;
        r100.setBackground(null);
        this.E.setVisibility(8);
        addView(this.E, new FrameLayout.LayoutParams(-1, -1));
        this.E.setOnMatrixChangeListener(new am5.b(this));
        this.E.setOnClickListener(new am5.c(this));
        b r101 = new b(this, getContext());
        this.f236784J = r101;
        r101.setEnabled(false);
        addView(this.f236784J);
        this.f236809y = new am5.a(getContext());
        int r102 = P;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(r102, r102);
        r103.gravity = 17;
        this.f236809y.setLayoutParams(r103);
        this.f236809y.setVisibility(8);
        addView(this.f236809y);
        TextView r104 = new TextView(getContext());
        this.F = r104;
        r104.setText(R.string.Doc_Facade_Cancel);
        this.F.setTextSize(2, 16.0f);
        this.F.setEllipsize(TextUtils.TruncateAt.END);
        this.F.setSingleLine(true);
        this.F.setTextColor(this.f236797m);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.leftMargin = n.d(16);
        r105.topMargin = n.d(34);
        this.F.setLayoutParams(r105);
        this.F.setVisibility(8);
        this.F.setOnClickListener(new d(this));
        addView(this.F);
        TextView r106 = new TextView(getContext());
        this.G = r106;
        r106.setText(getResources().getString(R.string.Drive_Drive_PrepareAreaCommentAdd));
        this.G.setTextColor(-1);
        this.G.setTextSize(16.0f);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.gravity = 81;
        r107.bottomMargin = n.d(128);
        this.G.setLayoutParams(r107);
        this.G.setBackgroundDrawable(getResources().getDrawable(R.drawable.drive_bg_area_comment_add));
        this.G.setVisibility(8);
        this.G.setElevation(n.d(8));
        this.G.setOnClickListener(new e(this));
        addView(this.G);
        setOnClickListener(new f(this));
        this.I = new UDShadowLayout(getContext());
        FrameLayout r108 = new FrameLayout(getContext());
        UDShadowLayout.LayoutParams r109 = new UDShadowLayout.LayoutParams(-2, -2);
        this.I.c(R.style.UDShadow_S3);
        this.I.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        TextView r110 = new TextView(getContext());
        this.H = r110;
        r108.addView(r110);
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-2, -2);
        r111.gravity = 81;
        r111.bottomMargin = n.d(6);
        this.H.setLayoutParams(r111);
        this.H.setText(getResources().getString(R.string.Drive_Drive_AreaCommentAddText));
        Drawable r112 = l.a(getContext(), R.drawable.ud_icon_add_comment_outlined, R.color.icon_n1);
        if (r112 == null) goto L5;
        r112.setBounds(0, 0, n.d(18), n.d(18));
        this.H.setCompoundDrawables(r112, null, null, null);
    L5:
        this.H.setPadding(n.d(10), n.d(9), n.d(9), n.d(10));
        this.H.setCompoundDrawablePadding(8);
        TextView r113 = this.H;
        r113.setBackgroundDrawable(l.a(r113.getContext(), R.drawable.facade_round_around_xl, R.color.bg_float));
        this.H.setTextColor(ContextCompat.getColor(getContext(), R.color.text_title));
        this.H.setTextSize(16.0f);
        this.H.setGravity(17);
        this.H.setOnClickListener(new g(this));
        this.I.setVisibility(8);
        this.I.addView(r108, r109);
        addView(this.I);
        setClickable(false);
        this.f236792h = ViewDragHelper.create(this, 5.0f, new a(this));
    }

    public void setEnableCommentRectClickable(boolean r100) {
    }

    static {
        P = n.d(100);
        Q = n.d(24);
        R = n.d(4);
        S = n.d(8);
    }

    private CommentRectF getCreateCommentRect() {
        if (this.f236809y.getVisibility() == 0) goto L5;
        return null;
    L5:
        float r100 = 0.0f;
        if (this.f236805u.width() > 0.0f) goto L8;
    L32:
        tt5.a.d("CommentRectLayout", "getCreateCommentRect but whole width or height is zero");
        return null;
    L8:
        if (this.f236805u.height() <= 0.0f) goto L32;
        CommentRectF r101 = new CommentRectF();
        float r102 = (this.f236809y.getTop() - this.f236805u.top) + this.f236809y.getSideOffsetValue();
        float r103 = (this.f236809y.getLeft() - this.f236805u.left) + this.f236809y.getSideOffsetValue();
        float r104 = (this.f236809y.getRight() - this.f236805u.left) - this.f236809y.getSideOffsetValue();
        float r105 = (this.f236809y.getBottom() - this.f236805u.top) - this.f236809y.getSideOffsetValue();
        if (r102 >= 0.0f) goto L14;
        r102 = 0.0f;
    L14:
        if (r103 >= 0.0f) goto L17;
        r103 = 0.0f;
    L17:
        if (r104 >= 0.0f) goto L20;
        r104 = 0.0f;
    L20:
        if (r105 < 0.0f) goto L23;
        r100 = r105;
    L23:
        r101.set(l(r103 / this.f236805u.width()), l(r102 / this.f236805u.height()), l(r104 / this.f236805u.width()), l(r100 / this.f236805u.height()));
        RectF r106 = this.f236806v;
        if (r106 == null) goto L31;
        ((RectF) r101).left = Math.max(((RectF) r101).left, r106.left);
        ((RectF) r101).top = Math.max(((RectF) r101).top, this.f236806v.top);
        ((RectF) r101).right = Math.min(((RectF) r101).right, this.f236806v.right);
        float r107 = Math.min(((RectF) r101).bottom, this.f236806v.bottom);
        ((RectF) r101).bottom = r107;
        float r108 = ((RectF) r101).left;
        float r109 = ((RectF) r101).right;
        if (r108 <= r109) goto L29;
        ((RectF) r101).left = r109;
    L29:
        if (((RectF) r101).top <= r107) goto L31;
        ((RectF) r101).top = r107;
    L31:
        return r101;
    }

    private RectF getCreateContentBoundsInView() {
        if (this.f236806v == null) goto L10;
        if (this.f236807w.isEmpty() == true) goto L10;
        return this.f236807w;
    L10:
        return this.f236805u;
    }

    private RectF getWholePageRectF() {
        RectF r100 = this.f236788d;
        if (r100 == null) goto L9;
        if (r100.isEmpty() == true) goto L9;
        return this.f236788d;
    L9:
        return this.f236805u;
    }

    public final void g() {
        if (this.f236809y.getVisibility() == 0) goto L5;
        return;
    L5:
        RectF r100 = this.f236810z;
        float r101 = r100.left;
        float r102 = r100.top;
        float r103 = r100.right;
        float r104 = r100.bottom;
        RectF r105 = getCreateOuterBoundsInView();
        float r106 = r105.left;
        boolean r107 = true;
        if (r101 >= r106) goto L8;
        r101 = r106;
        boolean r108 = true;
    L9:
        float r109 = r105.top;
        if (r102 >= r109) goto L12;
        r102 = r109;
        r108 = true;
    L12:
        float r110 = r105.right;
        if (r103 <= r110) goto L15;
        r103 = r110;
        r108 = true;
    L15:
        float r111 = r105.bottom;
        if (r104 <= r111) goto L18;
        r104 = r111;
    L19:
        if (r107 == false) goto L22;
        this.f236810z.set(r101, r102, r103, r104);
        return;
    L22:
        return;
    L18:
        r107 = r108;
        goto L19
    L8:
        r108 = false;
        goto L9
    }

    public final CommentRectF j() {
        if (this.f236799o == true) goto L5;
    L7:
        CommentRectF r100 = null;
    L8:
        k();
        setCommentRectVisible(true);
        this.f236799o = false;
        this.f236809y.setVisibility(8);
        this.I.setVisibility(8);
        this.f236784J.invalidate();
        tt5.a.h("CommentRectLayout", "CommentRectLayout create rect=" + r100);
        return r100;
    L5:
        if (this.f236809y.getVisibility() != 0) goto L7;
        r100 = getCreateCommentRect();
        goto L8
    }

    public final boolean q() {
        if (this.f236799o == true) goto L5;
        return false;
    L5:
        return true;
    }

    public final void s() {
        if (this.I.getVisibility() == 0) goto L5;
        return;
    L5:
        int r100 = this.I.getMeasuredWidth();
        int r101 = this.I.getMeasuredHeight();
        int r102 = getWidth();
        int r103 = getHeight();
        RectF r104 = this.f236810z;
        float r105 = r100;
        float r106 = r104.left + ((r104.width() - r105) / 2.0f);
        if (this.O == false) goto L15;
        RectF r107 = this.f236810z;
        float r108 = r107.top;
        float r110 = r101;
        if ((r108 - r110) < 0.0f) goto L10;
        float r109 = r108 - r110;
    L14:
        float r111 = r109 + S;
    L23:
        float r112 = Math.max(0.0f, Math.min(r106, r102 - r100));
        float r113 = Math.max(0.0f, Math.min(r111, r103 - r101));
        this.I.layout(Math.round(r112), Math.round(r113), Math.round(r112 + r105), Math.round(r113 + r101));
        return;
    L10:
        r109 = r107.bottom;
        if ((r110 + r109) > r103) goto L13;
        this.O = false;
        goto L14
    L13:
        r109 = Math.max(0, r103 - r101);
        this.O = false;
        goto L14
    L15:
        RectF r114 = this.f236810z;
        float r115 = r114.bottom;
        float r116 = r101;
        if ((r115 + r116) <= r103) goto L22;
        float r117 = r114.top;
        if ((r117 - r116) < 0.0f) goto L21;
        r115 = r117 - r116;
        this.O = true;
        goto L22
    L21:
        r115 = Math.max(0, r103 - r101);
        this.O = false;
    L22:
        r111 = r115 - R;
        goto L23
    }

    public final void x() {
        if (this.f236806v != null) goto L5;
    L11:
        this.f236807w.setEmpty();
        return;
    L5:
        if (this.f236805u.width() <= 0.0f) goto L11;
        if (this.f236805u.height() <= 0.0f) goto L11;
        float r100 = this.f236805u.width();
        float r101 = this.f236805u.height();
        RectF r102 = this.f236807w;
        RectF r103 = this.f236805u;
        float r104 = r103.left;
        RectF r105 = this.f236806v;
        float r106 = (r105.left * r100) + r104;
        float r107 = r103.top;
        r102.set(r106, (r105.top * r101) + r107, r104 + (r105.right * r100), r107 + (r105.bottom * r101));
    }

    private RectF getCreateOuterBoundsInView() {
        RectF r100 = getCreateContentBoundsInView();
        am5.a r101 = this.f236809y;
        if (r101 == null) goto L5;
        float r102 = r101.getSideOffsetValue();
    L6:
        this.f236808x.set(r100.left - r102, r100.top - r102, r100.right + r102, r100.bottom + r102);
        return this.f236808x;
    L5:
        r102 = 0.0f;
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
        b r100 = this.f236784J;
        if (r100 == null) goto L6;
        r100.invalidate();
        return;
    }

    public final void u() {
        v(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public boolean getCommentRectVisible() {
        return this.f236798n;
    }

    public String getHighLightCommentId() {
        return this.B;
    }

    public RectF getHostWholeRectF() {
        return this.f236805u;
    }

    public CommentRectLayout(Context r100) {
        super(r100);
        this.f236785a = new ArrayList();
        this.f236786b = new ArrayList();
        this.f236789e = new Paint();
        this.f236790f = new Paint();
        this.f236791g = n.d(4);
        this.f236793i = false;
        this.f236798n = false;
        this.f236799o = false;
        this.f236805u = new RectF();
        this.f236807w = new RectF();
        this.f236808x = new RectF();
        this.f236810z = new RectF();
        this.A = 1.0f;
        this.C = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.K = true;
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.L = r101.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.M = r101.h("ccm.mobile.area_comment_polish_for_ms");
        this.N = false;
        this.O = false;
        p();
    }

    public static /* synthetic */ RectF b(CommentRectLayout r100) {
        return r100.getCreateOuterBoundsInView();
    }

    public static /* synthetic */ RectF c(CommentRectLayout r100) {
        return r100.getWholePageRectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r210) {
        float r100 = r210.getX();
        float r101 = r210.getY();
        if (r(r100, r101, this.F) == true) goto L168;
        if (r(r100, r101, this.G) == true) goto L168;
        if (r(r100, r101, this.I) == true) goto L168;
        c r102 = this.D;
        if (r102 == null) goto L13;
        r102.onTouchEvent(r210);
    L13:
        if (this.L == true) goto L15;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == false) goto L22;
    L24:
        boolean r104 = r(r100, r101, this.f236809y);
        int r105 = r210.getAction();
        if (r105 == 0) goto L102;
        if (r105 == 1) goto L101;
        if (r105 == 2) goto L30;
        if (r105 == 3) goto L101;
    L149:
        if (this.f236804t == false) goto L152;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f236792h.processTouchEvent(r210);
    L158:
        if (this.f236803s <= 0) goto L160;
        return true;
    L160:
        if (this.f236804t == true) goto L170;
        if (r104 == false) goto L163;
        return true;
    L163:
        if (super.dispatchTouchEvent(r210) == true) goto L172;
        return false;
    L172:
        return true;
    L170:
        return true;
    L152:
        if (this.f236803s <= 0) goto L154;
    L156:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L158
    L154:
        if (this.f236799o == true) goto L156;
    L30:
        int r106 = this.f236803s;
        if (r106 <= 0) goto L100;
        int r110 = am5.a.f4394g;
        float r111 = this.A;
        if (r111 > 1.0f) goto L35;
        int r112 = am5.a.f4396i;
    L36:
        int r107 = (int) (r100 - this.f236801q);
        int r108 = (int) (r101 - this.f236802r);
        if (r106 != 1) goto L44;
        float r109 = r107 + this.f236809y.getLeft();
        float r113 = r108 + this.f236809y.getTop();
        float r114 = this.f236809y.getRight();
        float r115 = this.f236809y.getBottom();
        float r116 = r112;
        if ((r114 - r109) >= r116) goto L42;
        r109 = r114 - r116;
    L42:
        if ((r115 - r113) < r116) goto L71;
    L87:
        RectF r117 = getCreateOuterBoundsInView();
        float r118 = r117.top;
        if (r113 >= r118) goto L90;
        r113 = r118;
    L90:
        float r119 = r117.left;
        if (r109 >= r119) goto L93;
        r109 = r119;
    L93:
        float r120 = r117.right;
        if (r114 <= r120) goto L96;
        r114 = r120;
    L96:
        float r121 = r117.bottom;
        if (r115 <= r121) goto L99;
        r115 = r121;
    L99:
        this.f236810z.set(r109, r113, r114, r115);
        requestLayout();
    L71:
        r113 = r115 - r116;
        goto L87
    L44:
        if (r106 != 2) goto L52;
        float r122 = this.f236809y.getLeft();
        float r123 = r108 + this.f236809y.getTop();
        float r124 = r107 + this.f236809y.getRight();
        r115 = this.f236809y.getBottom();
        float r125 = r112;
        if ((r124 - r122) >= r125) goto L49;
        r124 = r122 + r125;
    L49:
        if ((r115 - r123) >= r125) goto L51;
        r123 = r115 - r125;
    L51:
        float r126 = r123;
        r114 = r124;
        r109 = r122;
        r113 = r126;
        goto L87
    L52:
        if (r106 != 3) goto L60;
        r109 = r107 + this.f236809y.getLeft();
        r113 = this.f236809y.getTop();
        float r127 = this.f236809y.getRight();
        float r128 = r108 + this.f236809y.getBottom();
        float r129 = r112;
        if ((r127 - r109) >= r129) goto L57;
        r109 = r127 - r129;
    L57:
        if ((r128 - r113) < r129) goto L75;
    L59:
        float r130 = r127;
        r115 = r128;
        r114 = r130;
    L75:
        r114 = r127;
    L76:
        r115 = r129 + r113;
        goto L87
    L60:
        if (r106 != 4) goto L68;
        float r131 = this.f236809y.getLeft();
        float r132 = this.f236809y.getTop();
        float r133 = r107 + this.f236809y.getRight();
        float r134 = r108 + this.f236809y.getBottom();
        r129 = r112;
        if ((r133 - r131) >= r129) goto L65;
        r133 = r131 + r129;
    L65:
        if ((r134 - r132) >= r129) goto L67;
        r114 = r133;
        r109 = r131;
        r113 = r132;
        goto L76
    L67:
        r114 = r133;
        r109 = r131;
        r113 = r132;
        r115 = r134;
        goto L87
    L68:
        if (r106 != 5) goto L72;
        r109 = this.f236809y.getLeft();
        r113 = r108 + this.f236809y.getTop();
        r114 = this.f236809y.getRight();
        r115 = this.f236809y.getBottom();
        r116 = r112;
        if ((r115 - r113) >= r116) goto L87;
    L72:
        if (r106 != 6) goto L77;
        r109 = this.f236809y.getLeft();
        r113 = this.f236809y.getTop();
        r127 = this.f236809y.getRight();
        r128 = r108 + this.f236809y.getBottom();
        r129 = r112;
        if ((r128 - r113) >= r129) goto L59;
    L77:
        if (r106 != 7) goto L82;
        r109 = r107 + this.f236809y.getLeft();
        r113 = this.f236809y.getTop();
        r114 = this.f236809y.getRight();
        r115 = this.f236809y.getBottom();
        float r135 = r112;
        if ((r114 - r109) >= r135) goto L87;
        r109 = r114 - r135;
        goto L87
    L82:
        if (r106 != 8) goto L86;
        r122 = this.f236809y.getLeft();
        r123 = this.f236809y.getTop();
        r124 = r107 + this.f236809y.getRight();
        r115 = this.f236809y.getBottom();
        float r136 = r112;
        if ((r124 - r122) >= r136) goto L51;
        r124 = r136 + r122;
        goto L51
    L86:
        r113 = 0.0f;
        r109 = 0.0f;
        r114 = 0.0f;
        r115 = 0.0f;
        goto L87
    L35:
        r112 = (int) ((am5.a.f4394g * 2) + (r111 * am5.a.f4395h));
    L100:
        this.f236801q = r100;
        this.f236802r = r101;
    L101:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f236803s = 0;
        this.f236804t = false;
        goto L149
    L102:
        this.f236801q = r100;
        this.f236802r = r101;
        this.f236804t = false;
        if (r104 == false) goto L149;
        am5.a r137 = this.f236809y;
        float r138 = r100 - r137.getLeft();
        float r139 = r101 - this.f236809y.getTop();
        int r140 = r137.f4402e * 2;
        float r141 = r137.getWidth() / 2.0f;
        float r142 = r137.getHeight() / 2.0f;
        float r143 = r140;
        if (r138 > r143) goto L110;
        if (r139 > r143) goto L110;
        int r144 = 1;
    L143:
        this.f236803s = r144;
        if (r144 > 0) goto L146;
        boolean r145 = true;
    L147:
        this.f236804t = r145;
        goto L149
    L146:
        r145 = false;
    L110:
        if (r138 >= (r137.getWidth() - r140)) goto L112;
    L114:
        if (r138 > r143) goto L119;
        if (r139 < (r137.getHeight() - r140)) goto L119;
        r144 = 3;
    L119:
        if (r138 >= (r137.getWidth() - r140)) goto L121;
    L123:
        float r146 = r138 - r141;
        if (Math.abs(r146) > r143) goto L129;
        if (r139 > r143) goto L129;
        r144 = 5;
    L129:
        if (Math.abs(r146) <= r143) goto L131;
    L133:
        if (r138 > r143) goto L138;
        if (Math.abs(r139 - r142) > r143) goto L138;
        r144 = 7;
    L138:
        if (r138 >= (r137.getWidth() - r140)) goto L140;
    L142:
        r144 = 0;
        goto L143
    L140:
        if (Math.abs(r139 - r142) > r143) goto L142;
        r144 = 8;
        goto L143
    L131:
        if (r139 < (r137.getHeight() - r140)) goto L133;
        r144 = 6;
        goto L143
    L121:
        if (r139 < (r137.getHeight() - r140)) goto L123;
        r144 = 4;
        goto L143
    L112:
        if (r139 > r143) goto L114;
        r144 = 2;
        goto L143
    L22:
        if (this.f236793i == false) goto L24;
        return true;
    L15:
        if (this.N == true) goto L17;
    L18:
        r103 = true;
        goto L20
    L17:
        if (this.M == false) goto L19;
    L168:
        return super.dispatchTouchEvent(r210);
    }

    public final void f(RectF r110) {
        RectF r100 = new RectF();
        float r101 = r110.width();
        float r102 = r110.height();
        int r103 = 0;
    L4:
        if (r103 >= ((ArrayList) this.f236785a).size()) goto L17;
        CommentRectF r104 = (CommentRectF) ListProtector.get(this.f236785a, r103);
        if (r104.getType() != 1) goto L8;
    L15:
        n(r104, r110, r101, r102, r100);
        CommentRectF r105 = (CommentRectF) ListProtector.get(this.f236786b, r103);
        String r106 = r104.f236775b;
        float r107 = r100.left;
        float r108 = r100.top;
        float r109 = r100.right;
        float r111 = r100.bottom;
        r105.f236775b = r106;
        r105.set(r107, r108, r109, r111);
    L16:
        r103 = r103 + 1;
        goto L4
    L8:
        if (r104.getType() == 5) goto L15;
        if (r104.getType() != 2) goto L13;
    L14:
        CommentRectF r112 = (CommentRectF) ListProtector.get(this.f236786b, r103);
        r112.f236775b = r104.f236775b;
        r112.set(0.0f, 0.0f, 0.0f, 0.0f);
        goto L16
    L13:
        if (r104.getType() != 3) goto L16;
    }

    public final RectF m(CommentRectF r100) {
        float r101 = Q;
        float r102 = ((RectF) r100).top - r101;
        if (r102 < this.f236805u.top) goto L5;
    L13:
        float r103 = ((RectF) r100).left + ((r100.width() - r101) / 2.0f);
        float r104 = ((RectF) r100).top - r101;
        return new RectF(r103, r104, r101 + r103, r101 + r104);
    L5:
        if (r102 > 0.0f) goto L13;
        if ((getHeight() - ((RectF) r100).bottom) < r101) goto L11;
        float r105 = ((RectF) r100).left + ((r100.width() - r101) / 2.0f);
        float r106 = ((RectF) r100).bottom;
        return new RectF(r105, r106, r101 + r105, r101 + r106);
    L11:
        float r107 = ((RectF) r100).left + ((r100.width() - r101) / 2.0f);
        float r108 = ((RectF) r100).top;
        return new RectF(r107, r108, r101 + r107, r101 + r108);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public void setCloseButtonColor(int r100) {
        TextView r101 = this.F;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setCommentClickListener(c r100) {
        this.D = r100;
    }

    public void setCommentRectLayoutDrawDelegate(b r100) {
        this.f236784J = r100;
    }

    public void setCommentRectVisible(boolean r100) {
        this.f236798n = r100;
        this.f236784J.invalidate();
    }

    public void setCommentableAreaPercent(RectF r100) {
        if (r100 != null) goto L4;
        this.f236806v = null;
        this.f236807w.setEmpty();
    L15:
        if (this.f236799o == true) goto L17;
    L19:
        b r101 = this.f236784J;
        if (r101 == null) goto L24;
        r101.invalidate();
        return;
    L24:
        return;
    L17:
        if (this.f236809y.getVisibility() != 0) goto L19;
        g();
        requestLayout();
        return;
    L4:
        float r102 = l(r100.left);
        float r103 = l(r100.top);
        float r104 = l(r100.right);
        float r105 = l(r100.bottom);
        if (r102 <= r104) goto L8;
        r104 = r102;
        r102 = r104;
    L8:
        if (r103 <= r105) goto L10;
        r103 = r105;
        r105 = r103;
    L10:
        RectF r106 = new RectF(r102, r103, r104, r105);
        if (this.f236806v != null) goto L13;
        this.f236806v = new RectF();
    L13:
        this.f236806v.set(r106);
        x();
        goto L15
    }

    public void setCustomImageScale(float r100) {
        if (this.E.getBackground() == null) goto L5;
    L6:
        this.E.setScale(r100);
        return;
    L5:
        if (this.E.u() == true) goto L6;
    }

    public void setDisableShowCommentRect(boolean r100) {
        this.f236800p = r100;
        this.f236784J.invalidate();
    }

    public void setEnableCorrectMatrix(boolean r100) {
        this.K = r100;
    }

    public void setIsVC(boolean r100) {
        this.N = r100;
        tt5.a.h("CommentRectLayout", "setIsVC: isVC:" + r100);
    }

    public CommentRectLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f236785a = new ArrayList();
        this.f236786b = new ArrayList();
        this.f236789e = new Paint();
        this.f236790f = new Paint();
        this.f236791g = n.d(4);
        this.f236793i = false;
        this.f236798n = false;
        this.f236799o = false;
        this.f236805u = new RectF();
        this.f236807w = new RectF();
        this.f236808x = new RectF();
        this.f236810z = new RectF();
        this.A = 1.0f;
        this.C = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.K = true;
        com.bytedance.ee.bear.appsetting.c r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.L = r102.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.M = r102.h("ccm.mobile.area_comment_polish_for_ms");
        this.N = false;
        this.O = false;
        p();
    }

    public final void e(RectF r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.equals(this.f236805u) == true) goto L45;
        this.A = r101;
        tt5.a.b("CommentRectLayout", "onMatrixChanged() called with: rect = [" + r100 + "]");
        RectF r102 = new RectF(this.f236805u);
        this.f236805u.set(r100.left, r100.top, r100.right, r100.bottom);
        x();
        if (this.f236809y.getVisibility() == 0) goto L9;
    L29:
        f(this.f236805u);
        if (this.f236788d == null) goto L35;
        RectF r103 = this.f236787c;
        if (r103 == null) goto L35;
        RectF r104 = this.f236805u;
        n(r103, r104, r104.width(), this.f236805u.height(), this.f236788d);
    L35:
        if (this.f236798n == false) goto L37;
    L40:
        this.f236784J.invalidate();
        return;
    L37:
        if (this.f236799o == true) goto L39;
        return;
    L39:
        if (this.f236809y.getVisibility() == 0) goto L40;
        return;
    L9:
        if (r102.left <= 0.0f) goto L11;
    L16:
        RectF r105 = this.f236810z;
        if (r105.left <= 0.0f) goto L19;
    L25:
        float r106 = this.f236809y.getSideOffsetValue();
        RectF r107 = this.f236810z;
        float r108 = r107.left + r106;
        float r109 = r107.top + r106;
        float r110 = r107.right - r106;
        float r111 = r107.bottom - r106;
        float r112 = (r108 - r102.left) / r102.width();
        float r113 = (r109 - r102.top) / r102.height();
        float r114 = (r110 - r102.left) / r102.width();
        float r115 = (r111 - r102.top) / r102.height();
        float r116 = Math.min(r112, 1.0f);
        float r117 = Math.min(r113, 1.0f);
        float r118 = Math.min(r114, 1.0f);
        float r119 = Math.min(r115, 1.0f);
        float r120 = Math.max(r116, 0.0f);
        float r121 = Math.max(r117, 0.0f);
        float r122 = Math.max(r118, 0.0f);
        float r123 = Math.max(r119, 0.0f);
        float r124 = r100.left + (r120 * r100.width());
        float r125 = r100.top + (r121 * r100.height());
        float r126 = r100.left + (r122 * r100.width());
        float r127 = r100.top + (r123 * r100.height());
        float r128 = Math.max(r100.left, r124) - r106;
        float r129 = Math.max(r100.top, r125) - r106;
        float r130 = Math.min(r100.right, r126) + r106;
        float r131 = Math.min(r100.bottom, r127) + r106;
        boolean r132 = this.K;
        this.f236810z.set(r128, r129, r130, r131);
        if (r132 == false) goto L28;
        g();
    L28:
        requestLayout();
        goto L29
    L19:
        if (r105.top > 0.0f) goto L25;
        if (r105.right > 0.0f) goto L25;
        if (r105.bottom > 0.0f) goto L25;
    L11:
        if (r102.top > 0.0f) goto L16;
        if (r102.right > 0.0f) goto L16;
        if (r102.bottom <= 0.0f) goto L29;
    }

    public final void i(boolean r100, boolean r101) {
        if (this.f236793i != r100) goto L5;
        return;
    L5:
        this.f236793i = r100;
        am5.a r102 = this.f236809y;
        r102.f4403f = !r100;
        r102.invalidate();
        this.I.clearAnimation();
        int r103 = 0;
        if (r101 == true) goto L14;
        this.I.setAlpha(1.0f);
        UDShadowLayout r104 = this.I;
        if (r100 == false) goto L11;
        r103 = 8;
    L11:
        r104.setVisibility(r103);
        return;
    L14:
        if (r100 == true) goto L16;
        this.I.setAlpha(0.0f);
        this.I.setVisibility(0);
        this.I.animate().alpha(1.0f).setDuration(200).start();
        return;
    L16:
        this.I.animate().alpha(0.0f).setDuration(200).withEndAction(new i(this)).start();
    }

    public final CommentRectF o(float r100, float r101) {
        if (this.f236798n == true) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        int r103 = ((ArrayList) this.f236786b).size() - 1;
    L6:
        if (r103 < 0) goto L17;
        CommentRectF r104 = (CommentRectF) ListProtector.get(this.f236786b, r103);
        if (r104.getType() != 1) goto L13;
        if (m(r104).contains(r100, r101) == false) goto L13;
        return r104;
    L13:
        if (r104.contains(r100, r101) == false) goto L15;
        r102.add(r104);
    L15:
        r103 = r103 - 1;
        goto L6
    L17:
        if (hu5.a.d(r102) == false) goto L19;
        return null;
    L19:
        int r105 = 0;
        if (r102.size() == 1) goto L22;
        CommentRectF r106 = (CommentRectF) ListProtector.get(r102, 0);
        float r107 = Float.MAX_VALUE;
    L25:
        if (r105 >= r102.size()) goto L30;
        CommentRectF r108 = (CommentRectF) ListProtector.get(r102, r105);
        float r109 = (((RectF) r108).right - ((RectF) r108).left) * (((RectF) r108).bottom - ((RectF) r108).top);
        if (r109 >= r107) goto L29;
        r106 = r108;
        r107 = r109;
    L29:
        r105 = r105 + 1;
        goto L25
    L30:
        return r106;
    L22:
        return (CommentRectF) ListProtector.get(r102, 0);
    }

    public final void t(int r100, Bitmap r101) {
        this.E.setBackgroundColor(r100);
        if (r101 == null) goto L6;
        this.E.setImage(new qlb.a(r101, false));
        return;
    }

    public final void v(final float r100, final float r101) {
        this.O = false;
        setClickable(false);
        if (this.E.u() == false) goto L5;
    L6:
        this.E.setVisibility(0);
    L7:
        this.G.setVisibility(8);
        setCommentRectVisible(false);
        ((FrameLayout.LayoutParams) this.f236809y.getLayoutParams()).gravity = 17;
        this.F.setVisibility(0);
        this.f236799o = true;
        final int r102 = n.d(188);
        postDelayed(new h(this, r102, r100, r101), 300);
        c r103 = this.D;
        if (r103 == null) goto L11;
        r103.d(true);
        return;
    L11:
        return;
    L5:
        if (this.E.getBackground() == null) goto L7;
        goto L6
    }

    public final void w(List<CommentRectF> r100, RectF r101) {
        if (r100 != null) goto L4;
        r100 = new ArrayList();
    L4:
        ((ArrayList) this.f236785a).clear();
        ((ArrayList) this.f236786b).clear();
        Iterator<CommentRectF> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        CommentRectF r103 = r102.next();
        ((ArrayList) this.f236785a).add(r103);
        r103.getClass();
        CommentRectF r104 = new CommentRectF();
        r104.set(r103);
        r104.f236774a = r103.f236774a;
        r104.f236775b = r103.f236775b;
        r104.f236776c = r103.f236776c;
        r104.f236777d = r103.f236777d;
        r104.f236779f = r103.f236779f;
        r104.f236780g = r103.f236780g;
        r104.f236781h = r103.f236781h;
        ((RectF) r104).left = l(((RectF) r104).left);
        ((RectF) r104).top = l(((RectF) r104).top);
        ((RectF) r104).right = l(((RectF) r104).right);
        ((RectF) r104).bottom = l(((RectF) r104).bottom);
        ((ArrayList) this.f236786b).add(r104);
        goto L6
    L8:
        tt5.a.b("CommentRectLayout", "comment rect layout target list=" + this.f236786b);
        f(this.f236805u);
        tt5.a.b("CommentRectLayout", "comment rect layout target list after=" + this.f236786b);
        if (r101 != null) goto L11;
    L14:
        this.f236787c = null;
        this.f236788d = null;
    L16:
        if (this.f236798n == false) goto L20;
        this.f236784J.invalidate();
        return;
    L20:
        return;
    L11:
        if (r101.isEmpty() == true) goto L14;
        this.f236787c = r101;
        this.f236788d = new RectF();
        RectF r105 = this.f236787c;
        RectF r106 = this.f236805u;
        n(r105, r106, r106.width(), this.f236805u.height(), this.f236788d);
        goto L16
    }

    public CommentRectLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f236785a = new ArrayList();
        this.f236786b = new ArrayList();
        this.f236789e = new Paint();
        this.f236790f = new Paint();
        this.f236791g = n.d(4);
        this.f236793i = false;
        this.f236798n = false;
        this.f236799o = false;
        this.f236805u = new RectF();
        this.f236807w = new RectF();
        this.f236808x = new RectF();
        this.f236810z = new RectF();
        this.A = 1.0f;
        this.C = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.K = true;
        com.bytedance.ee.bear.appsetting.c r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.L = r103.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.M = r103.h("ccm.mobile.area_comment_polish_for_ms");
        this.N = false;
        this.O = false;
        p();
    }

    public static boolean r(float r100, float r101, View r102) {
        if (r102.getVisibility() == 0) goto L5;
    L13:
        return false;
    L5:
        if (r100 < r102.getLeft()) goto L13;
        if (r100 > r102.getRight()) goto L13;
        if (r101 < r102.getTop()) goto L13;
        if (r101 > r102.getBottom()) goto L13;
        return true;
    }

    public final void h(Canvas r110, RectF r111, int r112) {
        float r100 = Math.round(r111.left);
        float r101 = Math.round(r111.top);
        float r102 = Math.round(r111.right);
        float r103 = Math.round(r111.bottom);
        int r104 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.f236790f.setXfermode(null);
        RectF r105 = this.f236805u;
        float r106 = r105.left;
        if (r106 >= 0.0f) goto L5;
        float r113 = 0.0f;
    L6:
        float r107 = r105.top;
        if (r107 >= 0.0f) goto L9;
        float r114 = 0.0f;
    L11:
        if (r105.right <= getWidth()) goto L13;
        float r108 = getWidth();
    L14:
        float r115 = r108;
        if (this.f236805u.bottom <= getBottom()) goto L17;
        float r109 = getBottom();
    L18:
        r110.drawRect(r113, r114, r115, r109, this.f236790f);
        this.f236790f.setXfermode(this.C);
        float r116 = r112;
        r110.drawRect(r100 + r116, r101 + r116, r102 - r116, r103 - r116, this.f236790f);
        r110.restoreToCount(r104);
        return;
    L17:
        r109 = this.f236805u.bottom;
        goto L18
    L13:
        r108 = this.f236805u.right;
        goto L14
    L9:
        r114 = r107;
        goto L11
    L5:
        r113 = r106;
        goto L6
    }

    public static void a(CommentRectLayout r100, int r101, float r102, float r103) {
        r100.I.setVisibility(0);
        r100.f236809y.setVisibility(0);
        RectF r104 = r100.getCreateOuterBoundsInView();
        int r105 = (int) Math.floor(Math.min(r104.width(), r104.height()));
        float r106 = r100.A;
        if (r106 > 1.0f) goto L5;
        int r107 = am5.a.f4396i;
    L6:
        if (r105 <= 0) goto L10;
        r101 = Math.min(r101, r105);
        if (r101 >= r107) goto L10;
        r101 = Math.min(r107, r105);
    L10:
        float r108 = 0.0f;
        if (r101 > 0) goto L13;
        r100.f236810z.set(0.0f, 0.0f, 0.0f, 0.0f);
        r100.f236809y.setVisibility(8);
        r100.I.setVisibility(8);
        return;
    L13:
        float r109 = r101;
        float r110 = r109 / 2.0f;
        float r111 = (int) (r102 - r110);
        float r112 = (int) (r103 - r110);
        float r113 = r111 + r109;
        float r114 = r112 + r109;
        if (r111 >= 0.0f) goto L17;
        r113 = r109;
        r111 = 0.0f;
    L17:
        if (r113 <= r100.getWidth()) goto L20;
        r113 = r100.getWidth();
        r111 = r113 - r109;
    L20:
        if (r112 >= 0.0f) goto L22;
        r114 = r109;
    L24:
        if (r114 <= r100.getHeight()) goto L26;
        r114 = r100.getHeight();
        r108 = r114 - r109;
    L26:
        float r115 = r104.left;
        if (r111 >= r115) goto L29;
        r113 = r115 + r109;
        r111 = r115;
    L29:
        float r116 = r104.top;
        if (r108 >= r116) goto L32;
        r114 = r116 + r109;
        r108 = r116;
    L32:
        float r117 = r104.right;
        if (r113 <= r117) goto L35;
        r111 = r117 - r109;
        r113 = r117;
    L35:
        float r118 = r104.bottom;
        if (r114 <= r118) goto L38;
        r108 = r118 - r109;
        r114 = r118;
    L38:
        r100.f236810z.set(r111, r108, r113, r114);
        r100.g();
        r100.requestLayout();
        return;
    L22:
        r108 = r112;
        goto L24
    L5:
        r107 = (int) ((am5.a.f4394g * 2) + (r106 * am5.a.f4395h));
        goto L6
    }

    public static void d(CommentRectLayout r100, CommentRectF r101, Canvas r102, Drawable r103) {
        RectF r104 = r100.m(r101);
        float r105 = r104.top;
        if (r105 < ((RectF) r101).bottom) goto L5;
        r103.setBounds((int) r104.left, (int) r105, (int) r104.right, (int) r104.bottom);
        r102.save();
        float r106 = r104.left;
        float r107 = Q / 2;
        r102.rotate(180.0f, r106 + r107, r104.top + r107);
        r103.draw(r102);
        r102.restore();
        return;
    L5:
        r103.setBounds((int) r104.left, (int) r105, (int) r104.right, (int) r104.bottom);
        r103.draw(r102);
    }

    public static void n(RectF r100, RectF r101, float r102, float r103, RectF r104) {
        float r105 = r101.left + (l(r100.left) * r102);
        float r106 = r101.left + (l(r100.right) * r102);
        r104.set(r105, r101.top + (l(r100.top) * r103), r106, r101.top + (l(r100.bottom) * r103));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f236809y.getVisibility() != 0) goto L6;
        this.f236809y.layout(Math.round(this.f236810z.left), Math.round(this.f236810z.top), Math.round(this.f236810z.right), Math.round(this.f236810z.bottom));
        s();
        return;
    }
}
