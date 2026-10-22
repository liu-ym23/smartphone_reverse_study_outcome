package com.bytedance.locallife.dito.core;

import android.os.SystemClock;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f257908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f257909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f257910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f257911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f257912e;

    public e0() {
        this(null, 0, 0, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f257908a, r101.f257908a) == true) goto L12;
        return false;
    L12:
        if (this.f257909b == r101.f257909b) goto L15;
        return false;
    L15:
        if (this.f257910c == r101.f257910c) goto L18;
        return false;
    L18:
        if (this.f257911d == r101.f257911d) goto L21;
        return false;
    L21:
        if (this.f257912e == r101.f257912e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f257908a.hashCode() * 31;
        long r101 = this.f257909b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f257910c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f257911d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f257912e;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    }

    public final String toString() {
        return "MonitorData(uuid=" + this.f257908a + ", monitorStartTime=" + this.f257909b + ", activityCreateTime=" + this.f257910c + ", routerStartSystemClock=" + this.f257911d + ", lynxViewPreloadTime=" + this.f257912e + ')';
    }

    public e0(String r100, long r101, long r102, long r103, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = UUID.randomUUID().toString();
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = SystemClock.elapsedRealtime();
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r110 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        this.f257908a = r100;
        this.f257909b = r101;
        this.f257910c = r102;
        this.f257911d = r103;
        this.f257912e = 0;
    }
}
