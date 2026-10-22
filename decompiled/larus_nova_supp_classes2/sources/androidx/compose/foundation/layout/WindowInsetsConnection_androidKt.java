package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"imeNestedScroll", "Landroidx/compose/ui/Modifier;", "rememberWindowInsetsConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "rememberWindowInsetsConnection-VRgvIgI", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Inflection", "", "PlatformFlingScrollFriction", "GravityEarth", "InchesPerMeter", "DecelerationRate", "", "DecelMinusOne", "StartTension", "EndTension", "P1", "P2", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsConnection_androidKt {
    private static final double DecelMinusOne = 0.0d;
    private static final double DecelerationRate = 0.0d;
    private static final float EndTension = 1.0f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float PlatformFlingScrollFriction = 0.0f;
    private static final float StartTension = 0.5f;

    public static /* synthetic */ DisposableEffectResult a(WindowInsetsNestedScrollConnection r0, DisposableEffectScope r1) {
        return rememberWindowInsetsConnection_VRgvIgI$lambda$4$lambda$3(r0, r1);
    }

    static {
        PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
        double r0 = Math.log(0.78d) / Math.log(0.9d);
        DecelerationRate = r0;
        DecelMinusOne = r0 - 1.0d;
    }

    public static final /* synthetic */ double access$getDecelMinusOne$p() {
        return DecelMinusOne;
    }

    public static final /* synthetic */ double access$getDecelerationRate$p() {
        return DecelerationRate;
    }

    public static final /* synthetic */ float access$getPlatformFlingScrollFriction$p() {
        return PlatformFlingScrollFriction;
    }

    public static final Modifier imeNestedScroll(Modifier r2) {
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        return r2;
    L6:
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L8;
        Function1<InspectorInfo, Unit> r0 = new WindowInsetsConnection_androidKt$imeNestedScroll$$inlined$debugInspectorInfo$1();
    L10:
        return ComposedModifierKt.composed(r2, r0, AnonymousClass2.INSTANCE);
    L8:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L10
    }

    private static final DisposableEffectResult rememberWindowInsetsConnection_VRgvIgI$lambda$4$lambda$3(final WindowInsetsNestedScrollConnection r0, DisposableEffectScope r1) {
        return new WindowInsetsConnection_androidKt$rememberWindowInsetsConnection_VRgvIgI$lambda$4$lambda$3$$inlined$onDispose$1(r0);
    }

    /* JADX INFO: renamed from: rememberWindowInsetsConnection-VRgvIgI, reason: not valid java name */
    public static final NestedScrollConnection m1043rememberWindowInsetsConnectionVRgvIgI(AndroidWindowInsets r5, int r6, Composer r7, int r8) {
        r7.startReplaceGroup(-1011341039);
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-1011341039, r8, -1, "androidx.compose.foundation.layout.rememberWindowInsetsConnection (WindowInsetsConnection.android.kt:105)");
    L6:
        if (Build.VERSION.SDK_INT >= 30) goto L12;
        DoNothingNestedScrollConnection r9 = DoNothingNestedScrollConnection.INSTANCE;
        if (ComposerKt.isTraceInProgress() == false) goto L10;
        ComposerKt.traceEventEnd();
    L10:
        r7.endReplaceGroup();
        return r9;
    L12:
        LayoutDirection r0 = (LayoutDirection) r7.consume(CompositionLocalsKt.getLocalLayoutDirection());
        SideCalculator r10 = SideCalculator.Companion.m996chooseCalculatorni1skBw(r6, r0);
        View r1 = (View) r7.consume(AndroidCompositionLocals_androidKt.getLocalView());
        Density r2 = (Density) r7.consume(CompositionLocalsKt.getLocalDensity());
        if (((r8 & 14) ^ 6) <= 4) goto L17;
        if (r7.changed(r5) == false) goto L17;
    L18:
        boolean r11 = true;
    L20:
        boolean r12 = ((r11 | r7.changed(r1)) | r7.changed(r10)) | r7.changed(r2);
        Object r3 = r7.rememberedValue();
        if (r12 == false) goto L23;
    L24:
        r3 = new WindowInsetsNestedScrollConnection(r5, r1, r10, r2);
        r7.updateRememberedValue(r3);
    L25:
        final WindowInsetsNestedScrollConnection r4 = (WindowInsetsNestedScrollConnection) r3;
        boolean r13 = r7.changedInstance(r4);
        Object r14 = r7.rememberedValue();
        if (r13 == false) goto L28;
    L29:
        r14 = new g2(r4);
        r7.updateRememberedValue(r14);
    L30:
        EffectsKt.DisposableEffect(r4, (Function1) r14, r7, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        r7.endReplaceGroup();
        return r4;
    L28:
        if (r14 != Composer.Companion.getEmpty()) goto L30;
    L23:
        if (r3 != Composer.Companion.getEmpty()) goto L25;
    L17:
        if ((r8 & 6) == 4) goto L18;
        r11 = false;
        goto L20
    }
}
