package com.bytedance.android.shopping.store.moments.module.presenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends com.bytedance.android.ec.store.utils.j {
    public final /* synthetic */ ECStoreShortVideoPresenterNew a;

    public final void a() {
        this.a.i0().isMute().setValue(Boolean.TRUE);
    }

    public final void b() {
        if (this.a.A.getStoreParam().isSplitMode() == true) goto L6;
        this.a.i0().isMute().setValue(Boolean.FALSE);
        return;
    }

    public o(ECStoreShortVideoPresenterNew r1) {
        this.a = r1;
    }
}
