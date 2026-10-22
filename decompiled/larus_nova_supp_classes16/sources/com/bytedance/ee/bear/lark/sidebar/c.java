package com.bytedance.ee.bear.lark.sidebar;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.sidebar.navigation.SidebarNavigationView;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ SidebarDocTabFragment a;

    public c(SidebarDocTabFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        ForsetiViewMode r7 = (ForsetiViewMode) r6;
        tt5.a.h("SidebarDocTabFragment", "observeForsetiMode:mode:" + r7 + ' ');
        SidebarDocTabFragment r0 = this.a;
        Intrinsics.checkNotNull(r7);
        if (r0.X == false) goto L12;
        r0.V = !r7.isCompact();
        SidebarNavigationView r1 = r0.M;
        if (r1 == null) goto L8;
        r1.v(r0, new ce5.a(r0), !r7.isCompact(), r0.U);
    L8:
        if (r7 == r0.W) goto L10;
    L11:
        r0.Ca0(r0.getRootView(), !r7.isCompact());
        goto L12
    L10:
        if (r0.G == false) goto L11;
    L12:
        r0.W = r7;
    }
}
