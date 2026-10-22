package g67;

import com.bytedance.privacy.pcc.network.model.h;
import e67.b;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f480168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OkHttpClient f480169b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f480170c;

    public a() {
    }

    static {
        f480168a = a.class.getSimpleName();
        f480169b = new OkHttpClient();
    }

    public static a a() {
        if (f480170c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f480170c != null) goto L9;
        f480170c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f480170c;
    }

    public static String b(String r100, String r101, String r102) {
        if (b.a().b() == false) goto L5;
        String r103 = "https://opcc-gateway-boe.bytedance.net";
    L6:
        String r104 = r103.concat("/opcc/v2/auth/upload/channelRet");
        Request.Builder r105 = new Request.Builder().url(r104).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r102)).addHeader("Content-Type", "application/json").addHeader("x-requestId", r100).addHeader("x-timestamp", r101);
        b.a().b();
        Request r106 = r105.build();
        String r107 = f480168a;
        k67.b.a(r107, "PCC UploadChannelRet request: " + r104);
        k67.b.a(r107, "PCC UploadChannelRet body: " + r102);
        int r108 = 1;
    L7:
        String r109 = "";
        if (r108 > 3) goto L39;
        Response r110 = f480169b.newCall(r106).execute();     // Catch: Exception -> L28 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L21:
        th = move-exception;
        if (r110 != null) goto L45;
    L27:
        throw th;     // Catch: Exception -> L28 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L45:
        r110.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L28 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
        goto L27
    L11:
        if (r110.body() == null) goto L14;
        r109 = r110.body().string();     // Catch: Throwable -> L21
    L14:
        if (r110.isSuccessful() == true) goto L15;
        k67.b.c(r107, "PCC UploadChannelRet attempt " + r108 + ": HTTP " + r110.code() + " body=" + r109);     // Catch: Throwable -> L21
        r110.close();     // Catch: Exception -> L28 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L35:
        if (r108 >= 3) goto L38;
        Thread.sleep(500);     // Catch: InterruptedException -> L40
    L38:
        r108 = r108 + 1;
        goto L7
    L15:
        k67.b.a(r107, "PCC UploadChannelRet response: " + r109);     // Catch: Throwable -> L21
        String r111 = h.a(r109).f266708a;     // Catch: Throwable -> L21
        r110.close();     // Catch: Exception -> L28 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
        return r111;
    L31:
        e = move-exception;
        k67.b.c(r107, "PCC UploadChannelRet attempt " + r108 + ": ConnectException: " + e.getMessage());
    L33:
        e = move-exception;
        k67.b.c(r107, "PCC UploadChannelRet attempt " + r108 + ": SocketTimeoutException: " + e.getMessage());
    L29:
        e = move-exception;
        k67.b.c(r107, "PCC UploadChannelRet attempt " + r108 + ": IOException: " + e.getMessage());
    L28:
        k67.b.b(r107, "PCC UploadChannelRet attempt " + r108 + ": unexpected exception: ");
        goto L35
    L39:
        return "";
    L5:
        r103 = "https://opcc-gateway.obriccloud.com";
        goto L6
    }
}
