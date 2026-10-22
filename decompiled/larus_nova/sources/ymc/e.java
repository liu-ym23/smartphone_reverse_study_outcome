package ymc;

import com.ss.videoarch.liveplayer.h;
import com.ss.videoarch.liveplayer.log.LiveError;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    public interface a {
        void onCompletion(JSONObject r100);

        void onError(LiveError r100);
    }

    private e() {
    }

    public static void doRequest(h r100, String r101, String r102, a r103) {
        if (r102 != null) goto L4;
        return;
    L4:
        h.b r104 = r100.doRequest(r101, r102);
        if (r104 != null) goto L8;
        r103.onError(new LiveError(LiveError.EMPTY, "result is null", null));
        return;
    L8:
        Exception r105 = r104.f458846e;
        if (r105 != null) goto L14;
        JSONObject r106 = r104.f458842a;
        if (r106 == null) goto L14;
        r103.onCompletion(r106);
        return;
    L14:
        HashMap r107 = new HashMap();
        JSONObject r108 = r104.f458842a;
        if (r108 == null) goto L18;
        r107.put("rawResp", r108);
    L18:
        if ((r105 instanceof IOException) == false) goto L21;
        r107.put("description", "network IO exception");
        LiveError r109 = new LiveError(LiveError.NETWORK_IO_ERROR, r105.toString(), r107);
    L30:
        r103.onError(r109);
        return;
    L21:
        if ((r105 instanceof JSONException) == false) goto L29;
        r107.put("description", "parse JSON failure");
        String r110 = r104.f458843b;
        if (r110 == null) goto L25;
        r107.put("rowBody", r110);
    L25:
        String r111 = r104.f458844c;
        if (r111 == null) goto L28;
        r107.put("responseHeader", r111);
    L28:
        r109 = new LiveError(LiveError.PARSE_JSON, r105.getMessage(), r107);
        goto L30
    L29:
        r107.put("description", "response not successful");
        r109 = new LiveError(LiveError.RESPONSE_ERROR, r105.getMessage(), r107);
        goto L30
    }
}
