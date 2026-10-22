package u45;

import ay4.d;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VFSPath f548695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OkHttpClient f548696b;

    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u45.a f548697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VFSPath f548698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f548699c;

        @Override // okhttp3.Callback
        public final void onFailure(Call r100, IOException r101) {
            tt5.a.e("SimpleDownloadHelper", "on Download Failure: ", r101, false);
            u45.a r102 = this.f548697a;
            if (r102 == null) goto L6;
            r102.c(r101);
            return;
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call r110, Response r111) {
            String r112 = r111.header("Content-Length");
            if (r112 != null) goto L5;
            r112 = "-1";
        L5:
            long r100 = CastLongProtector.parseLong(r112);
            tt5.a.b("SimpleDownloadHelper", "content len: " + r100);
            OutputStream r101 = null;
            d.a().F(this.f548698b.getParent()).mkdirs();     // Catch: Throwable -> L23 IOException -> L25
            r101 = this.f548698b.toFile().newOutputStream();     // Catch: Throwable -> L23 IOException -> L25
            InputStream r113 = r111.body().byteStream();     // Catch: Throwable -> L23 IOException -> L25
            byte[] r102 = new byte[1024];     // Catch: Throwable -> L23 IOException -> L25
            int r103 = 0;
        L7:
            int r104 = r113.read(r102, 0, 1024);     // Catch: Throwable -> L23 IOException -> L25
            int r105 = -1;
            if (r104 == (-1)) goto L17;
            r103 = r103 + r104;     // Catch: Throwable -> L23 IOException -> L25
            u45.a r106 = this.f548697a;     // Catch: Throwable -> L23 IOException -> L25
            if (r106 == null) goto L16;
            if (r100 == (-1)) goto L15;
            r105 = (int) ((r103 * 100.0f) / r100);     // Catch: Throwable -> L23 IOException -> L25
        L15:
            r106.a(r105);     // Catch: Throwable -> L23 IOException -> L25
        L16:
            r101.write(r102, 0, r104);     // Catch: Throwable -> L23 IOException -> L25
            goto L7
        L17:
            r113.close();     // Catch: Throwable -> L23 IOException -> L25
            r101.close();     // Catch: Throwable -> L23 IOException -> L25
            b.a(this.f548699c, r101);
            u45.a r114 = this.f548697a;
            if (r114 == null) goto L21;
            r114.b(this.f548698b);
        L21:
            tt5.a.b("SimpleDownloadHelper", "download complete: ");
            return;
        L25:
            e = move-exception;
            tt5.a.e("SimpleDownloadHelper", "onResponse: ", e, false);     // Catch: Throwable -> L23
            u45.a r115 = this.f548697a;     // Catch: Throwable -> L23
            if (r115 == null) goto L29;
            r115.c(e);     // Catch: Throwable -> L23
        L29:
            b.a(this.f548699c, r101);
            return;
        L23:
            th = move-exception;
            b.a(this.f548699c, r101);
            throw th;
        }

        public a(b r100, u45.a r101, VFSPath r102) {
            this.f548699c = r100;
            this.f548697a = r101;
            this.f548698b = r102;
        }
    }

    public b() {
    }

    public static void a(b r100, Closeable r101) {
        r100.getClass();
        if (r101 == null) goto L11;
        r101.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        tt5.a.e("SimpleDownloadHelper", "onResponse: close error ", e, false);
        return;
    }

    public final void b(String r100, VFSPath r101, u45.a r102) {
        this.f548695a = r101;
        if (this.f548696b != null) goto L5;
        OkHttpClient.Builder r103 = new OkHttpClient.Builder().retryOnConnectionFailure(true);
        TimeUnit r104 = TimeUnit.SECONDS;
        this.f548696b = r103.connectTimeout(10, r104).readTimeout(10, r104).build();
    L5:
        Request r105 = new Request.Builder().url(r100).build();
        if (r102 == null) goto L8;
        r102.onStart();
    L8:
        this.f548696b.newCall(r105).enqueue(new a(this, r102, r101));
    }
}
