package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public class SmartBindService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f395985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServiceConnection f395986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f395987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f395988d;

    public void smartBindToService() {
        Context r100 = this.f395985a;
        Intent r101 = new Intent(this.f395987c);
        List<ResolveInfo> r102 = r100.getPackageManager().queryIntentServices(r101, 0);
        if (r102 == null) goto L10;
        Iterator<ResolveInfo> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next().serviceInfo.packageName;
        if (r104.equals(r100.getPackageName()) == true) goto L6;
    L12:
        if (r104 == null) goto L16;
        Intent r105 = new Intent(this.f395987c);
        r105.setPackage(r104);
        this.f395985a.bindService(r105, this.f395986b, 1);     // Catch: Throwable -> L26
        return;
    L38:
        return;
    L16:
        String r106 = this.f395988d;
        if (r106 != null) goto L19;
        return;
    L19:
        if (r106.isEmpty() == true) goto L36;
        ComponentName r107 = new ComponentName(this.f395985a.getPackageName(), this.f395988d);
        Intent r108 = new Intent();
        r108.setComponent(r107);
        r108.setAction(this.f395987c);
        this.f395985a.bindService(r108, this.f395986b, 1);     // Catch: Exception -> L24
        return;
    L25:
        return;
    L36:
        return;
    L10:
        r104 = null;
        goto L12
    }

    public SmartBindService(Context r100, ServiceConnection r101, String r102, String r103) {
        this.f395985a = r100;
        this.f395986b = r101;
        this.f395987c = r102;
        this.f395988d = r103;
    }
}
