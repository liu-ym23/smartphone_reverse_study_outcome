package com.bytedance.android.livesdk.linkvideo;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/LoadMoreScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "a", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreScrollListener extends RecyclerView.OnScrollListener {
    public int a;
    public int b;
    public final GridLayoutManager c;
    public final Function0<Unit> d;

    public static final class a {
    }

    static {
    }

    public LoadMoreScrollListener(GridLayoutManager r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        Intrinsics.checkNotNullParameter(r3, "loadMore");
        this.c = r2;
        this.d = r3;
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        if (r3 != 0) goto L10;
        int r4 = this.c.getItemCount();
        if (this.b == 0) goto L7;
        return;
    L7:
        if (this.a != (r4 - 1)) goto L12;
        this.b = 1;
        this.d.invoke();
        return;
    L12:
        return;
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        this.a = this.c.findLastVisibleItemPosition();
    }
}
