package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends LKUIPtrDefaultHandler2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileListView f421765a;

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler
    public final void onRefreshBegin(LKUIPtrFrameLayout r100) {
    }

    public e(FileListView r100) {
        this.f421765a = r100;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final void onLoadMoreBegin(LKUIPtrFrameLayout r100) {
        j.a r101 = this.f421765a.f421746i;
        if (r101 == null) goto L6;
        r101.onLoadMore();
        return;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2, com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r100, View r101, View r102) {
        if (super.checkCanDoLoadMore(r100, r101, r102) == false) goto L11;
        j.a r103 = this.f421765a.f421746i;
        if (r103 == null) goto L7;
        boolean r104 = r103.o0();
    L8:
        if (r104 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r104 = false;
        goto L8
    L11:
        return false;
    }
}
