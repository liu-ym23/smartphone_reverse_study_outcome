package com.bytedance.locallife.poi.media.ui.indicator;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.locallife.poi.media.ui.indicator.PoiVerticalPagerIndicator$mPageChangeCallback$2$1$onPageScrollStateChanged$1", f = "PoiVerticalPagerIndicator.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class PoiVerticalPagerIndicator$mPageChangeCallback$2$1$onPageScrollStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PoiVerticalPagerIndicator this$0;

    public PoiVerticalPagerIndicator$mPageChangeCallback$2$1$onPageScrollStateChanged$1(PoiVerticalPagerIndicator r100, Continuation<? super PoiVerticalPagerIndicator$mPageChangeCallback$2$1$onPageScrollStateChanged$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PoiVerticalPagerIndicator$mPageChangeCallback$2$1$onPageScrollStateChanged$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PoiVerticalPagerIndicator$mPageChangeCallback$2$1$onPageScrollStateChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ViewPager2 r104 = this.this$0.f262862f;
        if (r104 != null) goto L14;
    L16:
        r103 = false;
    L17:
        if (r103 == false) goto L19;
        this.this$0.f262859c.setVisibility(8);
        this.this$0.f262860d.setVisibility(8);
        this.this$0.f262861e.setVisibility(8);
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    L14:
        if (r104.getScrollState() != 0) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(3000, this) != r101) goto L11;
        return r101;
    }
}
