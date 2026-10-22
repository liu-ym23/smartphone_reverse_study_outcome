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
import com.ss.android.lark.picker.config.PickerConfig;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends BaseSearchFilterView {
    public SelectPickerConfig d;
    public LinearLayout e;
    public FrameLayout f;
    public FrameLayout g;
    public FrameLayout h;
    public TextView i;
    public View j;
    public View k;
    public View l;
    public TextView m;
    public TextView n;
    public int o;

    public static final class a {
    }

    static {
    }

    public final FrameLayout getSearchDocRootFromXml() {
        KeyEvent.Callback r0 = this.g;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385373);
        this.g = (FrameLayout) r0;
    L6:
        return (FrameLayout) r0;
    }

    public final FrameLayout getSearchFolderRootFromXml() {
        KeyEvent.Callback r0 = this.f;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385488);
        this.f = (FrameLayout) r0;
    L6:
        return (FrameLayout) r0;
    }

    public final LinearLayout getSearchTabContainerFromXml() {
        KeyEvent.Callback r0 = this.e;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385604);
        this.e = (LinearLayout) r0;
    L6:
        return (LinearLayout) r0;
    }

    public final TextView getSearchTabDocFromXml() {
        KeyEvent.Callback r0 = this.m;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385605);
        this.m = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final View getSearchTabDocIndicatorFromXml() {
        View r0 = this.k;
        if (r0 != null) goto L6;
        View r1 = findViewById(2131385606);
        this.k = r1;
        return r1;
    L6:
        return r0;
    }

    public final TextView getSearchTabFolderFromXml() {
        KeyEvent.Callback r0 = this.n;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385607);
        this.n = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final View getSearchTabFolderIndicatorFromXml() {
        View r0 = this.l;
        if (r0 != null) goto L6;
        View r1 = findViewById(2131385608);
        this.l = r1;
        return r1;
    L6:
        return r0;
    }

    public final TextView getSearchTabWikiSpaceFromXml() {
        KeyEvent.Callback r0 = this.i;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385609);
        this.i = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final View getSearchTabWikiSpaceIndicatorFromXml() {
        View r0 = this.j;
        if (r0 != null) goto L6;
        View r1 = findViewById(2131385610);
        this.j = r1;
        return r1;
    L6:
        return r0;
    }

    public final FrameLayout getSearchWikiRootFromXml() {
        KeyEvent.Callback r0 = this.h;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385645);
        this.h = (FrameLayout) r0;
    L6:
        return (FrameLayout) r0;
    }

    public final SelectPickerConfig getSelectConfig() {
        return this.d;
    }

    public final void d(PickerConfig r4) {
        SelectPickerConfig r0 = this.d;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.getUseFilter() != true) goto L7;
    L8:
        if (r2 == false) goto L12;
        FilterViewV2 r1 = getFilterView();
        if (r1 == null) goto L12;
        r1.setVisibility(0);
    L12:
        em5.e r3 = getFilterDataHolder().a();
        if (r3 == null) goto L16;
        r3.c(r4);
        return;
    L16:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void setSearchDocRootFromXml(FrameLayout r1) {
        this.g = r1;
    }

    public final void setSearchFolderRootFromXml(FrameLayout r1) {
        this.f = r1;
    }

    public final void setSearchTabContainerFromXml(LinearLayout r1) {
        this.e = r1;
    }

    public final void setSearchTabDocFromXml(TextView r1) {
        this.m = r1;
    }

    public final void setSearchTabDocIndicatorFromXml(View r1) {
        this.k = r1;
    }

    public final void setSearchTabFolderFromXml(TextView r1) {
        this.n = r1;
    }

    public final void setSearchTabFolderIndicatorFromXml(View r1) {
        this.l = r1;
    }

    public final void setSearchTabWikiSpaceFromXml(TextView r1) {
        this.i = r1;
    }

    public final void setSearchTabWikiSpaceIndicatorFromXml(View r1) {
        this.j = r1;
    }

    public final void setSearchWikiRootFromXml(FrameLayout r1) {
        this.h = r1;
    }

    public final void setSelectConfig(SelectPickerConfig r1) {
        this.d = r1;
    }

    public b(Context r4, SelectPickerConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null);
        this.d = r5;
        b();
        getSearchTabContainerFromXml().setVisibility(0);
        SelectPickerConfig r6 = this.d;
        if (r6 == null) goto L20;
        SelectTabConfig r7 = r6.getSelectTabConfig();
        if (r7.getUseDoc() == true) goto L12;
        if (r7.getUseFolder() == true) goto L12;
        if (r7.getUseWiki() == true) goto L12;
        setVisibility(8);
    L12:
        if (r7.getUseFolder() == false) goto L15;
        getSearchFolderRootFromXml().setVisibility(0);
    L15:
        if (r7.getUseDoc() == false) goto L18;
        getSearchDocRootFromXml().setVisibility(0);
    L18:
        if (r7.getUseWiki() == false) goto L20;
        getSearchWikiRootFromXml().setVisibility(0);
    L20:
        getSearchTabWikiSpaceFromXml().setOnClickListener(new c(this));
        getSearchTabDocFromXml().setOnClickListener(new d(this));
        getSearchTabFolderFromXml().setOnClickListener(new e(this));
        int r8 = em5.c.a;
        Context r9 = getContext();
        Intrinsics.checkNotNullParameter(r9, "context");
        setFilterDataHolder(new WikiSearchFilterDataHolder(r9));
        List<cpc.a> r10 = getFilterDataHolder().b;
        FilterViewV2 r11 = getFilterView();
        if (r11 == null) goto L23;
        r11.a(r10);
    L23:
        FilterViewV2 r12 = getFilterView();
        if (r12 == null) goto L26;
        r12.setVisibility(8);
    L26:
        FilterViewV2 r13 = getFilterView();
        if (r13 == null) goto L29;
        r13.b();
    L29:
        BaseSearchFilterView$initItemClickListener$itemClickListener$1 r14 = new BaseSearchFilterView$initItemClickListener$itemClickListener$1(this);
        FilterViewV2 r15 = this.a;
        if (r15 == null) goto L33;
        r15.setOnFilterItemClick(r14);
        return;
    }
}
