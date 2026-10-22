package com.obric.oui.material;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f401494a = 0;

    static {
    }

    public static Object a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r101, "tokens");
        if (r100 == null) goto L7;
        String r102 = r100.toLowerCase(Locale.ROOT);
        if (r102 == null) goto L7;
        String r103 = StringsKt.trim(r102).toString();
    L9:
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        return null;
    L18:
        return r101.get(r103);
    L11:
        if (r103.length() == 0) goto L14;
        r104 = false;
    L7:
        r103 = null;
        goto L9
    }

    public static void b(Map r100, Map r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tokenMap");
        Intrinsics.checkNotNullParameter(r101, "customTokens");
        if (r101.isEmpty() == false) goto L6;
        return;
    L6:
        if (r102 == false) goto L16;
        Iterator r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L27;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        Object r106 = r104.getValue();
        String r107 = StringsKt.trim(r105.toLowerCase(Locale.ROOT)).toString();
        if (r107.length() <= 0) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L9;
        r100.put(r107, r106);
        goto L9
    L13:
        r108 = false;
        goto L14
    L27:
        return;
    L16:
        Iterator r109 = r101.entrySet().iterator();
    L18:
        if (r109.hasNext() == false) goto L40;
        Map.Entry r110 = (Map.Entry) r109.next();
        String r111 = (String) r110.getKey();
        Object r112 = r110.getValue();
        String r113 = StringsKt.trim(r111.toLowerCase(Locale.ROOT)).toString();
        if (r113.length() <= 0) goto L22;
        boolean r114 = true;
    L23:
        if (r114 == false) goto L18;
        if (r100.containsKey(r113) == true) goto L18;
        r100.put(r113, r112);
        goto L18
    L22:
        r114 = false;
        goto L23
    }
}
