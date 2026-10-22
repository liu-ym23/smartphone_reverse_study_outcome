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
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\b\n\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\r\u001aO\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"selectable", "Landroidx/compose/ui/Modifier;", "selected", "", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "selectable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "selectable-O2vRcR0", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectableKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* JADX INFO: renamed from: selectable-XHw0xAI, reason: not valid java name */
    public static final /* synthetic */ Modifier m1291selectableXHw0xAI(Modifier r2, final boolean r3, final boolean r4, final Role r5, final Function0 r6) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1(r3, r4, r5, r6);
    L7:
        return ComposedModifierKt.composed(r2, r0, new SelectableKt$selectable$2(r3, r4, r5, r6));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: selectable-oSLSa3U, reason: not valid java name */
    public static final Modifier m1293selectableoSLSa3U(Modifier r10, final boolean r11, final boolean r12, final Role r13, final MutableInteractionSource r14, final Function0<Unit> r15) {
        if (ComposeFoundationFlags.isNonComposedClickableEnabled == false) goto L6;
        return r10.then(new SelectableElement(r11, r14, null, true, r12, r13, r15, null));
    L6:
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L8;
        Function1<InspectorInfo, Unit> r0 = new SelectableKt$selectableoSLSa3U$$inlined$debugInspectorInfo$1(r11, r12, r13, r15);
    L10:
        return ComposedModifierKt.composed(r10, r0, new SelectableKt$selectable$4(r14, r11, r12, r13, r15));
    L8:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L10
    }

    /* JADX INFO: renamed from: selectable-O2vRcR0, reason: not valid java name */
    public static final Modifier m1289selectableO2vRcR0(Modifier r11, final boolean r12, MutableInteractionSource r13, final Indication r14, final boolean r15, final Role r16, final Function0<Unit> r17) {
        if ((r14 instanceof IndicationNodeFactory) == false) goto L6;
        SelectableElement r9 = new SelectableElement(r12, r13, (IndicationNodeFactory) r14, false, r15, r16, r17, null);
    L12:
        return r11.then(r9);
    L6:
        if (r14 != null) goto L8;
        r9 = new SelectableElement(r12, r13, null, false, r15, r16, r17, null);
        goto L12
    L8:
        if (r13 == null) goto L10;
        r9 = IndicationKt.indication(Modifier.Companion, r13, r14).then(new SelectableElement(r12, r13, null, false, r15, r16, r17, null));
        goto L12
    L10:
        r9 = ComposedModifierKt.composed$default(Modifier.Companion, null, new SelectableKt$selectableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(r14, r12, r15, r16, r17), 1, null);
        goto L12
    }

    /* JADX INFO: renamed from: selectable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1292selectableXHw0xAI$default(Modifier r0, boolean r1, boolean r2, Role r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return m1291selectableXHw0xAI(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: selectable-oSLSa3U$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1294selectableoSLSa3U$default(Modifier r6, boolean r7, boolean r8, Role r9, MutableInteractionSource r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r12 & 4) == 0) goto L9;
        Role r3 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        MutableInteractionSource r4 = null;
    L15:
        return m1293selectableoSLSa3U(r6, r7, r2, r3, r4, r11);
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

    /* JADX INFO: renamed from: selectable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1290selectableO2vRcR0$default(Modifier r7, boolean r8, MutableInteractionSource r9, Indication r10, boolean r11, Role r12, Function0 r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r14 & 16) == 0) goto L10;
        r12 = null;
    L10:
        return m1289selectableO2vRcR0(r7, r8, r9, r10, r4, r12, r13);
    L5:
        r4 = r11;
        goto L7
    }
}
