package com.bytedance.android.window.shop.home.header.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.window.base.utils.WindowForceDoFrameMessage;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.lifecycle.c;
import com.bytedance.android.window.shop.lifecycle.f;
import com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout;
import com.bytedance.android.window.shop.repository.dto.a1;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.widget.ECShopRecyclerView;
import com.bytedance.android.window.shop.widget.WindowHeaderItemDecoration;
import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oq3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/home/header/presenter/WindowHeaderPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderPresenter extends QFragmentPresenter implements LifecycleEventObserver, ECRecyclerViewPinnableLayout.b {
    public final Lazy f;
    public ECShopRecyclerView g;
    public ECRecyclerViewPinnableLayout h;
    public final WindowTypeSeparatedAdapter i;
    public final WindowTypeSeparatedAdapter j;
    public final View k;
    public final Fragment l;

    public static final class a<T> implements Observer {
        public final /* synthetic */ WindowHeaderPresenter a;

        public a(WindowHeaderPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            uq3.a r4 = (uq3.a) r3;
            if (r4.c == null) goto L23;
            ConcurrentHashMap<Long, f> r0 = c.a;
            f r1 = c.a(((ECWindowViewModel) this.a.f.getValue()).getShopParam().getLifecycleMonitorId());
            if (r1 == null) goto L8;
            r1.f();
        L8:
            this.a.j.clear();
            List<a1> r5 = r4.a;
            if (r5 == null) goto L24;
            Fragment r2 = this.a.Y().a;
            if (r2 == null) goto L14;
            String r6 = r2.getTag();
        L15:
            if (r6 == null) goto L17;
            Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r7 = WindowDataMapper.a;
            List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r8 = WindowDataMapper.a(r5, new WindowHeaderPresenter$onBind$1$list$1(this));
        L18:
            r8.add(new e());
            this.a.j.D2(r8);
            if (yq3.a.d() != 1) goto L22;
            WindowForceDoFrameMessage.a();
            return;
        L22:
            return;
        L17:
            r8 = WindowDataMapper.a(r5, null);
            goto L18
        L14:
            r6 = null;
            goto L15
        L24:
            return;
        }
    }

    @Override // com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout.b
    public final void A(ECRecyclerViewPinnableLayout.InnerRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
    }

    @Override // com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout.b
    public final void S(ECRecyclerViewPinnableLayout.InnerRecyclerView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
    }

    public final void c0() {
        ECShopRecyclerView r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        r0.swapAdapter(null, true);
    }

    public final void b0(QModel r4) {
        this.l.getLifecycle().addObserver(this);
        ECRecyclerViewPinnableLayout r5 = (ECRecyclerViewPinnableLayout) this.k.findViewById(2131370824);
        this.h = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
    L5:
        r5.setLayoutManager(new LinearLayoutManager(l0.b(Y().c())));
        ECRecyclerViewPinnableLayout r6 = this.h;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
    L8:
        r6.setAdapter(this.i);
        ECRecyclerViewPinnableLayout r7 = this.h;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
    L11:
        r7.setPinedCallback(this);
        ECShopRecyclerView r8 = (ECShopRecyclerView) this.k.findViewById(2131370821);
        this.g = r8;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L14:
        r8.setItemAnimator(null);
        ECShopRecyclerView r9 = this.g;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L17:
        r9.setAdapter(this.j);
        ECShopRecyclerView r10 = this.g;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L20:
        r10.addItemDecoration(new WindowHeaderItemDecoration());
        ECShopRecyclerView r11 = this.g;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L23:
        r11.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        ((ECWindowViewModel) this.f.getValue()).getHeaderResponse().a(Y().e(), new a(this), false);
    }

    public WindowHeaderPresenter(View r13, Fragment r14) {
        Intrinsics.checkNotNullParameter(r13, "rootView");
        Intrinsics.checkNotNullParameter(r14, "tabFragment");
        super(r14);
        this.k = r13;
        this.l = r14;
        this.f = LazyKt.lazy(new WindowHeaderPresenter$viewModel$2(this));
        this.i = new WindowTypeSeparatedAdapter(r14, CollectionsKt.emptyList(), WindowHeaderPresenter$pinAdapter$1.INSTANCE, WindowHeaderPresenter$pinAdapter$2.INSTANCE, true);
        this.j = new WindowTypeSeparatedAdapter(r14, CollectionsKt.emptyList(), new WindowHeaderPresenter$adapter$1(this), WindowHeaderPresenter$adapter$2.INSTANCE, true);
    }
}
