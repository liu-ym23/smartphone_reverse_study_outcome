package com.ss.android.ugc.aweme.search.common.result.recycler;

import com.ss.android.ugc.aweme.utils.scrollcontroller.IScrollHolderListener;
import com.ss.android.ugc.aweme.utils.scrollcontroller.IScrollViewHolder;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/recycler/IScrollViewController;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IScrollViewController {
    void addScrollListener(IScrollHolderListener r100);

    void clear(Set<IScrollViewHolder> r100);

    int getCardInBgNum();

    int getItemRangeHeight(int r100, int r101);

    int getKiwiFruitRangeHeight();

    boolean isKiwiExpand();

    boolean isKiwiMode();

    void register(IScrollViewHolder r100);

    void release();

    void removeScrollListener(IScrollHolderListener r100);
}
