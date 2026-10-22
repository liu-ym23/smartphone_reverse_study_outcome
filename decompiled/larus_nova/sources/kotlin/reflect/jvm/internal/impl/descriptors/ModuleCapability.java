package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ModuleCapability<T> {
    private final String name;

    public String toString() {
        return this.name;
    }

    public ModuleCapability(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
    }
}
