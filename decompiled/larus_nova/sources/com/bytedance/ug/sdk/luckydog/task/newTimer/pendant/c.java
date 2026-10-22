package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ym7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<ym7.b> f272121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ym7.b f272122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ym7.n f272123c;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f272121a = new CopyOnWriteArrayList();
    }

    @Override // ym7.d
    public final void a(ym7.b r100) {
        Gson r101 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "registerPendantShower onCall", MapsKt.mapOf(new Pair[]{TuplesKt.to("listener", r100.getClass().getSimpleName()), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, r100.getTaskKey())}), null);
        if (this.f272121a.contains(r100) == true) goto L6;
        this.f272121a.add(r100);
        return;
    }

    @Override // ym7.d
    public final void c(ym7.b r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantExclusionService", "unRegisterPendantShower() called; ");
        if (this.f272121a.contains(r100) == false) goto L6;
        this.f272121a.remove(r100);
        return;
    }

    @Override // ym7.d
    public final void b(String r100, ym7.n r110, String r111) {
        Gson r101 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "updatePendantShowerIfNeeded onCall, 收到需要展示通知，倒序遍历让哪个挂件展示", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", r100), TuplesKt.to("extra", r110), TuplesKt.to("listenerList", this.f272121a), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, r111)}), null);
        Iterator r112 = CollectionsKt.reversed(this.f272121a).iterator();
    L4:
        if (r112.hasNext() == false) goto L21;
        ym7.b r102 = (ym7.b) r112.next();
        if (r102.j(r100) == false) goto L4;
        Gson r113 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "updatePendantShowerIfNeeded onCall; 能展示, 调用show, 然后将最后一个隐藏", MapsKt.mapOf(new Pair[]{TuplesKt.to("listener", r102.getClass().getSimpleName()), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, r102.getTaskKey())}), null);
        if ((!Intrinsics.areEqual(this.f272122b, r102)) == false) goto L13;
        ym7.b r114 = this.f272122b;
        if (r114 == null) goto L12;
        r114.f(r100, this.f272123c);
    L12:
        this.f272122b = r102;
    L13:
        this.f272123c = r110;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantExclusionService", "互斥处理后, showPendant() onCall,lastListener:" + this.f272122b);
        ym7.b r115 = this.f272122b;
        if (r115 == null) goto L20;
        r115.a(r100, r110);
        return;
    L20:
        return;
    }
}
