package com.bytedance.locallife.hybrid.bridge;

import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.locallife.hybrid.bridge.network.LifeSaasNetwork;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import defpackage.ApiResultException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "fetch")
public final class f extends mt6.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f258998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f258999c;

    public static final class a {
    }

    public static final class b implements nu6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f259000a = null;

        static {
            f259000a = new b();
        }

        public b() {
        }

        @Override // nu6.b
        public final void a(nu6.c r100) {
            if (r100.f520608b == null) goto L5;
            new ApiResultException(BuyNowCloseMethod.NETWORK_ERROR, r100.f520608b);
            return;
        L5:
            JSONObject r101 = r100.f520607a;
            if (r101 != null) goto L8;
            return;
        L8:
            if (r101.has("message") == true) goto L10;
        L12:
            boolean r102 = false;
            if (r100.f520607a.has("code") == false) goto L16;
            int r103 = r100.f520607a.optInt("code");
        L22:
            if (r103 == 0) goto L24;
        L23:
            r102 = true;
        L24:
            if (r102 == false) goto L29;
            new ApiResultException(UploadTypeInf.API_ERROR, new Exception(r100.f520607a.toString()));
            return;
        L29:
            return;
        L16:
            if (r100.f520607a.has("status_code") == false) goto L19;
            r103 = r100.f520607a.optInt("status_code");
            goto L22
        L19:
            if (r100.f520607a.has("statusCode") == false) goto L21;
            r103 = r100.f520607a.optInt("statusCode");
            goto L22
        L21:
            r103 = 0;
            goto L22
        L10:
            if (Intrinsics.areEqual("success", r100.f520607a.optString("message")) == true) goto L12;
            goto L12
        }
    }

    public static final class c implements nu6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f259001a;

        public c(IDLXBridgeMethod.a r100) {
            this.f259001a = r100;
        }

        @Override // nu6.a
        public final void a(JSONObject r100) {
            if (r100.has("response") == false) goto L5;
            r100.put(TemplateNodeType.RAW, r100.optJSONObject("response"));
        L5:
            this.f259001a.invoke(com.bytedance.locallife.common.utils.f.e(r100));
        }
    }

    static {
    }

    public f() {
        this.f258998b = "fetch";
        this.f258999c = b.f259000a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f258998b;
    }

    public static n56.f a(JSONObject r100) {
        n56.f r101 = new n56.f();
        r101.f518032d = r100;
        JSONObject r102 = r100.optJSONObject("jsMsg");
        if (r102 == null) goto L5;
        r101.f518029a = r102.optString("type");
        r101.f518031c = r102.optString("func");
        r101.f518030b = r102.optString(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID);
        r101.f518033e = r102.optInt("version");
        r101.f518038j = r102.optBoolean("needCallback");
        r101.f518037i = r102.optString("permissionGroup");
    L5:
        return r101;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        m16.b r102 = (m16.b) r100.getService(m16.b.class);
        if (r102 == null) goto L5;
        n56.a r103 = (n56.a) r102.c(n56.a.class);
    L6:
        n56.a r104 = r103;
        JSONObject r105 = com.bytedance.locallife.biz.common.utils.b.c(r101);     // Catch: Exception -> L16
        String r106 = r105.optString("url", "");     // Catch: Exception -> L18
        if (r106.length() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        r105.put("url", LifeSaasNetwork.b(r106));     // Catch: Exception -> L18
        goto L14
    L11:
        r107 = false;
    L14:
        new ou6.i(a(r105), r105.optJSONObject("res"), r104, new c(r110), this.f258999c).b();     // Catch: Exception -> L16
        return;
    L16:
        com.bytedance.locallife.biz.common.utils.c.a("FetchMethod", "fetch method is wrong");
        return;
    L5:
        r103 = null;
        goto L6
    }
}
