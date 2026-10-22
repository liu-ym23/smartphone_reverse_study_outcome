package com.bytedance.ee.bear.fileselector;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileSelectConfig f226787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ itb.e f226788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f226789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ itb.g f226790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f226791e;

    public e(FileSelectConfig r100, itb.e r101, FragmentActivity r102, itb.g r103, f r104) {
        this.f226787a = r100;
        this.f226788b = r101;
        this.f226789c = r102;
        this.f226790d = r103;
        this.f226791e = r104;
    }

    public final void a() {
        g r100 = g.f226794a;
        FileSelectConfig r101 = this.f226787a;
        r100.getClass();
        int r102 = r101.selectType;
        boolean r103 = true;
        if (r102 != 1) goto L5;
    L10:
        if (r103 == false) goto L12;
        boolean r104 = this.f226788b.M0(this.f226789c, this.f226790d, this.f226791e);
    L13:
        if (r104 == true) goto L16;
        tt5.a.k("OfficeMediaFileSelector", "host media api returned false");
        g.b(this.f226787a);
        return;
    L16:
        return;
    L12:
        r104 = this.f226788b.f0(this.f226789c, this.f226790d, this.f226791e);
        goto L13
    L5:
        if (r102 == 3) goto L7;
    L9:
        r103 = false;
        goto L10
    L7:
        if (r101.sourceType != 1) goto L9;
        goto L9
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
