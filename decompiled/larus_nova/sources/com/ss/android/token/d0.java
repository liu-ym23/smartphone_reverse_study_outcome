package com.ss.android.token;

import android.os.Build;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class d0 {
    public static final Set a() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return ConcurrentHashMap.newKeySet();
    L6:
        return Collections.synchronizedSet(new HashSet());
    }

    public static final JSONObject b(Pair... r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L6
        int r102 = r100.length;     // Catch: JSONException -> L6
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Pair r104 = r100[r103];     // Catch: JSONException -> L6
        r101.put((String) r104.getFirst(), r104.getSecond());     // Catch: JSONException -> L6
        r103 = r103 + 1;
        goto L3
    L11:
        return r101;
    L7:
        return new JSONObject();
    }
}
