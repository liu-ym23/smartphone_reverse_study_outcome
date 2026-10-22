package com.ss.android.lark.search.doubao.chat;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes38.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoChatSearchFragment f440053a;

    public b(DoubaoChatSearchFragment r100) {
        this.f440053a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        this.f440053a.getContext();
    }
}
