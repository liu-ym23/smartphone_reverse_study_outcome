package com.bytedance.geckox.buffer.impl;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.geckox.logger.GeckoLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import ez5.d;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015J\u0019\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 J\u0019\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 J1\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0082 J1\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0082 J!\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¨\u0006\u0016"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/MemoryBuffer;", "Lny5/a;", "", "nPtr", "length", "", "nRelease", "", "path", "nCreate", "ptr", "offset", "", HTTP.CONTENT_RANGE_BYTES, "", "off", "len", "nWrite", EffectConfiguration.KEY_CURSOR, "nRead", "nFlush", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class MemoryBuffer implements ny5.a {

    public static final class a {
    }

    private final native long nCreate(String r100, long r101) throws IOException;

    private final native void nFlush(long r100, String r101, long r102) throws IOException;

    private final native void nRead(long r100, long r101, byte[] r102, int r103, int r104);

    private final native void nRelease(long r100, long r101);

    private final native void nWrite(long r100, long r101, byte[] r102, int r103, int r104);

    @Override // ny5.a
    public final File a() {
        return null;
    }

    public final void finalize() {
        throw null;     // Catch: Exception -> L4
    L4:
        e = move-exception;
        GeckoLogger.w("finalize:", e);
    }

    @Override // ny5.a
    public final void finish() {
    }

    @Override // ny5.a
    public final long length() {
        return 0;
    }

    static {
        d.a("buffer");
    }

    @Override // ny5.a
    public final void b() {
        release();
        throw null;
    }

    @Override // ny5.a
    public final void c() throws IOException {
        throw null;
    }

    @Override // ny5.a
    public final long position() throws IOException {
        throw null;
    }

    @Override // ny5.a
    public final int read() throws IOException {
        throw null;
    }

    @Override // ny5.a
    public final void release() {
        throw null;
    }

    @Override // ny5.a
    public final void position(long r100) throws IOException {
        throw null;
    }

    @Override // ny5.a
    public final int read(byte[] r100) throws IOException {
        int r101 = r100.length;
        throw null;
    }

    @Override // ny5.a
    public final synchronized long skip(long r100) throws IOException {
        monitor-enter(this);
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // ny5.a
    public final void write(byte[] r100) throws IOException {
        int r101 = r100.length;
        throw null;
    }

    @Override // ny5.a
    public final void write(int r100) throws IOException {
        throw null;
    }

    @Override // ny5.a
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        throw null;
    }

    @Override // ny5.a
    public final int write(byte[] r100, int r101, int r102) throws IOException {
        throw null;
    }
}
