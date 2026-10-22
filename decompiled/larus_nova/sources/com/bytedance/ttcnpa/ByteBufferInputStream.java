package com.bytedance.ttcnpa;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ttcnpa/ByteBufferInputStream;", "Ljava/io/InputStream;", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public final class ByteBufferInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f271031a;

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f271031a.hasRemaining() == true) goto L6;
        return -1;
    L6:
        return this.f271031a.get() & UByte.MAX_VALUE;
    }

    public ByteBufferInputStream(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "buf");
        this.f271031a = r100;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        if (this.f271031a.hasRemaining() == true) goto L6;
        return -1;
    L6:
        int r103 = RangesKt.coerceAtMost(r102, this.f271031a.remaining());
        this.f271031a.get(r100, r101, r103);
        return r103;
    }
}
