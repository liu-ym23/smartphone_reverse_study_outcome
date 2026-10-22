package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0016J\u0006\u00104\u001a\u00020-J\u0006\u00105\u001a\u00020-J\u0006\u00106\u001a\u00020-J\u000e\u00107\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020-2\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020-H\u0002J\b\u0010=\u001a\u00020-H\u0002J\b\u0010>\u001a\u00020-H\u0002J\b\u0010?\u001a\u00020-H\u0002J\f\u0010@\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010@\u001a\u00020\u0005*\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/swipe/SwipeActionItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "triggerDistancePx", "", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;F)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "capturedItemInfo", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/swipe/SwipeActionHandler$CapturedItemInfo;", "animatingCapturedInfo", "iconAppearDistancePx", "cxMax", "bgRadius", "iconRadius", "ringStrokeWidth", "ringRadiusMax", "triggerBgAnimator", "Landroid/animation/ValueAnimator;", "triggerIconAnimator", "Landroid/animation/AnimatorSet;", "triggerIconScaleUpAnimator", "triggerIconScaleDownAnimator", "triggerRingAnimator", "triggerEffectExecuted", "", "paint", "Landroid/graphics/Paint;", "ringPaint", "ringStrokeColor", "", "saveCanvasRectF", "Landroid/graphics/RectF;", "itemBackgroundRectF", "ringPathCircle", "Landroid/graphics/Path;", "ringPathMeasure", "Landroid/graphics/PathMeasure;", "ringPath", "circleRadiusScaleFactorMax", "ringRippleAlphaMax", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "invalidate", "release", "performTriggerEffect", "startDragging", "animateItemBack", "itemView", "Landroid/view/View;", "performVibration", "performTriggerAnimation", "performTriggerRippleAnimation", "performTriggerIconAnimation", "performTriggerBgAnimation", "dp", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeActionItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f414204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f414205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f414206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SwipeActionHandler.CapturedItemInfo f414207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SwipeActionHandler.CapturedItemInfo f414208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f414209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f414210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f414211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f414212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f414213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ValueAnimator f414214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f414215l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f414216m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f414217n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f414218o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f414219p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f414220q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f414221r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f414222s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RectF f414223t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RectF f414224u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Path f414225v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PathMeasure f414226w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Path f414227x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f414228y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f414229z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeActionItemDecoration f414230a;

        public b(SwipeActionItemDecoration r100) {
            this.f414230a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f414230a.i();
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeActionItemDecoration f414231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f414232b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f414231a.i();
            this.f414231a.f414208e = null;
            this.f414232b.setTranslationX(0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f414231a.i();
            this.f414231a.f414208e = null;
            this.f414232b.setTranslationX(0.0f);
        }

        public c(SwipeActionItemDecoration r100, View r101) {
            this.f414231a = r100;
            this.f414232b = r101;
        }
    }

    static {
    }

    public final void i() {
        if (this.f414204a.isComputingLayout() == true) goto L9;
        this.f414204a.invalidateItemDecorations();     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f414208e = this.f414207d;
        r100.animate().translationX(0.0f).setDuration(200).setUpdateListener(new b(this)).setInterpolator(new DecelerateInterpolator()).setListener(new c(this, r100)).start();
    }

    public SwipeActionItemDecoration(SceneCoordinateRecyclerView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f414204a = r100;
        this.f414205b = r101;
        Context r102 = r100.getContext();
        this.f414206c = r102;
        this.f414209f = UIUtils.dp2px(r102, 30);
        this.f414210g = UIUtils.dp2px(r102, 46.0f);
        this.f414211h = UIUtils.dp2px(r102, 16.0f);
        this.f414212i = UIUtils.dp2px(r102, 8.0f);
        float r103 = UIUtils.dp2px(r102, 1.0f);
        this.f414213j = UIUtils.dp2px(r102, 40.0f);
        Paint r104 = new Paint();
        r104.setFlags(1);
        r104.setColor(UDColorUtils.getColor(r102, R.color.N900_10));
        this.f414220q = r104;
        Paint r105 = new Paint();
        r105.setFlags(1);
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeWidth(r103);
        r105.setStrokeCap(Paint.Cap.ROUND);
        this.f414221r = r105;
        this.f414222s = UDColorUtils.getColor(r102, R.color.N900_10);
        this.f414225v = new Path();
        this.f414226w = new PathMeasure();
        this.f414227x = new Path();
        this.f414228y = 1.2f;
        this.f414229z = 102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        super.onDraw(r100, r101, r102);
        SwipeActionHandler.CapturedItemInfo r103 = this.f414207d;
        if (r103 != null) goto L7;
        r103 = this.f414208e;
        if (r103 != null) goto L7;
        return;
    L7:
        RecyclerView.ViewHolder r104 = r103.f414192b;
        Iterator<View> r105 = ViewGroupKt.getChildren(r101).iterator();
    L8:
        ColorDrawable r106 = null;
        if (r105.hasNext() == false) goto L13;
        View r107 = r105.next();
        if (Intrinsics.areEqual(r107, r104.itemView) == false) goto L8;
    L14:
        View r108 = r107;
        if (r108 != null) goto L17;
        return;
    L17:
        Drawable r109 = r104.itemView.getBackground();
        if ((r109 instanceof ColorDrawable) == false) goto L20;
        r106 = (ColorDrawable) r109;
    L20:
        if (r106 == null) goto L29;
        int r110 = this.f414220q.getColor();
        this.f414220q.setColor(r106.getColor());
        RectF r111 = this.f414224u;
        if (r111 != null) goto L24;
        r111 = new RectF();
        this.f414224u = r111;
    L24:
        r111.set(0.0f, r108.getY(), r108.getWidth(), r108.getY() + r108.getHeight());
        r100.drawRect(r111, this.f414220q);
        this.f414220q.setColor(r110);
        return;
    L29:
        return;
    L13:
        r107 = null;
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        super.onDrawOver(r110, r111, r112);
        SwipeActionHandler.CapturedItemInfo r100 = this.f414207d;
        if (r100 != null) goto L7;
        r100 = this.f414208e;
        if (r100 != null) goto L7;
        return;
    L7:
        RecyclerView.ViewHolder r101 = r100.f414192b;
        Drawable r102 = (Drawable) r100.f414198h.getValue();
        Iterator<View> r103 = ViewGroupKt.getChildren(r111).iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        View r104 = r103.next();
        if (Intrinsics.areEqual(r104, r101.itemView) == false) goto L9;
    L14:
        View r105 = r104;
        if (r105 != null) goto L17;
        return;
    L17:
        float r106 = Math.min(this.f414205b, Math.max(0.0f, r105.getTranslationX()));
        float r107 = this.f414209f;
        if (r106 >= r107) goto L20;
        float r108 = 0.0f;
    L24:
        float r109 = this.f414211h;
        float r113 = r109 + ((this.f414210g - r109) * r108);
        float r114 = r105.getY() + r100.a();
        ValueAnimator r115 = this.f414216m;
        boolean r116 = false;
        if (r115 != null) goto L27;
    L29:
        boolean r117 = false;
    L30:
        if (r117 == false) goto L41;
        ValueAnimator r118 = this.f414216m;
        if (r118 == null) goto L34;
        Object r119 = r118.getAnimatedValue();
    L36:
        if ((r119 instanceof Float) == false) goto L38;
        Float r120 = (Float) r119;
    L39:
        if (r120 == null) goto L59;
        float r121 = r120.floatValue();
    L60:
        ValueAnimator r122 = this.f414214k;
        if (r122 == null) goto L63;
        Object r123 = r122.getAnimatedValue();
    L65:
        if ((r123 instanceof Float) == false) goto L67;
        Float r124 = (Float) r123;
    L68:
        if (r124 == null) goto L70;
        float r125 = r124.floatValue();
    L72:
        if (r108 != 1.0f) goto L74;
        boolean r126 = true;
    L75:
        if (r126 == true) goto L79;
        if (this.f414219p == true) goto L79;
    L85:
        float r127 = this.f414212i;
        float r128 = r127 + ((r121 * (this.f414228y - 1)) * r127);
        RectF r129 = this.f414223t;
        if (r129 != null) goto L88;
        r129 = new RectF();
        this.f414223t = r129;
    L88:
        float r130 = this.f414211h;
        r129.set(0.0f, r114 - r130, this.f414210g + r130, r130 + r114);
        float r131 = -r128;
        r129.inset(r131, r131);
        int r132 = r110.saveLayerAlpha(r129, MathKt.roundToInt(255 * r108));
        r102.setBounds(MathKt.roundToInt(r113 - r128), MathKt.roundToInt(r114 - r128), MathKt.roundToInt(r113 + r128), MathKt.roundToInt(r128 + r114));
        r102.draw(r110);
        r110.restoreToCount(r132);
        this.f414227x.reset();
        ValueAnimator r133 = this.f414218o;
        if (r133 == null) goto L91;
        Object r134 = r133.getAnimatedValue();
    L93:
        if ((r134 instanceof Float) == false) goto L95;
        Float r135 = (Float) r134;
    L96:
        if (r135 == null) goto L98;
        float r136 = r135.floatValue();
    L100:
        if (this.f414219p == true) goto L108;
        if (r108 >= 1.0f) goto L108;
        this.f414225v.reset();
        this.f414225v.addCircle(r113, r114, this.f414211h, Path.Direction.CW);
        this.f414226w.setPath(this.f414225v, false);
        float r137 = this.f414226w.getLength();
        if (r108 > 0.25f) goto L105;
        PathMeasure r138 = this.f414226w;
        r138.getSegment(r137 * 0.75f, r138.getLength() * (r108 + 0.75f), this.f414227x, true);
    L106:
        this.f414221r.setColor(this.f414222s);
        r110.drawPath(this.f414227x, this.f414221r);
        return;
    L105:
        PathMeasure r139 = this.f414226w;
        r139.getSegment(r137 * 0.75f, r139.getLength(), this.f414227x, true);
        PathMeasure r140 = this.f414226w;
        r140.getSegment(0.0f, r140.getLength() * (r108 - 0.25f), this.f414227x, false);
    L108:
        if (r136 != 0.0f) goto L110;
        boolean r141 = true;
    L111:
        if (r141 == false) goto L113;
        return;
    L113:
        if (r136 != 1.0f) goto L115;
        r116 = true;
    L115:
        if (r116 == true) goto L123;
        this.f414227x.addCircle(r113, r114, this.f414213j * r136, Path.Direction.CW);
        this.f414221r.setColor(this.f414222s);
        this.f414221r.setAlpha((int) ((1.0f - r136) * this.f414229z));
        r110.drawPath(this.f414227x, this.f414221r);
        return;
    L123:
        return;
    L110:
        r141 = false;
        goto L111
    L98:
        r136 = 0.0f;
        goto L100
    L95:
        r135 = null;
        goto L96
    L91:
        r134 = null;
    L79:
        if (r125 <= 0.0f) goto L85;
        if (this.f414219p == false) goto L84;
        if (r108 >= 1.0f) goto L84;
        r125 = r108;
    L84:
        int r142 = this.f414220q.getAlpha();
        this.f414220q.setAlpha(MathKt.roundToInt(r142 * r125));
        float r143 = this.f414211h;
        r110.drawCircle(r113, r114, r143 + (((this.f414228y - 1) * r121) * r143), this.f414220q);
        this.f414220q.setAlpha(r142);
        goto L85
    L74:
        r126 = false;
        goto L75
    L70:
        r125 = 0.0f;
        goto L72
    L67:
        r124 = null;
        goto L68
    L63:
        r123 = null;
    L59:
        r121 = 0.0f;
        goto L60
    L38:
        r120 = null;
        goto L39
    L34:
        r119 = null;
        goto L36
    L41:
        ValueAnimator r144 = this.f414217n;
        if (r144 != null) goto L44;
    L46:
        boolean r145 = false;
    L47:
        if (r145 == false) goto L59;
        ValueAnimator r146 = this.f414217n;
        if (r146 == null) goto L51;
        Object r147 = r146.getAnimatedValue();
    L53:
        if ((r147 instanceof Float) == false) goto L55;
        Float r148 = (Float) r147;
    L56:
        if (r148 == null) goto L59;
        r121 = 1 - r148.floatValue();
        goto L60
    L55:
        r148 = null;
        goto L56
    L51:
        r147 = null;
        goto L53
    L44:
        if (r144.isRunning() != true) goto L46;
        r145 = true;
        goto L47
    L27:
        if (r115.isRunning() != true) goto L29;
        r117 = true;
        goto L30
    L20:
        float r149 = this.f414205b;
        if (r106 >= r149) goto L23;
        r108 = (r106 - r107) / (r149 - r107);
        goto L24
    L23:
        r108 = 1.0f;
        goto L24
    L13:
        r104 = null;
        goto L14
    }
}
