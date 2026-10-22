package com.ss.ugc.effectplatform.extension;

import bytekn.foundation.io.file.ContentEncoding;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
public final class ByteArrayExKt {
    public static final byte[] a(String r100) {
        return r100.getBytes(Charsets.UTF_8);
    }

    public static final String b(byte[] r100, int r101, int r102, final ContentEncoding r103) {
        return new String(r100, r101, r102, new ByteArrayExKt$toString$charset$1(r103).invoke());
    }
}
