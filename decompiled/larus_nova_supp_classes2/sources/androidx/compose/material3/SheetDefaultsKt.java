package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0000\u001aW\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001e\"\u0010\u0010\u001f\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 \"\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"DragHandleWithTooltip", "", "Landroidx/compose/foundation/layout/ColumnScope;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "velocity", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "positionalThreshold", "Landroidx/compose/ui/unit/Dp;", "velocityThreshold", "rememberSheetState-AGcomas", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "DragHandleVerticalPadding", "F", "BottomSheetAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SheetDefaultsKt {
    private static final AnimationSpec<Float> BottomSheetAnimationSpec = null;
    private static final float DragHandleVerticalPadding = 0.0f;

    private static final Unit DragHandleWithTooltip$lambda$1(ColumnScope r0, Function2 r1, int r2, Composer r3, int r4) {
        DragHandleWithTooltip(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ float a(Density r0, float r1) {
        return rememberSheetState_AGcomas$lambda$6$lambda$5(r0, r1);
    }

    public static /* synthetic */ float b(Density r0, float r1) {
        return rememberSheetState_AGcomas$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ boolean c(SheetValue r0) {
        return rememberSheetState_AGcomas$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit d(ColumnScope r0, Function2 r1, int r2, Composer r3, int r4) {
        return DragHandleWithTooltip$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ SheetState e(boolean r0, Function0 r1, Function0 r2, SheetValue r3, Function1 r4, boolean r5) {
        return rememberSheetState_AGcomas$lambda$11$lambda$10(r0, r1, r2, r3, r4, r5);
    }

    private static final boolean rememberSheetState_AGcomas$lambda$3$lambda$2(SheetValue r0) {
        return true;
    }

    static {
        DragHandleVerticalPadding = Dp.constructor-impl(22);
        BottomSheetAnimationSpec = AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    }

    public static final /* synthetic */ AnimationSpec access$getBottomSheetAnimationSpec$p() {
        return BottomSheetAnimationSpec;
    }

    public static final /* synthetic */ float access$getDragHandleVerticalPadding$p() {
        return DragHandleVerticalPadding;
    }

    private static final float rememberSheetState_AGcomas$lambda$6$lambda$5(Density r0, float r1) {
        return r0.toPx-0680j_4(r1);
    }

    private static final float rememberSheetState_AGcomas$lambda$9$lambda$8(Density r0, float r1) {
        return r0.toPx-0680j_4(r1);
    }

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(final SheetState r1, final Orientation r2, final Function1<? super Float, Unit> r3) {
        return new AnonymousClass1(r1, r3, r2);
    }

    public static final void DragHandleWithTooltip(final ColumnScope r17, final Function2<? super Composer, ? super Integer, Unit> r18, Composer r19, final int r20) {
        Composer r15 = r19.startRestartGroup(1033612924);
        if ((r20 & 6) == 0) goto L5;
        int r2 = r20;
    L11:
        if ((r20 & 48) == 0) goto L13;
    L17:
        int r8 = r2;
        if ((r8 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r15.shouldExecute(r3, r8 & 1) == true) goto L24;
        r15.skipToGroupEnd();
    L42:
        ScopeUpdateScope r1 = r15.endRestartGroup();
        if (r1 == null) goto L46;
        r1.updateScope(new un(r17, r18, r20));
        return;
    L46:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1033612924, r8, -1, "androidx.compose.material3.DragHandleWithTooltip (SheetDefaults.kt:432)");
    L26:
        final String r4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911715), r15, 0);
        Modifier.Companion r5 = Modifier.Companion;
        Alignment.Companion r6 = Alignment.Companion;
        Modifier r7 = r17.align(r5, r6.getCenterHorizontally());
        MeasurePolicy r9 = BoxKt.maybeCachedBoxMeasurePolicy(r6.getTopStart(), false);
        int r10 = ComposablesKt.getCurrentCompositeKeyHash(r15, 0);
        CompositionLocalMap r11 = r15.getCurrentCompositionLocalMap();
        Modifier r12 = ComposedModifierKt.materializeModifier(r15, r7);
        ComposeUiNode.Companion r13 = ComposeUiNode.Companion;
        Function0 r14 = r13.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L29;
        ComposablesKt.invalidApplier();
    L29:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L32;
        r15.createNode(r14);
    L33:
        Composer r16 = Updater.constructor-impl(r15);
        Updater.set-impl(r16, r9, r13.getSetMeasurePolicy());
        Updater.set-impl(r16, r11, r13.getSetResolvedCompositionLocals());
        Function2 r21 = r13.getSetCompositeKeyHash();
        if (r16.getInserting() == false) goto L36;
    L37:
        r16.updateRememberedValue(Integer.valueOf(r10));
        r16.apply(Integer.valueOf(r10), r21);
    L38:
        Updater.set-impl(r16, r12, r13.getSetModifier());
        BoxScopeInstance r22 = BoxScopeInstance.INSTANCE;
        TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m3549rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.Companion.m3535getAbovelOKsHw4(), MenuKt.ClosedAlphaTarget, r15, 390, 2), ComposableLambdaKt.rememberComposableLambda(2059851063, true, new SheetDefaultsKt$DragHandleWithTooltip$1$1(r4), r15, 54), TooltipKt.rememberTooltipState(false, false, null, r15, 0, 7), null, null, false, false, false, r18, r15, ((r8 << 21) & 234881024) | 48, 248);
        r15.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventEnd();
        goto L42
    L36:
        if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r10)) == true) goto L38;
    L32:
        r15.useNode();
        goto L33
    L20:
        r3 = false;
        goto L22
    L13:
        if (r15.changedInstance(r18) == false) goto L15;
        int r23 = 32;
    L16:
        r2 = r2 | r23;
        goto L17
    L15:
        r23 = 16;
        goto L16
    L5:
        if (r15.changed(r17) == false) goto L7;
        int r24 = 4;
    L8:
        r2 = r24 | r20;
        goto L11
    L7:
        r24 = 2;
        goto L8
    }

    private static final SheetState rememberSheetState_AGcomas$lambda$11$lambda$10(boolean r8, Function0 r9, Function0 r10, SheetValue r11, Function1 r12, boolean r13) {
        return new SheetState(r8, r9, r10, r11, r12, r13);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v3 ??, still in use, count: 1, list:
          (r1v3 ?? I:java.lang.Object) from 0x0178: INVOKE (r22v0 ?? I:androidx.compose.runtime.Composer), (r1v3 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:150995320)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* JADX INFO: renamed from: rememberSheetState-AGcomas, reason: not valid java name */
    public static final androidx.compose.material3.SheetState m3114rememberSheetStateAGcomas(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v3 ??, still in use, count: 1, list:
          (r1v3 ?? I:java.lang.Object) from 0x0178: INVOKE (r22v0 ?? I:androidx.compose.runtime.Composer), (r1v3 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:150995320)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r16v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */
}
