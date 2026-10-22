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
import java.util.ArrayList;
import java.util.List;
import zd5.q;
import zd5.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements b {
    public final View a;
    public TextView b;
    public final Context c;
    public final int d;
    public final String e;
    public final boolean f;
    public FolderSortStrategy g;
    public SortAdapter h;
    public b.a i;

    public final void destroy() {
    }

    public final void create() {
        ((CommonActionPanelLayout) this.a.findViewById(2131388889)).setOnActionListener(new k(this));
        TextView r0 = (TextView) this.a.findViewById(2131391298);
        this.b = r0;
        r0.setOnClickListener(new l(this));
        RecyclerView r1 = this.a.findViewById(2131385011);
        SortAdapter r2 = new SortAdapter(this.f);
        this.h = r2;
        r2.c = this.d;
        r2.notifyDataSetChanged();
        SortAdapter r3 = this.h;
        r1.setLayoutManager(new LinearLayoutManager(this.c, 1, false));
        r1.addItemDecoration(new FilterItemDecoration());
        r1.setAdapter(r3);
        SortAdapter r4 = this.h;
        r4.e = new r(this);
    }

    @Override // com.bytedance.ee.bear.list.sort.b
    public final void H(FolderSortStrategy r9) {
        this.g = new FolderSortStrategy(r9.a, r9.getType(), r9.c, r9.d, r9.e, r9.f);
        int r1 = 0;
    L4:
        if (r1 >= ((ArrayList) this.h.b).size()) goto L24;
        q r2 = (q) ListProtector.get(this.h.b, r1);
        if (r2.b != r9.e) goto L23;
        r2.c = r9.f;
        SortAdapter r3 = this.h;
        r3.c = r1;
        r3.notifyDataSetChanged();
        int r4 = 8;
        if (this.f == true) goto L10;
        TextView r5 = this.b;
        if (r1 == this.d) goto L22;
        r4 = 0;
    L22:
        r5.setVisibility(r4);
        goto L23
    L10:
        if (r2.f != SortAscType.TITLE) goto L12;
        boolean r6 = true;
    L13:
        TextView r7 = this.b;
        if (r1 == this.d) goto L16;
    L17:
        r4 = 0;
    L18:
        r7.setVisibility(r4);
        goto L23
    L16:
        if (r2.c == r6) goto L18;
    L12:
        r6 = false;
    L23:
        r1 = r1 + 1;
        goto L4
    L24:
        tt5.a.h("SortView", "show()...sortStrategy = " + r9.toString());
    }

    @Override // com.bytedance.ee.bear.list.sort.b
    public final void S2(List<q> r3) {
        SortAdapter r0 = this.h;
        ((ArrayList) r0.b).clear();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.size() <= 0) goto L9;
        ((ArrayList) r0.b).addAll(r3);
        return;
    }

    public final FolderSortStrategy h(q r9) {
        FolderSortStrategy r0 = this.g;
        if (r0 == null) goto L6;
        r0.e = r9.b;
        r0.f = r9.c;
        return r0;
    L6:
        String r2 = this.e;
        FilterType r1 = FilterType.ALL;
        return new FolderSortStrategy(r2, r1.getType(), r1.getFileType(), r1.getForbiddenFileType(), r9.b, r9.c);
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.i = (b.a) r1;
    }

    public m(View r1, Context r2, int r3, String r4, boolean r5) {
        this.a = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
