package com.bytedance.locallife.biz.utils.rv;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/biz/utils/rv/OnLoadMoreListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class OnLoadMoreListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f256991a;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (r102 <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        return;
    L8:
        if (this.f256991a == true) goto L16;
        this.f256991a = true;
        throw null;     // Catch: Throwable -> L13
    L17:
        return;
    L16:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
