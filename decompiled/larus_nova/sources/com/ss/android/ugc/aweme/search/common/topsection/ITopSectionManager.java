package com.ss.android.ugc.aweme.search.common.topsection;

import android.widget.LinearLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/ITopSectionManager;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITopSectionManager {
    LinearLayout getHeadCardView();

    AppBarLayout getTopSectionView();

    boolean hasHeadCard();

    void preBindFilterCard(List<SearchAggregateCommodity> r100);
}
