package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/RecyclerViewAbstract;", "", "Landroid/content/Context;", "getContext", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public interface RecyclerViewAbstract {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public static final class DefaultImpls {
        public static Context getContext(RecyclerViewAbstract r100) {
            RecyclerView r101 = r100.getRecyclerView();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.getContext();
        }
    }

    Context getContext();

    int getOrientation();

    @Deprecated(message = "")
    RecyclerView getRecyclerView();
}
