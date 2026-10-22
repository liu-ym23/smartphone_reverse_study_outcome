package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f198960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f198961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AoActivityResultRequest.a f198962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AoActivityResultRequest f198963d;

    public final void a() {
        AoActivityResultRequest.OnActivityResultFragment r100 = new AoActivityResultRequest.OnActivityResultFragment();
        Activity r101 = this.f198963d.f198942a;
        Intent r102 = this.f198960a;
        int r103 = this.f198961b;
        AoActivityResultRequest.a r104 = this.f198962c;
        if (r100.f198943a.getAndSet(true) == true) goto L18;
        r100.f198944b = r102;
        r100.f198945c = r103;
        r100.f198946d = r104;
        if (r101.isFinishing() == true) goto L14;
        r101.getFragmentManager().beginTransaction().add(0, r100).commitAllowingStateLoss();
        return;
    L14:
        r101.startActivityForResult(r100.f198944b, r100.f198945c);     // Catch: ActivityNotFoundException -> L9
        return;
    L10:
        if (r104 == null) goto L16;
        ((a) r104).a(r103, Integer.MIN_VALUE, null);
        return;
    L16:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(AoActivityResultRequest r100, Intent r101, a r102) {
        this.f198963d = r100;
        this.f198960a = r101;
        this.f198961b = 32766;
        this.f198962c = r102;
    }
}
