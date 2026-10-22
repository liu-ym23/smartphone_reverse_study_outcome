package com.bytedance.sdk.account.utils;

import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static Map<String, String> a(List<Pair<String, String>> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator<Pair<String, String>> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        Pair<String, String> r103 = r102.next();
        if (TextUtils.isEmpty((CharSequence) r103.first) == true) goto L7;
        if (TextUtils.isEmpty((CharSequence) r103.second) == true) goto L7;
        r101.put(r103.first, r103.second);
        goto L7
    L13:
        return r101;
    }
}
