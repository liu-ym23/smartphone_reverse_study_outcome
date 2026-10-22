package com.larus.dora.obric.device_management.setting.earbuds;

import com.larus.dora.impl.core.DoraUserManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsSettingsGeneralGroupHolder$bindMultiUserModeAction$2$1$result$1", f = "DoraObricEarbudsSettingsGeneralGroupHolder.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricEarbudsSettingsGeneralGroupHolder$bindMultiUserModeAction$2$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;

    public DoraObricEarbudsSettingsGeneralGroupHolder$bindMultiUserModeAction$2$1$result$1(boolean r100, Continuation<? super DoraObricEarbudsSettingsGeneralGroupHolder$bindMultiUserModeAction$2$1$result$1> r101) {
        this.$isChecked = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraObricEarbudsSettingsGeneralGroupHolder$bindMultiUserModeAction$2$1$result$1(this.$isChecked, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((DoraObricEarbudsSettingsGeneralGroupHolder$bindMultiUserModeAction$2$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        Boolean r104 = (Boolean) r100;
        g49.d.d("DoraObricEarbudsSettingsGeneralGroupHolder", "updateMultiUserModeState: result = " + r104.booleanValue());
        r103 = r104.booleanValue();
    L16:
        return Boxing.boxBoolean(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DoraUserManager r105 = DoraUserManager.f332169a;
        boolean r106 = DoraUserManager.b();
        boolean r107 = this.$isChecked;
        if (r106 != r107) goto L11;
        g49.d.d("DoraObricEarbudsSettingsGeneralGroupHolder", "updateMultiUserModeState: enable already " + this.$isChecked);
        goto L16
    L11:
        this.label = 1;
        r100 = DoraUserManager.e(r107, this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
