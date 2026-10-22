package com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class c implements f {
    public c() {
    }

    @Override // com.google.common.hash.f
    public abstract f b(byte[] r100, int r101, int r102);

    public abstract f h(char r100);

    @Override // com.google.common.hash.k
    public /* bridge */ /* synthetic */ k f(byte[] r100) {
        return g(r100);
    }

    public f g(byte[] r100) {
        return b(r100, 0, r100.length);
    }

    @Override // com.google.common.hash.f, com.google.common.hash.k
    public /* bridge */ /* synthetic */ k putInt(int r100) {
        return putInt(r100);
    }

    @Override // com.google.common.hash.f, com.google.common.hash.k
    public /* bridge */ /* synthetic */ k putLong(long r100) {
        return putLong(r100);
    }

    @Override // com.google.common.hash.f
    public f d(CharSequence r100, Charset r101) {
        return g(r100.toString().getBytes(r101));
    }

    @Override // com.google.common.hash.k
    public /* bridge */ /* synthetic */ f e(CharSequence r100, Charset r101) {
        return d(r100, r101);
    }
}
