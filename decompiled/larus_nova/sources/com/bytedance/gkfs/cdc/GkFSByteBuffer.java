package com.bytedance.gkfs.cdc;

import com.bytedance.gkfs.GkFSExecutor;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0010J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 J1\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0082 J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0082 ¨\u0006\u0011"}, d2 = {"Lcom/bytedance/gkfs/cdc/GkFSByteBuffer;", "", "", "cap", "", "nCreate", "", "src", "srcPos", "buf", "bufPos", "length", "nCopyFrom", "addr", "", "nFree", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class GkFSByteBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f245141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f245142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f245143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f245144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f245145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f245146f;

    public static final class a {
    }

    private final native int nCopyFrom(byte[] r100, int r101, long r102, int r103, int r104);

    private final native long nCreate(int r100);

    private final native void nFree(long r100);

    static {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("gkfs", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> gkfs");
        com.bytedance.librarian.a.c("gkfs");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> gkfs");
    }

    public final void c() {
        if (this.f245143c.compareAndSet(false, true) == false) goto L8;
        long r100 = this.f245141a;
        if (r100 == 0) goto L9;
        nFree(r100);
        return;
    L9:
        return;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("GkFSByteBuffer@");
        r100.append(hashCode());
        r100.append("(limit=");
        r100.append(this.f245144d);
        r100.append(", nonHeapAddress=");
        r100.append(this.f245141a);
        r100.append(", heapBuffer=ByteArray@");
        byte[] r101 = this.f245142b;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.hashCode());
    L6:
        r100.append(r102);
        r100.append(", isReleased=");
        r100.append(this.f245143c.get());
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public GkFSByteBuffer() {
        this.f245146f = 32768;
        long r100 = nCreate(32768);
        if (r100 != 0) goto L5;
        GkFSExecutor.a(b.f245149a);
    L5:
        this.f245141a = r100;
        if (r100 != 0) goto L8;
        byte[] r101 = new byte[32768];
    L9:
        this.f245142b = r101;
        this.f245143c = new AtomicBoolean(false);
        this.f245144d = 32768;
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final void d(int r100) {
        if (r100 > this.f245144d) goto L6;
        if (r100 < 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L11;
        this.f245145e = r100;
        return;
    L11:
        throw new IllegalArgumentException(("Bad position " + r100 + '/' + this.f245144d).toString());
    L6:
        r101 = false;
        goto L7
    }

    public final void b(byte[] r100, int r110, int r111) throws BufferOverflowException, IOException {
        if (this.f245143c.get() == true) goto L24;
        int r101 = this.f245144d;
        int r102 = this.f245145e;
        if (r111 > (r101 - r102)) goto L22;
        long r103 = this.f245141a;
        if (r103 == 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L12;
        byte[] r105 = this.f245142b;
        if (r105 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        System.arraycopy(r100, r110, r105, this.f245145e, r111);
        return;
    L12:
        if (nCopyFrom(r100, r110, r103, r102, r111) != (-1)) goto L15;
        return;
    L15:
        throw new IOException("copy bytes to buffer failed, nonHeapAddress=" + this.f245141a);
    L9:
        r104 = false;
        goto L10
    L22:
        throw new BufferOverflowException();
    L24:
        throw new IOException("released");
    }
}
