package com.bytedance.locallife.biz.mob;

import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.locallife.biz.mob.a f256710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f256711b;

    public static final class a {
    }

    static {
    }

    public f(com.bytedance.locallife.biz.mob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "etKit");
        this.f256710a = r100;
        this.f256711b = new LinkedHashMap();
    }

    public final void b(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
        EventType r102 = EventType.CLICK;
        Intrinsics.checkNotNullParameter(r102, "eventType");
        com.bytedance.locallife.common.utils.a.d(this.f256711b, "life_event_type", String.valueOf(r102.getType()));
        c(r100, r101);
    }

    public final void c(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
        Map<String, String> r102 = MapsKt.toMutableMap(r101);
        Iterator r103 = ((LinkedHashMap) this.f256711b).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        com.bytedance.locallife.common.utils.a.d(r102, r104.getKey(), r104.getValue());
        goto L4
    L6:
        this.f256710a.a(r100, r102);
    }

    public static void a(f r100, View r101, String r102, boolean r103, boolean r104, int r105) {
        int r106 = 0;
        if ((r105 & 8) == 0) goto L6;
        r104 = false;
    L6:
        if ((r105 & 16) == 0) goto L8;
        r106 = -1;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "abcd");
        com.bytedance.locallife.biz.btm.b.a r107 = new com.bytedance.locallife.biz.btm.b.a(r102, Boolean.valueOf(r103));
        r107.b(r101);
        r107.f256558c.setAddBtmChain(r104);
        if (r104 == false) goto L12;
        if (r106 <= (-1)) goto L12;
        r107.f256558c.setBtmChainLength(r106);
    L12:
        JSONObject r108 = r107.a();
        Iterator<String> r109 = r108.keys();
    L14:
        if (r109.hasNext() == false) goto L16;
        String r110 = r109.next();
        com.bytedance.locallife.common.utils.a.d(r100.f256711b, r110, r108.optString(r110));
        goto L14
    }
}
