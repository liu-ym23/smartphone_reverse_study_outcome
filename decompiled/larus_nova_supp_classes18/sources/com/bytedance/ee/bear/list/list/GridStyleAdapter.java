package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.g0;
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
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.docs.icon.entity.IconShape;
import fd5.l;
import fd5.n;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GridStyleAdapter extends BaseQuickAdapter<Document, BaseViewHolder> implements d {
    public AccountService.Account a;
    public d.a b;
    public j c;
    public boolean d;
    public final String e;
    public final boolean f;
    public final ce5.a g;

    public class a extends t {
        public final /* synthetic */ int c;
        public final /* synthetic */ Document d;
        public final /* synthetic */ GridStyleAdapter e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            d.a r0 = this.e.b;
            if (r0 == null) goto L6;
            r0.D(r5, this.c, this.d, true);
            return;
        }

        public a(GridStyleAdapter r1, int r2, Document r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public class b extends t {
        public final /* synthetic */ int c;
        public final /* synthetic */ Document d;
        public final /* synthetic */ GridStyleAdapter e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            j r0 = this.e.c;
            if (r0 == null) goto L6;
            r0.Y(r5, this.c, this.d, true);
            return;
        }

        public b(GridStyleAdapter r1, int r2, Document r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public boolean A2() {
        return true;
    }

    public boolean B2() {
        return true;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void M0(d.c r1) {
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final int getItemCount() {
        return getHeaderLayoutCount() + ((BaseQuickAdapter) this).mData.size();
    }

    public IconShape C2() {
        return IconShape.SQUARE;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void I(d.a r1) {
        this.b = r1;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void L(AccountService.Account r1) {
        this.a = r1;
        notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void o0(d.b r2) {
        this.c = new j(r2);
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void setData(List<Document> r1) {
        ((BaseQuickAdapter) this).mData = r1;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void v(int r3) {
        tt5.a.h("GridStyleAdapter", "updateSortStrategy()...strategy = " + r3);
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void x0(boolean r3) {
        tt5.a.h("GridStyleAdapter", "changeNetworkState()...isConnect = " + r3);
        this.d = r3;
    }

    public GridStyleAdapter(String r3, ce5.a r4) {
        super(2131563488);
        this.e = r3;
        this.f = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.docs_diy_icon", false);
        this.d = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        this.g = r4;
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        z2(r1, (Document) r2);
    }

    public BaseViewHolder onCreateDefViewHolder(ViewGroup r2, int r3) {
        return new GridStyleViewHolder(pd5.b.a.a.a(((BaseQuickAdapter) this).mContext));
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final /* bridge */ /* synthetic */ void p2(int r1, Document r2) {
        super.setData(r1, r2);
    }

    public void z2(BaseViewHolder r3, Document r4) {
        int r0 = r3.getLayoutPosition() - getHeaderLayoutCount();
        if ((r3 instanceof GridStyleViewHolder) == false) goto L5;
        y2((GridStyleViewHolder) r3, r4, r0);
        lc5.f.m(this.d, r4, "tab_" + this.e);
        return;
    L5:
        tt5.a.h("GridStyleAdapter", "convert()...helper = " + r3);
    }

    public void y2(GridStyleViewHolder r13, Document r14, int r15) {
        boolean r1 = false;
        r13.a.setVisibility(0);
        r13.a.setTag(r14);
        r13.a.setOnClickListener(new a(this, r15, r14));
        r13.g.setText(t0.g(((BaseQuickAdapter) this).mContext, r14));
        r13.k.setTitleVisibility(false);
        SpaceTagTitleView r0 = r13.k;
        SpaceTagType[] r3 = new SpaceTagType[3];
        if (r14.g2 == 0) goto L5;
        boolean r4 = true;
    L6:
        int r6 = SpaceTagType.e;
        r3[0] = SpaceTagType.Companion.i(r4);
        String r5 = r14.E2;
        boolean r7 = r14.x;
        if (NodeType.isShortcut(r14.M1) == false) goto L9;
    L13:
        boolean r8 = false;
    L14:
        r3[1] = SpaceTagType.Companion.f(r5, r7, r8);
        int r9 = 2;
        r3[2] = SpaceTagType.Companion.g(r14.y);
        r0.setLabels(r3);
        boolean r2 = hu5.a.f(r13.k.e);
        ZoomLevel6 r10 = zz7.b.d();
        if (r2 == false) goto L17;
    L18:
        r9 = 1;
    L19:
        r13.g.setMaxLines(r9);
        SpaceTagTitleView r11 = r13.k;
        if (r2 == false) goto L22;
        int r12 = 0;
    L23:
        r11.setVisibility(r12);
        r13.h.setTag(r14);
        r13.h.setOnClickListener(new b(this, r15, r14));
        View r16 = r13.d;
        if (r14.z == true) goto L26;
    L28:
        int r17 = 8;
    L29:
        r16.setVisibility(r17);
        if (NodeType.isShortcut(r14.M1) == false) goto L32;
        r13.f.setVisibility(0);
    L38:
        AppCompatImageView r18 = r13.e;
        AccountService.Account r19 = this.a;
        if (r19 == null) goto L41;
        String r110 = r19.token;
    L42:
        Context r20 = ((BaseQuickAdapter) this).mContext;
        new fd5.e(new g0(r20, r14, r110, true, r18), this.f, C2()).a(this.g);
        Context r111 = ((BaseQuickAdapter) this).mContext;
        r13.getItemId();
        boolean r21 = this.d;
        int r22 = r14.getType();
        sbb.e r23 = sbb.e.f;
        if (r22 == r23.b) goto L45;
        fd5.b r112 = new fd5.a(r14, r111, r21);
    L52:
        r112.a(r13.b, r13.c);
        ViewGroup r113 = r13.a;
        int r114 = r14.getType();
        if (r114 != r23.b) goto L55;
    L72:
        r1 = true;
    L73:
        if (r1 == false) goto L75;
        float r115 = 1.0f;
    L76:
        r113.setAlpha(r115);
        return;
    L75:
        r115 = 0.3f;
        goto L76
    L55:
        if (TextUtils.isEmpty(r14.u) == false) goto L72;
        if (this.d == true) goto L72;
        if (r14.b2 == true) goto L73;
        if (r14.w == false) goto L69;
        if (r114 == sbb.e.n.b) goto L69;
        if (r114 != sbb.e.i.b) goto L72;
    L69:
        if (r114 != sbb.e.n.b) goto L73;
        if (r14.x2 == false) goto L73;
    L45:
        if (NodeType.isShortcut(r14.M1) == false) goto L48;
        r112 = new n();
        goto L52
    L48:
        if (FolderVersion.isPersonalFolder(r14.L1, r14.P1) == false) goto L50;
        r112 = new l();
        goto L52
    L50:
        r112 = new n();
        goto L52
    L41:
        r110 = "";
        goto L42
    L32:
        r13.f.setVisibility(8);
        LKUIRoundedImageView2 r116 = r13.i;
        r116.setBorderColor(r116.getContext().getResources().getColor(2131103449));
        r13.i.setManualOffline(r14.p0);
        r13.i.setSyncState(r14.v);
        if (r14.v != 3) goto L38;
        if (r14.p0 == false) goto L37;
        r14.v = 7;
        goto L38
    L37:
        r14.v = 0;
        goto L38
    L26:
        if (B2() == false) goto L28;
        r17 = 0;
        goto L29
    L22:
        r12 = 8;
        goto L23
    L17:
        if (r10.getLevel() <= ZoomLevel6.LARGE1.getLevel()) goto L19;
    L9:
        if (A2() == false) goto L13;
        int r24 = x4.a;
        if (x4.a(this.a) == false) goto L13;
        r8 = true;
        goto L14
    L5:
        r4 = false;
        goto L6
    }
}
