package com.ss.android.lark.vfs;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class BackupFileSystemProvider implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444801a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/vfs/BackupFileSystemProvider$BackupFileSystem;", "Lcom/ss/android/lark/vfs/NativeFileSystem;", "<init>", "()V", "resolvePath", "Lcom/ss/android/lark/vfs/FilePath;", "uri", "Landroid/net/Uri;", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BackupFileSystem extends NativeFileSystem {
        public BackupFileSystem() {
        }

        @Override // com.ss.android.lark.vfs.NativeFileSystem, com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
        public FilePath resolvePath(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            final String r101 = r100.toString();
            return new BackupFileSystemProvider$BackupFileSystem$resolvePath$1(this, r101);
        }

        @Override // com.ss.android.lark.vfs.NativeFileSystem, com.ss.android.lark.vfs.AbstractFileSystem, com.ss.android.lark.vfs.FileSystem
        public /* bridge */ /* synthetic */ VFSPath resolvePath(Uri r100) {
            return resolvePath(r100);
        }
    }

    @Override // com.ss.android.lark.vfs.c
    public final String getName() {
        return "BackupFileSystemProvider-" + this.f444801a;
    }

    public BackupFileSystemProvider() {
        Intrinsics.checkNotNullParameter("docsource", "scheme");
        this.f444801a = "docsource";
    }

    @Override // com.ss.android.lark.vfs.c
    public final String scheme() {
        return this.f444801a;
    }

    @Override // com.ss.android.lark.vfs.c
    public final FileSystem a(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return new BackupFileSystem();
    }
}
