package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/UndoManager;", "", "maxStoredCharacters", "", "<init>", "(I)V", "getMaxStoredCharacters", "()I", "undoStack", "Landroidx/compose/foundation/text/UndoManager$Entry;", "redoStack", "storedCharacters", "lastSnapshot", "", "Ljava/lang/Long;", "forceNextSnapshot", "", "snapshotIfNeeded", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "now", "makeSnapshot", "removeLastUndo", "undo", "redo", "Entry", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UndoManager {
    public static final int $stable = 8;
    private boolean forceNextSnapshot;
    private Long lastSnapshot;
    private final int maxStoredCharacters;
    private Entry redoStack;
    private int storedCharacters;
    private Entry undoStack;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/text/UndoManager$Entry;", "", "next", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "<init>", "(Landroidx/compose/foundation/text/UndoManager$Entry;Landroidx/compose/ui/text/input/TextFieldValue;)V", "getNext", "()Landroidx/compose/foundation/text/UndoManager$Entry;", "setNext", "(Landroidx/compose/foundation/text/UndoManager$Entry;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Entry {
        private Entry next;
        private TextFieldValue value;

        public final Entry getNext() {
            return this.next;
        }

        public final TextFieldValue getValue() {
            return this.value;
        }

        public final void setNext(Entry r1) {
            this.next = r1;
        }

        public final void setValue(TextFieldValue r1) {
            this.value = r1;
        }

        public Entry(Entry r1, TextFieldValue r2) {
            this.next = r1;
            this.value = r2;
        }

        public /* synthetic */ Entry(Entry r1, TextFieldValue r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1, r2);
        }
    }

    public UndoManager() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public final void forceNextSnapshot() {
        this.forceNextSnapshot = true;
    }

    private final void removeLastUndo() {
        Entry r0 = this.undoStack;
        if (r0 == null) goto L5;
        Entry r2 = r0.getNext();
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (r0 == null) goto L12;
        Entry r3 = r0.getNext();
        if (r3 == null) goto L12;
        Entry r4 = r3.getNext();
    L13:
        if (r4 == null) goto L15;
        r0 = r0.getNext();
        goto L8
    L15:
        if (r0 == null) goto L19;
        r0.setNext(null);
        return;
    L19:
        return;
    L12:
        r4 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final TextFieldValue redo() {
        Entry r0 = this.redoStack;
        if (r0 == null) goto L5;
        this.redoStack = r0.getNext();
        this.undoStack = new Entry(this.undoStack, r0.getValue());
        this.storedCharacters += r0.getValue().getText().length();
        return r0.getValue();
    L5:
        return null;
    }

    public final TextFieldValue undo() {
        Entry r0 = this.undoStack;
        if (r0 == null) goto L8;
        Entry r2 = r0.getNext();
        if (r2 == null) goto L9;
        this.undoStack = r2;
        this.storedCharacters -= r0.getValue().getText().length();
        this.redoStack = new Entry(this.redoStack, r0.getValue());
        return r2.getValue();
    L9:
        return null;
    L8:
        return null;
    }

    public final int getMaxStoredCharacters() {
        return this.maxStoredCharacters;
    }

    public UndoManager(int r1) {
        this.maxStoredCharacters = r1;
    }

    public final void makeSnapshot(TextFieldValue r4) {
        this.forceNextSnapshot = false;
        Entry r0 = this.undoStack;
        if (r0 == null) goto L5;
        TextFieldValue r1 = r0.getValue();
    L7:
        if (Intrinsics.areEqual(r4, r1) == false) goto L9;
        return;
    L9:
        String r2 = r4.getText();
        Entry r3 = this.undoStack;
        if (r3 == null) goto L14;
        TextFieldValue r5 = r3.getValue();
        if (r5 == null) goto L14;
        String r6 = r5.getText();
    L16:
        if (Intrinsics.areEqual(r2, r6) == false) goto L21;
        Entry r7 = this.undoStack;
        if (r7 == null) goto L25;
        r7.setValue(r4);
        return;
    L25:
        return;
    L21:
        this.undoStack = new Entry(this.undoStack, r4);
        this.redoStack = null;
        int r8 = this.storedCharacters + r4.getText().length();
        this.storedCharacters = r8;
        if (r8 <= this.maxStoredCharacters) goto L26;
        removeLastUndo();
        return;
    L26:
        return;
    L14:
        r6 = null;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public final void snapshotIfNeeded(TextFieldValue r5, long r6) {
        if (this.forceNextSnapshot == true) goto L10;
        Long r0 = this.lastSnapshot;
        if (r0 == null) goto L7;
        long r1 = r0.longValue();
    L9:
        if (r6 > (r1 + ((long) UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS()))) goto L10;
        return;
    L7:
        r1 = 0;
    L10:
        this.lastSnapshot = Long.valueOf(r6);
        makeSnapshot(r5);
    }

    public /* synthetic */ UndoManager(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 100000;
    L5:
        this(r1);
    }

    public static /* synthetic */ void snapshotIfNeeded$default(UndoManager r0, TextFieldValue r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = UndoManager_jvmKt.timeNowMillis();
    L5:
        r0.snapshotIfNeeded(r1, r2);
    }
}
