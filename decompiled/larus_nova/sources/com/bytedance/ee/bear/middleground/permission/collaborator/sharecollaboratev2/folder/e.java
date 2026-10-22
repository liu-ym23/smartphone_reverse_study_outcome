package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f233756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Long f233757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f233758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f233759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Boolean f233760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Integer f233761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Boolean f233762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f233763h;

    public e(long r100, Long r101, Integer r102, Integer r103, Boolean r104, Integer r105, Boolean r106, boolean r107) {
        this.f233756a = r100;
        this.f233757b = r101;
        this.f233758c = r102;
        this.f233759d = r103;
        this.f233760e = r104;
        this.f233761f = r105;
        this.f233762g = r106;
        this.f233763h = r107;
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
        int r101 = (int) (this.f233756a - this.f233757b.longValue());
        int r102 = (int) (r100 - this.f233756a);
        int r103 = this.f233758c.intValue();
        int r104 = this.f233759d.intValue();
        int r105 = this.f233758c.intValue() + this.f233759d.intValue();
        int r106 = ((this.f233758c.intValue() + this.f233759d.intValue()) + r101) + r102;
        Boolean r107 = this.f233760e;
        if (r107 == null) goto L5;
        boolean r110 = r107.booleanValue();
    L6:
        com.bytedance.ee.bear.middleground.permission.c.C(r103, r104, r101, r102, r105, r106, DocumentType.FOLDER_NAME, r110, this.f233761f.intValue(), this.f233762g.booleanValue());
        boolean r108 = !this.f233763h;
        Boolean r109 = this.f233760e;
        if (r109 == null) goto L9;
        boolean r111 = r109.booleanValue();
    L10:
        com.bytedance.ee.bear.middleground.permission.c.B(r108, DocumentType.FOLDER_NAME, r111, this.f233761f.intValue(), this.f233762g.booleanValue(), 0);
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
