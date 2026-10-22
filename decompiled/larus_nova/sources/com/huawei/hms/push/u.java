package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f277671c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o f277673b;

    static {
        f277671c = new String[]{"url", "app", "cosa", "rp"};
    }

    private void a() {
        HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f277673b.c());     // Catch: Exception -> L7
        if (e.c(this.f277672a, this.f277673b.c()) == false) goto L12;
        b();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
    }

    private void b() {
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.f277673b.c() + ",and msg.intentUri is " + this.f277673b.m());     // Catch: Exception -> L28
        Intent r100 = e.b(this.f277672a, this.f277673b.c());     // Catch: Exception -> L28
        boolean r101 = false;
        if (this.f277673b.m() == null) goto L15;
        Intent r102 = Intent.parseUri(this.f277673b.m(), 0);     // Catch: Exception -> L12
        r102.setSelector(null);     // Catch: Exception -> L12
        if (r102.getClipData() != null) goto L9;
        r102.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));     // Catch: Exception -> L12
    L9:
        HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + r102.getAction());     // Catch: Exception -> L12
        r101 = e.a(this.f277672a, this.f277673b.c(), r102).booleanValue();     // Catch: Exception -> L12
        if (r101 == false) goto L19;
        r100 = r102;
    L19:
        if (r100 != null) goto L22;
        HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");     // Catch: Exception -> L28
        return;
    L22:
        r100.setPackage(this.f277673b.c());     // Catch: Exception -> L28
        if (r101 == false) goto L25;
        r100.addFlags(268435456);     // Catch: Exception -> L28
    L26:
        this.f277672a.startActivity(r100);     // Catch: Exception -> L28
        return;
    L25:
        r100.setFlags(805437440);     // Catch: Exception -> L28
        goto L26
    L12:
        e = move-exception;
        HMSLog.w("PushSelfShowLog", "intentUri error." + e.toString());     // Catch: Exception -> L28
        goto L19
    L15:
        if (this.f277673b.a() == null) goto L19;
        Intent r103 = new Intent(this.f277673b.a());     // Catch: Exception -> L28
        if (e.a(this.f277672a, this.f277673b.c(), r103).booleanValue() == false) goto L19;
        r100 = r103;
    L28:
        e = move-exception;
        HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e.toString());
    }

    public void c() {
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f277672a == null) goto L21;
        o r100 = this.f277673b;
        if (r100 == null) goto L21;
        if ("app".equals(r100.h()) == false) goto L11;
        a();
        return;
    L11:
        if ("cosa".equals(this.f277673b.h()) == false) goto L14;
        b();
        return;
    L14:
        if ("rp".equals(this.f277673b.h()) == false) goto L17;
        HMSLog.w("PushSelfShowLog", this.f277673b.h() + " not support rich message.");
        return;
    L17:
        if ("url".equals(this.f277673b.h()) == false) goto L19;
        HMSLog.w("PushSelfShowLog", this.f277673b.h() + " not support URL.");
        return;
    L19:
        HMSLog.d("PushSelfShowLog", this.f277673b.h() + " is not exist in hShowType");
        return;
    L21:
        HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
    }

    public static boolean a(String r100) {
        String[] r101 = f277671c;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101[r103].equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public u(Context r100, o r101) {
        this.f277672a = r100;
        this.f277673b = r101;
    }
}
