package com.ss.android.lark.contact.impl.group.manage;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends LKUIPtrDefaultHandler2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyManageGroupView f419519a;

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler
    public final void onRefreshBegin(LKUIPtrFrameLayout r100) {
    }

    public g(MyManageGroupView r100) {
        this.f419519a = r100;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final void onLoadMoreBegin(LKUIPtrFrameLayout r100) {
        this.f419519a.f419507c.Z7();
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2, com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r100, View r101, View r102) {
        if (super.checkCanDoLoadMore(r100, r101, r102) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f419519a.f419507c.canLoadMore() == false) goto L7;
        return true;
    }
}
