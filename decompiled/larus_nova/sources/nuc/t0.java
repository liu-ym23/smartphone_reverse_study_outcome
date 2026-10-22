package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public final class t0 {
    @InternalSerializationApi
    public static final r0 a(String r100, juc.d r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "primitiveSerializer");
        return new r0(r100, new s0(r101));
    }
}
