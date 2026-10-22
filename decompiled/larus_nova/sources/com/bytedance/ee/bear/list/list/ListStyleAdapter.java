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
import com.bytedance.ee.bear.contract.AccountService$Account;
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
import com.bytedance.ee.util.ui.l;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import dd5.a1;
import dd5.y0;
import dd5.z0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class ListStyleAdapter extends BaseQuickAdapter<Document, BaseViewHolder> implements View.OnClickListener, d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f228479n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AccountService$Account f228480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.a f228481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f228482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d.c f228483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DocsLinearLayoutManager f228484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f228485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f228486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f228487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f228488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f228489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ce5.a f228490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Fragment f228491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f228492m;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f228493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Document f228494d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ListStyleAdapter f228495e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            tt5.a.h("ListStyleAdapter", "onClicked: mItemClickListener:" + this.f228495e.f228481b);
            d.a r101 = this.f228495e.f228481b;
            if (r101 == null) goto L6;
            r101.D(r100, this.f228493c, this.f228494d, false);
            return;
        }

        public a(ListStyleAdapter r100, int r101, Document r102) {
            this.f228495e = r100;
            this.f228493c = r101;
            this.f228494d = r102;
        }
    }

    public class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f228496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Document f228497d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ListStyleAdapter f228498e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            j r101 = this.f228498e.f228482c;
            if (r101 == null) goto L5;
            r101.x0(r100, this.f228496c, this.f228497d, false);
        L5:
            this.f228498e.D2();
        }

        public b(ListStyleAdapter r100, int r101, Document r102) {
            this.f228498e = r100;
            this.f228496c = r101;
            this.f228497d = r102;
        }
    }

    public interface c {
        boolean a(Document r100);
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getHeaderLayoutCount() + this.mData.size();
    }

    private boolean C2(Document r100) {
        int r101 = r100.getType();
        if (r101 != sbb.e.f541295f.f541317b) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(r100.f227899u) == true) goto L7;
        return true;
    L7:
        if (this.f228485f == false) goto L10;
        return true;
    L10:
        if (r100.f227871b2 == false) goto L13;
        return false;
    L13:
        if (r100.f227903w == false) goto L21;
        if (r101 == sbb.e.f541303n.f541317b) goto L21;
        if (r101 == sbb.e.f541298i.f541317b) goto L21;
        if (r101 == sbb.e.f541302m.f541317b) goto L21;
        return true;
    L21:
        if (r101 == sbb.e.f541303n.f541317b) goto L23;
    L25:
        return false;
    L23:
        if (r100.f227906x2 == false) goto L25;
        return true;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void I(d.a r100) {
        tt5.a.h("ListStyleAdapter", "setOnItemClickListener() called with: listener = [" + r100 + "]");
        this.f228481b = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void L(AccountService$Account r100) {
        this.f228480a = r100;
        notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void M0(d.c r100) {
        this.f228483d = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void o0(d.b r100) {
        this.f228482c = new j(r100);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        D2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.list.list.d
    public final void setData(List<Document> r100) {
        this.mData = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void v(int r100) {
        tt5.a.h("ListStyleAdapter", "updateSortStrategy()...strategy = " + r100);
        this.f228487h = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final void x0(boolean r100) {
        tt5.a.h("ListStyleAdapter", "changeNetworkState()...isConnect = " + r100);
        this.f228485f = r100;
    }

    public void E2(BaseViewHolder r100, Document r101) {
        int r102 = r100.getLayoutPosition() - getHeaderLayoutCount();
        if ((r100 instanceof ListStyleViewHolder) == false) goto L5;
        A2((ListStyleViewHolder) r100, r101, r102);
        lc5.f.m(this.f228485f, r101, "tab_" + this.f228486g);
        return;
    L5:
        tt5.a.h("ListStyleAdapter", "convert()...helper = " + r100 + ", position = " + r102);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Document r101) {
        E2(r100, r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        return new ListStyleViewHolder(pd5.c.a.f528677a.a(r100.getContext()));
    }

    @Override // com.bytedance.ee.bear.list.list.d
    public final /* bridge */ /* synthetic */ void p2(int r100, Document r101) {
        super.setData(r100, r101);
    }

    public void y2(ListStyleViewHolder r100, Document r101) {
        r100.f228502d.setText(t0.D(this.mContext, r101));
    }

    public void z2(Document r110, ImageView r111) {
        AccountService$Account r100 = this.f228480a;
        if (r100 == null) goto L5;
        String r101 = r100.token;
    L6:
        String r102 = r101;
        if (kac.a.a() == false) goto L100;
        if (r111 == null) goto L100;
        JSONObject r103 = null;
        if (r110 == null) goto L13;
        String r104 = r110.F2;
    L15:
        if (TextUtils.isEmpty(r104) == false) goto L102;
    L20:
        boolean r105 = false;
        if (r110 == null) goto L79;
        int r106 = -1;
        if (r103 != null) goto L27;
    L28:
        int r107 = -1;
    L30:
        if (r107 == (-1)) goto L32;
        r106 = r107;
    L38:
        if (r106 != 1) goto L40;
        boolean r108 = true;
    L41:
        if (r108 == false) goto L43;
        int r109 = 30;
    L81:
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L100;
        int r113 = zz7.b.g(r111.getContext(), 40);
        int r114 = zz7.b.g(r111.getContext(), (40 - r109) / 2);
        if (r112.width == r113) goto L87;
    L88:
        r105 = true;
    L89:
        if (r105 == false) goto L92;
        r112.width = r113;
        r112.height = r113;
        r111.setLayoutParams(r112);
    L92:
        if (r111.getPaddingLeft() == r114) goto L94;
    L99:
        r111.setPadding(r114, r114, r114, r114);
        goto L100
    L94:
        if (r111.getPaddingTop() != r114) goto L99;
        if (r111.getPaddingRight() != r114) goto L99;
        if (r111.getPaddingBottom() == r114) goto L100;
    L87:
        if (r112.height == r113) goto L89;
    L43:
        if (r106 != 2) goto L45;
    L48:
        boolean r115 = true;
    L49:
        if (r115 == false) goto L51;
    L80:
        r109 = 34;
        goto L81
    L51:
        if (r110.getType() != sbb.e.f541303n.f541317b) goto L53;
        int r116 = r110.f227908y1;
    L54:
        if (r103 == null) goto L60;
        if (r103.has("obj_type") == false) goto L60;
        r116 = r103.optInt("obj_type", r116);
    L60:
        if (r116 != sbb.e.f541298i.f541317b) goto L62;
        boolean r117 = true;
    L63:
        if (r117 == true) goto L80;
        if (r110.getType() != sbb.e.f541301l.f541317b) goto L76;
        if (r103 != null) goto L68;
    L71:
        boolean r118 = true;
    L72:
        if (r118 == false) goto L76;
        if (TextUtils.isEmpty(r110.H) == true) goto L76;
        boolean r119 = true;
    L77:
        if (r119 == false) goto L79;
    L68:
        if (TextUtils.isEmpty(r103.optString("key")) == true) goto L71;
        r118 = false;
    L76:
        r119 = false;
        goto L77
    L62:
        r117 = false;
        goto L63
    L53:
        r116 = r110.getType();
        goto L54
    L45:
        if (r106 == 3) goto L48;
        r115 = false;
        goto L49
    L40:
        r108 = false;
        goto L41
    L32:
        Document.DocumentIcon r120 = r110.f227886k1;
        if (r120 == null) goto L38;
        if (TextUtils.isEmpty(r120.f227911a) == true) goto L38;
        r106 = r120.f227912b;
        goto L38
    L27:
        if (TextUtils.isEmpty(r103.optString("key")) == true) goto L28;
        r107 = r103.optInt("type", -1);
    L79:
        r109 = 40;
        goto L81
    L102:
        r103 = new JSONObject(r104);     // Catch: Exception -> L19
        goto L20
    L13:
        r104 = null;
    L100:
        new fd5.e(new g0(this.mContext, r110, r102, false, r111), this.f228489j, H2()).a(this.f228490k);
        return;
    L5:
        r101 = "";
        goto L6
    }

    public void A2(final ListStyleViewHolder r110, final Document r111, int r112) {
        ((ArrayList) r110.f228499a.f226703p).clear();
        r110.f228499a.setLayoutManager(this.f228484e);
        SwipeMenuLayout r100 = r110.f228499a;
        SwipeMenuLayout.c r101 = new z0(this, r111);
        if (((ArrayList) r100.f226703p).contains(r101) == true) goto L5;
        ((ArrayList) r100.f226703p).add(r101);
    L5:
        r110.f228500b.setTag(r111);
        r110.f228500b.setOnClickListener(new a(this, r112, r111));
        r110.f228501c.setTitle(t0.g(this.mContext, r111));
        SpaceTagTitleView r102 = r110.f228501c;
        SpaceTagType[] r103 = new SpaceTagType[4];
        boolean r104 = true;
        boolean r105 = false;
        if (r111.f227878g2 == 0) goto L8;
        boolean r106 = true;
    L9:
        int r107 = SpaceTagType.f240339e;
        r103[0] = SpaceTagType.Companion.i(r106);
        String r108 = r111.E2;
        boolean r109 = r111.f227904x;
        if (NodeType.isShortcut(r111.M1) == false) goto L12;
    L16:
        boolean r113 = false;
    L17:
        r103[1] = SpaceTagType.Companion.f(r108, r109, r113);
        r103[2] = SpaceTagType.Companion.g(r111.f227907y);
        if (r111.f227910z == true) goto L20;
    L22:
        boolean r114 = false;
    L23:
        int r115 = SpaceTagType.f240339e;
        r103[3] = SpaceTagType.Companion.h(r114);
        r102.setLabels(r103);
        if (NodeType.isShortcut(r111.M1) == false) goto L26;
        r110.f228505g.setVisibility(0);
        r110.f228502d.setText(R.string.CreationMobile_Wiki_Shortcuts_ShortcutLabel_Placeholder);
    L47:
        z2(r111, r110.f228504f);
        r110.f228506h.setImageResource(R.drawable.ud_icon_more_outlined);
        l.c(r110.f228506h, R.color.static_white);
        r110.f228506h.setTag(r111);
        r110.f228506h.setOnClickListener(new h(this, r112, r111));
        r110.f228507i.setImageResource(R.drawable.ud_icon_share_outlined);
        l.c(r110.f228507i, R.color.static_white);
        ImageView r116 = r110.f228507i;
        if (r111.b() == true) goto L51;
        r104 = false;
    L51:
        float r117 = 0.3f;
        if (r104 == false) goto L54;
        float r118 = 0.3f;
    L55:
        r116.setAlpha(r118);
        r110.f228507i.setTag(r111);
        r110.f228507i.setOnClickListener(new i(this, r112, r111));
        B2(r110, r112, r111);
        if (ForsetiHelper.n() == true) goto L58;
    L71:
        r110.f228509k.setVisibility(8);
        r110.f228509k.setBackground(null);
    L72:
        ConstraintLayout r119 = r110.f228500b;
        if (C2(r111) == false) goto L75;
        r117 = 1.0f;
    L75:
        r119.setAlpha(r117);
        SwipeMenuLayout r120 = r110.f228499a;
        boolean r121 = C2(r111);
        boolean r122 = ForsetiHelper.n();
        boolean r123 = r110.f228499a.getSwipeEnable();
        tt5.a.h("ListStyleAdapter", "enableSwipe: canOpenUnderOffline:" + r121 + " isEnablePadSpace:" + r122 + " swipeEnable:" + r123);
        if (r122 == false) goto L79;
        if (r123 == true) goto L79;
    L80:
        r120.setSwipeEnable(r105);
        return;
    L79:
        r105 = r121;
        goto L80
    L58:
        if (this.f228482c.t0() == false) goto L71;
        r110.f228509k.setVisibility(0);
        r110.f228509k.setImageResource(R.drawable.ud_icon_more_outlined);
        l.c(r110.f228509k, R.color.ud_N600);
        r110.f228509k.setTag(r111);
        r110.f228509k.setOnClickListener(new g(this, r112, r111));
        Fragment r124 = this.f228491l;
        if (r124 == null) goto L72;
        if (ForsetiHelper.s(r124) == false) goto L72;
        if (ForsetiHelper.n() == false) goto L72;
        ForsetiViewModel r125 = ForsetiHelper.j(this.f228491l);
        if (r125 == null) goto L72;
        r125.getViewMode().observe(this.f228491l, new a1(r110));
        goto L72
    L54:
        r118 = 1.0f;
        goto L55
    L26:
        r110.f228505g.setVisibility(8);
        TextView r126 = r110.f228512n;
        if (TextUtils.isEmpty(r111.T1) == true) goto L40;
        AccountService$Account r127 = this.f228480a;
        if (r127 != null) goto L31;
    L37:
        boolean r128 = false;
    L38:
        if (r128 == false) goto L40;
        r126.setVisibility(0);
        r126.setText(r111.T1 + " · ");
        Drawable r129 = this.mContext.getResources().getDrawable(R.drawable.ud_icon_safe_pass_outlined);
        r129.setTint(this.mContext.getResources().getColor(R.color.text_placeholder));
        r129.setBounds(0, 0, y9c.d.a(14), y9c.d.a(14));
        r126.setCompoundDrawables(r129, null, null, null);
    L41:
        y2(r110, r111);
        r110.f228510l.setManualOffline(r111.f227892p0);
        r110.f228510l.setSyncState(r111.f227900v);
        r110.f228503e.setVisibility(r110.f228510l.getVisibility());
        r110.T3(r111.f227900v);
        if (r111.f227900v != 3) goto L47;
        if (r111.f227892p0 == false) goto L46;
        r111.f227900v = 7;
        goto L47
    L46:
        r111.f227900v = 0;
        goto L47
    L31:
        if (TextUtils.equals(r111.f227875f, r127.tenantId) == false) goto L37;
        if (r111.getType() != sbb.e.f541303n.f541317b) goto L36;
        r128 = fj5.a.b(r111.f227908y1);
        goto L38
    L36:
        r128 = fj5.a.c(r111.getType(), DocVersion.isDocV2(r111.L1));
    L40:
        r126.setText("");
        r126.setCompoundDrawables(null, null, null, null);
        r126.setVisibility(8);
        goto L41
    L20:
        if (G2() == false) goto L22;
        r114 = true;
        goto L23
    L12:
        if (F2() == false) goto L16;
        int r130 = x4.f229847a;
        if (x4.a(this.f228480a) == false) goto L16;
        r113 = true;
        goto L17
    L8:
        r106 = false;
        goto L9
    }

    public void B2(ListStyleViewHolder r100, int r101, Document r102) {
        r100.f228508j.setImageResource(R.drawable.ud_icon_delete_trash_outlined);
        l.c(r100.f228508j, R.color.static_white);
        ImageView r103 = r100.f228508j;
        if (this.f228492m.a(r102) == false) goto L8;
        if (r102 == null) goto L8;
        if (r102.b() == false) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        float r105 = 0.3f;
    L12:
        r103.setAlpha(r105);
        r100.f228508j.setOnClickListener(new b(this, r101, r102));
        r100.f228508j.setTag(r102);
        return;
    L11:
        r105 = 1.0f;
    L8:
        r104 = false;
        goto L9
    }

    public ListStyleAdapter(String r100, String r101, DocsLinearLayoutManager r102, ce5.a r103, LifeCycleFragment r104) {
        super(R.layout.list_list_item);
        this.f228492m = new y0();
        this.f228490k = r103;
        this.f228486g = r100;
        this.f228488i = r101;
        this.f228484e = r102;
        this.f228489j = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.docs_diy_icon", false);
        this.f228485f = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
        this.f228491l = r104;
    }
}
