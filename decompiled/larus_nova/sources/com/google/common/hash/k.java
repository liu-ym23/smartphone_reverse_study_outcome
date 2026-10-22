package com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface k {
    f e(CharSequence r100, Charset r101);

    k f(byte[] r100);

    k putInt(int r100);

    k putLong(long r100);
}
