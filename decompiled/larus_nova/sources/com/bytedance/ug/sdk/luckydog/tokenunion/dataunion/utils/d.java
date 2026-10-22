package com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Map<String, String> f272294a;

    static {
        f272294a = new HashMap();
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }

    public static synchronized void b(Context r110, boolean r111, String r112, om7.c r113) {
        monitor-enter(d.class);
        Set r100 = pm7.a.C7212a.f529851a.f529847a;     // Catch: Throwable -> L73
        if (r100 != null) goto L9;
        r100 = new HashSet();     // Catch: Throwable -> L73
    L9:
        if (r100.isEmpty() == false) goto L13;
        r113.a(r112, null);     // Catch: Throwable -> L73
        um7.e.b("getUnionValue() pkgList is null; return");     // Catch: Throwable -> L73
        monitor-exit(d.class);
        return;
    L13:
        ContentResolver r101 = r110.getContentResolver();     // Catch: Throwable -> L73
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L73
        Iterator r103 = r100.iterator();     // Catch: Throwable -> L73
    L15:
        if (r103.hasNext() == false) goto L70;
        String r104 = (String) r103.next();     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r104) == true) goto L15;
        if (TextUtils.isEmpty(r104) == false) goto L22;
    L24:
        boolean r105 = false;
    L25:
        if (r105 == false) goto L26;
        Cursor r106 = a(r101, Uri.parse("content://" + r104 + ".luckydog" + HTTP.URL_DEFAULT + RemoteMessageConst.DEVICE_TOKEN), new String[]{r112});     // Catch: Throwable -> L52
        if (r106 == null) goto L45;
    L43:
        th = th;
    L89:
        um7.e.a(th.getMessage());     // Catch: Throwable -> L62
        if (r106 == null) goto L15;
        r106.close();     // Catch: Throwable -> L58
    L58:
        th = th;
    L60:
        um7.e.a(th.getMessage());     // Catch: Throwable -> L73
        goto L15
    L62:
        th = move-exception;
        if (r106 != null) goto L80;
    L68:
        throw th;     // Catch: Throwable -> L73
    L80:
        r106.close();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        um7.e.a(th.getMessage());     // Catch: Throwable -> L73
        goto L68
    L31:
        if (r106.moveToFirst() == false) goto L46;
        String r107 = r106.getString(0);     // Catch: Throwable -> L43
        um7.e.b("getUnionValue() cursor.getString(0) = " + r107);     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r107) == true) goto L46;
        String r108 = om7.f.a(r107.getBytes());     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r108) == true) goto L46;
        um7.e.b("getUnionValue() get token from provider: " + r104 + "; unionValue = " + r108);     // Catch: Throwable -> L43
        b.a(r112, r108, r104, DataUnionStrategy.UNION_PROVIDER);     // Catch: Throwable -> L43
        r113.a(r112, r108);     // Catch: Throwable -> L43
        r106.close();     // Catch: Throwable -> L39
    L41:
        monitor-exit(d.class);
        return;
    L39:
        th = move-exception;
        um7.e.a(th.getMessage());     // Catch: Throwable -> L73
    L46:
        if (r106 == null) goto L15;
        r106.close();     // Catch: Throwable -> L49
    L49:
        th = th;
        goto L60
    L45:
        um7.e.b("getUnionValue() pending pkg = " + r104);     // Catch: Throwable -> L43
        r102.add(r104);     // Catch: Throwable -> L43
    L52:
        th = th;
        r106 = null;
        goto L89
    L26:
        um7.e.b("getUnionValue() isOk is false continue");     // Catch: Throwable -> L73
        goto L15
    L22:
        if (r104.equals(r110.getPackageName()) == true) goto L24;
        r105 = true;
        goto L25
    L70:
        if (r102.isEmpty() == true) goto L75;
        if (r111 == false) goto L75;
        c(r110, r102, r112, r113);     // Catch: Throwable -> L73
    L76:
        monitor-exit(d.class);
        return;
    L75:
        r113.a(r112, null);     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        throw th;
    }

    public static synchronized void c(Context r110, List r111, final String r112, final om7.c r210) {
        monitor-enter(d.class);
        um7.e.b("queryDataUnionByActivity() on call; key = " + r112);     // Catch: Throwable -> L56
        if (((ArrayList) r111).isEmpty() == false) goto L7;
    L9:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L14;
        r210.a(r112, null);     // Catch: Throwable -> L56
        um7.e.b("queryDataUnionByActivity() isBad is true; return; ");     // Catch: Throwable -> L56
        monitor-exit(d.class);
        return;
    L14:
        final ArrayList r113 = new ArrayList();     // Catch: Throwable -> L56
        Thread.sleep(100);     // Catch: Throwable -> L18
    L21:
        final CountDownLatch r114 = new CountDownLatch(1);     // Catch: Throwable -> L56
        Iterator r115 = ((ArrayList) r111).iterator();     // Catch: Throwable -> L56
    L23:
        if (r115.hasNext() == false) goto L60;
        final String r101 = (String) r115.next();     // Catch: Throwable -> L56
        Intent r102 = new Intent(r101 + ".luckydog.DataUnionActivity");     // Catch: Throwable -> L56
        r102.putExtra("key_result_receiver", new DataUnionProviderUtils$1(r101, r112, r210, r114, r113));     // Catch: Throwable -> L43
        r102.putExtra("key_union_value_key", r112);     // Catch: Throwable -> L43
        r102.addFlags(268435456);     // Catch: Throwable -> L43
        List<ResolveInfo> r103 = r110.getPackageManager().queryIntentActivities(r102, 65536);     // Catch: Throwable -> L43
        if (r103 != null) goto L28;
    L30:
        boolean r104 = false;
    L31:
        if (r104 == false) goto L23;
        Thread.sleep(100);     // Catch: Throwable -> L43
        if (((HashMap) f272294a).containsKey(r112) == false) goto L62;
        um7.e.b("queryDataUnionByActivity() contains(key) return;");     // Catch: Throwable -> L43
        monitor-exit(d.class);
        return;
    L62:
        r110.startActivity(r102);     // Catch: Throwable -> L41
        r113.add(r101);     // Catch: Throwable -> L41
    L41:
        th = th;
    L45:
        um7.e.a(th.getMessage());     // Catch: Throwable -> L56
        goto L23
    L28:
        if (r103.size() <= 0) goto L30;
        r104 = true;
    L43:
        th = th;
        goto L45
    L60:
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L52
        um7.e.b("开始等待");     // Catch: Throwable -> L52
        r114.await(4000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L52
        um7.e.b("等待结束 耗时： " + (System.currentTimeMillis() - r105));     // Catch: Throwable -> L52
        if (((HashMap) f272294a).containsKey(r112) == true) goto L50;
        ((HashMap) f272294a).put(r112, "");     // Catch: Throwable -> L52
        um7.e.b("queryDataUnionByActivity() latch.await() finish; 执行回调onDataUnion(null)");     // Catch: Throwable -> L52
        r210.a(r112, "");     // Catch: Throwable -> L52
    L59:
    L54:
        monitor-exit(d.class);
        return;
    L50:
        um7.e.b("开始回调时 已经包含key，不再回调");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        um7.e.b(th.getMessage());     // Catch: Throwable -> L56
        goto L54
    L18:
        th = move-exception;
        um7.e.a(th.getMessage());     // Catch: Throwable -> L56
        goto L21
    L7:
        if (TextUtils.isEmpty(r112) == true) goto L9;
        r100 = false;
    L56:
        th = move-exception;
        throw th;
    }
}
