package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class p extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o f277652b;

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com_huawei_hms_push_p_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_huawei_hms_push_p__run$___twin___() {
        HMSLog.i("PushSelfShowLog", "enter run()");
    L10:
        e = move-exception;
        HMSLog.e("PushSelfShowLog", e.toString());
        return;
    L4:
        if (b(this.f277651a) == true) goto L6;
        return;
    L6:
        if (b(this.f277651a, this.f277652b) == false) goto L8;
        return;
    L8:
        n.a(this.f277651a, this.f277652b);     // Catch: Exception -> L10
    }

    private boolean a(Context r100) {
        return e.c(r100, this.f277652b.c());
    }

    private boolean b(Context r100) {
        if ("cosa".equals(this.f277652b.h()) == true) goto L5;
        return true;
    L5:
        return a(r100);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_huawei_hms_push_p_com_larus_apm_impl_protector_RunnableLancet_run(p r100) {
        r100.com_huawei_hms_push_p__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public p(Context r100, o r101) {
        this.f277651a = r100;
        this.f277652b = r101;
    }

    private static Intent a(Context r100, o r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        Intent r102 = e.b(r100, r101.c());
        if (r101.m() == null) goto L16;
        Intent r103 = Intent.parseUri(r101.m(), 0);     // Catch: Exception -> L13
        r103.setSelector(null);     // Catch: Exception -> L13
        if (r103.getClipData() != null) goto L10;
        r103.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));     // Catch: Exception -> L13
    L10:
        HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + r103.getAction());     // Catch: Exception -> L13
        if (e.a(r100, r101.c(), r103).booleanValue() == true) goto L25;
        return r102;
    L25:
        return r103;
    L13:
        e = move-exception;
        HMSLog.w("PushSelfShowLog", "intentUri error," + e.toString());
        return r102;
    L16:
        if (r101.a() == null) goto L20;
        Intent r104 = new Intent(r101.a());
        if (e.a(r100, r101.c(), r104).booleanValue() == false) goto L20;
        r102 = r104;
    L20:
        r102.setPackage(r101.c());
        return r102;
    }

    private boolean b(Context r100, o r101) {
        if ("cosa".equals(r101.h()) == true) goto L5;
    L7:
        return false;
    L5:
        if (a(r100, r101) != null) goto L7;
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }
}
