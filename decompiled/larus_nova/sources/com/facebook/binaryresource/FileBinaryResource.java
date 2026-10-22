package com.facebook.binaryresource;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.facebook.common.internal.Files;
import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public class FileBinaryResource implements BinaryResource {
    private final File mFile;

    public int hashCode() {
        return this.mFile.hashCode();
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream openStream() throws IOException {
        return new PolarisFileInputStreamWrapper(this.mFile);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public byte[] read() throws IOException {
        return Files.toByteArray(this.mFile);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.mFile.length();
    }

    public File getFile() {
        return this.mFile;
    }

    private FileBinaryResource(File r100) {
        this.mFile = (File) Preconditions.checkNotNull(r100);
    }

    public static FileBinaryResource createOrNull(File r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new FileBinaryResource(r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if ((r100 instanceof FileBinaryResource) == true) goto L7;
        return false;
    L7:
        return this.mFile.equals(((FileBinaryResource) r100).mFile);
    }
}
