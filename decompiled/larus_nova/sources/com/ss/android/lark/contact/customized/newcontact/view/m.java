package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class m extends LKUIPtrDefaultHandler2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f419389a;

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler
    public final void onRefreshBegin(LKUIPtrFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
    }

    public m(l r100) {
        this.f419389a = r100;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final void onLoadMoreBegin(LKUIPtrFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        l.a r101 = this.f419389a.f419384c;
        if (r101 == null) goto L6;
        r101.T();
        return;
    }

    @Override // com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2, com.ss.android.lark.widget.ptr.LKUIPtrHandler2
    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.FOOTER);
        if (super.checkCanDoLoadMore(r100, r101, r102) == false) goto L13;
        l.a r103 = this.f419389a.f419384c;
        if (r103 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r103.canLoadMore() != true) goto L9;
        r104 = true;
        goto L10
    L13:
        return false;
    }
}
