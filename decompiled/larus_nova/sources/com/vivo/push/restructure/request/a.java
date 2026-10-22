package com.vivo.push.restructure.request;

import android.content.Intent;
import android.os.Bundle;
import com.vivo.push.restructure.request.a.a.b;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f462482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private I f462483b;

    public abstract O a(com.vivo.push.restructure.request.a.a.a r100);

    public final Intent a(int r100) {
        Intent r101 = new Intent();
        Bundle r102 = new Bundle();
        r102.putString("client_pkgname", com.vivo.push.restructure.a.a().b().getPackageName());
        r102.putBoolean("support_rf", true);
        com.vivo.push.restructure.request.a.c r103 = new com.vivo.push.restructure.request.a.c(this.f462482a, r100);
        com.vivo.push.restructure.request.a.a.a r104 = new com.vivo.push.restructure.request.a.a.a();
        r103.a(r104);
        r102.putString("cf_content", r104.e());
        com.vivo.push.restructure.request.a.a.a r105 = new com.vivo.push.restructure.request.a.a.a();
        this.f462483b.a(r105);
        r102.putString("content", r105.e());
        r101.putExtras(r102);
        return r101;
    }

    public a(int r100, I r101) {
        this.f462482a = r100;
        this.f462483b = r101;
    }
}
