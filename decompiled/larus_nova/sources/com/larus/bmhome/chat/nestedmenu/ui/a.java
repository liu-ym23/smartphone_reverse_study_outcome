package com.larus.bmhome.chat.nestedmenu.ui;

import com.larus.bmhome.view.screenmenu.l0;
import di8.d0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f308317a = 0;

    static {
    }

    public static List a(LinkedHashMap r110, int r111, LinkedHashMap r112) {
        Intrinsics.checkNotNullParameter(r110, "sections");
        Intrinsics.checkNotNullParameter(r112, "clickSections");
        ArrayList r100 = new ArrayList();
        Set r101 = r110.entrySet();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L22;
        Object r104 = r103.next();
        Map.Entry r105 = (Map.Entry) r104;
        Intrinsics.checkNotNull(r105);
        List r106 = (List) r105.getValue();
        if ((r106 instanceof Collection) == true) goto L8;
    L10:
        Iterator r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L19;
        if (com.larus.bmhome.chat.nestedmenu.e.a((d0) r107.next()) == null) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L12;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L4;
        r102.add(r104);
        goto L4
    L16:
        r108 = false;
    L19:
        r109 = false;
        goto L20
    L8:
        if (r106.isEmpty() == false) goto L10;
    L22:
        Iterator r113 = r102.iterator();
        int r114 = 0;
        int r115 = 0;
    L24:
        if (r113.hasNext() == false) goto L42;
        Object r116 = r113.next();
        int r117 = r114 + 1;
        if (r114 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        Map.Entry r118 = (Map.Entry) r116;
        Intrinsics.checkNotNull(r118);
        String r119 = (String) r118.getKey();
        Iterator r120 = ((List) r118.getValue()).iterator();
    L30:
        if (r120.hasNext() == false) goto L38;
        d0 r121 = (d0) r120.next();
        l0 r122 = com.larus.bmhome.chat.nestedmenu.e.a(r121);
        q.a r123 = null;
        if (r122 == null) goto L35;
        r123 = new q.a(r119, r112, r121, l0.b(r122, r115, null, false, -2));
        r115 = r115 + 1;
    L35:
        if (r123 == null) goto L30;
        r100.add(r123);
        goto L30
    L38:
        if (r114 == (r102.size() - 1)) goto L41;
        if (r111 <= 0) goto L41;
        r100.add(new q.b(r111));
    L41:
        r114 = r117;
        goto L24
    L42:
        return r100;
    }
}
