package com.bytedance.ee.bear.search.picker.filter;

import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.config.condition.DocTypes;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import em5.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceSearchReloader extends e {
    public final boolean a;
    public final ArrayList<Integer> b;
    public final ArrayList<SearchChatterInfo> c;
    public final ArrayList<SearchBaseInfo> d;
    public final ArrayList<SearchSpaceInfo> e;
    public final SearchChatterInfo f;

    public static final class a {
    }

    static {
    }

    @Override // em5.e
    public final boolean b() {
        if (this.a == false) goto L5;
    L13:
        return false;
    L5:
        if (this.c.isEmpty() == false) goto L13;
        if (this.b.isEmpty() == false) goto L13;
        if (this.d.isEmpty() == false) goto L13;
        if (this.e.isEmpty() == false) goto L13;
        return true;
    }

    public SpaceSearchReloader(SpaceSearchFilterDataHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        super(r3);
        SearchChatterInfo r0 = new SearchChatterInfo();
        this.f = r0;
        this.a = r3.e.e;
        r0.setId(r3.d);
        this.b = r3.f.f;
        this.c = r3.h.f;
        this.d = r3.i.f;
        this.e = r3.g.f;
    }

    @Override // em5.e
    public final void c(PickerConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "pickerConfig");
        final ArrayList r0 = new ArrayList();
        final DocTypes r1 = com.bytedance.ee.bear.search.picker.b.a();
        tt5.a.h("SpaceSearchReloader", "updatePickerConfig, filter reload, defaultDocTypes=" + r1.getTypes());
        if (this.a == false) goto L5;
        r0.add(this.f);
    L6:
        r5.searcher(new SpaceSearchReloader$updatePickerConfig$1$1(this, r1, r0));
        r5.recommendList(new SpaceSearchReloader$updatePickerConfig$1$2(this, r1, r0));
        return;
    L5:
        r0.addAll(this.c);
        goto L6
    }
}
