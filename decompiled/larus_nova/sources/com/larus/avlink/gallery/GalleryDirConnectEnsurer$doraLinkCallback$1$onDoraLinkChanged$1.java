package com.larus.avlink.gallery;

import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1", f = "GalleryDirConnectEnsurer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1(Continuation<? super GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GalleryDirConnectEnsurer$doraLinkCallback$1$onDoraLinkChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r110);
        e.f292493a.getClass();
        e.a();
        if (e.i() == true) goto L28;
    L24:
        FLogger.f375446a.i("GalleryDirConnectEnsurer", "gallery directories ensured on device connected");
        return Unit.INSTANCE;
    L28:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L19
        File r101 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);     // Catch: Throwable -> L19
        PolarisFileWrapper r102 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), e.k());     // Catch: Throwable -> L19
        if (StringsKt.startsWith$default(r102.getCanonicalPath(), r101.getCanonicalPath() + File.separator, false, 2, null) == true) goto L11;
        FLogger.f375446a.w("GalleryPaths", "public album dir escapes pictures root, skip");     // Catch: Throwable -> L19
    L17:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L24;
        FLogger.f375446a.w("GalleryPaths", "public album dir create error: " + r104.getMessage());
        goto L24
    L11:
        if (r102.exists() == false) goto L14;
        FLogger.f375446a.i("GalleryPaths", "public album dir already exists: " + r102.getPath());     // Catch: Throwable -> L19
        goto L17
    L14:
        if (r102.mkdirs() == false) goto L16;
        FLogger.f375446a.i("GalleryPaths", "public album dir created: " + r102.getPath());     // Catch: Throwable -> L19
        goto L17
    L16:
        FLogger.f375446a.w("GalleryPaths", "public album dir create failed: " + r102.getPath());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
