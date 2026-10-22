package com.larus.search.impl.global;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.paging.PagingSource;
import com.larus.paging.i0;
import com.larus.paging.j0;
import com.larus.paging.k0;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/search/impl/global/GlobalSearchViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getSearchResultPager", "Landroidx/lifecycle/LiveData;", "Lcom/larus/paging/PagingData;", "Lcom/larus/search/impl/global/model/GlobalSearchResultItemWrapper;", "keyword", "", "enterMethod", "trackNode", "Ljava/lang/ref/WeakReference;", "Lcom/ixigua/lib/track/ITrackNode;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlobalSearchViewModel extends AndroidViewModel {
    public static /* synthetic */ PagingSource yo(String r100, String r101, WeakReference r102) {
        return getSearchResultPager$lambda$0(r100, r101, r102);
    }

    public GlobalSearchViewModel(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        super(r100);
    }

    private static final PagingSource getSearchResultPager$lambda$0(String r100, String r101, WeakReference r102) {
        return new GlobalSearchPagingSource(r100, r101, r102);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.search.impl.global.u] */
    public final LiveData<k0<ws9.c>> getSearchResultPager(final String r100, final String r101, final WeakReference<by7.e> r102) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "trackNode");
        return FlowLiveDataConversions.asLiveData$default(com.larus.paging.g.a(new i0(new j0(), new u(r100, r101, r102)).f363862a, ViewModelKt.getViewModelScope(this)), null, 0, 3, null);
    }
}
