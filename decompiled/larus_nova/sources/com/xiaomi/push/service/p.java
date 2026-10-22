package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.xiaomi.push.BuildConfig;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f464330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f464333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f464335f;

    public static boolean a() {
        return com.xiaomi.push.q.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
    L4:
        return false;
    }

    private static String a(Context r100) {
        if ("com.xiaomi.xmsf".equals(r100) == false) goto L10;
        if (TextUtils.isEmpty(null) == false) goto L11;
        String r101 = com.xiaomi.push.j.m9292a("ro.miui.region");
        if (TextUtils.isEmpty(r101) == true) goto L13;
        return r101;
    L13:
        return com.xiaomi.push.j.m9292a("ro.product.locale.region");
    L11:
        return null;
    L10:
        return com.xiaomi.push.j.b();
    }

    private static boolean b(Context r100) {
        return r100.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9408a(Context r100) {
        if ("com.xiaomi.xmsf".equals(r100.getPackageName()) == true) goto L5;
    L7:
        return false;
    L5:
        if (a() == false) goto L7;
        return true;
    }

    public am.b a(XMPushService r100) {
        am.b r101 = new am.b(r100);
        a(r101, r100, r100.m9333b(), "c");
        return r101;
    }

    public am.b a(am.b r100, Context r101, h r102, String r103) {
        r100.f1054a = r101.getPackageName();
        r100.f1057b = this.f1123a;
        r100.f464222h = this.f464332c;
        r100.f464217c = this.f464331b;
        r100.f464221g = "5";
        r100.f464218d = "XMPUSH-PASS";
        r100.f1056a = false;
        com.xiaomi.push.r.a r104 = new com.xiaomi.push.r.a();
        r104.a("sdk_ver", 48).a("cpvn", BuildConfig.VERSION_NAME).a("cpvc", Integer.valueOf(BuildConfig.VERSION_CODE)).a("country_code", b.a(r101).b()).a(EffectConfiguration.KEY_REGION, b.a(r101).a()).a("miui_vn", com.xiaomi.push.j.c()).a("miui_vc", Integer.valueOf(com.xiaomi.push.j.a(r101))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.a(r101, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(af.m9347a(r101))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.g.a(r101)));
        String r105 = a(r101);
        if (TextUtils.isEmpty(r105) == true) goto L5;
        r104.a("latest_country_code", r105);
    L5:
        String r106 = com.xiaomi.push.j.d();
        if (TextUtils.isEmpty(r106) == true) goto L8;
        r104.a("device_ch", r106);
    L8:
        String r107 = com.xiaomi.push.j.e();
        if (TextUtils.isEmpty(r107) == true) goto L11;
        r104.a("device_mfr", r107);
    L11:
        r100.f464219e = r104.toString();
        if (b(r101) == false) goto L14;
        String r108 = "1000271";
    L15:
        com.xiaomi.push.r.a r109 = new com.xiaomi.push.r.a();
        r109.a("appid", r108).a("locale", Locale.getDefault().toString()).a(DocumentType.DOCX_SYNC_BLOCK_NAME, 1);
        if (m9408a(r101) == false) goto L18;
        r109.a("ab", r103);
    L18:
        r100.f464220f = r109.toString();
        r100.f1053a = r102;
        return r100;
    L14:
        r108 = this.f464333d;
        goto L15
    }

    public p(String r100, String r101, String r102, String r103, String r104, String r105, int r106) {
        this.f1123a = r100;
        this.f464331b = r101;
        this.f464332c = r102;
        this.f464333d = r103;
        this.f464334e = r104;
        this.f464335f = r105;
        this.f464330a = r106;
    }
}
