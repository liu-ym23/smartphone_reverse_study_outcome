package com.bytedance.geckox.buffer.impl;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.EventSubType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import ez5.d;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015J\u0019\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 J\u0019\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 J1\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0082 J1\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0082 J\u0019\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¨\u0006\u0016"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/MMapBuffer;", "Lny5/a;", "", "nPtr", "length", "", "nRelease", "", "path", "nCreate", "ptr", "offset", "", HTTP.CONTENT_RANGE_BYTES, "off", "len", "", "nWrite", EffectConfiguration.KEY_CURSOR, "nRead", "nFlush", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class MMapBuffer implements ny5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f245077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f245078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f245079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f245080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f245081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f245082f;

    public static final class a {
    }

    private final native long nCreate(String r100, long r101) throws IOException;

    private final native int nFlush(long r100, long r101) throws IOException;

    private final native void nRead(long r100, long r101, byte[] r102, int r103, int r104);

    private final native int nRelease(long r100, long r101);

    private final native void nWrite(long r100, long r101, byte[] r102, int r103, int r104);

    @Override // ny5.a
    public final int read() throws IOException {
        byte[] r100 = new byte[1];
        if (read(r100, 0, 1) > 0) goto L6;
        return -1;
    L6:
        return r100[0];
    }

    static {
        d.a("buffer");
    }

    @Override // ny5.a
    public final void c() throws IOException {
        if (this.f245079c.get() == true) goto L7;
        nFlush(this.f245077a, this.f245081e);
        return;
    L7:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final void finish() {
        this.f245080d.set(true);
    }

    @Override // ny5.a
    public final long position() throws IOException {
        if (this.f245079c.get() == true) goto L7;
        return this.f245078b;
    L7:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final void release() {
        if (this.f245079c.getAndSet(true) == false) goto L5;
        return;
    L5:
        nRelease(this.f245077a, this.f245081e);
        this.f245077a = 0;
    }

    @Override // ny5.a
    public final void b() {
        release();
        a().delete();
    }

    public final void finalize() {
        release();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        GeckoLogger.w("finalize:", e);
    }

    @Override // ny5.a
    public final File a() {
        return this.f245082f;
    }

    @Override // ny5.a
    public final long length() {
        return this.f245081e;
    }

    @Override // ny5.a
    public final void position(long r100) throws IOException {
        if (this.f245079c.get() == true) goto L13;
        long r101 = 0;
        if (r100 >= 0) goto L7;
    L6:
        r100 = r101;
    L10:
        this.f245078b = r100;
        return;
    L7:
        r101 = this.f245081e;
        if (r100 <= r101) goto L10;
    L13:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // ny5.a
    public final synchronized long skip(long r100) throws IOException {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f245079c.get() == true) goto L20;
        if (r100 > 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        long r101 = this.f245078b;     // Catch: Throwable -> L21
        long r102 = r100 + r101;     // Catch: Throwable -> L21
        this.f245078b = r102;     // Catch: Throwable -> L21
        if (r102 >= 0) goto L12;
        this.f245078b = 0;     // Catch: Throwable -> L21
    L16:
        long r103 = this.f245078b - r101;
        monitor-exit(this);
        return r103;
    L12:
        long r104 = this.f245081e;     // Catch: Throwable -> L21
        if (r102 <= r104) goto L16;
        this.f245078b = r104;     // Catch: Throwable -> L21
        goto L16
    L20:
        throw new IOException("released!");     // Catch: Throwable -> L21
    }

    @Override // ny5.a
    public final void write(int r100) throws IOException {
        write(new byte[]{(byte) r100}, 0, 1);
    }

    @Override // ny5.a
    public final void write(byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    public MMapBuffer(long r100, File r101) {
        this.f245081e = r100;
        this.f245082f = r101;
        this.f245079c = new AtomicBoolean(false);
        this.f245080d = new AtomicBoolean(false);
        r101.getParentFile().mkdirs();
        this.f245077a = nCreate(r101.getAbsolutePath(), r100);
    }

    @Override // ny5.a
    public final int read(byte[] r100, int r110, int r111) throws IOException {
        if (this.f245079c.get() == true) goto L32;
        if (r111 < 1) goto L29;
        if (r110 >= 0) goto L8;
        return 0;
    L8:
        if (r110 < r100.length) goto L11;
        return 0;
    L11:
        if ((r110 + r111) <= r100.length) goto L13;
        r111 = r100.length - r110;
    L13:
        monitor-enter(this);
        long r101 = this.f245078b;     // Catch: Throwable -> L26
        long r102 = this.f245081e;     // Catch: Throwable -> L26
        if (r101 != r102) goto L21;
        monitor-exit(this);
        return -1;
    L21:
        if ((((long) r111) + r101) <= r102) goto L23;
        r111 = (int) (r102 - r101);
    L23:
        nRead(this.f245077a, r101, r100, r110, r111);     // Catch: Throwable -> L26
        this.f245078b += (long) r111;     // Catch: Throwable -> L26
        monitor-exit(this);
        return r111;
    L26:
        th = move-exception;
        throw th;
    L29:
        return 0;
    L32:
        throw new IOException("released!");
    }

    @Override // ny5.a
    public final int write(byte[] r110, int r111, int r112) throws IOException {
        if (r110.length != 0) goto L5;
    L45:
        return 0;
    L5:
        if (r112 < 1) goto L45;
        if (r111 < 0) goto L45;
        if (r111 >= r110.length) goto L45;
        if ((r111 + r112) <= r110.length) goto L14;
        r112 = r110.length - r111;
    L14:
        monitor-enter(this);
        long r100 = this.f245078b;     // Catch: Throwable -> L42
        long r101 = this.f245081e;     // Catch: Throwable -> L42
        if (r100 != r101) goto L21;
        monitor-exit(this);
        return 0;
    L21:
        if ((((long) r112) + r100) <= r101) goto L24;
        r112 = (int) (r101 - r100);
    L24:
        if (this.f245079c.get() == false) goto L32;
        String r113 = "MMapBuffer write after release: " + this + '-' + this.f245081e + '-' + this.f245082f.getAbsolutePath();     // Catch: Throwable -> L42
        GeckoLogger.w(r113);     // Catch: Throwable -> L42
        EventSubType r114 = EventSubType.WRITE_AFTER_RELEASE;     // Catch: Throwable -> L42
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L42
        r115.put("sub_type", r114.getType());     // Catch: Throwable -> L42
        if (r113 == null) goto L28;
        r115.put(LocationMonitorConst.ERR_MSG, r113);     // Catch: Throwable -> L42
    L28:
        y86.a.c("geckosdk_event_message", r115);     // Catch: Throwable -> L42
        monitor-exit(this);
        return 0;
    L32:
        if (this.f245080d.get() == false) goto L39;
        String r116 = "MMapBuffer write after finish: " + this + '-' + this.f245081e + '-' + this.f245082f.getAbsolutePath();     // Catch: Throwable -> L42
        GeckoLogger.w(r116);     // Catch: Throwable -> L42
        EventSubType r117 = EventSubType.WRITE_AFTER_FINISH;     // Catch: Throwable -> L42
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L42
        r118.put("sub_type", r117.getType());     // Catch: Throwable -> L42
        if (r116 == null) goto L36;
        r118.put(LocationMonitorConst.ERR_MSG, r116);     // Catch: Throwable -> L42
    L36:
        y86.a.c("geckosdk_event_message", r118);     // Catch: Throwable -> L42
        monitor-exit(this);
        return 0;
    L39:
        nWrite(this.f245077a, this.f245078b, r110, r111, r112);     // Catch: Throwable -> L42
        this.f245078b += (long) r112;     // Catch: Throwable -> L42
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(this);
        return r112;
    L42:
        th = move-exception;
        throw th;
    }
}
