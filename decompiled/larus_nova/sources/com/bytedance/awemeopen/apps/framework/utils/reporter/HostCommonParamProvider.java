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

/* JADX INFO: loaded from: classes14.dex */
public final class HostCommonParamProvider implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f197742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f197743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f197744c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.infra.base.event.d
    public final JSONObject getParams() {
        JSONObject r100 = this.f197742a;
        if (r100 == null) goto L5;
        JSONObject r101 = new JSONObject();
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<String> r103 = r100.keys();
    L7:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L21;
        String r105 = r103.next();
        if (StringsKt.startsWith$default(r105, "host_", false, 2, null) == true) goto L11;
        r102.put(r105, r100.get(r105).toString());
        goto L7
    L11:
        r101.put(r105, r100.get(r105));
        if (SetsKt.setOf("host_enter_from").contains(r105) == false) goto L14;
    L17:
        if (r104 == true) goto L7;
        r102.put(r105, r100.get(r105).toString());
        goto L7
    L14:
        if (((Set) this.f197744c.getValue()).contains(r105) == true) goto L17;
        r104 = false;
        goto L17
    L21:
        if (this.f197743b == false) goto L23;
    L25:
        return r101;
    L23:
        if ((!r102.isEmpty()) == false) goto L25;
        d14.a r106 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).Z("host pass bad keys:" + CollectionsKt.joinToString$default(r102.keySet(), null, null, null, 0, null, null, 63, null));
        this.f197743b = true;
        goto L25
    L5:
        return new JSONObject();
    }

    public HostCommonParamProvider(JSONObject r100) {
        this.f197742a = r100;
        this.f197744c = LazyKt.lazy(HostCommonParamProvider$whiteListSetting$2.INSTANCE);
    }
}
