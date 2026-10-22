package com.bytedance.ee.bear.office.space;

import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements Runnable {
    public final /* synthetic */ OfficeSpaceFragment a;
    public final /* synthetic */ OfficeSpaceTab b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ViewPager2 d;
    public final /* synthetic */ int e;
    public final /* synthetic */ long f;

    public h(OfficeSpaceFragment r1, OfficeSpaceTab r2, String r3, ViewPager2 r4, int r5, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r0 = com.bytedance.ee.bear.office.list.h.a;
        OfficeSpaceFragment r1 = this.a;
        int r2 = OfficeSpaceFragment.v;
        boolean r3 = com.bytedance.ee.bear.office.list.h.e(r1.Z90(), this.b);
        if (r3 == false) goto L5;
        String r4 = "tab_preload_success";
    L6:
        StringBuilder r5 = new StringBuilder("[OfficeCreatePerf] stage=");
        r5.append(r4);
        r5.append(" runtime=");
        OfficeSpaceFragment r6 = this.a;
        r5.append(r6.da0(r6.Z90()));
        r5.append(" tab=");
        r5.append(this.b);
        r5.append(" reason=");
        r5.append(this.c);
        r5.append(" ready=");
        r5.append(r3);
        r5.append(" offscreen=");
        r5.append(this.d.getOffscreenPageLimit());
        r5.append(" currentIndex=");
        r5.append(this.d.getCurrentItem());
        r5.append(" targetIndex=");
        r5.append(this.e);
        r5.append(" elapsed=");
        r5.append(System.currentTimeMillis() - this.f);
        tt5.a.h("OfficeSpaceFragment", r5.toString());
        return;
    L5:
        r4 = "tab_preload_pending";
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
