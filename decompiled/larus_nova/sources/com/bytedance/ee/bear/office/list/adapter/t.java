package com.bytedance.ee.bear.office.list.adapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f235859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeLongPressMenuAction f235860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z f235861c;

    public t(x r100, OfficeLongPressMenuAction r101, z r102) {
        this.f235859a = r100;
        this.f235860b = r101;
        this.f235861c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x r100 = this.f235859a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.a(this.f235860b, this.f235861c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
