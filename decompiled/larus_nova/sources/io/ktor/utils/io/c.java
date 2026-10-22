package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    public static final ByteBufferChannel a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        int r101 = r100.length;
        Intrinsics.checkNotNullParameter(r100, "content");
        return new ByteBufferChannel(ByteBuffer.wrap(r100, 0, r101));
    }
}
