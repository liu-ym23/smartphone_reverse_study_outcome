package v38;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import com.larus.account.saas.security.api.IAccountSecurityService;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Interceptor {

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Request r101 = r100.request();
        SsResponse<?> r102 = r100.proceed(r101);
        if (r102 != null) goto L8;
        return null;
    L8:
        List<Header> r103 = r102.headers();
        if (StringsKt.equals(a(r103, "x-flow-ban-account"), "1", true) == false) goto L17;
        JSONObject r104 = new JSONObject();
        if (r101 == null) goto L13;
        String r105 = r101.getPath();
    L14:
        r104.put("path", r105);
        r104.put("logId", a(r103, NetResponse.HEADER_KEY_LOG_ID));
        r104.put("scene", "ban_account");
        SaasTracking.f286464a.reportEvent("doubao_account_banned", r104);
        b48.b r106 = FlowAccountSdk.f().getAccountInfo();
        if (r106.f17593a == false) goto L17;
        FlowAccountSdk.f().a("account_ban", null);
        IAccountSecurityService.f286489a.b(null, r106.f17594b);
        goto L17
    L13:
        r105 = null;
    L17:
        return r102;
    }

    public static String a(List r100, String r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals(((Header) r103).getName(), r101, true) == false) goto L4;
    L9:
        Header r104 = (Header) r103;
        if (r104 != null) goto L12;
        return null;
    L12:
        return r104.getValue();
    L8:
        r103 = null;
        goto L9
    }
}
