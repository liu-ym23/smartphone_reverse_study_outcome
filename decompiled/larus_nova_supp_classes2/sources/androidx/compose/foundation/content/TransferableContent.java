package androidx.compose.foundation.content;

import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/content/TransferableContent;", "", "clipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "clipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "source", "Landroidx/compose/foundation/content/TransferableContent$Source;", "platformTransferableContent", "Landroidx/compose/foundation/content/PlatformTransferableContent;", "<init>", "(Landroidx/compose/ui/platform/ClipEntry;Landroidx/compose/ui/platform/ClipMetadata;ILandroidx/compose/foundation/content/PlatformTransferableContent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClipEntry", "()Landroidx/compose/ui/platform/ClipEntry;", "getClipMetadata", "()Landroidx/compose/ui/platform/ClipMetadata;", "getSource-kB6V9T0", "()I", "I", "getPlatformTransferableContent", "()Landroidx/compose/foundation/content/PlatformTransferableContent;", "Source", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransferableContent {
    public static final int $stable = 8;
    private final ClipEntry clipEntry;
    private final ClipMetadata clipMetadata;
    private final PlatformTransferableContent platformTransferableContent;
    private final int source;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/content/TransferableContent$Source;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Source {
        private static final int Clipboard = 0;
        public static final Companion Companion = null;
        private static final int DragAndDrop = 0;
        private static final int Keyboard = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/content/TransferableContent$Source$Companion;", "", "<init>", "()V", "Keyboard", "Landroidx/compose/foundation/content/TransferableContent$Source;", "getKeyboard-kB6V9T0", "()I", "I", "DragAndDrop", "getDragAndDrop-kB6V9T0", "Clipboard", "getClipboard-kB6V9T0", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            /* JADX INFO: renamed from: getClipboard-kB6V9T0, reason: not valid java name */
            public final int m464getClipboardkB6V9T0() {
                return Source.access$getClipboard$cp();
            }

            /* JADX INFO: renamed from: getDragAndDrop-kB6V9T0, reason: not valid java name */
            public final int m465getDragAndDropkB6V9T0() {
                return Source.access$getDragAndDrop$cp();
            }

            /* JADX INFO: renamed from: getKeyboard-kB6V9T0, reason: not valid java name */
            public final int m466getKeyboardkB6V9T0() {
                return Source.access$getKeyboard$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Source m457boximpl(int r1) {
            return new Source(r1);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m458constructorimpl(int r0) {
            return r0;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m459equalsimpl(int r2, Object r3) {
            if ((r3 instanceof Source) == true) goto L6;
            return false;
        L6:
            if (r2 == ((Source) r3).m463unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m460equalsimpl0(int r0, int r1) {
            if (r0 != r1) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m461hashCodeimpl(int r0) {
            return r0;
        }

        public boolean equals(Object r2) {
            return m459equalsimpl(this.value, r2);
        }

        public int hashCode() {
            return m461hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m463unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            Keyboard = m458constructorimpl(0);
            DragAndDrop = m458constructorimpl(1);
            Clipboard = m458constructorimpl(2);
        }

        public String toString() {
            return m462toStringimpl(this.value);
        }

        public static final /* synthetic */ int access$getClipboard$cp() {
            return Clipboard;
        }

        public static final /* synthetic */ int access$getDragAndDrop$cp() {
            return DragAndDrop;
        }

        public static final /* synthetic */ int access$getKeyboard$cp() {
            return Keyboard;
        }

        private /* synthetic */ Source(int r1) {
            this.value = r1;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m462toStringimpl(int r2) {
            if (m460equalsimpl0(r2, Keyboard) == false) goto L6;
            return "Source.Keyboard";
        L6:
            if (m460equalsimpl0(r2, DragAndDrop) == false) goto L9;
            return "Source.DragAndDrop";
        L9:
            if (m460equalsimpl0(r2, Clipboard) == false) goto L12;
            return "Source.Clipboard";
        L12:
            return "Invalid (" + r2 + ')';
        }
    }

    public /* synthetic */ TransferableContent(ClipEntry r1, ClipMetadata r2, int r3, PlatformTransferableContent r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public final ClipEntry getClipEntry() {
        return this.clipEntry;
    }

    public final ClipMetadata getClipMetadata() {
        return this.clipMetadata;
    }

    public final PlatformTransferableContent getPlatformTransferableContent() {
        return this.platformTransferableContent;
    }

    /* JADX INFO: renamed from: getSource-kB6V9T0, reason: not valid java name */
    public final int m456getSourcekB6V9T0() {
        return this.source;
    }

    private TransferableContent(ClipEntry r1, ClipMetadata r2, int r3, PlatformTransferableContent r4) {
        this.clipEntry = r1;
        this.clipMetadata = r2;
        this.source = r3;
        this.platformTransferableContent = r4;
    }

    public /* synthetic */ TransferableContent(ClipEntry r7, ClipMetadata r8, int r9, PlatformTransferableContent r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 8) == 0) goto L5;
        r10 = null;
    L5:
        this(r7, r8, r9, r10, null);
    }
}
