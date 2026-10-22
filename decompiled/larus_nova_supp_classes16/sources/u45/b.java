package u45;

import ay4.d;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public VFSPath a;
    public OkHttpClient b;

    public class a implements Callback {
        public final /* synthetic */ u45.a a;
        public final /* synthetic */ VFSPath b;
        public final /* synthetic */ b c;

        public final void onFailure(Call r3, IOException r4) {
            tt5.a.e("SimpleDownloadHelper", "on Download Failure: ", r4, false);
            u45.a r5 = this.a;
            if (r5 == null) goto L6;
            r5.c(r4);
            return;
        }

        public final void onResponse(Call r14, Response r16) {
            String r17 = r16.header("Content-Length");
            if (r17 != null) goto L5;
            r17 = ShowCardsJsData.ID_GLOBAL;
        L5:
            long r0 = CastLongProtector.parseLong(r17);
            tt5.a.b("SimpleDownloadHelper", "content len: " + r0);
            OutputStream r3 = null;
            d.a().F(this.b.getParent()).mkdirs();     // Catch: Throwable -> L23 IOException -> L25
            r3 = this.b.toFile().newOutputStream();     // Catch: Throwable -> L23 IOException -> L25
            InputStream r18 = r16.body().byteStream();     // Catch: Throwable -> L23 IOException -> L25
            byte[] r5 = new byte[1024];     // Catch: Throwable -> L23 IOException -> L25
            int r6 = 0;
        L7:
            int r7 = r18.read(r5, 0, 1024);     // Catch: Throwable -> L23 IOException -> L25
            int r8 = -1;
            if (r7 == (-1)) goto L17;
            r6 = r6 + r7;     // Catch: Throwable -> L23 IOException -> L25
            u45.a r9 = this.a;     // Catch: Throwable -> L23 IOException -> L25
            if (r9 == null) goto L16;
            if (r0 == (-1)) goto L15;
            r8 = (int) ((r6 * 100.0f) / r0);     // Catch: Throwable -> L23 IOException -> L25
        L15:
            r9.a(r8);     // Catch: Throwable -> L23 IOException -> L25
        L16:
            r3.write(r5, 0, r7);     // Catch: Throwable -> L23 IOException -> L25
            goto L7
        L17:
            r18.close();     // Catch: Throwable -> L23 IOException -> L25
            r3.close();     // Catch: Throwable -> L23 IOException -> L25
            b.a(this.c, r3);
            u45.a r19 = this.a;
            if (r19 == null) goto L21;
            r19.b(this.b);
        L21:
            tt5.a.b("SimpleDownloadHelper", "download complete: ");
            return;
        L25:
            e = move-exception;
            tt5.a.e("SimpleDownloadHelper", "onResponse: ", e, false);     // Catch: Throwable -> L23
            u45.a r110 = this.a;     // Catch: Throwable -> L23
            if (r110 == null) goto L29;
            r110.c(e);     // Catch: Throwable -> L23
        L29:
            b.a(this.c, r3);
            return;
        L23:
            th = move-exception;
            b.a(this.c, r3);
            throw th;
        }

        public a(b r1, u45.a r2, VFSPath r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public b() {
    }

    public static void a(b r2, Closeable r3) {
        r2.getClass();
        if (r3 == null) goto L11;
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        tt5.a.e("SimpleDownloadHelper", "onResponse: close error ", e, false);
        return;
    }

    public final void b(String r5, VFSPath r6, u45.a r7) {
        this.a = r6;
        if (this.b != null) goto L5;
        OkHttpClient.Builder r0 = new OkHttpClient.Builder().retryOnConnectionFailure(true);
        TimeUnit r1 = TimeUnit.SECONDS;
        this.b = r0.connectTimeout(10, r1).readTimeout(10, r1).build();
    L5:
        Request r8 = new Request.Builder().url(r5).build();
        if (r7 == null) goto L8;
        r7.onStart();
    L8:
        this.b.newCall(r8).enqueue(new a(this, r7, r6));
    }
}
