package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils;

import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class ContainerUtils implements ICJTag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContainerUtils f202693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f202694b = null;

    public ContainerUtils() {
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "ContainerUtils";
    }

    static {
        f202693a = new ContainerUtils();
        f202694b = LazyKt.lazy(ContainerUtils$xBridgeCollectByService$2.INSTANCE);
    }

    public static a a(IXPayBaseMethod.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return new a(r100);
    }

    public static List b(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L27;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Long) == false) goto L8;
        r101.add(Long.valueOf(r100.optLong(r103)));
    L26:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof Double) == false) goto L11;
        r101.add(Double.valueOf(r100.optDouble(r103)));
        goto L26
    L11:
        if ((r104 instanceof Integer) == false) goto L14;
        r101.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r100, r103)));
        goto L26
    L14:
        if ((r104 instanceof String) == false) goto L17;
        r101.add(r100.optString(r103));
        goto L26
    L17:
        if ((r104 instanceof JSONObject) == false) goto L20;
        r101.add(c(r100.optJSONObject(r103)));
        goto L26
    L20:
        if ((r104 instanceof JSONArray) == false) goto L23;
        r101.add(b(r100.optJSONArray(r103)));
        goto L26
    L23:
        if ((r104 instanceof Boolean) == false) goto L25;
        r101.add(Boolean.valueOf(r100.optBoolean(r103)));
        goto L26
    L25:
        r101.add(null);
        goto L26
    L27:
        return r101;
    }

    public static Map c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L26;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Long) == true) goto L7;
        if ((r104 instanceof Double) == true) goto L10;
        if ((r104 instanceof Integer) == true) goto L13;
        if ((r104 instanceof String) == true) goto L16;
        if ((r104 instanceof JSONObject) == true) goto L19;
        if ((r104 instanceof JSONArray) == true) goto L22;
        if ((r104 instanceof Boolean) == false) goto L4;
        r101.put(r103, Boolean.valueOf(r100.optBoolean(r103)));
        goto L4
    L22:
        r101.put(r103, b(r100.optJSONArray(r103)));
        goto L4
    L19:
        r101.put(r103, c(r100.optJSONObject(r103)));
        goto L4
    L16:
        r101.put(r103, r100.optString(r103));
        goto L4
    L13:
        r101.put(r103, Integer.valueOf(r100.optInt(r103)));
        goto L4
    L10:
        r101.put(r103, Double.valueOf(r100.optDouble(r103)));
        goto L4
    L7:
        r101.put(r103, Long.valueOf(r100.optLong(r103)));
        goto L4
    L26:
        return r101;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }
}
