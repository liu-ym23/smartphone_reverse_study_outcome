package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$5$2", f = "Zip.kt", i = {}, l = {234, 234}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combine$5$2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object[], Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$2(Function2<? super Object[], ? super Continuation<Object>, ? extends Object> r100, Continuation<? super FlowKt__ZipKt$combine$5$2> r101) {
        this.$transform = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Object[] r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> r100, Object[] r101, Continuation<? super Unit> r102) {
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$5$2 r103 = new FlowKt__ZipKt$combine$5$2(this.$transform, r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        FlowCollector r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (r103.emit(r100, this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        r103 = (FlowCollector) this.L$0;
        Object[] r104 = (Object[]) this.L$1;
        Function2<Object[], Continuation<Object>, Object> r105 = this.$transform;
        this.L$0 = r103;
        this.label = 1;
        r100 = r105.invoke(r104, this);
        if (r100 != r101) goto L13;
        return r101;
    }

    public final Object invokeSuspend$$forInline(Object r100) {
        FlowCollector r101 = (FlowCollector) this.L$0;
        Object[] r102 = (Object[]) this.L$1;
        Object r103 = this.$transform.invoke(r102, this);
        InlineMarker.mark(0);
        r101.emit(r103, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
