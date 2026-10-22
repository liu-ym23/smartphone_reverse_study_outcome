package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
final class SubtypePathNode {
    private final SubtypePathNode previous;
    private final KotlinType type;

    public final SubtypePathNode getPrevious() {
        return this.previous;
    }

    public final KotlinType getType() {
        return this.type;
    }

    public SubtypePathNode(KotlinType r100, SubtypePathNode r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
        this.previous = r101;
    }
}
