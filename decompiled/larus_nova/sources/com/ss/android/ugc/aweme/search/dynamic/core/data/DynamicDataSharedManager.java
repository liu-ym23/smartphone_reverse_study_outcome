package com.ss.android.ugc.aweme.search.dynamic.core.data;

import android.util.SparseArray;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch;
import com.ss.android.ugc.aweme.search.components.dynamic.SearchLynxData;
import com.ss.android.ugc.aweme.search.components.dynamic.SearchLynxDataCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/data/DynamicDataSharedManager;", "", "<init>", "()V", "Companion", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class DynamicDataSharedManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DynamicPatch f452679c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f452680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SearchLynxData f452681b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/data/DynamicDataSharedManager$Companion;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
        f452679c = new DynamicPatch();
    }

    public final int a() {
        SearchLynxData r100 = new SearchLynxData(f452679c);
        SearchLynxDataCenter r101 = SearchLynxDataCenter.f452578a;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);     // Catch: Throwable -> L16
        Objects.toString(r100);     // Catch: Throwable -> L16
        int r102 = -1;
        if (SearchLynxDataCenter.f452582e != (-1)) goto L9;
        monitor-exit(r101);
    L14:
        this.f452680a = r102;
        this.f452681b = r100;
        return r102;
    L9:
        r102 = SearchLynxDataCenter.f452579b;     // Catch: Throwable -> L16
        SearchLynxDataCenter.f452579b = r102 + 1;     // Catch: Throwable -> L16
        SearchLynxDataCenter.f452580c.put(r102, r100);     // Catch: Throwable -> L16
        SparseArray<List<Integer>> r103 = SearchLynxDataCenter.f452581d;     // Catch: Throwable -> L16
        List<Integer> r104 = r103.get(SearchLynxDataCenter.f452582e);     // Catch: Throwable -> L16
        if (r104 != null) goto L12;
        r104 = new ArrayList();     // Catch: Throwable -> L16
    L12:
        r104.add(Integer.valueOf(r102));     // Catch: Throwable -> L16
        r103.put(SearchLynxDataCenter.f452582e, r104);     // Catch: Throwable -> L16
        monitor-exit(r101);
    L16:
        th = move-exception;
        throw th;
    }

    public DynamicDataSharedManager() {
        this.f452680a = -1;
    }
}
