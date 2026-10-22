package com.larus.bmhome.chat;

import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i1 implements t1a.c {
    public volatile int A;
    public volatile int B;
    public long C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f303149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f303150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f303151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f303152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f303153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f303154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f303155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f303156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f303157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f303158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f303159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f303160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f303161m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f303162n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f303163o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile long f303164p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f303165q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f303166r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f303167s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile int f303168t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f303169u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f303170v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f303171w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f303172x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile int f303173y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile int f303174z;

    public static final class a {
    }

    static {
    }

    public i1() {
        this(0, 0, 1048575);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r101 = (i1) r100;
        if (Intrinsics.areEqual(this.f303149a, r101.f303149a) == true) goto L12;
        return false;
    L12:
        if (this.f303150b == r101.f303150b) goto L15;
        return false;
    L15:
        if (this.f303151c == r101.f303151c) goto L18;
        return false;
    L18:
        if (this.f303152d == r101.f303152d) goto L21;
        return false;
    L21:
        if (this.f303153e == r101.f303153e) goto L24;
        return false;
    L24:
        if (this.f303154f == r101.f303154f) goto L27;
        return false;
    L27:
        if (this.f303155g == r101.f303155g) goto L30;
        return false;
    L30:
        if (this.f303156h == r101.f303156h) goto L33;
        return false;
    L33:
        if (this.f303157i == r101.f303157i) goto L36;
        return false;
    L36:
        if (this.f303158j == r101.f303158j) goto L39;
        return false;
    L39:
        if (this.f303159k == r101.f303159k) goto L42;
        return false;
    L42:
        if (this.f303160l == r101.f303160l) goto L45;
        return false;
    L45:
        if (this.f303161m == r101.f303161m) goto L48;
        return false;
    L48:
        if (this.f303162n == r101.f303162n) goto L51;
        return false;
    L51:
        if (this.f303163o == r101.f303163o) goto L54;
        return false;
    L54:
        if (this.f303164p == r101.f303164p) goto L57;
        return false;
    L57:
        if (this.f303165q == r101.f303165q) goto L60;
        return false;
    L60:
        if (this.f303166r == r101.f303166r) goto L63;
        return false;
    L63:
        if (this.f303167s == r101.f303167s) goto L66;
        return false;
    L66:
        if (this.f303168t == r101.f303168t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f303149a.hashCode() * 31;
        long r101 = this.f303150b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f303151c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f303152d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f303153e;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f303154f;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f303155g;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f303156h;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f303157i;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.f303158j;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.f303159k;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.f303160l;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.f303161m;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        long r125 = this.f303162n;
        int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
        long r127 = this.f303163o;
        int r128 = (r126 + ((int) (r127 ^ (r127 >>> 32)))) * 31;
        long r129 = this.f303164p;
        int r130 = (r128 + ((int) (r129 ^ (r129 >>> 32)))) * 31;
        long r131 = this.f303165q;
        int r132 = (r130 + ((int) (r131 ^ (r131 >>> 32)))) * 31;
        long r133 = this.f303166r;
        int r134 = (r132 + ((int) (r133 ^ (r133 >>> 32)))) * 31;
        long r135 = this.f303167s;
        return ((r134 + ((int) (r135 ^ (r135 >>> 32)))) * 31) + this.f303168t;
    }

    public final String toString() {
        return "ChatPageMetrics(pageTraceId=" + this.f303149a + ", initTime=" + this.f303150b + ", imInitTime=" + this.f303151c + ", createStartTime=" + this.f303152d + ", createViewStartTime=" + this.f303153e + ", startTime=" + this.f303154f + ", resumeStartTime=" + this.f303155g + ", resumeEndTime=" + this.f303156h + ", conversationChangeStartTime=" + this.f303157i + ", conversationChangeEndTime=" + this.f303158j + ", botChangeStartTime=" + this.f303159k + ", botChangeEndTime=" + this.f303160l + ", actionBarLoadStartTime=" + this.f303161m + ", actionBarFirstFrameTime=" + this.f303162n + ", wcbLoadedTime=" + this.f303163o + ", localMsgListCallbackTime=" + this.f303164p + ", remoteMsgListCallbackTime=" + this.f303165q + ", localMsgListRenderTime=" + this.f303166r + ", remoteMsgListRenderTime=" + this.f303167s + ", firstScreenMsgListCount=" + this.f303168t + ')';
    }

    public final synchronized void a(String r110, long r111) {
        monitor-enter(this);
        long r100 = this.f303172x;     // Catch: Throwable -> L21
        if (r100 > 0) goto L7;
    L9:
        long r101 = 0;
    L10:
        long r102 = this.f303150b;     // Catch: Throwable -> L21
        if (r102 > 0) goto L13;
    L15:
        long r103 = 0;
    L16:
        FLogger.f375446a.d("ChatPageMetrics", "record stage=" + r110 + " delta=" + r101 + " pageDuration=" + r103);     // Catch: Throwable -> L21
        if (r111 <= 0) goto L19;
        this.f303172x = r111;     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L13:
        if (r111 <= 0) goto L15;
        r103 = r111 - r102;     // Catch: Throwable -> L21
        goto L16
    L7:
        if (r111 <= 0) goto L9;
        r101 = r111 - r100;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public i1(long r100, long r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        String r103 = UUID.randomUUID().toString();
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = 0;
    L10:
        if ((r102 & 4) == 0) goto L13;
        r101 = 0;
    L13:
        if ((r102 & 524288) == 0) goto L15;
        int r104 = -1;
    L16:
        Intrinsics.checkNotNullParameter(r103, "pageTraceId");
        this.f303149a = r103;
        this.f303150b = r100;
        this.f303151c = r101;
        this.f303152d = 0;
        this.f303153e = 0;
        this.f303154f = 0;
        this.f303155g = 0;
        this.f303156h = 0;
        this.f303157i = 0;
        this.f303158j = 0;
        this.f303159k = 0;
        this.f303160l = 0;
        this.f303161m = 0;
        this.f303162n = 0;
        this.f303163o = 0;
        this.f303164p = 0;
        this.f303165q = 0;
        this.f303166r = 0;
        this.f303167s = 0;
        this.f303168t = r104;
        this.f303169u = "";
        this.f303170v = "";
        FLogger.f375446a.d("ChatPageMetrics", "record stage=initTime time=" + r100 + " pageTraceId=" + r103);
        this.f303172x = r100;
        return;
    L15:
        r104 = 0;
        goto L16
    L5:
        r103 = null;
        goto L7
    }
}
