package com.bytedance.ee.bear.search.picker.filter.wiki;

import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiSearchReloader extends em5.e {
    public final ArrayList<Integer> a;
    public final ArrayList<SearchChatterInfo> b;
    public final ArrayList<SearchBaseInfo> c;
    public final ArrayList<SearchWikiSpaceInfo> d;

    @Override // em5.e
    public final boolean b() {
        if (this.b.isEmpty() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.c.isEmpty() == false) goto L11;
        if (this.a.isEmpty() == false) goto L11;
        if (this.d.isEmpty() == false) goto L11;
        return true;
    }

    public WikiSearchReloader(WikiSearchFilterDataHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        super(r2);
        this.a = r2.e.f;
        this.b = r2.f.f;
        this.c = r2.g.f;
        this.d = r2.d.f;
    }

    @Override // em5.e
    public final void c(PickerConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "pickerConfig");
        r2.searcher(new WikiSearchReloader$updatePickerConfig$1$1(this));
        r2.recommendList(new WikiSearchReloader$updatePickerConfig$1$2(this));
    }
}
