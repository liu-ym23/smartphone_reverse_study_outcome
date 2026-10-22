package androidx.compose.material.pullrefresh;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Be\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00040\u0003\u00121\u0010\b\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b\u001f\u0010 R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\b\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPull", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "pullDelta", "onRelease", "Lkotlin/Function2;", "flingVelocity", "Lkotlin/coroutines/Continuation;", "", "enabled", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Z)V", "Lkotlin/jvm/functions/Function2;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PullRefreshNestedScrollConnection implements NestedScrollConnection {
    private final boolean enabled;
    private final Function1<Float, Float> onPull;
    private final Function2<Float, Continuation<? super Float>, Object> onRelease;

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public final /* synthetic */ Object m2254onPostFlingRZ2iAVY(long r1, long r3, Continuation r5) {
        return NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, r1, r3, r5);
    }

    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object m2256onPreFlingQWom1Mo(long r5, Continuation<? super Velocity> r7) {
        if ((r7 instanceof PullRefreshNestedScrollConnection$onPreFling$1) == false) goto L7;
        PullRefreshNestedScrollConnection$onPreFling$1 r0 = (PullRefreshNestedScrollConnection$onPreFling$1) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        float r6 = r0.F$0;
        ResultKt.throwOnFailure(r8);
    L19:
        return Velocity.box-impl(VelocityKt.Velocity(r6, ((Number) r8).floatValue()));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Function2<Float, Continuation<? super Float>, Object> r9 = this.onRelease;
        Float r10 = Boxing.boxFloat(Velocity.getY-impl(r5));
        r0.F$0 = MenuKt.ClosedAlphaTarget;
        r0.label = 1;
        r8 = r9.invoke(r10, r0);
        if (r8 != r2) goto L17;
        return r2;
    L17:
        r6 = MenuKt.ClosedAlphaTarget;
    L7:
        r0 = new PullRefreshNestedScrollConnection$onPreFling$1(this, r7);
        goto L8
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m2257onPreScrollOzD1aCk(long r5, int r7) {
        if (this.enabled == true) goto L6;
        return Offset.Companion.getZero-F1C5BW0();
    L6:
        if (NestedScrollSource.equals-impl0(r7, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L11;
        int r6 = (int) (r5 & 4294967295L);
        if (Float.intBitsToFloat(r6) >= MenuKt.ClosedAlphaTarget) goto L11;
        float r8 = ((Number) this.onPull.invoke(Float.valueOf(Float.intBitsToFloat(r6)))).floatValue();
        return Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (4294967295L & Float.floatToRawIntBits(r8)));
    L11:
        return Offset.Companion.getZero-F1C5BW0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PullRefreshNestedScrollConnection(Function1<? super Float, Float> r1, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> r2, boolean r3) {
        this.onPull = r1;
        this.onRelease = r2;
        this.enabled = r3;
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m2255onPostScrollDzOQY0M(long r3, long r5, int r7) {
        if (this.enabled == true) goto L6;
        return Offset.Companion.getZero-F1C5BW0();
    L6:
        if (NestedScrollSource.equals-impl0(r7, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L11;
        int r6 = (int) (r5 & 4294967295L);
        if (Float.intBitsToFloat(r6) <= MenuKt.ClosedAlphaTarget) goto L11;
        float r8 = ((Number) this.onPull.invoke(Float.valueOf(Float.intBitsToFloat(r6)))).floatValue();
        long r9 = Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget);
        return Offset.constructor-impl((4294967295L & Float.floatToRawIntBits(r8)) | (r9 << 32));
    L11:
        return Offset.Companion.getZero-F1C5BW0();
    }
}
