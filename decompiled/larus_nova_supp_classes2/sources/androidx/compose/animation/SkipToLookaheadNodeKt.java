package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DefaultEnabled", "Lkotlin/Function0;", "", "createContentScaleModifier", "Landroidx/compose/ui/Modifier;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SkipToLookaheadNodeKt {
    private static final Function0<Boolean> DefaultEnabled = null;

    static {
        DefaultEnabled = SkipToLookaheadNodeKt$DefaultEnabled$1.INSTANCE;
    }

    public static final /* synthetic */ Function0 access$getDefaultEnabled$p() {
        return DefaultEnabled;
    }

    public static final Modifier createContentScaleModifier(Modifier r2, ScaleToBoundsImpl r3, final Function0<Boolean> r4) {
        if (Intrinsics.areEqual(r3.getContentScale(), ContentScale.Companion.getCrop()) == false) goto L5;
        Modifier r0 = GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new AnonymousClass1(r4));
    L7:
        return r2.then(r0).then(new SkipToLookaheadElement(r3, r4));
    L5:
        r0 = Modifier.Companion;
        goto L7
    }
}
