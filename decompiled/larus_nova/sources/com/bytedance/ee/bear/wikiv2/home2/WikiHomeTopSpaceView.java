package com.bytedance.ee.bear.wikiv2.home2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.list.homepage.banner.BannerMoreView;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceCover;
import com.bytedance.ee.bear.wikiv2.home.banner.WikiHomePageSpaceSnapHelper;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0003-./B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020#2\u0006\u0010 \u001a\u00020!J\u001a\u0010(\u001a\u00020#2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dJ\b\u0010)\u001a\u00020#H\u0007J\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "listBannerTvTitleFromXml", "Landroid/widget/TextView;", "getListBannerTvTitleFromXml", "()Landroid/widget/TextView;", "setListBannerTvTitleFromXml", "(Landroid/widget/TextView;)V", "listBannerMoreFromXml", "Lcom/bytedance/ee/bear/list/homepage/banner/BannerMoreView;", "getListBannerMoreFromXml", "()Lcom/bytedance/ee/bear/list/homepage/banner/BannerMoreView;", "setListBannerMoreFromXml", "(Lcom/bytedance/ee/bear/list/homepage/banner/BannerMoreView;)V", "listBannerRvListFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getListBannerRvListFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setListBannerRvListFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "wikiTopSpaceAdapter", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView$WikiTopSpaceAdapter;", "enableChecker", "Lio/reactivex/functions/Function;", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "", "delegate", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView$ViewDelegate;", "initView", "", "setData", "data", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceUIList;", "setDelegate", "setItemEnableChecker", "notifyDataSetChanged", "smoothScrollToPosition", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "WikiTopSpaceAdapter", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiHomeTopSpaceView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f240825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BannerMoreView f240826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f240827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f240828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function<SpaceBean, Boolean> f240829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f240830f;

    public static final class a {
    }

    public interface b {
        void a(String r100);
    }

    public final class c extends BaseQuickAdapter<SpaceBean, BaseViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiHomeTopSpaceView f240831a;

        public final int y2() {
            List<T> r100 = this.mData;
            if (r100 != 0) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public c(WikiHomeTopSpaceView r100) {
            this.f240831a = r100;
            super(R.layout.wiki_home_banner_item);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public final void convert(BaseViewHolder r110, SpaceBean r111) {
            SpaceBean r112 = r111;
            Intrinsics.checkNotNullParameter(r110, "viewHolder");
            Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
            ViewGroup.LayoutParams r100 = r110.itemView.findViewById(R.id.wiki_banner_card_view).getLayoutParams();
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100;
            int r102 = 0;
            boolean r103 = true;
            if (r110.getAdapterPosition() != 0) goto L5;
            int[] r104 = {com.bytedance.ee.util.ui.n.d(14), com.bytedance.ee.util.ui.n.d(14), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(16)};
        L6:
            r101.setMargins(r104[0], r104[1], r104[2], r104[3]);
            ((CardView) r110.itemView.findViewById(R.id.wiki_banner_card_view)).setCardElevation(com.bytedance.ee.util.ui.n.d(10));
            ((TextView) r110.itemView.findViewById(R.id.tv_banner_title)).setText(r112.space_name);
            ((ImageView) r110.itemView.findViewById(R.id.iv_banner_star)).setVisibility(8);
            SpaceCover r105 = r112.space_cover;
            TextView r106 = (TextView) r110.itemView.findViewById(R.id.tv_banner_title);
            if (r105 == null) goto L13;
            Resources r107 = r110.itemView.getResources();
            if (r105.is_graph_dark == false) goto L11;
            int r108 = r107.getColor(R.color.static_white);
        L12:
            r106.setTextColor(r108);
            goto L13
        L11:
            r108 = r107.getColor(R.color.static_black);
        L13:
            SpaceCover r109 = r112.space_cover;
            ImageView r113 = (ImageView) r110.itemView.findViewById(R.id.wiki_banner_background_image);
            String r114 = null;
            if (r109 == null) goto L41;
            boolean r115 = r109.is_graph_dark;
            String r116 = r109.color_value;
            if (r115 == false) goto L18;
            int r117 = r110.itemView.getResources().getColor(R.color.lkui_N950);
        L20:
            if (TextUtils.isEmpty(r116) == true) goto L37;
            if (r116 != null) goto L89;
        L29:
            boolean r118 = true;
        L30:
            if (r118 == false) goto L32;
        L34:
            r117 = Color.parseColor(r116);     // Catch: Exception -> L27
        L27:
            e = move-exception;
            tt5.a.e("WikiHomeTopSpaceView", "parseColor err", e, false);
            goto L37
        L32:
            if (StringsKt.startsWith$default(r116, "#", false, 2, null) == true) goto L34;
            r116 = "#" + r116;     // Catch: Exception -> L27
            goto L34
        L89:
            if (r116.length() == 0) goto L29;
            r118 = false;
        L37:
            GradientDrawable r119 = new GradientDrawable();
            r119.setColor(r117);
            if (TextUtils.isEmpty(r109.origin) == false) goto L40;
            tt5.a.h("WikiHomeTopSpaceView", "bindImage spaceCover.thumbnail is empty");
            r113.setImageDrawable(r119);
            goto L41
        L40:
            Intrinsics.checkNotNull(Glide.with(r110.itemView.getContext()).load(new BearGlideUrl(r109.origin)).placeholder(r119).error(r119).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new v()).into(r113));
            goto L41
        L18:
            r117 = r110.itemView.getResources().getColor(R.color.static_white);
        L41:
            Function<SpaceBean, Boolean> r120 = this.f240831a.f240829e;
            if (r120 == null) goto L46;
            Boolean r121 = r120.apply(r112);
            if (r121 == null) goto L46;
            boolean r122 = r121.booleanValue();
        L47:
            r110.itemView.setEnabled(r122);
            View r123 = r110.itemView;
            if (r122 == false) goto L50;
            float r124 = 1.0f;
        L51:
            r123.setAlpha(r124);
            View r125 = r110.getView(R.id.scope_content);
            TextView r126 = (TextView) r110.getView(R.id.tv_scope);
            boolean r127 = r112.isOpenSharing();
            boolean r128 = r112.isPublicScope();
            boolean r129 = up5.i.a(r112.tenant_id);
            DisplayTag r130 = r112.display_tag;
            if (r130 != null) goto L54;
            if (r129 == false) goto L71;
            if (r127 == true) goto L72;
            if (r128 == false) goto L71;
        L72:
            if (r103 == true) goto L75;
            r102 = 8;
        L75:
            r125.setVisibility(r102);
            if (r103 == false) goto L87;
            DisplayTag r131 = r112.display_tag;
            if (r131 == null) goto L84;
            String r132 = r131.getTag_value();
            if (r132 != null) goto L83;
            r132 = "";
        L83:
            r126.setText(r132);
            goto L87
        L84:
            if (r127 == false) goto L86;
            r126.setText(R.string.LarkCCM_Wiki_WebAccess_Tag);
            goto L87
        L86:
            r126.setText(R.string.LarkCCM_Wiki_OrgAccess_Tag);
        L87:
            r110.itemView.setOnClickListener(new w(r112, this.f240831a));
            return;
        L71:
            r103 = false;
            goto L72
        L54:
            if (r130.isValidInSameTenant() != true) goto L56;
            boolean r133 = true;
        L57:
            if (r133 == true) goto L60;
            r129 = true;
        L60:
            if (r129 == false) goto L71;
            DisplayTag r134 = r112.display_tag;
            if (r134 == null) goto L65;
            r114 = r134.getTag_value();
        L65:
            if (TextUtils.isEmpty(r114) == true) goto L71;
        L56:
            r133 = false;
            goto L57
        L50:
            r124 = 0.3f;
        L46:
            r122 = true;
            goto L47
        L5:
            r104 = new int[]{0, com.bytedance.ee.util.ui.n.d(14), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(16)};
            goto L6
        }
    }

    static {
    }

    public final BannerMoreView getListBannerMoreFromXml() {
        KeyEvent.Callback r100 = this.f240826b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.list_banner_more);
        this.f240826b = (BannerMoreView) r100;
    L6:
        return (BannerMoreView) r100;
    }

    public final RecyclerView getListBannerRvListFromXml() {
        KeyEvent.Callback r100 = this.f240827c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.list_banner_rv_list);
        this.f240827c = (RecyclerView) r100;
    L6:
        return (RecyclerView) r100;
    }

    public final TextView getListBannerTvTitleFromXml() {
        KeyEvent.Callback r100 = this.f240825a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.list_banner_tv_title);
        this.f240825a = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final void setData(com.bytedance.ee.bear.wikiv2.home2.model.l r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f240828d.setNewDiffData(new WikiSpaceDiffCallback(r100.f240936a));
    }

    public final void setDelegate(b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f240830f = r100;
    }

    public final void setItemEnableChecker(Function<SpaceBean, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "enableChecker");
        this.f240829e = r100;
    }

    public final void setListBannerMoreFromXml(BannerMoreView r100) {
        this.f240826b = r100;
    }

    public final void setListBannerRvListFromXml(RecyclerView r100) {
        this.f240827c = r100;
    }

    public final void setListBannerTvTitleFromXml(TextView r100) {
        this.f240825a = r100;
    }

    public WikiHomeTopSpaceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        c r102 = new c(this);
        this.f240828d = r102;
        LayoutInflater.from(r100).inflate(R.layout.wiki_home_banner, this);
        getListBannerTvTitleFromXml().setText(getResources().getString(R.string.LarkCCM_NewCM_Sidebar_Mobile_PinWorkspaceToTop_Title));
        getListBannerMoreFromXml().setVisibility(8);
        int r103 = 0;
        getListBannerRvListFromXml().setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getListBannerRvListFromXml().setItemAnimator(null);
        getListBannerRvListFromXml().setAdapter(r102);
        aq5.a r104 = new aq5.a();
        WikiHomePageSpaceSnapHelper r105 = new WikiHomePageSpaceSnapHelper();
        r105.f240718b = (int) r104.f15901e;
        r105.f240719c = 1;
        r105.attachToRecyclerView(getListBannerRvListFromXml());
        ArrayList r106 = new ArrayList();
    L4:
        if (r103 >= 4) goto L6;
        r106.add(new SpaceBean());
        r103 = r103 + 1;
        goto L4
    L6:
        this.f240828d.setNewData(r106);
        this.f240828d.setEmptyView(R.layout.wiki_home_banner_empty, this);
    }
}
