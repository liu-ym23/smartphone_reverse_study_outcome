package com.bytedance.android.shopping.store.home;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.store.utils.playable.controller.RestrictMarginAreaProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECShopPlayAbilityPlugin;", "", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/bytedance/android/shopping/store/home/c0;", "event", "", "refreshPlay", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopPlayAbilityPlugin implements LifecycleEventObserver {
    public r a;
    public final RecyclerView b;
    public final LifecycleOwner c;
    public final RestrictMarginAreaProcessor d;

    @Subscribe
    public final void refreshPlay(c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (r2.a != 1) goto L8;
        r r3 = this.a;
        if (r3 == null) goto L9;
        r3.a();
        return;
    L9:
        return;
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = q.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        r r5 = this.a;
        if (r5 == null) goto L16;
        r5.e.b();
        return;
    L16:
        return;
    L5:
        if (r4 != 2) goto L17;
        r r6 = this.a;
        if (r6 == null) goto L14;
        r6.e.d();
        return;
    L14:
        return;
    }

    public ECShopPlayAbilityPlugin(ECHybridRecyclerView r2, Fragment r3, RestrictMarginAreaProcessor r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
