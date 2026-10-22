package rq5;

import com.bytedance.ee.bear.contract.NetService;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;
import org.json.JSONObject;
import tp5.b;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f538926a = 0;

    /* JADX INFO: renamed from: rq5.a$a, reason: collision with other inner class name */
    public static final class C7519a {
        @JvmStatic
        public static void a(Throwable r100, String r101, String r102, boolean r103) {
            if ((r100 instanceof NetService.ServerErrorException) == true) goto L5;
            return;
        L5:
            if (b.b(r100, 233525003) == false) goto L14;
            JSONObject r104 = new JSONObject(((NetService.ServerErrorException) r100).getData());     // Catch: JSONException -> L8
            r104.put("spaceId", r101);     // Catch: JSONException -> L8
            r104.put("token", r102);     // Catch: JSONException -> L8
            r104.put("isDeleteWithSub", r103);     // Catch: JSONException -> L8
            ((NetService.ServerErrorException) r100).setData(r104.toString());     // Catch: JSONException -> L8
            return;
        L8:
            e = move-exception;
            tt5.a.k("ApplyDeleteWikiParser", "parseThrowable fail: " + e);
            return;
        }
    }

    static {
    }
}
