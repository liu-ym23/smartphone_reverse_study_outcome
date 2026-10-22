package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\\]B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\"\u0010/\u001a\u0002002\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0086\bJ\b\u00104\u001a\u00020\u0003H\u0016J\b\u0010:\u001a\u00020\u000fH\u0001J\u0010\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020\u000fH\u0001J\b\u0010=\u001a\u000200H\u0001JE\u0010>\u001a\u0002002\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u00172\b\b\u0002\u0010B\u001a\u00020C2\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0080\b¢\u0006\u0002\bDJ'\u0010E\u001a\u0002002\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0080\b¢\u0006\u0002\bFJ&\u0010G\u001a\u0002002\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u00172\b\b\u0002\u0010B\u001a\u00020CH\u0002J \u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u0017H\u0002J(\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020N2\u0006\u0010B\u001a\u00020CH\u0002J\u0015\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bRJ\u0015\u0010S\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bTJ%\u0010U\u001a\u0002002\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u0017H\u0001¢\u0006\u0002\bYR\u0014\u0010\u000b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u001e8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u001d\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u00105\u001a\u0002068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0011\u001a\u0004\b8\u00109R\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020Q0[X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "initialTextUndoManager", "Landroidx/compose/foundation/text/input/TextUndoManager;", "<init>", "(Ljava/lang/String;JLandroidx/compose/foundation/text/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "textUndoManager", "getTextUndoManager$foundation_release", "()Landroidx/compose/foundation/text/input/TextUndoManager;", "mainBuffer", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "getMainBuffer$foundation_release$annotations", "()V", "getMainBuffer$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldBuffer;", "setMainBuffer$foundation_release", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "<set-?>", "", "isEditing", "()Z", "setEditing", "(Z)V", "isEditing$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "getValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "setValue", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;)V", "value$delegate", "text", "", "getText", "()Ljava/lang/CharSequence;", "selection", "getSelection-d9O1mEE", "()J", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "edit", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toString", "undoState", "Landroidx/compose/foundation/text/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text/input/UndoState;", "startEdit", "commitEdit", "newValue", "finishEditing", "editAsUser", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "restartImeIfContentChanges", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "editAsUser$foundation_release", "editWithNoSideEffects", "editWithNoSideEffects$foundation_release", "commitEditAsUser", "updateValueAndNotifyListeners", "oldValue", "recordEditForUndo", "previousValue", "postValue", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "addNotifyImeListener", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "addNotifyImeListener$foundation_release", "removeNotifyImeListener", "removeNotifyImeListener$foundation_release", "syncMainBufferToTemporaryBuffer", "temporaryBuffer", "textChanged", "selectionChanged", "syncMainBufferToTemporaryBuffer$foundation_release", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "NotifyImeListener", "Saver", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldState {
    public static final int $stable = 0;
    private final MutableState isEditing$delegate;
    private TextFieldBuffer mainBuffer;
    private final MutableVector<NotifyImeListener> notifyImeListeners;
    private final TextUndoManager textUndoManager;
    private final UndoState undoState;
    private final MutableState value$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "newValue", "restartIme", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface NotifyImeListener {
        void onChange(TextFieldCharSequence r1, TextFieldCharSequence r2, boolean r3);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextFieldState;", "", "<init>", "()V", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "value", "restore", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {
        public static final int $stable = 0;
        public static final Saver INSTANCE = null;

        static {
            INSTANCE = new Saver();
        }

        private Saver() {
        }

        public TextFieldState restore(Object r11) {
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List r12 = (List) r11;
            Object r0 = ListProtector.get(r12, 0);
            Object r1 = ListProtector.get(r12, 1);
            Object r2 = ListProtector.get(r12, 2);
            Object r13 = ListProtector.get(r12, 3);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.String");
            String r5 = (String) r0;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Int");
            int r3 = ((Integer) r1).intValue();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
            long r6 = TextRangeKt.TextRange(r3, ((Integer) r2).intValue());
            TextUndoManager.Companion.Saver r4 = TextUndoManager.Companion.Saver.INSTANCE;
            Intrinsics.checkNotNull(r13);
            TextUndoManager r8 = r4.restore(r13);
            Intrinsics.checkNotNull(r8);
            return new TextFieldState(r5, r6, r8, null);
        }

        /* JADX INFO: renamed from: restore, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1538restore(Object r1) {
            return restore(r1);
        }

        public Object save(SaverScope r4, TextFieldState r5) {
            return CollectionsKt.listOf(new Object[]{r5.getText().toString(), Integer.valueOf(TextRange.getStart-impl(r5.m1537getSelectiond9O1mEE())), Integer.valueOf(TextRange.getEnd-impl(r5.m1537getSelectiond9O1mEE())), TextUndoManager.Companion.Saver.INSTANCE.save(r4, r5.getTextUndoManager$foundation_release())});
        }

        public /* bridge */ /* synthetic */ Object save(SaverScope r1, Object r2) {
            return save(r1, (TextFieldState) r2);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TextFieldEditUndoBehavior.values().length];
            r0[TextFieldEditUndoBehavior.ClearHistory.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TextFieldEditUndoBehavior.MergeIfPossible.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TextFieldEditUndoBehavior.NeverMerge.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public /* synthetic */ TextFieldState(String r1, long r2, TextUndoManager r4, DefaultConstructorMarker r5) {
        this(r1, r2, r4);
    }

    public /* synthetic */ TextFieldState(String r1, long r2, DefaultConstructorMarker r4) {
        this(r1, r2);
    }

    public static /* synthetic */ void getMainBuffer$foundation_release$annotations() {
    }

    public static /* synthetic */ void getUndoState$annotations() {
    }

    public final void finishEditing() {
        setEditing(false);
    }

    private final boolean isEditing() {
        return ((Boolean) this.isEditing$delegate.getValue()).booleanValue();
    }

    public final TextFieldCharSequence getValue$foundation_release() {
        return (TextFieldCharSequence) this.value$delegate.getValue();
    }

    public final TextFieldBuffer startEdit() {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
        boolean r4 = isEditing();     // Catch: Throwable -> L13
        r0.restoreNonObservable(r1, r3, r2);
        if ((!r4) == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException("TextFieldState does not support concurrent or nested editing.");
    L11:
        setEditing(true);
        return new TextFieldBuffer(getValue$foundation_release(), null, null, null, 14, null);
    L13:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L5:
        r2 = null;
        goto L6
    }

    public String toString() {
        Snapshot.Companion r1 = Snapshot.Companion;
        Snapshot r2 = r1.getCurrentThreadSnapshot();
        if (r2 == null) goto L5;
        Function1 r3 = r2.getReadObserver();
    L6:
        Snapshot r4 = r1.makeCurrentNonObservable(r2);
        String r0 = "TextFieldState(selection=" + TextRange.toString-impl(m1537getSelectiond9O1mEE()) + ", text=\"" + getText() + "\")";     // Catch: Throwable -> L10
        r1.restoreNonObservable(r2, r4, r3);
        return r0;
    L10:
        th = move-exception;
        r1.restoreNonObservable(r2, r4, r3);
        throw th;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m1536getCompositionMzsxiRA() {
        return getValue$foundation_release().m1534getCompositionMzsxiRA();
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1537getSelectiond9O1mEE() {
        return getValue$foundation_release().m1535getSelectiond9O1mEE();
    }

    public final CharSequence getText() {
        return getValue$foundation_release().getText();
    }

    public final TextFieldBuffer getMainBuffer$foundation_release() {
        return this.mainBuffer;
    }

    public final TextUndoManager getTextUndoManager$foundation_release() {
        return this.textUndoManager;
    }

    public final UndoState getUndoState() {
        return this.undoState;
    }

    private final void setEditing(boolean r2) {
        this.isEditing$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setValue(TextFieldCharSequence r2) {
        this.value$delegate.setValue(r2);
    }

    public final void addNotifyImeListener$foundation_release(NotifyImeListener r2) {
        this.notifyImeListeners.add(r2);
    }

    public final void commitEdit(TextFieldBuffer r12) {
        if (r12.getChanges().getChangeCount() <= 0) goto L5;
        boolean r0 = true;
    L6:
        boolean r2 = !TextRange.equals-impl0(r12.m1527getSelectiond9O1mEE(), this.mainBuffer.m1527getSelectiond9O1mEE());
        if (r0 == true) goto L10;
        if (r2 == true) goto L10;
        r12.setCanCallAddStyle$foundation_release(true);
    L10:
        if (r0 == false) goto L12;
        recordEditForUndo(getValue$foundation_release(), TextFieldBuffer.m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(r12, 0, null, null, null, 15, null), r12.getChanges(), TextFieldEditUndoBehavior.NeverMerge);
    L12:
        syncMainBufferToTemporaryBuffer$foundation_release(r12, r0, r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void edit(Function1<? super TextFieldBuffer, Unit> r3) {
        TextFieldBuffer r0 = startEdit();
        r3.invoke(r0);     // Catch: Throwable -> L6
        commitEdit(r0);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        finishEditing();
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        finishEditing();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final void editWithNoSideEffects$foundation_release(Function1<? super TextFieldBuffer, Unit> r10) {
        getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        r10.invoke(getMainBuffer$foundation_release());
        TextFieldCharSequence r11 = TextFieldBuffer.m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(getMainBuffer$foundation_release(), 0, null, null, null, 15, null);
        access$updateValueAndNotifyListeners(this, getValue$foundation_release(), r11, true);
    }

    public final void removeNotifyImeListener$foundation_release(NotifyImeListener r2) {
        this.notifyImeListeners.remove(r2);
    }

    public final void setMainBuffer$foundation_release(TextFieldBuffer r1) {
        this.mainBuffer = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TextFieldState(String r7, long r8) {
        Object[] r0 = 0 == true ? 1 : 0;
        this(r7, r8, new TextUndoManager(null, r0, 3, 0 == true ? 1 : 0), null);
    }

    private TextFieldState(String r20, long r21, TextUndoManager r23) {
        this.textUndoManager = r23;
        this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(r20, TextRangeKt.coerceIn-8ffj60Q(r21, 0, r20.length()), null, null, null, null, 60, null), null, null, null, 14, null);
        this.isEditing$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(new TextFieldCharSequence(r20, r21, null, null, null, null, 60, null), null, 2, null);
        this.undoState = new UndoState(this);
        this.notifyImeListeners = new MutableVector(new NotifyImeListener[16], 0);
    }

    private final void commitEditAsUser(InputTransformation r24, boolean r25, TextFieldEditUndoBehavior r26) {
        TextFieldCharSequence r11 = getValue$foundation_release();
        if (this.mainBuffer.getChangeTracker$foundation_release().getChangeCount() == 0) goto L5;
    L14:
        boolean r5 = false;
        if (this.mainBuffer.getChangeTracker$foundation_release().getChangeCount() == 0) goto L17;
        boolean r4 = true;
    L18:
        TextFieldCharSequence r10 = new TextFieldCharSequence(this.mainBuffer.toString(), this.mainBuffer.m1527getSelectiond9O1mEE(), this.mainBuffer.m1525getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getHighlight$foundation_release(), TextFieldStateKt.m1539access$finalizeComposingAnnotationsitr0ztk(this.mainBuffer.m1525getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getComposingAnnotations$foundation_release()), null, 32, null);
        if (r24 != null) goto L25;
        if (r4 == false) goto L23;
        if (r25 == false) goto L23;
        r5 = true;
    L23:
        updateValueAndNotifyListeners(r11, r10, r5);
        recordEditForUndo(r11, r10, this.mainBuffer.getChangeTracker$foundation_release(), r26);
        return;
    L25:
        TextFieldBuffer r14 = new TextFieldBuffer(r10, this.mainBuffer.getChangeTracker$foundation_release(), r11, null, 8, null);
        r24.transformInput(r14);
        boolean r1 = !StringsKt.contentEquals(r14.asCharSequence(), r10);
        boolean r6 = !TextRange.equals-impl0(r14.m1527getSelectiond9O1mEE(), r10.m1535getSelectiond9O1mEE());
        if (r1 == true) goto L30;
        if (r6 == true) goto L30;
        TextFieldBuffer r7 = r14;
        updateValueAndNotifyListeners(r11, TextFieldBuffer.m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(r14, 0, r10.m1534getCompositionMzsxiRA(), null, null, 13, null), r25);
    L31:
        recordEditForUndo(r11, getValue$foundation_release(), r7.getChanges(), r26);
        return;
    L30:
        r7 = r14;
        syncMainBufferToTemporaryBuffer$foundation_release(r7, r1, r6);
        goto L31
    L17:
        r4 = false;
        goto L18
    L5:
        if (TextRange.equals-impl0(r11.m1535getSelectiond9O1mEE(), this.mainBuffer.m1527getSelectiond9O1mEE()) == false) goto L14;
        if (Intrinsics.areEqual(r11.m1534getCompositionMzsxiRA(), this.mainBuffer.m1525getCompositionMzsxiRA$foundation_release()) == true) goto L9;
    L12:
        updateValueAndNotifyListeners(getValue$foundation_release(), new TextFieldCharSequence(this.mainBuffer.toString(), this.mainBuffer.m1527getSelectiond9O1mEE(), this.mainBuffer.m1525getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getHighlight$foundation_release(), TextFieldStateKt.m1539access$finalizeComposingAnnotationsitr0ztk(this.mainBuffer.m1525getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getComposingAnnotations$foundation_release()), null, 32, null), r25);
        return;
    L9:
        if (Intrinsics.areEqual(r11.getHighlight(), this.mainBuffer.getHighlight$foundation_release()) == false) goto L12;
        if (Intrinsics.areEqual(r11.getComposingAnnotations(), this.mainBuffer.getComposingAnnotations$foundation_release()) == false) goto L12;
    }

    private final void updateValueAndNotifyListeners(TextFieldCharSequence r7, TextFieldCharSequence r8, boolean r9) {
        setValue(r8);
        finishEditing();
        MutableVector<NotifyImeListener> r0 = this.notifyImeListeners;
        Object[] r1 = r0.content;
        int r2 = r0.getSize();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L13;
        NotifyImeListener r4 = (NotifyImeListener) r1[r3];
        if (r9 == true) goto L7;
    L11:
        boolean r5 = false;
    L12:
        r4.onChange(r7, r8, r5);
        r3 = r3 + 1;
        goto L3
    L7:
        if (r7.contentEquals(r8) == true) goto L11;
        if (r7.m1534getCompositionMzsxiRA() == null) goto L11;
        r5 = true;
        goto L12
    }

    public final void syncMainBufferToTemporaryBuffer$foundation_release(TextFieldBuffer r21, boolean r22, boolean r23) {
        TextFieldCharSequence r1 = TextFieldBuffer.m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(this.mainBuffer, 0, null, null, null, 15, null);
        if (r22 == false) goto L5;
        this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(r21.toString(), r21.m1527getSelectiond9O1mEE(), null, null, null, null, 60, null), null, null, null, 14, null);
    L7:
        if (r22 == true) goto L11;
        if (r23 == true) goto L11;
        if (Intrinsics.areEqual(r1.m1534getCompositionMzsxiRA(), r21.m1525getCompositionMzsxiRA$foundation_release()) == false) goto L11;
    L12:
        updateValueAndNotifyListeners(r1, TextFieldBuffer.m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(this.mainBuffer, 0, null, null, null, 15, null), true);
        return;
    L11:
        this.mainBuffer.commitComposition$foundation_release();
        goto L12
    L5:
        if (r23 == false) goto L7;
        this.mainBuffer.m1529setSelection5zctL8(TextRangeKt.TextRange(TextRange.getStart-impl(r21.m1527getSelectiond9O1mEE()), TextRange.getEnd-impl(r21.m1527getSelectiond9O1mEE())));
        goto L7
    }

    public /* synthetic */ TextFieldState(String r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = TextRangeKt.TextRange(r1.length());
    L8:
        this(r1, r2, null);
    }

    public static final /* synthetic */ void access$commitEditAsUser(TextFieldState r0, InputTransformation r1, boolean r2, TextFieldEditUndoBehavior r3) {
        r0.commitEditAsUser(r1, r2, r3);
    }

    public static final /* synthetic */ void access$updateValueAndNotifyListeners(TextFieldState r0, TextFieldCharSequence r1, TextFieldCharSequence r2, boolean r3) {
        r0.updateValueAndNotifyListeners(r1, r2, r3);
    }

    private final void recordEditForUndo(TextFieldCharSequence r3, TextFieldCharSequence r4, TextFieldBuffer.ChangeList r5, TextFieldEditUndoBehavior r6) {
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r7 != 1) goto L5;
        this.textUndoManager.clearHistory();
        return;
    L5:
        if (r7 != 2) goto L7;
        TextUndoManagerKt.recordChanges(this.textUndoManager, r3, r4, r5, true);
        return;
    L7:
        if (r7 != 3) goto L10;
        TextUndoManagerKt.recordChanges(this.textUndoManager, r3, r4, r5, false);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void editAsUser$foundation_release(InputTransformation r2, boolean r3, TextFieldEditUndoBehavior r4, Function1<? super TextFieldBuffer, Unit> r5) {
        getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        r5.invoke(getMainBuffer$foundation_release());
        access$commitEditAsUser(this, r2, r3, r4);
    }

    public static /* synthetic */ void commitEditAsUser$default(TextFieldState r0, InputTransformation r1, boolean r2, TextFieldEditUndoBehavior r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = TextFieldEditUndoBehavior.MergeIfPossible;
    L8:
        r0.commitEditAsUser(r1, r2, r3);
    }

    public static /* synthetic */ void editAsUser$foundation_release$default(TextFieldState r0, InputTransformation r1, boolean r2, TextFieldEditUndoBehavior r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = TextFieldEditUndoBehavior.MergeIfPossible;
    L8:
        r0.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        r4.invoke(r0.getMainBuffer$foundation_release());
        access$commitEditAsUser(r0, r1, r2, r3);
    }
}
