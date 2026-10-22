package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"indication", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "Landroidx/compose/foundation/Indication;", "LocalIndication", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalIndication", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "RememberUpdatedInstanceDeprecationMessage", "", "IndicationInstanceDeprecationMessage", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IndicationKt {
    private static final String IndicationInstanceDeprecationMessage = "IndicationInstance has been deprecated along with the rememberUpdatedInstance that returns it. Indication implementations should instead use Modifier.Node APIs, and should be returned from IndicationNodeFactory#create. For a migration guide and background information, please visit developer.android.com";
    private static final ProvidableCompositionLocal<Indication> LocalIndication = null;
    private static final String RememberUpdatedInstanceDeprecationMessage = "rememberUpdatedInstance has been deprecated - implementers should instead implement IndicationNodeFactory#create for improved performance and efficiency. Callers should check if the Indication is an IndicationNodeFactory, and call that API instead. For a migration guide and background information, please visit developer.android.com";

    public static /* synthetic */ Indication a() {
        return LocalIndication$lambda$1();
    }

    static {
        LocalIndication = CompositionLocalKt.compositionLocalOf$default(null, new r0(), 1, null);
    }

    private static final Indication LocalIndication$lambda$1() {
        return DefaultDebugIndication.INSTANCE;
    }

    public static final ProvidableCompositionLocal<Indication> getLocalIndication() {
        return LocalIndication;
    }

    public static final Modifier indication(Modifier r2, final InteractionSource r3, final Indication r4) {
        if (r4 != null) goto L5;
        return r2;
    L5:
        if ((r4 instanceof IndicationNodeFactory) == false) goto L9;
        return r2.then(new IndicationModifierElement(r3, (IndicationNodeFactory) r4));
    L9:
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L11;
        Function1<InspectorInfo, Unit> r0 = new IndicationKt$indication$$inlined$debugInspectorInfo$1(r3, r4);
    L13:
        return ComposedModifierKt.composed(r2, r0, new AnonymousClass2(r4, r3));
    L11:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L13
    }
}
