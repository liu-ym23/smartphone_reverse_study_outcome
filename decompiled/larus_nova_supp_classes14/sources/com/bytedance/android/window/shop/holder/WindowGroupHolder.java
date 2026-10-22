package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowGroupHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "A", "B", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/n;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowGroupHolder<A extends f, B extends f> extends ShopWindowItemHolder<n> implements IECLynxCardLifeCycle {
    public final Lazy q;
    public final Lazy r;
    public final ShopWindowItemHolder<A> s;
    public final ShopWindowItemHolder<B> t;

    public final void createViewDuration(long r1) {
    }

    public final void onCreateKitViewEnd(long r1) {
    }

    public final void onDestroy() {
    }

    public final void onFirstScreen() {
    }

    public final void onLoadStart() {
    }

    public final void onLoadSuccess() {
    }

    public final void onPreCreateView(boolean r1) {
    }

    public final void onRealSuccess() {
    }

    public final void onReceivedError(com.bytedance.lynx.service.model.b r1) {
    }

    public final void onRuntimeReady() {
    }

    public final void onTimingSetup(Map<String, ? extends Object> r1) {
    }

    public final void onTimingSetupPref(k r1) {
    }

    public final void onTimingUpdatePref(k r1) {
    }

    public final void onTransDataTime(long r1, long r3) {
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        if (this.s.s4() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.t.s4() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void t4() {
        this.s.t4();
        this.t.t4();
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r4) {
        n r5 = (n) r4;
        Intrinsics.checkNotNullParameter(r5, "vo");
        ShopWindowItemHolder<A> r1 = this.s;
        f r2 = r5.k;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "vo");
        r1.q4(r2);
        ShopWindowItemHolder<B> r3 = this.t;
        f r6 = r5.l;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "vo");
        r3.q4(r6);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r7) {
        StaggeredGridLayoutManager.LayoutParams r8 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r8 == null) goto L13;
        int r9 = r8.getSpanIndex();
        if (s4() == false) goto L8;
        return new Rect(d.a(12), 0, d.a(12), d.a(8));
    L8:
        if ((r9 % 2) != 1) goto L11;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(12), d.a(9));
    L11:
        return new Rect(d.a(12), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    public final void u4(WindowLayoutType r5) {
        Intrinsics.checkNotNullParameter(r5, "layoutType");
        ShopWindowItemHolder<A> r0 = this.s;
        ShopWindowItemHolder<B> r2 = null;
        if ((r0 instanceof WindowGroupHolder) == true) goto L5;
        r0 = null;
    L5:
        WindowGroupHolder r1 = (WindowGroupHolder) r0;
        if (r1 == null) goto L8;
        r1.u4(r5);
    L8:
        ShopWindowItemHolder<B> r3 = this.t;
        if ((r3 instanceof WindowGroupHolder) == false) goto L12;
        r2 = r3;
    L12:
        WindowGroupHolder r4 = (WindowGroupHolder) r2;
        if (r4 == null) goto L15;
        r4.u4(r5);
    L15:
        Iterator r6 = ((List) this.q.getValue()).iterator();
    L17:
        if (r6.hasNext() == false) goto L20;
        WindowLynxHolder r7 = (WindowLynxHolder) r6.next();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r7.w = r5;
        goto L17
    L20:
        if (((List) this.r.getValue()).isEmpty() == true) goto L66;
        List r8 = (List) this.r.getValue();
        boolean r9 = false;
        if ((r8 instanceof Collection) == true) goto L25;
    L27:
        Iterator r10 = r8.iterator();
    L29:
        if (r10.hasNext() == false) goto L33;
        if (((ShopWindowItemHolder) r10.next()).s4() == false) goto L29;
        boolean r11 = false;
    L34:
        if (r11 == false) goto L39;
        Iterator r12 = ((List) this.q.getValue()).iterator();
    L37:
        if (r12.hasNext() == false) goto L67;
        WindowLynxHolder r13 = (WindowLynxHolder) r12.next();
        WindowLayoutType r14 = WindowLayoutType.DOUBLECOLUMN;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.w = r14;
        goto L37
    L67:
        return;
    L39:
        List r15 = (List) this.r.getValue();
        if ((r15 instanceof Collection) == true) goto L42;
    L44:
        Iterator r16 = r15.iterator();
    L46:
        if (r16.hasNext() == false) goto L50;
        if (((ShopWindowItemHolder) r16.next()).s4() == true) goto L46;
    L51:
        if (r9 == false) goto L56;
        Iterator r17 = ((List) this.q.getValue()).iterator();
    L54:
        if (r17.hasNext() == false) goto L68;
        WindowLynxHolder r18 = (WindowLynxHolder) r17.next();
        WindowLayoutType r19 = WindowLayoutType.SINGLECOLUMN;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.w = r19;
        goto L54
    L68:
        return;
    L56:
        return;
    L50:
        r9 = true;
        goto L51
    L42:
        if (r15.isEmpty() == false) goto L44;
    L33:
        r11 = true;
        goto L34
    L25:
        if (r8.isEmpty() == false) goto L27;
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    public WindowGroupHolder(ShopWindowItemHolder<A> r5, ShopWindowItemHolder<B> r6) {
        Intrinsics.checkNotNullParameter(r5, "firstHolder");
        Intrinsics.checkNotNullParameter(r6, "secondHolder");
        LinearLayout r0 = new LinearLayout(((RecyclerView.ViewHolder) r5).itemView.getContext());
        r0.setOrientation(1);
        r0.addView(((RecyclerView.ViewHolder) r5).itemView);
        r0.addView(new View(((RecyclerView.ViewHolder) r5).itemView.getContext()), 0, d.a(9));
        r0.addView(((RecyclerView.ViewHolder) r6).itemView);
        Unit r1 = Unit.INSTANCE;
        super(r0);
        this.s = r5;
        this.t = r6;
        this.q = LazyKt.lazy(new WindowGroupHolder$lynxHolders$2(this));
        this.r = LazyKt.lazy(new WindowGroupHolder$nativeHolders$2(this));
    }

    public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }
}
