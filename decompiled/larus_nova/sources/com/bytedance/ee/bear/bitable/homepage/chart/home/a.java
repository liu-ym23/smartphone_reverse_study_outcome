package com.bytedance.ee.bear.bitable.homepage.chart.home;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.homepage.chart.c;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.bytedance.ee.bear.bitable.homepage.chart.g;
import com.bytedance.ee.bear.bitable.homepage.chart.k;
import com.larksuite.framework.thread.CoreThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f212496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayoutManager f212497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView.Adapter<?> f212498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f212499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f212500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f212501f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.homepage.chart.home.a$a, reason: collision with other inner class name */
    public static final class C3048a {
    }

    static {
    }

    public final void c() {
        if (this.f212499d != null) goto L5;
    L11:
        boolean r100 = false;
    L12:
        if (r100 == false) goto L15;
        return;
    L15:
        throw new IllegalStateException("You must attach correct RecyclerView first");
    L5:
        if (this.f212496a == null) goto L11;
        if (this.f212498c == null) goto L11;
        if (this.f212497b == null) goto L11;
        r100 = true;
        goto L12
    }

    public a() {
        this.f212500e = "";
        this.f212501f = "";
    }

    public static final void a(a r110) {
        r110.c();
        LinearLayoutManager r100 = r110.f212497b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r100 = null;
    L5:
        int r101 = r100.findFirstCompletelyVisibleItemPosition();
        LinearLayoutManager r102 = r110.f212497b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r102 = null;
    L8:
        IntRange r103 = new IntRange(r101, r102.findLastCompletelyVisibleItemPosition());
        ArrayList r104 = new ArrayList();
        Iterator<Integer> r105 = r103.iterator();
    L9:
        boolean r106 = false;
        if (r105.hasNext() == false) goto L21;
        Integer r107 = r105.next();
        int r108 = r107.intValue();
        if (r108 < 0) goto L19;
        RecyclerView.Adapter<?> r109 = r110.f212498c;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r109 = null;
    L17:
        if (r108 >= r109.getItemCount()) goto L19;
        r106 = true;
    L19:
        if (r106 == false) goto L9;
        r104.add(r107);
        goto L9
    L21:
        ArrayList r111 = new ArrayList();
        Iterator r112 = r104.iterator();
    L23:
        if (r112.hasNext() == false) goto L30;
        int r113 = ((Number) r112.next()).intValue();
        k r114 = r110.f212499d;
        if (r114 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("entityProvider");
        r114 = null;
    L27:
        ChartEntity r115 = r114.x2(r113);
        if (r115 == null) goto L23;
        r111.add(r115);
        goto L23
    L30:
        ArrayList r116 = new ArrayList();
        Iterator r117 = r111.iterator();
    L32:
        if (r117.hasNext() == false) goto L37;
        Object r118 = r117.next();
        if ((!((ChartEntity) r118).getHasExposed()) == false) goto L32;
        r116.add(r118);
        goto L32
    L37:
        if ((!r116.isEmpty()) == false) goto L69;
        Iterator r119 = r116.iterator();
    L40:
        if (r119.hasNext() == false) goto L42;
        ChartEntity r120 = (ChartEntity) r119.next();
        r120.setHasExposed(true);
        int r121 = c.f212424a;
        String r122 = r110.f212500e;
        String r123 = r110.f212501f;
        Intrinsics.checkNotNullParameter(r120, "entity");
        CoreThreadPool.getBackgroundHandler().post(new g(r120, r122, r123, null));
        goto L40
    L42:
        LinearLayoutManager r124 = r110.f212497b;
        if (r124 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r124 = null;
    L45:
        int r125 = r124.findFirstVisibleItemPosition();
        LinearLayoutManager r126 = r110.f212497b;
        if (r126 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r126 = null;
    L48:
        int r127 = r126.findLastVisibleItemPosition();
        int r128 = 0;
    L49:
        if (r128 >= r125) goto L57;
        k r129 = r110.f212499d;
        if (r129 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("entityProvider");
        r129 = null;
    L53:
        ChartEntity r130 = r129.x2(r128);
        if (r130 == null) goto L56;
        r130.setHasExposed(false);
    L56:
        r128 = r128 + 1;
        goto L49
    L57:
        int r131 = r127 + 1;
        RecyclerView.Adapter<?> r132 = r110.f212498c;
        if (r132 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r132 = null;
    L60:
        int r133 = r132.getItemCount();
    L61:
        if (r131 >= r133) goto L92;
        k r134 = r110.f212499d;
        if (r134 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("entityProvider");
        r134 = null;
    L65:
        ChartEntity r135 = r134.x2(r131);
        if (r135 == null) goto L68;
        r135.setHasExposed(false);
    L68:
        r131 = r131 + 1;
        goto L61
    L92:
        return;
    }

    public static final void b(a r100) {
        r100.c();
        RecyclerView.Adapter<?> r101 = r100.f212498c;
        RecyclerView r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L6:
        if (r101.getItemCount() <= 0) goto L14;
        RecyclerView r103 = r100.f212496a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L12:
        r102.post(new b(r100));
        return;
    L11:
        r102 = r103;
        goto L12
    }
}
