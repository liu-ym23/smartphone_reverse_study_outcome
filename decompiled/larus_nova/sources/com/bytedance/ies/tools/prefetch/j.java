package com.bytedance.ies.tools.prefetch;

import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public interface j {
    PrefetchProcess b(PrefetchRequest r100);

    PrefetchProcess c(PrefetchRequest r100);

    List<PrefetchProcess> getCacheByScheme(String r100);

    void prefetch(String r100);
}
