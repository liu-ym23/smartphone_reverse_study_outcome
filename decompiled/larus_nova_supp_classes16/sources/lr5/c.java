package lr5;

import com.bytedance.ee.eenet.util.HttpChannel;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends f {
    public c(f r1) {
        this.a = r1;
    }

    @Override // lr5.g
    public final f a(OkHttpClient r2) {
        return new c(this.a.a(r2));
    }

    public final Call newCall(Request r8) {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        jr5.a r1 = b.e;
        HttpChannel r2 = b.d;
        HttpChannel r3 = HttpChannel.OkHttpChannel;
        boolean r4 = false;
        if (r2 != r3) goto L6;
    L16:
        boolean r5 = true;
    L18:
        if (r5 == true) goto L20;
        HttpChannel r6 = HttpChannel.RustChannel;
        if (r6 != r3) goto L33;
        if ((r0 instanceof h) == false) goto L33;
    L34:
        r4 = true;
    L35:
        if (r4 == true) goto L38;
        r0 = b.a(r6).a(r0);
        this.a = r0;
    L38:
        return r0.newCall(r8);
    L33:
        if ((r0 instanceof i) == false) goto L35;
    L20:
        if ((r0 instanceof h) == false) goto L22;
    L25:
        r4 = true;
    L26:
        if (r4 == true) goto L38;
        r0 = b.a(r3).a(r0);
        this.a = r0;
        goto L38
    L22:
        if (r3 != HttpChannel.RustChannel) goto L26;
        if ((r0 instanceof i) == false) goto L26;
    L6:
        if (r2 == HttpChannel.RustChannel) goto L8;
    L17:
        r5 = false;
        goto L18
    L8:
        if (r1 != null) goto L10;
        tt5.a.k("eenet_EEOk3HttpClient", "EEHttpDepend no set will force use ok3 httpclient");
        goto L16
    L10:
        Map r7 = com.bytedance.lark.sdk.d.e;
        com.bytedance.lark.sdk.d.f.a.getClass();
        if (com.bytedance.lark.sdk.d.p < 0) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == true) goto L17;
        tt5.a.k("eenet_EEOk3HttpClient", "rustSdk plugin no inited will force use ok3 httpclient");
        goto L16
    L13:
        r9 = false;
        goto L14
    }
}
