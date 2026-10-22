package com.bytedance.ies.argus.repository;

import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends BaseConfigProvider<f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f246125e;

    public g(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        super(r100);
    }

    public final e c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cId");
        f r101 = this.f246125e;
        if (r101 == null) goto L7;
        Map<String, e> r102 = r101.f246120a;
        if (r102 == null) goto L7;
        return r102.get(r100);
    L7:
        return null;
    }

    @Override // com.bytedance.ies.argus.repository.BaseConfigProvider
    public final f a(JSONObject r100, c r110) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r110, "info");
        JSONObject r101 = r100.optJSONObject("const_conf");
        JSONObject r102 = r100.optJSONObject("conf");
        if (r102 != null) goto L6;
        f r103 = new f(0);
    L21:
        this.f246125e = r103;
        return r103;
    L6:
        if (r101 == null) goto L8;
        Lazy r104 = ArgusGsonUtils.f246245a;
        com.bytedance.ies.argus.bean.config.e r105 = (com.bytedance.ies.argus.bean.config.e) ArgusGsonUtils.c(r101, com.bytedance.ies.argus.bean.config.e.class);
    L9:
        Lazy<ArgusEnv> r106 = ArgusEnv.f245917d;
        ArgusEnv.b.a().getClass();
        LinkedHashMap r107 = new LinkedHashMap();
        JSONObject r108 = r102.optJSONObject("host");
        e r109 = e.a.a("host", r108, null);
        if (r109 == null) goto L12;
        r107.put("host", r109);
    L12:
        Iterator<String> r111 = r102.keys();
    L14:
        if (r111.hasNext() == false) goto L20;
        String r112 = r111.next();
        if (Intrinsics.areEqual(r112, "host") == true) goto L14;
        e r113 = e.a.a(r112, r102.optJSONObject(r112), r108);
        if (r113 == null) goto L14;
        r107.put(r112, r113);
        goto L14
    L20:
        r103 = new f(MapsKt.toMap(r107), r105, r110.f246111d, r110.f246112e, r110.f246110c);
        goto L21
    L8:
        r105 = null;
        goto L9
    }
}
