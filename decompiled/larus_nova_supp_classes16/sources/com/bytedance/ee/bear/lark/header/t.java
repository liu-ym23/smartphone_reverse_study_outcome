package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.banner.bean.BannerScene;
import com.bytedance.ee.bear.contract.ConnectionService;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t implements i {
    public FrameLayout a;
    public com.bytedance.ee.bear.banner.d b;
    public mn4.a c;
    public com.bytedance.creativex.mediaimport.preview.internal.main.g d;
    public Disposable e;
    public boolean f;
    public final boolean g;
    public final BannerScene h;
    public final String i;

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r1) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("UGHeader", "destroy()...");
        this.a = null;
        com.bytedance.ee.bear.banner.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        mn4.a r1 = this.c;
        if (r1 == null) goto L8;
        r1.a(this.d);
    L8:
        Disposable r2 = this.e;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.isDisposed() == true) goto L15;
        this.e.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return this.g;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.f;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(final Context r3) {
        tt5.a.h("UGHeader", "initData()...enableUgReach  ");
        this.f = true;
        com.bytedance.ee.bear.banner.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.e = ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().e().subscribe(new r(this, r3), new s());
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r3) {
        tt5.a.h("UGHeader", "createView()...");
        FrameLayout r0 = new FrameLayout(r3);
        this.a = r0;
        return r0;
    }

    public t(boolean r1, BannerScene r2, String r3) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
    }
}
