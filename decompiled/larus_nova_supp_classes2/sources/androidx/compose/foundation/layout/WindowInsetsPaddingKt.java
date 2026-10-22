package androidx.compose.foundation.layout;

import androidx.autofill.HintConstants;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a/\u0010\u0007\u001a\u00020\u0001*\u00020\u00012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0007\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0001\"\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"windowInsetsPadding", "Landroidx/compose/ui/Modifier;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "consumeWindowInsets", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "onConsumedWindowInsetsChanged", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "consumedWindowInsets", "", "recalculateWindowInsets", "ModifierLocalConsumedWindowInsets", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getModifierLocalConsumedWindowInsets", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsPaddingKt {
    private static final ProvidableModifierLocal<WindowInsets> ModifierLocalConsumedWindowInsets = null;

    private static final WindowInsets ModifierLocalConsumedWindowInsets$lambda$4() {
        return WindowInsetsKt.WindowInsets(0, 0, 0, 0);
    }

    public static /* synthetic */ WindowInsets a() {
        return ModifierLocalConsumedWindowInsets$lambda$4();
    }

    static {
        ModifierLocalConsumedWindowInsets = ModifierLocalKt.modifierLocalOf(new n2());
    }

    public static final ProvidableModifierLocal<WindowInsets> getModifierLocalConsumedWindowInsets() {
        return ModifierLocalConsumedWindowInsets;
    }

    public static final Modifier recalculateWindowInsets(Modifier r1) {
        return r1.then(RecalculateWindowInsetsModifierElement.INSTANCE);
    }

    public static final Modifier consumeWindowInsets(Modifier r2, final PaddingValues r3) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$2(r3);
    L7:
        return ComposedModifierKt.composed(r2, r0, new AnonymousClass4(r3));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier onConsumedWindowInsetsChanged(Modifier r2, final Function1<? super WindowInsets, Unit> r3) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1(r3);
    L7:
        return ComposedModifierKt.composed(r2, r0, new C01702(r3));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier windowInsetsPadding(Modifier r2, final WindowInsets r3) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1(r3);
    L7:
        return ComposedModifierKt.composed(r2, r0, new C01712(r3));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier consumeWindowInsets(Modifier r2, final WindowInsets r3) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$1(r3);
    L7:
        return ComposedModifierKt.composed(r2, r0, new AnonymousClass2(r3));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }
}
