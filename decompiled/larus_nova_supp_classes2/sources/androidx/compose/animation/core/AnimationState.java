package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004BM\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010+\u001a\u00020,H\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u0001@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R$\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010&\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b*\u0010\u0015¨\u0006-"}, d2 = {"Landroidx/compose/animation/core/AnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "", "<init>", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue$animation_core", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core", "(Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationVector;", "getLastFrameTimeNanos", "()J", "setLastFrameTimeNanos$animation_core", "(J)V", "getFinishedTimeNanos", "setFinishedTimeNanos$animation_core", "()Z", "setRunning$animation_core", "(Z)V", "velocity", "getVelocity", "toString", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationState<T, V extends AnimationVector> implements State<T> {
    public static final int $stable = 0;
    private long finishedTimeNanos;
    private boolean isRunning;
    private long lastFrameTimeNanos;
    private final TwoWayConverter<T, V> typeConverter;
    private final MutableState value$delegate;
    private V velocityVector;

    public T getValue() {
        return (T) this.value$delegate.getValue();
    }

    public final T getVelocity() {
        return (T) this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public String toString() {
        return "AnimationState(value=" + getValue() + ", velocity=" + getVelocity() + ", isRunning=" + this.isRunning + ", lastFrameTimeNanos=" + this.lastFrameTimeNanos + ", finishedTimeNanos=" + this.finishedTimeNanos + ')';
    }

    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final V getVelocityVector() {
        return this.velocityVector;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final void setFinishedTimeNanos$animation_core(long r1) {
        this.finishedTimeNanos = r1;
    }

    public final void setLastFrameTimeNanos$animation_core(long r1) {
        this.lastFrameTimeNanos = r1;
    }

    public final void setRunning$animation_core(boolean r1) {
        this.isRunning = r1;
    }

    public void setValue$animation_core(T r2) {
        this.value$delegate.setValue(r2);
    }

    public final void setVelocityVector$animation_core(V r1) {
        this.velocityVector = r1;
    }

    public AnimationState(TwoWayConverter<T, V> r3, T r4, V r5, long r6, long r8, boolean r10) {
        this.typeConverter = r3;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        if (r5 == null) goto L6;
        V r7 = (V) AnimationVectorsKt.copy(r5);
        if (r7 == null) goto L6;
    L7:
        this.velocityVector = r7;
        this.lastFrameTimeNanos = r6;
        this.finishedTimeNanos = r8;
        this.isRunning = r10;
        return;
    L6:
        r7 = (V) AnimationStateKt.createZeroVectorFrom(r3, r4);
        goto L7
    }

    public /* synthetic */ AnimationState(TwoWayConverter r11, Object r12, AnimationVector r13, long r14, long r16, boolean r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 4) == 0) goto L5;
        AnimationVector r4 = null;
    L7:
        if ((r19 & 8) == 0) goto L9;
        long r5 = Long.MIN_VALUE;
    L11:
        if ((r19 & 16) == 0) goto L13;
        long r7 = Long.MIN_VALUE;
    L15:
        if ((r19 & 32) == 0) goto L17;
        boolean r9 = false;
    L18:
        this(r11, r12, r4, r5, r7, r9);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }
}
