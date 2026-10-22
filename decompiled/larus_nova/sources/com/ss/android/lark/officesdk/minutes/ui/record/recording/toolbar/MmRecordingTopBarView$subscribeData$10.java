package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mwb.h;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "degraded", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView$subscribeData$10", f = "MmRecordingTopBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTopBarView$subscribeData$10 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingTopBarView this$0;

    public MmRecordingTopBarView$subscribeData$10(MmRecordingTopBarView r100, Continuation<? super MmRecordingTopBarView$subscribeData$10> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingTopBarView$subscribeData$10 r102 = new MmRecordingTopBarView$subscribeData$10(this.this$0, r101);
        r102.Z$0 = ((Boolean) r100).booleanValue();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Unit> r101) {
        return invoke(r100.booleanValue(), r101);
    }

    public final Object invoke(boolean r100, Continuation<? super Unit> r101) {
        return ((MmRecordingTopBarView$subscribeData$10) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r100);
        boolean r101 = this.Z$0;
        h r102 = this.this$0.f436651a;
        h r103 = null;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L7:
        r102.f516083d.setEnabled(!r101);
        h r104 = this.this$0.f436651a;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L10:
        ImageView r105 = r104.f516083d;
        float r106 = 0.4f;
        if (r101 == false) goto L13;
        float r107 = 0.4f;
    L14:
        r105.setAlpha(r107);
        h r108 = this.this$0.f436651a;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L17:
        r108.f516084e.setEnabled(!r101);
        h r109 = this.this$0.f436651a;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L20:
        ImageView r110 = r109.f516084e;
        if (r101 == false) goto L23;
        float r111 = 0.4f;
    L24:
        r110.setAlpha(r111);
        h r112 = this.this$0.f436651a;
        if (r112 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L27:
        r112.f516085f.setEnabled(!r101);
        h r113 = this.this$0.f436651a;
        if (r113 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L31:
        ImageView r114 = r103.f516085f;
        if (r101 == true) goto L35;
        r106 = 1.0f;
    L35:
        r114.setAlpha(r106);
        return Unit.INSTANCE;
    L30:
        r103 = r113;
        goto L31
    L23:
        r111 = 1.0f;
        goto L24
    L13:
        r107 = 1.0f;
        goto L14
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
