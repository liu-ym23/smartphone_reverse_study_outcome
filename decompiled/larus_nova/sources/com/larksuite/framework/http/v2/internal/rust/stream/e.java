package com.larksuite.framework.http.v2.internal.rust.stream;

import androidx.collection.SieveCacheKt;
import com.byted.cast.common.Constants;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import okio.Source;
import okio.j0;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f285632a;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c r100 = this.f285632a;
        r100.getClass();
        FileInputStream r101 = r100.f285626f;     // Catch: Throwable -> L7 IOException -> L12
        if (r101 == null) goto L10;
        r101.close();     // Catch: Throwable -> L7 IOException -> L12
    L7:
        th = move-exception;
        r100.f285626f = null;
        throw th;
    L10:
        r100.f285626f = null;
    }

    @Override // okio.Source
    public final j0 timeout() {
        return j0.f524073d;
    }

    public e(c r100) {
        this.f285632a = r100;
    }

    @Override // okio.Source
    public final long read(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        if (r101 != 0) goto L5;
        return 0;
    L5:
        c r102 = this.f285632a;
        r102.getClass();
        r102.f285623c.await();     // Catch: InterruptedException -> L24
        Throwable r103 = this.f285632a.f285624d.get();
        if (r103 != null) goto L23;
        FileInputStream r104 = this.f285632a.f285626f;
        if (r104 != null) goto L12;
        r104 = new PolarisFileInputStreamWrapper(this.f285632a.f285621a);
        this.f285632a.f285626f = r104;
    L12:
        byte[] r105 = new byte[(int) RangesKt.coerceAtMost(r101, SieveCacheKt.NodeLinkMask)];
        int r106 = r104.read(r105);     // Catch: IOException -> L19
        if (r106 <= 0) goto L31;
        r100.write(r105, 0, r106);     // Catch: IOException -> L19
        return r106;
    L31:
        return -1;
    L19:
        e = move-exception;
        throw new IllegalStateException("Failed to read request body", e);
    L23:
        throw new IllegalStateException("Failed to read request body", r103);
    L24:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        throw new IllegalStateException("Failed to read request body", e);
    }
}
