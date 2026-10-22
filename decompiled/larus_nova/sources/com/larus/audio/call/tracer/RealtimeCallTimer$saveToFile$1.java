package com.larus.audio.call.tracer;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.call.f;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.call.tracer.RealtimeCallTimer$saveToFile$1", f = "RealtimeCallTimer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallTimer$saveToFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallTimer this$0;

    public RealtimeCallTimer$saveToFile$1(RealtimeCallTimer r100, Continuation<? super RealtimeCallTimer$saveToFile$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RealtimeCallTimer$saveToFile$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RealtimeCallTimer$saveToFile$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r110);
        PolarisFileWrapper r111 = new PolarisFileWrapper(f.d().f289127c.f289103f, "mic_dump.log");
        File r100 = r111.getParentFile();
        if (r100 == null) goto L7;
        Boxing.boxBoolean(r100.mkdirs());
    L7:
        SimpleDateFormat r101 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        PrintWriter r102 = new PrintWriter(r111);
        RealtimeCallTimer r112 = this.this$0;
        Iterator<Long> r103 = r112.f289634a.iterator();     // Catch: Throwable -> L18
        int r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L15;
        Long r105 = r103.next();     // Catch: Throwable -> L18
        int r106 = r104 + 1;     // Catch: Throwable -> L18
        if (r104 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L18
    L14:
        long r107 = r105.longValue();     // Catch: Throwable -> L18
        int r108 = r112.f289635b.get(r104).intValue();     // Catch: Throwable -> L18
        int r109 = r112.f289636c.get(r104).intValue();     // Catch: Throwable -> L18
        r102.println(r101.format(new Date(r112.f289637d.get(r104).longValue())) + ": buffer size " + r108 + ", read size " + r109 + ",  elapsed time " + r107 + " ms");     // Catch: Throwable -> L18
        r104 = r106;
        goto L10
    L15:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r102, null);
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
