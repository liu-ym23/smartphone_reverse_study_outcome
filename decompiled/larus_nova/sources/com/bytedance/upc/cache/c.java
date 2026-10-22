package com.bytedance.upc.cache;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f272454a = null;

    static {
        f272454a = new AtomicBoolean(false);
    }

    public static Pair<Boolean, String> b() {
        b r100 = b.f272453c;
        if (r100.a() != null) goto L5;
        String r101 = r100.b("upc_cache_deviceid");
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return new Pair(Boolean.TRUE, r101);
    L11:
        return new Pair(Boolean.FALSE, "");
    L5:
        return new Pair(Boolean.FALSE, "");
    }

    public static Pair<Boolean, String> c() {
        b r100 = b.f272453c;
        if (r100.a() != null) goto L5;
        String r101 = r100.b("upc_cache_imei");
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return new Pair(Boolean.TRUE, r101);
    L11:
        return new Pair(Boolean.FALSE, "");
    L5:
        return new Pair(Boolean.FALSE, "");
    }

    public static void a(Object r100) {
        if ((r100 instanceof String) == false) goto L8;
        String r101 = (String) r100;
        if (TextUtils.isEmpty(r101) == true) goto L21;
        Set<String> r102 = ApiHookRecord.f272434a;
        ApiHookRecord.e("MAC_ADDRESS", r101);
        return;
    L21:
        return;
    L8:
        if ((r100 instanceof byte[]) == false) goto L23;
        byte[] r103 = (byte[]) r100;
        StringBuilder r104 = new StringBuilder();
        int r105 = r103.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L14;
        r104.append(String.format("%02X:", new Object[]{Byte.valueOf(r103[r106])}));
        r106 = r106 + 1;
        goto L11
    L14:
        if (r104.length() <= 0) goto L16;
        r104.deleteCharAt(r104.length() - 1);
    L16:
        String r107 = r104.toString();
        if (TextUtils.isEmpty(r107) == true) goto L24;
        Set<String> r108 = ApiHookRecord.f272434a;
        ApiHookRecord.e("MAC_ADDRESS", r107);
        return;
    L24:
        return;
    }
}
