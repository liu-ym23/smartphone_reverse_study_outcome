package com.bytedance.ee.bear.wikiv2.home2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.homepage.title.HomeSubTitleView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.listitem.ListStyleItemDecoration;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0003EFGB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u000e\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u0004\u0018\u00010\u0015J\u000e\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u0015J\b\u00107\u001a\u00020-H\u0002J\u0006\u00108\u001a\u00020%J\u000e\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020-2\u0006\u0010'\u001a\u00020(J\u001a\u0010=\u001a\u00020-2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#J\u000e\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020%J\u0010\u0010@\u001a\u00020-2\b\u0010*\u001a\u0004\u0018\u00010+J\u000e\u0010A\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010B\u001a\u00020-H\u0007J\u000e\u0010C\u001a\u00020-2\u0006\u0010 \u001a\u00020DR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00060\u001dR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "listRecyclerViewFromXml", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "getListRecyclerViewFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "setListRecyclerViewFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;)V", "listStateViewRootFromXml", "Lcom/bytedance/ee/bear/list/loadstateview/LoadStateView;", "getListStateViewRootFromXml", "()Lcom/bytedance/ee/bear/list/loadstateview/LoadStateView;", "setListStateViewRootFromXml", "(Lcom/bytedance/ee/bear/list/loadstateview/LoadStateView;)V", "dataList", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceUIList;", "subTitleView", "Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;", "loadStateView", "Lcom/bytedance/ee/bear/list/loadstateview/LoadStateViewWrapper;", "driveUploadView", "Lcom/bytedance/ee/bear/list/common/header/DriveUploadView;", "wikiRecentSpaceAdapter", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView$WikiRecentSpaceAdapter;", "docsLayoutManager", "Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/DocsLinearLayoutManager;", "itemDecoration", "Lcom/bytedance/ee/bear/list/listitem/ListStyleItemDecoration;", "enableChecker", "Lio/reactivex/functions/Function;", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "", "enableMenuClick", "delegate", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView$ViewDelegate;", "wikiCustomSpaceIconEnable", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "initView", "", "showLoadStart", "showLoadSuccess", "showLoadFail", "throwable", "", "isGridStyle", "getData", "setData", WikiFolderPushPlugin.DATA, "notifyFilterUpdate", "isFilterVisible", "scrollToPosition", "pos", "", "setDelegate", "setItemEnableChecker", "setMenuEnable", "enable", "setUserComponentAbility", "setSubTitleView", "notifyDataSetChanged", "addItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "WikiRecentSpaceAdapter", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiHomeRecentSpaceView extends FrameLayout {
    public BaseRecyclerView a;
    public LoadStateView b;
    public com.bytedance.ee.bear.wikiv2.home2.model.l c;
    public HomeSubTitleView d;
    public com.bytedance.ee.bear.list.loadstateview.h e;
    public final c f;
    public final DocsLinearLayoutManager g;
    public final ListStyleItemDecoration h;
    public Function<SpaceBean, Boolean> i;
    public boolean j;
    public b k;
    public final boolean l;
    public ce5.a m;

    public static final class a {
    }

    public interface b {
        void L2();

        void M2();

        void N2(String r1, boolean r2);

        void O2();

        void a(String r1);
    }

    public final class c extends BaseQuickAdapter<SpaceBean, BaseViewHolder> {
        public final com.bytedance.ee.bear.wikiv2.icon.a a;
        public final /* synthetic */ WikiHomeRecentSpaceView b;

        public final int y2() {
            List r0 = ((BaseQuickAdapter) this).mData;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public c(WikiHomeRecentSpaceView r1) {
            this.b = r1;
            super(2131568243);
            this.a = new com.bytedance.ee.bear.wikiv2.icon.a();
        }

        public final void convert(BaseViewHolder r14, Object r15) {
            SpaceBean r16 = (SpaceBean) r15;
            Intrinsics.checkNotNullParameter(r14, "holder");
            Intrinsics.checkNotNullParameter(r16, "item");
            AppCompatImageView r0 = r14.getView(2131375773);
            SpaceTagTitleView r1 = (SpaceTagTitleView) r14.getView(2131375808);
            TextView r2 = (TextView) r14.getView(2131391910);
            AppCompatImageView r3 = r14.getView(2131387824);
            ConstraintLayout r4 = r14.getView(2131375720);
            SwipeMenuLayout r17 = r14.getView(2131378129);
            r17.setLayoutManager(this.b.g);
            boolean r5 = up5.i.a(r16.tenant_id);
            if (this.b.l == false) goto L5;
            int r6 = com.bytedance.ee.util.ui.n.d(40);
            com.bytedance.ee.bear.wikiv2.icon.a r8 = this.a;
            String r9 = r16.space_id;
            String r10 = r16.space_name;
            String r11 = r16.space_icon_info;
            Intrinsics.checkNotNull(r0);
            com.bytedance.ee.bear.wikiv2.icon.b r12 = new com.bytedance.ee.bear.wikiv2.icon.b(r0, 2131256279, r6, r6);
            ce5.a r7 = this.b.m;
            r8.getClass();
            com.bytedance.ee.bear.wikiv2.icon.a.a(r9, r10, r11, r12, r7);
        L6:
            r1.setTitle(r16.space_name);
            ArrayList r13 = new ArrayList();
            DisplayTag r18 = r16.display_tag;
            boolean r19 = false;
            boolean r20 = true;
            if (r18 != null) goto L9;
            int r21 = SpaceTagType.e;
            if (r5 == true) goto L22;
        L24:
            boolean r22 = false;
        L25:
            r13.add(SpaceTagType.Companion.d(r22));
            if (r5 == true) goto L28;
        L32:
            r13.add(SpaceTagType.Companion.b(r19));
        L33:
            r1.setLabels(r13);
            Intrinsics.checkNotNull(r2);
            int r23 = com.bytedance.ee.util.ui.n.d(16);
            r2.setPadding(r2.getPaddingLeft(), r2.getPaddingTop(), r23, r2.getPaddingBottom());
            if (TextUtils.isEmpty(r16.description) == true) goto L36;
            String r24 = r16.description;
        L37:
            r2.setText(r24);
            if (r16.is_star == false) goto L40;
            int r25 = 2131256070;
        L41:
            r3.setImageResource(r25);
            r3.setOnClickListener(new q(r17, r16, this.b));
            boolean r110 = this.b.j;
            r3.setEnabled(r110);
            float r26 = 1.0f;
            if (r110 == false) goto L44;
            float r111 = 1.0f;
        L45:
            r3.setAlpha(r111);
            Function<SpaceBean, Boolean> r112 = this.b.i;
            if (r112 == null) goto L50;
            Boolean r113 = (Boolean) r112.apply(r16);
            if (r113 == null) goto L50;
            r20 = r113.booleanValue();
        L50:
            r4.setEnabled(r20);
            if (r20 == true) goto L54;
            r26 = 0.3f;
        L54:
            r4.setAlpha(r26);
            r4.setOnClickListener(new r(r16, this.b));
            return;
        L44:
            r111 = 0.3f;
            goto L45
        L40:
            r25 = 2131254096;
            goto L41
        L36:
            r24 = ((BaseQuickAdapter) this).mContext.getString(2131888324);
            goto L37
        L28:
            if (r16.isOpenSharing() == true) goto L32;
            if (r16.isPublicScope() == false) goto L32;
            r19 = true;
            goto L32
        L22:
            if (r16.isOpenSharing() == false) goto L24;
            r22 = true;
            goto L25
        L9:
            if (r18.isValidInSameTenant() != true) goto L11;
            r19 = true;
        L11:
            if (r19 == true) goto L14;
            r5 = true;
        L14:
            int r27 = SpaceTagType.e;
            DisplayTag r28 = r16.display_tag;
            if (r28 == null) goto L17;
            String r29 = r28.getTag_value();
        L18:
            r13.add(SpaceTagType.Companion.e(r29, r5));
            goto L33
        L17:
            r29 = null;
            goto L18
        L5:
            r0.setImageResource(2131256279);
            goto L6
        }
    }

    public static final class d implements wc5.f.a {
        public final /* synthetic */ WikiHomeRecentSpaceView a;

        @Override // wc5.f.a
        public final void Qi() {
        }

        @Override // wc5.f.a
        public final void WU(boolean r1) {
        }

        @Override // wc5.f.a
        public final void eF() {
            b r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.O2();
            return;
        }

        public d(WikiHomeRecentSpaceView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void a() {
        com.bytedance.ee.bear.wikiv2.home2.model.l r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        HomeSubTitleView r1 = this.d;
        if (r1 == null) goto L30;
        boolean r3 = false;
        if (r0.e.isEmptyFilterOption() == true) goto L11;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L19;
        r1.setFilterVisible(false);
        return;
    L19:
        r1.setFilterVisible(true);
        if (r0.e.isEmptyFilterOption() == false) goto L22;
    L24:
        r1.setOffline(!r3);
        if ((!r0.e.isEmptyFilter()) == false) goto L27;
        SubMenuView.FilterState r4 = SubMenuView.FilterState.CHECKED;
    L28:
        r1.setFilterState(r4);
        return;
    L27:
        r4 = SubMenuView.FilterState.DEFAULT;
        goto L28
    L22:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L24;
        r3 = true;
        goto L24
    L11:
        if (r0.e.isEmptyFilter() == false) goto L16;
        if (r0.e.isLastFilterOptionEmpty() == false) goto L16;
        r2 = false;
        goto L17
    }

    public final BaseRecyclerView getListRecyclerViewFromXml() {
        CommonRecyclerView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131378168);
        this.a = (BaseRecyclerView) r0;
    L6:
        return (BaseRecyclerView) r0;
    }

    public final LoadStateView getListStateViewRootFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131378179);
        this.b = (LoadStateView) r0;
    L6:
        return (LoadStateView) r0;
    }

    public final com.bytedance.ee.bear.wikiv2.home2.model.l getData() {
        return this.c;
    }

    public final void setData(com.bytedance.ee.bear.wikiv2.home2.model.l r6) {
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.DATA);
        com.bytedance.ee.bear.wikiv2.home2.model.l r0 = this.c;
        this.c = r6;
        ListStyleItemDecoration r1 = this.h;
        boolean r2 = r6.b;
        r1.getClass();
        tt5.a.h("ListStyleItemDecoration", "setHasMore()...hasMore = " + r2);
        r1.a = r2;
        this.f.setNewDiffData(new WikiSpaceDiffCallback(r6.a));
        com.bytedance.ee.bear.list.loadstateview.h r3 = this.e;
        if (r3 != null) goto L5;
    L9:
        com.bytedance.ee.bear.list.loadstateview.h r4 = this.e;
        if (r4 == null) goto L12;
        r4.c(this.f.y2());
    L12:
        a();
        if (r0 == null) goto L20;
        Intrinsics.checkNotNullParameter(r0, "uiList");
        if (r6.e.isSameFilterWith(r0.e) == false) goto L17;
        return;
    L17:
        if (this.f.y2() <= 0) goto L22;
        getListRecyclerViewFromXml().scrollToPosition(0);
        return;
    L22:
        return;
    L20:
        return;
    L5:
        if ((!r6.e.isEmptyFilter()) == true) goto L7;
        EmptyCategory r5 = EmptyCategory.WIKI_SPACE;
    L8:
        r3.f(r5);
        goto L9
    L7:
        r5 = EmptyCategory.WIKI_SPACE_MGMT;
        goto L8
    }

    public final void setDelegate(b r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.k = r2;
    }

    public final void setItemEnableChecker(Function<SpaceBean, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "enableChecker");
        this.i = r2;
    }

    public final void setListRecyclerViewFromXml(BaseRecyclerView r1) {
        this.a = r1;
    }

    public final void setListStateViewRootFromXml(LoadStateView r1) {
        this.b = r1;
    }

    public final void setMenuEnable(boolean r1) {
        this.j = r1;
    }

    public final void setSubTitleView(HomeSubTitleView r5) {
        Intrinsics.checkNotNullParameter(r5, "subTitleView");
        r5.setTitle(getResources().getString(2131889641));
        r5.setTextSize(16.0f);
        r5.setTextStyle(1);
        r5.setTextColor(2131106622);
        ImageView r0 = r5.e;
        ImageView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r1).setMarginEnd(0);
        ImageView r3 = r5.f;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r3 = null;
    L8:
        r3.setVisibility(8);
        ImageView r4 = r5.e;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
    L12:
        r2.setVisibility(8);
        r5.setFilterState(SubMenuView.FilterState.DEFAULT);
        r5.setViewDelegate(new d(this));
        this.d = r5;
        return;
    L11:
        r2 = r4;
        goto L12
    }

    public final void setUserComponentAbility(ce5.a r1) {
        this.m = r1;
    }

    public WikiHomeRecentSpaceView(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        c r7 = new c(this);
        this.f = r7;
        DocsLinearLayoutManager r0 = new DocsLinearLayoutManager(r5);
        this.g = r0;
        ListStyleItemDecoration r1 = new ListStyleItemDecoration();
        this.h = r1;
        this.j = true;
        LayoutInflater.from(r5).inflate(2131568242, this);
        BaseRecyclerView r8 = getListRecyclerViewFromXml();
        String r2 = "bear_space_list_wiki_home_".concat(SegmentStyle.FONT_STYLE_NORMAL);
        if ((r8 instanceof CommonRecyclerView) == false) goto L5;
        r8.setSceneTag(r2);
    L5:
        getListRecyclerViewFromXml().setItemAnimator(null);
        getListRecyclerViewFromXml().setLayoutManager(r0);
        getListRecyclerViewFromXml().addItemDecoration(r1);
        getListRecyclerViewFromXml().setAdapter(r7);
        getListRecyclerViewFromXml().getViewTreeObserver().addOnPreDrawListener(new s(this));
        com.bytedance.ee.bear.list.loadstateview.h r9 = new com.bytedance.ee.bear.list.loadstateview.h(getListStateViewRootFromXml());
        r9.a(EmptyCategory.WIKI_SPACE);
        r9.e(new t(this));
        this.e = r9;
        pc5.i r10 = new pc5.i(getContext());
        r10.setViewDelegate(new u(r10, this));
        r10.a("all_files_token", "workspace", "none");
        this.l = qc5.a.l();
    }
}
