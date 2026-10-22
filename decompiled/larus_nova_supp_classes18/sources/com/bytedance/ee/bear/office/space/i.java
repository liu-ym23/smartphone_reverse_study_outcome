package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements Runnable {
    public final /* synthetic */ OfficeSpaceFragment a;
    public final /* synthetic */ OfficeSpaceTab b;
    public final /* synthetic */ View c;

    public i(OfficeSpaceFragment r1, OfficeSpaceTab r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        OfficeSpaceFragment r0 = this.a;
        boolean r1 = false;
        r0.n = false;
        if (r0.isAdded() == true) goto L5;
    L13:
        StringBuilder r2 = new StringBuilder("abort header more retry, page state changed, runtime=");
        OfficeSpaceFragment r5 = this.a;
        r2.append(r5.da0(r5.Z90()));
        r2.append(", tab=");
        r2.append(this.b);
        r2.append(", currentTab=");
        r2.append(this.a.W90());
        r2.append(", hostAdded=");
        r2.append(this.a.isAdded());
        r2.append(", hasView=");
        if (this.a.getView() == null) goto L16;
        r1 = true;
    L16:
        r2.append(r1);
        r2.append(", anchor=");
        OfficeSpaceFragment r3 = this.a;
        View r4 = this.c;
        r3.getClass();
        r2.append(OfficeSpaceFragment.aa0(r4));
        tt5.a.h("OfficeSpaceFragment", r2.toString());
        return;
    L5:
        if (this.a.getView() == null) goto L13;
        OfficeSpaceTab r6 = this.a.W90();
        OfficeSpaceTab r7 = this.b;
        if (r6 != r7) goto L13;
        if (this.a.X90(this.c, r7) == true) goto L18;
        StringBuilder r8 = new StringBuilder("show header more menu failed after space retry, runtime=");
        OfficeSpaceFragment r9 = this.a;
        r8.append(r9.da0(r9.Z90()));
        r8.append(", tab=");
        r8.append(this.b);
        r8.append(", anchor=");
        OfficeSpaceFragment r10 = this.a;
        View r11 = this.c;
        r10.getClass();
        r8.append(OfficeSpaceFragment.aa0(r11));
        tt5.a.h("OfficeSpaceFragment", r8.toString());
        UDToast.a r12 = UDToast.build(this.c.getContext());
        r12.b.e(2131886372);
        r12.b.d = -1;
        r12.h();
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
}
