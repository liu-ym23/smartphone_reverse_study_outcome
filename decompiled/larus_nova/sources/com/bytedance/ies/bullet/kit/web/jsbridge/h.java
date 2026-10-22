package com.bytedance.ies.bullet.kit.web.jsbridge;

import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f247067a;

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final /* synthetic */ void b(c0 r100, int r101) {
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final void c(String r100, String r101, int r102, String r103, o0 r104) {
    }

    public h(f r100) {
        this.f247067a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final void a(String r100, String r101, o0 r110) {
        f r102 = this.f247067a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L57
        List<TimeLineEvent> r111 = r110.f249419c;     // Catch: Throwable -> L57
        Unit r104 = null;
        if (r111 == null) goto L55;
        List<TimeLineEvent> r112 = r111;     // Catch: Throwable -> L57
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r112, 10)), 16));     // Catch: Throwable -> L57
        Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L57
    L7:
        if (r113.hasNext() == false) goto L9;
        Object r106 = r113.next();     // Catch: Throwable -> L57
        r105.put(((TimeLineEvent) r106).getLabel(), r106);     // Catch: Throwable -> L57
        goto L7
    L9:
        TimeLineEvent r114 = (TimeLineEvent) r105.get("label_create_java_call");     // Catch: Throwable -> L57
        if (r114 == null) goto L21;
        HashMap<String, Object> r115 = r114.getExtra();     // Catch: Throwable -> L57
        if (r115 == null) goto L14;
        Object r116 = r115.get("callbackId");     // Catch: Throwable -> L57
    L16:
        if ((r116 instanceof String) == false) goto L18;
        String r117 = (String) r116;     // Catch: Throwable -> L57
    L19:
        if (r117 == null) goto L21;
    L22:
        if (r117 == null) goto L55;
        int r107 = f.f247047s;     // Catch: Throwable -> L57
        com.bytedance.ies.bullet.core.kit.bridge.e r108 = (com.bytedance.ies.bullet.core.kit.bridge.e) ((LinkedHashMap) r102.f247065r).get(r117);     // Catch: Throwable -> L57
        if (r108 != null) goto L26;
        r108 = new com.bytedance.ies.bullet.core.kit.bridge.e();     // Catch: Throwable -> L57
        r102.f247065r.put(r117, r108);     // Catch: Throwable -> L57
    L26:
        TimeLineEvent r109 = (TimeLineEvent) r105.get("label_pre_call_origin_url");     // Catch: Throwable -> L57
        if (r109 == null) goto L33;
        long r118 = r109.getTimeInMillis();     // Catch: Throwable -> L57
        if (r118 > 0) goto L32;
        r118 = System.currentTimeMillis();     // Catch: Throwable -> L57
    L32:
        r108.f246547a = r118;     // Catch: Throwable -> L57
        r108.f246548b = r118;     // Catch: Throwable -> L57
    L33:
        TimeLineEvent r119 = (TimeLineEvent) r105.get("label_call_origin_url");     // Catch: Throwable -> L57
        if (r119 == null) goto L40;
        long r120 = r119.getTimeInMillis();     // Catch: Throwable -> L57
        if (r120 > 0) goto L39;
        r120 = System.currentTimeMillis();     // Catch: Throwable -> L57
    L39:
        r108.f246549c = r120;     // Catch: Throwable -> L57
    L40:
        TimeLineEvent r121 = (TimeLineEvent) r105.get("label_pre_handle_origin_url");     // Catch: Throwable -> L57
        if (r121 == null) goto L48;
        long r122 = r121.getTimeInMillis();     // Catch: Throwable -> L57
        if (r122 > 0) goto L46;
        r122 = System.currentTimeMillis();     // Catch: Throwable -> L57
    L46:
        r108.f246550d = r122;     // Catch: Throwable -> L57
    L48:
        if (r108.a() == false) goto L54;
        r102.f247065r.remove(r117);     // Catch: Throwable -> L57
        Function2<? super String, ? super com.bytedance.ies.bullet.core.kit.bridge.e, Unit> r123 = r102.f247063p;     // Catch: Throwable -> L57
        if (r123 == null) goto L54;
        if (r101 != null) goto L53;
        r101 = "";
    L53:
        r123.invoke(r101, r108);     // Catch: Throwable -> L57
    L54:
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L57
        goto L55
    L18:
        r117 = null;
        goto L19
    L14:
        r116 = null;
    L21:
        r117 = null;
    L55:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L57
        return;
    L57:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
