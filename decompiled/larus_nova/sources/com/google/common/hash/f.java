package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface f extends k {
    HashCode a();

    f b(byte[] r100, int r101, int r102);

    f c(ByteBuffer r100);

    f d(CharSequence r100, Charset r101);

    @Override // com.google.common.hash.k
    f putInt(int r100);

    @Override // com.google.common.hash.k
    f putLong(long r100);
}
