package com.ss.android.lark.vfs;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lcom/ss/android/lark/vfs/VFSFile;", "Ljava/io/File;", "vfsPath", "Lcom/ss/android/lark/vfs/VFSPath;", "<init>", "(Lcom/ss/android/lark/vfs/VFSPath;)V", "getVfsPath", "()Lcom/ss/android/lark/vfs/VFSPath;", "getParent", "", "delete", "", "length", "", "listFiles", "", "()[Lcom/ss/android/lark/vfs/VFSFile;", "newInputStream", "Ljava/io/InputStream;", "newOutputStream", "Ljava/io/OutputStream;", "afterWriteCompat", "toUri", "Landroid/net/Uri;", "writeBytes", "", HTTP.CONTENT_RANGE_BYTES, "", "readText", "charset", "Ljava/nio/charset/Charset;", "readBytes", "equals", "other", "", "hashCode", "", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VFSFile extends File {
    private final VFSPath vfsPath;

    public final File afterWriteCompat() {
        VFSFiles r100 = VFSFiles.f444819b;
        VFSPath r101 = this.vfsPath;
        r100.getClass();
        return VFSFiles.a(r101).x(this.vfsPath);
    }

    @Override // java.io.File
    public boolean delete() {
        VFSFiles r100 = VFSFiles.f444819b;
        VFSPath r101 = this.vfsPath;
        r100.getClass();
        return VFSFiles.a(r101).delete(this.vfsPath);
    }

    @Override // java.io.File
    public String getParent() {
        VFSFiles r100 = VFSFiles.f444819b;
        VFSPath r101 = this.vfsPath;
        r100.getClass();
        if (VFSFiles.d(r101) == true) goto L10;
        VFSPath r102 = this.vfsPath.getParent();
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.getRealPath();
    L10:
        return super.getParent();
    }

    @Override // java.io.File
    public long length() {
        VFSFiles r100 = VFSFiles.f444819b;
        VFSPath r101 = this.vfsPath;
        r100.getClass();
        return VFSFiles.a(r101).size(this.vfsPath);
    }

    @Override // java.io.File
    public VFSFile[] listFiles() {
        VFSFiles r100 = VFSFiles.f444819b;
        VFSPath r101 = this.vfsPath;
        r100.getClass();
        return VFSFiles.a(r101).listFiles(this.vfsPath);
    }

    public final InputStream newInputStream() {
        VFSFiles r100 = VFSFiles.f444819b;
        VFSPath r101 = this.vfsPath;
        r100.getClass();
        return VFSFiles.a(r101).l(this.vfsPath);
    }

    public final OutputStream newOutputStream() {
        VFSFiles r100 = VFSFiles.f444819b;
        VFSPath r101 = this.vfsPath;
        r100.getClass();
        return VFSFiles.a(r101).s(this.vfsPath, false);
    }

    public final byte[] readBytes() {
        VFSFiles r100 = VFSFiles.f444819b;
        VFSPath r101 = this.vfsPath;
        r100.getClass();
        return VFSFiles.a(r101).w(this.vfsPath);
    }

    public final Uri toUri() {
        return this.vfsPath.toUri();
    }

    @Override // java.io.File
    public int hashCode() {
        return (super.hashCode() * 31) + this.vfsPath.hashCode();
    }

    public final VFSPath getVfsPath() {
        return this.vfsPath;
    }

    @Override // java.io.File
    public /* bridge */ /* synthetic */ File[] listFiles() {
        return listFiles();
    }

    public VFSFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "vfsPath");
        super(r100.getRealPath());
        this.vfsPath = r100;
    }

    @Override // java.io.File
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(VFSFile.class, r101) == false) goto L12;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.vfs.VFSFile");
        if (Intrinsics.areEqual(this.vfsPath, ((VFSFile) r100).vfsPath) == true) goto L18;
        return false;
    L18:
        return true;
    L12:
        if ((r100 instanceof File) == false) goto L19;
        VFSFiles r102 = VFSFiles.f444819b;
        VFSPath r103 = this.vfsPath;
        r102.getClass();
        return Intrinsics.areEqual(this, VFSFiles.a(r103).B((File) r100));
    L19:
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public final String readText(Charset r100) {
        Intrinsics.checkNotNullParameter(r100, "charset");
        VFSFiles r101 = VFSFiles.f444819b;
        VFSPath r102 = this.vfsPath;
        r101.getClass();
        return new String(VFSFiles.a(r102).w(this.vfsPath), r100);
    }

    public final void writeBytes(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        VFSFiles r101 = VFSFiles.f444819b;
        VFSPath r102 = this.vfsPath;
        r101.getClass();
        VFSFiles.a(r102).y(this.vfsPath, r100);
    }

    public static /* synthetic */ String readText$default(VFSFile r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        return r100.readText(r101);
    }
}
