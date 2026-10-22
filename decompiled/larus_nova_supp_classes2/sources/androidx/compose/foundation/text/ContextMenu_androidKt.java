package androidx.compose.foundation.text;

import android.content.res.Resources;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.PlatformDefaultTextContextMenuProviders_androidKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\f\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0004\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a=\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u001eH\u0000\u001a\u0012\u0010\u001f\u001a\u00020 *\u00020\tH\u0080@¢\u0006\u0002\u0010!\u001a\u0012\u0010\u001f\u001a\u00020 *\u00020\u0003H\u0080@¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"ContextMenuArea", "", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "enabled", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/SelectionManager;", "(Landroidx/compose/foundation/text/selection/SelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextItem", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "label", "Landroidx/compose/foundation/text/TextContextMenuItems;", "operation", "textItem", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "resources", "Landroid/content/res/Resources;", "item", "onClick", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ExtensionFunctionType;", "getContextMenuItemsAvailability", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextMenu_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, String> {
        final /* synthetic */ TextContextMenuItems $label;

        public AnonymousClass1(TextContextMenuItems r1) {
            this.$label = r1;
        }

        public final String invoke(Composer r4, int r5) {
            r4.startReplaceGroup(-1744780674);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-1744780674, r5, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (ContextMenu.android.kt:202)");
        L5:
            String r6 = this.$label.resolvedString(r4, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L8;
            ComposerKt.traceEventEnd();
        L8:
            r4.endReplaceGroup();
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Composer) r1, ((Number) r2).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass2 implements Function0<Unit> {
        final /* synthetic */ Function0<Unit> $operation;
        final /* synthetic */ ContextMenuState $state;

        public AnonymousClass2(Function0<Unit> r1, ContextMenuState r2) {
            this.$operation = r1;
            this.$state = r2;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1363invoke() {
            this.$operation.invoke();
            ContextMenuState_androidKt.close(this.$state);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1363invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$getContextMenuItemsAvailability$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt", f = "ContextMenu.android.kt", i = {0}, l = {228}, m = "getContextMenuItemsAvailability", n = {"$this$getContextMenuItemsAvailability"}, s = {"L$0"})
    public static final class C02091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02091(Continuation<? super C02091> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return ContextMenu_androidKt.getContextMenuItemsAvailability(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$getContextMenuItemsAvailability$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt", f = "ContextMenu.android.kt", i = {0}, l = {240}, m = "getContextMenuItemsAvailability", n = {"$this$getContextMenuItemsAvailability"}, s = {"L$0"})
    public static final class C02102 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02102(Continuation<? super C02102> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return ContextMenu_androidKt.getContextMenuItemsAvailability(null, this);
        }
    }

    private static final Unit ContextMenuArea$lambda$16(TextFieldSelectionState r0, boolean r1, Function2 r2, int r3, Composer r4, int r5) {
        ContextMenuArea(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$20(SelectionManager r0, Function2 r1, int r2, Composer r3, int r4) {
        ContextMenuArea(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$6(TextFieldSelectionManager r0, Function2 r1, int r2, Composer r3, int r4) {
        ContextMenuArea(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextFieldSelectionState r0, boolean r1, Function2 r2, int r3, Composer r4, int r5) {
        return ContextMenuArea$lambda$16(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit b(TextFieldSelectionManager r0, Function2 r1, int r2, Composer r3, int r4) {
        return ContextMenuArea$lambda$6(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(CoroutineScope r0, MutableState r1, TextFieldSelectionState r2) {
        return ContextMenuArea$lambda$15$lambda$14(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(ContextMenuState r0) {
        return ContextMenuArea$lambda$19$lambda$18(r0);
    }

    public static /* synthetic */ Unit e(ContextMenuState r0) {
        return ContextMenuArea$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit f(ContextMenuState r0) {
        return ContextMenuArea$lambda$13$lambda$12(r0);
    }

    public static /* synthetic */ Unit g(SelectionManager r0, Function2 r1, int r2, Composer r3, int r4) {
        return ContextMenuArea$lambda$20(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit h(CoroutineScope r0, TextFieldSelectionState r1, TextContextMenuItems r2) {
        return ContextMenuArea$lambda$11$lambda$10(r0, r1, r2);
    }

    public static /* synthetic */ Unit i(CoroutineScope r0, MutableState r1, TextFieldSelectionManager r2) {
        return ContextMenuArea$lambda$5$lambda$4(r0, r1, r2);
    }

    private static final Unit ContextMenuArea$lambda$13$lambda$12(ContextMenuState r0) {
        ContextMenuState_androidKt.close(r0);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$19$lambda$18(ContextMenuState r0) {
        ContextMenuState_androidKt.close(r0);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$3$lambda$2(ContextMenuState r0) {
        ContextMenuState_androidKt.close(r0);
        return Unit.INSTANCE;
    }

    public static final Object getContextMenuItemsAvailability(TextFieldSelectionState r4, Continuation<? super MenuItemsAvailability> r5) {
        if ((r5 instanceof C02091) == false) goto L7;
        C02091 r0 = (C02091) r5;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r4 = (TextFieldSelectionState) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L18:
        return MenuItemsAvailability.m1424boximpl(MenuItemsAvailability.m1426constructorimpl(r4.canCopy(), r4.canPaste(), r4.canCut(), r4.canSelectAll(), r4.canAutofill()));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r0.L$0 = r4;
        r0.label = 1;
        if (r4.updateClipboardEntry(r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new C02091(r5);
        goto L8
    }

    public static final Object getContextMenuItemsAvailability(TextFieldSelectionManager r4, Continuation<? super MenuItemsAvailability> r5) {
        if ((r5 instanceof C02102) == false) goto L7;
        C02102 r0 = (C02102) r5;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r4 = (TextFieldSelectionManager) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L18:
        return MenuItemsAvailability.m1424boximpl(MenuItemsAvailability.m1426constructorimpl(r4.canCopy$foundation_release(), r4.canPaste$foundation_release(), r4.canCut$foundation_release(), r4.canSelectAll$foundation_release(), r4.canAutofill$foundation_release()));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r0.L$0 = r4;
        r0.label = 1;
        if (r4.updateClipboardEntry$foundation_release(r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new C02102(r5);
        goto L8
    }

    private static final Unit ContextMenuArea$lambda$11$lambda$10(CoroutineScope r6, TextFieldSelectionState r7, TextContextMenuItems r8) {
        BuildersKt.launch$default(r6, null, CoroutineStart.UNDISPATCHED, new ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1(r8, r7, null), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$15$lambda$14(CoroutineScope r6, MutableState r7, TextFieldSelectionState r8) {
        BuildersKt.launch$default(r6, null, CoroutineStart.UNDISPATCHED, new ContextMenu_androidKt$ContextMenuArea$5$1$1(r7, r8, null), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$5$lambda$4(CoroutineScope r6, MutableState r7, TextFieldSelectionManager r8) {
        BuildersKt.launch$default(r6, null, CoroutineStart.UNDISPATCHED, new ContextMenu_androidKt$ContextMenuArea$2$1$1(r7, r8, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final void ContextMenuArea(final TextFieldSelectionManager r11, final Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, final int r14) {
        Composer r15 = r13.startRestartGroup(2080741862);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r14 & 48) != 0) goto L18;
        if (r15.changedInstance(r12) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r4 = true;
    L22:
        if (r15.shouldExecute(r4, r1 & 1) == true) goto L24;
        r15.skipToGroupEnd();
    L51:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L55;
        r16.updateScope(new p1(r11, r12, r14));
        return;
    L55:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventStart(2080741862, r1, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:52)");
    L27:
        if (ComposeFoundationFlags.isNewContextMenuEnabled == false) goto L29;
        r15.startReplaceGroup(-1881943916);
        PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(r11.getContextMenuAreaModifier(), r12, r15, r1 & 112, 0);
        r15.endReplaceGroup();
    L48:
        if (ComposerKt.isTraceInProgress() == false) goto L51;
        ComposerKt.traceEventEnd();
        goto L51
    L29:
        r15.startReplaceGroup(-1881814801);
        Object r0 = r15.rememberedValue();
        Composer.Companion r5 = Composer.Companion;
        if (r0 != r5.getEmpty()) goto L32;
        r0 = new ContextMenuState(null, 1, null);
        r15.updateRememberedValue(r0);
    L32:
        final ContextMenuState r2 = (ContextMenuState) r0;
        Object r6 = r15.rememberedValue();
        if (r6 != r5.getEmpty()) goto L35;
        r6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r15);
        r15.updateRememberedValue(r6);
    L35:
        final CoroutineScope r7 = (CoroutineScope) r6;
        Object r8 = r15.rememberedValue();
        if (r8 != r5.getEmpty()) goto L38;
        r8 = SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.m1424boximpl(MenuItemsAvailability.Companion.m1437getNoneJKCFgKw()), null, 2, null);
        r15.updateRememberedValue(r8);
    L38:
        final MutableState r9 = (MutableState) r8;
        Object r10 = r15.rememberedValue();
        if (r10 != r5.getEmpty()) goto L41;
        r10 = new n1(r2);
        r15.updateRememberedValue(r10);
    L41:
        Function0 r17 = (Function0) r10;
        Function1<ContextMenuScope, Unit> r18 = TextFieldSelectionManager_androidKt.contextMenuBuilder(r11, r2, r9);
        boolean r19 = r11.getEnabled();
        boolean r20 = r15.changedInstance(r7) | r15.changedInstance(r11);
        Object r110 = r15.rememberedValue();
        if (r20 == false) goto L44;
    L45:
        r110 = new o1(r7, r9, r11);
        r15.updateRememberedValue(r110);
    L46:
        ContextMenuArea_androidKt.ContextMenuArea(r2, r17, r18, null, r19, (Function0) r110, r12, r15, ((r1 << 15) & 3670016) | 54, 8);
        r15.endReplaceGroup();
        goto L48
    L44:
        if (r110 != r5.getEmpty()) goto L46;
    L20:
        r4 = false;
        goto L22
    L5:
        if (r15.changedInstance(r11) == false) goto L7;
        int r21 = 4;
    L8:
        r1 = r21 | r14;
        goto L11
    L7:
        r21 = 2;
        goto L8
    }

    public static final void ContextMenuArea(final SelectionManager r11, final Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, final int r14) {
        Composer r15 = r13.startRestartGroup(-954926513);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r14 & 48) != 0) goto L18;
        if (r15.changedInstance(r12) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r15.shouldExecute(r3, r1 & 1) == true) goto L24;
        r15.skipToGroupEnd();
    L40:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L44;
        r16.updateScope(new r1(r11, r12, r14));
        return;
    L44:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventStart(-954926513, r1, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:136)");
    L27:
        if (ComposeFoundationFlags.isNewContextMenuEnabled == false) goto L29;
        r15.startReplaceGroup(1647828491);
        PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(r11.getContextMenuAreaModifier(), r12, r15, r1 & 112, 0);
        r15.endReplaceGroup();
    L37:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventEnd();
        goto L40
    L29:
        r15.startReplaceGroup(1647943935);
        Object r0 = r15.rememberedValue();
        Composer.Companion r4 = Composer.Companion;
        if (r0 != r4.getEmpty()) goto L32;
        r0 = new ContextMenuState(null, 1, null);
        r15.updateRememberedValue(r0);
    L32:
        final ContextMenuState r5 = (ContextMenuState) r0;
        Object r6 = r15.rememberedValue();
        if (r6 != r4.getEmpty()) goto L35;
        r6 = new q1(r5);
        r15.updateRememberedValue(r6);
    L35:
        ContextMenuArea_androidKt.ContextMenuArea(r5, (Function0) r6, SelectionManager_androidKt.contextMenuBuilder(r11, r5), null, false, null, r12, r15, ((r1 << 15) & 3670016) | 54, 56);
        r15.endReplaceGroup();
        goto L37
    L20:
        r3 = false;
        goto L22
    L5:
        if (r15.changedInstance(r11) == false) goto L7;
        int r7 = 4;
    L8:
        r1 = r7 | r14;
        goto L11
    L7:
        r7 = 2;
        goto L8
    }

    public static final void ContextMenuArea(final TextFieldSelectionState r11, final boolean r12, final Function2<? super Composer, ? super Integer, Unit> r13, Composer r14, final int r15) {
        Composer r16 = r14.startRestartGroup(-579239002);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L11:
        if ((r15 & 48) != 0) goto L18;
        if (r16.changed(r12) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r15 & 384) != 0) goto L25;
        if (r16.changedInstance(r13) == false) goto L22;
        int r4 = 256;
    L23:
        r1 = r1 | r4;
        goto L25
    L22:
        r4 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r5 = true;
    L29:
        if (r16.shouldExecute(r5, r1 & 1) == true) goto L31;
        r16.skipToGroupEnd();
    L72:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L76;
        r17.updateScope(new v1(r11, r12, r13, r15));
        return;
    L76:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-579239002, r1, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:81)");
    L34:
        if (ComposeFoundationFlags.isNewContextMenuEnabled == false) goto L45;
        r16.startReplaceGroup(1069759610);
        if (r12 == false) goto L43;
        r16.startReplaceGroup(1069803754);
        Modifier.Companion r0 = Modifier.Companion;
        boolean r2 = r16.changedInstance(r11);
        Object r6 = r16.rememberedValue();
        if (r2 == false) goto L40;
    L41:
        r6 = new ContextMenu_androidKt$ContextMenuArea$modifier$1$1(r11, null);
        r16.updateRememberedValue(r6);
    L42:
        Modifier r7 = TextContextMenuGesturesModifierKt.textContextMenuGestures(r0, (Function1) r6);
        r16.endReplaceGroup();
    L44:
        PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(r7, r13, r16, (r1 >> 3) & 112, 0);
        r16.endReplaceGroup();
    L69:
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
        goto L72
    L40:
        if (r6 != Composer.Companion.getEmpty()) goto L42;
    L43:
        r16.startReplaceGroup(1070289524);
        r16.endReplaceGroup();
        r7 = Modifier.Companion;
        goto L44
    L45:
        r16.startReplaceGroup(1070458381);
        Object r8 = r16.rememberedValue();
        Composer.Companion r9 = Composer.Companion;
        if (r8 != r9.getEmpty()) goto L48;
        r8 = new ContextMenuState(null, 1, null);
        r16.updateRememberedValue(r8);
    L48:
        final ContextMenuState r10 = (ContextMenuState) r8;
        Object r18 = r16.rememberedValue();
        if (r18 != r9.getEmpty()) goto L51;
        r18 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r16);
        r16.updateRememberedValue(r18);
    L51:
        final CoroutineScope r19 = (CoroutineScope) r18;
        Object r20 = r16.rememberedValue();
        if (r20 != r9.getEmpty()) goto L54;
        r20 = SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.m1424boximpl(MenuItemsAvailability.Companion.m1437getNoneJKCFgKw()), null, 2, null);
        r16.updateRememberedValue(r20);
    L54:
        final MutableState r21 = (MutableState) r20;
        boolean r22 = r16.changedInstance(r19);
        Object r23 = r16.rememberedValue();
        if (r22 == false) goto L57;
    L58:
        r23 = new s1(r19);
        r16.updateRememberedValue(r23);
    L59:
        Function1<ContextMenuScope, Unit> r24 = TextFieldSelectionState_androidKt.contextMenuBuilder(r11, r10, r21, (Function2) r23);
        Object r25 = r16.rememberedValue();
        if (r25 != r9.getEmpty()) goto L62;
        r25 = new t1(r10);
        r16.updateRememberedValue(r25);
    L62:
        Function0 r26 = (Function0) r25;
        boolean r27 = r16.changedInstance(r19) | r16.changedInstance(r11);
        Object r28 = r16.rememberedValue();
        if (r27 == false) goto L65;
    L66:
        r28 = new u1(r19, r21, r11);
        r16.updateRememberedValue(r28);
    L67:
        ContextMenuArea_androidKt.ContextMenuArea(r10, r26, r24, null, r12, (Function0) r28, r13, r16, (((r1 << 9) & 57344) | 54) | ((r1 << 12) & 3670016), 8);
        r16.endReplaceGroup();
        goto L69
    L65:
        if (r28 != r9.getEmpty()) goto L67;
    L57:
        if (r23 != r9.getEmpty()) goto L59;
    L27:
        r5 = false;
        goto L29
    L5:
        if (r16.changedInstance(r11) == false) goto L7;
        int r29 = 4;
    L8:
        r1 = r29 | r15;
        goto L11
    L7:
        r29 = 2;
        goto L8
    }

    public static final void TextItem(ContextMenuScope r8, ContextMenuState r9, TextContextMenuItems r10, boolean r11, Function0<Unit> r12) {
        if (r11 == false) goto L5;
        ContextMenuScope.item$default(r8, new AnonymousClass1(r10), null, false, null, new AnonymousClass2(r12, r9), 14, null);
        return;
    }

    public static final void textItem(TextContextMenuBuilderScope r0, Resources r1, TextContextMenuItems r2, boolean r3, Function1<? super TextContextMenuSession, Unit> r4) {
        if (r3 == false) goto L5;
        TextContextMenuBuilderScope_androidKt.item(r0, r2.getKey(), r2.resolveString(r1), r2.getDrawableId(), r4);
        return;
    }
}
