package com.bytedance.retrofit2.mime;

import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class TypedByteArray extends AbsTypedOutput implements TypedInput {
    private byte[] bytes;
    private final String fakeFileName;
    private final String mimeType;

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        if (TextUtils.isEmpty(this.fakeFileName) == false) goto L7;
        return null;
    L7:
        return this.fakeFileName;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public byte[] getOriginBody() {
        return TTRequestCompressManager.decompressDataByType(this.bytes, this.mType, this.mOriginBodySize);
    }

    public int hashCode() {
        return (this.mimeType.hashCode() * 31) + Arrays.hashCode(this.bytes);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public InputStream in() throws IOException {
        return new ByteArrayInputStream(this.bytes);
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public boolean interceptRequestBody() {
        byte[] r100 = this.bytes;
        if (r100 != null) goto L5;
    L12:
        return false;
    L5:
        if (r100.length > 102400) goto L12;
        byte[] r101 = EncryptorUtil.b(r100, r100.length);
        if (r101 != null) goto L10;
        return false;
    L10:
        this.bytes = r101;
        this.mIsBodyEncrypted = true;
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.bytes.length;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        byte[] r100 = this.bytes;
        if (r100 != null) goto L6;
        return null;
    L6:
        this.mBodyMd5Stub = DigestUtil.md5Hex(r100);
        return this.mBodyMd5Stub;
    }

    public String toString() {
        return "TypedByteArray[length=" + length() + "]";
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return this.mimeType;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        TypedByteArray r101 = (TypedByteArray) r100;
        if (Arrays.equals(this.bytes, r101.bytes) == true) goto L14;
        return false;
    L14:
        if (this.mimeType.equals(r101.mimeType) == true) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r100) throws IOException {
        r100.write(this.bytes);
    }

    public TypedByteArray(String r100, byte[] r101, String... r102) {
        if (r102 != null) goto L5;
    L7:
        String r103 = null;
    L8:
        if (r100 == null) goto L10;
    L13:
        if (r101 == null) goto L17;
        this.mimeType = r100;
        this.bytes = r101;
        this.fakeFileName = r103;
        return;
    L17:
        throw new NullPointerException("bytes null");
    L10:
        if (TextUtils.isEmpty(r103) == false) goto L12;
        r100 = "application/unknown";
        goto L13
    L12:
        r100 = "application/octet-stream";
        goto L13
    L5:
        if (r102.length <= 0) goto L7;
        r103 = r102[0];
        goto L8
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public TTRequestCompressManager.CompressData compressRequestBody(String r100, String r101, boolean r102) {
        byte[] r103 = this.bytes;
        if (r103 != null) goto L6;
        return null;
    L6:
        TTRequestCompressManager.CompressData r104 = TTRequestCompressManager.compressBody(r103, r103.length, r100, r101, r102);
        if (r104 != null) goto L9;
    L12:
        return r104;
    L9:
        if (r104.data == null) goto L12;
        this.mOriginBodySize = this.bytes.length;
        this.bytes = r104.data;
        this.mType = r104.contentEncoding;
        goto L12
    }
}
