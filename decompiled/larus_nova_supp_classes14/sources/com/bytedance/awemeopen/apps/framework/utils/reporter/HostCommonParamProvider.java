package com.bytedance.awemeopen.apps.framework.utils.reporter;

import com.bytedance.awemeopen.infra.base.event.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HostCommonParamProvider implements d {
    public final JSONObject a;
    public boolean b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public final JSONObject getParams() {
        JSONObject r0 = this.a;
        if (r0 == null) goto L5;
        JSONObject r1 = new JSONObject();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<String> r3 = r0.keys();
    L7:
        boolean r5 = true;
        if (r3.hasNext() == false) goto L21;
        String r4 = r3.next();
        if (StringsKt.startsWith$default(r4, "host_", false, 2, null) == true) goto L11;
        r2.put(r4, r0.get(r4).toString());
        goto L7
    L11:
        r1.put(r4, r0.get(r4));
        if (SetsKt.setOf("host_enter_from").contains(r4) == false) goto L14;
    L17:
        if (r5 == true) goto L7;
        r2.put(r4, r0.get(r4).toString());
        goto L7
    L14:
        if (((Set) this.c.getValue()).contains(r4) == true) goto L17;
        r5 = false;
        goto L17
    L21:
        if (this.b == false) goto L23;
    L25:
        return r1;
    L23:
        if ((!r2.isEmpty()) == false) goto L25;
        d14.a r6 = b14.a.a;
        b14.a.a(t24.a.class).Z("host pass bad keys:" + CollectionsKt.joinToString$default(r2.keySet(), null, null, null, 0, null, null, 63, null));
        this.b = true;
        goto L25
    L5:
        return new JSONObject();
    }

    public HostCommonParamProvider(JSONObject r1) {
        this.a = r1;
        this.c = LazyKt.lazy(HostCommonParamProvider$whiteListSetting$2.INSTANCE);
    }
}
