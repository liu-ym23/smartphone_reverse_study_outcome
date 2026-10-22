package com.ss.android.ugc.aweme.search.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.commodity.provider.IECSearchResultDataProvider;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.tab.IECSearchTabFeed;
import com.ss.android.ugc.aweme.search.common.viewpager.ECLazyFragmentPagerAdapter;
import com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.ECSearchBizScene;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.SrpBizDiffConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ECEmptyFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/search/common/viewpager/ECLazyFragmentPagerAdapter$Laziable;", "Lcom/ss/android/ugc/aweme/search/common/viewpager/IECSearchBaseFragment;", "Lcom/ss/android/ugc/aweme/search/common/tab/IECSearchTabFeed;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECEmptyFragment extends Fragment implements ECLazyFragmentPagerAdapter.Laziable, IECSearchBaseFragment, IECSearchTabFeed {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f451372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f451373e;

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final SrpBizDiffConfig D00() {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final IECSearchResultDataProvider IN() {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final void R7() {
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final void TT(int r100) {
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final void updateSearchParams(JSONObject r100) {
    }

    public ECEmptyFragment() {
        ECSearchBizScene r100 = ECSearchBizScene.HYBRID_SEARCH;
        this.f451372d = "";
        this.f451373e = "";
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final String PO() {
        return this.f451372d;
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final String getTabType() {
        return this.f451373e;
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final void cR(ECSearchParam r100) {
        Intrinsics.checkNotNullParameter(r100, "ecSearchParam");
        Intrinsics.checkNotNullParameter(r100, "ecSearchParam");
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment
    public final void l7(ECSearchParam r100) {
        Intrinsics.checkNotNullParameter(r100, "ecSearchParam");
        Intrinsics.checkNotNullParameter(r100, "ecSearchParam");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ec_search_fragment_blank, r101, false);
    }
}
