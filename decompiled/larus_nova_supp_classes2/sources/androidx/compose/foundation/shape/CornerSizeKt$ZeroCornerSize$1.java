package androidx.compose.foundation.shape;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\r\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/compose/foundation/shape/CornerSizeKt$ZeroCornerSize$1", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "", "valueOverride", "getValueOverride", "()Ljava/lang/String;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CornerSizeKt$ZeroCornerSize$1 implements CornerSize, InspectableValue {
    public CornerSizeKt$ZeroCornerSize$1() {
    }

    public final /* synthetic */ Sequence getInspectableElements() {
        return InspectableValue.-CC.$default$getInspectableElements(this);
    }

    public final /* synthetic */ String getNameFallback() {
        return InspectableValue.-CC.$default$getNameFallback(this);
    }

    /* JADX INFO: renamed from: getValueOverride, reason: collision with other method in class */
    public String m1323getValueOverride() {
        return "ZeroCornerSize";
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo1321toPxTmRCtEA(long r1, Density r3) {
        return MenuKt.ClosedAlphaTarget;
    }

    public String toString() {
        return "ZeroCornerSize";
    }

    public /* bridge */ /* synthetic */ Object getValueOverride() {
        return m1323getValueOverride();
    }
}
