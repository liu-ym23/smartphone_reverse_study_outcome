package com.bytedance.locallife.dito.common.request;

import com.bytedance.locallife.dito.exception.NetworkUndefineErrorException;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypedInput f257666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f257667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f257668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DowngradeReason f257669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ChunkData> f257670e;

    @Override // com.bytedance.locallife.dito.common.request.l
    public final void enable() {
        this.f257668c = true;
    }

    @Override // com.bytedance.locallife.dito.common.request.k
    public final Map<String, Object> getExtra() {
        return this.f257667b;
    }

    public e(TypedInput r100) {
        this.f257666a = r100;
        this.f257667b = new LinkedHashMap();
        this.f257668c = true;
        this.f257669d = DowngradeReason.DEFAULT;
        this.f257670e = new ArrayList();
    }

    @Override // com.bytedance.locallife.dito.common.request.k
    public final void a(com.bytedance.locallife.poi.dito.container.api.a r110) {
        Intrinsics.checkNotNullParameter(r110, "observer");
        d r100 = new d(this, r110);
        if (this.f257666a != null) goto L7;
        r100.onFailed(new NetworkUndefineErrorException("type input is null", null, 2, null));
        return;
    L7:
        if (this.f257668c == true) goto L9;
        ChunkHandler.f257654a.getClass();     // Catch: Throwable -> L63
        r100.a(ChunkHandler.Companion.f257656b.getValue().b(0, this.f257666a.in(), this.f257666a.mimeType(), this.f257667b), this.f257669d);     // Catch: Throwable -> L63
    L65:
        r100.onComplete();
        return;
    L63:
        th = move-exception;
        r100.onFailed(th);
        goto L65
    L9:
        if ((!((ArrayList) this.f257670e).isEmpty()) == false) goto L15;
        Iterator r101 = ((ArrayList) this.f257670e).iterator();
    L12:
        if (r101.hasNext() == false) goto L14;
        r110.b((ChunkData) r101.next());
        goto L12
    L14:
        return;
    L15:
        h r111 = new h(this.f257666a.in());
        String r102 = this.f257666a.mimeType();
        Map<String, Object> r103 = this.f257667b;
        r111.a();     // Catch: IOException -> L18
    L21:
        if (r111.f257682l == 0) goto L23;
        r100.onFailed(new IllegalStateException("ChunkedInputStream already been observed!"));
        return;
    L23:
        r111.f257682l = 1;
        System.currentTimeMillis();
        int r104 = 0;
    L79:
        System.currentTimeMillis();     // Catch: Throwable -> L44
        int r105 = r111.e();     // Catch: Throwable -> L44
        if (r105 < 0) goto L26;
        byte[] r106 = new byte[r105];     // Catch: Throwable -> L44
        System.arraycopy(r111.f257674d, r111.f257675e, r106, 0, r105);     // Catch: Throwable -> L44
        ChunkHandler.f257654a.getClass();     // Catch: Throwable -> L39
        int r107 = r104 + 1;
        r100.b(ChunkHandler.Companion.f257656b.getValue().b(r104, new ByteArrayInputStream(r106), r102, r103));     // Catch: Throwable -> L37
    L42:
        r104 = r107;
        r111.f257675e += r105;     // Catch: Throwable -> L44
        System.currentTimeMillis();     // Catch: Throwable -> L44
    L37:
        Throwable th10 = th;
    L41:
        r100.onFailed(th10);     // Catch: Throwable -> L44
    L39:
        th = move-exception;
        r107 = r104;
        th10 = th;
        goto L41
    L26:
        r100.onComplete();     // Catch: Throwable -> L44
        System.currentTimeMillis();
        InputStream r112 = r111.f257671a;     // Catch: Throwable -> L50
        if (r112 == null) goto L91;
    L71:
        r112.close();     // Catch: Throwable -> L50 Exception -> L67
        goto L95
    L94:
        return;
    L95:
        return;
    L91:
        return;
    L50:
        th = move-exception;
        th.printStackTrace();
        return;
    L44:
        th = move-exception;
        r100.onFailed(th);     // Catch: Throwable -> L52
        System.currentTimeMillis();
        r112 = r111.f257671a;     // Catch: Throwable -> L50
        if (r112 != null) goto L71;
        return;
    L52:
        th = move-exception;
        System.currentTimeMillis();
        InputStream r113 = r111.f257671a;     // Catch: Throwable -> L58
        if (r113 != null) goto L69;
    L60:
        throw th;
    L69:
        r113.close();     // Catch: Throwable -> L58 Exception -> L68
    L58:
        th = move-exception;
        th.printStackTrace();
    L18:
        e = move-exception;
        r100.onFailed(e);
        goto L21
    }

    @Override // com.bytedance.locallife.dito.common.request.l
    public final void b(DowngradeReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f257668c = false;
        this.f257669d = r100;
    }
}
