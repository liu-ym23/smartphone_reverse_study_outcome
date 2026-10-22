package com.bytedance.ee.bear.search.picker.filter.wiki;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.search.SelectPickerConfig;
import com.bytedance.ee.bear.search.SelectTabConfig;
import com.bytedance.ee.bear.search.picker.filter.BaseSearchFilterView;
import com.bytedance.ee.bear.search.picker.filter.BaseSearchFilterView$initItemClickListener$itemClickListener$1;
import com.larus.nova.R;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends BaseSearchFilterView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SelectPickerConfig f236961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f236962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f236963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f236964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f236965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f236966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f236967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f236968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f236969l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f236970m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f236971n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f236972o;

    public static final class a {
    }

    static {
    }

    public final FrameLayout getSearchDocRootFromXml() {
        KeyEvent.Callback r100 = this.f236964g;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.search_doc_root);
        this.f236964g = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final FrameLayout getSearchFolderRootFromXml() {
        KeyEvent.Callback r100 = this.f236963f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.search_folder_root);
        this.f236963f = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final LinearLayout getSearchTabContainerFromXml() {
        KeyEvent.Callback r100 = this.f236962e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.search_tab_container);
        this.f236962e = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final TextView getSearchTabDocFromXml() {
        KeyEvent.Callback r100 = this.f236970m;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.search_tab_doc);
        this.f236970m = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final View getSearchTabDocIndicatorFromXml() {
        View r100 = this.f236968k;
        if (r100 != null) goto L6;
        View r101 = findViewById(R.id.search_tab_doc_indicator);
        this.f236968k = r101;
        return r101;
    L6:
        return r100;
    }

    public final TextView getSearchTabFolderFromXml() {
        KeyEvent.Callback r100 = this.f236971n;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.search_tab_folder);
        this.f236971n = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final View getSearchTabFolderIndicatorFromXml() {
        View r100 = this.f236969l;
        if (r100 != null) goto L6;
        View r101 = findViewById(R.id.search_tab_folder_indicator);
        this.f236969l = r101;
        return r101;
    L6:
        return r100;
    }

    public final TextView getSearchTabWikiSpaceFromXml() {
        KeyEvent.Callback r100 = this.f236966i;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.search_tab_wiki_space);
        this.f236966i = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final View getSearchTabWikiSpaceIndicatorFromXml() {
        View r100 = this.f236967j;
        if (r100 != null) goto L6;
        View r101 = findViewById(R.id.search_tab_wiki_space_indicator);
        this.f236967j = r101;
        return r101;
    L6:
        return r100;
    }

    public final FrameLayout getSearchWikiRootFromXml() {
        KeyEvent.Callback r100 = this.f236965h;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.search_wiki_root);
        this.f236965h = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final SelectPickerConfig getSelectConfig() {
        return this.f236961d;
    }

    public final void d(PickerConfig r100) {
        SelectPickerConfig r101 = this.f236961d;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.getUseFilter() != true) goto L7;
    L8:
        if (r102 == false) goto L12;
        FilterViewV2 r103 = getFilterView();
        if (r103 == null) goto L12;
        r103.setVisibility(0);
    L12:
        em5.e r104 = getFilterDataHolder().a();
        if (r104 == null) goto L16;
        r104.c(r100);
        return;
    L16:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void setSearchDocRootFromXml(FrameLayout r100) {
        this.f236964g = r100;
    }

    public final void setSearchFolderRootFromXml(FrameLayout r100) {
        this.f236963f = r100;
    }

    public final void setSearchTabContainerFromXml(LinearLayout r100) {
        this.f236962e = r100;
    }

    public final void setSearchTabDocFromXml(TextView r100) {
        this.f236970m = r100;
    }

    public final void setSearchTabDocIndicatorFromXml(View r100) {
        this.f236968k = r100;
    }

    public final void setSearchTabFolderFromXml(TextView r100) {
        this.f236971n = r100;
    }

    public final void setSearchTabFolderIndicatorFromXml(View r100) {
        this.f236969l = r100;
    }

    public final void setSearchTabWikiSpaceFromXml(TextView r100) {
        this.f236966i = r100;
    }

    public final void setSearchTabWikiSpaceIndicatorFromXml(View r100) {
        this.f236967j = r100;
    }

    public final void setSearchWikiRootFromXml(FrameLayout r100) {
        this.f236965h = r100;
    }

    public final void setSelectConfig(SelectPickerConfig r100) {
        this.f236961d = r100;
    }

    public b(Context r100, SelectPickerConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        this.f236961d = r101;
        b();
        getSearchTabContainerFromXml().setVisibility(0);
        SelectPickerConfig r102 = this.f236961d;
        if (r102 == null) goto L20;
        SelectTabConfig r103 = r102.getSelectTabConfig();
        if (r103.getUseDoc() == true) goto L12;
        if (r103.getUseFolder() == true) goto L12;
        if (r103.getUseWiki() == true) goto L12;
        setVisibility(8);
    L12:
        if (r103.getUseFolder() == false) goto L15;
        getSearchFolderRootFromXml().setVisibility(0);
    L15:
        if (r103.getUseDoc() == false) goto L18;
        getSearchDocRootFromXml().setVisibility(0);
    L18:
        if (r103.getUseWiki() == false) goto L20;
        getSearchWikiRootFromXml().setVisibility(0);
    L20:
        getSearchTabWikiSpaceFromXml().setOnClickListener(new c(this));
        getSearchTabDocFromXml().setOnClickListener(new d(this));
        getSearchTabFolderFromXml().setOnClickListener(new e(this));
        int r104 = em5.c.f473092a;
        Context r105 = getContext();
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        setFilterDataHolder(new WikiSearchFilterDataHolder(r105));
        List<cpc.a> r106 = getFilterDataHolder().f473089b;
        FilterViewV2 r107 = getFilterView();
        if (r107 == null) goto L23;
        r107.a(r106);
    L23:
        FilterViewV2 r108 = getFilterView();
        if (r108 == null) goto L26;
        r108.setVisibility(8);
    L26:
        FilterViewV2 r109 = getFilterView();
        if (r109 == null) goto L29;
        r109.b();
    L29:
        BaseSearchFilterView$initItemClickListener$itemClickListener$1 r110 = new BaseSearchFilterView$initItemClickListener$itemClickListener$1(this);
        FilterViewV2 r111 = this.f236839a;
        if (r111 == null) goto L33;
        r111.setOnFilterItemClick(r110);
        return;
    }
}
