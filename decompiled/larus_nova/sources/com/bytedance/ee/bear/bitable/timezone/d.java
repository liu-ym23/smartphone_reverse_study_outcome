package com.bytedance.ee.bear.bitable.timezone;

import com.bytedance.ee.util.ui.j;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements com.bytedance.ee.bear.facade.common.widget.d.InterfaceC3246d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f215953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f215954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableTimeZoneListFragment f215955c;

    @Override // com.bytedance.ee.bear.facade.common.widget.d.InterfaceC3246d
    public final /* synthetic */ void c() {
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.InterfaceC3246d
    public final void a() {
        if (this.f215953a == this.f215954b.element) goto L6;
        BitableTimeZoneListFragment r100 = this.f215955c;
        boolean r101 = BitableTimeZoneListFragment.f215939j;
        r100.getClass();
        j.d(new e(r100), 200);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.InterfaceC3246d
    public final void b(int r100) {
        this.f215953a = r100;
    }

    public d(Ref.IntRef r100, BitableTimeZoneListFragment r101) {
        this.f215954b = r100;
        this.f215955c = r101;
    }
}
