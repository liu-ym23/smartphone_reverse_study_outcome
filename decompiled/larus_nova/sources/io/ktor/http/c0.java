package io.ktor.http;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c0 extends io.ktor.util.r implements z {
    public final String toString() {
        return "Parameters " + entries();
    }

    public c0(Map<String, ? extends List<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        super(r100);
    }
}
