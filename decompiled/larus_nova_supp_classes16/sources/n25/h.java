package n25;

import android.webkit.WebResourceResponse;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends WebResourceResponse {
    public final String a;

    @Override // android.webkit.WebResourceResponse
    public final InputStream getData() {
        tt5.a.h("OfflineWebResourceRespo", "getData url : " + this.a);
        return super.getData();
    }

    public h(String r1, String r2, String r3, InputStream r4) {
        super(r2, r3, r4);
        this.a = r1;
    }
}
