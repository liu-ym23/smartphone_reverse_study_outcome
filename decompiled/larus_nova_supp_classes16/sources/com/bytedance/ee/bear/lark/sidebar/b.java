package com.bytedance.ee.bear.lark.sidebar;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements gqa.d {
    public final /* synthetic */ SidebarDocTabFragment a;
    public final /* synthetic */ SmartRefreshLayout b;

    public b(SidebarDocTabFragment r1, SmartRefreshLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d2(cqa.h r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        SidebarDocTabFragment r4 = this.a;
        int r0 = SidebarDocTabFragment.Y;
        HomeTabAdapter r5 = r4.p;
        Fragment r1 = null;
        if (r5 == null) goto L5;
        Fragment r2 = r5.c;
    L7:
        if ((r2 instanceof wc5.e) == false) goto L12;
        if (r5 == null) goto L10;
        r1 = r5.c;
    L10:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.list.homepage.IHomeSubFragment");
        ((wc5.e) r1).d2(this.b);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L7
    }
}
