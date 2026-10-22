package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2", f = "CreationMediaAttachmentExtUpdater.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $uri;
    private /* synthetic */ Object L$0;
    int label;

    public CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2(String r100, Continuation<? super CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2> r101) {
        this.$uri = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2 r102 = new CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2(this.$uri, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L11;
        if (r102 != 1) goto L10;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L7
    L21:
        FileUrlRespData r103 = (FileUrlRespData) ((com.larus.network.http.a) r100).f360135b;     // Catch: Throwable -> L7
        if (r103 == null) goto L28;
        List<FileUrlData> r104 = r103.getFileUrlList();     // Catch: Throwable -> L7
        if (r104 == null) goto L28;
        FileUrlData r105 = (FileUrlData) CollectionsKt.firstOrNull(r104);     // Catch: Throwable -> L7
        if (r105 == null) goto L28;
        String r106 = r105.getMainUrl();     // Catch: Throwable -> L7
    L29:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L7
    L32:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L36;
        FLogger.f375446a.e("CreationMediaAttachmentExtUpdater", "[requireImageUrlOfUri] require url failed", r108);
    L36:
        if (Result.m9455isFailureimpl(r107) == false) goto L39;
        return null;
    L39:
        return r107;
    L28:
        r106 = null;
        goto L29
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r109 = (CoroutineScope) this.L$0;
        if (this.$uri.length() != 0) goto L14;
        boolean r110 = true;
    L15:
        if (r110 == false) goto L17;
        return null;
    L17:
        String r111 = this.$uri;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L7
        List r113 = CollectionsKt.listOf(r111);     // Catch: Throwable -> L7
        UploadDataType r114 = UploadDataType.IMAGE;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r100 = com.larus.uaigc.api.o.b(r113, r114, this);     // Catch: Throwable -> L7
        if (r100 != r101) goto L21;
        return r101;
    L14:
        r110 = false;
    L7:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    }
}
