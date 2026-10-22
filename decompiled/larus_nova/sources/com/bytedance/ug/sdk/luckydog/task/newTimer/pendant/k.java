package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements ym7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, CopyOnWriteArrayList<ym7.f>> f272140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<ym7.e> f272141b;

    public static final class a {
    }

    static {
    }

    public k() {
        this.f272140a = new ConcurrentHashMap();
        this.f272141b = new CopyOnWriteArraySet();
    }

    @Override // ym7.g
    public final void a(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantRuleService", "notifyRuleChanged() called; ruleId = ".concat(r100));
        CopyOnWriteArrayList<ym7.f> r101 = this.f272140a.get(r100);
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        ym7.f r103 = (ym7.f) r102.next();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantRuleService", "notifyRuleChanged() 执行回调onRuleChanged ruleId = ".concat(r100));
        r103.d(r100);
        goto L6
    L11:
        return;
    L8:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantRuleService", "notifyRuleChanged() list为空了 ruleId = ".concat(r100));
    }

    @Override // ym7.g
    public final void b(ym7.e r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantRuleService", "addRule() called;");
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f272141b.contains(r100) == true) goto L9;
        this.f272141b.add(r100);
        return;
    }

    @Override // ym7.g
    public final List<ym7.e> d(List<String> r100) {
        ArrayList r101 = new ArrayList();
        if (r100.isEmpty() == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return r101;
    L8:
        Iterator<ym7.e> r103 = this.f272141b.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        ym7.e r104 = r103.next();
        if (r100.contains(r104.getRuleId()) == false) goto L10;
        r101.add(r104);
        goto L10
    L14:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    @Override // ym7.g
    public final void e(ym7.f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<String, CopyOnWriteArrayList<ym7.f>>> r101 = this.f272140a.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, CopyOnWriteArrayList<ym7.f>> r102 = r101.next();
        if (r102.getValue().contains(r100) == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantRuleService", "removeListener() rule对应的list中移除；rule = " + r102.getKey());
        r102.getValue().remove(r100);
        goto L6
    }

    @Override // ym7.g
    public final void c(ym7.f r100, List<String> r101) {
        if (r101.isEmpty() == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L21;
        if (r100 == null) goto L30;
        Iterator<String> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L31;
        String r104 = r103.next();
        if (this.f272140a.containsKey(r104) == true) goto L14;
        CopyOnWriteArrayList<ym7.f> r105 = new CopyOnWriteArrayList();
        r105.add(r100);
        this.f272140a.put(r104, r105);
        goto L11
    L14:
        CopyOnWriteArrayList<ym7.f> r106 = this.f272140a.get(r104);
        if (r106 != null) goto L18;
        r106 = new CopyOnWriteArrayList();
        this.f272140a.put(r104, r106);
    L18:
        if (r106.contains(r100) == true) goto L11;
        r106.add(r100);
        this.f272140a.put(r104, r106);
        goto L11
    L31:
        return;
    L30:
        return;
    L21:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
