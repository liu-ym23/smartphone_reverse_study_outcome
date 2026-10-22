package com.ss.android.lark.search.ui.result;

import android.view.View;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends LKUIPtrDefaultHandler2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchResultView f440296a;

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler, com.ss.android.lark.widget.ptr.LKUIPtrHandler
    public final boolean checkCanDoRefresh(LKUIPtrFrameLayout r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "header");
        return false;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler
    public final void onRefreshBegin(LKUIPtrFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
    }

    public c(SearchResultView r100) {
        this.f440296a = r100;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final void onLoadMoreBegin(LKUIPtrFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        SearchResultView.d r101 = this.f440296a.f440272q;
        if (r101 == null) goto L6;
        r101.onLoadMore();
        return;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2, com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.FOOTER);
        if (super.checkCanDoLoadMore(r100, r101, r102) == false) goto L13;
        SearchResultView r103 = this.f440296a;
        if (r103.A == false) goto L14;
        SearchResultView.d r104 = r103.f440272q;
        if (r104 == null) goto L9;
        boolean r105 = r104.canLoadMore();
    L10:
        if (r105 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r105 = false;
        goto L10
    L14:
        return false;
    L13:
        return false;
    }
}
