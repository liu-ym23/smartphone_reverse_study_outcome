package com.bytedance.ee.bear.lark.sidebar;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ SidebarDocTabFragment a;
    public final /* synthetic */ FolderSortStrategy b;

    public e(SidebarDocTabFragment r1, FolderSortStrategy r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        mc5.j r4 = this.a.P;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("listDatabaseService");
        r4 = null;
    L6:
        r4.D3(this.b);
        SortAndFilterViewModel r5 = this.a.s;
        if (r5 == null) goto L10;
        r5.postSortStrategy(this.b);
        return;
    }
}
