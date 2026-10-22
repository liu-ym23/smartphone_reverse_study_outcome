package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.shopping.searchsimilar.model.SortRuleInfo;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public boolean a;
    public List<SortRuleInfo> b;
    public TabLayout c;
    public SimilarProductVM d;
    public int e;
    public int f;

    public static final class a {
    }

    static {
    }

    public h() {
        this.a = true;
        this.b = new ArrayList();
        this.e = -1;
        this.f = 1;
    }

    public final List<Integer> a(int r2) {
        SortRuleInfo r3 = (SortRuleInfo) CollectionsKt.getOrNull(this.b, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getSubSortType();
    }
}
