package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.common.widget.InterceptableRecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiHorizontalScrollView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemBackgroundDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemNewDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemPressedDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiScrollTextView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiTreeItemTouchListener;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikNodeType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiBottomDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;
import com.oubowu.stickyitemdecoration.StickyItemDecoration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\f\u0010\r\u001a\u00060\u000eR\u00020\u0001H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeView;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isSidebarView", "", "getWikiAdapter", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$WikiAdapter;", "initView", "", "initStickyHeadView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setItemDecorations", "decors", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "canAdd", "decor", "getDefaultItemDecorations", "isPositionValid", "position", "SidebarTreeAdapter", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarTreeView extends WikiTreeView {
    public static final /* synthetic */ int F = 0;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeView$SidebarTreeAdapter;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView$WikiAdapter;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeView;", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeView;)V", "onCreateDefViewHolder", "Lcom/chad/library/adapter/base/BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "convert", "", "holder", "node", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "bindTitleRootView", "view", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemTitleRootView;", "fromStickyHeader", "", "bindTitleView", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemTitleView;", "bindSpaceView", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemSpaceView;", "bindDocumentView", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarItemDocumentView;", "bindDirView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemDirView;", "bindItemView", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikItemLeafView;", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SidebarTreeAdapter extends WikiTreeView.WikiAdapter {
        public final /* synthetic */ SidebarTreeView e;

        public static final class a implements WikItemDirView.b {
            public final /* synthetic */ SidebarTreeView a;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

            public a(SidebarTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView.b
            public final void a(boolean r3) {
                WikiTreeView.b r0 = this.a.getListener();
                if (r0 == null) goto L5;
                r0.e(this.b);
            L5:
                WikiTreeView.b r1 = this.a.getListener();
                if (r1 == null) goto L9;
                r1.f(this.b, r3);
                return;
            }
        }

        public static final class b implements WikItemDirView.b {
            public final /* synthetic */ SidebarTreeView a;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

            public b(SidebarTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView.b
            public final void a(boolean r3) {
                WikiTreeView.b r0 = this.a.getListener();
                if (r0 == null) goto L6;
                r0.f(this.b, r3);
                return;
            }
        }

        public static final class c implements WikItemLeafView.e {
            public final /* synthetic */ SidebarTreeView a;
            public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;
            public final /* synthetic */ SidebarItemTitleRootView c;

            public c(SidebarTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2, SidebarItemTitleRootView r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView.e
            public final void a() {
                WikiTreeView.b r0 = this.a.getListener();
                if (r0 == null) goto L6;
                r0.f(this.b, !this.c.u);
                return;
            }
        }

        public static final class d implements View.OnClickListener {
            public final /* synthetic */ SidebarTreeView a;
            public final /* synthetic */ SidebarItemTitleRootView b;

            public d(SidebarTreeView r1, SidebarItemTitleRootView r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                WikiTreeView.b r3 = this.a.getListener();
                if (r3 == null) goto L6;
                r3.h(this.b);
                return;
            }
        }

        public SidebarTreeAdapter(SidebarTreeView r1) {
            this.e = r1;
            super(r1);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.WikiAdapter
        public final void C2(BaseViewHolder r8, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r9) {
            Intrinsics.checkNotNullParameter(r8, "holder");
            Intrinsics.checkNotNullParameter(r9, "node");
            View r0 = ((RecyclerView.ViewHolder) r8).itemView;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView");
            WikItemLeafView r1 = (WikItemLeafView) r0;
            r1.f();
            int r10 = r8.getItemViewType();
            if (r10 != WikNodeType.TITLE_ROOT.getValue()) goto L6;
            F2((SidebarItemTitleRootView) r1, r9, false);
            return;
        L6:
            if (r10 != WikNodeType.TITLE.getValue()) goto L9;
            SidebarItemTitleView r2 = (SidebarItemTitleView) r1;
            r2.setIconPadding(0);
            r2.setSwipeMenuEnable(false);
            r2.setTitle(r9.e);
            r2.setFocus(false);
            r2.setSwipeMenuEnable(false);
            r2.setMenuClickEnable(true);
            r2.setItemClickListener(new g(this.e, r9));
            r2.setExpand(r9.p);
            r2.getLayoutParams().width = -1;
            return;
        L9:
            if (r10 != WikNodeType.SPACE.getValue()) goto L25;
            SidebarItemSpaceView r3 = (SidebarItemSpaceView) r1;
            r3.setIconPadding(0);
            com.bytedance.ee.bear.wikiv2.icon.d r11 = this.a;
            com.bytedance.ee.bear.wikiv2.icon.c r4 = new com.bytedance.ee.bear.wikiv2.icon.c();
            SidebarTreeView r5 = this.e;
            String r6 = r9.b;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.WIKI_TOKEN);
            if (TextUtils.isEmpty(r5.q) == false) goto L13;
        L15:
            boolean r7 = false;
        L16:
            r4.a = r7;
            r4.b = true;
            r4.c = true;
            r4.d = this.b;
            r4.e = this.c;
            Unit r12 = Unit.INSTANCE;
            r11.a(r9, r3, r4, this.e.getUserComponentAbility());
            r3.setTitle(WikiTreeView.WikiAdapter.D2(r9));
            int r13 = h18.e.a;
            r3.setTitleStyle(h18.e.b(this.e.getContext(), 0));
            r3.g(r9.o - 1, this.e.getWikiUIList().b);
            r3.setFocus(false);
            r3.setSwipeMenuEnable(false);
            r3.setMenuClickEnable(false);
            int r14 = this.e.getTitleRightMargin();
            Object r15 = r3.findViewById(2131388772);
            if (r15 != null) goto L19;
        L21:
            r3.setSwipeMenuClickListener(new com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.c(this.e, r9, r3));
            r3.setUserSwipeMenuListener(new com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.d(this.e, r9));
            r3.setItemClickListener(new e(r3));
            r3.setLoading(false);
            Gson r16 = dr5.a.a;
            dr5.a.C0226a.a(r9, r3.getIndicatorView());
            r3.setExpand(r9.p);
            r3.setExpandClickListener(new f(this.e, r9));
            if (this.e.e(r9) == true) goto L40;
            r3.d();
            return;
        L40:
            return;
        L19:
            if ((r15 instanceof WikiScrollTextView) == false) goto L21;
            ((WikiScrollTextView) r15).b = r14;
            goto L21
        L13:
            if (TextUtils.equals(r5.q, r6) == false) goto L15;
            r7 = true;
            goto L16
        L25:
            if (r10 != WikNodeType.DOCUMENT.getValue()) goto L28;
            SidebarItemDocumentView r17 = (SidebarItemDocumentView) r1;
            z2(r17, r9);
            r17.setMenuClickEnable(true);
            r17.i(2131387817, false);
            return;
        L28:
            if (r10 != WikNodeType.ROOT.getValue()) goto L31;
            B2((SidebarItemRootView) r1, r9, false);
            return;
        L31:
            if (r10 != WikNodeType.NONE.getValue()) goto L34;
            A2((SidebarItemNoneView) r1, r9);
            return;
        L34:
            if (r10 != WikNodeType.DIR.getValue()) goto L36;
            y2((SidebarItemDirView) r1, r9);
            return;
        L36:
            z2(r1, r9);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.WikiAdapter
        public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
            C2(r1, (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) r2);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.WikiAdapter
        public final BaseViewHolder onCreateDefViewHolder(ViewGroup r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "parent");
            WikItemLeafView r2 = null;
            if (r11 != WikNodeType.TITLE_ROOT.getValue()) goto L6;
            BaseViewHolder r12 = new BaseViewHolder(new SidebarItemTitleRootView(this.e.getContext(), null, 0, 14));
        L24:
            View r13 = ((RecyclerView.ViewHolder) r12).itemView;
            if ((r13 instanceof WikItemLeafView) == false) goto L27;
            r2 = (WikItemLeafView) r13;
        L27:
            if (r2 == null) goto L29;
            SidebarTreeView r14 = this.e;
            int r0 = SidebarTreeView.F;
            r2.setScrollManager(r14.getScrollManager());
        L29:
            return r12;
        L6:
            if (r11 != WikNodeType.TITLE.getValue()) goto L9;
            r12 = new BaseViewHolder(new SidebarItemTitleView(this.e.getContext(), null, 0, 14));
            goto L24
        L9:
            if (r11 != WikNodeType.SPACE.getValue()) goto L12;
            r12 = new BaseViewHolder(new SidebarItemSpaceView(this.e.getContext(), null, 0, 14));
            goto L24
        L12:
            if (r11 != WikNodeType.DOCUMENT.getValue()) goto L15;
            r12 = new BaseViewHolder(new SidebarItemDocumentView(this.e.getContext(), null, 0, 14));
            goto L24
        L15:
            if (r11 != WikNodeType.ROOT.getValue()) goto L18;
            r12 = new BaseViewHolder(new SidebarItemRootView(this.e.getContext(), null, 0, 14, 0));
            goto L24
        L18:
            if (r11 != WikNodeType.NONE.getValue()) goto L21;
            r12 = new BaseViewHolder(new SidebarItemNoneView(this.e.getContext(), null, 0, 14));
            goto L24
        L21:
            if (r11 != WikNodeType.DIR.getValue()) goto L23;
            r12 = new BaseViewHolder(new SidebarItemDirView(this.e.getContext(), null, 0, 14, 0));
            goto L24
        L23:
            r12 = new BaseViewHolder(new SidebarItemLeafView(this.e.getContext(), null, 0, 14, 0));
            goto L24
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.WikiAdapter
        public final void y2(WikItemDirView r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "node");
            Gson r0 = dr5.a.a;
            dr5.a.C0226a.a(r3, r2.getIndicatorView());
            z2(r2, r3);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView.WikiAdapter
        public final void z2(WikItemLeafView r5, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r6) {
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "node");
            super.z2(r5, r6);
            if (r6.c() == true) goto L5;
            return;
        L5:
            if ((r5 instanceof WikItemDirView) == false) goto L23;
            boolean r1 = true;
            if (pq5.a.a(r6) == true) goto L19;
            Intrinsics.checkNotNullParameter(r6, "<this>");
            if (TextUtils.equals("wikiroot%title_root_share_token", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r6.n, 0)) == true) goto L11;
        L15:
            boolean r0 = false;
        L16:
            if (r0 == true) goto L19;
            r1 = false;
            goto L19
        L11:
            if (r6.o != 1) goto L15;
            if (TextUtils.equals("wikiroot%title_root_share_token", r6.f) == true) goto L15;
            r0 = true;
        L19:
            if (r1 == false) goto L24;
            ((WikItemDirView) r5).setExpandClickListener(new a(this.e, r6));
            return;
        L24:
            return;
        }

        public final void F2(SidebarItemTitleRootView r5, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "node");
            if (r7 == false) goto L20;
            ce5.a r2 = this.e.getUserComponentAbility();
            if (r2 == null) goto L13;
            BenefitManagerAPI r3 = r2.g;
            if (r3 == null) goto L13;
            BenefitStore r4 = r3.n1();
            if (r4 == null) goto L13;
            if (r4.hasBenefit("common_wiki_node_management") == true) goto L13;
            boolean r8 = true;
        L14:
            boolean r9 = !r8;
            if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.b(r6) == false) goto L18;
            if (r9 == false) goto L18;
            boolean r10 = true;
        L19:
            r5.setCreateButtonVisible(r10);
        L18:
            r10 = false;
        L13:
            r8 = false;
        L20:
            r5.setIconPadding(this.e.getIndicatorPadding());
            r5.setSwipeMenuEnable(false);
            r5.setTitle(r6.e);
            com.bytedance.ee.bear.wikiv2.icon.d r11 = this.a;
            com.bytedance.ee.bear.wikiv2.icon.c r12 = new com.bytedance.ee.bear.wikiv2.icon.c();
            r12.a = false;
            r12.b = false;
            r12.c = true;
            r12.d = this.b;
            r12.e = this.c;
            Unit r0 = Unit.INSTANCE;
            r11.a(r6, r5, r12, this.e.getUserComponentAbility());
            Gson r1 = dr5.a.a;
            dr5.a.C0226a.a(r6, r5.getIndicatorView());
            r5.setExpand(r6.p);
            if (r7 == false) goto L23;
            int r13 = -1;
        L24:
            com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r14 = r5.q;
            if (r14 == null) goto L29;
            WikiHorizontalScrollView r15 = r14.b;
            if (r15 == null) goto L29;
            r5.setScrollX(-r15.getScrollX());
        L29:
            r5.k(r13);
            r5.setExpandClickListener(new b(this.e, r6));
            r5.setFocus(false);
            r5.setItemClickListener(new c(this.e, r6, r5));
            r5.setOnAddClickListener(new d(this.e, r5));
            r5.getLayoutParams().width = -1;
            return;
        L23:
            r13 = this.e.getWikiUIList().d(r6.n);
            goto L24
        }
    }

    public static final class a implements WikiItemNewDecoration.a {
        public final /* synthetic */ SidebarTreeView a;

        public a(SidebarTreeView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemNewDecoration.a
        public final boolean a(WikItemLeafView r5, int r6) {
        L25:
            e = move-exception;
            tt5.a.d("Wiki_WikiTreeRvView", "canDraw err: " + e);
        L27:
            return false;
        L4:
            if (SidebarTreeView.o(this.a, r6) == false) goto L27;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r7 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.a.getWikiUIList().a, r6);     // Catch: Exception -> L25
            ce5.a r1 = this.a.getUserComponentAbility();     // Catch: Exception -> L25
            if (r1 == null) goto L14;
            BenefitManagerAPI r2 = r1.g;     // Catch: Exception -> L25
            if (r2 == null) goto L14;
            BenefitStore r3 = r2.n1();     // Catch: Exception -> L25
            if (r3 == null) goto L14;
            if (r3.hasBenefit("common_wiki_node_management") == true) goto L14;
            boolean r4 = true;
        L15:
            if (r4 == true) goto L17;
            boolean r8 = true;
        L19:
            if ((r5 instanceof SidebarItemTitleRootView) == false) goto L30;
            if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.b(r7) == false) goto L31;
            if (r8 == false) goto L32;
            return true;
        L32:
            return false;
        L31:
            return false;
        L30:
            return false;
        L17:
            r8 = false;
        L14:
            r4 = false;
            goto L15
        }
    }

    public SidebarTreeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public SidebarTreeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public SidebarTreeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView
    public List<RecyclerView.ItemDecoration> getDefaultItemDecorations() {
        return CollectionsKt.listOf(new RecyclerView.ItemDecoration[]{new WikiItemPressedDecoration(getContext()), new WikiItemNewDecoration(getContext(), new Rect(20, 21, 8, 7), new a(this))});
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView
    public WikiTreeView.WikiAdapter getWikiAdapter() {
        return new SidebarTreeAdapter(this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView
    public final void d() {
        super.d();
        View r0 = findViewById(2131393268);
        if (r0 == null) goto L5;
        int r2 = (int) getContext().getResources().getDimension(2131168174);
        r0.setPadding(r2, 0, r2, 0);
    L5:
        getRecyclerViewFromXml().setPadding(0, 0, 0, 0);
        getRecyclerViewFromXml().setOverScrollMode(2);
        setEnableDiffRender(true);
        InterceptableRecyclerView r1 = getRecyclerViewFromXml();
        if (r1 == null) goto L9;
        r1.addOnItemTouchListener(new WikiTreeItemTouchListener(new SidebarTreeView$initView$2(this), new SidebarTreeView$initView$3(this)));
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView
    public final void c(InterceptableRecyclerView r6) {
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        SidebarItemTitleRootView r0 = new SidebarItemTitleRootView(getContext(), null, 0, 14);
        StickyHeadContainer r1 = getStickyHeadContainerFromXml();
        if (r1 == null) goto L5;
        r1.removeAllViews();
    L5:
        getStickyHeadContainerFromXml().addView(r0, new ViewGroup.LayoutParams(-1, n.d(51)));
        getStickyHeadContainerFromXml().setDataCallback(new h(this, r0));
        StickyItemDecoration r2 = new StickyItemDecoration(getStickyHeadContainerFromXml(), WikNodeType.TITLE_ROOT.getValue());
        r2.h = new i(this);
        r6.addItemDecoration(r2);
    }

    public final boolean p(RecyclerView.ItemDecoration r5) {
        int r0 = getRecyclerViewFromXml().getItemDecorationCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L18;
        if ((getRecyclerViewFromXml().getItemDecorationAt(r2) instanceof WikiItemBackgroundDecoration) == false) goto L9;
        if ((r5 instanceof WikiItemBackgroundDecoration) == false) goto L9;
    L16:
        return false;
    L9:
        if ((getRecyclerViewFromXml().getItemDecorationAt(r2) instanceof WikiBottomDecoration) == false) goto L13;
        if ((r5 instanceof WikiBottomDecoration) == true) goto L16;
    L13:
        if ((getRecyclerViewFromXml().getItemDecorationAt(r2) instanceof WikiItemNewDecoration) == false) goto L17;
        if ((r5 instanceof WikiItemNewDecoration) == true) goto L16;
    L17:
        r2 = r2 + 1;
        goto L3
    L18:
        return true;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView
    public void setItemDecorations(List<? extends RecyclerView.ItemDecoration> r3) {
        if (r3 == null) goto L11;
        Iterator<? extends RecyclerView.ItemDecoration> r4 = r3.iterator();
    L5:
        if (r4.hasNext() == false) goto L11;
        RecyclerView.ItemDecoration r0 = r4.next();
        if (p(r0) == false) goto L5;
        InterceptableRecyclerView r1 = getRecyclerViewFromXml();
        if (r1 == null) goto L5;
        r1.addItemDecoration(r0);
    L11:
        Iterator<T> r5 = getDefaultItemDecorations().iterator();
    L13:
        if (r5.hasNext() == false) goto L19;
        RecyclerView.ItemDecoration r2 = (RecyclerView.ItemDecoration) r5.next();
        if (p(r2) == false) goto L13;
        InterceptableRecyclerView r6 = getRecyclerViewFromXml();
        if (r6 == null) goto L13;
        r6.addItemDecoration(r2);
        goto L13
    }

    public static final boolean o(SidebarTreeView r0, int r1) {
        if (r1 >= 0) goto L4;
        r0.getClass();
    L7:
        return false;
    L4:
        if (r1 >= ((ArrayList) r0.getWikiUIList().a).size()) goto L7;
        return true;
    }

    public SidebarTreeView(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
    }
}
