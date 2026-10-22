package ko4;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends io4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f504425b;

    /* JADX INFO: renamed from: ko4.a$a, reason: collision with other inner class name */
    public static final class C6581a {
    }

    public static final class b<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f504426a;

        public b(XBridgeMethod.Callback r100) {
            this.f504426a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            j.e("BitableCallWebviewJSBMethod", "onSuccess");
            XBridgeMethod.Callback r102 = this.f504426a;
            LinkedHashMap r103 = new LinkedHashMap();
            r103.put("code", 1);
            r103.put("msg", "");
            Intrinsics.checkNotNull(r101);
            r103.put("data", r101);
            r102.invoke(r103);
        }
    }

    static {
    }

    public a() {
        this.f504425b = "bitable.common.callWebviewJSB";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f504425b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r110, XBridgePlatformType r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, "type");
        String r112 = s.f(r100, "webviewJsbName", "");
        if (r112.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        XCoreBridgeMethod.onFailure$default(this, r110, 0, "webviewJsbName is empty", null, 8, null);
        return;
    L9:
        or4.a r102 = (or4.a) getBridgeService(or4.a.class);
        if (r102 != null) goto L13;
        XCoreBridgeMethod.onFailure$default(this, r110, 0, "webJSExecutor not found", null, 8, null);
        return;
    L13:
        XReadableMap r103 = s.e(r100, "param");
        if (r103 == null) goto L18;
        Map<String, Object> r104 = r103.toMap();
        if (r104 == null) goto L18;
        JSONObject r105 = new JSONObject(r104);
    L19:
        r102.a(r112, r105, new b(r110));
        return;
    L18:
        r105 = null;
        goto L19
    L5:
        r101 = false;
        goto L6
    }
}
