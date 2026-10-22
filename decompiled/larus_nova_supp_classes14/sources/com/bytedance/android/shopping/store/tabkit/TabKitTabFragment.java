package com.bytedance.android.shopping.store.tabkit;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.model.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0013\u0010&\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010'\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b'\u0010\u0018¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "Landroidx/fragment/app/Fragment;", "fragment", "findTabKitFragment", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "tabKitViewModel$delegate", "Lkotlin/Lazy;", "getTabKitViewModel", "()Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "tabKitViewModel", "Lcom/bytedance/android/shopping/store/tabkit/f;", "tabKitFragment$delegate", "getTabKitFragment", "()Lcom/bytedance/android/shopping/store/tabkit/f;", "tabKitFragment", "", "isAlreadyShow", "Z", "()Z", "setAlreadyShow", "(Z)V", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "getTab", "()Lcom/bytedance/android/shopping/store/tabkit/model/k;", "tab", "", "getTabId", "()I", "tabId", "Lcom/bytedance/android/shopping/store/tabkit/model/v;", "getTabState", "()Lcom/bytedance/android/shopping/store/tabkit/model/v;", "tabState", "isInForeground", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TabKitTabFragment extends Fragment {
    private boolean isAlreadyShow;
    private final Lazy tabKitFragment$delegate;
    private final Lazy tabKitViewModel$delegate;

    public final f getTabKitFragment() {
        return (f) this.tabKitFragment$delegate.getValue();
    }

    public final TabKitViewModel getTabKitViewModel() {
        return (TabKitViewModel) this.tabKitViewModel$delegate.getValue();
    }

    public TabKitTabFragment() {
        this.tabKitViewModel$delegate = LazyKt.lazy(new TabKitTabFragment$tabKitViewModel$2(this));
        this.tabKitFragment$delegate = LazyKt.lazy(new TabKitTabFragment$tabKitFragment$2(this));
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getTab() {
        return getTabKitViewModel().getTabById(Integer.valueOf(getTabId()));
    }

    public final int getTabId() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getInt("tab_id");
    }

    public final v getTabState() {
        return getTabKitViewModel().getTabState(Integer.valueOf(getTabId()));
    }

    public final boolean isInForeground() {
        com.bytedance.android.shopping.store.tabkit.model.k r0 = getTab();
        y r1 = (y) getTabKitViewModel().getCurrentTab().getValue();
        if (r1 == null) goto L5;
        com.bytedance.android.shopping.store.tabkit.model.k r2 = r1.a;
    L7:
        return Intrinsics.areEqual(r0, r2);
    L5:
        r2 = null;
        goto L7
    }

    public final boolean isAlreadyShow() {
        return this.isAlreadyShow;
    }

    private final Fragment findTabKitFragment(Fragment r2) {
        Fragment r3 = r2.getParentFragment();
        Intrinsics.checkNotNull(r3);
        if ((r3 instanceof f) == false) goto L5;
        return r3;
    L5:
        return findTabKitFragment(r3);
    }

    public final void setAlreadyShow(boolean r1) {
        this.isAlreadyShow = r1;
    }

    public static final /* synthetic */ Fragment access$findTabKitFragment(TabKitTabFragment r0, Fragment r1) {
        return r0.findTabKitFragment(r1);
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        getTabKitViewModel().getCurrentTab().observe(getViewLifecycleOwner(), new AnonymousClass1(this));
    }
}
