package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.g0;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.x4;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import fd5.l;
import fd5.n;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class GridStyleAdapter extends BaseQuickAdapter<Document, BaseViewHolder> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AccountService$Account f228455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.a f228456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f228457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f228458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f228459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f228460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ce5.a f228461g;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f228462c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Document f228463d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ GridStyleAdapter f228464e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            d.a r101 = this.f228464e.f228456b;
            if (r101 == null) goto L6;
            r101.D(r100, this.f228462c, this.f228463d, true);
            return;
        }

        public a(GridStyleAdapter r100, int r101, Document r102) {
            this.f228464e = r100;
            this.f228462c = r101;
            this.f228463d = r102;
        }
    }

    public class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f228465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Document f228466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ GridStyleAdapter f228467e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            j r101 = this.f228467e.f228457c;
            if (r101 == null) goto L6;
            r101.Y(r100, this.f228465c, this.f228466d, true);
            return;
        }

        public b(GridStyleAdapter r100, int r101, Document r102) {
            this.f228467e = r100;
            this.f228465c = r101;
            this.f228466d = r102;
        }
    }

    public boolean A2() {
        return true;
    }

    public boolean B2() {
        return true;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void M0(d.c r100) {
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getHeaderLayoutCount() + this.mData.size();
    }

    public IconShape C2() {
        return IconShape.SQUARE;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void I(d.a r100) {
        this.f228456b = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void L(AccountService$Account r100) {
        this.f228455a = r100;
        notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void o0(d.b r100) {
        this.f228457c = new j(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.list.list.d
    public final void setData(List<Document> r100) {
        this.mData = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void v(int r100) {
        tt5.a.h("GridStyleAdapter", "updateSortStrategy()...strategy = " + r100);
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void x0(boolean r100) {
        tt5.a.h("GridStyleAdapter", "changeNetworkState()...isConnect = " + r100);
        this.f228458d = r100;
    }

    public GridStyleAdapter(String r100, ce5.a r101) {
        super(R.layout.list_grid_item);
        this.f228459e = r100;
        this.f228460f = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.docs_diy_icon", false);
        this.f228458d = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
        this.f228461g = r101;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Document r101) {
        z2(r100, r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        return new GridStyleViewHolder(pd5.b.a.f528675a.a(this.mContext));
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final /* bridge */ /* synthetic */ void p2(int r100, Document r101) {
        super.setData(r100, r101);
    }

    public void z2(BaseViewHolder r100, Document r101) {
        int r102 = r100.getLayoutPosition() - getHeaderLayoutCount();
        if ((r100 instanceof GridStyleViewHolder) == false) goto L5;
        y2((GridStyleViewHolder) r100, r101, r102);
        lc5.f.m(this.f228458d, r101, "tab_" + this.f228459e);
        return;
    L5:
        tt5.a.h("GridStyleAdapter", "convert()...helper = " + r100);
    }

    public void y2(GridStyleViewHolder r110, Document r111, int r112) {
        boolean r100 = false;
        r110.f228468a.setVisibility(0);
        r110.f228468a.setTag(r111);
        r110.f228468a.setOnClickListener(new a(this, r112, r111));
        r110.f228474g.setText(t0.g(this.mContext, r111));
        r110.f228478k.setTitleVisibility(false);
        SpaceTagTitleView r101 = r110.f228478k;
        SpaceTagType[] r102 = new SpaceTagType[3];
        if (r111.f227878g2 == 0) goto L5;
        boolean r103 = true;
    L6:
        int r104 = SpaceTagType.f240339e;
        r102[0] = SpaceTagType.Companion.i(r103);
        String r105 = r111.E2;
        boolean r106 = r111.f227904x;
        if (NodeType.isShortcut(r111.M1) == false) goto L9;
    L13:
        boolean r107 = false;
    L14:
        r102[1] = SpaceTagType.Companion.f(r105, r106, r107);
        int r108 = 2;
        r102[2] = SpaceTagType.Companion.g(r111.f227907y);
        r101.setLabels(r102);
        boolean r109 = hu5.a.f(r110.f228478k.f240337e);
        ZoomLevel6 r113 = zz7.b.d();
        if (r109 == false) goto L17;
    L18:
        r108 = 1;
    L19:
        r110.f228474g.setMaxLines(r108);
        SpaceTagTitleView r114 = r110.f228478k;
        if (r109 == false) goto L22;
        int r115 = 0;
    L23:
        r114.setVisibility(r115);
        r110.f228475h.setTag(r111);
        r110.f228475h.setOnClickListener(new b(this, r112, r111));
        View r116 = r110.f228471d;
        if (r111.f227910z == true) goto L26;
    L28:
        int r117 = 8;
    L29:
        r116.setVisibility(r117);
        if (NodeType.isShortcut(r111.M1) == false) goto L32;
        r110.f228473f.setVisibility(0);
    L38:
        AppCompatImageView r118 = r110.f228472e;
        AccountService$Account r119 = this.f228455a;
        if (r119 == null) goto L41;
        String r120 = r119.token;
    L42:
        Context r121 = this.mContext;
        new fd5.e(new g0(r121, r111, r120, true, r118), this.f228460f, C2()).a(this.f228461g);
        Context r122 = this.mContext;
        r110.getItemId();
        boolean r123 = this.f228458d;
        int r124 = r111.getType();
        sbb.e r125 = sbb.e.f541295f;
        if (r124 == r125.f541317b) goto L45;
        fd5.b r126 = new fd5.a(r111, r122, r123);
    L52:
        r126.a(r110.f228469b, r110.f228470c);
        ViewGroup r127 = r110.f228468a;
        int r128 = r111.getType();
        if (r128 != r125.f541317b) goto L55;
    L72:
        r100 = true;
    L73:
        if (r100 == false) goto L75;
        float r129 = 1.0f;
    L76:
        r127.setAlpha(r129);
        return;
    L75:
        r129 = 0.3f;
        goto L76
    L55:
        if (TextUtils.isEmpty(r111.f227899u) == false) goto L72;
        if (this.f228458d == true) goto L72;
        if (r111.f227871b2 == true) goto L73;
        if (r111.f227903w == false) goto L69;
        if (r128 == sbb.e.f541303n.f541317b) goto L69;
        if (r128 != sbb.e.f541298i.f541317b) goto L72;
    L69:
        if (r128 != sbb.e.f541303n.f541317b) goto L73;
        if (r111.f227906x2 == false) goto L73;
    L45:
        if (NodeType.isShortcut(r111.M1) == false) goto L48;
        r126 = new n();
        goto L52
    L48:
        if (FolderVersion.isPersonalFolder(r111.L1, r111.P1) == false) goto L50;
        r126 = new l();
        goto L52
    L50:
        r126 = new n();
        goto L52
    L41:
        r120 = "";
        goto L42
    L32:
        r110.f228473f.setVisibility(8);
        SyncStateView r130 = r110.f228476i;
        r130.setBorderColor(r130.getContext().getResources().getColor(R.color.lkui_N00));
        r110.f228476i.setManualOffline(r111.f227892p0);
        r110.f228476i.setSyncState(r111.f227900v);
        if (r111.f227900v != 3) goto L38;
        if (r111.f227892p0 == false) goto L37;
        r111.f227900v = 7;
        goto L38
    L37:
        r111.f227900v = 0;
        goto L38
    L26:
        if (B2() == false) goto L28;
        r117 = 0;
        goto L29
    L22:
        r115 = 8;
        goto L23
    L17:
        if (r113.getLevel() <= ZoomLevel6.LARGE1.getLevel()) goto L19;
    L9:
        if (A2() == false) goto L13;
        int r131 = x4.f229847a;
        if (x4.a(this.f228455a) == false) goto L13;
        r107 = true;
        goto L14
    L5:
        r103 = false;
        goto L6
    }
}
