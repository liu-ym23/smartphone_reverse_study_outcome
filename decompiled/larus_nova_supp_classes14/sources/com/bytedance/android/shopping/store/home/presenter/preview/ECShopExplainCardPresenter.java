package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/preview/ECShopExplainCardPresenter;", "Lcom/bytedance/android/shopping/store/home/frame/presenter/a;", "Lcom/bytedance/android/ec/store/common/headlive/StoreV3LiveRoomVO;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onDestroy", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopExplainCardPresenter extends com.bytedance.android.shopping.store.home.frame.presenter.a<StoreV3LiveRoomVO> implements LifecycleObserver {
    public ViewGroup j;
    public ViewGroup k;
    public cf.d l;
    public final Lazy m;
    public final Lazy n;
    public StoreV3LiveRoomVO o;

    public final void c0() {
        cf.d r0 = this.l;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        this.l = null;
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void j0() {
        p r0 = (p) this.m.getValue();
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.o != null) goto L5;
        return;
    L5:
        if (this.j == null) goto L9;
        Lazy r0 = ECTaskManager.b;
        ECTaskManager.a.a().a(d0().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopExplainCardPresenter$onResume$$inlined$let$lambda$1(this));
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        e0().removeObserver(this);
    }

    public ECShopExplainCardPresenter(Fragment r1) {
        Intrinsics.checkNotNull(r1);
        super(r1);
        this.m = LazyKt.lazy(new ECShopExplainCardPresenter$modelAdapter$2(this));
        this.n = LazyKt.lazy(new ECShopExplainCardPresenter$behaviorAdapter$2(this));
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void i0(StoreV3LiveRoomVO r4) {
        StoreV3LiveRoomVO r5 = r4;
        p r0 = (p) this.m.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.j() != true) goto L14;
        this.o = r5;
        this.j = (ViewGroup) Z().b(2131387443).f();
        this.k = (ViewGroup) Z().b(2131372771).f();
        p r6 = (p) this.m.getValue();
        if (r6 == null) goto L11;
        jm.a<ShopLiveState> r7 = r6.e();
        if (r7 == null) goto L11;
        r7.a(h0(), new a(this), false);
    L11:
        e0().addObserver(this);
        return;
    }
}
