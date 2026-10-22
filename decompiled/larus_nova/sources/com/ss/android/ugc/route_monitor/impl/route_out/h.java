package com.ss.android.ugc.route_monitor.impl.route_out;

import android.os.SystemClock;
import com.ss.android.ugc.route_monitor.impl.biz_event.BizEventDataRecorder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<com.ss.android.ugc.route_monitor.impl.biz_event.c> f454696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<com.ss.android.ugc.route_monitor.impl.biz_event.c> f454697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f454698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f454699d;

    public final JSONObject b() {
        ArrayList<com.ss.android.ugc.route_monitor.impl.biz_event.c> r100 = this.f454696a;
        ArrayList<com.ss.android.ugc.route_monitor.impl.biz_event.c> r101 = this.f454697b;
        JSONObject r102 = new JSONObject();
        r102.put("route_out_session", this.f454699d);
        ArrayList r103 = new ArrayList(r100.size() + r101.size());
        monitor-enter(r100);
        r103.addAll(r100);     // Catch: Throwable -> L18
        monitor-exit(r100);
        monitor-enter(r101);
        r103.addAll(r101);     // Catch: Throwable -> L15
        monitor-exit(r101);
        JSONArray r104 = new JSONArray();
        Iterator r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        r104.put(r105.next());
        goto L11
    L13:
        r102.put("combine_route_biz_event", r104);
        r102.put("report_reason", this.f454698c);
        return r102;
    L15:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        return b().toString();
    }

    public h(String r110) {
        this.f454699d = r110;
        this.f454696a = new ArrayList();
        this.f454697b = new ArrayList();
        BizEventDataRecorder r111 = BizEventDataRecorder.f454415e;
        long r100 = SystemClock.uptimeMillis();
        r111.getClass();
        LinkedList<com.ss.android.ugc.route_monitor.impl.biz_event.c> r112 = BizEventDataRecorder.f454414d;
        monitor-enter(r112);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (r112.isEmpty() == false) goto L9;
        List<com.ss.android.ugc.route_monitor.impl.biz_event.c> r101 = CollectionsKt.emptyList();     // Catch: Throwable -> L24
        monitor-exit(r112);
    L22:
        a(r101);
        return;
    L9:
        Iterator r102 = CollectionsKt.withIndex(r112).iterator();     // Catch: Throwable -> L24
    L11:
        if (r102.hasNext() == false) goto L20;
        IndexedValue r103 = (IndexedValue) r102.next();     // Catch: Throwable -> L24
        ((com.ss.android.ugc.route_monitor.impl.biz_event.c) r103.getValue()).getClass();     // Catch: Throwable -> L24
        long r104 = r100 - 0;     // Catch: Throwable -> L24
        BizEventDataRecorder r105 = BizEventDataRecorder.f454415e;     // Catch: Throwable -> L24
        r105.getClass();     // Catch: Throwable -> L24
        if (r104 <= ((com.ss.android.ugc.route_monitor.impl.biz_event.a) BizEventDataRecorder.f454413c.getValue(r105, BizEventDataRecorder.f454412b[0])).f454418c) goto L11;
        if (r103.getIndex() <= 0) goto L17;
        r101 = BizEventDataRecorder.f454414d.subList(0, r103.getIndex());     // Catch: Throwable -> L24
    L18:
        monitor-exit(r112);
        goto L22
    L17:
        r101 = CollectionsKt.emptyList();     // Catch: Throwable -> L24
        goto L18
    L20:
        r101 = CollectionsKt.toList(BizEventDataRecorder.f454414d);     // Catch: Throwable -> L24
        monitor-exit(r112);
        goto L22
    }

    public final void a(List<com.ss.android.ugc.route_monitor.impl.biz_event.c> r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList<com.ss.android.ugc.route_monitor.impl.biz_event.c> r101 = this.f454696a;
        monitor-enter(r101);
        this.f454696a.addAll(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
