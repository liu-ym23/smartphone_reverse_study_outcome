package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", MapMonitorConst.ATTEMPT, ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<FlowCollector<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$retry$3(long r100, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> r101, Continuation<? super FlowKt__ErrorsKt$retry$3> r102) {
        this.$retries = r100;
        this.$predicate = r101;
        super(4, r102);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Throwable r101, Long r102, Continuation<? super Boolean> r110) {
        return invoke(r100, r101, r102.longValue(), r110);
    }

    public final Object invoke(FlowCollector<Object> r100, Throwable r101, long r102, Continuation<? super Boolean> r103) {
        FlowKt__ErrorsKt$retry$3 r104 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, r103);
        r104.L$0 = r101;
        r104.J$0 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        if (((Boolean) r100).booleanValue() == true) goto L18;
    L16:
        r103 = false;
    L18:
        return Boxing.boxBoolean(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Throwable r104 = (Throwable) this.L$0;
        if (this.J$0 >= this.$retries) goto L16;
        Function2<Throwable, Continuation<? super Boolean>, Object> r105 = this.$predicate;
        this.label = 1;
        r100 = r105.invoke(r104, this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
