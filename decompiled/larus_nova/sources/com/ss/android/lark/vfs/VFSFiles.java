package com.ss.android.lark.vfs;

import android.net.Uri;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class VFSFiles implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VFSFiles f444819b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f444820c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f444821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f444822e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f444823f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f444824a;

    public interface a {
        File a(PolarisFileWrapper r100);

        File b(File r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean A(VFSPath r100, VFSPath r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        return this.f444824a.A(r100, r101, r102);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile B(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.f444824a.B(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean C() {
        this.f444824a.getClass();
        return true;
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile D(File r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return this.f444824a.D(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final OutputStream E(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.f444824a.E(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile F(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.F(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File G(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.G(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath H(File r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return this.f444824a.H(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean createNewFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.createNewFile(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public boolean delete(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.delete(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean exists(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.exists(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.i(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean isDirectory(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.isDirectory(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean isFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.isFile(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final InputStream j(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.f444824a.j(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final InputStream k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.k(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final InputStream l(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.l(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile[] listFiles(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.listFiles(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final OutputStream m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.m(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final boolean mkdirs(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.mkdirs(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File n(File r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.f444824a.n(r100, true);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File o(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return this.f444824a.o(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.p(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath q(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f444824a.q(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File r(VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.r(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final OutputStream s(VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.s(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final long size(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.size(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath t(File r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f444824a.t(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath u(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return this.f444824a.u(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSFile v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return this.f444824a.v(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final byte[] w(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.w(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File x(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.x(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final void y(VFSPath r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, HTTP.CONTENT_RANGE_BYTES);
        this.f444824a.y(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.f444824a.z(r100);
    }

    static {
        f444819b = new VFSFiles();
        f444820c = "VFSFiles";
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f444822e = LazyKt.lazy(r100, VFSFiles$vfsImpl$2.INSTANCE);
        f444823f = LazyKt.lazy(r100, VFSFiles$nativeImpl$2.INSTANCE);
    }

    public VFSFiles() {
        this.f444824a = new i();
    }

    public static h a(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return b(d(r100));
    }

    public static h b(boolean r100) {
        if (r100 == false) goto L7;
        FileSystemManager.f444805a.getClass();
        if (FileSystemManager.f444809e == false) goto L7;
        return (VFSFiles) f444822e.getValue();
    L7:
        return (e) f444823f.getValue();
    }

    public static /* synthetic */ h c(VFSFiles r100) {
        r100.getClass();
        return b(true);
    }

    public static boolean d(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FilePath) == true) goto L5;
    L8:
        return true;
    L5:
        if (((FilePath) r100).isNormalPath$unistore_release() == false) goto L8;
        return false;
    }
}
