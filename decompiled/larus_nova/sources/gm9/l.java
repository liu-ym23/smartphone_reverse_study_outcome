package gm9;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.retrofit2.client.Request;
import com.larus.utils.logger.FLogger;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481769a = 0;

    static {
    }

    public static String a(JSONObject r100, String r101) {
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        if (StringsKt.equals(r103, r101, true) == false) goto L4;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof String) == false) goto L10;
        return (String) r104;
    L10:
        return null;
    }

    public static com.larus.network.a b(Request r110, CronetIOException r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        BaseHttpRequestInfo r112 = r111.getRequestInfo();
        com.larus.network.a r100 = null;
        if (r112 == null) goto L5;
        String r113 = r112.responseHeaders;
    L6:
        if (r113 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        return null;
    L14:
        JSONObject r102 = new JSONObject(r113);
        String r103 = a(r102, "x-lsc-code");
        String r104 = a(r102, "x-lsc-decision");
        String r105 = a(r102, NetResponse.HEADER_KEY_LOG_ID);
        if (r103 == null) goto L28;
        if (r104 != null) goto L19;
        FLogger.f375446a.i("FlowAccessControl", "Ignore access control action, reason=missing_lsc_decision");
        goto L28
    L19:
        String r114 = r110.getHost();
        if (r114 != null) goto L22;
        String r106 = "";
    L23:
        String r115 = r110.getPath();
        if (r115 != null) goto L26;
        String r107 = "";
    L27:
        r100 = new com.larus.network.a(r103, r104, r105, r106, r107, false, System.currentTimeMillis());
        goto L28
    L26:
        r107 = r115;
        goto L27
    L22:
        r106 = r114;
    L28:
        return r100;
    L8:
        if (StringsKt.isBlank(r113) == true) goto L11;
        r101 = false;
        goto L12
    L5:
        r113 = null;
        goto L6
    }
}
