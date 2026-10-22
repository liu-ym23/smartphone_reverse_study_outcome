package com.bytedance.ee.bear.bitable.share.view.memberview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f215523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Long f215524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f215525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f215526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Boolean f215527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Integer f215528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Boolean f215529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f215530h;

    public c(long r100, Long r101, Integer r102, Integer r103, Boolean r104, Integer r105, Boolean r106, boolean r107) {
        this.f215523a = r100;
        this.f215524b = r101;
        this.f215525c = r102;
        this.f215526d = r103;
        this.f215527e = r104;
        this.f215528f = r105;
        this.f215529g = r106;
        this.f215530h = r107;
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
        int r101 = (int) (this.f215523a - this.f215524b.longValue());
        int r102 = (int) (r100 - this.f215523a);
        int r103 = this.f215525c.intValue();
        int r104 = this.f215526d.intValue();
        int r105 = this.f215525c.intValue() + this.f215526d.intValue();
        int r106 = ((this.f215525c.intValue() + this.f215526d.intValue()) + r101) + r102;
        Boolean r107 = this.f215527e;
        if (r107 == null) goto L5;
        boolean r110 = r107.booleanValue();
    L6:
        com.bytedance.ee.bear.middleground.permission.c.C(r103, r104, r101, r102, r105, r106, "bitable_share_form", r110, this.f215528f.intValue(), this.f215529g.booleanValue());
        boolean r108 = !this.f215530h;
        Boolean r109 = this.f215527e;
        if (r109 == null) goto L9;
        boolean r111 = r109.booleanValue();
    L10:
        com.bytedance.ee.bear.middleground.permission.c.B(r108, "bitable_share_form", r111, this.f215528f.intValue(), this.f215529g.booleanValue(), 0);
        return;
    L9:
        r111 = false;
        goto L10
    L5:
        r110 = false;
        goto L6
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
}
