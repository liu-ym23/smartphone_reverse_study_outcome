package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010,\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020.0-H\u0002J\f\u0010,\u001a\u00020\u0017*\u00020.H\u0002J\u0019\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u00101\u001a\u000202¢\u0006\u0004\b6\u00107J!\u00108\u001a\u00020\u00172\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b;H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006<"}, d2 = {"Landroidx/compose/foundation/text/TextFieldKeyInput;", "", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "selectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "editable", "", "singleLine", "preparedSelectionState", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "keyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "onValueChange", "Lkotlin/Function1;", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "<init>", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;ZZLandroidx/compose/foundation/text/selection/TextPreparedSelectionState;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;Landroidx/compose/foundation/text/DeadKeyCombiner;Landroidx/compose/foundation/text/KeyMapping;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getEditable", "()Z", "getSingleLine", "getPreparedSelectionState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "I", "apply", "", "Landroidx/compose/ui/text/input/EditCommand;", "typedCommand", "Landroidx/compose/ui/text/input/CommitTextCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "typedCommand-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/text/input/CommitTextCommand;", "process", "process-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "commandExecutionContext", "block", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldKeyInput {
    public static final int $stable = 8;
    private final boolean editable;
    private final int imeAction;
    private final DeadKeyCombiner keyCombiner;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final LegacyTextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KeyCommand.values().length];
            r0[KeyCommand.COPY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L54
        L133:
            r0[KeyCommand.PASTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L55
        L151:
            r0[KeyCommand.CUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L56
        L165:
            r0[KeyCommand.LEFT_CHAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L57
        L169:
            r0[KeyCommand.RIGHT_CHAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L58
        L179:
            r0[KeyCommand.LEFT_WORD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L59
        L193:
            r0[KeyCommand.RIGHT_WORD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L60
        L121:
            r0[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;     // Catch: NoSuchFieldError -> L61
        L137:
            r0[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;     // Catch: NoSuchFieldError -> L62
        L141:
            r0[KeyCommand.UP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L63
        L157:
            r0[KeyCommand.DOWN.ordinal()] = 11;     // Catch: NoSuchFieldError -> L64
        L185:
            r0[KeyCommand.PAGE_UP.ordinal()] = 12;     // Catch: NoSuchFieldError -> L65
        L199:
            r0[KeyCommand.PAGE_DOWN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L66
        L105:
            r0[KeyCommand.LINE_START.ordinal()] = 14;     // Catch: NoSuchFieldError -> L67
        L117:
            r0[KeyCommand.LINE_END.ordinal()] = 15;     // Catch: NoSuchFieldError -> L68
        L147:
            r0[KeyCommand.LINE_LEFT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L69
        L163:
            r0[KeyCommand.LINE_RIGHT.ordinal()] = 17;     // Catch: NoSuchFieldError -> L70
        L167:
            r0[KeyCommand.HOME.ordinal()] = 18;     // Catch: NoSuchFieldError -> L71
        L181:
            r0[KeyCommand.END.ordinal()] = 19;     // Catch: NoSuchFieldError -> L72
        L109:
            r0[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;     // Catch: NoSuchFieldError -> L73
        L125:
            r0[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;     // Catch: NoSuchFieldError -> L74
        L127:
            r0[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;     // Catch: NoSuchFieldError -> L75
        L143:
            r0[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;     // Catch: NoSuchFieldError -> L76
        L173:
            r0[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;     // Catch: NoSuchFieldError -> L77
        L187:
            r0[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;     // Catch: NoSuchFieldError -> L78
        L189:
            r0[KeyCommand.NEW_LINE.ordinal()] = 26;     // Catch: NoSuchFieldError -> L79
        L107:
            r0[KeyCommand.TAB.ordinal()] = 27;     // Catch: NoSuchFieldError -> L80
        L131:
            r0[KeyCommand.SELECT_ALL.ordinal()] = 28;     // Catch: NoSuchFieldError -> L81
        L149:
            r0[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;     // Catch: NoSuchFieldError -> L82
        L153:
            r0[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;     // Catch: NoSuchFieldError -> L83
        L171:
            r0[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;     // Catch: NoSuchFieldError -> L84
        L195:
            r0[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;     // Catch: NoSuchFieldError -> L85
        L111:
            r0[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;     // Catch: NoSuchFieldError -> L86
        L113:
            r0[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;     // Catch: NoSuchFieldError -> L87
        L129:
            r0[KeyCommand.SELECT_LINE_START.ordinal()] = 35;     // Catch: NoSuchFieldError -> L88
        L159:
            r0[KeyCommand.SELECT_LINE_END.ordinal()] = 36;     // Catch: NoSuchFieldError -> L89
        L175:
            r0[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;     // Catch: NoSuchFieldError -> L90
        L177:
            r0[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;     // Catch: NoSuchFieldError -> L91
        L191:
            r0[KeyCommand.SELECT_UP.ordinal()] = 39;     // Catch: NoSuchFieldError -> L92
        L119:
            r0[KeyCommand.SELECT_DOWN.ordinal()] = 40;     // Catch: NoSuchFieldError -> L93
        L135:
            r0[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;     // Catch: NoSuchFieldError -> L94
        L139:
            r0[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;     // Catch: NoSuchFieldError -> L95
        L155:
            r0[KeyCommand.SELECT_HOME.ordinal()] = 43;     // Catch: NoSuchFieldError -> L96
        L183:
            r0[KeyCommand.SELECT_END.ordinal()] = 44;     // Catch: NoSuchFieldError -> L97
        L197:
            r0[KeyCommand.DESELECT.ordinal()] = 45;     // Catch: NoSuchFieldError -> L98
        L103:
            r0[KeyCommand.UNDO.ordinal()] = 46;     // Catch: NoSuchFieldError -> L99
        L115:
            r0[KeyCommand.REDO.ordinal()] = 47;     // Catch: NoSuchFieldError -> L100
        L145:
            r0[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;     // Catch: NoSuchFieldError -> L101
        L161:
            r0[KeyCommand.CENTER.ordinal()] = 49;     // Catch: NoSuchFieldError -> L102
        L52:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public /* synthetic */ TextFieldKeyInput(LegacyTextFieldState r1, TextFieldSelectionManager r2, TextFieldValue r3, boolean r4, boolean r5, TextPreparedSelectionState r6, OffsetMapping r7, UndoManager r8, DeadKeyCombiner r9, KeyMapping r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ EditCommand a(TextFieldPreparedSelection r0) {
        return process_ZmokQxo$lambda$17$lambda$12(r0);
    }

    public static /* synthetic */ EditCommand b(TextFieldPreparedSelection r0) {
        return process_ZmokQxo$lambda$17$lambda$8(r0);
    }

    public static /* synthetic */ EditCommand c(TextFieldPreparedSelection r0) {
        return process_ZmokQxo$lambda$17$lambda$6(r0);
    }

    public static /* synthetic */ EditCommand d(TextFieldPreparedSelection r0) {
        return process_ZmokQxo$lambda$17$lambda$10(r0);
    }

    public static /* synthetic */ Unit e(TextFieldValue r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ EditCommand f(TextFieldPreparedSelection r0) {
        return process_ZmokQxo$lambda$17$lambda$5(r0);
    }

    public static /* synthetic */ Unit g(KeyCommand r0, TextFieldKeyInput r1, Ref.BooleanRef r2, TextFieldPreparedSelection r3) {
        return process_ZmokQxo$lambda$17(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit h(TextFieldPreparedSelection r0) {
        return process_ZmokQxo$lambda$17$lambda$3(r0);
    }

    public static /* synthetic */ Unit i(TextFieldPreparedSelection r0) {
        return process_ZmokQxo$lambda$17$lambda$4(r0);
    }

    public static /* synthetic */ EditCommand j(TextFieldPreparedSelection r0) {
        return process_ZmokQxo$lambda$17$lambda$14(r0);
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    private static final Unit _init_$lambda$0(TextFieldValue r0) {
        return Unit.INSTANCE;
    }

    private final void apply(List<? extends EditCommand> r4) {
        EditProcessor r0 = this.state.getProcessor();
        List r5 = CollectionsKt.toMutableList(r4);
        ListProtector.add(r5, 0, new FinishComposingTextCommand());
        TextFieldValue r6 = r0.apply(r5);
        this.onValueChange.invoke(r6);
    }

    private final void commandExecutionContext(Function1<? super TextFieldPreparedSelection, Unit> r6) {
        TextFieldPreparedSelection r0 = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        r6.invoke(r0);
        if (TextRange.equals-impl0(r0.m1826getSelectiond9O1mEE(), this.value.getSelection-d9O1mEE()) == true) goto L5;
    L6:
        this.onValueChange.invoke(r0.getValue());
        return;
    L5:
        if (Intrinsics.areEqual(r0.getAnnotatedString(), this.value.getAnnotatedString()) == false) goto L6;
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$10(TextFieldPreparedSelection r4) {
        Integer r0 = r4.getNextWordOffset();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new DeleteSurroundingTextCommand(0, r0.intValue() - TextRange.getEnd-impl(r4.m1826getSelectiond9O1mEE()));
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$12(TextFieldPreparedSelection r4) {
        Integer r0 = r4.getLineStartByOffset();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
        return new DeleteSurroundingTextCommand(TextRange.getEnd-impl(r4.m1826getSelectiond9O1mEE()) - r1, 0);
    L5:
        return null;
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$14(TextFieldPreparedSelection r4) {
        Integer r0 = r4.getLineEndByOffset();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new DeleteSurroundingTextCommand(0, r0.intValue() - TextRange.getEnd-impl(r4.m1826getSelectiond9O1mEE()));
    }

    private static final Unit process_ZmokQxo$lambda$17$lambda$3(TextFieldPreparedSelection r0) {
        r0.moveCursorLeft();
        return Unit.INSTANCE;
    }

    private static final Unit process_ZmokQxo$lambda$17$lambda$4(TextFieldPreparedSelection r0) {
        r0.moveCursorRight();
        return Unit.INSTANCE;
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$5(TextFieldPreparedSelection r4) {
        int r0 = r4.getPrecedingCodePointOrEmojiStartIndex();
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        return new DeleteSurroundingTextCommand(TextRange.getEnd-impl(r4.m1826getSelectiond9O1mEE()) - r0, 0);
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$6(TextFieldPreparedSelection r4) {
        int r0 = r4.getNextCharacterIndex();
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        return new DeleteSurroundingTextCommand(0, r0 - TextRange.getEnd-impl(r4.m1826getSelectiond9O1mEE()));
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$8(TextFieldPreparedSelection r4) {
        Integer r0 = r4.getPreviousWordOffset();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
        return new DeleteSurroundingTextCommand(TextRange.getEnd-impl(r4.m1826getSelectiond9O1mEE()) - r1, 0);
    L5:
        return null;
    }

    /* JADX INFO: renamed from: typedCommand-ZmokQxo, reason: not valid java name */
    private final CommitTextCommand m1465typedCommandZmokQxo(KeyEvent r3) {
        if (TextFieldKeyInput_androidKt.m1470isTypedEventZmokQxo(r3) == true) goto L5;
        return null;
    L5:
        Integer r4 = this.keyCombiner.m1366consumeZmokQxo(r3);
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
        return new CommitTextCommand(StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), r5).toString(), 1);
    L9:
        return null;
    }

    /* JADX INFO: renamed from: process-ZmokQxo, reason: not valid java name */
    public final boolean m1466processZmokQxo(KeyEvent r5) {
        CommitTextCommand r0 = m1465typedCommandZmokQxo(r5);
        if (r0 == null) goto L10;
        if (this.editable == false) goto L7;
        apply(r0);
        this.preparedSelectionState.resetCachedX();
        return true;
    L7:
        return false;
    L10:
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(r5), KeyEventType.Companion.getKeyDown-CS__XNY()) == true) goto L12;
        return false;
    L12:
        final KeyCommand r6 = this.keyMapping.mo1370mapZmokQxo(r5);
        if (r6 != null) goto L15;
    L24:
        return false;
    L15:
        if (r6.getEditsText() == true) goto L17;
    L19:
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        r1.element = true;
        commandExecutionContext(new u3(r6, this, r1));
        UndoManager r7 = this.undoManager;
        if (r7 == null) goto L23;
        r7.forceNextSnapshot();
    L23:
        return r1.element;
    L17:
        if (this.editable == true) goto L19;
        goto L19
    }

    private final void apply(EditCommand r1) {
        apply(CollectionsKt.listOf(r1));
    }

    private static final Unit process_ZmokQxo$lambda$17(KeyCommand r2, TextFieldKeyInput r3, Ref.BooleanRef r4, TextFieldPreparedSelection r5) {
        if (r2 != null) goto L4;
        int r6 = -1;
    L6:
        switch(r6) {
            case 1: goto L88;
            case 2: goto L87;
            case 3: goto L86;
            case 4: goto L85;
            case 5: goto L84;
            case 6: goto L83;
            case 7: goto L82;
            case 8: goto L81;
            case 9: goto L80;
            case 10: goto L79;
            case 11: goto L78;
            case 12: goto L77;
            case 13: goto L76;
            case 14: goto L75;
            case 15: goto L74;
            case 16: goto L73;
            case 17: goto L72;
            case 18: goto L71;
            case 19: goto L70;
            case 20: goto L67;
            case 21: goto L64;
            case 22: goto L61;
            case 23: goto L58;
            case 24: goto L55;
            case 25: goto L52;
            case 26: goto L48;
            case 27: goto L43;
            case 28: goto L41;
            case 29: goto L40;
            case 30: goto L39;
            case 31: goto L38;
            case 32: goto L37;
            case 33: goto L36;
            case 34: goto L35;
            case 35: goto L34;
            case 36: goto L33;
            case 37: goto L32;
            case 38: goto L31;
            case 39: goto L30;
            case 40: goto L29;
            case 41: goto L28;
            case 42: goto L27;
            case 43: goto L26;
            case 44: goto L25;
            case 45: goto L24;
            case 46: goto L16;
            case 47: goto L11;
            case 48: goto L9;
            case 49: goto L10;
            default: goto L8;
        };
    L9:
        KeyEventHelpers_androidKt.showCharacterPalette();
    L10:
        Unit r7 = Unit.INSTANCE;
    L90:
        return Unit.INSTANCE;
    L11:
        UndoManager r8 = r3.undoManager;
        if (r8 == null) goto L90;
        TextFieldValue r9 = r8.redo();
        if (r9 == null) goto L90;
        r3.onValueChange.invoke(r9);
        Unit r10 = Unit.INSTANCE;
        goto L90
    L16:
        UndoManager r11 = r3.undoManager;
        if (r11 == null) goto L19;
        r11.makeSnapshot(r5.getValue());
    L19:
        UndoManager r12 = r3.undoManager;
        if (r12 == null) goto L90;
        TextFieldValue r13 = r12.undo();
        if (r13 == null) goto L90;
        r3.onValueChange.invoke(r13);
        Unit r14 = Unit.INSTANCE;
        goto L90
    L24:
        r5.deselect();
        goto L90
    L25:
        r5.moveCursorToEnd().selectMovement();
        goto L90
    L26:
        r5.moveCursorToHome().selectMovement();
        goto L90
    L27:
        r5.moveCursorDownByPage().selectMovement();
        goto L90
    L28:
        r5.moveCursorUpByPage().selectMovement();
        goto L90
    L29:
        r5.moveCursorDownByLine().selectMovement();
        goto L90
    L30:
        r5.moveCursorUpByLine().selectMovement();
        goto L90
    L31:
        r5.moveCursorToLineRightSide().selectMovement();
        goto L90
    L32:
        r5.moveCursorToLineLeftSide().selectMovement();
        goto L90
    L33:
        r5.moveCursorToLineEnd().selectMovement();
        goto L90
    L34:
        r5.moveCursorToLineStart().selectMovement();
        goto L90
    L35:
        r5.moveCursorNextByParagraph().selectMovement();
        goto L90
    L36:
        r5.moveCursorPrevByParagraph().selectMovement();
        goto L90
    L37:
        r5.moveCursorRightByWord().selectMovement();
        goto L90
    L38:
        r5.moveCursorLeftByWord().selectMovement();
        goto L90
    L39:
        r5.moveCursorRight().selectMovement();
        goto L90
    L40:
        r5.moveCursorLeft().selectMovement();
        goto L90
    L41:
        r5.selectAll();
        goto L90
    L52:
        List<EditCommand> r15 = r5.deleteIfSelectedOr(new s3());
        if (r15 == null) goto L90;
        r3.apply(r15);
        Unit r16 = Unit.INSTANCE;
        goto L90
    L55:
        List<EditCommand> r17 = r5.deleteIfSelectedOr(new r3());
        if (r17 == null) goto L90;
        r3.apply(r17);
        Unit r18 = Unit.INSTANCE;
        goto L90
    L58:
        List<EditCommand> r19 = r5.deleteIfSelectedOr(new q3());
        if (r19 == null) goto L90;
        r3.apply(r19);
        Unit r20 = Unit.INSTANCE;
        goto L90
    L61:
        List<EditCommand> r21 = r5.deleteIfSelectedOr(new p3());
        if (r21 == null) goto L90;
        r3.apply(r21);
        Unit r22 = Unit.INSTANCE;
        goto L90
    L64:
        List<EditCommand> r23 = r5.deleteIfSelectedOr(new o3());
        if (r23 == null) goto L90;
        r3.apply(r23);
        Unit r24 = Unit.INSTANCE;
        goto L90
    L67:
        List<EditCommand> r25 = r5.deleteIfSelectedOr(new n3());
        if (r25 == null) goto L90;
        r3.apply(r25);
        Unit r26 = Unit.INSTANCE;
        goto L90
    L70:
        r5.moveCursorToEnd();
        goto L90
    L71:
        r5.moveCursorToHome();
        goto L90
    L72:
        r5.moveCursorToLineRightSide();
        goto L90
    L73:
        r5.moveCursorToLineLeftSide();
        goto L90
    L74:
        r5.moveCursorToLineEnd();
        goto L90
    L75:
        r5.moveCursorToLineStart();
        goto L90
    L76:
        r5.moveCursorDownByPage();
        goto L90
    L77:
        r5.moveCursorUpByPage();
        goto L90
    L78:
        r5.moveCursorDownByLine();
        goto L90
    L79:
        r5.moveCursorUpByLine();
        goto L90
    L80:
        r5.moveCursorNextByParagraph();
        goto L90
    L81:
        r5.moveCursorPrevByParagraph();
        goto L90
    L82:
        r5.moveCursorRightByWord();
        goto L90
    L83:
        r5.moveCursorLeftByWord();
        goto L90
    L84:
        r5.collapseRightOr(new m3());
        goto L90
    L85:
        r5.collapseLeftOr(new l3());
        goto L90
    L86:
        r3.selectionManager.cut$foundation_release();
        goto L90
    L87:
        r3.selectionManager.paste$foundation_release();
        goto L90
    L88:
        r3.selectionManager.copy$foundation_release(false);
        goto L90
    L8:
        throw new NoWhenBranchMatchedException();
    L43:
        if (r3.singleLine == true) goto L45;
        r3.apply(new CommitTextCommand("\t", 1));
    L46:
        Unit r27 = Unit.INSTANCE;
        goto L90
    L45:
        r4.element = false;
        goto L46
    L48:
        if (r3.singleLine == true) goto L50;
        r3.apply(new CommitTextCommand("\n", 1));
    L51:
        Unit r28 = Unit.INSTANCE;
        goto L90
    L50:
        r4.element = ((Boolean) r3.state.getOnImeActionPerformedWithResult().invoke(ImeAction.box-impl(r3.imeAction))).booleanValue();
        goto L51
    L4:
        r6 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        goto L6
    }

    private TextFieldKeyInput(LegacyTextFieldState r1, TextFieldSelectionManager r2, TextFieldValue r3, boolean r4, boolean r5, TextPreparedSelectionState r6, OffsetMapping r7, UndoManager r8, DeadKeyCombiner r9, KeyMapping r10, Function1<? super TextFieldValue, Unit> r11, int r12) {
        this.state = r1;
        this.selectionManager = r2;
        this.value = r3;
        this.editable = r4;
        this.singleLine = r5;
        this.preparedSelectionState = r6;
        this.offsetMapping = r7;
        this.undoManager = r8;
        this.keyCombiner = r9;
        this.keyMapping = r10;
        this.onValueChange = r11;
        this.imeAction = r12;
    }

    public /* synthetic */ TextFieldKeyInput(LegacyTextFieldState r24, TextFieldSelectionManager r25, TextFieldValue r26, boolean r27, boolean r28, TextPreparedSelectionState r29, OffsetMapping r30, UndoManager r31, DeadKeyCombiner r32, KeyMapping r33, Function1 r34, int r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 4) == 0) goto L5;
        TextFieldValue r12 = new TextFieldValue(null, 0, null, 7, null);
    L7:
        if ((r36 & 8) == 0) goto L9;
        boolean r13 = true;
    L11:
        if ((r36 & 16) == 0) goto L13;
        boolean r14 = false;
    L15:
        if ((r36 & 64) == 0) goto L17;
        OffsetMapping r16 = OffsetMapping.Companion.getIdentity();
    L19:
        if ((r36 & 128) == 0) goto L21;
        UndoManager r17 = null;
    L23:
        if ((r36 & 512) == 0) goto L25;
        KeyMapping r19 = KeyMapping_androidKt.getPlatformDefaultKeyMapping();
    L27:
        if ((r36 & 1024) == 0) goto L29;
        Function1 r20 = new t3();
    L30:
        this(r24, r25, r12, r13, r14, r29, r16, r17, r32, r19, r20, r35, null);
        return;
    L29:
        r20 = r34;
        goto L30
    L25:
        r19 = r33;
        goto L27
    L21:
        r17 = r31;
        goto L23
    L17:
        r16 = r30;
        goto L19
    L13:
        r14 = r28;
        goto L15
    L9:
        r13 = r27;
        goto L11
    L5:
        r12 = r26;
        goto L7
    }
}
