package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeEnhancementInfo {
    private final Map<Integer, JavaTypeQualifiers> map;

    public final Map<Integer, JavaTypeQualifiers> getMap() {
        return this.map;
    }

    public TypeEnhancementInfo(Map<Integer, JavaTypeQualifiers> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.map = r100;
    }
}
