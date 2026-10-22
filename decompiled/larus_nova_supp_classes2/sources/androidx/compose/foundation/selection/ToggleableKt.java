package androidx.compose.foundation.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\b\n\u001aM\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\r\u001aU\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u0010\u001a=\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0007¢\u0006\u0002\b\u0016\u001aG\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017\u001aO\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0018¨\u0006\u0019"}, d2 = {"toggleable", "Landroidx/compose/ui/Modifier;", "value", "", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "toggleable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "toggleable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "toggleable-O2vRcR0", "triStateToggleable", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "triStateToggleable-XHw0xAI", "triStateToggleable-oSLSa3U", "triStateToggleable-O2vRcR0", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ToggleableKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* JADX INFO: renamed from: toggleable-XHw0xAI, reason: not valid java name */
    public static final /* synthetic */ Modifier m1299toggleableXHw0xAI(Modifier r2, final boolean r3, final boolean r4, final Role r5, final Function1 r6) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(r3, r4, r5, r6);
    L7:
        return ComposedModifierKt.composed(r2, r0, new ToggleableKt$toggleable$2(r3, r4, r5, r6));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* JADX INFO: renamed from: triStateToggleable-XHw0xAI, reason: not valid java name */
    public static final /* synthetic */ Modifier m1305triStateToggleableXHw0xAI(Modifier r2, final ToggleableState r3, final boolean r4, final Role r5, final Function0 r6) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new ToggleableKt$triStateToggleableXHw0xAI$$inlined$debugInspectorInfo$1(r3, r4, r5, r6);
    L7:
        return ComposedModifierKt.composed(r2, r0, new ToggleableKt$triStateToggleable$2(r3, r4, r5, r6));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: toggleable-oSLSa3U, reason: not valid java name */
    public static final Modifier m1301toggleableoSLSa3U(Modifier r10, final boolean r11, final boolean r12, final Role r13, final MutableInteractionSource r14, final Function1<? super Boolean, Unit> r15) {
        if (ComposeFoundationFlags.isNonComposedClickableEnabled == false) goto L6;
        return r10.then(new ToggleableElement(r11, r14, null, true, r12, r13, r15, null));
    L6:
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L8;
        Function1<InspectorInfo, Unit> r0 = new ToggleableKt$toggleableoSLSa3U$$inlined$debugInspectorInfo$1(r11, r12, r13, r15);
    L10:
        return ComposedModifierKt.composed(r10, r0, new ToggleableKt$toggleable$4(r14, r11, r12, r13, r15));
    L8:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L10
    }

    /* JADX INFO: renamed from: triStateToggleable-oSLSa3U, reason: not valid java name */
    public static final Modifier m1307triStateToggleableoSLSa3U(Modifier r10, final ToggleableState r11, final boolean r12, final Role r13, final MutableInteractionSource r14, final Function0<Unit> r15) {
        if (ComposeFoundationFlags.isNonComposedClickableEnabled == false) goto L6;
        return r10.then(new TriStateToggleableElement(r11, r14, null, true, r12, r13, r15, null));
    L6:
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L8;
        Function1<InspectorInfo, Unit> r0 = new ToggleableKt$triStateToggleableoSLSa3U$$inlined$debugInspectorInfo$1(r11, r12, r13, r15);
    L10:
        return ComposedModifierKt.composed(r10, r0, new ToggleableKt$triStateToggleable$4(r14, r11, r12, r13, r15));
    L8:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L10
    }

    /* JADX INFO: renamed from: toggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m1297toggleableO2vRcR0(Modifier r11, final boolean r12, MutableInteractionSource r13, final Indication r14, final boolean r15, final Role r16, final Function1<? super Boolean, Unit> r17) {
        if ((r14 instanceof IndicationNodeFactory) == false) goto L6;
        ToggleableElement r9 = new ToggleableElement(r12, r13, (IndicationNodeFactory) r14, false, r15, r16, r17, null);
    L12:
        return r11.then(r9);
    L6:
        if (r14 != null) goto L8;
        r9 = new ToggleableElement(r12, r13, null, false, r15, r16, r17, null);
        goto L12
    L8:
        if (r13 == null) goto L10;
        r9 = IndicationKt.indication(Modifier.Companion, r13, r14).then(new ToggleableElement(r12, r13, null, false, r15, r16, r17, null));
        goto L12
    L10:
        r9 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ToggleableKt$toggleableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(r14, r12, r15, r16, r17), 1, null);
        goto L12
    }

    /* JADX INFO: renamed from: toggleable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1300toggleableXHw0xAI$default(Modifier r0, boolean r1, boolean r2, Role r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return m1299toggleableXHw0xAI(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: triStateToggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m1303triStateToggleableO2vRcR0(Modifier r11, final ToggleableState r12, MutableInteractionSource r13, final Indication r14, final boolean r15, final Role r16, final Function0<Unit> r17) {
        if ((r14 instanceof IndicationNodeFactory) == false) goto L6;
        TriStateToggleableElement r9 = new TriStateToggleableElement(r12, r13, (IndicationNodeFactory) r14, false, r15, r16, r17, null);
    L12:
        return r11.then(r9);
    L6:
        if (r14 != null) goto L8;
        r9 = new TriStateToggleableElement(r12, r13, null, false, r15, r16, r17, null);
        goto L12
    L8:
        if (r13 == null) goto L10;
        r9 = IndicationKt.indication(Modifier.Companion, r13, r14).then(new TriStateToggleableElement(r12, r13, null, false, r15, r16, r17, null));
        goto L12
    L10:
        r9 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ToggleableKt$triStateToggleableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(r14, r12, r15, r16, r17), 1, null);
        goto L12
    }

    /* JADX INFO: renamed from: triStateToggleable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1306triStateToggleableXHw0xAI$default(Modifier r0, ToggleableState r1, boolean r2, Role r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return m1305triStateToggleableXHw0xAI(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: toggleable-oSLSa3U$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1302toggleableoSLSa3U$default(Modifier r6, boolean r7, boolean r8, Role r9, MutableInteractionSource r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r12 & 4) == 0) goto L9;
        Role r3 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        MutableInteractionSource r4 = null;
    L15:
        return m1301toggleableoSLSa3U(r6, r7, r2, r3, r4, r11);
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    /* JADX INFO: renamed from: triStateToggleable-oSLSa3U$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1308triStateToggleableoSLSa3U$default(Modifier r6, ToggleableState r7, boolean r8, Role r9, MutableInteractionSource r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r12 & 4) == 0) goto L9;
        Role r3 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        MutableInteractionSource r4 = null;
    L15:
        return m1307triStateToggleableoSLSa3U(r6, r7, r2, r3, r4, r11);
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    /* JADX INFO: renamed from: toggleable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1298toggleableO2vRcR0$default(Modifier r7, boolean r8, MutableInteractionSource r9, Indication r10, boolean r11, Role r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r14 & 16) == 0) goto L10;
        r12 = null;
    L10:
        return m1297toggleableO2vRcR0(r7, r8, r9, r10, r4, r12, r13);
    L5:
        r4 = r11;
        goto L7
    }

    /* JADX INFO: renamed from: triStateToggleable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1304triStateToggleableO2vRcR0$default(Modifier r7, ToggleableState r8, MutableInteractionSource r9, Indication r10, boolean r11, Role r12, Function0 r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r14 & 16) == 0) goto L10;
        r12 = null;
    L10:
        return m1303triStateToggleableO2vRcR0(r7, r8, r9, r10, r4, r12, r13);
    L5:
        r4 = r11;
        goto L7
    }
}
