package androidx.compose.material3;

import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a`\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\u0015\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000eX\u008a\u0084\u0002"}, d2 = {"createDefaultModalWideNavigationRailProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRailDialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "onPredictiveBack", "Lkotlin/Function1;", "", "onPredictiveBackCancelled", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRail_androidKt {
    private static final Unit ModalWideNavigationRailDialog$lambda$10(Function0 r9, ModalWideNavigationRailProperties r10, Function1 r11, Function0 r12, RailPredictiveBackState r13, Function2 r14, int r15, Composer r16, int r17) {
        ModalWideNavigationRailDialog(r9, r10, r11, r12, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ModalWideNavigationRailDialogWrapper r0, Function0 r1, ModalWideNavigationRailProperties r2, LayoutDirection r3) {
        return ModalWideNavigationRailDialog$lambda$9$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(Function0 r0, ModalWideNavigationRailProperties r1, Function1 r2, Function0 r3, RailPredictiveBackState r4, Function2 r5, int r6, Composer r7, int r8) {
        return ModalWideNavigationRailDialog$lambda$10(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ DisposableEffectResult c(ModalWideNavigationRailDialogWrapper r0, DisposableEffectScope r1) {
        return ModalWideNavigationRailDialog$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ UUID d() {
        return ModalWideNavigationRailDialog$lambda$2$lambda$1();
    }

    public static final ModalWideNavigationRailProperties createDefaultModalWideNavigationRailProperties() {
        return new ModalWideNavigationRailProperties(false, 1, null);
    }

    private static final UUID ModalWideNavigationRailDialog$lambda$2$lambda$1() {
        return UUID.randomUUID();
    }

    public static void INVOKEVIRTUAL_androidx_compose_material3_WideNavigationRail_androidKt_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(ModalWideNavigationRailDialogWrapper r1) {
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

    private static final Function2<Composer, Integer, Unit> ModalWideNavigationRailDialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> r0) {
        return (Function2) r0.getValue();
    }

    public static final /* synthetic */ Function2 access$ModalWideNavigationRailDialog$lambda$0(State r0) {
        return ModalWideNavigationRailDialog$lambda$0(r0);
    }

    private static final DisposableEffectResult ModalWideNavigationRailDialog$lambda$7$lambda$6(final ModalWideNavigationRailDialogWrapper r0, DisposableEffectScope r1) {
        INVOKEVIRTUAL_androidx_compose_material3_WideNavigationRail_androidKt_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r0);
        return new WideNavigationRail_androidKt$ModalWideNavigationRailDialog$lambda$7$lambda$6$$inlined$onDispose$1(r0);
    }

    private static final Unit ModalWideNavigationRailDialog$lambda$9$lambda$8(ModalWideNavigationRailDialogWrapper r0, Function0 r1, ModalWideNavigationRailProperties r2, LayoutDirection r3) {
        r0.updateParameters(r1, r2, r3);
        return Unit.INSTANCE;
    }

    public static final void ModalWideNavigationRailDialog(final Function0<Unit> r22, final ModalWideNavigationRailProperties r23, final Function1<? super Float, Unit> r24, final Function0<Unit> r25, final RailPredictiveBackState r26, final Function2<? super Composer, ? super Integer, Unit> r27, Composer r28, final int r29) {
        Composer r15 = r28.startRestartGroup(2015914411);
        if ((r29 & 6) == 0) goto L5;
        int r1 = r29;
    L11:
        if ((r29 & 48) != 0) goto L18;
        if (r15.changed(r23) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r29 & 384) != 0) goto L25;
        if (r15.changedInstance(r24) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r29 & 3072) != 0) goto L32;
        if (r15.changedInstance(r25) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r29 & 24576) != 0) goto L39;
        if (r15.changed(r26) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r29) == 0) goto L41;
    L45:
        int r6 = r1;
        if ((74899 & r6) == 74898) goto L48;
        boolean r7 = true;
    L50:
        if (r15.shouldExecute(r7, r6 & 1) == true) goto L52;
        r15.skipToGroupEnd();
    L89:
        ScopeUpdateScope r8 = r15.endRestartGroup();
        if (r8 == null) goto L93;
        r8.updateScope(new wy(r22, r23, r24, r25, r26, r27, r29));
        return;
    L93:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(2015914411, r6, -1, "androidx.compose.material3.ModalWideNavigationRailDialog (WideNavigationRail.android.kt:124)");
    L54:
        View r9 = (View) r15.consume(AndroidCompositionLocals_androidKt.getLocalView());
        Density r10 = (Density) r15.consume(CompositionLocalsKt.getLocalDensity());
        Enum r0 = (LayoutDirection) r15.consume(CompositionLocalsKt.getLocalLayoutDirection());
        CompositionContext r14 = ComposablesKt.rememberCompositionContext(r15, 0);
        State r11 = SnapshotStateKt.rememberUpdatedState(r27, r15, (r6 >> 15) & 14);
        Object[] r12 = new Object[0];
        Object r13 = r15.rememberedValue();
        Composer.Companion r17 = Composer.Companion;
        if (r13 != r17.getEmpty()) goto L57;
        r13 = new ty();
        r15.updateRememberedValue(r13);
    L57:
        UUID r16 = (UUID) RememberSaveableKt.rememberSaveable(r12, (Function0) r13, r15, 48);
        boolean r18 = DarkThemeKt.isSystemInDarkTheme(r15, 0);
        boolean r19 = r15.changed(r9) | r15.changed(r10);
        Object r20 = r15.rememberedValue();
        if (r19 == true) goto L63;
        Enum r110 = r0;
        if (r20 == r17.getEmpty()) goto L64;
        Enum r21 = r110;
        char r111 = 4;
    L65:
        final ModalWideNavigationRailDialogWrapper r30 = (ModalWideNavigationRailDialogWrapper) r20;
        boolean r31 = r15.changedInstance(r30);
        Object r32 = r15.rememberedValue();
        if (r31 == false) goto L68;
    L69:
        r32 = new uy(r30);
        r15.updateRememberedValue(r32);
    L70:
        EffectsKt.DisposableEffect(r30, (Function1) r32, r15, 0);
        boolean r33 = r15.changedInstance(r30);
        if ((r6 & 14) != r111) goto L73;
        boolean r34 = true;
    L74:
        boolean r35 = r33 | r34;
        if ((r6 & 112) != 32) goto L77;
        boolean r36 = true;
    L78:
        boolean r37 = (r35 | r36) | r15.changed(r21.ordinal());
        Object r38 = r15.rememberedValue();
        if (r37 == false) goto L81;
    L84:
        int r39 = 0;
        final Enum r40 = r21;
        r38 = new vy(r30, r22, r23, r40);
        r15.updateRememberedValue(r38);
    L85:
        EffectsKt.SideEffect((Function0) r38, r15, r39);
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventEnd();
        goto L89
    L81:
        if (r38 == r17.getEmpty()) goto L84;
        r39 = 0;
        goto L85
    L77:
        r36 = false;
        goto L78
    L73:
        r34 = false;
        goto L74
    L68:
        if (r32 != r17.getEmpty()) goto L70;
    L64:
        r21 = r110;
        r111 = 4;
        ModalWideNavigationRailDialogWrapper r41 = new ModalWideNavigationRailDialogWrapper(r22, r23, r9, r21, r10, r16, r24, r25, r26, r18);
        r41.setContent(r14, ComposableLambdaKt.composableLambdaInstance(-406777160, true, new WideNavigationRail_androidKt$ModalWideNavigationRailDialog$dialog$1$1$1(r11)));
        r15.updateRememberedValue(r41);
        r20 = r41;
        goto L65
    L63:
        r110 = r0;
        goto L64
    L48:
        r7 = false;
        goto L50
    L41:
        if (r15.changedInstance(r27) == false) goto L43;
        int r42 = 131072;
    L44:
        r1 = r1 | r42;
        goto L45
    L43:
        r42 = 65536;
        goto L44
    L5:
        if (r15.changedInstance(r22) == false) goto L7;
        int r43 = 4;
    L8:
        r1 = r43 | r29;
        goto L11
    L7:
        r43 = 2;
        goto L8
    }
}
