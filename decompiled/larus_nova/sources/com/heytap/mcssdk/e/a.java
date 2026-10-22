package com.heytap.mcssdk.e;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;
import com.ss.android.cert.manager.constants.BytedCertConstant;

/* JADX INFO: loaded from: classes3.dex */
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f276402a = null;

    static {
        f276402a = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
    }

    public a() {
    }

    @Override // com.heytap.mcssdk.e.d
    public BaseMode a(Context r100, int r101, Intent r102) {
        if (4105 == r101) goto L5;
        return null;
    L5:
        return a(r102, r101);
    }

    @Override // com.heytap.mcssdk.e.c
    public BaseMode a(Intent r110, int r111) {
        com.heytap.mcssdk.c.b r100 = null;
        com.heytap.mcssdk.c.b r101 = new com.heytap.mcssdk.c.b();     // Catch: Exception -> L13 Throwable -> L31
        r101.a(Integer.parseInt(com.heytap.mcssdk.utils.b.d(r110.getStringExtra("command"))));     // Catch: Exception -> L11 Throwable -> L23
        r101.b(Integer.parseInt(com.heytap.mcssdk.utils.b.d(r110.getStringExtra("code"))));     // Catch: Exception -> L11 Throwable -> L23
        r101.e(com.heytap.mcssdk.utils.b.d(r110.getStringExtra("content")));     // Catch: Exception -> L11 Throwable -> L23
        r101.a(com.heytap.mcssdk.utils.b.d(r110.getStringExtra(com.heytap.mcssdk.constant.b.f276376z)));     // Catch: Exception -> L11 Throwable -> L23
        r101.b(com.heytap.mcssdk.utils.b.d(r110.getStringExtra(com.heytap.mcssdk.constant.b.A)));     // Catch: Exception -> L11 Throwable -> L23
        r101.g(com.heytap.mcssdk.utils.b.d(r110.getStringExtra(com.heytap.mcssdk.constant.b.f276355e)));     // Catch: Exception -> L11 Throwable -> L23
        String r102 = f276402a;
        com.heytap.mcssdk.utils.d.b(r102, "parseMessageByIntent() finally will get miniProgramPkg");
        com.heytap.mcssdk.utils.d.b(r102, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");     // Catch: Exception -> L8
        r101.f(r110.getStringExtra("miniProgramPkg"));     // Catch: Exception -> L8
        com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + r101.toString());     // Catch: Exception -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage() + " ");
    L11:
        Exception e100 = e;
    L15:
        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e100.getMessage());     // Catch: Throwable -> L23
        String r103 = f276402a;
        com.heytap.mcssdk.utils.d.b(r103, "parseMessageByIntent() finally will get miniProgramPkg");
        if (r101 != null) goto L36;
    L22:
        return r101;
    L36:
        com.heytap.mcssdk.utils.d.b(r103, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");     // Catch: Exception -> L20
        r101.f(r110.getStringExtra("miniProgramPkg"));     // Catch: Exception -> L20
        com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + r101.toString());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage() + " ");
    L23:
        r100 = r101;
        goto L24
    L13:
        e = move-exception;
        r101 = null;
        e100 = e;
    L24:
        String r104 = f276402a;
        com.heytap.mcssdk.utils.d.b(r104, "parseMessageByIntent() finally will get miniProgramPkg");
        if (r100 != null) goto L39;
    L30:
        return r100;
    L39:
        com.heytap.mcssdk.utils.d.b(r104, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");     // Catch: Exception -> L28
        r100.f(r110.getStringExtra("miniProgramPkg"));     // Catch: Exception -> L28
        com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + r100.toString());     // Catch: Exception -> L28
    L28:
        e = move-exception;
        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage() + " ");
        goto L30
    }
}
