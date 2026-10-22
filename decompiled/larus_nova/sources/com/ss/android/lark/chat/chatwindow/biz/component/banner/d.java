package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import java.util.Comparator;

/* JADX INFO: loaded from: classes35.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f411979a = null;

    static {
        f411979a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return ((wya.b) r100).getPriority() - ((wya.b) r101).getPriority();
    }
}
