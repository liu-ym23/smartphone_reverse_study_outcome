package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class u0 {
    public static f0 a(String r100, String r101, String r102, String r103) {
        f0 r104 = new f0();
        r104.a(r100);
        r104.b(q0.f());
        r104.e(r101);
        r104.c(r103);
        StringBuffer r105 = new StringBuffer("hmshi");
        r105.append(r102);
        r105.append("qrt");
        r104.d(r105.toString());
        return r104;
    }

    public static l a(String r100, String r101) {
        l r102 = new l();
        r102.a(j.a().a(r100, r101));
        return r102;
    }

    public static y0 a(String r100, String r101, String r102) {
        y0 r103 = new y0();
        r103.c(q0.j());
        r103.e(q0.l());
        r103.a(r102);
        r103.b(j.a().b(r101, r100));
        return r103;
    }

    public static h1 b(String r100, String r101) {
        m1.d().a(r100, r101);
        if (TextUtils.isEmpty(m1.d().a()) == false) goto L7;
        v.f("hmsSdk", "event chifer is empty");
        return null;
    L7:
        return new h1(m1.d().c());
    }

    public static Map<String, String> c(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("App-Id", q0.f());
        r102.put("App-Ver", q0.g());
        r102.put("Sdk-Name", "hianalytics");
        r102.put("Sdk-Ver", "2.2.0.315");
        r102.put("Device-Type", Build.MODEL);
        r102.put("servicetag", r100);
        v.a("hmsSdk", "sendData RequestId : " + r101);
        r102.put("Request-Id", r101);
        return r102;
    }
}
