package com.larus.office.base.plugins.attachment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.plugins.attachment.OpenImageHandler$preCheckExportPermission$2$downloadDeferred$1", f = "OpenImageHandler.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class OpenImageHandler$preCheckExportPermission$2$downloadDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $fileToken;
    final /* synthetic */ Integer $fileType;
    final /* synthetic */ com.bytedance.ee.permission.a $permissionService;
    int label;
    final /* synthetic */ f this$0;

    public OpenImageHandler$preCheckExportPermission$2$downloadDeferred$1(f r100, com.bytedance.ee.permission.a r101, String r102, Integer r103, Continuation<? super OpenImageHandler$preCheckExportPermission$2$downloadDeferred$1> r104) {
        this.this$0 = r100;
        this.$permissionService = r101;
        this.$fileToken = r102;
        this.$fileType = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OpenImageHandler$preCheckExportPermission$2$downloadDeferred$1(this.this$0, this.$permissionService, this.$fileToken, this.$fileType, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((OpenImageHandler$preCheckExportPermission$2$downloadDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        f r103 = this.this$0;
        com.bytedance.ee.permission.a r104 = this.$permissionService;
        String r105 = this.$fileToken;
        int r106 = this.$fileType.intValue();
        this.label = 1;
        r100 = f.a(r103, r104, r105, r106, "ATTACHMENT_DOWNLOAD", this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
