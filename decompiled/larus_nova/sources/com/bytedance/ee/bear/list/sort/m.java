package com.bytedance.ee.bear.list.sort;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import zd5.q;
import zd5.r;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f229740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f229741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f229742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f229743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f229744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f229745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FolderSortStrategy f229746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SortAdapter f229747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b.a f229748i;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ((CommonActionPanelLayout) this.f229740a.findViewById(R.id.title_panel)).setOnActionListener(new k(this));
        TextView r100 = (TextView) this.f229740a.findViewById(R.id.tv_reset);
        this.f229741b = r100;
        r100.setOnClickListener(new l(this));
        RecyclerView r101 = (RecyclerView) this.f229740a.findViewById(R.id.rv_sort_strategy);
        SortAdapter r102 = new SortAdapter(this.f229745f);
        this.f229747h = r102;
        r102.f229645c = this.f229743d;
        r102.notifyDataSetChanged();
        SortAdapter r103 = this.f229747h;
        r101.setLayoutManager(new LinearLayoutManager(this.f229742c, 1, false));
        r101.addItemDecoration(new FilterItemDecoration());
        r101.setAdapter(r103);
        SortAdapter r104 = this.f229747h;
        r104.f229647e = new r(this);
    }

    @Override // com.bytedance.ee.bear.list.sort.b
    public final void H(FolderSortStrategy r100) {
        this.f229746g = new FolderSortStrategy(r100.f227680a, r100.getType(), r100.f227682c, r100.f227683d, r100.f227684e, r100.f227685f);
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f229747h.f229644b).size()) goto L24;
        q r102 = (q) ListProtector.get(this.f229747h.f229644b, r101);
        if (r102.f571311b != r100.f227684e) goto L23;
        r102.f571312c = r100.f227685f;
        SortAdapter r103 = this.f229747h;
        r103.f229645c = r101;
        r103.notifyDataSetChanged();
        int r104 = 8;
        if (this.f229745f == true) goto L10;
        TextView r105 = this.f229741b;
        if (r101 == this.f229743d) goto L22;
        r104 = 0;
    L22:
        r105.setVisibility(r104);
        goto L23
    L10:
        if (r102.f571315f != SortAscType.TITLE) goto L12;
        boolean r106 = true;
    L13:
        TextView r107 = this.f229741b;
        if (r101 == this.f229743d) goto L16;
    L17:
        r104 = 0;
    L18:
        r107.setVisibility(r104);
        goto L23
    L16:
        if (r102.f571312c == r106) goto L18;
    L12:
        r106 = false;
    L23:
        r101 = r101 + 1;
        goto L4
    L24:
        tt5.a.h("SortView", "show()...sortStrategy = " + r100.toString());
    }

    @Override // com.bytedance.ee.bear.list.sort.b
    public final void S2(List<q> r100) {
        SortAdapter r101 = this.f229747h;
        ((ArrayList) r101.f229644b).clear();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L9;
        ((ArrayList) r101.f229644b).addAll(r100);
        return;
    }

    public final FolderSortStrategy h(q r100) {
        FolderSortStrategy r101 = this.f229746g;
        if (r101 == null) goto L6;
        r101.f227684e = r100.f571311b;
        r101.f227685f = r100.f571312c;
        return r101;
    L6:
        String r102 = this.f229744e;
        FilterType r103 = FilterType.ALL;
        return new FolderSortStrategy(r102, r103.getType(), r103.getFileType(), r103.getForbiddenFileType(), r100.f571311b, r100.f571312c);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f229748i = (b.a) r100;
    }

    public m(View r100, Context r101, int r102, String r103, boolean r104) {
        this.f229740a = r100;
        this.f229742c = r101;
        this.f229743d = r102;
        this.f229744e = r103;
        this.f229745f = r104;
    }
}
