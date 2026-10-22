package f25;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.offline.base.GetAuthHeaderModel;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements tb5.h<GetAuthHeaderModel> {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final BridgeAuthType authType() {
        return BridgeAuthType.Private;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        GetAuthHeaderModel r102 = (GetAuthHeaderModel) r100;
        tt5.a.h("GetAuthHeaderHandler", "handle, data: " + r102);
        if (r102 != null) goto L6;
        if (r101 == null) goto L35;
        r101.b(new JSONObject());
        return;
    L35:
        return;
    L6:
        IOfficeSDKTokenProvider r103 = OfficeSDKManager.getTokenProvider();
        if (r103 == null) goto L27;
        String r104 = r102.getUrl();
        String r105 = "";
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        String r106 = r102.getMethod();
        if (r106 == null) goto L15;
        r105 = r106;
    L15:
        Map<String, String> r107 = r103.getAuthHeaders(r104, r105);
        if (r107 == null) goto L27;
        JSONObject r108 = new JSONObject();
        Iterator<Map.Entry<String, String>> r109 = r107.entrySet().iterator();     // Catch: Exception -> L23
    L20:
        if (r109.hasNext() == false) goto L25;
        Map.Entry<String, String> r110 = r109.next();     // Catch: Exception -> L23
        r108.put2(r110.getKey(), r110.getValue());     // Catch: Exception -> L23
    L25:
        if (r101 == null) goto L37;
        r101.b(r108);
        return;
    L37:
        return;
    L23:
        e = move-exception;
        tt5.a.e("GetAuthHeaderHandler", "handle, error when converting map to Json: ", e, false);
    L27:
        tt5.a.k("GetAuthHeaderHandler", "handle, headersMap is null");
        if (r101 == null) goto L39;
        r101.b(new JSONObject());
        return;
    }
}
