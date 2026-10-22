package com.bytedance.locallife.hybrid.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a0 extends mt6.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f258995b;

    public static final class a {
    }

    static {
    }

    public a0() {
        this.f258995b = "sendLog";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f258995b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r110, Map<String, ? extends Object> r210, IDLXBridgeMethod.a r211) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r210, "params");
        Intrinsics.checkNotNullParameter(r211, "callback");
        if (r210.isEmpty() == false) goto L5;
        b.a(r211, "params is empty");
        return;
    L5:
        Object r100 = r210.get("eventName");
        String r101 = null;
        if ((r100 instanceof String) == false) goto L8;
        String r102 = (String) r100;
    L9:
        Object r103 = r210.get("labelName");
        if ((r103 instanceof String) == false) goto L12;
        String r111 = (String) r103;
    L13:
        Object r104 = r210.get("value");
        if ((r104 instanceof String) == false) goto L16;
        String r105 = (String) r104;
    L18:
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        Object r106 = r210.get("extValue");
        if ((r106 instanceof String) == false) goto L23;
        String r107 = (String) r106;
    L24:
        if (r107 != null) goto L26;
        r107 = "";
    L26:
        Object r108 = r210.get("extJson");
        if ((r108 instanceof JSONObject) == false) goto L29;
        JSONObject r112 = (JSONObject) r108;
    L30:
        if (r112 == null) goto L32;
        r101 = r112.optString("category");
    L32:
        if (r101 != null) goto L34;
        String r109 = "";
    L36:
        if (TextUtils.isEmpty(r105) == true) goto L38;
        long r113 = CastLongProtector.parseLong(r105);
    L40:
        if (TextUtils.isEmpty(r107) == true) goto L42;
        long r114 = CastLongProtector.parseLong(r107);
    L43:
        Context r115 = ou6.b.f526748a.getContext(r110);
        if (r115 == null) goto L46;
        HostServiceUtilsKt.m0().c(r115, r109, r102, r111, r113, r114, r112);
        b.b(r211, "");
        return;
    L46:
        b.a(r211, "context is null");
        return;
    L42:
        r114 = 0;
        goto L43
    L38:
        r113 = 0;
        goto L40
    L34:
        r109 = r101;
        goto L36
    L29:
        r112 = null;
        goto L30
    L23:
        r107 = null;
        goto L24
    L16:
        r105 = null;
        goto L18
    L12:
        r111 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    }
}
