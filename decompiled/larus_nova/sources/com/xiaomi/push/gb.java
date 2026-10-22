package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class gb {
    private static void a(Context r100, gi r101) {
        if (r101.f625a == false) goto L6;
        r101.a("push_sdk_channel");
    L6:
        if (TextUtils.isEmpty(r101.d()) == false) goto L8;
        r101.f(com.xiaomi.push.service.az.a());
    L8:
        r101.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(r101.e()) == false) goto L12;
        r101.e(r100.getPackageName());
    L12:
        if (TextUtils.isEmpty(r101.c()) == false) goto L15;
        r101.e(r101.e());
        return;
    }

    private static HashMap<String, ArrayList<gi>> a(Context r100, List<gi> r101) {
        if (r101 != null) goto L4;
        return null;
    L4:
        if (r101.size() == 0) goto L19;
        HashMap<String, ArrayList<gi>> r102 = new HashMap();
        Iterator<gi> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        gi r104 = r103.next();
        a(r100, r104);
        ArrayList<gi> r105 = r102.get(r104.c());
        if (r105 != null) goto L12;
        r105 = new ArrayList();
        r102.put(r104.c(), r105);
    L12:
        r105.add(r104);
        goto L8
    L13:
        return r102;
    L19:
        return null;
    }

    private static void a(Context r100, gd r101, HashMap<String, ArrayList<gi>> r102) {
        Iterator<Map.Entry<String, ArrayList<gi>>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, ArrayList<gi>> r104 = r103.next();
        ArrayList<gi> r105 = r104.getValue();     // Catch: Exception -> L13
        if (r105 == null) goto L4;
        if (r105.size() == 0) goto L4;
        r101.a(r105, ((gi) ListProtector.get(r105, 0)).e(), r104.getKey());     // Catch: Exception -> L13
        goto L4
    }

    public static void a(Context r100, gd r101, List<gi> r102) {
        HashMap<String, ArrayList<gi>> r103 = a(r100, r102);
        if (r103 != null) goto L5;
    L9:
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
        return;
    L5:
        if (r103.size() == 0) goto L9;
        a(r100, r101, r103);
    }
}
