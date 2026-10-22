package com.ss.android.lark.search.ui.result;

import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchResultView f440306a;

    public d(SearchResultView r100) {
        this.f440306a = r100;
    }

    @Override // v3c.g
    public final void onItemClick(SearchBaseInfo r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        g r103 = this.f440306a.f440271p;
        if (r103 == null) goto L6;
        r103.onItemClick(r100, r101, r102);
        return;
    }
}
