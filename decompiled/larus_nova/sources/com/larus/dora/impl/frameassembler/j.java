package com.larus.dora.impl.frameassembler;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes27.dex */
public interface j {
    PolarisFileOutputStreamWrapper a(h r100) throws IOException;

    void b(h r100, OutputStream r101) throws IOException;

    void c(h r100, OutputStream r101, Throwable r102) throws IOException;

    void d(h r100, OutputStream r101, byte[] r102, int r103) throws IOException;

    void e(h r100, OutputStream r101, DoraIncompleteReason r102) throws IOException;
}
