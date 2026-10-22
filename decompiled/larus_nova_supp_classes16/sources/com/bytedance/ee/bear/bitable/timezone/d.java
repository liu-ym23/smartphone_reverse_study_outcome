package com.bytedance.ee.bear.bitable.timezone;

import com.bytedance.ee.util.ui.j;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements com.bytedance.ee.bear.facade.common.widget.d.InterfaceC0190d {
    public int a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ BitableTimeZoneListFragment c;

    @Override // com.bytedance.ee.bear.facade.common.widget.d.InterfaceC0190d
    public final /* synthetic */ void c() {
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.InterfaceC0190d
    public final void a() {
        if (this.a == this.b.element) goto L6;
        BitableTimeZoneListFragment r0 = this.c;
        boolean r1 = BitableTimeZoneListFragment.j;
        r0.getClass();
        j.d(new e(r0), 200);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.InterfaceC0190d
    public final void b(int r1) {
        this.a = r1;
    }

    public d(Ref.IntRef r1, BitableTimeZoneListFragment r2) {
        this.b = r1;
        this.c = r2;
    }
}
