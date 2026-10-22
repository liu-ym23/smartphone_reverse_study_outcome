package androidx.compose.foundation.text.input.internal.selection;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifier_androidKt;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\u0004H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¨\u0006\u0012"}, d2 = {"contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "onMenuItemClicked", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/TextContextMenuItems;", "addBasicTextFieldTextContextMenuComponents", "Landroidx/compose/ui/Modifier;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldSelectionState_androidKt {
    public static /* synthetic */ boolean a(TextFieldSelectionState r0) {
        return addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$5(r0);
    }

    public static /* synthetic */ Unit b(Function0 r0, Function0 r1, TextFieldSelectionState r2, TextToolbarState r3, TextContextMenuSession r4) {
        return addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3$lambda$2(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(State r0, ContextMenuState r1, Function2 r2, TextFieldSelectionState r3, ContextMenuScope r4) {
        return contextMenuBuilder$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit d(TextFieldSelectionState r0, CoroutineScope r1, Context r2, TextContextMenuBuilderScope r3) {
        return addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(CoroutineScope r0, Function1 r1) {
        return addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldSuspendItem$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit f(TextFieldSelectionState r0) {
        return addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$6(r0);
    }

    public static /* synthetic */ Unit g(TextFieldSelectionState r0, CoroutineScope r1, TextContextMenuBuilderScope r2, Context r3) {
        return addBasicTextFieldTextContextMenuComponents$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit h(TextFieldSelectionState r0) {
        return addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$7(r0);
    }

    private static final boolean addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$5(TextFieldSelectionState r0) {
        return !r0.getTextToolbarShown();
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$6(TextFieldSelectionState r0) {
        r0.selectAll();
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$7(TextFieldSelectionState r0) {
        r0.autofill();
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldSuspendItem$lambda$4(CoroutineScope r6, Function1 r7) {
        BuildersKt.launch$default(r6, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionState_androidKt$addBasicTextFieldTextContextMenuComponents$1$textFieldSuspendItem$1$1(r7, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final Modifier addBasicTextFieldTextContextMenuComponents(Modifier r1, final TextFieldSelectionState r2, final CoroutineScope r3) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(r1, new d0(r2, r3));
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$10(final TextFieldSelectionState r7, final CoroutineScope r8, TextContextMenuBuilderScope r9, final Context r10) {
        PlatformSelectionBehaviors_androidKt.m1843addPlatformTextContextMenuItems71BSaZU(r9, r10, r7.getEditable$foundation_release(), r7.getTextFieldState$foundation_release().getVisualText().getText(), TextRange.box-impl(r7.getTextFieldState$foundation_release().getVisualText().m1535getSelectiond9O1mEE()), r7.getPlatformSelectionBehaviors$foundation_release(), new c0(r7, r8, r10));
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9(final TextFieldSelectionState r11, CoroutineScope r12, Context r13, TextContextMenuBuilderScope r14) {
        r14.separator();
        addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldSuspendItem(r14, r12, r13, r11, TextContextMenuItems.Cut, r11.canCut(), new TextFieldSelectionState_androidKt$addBasicTextFieldTextContextMenuComponents$1$1$1$1(r11, null));
        addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldSuspendItem(r14, r12, r13, r11, TextContextMenuItems.Copy, r11.canCopy(), new TextFieldSelectionState_androidKt$addBasicTextFieldTextContextMenuComponents$1$1$1$2(r11, null));
        addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldSuspendItem(r14, r12, r13, r11, TextContextMenuItems.Paste, r11.canPaste(), new TextFieldSelectionState_androidKt$addBasicTextFieldTextContextMenuComponents$1$1$1$3(r11, null));
        addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3(r14, r13, r11, TextContextMenuItems.SelectAll, r11.canSelectAll(), TextToolbarState.Selection, new f0(r11), new g0(r11));
        if (Build.VERSION.SDK_INT < 26) goto L5;
        addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3$default(r14, r13, r11, TextContextMenuItems.Autofill, r11.canAutofill(), null, null, new h0(r11), 48, null);
    L5:
        r14.separator();
        return Unit.INSTANCE;
    }

    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionState r1, final ContextMenuState r2, final State<MenuItemsAvailability> r3, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> r4) {
        return new i0(r3, r2, r4, r1);
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3$lambda$2(Function0 r0, Function0 r1, TextFieldSelectionState r2, TextToolbarState r3, TextContextMenuSession r4) {
        r0.invoke();
        if (r1 == null) goto L5;
        boolean r5 = ((Boolean) r1.invoke()).booleanValue();
    L6:
        if (r5 == false) goto L8;
        r4.close();
    L8:
        r2.updateTextToolbarState(r3);
        return Unit.INSTANCE;
    L5:
        r5 = true;
        goto L6
    }

    private static final Unit contextMenuBuilder$lambda$1(State r13, ContextMenuState r14, Function2 r15, TextFieldSelectionState r16, ContextMenuScope r17) {
        int r0 = ((MenuItemsAvailability) r13.getValue()).m1436unboximpl();
        contextMenuBuilder$lambda$1$textFieldItem(r17, r14, r15, r16, TextContextMenuItems.Cut, MenuItemsAvailability.m1431getCanCutimpl(r0));
        contextMenuBuilder$lambda$1$textFieldItem(r17, r14, r15, r16, TextContextMenuItems.Copy, MenuItemsAvailability.m1430getCanCopyimpl(r0));
        contextMenuBuilder$lambda$1$textFieldItem(r17, r14, r15, r16, TextContextMenuItems.Paste, MenuItemsAvailability.m1432getCanPasteimpl(r0));
        contextMenuBuilder$lambda$1$textFieldItem(r17, r14, r15, r16, TextContextMenuItems.SelectAll, MenuItemsAvailability.m1433getCanSelectAllimpl(r0));
        if (Build.VERSION.SDK_INT < 26) goto L6;
        contextMenuBuilder$lambda$1$textFieldItem(r17, r14, r15, r16, TextContextMenuItems.Autofill, MenuItemsAvailability.m1429getCanAutofillimpl(r0));
    L6:
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$1$textFieldItem(ContextMenuScope r8, final ContextMenuState r9, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> r10, final TextFieldSelectionState r11, final TextContextMenuItems r12, boolean r13) {
        if (r13 == false) goto L5;
        ContextMenuScope.item$default(r8, new ContextMenu_androidKt.AnonymousClass1(r12), null, false, null, new TextFieldSelectionState_androidKt$contextMenuBuilder$lambda$1$textFieldItem$$inlined$TextItem$1(r9, r10, r11, r12), 14, null);
        return;
    }

    private static final void addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldSuspendItem(TextContextMenuBuilderScope r10, final CoroutineScope r11, Context r12, TextFieldSelectionState r13, TextContextMenuItems r14, boolean r15, final Function1<? super Continuation<? super Unit>, ? extends Object> r16) {
        addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3$default(r10, r12, r13, r14, r15, null, null, new j0(r11, r16), 48, null);
    }

    private static final void addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3(TextContextMenuBuilderScope r1, Context r2, final TextFieldSelectionState r3, TextContextMenuItems r4, boolean r5, final TextToolbarState r6, final Function0<Boolean> r7, final Function0<Unit> r8) {
        ContextMenu_androidKt.textItem(r1, r2.getResources(), r4, r5, new e0(r8, r7, r3, r6));
    }

    public static /* synthetic */ void addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3$default(TextContextMenuBuilderScope r9, Context r10, TextFieldSelectionState r11, TextContextMenuItems r12, boolean r13, TextToolbarState r14, Function0 r15, Function0 r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        TextToolbarState r6 = TextToolbarState.None;
    L7:
        if ((r17 & 32) == 0) goto L9;
        Function0 r7 = null;
    L10:
        addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3(r9, r10, r11, r12, r13, r6, r7, r16);
        return;
    L9:
        r7 = r15;
        goto L10
    L5:
        r6 = r14;
        goto L7
    }
}
