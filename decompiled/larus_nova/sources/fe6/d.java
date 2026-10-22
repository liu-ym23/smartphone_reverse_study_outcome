package fe6;

import android.webkit.URLUtil;
import d8a.g;
import d8a.h;
import d8a.i;
import d8a.l;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f476609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OkHttpClient f476610b;

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f476611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f476612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f476613c;

        @Override // d8a.g
        public final void onFailed(i r100) {
            if (URLUtil.isNetworkUrl(this.f476612b.f467439a) == false) goto L5;
            this.f476613c.b(this.f476612b, this.f476611a, r100);
            return;
        L5:
            this.f476611a.onFailed(r100);
        }

        @Override // d8a.g
        public final void onSuccess(i r100) {
            this.f476611a.onSuccess(r100);
        }

        public a(d r100, g r101, h r102) {
            this.f476613c = r100;
            this.f476611a = r101;
            this.f476612b = r102;
        }
    }

    public d(l r100, OkHttpClient r101) {
        this.f476609a = r100;
        this.f476610b = r101;
    }

    @Override // d8a.l
    public final void a(h r100, g r101) {
        l r102 = this.f476609a;
        if (r102 != null) goto L9;
        i r103 = new i();
        if (URLUtil.isNetworkUrl(r100.f467439a) == false) goto L7;
        b(r100, r101, r103);
        return;
    L7:
        r101.onFailed(r103);
        return;
    L9:
        r102.a(r100, new a(this, r101, r100));
    }

    public final void b(h r100, g r101, i r102) {
        Request r103 = new Request.Builder().url(r100.f467439a).build();
        Response r104 = this.f476610b.newCall(r103).execute();     // Catch: Exception -> L22
        i r105 = new i();     // Catch: Throwable -> L15
        if (r104.body() != null) goto L7;
    L12:
        r101.onFailed(r102);     // Catch: Throwable -> L15
    L13:
        r104.close();     // Catch: Exception -> L22
        return;
    L7:
        if (r104.isSuccessful() == false) goto L12;
        r105.f467444d = r104.body().byteStream();     // Catch: Throwable -> L15
        r105.f467441a = r104.code();     // Catch: Throwable -> L15
        if (r104.body().contentType() == null) goto L11;
        r104.body().contentType().toString();     // Catch: Throwable -> L15
    L11:
        r105.f467443c = r104.headers().toMultimap();     // Catch: Throwable -> L15
        r101.onSuccess(r105);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r104 != null) goto L26;
    L21:
        throw th;     // Catch: Exception -> L22
    L26:
        r104.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22
    L22:
        r101.onFailed(r102);
    }
}
