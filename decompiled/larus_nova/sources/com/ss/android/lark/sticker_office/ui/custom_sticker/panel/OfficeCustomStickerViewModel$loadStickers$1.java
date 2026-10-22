package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerViewModel$loadStickers$1", f = "OfficeCustomStickerViewModel.kt", i = {}, l = {54, 58}, m = "invokeSuspend", n = {}, s = {})
final class OfficeCustomStickerViewModel$loadStickers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onNetComplete;
    int label;
    final /* synthetic */ OfficeCustomStickerViewModel this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeCustomStickerViewModel$loadStickers$1(OfficeCustomStickerViewModel r100, Function1<? super Boolean, Unit> r101, Continuation<? super OfficeCustomStickerViewModel$loadStickers$1> r102) {
        this.this$0 = r100;
        this.$onNetComplete = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficeCustomStickerViewModel$loadStickers$1(this.this$0, this.$onNetComplete, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfficeCustomStickerViewModel$loadStickers$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L20:
        if (Result.m9456isSuccessimpl(r103) == false) goto L22;
        MutableLiveData<List<Sticker>> r104 = this.this$0.f440883a;
        ResultKt.throwOnFailure(r103);
        r104.setValue((List<Sticker>) r103);
    L22:
        Function1<Boolean, Unit> r105 = this.$onNetComplete;
        if (r105 == null) goto L26;
        r105.invoke(Boxing.boxBoolean(Result.m9456isSuccessimpl(r103)));
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        Object r106 = ((Result) r100).m9458unboximpl();
    L14:
        if (Result.m9456isSuccessimpl(r106) == false) goto L16;
        MutableLiveData<List<Sticker>> r107 = this.this$0.f440883a;
        ResultKt.throwOnFailure(r106);
        r107.setValue((List<Sticker>) r106);
    L16:
        OfficeCustomStickerViewModel r108 = this.this$0;
        this.label = 2;
        r103 = OfficeCustomStickerViewModel.a(r108, false, this);
        if (r103 != r101) goto L20;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        OfficeCustomStickerViewModel r109 = this.this$0;
        this.label = 1;
        r106 = OfficeCustomStickerViewModel.a(r109, true, this);
        if (r106 != r101) goto L14;
        return r101;
    }
}
