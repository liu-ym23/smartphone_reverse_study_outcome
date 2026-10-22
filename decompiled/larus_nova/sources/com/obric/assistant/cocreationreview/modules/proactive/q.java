package com.obric.assistant.cocreationreview.modules.proactive;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class q extends com.obric.assistant.cocreationreview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleKey f387492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f387494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f387495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f387496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f387497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f387498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f387499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f387500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f387501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f387502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<a> f387503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<h> f387504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f387505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f387506p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f387507q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f387508r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f387509s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f387510t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a5 f387511u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f387512v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f387513w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final double f387514x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f387515y;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f387491a, r101.f387491a) == true) goto L12;
        return false;
    L12:
        if (this.f387492b == r101.f387492b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387493c, r101.f387493c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387494d, r101.f387494d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387495e, r101.f387495e) == true) goto L24;
        return false;
    L24:
        if (this.f387496f == r101.f387496f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387497g, r101.f387497g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387498h, r101.f387498h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387499i, r101.f387499i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387500j, r101.f387500j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f387501k, r101.f387501k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f387502l, r101.f387502l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f387503m, r101.f387503m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f387504n, r101.f387504n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f387505o, r101.f387505o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f387506p, r101.f387506p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f387507q, r101.f387507q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f387508r, r101.f387508r) == true) goto L63;
        return false;
    L63:
        if (this.f387509s == r101.f387509s) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f387510t, r101.f387510t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f387511u, r101.f387511u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f387512v, r101.f387512v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f387513w, r101.f387513w) == true) goto L78;
        return false;
    L78:
        if (Double.compare(this.f387514x, r101.f387514x) == 0) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f387515y, r101.f387515y) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f387491a.hashCode() * 31) + this.f387492b.hashCode()) * 31) + this.f387493c.hashCode()) * 31) + this.f387494d.hashCode()) * 31) + this.f387495e.hashCode()) * 31;
        long r101 = this.f387496f;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f387497g.hashCode()) * 31) + this.f387498h.hashCode()) * 31;
        String r103 = this.f387499i;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (((((((((((((r102 + r105) * 31) + this.f387500j.hashCode()) * 31) + this.f387501k.hashCode()) * 31) + this.f387502l.hashCode()) * 31) + this.f387503m.hashCode()) * 31) + this.f387504n.hashCode()) * 31) + this.f387505o.hashCode()) * 31;
        String r107 = this.f387506p;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f387507q;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f387508r;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (((r112 + r114) * 31) + this.f387509s) * 31;
        String r116 = this.f387510t;
        if (r116 != null) goto L21;
        int r117 = 0;
    L22:
        int r118 = (r115 + r117) * 31;
        a5 r119 = this.f387511u;
        if (r119 == null) goto L26;
        r104 = r119.hashCode();
    L26:
        int r120 = (((((r118 + r104) * 31) + this.f387512v.hashCode()) * 31) + this.f387513w.hashCode()) * 31;
        long r121 = Double.doubleToLongBits(this.f387514x);
        return ((r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31) + this.f387515y.hashCode();
    L21:
        r117 = r116.hashCode();
        goto L22
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProactiveAgentUsageRecord(id=" + this.f387491a + ", module=" + this.f387492b + ", recommendId=" + this.f387493c + ", inspirationId=" + this.f387494d + ", taskId=" + this.f387495e + ", createdAt=" + this.f387496f + ", triggeredAt=" + this.f387497g + ", triggerDomain=" + this.f387498h + ", triggerScenario=" + this.f387499i + ", triggerTitle=" + this.f387500j + ", triggerSummary=" + this.f387501k + ", suggestionText=" + this.f387502l + ", recommendedActions=" + this.f387503m + ", triggerMeasures=" + this.f387504n + ", sourcePackages=" + this.f387505o + ", actionContext=" + this.f387506p + ", evidence=" + this.f387507q + ", actionExecuteInstruction=" + this.f387508r + ", recommendStatus=" + this.f387509s + ", feedbackAction=" + this.f387510t + ", feedback=" + this.f387511u + ", status=" + this.f387512v + ", type=" + this.f387513w + ", score=" + this.f387514x + ", payload=" + this.f387515y + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.f387491a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.f387492b;
    }

    public final String getType() {
        return this.f387513w;
    }

    public q(String r110, ModuleKey r111, String r112, String r210, String r211, long r212, String r213, String r214, String r215, String r216, String r217, List r218, List r310, List r311, String r312, String r313, String r314, int r315, String r316, a5 r317, String r318, String r319, double r410, String r411) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r112, "recommendId");
        Intrinsics.checkNotNullParameter(r210, "inspirationId");
        Intrinsics.checkNotNullParameter(r211, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r213, "triggeredAt");
        Intrinsics.checkNotNullParameter("主动智能", "triggerDomain");
        Intrinsics.checkNotNullParameter(r215, "triggerTitle");
        Intrinsics.checkNotNullParameter(r216, "triggerSummary");
        Intrinsics.checkNotNullParameter(r217, "suggestionText");
        Intrinsics.checkNotNullParameter(r218, "recommendedActions");
        Intrinsics.checkNotNullParameter(r310, "triggerMeasures");
        Intrinsics.checkNotNullParameter(r311, "sourcePackages");
        Intrinsics.checkNotNullParameter(r318, "status");
        Intrinsics.checkNotNullParameter(r319, "type");
        Intrinsics.checkNotNullParameter(r411, WsConstants.KEY_PAYLOAD);
        this.f387491a = r110;
        this.f387492b = r111;
        this.f387493c = r112;
        this.f387494d = r210;
        this.f387495e = r211;
        this.f387496f = r212;
        this.f387497g = r213;
        this.f387498h = "主动智能";
        this.f387499i = r214;
        this.f387500j = r215;
        this.f387501k = r216;
        this.f387502l = r217;
        this.f387503m = r218;
        this.f387504n = r310;
        this.f387505o = r311;
        this.f387506p = r312;
        this.f387507q = r313;
        this.f387508r = r314;
        this.f387509s = r315;
        this.f387510t = r316;
        this.f387511u = r317;
        this.f387512v = r318;
        this.f387513w = r319;
        this.f387514x = r410;
        this.f387515y = r411;
    }
}
