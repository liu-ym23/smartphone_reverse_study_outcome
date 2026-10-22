package com.ss.android.ainote.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f407108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f407109c;

    public t(AINoteListView r100, long r101) {
        this.f407107a = r100;
        this.f407108b = r101;
        this.f407109c = "create_focus_protection_finish";
    }

    @Override // java.lang.Runnable
    public final void run() {
        Long r100 = this.f407107a.f406973k;     // Catch: Throwable -> L9
        long r101 = this.f407108b;     // Catch: Throwable -> L9
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.longValue() != r101) goto L16;
        this.f407107a.H();     // Catch: Throwable -> L9
        this.f407107a.o(this.f407108b, this.f407109c, 2);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
