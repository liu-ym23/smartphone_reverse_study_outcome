package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f271305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f271306b;

    static {
        f271305a = true;
        f271306b = new ArrayList();
    }

    public static List a() {
        if (com.bytedance.ug.sdk.luckycat.impl.utils.u.a().d("android_enable_read_common_dimension_white", Boolean.FALSE) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (f271305a == false) goto L25;
        int r100 = 0;
        f271305a = false;
        String r101 = com.bytedance.ug.sdk.luckycat.impl.utils.u.a().c("common_dimension_white", "");
        if (TextUtils.isEmpty(r101) == false) goto L26;
        ArrayList r102 = new ArrayList();
    L23:
        f271306b = r102;
        goto L25
    L26:
        JSONArray r103 = new JSONArray(r101);     // Catch: Exception -> L21
        if (r103.length() > 0) goto L14;
        r102 = new ArrayList();     // Catch: Exception -> L21
        goto L23
    L14:
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L21
        int r105 = r103.length();     // Catch: Exception -> L21
    L15:
        if (r100 >= r105) goto L20;
        String r106 = JSONArrayProtectorUtils.getString(r103, r100);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r106) == true) goto L19;
        r104.add(r106);     // Catch: Exception -> L21
    L19:
        r100 = r100 + 1;
        goto L15
    L20:
        r102 = r104;
    L21:
        e = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("CommonDimensionWhiteManager", "Exception: " + e.getMessage());
        r102 = new ArrayList();
    L25:
        return f271306b;
    }
}
