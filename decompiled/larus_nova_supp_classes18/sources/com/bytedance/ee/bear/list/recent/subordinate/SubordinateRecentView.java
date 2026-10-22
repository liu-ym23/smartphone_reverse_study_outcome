package com.bytedance.ee.bear.list.recent.subordinate;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.g;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.list.d;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SubordinateRecentView extends g {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.folder.g, com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return "subordinate_recent";
    }

    @Override // com.bytedance.ee.bear.list.folder.g, com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "SubordinateRecentView";
    }

    @Override // com.bytedance.ee.bear.list.folder.g, com.bytedance.ee.bear.list.list.c
    public final d n1() {
        this.q = null;
        if (this.f == false) goto L5;
        d r0 = new GridStyleAdapter(WikiSpaceType.PERSONAL, this.D);
    L6:
        U2(r0);
        s2(r0);
        return r0;
    L5:
        final String r1 = this.z;
        final DocsLinearLayoutManager r2 = this.p;
        final ce5.a r3 = this.D;
        r0 = new SubordinateRecentView$getAdapter$adapter$1(r1, r2, r3);
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.folder.g, com.bytedance.ee.bear.list.list.c
    public final void x2() {
        super.x2();
        this.k.a(EmptyCategory.SUBORDINATE_RECENT);
    }

    @Override // com.bytedance.ee.bear.list.folder.g, com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r2) {
        Intrinsics.checkNotNullParameter(r2, "sortStrategy");
        super.P2(r2);
        this.k.f(EmptyCategory.SUBORDINATE_RECENT);
    }

    public SubordinateRecentView(Context r2, View r3, LifeCycleFragment r4, g.b r5, ce5.a r6) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "dependence");
        Intrinsics.checkNotNullParameter(r6, "userComponentAbility");
        super(r2, r3, r4, r5, r6);
    }
}
