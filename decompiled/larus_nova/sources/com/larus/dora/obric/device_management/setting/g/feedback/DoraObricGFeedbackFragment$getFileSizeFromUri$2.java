package com.larus.dora.obric.device_management.setting.g.feedback;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.feedback.DoraObricGFeedbackFragment$getFileSizeFromUri$2", f = "DoraObricGFeedbackFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGFeedbackFragment$getFileSizeFromUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    public DoraObricGFeedbackFragment$getFileSizeFromUri$2(Context r100, Uri r101, Continuation<? super DoraObricGFeedbackFragment$getFileSizeFromUri$2> r102) {
        this.$context = r100;
        this.$uri = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraObricGFeedbackFragment$getFileSizeFromUri$2 r102 = new DoraObricGFeedbackFragment$getFileSizeFromUri$2(this.$context, this.$uri, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Long> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Long> r101) {
        return ((DoraObricGFeedbackFragment$getFileSizeFromUri$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Context r102 = this.$context;
        Uri r103 = this.$uri;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L26
        Cursor r105 = a(r102.getContentResolver(), r103, new String[]{"_size"});     // Catch: Throwable -> L26
        if (r105 == null) goto L23;
        Cursor r106 = r105;     // Catch: Throwable -> L26
        Cursor r107 = r106;     // Catch: Throwable -> L18
        if (r107.moveToFirst() == false) goto L14;
        int r108 = r107.getColumnIndex("_size");     // Catch: Throwable -> L18
        if (r108 == (-1)) goto L14;
        long r109 = r107.getLong(r108);     // Catch: Throwable -> L18
    L16:
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L26
    L24:
        Object r110 = Result.m9449constructorimpl(Boxing.boxLong(r109));     // Catch: Throwable -> L26
    L28:
        Long r111 = Boxing.boxLong(0);
        if (Result.m9455isFailureimpl(r110) == true) goto L31;
        return r110;
    L31:
        return r111;
    L14:
        r109 = 0;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L23:
        r109 = 0;
    L26:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }
}
