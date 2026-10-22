package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.ef;
import com.xiaomi.push.eg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f464274a;

    /* JADX INFO: renamed from: com.xiaomi.push.service.at$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a extends XMPushService.j {
        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "RecordTimeManager clear";
        }

        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo9047a() {
            at.a().m9372a();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final at f464275a = null;

        static {
            f464275a = new at();
        }

        public static /* synthetic */ at a() {
            return f464275a;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f464276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f464277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f464278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f464279d;

        private c() {
        }

        public long a() {
            long r100 = this.f464278c;
            long r101 = this.f464277b;
            if (r100 > r101) goto L5;
            return 0;
        L5:
            return r100 - r101;
        }

        public long b() {
            long r100 = this.f464279d;
            long r101 = this.f464278c;
            if (r100 > r101) goto L5;
            return 0;
        L5:
            return r100 - r101;
        }

        public /* synthetic */ c(AnonymousClass1 r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9372a() {
        if (this.f464274a.isEmpty() == true) goto L16;
        Iterator<Map.Entry<String, c>> r100 = this.f464274a.entrySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L26;
        Map.Entry<String, c> r101 = r100.next();
        if (r101 == null) goto L15;
        if (r101.getValue() == null) goto L15;
        c r102 = r101.getValue();
        if (Math.abs(SystemClock.elapsedRealtime() - r102.f464277b) <= 10000) goto L6;
        a(r101.getKey(), r102);
        r100.remove();
    L15:
        r100.remove();
        goto L6
    L26:
        return;
    }

    public at() {
        this.f464274a = new ConcurrentHashMap();
    }

    public static at a() {
        return b.a();
    }

    private void a(String r100, c r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        HashMap r102 = new HashMap();
        r102.put("xmsfVC", Long.valueOf(r101.f464276a));
        r102.put("packetId", r100);
        r102.put("pTime", Long.valueOf(r101.a()));
        r102.put("bTime", Long.valueOf(r101.b()));
        eg.a().a(new ef("msg_process_time", r102));
        return;
    L9:
        return;
    }

    public void b(String r100, long r101) {
        c r102 = this.f464274a.remove(r100);
        if (r102 == null) goto L6;
        r102.f464279d = r101;
        a(r100, r102);
        return;
    }

    public void a(String r100, long r101) {
        c r102 = this.f464274a.get(r100);
        if (r102 == null) goto L6;
        r102.f464278c = r101;
        return;
    }

    public void a(String r100, long r101, long r102) {
        c r103 = new c(null);
        r103.f464276a = r102;
        r103.f464277b = r101;
        this.f464274a.put(r100, r103);
    }
}
