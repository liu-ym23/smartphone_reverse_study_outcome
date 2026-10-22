package fm7;

import com.google.gson.Gson;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zm7.h;
import zm7.i;
import zm7.j;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<i>> f477832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, h> f477833b;

    public static final class a {
    }

    static {
    }

    public g() {
        this.f477832a = new ConcurrentHashMap();
        this.f477833b = new ConcurrentHashMap();
    }

    @Override // zm7.j
    public final void c(String r100) {
        Gson r101 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "notifyRuleMatch onCall", MapsKt.mapOf(TuplesKt.to(ControlRule.KEY_RULE_ID, r100)), null);
        List<i> r102 = this.f477832a.get(r100);
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        i r104 = (i) r103.next();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTimerRuleService", "notifyRuleMatch() 执行回调matchRule ruleId = ".concat(r100));
        r104.b(r100);
        goto L6
    L11:
        return;
    L8:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTimerRuleService", "notifyRuleMatch() list为空了 ruleId = ".concat(r100));
    }

    @Override // zm7.j
    public final void d(i r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, List<i>>> r102 = this.f477832a.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, List<i>> r103 = r102.next();
        String r104 = r103.getKey();
        List<i> r105 = r103.getValue();
        ArrayList r106 = new ArrayList();
        Iterator<i> r107 = r105.iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        i r108 = r107.next();
        if (Intrinsics.areEqual(r108, r100) == false) goto L9;
        r106.add(r108);
        goto L9
    L13:
        r105.removeAll(CollectionsKt.toSet(r106));
        if (r105.isEmpty() == false) goto L6;
        r101.add(r104);
        goto L6
    L16:
        Iterator r109 = r101.iterator();
    L18:
        if (r109.hasNext() == false) goto L20;
        String r110 = (String) r109.next();
        this.f477832a.remove(r110);
        goto L18
    }

    @Override // zm7.j
    public final void e(String r100) {
        Gson r101 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "notifyRuleDisMatch onCall", MapsKt.mapOf(TuplesKt.to(ControlRule.KEY_RULE_ID, r100)), null);
        List<i> r102 = this.f477832a.get(r100);
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        i r104 = (i) r103.next();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTimerRuleService", "notifyRuleDisMatch() 执行回调disMatchRule ruleId = ".concat(r100));
        r104.e(r100);
        goto L6
    L11:
        return;
    L8:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTimerRuleService", "notifyRuleDisMatch() list为空了 ruleId = ".concat(r100));
    }

    @Override // zm7.j
    public final void a(String r100, h r101) {
        if (r101 == null) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTimerRuleService", "addRealRule() called;");
        if (this.f477833b.containsKey(r100) == true) goto L8;
        this.f477833b.put(r100, r101);
    L8:
        if (r101.b() == false) goto L11;
        c(r100);
        return;
    L11:
        return;
    }

    @Override // zm7.j
    public final ConcurrentLinkedQueue<String> b(i r100, List<String> r101) {
        if (r100 == null) goto L4;
        ConcurrentLinkedQueue<String> r102 = new ConcurrentLinkedQueue();
        List<String> r103 = r101;
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTimerRuleService", "addTimerHelperListener() ruleIds为空了");
        return r102;
    L15:
        Iterator<String> r105 = r101.iterator();
    L17:
        if (r105.hasNext() == false) goto L34;
        String r106 = r105.next();
        ConcurrentHashMap<String, List<i>> r107 = this.f477832a;
        List<i> r108 = r107.get(r106);
        if (r108 != null) goto L24;
        r108 = CollectionsKt.mutableListOf(new i[]{r100});
        List<i> r109 = r107.putIfAbsent(r106, r108);
        if (r109 == null) goto L24;
        r108 = r109;
    L24:
        List<i> r110 = r108;
        if (r110.contains(r100) == true) goto L28;
        r110.add(r100);
    L28:
        if (this.f477833b.containsKey(r106) == false) goto L17;
        h r111 = this.f477833b.get(r106);
        if (r111 == null) goto L17;
        if (r111.b() != true) goto L17;
        r102.add(r106);
        goto L17
    L34:
        return r102;
    L8:
        if (r103.isEmpty() == true) goto L11;
        r104 = false;
        goto L12
    L4:
        return new ConcurrentLinkedQueue();
    }
}
