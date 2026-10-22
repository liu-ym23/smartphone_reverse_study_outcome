package com.obric.miniapp.impl;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f397659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f397660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f397662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f397663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f397664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f397665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f397666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f397667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f397668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f397669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f397670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f397671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f397672n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f397659a, r101.f397659a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397660b, r101.f397660b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397661c, r101.f397661c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397662d, r101.f397662d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397663e, r101.f397663e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f397664f, r101.f397664f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f397665g, r101.f397665g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f397666h, r101.f397666h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f397667i, r101.f397667i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f397668j, r101.f397668j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f397669k, r101.f397669k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f397670l, r101.f397670l) == true) goto L45;
        return false;
    L45:
        if (this.f397671m == r101.f397671m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f397672n, r101.f397672n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f397659a.hashCode() * 31;
        JSONObject r101 = this.f397660b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f397661c.hashCode()) * 31;
        String r105 = this.f397662d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((r104 + r106) * 31) + this.f397663e.hashCode()) * 31) + this.f397664f.hashCode()) * 31) + this.f397665g.hashCode()) * 31;
        String r108 = this.f397666h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f397667i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f397668j.hashCode()) * 31;
        Long r114 = this.f397669k;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.f397670l;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        long r118 = this.f397671m;
        return ((((r116 + r102) * 31) + ((int) (r118 ^ (r118 >>> 32)))) * 31) + this.f397672n.hashCode();
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveIslandNotifyContext(payload=" + this.f397659a + ", businessJson=" + this.f397660b + ", sessionKey=" + this.f397661c + ", jumpUrl=" + this.f397662d + ", islandBizData=" + this.f397663e + ", collapseData=" + this.f397664f + ", expandData=" + this.f397665g + ", collapseTemplateId=" + this.f397666h + ", expandTemplateId=" + this.f397667i + ", rawLiveIslandData=" + this.f397668j + ", status=" + this.f397669k + ", templateId=" + this.f397670l + ", triggerTs=" + this.f397671m + ", source=" + this.f397672n + ')';
    }

    public m(JSONObject r110, JSONObject r111, String r112, String r113, JSONObject r114, JSONObject r115, JSONObject r116, String r117, String r118, String r119, Long r210, Long r211, long r212, String r213) {
        Intrinsics.checkNotNullParameter(r110, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r112, "sessionKey");
        Intrinsics.checkNotNullParameter(r114, "islandBizData");
        Intrinsics.checkNotNullParameter(r115, "collapseData");
        Intrinsics.checkNotNullParameter(r116, "expandData");
        Intrinsics.checkNotNullParameter(r119, "rawLiveIslandData");
        Intrinsics.checkNotNullParameter(r213, "source");
        this.f397659a = r110;
        this.f397660b = r111;
        this.f397661c = r112;
        this.f397662d = r113;
        this.f397663e = r114;
        this.f397664f = r115;
        this.f397665g = r116;
        this.f397666h = r117;
        this.f397667i = r118;
        this.f397668j = r119;
        this.f397669k = r210;
        this.f397670l = r211;
        this.f397671m = r212;
        this.f397672n = r213;
    }
}
