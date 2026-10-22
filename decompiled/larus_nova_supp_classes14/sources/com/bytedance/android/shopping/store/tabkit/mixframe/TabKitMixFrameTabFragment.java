package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.shopping.store.tabkit.TabKitTabFragment;
import com.bytedance.android.shopping.store.tabkit.mixframe.impl.ECTabKitMixFrameBaseImpl;
import com.bytedance.android.shopping.store.tabkit.mixframe.impl.ECTabKitMixFrameFollowImpl;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/mixframe/TabKitMixFrameTabFragment;", "Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitMixFrameTabFragment extends TabKitTabFragment implements QViewModelOwner {
    public static final /* synthetic */ int j = 0;
    public final QUIManager d;
    public View e;
    public c f;
    public boolean g;
    public boolean h;
    public boolean i;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ TabKitMixFrameTabFragment a;

        public b(TabKitMixFrameTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            y r4 = (y) r3;
            if (r4 == null) goto L5;
            k r5 = r4.a;
        L7:
            if (Intrinsics.areEqual(r5, this.a.getTab()) == false) goto L12;
            TabKitMixFrameTabFragment r6 = this.a;
            r6.i = true;
            c r1 = r6.f;
            if (r1 == null) goto L11;
            r1.onShow(!r6.g);
        L11:
            this.a.g = true;
            return;
        L12:
            TabKitMixFrameTabFragment r7 = this.a;
            if (r7.i == false) goto L20;
            r7.i = false;
            c r2 = r7.f;
            if (r2 == null) goto L17;
            r2.onHide(!r7.h);
        L17:
            this.a.h = true;
            return;
        L20:
            return;
        L5:
            r5 = null;
            goto L7
        }
    }

    static {
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public TabKitMixFrameTabFragment() {
        this.d = new QUIManager();
    }

    public final void onDestroy() {
        super.onDestroy();
        c r0 = this.f;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.d.r(com.bytedance.android.shopping.store.tabkit.mixframe.b.class);
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L18;
        int r5 = r4.getInt("tab_id");
        if (getTabKitViewModel().isRouterParamsInitialized() == false) goto L7;
        TabKitMixFrameTabFragment r0 = this;
    L8:
        if (r0 == null) goto L11;
        String r1 = getTabKitViewModel().getRouterParams().getBizTag();
        if (r1 == null) goto L11;
    L12:
        String r6 = r1 + '_' + r5;
        c.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(this, "fragment");
        if (Intrinsics.areEqual(r6, "follow_shop_page_2") == false) goto L15;
        c r7 = new ECTabKitMixFrameFollowImpl(this);
    L16:
        this.f = r7;
        r7.init();
        return;
    L15:
        r7 = new ECTabKitMixFrameBaseImpl(this);
    L11:
        r1 = "";
        goto L12
    L7:
        r0 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        if (this.e != null) goto L16;
        c r6 = this.f;
        if (r6 == null) goto L13;
        View r7 = r6.a();
        if (r7 == null) goto L13;
        c r0 = this.f;
        if (r0 == null) goto L11;
        List<QIPresenter> r1 = r0.b(r7);
    L12:
        com.bytedance.android.shopping.store.tabkit.mixframe.b r8 = new com.bytedance.android.shopping.store.tabkit.mixframe.b(r7, r1);
    L14:
        if (r8 == null) goto L16;
        QUIManager r9 = this.d;
        r9.a = this;
        r9.l(r8, requireContext(), true);
        this.e = this.d.p();
        this.d.c(com.bytedance.android.shopping.store.tabkit.mixframe.b.class, null);
        goto L16
    L11:
        r1 = null;
    L13:
        r8 = null;
    L16:
        getTabKitViewModel().getCurrentTab().observe(getViewLifecycleOwner(), new b(this));
        return this.e;
    }
}
