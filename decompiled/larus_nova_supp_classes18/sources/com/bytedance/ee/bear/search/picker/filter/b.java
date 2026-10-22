package com.bytedance.ee.bear.search.picker.filter;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import em5.c;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends BaseSearchFilterView {
    public final com.bytedance.ee.bear.search.a d;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.ee.bear.search.a getFolderInfo() {
        return this.d;
    }

    public b(com.bytedance.ee.bear.search.a r4, Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null);
        this.d = r4;
        b();
        int r6 = c.a;
        Context r7 = getContext();
        Intrinsics.checkNotNullParameter(r7, "context");
        setFilterDataHolder(new SpaceSearchFilterDataHolder(r7));
        List<cpc.a> r8 = getFilterDataHolder().b;
        FilterViewV2 r0 = getFilterView();
        if (r0 == null) goto L5;
        r0.a(r8);
    L5:
        if (r4 == null) goto L7;
        em5.b r9 = getFilterDataHolder();
        SearchSpaceInfo r1 = new SearchSpaceInfo();
        r1.setDocType(Doc.Type.FOLDER);
        r1.setTitle(r4.b);
        r1.setId(r4.a);
        r1.setIsShareFolder(Boolean.valueOf(r4.c));
        Unit r10 = Unit.INSTANCE;
        r9.c("doc/in/folder", CollectionsKt.arrayListOf(new SearchSpaceInfo[]{r1}), new SpaceSearchFilterView$initFilterData$1$2(this));
    L10:
        BaseSearchFilterView$initItemClickListener$itemClickListener$1 r11 = new BaseSearchFilterView$initItemClickListener$itemClickListener$1(this);
        FilterViewV2 r12 = this.a;
        if (r12 == null) goto L14;
        r12.setOnFilterItemClick(r11);
        return;
    L14:
        return;
    L7:
        FilterViewV2 r13 = getFilterView();
        if (r13 == null) goto L10;
        r13.b();
        goto L10
    }
}
