package com.bytedance.ee.bear.search.picker.filter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterViewItemDecoration;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterAdapterV2;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import em5.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001bJ\u0010\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010#J\u001e\u0010&\u001a\u00020\u001b2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*J\u0010\u0010+\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010#J\u0010\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010#J\u0006\u0010/\u001a\u00020\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/BaseSearchFilterView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "filterView", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2;", "getFilterView", "()Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2;", "setFilterView", "(Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2;)V", "listener", "Lcom/bytedance/ee/bear/search/picker/filter/SearchFilterSelectListener;", "getListener", "()Lcom/bytedance/ee/bear/search/picker/filter/SearchFilterSelectListener;", "setListener", "(Lcom/bytedance/ee/bear/search/picker/filter/SearchFilterSelectListener;)V", "filterDataHolder", "Lcom/bytedance/ee/bear/search/picker/filter/base/SearchFilterDataHolder;", "getFilterDataHolder", "()Lcom/bytedance/ee/bear/search/picker/filter/base/SearchFilterDataHolder;", "setFilterDataHolder", "(Lcom/bytedance/ee/bear/search/picker/filter/base/SearchFilterDataHolder;)V", "initView", "", "initItemDecoration", "updateFilterView", "filterData", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "initItemClickListener", "setChatList", "chatInfo", "Ljava/io/Serializable;", "setWikiSpaceList", "wikiSpaceInfo", "setTypeList", "selectTypeItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/search/picker/filter/type/SelectTypeItem;", "Lkotlin/collections/ArrayList;", "setOwnerList", "chatterInfo", "setFolderList", "folderInfo", "doSearch", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseSearchFilterView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FilterViewV2 f236839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.search.picker.filter.a f236840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public em5.b f236841c;

    public static final class a {
    }

    public static final class b implements FilterViewV2.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSearchFilterView f236842a;

        @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.d
        public final void a() {
            Iterator r100 = ((ArrayList) this.f236842a.getFilterDataHolder().f473089b).iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((cpc.a) r100.next()).c();
            goto L4
        L6:
            FilterViewV2 r101 = this.f236842a.getFilterView();
            if (r101 == null) goto L17;
            List<cpc.a> r102 = this.f236842a.getFilterDataHolder().f473089b;
            Intrinsics.checkNotNullParameter(r102, "collection");
            if ((!r102.isEmpty()) == false) goto L17;
            FilterAdapterV2 r103 = r101.f460996d;
            if (r103 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
            r103 = null;
        L13:
            r103.getClass();
            Intrinsics.checkNotNullParameter(r102, "collection");
            ((ArrayList) r103.f460929b).clear();
            if ((!r102.isEmpty()) == false) goto L16;
            ((ArrayList) r103.f460929b).addAll(r102);
        L16:
            r103.notifyDataSetChanged();
        L17:
            FilterViewV2 r104 = this.f236842a.getFilterView();
            if (r104 == null) goto L20;
            r104.b();
        L20:
            this.f236842a.a();
        }

        public b(BaseSearchFilterView r100) {
            this.f236842a = r100;
        }
    }

    static {
    }

    public final em5.b getFilterDataHolder() {
        em5.b r100 = this.f236841c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("filterDataHolder");
        return null;
    }

    public final void a() {
        e r100 = getFilterDataHolder().a();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L11;
        FilterViewV2 r102 = this.f236839a;
        if (r102 == null) goto L14;
        r102.b();
    L14:
        com.bytedance.ee.bear.search.picker.filter.a r103 = this.f236840b;
        if (r103 == null) goto L18;
        r103.M60(r100);
        return;
    L18:
        return;
    L11:
        FilterViewV2 r104 = this.f236839a;
        if (r104 == null) goto L14;
        r104.c();
        goto L14
    L5:
        if (r100.b() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.search_filter_tab_layout, this);
        FilterViewV2 r100 = (FilterViewV2) findViewById(R.id.search_filter_view);
        this.f236839a = r100;
        if (r100 == null) goto L5;
        r100.setGradientBorderBackground(R.drawable.filter_view_reset_bg);
    L5:
        FilterViewV2 r101 = this.f236839a;
        if (r101 == null) goto L8;
        r101.setOnResetClick(new b(this));
    L8:
        FilterViewV2 r102 = this.f236839a;
        if (r102 == null) goto L13;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L13;
        r103.width = -1;
        r103.height = n.d(44);
    L13:
        FilterViewV2 r104 = this.f236839a;
        if (r104 == null) goto L23;
        RecyclerView r105 = (RecyclerView) r104.findViewById(R.id.filter_rv);
        if (r105 == null) goto L24;
        int r106 = r105.getItemDecorationCount();
        int r107 = 0;
    L18:
        if (r107 >= r106) goto L20;
        r105.removeItemDecorationAt(r107);
        r107 = r107 + 1;
        goto L18
    L20:
        r105.addItemDecoration(new FilterViewItemDecoration(n.c(12.0f), n.c(6.0f), n.c(12.0f), n.c(6.0f), n.c(10.0f)));
        return;
    L24:
        return;
    }

    public final FilterViewV2 getFilterView() {
        return this.f236839a;
    }

    public final com.bytedance.ee.bear.search.picker.filter.a getListener() {
        return this.f236840b;
    }

    public BaseSearchFilterView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void c(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "filterData");
        FilterViewV2 r101 = this.f236839a;
        if (r101 == null) goto L5;
        r101.update(r100);
    L5:
        a();
    }

    public final void setChatList(Serializable r100) {
    L8:
        e = move-exception;
        tt5.a.d("SpaceSearchFilterView", "select chat info parse json error:" + e.getMessage() + ", json:");
        return;
    L3:
        if ((r100 instanceof ArrayList) == false) goto L5;
        ArrayList r101 = (ArrayList) r100;     // Catch: Exception -> L8
    L6:
        getFilterDataHolder().c("doc/in/chat", r101, new AnonymousClass1(this));     // Catch: Exception -> L8
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setFilterDataHolder(em5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f236841c = r100;
    }

    public final void setFilterView(FilterViewV2 r100) {
        this.f236839a = r100;
    }

    public final void setFolderList(Serializable r100) {
    L9:
        e = move-exception;
        tt5.a.d("SpaceSearchFilterView", "select folder info parse json error:" + e.getMessage() + ", origin list:" + r100);
        return;
    L3:
        if ((r100 instanceof ArrayList) == false) goto L5;
        ArrayList r101 = (ArrayList) r100;     // Catch: Exception -> L9
    L6:
        if (r101 == null) goto L14;
        getFilterDataHolder().c("doc/in/folder", r101, new BaseSearchFilterView$setFolderList$1$1(this));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setListener(com.bytedance.ee.bear.search.picker.filter.a r100) {
        this.f236840b = r100;
    }

    public final void setOwnerList(Serializable r100) {
    L8:
        e = move-exception;
        tt5.a.d("SpaceSearchFilterView", "select owner info parse json error:" + e.getMessage() + ", origin json:" + r100);
        return;
    L3:
        if ((r100 instanceof ArrayList) == false) goto L5;
        ArrayList r101 = (ArrayList) r100;     // Catch: Exception -> L8
    L6:
        getFilterDataHolder().c("doc/owner", r101, new C105381(this));     // Catch: Exception -> L8
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setTypeList(ArrayList<com.bytedance.ee.bear.search.picker.filter.type.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectTypeItems");
        getFilterDataHolder().c("doc/type", r100, new C105391(this));
    }

    public final void setWikiSpaceList(Serializable r100) {
    L9:
        e = move-exception;
        tt5.a.d("SpaceSearchFilterView", "select folder info parse json error:" + e.getMessage() + ", origin list:" + r100);
        return;
    L3:
        if ((r100 instanceof ArrayList) == false) goto L5;
        ArrayList r101 = (ArrayList) r100;     // Catch: Exception -> L9
    L6:
        if (r101 == null) goto L14;
        getFilterDataHolder().c("doc/in/wiki", r101, new BaseSearchFilterView$setWikiSpaceList$1$1(this));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public BaseSearchFilterView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
