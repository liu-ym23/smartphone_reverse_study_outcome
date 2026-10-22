package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"aspectRatio", "Landroidx/compose/ui/Modifier;", "ratio", "", "matchHeightConstraintsFirst", "", "isSatisfiedBy", "Landroidx/compose/ui/unit/Constraints;", "width", "", "height", "isSatisfiedBy-NN6Ew-U", "(JII)Z", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AspectRatioKt {
    public static final Modifier aspectRatio(Modifier r2, final float r3, final boolean r4) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r1 = new AspectRatioKt$aspectRatio$$inlined$debugInspectorInfo$1(r3, r4);
    L7:
        return r2.then(new AspectRatioElement(r3, r4, r1));
    L5:
        r1 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: isSatisfiedBy-NN6Ew-U, reason: not valid java name */
    public static final boolean m827isSatisfiedByNN6EwU(long r4, int r6, int r7) {
        int r0 = Constraints.getMinWidth-impl(r4);
        if (r6 > Constraints.getMaxWidth-impl(r4)) goto L6;
        if (r0 > r6) goto L6;
        boolean r8 = true;
    L7:
        if (r8 == false) goto L15;
        int r9 = Constraints.getMinHeight-impl(r4);
        if (r7 > Constraints.getMaxHeight-impl(r4)) goto L12;
        if (r9 > r7) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        return true;
    L12:
        r5 = false;
    L15:
        return false;
    L6:
        r8 = false;
        goto L7
    }

    public static /* synthetic */ Modifier aspectRatio$default(Modifier r0, float r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return aspectRatio(r0, r1, r2);
    }
}
