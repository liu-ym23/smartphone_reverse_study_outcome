package com.bytedance.ee.android.file.picker.lib.v2.util.content;

import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.android.file.picker.lib.v2.util.content.FlowContentResolver$mapToList$1$list$1", f = "FlowContentResolver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowContentResolver$mapToList$1$list$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Object>>, Object> {
    final /* synthetic */ Function1<Cursor, Object> $mapper;
    final /* synthetic */ c $query;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowContentResolver$mapToList$1$list$1(c r100, Function1<? super Cursor, Object> r101, Continuation<? super FlowContentResolver$mapToList$1$list$1> r102) {
        this.$query = r100;
        this.$mapper = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowContentResolver$mapToList$1$list$1(this.$query, this.$mapper, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ArrayList<Object>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ArrayList<Object>> r101) {
        return ((FlowContentResolver$mapToList$1$list$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r100);
        Cursor r101 = this.$query.run();
        if (r101 == null) goto L18;
        Cursor r102 = r101;
        Function1<Cursor, Object> r103 = this.$mapper;
        Cursor r104 = r102;     // Catch: Throwable -> L13
        ArrayList r105 = new ArrayList(r104.getCount());     // Catch: Throwable -> L13
    L9:
        if (r104.moveToNext() == false) goto L12;
        r105.add(r103.invoke(r104));     // Catch: Throwable -> L13
        goto L9
    L12:
        CloseableKt.closeFinally(r102, null);
        return r105;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    L18:
        return null;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
