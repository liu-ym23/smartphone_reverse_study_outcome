package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/text/input/TextObfuscationMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TextObfuscationMode {
    public static final Companion Companion = null;
    private static final int Hidden = 0;
    private static final int RevealLastTyped = 0;
    private static final int Visible = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/input/TextObfuscationMode$Companion;", "", "<init>", "()V", "Visible", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "getVisible-vTwcZD0", "()I", "I", "RevealLastTyped", "getRevealLastTyped-vTwcZD0", "Hidden", "getHidden-vTwcZD0", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getHidden-vTwcZD0, reason: not valid java name */
        public final int m1558getHiddenvTwcZD0() {
            return TextObfuscationMode.access$getHidden$cp();
        }

        /* JADX INFO: renamed from: getRevealLastTyped-vTwcZD0, reason: not valid java name */
        public final int m1559getRevealLastTypedvTwcZD0() {
            return TextObfuscationMode.access$getRevealLastTyped$cp();
        }

        /* JADX INFO: renamed from: getVisible-vTwcZD0, reason: not valid java name */
        public final int m1560getVisiblevTwcZD0() {
            return TextObfuscationMode.access$getVisible$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextObfuscationMode m1551boximpl(int r1) {
        return new TextObfuscationMode(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1552constructorimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1553equalsimpl(int r2, Object r3) {
        if ((r3 instanceof TextObfuscationMode) == true) goto L6;
        return false;
    L6:
        if (r2 == ((TextObfuscationMode) r3).m1557unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1554equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1555hashCodeimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1556toStringimpl(int r2) {
        return "TextObfuscationMode(value=" + r2 + ')';
    }

    public boolean equals(Object r2) {
        return m1553equalsimpl(this.value, r2);
    }

    public int hashCode() {
        return m1555hashCodeimpl(this.value);
    }

    public String toString() {
        return m1556toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1557unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Visible = m1552constructorimpl(0);
        RevealLastTyped = m1552constructorimpl(1);
        Hidden = m1552constructorimpl(2);
    }

    public static final /* synthetic */ int access$getHidden$cp() {
        return Hidden;
    }

    public static final /* synthetic */ int access$getRevealLastTyped$cp() {
        return RevealLastTyped;
    }

    public static final /* synthetic */ int access$getVisible$cp() {
        return Visible;
    }

    public final int getValue() {
        return this.value;
    }

    private /* synthetic */ TextObfuscationMode(int r1) {
        this.value = r1;
    }
}
