package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.d;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static AnchorV4LoadMoreRecyclerView f;
    public boolean a;
    public int b;
    public AnchorV4LoadMoreRecyclerView c;
    public final View d;
    public final d e;

    public static final class a {
    }

    static {
    }

    public c(View r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "headView");
        this.d = r2;
        this.e = r3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.shopping.anchorv4.voavhs.head.more.AnchorV4LoadMoreRecyclerView] */
    public final AnchorV4LoadMoreRecyclerView a(final ScrollMoreText r6, final boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "scrollMoreText");
        final ?? r0 = new AnchorV4LoadMoreRecyclerView(this.d.getContext(), null, 6, 0);
        f = r0;
        r0.setScrollState(r7);
        r0.setAdapter(new AnchorV4HeadLoadMoreAdapter(this.d, r6, this.e));
        final Context r2 = r0.getContext();
        LinearLayoutManager r1 = new AnchorV4LoadMoreUtil$getLoadMoreLayout$$inlined$apply$lambda$1(r2, r7);
        r1.setOrientation(0);
        Unit r3 = Unit.INSTANCE;
        r0.setLayoutManager(r1);
        r0.setScrollToEndCallback(new AnchorV4LoadMoreUtil$getLoadMoreLayout$$inlined$apply$lambda$2(r0, this, r7, r6));
        r0.addOnScrollListener(new AnchorV4LoadMoreUtil$getLoadMoreLayout$$inlined$apply$lambda$3(this));
        this.c = r0;
        return r0;
    }
}
