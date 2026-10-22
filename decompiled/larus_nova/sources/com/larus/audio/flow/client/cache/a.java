package com.larus.audio.flow.client.cache;

import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes24.dex */
public interface a {
    void a(String r100, boolean r101);

    void b(String r100, byte[] r101);

    void c(String r100);

    boolean contains(String r100);

    void delete(String r100);

    Flow<byte[]> query(String r100, int r101);
}
