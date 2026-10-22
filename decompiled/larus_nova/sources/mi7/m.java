package mi7;

import ci7.z;
import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k.a f514108a;

    public static void a(int r100, String r101, k.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r103.put("type", r100);     // Catch: Exception -> L4
        r103.put("scheme", r101);     // Catch: Exception -> L4
        k.c("link invoke end", "link_invoke", r103, r102);     // Catch: Exception -> L4
        return;
    }

    public static void b(int r100, String r101, k.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("result", r100);     // Catch: Exception -> L9
        r103.put("url", r101);     // Catch: Exception -> L9
        j r104 = new j("link_invoke", "parse link fail", r103, r102);     // Catch: Exception -> L9
        IExecutor r105 = (IExecutor) z.a(IExecutor.class);     // Catch: Exception -> L9
        if (r105 != null) goto L13;
    L10:
        return;
    L13:
        r105.executeWithSingleThread(r104);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L9
    }

    public static void c(int r100, String r101, k.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r103.put("result", r100);     // Catch: Exception -> L4
        r103.put("scheme", r101);     // Catch: Exception -> L4
        k.c("parse link success", "link_invoke", r103, r102);     // Catch: Exception -> L4
        return;
    }
}
