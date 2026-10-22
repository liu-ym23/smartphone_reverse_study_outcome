package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.security.PublicKey;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f462563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f462564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f462565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected NotifyArriveCallbackByUser f462566d;

    public abstract int a();

    public abstract PendingIntent a(Context r100, Intent r101);

    public abstract Intent a(Context r100, InsideNotificationItem r101, NotifyArriveCallbackByUser r102);

    public b() {
    }

    public final long b() {
        return this.f462564b;
    }

    public static void a(Intent r100, Context r101) {
        String r102 = com.vivo.push.g.b.a().a(r101).a("com.vivo.pushservice");     // Catch: Exception -> L12
        PublicKey r103 = com.vivo.push.g.b.a().a(r101).a();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r102) == false) goto L6;
        r102 = "com.vivo.pushservice";
    L6:
        r100.putExtra("security_avoid_pull_rsa", r102);     // Catch: Exception -> L12
        if (r103 != null) goto L9;
        String r104 = "com.vivo.pushservice";
    L10:
        r100.putExtra("security_avoid_rsa_public_key", r104);     // Catch: Exception -> L12
        return;
    L9:
        r104 = ab.a(r103);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        t.a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt ：" + e.getMessage());
        r100.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
        r100.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
    }

    public static Intent a(Context r100, String r101, long r102, Intent r103, InsideNotificationItem r104) {
        Intent r105 = new Intent("com.vivo.pushservice.action.RECEIVE");
        r105.setPackage(r100.getPackageName());
        r105.setClassName(r100.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        r105.putExtra("command_type", "reflect_receiver");
        r105.putExtras(r103.getExtras());
        a(r105, r100);
        com.vivo.push.b.p r106 = new com.vivo.push.b.p(r101, r102, r104);
        r106.b(r103.getAction());
        if (r103.getComponent() == null) goto L6;
        r106.c(r103.getComponent().getPackageName());
        r106.d(r103.getComponent().getClassName());
    L6:
        if (r103.getData() == null) goto L8;
        r106.a(r103.getData());
    L8:
        r106.b(r105);
        return r105;
    }

    public final Intent a(Context r100, String r101, long r102, InsideNotificationItem r103, NotifyArriveCallbackByUser r104) {
        this.f462564b = r102;
        this.f462563a = r101;
        this.f462565c = r100;
        this.f462566d = r104;
        Intent r105 = a(r100, r103, r104);
        int r106 = a();
        if (r106 <= 0) goto L9;
        HashMap r107 = new HashMap();
        r107.put(com.heytap.mcssdk.constant.b.f276353c, String.valueOf(this.f462564b));
        String r108 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r108) == true) goto L7;
        r107.put("remoteAppId", r108);
    L7:
        r107.put("ap", this.f462563a);
        r107.put("clientsdkver", String.valueOf(ah.c(this.f462565c, this.f462563a)));
        f.a(r106, r107);
        return null;
    L9:
        return r105;
    }
}
