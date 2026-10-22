package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends a<com.bytedance.android.shopping.anchorv4.voavhs.headv2.j> {
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.b a;
    public final Context b;
    public final s c;

    public final Context getContext() {
        return this.b;
    }

    public c(Context r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final void l(Object r13, int r14, Integer r15) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.j r16 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.j) r13;
        Intrinsics.checkNotNullParameter(r16, "data");
        if (this.a != null) goto L31;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.b r17 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.b(this.b, this.c.rR());
        this.a = r17;
        Intrinsics.checkNotNullParameter(r16, "data");
        if (r17.a != null) goto L28;
        r17.b = r16;
        String r18 = r16.e();
        LinkedHashMap r2 = new LinkedHashMap();
        Map<String, String> r19 = r16.b();
        if (r19 == null) goto L14;
        Set<Map.Entry<String, String>> r110 = r19.entrySet();
        if (r110 == null) goto L14;
        Iterator<T> r111 = r110.iterator();
    L12:
        if (r111.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) r111.next();
        r2.put(r0.getKey(), r0.getValue());
    L14:
        LinkedTreeMap<String, Object> r112 = r17.c.getTrackMeta();
        if (r112 == null) goto L17;
        r2.put("pdp_track_meta", MapsKt.toMap(r112));
    L17:
        CommonMeta r113 = r17.c.r0();
        if (r113 == null) goto L20;
        String r114 = r113.getEntranceInfo();
    L21:
        if (r114 == null) goto L23;
        r2.put("entrance_info", r114);
    L23:
        r2.put("pdp_session_id", r17.c.getSessionId());
        Context r1 = r17.getContext();
        if (r18 != null) goto L26;
        String r3 = "";
    L27:
        r17.a = ECLiveHybridUtil.b(r1, r3, r2, r17, null, null, null, false, null, null, false, 4080);
        goto L28
    L26:
        r3 = r18;
        goto L27
    L20:
        r114 = null;
    L28:
        this.c.eh().h(true);
        return;
    }
}
