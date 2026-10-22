package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f246212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<String>> f246213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f246214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque<String> f246215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f246216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Integer> f246217g;

    public d(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "entryUrl");
        this.f246211a = r100;
        this.f246212b = new ArrayList();
        this.f246213c = new LinkedHashMap();
        float r102 = 1024;
        this.f246214d = ((r101 / 2) * r102) * r102;
        this.f246215e = new ArrayDeque();
        this.f246217g = new LinkedHashMap();
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "domData");
        String r102 = (String) ListProtector.get(StringsKt.split$default(r100, new String[]{"#"}, false, 0, 6, null), 0);
        if (((ArrayList) this.f246212b).contains(r102) == true) goto L5;
        ((ArrayList) this.f246212b).add(r102);
    L5:
        LinkedHashMap r103 = (LinkedHashMap) this.f246213c;
        Object r104 = r103.get(r102);
        if (r104 != null) goto L8;
        r104 = new ArrayList();
        r103.put(r102, r104);
    L8:
        List r105 = (List) r104;
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull(r105), r101) == false) goto L11;
        return;
    L11:
        r105.add(r101);
        this.f246215e.addLast(r102);
        this.f246216f += r101.length();
    L13:
        if (this.f246216f < this.f246214d) goto L46;
        if ((!this.f246215e.isEmpty()) == false) goto L47;
        if (this.f246213c.size() == 1) goto L19;
    L21:
        String r106 = this.f246215e.removeFirstOrNull();
        if (r106 == null) goto L45;
        List r107 = (List) ((LinkedHashMap) this.f246213c).get(r106);
        if (r107 == null) goto L13;
        if (r107.isEmpty() == true) goto L13;
        String r108 = (String) ListProtector.remove(r107, 0);
        this.f246216f -= r108.length();
        LinkedHashMap r109 = (LinkedHashMap) this.f246217g;
        Object r110 = r109.get(r106);
        if (r110 != null) goto L33;
        r110 = 0;
        r109.put(r106, r110);
    L33:
        this.f246217g.put(r106, Integer.valueOf(((Number) r110).intValue() + 1));
        int r111 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.a("WebDomMonitorJsbInjectProvider", "removeDom: nowCharSize=" + this.f246216f + " > maxTotalDomCharSize=" + this.f246214d + ",remove dom length is " + r108.length() + ",url=" + r106 + tb2.c.DEFAULT_TEXT);
        goto L13
    L45:
        return;
    L19:
        if (((List) ((Map.Entry) CollectionsKt.first(((LinkedHashMap) this.f246213c).entrySet())).getValue()).size() != 1) goto L21;
        return;
    L47:
        return;
    }
}
