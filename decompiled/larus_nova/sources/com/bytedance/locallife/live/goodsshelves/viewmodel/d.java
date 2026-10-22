package com.bytedance.locallife.live.goodsshelves.viewmodel;

import android.os.SystemClock;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesDSLPagingResponse;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesResponse;
import com.bytedance.locallife.live.goodsshelves.bean.j0;
import com.bytedance.locallife.live.goodsshelves.manager.PagedCacheManager;
import com.bytedance.locallife.live.goodsshelves.manager.i;
import com.bytedance.locallife.live.goodsshelves.manager.l;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jv6.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PagedCacheManager f260490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, j0> f260491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LiveGoodsShelvesViewModel f260492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, j0> f260493d;

    public final void e() {
        Iterator r100 = ((LinkedHashMap) this.f260491b).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((j0) ((Map.Entry) r100.next()).getValue()).f259610e = false;
        goto L4
    }

    public final PagedCacheManager a() {
        h r100 = com.bytedance.locallife.live.settings.c.f();
        boolean r101 = true;
        if (r100 == null) goto L5;
        int r102 = r100.w();
    L7:
        if (r102 != 1) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L23;
        LiveGoodsShelvesViewModel r104 = this.f260492c;
        if (r104 == null) goto L18;
        i r105 = r104.getCouponMigrationInfo();
        if (r105 == null) goto L18;
        if (r105.b() != true) goto L18;
    L19:
        if (r101 == false) goto L23;
        return null;
    L18:
        r101 = false;
    L23:
        return this.f260490a;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = 1;
        goto L7
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r101 = LiveLocalLifeViewModel.Companion.a(r100);
        PagedCacheManager r102 = null;
        if (r101 == null) goto L5;
        l r103 = r101.getLiveLifeShelfCacheManager();
    L7:
        if ((r103 instanceof PagedCacheManager) == false) goto L9;
        r102 = (PagedCacheManager) r103;
    L9:
        this.f260490a = r102;
        this.f260491b = new LinkedHashMap();
        this.f260493d = new LinkedHashMap();
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final j0 b(int r100) {
        Map<Integer, j0> r101 = this.f260493d;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        j0 r103 = (j0) r102.get(Integer.valueOf(r100));
        if (r103 != null) goto L11;
        PagedCacheManager r104 = a();
        if (r104 != null) goto L7;
    L9:
        return null;
    L7:
        if (r104.c(r100) == false) goto L9;
        Map<Integer, j0> r105 = r104.f259672q;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        return (j0) r106.get(Integer.valueOf(r100));
    L11:
        return r103;
    }

    public final j0 c(Integer r100) {
        return (j0) ((LinkedHashMap) this.f260491b).get(r100);
    }

    public final boolean d(int r100) {
        Map<Integer, j0> r101 = this.f260493d;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        j0 r103 = (j0) r102.get(Integer.valueOf(r100));
        PagedCacheManager r104 = a();
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L10;
        if (r103 != null) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r104.c(r100) != true) goto L7;
        r105 = true;
        goto L8
    }

    public final void h(int r100, LiveGoodsShelvesDSLPagingResponse r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r101, "pagingResponse");
        j0 r105 = new j0(r101, r102, r103, r104);
        Integer r106 = Integer.valueOf(r100);
        this.f260493d.put(r106, r105);
        PagedCacheManager r107 = a();
        if (r107 == null) goto L12;
        Intrinsics.checkNotNullParameter(r105, "data");
        LiveGoodsShelvesResponse r108 = r105.f259606a.f259555e;
        if (r108 == null) goto L7;
        Integer r109 = Integer.valueOf(r108.getSelectedTabId());
    L8:
        if (r109 == null) goto L13;
        j0 r110 = new j0(r105.f259606a, r105.f259607b, r105.f259608c, -1);
        r107.f259672q.put(r109, r110);
        r107.f259673r.put(r109, Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L13:
        return;
    L7:
        r109 = null;
        goto L8
    }

    public static /* synthetic */ void g(d r100, int r101, LiveGoodsShelvesDSLPagingResponse r102, int r110, int r111, int r112) {
        r100.f(r101, r102, r110, r111, r112, false);
    }

    public final void f(int r100, LiveGoodsShelvesDSLPagingResponse r101, int r102, int r103, int r104, boolean r105) {
        if (r101 != null) goto L4;
        return;
    L4:
        Integer r106 = Integer.valueOf(r100);
        this.f260491b.put(r106, new j0(r101, r102, r103, r104));
        boolean r107 = true;
        if (r100 != 1) goto L7;
    L10:
        if (r107 == false) goto L15;
        if (r102 == 0) goto L13;
        if (r105 == true) goto L13;
        return;
    L13:
        h(r100, r101, r102, r103, r104);
        return;
    L15:
        return;
    L7:
        if (r100 == 5) goto L10;
        r107 = false;
        goto L10
    }
}
