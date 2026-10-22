package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t3 extends cd5.e {
    @Override // wc5.f.a
    public final void Qi() {
    }

    @Override // cd5.e
    public final String a() {
        return "shared";
    }

    @Override // cd5.e
    public final String c() {
        return "sharetome";
    }

    @Override // wc5.f.a
    public final void eF() {
    }

    @Override // cd5.e
    public final void d(BaseFragment r8, Context r9, View r10) {
        this.f = new p3(r9, r10);
        v1 r11 = new v1(r8, r9, new u1(this.k), this.f, this.k);
        this.e = r11;
        r11.create();
    }

    public t3(LazyBaseFragment r1, Context r2, View r3, ce5.a r4) {
        super(r4);
        this.a = r1;
        this.b = r2;
        d(r1, r2, r3);
    }
}
