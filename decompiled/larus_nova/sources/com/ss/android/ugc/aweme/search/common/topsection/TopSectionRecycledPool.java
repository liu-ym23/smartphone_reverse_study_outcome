package com.ss.android.ugc.aweme.search.common.topsection;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.Logger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/TopSectionRecycledPool;", "", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopSectionRecycledPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<RecyclerView.ViewHolder> f452240a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/TopSectionRecycledPool$Companion;", "", "()V", "INIT_POOL_SIZE", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public TopSectionRecycledPool() {
        this.f452240a = new SparseArray(5);
    }

    public final RecyclerView.ViewHolder a(int r100) {
        RecyclerView.ViewHolder r101 = this.f452240a.get(r100, null);
        Logger.d("TopSectionManager", "getRecycledView: viewHolder = " + r101);
        if (r101 == null) goto L7;
        View r102 = r101.itemView;
        if (r102 == null) goto L7;
        ViewParent r103 = r102.getParent();
    L8:
        if (r103 != null) goto L10;
        return r101;
    L10:
        Logger.e("TopSectionManager", "getRecycledView error: itemView has parent");
        return null;
    L7:
        r103 = null;
        goto L8
    }

    public final void b(int r100, RecyclerView.ViewHolder r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        RecyclerView.ViewHolder r102 = this.f452240a.get(r100, null);
        Logger.d("TopSectionManager", "putRecycledView: viewType = " + r100);
        if (r102 == null) goto L8;
        Logger.e("TopSectionManager", "putRecycledView error: already contains viewHolder");
        return;
    L8:
        this.f452240a.put(r100, r101);
    }
}
