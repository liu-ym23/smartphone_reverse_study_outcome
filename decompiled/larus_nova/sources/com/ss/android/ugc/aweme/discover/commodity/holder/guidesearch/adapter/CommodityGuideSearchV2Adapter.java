package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.uikit.viewpager.AbsPagerAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/adapter/CommodityGuideSearchV2Adapter;", "Lcom/bytedance/ies/uikit/viewpager/AbsPagerAdapter;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityGuideSearchV2Adapter extends AbsPagerAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Fragment f450195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, WeakReference<View>> f450196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f450197d;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "object");
        return -2;
    }

    public final Context getContext() {
        return this.f450197d;
    }

    public CommodityGuideSearchV2Adapter(Context r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LayoutInflater.from(r100);
        this.f450197d = r100;
        this.f450196c = new LinkedHashMap();
    }

    @Override // com.bytedance.ies.uikit.viewpager.AbsPagerAdapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        if (this.f450195b != null) goto L7;
        return new View(this.f450197d);
    L7:
        return new View(this.f450197d);
    }
}
