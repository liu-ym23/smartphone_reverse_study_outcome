package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import com.google.gson.Gson;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements ym7.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, ym7.n> f272169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<String>> f272170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, CopyOnWriteArrayList<ym7.c>> f272171c;

    public static final class a {
    }

    static {
    }

    public o() {
        this.f272169a = new ConcurrentHashMap();
        this.f272170b = new ConcurrentHashMap();
        this.f272171c = new ConcurrentHashMap();
    }

    @Override // ym7.l
    public final void b(String r100) {
        c(r100, null);
    }

    @Override // ym7.l
    public final void e(ym7.c r100) {
        Iterator<Map.Entry<String, CopyOnWriteArrayList<ym7.c>>> r101 = this.f272171c.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, CopyOnWriteArrayList<ym7.c>> r102 = r101.next();
        if (r102.getValue().contains(r100) == false) goto L4;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckySceneService", "removeSceneListener() scene对应的list中移除；scene = " + r102.getKey());
        r102.getValue().remove(r100);
        goto L4
    }

    @Override // ym7.l
    public final void enterScene(String r100) {
        d(r100, null);
    }

    @Override // ym7.l
    public final void a(ym7.c r100, List<String> r101) {
        List<String> r102 = r101;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckySceneService", "addSceneListener() scenes isNullOrEmpty");
        return;
    L13:
        Gson r104 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "addSceneListener onCall, update map of scene to listener", MapsKt.mapOf(TuplesKt.to(InvRouter.SCENES, r101)), null);
        Iterator<String> r105 = r101.iterator();
    L15:
        if (r105.hasNext() == false) goto L25;
        String r106 = r105.next();
        if (this.f272171c.containsKey(r106) == true) goto L18;
        CopyOnWriteArrayList<ym7.c> r107 = new CopyOnWriteArrayList();
        r107.add(r100);
        this.f272171c.put(r106, r107);
        goto L15
    L18:
        CopyOnWriteArrayList<ym7.c> r108 = this.f272171c.get(r106);
        if (r108 != null) goto L22;
        r108 = new CopyOnWriteArrayList();
        this.f272171c.put(r106, r108);
    L22:
        if (r108.contains(r100) == true) goto L15;
        r108.add(r100);
        this.f272171c.put(r106, r108);
        goto L15
    L25:
        Iterator<Map.Entry<String, ym7.n>> r109 = this.f272169a.entrySet().iterator();
    L27:
        if (r109.hasNext() == false) goto L29;
        Map.Entry<String, ym7.n> r110 = r109.next();
        String r111 = r110.getKey();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckySceneService", "addSceneListener() 回调当前的scene");
        d(r111, r110.getValue());
        goto L27
    L29:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }

    @Override // ym7.l
    public final void c(String r110, ym7.n r111) {
        if (r110 == null) goto L30;
        Gson r100 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "quitScene onCall", MapsKt.mapOf(TuplesKt.to("scene", r110)), null);
        this.f272169a.remove(r110);
        g(r110, r111);
        List r112 = CollectionsKt.toList(this.f272171c.keySet());
        ArrayList r101 = new ArrayList();
        em7.b.f473100a.getClass();
        List r113 = em7.b.a.a(r110, r112, false);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckySceneService", "leaveScene() resList before = " + r113);
        List<String> r102 = this.f272170b.get(r110);
        this.f272170b.remove(r110);
        if (r102 == null) goto L16;
        Iterator<T> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        String r104 = (String) r103.next();
        Iterator<Map.Entry<String, List<String>>> r105 = this.f272170b.entrySet().iterator();
        boolean r106 = true;
    L10:
        if (r105.hasNext() == false) goto L14;
        if (r105.next().getValue().contains(r104) == false) goto L10;
        r106 = false;
        goto L10
    L14:
        if (r106 == false) goto L7;
        ((ArrayList) r113).add(r104);
    L16:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckySceneService", "leaveScene() resList before = " + r113);
        ArrayList r114 = (ArrayList) r113;
        if ((!r114.isEmpty()) == false) goto L25;
        Iterator r115 = r114.iterator();
    L20:
        if (r115.hasNext() == false) goto L25;
        String r107 = (String) r115.next();
        if ((!Intrinsics.areEqual(r107, r110)) == false) goto L20;
        g(r107, this.f272169a.get(r107));
        r101.add(r107);
    L25:
        if ((!r101.isEmpty()) == false) goto L47;
        Iterator r116 = r101.iterator();
    L28:
        if (r116.hasNext() == false) goto L48;
        this.f272169a.remove((String) r116.next());
        goto L28
    L48:
        return;
    L47:
        return;
    }

    @Override // ym7.l
    public final void d(String r100, ym7.n r101) {
        if (r100 == null) goto L19;
        Gson r102 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "enterScene onCall", MapsKt.mapOf(TuplesKt.to("scene", r100)), null);
        ConcurrentHashMap<String, ym7.n> r103 = this.f272169a;
        if (r101 == null) goto L6;
        ym7.n r104 = r101;
    L7:
        r103.put(r100, r104);
        f(r100, r101);
        List r105 = CollectionsKt.toList(this.f272171c.keySet());
        em7.b.f473100a.getClass();
        List<String> r106 = em7.b.a.a(r100, r105, true);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckySceneService", "enterScene() resList = " + r106);
        ArrayList r107 = (ArrayList) r106;
        if ((!r107.isEmpty()) == false) goto L25;
        this.f272170b.put(r100, r106);
        Iterator r108 = r107.iterator();
    L11:
        if (r108.hasNext() == false) goto L26;
        String r109 = (String) r108.next();
        if ((!Intrinsics.areEqual(r109, r100)) == false) goto L11;
        ConcurrentHashMap<String, ym7.n> r110 = this.f272169a;
        if (r101 == null) goto L17;
        ym7.n r111 = r101;
    L18:
        r110.put(r109, r111);
        f(r109, this.f272169a.get(r109));
        goto L11
    L17:
        r111 = new ym7.n(null, null, 7);
        goto L18
    L26:
        return;
    L25:
        return;
    L6:
        r104 = new ym7.n(null, null, 7);
        goto L7
    }

    public final void f(String r100, ym7.n r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckySceneService", "handleEnterScene() scene = " + r100);
        CopyOnWriteArrayList<ym7.c> r102 = this.f272171c.get(r100);
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((ym7.c) r103.next()).m(r100, r101);
        goto L6
    L10:
        return;
    }

    public final void g(String r100, ym7.n r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckySceneService", "handleQuitScene() scene = " + r100);
        CopyOnWriteArrayList<ym7.c> r102 = this.f272171c.get(r100);
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((ym7.c) r103.next()).k(r100, r101);
        goto L6
    L10:
        return;
    }
}
