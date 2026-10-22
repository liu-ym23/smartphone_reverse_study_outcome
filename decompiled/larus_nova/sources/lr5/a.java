package lr5;

import java.util.concurrent.atomic.AtomicReference;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient.Builder f510400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f510401b;

    public final f a() {
        if (this.f510401b.booleanValue() == false) goto L9;
        OkHttpClient.Builder r100 = this.f510400a;
        AtomicReference<c> r101 = b.f510402a;
        if (r100 != null) goto L8;
        return new h(new e().a());
    L8:
        return new h(r100.build());
    L9:
        OkHttpClient.Builder r102 = this.f510400a;
        b.c();
        return b.f510402a.get().a(r102.build());
    }

    public a(OkHttpClient.Builder r100, Boolean r101) {
        this.f510401b = Boolean.FALSE;
        sr5.a.a(r100);
        this.f510400a = r100;
        this.f510401b = r101;
    }
}
