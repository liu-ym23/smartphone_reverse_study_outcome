package com.bytedance.badger.v;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends e {
    public j(d r100, Function0 r101) {
        super(r100, "disable_compensation_types", r101);
    }

    @Override // com.bytedance.badger.v.e
    public final Object b(JSONObject r100, String r101, Object r102) {
        Collection r103 = (Collection) r102;
        JSONArray r104 = r100.optJSONArray(r101);
        if (r104 == null) goto L16;
        LinkedHashSet r105 = new LinkedHashSet();
        int r106 = r104.length();
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L17;
        Object r108 = r104.opt(r107);
        if ((r108 instanceof Number) == false) goto L10;
        Integer r109 = Integer.valueOf(((Number) r108).intValue());
    L13:
        if (r109 == null) goto L15;
        r105.add(r109);
    L15:
        r107 = r107 + 1;
        goto L5
    L10:
        if ((r108 instanceof String) == false) goto L12;
        r109 = StringsKt.toIntOrNull((String) r108);
        goto L13
    L12:
        r109 = null;
    L17:
        return r105;
    L16:
        r105 = new LinkedHashSet(r103);
        goto L17
    }
}
