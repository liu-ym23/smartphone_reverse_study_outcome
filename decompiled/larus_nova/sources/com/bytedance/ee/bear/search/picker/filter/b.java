package com.bytedance.ee.bear.search.picker.filter;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import em5.c;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends BaseSearchFilterView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.search.a f236857d;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.ee.bear.search.a getFolderInfo() {
        return this.f236857d;
    }

    public b(com.bytedance.ee.bear.search.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null);
        this.f236857d = r100;
        b();
        int r102 = c.f473092a;
        Context r103 = getContext();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        setFilterDataHolder(new SpaceSearchFilterDataHolder(r103));
        List<cpc.a> r104 = getFilterDataHolder().f473089b;
        FilterViewV2 r105 = getFilterView();
        if (r105 == null) goto L5;
        r105.a(r104);
    L5:
        if (r100 == null) goto L7;
        em5.b r106 = getFilterDataHolder();
        SearchSpaceInfo r107 = new SearchSpaceInfo();
        r107.setDocType(Doc.Type.FOLDER);
        r107.setTitle(r100.f236826b);
        r107.setId(r100.f236825a);
        r107.setIsShareFolder(Boolean.valueOf(r100.f236827c));
        Unit r108 = Unit.INSTANCE;
        r106.c("doc/in/folder", CollectionsKt.arrayListOf(new SearchSpaceInfo[]{r107}), new SpaceSearchFilterView$initFilterData$1$2(this));
    L10:
        BaseSearchFilterView$initItemClickListener$itemClickListener$1 r109 = new BaseSearchFilterView$initItemClickListener$itemClickListener$1(this);
        FilterViewV2 r110 = this.f236839a;
        if (r110 == null) goto L14;
        r110.setOnFilterItemClick(r109);
        return;
    L14:
        return;
    L7:
        FilterViewV2 r111 = getFilterView();
        if (r111 == null) goto L10;
        r111.b();
        goto L10
    }
}
