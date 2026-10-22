package v0b;

import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static VFSPath f552345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static OkHttpClient f552346b;

    static {
    }

    public d() {
    }

    public static final void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        j.b("CML_TAG_D_DownloadHelper", "closeQuietly, err:" + e);
        return;
    }

    public static void b(String r100, VFSPath r101, a r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "downloadPath");
        f552345a = r101;
        if (f552346b != null) goto L28;
        OkHttpClient.Builder r104 = new OkHttpClient.Builder().retryOnConnectionFailure(true);
        TimeUnit r105 = TimeUnit.SECONDS;
        f552346b = r104.connectTimeout(30, r105).readTimeout(30, r105).build();
    L28:
        Request.Builder r106 = new Request.Builder().url(r100);     // Catch: Exception -> L23
        Iterator r107 = ((HashMap) r103).entrySet().iterator();     // Catch: Exception -> L23
    L7:
        if (r107.hasNext() == false) goto L17;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: Exception -> L23
        String r109 = (String) r108.getKey();     // Catch: Exception -> L23
        String r110 = (String) r108.getValue();     // Catch: Exception -> L23
    L15:
        e = move-exception;
        j.c("CML_TAG_D_DownloadHelper", "忽略异常请求头: " + r109, e);     // Catch: Exception -> L23
        goto L7
    L10:
        if ((!StringsKt.isBlank(r109)) == false) goto L7;
        if ((!StringsKt.isBlank(r110)) == false) goto L7;
        r106.header(r109, r110);     // Catch: Exception -> L15
    L17:
        Request r111 = r106.build();     // Catch: Exception -> L23
        r102.onStart();     // Catch: Exception -> L23
        OkHttpClient r112 = f552346b;     // Catch: Exception -> L23
        if (r112 == null) goto L38;
        Call r113 = r112.newCall(r111);     // Catch: Exception -> L23
        if (r113 == null) goto L39;
        r113.enqueue(new c(r102, r101));     // Catch: Exception -> L23
        return;
    L39:
        return;
    L38:
        return;
    L23:
        e = move-exception;
        j.b("CML_TAG_D_DownloadHelper", "create request error: " + e);
        r102.c(e);
    }
}
