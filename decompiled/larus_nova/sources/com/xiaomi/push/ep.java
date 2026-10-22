package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
class ep {
    public static void a(com.xiaomi.push.service.am.b r100, String r101, ez r110) {
        Cdo.c r102 = new Cdo.c();
        if (TextUtils.isEmpty(r100.f464217c) == true) goto L6;
        r102.a(r100.f464217c);
    L6:
        if (TextUtils.isEmpty(r100.f464219e) == true) goto L9;
        r102.d(r100.f464219e);
    L9:
        if (TextUtils.isEmpty(r100.f464220f) == true) goto L12;
        r102.e(r100.f464220f);
    L12:
        if (r100.f1056a == false) goto L14;
        String r103 = "1";
    L15:
        r102.b(r103);
        if (TextUtils.isEmpty(r100.f464218d) == true) goto L18;
        r102.c(r100.f464218d);
    L19:
        eq r104 = new eq();
        r104.c(r100.f1057b);
        r104.a(CastIntegerProtector.parseInt(r100.f464221g));
        r104.b(r100.f1054a);
        r104.a("BIND", null);
        r104.a(r104.e());
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim]: bind id=" + r104.e());
        HashMap r105 = new HashMap();
        r105.put("challenge", r101);
        r105.put("token", r100.f464217c);
        r105.put("chid", r100.f464221g);
        r105.put("from", r100.f1057b);
        r105.put("id", r104.e());
        r105.put(RemoteMessageConst.TO, "xiaomi.com");
        if (r100.f1056a == false) goto L22;
        r105.put("kick", "1");
    L24:
        if (TextUtils.isEmpty(r100.f464219e) == true) goto L26;
        r105.put("client_attrs", r100.f464219e);
    L28:
        if (TextUtils.isEmpty(r100.f464220f) == true) goto L30;
        r105.put("cloud_attrs", r100.f464220f);
    L32:
        if (r100.f464218d.equals("XIAOMI-PASS") == false) goto L34;
    L37:
        String r106 = ay.a(r100.f464218d, null, r105, r100.f464222h);
    L38:
        r102.f(r106);
        r104.a(r102.m9042a(), null);
        r110.b(r104);
        return;
    L34:
        if (r100.f464218d.equals("XMPUSH-PASS") == true) goto L37;
        r100.f464218d.equals("XIAOMI-SASL");
        r106 = null;
        goto L38
    L30:
        r105.put("cloud_attrs", "");
        goto L32
    L26:
        r105.put("client_attrs", "");
        goto L28
    L22:
        r105.put("kick", "0");
        goto L24
    L18:
        r102.c("XIAOMI-SASL");
        goto L19
    L14:
        r103 = "0";
        goto L15
    }

    public static void a(String r100, String r101, ez r102) {
        eq r103 = new eq();
        r103.c(r101);
        r103.a(CastIntegerProtector.parseInt(r100));
        r103.a("UBND", null);
        r102.b(r103);
    }
}
