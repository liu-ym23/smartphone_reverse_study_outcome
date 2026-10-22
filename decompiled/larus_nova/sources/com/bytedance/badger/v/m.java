package com.bytedance.badger.v;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends e {
    public m(v r100, String r101, Function0 r102) {
        super(r100, r101, r102);
    }

    @Override // com.bytedance.badger.v.e
    public final Object b(JSONObject r100, String r101, Object r102) {
        Collection r103 = (Collection) r102;
        JSONArray r104 = r100.optJSONArray(r101);
        if (r104 == null) goto L7;
        LinkedHashSet r105 = new LinkedHashSet();
        int r106 = r104.length();
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L8;
        r105.add(r104.optString(r107));
        r107 = r107 + 1;
    L8:
        return r105;
    L7:
        r105 = new LinkedHashSet(r103);
        goto L8
    }
}
