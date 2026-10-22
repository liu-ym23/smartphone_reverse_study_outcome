package lr5;

import java.util.concurrent.atomic.AtomicReference;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final OkHttpClient.Builder a;
    public final Boolean b;

    public final f a() {
        if (this.b.booleanValue() == false) goto L9;
        OkHttpClient.Builder r0 = this.a;
        AtomicReference<c> r1 = b.a;
        if (r0 != null) goto L8;
        return new h(new e().a());
    L8:
        return new h(r0.build());
    L9:
        OkHttpClient.Builder r2 = this.a;
        b.c();
        return b.a.get().a(r2.build());
    }

    public a(OkHttpClient.Builder r2, Boolean r3) {
        this.b = Boolean.FALSE;
        sr5.a.a(r2);
        this.a = r2;
        this.b = r3;
    }
}
