package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R$\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R$\u0010 \u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013¨\u0006$"}, d2 = {"Landroidx/compose/material3/TimePickerStateImpl;", "Landroidx/compose/material3/TimePickerState;", "initialHour", "", "initialMinute", "is24Hour", "", "<init>", "(IIZ)V", "is24hour", "()Z", "set24hour", "(Z)V", "<set-?>", "Landroidx/compose/material3/TimePickerSelectionMode;", "selection", "getSelection-yecRtBI", "()I", "setSelection-6_8s6DQ", "(I)V", "selection$delegate", "Landroidx/compose/runtime/MutableState;", "hourState", "Landroidx/compose/runtime/MutableIntState;", "getHourState", "()Landroidx/compose/runtime/MutableIntState;", "minuteState", "getMinuteState", "value", "minute", "getMinute", "setMinute", "hour", "getHour", "setHour", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TimePickerStateImpl implements TimePickerState {
    public static final Companion Companion = null;
    private final MutableIntState hourState;
    private boolean is24hour;
    private final MutableIntState minuteState;
    private final MutableState selection$delegate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/TimePickerStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerStateImpl;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ List a(SaverScope r0, TimePickerStateImpl r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ TimePickerStateImpl b(List r0) {
            return Saver$lambda$1(r0);
        }

        public final Saver<TimePickerStateImpl, ?> Saver() {
            return SaverKt.Saver(new nw(), new ow());
        }

        private static final TimePickerStateImpl Saver$lambda$1(List r4) {
            Object r1 = ListProtector.get(r4, 0);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Int");
            int r2 = ((Integer) r1).intValue();
            Object r3 = ListProtector.get(r4, 1);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            int r5 = ((Integer) r3).intValue();
            Object r6 = ListProtector.get(r4, 2);
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Boolean");
            return new TimePickerStateImpl(r2, r5, ((Boolean) r6).booleanValue());
        }

        private static final List Saver$lambda$0(SaverScope r2, TimePickerStateImpl r3) {
            return CollectionsKt.listOf(new Object[]{Integer.valueOf(r3.getHour()), Integer.valueOf(r3.getMinute()), Boolean.valueOf(r3.is24hour())});
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHour() {
        return this.hourState.getIntValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinute() {
        return this.minuteState.getIntValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: getSelection-yecRtBI */
    public int mo2286getSelectionyecRtBI() {
        return ((TimePickerSelectionMode) this.selection$delegate.getValue()).m3438unboximpl();
    }

    public final MutableIntState getHourState() {
        return this.hourState;
    }

    public final MutableIntState getMinuteState() {
        return this.minuteState;
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean is24hour() {
        return this.is24hour;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void set24hour(boolean r1) {
        this.is24hour = r1;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHour(int r2) {
        this.hourState.setIntValue(r2);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinute(int r2) {
        this.minuteState.setIntValue(r2);
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: setSelection-6_8s6DQ */
    public void mo2288setSelection6_8s6DQ(int r2) {
        this.selection$delegate.setValue(TimePickerSelectionMode.m3432boximpl(r2));
    }

    public TimePickerStateImpl(int r4, int r5, boolean r6) {
        boolean r0 = true;
        if (r4 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L20;
        if (r5 >= 0) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == false) goto L18;
        this.is24hour = r6;
        this.selection$delegate = SnapshotStateKt.mutableStateOf$default(TimePickerSelectionMode.m3432boximpl(TimePickerSelectionMode.Companion.m3439getHouryecRtBI()), null, 2, null);
        this.hourState = SnapshotIntStateKt.mutableIntStateOf(r4);
        this.minuteState = SnapshotIntStateKt.mutableIntStateOf(r5);
        return;
    L18:
        throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
    L11:
        if (r5 >= 60) goto L13;
    L20:
        throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
    L5:
        if (r4 >= 24) goto L7;
        r2 = true;
        goto L8
    }
}
