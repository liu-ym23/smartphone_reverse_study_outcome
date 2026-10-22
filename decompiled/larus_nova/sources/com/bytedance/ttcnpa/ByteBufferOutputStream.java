package com.bytedance.ttcnpa;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ttcnpa/ByteBufferOutputStream;", "Ljava/io/OutputStream;", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public final class ByteBufferOutputStream extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f271032a;

    public ByteBufferOutputStream(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "buf");
        this.f271032a = r100;
    }

    @Override // java.io.OutputStream
    public final void write(int r100) throws IOException {
        this.f271032a.put((byte) r100);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        this.f271032a.put(r100, r101, r102);
    }
}
