package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class InvalidModuleException extends IllegalStateException {
    public InvalidModuleException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
    }
}
