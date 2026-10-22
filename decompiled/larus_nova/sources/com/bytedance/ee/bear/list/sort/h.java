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
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f229707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f229708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f229709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f229710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f229711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f229712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f229713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f229714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f229715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f229716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f229717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f229718l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f229719m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f229720n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f229721o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FilterTypeAdapter f229722p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SortTypeAdapter f229723q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a.InterfaceC3282a f229724r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f229725s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FolderSortStrategy f229726t;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        RecyclerView r100 = (RecyclerView) this.f229707a.findViewById(R.id.rv_filter_type);
        if (this.f229715i == false) goto L5;
        FilterTypeAdapter r101 = new ListFilterTypeAdapter();
    L6:
        this.f229722p = r101;
        r101.f229631c = this.f229713g;
        r101.notifyDataSetChanged();
        p(r100, this.f229722p);
        FilterTypeAdapter r102 = this.f229722p;
        r102.f229633e = new zd5.l(this);
        RecyclerView r103 = (RecyclerView) this.f229707a.findViewById(R.id.rv_sort_strategy);
        SortTypeAdapter r104 = new SortTypeAdapter();
        this.f229723q = r104;
        r104.f229684c = this.f229714h;
        r104.notifyDataSetChanged();
        SortTypeAdapter r105 = this.f229723q;
        r105.f229686e = this.f229711e;
        p(r103, r105);
        SortTypeAdapter r106 = this.f229723q;
        r106.f229687f = new zd5.m(this);
        int r107 = 0;
        if (this.f229709c == true) goto L9;
    L11:
        boolean r108 = false;
    L12:
        TextView r109 = (TextView) this.f229707a.findViewById(R.id.tv_type_title);
        TextView r110 = (TextView) this.f229707a.findViewById(R.id.tv_sort_title);
        int r111 = 8;
        if (r108 == false) goto L15;
        int r112 = 0;
    L16:
        r109.setVisibility(r112);
        if (this.f229709c == false) goto L19;
        int r113 = 0;
    L20:
        r100.setVisibility(r113);
        if (r108 == false) goto L23;
        int r114 = 0;
    L24:
        r110.setVisibility(r114);
        if (this.f229710d == false) goto L27;
        int r115 = 0;
    L28:
        r103.setVisibility(r115);
        int r116 = this.f229721o;
        if (r116 == 0) goto L31;
        r110.setText(r116);
    L31:
        TextView r117 = (TextView) this.f229707a.findViewById(R.id.tv_reset);
        this.f229725s = r117;
        r117.setOnClickListener(new e(this));
        TextView r118 = (TextView) this.f229707a.findViewById(R.id.tv_done);
        r118.setOnClickListener(new f(this));
        CommonActionPanelLayout r119 = (CommonActionPanelLayout) this.f229707a.findViewById(R.id.title_panel);
        r119.setOnActionListener(new g(this));
        Context r120 = this.f229708b;
        if (r120 != null) goto L34;
    L37:
        TextView r121 = this.f229725s;
        if (this.f229712f == false) goto L40;
        int r122 = 0;
    L41:
        r121.setVisibility(r122);
        if (this.f229716j == false) goto L44;
        r111 = 0;
    L44:
        r118.setVisibility(r111);
        ConstraintLayout.LayoutParams r123 = (ConstraintLayout.LayoutParams) r118.getLayoutParams();
        if (this.f229712f == false) goto L47;
        int r124 = cu5.c.a(13.0f);
    L48:
        ((ViewGroup.MarginLayoutParams) r123).leftMargin = r124;
        ConstraintLayout.LayoutParams r125 = (ConstraintLayout.LayoutParams) r118.getLayoutParams();
        if (this.f229712f == false) goto L51;
        r107 = cu5.c.a(19.0f);
    L51:
        ((ViewGroup.MarginLayoutParams) r125).topMargin = r107;
        return;
    L47:
        r124 = 0;
        goto L48
    L40:
        r122 = 8;
        goto L41
    L34:
        if (this.f229710d == false) goto L36;
        r119.setTitle(r120.getString(R.string.CreationMobile_Space_FilterNSort));
        goto L37
    L36:
        r119.setTitle(r120.getString(R.string.Doc_List_Filter_By_Type));
        goto L37
    L27:
        r115 = 8;
        goto L28
    L23:
        r114 = 8;
        goto L24
    L19:
        r113 = 8;
        goto L20
    L15:
        r112 = 8;
        goto L16
    L9:
        if (this.f229710d == false) goto L11;
        r108 = true;
        goto L12
    L5:
        r101 = new FilterTypeAdapter();
        goto L6
    }

    public final FolderSortStrategy o() {
        int r100 = sbb.e.f541294e.f541317b;
        FolderSortStrategy r101 = this.f229726t;
        if (r101 == null) goto L5;
        r100 = r101.getType();
        FolderSortStrategy r102 = this.f229726t;
        String r103 = r102.f227682c;
        String r104 = r102.f227683d;
        int r105 = r102.f227684e;
        boolean r106 = r102.f227685f;
    L6:
        q r107 = null;
        if (this.f229709c == false) goto L9;
        FilterType r108 = this.f229722p.y2();
    L11:
        if (this.f229710d == false) goto L13;
        SortTypeAdapter r109 = this.f229723q;
        r107 = (q) ListProtector.get(r109.f229683b, r109.f229684c);
    L13:
        if (r108 == null) goto L15;
        r100 = r108.getType();
        r103 = r108.getFileType();
        r104 = r108.getForbiddenFileType();
    L15:
        int r110 = r100;
        String r111 = r103;
        String r112 = r104;
        if (r107 == null) goto L18;
        r105 = r107.f571311b;
        r106 = r107.f571312c;
    L18:
        int r113 = r105;
        return new FolderSortStrategy(this.f229720n, r110, r111, r112, r113, r106);
    L9:
        r108 = null;
        goto L11
    L5:
        r103 = "";
        r105 = -1;
        r106 = false;
        r104 = "";
        goto L6
    }

    public final void s() {
        this.f229725s.setBackgroundResource(R.drawable.list_edit_filter_reset_bg);
        if (this.f229709c == false) goto L8;
        if (this.f229722p.f229631c == this.f229713g) goto L8;
    L13:
        boolean r100 = true;
    L15:
        if (r100 == false) goto L17;
        this.f229725s.setTextColor(this.f229708b.getResources().getColor(R.color.text_title));
        this.f229725s.setEnabled(true);
        return;
    L17:
        this.f229725s.setTextColor(this.f229708b.getResources().getColor(R.color.text_disable));
        this.f229725s.setEnabled(false);
        return;
    L8:
        if (this.f229710d == false) goto L14;
        SortTypeAdapter r101 = this.f229723q;
        int r102 = r101.f229684c;
        if (r102 != this.f229714h) goto L13;
        if (((q) ListProtector.get(r101.f229683b, r102)).f571312c == true) goto L13;
    L14:
        r100 = false;
        goto L15
    }

    @Override // com.bytedance.ee.bear.list.sort.a
    public final void H(FolderSortStrategy r100) {
        this.f229726t = r100;
        int r101 = 0;
        if (this.f229709c == false) goto L12;
        int r102 = 0;
    L6:
        if (r102 >= ((ArrayList) this.f229722p.f229630b).size()) goto L12;
        FilterType r103 = (FilterType) ListProtector.get(this.f229722p.f229630b, r102);
        if (r103.isSame(r100.getType(), r100.f227682c, r100.f227683d) == false) goto L10;
        FilterTypeAdapter r104 = this.f229722p;
        r104.f229631c = r102;
        r104.notifyDataSetChanged();
        SortTypeAdapter r105 = this.f229723q;
        r105.f229685d = r103;
        r105.notifyDataSetChanged();
    L10:
        r102 = r102 + 1;
    L12:
        if (this.f229710d == true) goto L14;
    L19:
        s();
        tt5.a.h("SortAndFilterView", "show()...sortStrategy = " + r100.toString());
        return;
    L14:
        if (r101 >= ((ArrayList) this.f229723q.f229683b).size()) goto L19;
        q r106 = (q) ListProtector.get(this.f229723q.f229683b, r101);
        if (r106.f571311b != r100.f227684e) goto L18;
        r106.f571312c = r100.f227685f;
        SortTypeAdapter r107 = this.f229723q;
        r107.f229684c = r101;
        r107.notifyDataSetChanged();
        FilterTypeAdapter r108 = this.f229722p;
        r108.f229632d = r106;
        r108.notifyDataSetChanged();
    L18:
        r101 = r101 + 1;
        goto L14
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f229724r = (a.InterfaceC3282a) r100;
    }

    public static void h(h r110, String r111) {
        q r100 = null;
        if (r110.f229709c == false) goto L5;
        FilterType r101 = r110.f229722p.y2();
    L7:
        if (r110.f229710d == false) goto L9;
        SortTypeAdapter r102 = r110.f229723q;
        r100 = (q) ListProtector.get(r102.f229683b, r102.f229684c);
    L9:
        String r103 = "";
        if (r101 == null) goto L12;
        String r104 = r101.getReportType();
    L13:
        if (r100 == null) goto L21;
        String r105 = r100.f571313d;
        if (r110.f229711e == true) goto L17;
    L20:
        r103 = r105;
        goto L21
    L17:
        if (r100.f571312c == false) goto L19;
        r105 = r105 + "_up";
        goto L20
    L19:
        r105 = r105 + "_down";
    L21:
        lc5.l r106 = new lc5.l(r111, r110.f229717k, r110.f229718l, r110.f229719m, r104, r103);
        lc5.f.a r112 = lc5.f.f508440a;
        Intrinsics.checkNotNullParameter(r106, "clickParam");
        JSONObject r113 = new JSONObject();
        String r107 = r106.f508477b;
        String r108 = r106.f508478c;
        String r109 = r106.f508479d;
        lc5.f.a.b(r112, new lc5.g(r113, r107, r108, r109, sbb.e.f541295f.f541317b, "", r109, DocumentType.FOLDER_NAME, null));
        r113.put("click", r106.f508476a);
        if (TextUtils.isEmpty(r106.f508480e) == true) goto L25;
        r113.put("doc_value", r106.f508480e);
    L25:
        if (TextUtils.isEmpty(r106.f508481f) == true) goto L27;
        r113.put("operate_value", r106.f508481f);
    L27:
        String r114 = lc5.f.a.i(r106.f508477b);
        if (TextUtils.isEmpty(r114) == true) goto L30;
        r113.put(PickerReporterConstants.KEY.TARGET, r114);
    L30:
        com.bytedance.ee.bear.contract.d r115 = lc5.f.a.d();
        if (r115 == null) goto L34;
        r115.i("ccm_space_header_filter_click", r113);
        return;
    L34:
        return;
    L12:
        r104 = "";
        goto L13
    L5:
        r101 = null;
        goto L7
    }

    public static void k(h r100, String r101) {
        q r102 = null;
        if (r100.f229709c == false) goto L5;
        FilterType r103 = r100.f229722p.y2();
    L7:
        if (r100.f229710d == false) goto L9;
        SortTypeAdapter r104 = r100.f229723q;
        r102 = (q) ListProtector.get(r104.f229683b, r104.f229684c);
    L9:
        String r105 = "";
        if (r103 == null) goto L12;
        String r106 = r103.getReportType();
    L13:
        if (r102 == null) goto L15;
        r105 = r102.f571313d;
    L15:
        HashMap r107 = new HashMap();
        r107.put("source", "filter_board");
        r107.put(EventConstant.Key.MODULE, r100.f229717k);
        r107.put("action", r101);
        r107.put("filter_action", r106);
        r107.put("sort_action", r105);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_content_management", r107);
        return;
    L12:
        r106 = "";
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.sort.a
    public final void h7(List<FilterType> r100, List<q> r101) {
        if (this.f229709c == false) goto L10;
        FilterTypeAdapter r102 = this.f229722p;
        ((ArrayList) r102.f229630b).clear();
        if (r100 == null) goto L10;
        if (r100.size() <= 0) goto L10;
        ((ArrayList) r102.f229630b).addAll(r100);
    L10:
        if (this.f229710d == false) goto L17;
        SortTypeAdapter r103 = this.f229723q;
        ((ArrayList) r103.f229683b).clear();
        if (r101 != null) goto L14;
        return;
    L14:
        if (r101.size() <= 0) goto L19;
        ((ArrayList) r103.f229683b).addAll(r101);
        return;
    L19:
        return;
    }

    public final void p(RecyclerView r100, RecyclerView.Adapter r101) {
        if (this.f229715i == false) goto L5;
        r100.setLayoutManager(new LinearLayoutManager(this.f229708b));
        r100.addItemDecoration(new ListFilterItemDecoration());
        r100.setAdapter(r101);
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r100.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = 0;
        r100.setLayoutParams(r102);
        return;
    L5:
        r100.setLayoutManager(new GridLayoutManager(this.f229708b, 2, 1, false));
        r100.addItemDecoration(new FilterItemDecoration());
        r100.setAdapter(r101);
    }

    public h(View r100, Context r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, int r107, int r108, String r110, String r111, String r112, String r113, int r114) {
        this.f229707a = r100;
        this.f229708b = r101;
        this.f229709c = r102;
        this.f229710d = r103;
        this.f229711e = r104;
        this.f229712f = r105;
        this.f229713g = r107;
        this.f229714h = r108;
        this.f229717k = r110;
        this.f229718l = r111;
        this.f229719m = r112;
        this.f229720n = r113;
        this.f229721o = r114;
        this.f229715i = !r103;
        this.f229716j = r106;
    }
}
