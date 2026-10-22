package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifier_androidKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0000\u001a3\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"isShiftPressed", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "textFieldMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "addBasicTextFieldTextContextMenuComponents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "contextMenuState", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "foundation_release", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldSelectionManager_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ TextFieldSelectionManager $manager;

        public AnonymousClass1(TextFieldSelectionManager r1) {
            this.$manager = r1;
        }

        public static /* synthetic */ Offset a(TextFieldSelectionManager r0, MutableState r1) {
            return invoke$lambda$4$lambda$3(r0, r1);
        }

        public static /* synthetic */ Modifier b(Density r0, MutableState r1, Function0 r2) {
            return invoke$lambda$9$lambda$8(r0, r1, r2);
        }

        public static /* synthetic */ Offset c(Function0 r0, Density r1) {
            return invoke$lambda$9$lambda$8$lambda$5(r0, r1);
        }

        public static /* synthetic */ Unit d(Density r0, MutableState r1, DpSize r2) {
            return invoke$lambda$9$lambda$8$lambda$7(r0, r1, r2);
        }

        private static final long invoke$lambda$1(MutableState<IntSize> r2) {
            return ((IntSize) r2.getValue()).unbox-impl();
        }

        private static final void invoke$lambda$2(MutableState<IntSize> r0, long r1) {
            r0.setValue(IntSize.box-impl(r1));
        }

        private static final Offset invoke$lambda$4$lambda$3(TextFieldSelectionManager r2, MutableState r3) {
            return Offset.box-impl(TextFieldSelectionManagerKt.m1909calculateSelectionMagnifierCenterAndroidO0kMr_c(r2, invoke$lambda$1(r3)));
        }

        private static final Offset invoke$lambda$9$lambda$8$lambda$5(Function0 r0, Density r1) {
            return (Offset) r0.invoke();
        }

        private static final Modifier invoke$lambda$9$lambda$8(final Density r14, final MutableState r15, final Function0 r16) {
            return Magnifier_androidKt.m425magnifierjPUL71Q$default(Modifier.Companion, new u2(r16), null, new v2(r14, r15), MenuKt.ClosedAlphaTarget, true, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, false, PlatformMagnifierFactory.Companion.getForCurrentPlatform(), 490, null);
        }

        private static final Unit invoke$lambda$9$lambda$8$lambda$7(Density r6, MutableState r7, DpSize r8) {
            int r0 = r6.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(r8.unbox-impl()));
            invoke$lambda$2(r7, IntSize.constructor-impl((((long) r0) << 32) | (((long) r6.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(r8.unbox-impl()))) & 4294967295L)));
            return Unit.INSTANCE;
        }

        public final Modifier invoke(Modifier r6, Composer r7, int r8) {
            r7.startReplaceGroup(1980580247);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(1980580247, r8, -1, "androidx.compose.foundation.text.selection.textFieldMagnifier.<anonymous> (TextFieldSelectionManager.android.kt:62)");
        L5:
            final Density r9 = (Density) r7.consume(CompositionLocalsKt.getLocalDensity());
            Object r0 = r7.rememberedValue();
            Composer.Companion r1 = Composer.Companion;
            if (r0 != r1.getEmpty()) goto L8;
            r0 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
            r7.updateRememberedValue(r0);
        L8:
            final MutableState r2 = (MutableState) r0;
            boolean r3 = r7.changedInstance(this.$manager);
            final TextFieldSelectionManager r4 = this.$manager;
            Object r5 = r7.rememberedValue();
            if (r3 == false) goto L11;
        L12:
            r5 = new s2(r4, r2);
            r7.updateRememberedValue(r5);
        L13:
            Function0 r10 = (Function0) r5;
            boolean r11 = r7.changed(r9);
            Object r12 = r7.rememberedValue();
            if (r11 == false) goto L16;
        L17:
            r12 = new t2(r9, r2);
            r7.updateRememberedValue(r12);
        L18:
            Modifier r13 = SelectionMagnifierKt.animatedSelectionMagnifier(r6, r10, (Function1) r12);
            if (ComposerKt.isTraceInProgress() == false) goto L21;
            ComposerKt.traceEventEnd();
        L21:
            r7.endReplaceGroup();
            return r13;
        L16:
            if (r12 != r1.getEmpty()) goto L18;
        L11:
            if (r5 != r1.getEmpty()) goto L13;
            goto L12
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        }
    }

    public static /* synthetic */ Unit a(TextFieldSelectionManager r0) {
        return contextMenuBuilder$lambda$15$lambda$10(r0);
    }

    public static /* synthetic */ Unit b(CoroutineScope r0, Function1 r1) {
        return addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldSuspendItem$lambda$1(r0, r1);
    }

    public static /* synthetic */ boolean c(TextFieldSelectionManager r0) {
        return addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$3(r0);
    }

    public static /* synthetic */ Unit d(TextFieldSelectionManager r0) {
        return contextMenuBuilder$lambda$15$lambda$14(r0);
    }

    public static /* synthetic */ Unit e(TextFieldSelectionManager r0) {
        return addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit f(TextFieldSelectionManager r0, CoroutineScope r1, TextContextMenuBuilderScope r2, Context r3) {
        return addBasicTextFieldTextContextMenuComponents$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit g(TextFieldSelectionManager r0) {
        return contextMenuBuilder$lambda$15$lambda$13(r0);
    }

    public static /* synthetic */ Unit h(TextFieldSelectionManager r0) {
        return addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$4(r0);
    }

    public static /* synthetic */ Unit i(TextFieldSelectionManager r0) {
        return contextMenuBuilder$lambda$15$lambda$11(r0);
    }

    public static final boolean isShiftPressed(PointerEvent r0) {
        return false;
    }

    public static /* synthetic */ Unit j(Function0 r0, Function0 r1, TextContextMenuSession r2) {
        return addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit k(TextFieldSelectionManager r0) {
        return contextMenuBuilder$lambda$15$lambda$12(r0);
    }

    public static /* synthetic */ Unit l(TextFieldSelectionManager r0, CoroutineScope r1, Context r2, TextContextMenuBuilderScope r3) {
        return addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit m(State r0, TextFieldSelectionManager r1, ContextMenuState r2, ContextMenuScope r3) {
        return contextMenuBuilder$lambda$15(r0, r1, r2, r3);
    }

    private static final boolean addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$3(TextFieldSelectionManager r0) {
        return !r0.getTextToolbarShown$foundation_release();
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$4(TextFieldSelectionManager r0) {
        r0.selectAll$foundation_release();
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$5(TextFieldSelectionManager r0) {
        r0.autofill$foundation_release();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$15$lambda$10(TextFieldSelectionManager r0) {
        r0.cut$foundation_release();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$15$lambda$11(TextFieldSelectionManager r1) {
        r1.copy$foundation_release(false);
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$15$lambda$12(TextFieldSelectionManager r0) {
        r0.paste$foundation_release();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$15$lambda$13(TextFieldSelectionManager r0) {
        r0.selectAll$foundation_release();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$15$lambda$14(TextFieldSelectionManager r0) {
        r0.autofill$foundation_release();
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldSuspendItem$lambda$1(CoroutineScope r6, Function1 r7) {
        BuildersKt.launch$default(r6, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$textFieldSuspendItem$1$1(r7, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final Modifier textFieldMagnifier(Modifier r3, TextFieldSelectionManager r4) {
        if (Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null) == true) goto L6;
        return r3;
    L6:
        return ComposedModifierKt.composed$default(r3, null, new AnonymousClass1(r4), 1, null);
    }

    public static final Modifier addBasicTextFieldTextContextMenuComponents(Modifier r1, final TextFieldSelectionManager r2, final CoroutineScope r3) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(r1, new i2(r2, r3));
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem$lambda$0(Function0 r0, Function0 r1, TextContextMenuSession r2) {
        r0.invoke();
        if (r1 == null) goto L5;
        boolean r3 = ((Boolean) r1.invoke()).booleanValue();
    L6:
        if (r3 == false) goto L9;
        r2.close();
    L9:
        return Unit.INSTANCE;
    L5:
        r3 = true;
        goto L6
    }

    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionManager r1, final ContextMenuState r2, final State<MenuItemsAvailability> r3) {
        return new f2(r3, r1, r2);
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$8(final TextFieldSelectionManager r7, final CoroutineScope r8, TextContextMenuBuilderScope r9, final Context r10) {
        boolean r2 = r7.getEditable();
        AnnotatedString r0 = r7.getTransformedText$foundation_release();
        if (r0 == null) goto L5;
        String r3 = r0.getText();
    L6:
        TextRange r1 = r7.m1904getLatestSelectionMzsxiRA$foundation_release();
        if (r1 == null) goto L9;
        long r4 = r1.unbox-impl();
        OffsetMapping r5 = r7.getOffsetMapping$foundation_release();
        TextRange r6 = TextRange.box-impl(TextRangeKt.TextRange(r5.originalToTransformed(TextRange.getStart-impl(r4)), r5.originalToTransformed(TextRange.getEnd-impl(r4))));
    L10:
        PlatformSelectionBehaviors_androidKt.m1843addPlatformTextContextMenuItems71BSaZU(r9, r10, r2, r3, r6, r7.getPlatformSelectionBehaviors$foundation_release(), new k2(r7, r8, r10));
        return Unit.INSTANCE;
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7(final TextFieldSelectionManager r14, CoroutineScope r15, Context r16, TextContextMenuBuilderScope r17) {
        r17.separator();
        addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldSuspendItem(r17, r15, r16, TextContextMenuItems.Cut, r14.canCut$foundation_release(), new TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$2$1$1(r14, null));
        addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldSuspendItem(r17, r15, r16, TextContextMenuItems.Copy, r14.canCopy$foundation_release(), new TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$2$1$2(r14, null));
        addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldSuspendItem(r17, r15, r16, TextContextMenuItems.Paste, r14.canPaste$foundation_release(), new TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$2$1$3(r14, null));
        addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem(r17, r16, TextContextMenuItems.SelectAll, r14.canSelectAll$foundation_release(), new m2(r14), new n2(r14));
        if (Build.VERSION.SDK_INT < 26) goto L5;
        addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem$default(r17, r16, TextContextMenuItems.Autofill, r14.canAutofill$foundation_release(), null, new o2(r14), 8, null);
    L5:
        r17.separator();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$15(State r3, final TextFieldSelectionManager r4, ContextMenuState r5, ContextMenuScope r6) {
        int r7 = ((MenuItemsAvailability) r3.getValue()).m1436unboximpl();
        contextMenuBuilder$lambda$15$textFieldItem$9(r6, r5, TextContextMenuItems.Cut, MenuItemsAvailability.m1431getCanCutimpl(r7), new p2(r4));
        contextMenuBuilder$lambda$15$textFieldItem$9(r6, r5, TextContextMenuItems.Copy, MenuItemsAvailability.m1430getCanCopyimpl(r7), new q2(r4));
        contextMenuBuilder$lambda$15$textFieldItem$9(r6, r5, TextContextMenuItems.Paste, MenuItemsAvailability.m1432getCanPasteimpl(r7), new r2(r4));
        contextMenuBuilder$lambda$15$textFieldItem$9(r6, r5, TextContextMenuItems.SelectAll, MenuItemsAvailability.m1433getCanSelectAllimpl(r7), new g2(r4));
        if (Build.VERSION.SDK_INT < 26) goto L6;
        contextMenuBuilder$lambda$15$textFieldItem$9(r6, r5, TextContextMenuItems.Autofill, MenuItemsAvailability.m1429getCanAutofillimpl(r7), new h2(r4));
    L6:
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$15$textFieldItem$9(ContextMenuScope r8, ContextMenuState r9, TextContextMenuItems r10, boolean r11, Function0<Unit> r12) {
        if (r11 == false) goto L5;
        ContextMenuScope.item$default(r8, new ContextMenu_androidKt.AnonymousClass1(r10), null, false, null, new ContextMenu_androidKt.AnonymousClass2(r12, r9), 14, null);
        return;
    }

    private static final void addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem(TextContextMenuBuilderScope r1, Context r2, TextContextMenuItems r3, boolean r4, final Function0<Boolean> r5, final Function0<Unit> r6) {
        ContextMenu_androidKt.textItem(r1, r2.getResources(), r3, r4, new j2(r6, r5));
    }

    private static final void addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldSuspendItem(TextContextMenuBuilderScope r8, final CoroutineScope r9, Context r10, TextContextMenuItems r11, boolean r12, final Function1<? super Continuation<? super Unit>, ? extends Object> r13) {
        addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem$default(r8, r10, r11, r12, null, new l2(r9, r13), 8, null);
    }

    public static /* synthetic */ void addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem$default(TextContextMenuBuilderScope r6, Context r7, TextContextMenuItems r8, boolean r9, Function0 r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem(r6, r7, r8, r9, r10, r11);
    }
}
