package e67;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f471145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OkHttpClient f471146b = null;

    public a() {
    }

    static {
        f471145a = a.class.getSimpleName();
        f471146b = new OkHttpClient();
    }

    public static String c() {
        Request.Builder r100 = new Request.Builder();
        if (b.a().b() == false) goto L5;
        String r101 = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    L6:
        Request r102 = r100.url(r101).get().build();
        String r103 = f471145a;
        k67.b.a(r103, "Challenge Request:" + r102.toString());
        k67.b.a(r103, "Challenge Request body:" + r102.body());
        int r104 = 1;
        String r105 = "";
    L8:
        if (r104 > 3) goto L42;
        Response r106 = f471146b.newCall(r102).execute();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L23:
        th = move-exception;
        if (r106 != null) goto L44;
    L29:
        throw th;     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L44:
        r106.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
        goto L29
    L11:
        if (r106.body() == null) goto L13;
        String r107 = r106.body().string();     // Catch: Throwable -> L23
    L16:
        if (r106.isSuccessful() == true) goto L17;
        k67.b.c(r103, "Challenge Attempt " + r104 + ": Response failed, code = " + r106.code());     // Catch: Throwable -> L23
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L23
        r108.append("Challenge Response body:");     // Catch: Throwable -> L23
        r108.append(r107);     // Catch: Throwable -> L23
        k67.b.c(r103, r108.toString());     // Catch: Throwable -> L23
        r106.close();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L38:
        if (r104 >= 3) goto L41;
        Thread.sleep(500);     // Catch: InterruptedException -> L43
    L41:
        r104 = r104 + 1;
        goto L8
    L17:
        k67.b.a(r103, "Challenge Response received successfully");     // Catch: Throwable -> L23
        k67.b.a(r103, "Challenge Response body:" + r107);     // Catch: Throwable -> L23
        r105 = b(r107);     // Catch: Throwable -> L23
        r106.close();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
        goto L42
    L13:
        r107 = "";
    L34:
        e = move-exception;
        k67.b.c(r103, "Challenge Attempt " + r104 + ": ConnectException (connect timeout): " + e.getMessage());
    L36:
        e = move-exception;
        k67.b.c(r103, "Challenge Attempt " + r104 + ": SocketTimeoutException (read/write timeout): " + e.getMessage());
    L32:
        e = move-exception;
        k67.b.c(r103, "Challenge Attempt " + r104 + ": IOException: " + e.getMessage());
    L30:
        e = move-exception;
        k67.b.b(r103, "Challenge Attempt " + r104 + ": Unexpected exception: ");
        e.printStackTrace();
    L42:
        return r105;
    L5:
        r101 = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
        goto L6
    }

    public static String a(String r100) {
        return JSONObjectProtectorUtils.getString(new JSONObject(JSONObjectProtectorUtils.getString(new JSONObject(r100), "data")), "nonce");
    L4:
        e = move-exception;
        k67.b.c(f471145a, "getChallenge exception: " + e.getMessage());
        return "";
    }

    public static String b(String r100) {
        String r101 = f471145a;
        int r102 = JSONObjectProtectorUtils.getInt(new JSONObject(r100), "code");     // Catch: Exception -> L5
    L8:
        if (r102 >= 200) goto L10;
    L15:
        return "";
    L10:
        if (r102 >= 300) goto L15;
        return a(r100);
    L13:
        e = move-exception;
        k67.b.c(r101, "parseChallenge exception: " + e.getMessage());
    L5:
        e = move-exception;
        k67.b.c(r101, "getResponseCode exception: " + e.getMessage());
        r102 = 400;
        goto L8
    }
}
