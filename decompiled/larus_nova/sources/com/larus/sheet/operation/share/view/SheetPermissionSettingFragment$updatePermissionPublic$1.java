package com.larus.sheet.operation.share.view;

import com.larus.sheet.api.ISheetService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.sheet.operation.share.view.SheetPermissionSettingFragment$updatePermissionPublic$1", f = "SheetPermissionSettingFragment.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class SheetPermissionSettingFragment$updatePermissionPublic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SheetPermissionSettingFragment this$0;

    public SheetPermissionSettingFragment$updatePermissionPublic$1(SheetPermissionSettingFragment r100, Continuation<? super SheetPermissionSettingFragment$updatePermissionPublic$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SheetPermissionSettingFragment$updatePermissionPublic$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SheetPermissionSettingFragment$updatePermissionPublic$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ISheetService r103 = (ISheetService) ServiceManager.get().getService(ISheetService.class);
        if (r103 == null) goto L14;
        final SheetPermissionSettingFragment r104 = this.this$0;
        String r105 = r104.f369118g;
        Function0 r106 = new e();
        Function1 r107 = new f(r104);
        this.label = 1;
        if (r103.e(r105, true, r106, r107) != r101) goto L14;
        return r101;
    }
}
