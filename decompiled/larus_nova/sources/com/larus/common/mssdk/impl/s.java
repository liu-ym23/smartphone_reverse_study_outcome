package com.larus.common.mssdk.impl;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.common_ui.dialog.k1;
import com.larus.network.HttpConst;

/* JADX INFO: loaded from: classes27.dex */
public final class s implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f326421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f326422b;

    @Override // com.larus.common_ui.dialog.k1
    public final void a() {
        com.bytedance.router.i r100 = SmartRouter.buildRoute(this.f326421a, this.f326422b);
        HttpConst.f359979a.getClass();
        String r101 = HttpConst.L;
        r100.f267554c.putExtra("open_link", r101);
        r100.d();
    }

    @Override // com.larus.common_ui.dialog.k1
    public final void b() {
        com.bytedance.router.i r100 = SmartRouter.buildRoute(this.f326421a, this.f326422b);
        HttpConst.f359979a.getClass();
        String r101 = HttpConst.M;
        r100.f267554c.putExtra("open_link", r101);
        r100.d();
    }

    public s(FragmentActivity r100) {
        this.f326421a = r100;
        this.f326422b = "//flow/privacy_web";
    }
}
