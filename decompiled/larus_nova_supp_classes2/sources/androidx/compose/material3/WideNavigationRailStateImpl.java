package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 !2\u00020\u0001:\u0001!B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001e\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\n¨\u0006\""}, d2 = {"Landroidx/compose/material3/WideNavigationRailStateImpl;", "Landroidx/compose/material3/WideNavigationRailState;", "initialValue", "Landroidx/compose/material3/WideNavigationRailValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/animation/core/AnimationSpec;)V", "getInitialValue", "()Landroidx/compose/material3/WideNavigationRailValue;", "setInitialValue", "(Landroidx/compose/material3/WideNavigationRailValue;)V", "internalValue", "internalState", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "_currentVal", "Landroidx/compose/runtime/State;", "isAnimating", "", "()Z", "targetValue", "getTargetValue", "currentValue", "getCurrentValue", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "toggle", "snapTo", "(Landroidx/compose/material3/WideNavigationRailValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailStateImpl implements WideNavigationRailState {
    public static final int $stable = 0;
    private static final float Collapsed = 0.0f;
    public static final Companion Companion = null;
    private static final float Expanded = 1.0f;
    private final State<WideNavigationRailValue> _currentVal;
    private final AnimationSpec<Float> animationSpec;
    private WideNavigationRailValue initialValue;
    private final Animatable<Float, AnimationVector1D> internalState;
    private final float internalValue;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/material3/WideNavigationRailStateImpl$Companion;", "", "<init>", "()V", "Collapsed", "", "Expanded", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/WideNavigationRailState;", "Landroidx/compose/material3/WideNavigationRailValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ WideNavigationRailValue a(SaverScope r0, WideNavigationRailState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ WideNavigationRailState b(AnimationSpec r0, WideNavigationRailValue r1) {
            return Saver$lambda$1(r0, r1);
        }

        public final Saver<WideNavigationRailState, WideNavigationRailValue> Saver(final AnimationSpec<Float> r3) {
            return SaverKt.Saver(new qy(), new ry(r3));
        }

        private static final WideNavigationRailValue Saver$lambda$0(SaverScope r0, WideNavigationRailState r1) {
            return r1.getTargetValue();
        }

        private static final WideNavigationRailState Saver$lambda$1(AnimationSpec r1, WideNavigationRailValue r2) {
            return new WideNavigationRailStateImpl(r2, r1);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public static /* synthetic */ WideNavigationRailValue a(WideNavigationRailStateImpl r0) {
        return _currentVal$lambda$0(r0);
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public WideNavigationRailValue getCurrentValue() {
        return (WideNavigationRailValue) this._currentVal.getValue();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public WideNavigationRailValue getTargetValue() {
        if (this.internalState.getTargetValue().floatValue() != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return WideNavigationRailValue.Expanded;
    L9:
        return WideNavigationRailValue.Collapsed;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public boolean isAnimating() {
        return this.internalState.isRunning();
    }

    public final WideNavigationRailValue getInitialValue() {
        return this.initialValue;
    }

    private static final WideNavigationRailValue _currentVal$lambda$0(WideNavigationRailStateImpl r1) {
        if (r1.internalState.getValue().floatValue() != 1.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return WideNavigationRailValue.Expanded;
    L9:
        return WideNavigationRailValue.Collapsed;
    L5:
        r2 = false;
        goto L6
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object collapse(Continuation<? super Unit> r9) {
        Object r10 = Animatable.animateTo$default(this.internalState, Boxing.boxFloat(0.0f), this.animationSpec, null, null, r9, 12, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object expand(Continuation<? super Unit> r9) {
        Object r10 = Animatable.animateTo$default(this.internalState, Boxing.boxFloat(1.0f), this.animationSpec, null, null, r9, 12, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final void setInitialValue(WideNavigationRailValue r1) {
        this.initialValue = r1;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object toggle(Continuation<? super Unit> r9) {
        Animatable<Float, AnimationVector1D> r0 = this.internalState;
        if (WideNavigationRailStateKt.isExpanded(getTargetValue()) == false) goto L5;
        float r1 = 0.0f;
    L6:
        Object r10 = Animatable.animateTo$default(r0, Boxing.boxFloat(r1), this.animationSpec, null, null, r9, 12, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r10;
    L10:
        return Unit.INSTANCE;
    L5:
        r1 = 1.0f;
        goto L6
    }

    public WideNavigationRailStateImpl(WideNavigationRailValue r8, AnimationSpec<Float> r9) {
        this.initialValue = r8;
        this.animationSpec = r9;
        if (WideNavigationRailStateKt.isExpanded(r8) == false) goto L5;
        float r10 = 1.0f;
    L6:
        this.internalValue = r10;
        this.internalState = new Animatable(Float.valueOf(r10), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        this._currentVal = SnapshotStateKt.derivedStateOf(new py(this));
        return;
    L5:
        r10 = 0.0f;
        goto L6
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object snapTo(WideNavigationRailValue r2, Continuation<? super Unit> r3) {
        if (WideNavigationRailStateKt.isExpanded(r2) == false) goto L5;
        float r4 = 1.0f;
    L6:
        Object r5 = this.internalState.snapTo(Boxing.boxFloat(r4), r3);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r5;
    L10:
        return Unit.INSTANCE;
    L5:
        r4 = 0.0f;
        goto L6
    }
}
