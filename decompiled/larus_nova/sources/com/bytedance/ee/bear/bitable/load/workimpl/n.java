package com.bytedance.ee.bear.bitable.load.workimpl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class n extends b {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.load.workimpl.b
    public final JSONObject n() {
        JSONObject r100 = new JSONObject();
        zt4.g r101 = (zt4.g) this.f214440a.e(zt4.g.class);
        if (r101 == null) goto L6;
        int r102 = zt4.g.f573593f;
        String r103 = r101.f573594e;
        r101.f573594e = null;
        if (r103 == null) goto L6;
    L7:
        r100.put("cacheRecordData", r103);
        tt5.a.h("RenderRecordWork", "getExtraParams cacheRecordData " + r103.length());
        this.f214440a.h("is_native_cache_render", Boolean.valueOf(com.larksuite.component.card.utils.k.b(r103)));
        return r100;
    L6:
        r103 = "";
        goto L7
    }

    public n(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
    }
}
