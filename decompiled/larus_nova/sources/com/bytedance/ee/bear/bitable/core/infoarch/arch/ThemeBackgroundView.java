package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J0\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0012\u0010!\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J \u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010&R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeBackgroundView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "srcId", "Ljava/lang/Integer;", "srcBottomColor", "paint", "Landroid/graphics/Paint;", "lastImgBottomColor", "lastImgHeight", "setImageDrawable", "", "drawable", "Landroid/graphics/drawable/Drawable;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawImageToBoundsWithGradient", "", "drawGradientRect", "imgBottomColor", "imgHeight", "targetWidth", "targetHeight", "gradientStartY", "", "setDrawable", "getAverageColor", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", SlcFlexDirection.FLEX_ROW, "(Landroid/graphics/Bitmap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThemeBackgroundView extends AppCompatImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f210206f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f210207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f210208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f210209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f210210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f210211e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.core.infoarch.arch.ThemeBackgroundView$setDrawable$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.bitable.core.infoarch.arch.ThemeBackgroundView$setDrawable$1", f = "ThemeBackgroundView.kt", i = {0}, l = {125}, m = "invokeSuspend", n = {SimplayerImageStrategy.RESULT_BITMAP}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Drawable $drawable;
        final /* synthetic */ Integer $imgId;
        Object L$0;
        int label;
        final /* synthetic */ ThemeBackgroundView this$0;

        public AnonymousClass1(Drawable r100, ThemeBackgroundView r101, Integer r102, Continuation<? super AnonymousClass1> r103) {
            this.$drawable = r100;
            this.this$0 = r101;
            this.$imgId = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$drawable, this.this$0, this.$imgId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            Bitmap r103 = (Bitmap) this.L$0;
            ResultKt.throwOnFailure(r100);
        L14:
            Integer r104 = (Integer) r100;
            Bitmap r105 = r103;
        L16:
            if (Intrinsics.areEqual(this.this$0.f210207a, this.$imgId) == false) goto L19;
            this.this$0.f210208b = r104;
            tt5.a.h("ThemeBackgroundView", "setImageDrawable, width: " + r105.getWidth() + ", height: " + r105.getHeight());
            ThemeBackgroundView.j(this.this$0, this.$drawable);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            r105 = ((BitmapDrawable) this.$drawable).getBitmap();
            r104 = null;
            if (r105 == null) goto L16;
            ThemeBackgroundView r106 = this.this$0;
            int r107 = r105.getHeight() - 1;
            this.L$0 = r105;
            this.label = 1;
            int r108 = ThemeBackgroundView.f210206f;
            r106.getClass();
            Object r109 = BuildersKt.withContext(Dispatchers.getIO(), new ThemeBackgroundView$getAverageColor$2(r105, r107, null), this);
            if (r109 != r101) goto L13;
            return r101;
        L13:
            r103 = r105;
            r100 = r109;
            goto L14
        }
    }

    static {
    }

    public ThemeBackgroundView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ThemeBackgroundView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final void setDrawable(Drawable r110) {
        if (r110 == null) goto L5;
        Integer r100 = Integer.valueOf(r110.hashCode());
    L6:
        this.f210207a = r100;
        if ((r110 instanceof BitmapDrawable) == true) goto L9;
        super.setImageDrawable(r110);
        return;
    L9:
        LifecycleOwner r101 = ViewTreeLifecycleOwner.get(this);
        if (r101 == null) goto L14;
        CoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r101);
        if (r102 == null) goto L14;
    L15:
        BuildersKt.launch$default(r102, Dispatchers.getMain(), null, new AnonymousClass1(r110, this, r100, null), 2, null);
        return;
    L14:
        r102 = GlobalScope.INSTANCE;
        goto L15
    L5:
        r100 = null;
        goto L6
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Drawable r100 = getDrawable();
        if ((r100 instanceof BitmapDrawable) == false) goto L5;
        BitmapDrawable r101 = (BitmapDrawable) r100;
    L6:
        boolean r102 = false;
        if (r101 == null) goto L33;
        Bitmap r103 = r101.getBitmap();
        if (r103 == null) goto L33;
        int r104 = getWidth();
        int r105 = getHeight();
        int r106 = r103.getWidth();
        int r107 = r103.getHeight();
        if (r104 <= 0) goto L33;
        if (r105 <= 0) goto L33;
        if (r106 <= 0) goto L33;
        if (r107 <= 0) goto L33;
        float r108 = r104;
        float r109 = r108 / r106;
        r110.save();
        r110.scale(r109, r109);
        r110.drawBitmap(r103, 0.0f, 0.0f, null);
        r110.restore();
        int r111 = (int) (r107 * r109);
        Integer r112 = this.f210208b;
        if (r111 >= r105) goto L32;
        if (r112 == null) goto L32;
        int r113 = r112.intValue();
        Integer r114 = this.f210210d;
        if (r114 != null) goto L24;
    L30:
        this.f210209c.setAntiAlias(true);
        this.f210209c.setShader(new LinearGradient(0.0f, Math.max(r111 - 80, 0), 0.0f, r111, 0, r113, Shader.TileMode.CLAMP));
        this.f210210d = Integer.valueOf(r113);
        this.f210211e = Integer.valueOf(r111);
    L31:
        r110.drawRect(0.0f, Math.max(r111 - 80, 0), r108, r105, this.f210209c);
        goto L32
    L24:
        if (r114.intValue() != r113) goto L30;
        Integer r115 = this.f210211e;
        if (r115 == null) goto L30;
        if (r115.intValue() == r111) goto L31;
    L32:
        r102 = true;
    L33:
        if (r102 == true) goto L36;
        super.onDraw(r110);
        return;
    L36:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        setDrawable(r100);
    }

    public static final /* synthetic */ void j(ThemeBackgroundView r100, Drawable r101) {
        super.setImageDrawable(r101);
    }

    public ThemeBackgroundView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f210209c = new Paint();
    }

    public /* synthetic */ ThemeBackgroundView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
