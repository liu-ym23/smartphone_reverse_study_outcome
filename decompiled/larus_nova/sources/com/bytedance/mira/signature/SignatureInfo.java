package com.bytedance.mira.signature;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
class SignatureInfo {
    public final long apkSigningBlockOffset;
    public final long centralDirOffset;
    public final ByteBuffer eocd;
    public final long eocdOffset;
    public final ByteBuffer signatureBlock;

    public SignatureInfo(ByteBuffer r100, long r101, long r102, long r103, ByteBuffer r104) {
        this.signatureBlock = r100;
        this.apkSigningBlockOffset = r101;
        this.centralDirOffset = r102;
        this.eocdOffset = r103;
        this.eocd = r104;
    }
}
