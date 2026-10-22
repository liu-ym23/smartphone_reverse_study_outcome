package com.bytedance.android.window.shop.widget.holderprocessor;

import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import com.bytedance.android.window.shop.product.presenter.lynxCard.ECLynxCardPresenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public boolean a;
    public final ConcurrentHashMap<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>, com.bytedance.android.window.shop.widget.holderprocessor.a> b;
    public final b c;
    public final a d;

    public static final class a extends gr3.d {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // gr3.d
        public final void a(final ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r2, com.bytedance.android.window.shop.repository.tab.entity.f r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            Intrinsics.checkNotNullParameter(r3, "vo");
            final c r5 = this.a;
            r5.getClass();
            if ((r2 instanceof WindowLynxHolder) == false) goto L5;
            WindowLynxHolder r6 = (WindowLynxHolder) r2;
            Function2<Long, Map<String, ? extends String>, Unit> r0 = new WindowCardPerformanceMonitor$postProcess$1(r5, r2);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r0, "listener");
            ECLynxCardPresenter r7 = (ECLynxCardPresenter) r6.y.getValue();
            r7.getClass();
            Intrinsics.checkNotNullParameter(r0, "listener");
            r7.i = r0;
            return;
        L5:
            com.bytedance.android.window.shop.widget.holderprocessor.a r8 = r5.b.get(r2);
            if (r8 == null) goto L10;
            r8.b = System.currentTimeMillis();
            return;
        }
    }

    public static final class b extends gr3.d {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // gr3.d
        public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r10, com.bytedance.android.window.shop.repository.tab.entity.f r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "holder");
            Intrinsics.checkNotNullParameter(r11, "vo");
            this.a.b.put(r10, new com.bytedance.android.window.shop.widget.holderprocessor.a(System.currentTimeMillis(), r10 instanceof WindowLynxHolder, Integer.valueOf(r10.getLayoutPosition()), false, -1, null));
        }
    }

    public c() {
        this.a = true;
        this.b = new ConcurrentHashMap();
        this.c = new b(this);
        this.d = new a(this);
    }
}
