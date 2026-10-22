package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.lifecycle.ECStorePerfMonitor;
import com.bytedance.android.shopping.store.lifecycle.g;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECShopBaseHolder extends BaseViewHolder {
    public final List<Runnable> o;
    public final ECStoreViewModel p;

    public static final class a implements Runnable {
        public final /* synthetic */ ECShopBaseHolder a;

        public a(ECShopBaseHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p.getFirstScreenConfig().b = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECShopBaseHolder a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ String c;

        public b(ECShopBaseHolder r1, Object r2, String r3, k.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.q4(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECShopBaseHolder a;

        public c(ECShopBaseHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECShopBaseHolder r0 = this.a;     // Catch: Throwable -> L8
            ECHybridListAdapter r1 = ((BaseViewHolder) r0).g;     // Catch: Throwable -> L8
            if (r1 == null) goto L11;
            Map<Long, m> r2 = com.bytedance.android.shopping.store.lifecycle.a.a;     // Catch: Throwable -> L8
            m r3 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r0.p.getStoreParam().getLifecycleMonitorId()));     // Catch: Throwable -> L8
            if (r3 == null) goto L15;
            r3.S(this.a.getAdapterPosition(), r1);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public boolean C3() {
        return false;
    }

    public abstract void q4(Object r1, String r2);

    public ECShopBaseHolder(View r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(r2);
        this.p = r3;
        this.o = Collections.synchronizedList(new ArrayList());
    }

    public final void b4(Object r10, String r11, k.a r12) {
        Intrinsics.checkNotNullParameter(r11, "itemId");
        Integer r1 = null;
        if ((r10 instanceof com.bytedance.android.ec.store.window.b) == true) goto L95;
        super.b4(r10, r11, r12);
        ECStoreTabAreaVO r0 = (ECStoreTabAreaVO) this.p.getTabArea().getValue();
        if (r0 == null) goto L7;
        r1 = r0.c;
    L7:
        int r2 = TabEnum.PRODUCT_TAB.getType();
        boolean r3 = false;
        if (r1 != null) goto L11;
    L53:
        this.p.getFirstScreenConfig().b = false;
    L54:
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.c() == false) goto L64;
        if (this.p.getFirstScreenConfig().c <= 0) goto L59;
    L68:
        if (r3 == true) goto L70;
        q4(r10, r11);
    L72:
        if (ECShopABSettings.c() == true) goto L74;
        this.p.getFirstScreenConfig().c--;
    L78:
        if (this.p.getFirstScreenConfig().c != 0) goto L83;
        Map<Long, m> r13 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r4 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.p.getStoreParam().getLifecycleMonitorId()));
        if (r4 == null) goto L83;
        ECStoreViewModel r5 = this.p;
        com.bytedance.android.shopping.store.lifecycle.c.a.h(r4, r5, r5.getFirstScreenConfig().d, this.p.getStoreParam(), null, null, 56);
    L83:
        if (this.p.getFirstScreenConfig().c <= 0) goto L85;
        this.o.add(new c(this));
        return;
    L85:
        Iterator<Runnable> r14 = this.o.iterator();
    L87:
        if (r14.hasNext() == false) goto L89;
        r14.next().run();
        goto L87
    L89:
        this.o.clear();
        ECHybridListAdapter r15 = ((BaseViewHolder) this).g;
        if (r15 == null) goto L99;
        Map<Long, m> r16 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r17 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.p.getStoreParam().getLifecycleMonitorId()));
        if (r17 == null) goto L100;
        r17.S(getAdapterPosition(), r15);
        return;
    L100:
        return;
    L99:
        return;
    L74:
        if ((this instanceof d) == false) goto L78;
        this.p.getFirstScreenConfig().c--;
        goto L78
    L70:
        ((RecyclerView.ViewHolder) this).itemView.post(new b(this, r10, r11, r12));
        goto L72
    L59:
        if (this.p.getFirstScreenConfig().b == false) goto L68;
        if ((this instanceof d) == false) goto L68;
    L67:
        r3 = true;
        goto L68
    L64:
        if (this.p.getFirstScreenConfig().c > 0) goto L68;
        if (this.p.getFirstScreenConfig().b == false) goto L68;
    L11:
        if (r1.intValue() != r2) goto L53;
        if (this.p.getFirstScreenConfig().a == false) goto L54;
        com.bytedance.android.shopping.store.viewmodel.c r6 = this.p.getFirstScreenConfig();
        ECShopABSettings.k.getClass();
        int r7 = 3;
        if (ECShopABSettings.c() == false) goto L32;
        boolean r8 = this.p.headerLiveDefaultShow();
        boolean r9 = Intrinsics.areEqual(this.p.isFlagShip(), Boolean.TRUE);
        if (this.p.getFirstScreenConfig().f != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L19;
        boolean r18 = true;
    L20:
        if (r18 == false) goto L25;
        if (r9 == false) goto L24;
        if (r8 == true) goto L26;
    L28:
        if (r18 == true) goto L31;
        r7 = r7 * 2;
    L31:
        int r19 = RangesKt.coerceAtMost(r7, RangesKt.coerceAtLeast(this.p.getFirstScreenConfig().e, 0));
    L47:
        r6.c = r19;
        ECStorePerfMonitor r20 = this.p.getPerfMonitor();
        if (r20 == null) goto L52;
        g r21 = r20.k;
        if (r21 == null) goto L52;
        r21.d = this.p.getFirstScreenConfig().c;
    L52:
        this.p.getFirstScreenConfig().a = false;
        ((RecyclerView.ViewHolder) this).itemView.post(new a(this));
    L26:
        r7 = 1;
        goto L28
    L24:
        r7 = 4;
        goto L28
    L25:
        if (r8 == true) goto L26;
        r7 = 2;
        goto L28
    L19:
        r18 = false;
        goto L20
    L32:
        boolean r22 = this.p.headerLiveDefaultShow();
        if (this.p.getFirstScreenConfig().f != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L35;
        boolean r23 = true;
    L36:
        if (r22 == false) goto L39;
        if (r23 == false) goto L39;
    L46:
        r19 = RangesKt.coerceAtMost(r7, RangesKt.coerceAtLeast(this.p.getFirstScreenConfig().e, 1));
    L39:
        if (r22 == false) goto L42;
        if (r23 == true) goto L42;
    L44:
        r7 = 4;
    L42:
        if (r22 == true) goto L45;
        if (r23 == true) goto L44;
    L45:
        r7 = 5;
        goto L46
    L35:
        r23 = false;
        goto L36
    L95:
        ((com.bytedance.android.ec.store.window.b) r10).getClass();
        throw null;
    }
}
