package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.gh;
import com.xiaomi.push.gi;
import com.xiaomi.push.go;
import com.xiaomi.push.hd;
import com.xiaomi.push.ho;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes41.dex */
public class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f464287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f1082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AtomicLong f1083a;

    static {
        f1083a = new AtomicLong(0);
        SimpleDateFormat r100 = new SimpleDateFormat("yyyy/MM/dd");
        f1082a = r100;
        f464287a = r100.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        monitor-enter(az.class);
        String r100 = f1082a.format(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L10
        if (TextUtils.equals(f464287a, r100) == true) goto L7;
        f1083a.set(0);     // Catch: Throwable -> L10
        f464287a = r100;     // Catch: Throwable -> L10
    L7:
        String r101 = r100 + "-" + f1083a.incrementAndGet();     // Catch: Throwable -> L10
        monitor-exit(az.class);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean a(String r100) {
        if (com.xiaomi.push.q.m9308b() == true) goto L5;
        return true;
    L5:
        if (Constants.HYBRID_PACKAGE_NAME.equals(r100) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean a(gi r100, boolean r101) {
        if (r100 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("item is null, verfiy ClientUploadDataItem failed.");
        return true;
    L6:
        if (r101 == true) goto L12;
        if (TextUtils.isEmpty(r100.f622a) == false) goto L12;
        com.xiaomi.channel.commonutils.logger.b.m8718a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
        return true;
    L12:
        if (TextUtils.isEmpty(r100.f629d) == false) goto L16;
        com.xiaomi.channel.commonutils.logger.b.m8718a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
        return true;
    L16:
        if (TextUtils.isEmpty(r100.f628c) == false) goto L20;
        com.xiaomi.channel.commonutils.logger.b.m8718a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
        return true;
    L20:
        if (com.xiaomi.push.ba.m8845a(r100.f629d) == true) goto L24;
        com.xiaomi.channel.commonutils.logger.b.m8718a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
        return true;
    L24:
        if (com.xiaomi.push.ba.m8845a(r100.f628c) == true) goto L27;
        com.xiaomi.channel.commonutils.logger.b.m8718a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
        return true;
    L27:
        String r102 = r100.f627b;
        if (r102 != null) goto L30;
        return false;
    L30:
        if (r102.length() <= 30720) goto L35;
        com.xiaomi.channel.commonutils.logger.b.m8718a("item.data is too large(" + r100.f627b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
        return true;
    L35:
        return false;
    }

    private static hd a(String r100, String r101, gh r102) {
        return new hd("-1", false).d(r100).b(r101).a(com.xiaomi.push.v.a(ho.a(r102))).c(go.B.f650a);
    }

    public static ArrayList<hd> a(List<gi> r110, String r111, String r112, int r113) {
        if (r110 != null) goto L7;
        com.xiaomi.channel.commonutils.logger.b.d("requests can not be null in TinyDataHelper.transToThriftObj().");
        return null;
    L7:
        if (r110.size() != 0) goto L10;
        com.xiaomi.channel.commonutils.logger.b.d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
        return null;
    L10:
        ArrayList<hd> r100 = new ArrayList();
        gh r101 = new gh();
        int r102 = 0;
        int r103 = 0;
    L12:
        if (r102 >= r110.size()) goto L41;
        gi r104 = (gi) ListProtector.get(r110, r102);
        if (r104 == null) goto L39;
        if (r104.m9132a() != null) goto L19;
    L30:
        int r105 = 0;
    L31:
        if (r105 > 0) goto L33;
        r105 = ho.a(r104).length;
    L33:
        if (r105 <= r113) goto L36;
        com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + r104.d());
        goto L39
    L36:
        if ((r103 + r105) <= r113) goto L38;
        r100.add(a(r111, r112, r101));
        r101 = new gh();
        r103 = 0;
    L38:
        r101.a(r104);
        r103 = r103 + r105;
        goto L39
    L19:
        if (r104.m9132a().containsKey("item_size") == false) goto L30;
        String r106 = r104.m9132a().get("item_size");
        if (TextUtils.isEmpty(r106) == false) goto L44;
    L25:
        r105 = 0;
    L27:
        if (r104.m9132a().size() != 1) goto L29;
        r104.a(null);
        goto L31
    L29:
        r104.m9132a().remove("item_size");
        goto L31
    L44:
        r105 = CastIntegerProtector.parseInt(r106);     // Catch: Exception -> L24
    L39:
        r102 = r102 + 1;
        goto L12
    L41:
        if (r101.a() == 0) goto L43;
        r100.add(a(r111, r112, r101));
    L43:
        return r100;
    }

    public static void a(Context r100, String r101, String r102, long r103, String r104) {
        gi r105 = new gi();
        r105.d(r101);
        r105.c(r102);
        r105.a(r103);
        r105.b(r104);
        r105.a("push_sdk_channel");
        r105.g(r100.getPackageName());
        r105.e(r100.getPackageName());
        r105.a(true);
        r105.b(System.currentTimeMillis());
        r105.f(a());
        ba.a(r100, r105);
    }
}
