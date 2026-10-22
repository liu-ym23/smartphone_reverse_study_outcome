package id;

import com.bytedance.android.chunkstreamprediction.network.h;
import com.bytedance.android.chunkstreamprediction.network.j;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements com.bytedance.android.chunkstreamprediction.network.b.InterfaceC0776b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.chunkstreamprediction.network.c f489275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f489276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f489277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f489278d;

    @Override // com.bytedance.android.chunkstreamprediction.network.b.InterfaceC0776b
    public void call(com.bytedance.android.chunkstreamprediction.network.b<Object> r110, com.bytedance.android.chunkstreamprediction.network.a<Object> r111) {
        com.bytedance.android.chunkstreamprediction.network.c r100 = this.f489275a;
        r100.f42526b = System.currentTimeMillis();
        r110.f42520a.getClass();
        h r101 = this.f489278d.f489281c;
        if (r101 == null) goto L49;
        r101.b();
    L49:
        com.bytedance.android.chunkstreamprediction.network.c.a r102 = new com.bytedance.android.chunkstreamprediction.network.c.a();     // Catch: Throwable -> L30
        r102.f42527a = System.currentTimeMillis();     // Catch: Throwable -> L30
        d r103 = this.f489276b.b();     // Catch: Throwable -> L30
        r102.f42528b = System.currentTimeMillis();     // Catch: Throwable -> L30
        if (r103.f489282a == 0) goto L7;
        InputStreamReader r104 = new InputStreamReader(r103, this.f489277c);     // Catch: Throwable -> L30
        JsonReader r105 = this.f489278d.f489279a.newJsonReader(r104);     // Catch: Throwable -> L30
        Object r106 = this.f489278d.f489280b.read(r105);     // Catch: Throwable -> L30
        r104.close();     // Catch: Throwable -> L30
        this.f489276b.a();     // Catch: Throwable -> L30
        long r107 = System.currentTimeMillis();     // Catch: Throwable -> L30
        r102.f42530d = r107;     // Catch: Throwable -> L30
        r102.f42529c = r102.f42528b + (r103.f489285d / 1000000);     // Catch: Throwable -> L30
        r102.f42532f = r107;     // Catch: Throwable -> L30
        r102.f42533g = r103.f489282a;     // Catch: Throwable -> L30
        com.bytedance.android.chunkstreamprediction.network.c r108 = this.f489275a;     // Catch: Throwable -> L30
        monitor-enter(r108);     // Catch: Throwable -> L30
        ((ArrayList) r108.f42525a).add(r102);     // Catch: Throwable -> L27
        monitor-exit(r108);     // Catch: Throwable -> L30
        j r109 = r110.f42520a;     // Catch: Throwable -> L30
        r102.toString();     // Catch: Throwable -> L30
        r109.getClass();     // Catch: Throwable -> L30
        if ((r106 instanceof com.bytedance.android.chunkstreamprediction.network.d) == false) goto L26;
        ((com.bytedance.android.chunkstreamprediction.network.d) r106).setChunkReadingReport(this.f489275a);     // Catch: Throwable -> L30
    L26:
        r111.onNext(r106);     // Catch: Throwable -> L30
        r102.f42531e = System.currentTimeMillis();     // Catch: Throwable -> L30
        goto L49
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L7:
        this.f489276b.a();     // Catch: Throwable -> L30
        if (this.f489276b.f489286a.read() != (-1)) goto L18;
        r110.f42520a.getClass();     // Catch: Throwable -> L30
        r111.onComplete();     // Catch: Throwable -> L30
        StreamParser.safeClose(this.f489276b.f489286a);     // Catch: Throwable -> L14
        h r112 = this.f489278d.f489281c;     // Catch: Throwable -> L14
        if (r112 == null) goto L62;
        r112.a();     // Catch: Throwable -> L14
        return;
    L62:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        throw new IOException("Not EOF");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r111.onFailed(th);     // Catch: Throwable -> L39
        StreamParser.safeClose(this.f489276b.f489286a);     // Catch: Throwable -> L36
        h r113 = this.f489278d.f489281c;     // Catch: Throwable -> L36
        if (r113 == null) goto L64;
        r113.a();     // Catch: Throwable -> L36
        return;
    L64:
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
        return;
    L39:
        th = move-exception;
        StreamParser.safeClose(this.f489276b.f489286a);     // Catch: Throwable -> L44
        if (this.f489278d.f489281c == null) goto L46;
        this.f489278d.f489281c.a();     // Catch: Throwable -> L44
    L46:
        throw th;
    L44:
        th = move-exception;
        th.printStackTrace();
        goto L46
    }

    public b(c r100, com.bytedance.android.chunkstreamprediction.network.c r101, e r102, String r103) {
        this.f489278d = r100;
        this.f489275a = r101;
        this.f489276b = r102;
        this.f489277c = r103;
    }
}
