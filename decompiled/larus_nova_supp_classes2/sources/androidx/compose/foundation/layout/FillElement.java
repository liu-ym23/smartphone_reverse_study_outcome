package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\f\u0010\u000f\u001a\u00020\r*\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/FillElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/FillNode;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "inspectorName", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;FLjava/lang/String;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FillElement extends ModifierNodeElement<FillNode> {
    public static final Companion Companion = null;
    private final Direction direction;
    private final float fraction;
    private final String inspectorName;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/layout/FillElement$Companion;", "", "<init>", "()V", "width", "Landroidx/compose/foundation/layout/FillElement;", "fraction", "", "height", "size", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final FillElement height(float r4) {
            return new FillElement(Direction.Vertical, r4, "fillMaxHeight");
        }

        public final FillElement size(float r4) {
            return new FillElement(Direction.Both, r4, "fillMaxSize");
        }

        public final FillElement width(float r4) {
            return new FillElement(Direction.Horizontal, r4, "fillMaxWidth");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FillNode create() {
        return new FillNode(this.direction, this.fraction);
    }

    public int hashCode() {
        return (this.direction.hashCode() * 31) + Float.floatToIntBits(this.fraction);
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m862create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FillElement) == true) goto L8;
        return false;
    L8:
        FillElement r6 = (FillElement) r5;
        if (this.direction == r6.direction) goto L12;
        return false;
    L12:
        if (this.fraction != r6.fraction) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        return false;
    L17:
        return true;
    L14:
        r7 = false;
        goto L15
    }

    public void inspectableProperties(InspectorInfo r3) {
        r3.setName(this.inspectorName);
        r3.getProperties().set("fraction", Float.valueOf(this.fraction));
    }

    public void update(FillNode r2) {
        r2.setDirection(this.direction);
        r2.setFraction(this.fraction);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((FillNode) r1);
    }

    public FillElement(Direction r1, float r2, String r3) {
        this.direction = r1;
        this.fraction = r2;
        this.inspectorName = r3;
    }
}
