package f30;

import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.config.fr;
import com.bytedance.android.livesdkapi.depend.constant.ApiConfig;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "apiParam")
public final class a extends g<Object, JSONObject> {

    /* JADX INFO: renamed from: f30.a$a, reason: collision with other inner class name */
    public static class C5853a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C5853a f475326c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f475327d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f475328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f475329b;

        public C5853a() {
        }

        static {
            f475326c = new C5853a();
            f475327d = fr.f120225a.getValue().intValue();
        }
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(Object r100, CallContext r101) throws Exception {
        JSONObject r102 = new JSONObject();
        C5853a r103 = C5853a.f475326c;
        if (r103.f475328a == null) goto L8;
        if ((System.currentTimeMillis() - r103.f475329b) <= C5853a.f475327d) goto L8;
        r103.f475328a = null;
    L8:
        if (r103.f475328a != null) goto L10;
        r103.f475328a = ((IMiddlewareNetworkService) k.f(IMiddlewareNetworkService.class)).getCommonParams();
        r103.f475329b = System.currentTimeMillis();
    L10:
        Map<String, String> r104 = r103.f475328a;
        Iterator<String> r105 = r104.keySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L19;
        String r106 = r105.next();
        String r107 = r104.get(r106);
        if (StringUtils.isEmpty(r106) == true) goto L12;
        if (StringUtils.isEmpty(r107) == true) goto L12;
        r102.put(r106, r107);
        goto L12
    L19:
        if (LiveHybridSettingKeys.ARGUS_API_PARAM_JSB_DELETE_TOKEN.getValue().booleanValue() == true) goto L28;
        JSONObject r108 = new JSONObject();
        Map<String, String> r109 = ((IHostWebView) k.f(IHostWebView.class)).getHeaderMap(ApiConfig.API_URL_PREFIX_I);
        if (r109 == null) goto L27;
        Iterator<Map.Entry<String, String>> r110 = r109.entrySet().iterator();
    L25:
        if (r110.hasNext() == false) goto L27;
        Map.Entry<String, String> r111 = r110.next();
        r108.put(r111.getKey(), r111.getValue());
    L27:
        r102.put("tt_token", r108);
    L28:
        return r102;
    }
}
