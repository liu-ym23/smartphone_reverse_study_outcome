package com.ss.android.lark.vfs.support;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.AbsNativePath;
import com.ss.android.lark.vfs.AbstractFileSystem;
import com.ss.android.lark.vfs.FileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.Schemes;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.c;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AssetsFileSystemProvider implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AssetsFileSystemProvider f444832a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/vfs/support/AssetsFileSystemProvider$AssetsFileSystem;", "Lcom/ss/android/lark/vfs/AbstractFileSystem;", "<init>", "()V", ChameleonAssertResManager.ASSET_FOLDER, "Landroid/content/res/AssetManager;", "getName", "", "resolvePath", "Lcom/ss/android/lark/vfs/support/AssetsFileSystemProvider$AssetsPath;", "uri", "Landroid/net/Uri;", "openInput", "Ljava/io/InputStream;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AssetsFileSystem extends AbstractFileSystem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient AssetManager f444833a;

        @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
        public String getName() {
            return "AssetsFileSystem";
        }

        public AssetsFileSystem() {
            FileSystemManager.f444805a.getClass();
            this.f444833a = FileSystemManager.g().getAssets();
        }

        @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
        public InputStream openInput(VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return this.f444833a.open(r100.getRealPath());
        }

        @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
        public AssetsPath resolvePath(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            String r101 = r100.getPath();
            if (r101 != null) goto L6;
            r101 = "";
        L6:
            return new AssetsPath(this, r101);
        }

        @Override // com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
        public /* bridge */ /* synthetic */ VFSPath resolvePath(Uri r100) {
            return resolvePath(r100);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0000H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/vfs/support/AssetsFileSystemProvider$AssetsPath;", "Lcom/ss/android/lark/vfs/AbsNativePath;", "fs", "Lcom/ss/android/lark/vfs/support/AssetsFileSystemProvider$AssetsFileSystem;", "assetsPath", "", "<init>", "(Lcom/ss/android/lark/vfs/support/AssetsFileSystemProvider$AssetsFileSystem;Ljava/lang/String;)V", "getRoot", "Lcom/ss/android/lark/vfs/VFSPath;", "toUri", "Landroid/net/Uri;", "toFile", "Lcom/ss/android/lark/vfs/VFSFile;", "getParent", "subPath", "name", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AssetsPath extends AbsNativePath {
        private final String assetsPath;

        @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
        public AssetsPath getParent() {
            String r100 = new PolarisFileWrapper(this.assetsPath).getParent();
            if (r100 != null) goto L5;
            return null;
        L5:
            return new AssetsPath((AssetsFileSystem) getSchemeFileSystem(), r100);
        }

        @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
        public VFSPath getRoot() {
            return new AssetsPath((AssetsFileSystem) getSchemeFileSystem(), "");
        }

        @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
        public VFSFile toFile() {
            return new VFSFile(this);
        }

        @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
        public Uri toUri() {
            return UriProtector.parse("assets://" + this.assetsPath);
        }

        @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
        public /* bridge */ /* synthetic */ VFSPath getParent() {
            return getParent();
        }

        @Override // com.ss.android.lark.vfs.AbsNativePath, com.ss.android.lark.vfs.AbsVFSPath, com.ss.android.lark.vfs.VFSPath
        public VFSPath subPath(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            return new AssetsPath((AssetsFileSystem) getSchemeFileSystem(), new PolarisFileWrapper(this.assetsPath, r100).getCanonicalPath());
        }

        public AssetsPath(AssetsFileSystem r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "fs");
            Intrinsics.checkNotNullParameter(r101, "assetsPath");
            super(r100, "", r101);
            this.assetsPath = r101;
        }
    }

    static {
        f444832a = new AssetsFileSystemProvider();
    }

    public AssetsFileSystemProvider() {
    }

    @Override // com.ss.android.lark.vfs.c
    public final String getName() {
        return "AssetsFileSystemProvider";
    }

    @Override // com.ss.android.lark.vfs.c
    public final String scheme() {
        return Schemes.ASSETS.getValue();
    }

    @Override // com.ss.android.lark.vfs.c
    public final FileSystem a(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return new AssetsFileSystem();
    }
}
