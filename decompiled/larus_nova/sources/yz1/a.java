package yz1;

import ay1.b;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.model.i;
import com.bytedance.android.livesdk.revenue.perf.wto.IRevWTORepeatableTask;
import com.bytedance.android.livesdk.revenue.perf.wto.WTOPriorityType;
import com.bytedance.android.livesdk.revenue.perf.wto.WTOSceneType;
import com.bytedance.android.livesdk.revenue.perf.wto.WTOThreadType;
import com.bytedance.android.livesdk.revenue.perf.wto.WTOThreadWorkType;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements IRevWTORepeatableTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f569515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f569516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<Integer> f569517c;

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final boolean cancelable() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final boolean isEffective() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final String taskBusinessInfo() {
        return "WTO-GiftListCacheTask";
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final int taskID() {
        return 2001;
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final List<Integer> taskCategoryList() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final void run() {
        Gson r100 = GsonHelper.get();
        ArrayList r101 = new ArrayList();
        w1 r102 = (w1) f.c(w1.class);
        List<? extends w1> r103 = this.f569515a.giftPages;
        boolean r104 = false;
        if (r103 == null) goto L13;
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L13;
        w1 r106 = (w1) r105.next();
        if (r106.getPageType() != 1) goto L6;
        if (r106.getDisplay() == false) goto L6;
        r101.addAll(r106.getGifts());
        com.bytedance.android.livesdk.gift.platform.core.utils.f.d(r101);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r101, false, null);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.a(r101);
        r102.setPageType(r106.getPageType());
        r102.setPageName(r106.getPageName());
        r102.setEventName(r106.getEventName());
        r102.setDisplay(r106.getDisplay());
        r102.setTopicList(r106.getTopicList());
    L13:
        if (r101.size() <= 12) goto L22;
        ArrayList r107 = new ArrayList();
        Iterator r108 = r101.iterator();
        int r109 = 0;
    L16:
        if (r108.hasNext() == false) goto L20;
        h1 r110 = (h1) r108.next();
        if (r109 > 11) goto L16;
        r107.add(r110);
        r109 = r109 + 1;
        goto L16
    L20:
        if (r102 == null) goto L24;
        r102.setGifts(r107);
    L24:
        if (r102 != null) goto L26;
        return;
    L26:
        new i().giftPages = CollectionsKt.listOf(r102);
        String r111 = GsonProtectorUtils.toJson(r100, r102);
        if (r111 != null) goto L29;
    L30:
        r104 = true;
    L31:
        if (r104 == false) goto L33;
        return;
    L33:
        com.bytedance.android.livesdk.sharedpref.f.d(new e("gift_list_response_v2_" + this.f569516b, ""), r111);
        HashSet<String> r112 = b.k();
        r112.add(String.valueOf(this.f569516b));
        b.y(r112);
        this.f569517c.add(Integer.valueOf(this.f569516b));
        return;
    L29:
        if (r111.length() != 0) goto L31;
    L22:
        if (r102 == null) goto L24;
        r102.setGifts(r101);
        goto L24
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final mq2.a taskExecutePeriod() {
        return mq2.a.C6840a.f514793b;
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final WTOPriorityType taskPriorityType() {
        return WTOPriorityType.SCHEDULE;
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTORepeatableTask
    public final WTOSceneType taskSceneType() {
        return WTOSceneType.COMMON;
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTOTask
    public final WTOThreadType taskThreadType() {
        return WTOThreadType.WorkerThread;
    }

    @Override // com.bytedance.android.livesdk.revenue.perf.wto.IRevWTORepeatableTask
    public final WTOThreadWorkType taskThreadWorkType() {
        return WTOThreadWorkType.IO;
    }

    public a(i r100, int r101, HashSet<Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r102, "cacheRoomTypeSet");
        this.f569515a = r100;
        this.f569516b = r101;
        this.f569517c = r102;
    }
}
