package com.bytedance.android.shopping.store.home;

import android.os.Handler;
import com.bytedance.android.shopping.store.lifecycle.ECStorePerfMonitor;
import com.bytedance.android.shopping.store.tabkit.TabKitTabFragment;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECStoreModuleBinderFragment;", "Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "Lpm/a;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECStoreModuleBinderFragment extends TabKitTabFragment implements pm.a {
    public final Lazy d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;

    public abstract void T90();

    public final ECStoreViewModel U90() {
        return (ECStoreViewModel) this.d.getValue();
    }

    public final void bindModule() {
        if (this.e == false) goto L6;
        return;
    L6:
        if (getView() == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        this.e = true;
        T90();
        return;
    L11:
        ((Handler) this.f.getValue()).post((ECStoreModuleBinderFragment$ensureBindRunnable$2.a) this.g.getValue());
        return;
    L8:
        r0 = false;
        goto L9
    }

    public ECStoreModuleBinderFragment() {
        this.d = LazyKt.lazy(new ECStoreModuleBinderFragment$storeViewModel$2(this));
        this.f = LazyKt.lazy(ECStoreModuleBinderFragment$mainHandler$2.INSTANCE);
        this.g = LazyKt.lazy(new ECStoreModuleBinderFragment$ensureBindRunnable$2(this));
    }

    public void onPause() {
        super.onPause();
        ECStorePerfMonitor r0 = U90().getPerfMonitor();
        if (r0 == null) goto L8;
        com.bytedance.android.shopping.store.lifecycle.g r1 = r0.k;
        if (r1 == null) goto L9;
        r1.b();
        return;
    L9:
        return;
    }

    public static final Handler S90(ECStoreModuleBinderFragment r0) {
        return (Handler) r0.f.getValue();
    }
}
