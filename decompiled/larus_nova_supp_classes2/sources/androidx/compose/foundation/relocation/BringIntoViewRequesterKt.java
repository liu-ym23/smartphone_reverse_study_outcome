package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewRequesterKt", "androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewResponderKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class BringIntoViewRequesterKt {
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public static final Modifier bringIntoViewRequester(Modifier r0, BringIntoViewRequester r1) {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.bringIntoViewRequester(r0, r1);
    }

    @Deprecated(message = "Use BringIntoViewModifierNode instead")
    public static final Modifier bringIntoViewResponder(Modifier r0, BringIntoViewResponder r1) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.bringIntoViewResponder(r0, r1);
    }
}
