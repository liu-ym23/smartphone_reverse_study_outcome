package com.larus.camera.impl.ui.component.result.general;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u000e*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u000eR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/ResultDetectAnimationView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadingAnimator", "Landroid/animation/Animator;", "isLoading", "", "startDelayed", "setLoadingState", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAnimation", "ensureViewMeasured", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelLoadingAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultDetectAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f322144d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animator f322145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f322146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f322147c;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f322148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Unit> f322149b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f322148a.getViewTreeObserver().removeOnPreDrawListener(this);
            kotlinx.coroutines.i<Unit> r100 = this.f322149b;
            Result.Companion r101 = Result.Companion;
            r100.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
            return false;
        }

        public b(View r100, kotlinx.coroutines.j r101) {
            this.f322148a = r100;
            this.f322149b = r101;
        }
    }

    static {
    }

    public ResultDetectAnimationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ResultDetectAnimationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final Object j(View r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ResultDetectAnimationView$ensureViewMeasured$1) == false) goto L7;
        ResultDetectAnimationView$ensureViewMeasured$1 r102 = (ResultDetectAnimationView$ensureViewMeasured$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L32:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        View r107 = (View) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L28:
        this.f322147c = true;
        r102.L$0 = null;
        r102.label = 2;
        if (DelayKt.delay(50, r102) != r105) goto L32;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        if (r100.getWidth() != 0) goto L19;
    L23:
        r102.L$0 = r100;
        r102.label = 1;
        kotlinx.coroutines.j r108 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r108.C();
        r100.getViewTreeObserver().addOnPreDrawListener(new b(r100, r108));
        Object r109 = r108.B();
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L26:
        if (r109 != r105) goto L28;
        return r105;
    L19:
        if (r100.getHeight() == 0) goto L23;
        return Unit.INSTANCE;
    L7:
        r102 = new ResultDetectAnimationView$ensureViewMeasured$1(this, r101);
        goto L8
    }

    public final Object l(boolean r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ResultDetectAnimationView$setLoadingState$1) == false) goto L7;
        ResultDetectAnimationView$setLoadingState$1 r100 = (ResultDetectAnimationView$setLoadingState$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        ValueAnimator r104 = null;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L46:
        Animator r113 = this.f322145a;
        if (r113 == null) goto L49;
        r113.cancel();
    L49:
        this.f322145a = null;
    L51:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultDetectAnimationView r114 = (ResultDetectAnimationView) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L25:
        if (this.f322146b == false) goto L39;
        Bitmap r115 = BitmapFactory.decodeResource(getResources(), R.drawable.larus_image_edu_preview_loading);
        if (r115 == null) goto L34;
        int r105 = getWidth();
        if (r115.getWidth() <= 0) goto L32;
        final float r106 = r105 / r115.getWidth();
    L33:
        final Matrix r107 = new Matrix();
        final float r108 = (-r115.getHeight()) * r106;
        final int r116 = getHeight() - r115.getHeight();
        r107.postScale(r106, r106);
        r107.postTranslate(0.0f, r108);
        setImageBitmap(r115);
        setImageMatrix(r107);
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r117.setInterpolator(new PathInterpolator(0.25f, 0.0f, 0.25f, 1.0f));
        r117.setDuration(800);
        r117.setRepeatCount(-1);
        r117.setRepeatMode(1);
        r117.addUpdateListener(new j(r107, r106, r108, r116, this));
        Intrinsics.checkNotNull(r117);
        r117.addListener(new k(this, this, this));
        r104 = r117;
        goto L34
    L32:
        r106 = 1.0f;
    L34:
        this.f322145a = r104;
        if (r104 == null) goto L38;
        if (r104 == null) goto L51;
        r104.start();
        goto L51
    L38:
        r114.setVisibility(4);
        goto L51
    L39:
        r114.setVisibility(4);
        goto L51
    L16:
        ResultKt.throwOnFailure(r112);
        this.f322146b = r110;
        if (r110 == true) goto L19;
    L40:
        if (r110 == true) goto L51;
        if (this.f322147c == false) goto L46;
        r100.label = 2;
        if (DelayKt.delay(50, r100) != r102) goto L46;
        return r102;
    L19:
        if (this.f322145a != null) goto L40;
        setVisibility(0);
        r100.L$0 = this;
        r100.label = 1;
        if (j(this, r100) != r102) goto L23;
        return r102;
    L23:
        r114 = this;
    L7:
        r100 = new ResultDetectAnimationView$setLoadingState$1(this, r111);
        goto L8
    }
}
