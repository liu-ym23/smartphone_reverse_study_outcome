package com.bytedance.ies.tools.prefetch;

import com.larus.platform.model.SlashMentionConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f248830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f248831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f248832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, a0> f248833d;

    public u() {
        throw null;
    }

    public u(JSONObject r100) {
        String r101 = r100.optString(SlashMentionConfig.SLASH_CONTENT_PROJECT);
        r100.optString("version");
        JSONObject r102 = r100.optJSONObject("occasions");
        if (r102 == null) goto L8;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<String> r104 = r102.keys();
    L6:
        if (r104.hasNext() == false) goto L8;
        String r105 = r104.next();
        r103.put(r105, g0.d(r102.optJSONArray(r105)));
    L8:
        JSONObject r106 = r100.optJSONObject("rules");
        b0 r107 = null;
        if (r106 == null) goto L11;
        r r108 = new r(r106);
    L12:
        JSONObject r109 = r100.optJSONObject("restful_rules");
        if (r109 == null) goto L15;
        r107 = new b0(r109);
    L15:
        LinkedHashMap r110 = new LinkedHashMap();
        JSONObject r111 = r100.optJSONObject("prefetch_apis");
        if (r111 == null) goto L24;
        Iterator<String> r112 = r111.keys();
        if (r112 == null) goto L24;
    L20:
        if (r112.hasNext() == false) goto L24;
        String r113 = r112.next();
        JSONObject r114 = r111.optJSONObject(r113);
        if (r114 == null) goto L20;
        a0 r115 = (a0) r110.put(r113, new a0(r114));
    L24:
        this.f248830a = r101;
        this.f248831b = r108;
        this.f248832c = r107;
        this.f248833d = r110;
        return;
    L11:
        r108 = null;
        goto L12
    }
}
