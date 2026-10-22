package com.bytedance.kmp.network;

import com.bytedance.kmp.network.util.NLog;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f252497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f252498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f252499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f252500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f252501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f252502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f252503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f252504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f252505i;

    public final void b() {
        if (((int) this.f252497a) != (-1)) goto L6;
        this.f252497a = fuc.a.a().a();
        return;
    }

    public final String toString() {
        return "KmpRequestMetrics(kmpRequestStartTime=" + this.f252497a + ", kmpRequestInterceptorStartTime=" + this.f252498b + ", kmpRequestInterceptorEndTime=" + this.f252499c + ", kmpResponseHeaderTime=" + this.f252500d + ", kmpResponseInterceptorStartTime=" + this.f252501e + ", kmpResponseInterceptorEndTime=" + this.f252502f + ", kmpResponseDecodeStartTime=" + this.f252503g + ", kmpResponseDecodeEndTime=" + this.f252504h + ", kmpRequestEndTime=" + this.f252505i + ')';
    }

    public d() {
        this.f252497a = -1;
        this.f252498b = -1;
        this.f252499c = -1;
        this.f252500d = -1;
        this.f252501e = -1;
        this.f252502f = -1;
        this.f252503g = -1;
        this.f252504h = -1;
        this.f252505i = -1;
    }

    public final void c() {
        this.f252504h = fuc.a.a().a();
    }

    public final void d() {
        this.f252503g = fuc.a.a().a();
    }

    public final Unit a(com.bytedance.kmp.network.response.d r100) {
        this.f252505i = fuc.a.a().a();
        if (r100.f252568f != null) goto L5;
        boolean r101 = true;
    L6:
        String r102 = "null";
        if (r101 == false) goto L15;
        NLog.Level r103 = NLog.f252570a;
        NLog.Level r104 = NLog.Level.DEBUG;
        if (r104.compareTo(NLog.f252570a) < 0) goto L22;
        String r105 = "KmpNetworkManager, reportOK".toString();
        if (r105 == null) goto L14;
        r102 = r105;
    L14:
        System.out.println("[" + StringsKt.first(r104.name()) + "][kmp-ttnet] " + r102);
    L22:
        Unit r106 = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r106;
    L15:
        NLog.Level r107 = NLog.f252570a;
        NLog.Level r108 = NLog.Level.DEBUG;
        if (r108.compareTo(NLog.f252570a) < 0) goto L22;
        String r109 = "KmpNetworkManager, reportError".toString();
        if (r109 == null) goto L21;
        r102 = r109;
    L21:
        System.out.println("[" + StringsKt.first(r108.name()) + "][kmp-ttnet] " + r102);
        goto L22
    L5:
        r101 = false;
        goto L6
    }
}
