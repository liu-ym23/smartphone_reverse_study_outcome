package com.bytedance.dora.link.monitor;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import kotlin.UByte;
import pk4.j;
import pk4.l;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f204443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f204444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f204445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f204446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f204447e;

    public g() {
        this.f204443a = new Object();
        this.f204444b = 0;
        this.f204445c = 0;
        this.f204446d = new ArrayList();
        this.f204447e = false;
    }

    public final void a() {
        Object r100 = this.f204443a;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f204444b == 0) goto L7;
    L10:
        j.d("DoraDownlinkBlockedMonitor", "onLinkDisconnected: reset state, timeoutCount=" + this.f204445c + ", linkBlockedReported=" + this.f204447e);     // Catch: Throwable -> L14
    L11:
        this.f204444b = 0;     // Catch: Throwable -> L14
        this.f204445c = 0;     // Catch: Throwable -> L14
        ((ArrayList) this.f204446d).clear();     // Catch: Throwable -> L14
        this.f204447e = false;     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.f204445c != 0) goto L10;
        if (this.f204447e == false) goto L11;
        goto L10
    }

    public final void b() {
        long r100 = SystemClock.elapsedRealtime();
        Object r101 = this.f204443a;
        monitor-enter(r101);
        this.f204444b = r100;     // Catch: Throwable -> L8
        this.f204445c = 0;     // Catch: Throwable -> L8
        ((ArrayList) this.f204446d).clear();     // Catch: Throwable -> L8
        this.f204447e = false;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        j.d("DoraDownlinkBlockedMonitor", "onLinkEstablished: anchor=" + r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void c(int r100, int r101, int r102, int r103) {
        Object r104 = this.f204443a;
        monitor-enter(r104);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f204445c <= 0) goto L7;
        j.d("DoraDownlinkBlockedMonitor", "onTxAckReceived: reset timeout state, sid=" + r100 + ", cid=" + r101 + ", nid=" + r102 + ", retCode=" + r103 + ", prevTimeoutCount=" + this.f204445c);     // Catch: Throwable -> L10
    L7:
        this.f204445c = 0;     // Catch: Throwable -> L10
        ((ArrayList) this.f204446d).clear();     // Catch: Throwable -> L10
        monitor-exit(r104);     // Catch: Throwable -> L10
    }

    public final void d(int r110, int r111, int r112, byte[] r113, int r114) {
        if (r114 != (-3)) goto L46;
        Object r100 = this.f204443a;
        monitor-enter(r100);
    L42:
        th = move-exception;
        throw th;
    L7:
        if (this.f204447e == false) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L42
        return;
    L11:
        if (r113 != null) goto L13;
    L16:
        int r115 = 0;
    L17:
        String r116 = r110 + "-" + r111 + "-" + r115 + "-" + System.currentTimeMillis();     // Catch: Throwable -> L42
        ((ArrayList) this.f204446d).add(r116);     // Catch: Throwable -> L42
        int r101 = this.f204445c + 1;     // Catch: Throwable -> L42
        this.f204445c = r101;     // Catch: Throwable -> L42
        if (r101 != 1) goto L21;
        j.f("DoraDownlinkBlockedMonitor", "onTxAckTimeout: sid=" + r110 + ", cid=" + r111 + ", nid=" + r112 + ", record=" + r116);     // Catch: Throwable -> L42
    L21:
        if (r101 >= 20) goto L24;
        monitor-exit(r100);     // Catch: Throwable -> L42
        return;
    L24:
        this.f204447e = true;     // Catch: Throwable -> L42
        long r102 = 0;
        if (this.f204444b <= 0) goto L27;
        long r117 = SystemClock.elapsedRealtime() - this.f204444b;     // Catch: Throwable -> L42
    L28:
        j.f("DoraDownlinkBlockedMonitor", "linkBlockedDetected: timeoutCount=" + r101 + ", durationMs=" + r117 + ", lastRecord=" + r116);     // Catch: Throwable -> L42
        ArrayList r118 = new ArrayList(this.f204446d);     // Catch: Throwable -> L42
        monitor-exit(r100);     // Catch: Throwable -> L42
        if (r118.isEmpty() == true) goto L64;
        String[] r119 = ((String) ListProtector.get(r118, r118.size() - 1)).split("-");
        if (r119.length < 3) goto L36;
        String r120 = r119[0] + "-" + r119[1] + "-" + r119[2];
    L38:
        if (r119.length >= 4) goto L56;
    L41:
        String r121 = (String) r118.stream().map(new f()).collect(Collectors.joining(",", "[", "]"));
        HashMap r103 = new HashMap();
        r103.put("last_cmd", r120);
        r103.put("last_cmd_send_time", Long.valueOf(r102));
        r103.put("last_cmds_info", r121);
        r103.put("duration", Long.valueOf(r117));
        l.c(l.f529639g, r103);
        j.d("DoraDownlinkBlockedMonitor", "fireLinkBlockedEvent: last_cmd=" + r120 + ", duration=" + r117 + ", recordsSize=" + r118.size());
        return;
    L56:
        r102 = CastLongProtector.parseLong(r119[3]);     // Catch: Throwable -> L55
        goto L41
    L36:
        r120 = "";
        goto L38
    L64:
        return;
    L27:
        j.f("DoraDownlinkBlockedMonitor", "duration is 0 due to missing linkEstablishedElapsedMs anchor.");     // Catch: Throwable -> L42
        r117 = 0;
        goto L28
    L13:
        if (r113.length == 0) goto L16;
        r115 = r113[0] & UByte.MAX_VALUE;     // Catch: Throwable -> L42
        goto L17
    L46:
        if (r114 != (-4)) goto L48;
    L53:
        j.f("DoraDownlinkBlockedMonitor", "onTxSyncFinished: ignore non-ack result, sid=" + r110 + ", cid=" + r111 + ", nid=" + r112 + ", retCode=" + r114);
        return;
    L48:
        if (r114 == (-6)) goto L53;
        if (r114 == (-2)) goto L62;
        c(r110, r111, r112, r114);
        return;
    }
}
