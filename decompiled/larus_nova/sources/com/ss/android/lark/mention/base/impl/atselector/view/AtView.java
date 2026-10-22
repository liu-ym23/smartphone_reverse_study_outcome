package com.ss.android.lark.mention.base.impl.atselector.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import butterknife.BindView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.stickyheader.AnimationFixStickyRecyclerHeadersDecoration;
import com.larksuite.framework.utils.ExternalKeyboardUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.AtHeaderSelectedAdapter;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.AtSelectAdapter;
import com.ss.android.lark.mention.base.impl.atselector.view.tracker.VisibilityScrollListener;
import com.ss.android.lark.mention.base.impl.statistics.MentionBoardHitPoint;
import com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionHelperKt;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.quick_sidebar.QuickSideBarTipsView;
import com.ss.android.lark.widget.quick_sidebar.QuickSideBarView;
import com.ss.ttm.player.MediaPlayer;
import com.suite.lark.emm.design.edittext.SCEditText;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes36.dex */
public class AtView implements com.ss.android.lark.mention.base.impl.atselector.e, m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Long f431809o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f431810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f431811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f431812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtSelectAdapter f431813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtSelectAdapter f431814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtHeaderSelectedAdapter f431815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Integer> f431816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f431817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.android.lark.mention.base.impl.atselector.e.a f431818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public frb.a f431819j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f431820k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f431821l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n f431822m;

    @BindView(9726)
    View mLoadEmptyView;

    @BindView(9560)
    LKUIPtrClassicFrameLayout mPtrFrame;

    @BindView(9992)
    View mQuickSideBarCover;

    @BindView(9990)
    QuickSideBarTipsView mQuickSideBarTipView;

    @BindView(9991)
    QuickSideBarView mQuickSideBarView;

    @BindView(9253)
    RecyclerView mRecommendRecyclerView;

    @BindView(10006)
    LinearLayout mRecyclerViewLayout;

    @BindView(10087)
    LinearLayout mSearchBar;

    @BindView(10253)
    TextView mSearchEmptyHintTV;

    @BindView(10097)
    SCEditText mSearchEt;

    @BindView(10110)
    RecyclerView mSearchResultRV;

    @BindView(9086)
    LinearLayout mSelectAtLayout;

    @BindView(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_LOUDNESS_STRATEGY_3_LIMITER_MAKEUP_GAIN)
    RecyclerView mSelectedRV;

    @BindView(10290)
    CommonTitleBar mTitleBar;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f431823n;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtView f431824a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(AtView r100) {
            this.f431824a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            AtView r101 = this.f431824a;
            n r102 = r101.f431822m;
            if (r102 == null) goto L5;
            String r103 = r100.toString();
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "text");
            BuildersKt.launch$default(r102.f431852a, null, null, new TextChangeDebounceHelper$onTextChanged$1(r102, r103, null), 3, null);
            return;
        L5:
            r101.k(r100.toString());
        }
    }

    public class b implements IItemContainer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtView f431825a;

        public b(AtView r100) {
            this.f431825a = r100;
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
        public final void a(BaseAtBean r100) {
            this.f431825a.f431818i.u4(r100);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
        public final void b(BaseAtBean r100) {
            this.f431825a.f431818i.l8(r100);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
        public final void c(BaseAtBean r100) {
            this.f431825a.f431818i.l1(r100);
        }
    }

    public class c implements AtHeaderSelectedAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtView f431826a;

        public c(AtView r100) {
            this.f431826a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtView f431827a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f431827a.mRecyclerViewLayout.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(AtView r100) {
            this.f431827a = r100;
        }
    }

    public interface e {
        void a(AtView r100);

        void b(com.ss.android.lark.mention.base.impl.atselector.bean.d r100);

        void showToast(String r100);

        void y();
    }

    static {
        f431809o = 300L;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f431812c.a(this);
        String r100 = com.ss.android.lark.mention.base.impl.statistics.a.f431859a;
        AppreciableKit.Companion r101 = AppreciableKit.Companion;
        r101.getInstance().spanStart(com.ss.android.lark.mention.base.impl.statistics.a.f431859a, "init_view_cost");
        this.mTitleBar.setTitle(R.string.Lark_Legacy_TitleSelectMember);
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        this.mTitleBar.addAction(new g(this, UIUtils.getString(this.f431811b, R.string.Lark_Legacy_Select)));
        this.mTitleBar.setLeftClickListener(new h(this));
        TextView r102 = this.mTitleBar.getRightText();
        this.f431810a = r102;
        r102.setPadding(0, 0, UIUtils.dp2px(this.f431811b, 15.0f), 0);
        LinearLayoutManager r103 = new LinearLayoutManager(this.f431811b, 1, false);
        this.mRecommendRecyclerView.setLayoutManager(r103);
        ((SimpleItemAnimator) this.mRecommendRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.mRecommendRecyclerView.getItemAnimator().setRemoveDuration(0);
        this.mRecommendRecyclerView.getItemAnimator().setAddDuration(0);
        this.mRecyclerViewLayout.setVisibility(8);
        AtSelectAdapter r104 = new AtSelectAdapter();
        this.f431813d = r104;
        r104.f431835b = 0;
        r104.notifyItemRangeChanged(0, r104.getItemCount());
        AtSelectAdapter r105 = this.f431813d;
        r105.f431836c = this.f431820k;
        this.mRecommendRecyclerView.setAdapter(r105);
        AnimationFixStickyRecyclerHeadersDecoration r106 = new AnimationFixStickyRecyclerHeadersDecoration(this.f431813d);
        this.mRecommendRecyclerView.addItemDecoration(r106);
        LinearLayoutManager r107 = new LinearLayoutManager(this.f431811b, 1, false);
        this.mSearchResultRV.setLayoutManager(r107);
        this.f431814e = new AtSelectAdapter();
        ((SimpleItemAnimator) this.mSearchResultRV.getItemAnimator()).setSupportsChangeAnimations(false);
        this.mSearchResultRV.setAdapter(this.f431814e);
        AtSelectAdapter r108 = this.f431814e;
        r108.f431836c = this.f431820k;
        AtHeaderSelectedAdapter r109 = new AtHeaderSelectedAdapter();
        this.f431815f = r109;
        r109.f431832b = this.f431821l;
        this.mSelectedRV.setLayoutManager(new LinearLayoutManager(this.f431811b, 0, false));
        this.mSelectedRV.setAdapter(this.f431815f);
        com.ss.android.lark.mention.base.impl.atselector.e.a r110 = this.f431818i;
        if (r110 != null) goto L5;
    L15:
        ChatWindowPtrLoadingHeader r111 = new ChatWindowPtrLoadingHeader(this.f431811b);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r111);
        this.mPtrFrame.addPtrUIHandler(r111);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mPtrFrame.setPtrHandler(new i(this));
        this.mQuickSideBarView.setVisibility(8);
        this.mQuickSideBarCover.setVisibility(0);
        r101.getInstance().spanEnd(com.ss.android.lark.mention.base.impl.statistics.a.f431859a, "init_view_cost");
        this.mQuickSideBarView.setOnQuickSideBarTouchListener(new j(this));
        this.mRecommendRecyclerView.addOnScrollListener(new k(this));
        this.mSearchBar.setOnClickListener(new l(this));
        this.mSearchEt.setOnFocusChangeListener(new com.ss.android.lark.mention.base.impl.atselector.view.a(this));
        this.mSearchEt.addTextChangedListener(this.f431823n);
        int r112 = com.ss.android.lark.mention.base.a.f431661a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.picker.search_by_pinyin") == false) goto L18;
        this.mSearchEt.setImeOptions(3);
    L18:
        this.mSearchResultRV.addOnScrollListener(new f(this));
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.mention.disable_search_debounce") == true) goto L22;
        Log.i("AtView", "initDebounceHelper");
        long r113 = f431809o.longValue();
        int r114 = n.f431851f;
        Intrinsics.checkNotNullParameter(this, "onDebouncedTextChange");
        CoroutineScope r115 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        n r116 = new n(r115, r113, this);
        r116.f431856e = BuildersKt.launch$default(r115, null, null, new TextChangeDebounceHelper$startDebounceCollection$1(r116, null), 3, null);
        this.f431822m = r116;
        return;
    L22:
        return;
    L5:
        if (r110.V0() == false) goto L15;
        String r117 = "";
        if (this.f431818i.n6() != null) goto L9;
        String r118 = "";
    L10:
        frb.a r119 = new frb.a(r118, false);
        this.f431819j = r119;
        this.mRecommendRecyclerView.addOnScrollListener(new VisibilityScrollListener(r119));
        if (this.f431818i.n6() == null) goto L14;
        r117 = this.f431818i.n6();
    L14:
        int r120 = com.ss.android.lark.mention.base.a.f431661a;
        frb.a r121 = new frb.a(r117, FeatureGatingModule.getFeatureGatingService().isEnable("lark.myai.new_qa_im_at_ai_fix_mention_searchpanel"));
        this.mSearchResultRV.addOnScrollListener(new VisibilityScrollListener(r121));
        goto L15
    L9:
        r118 = this.f431818i.n6();
        goto L10
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        SCEditText r100 = this.mSearchEt;
        if (r100 == null) goto L5;
        r100.removeTextChangedListener(this.f431823n);
    L5:
        n r101 = this.f431822m;
        if (r101 == null) goto L12;
        Job r102 = r101.f431856e;
        if (r102 == null) goto L10;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L10:
        SendChannel.a.a(r101.f431855d);
        CoroutineScopeKt.cancel$default(r101.f431852a, null, 1, null);
    L12:
        if (this.f431819j == null) goto L15;
        ((LinkedHashMap) frb.a.f478644e).clear();
        ((LinkedHashMap) frb.a.f478645f).clear();
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void o7() {
        this.mPtrFrame.refreshComplete();
        String r100 = UIHelper.getString(R.string.Lark_Legacy_NetError);
        this.f431812c.showToast(r100);
    }

    public final void s() {
        if (this.mSearchResultRV.getVisibility() != 0) goto L7;
        if (this.mRecommendRecyclerView.getVisibility() == 0) goto L7;
    L8:
        KeyboardSelectionHelperKt.enableKeyboardNavigation(this.mSearchResultRV, this.f431814e, this.mSearchEt);
        return;
    L7:
        if (TextUtils.isEmpty(this.mSearchEt.getText().toString().trim()) == false) goto L8;
        KeyboardSelectionHelperKt.enableKeyboardNavigation(this.mRecommendRecyclerView, this.f431813d, this.mSearchEt);
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final int y0() {
        return this.f431817h;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void G8(List<BaseAtBean> r100) {
        AtSelectAdapter r101 = this.f431813d;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.resetSelectPosition();
        this.f431813d.diff(r100);
        this.f431813d.f431837d = true;
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void S3(List<BaseAtBean> r100) {
        AtSelectAdapter r101 = this.f431814e;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.resetSelectPosition();
        this.f431814e.resetAll(r100);
        this.f431814e.f431837d = true;
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void T5(Map<String, BaseAtBean> r100) {
        int r101 = (this.f431817h + 1) % 2;
        this.f431817h = r101;
        AtSelectAdapter r102 = this.f431813d;
        if (r102 == null) goto L5;
        r102.f431835b = r101;
        r102.notifyItemRangeChanged(0, r102.getItemCount());
        o(r100);
    L5:
        AtSelectAdapter r103 = this.f431814e;
        if (r103 == null) goto L9;
        r103.f431835b = this.f431817h;
        r103.notifyItemRangeChanged(0, r103.getItemCount());
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.view.m
    public final void h(String r100) {
        k(r100);
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void j1(com.ss.android.lark.mention.base.impl.atselector.bean.d r100) {
        KeyboardUtils.hideKeyboard(this.f431811b);
        this.f431812c.b(r100);
    }

    public final void k(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        Log.i("AtView", "handleTextChange clearSearchResult");
        this.f431814e.clear();
        this.f431814e.f431837d = true;
        this.mSearchResultRV.setVisibility(4);
        this.mPtrFrame.setVisibility(4);
        this.mQuickSideBarView.setVisibility(0);
        this.mQuickSideBarCover.setVisibility(8);
        this.mLoadEmptyView.setVisibility(8);
        this.mQuickSideBarTipView.setVisibility(8);
        this.mRecommendRecyclerView.setVisibility(0);
        s();
        return;
    L5:
        Log.i("AtView", "handleTextChange: " + r100.length());
        this.f431818i.onSearch(r100);
    }

    public final void o(Map<String, BaseAtBean> r100) {
        if (this.f431817h == 1) goto L5;
        this.f431810a.setText(R.string.Lark_Legacy_Select);
        if (this.f431813d == null) goto L17;
        this.f431818i.b6();
        return;
    L17:
        return;
    L5:
        if (r100.isEmpty() == false) goto L7;
        this.f431810a.setText(R.string.Lark_Legacy_SelectSingle);
        this.f431810a.setTextColor(UDColorUtils.getColor(this.f431811b, R.color.text_title));
    L9:
        if (this.f431813d == null) goto L15;
        this.f431818i.f6();
        return;
    L15:
        return;
    L7:
        this.f431810a.setText(UIHelper.mustacheFormat(R.string.Lark_Legacy_PickerConfirmWithCount, "count", Integer.toString(r100.size())));
        this.f431810a.setTextColor(UDColorUtils.getColor(this.f431811b, R.color.primary_fill_default));
        goto L9
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void o3(String r100) {
        this.mPtrFrame.refreshComplete();
        if (r100.equals(this.mSearchEt.getText().toString().trim()) == true) goto L5;
        return;
    L5:
        this.f431814e.clear();
        this.f431814e.f431837d = true;
        this.mSearchResultRV.setVisibility(4);
        this.mPtrFrame.setVisibility(4);
        this.mRecommendRecyclerView.setVisibility(4);
        this.mLoadEmptyView.setVisibility(0);
        s();
        String r101 = UIHelper.mustacheFormat(R.string.Lark_Legacy_Noresult, Keys.API_PARAM_KEY_SEARCH_KEY, r100);
        int r102 = r101.indexOf("'");
        int r103 = r101.lastIndexOf("'");
        TextView r104 = this.mSearchEmptyHintTV;
        r104.setText(y0.b(r101, r102, r103, r100, y9c.d.c(r104.getContext(), R.color.function_info_fill_default)));
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void p1(List<BaseAtBean> r100) {
        this.f431816g.clear();
        p(false, r100);
        this.f431813d.resetSelectPosition();
        this.f431813d.resetAll(r100);
        this.f431813d.f431837d = true;
        int r101 = com.ss.android.lark.mention.base.a.f431661a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.mention.show_recommend_when_select") == false) goto L5;
        this.mRecommendRecyclerView.setVisibility(0);
    L5:
        s();
        this.mRecommendRecyclerView.post(new com.ss.android.lark.mention.base.impl.atselector.view.b());
        fsb.f.b().f(this.mRecommendRecyclerView);
        MentionBoardHitPoint.b(true, r100);
        com.ss.android.lark.mention.base.impl.atselector.e.a r102 = this.f431818i;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.V0() == false) goto L15;
        frb.a r103 = this.f431819j;
        if (r103 == null) goto L16;
        r103.f478650d = false;
        ((LinkedHashMap) frb.a.f478644e).clear();
        ((LinkedHashMap) frb.a.f478645f).clear();
        this.mRecommendRecyclerView.post(new com.ss.android.lark.mention.base.impl.atselector.view.d(this));
        return;
    L16:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void s4(int r100) {
        AtSelectAdapter r101 = this.f431814e;
        if (r101 == null) goto L6;
        r101.notifyItemRangeChanged(0, r100, "sensitiveInfo");
        return;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f431818i = (com.ss.android.lark.mention.base.impl.atselector.e.a) r100;
    }

    public AtView(Context r100, e r101) {
        this.f431816g = new HashMap();
        this.f431817h = 0;
        this.f431820k = new b(this);
        this.f431821l = new c(this);
        this.f431823n = new a(this);
        this.f431811b = r100;
        this.f431812c = r101;
        if (aoc.b.a() == false) goto L6;
        Boolean r102 = ExternalKeyboardUtils.f285887a;
        ExternalKeyboardUtils.c(new com.ss.android.lark.mention.base.impl.atselector.view.c());
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void D4(Map<String, BaseAtBean> r100, boolean r101) {
        o(r100);
        if (r100.isEmpty() == false) goto L5;
        this.f431815f.diff(r100.values());
        this.mRecyclerViewLayout.post(new d(this));
        return;
    L5:
        this.mRecyclerViewLayout.setVisibility(0);
        this.f431815f.diff(r100.values());
        if (r101 == false) goto L10;
        this.mSelectedRV.getLayoutManager().scrollToPosition(this.f431815f.getItemCount() - 1);
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void E8(String r100, List<BaseAtBean> r101) {
        this.mPtrFrame.refreshComplete();
        if (r100.equals(this.mSearchEt.getText().toString().trim()) == true) goto L5;
        return;
    L5:
        p(true, r101);
        this.mSearchResultRV.scrollToPosition(0);
        this.mPtrFrame.setVisibility(0);
        this.mLoadEmptyView.setVisibility(8);
        this.mSearchResultRV.setVisibility(0);
        this.mQuickSideBarTipView.setVisibility(8);
        this.mQuickSideBarView.setVisibility(8);
        this.mRecommendRecyclerView.setVisibility(8);
        this.f431814e.resetSelectPosition();
        this.f431814e.resetAll(r101);
        this.f431814e.f431837d = true;
        s();
        MentionBoardHitPoint.b(false, r101);
    }

    public final void p(boolean r100, List<BaseAtBean> r101) {
        if (r100 == true) goto L16;
        ArrayList r102 = new ArrayList();
        Iterator<BaseAtBean> r103 = r101.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L15;
        BaseAtBean r105 = r103.next();
        if (r105 == null) goto L14;
        if (r105.getType() != 0) goto L14;
        String r106 = String.valueOf(r105.getPinyin());
        if (this.f431816g.containsKey(r106.toUpperCase()) == true) goto L14;
        this.f431816g.put(r106.toUpperCase(), Integer.valueOf(r104));
        r102.add(r106.toUpperCase());
    L14:
        r104 = r104 + 1;
        goto L6
    L15:
        this.mQuickSideBarView.setLetters(r102);
        this.mQuickSideBarView.setVisibility(0);
        this.mQuickSideBarCover.setVisibility(8);
        return;
    L16:
        this.mQuickSideBarView.setVisibility(8);
        this.mQuickSideBarCover.setVisibility(0);
    }
}
