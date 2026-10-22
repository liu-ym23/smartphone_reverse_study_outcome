package com.bytedance.android.window.shop.holder;

import android.view.View;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ WindowHotsaleLoadMoreHolder.ShopWindowLoadMorePresenter a;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ sq3.e b;

        public a(b r1, sq3.e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.i0(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(WindowHotsaleLoadMoreHolder.ShopWindowLoadMorePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        int r0 = rp.a.a;
        if (rp.a.a(r7.getId()) == false) goto L5;
        return;
    L5:
        sq3.e r1 = this.a.l;
        if (r1 == null) goto L19;
        int r2 = r1.k.size();
        if (r2 != 0) goto L11;
        List<? extends sq3.b> r3 = CollectionsKt.emptyList();
    L18:
        if (r3 == null) goto L19;
    L21:
        if (r3.isEmpty() == false) goto L23;
        return;
    L23:
        WindowHotsaleLoadMoreHolder.ShopWindowLoadMorePresenter r4 = this.a;
        sq3.e r5 = r4.l;
        if (r5 == null) goto L26;
        int r6 = WindowTabEventReporter.a;
        ECWindowViewModel r8 = r4.d0();
        ECWindowParam r9 = r4.d0().getShopParam();
        int r10 = r5.l;
        Intrinsics.checkNotNullParameter(r8, "reporter");
        Intrinsics.checkNotNullParameter(r9, "shopParam");
        WindowTabEventReporter.f(r8, r9, Integer.valueOf(r10), "live_top_list_more_click");
    L26:
        sq3.e r11 = this.a.l;
        if (r11 != null) goto L30;
        return;
    L30:
        if ((!r11.k.isEmpty()) == true) goto L34;
        WindowHotsaleLoadMoreHolder.b r12 = this.a.j;
        if (r12 == null) goto L42;
        r12.b(r11, r3);
        return;
    L42:
        return;
    L34:
        WindowHotsaleLoadMoreHolder.b r13 = this.a.j;
        if (r13 == null) goto L38;
        r13.a(r3);
    L38:
        if (((Number) this.a.n.getValue()).longValue() <= 0) goto L40;
        r7.postDelayed(new a(this, r11), ((Number) this.a.n.getValue()).longValue());
        return;
    L40:
        this.a.i0(r11);
        return;
    L11:
        if (r1.j.isEmpty() == false) goto L13;
        int r14 = Integer.MAX_VALUE;
    L14:
        if (r2 < r14) goto L16;
        List<? extends sq3.b> r15 = r1.k.subList(0, r14);
        List<? extends sq3.b> r16 = r1.k;
        r1.k = r16.subList(r14, r16.size());
    L17:
        r3 = r15;
        goto L18
    L16:
        r15 = CollectionsKt.toList(r1.k);
        r1.k.clear();
        goto L17
    L13:
        r14 = ((Number) ListProtector.remove(r1.j, 0)).intValue();
    L19:
        r3 = CollectionsKt.emptyList();
        goto L21
    }
}
