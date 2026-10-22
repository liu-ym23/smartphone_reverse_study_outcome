package com.ss.android.lark.contact.customized.mygroup.view;

import android.view.View;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends LKUIPtrDefaultHandler2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeMyJoinGroupFragment f419314a;

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler
    public final void onRefreshBegin(LKUIPtrFrameLayout r100) {
    }

    public d(OfficeMyJoinGroupFragment r100) {
        this.f419314a = r100;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final void onLoadMoreBegin(LKUIPtrFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        OfficeMyJoinGroupFragment r101 = this.f419314a;
        int r102 = OfficeMyJoinGroupFragment.f419302i;
        r101.S90().loadMore();
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2, com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.FOOTER);
        if (super.checkCanDoLoadMore(r100, r101, r102) == false) goto L7;
        OfficeMyJoinGroupFragment r103 = this.f419314a;
        int r104 = OfficeMyJoinGroupFragment.f419302i;
        if (r103.S90().canLoadMore() == false) goto L7;
        return true;
    L7:
        return false;
    }
}
