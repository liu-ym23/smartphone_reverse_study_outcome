package com.bytedance.ee.bear.list.list;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.g0;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.x4;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.l;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ss.android.lark.docs.icon.entity.IconShape;
import dd5.a1;
import dd5.y0;
import dd5.z0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ListStyleAdapter extends BaseQuickAdapter<Document, BaseViewHolder> implements View.OnClickListener, d {
    public static final /* synthetic */ int n = 0;
    public AccountService.Account a;
    public d.a b;
    public j c;
    public d.c d;
    public final DocsLinearLayoutManager e;
    public boolean f;
    public final String g;
    public int h;
    public final String i;
    public final boolean j;
    public final ce5.a k;
    public final Fragment l;
    public c m;

    public class a extends t {
        public final /* synthetic */ int c;
        public final /* synthetic */ Document d;
        public final /* synthetic */ ListStyleAdapter e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            tt5.a.h("ListStyleAdapter", "onClicked: mItemClickListener:" + this.e.b);
            d.a r0 = this.e.b;
            if (r0 == null) goto L6;
            r0.D(r5, this.c, this.d, false);
            return;
        }

        public a(ListStyleAdapter r1, int r2, Document r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public class b extends t {
        public final /* synthetic */ int c;
        public final /* synthetic */ Document d;
        public final /* synthetic */ ListStyleAdapter e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            j r0 = this.e.c;
            if (r0 == null) goto L5;
            r0.x0(r5, this.c, this.d, false);
        L5:
            this.e.D2();
        }

        public b(ListStyleAdapter r1, int r2, Document r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public interface c {
        boolean a(Document r1);
    }

    public boolean F2() {
        return true;
    }

    public boolean G2() {
        return true;
    }

    public final void D2() {
        if (SwipeMenuLayout.getViewCache() == null) goto L6;
        SwipeMenuLayout.getViewCache().f();
        return;
    }

    public IconShape H2() {
        if (kac.a.a() == true) goto L5;
        return null;
    L5:
        return IconShape.SQUARE;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final int getItemCount() {
        return getHeaderLayoutCount() + ((BaseQuickAdapter) this).mData.size();
    }

    private boolean C2(Document r5) {
        int r0 = r5.getType();
        if (r0 != sbb.e.f.b) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(r5.u) == true) goto L7;
        return true;
    L7:
        if (this.f == false) goto L10;
        return true;
    L10:
        if (r5.b2 == false) goto L13;
        return false;
    L13:
        if (r5.w == false) goto L21;
        if (r0 == sbb.e.n.b) goto L21;
        if (r0 == sbb.e.i.b) goto L21;
        if (r0 == sbb.e.m.b) goto L21;
        return true;
    L21:
        if (r0 == sbb.e.n.b) goto L23;
    L25:
        return false;
    L23:
        if (r5.x2 == false) goto L25;
        return true;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void I(d.a r3) {
        tt5.a.h("ListStyleAdapter", "setOnItemClickListener() called with: listener = [" + r3 + "]");
        this.b = r3;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void L(AccountService.Account r1) {
        this.a = r1;
        notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void M0(d.c r1) {
        this.d = r1;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void o0(d.b r2) {
        this.c = new j(r2);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        D2();
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void setData(List<Document> r1) {
        ((BaseQuickAdapter) this).mData = r1;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void v(int r3) {
        tt5.a.h("ListStyleAdapter", "updateSortStrategy()...strategy = " + r3);
        this.h = r3;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void x0(boolean r3) {
        tt5.a.h("ListStyleAdapter", "changeNetworkState()...isConnect = " + r3);
        this.f = r3;
    }

    public void E2(BaseViewHolder r3, Document r4) {
        int r0 = r3.getLayoutPosition() - getHeaderLayoutCount();
        if ((r3 instanceof ListStyleViewHolder) == false) goto L5;
        A2((ListStyleViewHolder) r3, r4, r0);
        lc5.f.m(this.f, r4, "tab_" + this.g);
        return;
    L5:
        tt5.a.h("ListStyleAdapter", "convert()...helper = " + r3 + ", position = " + r0);
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        E2(r1, (Document) r2);
    }

    public BaseViewHolder onCreateDefViewHolder(ViewGroup r2, int r3) {
        return new ListStyleViewHolder(pd5.c.a.a.a(r2.getContext()));
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final /* bridge */ /* synthetic */ void p2(int r1, Document r2) {
        super.setData(r1, r2);
    }

    public void y2(ListStyleViewHolder r2, Document r3) {
        r2.d.setText(t0.D(((BaseQuickAdapter) this).mContext, r3));
    }

    public void z2(Document r11, ImageView r12) {
        AccountService.Account r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.token;
    L6:
        String r4 = r1;
        if (kac.a.a() == false) goto L100;
        if (r12 == null) goto L100;
        JSONObject r2 = null;
        if (r11 == null) goto L13;
        String r3 = r11.F2;
    L15:
        if (TextUtils.isEmpty(r3) == false) goto L102;
    L20:
        boolean r5 = false;
        if (r11 == null) goto L79;
        int r6 = -1;
        if (r2 != null) goto L27;
    L28:
        int r8 = -1;
    L30:
        if (r8 == (-1)) goto L32;
        r6 = r8;
    L38:
        if (r6 != 1) goto L40;
        boolean r9 = true;
    L41:
        if (r9 == false) goto L43;
        int r7 = 30;
    L81:
        ViewGroup.LayoutParams r10 = r12.getLayoutParams();
        if (r10 == null) goto L100;
        int r13 = zz7.b.g(r12.getContext(), 40);
        int r14 = zz7.b.g(r12.getContext(), (40 - r7) / 2);
        if (r10.width == r13) goto L87;
    L88:
        r5 = true;
    L89:
        if (r5 == false) goto L92;
        r10.width = r13;
        r10.height = r13;
        r12.setLayoutParams(r10);
    L92:
        if (r12.getPaddingLeft() == r14) goto L94;
    L99:
        r12.setPadding(r14, r14, r14, r14);
        goto L100
    L94:
        if (r12.getPaddingTop() != r14) goto L99;
        if (r12.getPaddingRight() != r14) goto L99;
        if (r12.getPaddingBottom() == r14) goto L100;
    L87:
        if (r10.height == r13) goto L89;
    L43:
        if (r6 != 2) goto L45;
    L48:
        boolean r15 = true;
    L49:
        if (r15 == false) goto L51;
    L80:
        r7 = 34;
        goto L81
    L51:
        if (r11.getType() != sbb.e.n.b) goto L53;
        int r16 = r11.y1;
    L54:
        if (r2 == null) goto L60;
        if (r2.has("obj_type") == false) goto L60;
        r16 = r2.optInt("obj_type", r16);
    L60:
        if (r16 != sbb.e.i.b) goto L62;
        boolean r17 = true;
    L63:
        if (r17 == true) goto L80;
        if (r11.getType() != sbb.e.l.b) goto L76;
        if (r2 != null) goto L68;
    L71:
        boolean r18 = true;
    L72:
        if (r18 == false) goto L76;
        if (TextUtils.isEmpty(r11.H) == true) goto L76;
        boolean r19 = true;
    L77:
        if (r19 == false) goto L79;
    L68:
        if (TextUtils.isEmpty(r2.optString("key")) == true) goto L71;
        r18 = false;
    L76:
        r19 = false;
        goto L77
    L62:
        r17 = false;
        goto L63
    L53:
        r16 = r11.getType();
        goto L54
    L45:
        if (r6 == 3) goto L48;
        r15 = false;
        goto L49
    L40:
        r9 = false;
        goto L41
    L32:
        Document.DocumentIcon r20 = r11.k1;
        if (r20 == null) goto L38;
        if (TextUtils.isEmpty(r20.a) == true) goto L38;
        r6 = r20.b;
        goto L38
    L27:
        if (TextUtils.isEmpty(r2.optString("key")) == true) goto L28;
        r8 = r2.optInt(ResourceData.KEY_TYPE, -1);
    L79:
        r7 = 40;
        goto L81
    L102:
        r2 = new JSONObject(r3);     // Catch: Exception -> L19
        goto L20
    L13:
        r3 = null;
    L100:
        new fd5.e(new g0(((BaseQuickAdapter) this).mContext, r11, r4, false, r12), this.j, H2()).a(this.k);
        return;
    L5:
        r1 = "";
        goto L6
    }

    public void A2(final ListStyleViewHolder r10, final Document r11, int r12) {
        ((ArrayList) r10.a.p).clear();
        r10.a.setLayoutManager(this.e);
        SwipeMenuLayout r0 = r10.a;
        SwipeMenuLayout.c r1 = new z0(this, r11);
        if (((ArrayList) r0.p).contains(r1) == true) goto L5;
        ((ArrayList) r0.p).add(r1);
    L5:
        r10.b.setTag(r11);
        r10.b.setOnClickListener(new a(this, r12, r11));
        r10.c.setTitle(t0.g(((BaseQuickAdapter) this).mContext, r11));
        SpaceTagTitleView r2 = r10.c;
        SpaceTagType[] r3 = new SpaceTagType[4];
        boolean r4 = true;
        boolean r5 = false;
        if (r11.g2 == 0) goto L8;
        boolean r6 = true;
    L9:
        int r7 = SpaceTagType.e;
        r3[0] = SpaceTagType.Companion.i(r6);
        String r8 = r11.E2;
        boolean r9 = r11.x;
        if (NodeType.isShortcut(r11.M1) == false) goto L12;
    L16:
        boolean r13 = false;
    L17:
        r3[1] = SpaceTagType.Companion.f(r8, r9, r13);
        r3[2] = SpaceTagType.Companion.g(r11.y);
        if (r11.z == true) goto L20;
    L22:
        boolean r14 = false;
    L23:
        int r15 = SpaceTagType.e;
        r3[3] = SpaceTagType.Companion.h(r14);
        r2.setLabels(r3);
        if (NodeType.isShortcut(r11.M1) == false) goto L26;
        r10.g.setVisibility(0);
        r10.d.setText(2131887530);
    L47:
        z2(r11, r10.f);
        r10.h.setImageResource(2131255147);
        l.c(r10.h, 2131106521);
        r10.h.setTag(r11);
        r10.h.setOnClickListener(new h(this, r12, r11));
        r10.i.setImageResource(2131255656);
        l.c(r10.i, 2131106521);
        ImageView r16 = r10.i;
        if (r11.b() == true) goto L51;
        r4 = false;
    L51:
        float r17 = 0.3f;
        if (r4 == false) goto L54;
        float r18 = 0.3f;
    L55:
        r16.setAlpha(r18);
        r10.i.setTag(r11);
        r10.i.setOnClickListener(new i(this, r12, r11));
        B2(r10, r12, r11);
        if (ForsetiHelper.n() == true) goto L58;
    L71:
        r10.k.setVisibility(8);
        r10.k.setBackground(null);
    L72:
        ConstraintLayout r19 = r10.b;
        if (C2(r11) == false) goto L75;
        r17 = 1.0f;
    L75:
        r19.setAlpha(r17);
        SwipeMenuLayout r110 = r10.a;
        boolean r111 = C2(r11);
        boolean r20 = ForsetiHelper.n();
        boolean r112 = r10.a.getSwipeEnable();
        tt5.a.h("ListStyleAdapter", "enableSwipe: canOpenUnderOffline:" + r111 + " isEnablePadSpace:" + r20 + " swipeEnable:" + r112);
        if (r20 == false) goto L79;
        if (r112 == true) goto L79;
    L80:
        r110.setSwipeEnable(r5);
        return;
    L79:
        r5 = r111;
        goto L80
    L58:
        if (this.c.t0() == false) goto L71;
        r10.k.setVisibility(0);
        r10.k.setImageResource(2131255147);
        l.c(r10.k, 2131108724);
        r10.k.setTag(r11);
        r10.k.setOnClickListener(new g(this, r12, r11));
        Fragment r113 = this.l;
        if (r113 == null) goto L72;
        if (ForsetiHelper.s(r113) == false) goto L72;
        if (ForsetiHelper.n() == false) goto L72;
        ForsetiViewModel r114 = ForsetiHelper.j(this.l);
        if (r114 == null) goto L72;
        r114.getViewMode().observe(this.l, new a1(r10));
        goto L72
    L54:
        r18 = 1.0f;
        goto L55
    L26:
        r10.g.setVisibility(8);
        TextView r21 = r10.n;
        if (TextUtils.isEmpty(r11.T1) == true) goto L40;
        AccountService.Account r22 = this.a;
        if (r22 != null) goto L31;
    L37:
        boolean r23 = false;
    L38:
        if (r23 == false) goto L40;
        r21.setVisibility(0);
        r21.setText(r11.T1 + " · ");
        Drawable r24 = ((BaseQuickAdapter) this).mContext.getResources().getDrawable(2131255591);
        r24.setTint(((BaseQuickAdapter) this).mContext.getResources().getColor(2131106620));
        r24.setBounds(0, 0, y9c.d.a(14), y9c.d.a(14));
        r21.setCompoundDrawables(r24, null, null, null);
    L41:
        y2(r10, r11);
        r10.l.setManualOffline(r11.p0);
        r10.l.setSyncState(r11.v);
        r10.e.setVisibility(r10.l.getVisibility());
        r10.T3(r11.v);
        if (r11.v != 3) goto L47;
        if (r11.p0 == false) goto L46;
        r11.v = 7;
        goto L47
    L46:
        r11.v = 0;
        goto L47
    L31:
        if (TextUtils.equals(r11.f, r22.tenantId) == false) goto L37;
        if (r11.getType() != sbb.e.n.b) goto L36;
        r23 = fj5.a.b(r11.y1);
        goto L38
    L36:
        r23 = fj5.a.c(r11.getType(), DocVersion.isDocV2(r11.L1));
    L40:
        r21.setText("");
        r21.setCompoundDrawables(null, null, null, null);
        r21.setVisibility(8);
        goto L41
    L20:
        if (G2() == false) goto L22;
        r14 = true;
        goto L23
    L12:
        if (F2() == false) goto L16;
        int r25 = x4.a;
        if (x4.a(this.a) == false) goto L16;
        r13 = true;
        goto L17
    L8:
        r6 = false;
        goto L9
    }

    public void B2(ListStyleViewHolder r3, int r4, Document r5) {
        r3.j.setImageResource(2131254201);
        l.c(r3.j, 2131106521);
        ImageView r0 = r3.j;
        if (this.m.a(r5) == false) goto L8;
        if (r5 == null) goto L8;
        if (r5.b() == false) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        float r2 = 0.3f;
    L12:
        r0.setAlpha(r2);
        r3.j.setOnClickListener(new b(this, r4, r5));
        r3.j.setTag(r5);
        return;
    L11:
        r2 = 1.0f;
    L8:
        r1 = false;
        goto L9
    }

    public ListStyleAdapter(String r2, String r3, DocsLinearLayoutManager r4, ce5.a r5, LifeCycleFragment r6) {
        super(2131563505);
        this.m = new y0();
        this.k = r5;
        this.g = r2;
        this.i = r3;
        this.e = r4;
        this.j = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.docs_diy_icon", false);
        this.f = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        this.l = r6;
    }
}
