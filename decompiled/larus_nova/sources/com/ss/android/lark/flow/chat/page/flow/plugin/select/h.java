package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import java.util.Comparator;

/* JADX INFO: loaded from: classes36.dex */
public final class h<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T> f422859a = null;

    static {
        f422859a = new h();
    }

    public h() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return ((com.ss.android.lark.biz.im.api.extension.message.i) r100).getId() - ((com.ss.android.lark.biz.im.api.extension.message.i) r101).getId();
    }
}
