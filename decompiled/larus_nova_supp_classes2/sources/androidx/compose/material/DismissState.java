package androidx.compose.material;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/DismissState;", "Landroidx/compose/material/SwipeableState;", "Landroidx/compose/material/DismissValue;", "initialValue", "confirmStateChange", "Lkotlin/Function1;", "", "<init>", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;)V", "dismissDirection", "Landroidx/compose/material/DismissDirection;", "getDismissDirection", "()Landroidx/compose/material/DismissDirection;", "isDismissed", "direction", "reset", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "(Landroidx/compose/material/DismissDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DismissState extends SwipeableState<DismissValue> {
    public static final int $stable = 0;
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/DismissState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/DismissState;", "Landroidx/compose/material/DismissValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ DismissValue a(SaverScope r0, DismissState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ DismissState b(Function1 r0, DismissValue r1) {
            return Saver$lambda$1(r0, r1);
        }

        public final Saver<DismissState, DismissValue> Saver(final Function1<? super DismissValue, Boolean> r3) {
            return SaverKt.Saver(new e3(), new f3(r3));
        }

        private static final DismissValue Saver$lambda$0(SaverScope r0, DismissState r1) {
            return r1.getCurrentValue();
        }

        private static final DismissState Saver$lambda$1(Function1 r1, DismissValue r2) {
            return new DismissState(r2, r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(DismissValue r0) {
        return true;
    }

    public static /* synthetic */ boolean e(DismissValue r0) {
        return _init_$lambda$0(r0);
    }

    public final DismissDirection getDismissDirection() {
        if (((Number) getOffset().getValue()).floatValue() != androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        if (((Number) getOffset().getValue()).floatValue() <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L12;
        return DismissDirection.StartToEnd;
    L12:
        return DismissDirection.EndToStart;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean isDismissed(DismissDirection r3) {
        DismissValue r0 = getCurrentValue();
        if (r3 != DismissDirection.StartToEnd) goto L5;
        DismissValue r4 = DismissValue.DismissedToEnd;
    L6:
        if (r0 != r4) goto L8;
        return true;
    L8:
        return false;
    L5:
        r4 = DismissValue.DismissedToStart;
        goto L6
    }

    public final Object reset(Continuation<? super Unit> r7) {
        Object r8 = SwipeableState.animateTo$default(this, DismissValue.Default, null, r7, 2, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public DismissState(DismissValue r7, Function1<? super DismissValue, Boolean> r8) {
        super(r7, null, r8, 2, null);
    }

    public final Object dismiss(DismissDirection r7, Continuation<? super Unit> r8) {
        if (r7 != DismissDirection.StartToEnd) goto L5;
        DismissValue r9 = DismissValue.DismissedToEnd;
    L6:
        Object r10 = SwipeableState.animateTo$default(this, r9, null, r8, 2, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r10;
    L10:
        return Unit.INSTANCE;
    L5:
        r9 = DismissValue.DismissedToStart;
        goto L6
    }

    public /* synthetic */ DismissState(DismissValue r1, Function1 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new d3();
    L5:
        this(r1, r2);
    }
}
