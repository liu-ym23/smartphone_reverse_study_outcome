package com.ss.android.lark.vfs;

import android.net.Uri;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\u0011\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020 H\u0096\u0002J\u0013\u0010&\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001b\u0010\u000e\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/ss/android/lark/vfs/AbsNativePath;", "Lcom/ss/android/lark/vfs/AbsVFSPath;", "fs", "Lcom/ss/android/lark/vfs/FileSystem;", "rootDir", "", "path", "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;Ljava/lang/String;Ljava/lang/String;)V", "getFs", "()Lcom/ss/android/lark/vfs/FileSystem;", "getRootDir", "()Ljava/lang/String;", "getPath", "internalRealPath", "getInternalRealPath", "internalRealPath$delegate", "Lkotlin/Lazy;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "uri$delegate", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "file$delegate", "isRoot", "", "getRealPath", "isParentOf", "Lcom/ss/android/lark/vfs/VFSPath;", "getName", "toUri", "compareTo", "", "other", "equals", "", "hashCode", "toString", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsNativePath extends AbsVFSPath {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Lazy f444797c;
    private final Lazy file$delegate;

    /* JADX INFO: renamed from: fs, reason: collision with root package name */
    private final FileSystem f444798fs;
    private final Lazy internalRealPath$delegate;
    private final String path;
    private final String rootDir;

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ VFSPath getParent();

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ VFSPath getRoot();

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ VFSPath subPath(String r100);

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ VFSFile toFile();

    public final String a() {
        return (String) this.internalRealPath$delegate.getValue();
    }

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public String getName() {
        return ((File) this.file$delegate.getValue()).getName();
    }

    public int hashCode() {
        return (this.rootDir.hashCode() * 31) + a().hashCode();
    }

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public Uri toUri() {
        return (Uri) this.f444797c.getValue();
    }

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public String getRealPath() {
        return a();
    }

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public boolean isRoot() {
        return Intrinsics.areEqual(a(), this.rootDir);
    }

    @Override // com.ss.android.lark.vfs.AbsVFSPath
    public String toString() {
        return getRealPath();
    }

    public final FileSystem getFs() {
        return this.f444798fs;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getRootDir() {
        return this.rootDir;
    }

    public static final /* synthetic */ String access$getInternalRealPath(AbsNativePath r100) {
        return r100.a();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return getRealPath().compareTo(r100.getRealPath());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbsNativePath) == true) goto L8;
        return false;
    L8:
        AbsNativePath r101 = (AbsNativePath) r100;
        if (Intrinsics.areEqual(this.rootDir, r101.rootDir) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(a(), r101.a()) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
    public boolean isParentOf(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if ((r100 instanceof AbsNativePath) == true) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(((AbsNativePath) r100).getRealPath(), getRealPath(), false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(VFSPath r100) {
        return compareTo2(r100);
    }

    public AbsNativePath(FileSystem r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "fs");
        Intrinsics.checkNotNullParameter(r101, "rootDir");
        super(r100);
        this.f444798fs = r100;
        this.rootDir = r101;
        this.path = r102;
        this.internalRealPath$delegate = LazyKt.lazy(new AbsNativePath$internalRealPath$2(this));
        this.f444797c = LazyKt.lazy(new AbsNativePath$uri$2(this));
        this.file$delegate = LazyKt.lazy(new AbsNativePath$file$2(this));
    }

    public /* synthetic */ AbsNativePath(FileSystem r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = "";
    L5:
        this(r100, r101, r102);
    }
}
