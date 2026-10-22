package com.bytedance.ee.bear.list.sort;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements a {
    public final View a;
    public final Context b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final int h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final int o;
    public FilterTypeAdapter p;
    public SortTypeAdapter q;
    public a.InterfaceC0035a r;
    public TextView s;
    public FolderSortStrategy t;

    public final void destroy() {
    }

    public final void create() {
        RecyclerView r0 = this.a.findViewById(2131384948);
        if (this.i == false) goto L5;
        FilterTypeAdapter r1 = new ListFilterTypeAdapter();
    L6:
        this.p = r1;
        r1.c = this.g;
        r1.notifyDataSetChanged();
        p(r0, this.p);
        FilterTypeAdapter r2 = this.p;
        r2.e = new zd5.l(this);
        RecyclerView r3 = this.a.findViewById(2131385011);
        SortTypeAdapter r4 = new SortTypeAdapter();
        this.q = r4;
        r4.c = this.h;
        r4.notifyDataSetChanged();
        SortTypeAdapter r5 = this.q;
        r5.e = this.e;
        p(r3, r5);
        SortTypeAdapter r6 = this.q;
        r6.f = new zd5.m(this);
        int r7 = 0;
        if (this.c == true) goto L9;
    L11:
        boolean r8 = false;
    L12:
        TextView r9 = (TextView) this.a.findViewById(2131391653);
        TextView r10 = (TextView) this.a.findViewById(2131391490);
        int r11 = 8;
        if (r8 == false) goto L15;
        int r12 = 0;
    L16:
        r9.setVisibility(r12);
        if (this.c == false) goto L19;
        int r13 = 0;
    L20:
        r0.setVisibility(r13);
        if (r8 == false) goto L23;
        int r14 = 0;
    L24:
        r10.setVisibility(r14);
        if (this.d == false) goto L27;
        int r15 = 0;
    L28:
        r3.setVisibility(r15);
        int r16 = this.o;
        if (r16 == 0) goto L31;
        r10.setText(r16);
    L31:
        TextView r17 = (TextView) this.a.findViewById(2131391298);
        this.s = r17;
        r17.setOnClickListener(new e(this));
        TextView r18 = (TextView) this.a.findViewById(2131390524);
        r18.setOnClickListener(new f(this));
        CommonActionPanelLayout r19 = (CommonActionPanelLayout) this.a.findViewById(2131388889);
        r19.setOnActionListener(new g(this));
        Context r20 = this.b;
        if (r20 != null) goto L34;
    L37:
        TextView r21 = this.s;
        if (this.f == false) goto L40;
        int r22 = 0;
    L41:
        r21.setVisibility(r22);
        if (this.j == false) goto L44;
        r11 = 0;
    L44:
        r18.setVisibility(r11);
        ConstraintLayout.LayoutParams r23 = r18.getLayoutParams();
        if (this.f == false) goto L47;
        int r24 = cu5.c.a(13.0f);
    L48:
        ((ViewGroup.MarginLayoutParams) r23).leftMargin = r24;
        ConstraintLayout.LayoutParams r25 = r18.getLayoutParams();
        if (this.f == false) goto L51;
        r7 = cu5.c.a(19.0f);
    L51:
        ((ViewGroup.MarginLayoutParams) r25).topMargin = r7;
        return;
    L47:
        r24 = 0;
        goto L48
    L40:
        r22 = 8;
        goto L41
    L34:
        if (this.d == false) goto L36;
        r19.setTitle(r20.getString(2131887399));
        goto L37
    L36:
        r19.setTitle(r20.getString(2131887911));
        goto L37
    L27:
        r15 = 8;
        goto L28
    L23:
        r14 = 8;
        goto L24
    L19:
        r13 = 8;
        goto L20
    L15:
        r12 = 8;
        goto L16
    L9:
        if (this.d == false) goto L11;
        r8 = true;
        goto L12
    L5:
        r1 = new FilterTypeAdapter();
        goto L6
    }

    public final FolderSortStrategy o() {
        int r0 = sbb.e.e.b;
        FolderSortStrategy r1 = this.t;
        if (r1 == null) goto L5;
        r0 = r1.getType();
        FolderSortStrategy r2 = this.t;
        String r3 = r2.c;
        String r4 = r2.d;
        int r5 = r2.e;
        boolean r6 = r2.f;
    L6:
        q r7 = null;
        if (this.c == false) goto L9;
        FilterType r8 = this.p.y2();
    L11:
        if (this.d == false) goto L13;
        SortTypeAdapter r9 = this.q;
        r7 = (q) ListProtector.get(r9.b, r9.c);
    L13:
        if (r8 == null) goto L15;
        r0 = r8.getType();
        r3 = r8.getFileType();
        r4 = r8.getForbiddenFileType();
    L15:
        int r10 = r0;
        String r11 = r3;
        String r12 = r4;
        if (r7 == null) goto L18;
        r5 = r7.b;
        r6 = r7.c;
    L18:
        int r13 = r5;
        return new FolderSortStrategy(this.n, r10, r11, r12, r13, r6);
    L9:
        r8 = null;
        goto L11
    L5:
        r3 = "";
        r5 = -1;
        r6 = false;
        r4 = "";
        goto L6
    }

    public final void s() {
        this.s.setBackgroundResource(2131243702);
        if (this.c == false) goto L8;
        if (this.p.c == this.g) goto L8;
    L13:
        boolean r0 = true;
    L15:
        if (r0 == false) goto L17;
        this.s.setTextColor(this.b.getResources().getColor(2131106622));
        this.s.setEnabled(true);
        return;
    L17:
        this.s.setTextColor(this.b.getResources().getColor(2131106610));
        this.s.setEnabled(false);
        return;
    L8:
        if (this.d == false) goto L14;
        SortTypeAdapter r1 = this.q;
        int r3 = r1.c;
        if (r3 != this.h) goto L13;
        if (((q) ListProtector.get(r1.b, r3)).c == true) goto L13;
    L14:
        r0 = false;
        goto L15
    }

    @Override // com.bytedance.ee.bear.list.sort.a
    public final void H(FolderSortStrategy r7) {
        this.t = r7;
        int r1 = 0;
        if (this.c == false) goto L12;
        int r0 = 0;
    L6:
        if (r0 >= ((ArrayList) this.p.b).size()) goto L12;
        FilterType r2 = (FilterType) ListProtector.get(this.p.b, r0);
        if (r2.isSame(r7.getType(), r7.c, r7.d) == false) goto L10;
        FilterTypeAdapter r3 = this.p;
        r3.c = r0;
        r3.notifyDataSetChanged();
        SortTypeAdapter r4 = this.q;
        r4.d = r2;
        r4.notifyDataSetChanged();
    L10:
        r0 = r0 + 1;
    L12:
        if (this.d == true) goto L14;
    L19:
        s();
        tt5.a.h("SortAndFilterView", "show()...sortStrategy = " + r7.toString());
        return;
    L14:
        if (r1 >= ((ArrayList) this.q.b).size()) goto L19;
        q r5 = (q) ListProtector.get(this.q.b, r1);
        if (r5.b != r7.e) goto L18;
        r5.c = r7.f;
        SortTypeAdapter r6 = this.q;
        r6.c = r1;
        r6.notifyDataSetChanged();
        FilterTypeAdapter r8 = this.p;
        r8.d = r5;
        r8.notifyDataSetChanged();
    L18:
        r1 = r1 + 1;
        goto L14
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.r = (a.InterfaceC0035a) r1;
    }

    public static void h(h r12, String r13) {
        q r1 = null;
        if (r12.c == false) goto L5;
        FilterType r0 = r12.p.y2();
    L7:
        if (r12.d == false) goto L9;
        SortTypeAdapter r2 = r12.q;
        r1 = (q) ListProtector.get(r2.b, r2.c);
    L9:
        String r3 = "";
        if (r0 == null) goto L12;
        String r8 = r0.getReportType();
    L13:
        if (r1 == null) goto L21;
        String r4 = r1.d;
        if (r12.e == true) goto L17;
    L20:
        r3 = r4;
        goto L21
    L17:
        if (r1.c == false) goto L19;
        r4 = r4 + "_up";
        goto L20
    L19:
        r4 = r4 + "_down";
    L21:
        lc5.l r5 = new lc5.l(r13, r12.k, r12.l, r12.m, r8, r3);
        lc5.f.a r14 = lc5.f.a;
        Intrinsics.checkNotNullParameter(r5, "clickParam");
        JSONObject r15 = new JSONObject();
        String r6 = r5.b;
        String r7 = r5.c;
        String r9 = r5.d;
        lc5.f.a.b(r14, new lc5.g(r15, r6, r7, r9, sbb.e.f.b, "", r9, DocumentType.FOLDER_NAME, null));
        r15.put("click", r5.a);
        if (TextUtils.isEmpty(r5.e) == true) goto L25;
        r15.put("doc_value", r5.e);
    L25:
        if (TextUtils.isEmpty(r5.f) == true) goto L27;
        r15.put("operate_value", r5.f);
    L27:
        String r16 = lc5.f.a.i(r5.b);
        if (TextUtils.isEmpty(r16) == true) goto L30;
        r15.put("target", r16);
    L30:
        com.bytedance.ee.bear.contract.d r17 = lc5.f.a.d();
        if (r17 == null) goto L34;
        r17.i("ccm_space_header_filter_click", r15);
        return;
    L34:
        return;
    L12:
        r8 = "";
        goto L13
    L5:
        r0 = null;
        goto L7
    }

    public static void k(h r5, String r6) {
        q r1 = null;
        if (r5.c == false) goto L5;
        FilterType r0 = r5.p.y2();
    L7:
        if (r5.d == false) goto L9;
        SortTypeAdapter r2 = r5.q;
        r1 = (q) ListProtector.get(r2.b, r2.c);
    L9:
        String r3 = "";
        if (r0 == null) goto L12;
        String r4 = r0.getReportType();
    L13:
        if (r1 == null) goto L15;
        r3 = r1.d;
    L15:
        HashMap r7 = new HashMap();
        r7.put("source", "filter_board");
        r7.put("module", r5.k);
        r7.put("action", r6);
        r7.put("filter_action", r4);
        r7.put("sort_action", r3);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_content_management", r7);
        return;
    L12:
        r4 = "";
        goto L13
    L5:
        r0 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.sort.a
    public final void h7(List<FilterType> r3, List<q> r4) {
        if (this.c == false) goto L10;
        FilterTypeAdapter r0 = this.p;
        ((ArrayList) r0.b).clear();
        if (r3 == null) goto L10;
        if (r3.size() <= 0) goto L10;
        ((ArrayList) r0.b).addAll(r3);
    L10:
        if (this.d == false) goto L17;
        SortTypeAdapter r5 = this.q;
        ((ArrayList) r5.b).clear();
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.size() <= 0) goto L19;
        ((ArrayList) r5.b).addAll(r4);
        return;
    L19:
        return;
    }

    public final void p(RecyclerView r6, RecyclerView.Adapter r7) {
        if (this.i == false) goto L5;
        r6.setLayoutManager(new LinearLayoutManager(this.b));
        r6.addItemDecoration(new ListFilterItemDecoration());
        r6.setAdapter(r7);
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r6.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r8).bottomMargin = 0;
        r6.setLayoutParams(r8);
        return;
    L5:
        r6.setLayoutManager(new GridLayoutManager(this.b, 2, 1, false));
        r6.addItemDecoration(new FilterItemDecoration());
        r6.setAdapter(r7);
    }

    public h(View r1, Context r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8, int r9, String r10, String r11, String r12, String r13, int r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
        this.h = r9;
        this.k = r10;
        this.l = r11;
        this.m = r12;
        this.n = r13;
        this.o = r14;
        this.i = !r4;
        this.j = r7;
    }
}
