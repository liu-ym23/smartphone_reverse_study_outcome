package com.bytedance.gkfs.io;

import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.Unit;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f245202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f245203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, f> f245204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f245205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f245206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f245207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f245208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.gkfs.c f245209h;

    public static final class a {
    }

    static {
    }

    public final f a() throws IOException {
        if (this.f245203b.get() == true) goto L13;
        this.f245205d++;
        f r100 = this.f245204c.get(Integer.valueOf(this.f245205d));
        if (r100 != null) goto L15;
        UtilsKt$traceTime$1$1 r101 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        InputStream r102 = this.f245202a;
        StringBuilder r103 = new StringBuilder(40);
        int r104 = 0;
    L8:
        if (r104 >= 40) goto L10;
        r103.append((char) r102.read());
        r104 = r104 + 1;
        goto L8
    L10:
        c r105 = new c(r103.toString());
        InputStream r106 = this.f245202a;
        long r107 = ((long) UInt.m9544constructorimpl(UInt.m9544constructorimpl(UInt.m9544constructorimpl(UInt.m9544constructorimpl(UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) r106.read()) & UByte.MAX_VALUE) << 24) + UInt.m9544constructorimpl(UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) r106.read()) & UByte.MAX_VALUE) << 16)) + UInt.m9544constructorimpl(UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) r106.read()) & UByte.MAX_VALUE) << 8)) + UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) r106.read()) & UByte.MAX_VALUE))) & BodyPartID.bodyIdMax;
        this.f245206e += r101.invoke().longValue();
        f r108 = new f(r105, r107);
        this.f245204c.put(Integer.valueOf(this.f245205d), r108);
        return r108;
    L15:
        return r100;
    L13:
        throw new IOException("decoder has been closed!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f245203b.compareAndSet(false, true) == false) goto L11;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L6
        this.f245202a.close();     // Catch: Throwable -> L6
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }

    public g(byte[] r100, int r101, com.bytedance.gkfs.c r102) {
        this.f245207f = r100;
        this.f245208g = r101;
        this.f245209h = r102;
        this.f245202a = new ByteArrayInputStream(r100);
        this.f245203b = new AtomicBoolean(false);
        this.f245204c = new ConcurrentHashMap();
        this.f245205d = -1;
    }
}
