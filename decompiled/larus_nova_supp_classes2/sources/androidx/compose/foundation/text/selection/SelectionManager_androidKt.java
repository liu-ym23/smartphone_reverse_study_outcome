package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.view.KeyEvent;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifier_androidKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a%\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0014\u0010\u0011\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0000¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"isCopyKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "isCopyKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "selectionMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "addSelectionContainerTextContextMenuComponents", "selectionManager", "foundation_release", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionManager_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ SelectionManager $manager;

        public AnonymousClass1(SelectionManager r1) {
            this.$manager = r1;
        }

        public static /* synthetic */ Modifier a(Density r0, MutableState r1, Function0 r2) {
            return invoke$lambda$9$lambda$8(r0, r1, r2);
        }

        public static /* synthetic */ Offset b(SelectionManager r0, MutableState r1) {
            return invoke$lambda$4$lambda$3(r0, r1);
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

        private static final Offset invoke$lambda$4$lambda$3(SelectionManager r2, MutableState r3) {
            return Offset.box-impl(SelectionManagerKt.m1877calculateSelectionMagnifierCenterAndroidO0kMr_c(r2, invoke$lambda$1(r3)));
        }

        private static final Offset invoke$lambda$9$lambda$8$lambda$5(Function0 r0, Density r1) {
            return (Offset) r0.invoke();
        }

        private static final Modifier invoke$lambda$9$lambda$8(final Density r14, final MutableState r15, final Function0 r16) {
            return Magnifier_androidKt.m425magnifierjPUL71Q$default(Modifier.Companion, new o1(r16), null, new p1(r14, r15), MenuKt.ClosedAlphaTarget, true, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, false, PlatformMagnifierFactory.Companion.getForCurrentPlatform(), 490, null);
        }

        private static final Unit invoke$lambda$9$lambda$8$lambda$7(Density r6, MutableState r7, DpSize r8) {
            int r0 = r6.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(r8.unbox-impl()));
            invoke$lambda$2(r7, IntSize.constructor-impl((((long) r0) << 32) | (((long) r6.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(r8.unbox-impl()))) & 4294967295L)));
            return Unit.INSTANCE;
        }

        public final Modifier invoke(Modifier r6, Composer r7, int r8) {
            r7.startReplaceGroup(-1914520728);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-1914520728, r8, -1, "androidx.compose.foundation.text.selection.selectionMagnifier.<anonymous> (SelectionManager.android.kt:54)");
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
            final SelectionManager r4 = this.$manager;
            Object r5 = r7.rememberedValue();
            if (r3 == false) goto L11;
        L12:
            r5 = new m1(r4, r2);
            r7.updateRememberedValue(r5);
        L13:
            Function0 r10 = (Function0) r5;
            boolean r11 = r7.changed(r9);
            Object r12 = r7.rememberedValue();
            if (r11 == false) goto L16;
        L17:
            r12 = new n1(r9, r2);
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

    public static /* synthetic */ Unit a(SelectionManager r0) {
        return addSelectionContainerTextContextMenuComponents$lambda$9$lambda$8$lambda$7$lambda$6(r0);
    }

    public static /* synthetic */ Unit b(SelectionManager r0) {
        return contextMenuBuilder$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ boolean c(SelectionManager r0) {
        return addSelectionContainerTextContextMenuComponents$lambda$9$lambda$8$lambda$7$lambda$5(r0);
    }

    public static /* synthetic */ Unit d(SelectionManager r0, Context r1, TextContextMenuBuilderScope r2) {
        return addSelectionContainerTextContextMenuComponents$lambda$9$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(SelectionManager r0, TextContextMenuBuilderScope r1, Context r2) {
        return addSelectionContainerTextContextMenuComponents$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ Unit f(Function0 r0, Function0 r1, TextContextMenuSession r2) {
        return addSelectionContainerTextContextMenuComponents$lambda$9$selectionContainerItem$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit g(SelectionManager r0) {
        return contextMenuBuilder$lambda$2$lambda$0(r0);
    }

    public static /* synthetic */ Unit h(SelectionManager r0, ContextMenuState r1, ContextMenuScope r2) {
        return contextMenuBuilder$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit i(SelectionManager r0) {
        return addSelectionContainerTextContextMenuComponents$lambda$9$lambda$8$lambda$7$lambda$4(r0);
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$9$lambda$8$lambda$7$lambda$4(SelectionManager r0) {
        r0.copy$foundation_release();
        return Unit.INSTANCE;
    }

    private static final boolean addSelectionContainerTextContextMenuComponents$lambda$9$lambda$8$lambda$7$lambda$5(SelectionManager r1) {
        if (r1.getShowToolbar$foundation_release() == true) goto L5;
    L8:
        return true;
    L5:
        if (r1.isInTouchMode() == false) goto L8;
        return false;
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$9$lambda$8$lambda$7$lambda$6(SelectionManager r0) {
        r0.selectAll$foundation_release();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$2$lambda$0(SelectionManager r0) {
        r0.copy$foundation_release();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$2$lambda$1(SelectionManager r0) {
        r0.selectAll$foundation_release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: isCopyKeyEvent-ZmokQxo, reason: not valid java name */
    public static final boolean m1880isCopyKeyEventZmokQxo(KeyEvent r1) {
        if (KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1370mapZmokQxo(r1) != KeyCommand.COPY) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Modifier addSelectionContainerTextContextMenuComponents(Modifier r1, final SelectionManager r2) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(r1, new d1(r2));
    }

    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final SelectionManager r1, final ContextMenuState r2) {
        return new l1(r1, r2);
    }

    public static final Modifier selectionMagnifier(Modifier r3, SelectionManager r4) {
        if (Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null) == true) goto L6;
        return r3;
    L6:
        return ComposedModifierKt.composed$default(r3, null, new AnonymousClass1(r4), 1, null);
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$9(final SelectionManager r8, TextContextMenuBuilderScope r9, final Context r10) {
        Pair<AnnotatedString, TextRange> r0 = r8.getContextTextAndSelection$foundation_release();
        if (r0 == null) goto L5;
        CharSequence r4 = (AnnotatedString) r0.getFirst();
    L6:
        if (r0 == null) goto L8;
        TextRange r5 = (TextRange) r0.getSecond();
    L9:
        PlatformSelectionBehaviors_androidKt.m1843addPlatformTextContextMenuItems71BSaZU(r9, r10, false, r4, r5, r8.getPlatformSelectionBehaviors$foundation_release(), new f1(r8, r10));
        return Unit.INSTANCE;
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$9$lambda$8(final SelectionManager r15, Context r16, TextContextMenuBuilderScope r17) {
        r17.separator();
        addSelectionContainerTextContextMenuComponents$lambda$9$selectionContainerItem$default(r17, r16, TextContextMenuItems.Copy, r15.isNonEmptySelection$foundation_release(), null, new g1(r15), 8, null);
        addSelectionContainerTextContextMenuComponents$lambda$9$selectionContainerItem(r17, r16, TextContextMenuItems.SelectAll, !r15.isEntireContainerSelected$foundation_release(), new h1(r15), new i1(r15));
        r17.separator();
        return Unit.INSTANCE;
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$9$selectionContainerItem$lambda$3(Function0 r0, Function0 r1, TextContextMenuSession r2) {
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

    private static final Unit contextMenuBuilder$lambda$2(final SelectionManager r6, ContextMenuState r7, ContextMenuScope r8) {
        contextMenuBuilder$lambda$2$selectionItem(r8, r7, TextContextMenuItems.Copy, r6.isNonEmptySelection$foundation_release(), new j1(r6));
        Unit r1 = Unit.INSTANCE;
        contextMenuBuilder$lambda$2$selectionItem(r8, r7, TextContextMenuItems.SelectAll, !r6.isEntireContainerSelected$foundation_release(), new k1(r6));
        CollectionsKt.listOf(new Unit[]{r1, r1});
        return r1;
    }

    private static final void contextMenuBuilder$lambda$2$selectionItem(ContextMenuScope r8, ContextMenuState r9, TextContextMenuItems r10, boolean r11, Function0<Unit> r12) {
        if (r11 == false) goto L5;
        ContextMenuScope.item$default(r8, new ContextMenu_androidKt.AnonymousClass1(r10), null, false, null, new ContextMenu_androidKt.AnonymousClass2(r12, r9), 14, null);
        return;
    }

    private static final void addSelectionContainerTextContextMenuComponents$lambda$9$selectionContainerItem(TextContextMenuBuilderScope r1, Context r2, TextContextMenuItems r3, boolean r4, final Function0<Boolean> r5, final Function0<Unit> r6) {
        ContextMenu_androidKt.textItem(r1, r2.getResources(), r3, r4, new e1(r6, r5));
    }

    public static /* synthetic */ void addSelectionContainerTextContextMenuComponents$lambda$9$selectionContainerItem$default(TextContextMenuBuilderScope r6, Context r7, TextContextMenuItems r8, boolean r9, Function0 r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        addSelectionContainerTextContextMenuComponents$lambda$9$selectionContainerItem(r6, r7, r8, r9, r10, r11);
    }
}
