package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.SelectionMovementDeletionContext;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J]\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0016¢\u0006\u0004\b#\u0010$JU\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002¢\u0006\u0004\b&\u0010'J\f\u0010(\u001a\u00020)*\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", "<init>", "()V", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "currentlyConsumedDownKeys", "Landroidx/collection/MutableLongSet;", "onPreKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onKeyEvent", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "onKeyEvent-8zsqlwg", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "processKeyDownEvent", "processKeyDownEvent-q0GpTC0", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "getVisibleTextLayoutHeight", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TextFieldKeyEventHandler {
    public static final int $stable = 8;
    private MutableLongSet currentlyConsumedDownKeys;
    private final DeadKeyCombiner deadKeyCombiner;
    private final KeyMapping keyMapping;
    private final TextFieldPreparedSelectionState preparedSelectionState;

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

    public static /* synthetic */ Unit a(SelectionMovementDeletionContext r0) {
        return processKeyDownEvent_q0GpTC0$lambda$4$lambda$1(r0);
    }

    public static /* synthetic */ Unit b(SelectionMovementDeletionContext r0) {
        return processKeyDownEvent_q0GpTC0$lambda$4$lambda$2(r0);
    }

    public TextFieldKeyEventHandler() {
        this.preparedSelectionState = new TextFieldPreparedSelectionState();
        this.deadKeyCombiner = new DeadKeyCombiner();
        this.keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();
    }

    private final float getVisibleTextLayoutHeight(TextLayoutState r5) {
        LayoutCoordinates r0 = r5.getTextLayoutNodeCoordinates();
        if (r0 == null) goto L19;
        Rect r2 = null;
        if (r0.isAttached() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L19;
        LayoutCoordinates r6 = r5.getDecoratorNodeCoordinates();
        if (r6 != null) goto L12;
    L17:
        if (r2 == null) goto L19;
        return Float.intBitsToFloat((int) (r2.getSize-NH-jbRc() & 4294967295L));
    L12:
        if (r6.isAttached() == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L17;
        r2 = LayoutCoordinates.-CC.localBoundingBoxOf$default(r6, r0, false, 2, null);
    L19:
        return Float.NaN;
    }

    private static final Unit processKeyDownEvent_q0GpTC0$lambda$4$lambda$1(SelectionMovementDeletionContext r0) {
        r0.moveCursorLeftByChar();
        return Unit.INSTANCE;
    }

    private static final Unit processKeyDownEvent_q0GpTC0$lambda$4$lambda$2(SelectionMovementDeletionContext r0) {
        r0.moveCursorRightByChar();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: onPreKeyEvent-MyFupTE */
    public boolean mo1565onPreKeyEventMyFupTE(KeyEvent r1, TransformedTextFieldState r2, TextFieldSelectionState r3, FocusManager r4, SoftwareKeyboardController r5) {
        if (TextRange.getCollapsed-impl(r2.getVisualText().m1535getSelectiond9O1mEE()) == false) goto L5;
    L7:
        return false;
    L5:
        if (KeyEventHelpers_androidKt.m1369cancelsTextSelectionZmokQxo(r1) == false) goto L7;
        r3.deselect();
        return true;
    }

    /* JADX INFO: renamed from: processKeyDownEvent-q0GpTC0, reason: not valid java name */
    private final boolean m1646processKeyDownEventq0GpTC0(KeyEvent r14, TransformedTextFieldState r15, TextLayoutState r16, Function1<? super KeyCommand, ? extends Unit> r17, SoftwareKeyboardController r18, boolean r19, boolean r20, Function0<Boolean> r21) {
        boolean r9 = false;
        if (TextFieldKeyInput_androidKt.m1470isTypedEventZmokQxo(r14) == false) goto L10;
        Integer r2 = this.deadKeyCombiner.m1366consumeZmokQxo(r14);
        if (r2 == null) goto L10;
        String r3 = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(2), r2.intValue()).toString();
        if (r19 == false) goto L99;
        TransformedTextFieldState.replaceSelectedText$default(r15, r3, true, null, !TextFieldKeyEventHandler_androidKt.m1648isFromSoftKeyboardZmokQxo(r14), 4, null);
        this.preparedSelectionState.resetCachedX();
        return true;
    L99:
        return false;
    L10:
        KeyCommand r11 = this.keyMapping.mo1370mapZmokQxo(r14);
        if (r11 != null) goto L13;
    L98:
        return r9;
    L13:
        if (r11.getEditsText() == false) goto L16;
        if (r19 == false) goto L98;
    L16:
        SelectionMovementDeletionContext r12 = new SelectionMovementDeletionContext(r15, r16.getLayoutResult(), TextFieldKeyEventHandler_androidKt.m1648isFromSoftKeyboardZmokQxo(r14), getVisibleTextLayoutHeight(r16), this.preparedSelectionState);
        switch(WhenMappings.$EnumSwitchMapping$0[r11.ordinal()]) {
            case 1: goto L74;
            case 2: goto L74;
            case 3: goto L74;
            case 4: goto L73;
            case 5: goto L72;
            case 6: goto L71;
            case 7: goto L70;
            case 8: goto L69;
            case 9: goto L68;
            case 10: goto L67;
            case 11: goto L66;
            case 12: goto L65;
            case 13: goto L64;
            case 14: goto L63;
            case 15: goto L62;
            case 16: goto L61;
            case 17: goto L60;
            case 18: goto L59;
            case 19: goto L58;
            case 20: goto L57;
            case 21: goto L56;
            case 22: goto L55;
            case 23: goto L54;
            case 24: goto L53;
            case 25: goto L52;
            case 26: goto L48;
            case 27: goto L45;
            case 28: goto L44;
            case 29: goto L43;
            case 30: goto L42;
            case 31: goto L41;
            case 32: goto L40;
            case 33: goto L39;
            case 34: goto L38;
            case 35: goto L37;
            case 36: goto L36;
            case 37: goto L35;
            case 38: goto L34;
            case 39: goto L33;
            case 40: goto L32;
            case 41: goto L31;
            case 42: goto L30;
            case 43: goto L29;
            case 44: goto L28;
            case 45: goto L27;
            case 46: goto L26;
            case 47: goto L25;
            case 48: goto L24;
            case 49: goto L21;
            default: goto L19;
        };
    L24:
        KeyEventHelpers_androidKt.showCharacterPalette();
        Unit r1 = Unit.INSTANCE;
    L75:
        r9 = true;
    L77:
        if (ComposeFoundationFlags.isTextFieldDpadNavigationEnabled == false) goto L88;
        if (r11 != KeyCommand.UP) goto L81;
    L86:
        r9 = !TextRange.equals-impl0(r12.getInitialValue().m1535getSelectiond9O1mEE(), r12.m1699getSelectiond9O1mEE());
        goto L88
    L81:
        if (r11 == KeyCommand.DOWN) goto L86;
        if (r11 == KeyCommand.LEFT_CHAR) goto L86;
        if (r11 == KeyCommand.RIGHT_CHAR) goto L86;
    L88:
        if (TextRange.equals-impl0(r12.m1699getSelectiond9O1mEE(), r12.getInitialValue().m1535getSelectiond9O1mEE()) == true) goto L91;
        r15.m1679selectCharsIn5zctL8(r12.m1699getSelectiond9O1mEE());
    L91:
        if (r12.getWedgeAffinity() == null) goto L98;
        WedgeAffinity r4 = r12.getWedgeAffinity();
        if (r4 == null) goto L98;
        if (TextRange.getCollapsed-impl(r15.getUntransformedText().m1535getSelectiond9O1mEE()) == false) goto L97;
        r15.setSelectionWedgeAffinity(new SelectionWedgeAffinity(r4));
        goto L98
    L97:
        r15.setSelectionWedgeAffinity(SelectionWedgeAffinity.copy$default(r12.getInitialWedgeAffinity(), null, r4, 1, null));
        goto L98
    L25:
        r15.redo();
        Unit r5 = Unit.INSTANCE;
        goto L75
    L26:
        r15.undo();
        Unit r6 = Unit.INSTANCE;
        goto L75
    L27:
        r12.deselect();
        goto L75
    L28:
        r12.moveCursorToEnd().selectMovement();
        goto L75
    L29:
        r12.moveCursorToHome().selectMovement();
        goto L75
    L30:
        r12.moveCursorDownByPage().selectMovement();
        goto L75
    L31:
        r12.moveCursorUpByPage().selectMovement();
        goto L75
    L32:
        r12.moveCursorDownByLine().selectMovement();
        goto L75
    L33:
        r12.moveCursorUpByLine().selectMovement();
        goto L75
    L34:
        r12.moveCursorToLineRightSide().selectMovement();
        goto L75
    L35:
        r12.moveCursorToLineLeftSide().selectMovement();
        goto L75
    L36:
        r12.moveCursorToLineEnd().selectMovement();
        goto L75
    L37:
        r12.moveCursorToLineStart().selectMovement();
        goto L75
    L38:
        r12.moveCursorNextByParagraph().selectMovement();
        goto L75
    L39:
        r12.moveCursorPrevByParagraph().selectMovement();
        goto L75
    L40:
        r12.moveCursorRightByWord().selectMovement();
        goto L75
    L41:
        r12.moveCursorLeftByWord().selectMovement();
        goto L75
    L42:
        r12.moveCursorRightByChar().selectMovement();
        goto L75
    L43:
        r12.moveCursorLeftByChar().selectMovement();
        goto L75
    L44:
        r12.selectAll();
        goto L75
    L45:
        if (r20 == true) goto L47;
        TransformedTextFieldState.replaceSelectedText$default(r15, "\t", true, null, !TextFieldKeyEventHandler_androidKt.m1648isFromSoftKeyboardZmokQxo(r14), 4, null);
        r9 = true;
    L47:
        Unit r7 = Unit.INSTANCE;
        goto L77
    L48:
        if (r20 == true) goto L50;
        TransformedTextFieldState.replaceSelectedText$default(r15, "\n", true, null, !TextFieldKeyEventHandler_androidKt.m1648isFromSoftKeyboardZmokQxo(r14), 4, null);
        r9 = true;
    L51:
        Unit r8 = Unit.INSTANCE;
        goto L77
    L50:
        r9 = ((Boolean) r21.invoke()).booleanValue();
        goto L51
    L52:
        r12.moveCursorToLineEnd().deleteMovement();
        goto L75
    L53:
        r12.moveCursorToLineStart().deleteMovement();
        goto L75
    L54:
        r12.moveCursorNextByWord().deleteMovement();
        goto L75
    L55:
        r12.moveCursorPrevByWord().deleteMovement();
        goto L75
    L56:
        r12.moveCursorNextByChar().deleteMovement();
        goto L75
    L57:
        r12.moveCursorPrevByCodePointOrEmoji().deleteMovement();
        goto L75
    L58:
        r12.moveCursorToEnd();
        goto L75
    L59:
        r12.moveCursorToHome();
        goto L75
    L60:
        r12.moveCursorToLineRightSide();
        goto L75
    L61:
        r12.moveCursorToLineLeftSide();
        goto L75
    L62:
        r12.moveCursorToLineEnd();
        goto L75
    L63:
        r12.moveCursorToLineStart();
        goto L75
    L64:
        r12.moveCursorDownByPage();
        goto L75
    L65:
        r12.moveCursorUpByPage();
        goto L75
    L66:
        r12.moveCursorDownByLine();
        goto L75
    L67:
        r12.moveCursorUpByLine();
        goto L75
    L68:
        r12.moveCursorNextByParagraph();
        goto L75
    L69:
        r12.moveCursorPrevByParagraph();
        goto L75
    L70:
        r12.moveCursorRightByWord();
        goto L75
    L71:
        r12.moveCursorLeftByWord();
        goto L75
    L72:
        r12.collapseRightOr(new x1());
        goto L75
    L73:
        r12.collapseLeftOr(new w1());
        goto L75
    L74:
        r17.invoke(r11);
        Unit r10 = Unit.INSTANCE;
        goto L75
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        if (ComposeFoundationFlags.isTextFieldDpadNavigationEnabled == false) goto L23;
        r18.show();
        r9 = true;
    L23:
        Unit r13 = Unit.INSTANCE;
        goto L77
    }

    /* JADX INFO: renamed from: onKeyEvent-8zsqlwg */
    public boolean mo1564onKeyEvent8zsqlwg(KeyEvent r13, TransformedTextFieldState r14, TextLayoutState r15, TextFieldSelectionState r16, Function1<? super KeyCommand, ? extends Unit> r17, SoftwareKeyboardController r18, boolean r19, boolean r20, Function0<Boolean> r21) {
        long r10 = KeyEvent_androidKt.getKey-ZmokQxo(r13);
        int r0 = KeyEvent_androidKt.getType-ZmokQxo(r13);
        KeyEventType.Companion r1 = KeyEventType.Companion;
        if (KeyEventType.equals-impl0(r0, r1.getKeyUp-CS__XNY()) == false) goto L17;
        MutableLongSet r2 = this.currentlyConsumedDownKeys;
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L15;
        MutableLongSet r4 = this.currentlyConsumedDownKeys;
        if (r4 == null) goto L14;
        r4.remove(r10);
    L14:
        return true;
    L15:
        return false;
    L7:
        if (r2.contains(r10) != true) goto L9;
        r3 = true;
        goto L10
    L17:
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(r13), r1.getUnknown-CS__XNY()) == true) goto L19;
    L21:
        boolean r5 = m1646processKeyDownEventq0GpTC0(r13, r14, r15, r17, r18, r19, r20, r21);
        if (r5 == false) goto L27;
        MutableLongSet r6 = this.currentlyConsumedDownKeys;
        if (r6 != null) goto L26;
        r6 = new MutableLongSet(3);
        this.currentlyConsumedDownKeys = r6;
    L26:
        r6.plusAssign(r10);
    L27:
        return r5;
    L19:
        if (TextFieldKeyInput_androidKt.m1470isTypedEventZmokQxo(r13) == true) goto L21;
        return false;
    }
}
