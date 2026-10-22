package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import iq5.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements n.a {
    public final /* synthetic */ u a;

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void M5() {
        this.a.e.V6();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void V3() {
        this.a.e.ke();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void h2() {
        this.a.e.Z3();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void k6() {
        this.a.e.E5();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void onCancelClick() {
        this.a.e.onCancelClick();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void p() {
        this.a.e.Ra();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void r3() {
        this.a.e.U5();
    }

    public v(u r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void J2(iq5.o r2) {
        Intrinsics.checkNotNullParameter(r2, "bean");
        this.a.e.RW(r2);
        a0.a(this.a.d, "click_recent_folder");
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void a6(View r1, int r2, td5.e r3) {
        Intrinsics.checkNotNullParameter(r3, "openFolderBean");
        this.a.e.tN(r2, r3);
        a0.a(this.a.d, "click_recent_folder");
    }
}
