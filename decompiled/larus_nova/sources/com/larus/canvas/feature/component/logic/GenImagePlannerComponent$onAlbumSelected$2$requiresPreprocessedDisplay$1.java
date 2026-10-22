package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1", f = "GenImagePlannerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Uri $uri;
    int label;

    public GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1(Uri r100, Continuation<? super GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1> r101) {
        this.$uri = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1(this.$uri, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((GenImagePlannerComponent$onAlbumSelected$2$requiresPreprocessedDisplay$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r100);
        Uri r101 = this.$uri;
        Intrinsics.checkNotNullParameter(r101, "uri");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
        ParcelFileDescriptor r103 = com.larus.canvas.feature.component.logic.helper.g.a(AppHost.f326268a.getApplication().getContentResolver(), r101);     // Catch: Throwable -> L23
        boolean r104 = true;
        if (r103 != null) goto L34;
    L21:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L23
    L25:
        Boolean r106 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r105) == false) goto L29;
        r105 = r106;
    L29:
        return Boxing.boxBoolean(((Boolean) r105).booleanValue());
    L34:
        int r107 = new ExifInterface(r103.getFileDescriptor()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);     // Catch: Throwable -> L16
        if (r107 == 0) goto L12;
        if (r107 == 1) goto L12;
    L14:
        CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L23
    L12:
        r104 = false;
        goto L14
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
