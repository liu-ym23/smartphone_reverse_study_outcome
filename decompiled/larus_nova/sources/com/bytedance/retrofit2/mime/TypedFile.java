package com.bytedance.retrofit2.mime;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class TypedFile implements TypedInput, TypedOutput {
    private static final int BUFFER_SIZE = 4096;
    private final File file;
    private final String mimeType;

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return this.file.getName();
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public InputStream in() throws IOException {
        return new PolarisFileInputStreamWrapper(this.file);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public long length() {
        return this.file.length();
    }

    public String toString() {
        return this.file.getAbsolutePath() + " (" + mimeType() + ")";
    }

    public File file() {
        return this.file;
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public String mimeType() {
        return this.mimeType;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TypedFile) == true) goto L8;
        return false;
    L8:
        return this.file.equals(((TypedFile) r100).file);
    }

    public void moveTo(TypedFile r100) throws IOException {
        if (mimeType().equals(r100.mimeType()) == false) goto L10;
        if (this.file.renameTo(r100.file()) == false) goto L8;
        return;
    L8:
        throw new IOException("Rename failed!");
    L10:
        throw new IOException("Type mismatch.");
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r100) throws IOException {
        byte[] r101 = new byte[4096];
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(this.file);
    L12:
        int r103 = r102.read(r101);     // Catch: Throwable -> L9
        if (r103 == (-1)) goto L7;
        r100.write(r101, 0, r103);     // Catch: Throwable -> L9
        goto L12
    L7:
        r102.close();
        return;
    L9:
        th = move-exception;
        r102.close();
        throw th;
    }

    public TypedFile(String r100, File r101) {
        if (r100 != null) goto L5;
        r100 = "application/octet-stream";
    L5:
        if (r101 == null) goto L9;
        this.mimeType = r100;
        this.file = r101;
        return;
    L9:
        throw new NullPointerException("file");
    }
}
