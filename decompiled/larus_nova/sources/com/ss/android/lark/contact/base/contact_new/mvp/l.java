package com.ss.android.lark.contact.base.contact_new.mvp;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public final class l extends LKUIPtrDefaultHandler2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewContactView f418753a;

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler
    public final void onRefreshBegin(LKUIPtrFrameLayout r100) {
    }

    public l(NewContactView r100) {
        this.f418753a = r100;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final void onLoadMoreBegin(LKUIPtrFrameLayout r100) {
        this.f418753a.f418717b.T();
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2, com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r100, View r101, View r102) {
        if (super.checkCanDoLoadMore(r100, r101, r102) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f418753a.f418717b.canLoadMore() == false) goto L7;
        return true;
    }
}
