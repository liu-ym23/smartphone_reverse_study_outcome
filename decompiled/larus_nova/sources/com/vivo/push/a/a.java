package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.b.n;
import com.vivo.push.d;
import com.vivo.push.g.b;
import com.vivo.push.i;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.t;
import com.vivo.push.v;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static void a(Context r100, Intent r101) throws Exception {
        if (r100 != null) goto L11;
        t.d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    L11:
        r100.startService(r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        t.a("CommandBridge", "start service error", e);
        r101.setComponent(null);
        r100.sendBroadcast(r101);
    }

    public static void a(Context r100, n r101, String r102) {
        boolean r103 = aa.d(r100, r102);     // Catch: Exception -> L26
        if (r103 == false) goto L6;
        String r104 = "com.vivo.pushservice.action.RECEIVE";
    L8:
        if (TextUtils.isEmpty(r102) == true) goto L24;
        if (r103 == true) goto L13;
        if (a(r100, r104, r102) == true) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r101.a()) == false) goto L15;
        r101.a(r100.getPackageName());     // Catch: Exception -> L26
    L15:
        Intent r105 = new Intent();     // Catch: Exception -> L26
        r105.setFlags(1048576);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r104) == true) goto L18;
        r105.setAction(r104);     // Catch: Exception -> L26
    L18:
        r105.setPackage(r102);     // Catch: Exception -> L26
        if (r103 == false) goto L21;
        String r106 = "com.vivo.push.sdk.service.CommandService";
    L22:
        r105.setClassName(r102, r106);     // Catch: Exception -> L26
        r101.b(r105);     // Catch: Exception -> L26
        r105.putExtra("command_type", "reflect_receiver");     // Catch: Exception -> L26
        r105.putExtra("security_avoid_pull_rsa", b.a().a(r100).a("com.vivo.pushservice"));     // Catch: Exception -> L26
        r105.putExtra("security_avoid_rsa_public_key", ab.a(b.a().a(r100).a()));     // Catch: Exception -> L26
        a(r100, r105);     // Catch: Exception -> L26
        return;
    L21:
        r106 = "com.vivo.push.sdk.service.CommandClientService";
        goto L22
    L24:
        t.c(r100, "消息接受者包名为空！");     // Catch: Exception -> L26
        throw new Exception("消息接受者包名为空！");     // Catch: Exception -> L26
    L6:
        r104 = "com.vivo.pushclient.action.RECEIVE";
    L26:
        e = move-exception;
        t.a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
    }

    public static void a(Context r100, String r101, v r102) {
        boolean r103 = r102.d();
        if (r103 == false) goto L5;
        String r104 = "com.vivo.vms.upstageservice";
    L6:
        i r105 = i.a(r100, r104);
        boolean r106 = r105.a();
        if (TextUtils.isEmpty(r102.a()) == false) goto L10;
        r102.a(r100.getPackageName());
    L10:
        if (r106 == true) goto L12;
    L17:
        Intent r107 = new Intent("com.vivo.pushservice.action.METHOD");
        r107.setPackage(r101);
        if (r103 == false) goto L20;
        String r108 = "com.vivo.push.sdk.service.UpstageService";
    L21:
        r107.setClassName(r101, r108);
        r102.a(r107);
        a(r100, r107);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        t.a("CommandBridge", "CommandBridge startService exception: ", e);
        return;
    L20:
        r108 = "com.vivo.push.sdk.service.PushService";
        goto L21
    L12:
        if ("com.vivo.pushservice".equals(r100.getPackageName()) == true) goto L17;
        d r109 = new d(r102.a(), r101, new Bundle());
        r102.a(r109);
        if (r105.a(r109.b()) == false) goto L16;
        return;
    L16:
        t.b("CommandBridge", "send command error by aidl");
        t.c(r100, "send command error by aidl");
        goto L17
    L5:
        r104 = "com.vivo.vms.aidlservice";
        goto L6
    }

    private static boolean a(Context r100, String r101, String r102) {
        Intent r103 = new Intent(r101);
        r103.setPackage(r102);
        List<ResolveInfo> r104 = r100.getPackageManager().queryBroadcastReceivers(r103, 576);     // Catch: Exception -> L12
        if (r104 != null) goto L6;
    L10:
        t.b("CommandBridge", "action check error：action>>" + r101 + ";pkgname>>" + r102);     // Catch: Exception -> L12
        return false;
    L6:
        if (r104.size() <= 0) goto L10;
        return true;
    L12:
        t.b("CommandBridge", "queryBroadcastReceivers error");
        return false;
    }
}
