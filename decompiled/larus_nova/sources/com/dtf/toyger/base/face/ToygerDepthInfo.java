package com.dtf.toyger.base.face;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerDepthInfo {
    public byte[] depthInfo;

    public ToygerDepthInfo() {
        this.depthInfo = null;
    }

    public void depthBlobInfo(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        GZIPOutputStream r102 = null;
        GZIPOutputStream r103 = new GZIPOutputStream(r101);     // Catch: Throwable -> L14 IOException -> L23
        goto L24
    L34:
        r103.write(r100);     // Catch: Throwable -> L11 IOException -> L13
    L38:
        r103.close();     // Catch: Throwable -> L7 IOException -> L10
        this.depthInfo = r101.toByteArray();
        return;
    L10:
        this.depthInfo = r101.toByteArray();
        return;
    L7:
        th = move-exception;
        this.depthInfo = r101.toByteArray();
        throw th;
    L13:
        r102 = r103;
    L11:
        th = th;
        r102 = r103;
    L15:
        if (r102 != null) goto L40;
    L22:
        throw th;
    L40:
        r102.close();     // Catch: Throwable -> L18 IOException -> L21
        this.depthInfo = r101.toByteArray();
        goto L22
    L21:
        this.depthInfo = r101.toByteArray();
    L18:
        th = move-exception;
        this.depthInfo = r101.toByteArray();
        throw th;
    L14:
        th = th;
    L24:
        if (r102 == null) goto L44;
        r102.close();     // Catch: Throwable -> L27 IOException -> L30
        this.depthInfo = r101.toByteArray();
        return;
    L30:
        this.depthInfo = r101.toByteArray();
        return;
    L27:
        th = move-exception;
        this.depthInfo = r101.toByteArray();
        throw th;
    }
}
