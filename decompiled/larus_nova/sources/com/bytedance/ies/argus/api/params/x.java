package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class x extends com.bytedance.ies.argus.strategy.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f245793b;

    public x() {
        this(new LinkedHashMap());
    }

    @Override // com.bytedance.ies.argus.strategy.a
    public final String toString() {
        JSONObject r100 = new JSONObject();
        JSONUtilsKt.d(r100, "rewrite_headers_key", CollectionsKt.joinToString$default(this.f245793b.keySet(), ",", null, null, 0, null, null, 62, null));
        return r100.toString();
    }

    public x(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "rewriteHeaders");
        this.f245793b = r100;
    }

    public final void e(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "headers");
        Iterator<Map.Entry<String, String>> r101 = this.f245793b.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, String> r102 = r101.next();
        String r103 = r102.getKey();
        String r104 = r102.getValue();
        if (r104 == null) goto L7;
        r100.put(r103, r104);
        goto L4
    L7:
        r100.remove(r103);
        goto L4
    }
}
