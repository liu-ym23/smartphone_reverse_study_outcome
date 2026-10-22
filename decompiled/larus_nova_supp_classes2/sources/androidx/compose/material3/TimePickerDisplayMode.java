package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/TimePickerDisplayMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TimePickerDisplayMode {
    public static final Companion Companion = null;
    private static final int Input = 0;
    private static final int Picker = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/TimePickerDisplayMode$Companion;", "", "<init>", "()V", "Picker", "Landroidx/compose/material3/TimePickerDisplayMode;", "getPicker--ONbchU", "()I", "I", "Input", "getInput--ONbchU", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getInput--ONbchU, reason: not valid java name */
        public final int m3404getInputONbchU() {
            return TimePickerDisplayMode.access$getInput$cp();
        }

        /* JADX INFO: renamed from: getPicker--ONbchU, reason: not valid java name */
        public final int m3405getPickerONbchU() {
            return TimePickerDisplayMode.access$getPicker$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TimePickerDisplayMode m3397boximpl(int r1) {
        return new TimePickerDisplayMode(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3398constructorimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3399equalsimpl(int r2, Object r3) {
        if ((r3 instanceof TimePickerDisplayMode) == true) goto L6;
        return false;
    L6:
        if (r2 == ((TimePickerDisplayMode) r3).m3403unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3400equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3401hashCodeimpl(int r0) {
        return r0;
    }

    public boolean equals(Object r2) {
        return m3399equalsimpl(this.value, r2);
    }

    public int hashCode() {
        return m3401hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3403unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Picker = m3398constructorimpl(0);
        Input = m3398constructorimpl(1);
    }

    public String toString() {
        return m3402toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getInput$cp() {
        return Input;
    }

    public static final /* synthetic */ int access$getPicker$cp() {
        return Picker;
    }

    private /* synthetic */ TimePickerDisplayMode(int r1) {
        this.value = r1;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3402toStringimpl(int r1) {
        if (m3400equalsimpl0(r1, Picker) == false) goto L6;
        return "Picker";
    L6:
        if (m3400equalsimpl0(r1, Input) == false) goto L8;
        return "Input";
    L8:
        return "Unknown";
    }
}
