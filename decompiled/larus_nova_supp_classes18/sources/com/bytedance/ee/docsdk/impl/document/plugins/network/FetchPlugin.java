package com.bytedance.ee.docsdk.impl.document.plugins.network;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.network.NetworkConstant$RequestMethod;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.utils.NetUtils;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.idependency.NetService;
import com.ss.android.lark.chameleon.util.JsonUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/network/FetchPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "gson", "Lcom/google/gson/Gson;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Companion", "FetchHandler", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FetchPlugin extends AbsChameleonPlugin {
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final Companion Companion = null;
    private static final String FROM_MOBILE_WEB = "mobileweb";
    private static final String KEY_FROM_SOURCE = "fromsource";
    private static final String KEY_REQUEST_TAG = "EENet-Request-Tag";
    private static final String REQUEST_JS_TAG = "docJSFetchRequest";
    private static final String TAG = "FetchPlugin";
    private final Gson gson;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/network/FetchPlugin$Companion;", "", "()V", "ACCEPT_ENCODING", "", "FROM_MOBILE_WEB", "KEY_FROM_SOURCE", "KEY_REQUEST_TAG", "REQUEST_JS_TAG", "TAG", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000fH\u0002J,\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J6\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/network/FetchPlugin$FetchHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/network/FetchModel;", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/network/FetchPlugin;)V", "UNKNOWN_ERROR", "", "handle", "", "params", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "processHeaders", "", "", "headers", "", "runGetRequest", ResourceData.KEY_URL, "runPostRequest", "postBody", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class FetchHandler implements BridgeHandlerV2<FetchModel> {
        private final int UNKNOWN_ERROR;
        final /* synthetic */ FetchPlugin this$0;

        public FetchHandler(FetchPlugin r1) {
            this.this$0 = r1;
            this.UNKNOWN_ERROR = -2;
        }

        private final Map<String, String> processHeaders(Map<String, String> r5) {
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L8;
            Map.Entry<String, String> r1 = r6.next();
            String r2 = r1.getKey();
            String r3 = r1.getValue();
            if (Intrinsics.areEqual(r2, FetchPlugin.ACCEPT_ENCODING) == true) goto L4;
            r0.put(r2, r3);
            goto L4
        L8:
            r0.put(FetchPlugin.KEY_REQUEST_TAG, FetchPlugin.REQUEST_JS_TAG);
            r0.put(FetchPlugin.KEY_FROM_SOURCE, FetchPlugin.FROM_MOBILE_WEB);
            return r0;
        }

        public void handle(FetchModel r9, CallBackFunction r10) {
            Intrinsics.checkNotNullParameter(r10, "callback");
            if (r9 != null) goto L6;
            r10.onCallBack(new FetchResult(this.UNKNOWN_ERROR, "", "params is null", null, 8, null).toString());
            return;
        L6:
            String r0 = r9.getMethod().toUpperCase(Locale.ROOT);
            if (Intrinsics.areEqual(r0, NetworkConstant$RequestMethod.GET) == false) goto L10;
            runGetRequest(r9.getUrl(), r9.getHeaders(), r10);
            return;
        L10:
            if (Intrinsics.areEqual(r0, NetworkConstant$RequestMethod.POST) == false) goto L14;
            runPostRequest(r9.getUrl(), r9.getHeaders(), r9.getBody(), r10);
            return;
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((FetchModel) r1, r2);
        }

        private final void runGetRequest(final String r9, Map<String, String> r10, final CallBackFunction r11) {
            Log.i(FetchPlugin.TAG, "runGetRequest, url=" + r9);
            if (NetUtils.INSTANCE.isValidUrl(r9) == true) goto L6;
            r11.onCallBack(new FetchResult(-1, r9, "Invalid url", null, 8, null).toString());
            return;
        L6:
            NetService.INSTANCE.httpGet(r9, processHeaders(r10), new FetchPlugin$FetchHandler$runGetRequest$1(r9, r11));
        }

        private final void runPostRequest(final String r9, Map<String, String> r10, Object r11, final CallBackFunction r12) {
            Log.i(FetchPlugin.TAG, "runPostRequest, url=" + r9);
            if (NetUtils.INSTANCE.isValidUrl(r9) == true) goto L6;
            r12.onCallBack(new FetchResult(-1, r9, "Invalid url", null, 8, null).toString());
            return;
        L6:
            NetService.INSTANCE.httpPost(r9, processHeaders(r10), JsonUtils.INSTANCE.toJsonString(r11), new FetchPlugin$FetchHandler$runPostRequest$1(r9, r12));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FetchPlugin() {
        this.gson = new Gson();
    }

    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(JsBridgeConstants.BIZ_UTIL_FETCH, new FetchHandler(this));
    }
}
