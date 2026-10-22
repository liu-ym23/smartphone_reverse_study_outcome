package com.bytedance.ee.bear.search.picker.filter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterViewItemDecoration;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import em5.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001bJ\u0010\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010#J\u001e\u0010&\u001a\u00020\u001b2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*J\u0010\u0010+\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010#J\u0010\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010#J\u0006\u0010/\u001a\u00020\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/BaseSearchFilterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "filterView", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2;", "getFilterView", "()Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2;", "setFilterView", "(Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2;)V", "listener", "Lcom/bytedance/ee/bear/search/picker/filter/SearchFilterSelectListener;", "getListener", "()Lcom/bytedance/ee/bear/search/picker/filter/SearchFilterSelectListener;", "setListener", "(Lcom/bytedance/ee/bear/search/picker/filter/SearchFilterSelectListener;)V", "filterDataHolder", "Lcom/bytedance/ee/bear/search/picker/filter/base/SearchFilterDataHolder;", "getFilterDataHolder", "()Lcom/bytedance/ee/bear/search/picker/filter/base/SearchFilterDataHolder;", "setFilterDataHolder", "(Lcom/bytedance/ee/bear/search/picker/filter/base/SearchFilterDataHolder;)V", "initView", "", "initItemDecoration", "updateFilterView", "filterData", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "initItemClickListener", "setChatList", "chatInfo", "Ljava/io/Serializable;", "setWikiSpaceList", "wikiSpaceInfo", "setTypeList", "selectTypeItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/search/picker/filter/type/SelectTypeItem;", "Lkotlin/collections/ArrayList;", "setOwnerList", "chatterInfo", "setFolderList", "folderInfo", "doSearch", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseSearchFilterView extends FrameLayout {
    public FilterViewV2 a;
    public com.bytedance.ee.bear.search.picker.filter.a b;
    public em5.b c;

    public static final class a {
    }

    public static final class b implements FilterViewV2.d {
        public final /* synthetic */ BaseSearchFilterView a;

        public final void a() {
            Iterator r0 = ((ArrayList) this.a.getFilterDataHolder().b).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((cpc.a) r0.next()).c();
            goto L4
        L6:
            FilterViewV2 r1 = this.a.getFilterView();
            if (r1 == null) goto L17;
            List<cpc.a> r2 = this.a.getFilterDataHolder().b;
            Intrinsics.checkNotNullParameter(r2, "collection");
            if ((!r2.isEmpty()) == false) goto L17;
            FilterAdapter r3 = r1.d;
            if (r3 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
            r3 = null;
        L13:
            r3.getClass();
            Intrinsics.checkNotNullParameter(r2, "collection");
            ((ArrayList) r3.b).clear();
            if ((!r2.isEmpty()) == false) goto L16;
            ((ArrayList) r3.b).addAll(r2);
        L16:
            r3.notifyDataSetChanged();
        L17:
            FilterViewV2 r4 = this.a.getFilterView();
            if (r4 == null) goto L20;
            r4.b();
        L20:
            this.a.a();
        }

        public b(BaseSearchFilterView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final em5.b getFilterDataHolder() {
        em5.b r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("filterDataHolder");
        return null;
    }

    public final void a() {
        e r0 = getFilterDataHolder().a();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        FilterViewV2 r2 = this.a;
        if (r2 == null) goto L14;
        r2.b();
    L14:
        com.bytedance.ee.bear.search.picker.filter.a r3 = this.b;
        if (r3 == null) goto L18;
        r3.M60(r0);
        return;
    L18:
        return;
    L11:
        FilterViewV2 r4 = this.a;
        if (r4 == null) goto L14;
        r4.c();
        goto L14
    L5:
        if (r0.b() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(2131564467, this);
        FilterViewV2 r0 = findViewById(2131385481);
        this.a = r0;
        if (r0 == null) goto L5;
        r0.setGradientBorderBackground(2131235403);
    L5:
        FilterViewV2 r1 = this.a;
        if (r1 == null) goto L8;
        r1.setOnResetClick(new b(this));
    L8:
        FilterViewV2 r2 = this.a;
        if (r2 == null) goto L13;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L13;
        r3.width = -1;
        r3.height = n.d(44);
    L13:
        FilterViewV2 r4 = this.a;
        if (r4 == null) goto L23;
        RecyclerView r5 = r4.findViewById(2131372512);
        if (r5 == null) goto L24;
        int r6 = r5.getItemDecorationCount();
        int r7 = 0;
    L18:
        if (r7 >= r6) goto L20;
        r5.removeItemDecorationAt(r7);
        r7 = r7 + 1;
        goto L18
    L20:
        r5.addItemDecoration(new FilterViewItemDecoration(n.c(12.0f), n.c(6.0f), n.c(12.0f), n.c(6.0f), n.c(10.0f)));
        return;
    L24:
        return;
    }

    public final FilterViewV2 getFilterView() {
        return this.a;
    }

    public final com.bytedance.ee.bear.search.picker.filter.a getListener() {
        return this.b;
    }

    public BaseSearchFilterView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void c(cpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "filterData");
        FilterViewV2 r0 = this.a;
        if (r0 == null) goto L5;
        r0.update(r2);
    L5:
        a();
    }

    public final void setChatList(Serializable r4) {
    L8:
        e = move-exception;
        tt5.a.d("SpaceSearchFilterView", "select chat info parse json error:" + e.getMessage() + ", json:");
        return;
    L3:
        if ((r4 instanceof ArrayList) == false) goto L5;
        ArrayList r5 = (ArrayList) r4;     // Catch: Exception -> L8
    L6:
        getFilterDataHolder().c("doc/in/chat", r5, new AnonymousClass1(this));     // Catch: Exception -> L8
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void setFilterDataHolder(em5.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setFilterView(FilterViewV2 r1) {
        this.a = r1;
    }

    public final void setFolderList(Serializable r5) {
    L9:
        e = move-exception;
        tt5.a.d("SpaceSearchFilterView", "select folder info parse json error:" + e.getMessage() + ", origin list:" + r5);
        return;
    L3:
        if ((r5 instanceof ArrayList) == false) goto L5;
        ArrayList r0 = (ArrayList) r5;     // Catch: Exception -> L9
    L6:
        if (r0 == null) goto L14;
        getFilterDataHolder().c("doc/in/folder", r0, new BaseSearchFilterView$setFolderList$1$1(this));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void setListener(com.bytedance.ee.bear.search.picker.filter.a r1) {
        this.b = r1;
    }

    public final void setOwnerList(Serializable r5) {
    L8:
        e = move-exception;
        tt5.a.d("SpaceSearchFilterView", "select owner info parse json error:" + e.getMessage() + ", origin json:" + r5);
        return;
    L3:
        if ((r5 instanceof ArrayList) == false) goto L5;
        ArrayList r0 = (ArrayList) r5;     // Catch: Exception -> L8
    L6:
        getFilterDataHolder().c("doc/owner", r0, new C03541(this));     // Catch: Exception -> L8
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void setTypeList(ArrayList<com.bytedance.ee.bear.search.picker.filter.type.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "selectTypeItems");
        getFilterDataHolder().c("doc/type", r4, new C03551(this));
    }

    public final void setWikiSpaceList(Serializable r5) {
    L9:
        e = move-exception;
        tt5.a.d("SpaceSearchFilterView", "select folder info parse json error:" + e.getMessage() + ", origin list:" + r5);
        return;
    L3:
        if ((r5 instanceof ArrayList) == false) goto L5;
        ArrayList r0 = (ArrayList) r5;     // Catch: Exception -> L9
    L6:
        if (r0 == null) goto L14;
        getFilterDataHolder().c("doc/in/wiki", r0, new BaseSearchFilterView$setWikiSpaceList$1$1(this));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public BaseSearchFilterView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
