package com.vivo.push.restructure.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.ah;
import com.vivo.push.util.t;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
final class c extends a<com.vivo.push.restructure.a.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f462452b = null;

    static {
        f462452b = Arrays.asList(new Integer[]{3});
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(com.vivo.push.restructure.a.a r100) {
    L43:
        e = move-exception;
        t.a("CheckNode", e);
    L45:
        return 0;
    L4:
        if (com.vivo.push.restructure.a.a().e().m().isAgreePrivacyStatement() == true) goto L7;
        t.d("CheckNode", " checkNeedReportByPrivacyStatement is false  ");     // Catch: Exception -> L43
        return 2809;
    L7:
        Intent r101 = r100.b();     // Catch: Exception -> L43
        String r102 = com.vivo.push.sdk.a.a().b();     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r102) == false) goto L10;
    L21:
        Context r103 = com.vivo.push.restructure.a.a().b();     // Catch: Exception -> L43
        String r104 = r103.getPackageName();     // Catch: Exception -> L43
        String r105 = r101.getStringExtra("command_type");     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r105) == false) goto L24;
    L41:
        t.a("CheckNode", "commandTypeStr is not satisfy == ".concat(String.valueOf(r105)));     // Catch: Exception -> L43
        return GLMapStaticValue.AM_PARAMETERNAME_RENDER_COMPLETE;
    L24:
        if (r105.equals("reflect_receiver") == false) goto L41;
        int r106 = r101.getIntExtra("command", -1);     // Catch: Exception -> L43
        if (r106 >= 0) goto L30;
        r106 = r101.getIntExtra(com.alipay.sdk.m.p.e.f25671s, -1);     // Catch: Exception -> L43
    L30:
        if (f462452b.contains(Integer.valueOf(r106)) == true) goto L32;
    L37:
        String r107 = r101.getAction();     // Catch: Exception -> L43
        if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().e().a(r103, r107)) == false) goto L45;
        t.d("CheckNode", " reflectReceiver error: receiver for: " + r107 + " not found, package: " + r104);     // Catch: Exception -> L43
        r101.setPackage(r104);     // Catch: Exception -> L43
        r103.sendBroadcast(r101);     // Catch: Exception -> L43
        return 2802;
    L32:
        if (aa.c(r103, r104) == false) goto L37;
        if (aa.b(r103) == true) goto L37;
        t.a("CheckNode", "METHOD_ON_MESSAGE is not support");     // Catch: Exception -> L43
        return 2803;
    L10:
        if (r102.contains("CommandService") == false) goto L21;
        if (r101 != null) goto L13;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == true) goto L21;
        t.a("CheckNode", " !checkIntentIsSecurity(intent)");     // Catch: Exception -> L43
        return GLMapStaticValue.AM_PARAMETERNAME_RENDER_COMPLETE;
    L13:
        if (a(r101) == false) goto L17;
        if (a(r101, r100) == false) goto L17;
        r108 = true;
        goto L18
    }

    private static boolean a(Intent r100) {
        String r101 = r100.getStringExtra("security_avoid_pull");     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r101) == false) goto L18;
        t.a("CheckNode", "checkIntentIsSecurityTextUtils.isEmpty");     // Catch: Exception -> L15
        return true;
    L18:
        String r102 = com.vivo.push.util.a.a(com.vivo.push.restructure.a.a().b()).a(r101);     // Catch: Exception -> L10
        if ("com.vivo.pushservice".equals(r102) == true) goto L21;
        t.a("CheckNode", "!decrypt.equals, so decrypt == ".concat(String.valueOf(r102)));     // Catch: Exception -> L10
        return false;
    L21:
        return true;
    L10:
        e = move-exception;
        t.a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());     // Catch: Exception -> L15
        return false;
    L15:
        t.a("CheckNode", "getStringExtra error");
        return true;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a r100) {
        return a2(r100);
    }

    public c(com.vivo.push.restructure.a.a r100, j r101) {
        super("CheckNode", r100, r101);
    }

    private static boolean a(Intent r100, com.vivo.push.restructure.a.a r110) {
        Context r101 = com.vivo.push.restructure.a.a().b();     // Catch: Exception -> L36
        String r102 = ah.b(r101, "com.vivo.pushservice");     // Catch: Exception -> L36
        t.d("CheckNode", " 配置的验签参数 = ".concat(String.valueOf(r102)));     // Catch: Exception -> L36
        if (TextUtils.equals(r102, "1") == true) goto L6;
        return true;
    L6:
        String r103 = r100.getStringExtra("security_avoid_pull_rsa");     // Catch: Exception -> L36
        String r104 = r100.getStringExtra("security_avoid_rsa_public_key");     // Catch: Exception -> L36
        if (TextUtils.isEmpty(r103) == false) goto L9;
    L34:
        t.a("CheckNode", "!decrypt.equals, so securityContent == " + r103 + " or publickKey isempty ");     // Catch: Exception -> L36
        return false;
    L9:
        if (TextUtils.isEmpty(r104) == true) goto L34;
        if (com.vivo.push.g.b.a().a(r101).a("com.vivo.pushservice".getBytes("UTF-8"), ab.a(r104), Base64.decode(r103, 2)) == false) goto L15;
        t.d("CheckNode", " RSA验签通过  ");     // Catch: Exception -> L36
        return true;
    L15:
        StringBuilder r105 = new StringBuilder(" 验签参数传入错误 securityContent = ");     // Catch: Exception -> L36
        r105.append(r103);     // Catch: Exception -> L36
        r105.append(" publickKey= ");     // Catch: Exception -> L36
        r105.append(r104);     // Catch: Exception -> L36
        r105.append(" receivedMsg isempty? ");     // Catch: Exception -> L36
        if (r110 != null) goto L18;
        boolean r106 = true;
    L19:
        r105.append(r106);     // Catch: Exception -> L36
        r105.append(" receivedMsg isClickMsg? ");     // Catch: Exception -> L36
        if (r110 != null) goto L22;
        boolean r107 = false;
    L23:
        r105.append(r107);     // Catch: Exception -> L36
        t.c("CheckNode", r105.toString());     // Catch: Exception -> L36
        if (r110 != null) goto L26;
    L32:
        t.d("CheckNode", " RSA验签 不通过  ");     // Catch: Exception -> L36
        return false;
    L26:
        if (r110.k() == false) goto L32;
        if (TextUtils.equals(r103, "com.vivo.pushservice") == false) goto L30;
    L31:
        return true;
    L30:
        if (TextUtils.equals(r104, "com.vivo.pushservice") == false) goto L32;
    L22:
        r107 = r110.k();     // Catch: Exception -> L36
        goto L23
    L18:
        r106 = false;
    L36:
        e = move-exception;
        t.a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
        return true;
    }
}
