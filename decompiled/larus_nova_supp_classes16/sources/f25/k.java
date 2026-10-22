package f25;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.offline.base.GetAuthHeaderModel;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public final void handle(Object r5, tb5.m r6) {
        GetAuthHeaderModel r7 = (GetAuthHeaderModel) r5;
        tt5.a.h("GetAuthHeaderHandler", "handle, data: " + r7);
        if (r7 != null) goto L6;
        if (r6 == null) goto L35;
        r6.b(new JSONObject());
        return;
    L35:
        return;
    L6:
        IOfficeSDKTokenProvider r0 = OfficeSDKManager.getTokenProvider();
        if (r0 == null) goto L27;
        String r2 = r7.getUrl();
        String r3 = "";
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        String r8 = r7.getMethod();
        if (r8 == null) goto L15;
        r3 = r8;
    L15:
        Map r9 = r0.getAuthHeaders(r2, r3);
        if (r9 == null) goto L27;
        JSONObject r1 = new JSONObject();
        Iterator r10 = r9.entrySet().iterator();     // Catch: Exception -> L23
    L20:
        if (r10.hasNext() == false) goto L25;
        Map.Entry r4 = (Map.Entry) r10.next();     // Catch: Exception -> L23
        r1.put((String) r4.getKey(), (String) r4.getValue());     // Catch: Exception -> L23
    L25:
        if (r6 == null) goto L37;
        r6.b(r1);
        return;
    L37:
        return;
    L23:
        e = move-exception;
        tt5.a.e("GetAuthHeaderHandler", "handle, error when converting map to Json: ", e, false);
    L27:
        tt5.a.k("GetAuthHeaderHandler", "handle, headersMap is null");
        if (r6 == null) goto L39;
        r6.b(new JSONObject());
        return;
    }
}
