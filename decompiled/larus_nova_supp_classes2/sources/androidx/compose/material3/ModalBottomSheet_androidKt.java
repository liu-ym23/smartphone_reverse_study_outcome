package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¶\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001aT\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0004\b\"\u0010#\u001a\f\u0010$\u001a\u00020%*\u00020&H\u0000\u001a\u0013\u0010'\u001a\u00020%*\u00020\rH\u0000¢\u0006\u0004\b(\u0010)¨\u0006*²\u0006\u0015\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetDialog", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "ModalBottomSheetDialog-sW7UJKQ", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/material3/ModalBottomSheetProperties;Landroidx/compose/animation/core/Animatable;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "", "Landroid/view/View;", "isDark", "isDark-8_81llA", "(J)Z", "material3", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheet_androidKt {
    private static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$11(Function0 r9, long r10, ModalBottomSheetProperties r12, Animatable r13, Function2 r14, int r15, Composer r16, int r17) {
        m2875ModalBottomSheetDialogsW7UJKQ(r9, r10, r12, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ModalBottomSheet_dYc4hso$lambda$0(Function0 r20, Modifier r21, SheetState r22, float r23, Shape r24, long r25, long r27, float r29, long r30, Function2 r32, WindowInsets r33, ModalBottomSheetProperties r34, Function3 r35, int r36, int r37, int r38, Composer r39, int r40) {
        m2874ModalBottomSheetdYc4hso(r20, r21, r22, r23, r24, r25, r27, r29, r30, r32, r33, r34, r35, r39, RecomposeScopeImplKt.updateChangedFlags(r36 | 1), RecomposeScopeImplKt.updateChangedFlags(r37), r38);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ DisposableEffectResult a(ModalBottomSheetDialogWrapper r0, DisposableEffectScope r1) {
        return ModalBottomSheetDialog_sW7UJKQ$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit b(Function0 r0, long r1, ModalBottomSheetProperties r3, Animatable r4, Function2 r5, int r6, Composer r7, int r8) {
        return ModalBottomSheetDialog_sW7UJKQ$lambda$11(r0, r1, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit c(Function0 r1, Modifier r2, SheetState r3, float r4, Shape r5, long r6, long r8, float r10, long r11, Function2 r13, WindowInsets r14, ModalBottomSheetProperties r15, Function3 r16, int r17, int r18, int r19, Composer r20, int r21) {
        return ModalBottomSheet_dYc4hso$lambda$0(r1, r2, r3, r4, r5, r6, r8, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ Unit d(ModalBottomSheetDialogWrapper r0, Function0 r1, ModalBottomSheetProperties r2, long r3, LayoutDirection r5) {
        return ModalBottomSheetDialog_sW7UJKQ$lambda$10$lambda$9(r0, r1, r2, r3, r5);
    }

    public static /* synthetic */ UUID e() {
        return ModalBottomSheetDialog_sW7UJKQ$lambda$3$lambda$2();
    }

    private static final UUID ModalBottomSheetDialog_sW7UJKQ$lambda$3$lambda$2() {
        return UUID.randomUUID();
    }

    public static void INVOKEVIRTUAL_androidx_compose_material3_ModalBottomSheet_androidKt_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(ModalBottomSheetDialogWrapper r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    private static final Function2<Composer, Integer, Unit> ModalBottomSheetDialog_sW7UJKQ$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> r0) {
        return (Function2) r0.getValue();
    }

    public static final /* synthetic */ Function2 access$ModalBottomSheetDialog_sW7UJKQ$lambda$1(State r0) {
        return ModalBottomSheetDialog_sW7UJKQ$lambda$1(r0);
    }

    /* JADX INFO: renamed from: isDark-8_81llA, reason: not valid java name */
    public static final boolean m2876isDark8_81llA(long r3) {
        if (Color.equals-impl0(r3, Color.Companion.getTransparent-0d7_KjU()) == false) goto L5;
    L7:
        return false;
    L5:
        if (ColorKt.luminance-8_81llA(r3) > 0.5d) goto L7;
        return true;
    }

    public static final boolean isFlagSecureEnabled(View r1) {
        ViewGroup.LayoutParams r2 = r1.getRootView().getLayoutParams();
        if ((r2 instanceof WindowManager.LayoutParams) == false) goto L5;
        WindowManager.LayoutParams r3 = (WindowManager.LayoutParams) r2;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if ((r3.flags & 8192) == 0) goto L13;
        return true;
    L13:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    private static final DisposableEffectResult ModalBottomSheetDialog_sW7UJKQ$lambda$8$lambda$7(final ModalBottomSheetDialogWrapper r0, DisposableEffectScope r1) {
        INVOKEVIRTUAL_androidx_compose_material3_ModalBottomSheet_androidKt_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r0);
        return new ModalBottomSheet_androidKt$ModalBottomSheetDialog_sW7UJKQ$lambda$8$lambda$7$$inlined$onDispose$1(r0);
    }

    private static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$10$lambda$9(ModalBottomSheetDialogWrapper r0, Function0 r1, ModalBottomSheetProperties r2, long r3, LayoutDirection r5) {
        r0.m2868updateParameters9LQNqLg(r1, r2, r3, r5);
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v27 ??, still in use, count: 1, list:
          (r1v27 ?? I:java.lang.Object) from 0x01ae: INVOKE (r15v0 ?? I:androidx.compose.runtime.Composer), (r1v27 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:117440942)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* JADX INFO: renamed from: ModalBottomSheetDialog-sW7UJKQ, reason: not valid java name */
    public static final void m2875ModalBottomSheetDialogsW7UJKQ(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v27 ??, still in use, count: 1, list:
          (r1v27 ?? I:java.lang.Object) from 0x01ae: INVOKE (r15v0 ?? I:androidx.compose.runtime.Composer), (r1v27 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:117440942)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r23v0 ??
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

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use constructor with contentWindowInsets parameter.", replaceWith = @ReplaceWith(expression = "ModalBottomSheet(onDismissRequest,modifier,sheetState,sheetMaxWidth,shape,containerColor,contentColor,tonalElevation,scrimColor,dragHandle,{ windowInsets },properties,content,)", imports = {}))
    /* JADX INFO: renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    public static final /* synthetic */ void m2874ModalBottomSheetdYc4hso(final Function0 r44, Modifier r45, SheetState r46, float r47, Shape r48, long r49, long r51, float r53, long r54, Function2 r56, WindowInsets r57, ModalBottomSheetProperties r58, final Function3 r59, Composer r60, final int r61, final int r62, final int r63) {
        Composer r1 = r60.startRestartGroup(1342054200);
        if ((r63 & 1) == 0) goto L6;
        int r5 = r61 | 6;
    L13:
        int r6 = r63 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L25:
        if ((r61 & 384) == 0) goto L27;
        SheetState r10 = r46;
    L35:
        int r16 = r63 & 8;
        if (r16 == 0) goto L39;
        r5 = r5 | 3072;
    L47:
        if ((r61 & 24576) != 0) goto L58;
        if ((r63 & 16) != 0) goto L54;
        if (r1.changed(r48) == false) goto L54;
        int r18 = 16384;
    L55:
        r5 = r5 | r18;
    L54:
        r18 = 8192;
    L58:
        if ((r61 & 196608) != 0) goto L68;
        if ((r63 & 32) == 0) goto L62;
    L64:
        int r20 = 65536;
    L65:
        r5 = r5 | r20;
        goto L68
    L62:
        if (r1.changed(r49) == false) goto L64;
        r20 = 131072;
    L68:
        if ((r61 & 1572864) != 0) goto L76;
        long r11 = r51;
        if ((r63 & 64) == 0) goto L72;
    L74:
        int r22 = 524288;
    L75:
        r5 = r5 | r22;
    L77:
        int r0 = r63 & 128;
        if (r0 == 0) goto L81;
        r5 = r5 | 12582912;
    L88:
        if ((r61 & 100663296) != 0) goto L98;
        if ((r63 & 256) != 0) goto L95;
        if (r1.changed(r54) == false) goto L95;
        int r23 = 67108864;
    L96:
        r5 = r5 | r23;
    L95:
        r23 = 33554432;
    L98:
        int r2 = r63 & 512;
        if (r2 == 0) goto L102;
        r5 = r5 | 805306368;
    L110:
        if ((r62 & 6) == 0) goto L112;
        int r17 = r62;
    L120:
        int r3 = r63 & 2048;
        if (r3 == 0) goto L124;
        r17 = r17 | 48;
    L130:
        int r4 = r17;
        if ((r63 & 4096) == 0) goto L134;
        r4 = r4 | 384;
    L141:
        if ((306783379 & r5) == 306783378) goto L143;
    L146:
        boolean r7 = true;
    L148:
        if (r1.shouldExecute(r7, r5 & 1) == false) goto L219;
        r1.startDefaults();
        if ((r61 & 1) != 0) goto L152;
    L173:
        if (r6 == 0) goto L175;
        Modifier r8 = Modifier.Companion;
    L177:
        if ((r63 & 4) == 0) goto L179;
        SheetState r9 = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, r1, 0, 3);
        r5 = r5 & (-897);
    L180:
        if (r16 == 0) goto L182;
        float r12 = BottomSheetDefaults.INSTANCE.m2335getSheetMaxWidthD9Ej5fM();
    L183:
        Modifier r410 = r8;
        if ((r63 & 16) == 0) goto L186;
        Shape r13 = BottomSheetDefaults.INSTANCE.getExpandedShape(r1, 6);
        r5 = r5 & (-57345);
    L188:
        if ((r63 & 32) == 0) goto L190;
        r5 = r5 & (-458753);
        long r14 = BottomSheetDefaults.INSTANCE.getContainerColor(r1, 6);
    L192:
        if ((r63 & 64) == 0) goto L194;
        r11 = ColorSchemeKt.m2496contentColorForek8zF_U(r14, r1, (r5 >> 15) & 14);
        r5 = r5 & (-3670017);
    L194:
        if (r0 == 0) goto L196;
        float r15 = Dp.constructor-impl(0);
    L198:
        if ((r63 & 256) == 0) goto L200;
        long r19 = BottomSheetDefaults.INSTANCE.getScrimColor(r1, 6);
        r5 = (-234881025) & r5;
    L201:
        if (r2 == 0) goto L203;
        Function2 r21 = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m2534getLambda$1294623166$material3();
    L205:
        if ((r63 & 1024) == 0) goto L207;
        WindowInsets r24 = BottomSheetDefaults.INSTANCE.getWindowInsets(r1, 6);
        r4 = r4 & (-15);
    L208:
        if (r3 == 0) goto L210;
        Function2 r25 = r21;
        final WindowInsets r110 = r24;
        ModalBottomSheetProperties r37 = ModalBottomSheetDefaults.INSTANCE.getProperties();
        int r111 = r4;
        int r112 = r5;
        long r26 = r19;
        Modifier r27 = r410;
        float r28 = r12;
        float r29 = r15;
    L211:
        r1.endDefaults();
        Composer r64 = r1;
        if (ComposerKt.isTraceInProgress() == false) goto L215;
        ComposerKt.traceEventStart(1342054200, r112, r111, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:343)");
    L215:
        int r30 = r112 << 3;
        int r34 = ((((((((r112 & 14) | (r112 & 112)) | (r112 & 896)) | (r112 & 7168)) | (r30 & 458752)) | (r30 & 3670016)) | (r30 & 29360128)) | (r30 & 234881024)) | (r30 & 1879048192);
        int r31 = r111 << 3;
        ModalBottomSheetKt.m2869ModalBottomSheetYbuCTN8(r44, r27, r9, r28, false, r13, r14, r11, r29, r26, r25, new ModalBottomSheet_androidKt$ModalBottomSheet$1(r110), r37, r59, r64, r34, (((r112 >> 27) & 14) | (r31 & 896)) | (r31 & 7168), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L218;
        ComposerKt.traceEventEnd();
    L218:
        final WindowInsets r113 = r110;
        final ModalBottomSheetProperties r114 = r37;
        final Function2 r115 = r25;
        float r39 = r28;
        final Modifier r32 = r27;
        long r40 = r26;
        final float r33 = r39;
        final Shape r35 = r13;
        final float r116 = r29;
        final SheetState r36 = r9;
        final long r38 = r14;
        final long r41 = r11;
        final long r117 = r40;
    L220:
        ScopeUpdateScope r42 = r64.endRestartGroup();
        if (r42 == null) goto L224;
        r42.updateScope(new ef(r44, r32, r36, r33, r35, r38, r41, r116, r117, r115, r113, r114, r59, r61, r62, r63));
        return;
    L224:
        return;
    L210:
        r29 = r15;
        r37 = r58;
        r25 = r21;
        r110 = r24;
        r111 = r4;
        r112 = r5;
        r26 = r19;
        r27 = r410;
        r28 = r12;
        goto L211
    L207:
        r24 = r57;
        goto L208
    L203:
        r21 = r56;
        goto L205
    L200:
        r19 = r54;
        goto L201
    L196:
        r15 = r53;
        goto L198
    L190:
        r14 = r49;
        goto L192
    L186:
        r13 = r48;
        goto L188
    L182:
        r12 = r47;
        goto L183
    L179:
        r9 = r10;
        goto L180
    L175:
        r8 = r45;
        goto L177
    L152:
        if (r1.getDefaultsInvalid() == true) goto L173;
        r1.skipToGroupEnd();
        if ((r63 & 4) == 0) goto L158;
        r5 = r5 & (-897);
    L158:
        if ((r63 & 16) == 0) goto L161;
        r5 = r5 & (-57345);
    L161:
        if ((r63 & 32) == 0) goto L164;
        r5 = r5 & (-458753);
    L164:
        if ((r63 & 64) == 0) goto L167;
        r5 = r5 & (-3670017);
    L167:
        if ((r63 & 256) == 0) goto L170;
        r5 = r5 & (-234881025);
    L170:
        if ((r63 & 1024) == 0) goto L172;
        r4 = r4 & (-15);
    L172:
        r27 = r45;
        r28 = r47;
        r13 = r48;
        r29 = r53;
        r25 = r56;
        r110 = r57;
        r37 = r58;
        r111 = r4;
        r112 = r5;
        r9 = r10;
        r14 = r49;
        r26 = r54;
        goto L211
    L219:
        r64 = r1;
        r64.skipToGroupEnd();
        r32 = r45;
        r33 = r47;
        r35 = r48;
        r38 = r49;
        r115 = r56;
        r113 = r57;
        r114 = r58;
        r36 = r10;
        r41 = r11;
        r116 = r53;
        r117 = r54;
        goto L220
    L143:
        if ((r4 & 147) != 146) goto L146;
        r7 = false;
        goto L148
    L134:
        if ((r62 & 384) != 0) goto L141;
        if (r1.changedInstance(r59) == false) goto L138;
        int r210 = 256;
    L139:
        r4 = r4 | r210;
        goto L141
    L138:
        r210 = 128;
        goto L139
    L124:
        if ((r62 & 48) != 0) goto L130;
        if (r1.changed(r58) == false) goto L128;
        int r118 = 32;
    L129:
        r17 = r17 | r118;
        goto L130
    L128:
        r118 = 16;
        goto L129
    L112:
        if ((r63 & 1024) != 0) goto L117;
        if (r1.changed(r57) == false) goto L117;
        int r119 = 4;
    L118:
        r17 = r62 | r119;
    L117:
        r119 = 2;
        goto L118
    L102:
        if ((805306368 & r61) != 0) goto L110;
        if (r1.changedInstance(r56) == false) goto L106;
        int r211 = 536870912;
    L107:
        r5 = r5 | r211;
        goto L110
    L106:
        r211 = 268435456;
        goto L107
    L81:
        if ((r61 & 12582912) != 0) goto L88;
        if (r1.changed(r53) == false) goto L85;
        int r212 = 8388608;
    L86:
        r5 = r5 | r212;
        goto L88
    L85:
        r212 = 4194304;
        goto L86
    L72:
        if (r1.changed(r11) == false) goto L74;
        r22 = 1048576;
        goto L75
    L76:
        r11 = r51;
        goto L77
    L39:
        if ((r61 & 3072) != 0) goto L47;
        if (r1.changed(r47) == false) goto L43;
        int r120 = 2048;
    L44:
        r5 = r5 | r120;
        goto L47
    L43:
        r120 = 1024;
        goto L44
    L27:
        if ((r63 & 4) != 0) goto L31;
        r10 = r46;
        if (r1.changed(r10) == false) goto L32;
        int r121 = 256;
    L33:
        r5 = r5 | r121;
    L32:
        r121 = 128;
        goto L33
    L31:
        r10 = r46;
        goto L32
    L17:
        if ((r61 & 48) != 0) goto L25;
        if (r1.changed(r45) == false) goto L21;
        int r122 = 32;
    L22:
        r5 = r5 | r122;
        goto L25
    L21:
        r122 = 16;
        goto L22
    L6:
        if ((r61 & 6) == 0) goto L8;
        r5 = r61;
        goto L13
    L8:
        if (r1.changedInstance(r44) == false) goto L10;
        int r43 = 4;
    L11:
        r5 = r43 | r61;
        goto L13
    L10:
        r43 = 2;
        goto L11
    }
}
