package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a®\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0013\b\u0002\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0084\u0001\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00062\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScaffoldKt {
    private static final float FabSpacing = 0.0f;

    private static final Unit ScaffoldLayout_FMILGgc$lambda$16(int r10, Function2 r11, Function3 r12, Function2 r13, Function2 r14, WindowInsets r15, Function2 r16, int r17, Composer r18, int r19) {
        m3036ScaffoldLayoutFMILGgc(r10, r11, r12, r13, r14, r15, r16, r18, RecomposeScopeImplKt.updateChangedFlags(r17 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Scaffold_TvnljyQ$lambda$3(Modifier r16, Function2 r17, Function2 r18, Function2 r19, Function2 r20, int r21, long r22, long r24, WindowInsets r26, Function3 r27, int r28, int r29, Composer r30, int r31) {
        m3035ScaffoldTvnljyQ(r16, r17, r18, r19, r20, r21, r22, r24, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(MutableWindowInsets r0, WindowInsets r1, WindowInsets r2) {
        return Scaffold_TvnljyQ$lambda$2$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(int r0, Function2 r1, Function3 r2, Function2 r3, Function2 r4, WindowInsets r5, Function2 r6, int r7, Composer r8, int r9) {
        return ScaffoldLayout_FMILGgc$lambda$16(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit c(Modifier r0, Function2 r1, Function2 r2, Function2 r3, Function2 r4, int r5, long r6, long r8, WindowInsets r10, Function3 r11, int r12, int r13, Composer r14, int r15) {
        return Scaffold_TvnljyQ$lambda$3(r0, r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit d(Placeable r0, Placeable r1, Placeable r2, int r3, WindowInsets r4, SubcomposeMeasureScope r5, int r6, int r7, Placeable r8, FabPlacement r9, Placeable r10, Integer r11, Placeable.PlacementScope r12) {
        return ScaffoldLayout_FMILGgc$lambda$15$lambda$14$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ MeasureResult e(WindowInsets r0, Function2 r1, Function2 r2, Function2 r3, int r4, Function2 r5, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 r6, Function2 r7, SubcomposeMeasureScope r8, Constraints r9) {
        return ScaffoldLayout_FMILGgc$lambda$15$lambda$14(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static {
        FabSpacing = Dp.constructor-impl(16);
    }

    private static final Unit Scaffold_TvnljyQ$lambda$2$lambda$1(MutableWindowInsets r0, WindowInsets r1, WindowInsets r2) {
        r0.setInsets(WindowInsetsKt.exclude(r1, r2));
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v12 ??, still in use, count: 1, list:
          (r4v12 ?? I:java.lang.Object) from 0x01e5: INVOKE (r1v1 ?? I:androidx.compose.runtime.Composer), (r4v12 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:150995429)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* JADX INFO: renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    private static final void m3036ScaffoldLayoutFMILGgc(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v12 ??, still in use, count: 1, list:
          (r4v12 ?? I:java.lang.Object) from 0x01e5: INVOKE (r1v1 ?? I:androidx.compose.runtime.Composer), (r4v12 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:150995429)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r19v0 ??
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

    /* JADX INFO: renamed from: access$ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final /* synthetic */ void m3037access$ScaffoldLayoutFMILGgc(int r0, Function2 r1, Function3 r2, Function2 r3, Function2 r4, WindowInsets r5, Function2 r6, Composer r7, int r8) {
        m3036ScaffoldLayoutFMILGgc(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    private static final MeasureResult ScaffoldLayout_FMILGgc$lambda$15$lambda$14(final WindowInsets r24, Function2 r25, Function2 r26, Function2 r27, int r28, Function2 r29, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 r30, Function2 r31, final SubcomposeMeasureScope r32, Constraints r33) {
        final int r14 = Constraints.getMaxWidth-impl(r33.unbox-impl());
        final int r15 = Constraints.getMaxHeight-impl(r33.unbox-impl());
        long r1 = Constraints.copy-Zbe2FdA$default(r33.unbox-impl(), 0, 0, 0, 0, 10, null);
        int r3 = r24.getLeft(r32, r32.getLayoutDirection());
        int r4 = r24.getRight(r32, r32.getLayoutDirection());
        int r6 = r24.getBottom(r32);
        final Placeable r7 = ((Measurable) CollectionsKt.first(r32.subcompose(ScaffoldLayoutContent.TopBar, r25))).measure-BRTryo0(r1);
        int r9 = (-r3) - r4;
        int r8 = -r6;
        final Placeable r10 = ((Measurable) CollectionsKt.first(r32.subcompose(ScaffoldLayoutContent.Snackbar, r26))).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r1, r9, r8));
        final Placeable r11 = ((Measurable) CollectionsKt.first(r32.subcompose(ScaffoldLayoutContent.Fab, r27))).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r1, r9, r8));
        if (r11.getWidth() == 0) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == true) goto L28;
        int r13 = r11.getWidth();
        int r16 = r11.getHeight();
        FabPosition.Companion r17 = FabPosition.Companion;
        if (FabPosition.m2703equalsimpl0(r28, r17.m2710getStartERTFSPs()) == false) goto L18;
        if (r32.getLayoutDirection() != LayoutDirection.Ltr) goto L15;
        int r5 = r32.roundToPx-0680j_4(FabSpacing);
    L14:
        int r18 = r5 + r3;
    L27:
        final FabPlacement r19 = new FabPlacement(r18, r13, r16);
    L29:
        final Placeable r20 = ((Measurable) CollectionsKt.first(r32.subcompose(ScaffoldLayoutContent.BottomBar, r29))).measure-BRTryo0(r1);
        if (r20.getWidth() == 0) goto L32;
    L34:
        boolean r21 = false;
    L35:
        if (r19 == null) goto L43;
        if (r21 == false) goto L38;
    L41:
        int r0 = r19.getHeight() + r32.roundToPx-0680j_4(FabSpacing);
        int r22 = r24.getBottom(r32);
    L42:
        final Integer r110 = Integer.valueOf(r0 + r22);
    L44:
        int r2 = r10.getHeight();
        if (r2 == 0) goto L56;
        if (r110 == null) goto L48;
        int r23 = r110.intValue();
    L55:
        int r111 = r2 + r23;
    L57:
        PaddingValues r34 = WindowInsetsKt.asPaddingValues(r24, r32);
        if (r7.getWidth() == 0) goto L60;
    L62:
        float r35 = r32.toDp-u2uoSUM(r7.getHeight());
    L63:
        if (r21 == false) goto L65;
        float r36 = r34.mo898calculateBottomPaddingD9Ej5fM();
    L66:
        r30.setPaddingHolder(PaddingKt.m956PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(r34, r32.getLayoutDirection()), r35, PaddingKt.calculateEndPadding(r34, r32.getLayoutDirection()), r36));
        final Placeable r37 = ((Measurable) CollectionsKt.first(r32.subcompose(ScaffoldLayoutContent.MainContent, r31))).measure-BRTryo0(r1);
        final int r38 = r111;
        return MeasureScope.-CC.layout$default(r32, r14, r15, null, new yk(r37, r7, r10, r14, r24, r32, r15, r38, r20, r19, r11, r110), 4, null);
    L65:
        r36 = r32.toDp-u2uoSUM(r20.getHeight());
        goto L66
    L60:
        if (r7.getHeight() != 0) goto L62;
        r35 = r34.mo901calculateTopPaddingD9Ej5fM();
        goto L63
    L48:
        Integer r39 = Integer.valueOf(r20.getHeight());
        r39.intValue();
        if ((!r21) == true) goto L52;
        r39 = null;
    L52:
        if (r39 == null) goto L54;
        r23 = r39.intValue();
        goto L55
    L54:
        r23 = r24.getBottom(r32);
        goto L55
    L56:
        r111 = 0;
        goto L57
    L38:
        if (FabPosition.m2703equalsimpl0(r28, FabPosition.Companion.m2709getEndOverlayERTFSPs()) == true) goto L41;
        r0 = r20.getHeight() + r19.getHeight();
        r22 = r32.roundToPx-0680j_4(FabSpacing);
        goto L42
    L43:
        r110 = null;
        goto L44
    L32:
        if (r20.getHeight() != 0) goto L34;
        r21 = true;
        goto L35
    L15:
        int r40 = r32.roundToPx-0680j_4(FabSpacing);
    L16:
        r18 = ((r14 - r40) - r13) - r4;
        goto L27
    L18:
        if (FabPosition.m2703equalsimpl0(r28, r17.m2708getEndERTFSPs()) == true) goto L24;
        if (FabPosition.m2703equalsimpl0(r28, r17.m2709getEndOverlayERTFSPs()) == true) goto L24;
        r18 = (((r14 - r13) + r3) - r4) / 2;
    L24:
        if (r32.getLayoutDirection() != LayoutDirection.Ltr) goto L26;
        r40 = r32.roundToPx-0680j_4(FabSpacing);
        goto L16
    L26:
        r5 = r32.roundToPx-0680j_4(FabSpacing);
        goto L14
    L28:
        r19 = null;
        goto L29
    L5:
        if (r11.getHeight() != 0) goto L7;
        r12 = true;
        goto L8
    }

    /* JADX INFO: renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    public static final void m3035ScaffoldTvnljyQ(Modifier r31, Function2<? super Composer, ? super Integer, Unit> r32, Function2<? super Composer, ? super Integer, Unit> r33, Function2<? super Composer, ? super Integer, Unit> r34, Function2<? super Composer, ? super Integer, Unit> r35, int r36, long r37, long r39, WindowInsets r41, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r42, Composer r43, final int r44, final int r45) {
        Composer r1 = r43.startRestartGroup(-1211482744);
        int r2 = r45 & 1;
        if (r2 == 0) goto L6;
        int r4 = r44 | 6;
    L13:
        int r5 = r45 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r7 = r45 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r8 = r33;
    L35:
        int r9 = r45 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r11 = r45 & 16;
        if (r11 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        Function2<? super Composer, ? super Integer, Unit> r12 = r35;
    L57:
        int r15 = r45 & 32;
        if (r15 == 0) goto L61;
        r4 = r4 | 196608;
    L68:
        if ((r44 & 1572864) != 0) goto L78;
        if ((r45 & 64) == 0) goto L72;
    L74:
        int r17 = 524288;
    L75:
        r4 = r4 | r17;
        goto L78
    L72:
        if (r1.changed(r37) == false) goto L74;
        r17 = 1048576;
    L78:
        if ((r44 & 12582912) != 0) goto L86;
        long r10 = r39;
        if ((r45 & 128) == 0) goto L82;
    L84:
        int r0 = 4194304;
    L85:
        r4 = r4 | r0;
    L88:
        if ((r44 & 100663296) != 0) goto L99;
        if ((r45 & 256) != 0) goto L95;
        if (r1.changed(r41) == false) goto L95;
        int r20 = 67108864;
    L96:
        r4 = r4 | r20;
    L95:
        r20 = 33554432;
    L99:
        if ((r45 & 512) == 0) goto L102;
        r4 = r4 | 805306368;
    L109:
        boolean r21 = false;
        if ((r4 & 306783379) == 306783378) goto L112;
        boolean r3 = true;
    L114:
        if (r1.shouldExecute(r3, r4 & 1) == false) goto L194;
        r1.startDefaults();
        if ((r44 & 1) != 0) goto L118;
    L131:
        if (r2 == 0) goto L133;
        Modifier r6 = Modifier.Companion;
    L134:
        if (r5 == 0) goto L136;
        Function2<? super Composer, ? super Integer, Unit> r13 = ComposableSingletons$ScaffoldKt.INSTANCE.m2537getLambda$39202156$material3();
    L137:
        if (r7 == 0) goto L139;
        Function2<? super Composer, ? super Integer, Unit> r14 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
    L140:
        if (r9 == 0) goto L142;
        Function2<? super Composer, ? super Integer, Unit> r16 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
    L143:
        if (r11 == 0) goto L145;
        Function2<? super Composer, ? super Integer, Unit> r18 = ComposableSingletons$ScaffoldKt.INSTANCE.m2536getLambda$1514016380$material3();
    L146:
        if (r15 == 0) goto L148;
        int r19 = FabPosition.Companion.m2708getEndERTFSPs();
    L150:
        if ((r45 & 64) == 0) goto L152;
        r4 = r4 & (-3670017);
        long r22 = MaterialTheme.INSTANCE.getColorScheme(r1, 6).m2446getBackground0d7_KjU();
    L154:
        if ((r45 & 128) == 0) goto L157;
        r10 = ColorSchemeKt.m2496contentColorForek8zF_U(r22, r1, (r4 >> 18) & 14);
        r4 = (-29360129) & r4;
    L157:
        if ((r45 & 256) == 0) goto L159;
        int r110 = r4 & (-234881025);
        final WindowInsets r23 = ScaffoldDefaults.INSTANCE.getContentWindowInsets(r1, 6);
        Function2<? super Composer, ? super Integer, Unit> r24 = r16;
    L160:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L163;
        ComposerKt.traceEventStart(-1211482744, r110, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
    L163:
        int r111 = (234881024 & r110) ^ 100663296;
        if (r111 > 67108864) goto L166;
    L169:
        long r310 = r10;
        if ((r110 & 100663296) != 67108864) goto L172;
    L171:
        boolean r112 = true;
    L173:
        Object r113 = r1.rememberedValue();
        if (r112 == false) goto L176;
    L177:
        r113 = new MutableWindowInsets(r23);
        r1.updateRememberedValue(r113);
    L178:
        final MutableWindowInsets r114 = (MutableWindowInsets) r113;
        boolean r115 = r1.changed(r114);
        if (r111 <= 67108864) goto L183;
        if (r1.changed(r23) == false) goto L183;
    L184:
        r21 = true;
    L185:
        boolean r116 = r115 | r21;
        Object r117 = r1.rememberedValue();
        if (r116 == false) goto L188;
    L189:
        r117 = new zk(r114, r23);
        r1.updateRememberedValue(r117);
    L190:
        Modifier r118 = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(r6, (Function1) r117);
        final int r38 = r19;
        final Function2<? super Composer, ? super Integer, Unit> r311 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r312 = r24;
        final Function2<? super Composer, ? super Integer, Unit> r313 = r18;
        final Function2<? super Composer, ? super Integer, Unit> r314 = r14;
        ComposableLambda r25 = ComposableLambdaKt.rememberComposableLambda(848889571, true, new ScaffoldKt$Scaffold$2(r38, r311, r42, r312, r313, r114, r314), r1, 54);
        int r119 = r110 >> 12;
        long r120 = r22;
        long r121 = r310;
        SurfaceKt.m3213SurfaceT9BRK9s(r118, null, r120, r121, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, r25, r1, ((r119 & 896) | 12582912) | (r119 & 7168), 114);
        if (ComposerKt.isTraceInProgress() == false) goto L193;
        ComposerKt.traceEventEnd();
    L193:
        long r122 = r310;
        WindowInsets r123 = r23;
        final Function2<? super Composer, ? super Integer, Unit> r26 = r24;
        Function2<? super Composer, ? super Integer, Unit> r27 = r13;
        Modifier r28 = r6;
        long r29 = r22;
        final int r30 = r19;
        long r40 = r29;
    L195:
        ScopeUpdateScope r124 = r1.endRestartGroup();
        if (r124 == null) goto L199;
        final Modifier r46 = r28;
        final Function2<? super Composer, ? super Integer, Unit> r47 = r27;
        final Function2<? super Composer, ? super Integer, Unit> r48 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r49 = r18;
        final long r50 = r40;
        final long r51 = r122;
        final WindowInsets r125 = r123;
        r124.updateScope(new al(r46, r47, r48, r26, r49, r30, r50, r51, r125, r42, r44, r45));
        return;
    L199:
        return;
    L188:
        if (r117 != Composer.Companion.getEmpty()) goto L190;
    L183:
        if ((100663296 & r110) != 67108864) goto L185;
    L176:
        if (r113 != Composer.Companion.getEmpty()) goto L178;
    L172:
        r112 = false;
        goto L173
    L166:
        if (r1.changed(r23) == false) goto L169;
        r310 = r10;
        goto L171
    L159:
        r24 = r16;
    L130:
        r110 = r4;
        r23 = r41;
        goto L160
    L152:
        r22 = r37;
        goto L154
    L148:
        r19 = r36;
        goto L150
    L145:
        r18 = r12;
        goto L146
    L142:
        r16 = r34;
        goto L143
    L139:
        r14 = r8;
        goto L140
    L136:
        r13 = r32;
        goto L137
    L133:
        r6 = r31;
        goto L134
    L118:
        if (r1.getDefaultsInvalid() == true) goto L131;
        r1.skipToGroupEnd();
        if ((r45 & 64) == 0) goto L124;
        r4 = r4 & (-3670017);
    L124:
        if ((r45 & 128) == 0) goto L127;
        r4 = r4 & (-29360129);
    L127:
        if ((r45 & 256) == 0) goto L129;
        r4 = r4 & (-234881025);
    L129:
        r6 = r31;
        r13 = r32;
        r24 = r34;
        r19 = r36;
        r22 = r37;
        r14 = r8;
        r18 = r12;
        goto L130
    L194:
        r1.skipToGroupEnd();
        r28 = r31;
        r27 = r32;
        r26 = r34;
        r30 = r36;
        r123 = r41;
        r14 = r8;
        r18 = r12;
        r122 = r10;
        r40 = r37;
        goto L195
    L112:
        r3 = false;
        goto L114
    L102:
        if ((r44 & 805306368) != 0) goto L109;
        if (r1.changedInstance(r42) == false) goto L106;
        int r210 = 536870912;
    L107:
        r4 = r4 | r210;
        goto L109
    L106:
        r210 = 268435456;
        goto L107
    L82:
        if (r1.changed(r10) == false) goto L84;
        r0 = 8388608;
        goto L85
    L86:
        r10 = r39;
        goto L88
    L61:
        if ((r44 & 196608) != 0) goto L68;
        if (r1.changed(r36) == false) goto L65;
        int r126 = 131072;
    L66:
        r4 = r4 | r126;
        goto L68
    L65:
        r126 = 65536;
        goto L66
    L50:
        if ((r44 & 24576) != 0) goto L56;
        r12 = r35;
        if (r1.changedInstance(r12) == false) goto L54;
        int r127 = 16384;
    L55:
        r4 = r4 | r127;
        goto L57
    L54:
        r127 = 8192;
        goto L55
    L39:
        if ((r44 & 3072) != 0) goto L46;
        if (r1.changedInstance(r34) == false) goto L43;
        int r128 = 2048;
    L44:
        r4 = r4 | r128;
        goto L46
    L43:
        r128 = 1024;
        goto L44
    L28:
        if ((r44 & 384) != 0) goto L34;
        r8 = r33;
        if (r1.changedInstance(r8) == false) goto L32;
        int r52 = 256;
    L33:
        r4 = r4 | r52;
        goto L35
    L32:
        r52 = 128;
        goto L33
    L17:
        if ((r44 & 48) != 0) goto L24;
        if (r1.changedInstance(r32) == false) goto L21;
        int r53 = 32;
    L22:
        r4 = r4 | r53;
        goto L24
    L21:
        r53 = 16;
        goto L22
    L6:
        if ((r44 & 6) == 0) goto L8;
        r4 = r44;
        goto L13
    L8:
        if (r1.changed(r31) == false) goto L10;
        int r54 = 4;
    L11:
        r4 = r54 | r44;
        goto L13
    L10:
        r54 = 2;
        goto L11
    }

    private static final Unit ScaffoldLayout_FMILGgc$lambda$15$lambda$14$lambda$13(Placeable r17, Placeable r18, Placeable r19, int r20, WindowInsets r21, SubcomposeMeasureScope r22, int r23, int r24, Placeable r25, FabPlacement r26, Placeable r27, Integer r28, Placeable.PlacementScope r29) {
        Placeable.PlacementScope.place$default(r29, r17, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.place$default(r29, r18, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.place$default(r29, r19, (((r20 - r19.getWidth()) + r21.getLeft(r22, r22.getLayoutDirection())) - r21.getRight(r22, r22.getLayoutDirection())) / 2, r23 - r24, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.place$default(r29, r25, 0, r23 - r25.getHeight(), MenuKt.ClosedAlphaTarget, 4, null);
        if (r26 == null) goto L6;
        int r0 = r26.getLeft();
        Intrinsics.checkNotNull(r28);
        Placeable.PlacementScope.place$default(r29, r27, r0, r23 - r28.intValue(), MenuKt.ClosedAlphaTarget, 4, null);
    L6:
        return Unit.INSTANCE;
    }
}
