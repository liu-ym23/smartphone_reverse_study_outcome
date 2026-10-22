package com.larus.video.impl.sdk.prefetch;

import com.larus.platform.api.w4;
import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class v0<T> implements Comparator {
    public v0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((w4) ((Map.Entry) r101).getValue()).f365312b), Long.valueOf(((w4) ((Map.Entry) r100).getValue()).f365312b));
    }
}
