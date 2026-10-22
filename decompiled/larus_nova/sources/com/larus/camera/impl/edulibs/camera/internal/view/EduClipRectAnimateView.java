package com.larus.camera.impl.edulibs.camera.internal.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mx8.d;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001:B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0014J\u0016\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J\u001e\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0012J \u0010*\u001a\u00020\u00142\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0013J0\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020$H\u0014J\u0018\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020$H\u0002J\b\u00107\u001a\u00020\u0014H\u0002J\u0010\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0013H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipRectAnimateView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "animateDuration", "", "getAnimateDuration", "()J", "setAnimateDuration", "(J)V", "onUpdate", "Lkotlin/Function2;", "", "Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipRectAnimateView$RectData;", "", "initData", "dstData", "isInit", "", "drawPath", "Landroid/graphics/Path;", "tmpData", "tmpPath", "tmpMatrix", "Landroid/graphics/Matrix;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setConfig", "lineWidth", "", "lineColor", "setInitRectSize", "width", "height", "radius", "onAnimUpdate", "block", "startRectAnimation", "dst", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "calculateInitRect", "viewWidth", "viewHeight", "checkAndStartAnimation", "calculatePath", "data", "RectData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduClipRectAnimateView extends View {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f321680k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f321681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f321682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Float, ? super a, Unit> f321683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f321684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f321685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f321686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f321687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f321688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f321689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f321690j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f321691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f321692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f321693c;

        public a(RectF r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "location");
            this.f321691a = r100;
            this.f321692b = r101;
            this.f321693c = r102;
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EduClipRectAnimateView f321694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f321695b;

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
            Function2<? super Float, ? super a, Unit> r101 = this.f321694a.f321683c;
            if (r101 == null) goto L6;
            r101.invoke(Float.valueOf(1.0f), this.f321695b);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function2<? super Float, ? super a, Unit> r101 = this.f321694a.f321683c;
            if (r101 == null) goto L6;
            r101.invoke(Float.valueOf(1.0f), this.f321695b);
            return;
        }

        public b(EduClipRectAnimateView r100, a r101) {
            this.f321694a = r100;
            this.f321695b = r101;
        }
    }

    public final void b() {
        final a r100 = this.f321685e;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f321686f == false) goto L9;
        final RectF r101 = this.f321684d.f321691a;
        final RectF r102 = r100.f321691a;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(this.f321682b);
        r103.addUpdateListener(new d(this, r101, r102, r100));
        r103.addListener(new b(this, r100));
        r103.start();
        return;
    }

    public final long getAnimateDuration() {
        return this.f321682b;
    }

    public EduClipRectAnimateView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(a r100) {
        this.f321688h.f321691a.set(r100.f321691a);
        a r101 = this.f321688h;
        r101.f321692b = r100.f321692b;
        r101.f321693c = r100.f321693c;
        Path r102 = this.f321687g;
        RectF r103 = r100.f321691a;
        float r104 = r100.f321693c + r100.f321692b;
        float r105 = r103.left;
        float r106 = r103.top;
        RectF r107 = new RectF(r105, r106, r105 + r104, r106 + r104);
        r102.reset();
        this.f321689i.reset();
        this.f321689i.moveTo(r107.left, r107.bottom);
        this.f321689i.lineTo(r107.left, r107.bottom - r100.f321693c);
        this.f321689i.addArc(r107, 270.0f, -90.0f);
        this.f321689i.moveTo(r103.left + r100.f321692b, r103.top);
        this.f321689i.lineTo(r103.left + r104, r103.top);
        int r108 = 0;
    L4:
        if (r108 >= 4) goto L16;
        this.f321690j.reset();
        this.f321690j.postRotate(r108 * 90.0f, r107.centerX(), r107.centerY());
        float r109 = 0.0f;
        if (r108 == 1) goto L9;
        if (r108 == 2) goto L9;
        float r110 = 0.0f;
    L10:
        if (r108 != 2) goto L12;
    L14:
        r109 = r103.height() - r104;
    L15:
        this.f321690j.postTranslate(r110, r109);
        r102.addPath(this.f321689i, this.f321690j);
        r108 = r108 + 1;
        goto L4
    L12:
        if (r108 == 3) goto L14;
    L9:
        r110 = r103.width() - r104;
        goto L10
    L16:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawPath(this.f321687g, this.f321681a);
    }

    public final void setAnimateDuration(long r100) {
        this.f321682b = r100;
    }

    public EduClipRectAnimateView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint();
        r102.setStyle(Paint.Style.STROKE);
        this.f321681a = r102;
        this.f321682b = 300;
        this.f321684d = new a(new RectF(), 0.0f, 0.0f);
        this.f321687g = new Path();
        this.f321688h = new a(new RectF(), 0.0f, 0.0f);
        this.f321689i = new Path();
        this.f321690j = new Matrix();
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f321686f == true) goto L9;
        int r105 = getWidth();
        int r106 = getHeight();
        if (r105 <= 0) goto L10;
        if (r106 <= 0) goto L11;
        this.f321686f = true;
        a r107 = this.f321684d;
        RectF r108 = r107.f321691a;
        r108.offset((r105 - r108.width()) / 2.0f, (r106 - r107.f321691a.height()) / 2.0f);
        a(this.f321684d);
        b();
        return;
    L11:
        return;
    L10:
        return;
    }
}
