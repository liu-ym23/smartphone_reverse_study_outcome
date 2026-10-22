package com.larus.drive.sdk.impl.utils.file;

import com.larus.drive.sdk.impl.view.operation.download.DriveDownloadDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.file.DriveDownloadManager$onDownloadFailed$1", f = "DriveDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DriveDownloadManager$onDownloadFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    int label;

    public DriveDownloadManager$onDownloadFailed$1(String r100, Continuation<? super DriveDownloadManager$onDownloadFailed$1> r101) {
        this.$taskId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DriveDownloadManager$onDownloadFailed$1(this.$taskId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DriveDownloadManager$onDownloadFailed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$taskId;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        CoroutineScope r103 = DriveDownloadManager.f342019a;
        DriveDownloadManager.f342020b = this.$taskId;
    L13:
        DriveDownloadManager.f342022d = false;
        DriveDownloadManager.f342021c = 0;
        DriveDownloadManager.f342020b = null;
        WeakReference<DriveDownloadDialog> r104 = DriveDownloadManager.f342024f;
        if (r104 == null) goto L18;
        DriveDownloadDialog r105 = r104.get();
        if (r105 == null) goto L18;
        r105.S90();
    L18:
        DriveDownloadManager.f342024f = null;
        return Unit.INSTANCE;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r102 = false;
        goto L11
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
