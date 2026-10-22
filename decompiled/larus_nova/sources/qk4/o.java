package qk4;

import com.bytedance.dora.transfer.DoraTransferDirection;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f533542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ok4.b f533543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f533544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n.c f533545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f533546e;

    @Override // okhttp3.Callback
    public final void onFailure(Call r100, IOException r101) {
        pk4.j.g("DoraVisionUtils", "http error, spent: " + (System.currentTimeMillis() - this.f533542a), r101);
        ((ok4.e) this.f533543b).b(this.f533544c, ok4.a.f523636e, new ok4.f.a(r101.getMessage()));
        this.f533545d.a(r101);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call r110, Response r111) throws IOException {
        if (r111.isSuccessful() == true) goto L17;
        pk4.j.f("DoraVisionUtils", "http error: " + r111.code() + ", spent: " + (System.currentTimeMillis() - this.f533542a));
        ok4.b r112 = this.f533543b;
        ok4.e r113 = (ok4.e) r112;
        r113.b(this.f533544c, ok4.a.f523636e, new ok4.f.a("HTTP Code: " + r111.code()));
        this.f533545d.a(new IOException("HTTP Code: " + r111.code()));
        return;
    L17:
        pk4.j.a("DoraVisionUtils", "response: " + r111.headers());     // Catch: IOException -> L13
        PolarisFileWrapper r100 = new PolarisFileWrapper(n.a());     // Catch: IOException -> L13
        if (r100.exists() == true) goto L7;
        pk4.j.a("DoraVisionUtils", "mkdir: " + r100 + " -> " + r100.mkdirs());     // Catch: IOException -> L13
    L7:
        PolarisFileWrapper r114 = new PolarisFileWrapper(this.f533546e);     // Catch: IOException -> L13
        PolarisFileOutputStreamWrapper r101 = new PolarisFileOutputStreamWrapper(r114);     // Catch: IOException -> L13
        InputStream r115 = r111.body().byteStream();     // Catch: IOException -> L13
        byte[] r102 = new byte[4096];     // Catch: IOException -> L13
        int r103 = 0;
    L8:
        int r104 = r115.read(r102);     // Catch: IOException -> L13
        if (r104 == (-1)) goto L11;
        r101.write(r102, 0, r104);     // Catch: IOException -> L13
        r103 = r103 + r104;     // Catch: IOException -> L13
        ok4.b r105 = this.f533543b;     // Catch: IOException -> L13
        String r106 = this.f533544c;     // Catch: IOException -> L13
        DoraTransferDirection r107 = DoraTransferDirection.UPLINK;     // Catch: IOException -> L13
        ((ok4.e) r105).d(r106, r104);     // Catch: IOException -> L13
        goto L8
    L11:
        r101.flush();     // Catch: IOException -> L13
        r101.close();     // Catch: IOException -> L13
        r115.close();     // Catch: IOException -> L13
        pk4.j.a("DoraVisionUtils", "readed: " + r103 + ", spent: " + (System.currentTimeMillis() - this.f533542a));     // Catch: IOException -> L13
        ((ok4.e) this.f533543b).b(this.f533544c, ok4.a.f523636e, ok4.f.f523665b);     // Catch: IOException -> L13
        this.f533545d.onSuccess(r114.getAbsolutePath());     // Catch: IOException -> L13
        return;
    L13:
        e = move-exception;
        pk4.j.g("DoraVisionUtils", "read failed, spent: " + (System.currentTimeMillis() - this.f533542a), e);
        ((ok4.e) this.f533543b).b(this.f533544c, ok4.a.f523636e, new ok4.f.a(e.getMessage()));
        this.f533545d.a(e);
    }

    public o(long r100, ok4.e r101, String r102, com.larus.dora.impl.feedback.j r103, String r104, String r105) {
        this.f533542a = r100;
        this.f533543b = r101;
        this.f533544c = r102;
        this.f533545d = r103;
        this.f533546e = r105;
    }
}
