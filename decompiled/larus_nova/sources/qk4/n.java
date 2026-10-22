package qk4;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OkHttpClient f533536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OkHttpClient f533537b = null;

    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f533538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f533539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f533540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f533541d;

        @Override // okhttp3.Callback
        public final void onFailure(Call r100, IOException r101) {
            pk4.j.g("DoraVisionUtils", "http error, spent: " + (System.currentTimeMillis() - this.f533538a), r101);
            int r102 = this.f533539b;
            if (r102 <= 0) goto L5;
            n.b(this.f533540c, r102 - 1, this.f533541d);
            return;
        L5:
            ((f.a) this.f533541d).a(this.f533540c, r101);
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call r210, Response r211) throws IOException {
            if (r211.isSuccessful() == true) goto L53;
            pk4.j.f("DoraVisionUtils", "http error: " + r211.code() + ", spent: " + (System.currentTimeMillis() - this.f533538a));
            int r100 = this.f533539b;
            if (r100 <= 0) goto L49;
            n.b(this.f533540c, r100 - 1, this.f533541d);
            return;
        L49:
            b r101 = this.f533541d;
            f.a r102 = (f.a) r101;
            r102.a(this.f533540c, new IOException("HTTP Code: " + r211.code()));
            return;
        L53:
            Headers r103 = r211.headers();     // Catch: IOException -> L41
            pk4.j.a("DoraVisionUtils", "response: " + r103);     // Catch: IOException -> L41
            ByteArrayOutputStream r104 = new ByteArrayOutputStream();     // Catch: IOException -> L41
            InputStream r105 = r211.body().byteStream();     // Catch: Throwable -> L33
            byte[] r106 = new byte[8192];     // Catch: Throwable -> L24
        L8:
            int r110 = r105.read(r106, 0, 8192);     // Catch: Throwable -> L24
            if (r110 == (-1)) goto L11;
            r104.write(r106, 0, r110);     // Catch: Throwable -> L24
            goto L8
        L11:
            byte[] r111 = r104.toByteArray();     // Catch: Throwable -> L24
            r105.close();     // Catch: Throwable -> L33
            r104.close();     // Catch: IOException -> L41
            pk4.j.a("DoraVisionUtils", "readed: " + r111.length + ", spent: " + (System.currentTimeMillis() - this.f533538a));     // Catch: IOException -> L41
            int r107 = 3000;
            r107 = CastIntegerProtector.parseInt(r103.get("Image-Width"));     // Catch: Throwable -> L17
            int r112 = CastIntegerProtector.parseInt(r103.get("Image-Height"));     // Catch: Throwable -> L17
            int r113 = r107;
        L22:
            f.a r108 = (f.a) this.f533541d;     // Catch: IOException -> L41
            r108.f533511f.o(r108.f533506a, r111, r111.length, r108.f533507b, r113, r112, r108.f533508c, r108.f533509d, 0, r108.f533510e, 0);     // Catch: IOException -> L41
            r108.f533511f.f533501c.incrementAndGet();     // Catch: IOException -> L41
            return;
        L17:
            th = move-exception;
            if (pk4.j.f529630b > 5) goto L21;
            pk4.j.f529629a.w("DoraVisionUtils", th);     // Catch: IOException -> L41
        L21:
            r113 = r107;
            r112 = 4000;
            goto L22
        L24:
            th = move-exception;
            if (r105 == null) goto L62;
            r105.close();     // Catch: Throwable -> L29
        L63:
            throw th;     // Catch: Throwable -> L33
        L29:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L62:
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            r104.close();     // Catch: Throwable -> L37
        L64:
            throw th;     // Catch: IOException -> L41
        L37:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L41
            throw th;     // Catch: IOException -> L41
        L41:
            e = move-exception;
            pk4.j.g("DoraVisionUtils", "read failed, spent: " + (System.currentTimeMillis() - this.f533538a), e);
            int r109 = this.f533539b;
            if (r109 <= 0) goto L45;
            n.b(this.f533540c, r109 - 1, this.f533541d);
            return;
        L45:
            ((f.a) this.f533541d).a(this.f533540c, e);
        }

        public a(long r100, int r101, String r102, b r103) {
            this.f533538a = r100;
            this.f533539b = r101;
            this.f533540c = r102;
            this.f533541d = r103;
        }
    }

    public interface b {
    }

    public interface c {
        void a(IOException r100);

        void onSuccess(String r100);
    }

    static {
        OkHttpClient.Builder r100 = new OkHttpClient.Builder();
        TimeUnit r101 = TimeUnit.SECONDS;
        f533536a = r100.connectTimeout(4, r101).readTimeout(4, r101).writeTimeout(4, r101).addInterceptor(new rk4.c()).addInterceptor(new rk4.a()).build();
        f533537b = new OkHttpClient.Builder().connectTimeout(60, r101).readTimeout(60, r101).writeTimeout(60, r101).addInterceptor(new rk4.c()).addInterceptor(new rk4.a()).build();
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        r100.append(pk4.n.f529659c.getFilesDir());
        String r101 = File.separator;
        r100.append(r101);
        r100.append("DoraSDK");
        r100.append(r101);
        r100.append("GLog");
        return r100.toString();
    }

    public static void b(String r100, int r101, b r110) {
        Request r102 = new Request.Builder().url(r100).build();
        long r103 = System.currentTimeMillis();
        pk4.j.a("DoraVisionUtils", "takeVision[" + r101 + "]: " + r100);
        f533536a.newCall(r102).enqueue(new a(r103, r101, r100, r110));
    }
}
