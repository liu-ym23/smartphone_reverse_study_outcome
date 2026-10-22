package i67;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f488437a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OkHttpClient f488438b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f488439c;

    public a() {
    }

    static {
        f488437a = a.class.getSimpleName();
        f488438b = new OkHttpClient();
    }

    public static b a(String r100) {
        String r101 = f488437a;
        int r102 = JSONObjectProtectorUtils.getInt(new JSONObject(r100), "code");     // Catch: Exception -> L5
    L26:
        String r103 = JSONObjectProtectorUtils.getString(new JSONObject(r100), "msg");     // Catch: Exception -> L9
    L12:
        if (r102 >= 200) goto L14;
    L19:
        c r104 = null;
    L21:
        return new b(r102, r103, r104);
    L14:
        if (r102 >= 300) goto L19;
        r104 = b(r100);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        k67.b.c(r101, "buildNetworkResponse exception: " + e.getMessage());
    L9:
        e = move-exception;
        k67.b.c(r101, "getResponseMsg exception: " + e.getMessage());
        r103 = "";
    L5:
        e = move-exception;
        k67.b.c(r101, "getResponseCode exception: " + e.getMessage());
        r102 = 400;
        goto L26
    }

    public static c b(String r100) {
        JSONObject r101 = new JSONObject(JSONObjectProtectorUtils.getString(new JSONObject(r100), "data"));     // Catch: Exception -> L5
        return new c(r101.optString("rpdid", ""), r101.optString("rpuid", ""));
    L5:
        e = move-exception;
        k67.b.c(f488437a, "getPseudoID exception: " + e.getMessage());
        return null;
    }
}
