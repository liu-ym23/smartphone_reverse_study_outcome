package com.bytedance.locallife.live.controller;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T> f259394a = null;

    static {
        f259394a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qs6.b r101 = LiveLifeSaaSUtil.t();
        String r102 = ((Throwable) r100).getMessage();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.i("LiveRefluxCtr", "inviteCallback network error ".concat(r102));
    }
}
