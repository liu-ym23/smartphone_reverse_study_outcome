package rq5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;
import org.json.JSONObject;
import tp5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: rq5.a$a, reason: collision with other inner class name */
    public static final class C0302a {
        @JvmStatic
        public static void a(Throwable r2, String r3, String r4, boolean r5) {
            if ((r2 instanceof NetService.ServerErrorException) == true) goto L5;
            return;
        L5:
            if (b.b(r2, 233525003) == false) goto L14;
            JSONObject r0 = new JSONObject(((NetService.ServerErrorException) r2).getData());     // Catch: JSONException -> L8
            r0.put("spaceId", r3);     // Catch: JSONException -> L8
            r0.put(ResourceData.KEY_TOKEN, r4);     // Catch: JSONException -> L8
            r0.put("isDeleteWithSub", r5);     // Catch: JSONException -> L8
            ((NetService.ServerErrorException) r2).setData(r0.toString());     // Catch: JSONException -> L8
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
