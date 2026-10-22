package com.bytedance.android.shopping.store.moments.holder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.moments.dto.card.ShortVideoDTO;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import jj3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/holder/ECStoreShortVideoViewHolderNew;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreShortVideoViewHolderNew extends BaseViewHolder {
    public static final /* synthetic */ int s = 0;
    public final QUIManager o;
    public final View p;
    public final com.bytedance.android.shopping.store.moments.a q;
    public final ViewGroup r;

    public static final class a {
    }

    static {
    }

    public final boolean C3() {
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.C3());
    L7:
        return k.i(r1);
    L5:
        r1 = null;
        goto L7
    }

    public final void D() {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.IDLE;
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L6;
        r0.D();
        return;
    }

    public final void onHide() {
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L6;
        r0.onHide();
        return;
    }

    public final void onRelease() {
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L6;
        r0.onRelease();
        return;
    }

    public final void onShow() {
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L6;
        r0.onShow();
        return;
    }

    public final void K() {
        super.K();
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L6;
        r0.K();
        return;
    }

    public final void o() {
        super.o();
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L6;
        r0.o();
        return;
    }

    public final void D1(Long r1) {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.PLAYING;
        IHybridListViewHolder r2 = this.q.a;
        if (r2 == null) goto L6;
        IHybridListViewHolder.a.a(r2);
        return;
    }

    public final void m1(int r2, double r3) {
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L6;
        r0.m1(r2, r3);
        return;
    }

    public final void b4(Object r1, String r2, com.bytedance.android.ec.hybrid.list.entity.k.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        if ((r1 instanceof ShortVideoDTO) == true) goto L5;
        r1 = null;
    L5:
        ShortVideoDTO r4 = (ShortVideoDTO) r1;
        if (r4 != null) goto L8;
        return;
    L8:
        this.o.c(c.class, r4);
    }

    public final void g1(int r2, int r3, double r4) {
        IHybridListViewHolder r0 = this.q.a;
        if (r0 == null) goto L6;
        r0.g1(r2, r3, r4);
        return;
    }

    public ECStoreShortVideoViewHolderNew(QUIManager r2, View r3, com.bytedance.android.shopping.store.moments.a r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "shortVideoProxy");
        Intrinsics.checkNotNullParameter(r5, "parent");
        super(r3);
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
    }
}
