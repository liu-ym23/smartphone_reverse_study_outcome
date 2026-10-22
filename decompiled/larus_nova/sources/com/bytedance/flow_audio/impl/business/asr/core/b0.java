package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import com.bytedance.flow_audio.impl.business.asr.FlowAsrPrepareDecision;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowAsrSessionState f243883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowAsrPrepareDecision f243884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.flow_audio.impl.business.asr.q f243885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f243886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f243887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f243888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f243889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f243890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f243891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f243892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f243893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f243894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f243895m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f243896n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final hw5.a f243897o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (this.f243883a == r101.f243883a) goto L12;
        return false;
    L12:
        if (this.f243884b == r101.f243884b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243885c, r101.f243885c) == true) goto L18;
        return false;
    L18:
        if (this.f243886d == r101.f243886d) goto L21;
        return false;
    L21:
        if (this.f243887e == r101.f243887e) goto L24;
        return false;
    L24:
        if (this.f243888f == r101.f243888f) goto L27;
        return false;
    L27:
        if (this.f243889g == r101.f243889g) goto L30;
        return false;
    L30:
        if (this.f243890h == r101.f243890h) goto L33;
        return false;
    L33:
        if (this.f243891i == r101.f243891i) goto L36;
        return false;
    L36:
        if (this.f243892j == r101.f243892j) goto L39;
        return false;
    L39:
        if (this.f243893k == r101.f243893k) goto L42;
        return false;
    L42:
        if (this.f243894l == r101.f243894l) goto L45;
        return false;
    L45:
        if (this.f243895m == r101.f243895m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f243896n, r101.f243896n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f243897o, r101.f243897o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f243883a.hashCode() * 31) + this.f243884b.hashCode()) * 31) + this.f243885c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f243886d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f243887e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f243888f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f243889g == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f243890h == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f243891i == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.f243892j == false) goto L29;
        int r114 = 1231;
    L30:
        int r115 = (r113 + r114) * 31;
        if (this.f243893k == false) goto L33;
        int r116 = 1231;
    L34:
        int r117 = (r115 + r116) * 31;
        if (this.f243894l == false) goto L37;
        int r118 = 1231;
    L38:
        int r119 = (r117 + r118) * 31;
        if (this.f243895m == true) goto L42;
        r101 = 1237;
    L42:
        int r120 = (r119 + r101) * 31;
        String r121 = this.f243896n;
        int r122 = 0;
        if (r121 != null) goto L45;
        int r123 = 0;
    L46:
        int r124 = (r120 + r123) * 31;
        hw5.a r125 = this.f243897o;
        if (r125 == null) goto L51;
        r122 = r125.hashCode();
    L51:
        return r124 + r122;
    L45:
        r123 = r121.hashCode();
        goto L46
    L37:
        r118 = 1237;
        goto L38
    L33:
        r116 = 1237;
        goto L34
    L29:
        r114 = 1237;
        goto L30
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowAsrRuntimeState(state=" + this.f243883a + ", prepareDecision=" + this.f243884b + ", stopDecision=" + this.f243885c + ", canAcceptAudioFrame=" + this.f243886d + ", canAcceptSourceError=" + this.f243887e + ", canHandleAsrResponse=" + this.f243888f + ", canHandleAsrEnded=" + this.f243889g + ", canHandleAsrCompletionTimeout=" + this.f243890h + ", shouldDelayFailure=" + this.f243891i + ", canKeepPendingFailure=" + this.f243892j + ", isRetrying=" + this.f243893k + ", isTerminal=" + this.f243894l + ", isFileReplayConfig=" + this.f243895m + ", fileReplayPath=" + this.f243896n + ", pendingFailure=" + this.f243897o + ')';
    }

    public b0(FlowAsrSessionState r100, FlowAsrPrepareDecision r101, com.bytedance.flow_audio.impl.business.asr.q r102, boolean r103, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, String r119, hw5.a r210) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "prepareDecision");
        Intrinsics.checkNotNullParameter(r102, "stopDecision");
        this.f243883a = r100;
        this.f243884b = r101;
        this.f243885c = r102;
        this.f243886d = r103;
        this.f243887e = r110;
        this.f243888f = r111;
        this.f243889g = r112;
        this.f243890h = r113;
        this.f243891i = r114;
        this.f243892j = r115;
        this.f243893k = r116;
        this.f243894l = r117;
        this.f243895m = r118;
        this.f243896n = r119;
        this.f243897o = r210;
    }
}
