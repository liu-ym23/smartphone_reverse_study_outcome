package n25;

import android.webkit.WebResourceResponse;
import java.io.InputStream;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends WebResourceResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516738a;

    @Override // android.webkit.WebResourceResponse
    public final InputStream getData() {
        tt5.a.h("OfflineWebResourceRespo", "getData url : " + this.f516738a);
        return super.getData();
    }

    public h(String r100, String r101, String r102, InputStream r103) {
        super(r101, r102, r103);
        this.f516738a = r100;
    }
}
