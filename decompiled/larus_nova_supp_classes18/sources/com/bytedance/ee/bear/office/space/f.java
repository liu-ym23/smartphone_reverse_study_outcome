package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.OfficeListPageMenuCapabilityRegistry;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ OfficeSpaceFragment a;

    public f(OfficeSpaceFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        OfficeSpaceFragment r5 = this.a;
        int r0 = OfficeSpaceFragment.v;
        OfficeSpaceTab r6 = r5.W90();
        if (r6 == null) goto L13;
        OfficeSpaceFragment r1 = this.a;
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r2 = com.bytedance.ee.bear.office.list.h.a;
        String r3 = r1.Z90();
        Intrinsics.checkNotNullParameter(r6, "tab");
        OfficeListPageMenuCapabilityRegistry.a.getClass();
        com.bytedance.ee.bear.office.list.i r7 = OfficeListPageMenuCapabilityRegistry.a(r3, r6);
        if (r7 == null) goto L9;
        ed5.d r8 = r7.b();
        if (r8 == null) goto L9;
        r8.xk();
    L9:
        com.bytedance.ee.bear.office.list.p r9 = com.bytedance.ee.bear.office.list.h.c(r3, r6);
        if (r9 == null) goto L12;
        r9.xT();
    L12:
        com.bytedance.ee.bear.office.list.h.i(r3, false, 0);
    L13:
        this.a.ba0(false, 0);
    }
}
