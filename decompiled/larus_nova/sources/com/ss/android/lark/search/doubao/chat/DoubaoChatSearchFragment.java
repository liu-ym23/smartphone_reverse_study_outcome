package com.ss.android.lark.search.doubao.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.search.baseview.SearchInputView;
import com.ss.android.lark.search.doubao.chat.empty.DoubaoSearchEmptyView;
import com.ss.android.lark.search.doubao.chat.holder.msg.MessageClickHandler;
import com.ss.android.lark.search.doubao.util.DoubaoSearchPtrFooter;
import com.ss.android.lark.search.dto.info.SearchColdAndHotInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.search.ui.result.BinderConfig;
import com.ss.android.lark.search.ui.result.SearchResultAdapter;
import com.ss.android.lark.search.ui.result.SearchResultView;
import com.ss.android.lark.utils.UIHelper;
import com.ttnet.org.chromium.base.BaseSwitches;
import j4c.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/search/doubao/chat/DoubaoChatSearchFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "searchResultView", "Lcom/ss/android/lark/search/ui/result/SearchResultView;", "searchHistoryAdapter", "Lcom/ss/android/lark/search/doubao/chat/DoubaoSugAdapter;", "searchHistoryView", "Landroidx/recyclerview/widget/RecyclerView;", "searchInputView", "Lcom/ss/android/lark/search/baseview/SearchInputView;", "cancelTv", "Landroid/widget/TextView;", "viewModel", "Lcom/ss/android/lark/search/doubao/chat/DoubaoChatSearchViewModel;", "chatID", "", "messageClickHandler", "Lcom/ss/android/lark/search/doubao/chat/holder/msg/MessageClickHandler;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupHisotry", "setupResultView", "setupObserve", "getTitleAndSubTitleNums", "", LiveCommonConstants.REASON_ON_DEDTROY, "search-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoChatSearchFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SearchResultView f440022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DoubaoSugAdapter f440023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f440024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SearchInputView f440025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DoubaoChatSearchViewModel f440026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f440027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MessageClickHandler f440028j;

    public static final class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f440029a = null;

        static {
            f440029a = new a();
        }

        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r101, "insets");
            Insets r102 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            int r103 = r102.left;
            int r104 = r102.top;
            int r105 = r102.right;
            int r106 = r102.bottom;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            r100.setPadding(r103, r104, r105, r106);
            return r101;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubaoChatSearchFragment f440030a;

        public b(DoubaoChatSearchFragment r100) {
            this.f440030a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SearchInputView r101 = this.f440030a.f440025g;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
            r101 = null;
        L5:
            r101.clearFocus();
            FragmentActivity r102 = this.f440030a.getActivity();
            if (r102 == null) goto L11;
            OnBackPressedDispatcher r103 = r102.getOnBackPressedDispatcher();
            if (r103 == null) goto L12;
            r103.onBackPressed();
            return;
        L12:
            return;
        }
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        SearchInputView r100 = this.f440025g;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
        r100 = null;
    L6:
        r100.clearFocus();
    L7:
        super.onDestroy();
    }

    public DoubaoChatSearchFragment() {
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        String r102 = "";
        if (r101 == null) goto L8;
        String r103 = r101.getString("chat_id", "");
        if (r103 == null) goto L8;
        r102 = r103;
    L8:
        this.f440027i = r102;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ViewCompat.setOnApplyWindowInsetsListener(r100, a.f440029a);
        ViewCompat.requestApplyInsets(r100);
        String r102 = this.f440027i;
        SearchInputView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chatID");
        r102 = null;
    L5:
        DoubaoChatSearchViewModel r104 = (DoubaoChatSearchViewModel) new ViewModelProvider(this, new DoubaoChatSearchViewModelFactory(r102)).get(DoubaoChatSearchViewModel.class);
        this.f440026h = r104;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r104 = null;
    L8:
        r104.updateSubTitleNumbs(a0.b(new TextView(getContext()), DeviceUtils.getScreenWidth(getContext()) - UIHelper.dp2px(152.0f)));
        SearchResultView r105 = (SearchResultView) r100.findViewById(R.id.result_list);
        this.f440022d = r105;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
        r105 = null;
    L11:
        v r106 = new v(requireContext());
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "factory");
        BinderConfig r107 = r105.f440278w;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binderConfig");
        r107 = null;
    L14:
        Intrinsics.checkNotNullParameter(r107, "binderConfig");
        r106.f440100b = r107;
        SearchResultAdapter r108 = r105.f440270o;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r108 = null;
    L17:
        Intrinsics.checkNotNullParameter(r108, "adapter");
        if ((r108 instanceof SearchResultAdapter) == false) goto L21;
        BinderConfig r109 = r106.f440100b;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f440255c = r109;
        r108.z2(SearchMessageInfo.class, new com.ss.android.lark.search.doubao.chat.holder.msg.a(r106.f440100b));
        r108.z2(SearchColdAndHotInfo.class, new s3c.c(r106.f440100b));
    L21:
        RecyclerView r110 = (RecyclerView) r100.findViewById(R.id.doubao_sug_list);
        this.f440024f = r110;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("searchHistoryView");
        r110 = null;
    L24:
        r110.setLayoutManager(new LinearLayoutManager(requireContext()));
        SearchInputView r111 = (SearchInputView) r100.findViewById(R.id.picker_search_input);
        this.f440025g = r111;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
        r111 = null;
    L27:
        r111.setSearchIconRes(R.drawable.doubao_chat_search_icon);
        SearchInputView r112 = this.f440025g;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
        r112 = null;
    L30:
        r112.setSearchEditTextCornerRadius(UIHelper.dp2px(16.0f));
        TextView r113 = (TextView) r100.findViewById(R.id.picker_cancel_tv);
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("cancelTv");
        r113 = null;
    L33:
        r113.setOnClickListener(new b(this));
        this.f440028j = new MessageClickHandler(requireContext());
        this.f440023e = new DoubaoSugAdapter(DoubaoChatSearchFragment$setupHisotry$1.INSTANCE, new DoubaoChatSearchFragment$setupHisotry$2(this));
        RecyclerView r114 = this.f440024f;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("searchHistoryView");
        r114 = null;
    L36:
        DoubaoSugAdapter r115 = this.f440023e;
        if (r115 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("searchHistoryAdapter");
        r115 = null;
    L39:
        r114.setAdapter(r115);
        SearchResultView r116 = this.f440022d;
        if (r116 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
        r116 = null;
    L42:
        r116.setLoadingText(UIHelper.getString(R.string.LarkIM_Commen_Loading_Text));
        r116.setLoadingFooter(new DoubaoSearchPtrFooter(r116.getContext(), null, 6, 0));
        int r117 = UIHelper.dp2px(17.0f);
        View r118 = r116.f440259d;
        if (r118 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r118 = null;
    L45:
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L93;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        r120.topMargin = r117;
        r118.setLayoutParams(r120);
        r116.setOnLoadMore(new m(this));
        r116.setWeakNetErrorCallback(new n());
        r116.setNoNetErrorCallback(new o(this));
        r116.setClickHandler(new p(this));
        r116.setOnItemOnScreenListener(new q());
        r116.setMSearchResultEmptyViewInterface(new DoubaoSearchEmptyView(r116.getContext()));
        r116.setEmptyViewColdAndHotListener(new r(this));
        r116.setColdAndHotDataHelper(new s(this));
        r116.a();
        SearchInputView r121 = this.f440025g;
        if (r121 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
        r121 = null;
    L50:
        r121.setOnSearch(new d(this));
        SearchInputView r122 = this.f440025g;
        if (r122 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
        r122 = null;
    L53:
        r122.setOnQueryClear(new e(this));
        DoubaoChatSearchViewModel r123 = this.f440026h;
        if (r123 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r123 = null;
    L56:
        r123.getHistorySugs().observe(getViewLifecycleOwner(), new f(this));
        DoubaoChatSearchViewModel r124 = this.f440026h;
        if (r124 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r124 = null;
    L59:
        r124.getDeleteHistorySug().observe(getViewLifecycleOwner(), new g(this));
        DoubaoChatSearchViewModel r125 = this.f440026h;
        if (r125 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r125 = null;
    L62:
        r125.getResetSearchResult().observe(getViewLifecycleOwner(), new h(this));
        DoubaoChatSearchViewModel r126 = this.f440026h;
        if (r126 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r126 = null;
    L65:
        r126.getMoreSearchResult().observe(getViewLifecycleOwner(), new i(this));
        DoubaoChatSearchViewModel r127 = this.f440026h;
        if (r127 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r127 = null;
    L68:
        r127.getError().observe(getViewLifecycleOwner(), new j(this));
        DoubaoChatSearchViewModel r128 = this.f440026h;
        if (r128 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r128 = null;
    L71:
        r128.getShowLoading().observe(getViewLifecycleOwner(), new k(this));
        DoubaoChatSearchViewModel r129 = this.f440026h;
        if (r129 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r129 = null;
    L74:
        r129.getShowEmptyResult().observe(getViewLifecycleOwner(), new l(this));
        DoubaoChatSearchViewModel r130 = this.f440026h;
        if (r130 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r130 = null;
    L77:
        r130.getNoNetTypeData().observe(getViewLifecycleOwner(), new com.ss.android.lark.search.doubao.chat.a(this));
        DoubaoChatSearchViewModel r131 = this.f440026h;
        if (r131 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r131 = null;
    L80:
        r131.getShowToastRes().observe(getViewLifecycleOwner(), new com.ss.android.lark.search.doubao.chat.b(this));
        DoubaoChatSearchViewModel r132 = this.f440026h;
        if (r132 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r132 = null;
    L83:
        r132.getColdAndHotType().observe(getViewLifecycleOwner(), new c(this));
        SearchInputView r133 = this.f440025g;
        if (r133 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
        r133 = null;
    L86:
        r133.setHint(UIHelper.getString(R.string.LarkIM_Dm_KeywordSearch_Placeholder));
        SearchInputView r134 = this.f440025g;
        if (r134 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
    L90:
        r103.a();
        return;
    L89:
        r103 = r134;
        goto L90
    L93:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.doubao_chat_search_layout, r101, false);
    }
}
