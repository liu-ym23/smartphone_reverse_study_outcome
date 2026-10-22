package com.larus.bmhome.interactionpanel;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f312374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<InteractionPanelSource> f312375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f312376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f312377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f312378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f312379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f312380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f312381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InteractionPanelQueueState f312382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f312383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final w f312384k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f312374a, r101.f312374a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312375b, r101.f312375b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f312376c, r101.f312376c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f312377d, r101.f312377d) == true) goto L21;
        return false;
    L21:
        if (this.f312378e == r101.f312378e) goto L24;
        return false;
    L24:
        if (this.f312379f == r101.f312379f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f312380g, r101.f312380g) == true) goto L30;
        return false;
    L30:
        if (this.f312381h == r101.f312381h) goto L33;
        return false;
    L33:
        if (this.f312382i == r101.f312382i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f312383j, r101.f312383j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f312384k, r101.f312384k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f312374a.hashCode() * 31) + this.f312375b.hashCode()) * 31;
        t r101 = this.f312376c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        t r105 = this.f312377d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        long r107 = this.f312378e;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f312379f;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Long r111 = this.f312380g;
        if (r111 != null) goto L13;
        int r112 = 0;
    L14:
        int r113 = (r110 + r112) * 31;
        long r114 = this.f312381h;
        int r115 = (((r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31) + this.f312382i.hashCode()) * 31;
        String r116 = this.f312383j;
        if (r116 != null) goto L17;
        int r117 = 0;
    L18:
        int r118 = (r115 + r117) * 31;
        w r119 = this.f312384k;
        if (r119 == null) goto L23;
        r102 = r119.hashCode();
    L23:
        return r118 + r102;
    L17:
        r117 = r116.hashCode();
        goto L18
    L13:
        r112 = r111.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionPanelEntry(key=" + this.f312374a + ", sources=" + this.f312375b + ", mainHostPayload=" + this.f312376c + ", threadHostPayload=" + this.f312377d + ", firstEnqueueTimeMs=" + this.f312378e + ", updateTimeMs=" + this.f312379f + ", expireAtMs=" + this.f312380g + ", order=" + this.f312381h + ", queueState=" + this.f312382i + ", submitOwnerHostId=" + this.f312383j + ", trackContext=" + this.f312384k + ')';
    }

    public static m a(m r110, Set r111, t r210, t r211, long r212, Long r213, InteractionPanelQueueState r214, String r215, w r216, int r217) {
        if ((r217 & 1) == 0) goto L5;
        o r100 = r110.f312374a;
    L6:
        o r101 = r100;
        if ((r217 & 2) == 0) goto L9;
        Set r102 = r110.f312375b;
    L11:
        if ((r217 & 4) == 0) goto L13;
        t r103 = r110.f312376c;
    L15:
        if ((r217 & 8) == 0) goto L17;
        t r104 = r110.f312377d;
    L18:
        long r105 = 0;
        if ((r217 & 16) == 0) goto L21;
        long r112 = r110.f312378e;
    L23:
        if ((r217 & 32) == 0) goto L25;
        long r113 = r110.f312379f;
    L27:
        if ((r217 & 64) == 0) goto L29;
        Long r106 = r110.f312380g;
    L31:
        if ((r217 & 128) == 0) goto L33;
        r105 = r110.f312381h;
    L33:
        long r114 = r105;
        if ((r217 & 256) == 0) goto L36;
        InteractionPanelQueueState r107 = r110.f312382i;
    L38:
        if ((r217 & 512) == 0) goto L40;
        String r115 = r110.f312383j;
    L42:
        if ((r217 & 1024) == 0) goto L44;
        w r116 = r110.f312384k;
    L45:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "sources");
        Intrinsics.checkNotNullParameter(r107, "queueState");
        return new m(r101, r102, r103, r104, r112, r113, r106, r114, r107, r115, r116);
    L44:
        r116 = r216;
        goto L45
    L40:
        r115 = r215;
        goto L42
    L36:
        r107 = r214;
        goto L38
    L29:
        r106 = r213;
        goto L31
    L25:
        r113 = r212;
        goto L27
    L21:
        r112 = 0;
        goto L23
    L17:
        r104 = r211;
        goto L18
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(o r100, Set<? extends InteractionPanelSource> r101, t r102, t r103, long r104, long r105, Long r110, long r111, InteractionPanelQueueState r112, String r113, w r114) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "sources");
        Intrinsics.checkNotNullParameter(r112, "queueState");
        this.f312374a = r100;
        this.f312375b = r101;
        this.f312376c = r102;
        this.f312377d = r103;
        this.f312378e = r104;
        this.f312379f = r105;
        this.f312380g = r110;
        this.f312381h = r111;
        this.f312382i = r112;
        this.f312383j = r113;
        this.f312384k = r114;
    }
}
