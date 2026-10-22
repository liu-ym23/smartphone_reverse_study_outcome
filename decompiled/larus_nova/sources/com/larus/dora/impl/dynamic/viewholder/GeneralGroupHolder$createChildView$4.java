package com.larus.dora.impl.dynamic.viewholder;

import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.nova.R;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewholder.GeneralGroupHolder$createChildView$4", f = "GeneralGroupHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GeneralGroupHolder$createChildView$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z49.b $doraDevice;
    final /* synthetic */ ItemTextArrow $itemView;
    int label;

    public GeneralGroupHolder$createChildView$4(z49.b r100, ItemTextArrow r101, Continuation<? super GeneralGroupHolder$createChildView$4> r102) {
        this.$doraDevice = r100;
        this.$itemView = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GeneralGroupHolder$createChildView$4(this.$doraDevice, this.$itemView, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GeneralGroupHolder$createChildView$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        Function1<? super Boolean, Unit> r101 = PacificInterfaceManager.f338120a;
        String r102 = this.$doraDevice.c();
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        String r104 = this.$doraDevice.e();
        if (r104 == null) goto L11;
        r103 = r104;
    L11:
        boolean r105 = PacificInterfaceManager.c(r102, r103);
        ItemTextArrow r106 = this.$itemView;
        int r107 = j0.f375426a;
        if (r105 == false) goto L14;
        int r108 = R.string.larus_dora_voice_print_enrolled_cn;
    L15:
        String r109 = j0.d(r108);
        int r110 = ItemTextArrow.f316958k;
        r106.Z5(r109, null);
        return Unit.INSTANCE;
    L14:
        r108 = R.string.larus_dora_voice_print_not_enrolled_cn;
        goto L15
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
