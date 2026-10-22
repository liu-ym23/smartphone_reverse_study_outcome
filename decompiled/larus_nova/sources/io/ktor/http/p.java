package io.ktor.http;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class p extends io.ktor.util.r implements n {
    public final String toString() {
        return "Headers " + entries();
    }

    public p(Map<String, ? extends List<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        super(r100);
    }
}
