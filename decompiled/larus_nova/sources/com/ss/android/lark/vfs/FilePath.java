package com.ss.android.lark.vfs;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B%\b\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB/\b\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000bB%\b\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/vfs/FilePath;", "Lcom/ss/android/lark/vfs/AbsNativePath;", "fs", "Lcom/ss/android/lark/vfs/FileSystem;", "path", "", "isNormalPath", "", "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;Ljava/lang/String;Z)V", "rootDir", "(Lcom/ss/android/lark/vfs/FileSystem;Ljava/lang/String;Ljava/lang/String;Z)V", "uri", "Landroid/net/Uri;", "(Lcom/ss/android/lark/vfs/FileSystem;Landroid/net/Uri;Z)V", "isNormalPath$unistore_release", "()Z", "lazyFile", "Lcom/ss/android/lark/vfs/VFSFile;", "getLazyFile", "()Lcom/ss/android/lark/vfs/VFSFile;", "lazyFile$delegate", "Lkotlin/Lazy;", "getRoot", "Lcom/ss/android/lark/vfs/VFSPath;", "subPath", "name", "getParent", "toFile", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FilePath extends AbsNativePath {
    private final boolean isNormalPath;
    private final Lazy lazyFile$delegate;

    public FilePath(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this(null, r100, false, 5, null);
    }

    public FilePath(FileSystem r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "fs");
        Intrinsics.checkNotNullParameter(r101, "uri");
        this(r100, r101, false, 4, null);
    }

    public FilePath(FileSystem r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fs");
        Intrinsics.checkNotNullParameter(r101, "path");
        this(r100, r101, false, 4, null);
    }

    public FilePath(FileSystem r100, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "fs");
        Intrinsics.checkNotNullParameter(r110, "rootDir");
        this(r100, r110, r111, false, 8, null);
    }

    public FilePath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this(null, r100, false, 5, null);
    }

    public FilePath(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "rootDir");
        this(null, r100, r110, false, 9, null);
    }

    @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public VFSPath getRoot() {
        return new FilePath(getSchemeFileSystem(), getRootDir(), null, this.isNormalPath);
    }

    @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public VFSFile toFile() {
        return (VFSFile) this.lazyFile$delegate.getValue();
    }

    @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public VFSPath getParent() {
        String r100 = getPath();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return null;
    L12:
        File r102 = new PolarisFileWrapper(getPath()).getParentFile();
        if (r102 != null) goto L16;
        return null;
    L16:
        return new FilePath(getSchemeFileSystem(), getRootDir(), r102.getAbsolutePath(), this.isNormalPath);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean isNormalPath$unistore_release() {
        return this.isNormalPath;
    }

    @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public VFSPath subPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new FilePath(getSchemeFileSystem(), getRootDir(), new PolarisFileWrapper(getRealPath(), r100).getAbsolutePath(), this.isNormalPath);
    }

    public FilePath(FileSystem r100, Uri r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "fs");
        Intrinsics.checkNotNullParameter(r101, "uri");
        if (Intrinsics.areEqual(r101.getScheme(), Schemes.FILE.getValue()) == false) goto L7;
        String r103 = r101.getPath();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this(r100, r103, r102);
        return;
    L7:
        r103 = r101.toString();
        goto L8
    }

    public FilePath(FileSystem r100, String r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "fs");
        Intrinsics.checkNotNullParameter(r101, "path");
        super(r100, null, r101, 2, null);
        this.lazyFile$delegate = LazyKt.lazy(new FilePath$lazyFile$2(this));
        this.isNormalPath = r110;
    }

    public FilePath(FileSystem r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "fs");
        Intrinsics.checkNotNullParameter(r101, "rootDir");
        super(r100, r101, r102);
        this.lazyFile$delegate = LazyKt.lazy(new FilePath$lazyFile$2(this));
        this.isNormalPath = r103;
    }

    public /* synthetic */ FilePath(FileSystem r100, Uri r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new NativeFileSystem();
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = true;
    L8:
        this(r100, r101, r102);
    }

    public /* synthetic */ FilePath(FileSystem r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new NativeFileSystem();
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = true;
    L8:
        this(r100, r101, r102);
    }

    public /* synthetic */ FilePath(FileSystem r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new NativeFileSystem();
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = true;
    L8:
        this(r100, r101, r102, r103);
    }
}
