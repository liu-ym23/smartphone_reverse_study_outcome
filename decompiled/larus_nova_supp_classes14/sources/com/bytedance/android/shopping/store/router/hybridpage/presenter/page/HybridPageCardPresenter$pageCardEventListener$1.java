package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridPageCardPresenter$pageCardEventListener$1 implements com.bytedance.android.shopping.store.router.hybridpage.event.a {
    public final /* synthetic */ HybridPageCardPresenter a;

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void a() {
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$viewDisappeared$1(this));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void d() {
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$appResignActive$1(this));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void j() {
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$appBecomeActive$1(this));
    }

    public HybridPageCardPresenter$pageCardEventListener$1(HybridPageCardPresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void b(final boolean r3) {
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$viewAppeared$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void h(final boolean r3) {
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$sliceFinishLoad$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void i(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "hybridListId");
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$hybridListRequestLoadMore$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void k(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$sliceLoadError$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void m(final String r3, final Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$publishXEvent$1(this, r3, r4));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void f(final String r3, final String r4, final String r5) {
        Intrinsics.checkNotNullParameter(r3, "searchQuery");
        Intrinsics.checkNotNullParameter(r4, "searchSource");
        Intrinsics.checkNotNullParameter(r5, "suggestGroupId");
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$searchResultSearch$1(this, r3, r4, r5));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void l(final String r3, final Object r4, final String r5) {
        Intrinsics.checkNotNullParameter(r3, "apiName");
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$firstScreenApiCompleted$1(this, r3, r4, r5));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void e(final String r9, final int r10, final int r11, final ECHybridListItemVO r12) {
        Intrinsics.checkNotNullParameter(r9, "hybridListId");
        Intrinsics.checkNotNullParameter(r12, "itemModel");
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$hybridListCardClicked$1(this, r9, r10, r11, r12));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void g(final String r10, final int r11, final int r12, final int r13, final ECHybridListItemVO r14) {
        Intrinsics.checkNotNullParameter(r10, "hybridListId");
        Intrinsics.checkNotNullParameter(r14, "itemModel");
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$hybridListCardDisappeared$1(this, r10, r11, r12, r13, r14));
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.event.a
    public final void c(final String r12, final int r13, final int r14, final int r15, final ECHybridListItemVO r16, final boolean r17) {
        Intrinsics.checkNotNullParameter(r12, "hybridListId");
        Intrinsics.checkNotNullParameter(r16, "itemModel");
        HybridPageCardPresenter.e0(this.a, new HybridPageCardPresenter$pageCardEventListener$1$hybridListCardAppeared$1(this, r12, r13, r14, r15, r16, r17));
    }
}
