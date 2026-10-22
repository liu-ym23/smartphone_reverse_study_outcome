package com.bytedance.ee.bear.attachment.filereader;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f206392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f206393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h.a f206394c;

    @Override // okhttp3.Callback
    public final void onFailure(Call r100, IOException r101) {
        tt5.a.e("FileDownloadUtil", "   downloadFileFromTos 22  filePath:  url: " + du5.b.g(this.f206392a) + "  onFailure: ", r101, false);
        h.b(this.f206394c);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call r100, Response r101) throws IOException {
        tt5.a.b("FileDownloadUtil", "   downloadFileFromTos filePath:  url: " + du5.b.g(this.f206392a) + "  response: " + r101);
        h.a(r101, this.f206393b, this.f206394c);
    }

    public d(String r100, String r101, h.a r102) {
        this.f206392a = r100;
        this.f206393b = r101;
        this.f206394c = r102;
    }
}
