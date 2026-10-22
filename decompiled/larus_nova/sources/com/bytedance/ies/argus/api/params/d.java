package com.bytedance.ies.argus.api.params;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends com.bytedance.ies.argus.strategy.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f245733b;

    public d() {
        this.f245733b = CollectionsKt.emptyList();
    }

    public final void e(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "original");
        ArrayList r100 = new ArrayList();
        Iterator<String> r101 = this.f245733b.iterator();
    L4:
        if (r101.hasNext() == false) goto L28;
        String r102 = r101.next();
        boolean r111 = false;
        List r103 = StringsKt.split$default(r102, new char[]{'.'}, false, 0, 6, null);
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L13;
        String r106 = (String) r105.next();
        if (r106 == null) goto L12;
        r104.add(StringsKt.trim(r106).toString());
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L13:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r104.iterator();
    L15:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();
        if (((String) r109).length() <= 0) goto L19;
        boolean r112 = true;
    L20:
        if (r112 == false) goto L15;
        r107.add(r109);
        goto L15
    L19:
        r112 = false;
        goto L20
    L23:
        if (r107.isEmpty() == true) goto L26;
        r111 = f(r110, r107, 0);
    L26:
        if (r111 == false) goto L4;
        r100.add(r102);
        goto L4
    L28:
        Intrinsics.checkNotNullParameter(r110, "newValue");
    }

    public static boolean f(Object r100, List r101, int r102) {
        boolean r103 = false;
        int r104 = 0;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r102 < ((ArrayList) r101).size()) goto L8;
        return false;
    L8:
        if ((r100 instanceof JSONArray) == false) goto L14;
        JSONArray r105 = (JSONArray) r100;
        int r106 = r105.length();
        boolean r107 = false;
    L10:
        if (r104 >= r106) goto L12;
        r107 = r107 | f(r105.opt(r104), r101, r102);
        r104 = r104 + 1;
        goto L10
    L12:
        return r107;
    L14:
        if ((r100 instanceof List) == false) goto L20;
        Iterator r108 = ((List) r100).iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        r103 = r103 | f(r108.next(), r101, r102);
        goto L17
    L19:
        return r103;
    L20:
        String r109 = (String) ListProtector.get(r101, r102);
        if (r102 != CollectionsKt.getLastIndex(r101)) goto L23;
        boolean r110 = true;
    L25:
        if ((r100 instanceof JSONObject) == false) goto L40;
        if (r110 == false) goto L36;
        JSONObject r111 = (JSONObject) r100;
        if (r111.has(r109) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual("", "") == false) goto L33;
        r111.remove(r109);
    L34:
        return true;
    L33:
        r111.put(r109, "");
        goto L34
    L36:
        return f(((JSONObject) r100).opt(r109), r101, r102 + 1);
    L40:
        return false;
    L23:
        r110 = false;
        goto L25
    }
}
