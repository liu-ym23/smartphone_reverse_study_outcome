package com.bytedance.kmp.ec.yata.event.ability.request;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.platform.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f251614e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final YataStoreWrapper f251615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f251616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f251617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Object> f251618d;

    public static final class a {
    }

    static {
    }

    public b(YataStoreWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "storeWrapper");
        this.f251615a = r100;
    }

    public static String a(String r100, Map r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L25;
        int r103 = h.f251540a;
        LinkedHashMap r104 = null;
        if (r101 == null) goto L21;
        LinkedHashMap r105 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r106 = r101.entrySet().iterator();
    L13:
        if (r106.hasNext() == false) goto L19;
        Map.Entry r107 = (Map.Entry) r106.next();
        Object r108 = r107.getKey();
        Object r109 = r107.getValue();
        if (r109 == null) goto L17;
        String r110 = r109.toString();
    L18:
        r105.put(r108, r110);
        goto L13
    L17:
        r110 = null;
        goto L18
    L19:
        r104 = r105;
    L21:
        return h.a(r100, r104);
    L25:
        return r100;
    L4:
        if (r101.isEmpty() == true) goto L7;
        r102 = false;
        goto L8
    }
}
