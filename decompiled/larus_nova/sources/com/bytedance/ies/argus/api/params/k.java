package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class k extends com.bytedance.ies.argus.strategy.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f245764b;

    public k() {
        this.f245764b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ConcurrentHashMap<String, String> r101 = this.f245764b;
        ArrayList r102 = new ArrayList(r101.size());
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r103.next();
        r102.add(new Pair(r104.getKey(), CommonUtils.p(r104.getValue())));
        goto L4
    L6:
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator r106 = r102.iterator();
    L8:
        if (r106.hasNext() == false) goto L11;
        Pair r107 = (Pair) r106.next();
        Pair r108 = TuplesKt.to(r107.getFirst(), r107.getSecond());
        r105.put(r108.getFirst(), r108.getSecond());
        goto L8
    L11:
        if ((!r105.isEmpty()) == true) goto L14;
        r105 = null;
    L14:
        JSONObject r109 = new JSONObject();
        JSONUtilsKt.d(r109, "inject_js_code", r105);
        return r109;
    }
}
