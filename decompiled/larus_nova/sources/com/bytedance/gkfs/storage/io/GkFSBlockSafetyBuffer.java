package com.bytedance.gkfs.storage.io;

import com.bytedance.gkfs.cdc.GkFSByteBuffer;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bJ)\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0082 ¨\u0006\f"}, d2 = {"Lcom/bytedance/gkfs/storage/io/GkFSBlockSafetyBuffer;", "Lcom/bytedance/gkfs/storage/io/b;", "", "src", "", "srcPos", "", "dest", "len", "", "nGetNonHeapBytes", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class GkFSBlockSafetyBuffer extends b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RandomAccessFile f245340o;

    public static final class a {
    }

    static {
    }

    private final native void nGetNonHeapBytes(long r100, int r101, byte[] r102, int r103);

    @Override // com.bytedance.gkfs.storage.io.b
    public final int a() {
        return 1;
    }

    @Override // com.bytedance.gkfs.storage.io.b
    public final void d() {
        monitor-enter(this);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        this.f245340o.close();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.gkfs.storage.io.b
    public final void e(long r100) {
    }

    @Override // java.io.Flushable
    public final void flush() {
    }

    @Override // com.bytedance.gkfs.storage.io.b
    public final String toString() {
        return "GkFSBlockNormalBuffer@" + hashCode() + "(id=" + this.f245357e.f245185a + ", cacheSize=" + b() + ", backingFile=" + this.f245358f + ')';
    }

    public final void finalize() {
        d();
    }

    public GkFSBlockSafetyBuffer(com.bytedance.gkfs.io.a r100, PolarisFileWrapper r101) {
        super(r100, r101);
        this.f245340o = new RandomAccessFile(r101, "rws");
    }

    @Override // com.bytedance.gkfs.storage.io.b
    public final void g(long r100, GkFSByteBuffer r110, int r111) {
        monitor-enter(this);
        long r101 = r110.f245141a;     // Catch: Throwable -> L16
        if (r101 == 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        byte[] r103 = new byte[r111];     // Catch: Throwable -> L16
        nGetNonHeapBytes(r101, r110.f245145e, r103, r111);     // Catch: Throwable -> L16
        this.f245340o.seek(r100);     // Catch: Throwable -> L16
        this.f245340o.write(r103, 0, r111);     // Catch: Throwable -> L16
    L13:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        this.f245340o.seek(r100);     // Catch: Throwable -> L16
        RandomAccessFile r105 = this.f245340o;     // Catch: Throwable -> L16
        byte[] r112 = r110.f245142b;     // Catch: Throwable -> L16
        if (r112 != null) goto L12;
        Intrinsics.throwNpe();     // Catch: Throwable -> L16
    L12:
        r105.write(r112, r110.f245145e, r111);     // Catch: Throwable -> L16
        goto L13
    L6:
        r102 = false;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.gkfs.storage.io.b
    public final void f(long r100, byte[] r101, int r102, int r103) {
        monitor-enter(this);
        this.f245340o.seek(r100);     // Catch: Throwable -> L6
        this.f245340o.read(r101, r102, r103);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
