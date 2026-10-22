package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.anchorv3.PdpTaskManager;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.shopping.utils.d0;
import com.facebook.imagepipeline.common.Priority;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/product/DetailImagePreloader;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailImagePreloader extends RecyclerView.OnScrollListener {
    public int a;
    public ProductDetailInfoAdapter b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final Lazy f;

    public static final class a implements Runnable {
        public final /* synthetic */ com.bytedance.android.ecom.arch.slice.g a;

        public a(com.bytedance.android.ecom.arch.slice.g r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map r0 = this.a.getData();     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            Object r1 = r0.get("url");     // Catch: Throwable -> L10
            if (r1 == null) goto L17;
            String r2 = r1.toString();     // Catch: Throwable -> L10
            if (r2 == null) goto L18;
            int r3 = com.bytedance.android.ec.core.imagex.r.h;     // Catch: Throwable -> L10
            ImageExtensionsKt.B(r2, com.bytedance.android.ec.core.imagex.r.a.a("ec_product_detail_image"), null, null, Priority.MEDIUM, null, null, false, 192);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public DetailImagePreloader(com.bytedance.android.ec.core.anchorv3.n r2) {
        Intrinsics.checkNotNullParameter(r2, "settingV2");
        if (r2.c() != 0) goto L5;
        boolean r0 = true;
    L6:
        this.c = r0;
        this.d = r2.a();
        this.e = PdpPerfOpt.b().b();
        this.f = LazyKt.lazy(DetailImagePreloader$detailImagePreloadMap$2.INSTANCE);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super.onScrollStateChanged(r3, r4);
        if (r4 == 0) goto L5;
        return;
    L5:
        if (this.c == true) goto L9;
        j(r3, this.a, this.e, this.d);
        return;
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = r4;
        if (this.c == false) goto L6;
        j(r2, r4, this.e, this.d);
        return;
    }

    public final void j(RecyclerView r9, int r10, int r11, boolean r12) {
        RecyclerView.LayoutManager r13 = r9.getLayoutManager();
        if ((r13 instanceof StaggeredGridLayoutManager) == true) goto L5;
        r13 = null;
    L5:
        StaggeredGridLayoutManager r14 = (StaggeredGridLayoutManager) r13;
        if (r14 != null) goto L9;
        return;
    L9:
        if (r10 <= 0) goto L11;
        int[] r2 = d0.a;
        r14.findLastVisibleItemPositions(r2);
        int r15 = r2[0];
    L14:
        if (r15 < 0) goto L41;
        int r3 = 0;
    L16:
        if (r3 >= r11) goto L51;
        if (r10 <= 0) goto L20;
        int r4 = (r15 + r3) + 1;
    L22:
        if (((Set) this.f.getValue()).contains(Integer.valueOf(r4)) == true) goto L40;
        ((Set) this.f.getValue()).add(Integer.valueOf(r4));
        ProductDetailInfoAdapter r5 = this.b;
        if (r5 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L27:
        Object r6 = CollectionsKt.getOrNull(r5.getCurrentList(), r4);
        if ((r6 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L30;
        r6 = null;
    L30:
        com.bytedance.android.ecom.arch.slice.g r7 = (com.bytedance.android.ecom.arch.slice.g) r6;
        if (r7 == null) goto L52;
        String r8 = r7.getSliceId();
        if (r8 == null) goto L49;
        if (StringsKt.startsWith$default(r8, "detail_image", false, 2, null) != true) goto L50;
        a r16 = new a(r7);
        if (r12 == false) goto L39;
        PdpTaskManager.l.getClass();
        PdpTaskManager.k.post(r16);
        goto L40
    L39:
        r16.run();
        goto L40
    L50:
        return;
    L49:
        return;
    L52:
        return;
    L40:
        r3 = r3 + 1;
        goto L16
    L20:
        r4 = (r15 - r3) - 1;
        goto L22
    L51:
        return;
    L41:
        return;
    L11:
        if (r10 >= 0) goto L13;
        int[] r17 = d0.a;
        r14.findFirstVisibleItemPositions(r17);
        r15 = r17[0];
        goto L14
    L13:
        r15 = -1;
        goto L14
    }
}
