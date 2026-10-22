package androidx.activity;

import androidx.appcompat.widget.RtlSpacingHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"reportWhenComplete", "", "Landroidx/activity/FullyDrawnReporter;", "reporter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FullyDrawnReporterKt {

    /* JADX INFO: renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", i = {0}, l = {185}, m = "reportWhenComplete", n = {"$this$reportWhenComplete"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    public static final Object reportWhenComplete(FullyDrawnReporter r4, Function1<? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r4 = (FullyDrawnReporter) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L25
    L23:
        InlineMarker.finallyStart(1);
        r4.removeReporter();
        InlineMarker.finallyEnd(1);
        r4 = Unit.INSTANCE;
        return r4;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r7);
        r4.addReporter();
        if (r4.isFullyDrawnReported() == true) goto L19;
        r0.L$0 = r4;     // Catch: Throwable -> L25
        r0.label = 1;     // Catch: Throwable -> L25
        if (r5.invoke(r0) != r2) goto L23;
        return r2;
    L19:
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r4.removeReporter();
        InlineMarker.finallyEnd(1);
        throw th;
    L7:
        r0 = new AnonymousClass1(r6);
        goto L8
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super Unit> r3) {
        r1.addReporter();
        if (r1.isFullyDrawnReported() == false) goto L13;
        return Unit.INSTANCE;
    L13:
        r2.invoke(r3);     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        r1.removeReporter();
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.removeReporter();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
