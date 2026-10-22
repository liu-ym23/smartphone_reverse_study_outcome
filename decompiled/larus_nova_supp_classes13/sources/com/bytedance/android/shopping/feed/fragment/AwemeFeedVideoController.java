package com.bytedance.android.shopping.feed.fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/feed/fragment/AwemeFeedVideoController;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/inflow/compat/ToggleBottomSheetFragment$b;", "", "onCreate", "onResume", "onPause", "onDestroy", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AwemeFeedVideoController implements LifecycleObserver, ToggleBottomSheetFragment.b {
    public boolean a;
    public boolean b;
    public final FragmentActivity c;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.a = com.bytedance.android.shopping.feed.utils.f.b.isPlaying();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (this.a == false) goto L6;
        com.bytedance.android.shopping.feed.utils.f r0 = com.bytedance.android.shopping.feed.utils.f.b;
        r0.c();
        r0.h();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        com.bytedance.android.shopping.feed.utils.f.b.e(true, this.c);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.b == false) goto L5;
        return;
    L5:
        if (this.a == false) goto L9;
        com.bytedance.android.shopping.feed.utils.f r0 = com.bytedance.android.shopping.feed.utils.f.b;
        r0.c();
        r0.h();
        return;
    }

    public AwemeFeedVideoController(ToggleBottomSheetFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = true;
        this.c = r2.getActivity();
        Intrinsics.checkNotNullParameter(this, "onExpandStateChangedListener");
        r2.h.add(this);
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment.b
    public final void a(boolean r1) {
        this.b = r1;
        if (r1 == false) goto L6;
        com.bytedance.android.shopping.feed.utils.f.b.g();
        return;
    L6:
        if (this.a == false) goto L10;
        com.bytedance.android.shopping.feed.utils.f r2 = com.bytedance.android.shopping.feed.utils.f.b;
        r2.c();
        r2.h();
        return;
    }
}
