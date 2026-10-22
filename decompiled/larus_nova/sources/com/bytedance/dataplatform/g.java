package com.bytedance.dataplatform;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static Map a(Context r100) {
        SharedPreferences r101 = c(r100, "CLIENT_EXPERIMENT_CACHE_TAG");
        ConcurrentHashMap r102 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, ?>> r103 = r101.getAll().entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, ?> r104 = r103.next();
        if ((r104.getValue() instanceof Integer) == false) goto L4;
        r102.put(r104.getKey(), (Integer) r104.getValue());
        goto L4
    L8:
        return r102;
    }

    public static Map<String, String> b(Context r100, String r101) {
        SharedPreferences r102 = c(r100, r101);
        ConcurrentHashMap r103 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, ?>> r104 = r102.getAll().entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, ?> r105 = r104.next();
        if ((r105.getValue() instanceof String) == false) goto L4;
        r103.put(r105.getKey(), (String) r105.getValue());
        goto L4
    L8:
        return r103;
    }

    public static SharedPreferences c(Context r100, String r101) {
        return r100.getSharedPreferences(r101, 0);
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        return r100.createDeviceProtectedStorageContext().getSharedPreferences(r101, 0);
    L10:
        throw new RuntimeException("abtest SharedPreferences :" + r101);
    }

    public static Set d(Context r100, String r101) {
        return new ConcurrentSkipListSet(c(r100, "SP_EXPERIMENT_CACHE").getStringSet(r101, new ConcurrentSkipListSet()));
    }
}
