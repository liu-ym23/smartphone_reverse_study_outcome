package com.ss.android.lark.vfs;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a implements h {
    public a() {
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile B(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return F(t(r100));
    }

    @Override // com.ss.android.lark.vfs.h
    public OutputStream E(File r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "file");
        return s(t(r100), false);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile F(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return new VFSFile(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean createNewFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().createNewFile(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean delete(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().delete(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean exists(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().exists(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return F(z(r100));
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean isDirectory(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().isDirectory(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean isFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().isFile(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public InputStream j(File r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "file");
        return l(t(r100));
    }

    @Override // com.ss.android.lark.vfs.h
    public InputStream k(String r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        return l(z(r100));
    }

    @Override // com.ss.android.lark.vfs.h
    public final InputStream l(VFSPath r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        return r100.getFileSystem().openInput(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile[] listFiles(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().listFiles(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final OutputStream m(String r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        return E(new PolarisFileWrapper(r100));
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean mkdirs(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().mkdirs(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File o(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return x(t(r100));
    }

    @Override // com.ss.android.lark.vfs.h
    public final File p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return o(new PolarisFileWrapper(r100));
    }

    @Override // com.ss.android.lark.vfs.h
    public final long size(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().size(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath t(File r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if ((r100 instanceof VFSFile) == false) goto L6;
        return ((VFSFile) r100).getVfsPath();
    L6:
        return z(r100.getAbsolutePath());
    }

    @Override // com.ss.android.lark.vfs.h
    public final byte[] w(VFSPath r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        InputStream r101 = l(r100);
        byte[] r102 = ByteStreamsKt.readBytes(r101);
        r101.close();
        return r102;
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile D(File r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return F(H(r100, r101));
    }

    @Override // com.ss.android.lark.vfs.h
    public final File G(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return n(new PolarisFileWrapper(r100), r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath H(File r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r100 instanceof VFSFile) == false) goto L6;
        return ((VFSFile) r100).getVfsPath().subPath(r101);
    L6:
        return t(new PolarisFileWrapper(r100, r101));
    }

    public final boolean a(VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        boolean r102 = C();
        VFSFiles.f444819b.getClass();
        if (r102 == VFSFiles.d(r100)) goto L8;
        if (r101 == false) goto L9;
        int r103 = com.ss.android.lark.storage.monitor.b.a.f441106a;
        com.ss.android.lark.storage.monitor.b.a.a(VFSFiles.f444820c, "vfs status is not match", new IllegalStateException("vfs status not match: " + r102 + " -> " + VFSFiles.d(r100)), true);
        return false;
    L9:
        return false;
    L8:
        return true;
    }

    @Override // com.ss.android.lark.vfs.h
    public File n(File r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return r(t(r100), r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final OutputStream s(VFSPath r100, boolean r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        createNewFile(r100);
        return r100.getFileSystem().openOutput(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath u(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return t(new PolarisFileWrapper(r100, r101));
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return F(u(r100, r101));
    }

    @Override // com.ss.android.lark.vfs.h
    public final void y(VFSPath r100, byte[] r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, HTTP.CONTENT_RANGE_BYTES);
        OutputStream r102 = s(r100, false);
        r102.write(r101);
        r102.close();
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean A(VFSPath r100, VFSPath r101, boolean r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        if (r102 == false) goto L5;
        VFSPath r103 = r101.subPath(r100.getName());
    L7:
        if (Intrinsics.areEqual(r100.getFileSystem(), r101.getFileSystem()) == false) goto L12;
        if (r100.getFileSystem().move(r100, r103) == false) goto L12;
        return true;
    L12:
        return b.a(r100, r103);
    L5:
        r103 = r101;
        goto L7
    }
}
