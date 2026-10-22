package com.bytedance.jedi.model.datasource;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"model_release"}, k = 2, mv = {1, 7, 1})
public final class OptionalKt {
    public static final <T> Optional<T> a(T r100) {
        if (r100 != null) goto L5;
        Optional.f251065b.getClass();
        return Optional.f251066c;
    L5:
        return new Optional(r100);
    }
}
