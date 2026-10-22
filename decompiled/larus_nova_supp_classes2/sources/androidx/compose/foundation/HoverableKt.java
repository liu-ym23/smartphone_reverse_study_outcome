package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"hoverable", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HoverableKt {
    public static final Modifier hoverable(Modifier r0, MutableInteractionSource r1, boolean r2) {
        if (r2 == false) goto L4;
        HoverableElement r3 = new HoverableElement(r1);
    L6:
        return r0.then(r3);
    L4:
        r3 = Modifier.Companion;
        goto L6
    }

    public static /* synthetic */ Modifier hoverable$default(Modifier r0, MutableInteractionSource r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return hoverable(r0, r1, r2);
    }
}
