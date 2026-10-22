package com.bytedance.android.window.shop.widget.holderprocessor;

import com.bytedance.android.ec.hybrid.list.ability.q;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.window.shop.holder.WindowHybridToolBarHolder;
import com.bytedance.android.window.shop.home.tab.presenter.ECWindowLynxMonitorHolder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public boolean a;
    public final ConcurrentHashMap<BaseViewHolder, com.bytedance.android.window.shop.widget.holderprocessor.a> b;
    public final List<Integer> c;
    public final Set<Class<WindowHybridToolBarHolder>> d;
    public final b e;
    public final a f;

    public static final class a extends q {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void a(final BaseViewHolder r3, ECHybridListItemVO r4) {
            Intrinsics.checkNotNullParameter(r3, "holder");
            final d r5 = this.a;
            r5.getClass();
            if ((r3 instanceof ECWindowLynxMonitorHolder) == false) goto L5;
            ECWindowLynxMonitorHolder r0 = (ECWindowLynxMonitorHolder) r3;
            Function3<Long, Long, Map<String, ? extends String>, Unit> r1 = new WindowHybridCardPerformanceMonitor$postProcess$1(r5, r3);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "listener");
            r0.X = r1;
            return;
        L5:
            com.bytedance.android.window.shop.widget.holderprocessor.a r6 = r5.b.get(r3);
            if (r6 == null) goto L10;
            r6.b = System.currentTimeMillis();
            return;
        }
    }

    public static final class b extends q {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void a(BaseViewHolder r12, ECHybridListItemVO r13) {
            Intrinsics.checkNotNullParameter(r12, "holder");
            d r0 = this.a;
            if (CollectionsKt.contains(r0.d, r12.getClass()) == true) goto L11;
            ConcurrentHashMap<BaseViewHolder, com.bytedance.android.window.shop.widget.holderprocessor.a> r1 = r0.b;
            long r2 = System.currentTimeMillis();
            boolean r4 = r12 instanceof ECLynxCardHolder;
            Integer r5 = Integer.valueOf(r12.getLayoutPosition());
            if (r13 == null) goto L8;
            Integer r14 = r13.c;
        L9:
            r1.put(r12, new com.bytedance.android.window.shop.widget.holderprocessor.a(r2, r4, r5, false, -1, r14));
            return;
        L8:
            r14 = null;
            goto L9
        }
    }

    public d() {
        this.a = true;
        this.b = new ConcurrentHashMap();
        new LinkedHashMap();
        this.c = new ArrayList();
        this.d = SetsKt.setOf(WindowHybridToolBarHolder.class);
        this.e = new b(this);
        this.f = new a(this);
    }
}
