package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperationKt;
import androidx.compose.foundation.text.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u0017H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager;", "", "initialStagingUndo", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undoManager", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;Landroidx/compose/foundation/text/input/internal/undo/UndoManager;)V", "<set-?>", "stagingUndo", "getStagingUndo", "()Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "setStagingUndo", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)V", "stagingUndo$delegate", "Landroidx/compose/runtime/MutableState;", "canUndo", "", "getCanUndo", "()Z", "canRedo", "getCanRedo", "undo", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "redo", "record", "op", "clearHistory", "flush", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextUndoManager {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final MutableState stagingUndo$delegate;
    private final UndoManager<TextUndoOperation> undoManager;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager$Companion;", "", "<init>", "()V", "Saver", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R \u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager$Companion$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextUndoManager;", "", "<init>", "()V", "undoManagerSaver", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "value", "restore", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextUndoManager, Object> {
            public static final int $stable = 0;
            public static final Saver INSTANCE = null;
            private static final androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object> undoManagerSaver = null;

            private Saver() {
            }

            static {
                INSTANCE = new Saver();
                UndoManager.Companion r0 = UndoManager.Companion;
                final androidx.compose.runtime.saveable.Saver<TextUndoOperation, Object> r1 = TextUndoOperation.Companion.getSaver();
                undoManagerSaver = new TextUndoManager$Companion$Saver$special$$inlined$createSaver$1(r1);
                $stable = 8;
            }

            public TextUndoManager restore(Object r3) {
                Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List r4 = (List) r3;
                Object r0 = ListProtector.get(r4, 0);
                Object r5 = ListProtector.get(r4, 1);
                if (r0 == null) goto L5;
                TextUndoOperation r1 = (TextUndoOperation) TextUndoOperation.Companion.getSaver().restore(r0);
            L6:
                androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object> r2 = undoManagerSaver;
                Intrinsics.checkNotNull(r5);
                UndoManager r6 = (UndoManager) r2.restore(r5);
                Intrinsics.checkNotNull(r6);
                return new TextUndoManager(r1, r6);
            L5:
                r1 = null;
                goto L6
            }

            /* JADX INFO: renamed from: restore, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1561restore(Object r1) {
                return restore(r1);
            }

            public Object save(SaverScope r4, TextUndoManager r5) {
                Object[] r0 = new Object[2];
                TextUndoOperation r1 = TextUndoManager.access$getStagingUndo(r5);
                if (r1 == null) goto L5;
                Object r2 = TextUndoOperation.Companion.getSaver().save(r4, r1);
            L6:
                r0[0] = r2;
                r0[1] = undoManagerSaver.save(r4, TextUndoManager.access$getUndoManager$p(r5));
                return CollectionsKt.listOf(r0);
            L5:
                r2 = null;
                goto L6
            }

            public /* bridge */ /* synthetic */ Object save(SaverScope r1, Object r2) {
                return save(r1, (TextUndoManager) r2);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextUndoManager() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public final void clearHistory() {
        setStagingUndo(null);
        this.undoManager.clearHistory();
    }

    private final void flush() {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r3 = r1.getReadObserver();
    L6:
        Snapshot r4 = r0.makeCurrentNonObservable(r1);
        TextUndoOperation r5 = getStagingUndo();     // Catch: Throwable -> L13
        r0.restoreNonObservable(r1, r4, r3);
        if (r5 == null) goto L11;
        this.undoManager.record(r5);
    L11:
        setStagingUndo(null);
        return;
    L13:
        th = move-exception;
        r0.restoreNonObservable(r1, r4, r3);
        throw th;
    L5:
        r3 = null;
        goto L6
    }

    private final TextUndoOperation getStagingUndo() {
        return (TextUndoOperation) this.stagingUndo$delegate.getValue();
    }

    public final boolean getCanRedo() {
        if (this.undoManager.getCanRedo$foundation_release() == true) goto L5;
    L7:
        return false;
    L5:
        if (getStagingUndo() != null) goto L7;
        return true;
    }

    public final boolean getCanUndo() {
        if (this.undoManager.getCanUndo$foundation_release() == false) goto L5;
    L8:
        return true;
    L5:
        if (getStagingUndo() != null) goto L8;
        return false;
    }

    public static final /* synthetic */ TextUndoOperation access$getStagingUndo(TextUndoManager r0) {
        return r0.getStagingUndo();
    }

    public static final /* synthetic */ UndoManager access$getUndoManager$p(TextUndoManager r0) {
        return r0.undoManager;
    }

    private final void setStagingUndo(TextUndoOperation r2) {
        this.stagingUndo$delegate.setValue(r2);
    }

    public final void record(TextUndoOperation r6) {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
        TextUndoOperation r4 = getStagingUndo();     // Catch: Throwable -> L18
        r0.restoreNonObservable(r1, r3, r2);
        if (r4 != null) goto L12;
        setStagingUndo(r6);
        return;
    L12:
        TextUndoOperation r5 = TextUndoManagerKt.merge(r4, r6);
        if (r5 == null) goto L16;
        setStagingUndo(r5);
        return;
    L16:
        flush();
        setStagingUndo(r6);
        return;
    L18:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L5:
        r2 = null;
        goto L6
    }

    public final void redo(TextFieldState r2) {
        if (getCanRedo() == true) goto L5;
        return;
    L5:
        TextUndoOperationKt.redo(r2, this.undoManager.redo());
    }

    public final void undo(TextFieldState r2) {
        if (getCanUndo() == true) goto L5;
        return;
    L5:
        flush();
        TextUndoOperationKt.undo(r2, this.undoManager.undo());
    }

    public TextUndoManager(TextUndoOperation r2, UndoManager<TextUndoOperation> r3) {
        this.undoManager = r3;
        this.stagingUndo$delegate = SnapshotStateKt.mutableStateOf$default(r2, null, 2, null);
    }

    public /* synthetic */ TextUndoManager(TextUndoOperation r7, UndoManager r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r8 = new UndoManager(null, null, 100, 3, null);
    L8:
        this(r7, r8);
    }
}
