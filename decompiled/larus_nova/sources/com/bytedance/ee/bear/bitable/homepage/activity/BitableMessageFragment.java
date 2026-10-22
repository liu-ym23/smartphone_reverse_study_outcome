package com.bytedance.ee.bear.bitable.homepage.activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.lark.dependency.n;
import com.bytedance.ee.bear.list.homepage.banner.ActivityEmptyConfig;
import com.bytedance.ee.bear.list.homepage.banner.BitableBannerConfig;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 T2\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0016J\u0012\u0010:\u001a\u00020,2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u000106J\u0006\u0010?\u001a\u00020,J\u0016\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DJ\b\u0010E\u001a\u00020,H\u0016J\b\u0010F\u001a\u00020,H\u0016J&\u0010G\u001a\u0004\u0018\u00010B2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001a\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020B2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010N\u001a\u00020,H\u0002J\u0018\u0010O\u001a\u00020,2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010QH\u0002J\u0010\u0010R\u001a\u00020,2\u0006\u0010S\u001a\u000203H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/BitableMessageFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "containerFromXml", "Landroid/widget/LinearLayout;", "getContainerFromXml", "()Landroid/widget/LinearLayout;", "setContainerFromXml", "(Landroid/widget/LinearLayout;)V", "errStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getErrStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setErrStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "emptyTitleFromXml", "Landroid/widget/TextView;", "getEmptyTitleFromXml", "()Landroid/widget/TextView;", "setEmptyTitleFromXml", "(Landroid/widget/TextView;)V", "emptyDescFromXml", "getEmptyDescFromXml", "setEmptyDescFromXml", "tabEmptyLayoutFromXml", "getTabEmptyLayoutFromXml", "setTabEmptyLayoutFromXml", "recyclerViewFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "errLayoutFromXml", "getErrLayoutFromXml", "setErrLayoutFromXml", "clearFromXmlViewCache", "", "onDestroyView", "adapter", "Lcom/bytedance/ee/bear/bitable/homepage/activity/BitableMessageAdapter;", "viewModel", "Lcom/bytedance/ee/bear/bitable/homepage/activity/BitableMessageViewModel;", "isTab", "", "isFromWorkBench", "baseHpFrom", "", "useNewActivityNoMessage", "activityEmptyConfig", "Lcom/bytedance/ee/bear/list/homepage/banner/ActivityEmptyConfig;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "goToProfile", "userId", "openMessageActivity", RuleConditionBean.OPEN_URL_KEY, BaseSwitches.V, "Landroid/view/View;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/bitable/homepage/activity/HomePageData;", "onPause", "onResume", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "updateView", "list", "", "updateErrState", "isEmpty", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMessageFragment extends BaseFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f212271t = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f212272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f212273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SpaceEmptyState f212274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f212275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f212276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f212277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f212278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f212279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BitableMessageAdapter f212280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BitableMessageViewModel f212281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f212282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f212283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f212284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f212285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ActivityEmptyConfig f212286s;

    public static final class a {
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMessageFragment f212287a;

        public b(BitableMessageFragment r100) {
            this.f212287a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.activity.j
        public final void a(View r110, HomePageData r111) {
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
            BitableMessageFragment r100 = this.f212287a;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
            if (r100.f212282o == false) goto L5;
            r100.Z90();
            return;
        L5:
            boolean r101 = true;
            String r102 = "homepage";
            String r103 = null;
            if (r111.getMessageType() != 1) goto L28;
            Context r112 = r100.getContext();
            CardInfo r104 = r111.getCardInfo();
            if (r104 == null) goto L10;
            String r105 = r104.getChatId();
        L11:
            CardInfo r113 = r111.getCardInfo();
            if (r113 == null) goto L14;
            Integer r114 = r113.getPosition();
        L15:
            if (r112 != null) goto L17;
            return;
        L17:
            if (TextUtils.isEmpty(r105) == true) goto L125;
            if (r114 == null) goto L126;
            n r106 = (n) org.koin.java.a.c(n.class, null, null, 6);
            if (r105 != null) goto L22;
            r105 = "";
        L22:
            r114.intValue();
            r106.n(r112, r105);
            lc5.f.a r115 = lc5.f.f508440a;
            if (r100.f212282o == true) goto L26;
            r102 = "activity_all";
        L26:
            r115.m("", "", r102, "automation");
            return;
        L126:
            return;
        L125:
            return;
        L14:
            r114 = null;
            goto L15
        L10:
            r105 = null;
            goto L11
        L28:
            if (r111.getMessageType() != 2) goto L128;
            NoticeInfo r116 = r111.getNoticeInfo();
            if (r116 == null) goto L37;
            Integer r117 = r116.getNoticeStatus();
            if (r117 == null) goto L37;
            if (r117.intValue() != 11) goto L37;
            boolean r118 = true;
        L38:
            if (r118 == false) goto L42;
            Context r119 = r100.getContext();
            if (r119 == null) goto L129;
            UDToast.show(r119, R.string.LarkCCM_Doc_Feed_Comment_Delete);
            return;
        L129:
            return;
        L42:
            NoticeInfo r120 = r111.getNoticeInfo();
            if (r120 == null) goto L45;
            String r121 = r120.getObjUrl();
        L46:
            NoticeInfo r107 = r111.getNoticeInfo();
            if (r107 == null) goto L51;
            Content r108 = r107.parseContent();
            if (r108 == null) goto L51;
            String r109 = r108.getCommentId();
        L52:
            NoticeInfo r122 = r111.getNoticeInfo();
            if (r122 == null) goto L57;
            Content r123 = r122.parseContent();
            if (r123 == null) goto L57;
            String r124 = r123.getReplyId();
        L58:
            NoticeInfo r125 = r111.getNoticeInfo();
            if (r125 == null) goto L65;
            NoticeExtra r126 = r125.parseExtra();
            if (r126 == null) goto L65;
            TableExtra r127 = r126.getTableExtra();
            if (r127 == null) goto L65;
            String r128 = r127.getTable();
        L66:
            NoticeInfo r129 = r111.getNoticeInfo();
            if (r129 == null) goto L73;
            NoticeExtra r130 = r129.parseExtra();
            if (r130 == null) goto L73;
            TableExtra r131 = r130.getTableExtra();
            if (r131 == null) goto L73;
            String r132 = r131.getView();
        L74:
            NoticeInfo r133 = r111.getNoticeInfo();
            if (r133 == null) goto L82;
            Integer r134 = r133.getNoticeType();
            if (r134 == null) goto L82;
            if (r134.intValue() != 2001) goto L82;
        L84:
            if (TextUtils.isEmpty(r121) == false) goto L86;
        L107:
            lc5.f.a r135 = lc5.f.f508440a;
            NoticeInfo r136 = r111.getNoticeInfo();
            if (r136 == null) goto L110;
            String r137 = r136.getNoticeId();
        L111:
            NoticeInfo r138 = r111.getNoticeInfo();
            if (r138 == null) goto L115;
            r103 = r138.getSourceToken();
        L115:
            if (r100.f212282o == true) goto L118;
            r102 = "activity_all";
        L118:
            if (r101 == false) goto L120;
            String r139 = "mention";
        L121:
            r135.m(r137, r103, r102, r139);
            return;
        L120:
            r139 = "comment";
            goto L121
        L110:
            r137 = null;
            goto L111
        L86:
            if (TextUtils.isEmpty(r109) == true) goto L89;
            r121 = com.bytedance.ee.util.io.e.a(r121, "comment_id", r109);
        L89:
            if (TextUtils.isEmpty(r124) == true) goto L92;
            r121 = com.bytedance.ee.util.io.e.a(r121, NoticeInfo.KEY_REPLY_ID, r124);
        L92:
            if (TextUtils.isEmpty(r128) == true) goto L95;
            r121 = com.bytedance.ee.util.io.e.a(r121, CopyContentTypeString.TABLE, r128);
        L95:
            if (TextUtils.isEmpty(r132) == true) goto L97;
            r121 = com.bytedance.ee.util.io.e.a(r121, "view", r132);
        L97:
            if (r101 == false) goto L103;
            if (r100.f212283p == false) goto L101;
            String r140 = "base_hp_workbench_mention";
        L106:
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(com.bytedance.ee.util.io.e.a(r121, "ccm_open_type", r140));
            goto L107
        L101:
            r140 = "base_hp_larktab_mention";
            goto L106
        L103:
            if (r100.f212283p == false) goto L105;
            r140 = "base_hp_workbench_comment";
            goto L106
        L105:
            r140 = "base_hp_larktab_comment";
        L82:
            r101 = false;
        L73:
            r132 = null;
        L65:
            r128 = null;
        L57:
            r124 = null;
        L51:
            r109 = null;
            goto L52
        L45:
            r121 = null;
        L37:
            r118 = false;
            goto L38
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMessageFragment f212288a;

        public c(BitableMessageFragment r100) {
            this.f212288a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ActivityEmptyConfig r101 = this.f212288a.f212286s;
            if (r101 == null) goto L5;
            String r102 = r101.getButtonUrl();
        L7:
            if (TextUtils.isEmpty(r102) == true) goto L10;
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r102);
            return;
        L10:
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    static {
    }

    public final LinearLayout U90() {
        View r100 = this.f212279l;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.errLayout);
    L8:
        this.f212279l = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final SpaceEmptyState V90() {
        View r100 = this.f212274g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.errState);
    L8:
        this.f212274g = (SpaceEmptyState) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SpaceEmptyState) r100;
    }

    public final RecyclerView W90() {
        View r100 = this.f212278k;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.recyclerView);
    L8:
        this.f212278k = (RecyclerView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (RecyclerView) r100;
    }

    public final LinearLayout X90() {
        View r100 = this.f212277j;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.tab_empty_layout);
    L8:
        this.f212277j = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final BaseTitleBar Y90() {
        View r100 = this.f212272e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.titleBar);
    L8:
        this.f212272e = (BaseTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (BaseTitleBar) r100;
    }

    public final void Z90() {
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).w2("/bitable/home/message/activity").l("is_tab", false).l("is_from_workbench", this.f212283p).i("base_hp_from", this.f212284q).e();
    }

    public BitableMessageFragment() {
        this.f212284q = "";
        this.f212285r = !com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.activity.new.disable");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f212272e = null;
        this.f212273f = null;
        this.f212274g = null;
        this.f212275h = null;
        this.f212276i = null;
        this.f212277j = null;
        this.f212278k = null;
        this.f212279l = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        BitableMessageViewModel r100 = this.f212281n;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L5:
        r100.clearTask();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        BitableMessageViewModel r100 = this.f212281n;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L5:
        r100.startTask();
    }

    public final void aa0(boolean r100) {
        SpaceEmptyState r101 = V90();
        if (this.f212282o == false) goto L5;
        int r102 = 0;
    L8:
        r101.setImageRes(Integer.valueOf(r102));
        ActivityEmptyConfig r103 = this.f212286s;
        String r104 = null;
        if (r103 == null) goto L11;
        String r105 = r103.getTitle();
    L12:
        if (r105 == null) goto L16;
        ActivityEmptyConfig r106 = this.f212286s;
        if (r106 == null) goto L19;
        String r107 = r106.getTitle();
    L20:
        SpaceEmptyState r108 = V90();
        if (this.f212282o == true) goto L23;
        if (r100 == false) goto L23;
    L24:
        r108.setTitle(r107);
        ActivityEmptyConfig r109 = this.f212286s;
        if (r109 == null) goto L27;
        String r110 = r109.getDesc();
    L28:
        if (r110 == null) goto L32;
        ActivityEmptyConfig r111 = this.f212286s;
        if (r111 == null) goto L35;
        String r112 = r111.getDesc();
    L36:
        if (r100 == true) goto L42;
        Context r113 = getContext();
        if (r113 == null) goto L41;
        r112 = r113.getString(R.string.Bitable_Workspace_UnableToLoadData_Description);
        goto L42
    L41:
        r112 = null;
    L42:
        V90().setDesc(r112);
        SpaceEmptyState r114 = V90();
        if (this.f212282o == true) goto L49;
        if (r100 == false) goto L49;
        ActivityEmptyConfig r115 = this.f212286s;
        if (r115 == null) goto L49;
        r104 = r115.getButton();
    L49:
        r114.setPrimaryText(r104);
        V90().setPrimaryClickListener(new c(this));
        return;
    L35:
        r112 = null;
        goto L36
    L32:
        Context r116 = getContext();
        if (r116 == null) goto L35;
        r112 = r116.getString(R.string.Bitable_Workspace_Mobile_NoRecentActivity_Desc);
        goto L36
    L27:
        r110 = null;
    L23:
        r107 = null;
    L19:
        r107 = null;
        goto L20
    L16:
        Context r117 = getContext();
        if (r117 == null) goto L19;
        r107 = r117.getString(R.string.Bitable_Workspace_Mobile_NoRecentActivity_Title);
        goto L20
    L11:
        r105 = null;
        goto L12
    L5:
        if (r100 == false) goto L7;
        r102 = R.drawable.ccm_empty_positive_activity_action_1;
        goto L8
    L7:
        r102 = R.drawable.ccm_empty_negative_load_failed;
        goto L8
    }

    public final void ba0(List<HomePageData> r100) {
        if (r100 != null) goto L5;
        W90().setVisibility(8);
        U90().setVisibility(0);
        X90().setVisibility(8);
        aa0(false);
        tt5.a.h("BitableMessageFragment", "data is null");
        return;
    L5:
        if (r100.isEmpty() == true) goto L7;
    L13:
        BitableMessageAdapter r101 = null;
        if (this.f212282o == true) goto L16;
    L22:
        BitableMessageAdapter r102 = this.f212280m;
        if (r102 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L26:
        r101.setNewData(r100);
    L27:
        W90().setVisibility(0);
        U90().setVisibility(8);
        X90().setVisibility(8);
        return;
    L25:
        r101 = r102;
        goto L26
    L16:
        if (r100.size() <= 1) goto L22;
        BitableMessageAdapter r103 = this.f212280m;
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L21:
        r101.setNewData(r100.subList(0, 2));
        goto L27
    L20:
        r101 = r103;
        goto L21
    L7:
        if (this.f212285r == false) goto L13;
        W90().setVisibility(8);
        if (this.f212282o == false) goto L11;
        X90().setVisibility(0);
        U90().setVisibility(8);
    L12:
        aa0(true);
        return;
    L11:
        X90().setVisibility(8);
        U90().setVisibility(0);
        goto L12
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = r101.getBoolean("is_tab");
    L6:
        this.f212282o = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        r102 = r104.getBoolean("is_from_workbench");
    L9:
        this.f212283p = r102;
        Bundle r105 = getArguments();
        if (r105 == null) goto L13;
        String r106 = r105.getString("base_hp_from");
        if (r106 == null) goto L13;
    L14:
        this.f212284q = r106;
        this.f212281n = (BitableMessageViewModel) ViewModelProviders.of(requireActivity()).get(BitableMessageViewModel.class);
        this.f212280m = new BitableMessageAdapter(this.f212282o, new AnonymousClass1(this), new b(this));
        return;
    L13:
        r106 = "";
        goto L14
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        BaseTitleBar r102 = Y90();
        int r103 = 0;
        if (this.f212282o == false) goto L5;
        int r104 = 8;
    L6:
        r102.setVisibility(r104);
        Y90().setLeftClickListener(new e(this));
        View r105 = this.f212273f;
        BitableMessageViewModel r106 = null;
        if (r105 != null) goto L13;
        View r107 = getView();
        if (r107 == null) goto L11;
        r105 = r107.findViewById(R.id.container);
    L12:
        this.f212273f = (LinearLayout) r105;
        goto L13
    L11:
        r105 = null;
    L13:
        ViewGroup.LayoutParams r108 = ((LinearLayout) r105).getLayoutParams();
        if (this.f212282o == false) goto L16;
        int r109 = -2;
    L17:
        r108.height = r109;
        View r110 = this.f212273f;
        if (r110 != null) goto L24;
        View r111 = getView();
        if (r111 == null) goto L22;
        r110 = r111.findViewById(R.id.container);
    L23:
        this.f212273f = (LinearLayout) r110;
        goto L24
    L22:
        r110 = null;
    L24:
        ((LinearLayout) r110).setLayoutParams(r108);
        SpaceEmptyState r112 = V90();
        if (this.f212282o == false) goto L27;
        int r113 = 0;
    L28:
        r112.setImageRes(Integer.valueOf(r113));
        V90().setOnClickListener(new f(this));
        boolean r114 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.tab.activity.tips.enable");
        ImageView r115 = new ImageView(getContext());
        r115.setImageResource(R.drawable.ud_icon_info_outlined);
        Context r116 = getContext();
        if (r116 == null) goto L31;
        ColorStateList r117 = AppCompatResources.getColorStateList(r116, R.color.icon_n3);
    L32:
        r115.setImageTintList(r117);
        if (r114 == true) goto L36;
        r103 = 8;
    L36:
        r115.setVisibility(r103);
        RelativeLayout.LayoutParams r118 = new RelativeLayout.LayoutParams(com.bytedance.ee.util.ui.n.d(20), com.bytedance.ee.util.ui.n.d(20));
        r118.leftMargin = com.bytedance.ee.util.ui.n.d(6);
        BaseTitleBar r119 = Y90();
        if (r119 == null) goto L39;
        r118.addRule(1, r119.f240033h.getId());
        r118.addRule(15);
        r119.f240032g.addView(r115, r118);
    L39:
        r115.setOnClickListener(new g(this));
        if (this.f212285r == false) goto L82;
        BitableBannerConfig r120 = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        if (r120 == null) goto L44;
        ActivityEmptyConfig r121 = r120.getActivityEmptyConfig();
    L45:
        this.f212286s = r121;
        if (r121 == null) goto L48;
        String r122 = r121.getTitle();
    L50:
        if (TextUtils.isEmpty(r122) == true) goto L63;
        View r123 = this.f212275h;
        if (r123 != null) goto L58;
        View r124 = getView();
        if (r124 == null) goto L56;
        r123 = r124.findViewById(R.id.empty_title);
    L57:
        this.f212275h = (TextView) r123;
        goto L58
    L56:
        r123 = null;
    L58:
        TextView r125 = (TextView) r123;
        ActivityEmptyConfig r126 = this.f212286s;
        if (r126 == null) goto L61;
        String r127 = r126.getTitle();
    L62:
        r125.setText(r127);
        goto L63
    L61:
        r127 = null;
    L63:
        ActivityEmptyConfig r128 = this.f212286s;
        if (r128 == null) goto L66;
        String r129 = r128.getDesc();
    L68:
        if (TextUtils.isEmpty(r129) == true) goto L81;
        View r130 = this.f212276i;
        if (r130 != null) goto L76;
        View r131 = getView();
        if (r131 == null) goto L74;
        r130 = r131.findViewById(R.id.empty_desc);
    L75:
        this.f212276i = (TextView) r130;
        goto L76
    L74:
        r130 = null;
    L76:
        TextView r132 = (TextView) r130;
        ActivityEmptyConfig r133 = this.f212286s;
        if (r133 == null) goto L79;
        String r134 = r133.getDesc();
    L80:
        r132.setText(r134);
        goto L81
    L79:
        r134 = null;
    L81:
        X90().setOnClickListener(new h(this));
        goto L82
    L66:
        r129 = null;
        goto L68
    L48:
        r122 = null;
        goto L50
    L44:
        r121 = null;
    L82:
        RecyclerView r135 = W90();
        BitableMessageAdapter r136 = this.f212280m;
        if (r136 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r136 = null;
    L85:
        r135.setAdapter(r136);
        W90().setLayoutManager(new LinearLayoutManagerWrapper(requireContext()));
        List<HomePageData> r137 = ay4.b.d(DocumentType.BITABLE_NAME, 4).getJSONArray("homepage_message", HomePageData.class);
        if (r137 == null) goto L88;
        ba0(r137);
    L88:
        BitableMessageViewModel r138 = this.f212281n;
        if (r138 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r138 = null;
    L91:
        r138.fetchHomePageData();
        BitableMessageViewModel r139 = this.f212281n;
        if (r139 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L95:
        r106.getHomePageListData().observe(getViewLifecycleOwner(), new i(this));
        lc5.f.a r140 = lc5.f.f508440a;
        if (this.f212282o == false) goto L98;
        String r141 = "homepage";
    L100:
        if (this.f212283p == false) goto L102;
        String r142 = "workbench";
    L103:
        r140.A("ccm_base_homepage_activity_view", r141, r142, this.f212284q);
        return;
    L102:
        r142 = "larktab_bitable";
        goto L103
    L98:
        r141 = "activity_all";
        goto L100
    L94:
        r106 = r139;
        goto L95
    L31:
        r117 = null;
        goto L32
    L27:
        r113 = R.drawable.ccm_empty_negative_load_failed;
        goto L28
    L16:
        r109 = -1;
        goto L17
    L5:
        r104 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_homepage_message_layout, r101, false);
    }
}
