package com.relax;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f405698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f405699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f405700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f405701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RelaxView f405702e;

    public final void a() {
        RelaxEngine r100 = this.f405702e.f404565e;
        int r101 = this.f405698a;
        int r102 = this.f405699b;
        int r103 = this.f405700c;
        int r104 = this.f405701d;
        if (r100.f404544c.b() == true) goto L6;
        return;
    L6:
        if (r100.f404543b == null) goto L20;
        RelaxEngine.a r105 = r100.f404545d;
        if (r105.f404552g == r101) goto L11;
    L16:
        r105.f404552g = r101;
        r105.f404553h = r103;
        r105.f404554i = r102;
        r105.f404555j = r104;
        r100.b(false);
        return;
    L11:
        if (r105.f404553h != r103) goto L16;
        if (r105.f404554i != r102) goto L16;
        if (r105.f404555j != r104) goto L16;
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

    public u(RelaxView r100, int r101, int r102, int r103, int r104) {
        this.f405702e = r100;
        this.f405698a = r101;
        this.f405699b = r102;
        this.f405700c = r103;
        this.f405701d = r104;
    }
}
