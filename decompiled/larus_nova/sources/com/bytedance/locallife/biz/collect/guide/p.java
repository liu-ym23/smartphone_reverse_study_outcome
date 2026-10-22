package com.bytedance.locallife.biz.collect.guide;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class p implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f256618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, HashSet<String>> f256619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<String> f256620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l<k> f256621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<l<k>> f256622f;

    @Override // com.bytedance.locallife.biz.collect.guide.n
    public final int c() {
        return this.f256618b;
    }

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "poiPageId");
        this.f256617a = r100;
        this.f256619c = new HashMap();
        this.f256620d = new HashSet();
        this.f256622f = new LinkedList();
    }

    @Override // com.bytedance.locallife.biz.collect.guide.n
    public final void a(l<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "goodsView");
        this.f256622f.remove(r100);
        if (this.f256622f.isEmpty() == false) goto L5;
        l<k> r101 = null;
    L6:
        this.f256621e = r101;
        return;
    L5:
        r101 = this.f256622f.getLast();
        goto L6
    }

    @Override // com.bytedance.locallife.biz.collect.guide.n
    public final void b(l<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "goodsView");
        k r101 = r100.c();
        if (r101 == null) goto L15;
        HashSet<String> r102 = this.f256619c.get(r101.f256607b);
        if (r102 != null) goto L7;
        r102 = new HashSet();
    L7:
        String r103 = r101.f256606a;
        if (r103 == null) goto L10;
        r102.add(r103);
    L10:
        this.f256619c.put(r101.f256607b, r102);
        String r104 = r101.f256607b;
        if (r104 == null) goto L13;
        this.f256620d.add(r104);
    L13:
        this.f256622f.add(r100);
        this.f256621e = r100;
        return;
    }

    @Override // com.bytedance.locallife.biz.collect.guide.n
    public final String d(CollectGuideInfo r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f256620d.size() < r100.getPoiTriggerTimes()) goto L9;
        return "repeat_show";
    L9:
        HashSet<String> r102 = this.f256619c.get(r101);
        if (r102 == null) goto L12;
        int r103 = r102.size();
    L14:
        if (r103 < r100.getPoiTriggerTimes()) goto L17;
        return "multi_show";
    L17:
        return null;
    L12:
        r103 = 0;
        goto L14
    }

    @Override // com.bytedance.locallife.biz.collect.guide.n
    public final void e(String r100, CollectGuideInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "collectInfo");
        CollectGuideFrequencyInfo r102 = r101.getFrequencyInfo();
        boolean r103 = false;
        if (r102 == null) goto L9;
        SortRuleGuide r104 = r102.getSortRuleGuide();
        if (r104 == null) goto L9;
        if (r104.getCrossPoi() != 1) goto L9;
        r103 = true;
    L9:
        if (r103 == false) goto L12;
        this.f256618b++;
        return;
    }
}
