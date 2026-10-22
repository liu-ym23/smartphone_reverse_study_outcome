package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import iq5.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v implements n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f241215a;

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void M5() {
        this.f241215a.f241208e.V6();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void V3() {
        this.f241215a.f241208e.ke();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void h2() {
        this.f241215a.f241208e.Z3();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void k6() {
        this.f241215a.f241208e.E5();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void onCancelClick() {
        this.f241215a.f241208e.onCancelClick();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void p() {
        this.f241215a.f241208e.Ra();
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void r3() {
        this.f241215a.f241208e.U5();
    }

    public v(u r100) {
        this.f241215a = r100;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void J2(iq5.o r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        this.f241215a.f241208e.RW(r100);
        a0.a(this.f241215a.f241207d, "click_recent_folder");
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n.a
    public final void a6(View r100, int r101, td5.e r102) {
        Intrinsics.checkNotNullParameter(r102, "openFolderBean");
        this.f241215a.f241208e.tN(r101, r102);
        a0.a(this.f241215a.f241207d, "click_recent_folder");
    }
}
