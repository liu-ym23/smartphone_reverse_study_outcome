package com.bytedance.android.shopping.store.search.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.arch.viewmodel.b;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import im.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/search/fragment/ECShopSearchFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSearchFragment extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int i = 0;
    public final QUIManager d;
    public boolean e;
    public final Lazy f;
    public final c g;
    public ViewGroup h;

    public static final class a {
    }

    static {
    }

    public final ShopSearchViewModel S90() {
        return (ShopSearchViewModel) this.g.getValue();
    }

    public final ViewModelProvider.Factory o6() {
        return (ViewModelProvider.Factory) this.f.getValue();
    }

    public final void T90() {
        if (this.e == true) goto L19;
        this.e = true;
        ShopSearchViewModel r1 = S90();
        Pair[] r2 = new Pair[8];
        r2[0] = TuplesKt.to("store_type", "shop");
        r2[1] = TuplesKt.to("author_id", S90().getSearchParam().getStoreAccountParam().getUserId());
        r2[2] = TuplesKt.to("shop_id", S90().getSearchParam().getShopId());
        List<SearchSuggestWord> r0 = S90().getSearchParam().getSearchSuggestWords();
        if (r0 == null) goto L9;
        SearchSuggestWord r3 = (SearchSuggestWord) CollectionsKt.firstOrNull(r0);
        if (r3 == null) goto L9;
        String r4 = r3.getWord();
    L10:
        r2[3] = TuplesKt.to("icon_content", r4);
        Integer r5 = S90().getSearchParam().getFollowStatus();
        if (r5 != null) goto L14;
    L16:
        String r6 = CommentScene.COMMENTSCENE_NO_AWEME;
    L17:
        r2[4] = TuplesKt.to("follow_status", r6);
        r2[5] = TuplesKt.to("entrance_info", S90().getSearchParam().getEntranceInfo());
        r2[6] = TuplesKt.to("page_name", S90().getSearchParam().getPageName());
        r2[7] = TuplesKt.to("words_content", S90().getSearchParam().getSearchHint());
        r1.doEventAction("search_process_page_show", r2);
        QUIManager r7 = this.d;
        ViewGroup r8 = this.h;
        Intrinsics.checkNotNull(r8);
        r7.k(new ck3.a(r8), requireActivity(), this);
        this.d.c(ck3.a.class, null);
        return;
    L14:
        if (r5.intValue() != (-1)) goto L16;
        r6 = "0";
    L9:
        r4 = null;
        goto L10
    }

    public ECShopSearchFragment() {
        this.d = new QUIManager();
        this.f = LazyKt.lazy(ECShopSearchFragment$factory$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new ECShopSearchFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new ECShopSearchFragment$$special$$inlined$viewModels$1(this);
        this.g = b.a(this, Reflection.getOrCreateKotlinClass(ShopSearchViewModel.class), new ECShopSearchFragment$$special$$inlined$viewModels$2(r1), r0);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.r(ck3.a.class);
    }

    public final void onPause() {
        super.onPause();
        S90().traceTimeEnd();
    }

    public final void onResume() {
        super.onResume();
        S90().initSearchHistoryData(requireContext());
        S90().traceTimeStart();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        ShopSearchViewModel r5 = S90();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("search_param");
    L6:
        if (r1 == null) goto L15;
        r5.setSearchParam((ECShopSearchParam) r1);
        BtmSDK.INSTANCE.registerBtmPageOnCreate(this, "a1.b8121", S90().getSearchParam().getSourceBtmToken());
        qm.a.b("ec_perf_duration_shop_search");
        qm.a.a("ec_perf_duration_shop_search", "initial", System.currentTimeMillis());
        r r6 = r.a;
        if (r6.isLogin() == false) goto L11;
        S90().setUserId(r6.f());
        S90().setMarketId(S90().getSearchParam().getShopId());
    L11:
        if (S90().getSearchParam().getEnableHideFloatLive() == false) goto L16;
        k.a();
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.router.ECShopSearchParam");
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        T90();
        View r4 = r2.findViewById(2131387282);
        if (r4 == null) goto L6;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.height = j56.a.b(r4.getContext());
        return;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        if (r4 == 10) goto L12;
        if (r4 == 11) goto L8;
        return;
    L8:
        if (this.e == true) goto L10;
        T90();
    L10:
        S90().getSearchContent().g("");
        S90().getSugRequestParam().b = 1;
        ((ArrayList) S90().getSugRequestParam().c).clear();
        return;
    L12:
        if (this.e == true) goto L14;
        T90();
    L14:
        S90().getSugRequestParam().b = 1;
        ((ArrayList) S90().getSugRequestParam().c).clear();
        dn.a r6 = S90().getSugRequestParam();
        int r7 = 3;
        if (r5 == null) goto L17;
        r7 = r5.getIntExtra("sug_enter_type", 3);
    L17:
        r6.g = r7;
        ShopSearchViewModel r8 = S90();
        long r0 = 0;
        if (r5 == null) goto L20;
        r0 = r5.getLongExtra("sug_gap_time", 0);
    L20:
        r8.setPageDuration(r0);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.h != null) goto L10;
        View r5 = th.a.c(requireContext(), 2131561062, r3, false);
        if (r5 == null) goto L8;
        this.h = (ViewGroup) r5;
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L10:
        return this.h;
    }
}
