package fm7;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements zm7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<String> f477814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<zm7.a>> f477815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Float> f477816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<String>> f477817d;

    /* JADX INFO: renamed from: fm7.a$a, reason: collision with other inner class name */
    public static final class C5928a {
    }

    static {
    }

    public a() {
        this.f477814a = new ConcurrentLinkedQueue();
        this.f477815b = new ConcurrentHashMap();
        this.f477816c = new ConcurrentHashMap();
        this.f477817d = new ConcurrentHashMap();
    }

    @Override // zm7.d
    public final synchronized void a(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L25;
        monitor-exit(this);
        return;
    L25:
        em7.b.a r101 = em7.b.f473100a;     // Catch: Throwable -> L22
        List r102 = CollectionsKt.toList(this.f477815b.keySet());     // Catch: Throwable -> L22
        r101.getClass();     // Catch: Throwable -> L22
        List<String> r103 = em7.b.a.a(r100, r102, true);     // Catch: Throwable -> L22
        Gson r104 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;     // Catch: Throwable -> L22
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "enableTiming onCall", MapsKt.mapOf(new Pair[]{TuplesKt.to("action", r100), TuplesKt.to("matchActionList", r103)}), null);     // Catch: Throwable -> L22
        if ((true ^ ((ArrayList) r103).isEmpty()) == false) goto L18;
        this.f477817d.put(r100, r103);     // Catch: Throwable -> L22
        Iterator r105 = ((ArrayList) r103).iterator();     // Catch: Throwable -> L22
    L10:
        if (r105.hasNext() == false) goto L18;
        String r106 = (String) r105.next();     // Catch: Throwable -> L22
        List<zm7.a> r107 = this.f477815b.get(r106);     // Catch: Throwable -> L22
        if (r107 == null) goto L10;
        Iterator<T> r108 = r107.iterator();     // Catch: Throwable -> L22
    L15:
        if (r108.hasNext() == false) goto L10;
        ((zm7.a) r108.next()).a(r106);     // Catch: Throwable -> L22
    L18:
        if (this.f477814a.contains(r100) == true) goto L20;
        this.f477814a.add(r100);     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // zm7.d
    public final synchronized void b(float r100) {
        monitor-enter(this);
        Iterator<Map.Entry<String, Float>> r101 = this.f477816c.entrySet().iterator();     // Catch: Throwable -> L12
    L5:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, Float> r102 = r101.next();     // Catch: Throwable -> L12
        String r103 = r102.getKey();     // Catch: Throwable -> L12
        float r104 = r102.getValue().floatValue() - r100;     // Catch: Throwable -> L12
        this.f477816c.put(r103, Float.valueOf(r104));     // Catch: Throwable -> L12
        if (r104 > 0) goto L5;
        c(r103);     // Catch: Throwable -> L12
        goto L5
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // zm7.d
    public final synchronized void c(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L37;
        monitor-exit(this);
        return;
    L37:
        em7.b.a r101 = em7.b.f473100a;     // Catch: Throwable -> L34
        List r102 = CollectionsKt.toList(this.f477815b.keySet());     // Catch: Throwable -> L34
        r101.getClass();     // Catch: Throwable -> L34
        List r103 = em7.b.a.a(r100, r102, false);     // Catch: Throwable -> L34
        Gson r104 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;     // Catch: Throwable -> L34
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "disableTiming onCall", MapsKt.mapOf(TuplesKt.to("action", r100)), null);     // Catch: Throwable -> L34
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTimerActionService", "disableTiming() matchActionList before = " + r103);     // Catch: Throwable -> L34
        List<String> r105 = this.f477817d.get(r100);     // Catch: Throwable -> L34
        this.f477817d.remove(r100);     // Catch: Throwable -> L34
        if (r105 == null) goto L20;
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L34
    L11:
        if (r106.hasNext() == false) goto L20;
        String r107 = (String) r106.next();     // Catch: Throwable -> L34
        Iterator<Map.Entry<String, List<String>>> r108 = this.f477817d.entrySet().iterator();     // Catch: Throwable -> L34
        boolean r109 = true;
    L14:
        if (r108.hasNext() == false) goto L18;
        if (r108.next().getValue().contains(r107) == false) goto L14;
        r109 = false;
        goto L14
    L18:
        if (r109 == false) goto L11;
        ((ArrayList) r103).add(r107);     // Catch: Throwable -> L34
    L20:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyTimerActionService", "disableTiming() matchActionList after = " + r103);     // Catch: Throwable -> L34
        if ((!((ArrayList) r103).isEmpty()) == false) goto L31;
        Iterator r110 = ((ArrayList) r103).iterator();     // Catch: Throwable -> L34
    L24:
        if (r110.hasNext() == false) goto L31;
        String r111 = (String) r110.next();     // Catch: Throwable -> L34
        List<zm7.a> r112 = this.f477815b.get(r111);     // Catch: Throwable -> L34
        if (r112 == null) goto L24;
        Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L34
    L29:
        if (r113.hasNext() == false) goto L24;
        ((zm7.a) r113.next()).c(r111);     // Catch: Throwable -> L34
    L31:
        this.f477814a.remove(r100);     // Catch: Throwable -> L34
        this.f477816c.remove(r100);     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L34:
        th = move-exception;
        throw th;
    }

    @Override // zm7.d
    public final synchronized void e(zm7.a r100) {
        monitor-enter(this);
        if (r100 != null) goto L28;
        monitor-exit(this);
        return;
    L28:
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L25
        Iterator<Map.Entry<String, List<zm7.a>>> r102 = this.f477815b.entrySet().iterator();     // Catch: Throwable -> L25
    L8:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, List<zm7.a>> r103 = r102.next();     // Catch: Throwable -> L25
        String r104 = r103.getKey();     // Catch: Throwable -> L25
        List<zm7.a> r105 = r103.getValue();     // Catch: Throwable -> L25
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L25
        Iterator<zm7.a> r107 = r105.iterator();     // Catch: Throwable -> L25
    L11:
        if (r107.hasNext() == false) goto L15;
        zm7.a r108 = r107.next();     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r108, r100) == false) goto L11;
        r106.add(r108);     // Catch: Throwable -> L25
        goto L11
    L15:
        r105.removeAll(CollectionsKt.toSet(r106));     // Catch: Throwable -> L25
        if (r105.isEmpty() == false) goto L8;
        r101.add(r104);     // Catch: Throwable -> L25
        goto L8
    L18:
        Iterator r109 = r101.iterator();     // Catch: Throwable -> L25
    L19:
        if (r109.hasNext() == false) goto L23;
        String r110 = (String) r109.next();     // Catch: Throwable -> L25
        this.f477815b.remove(r110);     // Catch: Throwable -> L25
        goto L19
    L23:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // zm7.d
    public final synchronized List<String> d(zm7.a r100, List<String> r101) {
        monitor-enter(this);
        if (r100 == null) goto L19;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L22
        Gson r103 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;     // Catch: Throwable -> L22
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "addActionListener onCall, update map of action to listener", MapsKt.mapOf(TuplesKt.to(SlcCommonAction.KEY_ACTIONS, r101)), null);     // Catch: Throwable -> L22
        Iterator<String> r104 = r101.iterator();     // Catch: Throwable -> L22
    L6:
        if (r104.hasNext() == false) goto L17;
        String r105 = r104.next();     // Catch: Throwable -> L22
        ConcurrentHashMap<String, List<zm7.a>> r106 = this.f477815b;     // Catch: Throwable -> L22
        List<zm7.a> r107 = r106.get(r105);     // Catch: Throwable -> L22
        if (r107 != null) goto L13;
        r107 = new ArrayList();     // Catch: Throwable -> L22
        List<zm7.a> r108 = r106.putIfAbsent(r105, r107);     // Catch: Throwable -> L22
        if (r108 == null) goto L13;
        r107 = r108;
    L13:
        r107.add(r100);     // Catch: Throwable -> L22
        if (this.f477814a.contains(r105) == false) goto L6;
        r102.add(r105);     // Catch: Throwable -> L22
        goto L6
    L17:
        monitor-exit(this);
        return r102;
    L19:
        ArrayList r109 = new ArrayList();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r109;
    L22:
        th = move-exception;
        throw th;
    }
}
