package com.larus.im.internal.network.link.impl.rtc;

import com.larus.im.internal.trace.legacy.RTCEstablishReportScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f349294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f349296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<String, Object, Unit> f349297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<ue9.b, Unit> f349298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<ue9.c, Unit> f349299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f349300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<RTCConnectRetryReason, Boolean> f349301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<Integer, Integer, Boolean> f349302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f349303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function3<RTCEstablishReportScene, Long, Function0<Unit>, Unit> f349304k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f349294a, r101.f349294a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f349295b, r101.f349295b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f349296c, r101.f349296c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f349297d, r101.f349297d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f349298e, r101.f349298e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f349299f, r101.f349299f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f349300g, r101.f349300g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f349301h, r101.f349301h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f349302i, r101.f349302i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f349303j, r101.f349303j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f349304k, r101.f349304k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((this.f349294a.hashCode() * 31) + this.f349295b.hashCode()) * 31) + this.f349296c.hashCode()) * 31) + this.f349297d.hashCode()) * 31) + this.f349298e.hashCode()) * 31) + this.f349299f.hashCode()) * 31) + this.f349300g.hashCode()) * 31) + this.f349301h.hashCode()) * 31) + this.f349302i.hashCode()) * 31) + this.f349303j.hashCode()) * 31) + this.f349304k.hashCode();
    }

    public final String toString() {
        return "FlowRTCLinkSessionContext(config=" + this.f349294a + ", traceId=" + this.f349295b + ", roomIdProvider=" + this.f349296c + ", notifyOtherEvent=" + this.f349297d + ", notifyConnectionStateChanged=" + this.f349298e + ", reportConnectFailed=" + this.f349299f + ", releaseSession=" + this.f349300g + ", tryHandleConnectRetryFailure=" + this.f349301h + ", tryHandleConnectNetworkFailure=" + this.f349302i + ", markSessionStarted=" + this.f349303j + ", finishRTCConnectOnce=" + this.f349304k + ')';
    }

    public d(p r100, String r101, com.larus.im.internal.network.link.impl.rtc.abs.d r102, Function2 r103, com.larus.im.internal.network.link.impl.rtc.abs.e r104, com.larus.im.internal.network.link.impl.rtc.abs.f r105, com.larus.im.internal.network.link.impl.rtc.abs.g r106, Function1 r107, Function2 r110, Function0 r111, Function3 r112) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        Intrinsics.checkNotNullParameter(r102, "roomIdProvider");
        Intrinsics.checkNotNullParameter(r103, "notifyOtherEvent");
        Intrinsics.checkNotNullParameter(r104, "notifyConnectionStateChanged");
        Intrinsics.checkNotNullParameter(r105, "reportConnectFailed");
        Intrinsics.checkNotNullParameter(r106, "releaseSession");
        Intrinsics.checkNotNullParameter(r107, "tryHandleConnectRetryFailure");
        Intrinsics.checkNotNullParameter(r110, "tryHandleConnectNetworkFailure");
        Intrinsics.checkNotNullParameter(r111, "markSessionStarted");
        Intrinsics.checkNotNullParameter(r112, "finishRTCConnectOnce");
        this.f349294a = r100;
        this.f349295b = r101;
        this.f349296c = r102;
        this.f349297d = r103;
        this.f349298e = r104;
        this.f349299f = r105;
        this.f349300g = r106;
        this.f349301h = r107;
        this.f349302i = r110;
        this.f349303j = r111;
        this.f349304k = r112;
    }
}
