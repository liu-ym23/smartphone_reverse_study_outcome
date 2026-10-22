package n25;

import android.os.SystemClock;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import io.reactivex.functions.Function;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Function<String, Boolean> {
    public final /* synthetic */ String a;
    public final /* synthetic */ DocBridgeWebViewV2 b;
    public final /* synthetic */ c c;

    public final Object apply(Object r6) throws Exception {
        String r7 = (String) r6;
        a r8 = this.c.b;
        if (r8 == null) goto L5;
        String r1 = this.a;
        tt5.a.h(r8.b, "setPreloadUrl()... preloadUrl = " + r1);
        r8.s = r1;
        r8.v = false;
    L5:
        DocBridgeWebViewV2 r9 = this.b;
        tt5.a.h(r9.g1, "resetIsReady()...  ");
        ((HashMap) r9.M1).clear();
        r9.P1 = false;
        DocBridgeWebViewV2 r10 = this.b;
        r10.getClass();
        r10.Q2 = SystemClock.uptimeMillis();
        r10.P2 = System.currentTimeMillis();
        r10.R2 = 0;
        r10.H();
        this.b.resumeTimers();
        this.b.loadUrl(this.a);
        tt5.a.h(this.c.a, "***reportPreloadHtml*** preloadHtml start  preloadUrl: " + this.a);
        return Boolean.TRUE;
    }

    public d(c r1, String r2, DocBridgeWebViewV2 r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
