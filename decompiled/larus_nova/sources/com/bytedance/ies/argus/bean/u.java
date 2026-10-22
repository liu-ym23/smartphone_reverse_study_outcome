package com.bytedance.ies.argus.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f246050d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestCheckAction f246051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, ArrayList<String>> f246052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<String>> f246053c;

    public static final class a {
    }

    static {
    }

    public u() {
        throw null;
    }

    public u(Map r110, t06.k r111) {
        this.f246051a = RequestCheckAction.DISABLE;
        this.f246052b = new HashMap();
        this.f246053c = new HashMap();
        Object r100 = r110.get("action");
        if (r100 != null) goto L5;
        r100 = "disable";
    L5:
        RequestCheckAction[] r101 = RequestCheckAction.values();
        int r102 = r101.length;
        int r103 = 0;
    L6:
        Map r104 = null;
        if (r103 >= r102) goto L12;
        RequestCheckAction r105 = r101[r103];
        if (Intrinsics.areEqual(r105.getValue(), r100.toString()) == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r105 == null) goto L15;
        this.f246051a = r105;
    L15:
        Map<String, Map<String, Object>> r112 = r111.b();
        if (r112 != null) goto L18;
        r112 = new HashMap();
    L18:
        Object r113 = r110.get("settings");
        if ((r113 instanceof Map) == false) goto L21;
        r104 = (Map) r113;
    L21:
        if (r104 == null) goto L41;
        Iterator r114 = r104.entrySet().iterator();
    L24:
        if (r114.hasNext() == false) goto L57;
        Map.Entry r106 = (Map.Entry) r114.next();
        Object r107 = r106.getKey();
        Object r108 = r106.getValue();
        if ((r107 instanceof String) == false) goto L24;
        ArrayList<String> r109 = new ArrayList();
        ArrayList<String> r115 = new ArrayList();
        if ((r108 instanceof String) == true) goto L30;
        if ((r108 instanceof List) == false) goto L24;
        Iterator r116 = ((List) r108).iterator();
    L35:
        if (r116.hasNext() == false) goto L40;
        Object r117 = r116.next();
        if ((r117 instanceof String) == false) goto L35;
        String r118 = (String) r117;
        r109.addAll(a(true, r118, r112));
        r115.addAll(a(false, r118, r112));
    L40:
        this.f246052b.put((String) r107, r109);
        this.f246053c.put((String) r107, r115);
        goto L24
    L30:
        String r119 = (String) r108;
        r109.addAll(a(true, r119, r112));
        r115.addAll(a(false, r119, r112));
        goto L40
    L57:
        return;
    L41:
        return;
    L12:
        r105 = null;
        goto L13
    }

    public static List a(boolean r100, String r101, Map r102) {
        if (r102.isEmpty() == true) goto L53;
        boolean r103 = false;
        if (r101.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L53;
        Object r105 = r102.get(r101);
        List r106 = null;
        if ((r105 instanceof Map) == false) goto L13;
        Map r107 = (Map) r105;
    L14:
        if (r107 == null) goto L51;
        if (r100 == false) goto L17;
        String r108 = "match_reg";
    L18:
        Object r109 = r107.get(r108);
        if ((r109 instanceof String) == false) goto L21;
        String r110 = (String) r109;
    L22:
        if (r110 != null) goto L24;
        Object r111 = r107.get(r108);
        if ((r111 instanceof List) == false) goto L33;
        r106 = (List) r111;
    L33:
        if (r106 == null) goto L51;
        ArrayList r112 = new ArrayList();
        Iterator r113 = r106.iterator();
    L36:
        if (r113.hasNext() == false) goto L40;
        Object r114 = r113.next();
        if ((r114 instanceof String) == false) goto L36;
        r112.add(r114);
        goto L36
    L40:
        ArrayList r115 = new ArrayList();
        Iterator r116 = r112.iterator();
    L42:
        if (r116.hasNext() == false) goto L49;
        Object r117 = r116.next();
        if (((String) r117).length() <= 0) goto L46;
        boolean r118 = true;
    L47:
        if (r118 == false) goto L42;
        r115.add(r117);
        goto L42
    L46:
        r118 = false;
        goto L47
    L49:
        return r115;
    L24:
        if (r110.length() <= 0) goto L26;
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        return CollectionsKt.listOf(r110);
    L29:
        return CollectionsKt.emptyList();
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = "exclude_reg";
    L51:
        return CollectionsKt.emptyList();
    L13:
        r107 = null;
        goto L14
    L7:
        r104 = false;
    L53:
        return CollectionsKt.emptyList();
    }
}
