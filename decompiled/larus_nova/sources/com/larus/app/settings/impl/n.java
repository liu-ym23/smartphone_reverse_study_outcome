package com.larus.app.settings.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f287038a = null;

    static {
        f287038a = SetsKt.setOf(new Integer[]{0, 1, 2});
    }

    public static final Integer a(t r100) {
        Map<String, u> r101 = r100.a();
        if (r101 == null) goto L6;
        u r102 = r101.get("2");
        if (r102 == null) goto L6;
    L29:
        s r103 = r102.c();
        if (r103 == null) goto L39;
        Integer r104 = r103.a();
        if (r104 == null) goto L39;
        if (f287038a.contains(Integer.valueOf(r104.intValue())) == true) goto L37;
        r104 = null;
    L37:
        if (r104 == null) goto L39;
        return Integer.valueOf(r104.intValue());
    L39:
        String r105 = r102.b();
        if (r105 != null) goto L42;
        return null;
    L42:
        if ((!StringsKt.isBlank(r105)) == true) goto L45;
        r105 = null;
    L45:
        if (r105 == null) goto L76;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L53
        JSONObject r107 = new JSONObject(r105).optJSONObject("portrait_auth");     // Catch: Throwable -> L53
        if (r107 == null) goto L50;
        Integer r108 = Integer.valueOf(r107.optInt("status", -1));     // Catch: Throwable -> L53
    L51:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L53
    L56:
        if (Result.m9455isFailureimpl(r109) == false) goto L58;
        r109 = null;
    L58:
        Integer r110 = (Integer) r109;
        if (r110 != null) goto L61;
        return null;
    L61:
        if (f287038a.contains(Integer.valueOf(r110.intValue())) == true) goto L63;
        return null;
    L63:
        return r110;
    L50:
        r108 = null;
    L53:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L76:
        return null;
    L6:
        Map<String, u> r112 = r100.a();
        if (r112 == null) goto L26;
        Collection<u> r113 = r112.values();
        if (r113 == null) goto L26;
        Iterator<T> r114 = r113.iterator();
    L12:
        if (r114.hasNext() == false) goto L24;
        Object r115 = r114.next();
        u r116 = (u) r115;
        if (r116 == null) goto L21;
        Integer r117 = r116.a();
        if (r117 == null) goto L21;
        if (r117.intValue() != 2) goto L21;
        boolean r118 = true;
    L22:
        if (r118 == false) goto L12;
    L25:
        r102 = (u) r115;
    L27:
        if (r102 != null) goto L29;
        return null;
    L21:
        r118 = false;
        goto L22
    L24:
        r115 = null;
    L26:
        r102 = null;
        goto L27
    }

    public static final boolean b(List r100, int r101) {
        if (r100 == null) goto L28;
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();
        com.larus.uaigc.api.v r104 = (com.larus.uaigc.api.v) r103;
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L6;
    L16:
        com.larus.uaigc.api.v r106 = (com.larus.uaigc.api.v) r103;
        if (r106 != null) goto L20;
        return false;
    L20:
        if (r106.b() != 1) goto L29;
        return true;
    L29:
        return false;
    L10:
        if (r104.a() != r101) goto L12;
        r105 = true;
        goto L13
    L15:
        r103 = null;
        goto L16
    L28:
        return false;
    }
}
