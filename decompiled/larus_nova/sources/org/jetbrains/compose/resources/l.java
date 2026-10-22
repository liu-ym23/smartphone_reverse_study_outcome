package org.jetbrains.compose.resources;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class l extends n {
    @InternalResourceApi
    public l() {
        throw null;
    }

    public l(int r100) {
        Set r101 = SetsKt.emptySet();
        Intrinsics.checkNotNullParameter("", "key");
        Intrinsics.checkNotNullParameter(r101, "items");
        super(r100, r101);
    }
}
