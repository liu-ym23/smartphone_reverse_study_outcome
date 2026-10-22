package com.bytedance.ee.bear.wikiv2.home2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.homepage.title.HomeSubTitleView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.listitem.ListStyleItemDecoration;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0003EFGB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u000e\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u0004\u0018\u00010\u0015J\u000e\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u0015J\b\u00107\u001a\u00020-H\u0002J\u0006\u00108\u001a\u00020%J\u000e\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020-2\u0006\u0010'\u001a\u00020(J\u001a\u0010=\u001a\u00020-2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#J\u000e\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020%J\u0010\u0010@\u001a\u00020-2\b\u0010*\u001a\u0004\u0018\u00010+J\u000e\u0010A\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010B\u001a\u00020-H\u0007J\u000e\u0010C\u001a\u00020-2\u0006\u0010 \u001a\u00020DR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00060\u001dR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "listRecyclerViewFromXml", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "getListRecyclerViewFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "setListRecyclerViewFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;)V", "listStateViewRootFromXml", "Lcom/bytedance/ee/bear/list/loadstateview/LoadStateView;", "getListStateViewRootFromXml", "()Lcom/bytedance/ee/bear/list/loadstateview/LoadStateView;", "setListStateViewRootFromXml", "(Lcom/bytedance/ee/bear/list/loadstateview/LoadStateView;)V", "dataList", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceUIList;", "subTitleView", "Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;", "loadStateView", "Lcom/bytedance/ee/bear/list/loadstateview/LoadStateViewWrapper;", "driveUploadView", "Lcom/bytedance/ee/bear/list/common/header/DriveUploadView;", "wikiRecentSpaceAdapter", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView$WikiRecentSpaceAdapter;", "docsLayoutManager", "Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/DocsLinearLayoutManager;", "itemDecoration", "Lcom/bytedance/ee/bear/list/listitem/ListStyleItemDecoration;", "enableChecker", "Lio/reactivex/functions/Function;", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "", "enableMenuClick", "delegate", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeRecentSpaceView$ViewDelegate;", "wikiCustomSpaceIconEnable", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "initView", "", "showLoadStart", "showLoadSuccess", "showLoadFail", LynxError.LYNX_THROWABLE, "", "isGridStyle", "getData", "setData", "data", "notifyFilterUpdate", "isFilterVisible", "scrollToPosition", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "setDelegate", "setItemEnableChecker", "setMenuEnable", "enable", "setUserComponentAbility", "setSubTitleView", "notifyDataSetChanged", "addItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "WikiRecentSpaceAdapter", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiHomeRecentSpaceView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseRecyclerView f240809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoadStateView f240810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.wikiv2.home2.model.l f240811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HomeSubTitleView f240812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ee.bear.list.loadstateview.h f240813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f240814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DocsLinearLayoutManager f240815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ListStyleItemDecoration f240816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function<SpaceBean, Boolean> f240817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f240818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f240819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f240820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ce5.a f240821m;

    public static final class a {
    }

    public interface b {
        void L2();

        void M2();

        void N2(String r100, boolean r101);

        void O2();

        void a(String r100);
    }

    public final class c extends BaseQuickAdapter<SpaceBean, BaseViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.wikiv2.icon.a f240822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRecentSpaceView f240823b;

        public final int y2() {
            List<T> r100 = this.mData;
            if (r100 != 0) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public c(WikiHomeRecentSpaceView r100) {
            this.f240823b = r100;
            super(R.layout.wiki_home_recent_space_item);
            this.f240822a = new com.bytedance.ee.bear.wikiv2.icon.a();
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public final void convert(BaseViewHolder r110, SpaceBean r111) {
            SpaceBean r112 = r111;
            Intrinsics.checkNotNullParameter(r110, "holder");
            Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
            AppCompatImageView r100 = (AppCompatImageView) r110.getView(R.id.item_icon);
            SpaceTagTitleView r101 = (SpaceTagTitleView) r110.getView(R.id.item_name);
            TextView r102 = (TextView) r110.getView(R.id.update_time);
            AppCompatImageView r103 = (AppCompatImageView) r110.getView(R.id.swipe_menu_star);
            ConstraintLayout r104 = (ConstraintLayout) r110.getView(R.id.item_content);
            SwipeMenuLayout r113 = (SwipeMenuLayout) r110.getView(R.id.list_item);
            r113.setLayoutManager(this.f240823b.f240815g);
            boolean r105 = up5.i.a(r112.tenant_id);
            if (this.f240823b.f240820l == false) goto L5;
            int r106 = com.bytedance.ee.util.ui.n.d(40);
            com.bytedance.ee.bear.wikiv2.icon.a r107 = this.f240822a;
            String r108 = r112.space_id;
            String r114 = r112.space_name;
            String r115 = r112.space_icon_info;
            Intrinsics.checkNotNull(r100);
            com.bytedance.ee.bear.wikiv2.icon.b r116 = new com.bytedance.ee.bear.wikiv2.icon.b(r100, R.drawable.ud_icon_wikibook_circle_colorful, r106, r106);
            ce5.a r109 = this.f240823b.f240821m;
            r107.getClass();
            com.bytedance.ee.bear.wikiv2.icon.a.a(r108, r114, r115, r116, r109);
        L6:
            r101.setTitle(r112.space_name);
            ArrayList r117 = new ArrayList();
            DisplayTag r118 = r112.display_tag;
            boolean r119 = false;
            boolean r120 = true;
            if (r118 != null) goto L9;
            int r121 = SpaceTagType.f240339e;
            if (r105 == true) goto L22;
        L24:
            boolean r122 = false;
        L25:
            r117.add(SpaceTagType.Companion.d(r122));
            if (r105 == true) goto L28;
        L32:
            r117.add(SpaceTagType.Companion.b(r119));
        L33:
            r101.setLabels(r117);
            Intrinsics.checkNotNull(r102);
            int r123 = com.bytedance.ee.util.ui.n.d(16);
            r102.setPadding(r102.getPaddingLeft(), r102.getPaddingTop(), r123, r102.getPaddingBottom());
            if (TextUtils.isEmpty(r112.description) == true) goto L36;
            String r124 = r112.description;
        L37:
            r102.setText(r124);
            if (r112.is_star == false) goto L40;
            int r125 = R.drawable.ud_icon_unpin_outlined;
        L41:
            r103.setImageResource(r125);
            r103.setOnClickListener(new q(r113, r112, this.f240823b));
            boolean r126 = this.f240823b.f240818j;
            r103.setEnabled(r126);
            float r127 = 1.0f;
            if (r126 == false) goto L44;
            float r128 = 1.0f;
        L45:
            r103.setAlpha(r128);
            Function<SpaceBean, Boolean> r129 = this.f240823b.f240817i;
            if (r129 == null) goto L50;
            Boolean r130 = r129.apply(r112);
            if (r130 == null) goto L50;
            r120 = r130.booleanValue();
        L50:
            r104.setEnabled(r120);
            if (r120 == true) goto L54;
            r127 = 0.3f;
        L54:
            r104.setAlpha(r127);
            r104.setOnClickListener(new r(r112, this.f240823b));
            return;
        L44:
            r128 = 0.3f;
            goto L45
        L40:
            r125 = R.drawable.ud_icon_chat_pin_outlined;
            goto L41
        L36:
            r124 = this.mContext.getString(R.string.Doc_Wiki_Home_DescriptionEmptyText);
            goto L37
        L28:
            if (r112.isOpenSharing() == true) goto L32;
            if (r112.isPublicScope() == false) goto L32;
            r119 = true;
            goto L32
        L22:
            if (r112.isOpenSharing() == false) goto L24;
            r122 = true;
            goto L25
        L9:
            if (r118.isValidInSameTenant() != true) goto L11;
            r119 = true;
        L11:
            if (r119 == true) goto L14;
            r105 = true;
        L14:
            int r131 = SpaceTagType.f240339e;
            DisplayTag r132 = r112.display_tag;
            if (r132 == null) goto L17;
            String r133 = r132.getTag_value();
        L18:
            r117.add(SpaceTagType.Companion.e(r133, r105));
            goto L33
        L17:
            r133 = null;
            goto L18
        L5:
            r100.setImageResource(R.drawable.ud_icon_wikibook_circle_colorful);
            goto L6
        }
    }

    public static final class d implements wc5.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRecentSpaceView f240824a;

        @Override // wc5.f.a
        public final void Qi() {
        }

        @Override // wc5.f.a
        public final void WU(boolean r100) {
        }

        @Override // wc5.f.a
        public final void eF() {
            b r100 = this.f240824a.f240819k;
            if (r100 == null) goto L6;
            r100.O2();
            return;
        }

        public d(WikiHomeRecentSpaceView r100) {
            this.f240824a = r100;
        }
    }

    static {
    }

    public final void a() {
        com.bytedance.ee.bear.wikiv2.home2.model.l r100 = this.f240811c;
        if (r100 != null) goto L5;
        return;
    L5:
        HomeSubTitleView r101 = this.f240812d;
        if (r101 == null) goto L30;
        boolean r102 = false;
        if (r100.f240940e.isEmptyFilterOption() == true) goto L11;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == true) goto L19;
        r101.setFilterVisible(false);
        return;
    L19:
        r101.setFilterVisible(true);
        if (r100.f240940e.isEmptyFilterOption() == false) goto L22;
    L24:
        r101.setOffline(!r102);
        if ((!r100.f240940e.isEmptyFilter()) == false) goto L27;
        SubMenuView.FilterState r104 = SubMenuView.FilterState.CHECKED;
    L28:
        r101.setFilterState(r104);
        return;
    L27:
        r104 = SubMenuView.FilterState.DEFAULT;
        goto L28
    L22:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == false) goto L24;
        r102 = true;
        goto L24
    L11:
        if (r100.f240940e.isEmptyFilter() == false) goto L16;
        if (r100.f240940e.isLastFilterOptionEmpty() == false) goto L16;
        r103 = false;
        goto L17
    }

    public final BaseRecyclerView getListRecyclerViewFromXml() {
        KeyEvent.Callback r100 = this.f240809a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.list_recycler_view);
        this.f240809a = (BaseRecyclerView) r100;
    L6:
        return (BaseRecyclerView) r100;
    }

    public final LoadStateView getListStateViewRootFromXml() {
        KeyEvent.Callback r100 = this.f240810b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.list_state_view_root);
        this.f240810b = (LoadStateView) r100;
    L6:
        return (LoadStateView) r100;
    }

    public final com.bytedance.ee.bear.wikiv2.home2.model.l getData() {
        return this.f240811c;
    }

    public final void setData(com.bytedance.ee.bear.wikiv2.home2.model.l r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        com.bytedance.ee.bear.wikiv2.home2.model.l r101 = this.f240811c;
        this.f240811c = r100;
        ListStyleItemDecoration r102 = this.f240816h;
        boolean r103 = r100.f240937b;
        r102.getClass();
        tt5.a.h("ListStyleItemDecoration", "setHasMore()...hasMore = " + r103);
        r102.f228617a = r103;
        this.f240814f.setNewDiffData(new WikiSpaceDiffCallback(r100.f240936a));
        com.bytedance.ee.bear.list.loadstateview.h r104 = this.f240813e;
        if (r104 != null) goto L5;
    L9:
        com.bytedance.ee.bear.list.loadstateview.h r105 = this.f240813e;
        if (r105 == null) goto L12;
        r105.c(this.f240814f.y2());
    L12:
        a();
        if (r101 == null) goto L20;
        Intrinsics.checkNotNullParameter(r101, "uiList");
        if (r100.f240940e.isSameFilterWith(r101.f240940e) == false) goto L17;
        return;
    L17:
        if (this.f240814f.y2() <= 0) goto L22;
        getListRecyclerViewFromXml().scrollToPosition(0);
        return;
    L22:
        return;
    L20:
        return;
    L5:
        if ((!r100.f240940e.isEmptyFilter()) == true) goto L7;
        EmptyCategory r106 = EmptyCategory.WIKI_SPACE;
    L8:
        r104.f(r106);
        goto L9
    L7:
        r106 = EmptyCategory.WIKI_SPACE_MGMT;
        goto L8
    }

    public final void setDelegate(b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f240819k = r100;
    }

    public final void setItemEnableChecker(Function<SpaceBean, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "enableChecker");
        this.f240817i = r100;
    }

    public final void setListRecyclerViewFromXml(BaseRecyclerView r100) {
        this.f240809a = r100;
    }

    public final void setListStateViewRootFromXml(LoadStateView r100) {
        this.f240810b = r100;
    }

    public final void setMenuEnable(boolean r100) {
        this.f240818j = r100;
    }

    public final void setSubTitleView(HomeSubTitleView r100) {
        Intrinsics.checkNotNullParameter(r100, "subTitleView");
        r100.setTitle(getResources().getString(R.string.LarkCCM_NewCM_Sidebar_Mobile_AllWorkspaces_Title));
        r100.setTextSize(16.0f);
        r100.setTextStyle(1);
        r100.setTextColor(R.color.text_title);
        AppCompatImageView r101 = r100.f228370e;
        AppCompatImageView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r103).setMarginEnd(0);
        AppCompatImageView r104 = r100.f228371f;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r104 = null;
    L8:
        r104.setVisibility(8);
        AppCompatImageView r105 = r100.f228370e;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
    L12:
        r102.setVisibility(8);
        r100.setFilterState(SubMenuView.FilterState.DEFAULT);
        r100.setViewDelegate(new d(this));
        this.f240812d = r100;
        return;
    L11:
        r102 = r105;
        goto L12
    }

    public final void setUserComponentAbility(ce5.a r100) {
        this.f240821m = r100;
    }

    public WikiHomeRecentSpaceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        c r102 = new c(this);
        this.f240814f = r102;
        DocsLinearLayoutManager r103 = new DocsLinearLayoutManager(r100);
        this.f240815g = r103;
        ListStyleItemDecoration r104 = new ListStyleItemDecoration();
        this.f240816h = r104;
        this.f240818j = true;
        LayoutInflater.from(r100).inflate(R.layout.wiki_home_recent_list, this);
        BaseRecyclerView r105 = getListRecyclerViewFromXml();
        String r106 = "bear_space_list_wiki_home_".concat("normal");
        if ((r105 instanceof CommonRecyclerView) == false) goto L5;
        r105.setSceneTag(r106);
    L5:
        getListRecyclerViewFromXml().setItemAnimator(null);
        getListRecyclerViewFromXml().setLayoutManager(r103);
        getListRecyclerViewFromXml().addItemDecoration(r104);
        getListRecyclerViewFromXml().setAdapter(r102);
        getListRecyclerViewFromXml().getViewTreeObserver().addOnPreDrawListener(new s(this));
        com.bytedance.ee.bear.list.loadstateview.h r107 = new com.bytedance.ee.bear.list.loadstateview.h(getListStateViewRootFromXml());
        r107.a(EmptyCategory.WIKI_SPACE);
        r107.e(new t(this));
        this.f240813e = r107;
        pc5.i r108 = new pc5.i(getContext());
        r108.setViewDelegate(new u(r108, this));
        r108.a("all_files_token", "workspace", "none");
        this.f240820l = qc5.a.l();
    }
}
