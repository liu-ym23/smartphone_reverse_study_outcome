package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class ad extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ad f462537b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.vivo.push.f.a f462538d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, byte[]> f462539c;

    public static synchronized ad c() {
        monitor-enter(ad.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f462537b != null) goto L8;
        f462537b = new ad();     // Catch: Throwable -> L13
    L8:
        if (f462538d != null) goto L10;
        f462538d = new com.vivo.push.f.a();     // Catch: Throwable -> L13
    L10:
        ad r100 = f462537b;     // Catch: Throwable -> L13
        monitor-exit(ad.class);
        return r100;
    }

    public final byte[] d() {
        byte[] r100 = this.f462539c.get("com.vivo.push.c");
        if (r100 == null) goto L7;
        if (r100.length <= 0) goto L7;
        return r100;
    L7:
        return f462538d.a(this.f462567a);
    }

    public final byte[] e() {
        byte[] r100 = this.f462539c.get("com.vivo.push.d");
        if (r100 == null) goto L7;
        if (r100.length <= 0) goto L7;
        return r100;
    L7:
        return f462538d.b(this.f462567a);
    }

    public ad() {
        this.f462539c = new ConcurrentHashMap();
    }

    private synchronized void b(Context r100) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (b(CloudControlInf.DATA_CLEAR) == true) goto L17;
        if (r100 == null) goto L17;
        Iterator<Map.Entry<String, ?>> r101 = a().getAll().entrySet().iterator();     // Catch: Throwable -> L19
    L8:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next().getKey();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r102) == true) goto L8;
        if (r102.contains("_sub_") == true) goto L15;
        if (r102.contains("_cache_") == false) goto L8;
    L15:
        c(r102);     // Catch: Throwable -> L19
        goto L8
    L16:
        t.c("SharePreferenceManager", " old data clear ");     // Catch: Throwable -> L19
        a(CloudControlInf.DATA_CLEAR);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
    }

    private static byte[] d(String r100) {
        byte[] r101 = null;
        String[] r102 = r100.split(",");     // Catch: Exception -> L10
        int r103 = 0;
        if (r102.length <= 0) goto L6;
        r101 = new byte[r102.length];     // Catch: Exception -> L10
        int r104 = r102.length;     // Catch: Exception -> L10
    L7:
        if (r103 >= r104) goto L12;
        r101[r103] = CastByteProtector.parseByte(r102[r103].trim());     // Catch: Exception -> L10
        r103 = r103 + 1;
    L12:
        return r101;
    L6:
        r104 = 0;
    L10:
        e = move-exception;
        t.a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
        goto L12
    }

    private List<String> e(String r110) {
        if (this.f462567a != null) goto L6;
        t.c("SharePreferenceManager", " parsLocalIv error mContext is null ");
        return null;
    L6:
        ArrayList r100 = new ArrayList();
        Context r101 = this.f462567a;     // Catch: Exception -> L24
        Object r111 = ah.a(r101, r101.getPackageName(), r110);     // Catch: Exception -> L24
        if (r111 != null) goto L10;
        return null;
    L10:
        String r102 = new String(Base64.decode(r111.toString(), 2));     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r102) == false) goto L13;
        return null;
    L13:
        String[] r112 = r102.split(",#@");     // Catch: Exception -> L24
        if (r112 != null) goto L16;
    L23:
        return null;
    L16:
        if (r112.length < 4) goto L23;
        int r103 = r112.length;     // Catch: Exception -> L24
        int r104 = 0;
    L19:
        if (r104 >= r103) goto L21;
        r100.add(r112[r104].replace(",#@", ""));     // Catch: Exception -> L24
        r104 = r104 + 1;     // Catch: Exception -> L24
        goto L19
    L21:
        if (r100.size() < 4) goto L23;
    L26:
        return r100;
    L24:
        e = move-exception;
        t.c("SharePreferenceManager", " parsLocalIv error e =" + e.getMessage());
        goto L26
    }

    public final synchronized void a(Context r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f462567a != null) goto L13;
        this.f462567a = r100;     // Catch: Throwable -> L15
        a(r100, "com.vivo.push_preferences");     // Catch: Throwable -> L15
        List<String> r101 = e("local_iv");     // Catch: Throwable -> L15
        if (r101 != null) goto L8;
    L11:
        t.a("SharePreferenceManager", " initSecureCode error list is null ");     // Catch: Throwable -> L15
    L12:
        b(this.f462567a);     // Catch: Throwable -> L15
        goto L13
    L8:
        if (r101.size() < 4) goto L11;
        this.f462539c.put("com.vivo.push.a", d((String) ListProtector.get(r101, 1)));     // Catch: Throwable -> L15
        this.f462539c.put("com.vivo.push.b", d((String) ListProtector.get(r101, 2)));     // Catch: Throwable -> L15
        this.f462539c.put("com.vivo.push.c", d((String) ListProtector.get(r101, 3)));     // Catch: Throwable -> L15
        this.f462539c.put("com.vivo.push.d", d((String) ListProtector.get(r101, 0)));     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }
}
