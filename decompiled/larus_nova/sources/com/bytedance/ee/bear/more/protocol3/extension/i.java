package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T> f234833a = null;

    static {
        f234833a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DefMoreInfoBehavior", "feedShortcutFlow err. ", (Throwable) r100, false);
    }
}
