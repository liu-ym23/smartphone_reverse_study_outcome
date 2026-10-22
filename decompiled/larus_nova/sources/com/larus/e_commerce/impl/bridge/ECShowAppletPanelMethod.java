package com.larus.e_commerce.impl.bridge;

import android.content.Context;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.api.IECommerceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o89.i;
import org.json.JSONArray;
import org.json.JSONObject;
import s89.d;
import u89.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u0004\u0018\u00010\u0011H\u0002J\f\u0010\u0012\u001a\u00020\u0010*\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/e_commerce/impl/bridge/ECShowAppletPanelMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "params", "Lorg/json/JSONObject;", "iReturn", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod$IReturn;", "toPanelItems", "", "Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem;", "Lorg/json/JSONArray;", "toPanelItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECShowAppletPanelMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f342402e;

    public ECShowAppletPanelMethod() {
        this.f342402e = "flow.ecShowAppletPanel";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f342402e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r210, ECBaseBridgeMethod.a r211) {
        Intrinsics.checkNotNullParameter(r210, "params");
        Intrinsics.checkNotNullParameter(r211, "iReturn");
        Context r100 = getContext();
        if (r100 != null) goto L5;
        r100 = AppHost.f326268a.a().getCurrentActivity();
    L5:
        IECommerceService r101 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r100 == null) goto L41;
        if (r101 == null) goto L41;
        int r102 = i.f522401a;
        String r103 = r210.optString("scene", "");
        JSONArray r104 = r210.optJSONArray("items");
        if (r104 != null) goto L12;
        List r105 = CollectionsKt.emptyList();
    L36:
        JSONObject r106 = r210.optJSONObject("extra");
        if (r106 == null) goto L39;
        a.c(r106);
    L39:
        i.a(r100, r103, r105);
        r211.onSuccess(null);
        return;
    L12:
        int r107 = r104.length();
        ArrayList r108 = new ArrayList(r107);
        int r110 = 0;
    L13:
        if (r110 >= r107) goto L35;
        JSONObject r111 = r104.optJSONObject(r110);
        if (r111 == null) goto L33;
        String r112 = r111.optString("key", "");
        String r113 = r111.optString("title", "");
        String r114 = r111.optString("iconUrl");
        Intrinsics.checkNotNull(r114);
        if ((!StringsKt.isBlank(r114)) == false) goto L19;
        String r115 = r114;
    L20:
        PanelItem r116 = new PanelItem(r112, r113, r111.optInt("order", Integer.MAX_VALUE), null, r115, r111.optInt("line", 1), 8, null);
        JSONObject r117 = r111.optJSONObject("extra");
        if (r117 == null) goto L23;
        Map<String, ? extends Object> r118 = a.c(r117);
    L24:
        r116.setExtra(r118);
        String r119 = r111.optString("jumpUrl");
        Intrinsics.checkNotNull(r119);
        if ((!StringsKt.isBlank(r119)) == true) goto L28;
        r119 = null;
    L28:
        String r120 = r111.optString("clickEventName");
        Intrinsics.checkNotNull(r120);
        if ((true ^ StringsKt.isBlank(r120)) == true) goto L32;
        r120 = null;
    L32:
        r116.setOnClickListener(new d(r119, r120));
    L34:
        r108.add(r116);
        r110 = r110 + 1;
        goto L13
    L23:
        r118 = null;
        goto L24
    L19:
        r115 = null;
        goto L20
    L33:
        r116 = null;
        goto L34
    L35:
        r105 = CollectionsKt.filterNotNull(r108);
    L41:
        r211.onFailed(-1, "context or service is null");
    }
}
