package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class d implements com.ss.android.lark.conditional.access.traffic.handler.policy.center.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f418442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f418443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f418444c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f418445a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f418445a, ((a) r100).f418445a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f418445a.hashCode();
        }

        public final String toString() {
            return "ActionKey(displayId=" + this.f418445a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "displayId");
            this.f418445a = r100;
        }
    }

    public static final class b {
    }

    static {
    }

    public static long a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Long.valueOf(w4c.c.a().r0()));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = 10L;
    L9:
        long r102 = ((Number) r101).longValue();
        if (r102 > 0) goto L13;
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "cooling settings fallback, reason=invalid_value, value=" + r102 + ", coolingSeconds=10");
        return 10;
    L13:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean b() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(w4c.c.a().m()));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Inject
    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f418442a = r100;
    }

    @Override // com.ss.android.lark.conditional.access.traffic.handler.policy.center.a
    public final synchronized boolean C5(InternalSecurityAction r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "action");     // Catch: Throwable -> L27
        if (b() == false) goto L9;
        this.f418443b = null;     // Catch: Throwable -> L27
        this.f418444c = 0;     // Catch: Throwable -> L27
        int r100 = ScsLogger.f440428a;     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "incoming dedup bypassed by disable setting, " + c(this, r110, null, "dedup_disabled", null, null, 26));     // Catch: Throwable -> L27
        monitor-exit(this);
        return false;
    L9:
        a r101 = d(r110, "incoming");     // Catch: Throwable -> L27
        if (r101 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        a r102 = this.f418443b;     // Catch: Throwable -> L27
        if (r102 != null) goto L18;
        monitor-exit(this);
        return false;
    L18:
        if (this.f418444c > System.currentTimeMillis()) goto L22;
        int r103 = ScsLogger.f440428a;     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "cooling expired, " + c(this, r110, r102, "cooling_expired", null, null, 24));     // Catch: Throwable -> L27
        this.f418443b = null;     // Catch: Throwable -> L27
        this.f418444c = 0;     // Catch: Throwable -> L27
        monitor-exit(this);
        return false;
    L22:
        boolean r104 = Intrinsics.areEqual(r102, r101);     // Catch: Throwable -> L27
        if (r104 == false) goto L25;
        int r105 = ScsLogger.f440428a;     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "incoming filtered by cooling, " + c(this, r110, r101, "cooling", null, null, 24));     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return r104;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.conditional.access.traffic.handler.policy.center.a
    public final synchronized void i3(InternalSecurityAction r110) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (b() == false) goto L9;
        this.f418443b = null;     // Catch: Throwable -> L17
        this.f418444c = 0;     // Catch: Throwable -> L17
        int r100 = ScsLogger.f440428a;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "onPingSuccess dedup bypassed by disable setting, " + c(this, r110, null, "dedup_disabled", null, null, 26));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L9:
        a r101 = d(r110, "ping_success");     // Catch: Throwable -> L17
        if (r101 != null) goto L14;
        int r102 = ScsLogger.f440428a;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "onPingSuccess bypass, " + c(this, r110, null, "missing_display_id", null, null, 26));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        long r103 = a();     // Catch: Throwable -> L17
        this.f418443b = r101;     // Catch: Throwable -> L17
        this.f418444c = System.currentTimeMillis() + (((long) 1000) * r103);     // Catch: Throwable -> L17
        int r104 = ScsLogger.f440428a;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "onPingSuccess cooling start, " + c(this, r110, r101, "ping_success", Long.valueOf(r103), null, 16));     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public final a d(InternalSecurityAction r110, String r111) {
        if (r110 == null) goto L7;
        DecisionData.Action r100 = r110.getCurrentAction();
        if (r100 == null) goto L7;
        String r101 = r100.getName();
    L9:
        if (Intrinsics.areEqual(r101, "ACCESS_CONTROL_ACTION_COMMON") == true) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r110.getCurrentAction().getParams().get("policyType"), "POLICY_CENTER") == true) goto L15;
        return null;
    L15:
        if (Intrinsics.areEqual(r110.getCurrentAction().getParams().get("containerType"), "page") == true) goto L17;
        return null;
    L17:
        String r102 = r110.getCurrentAction().getParams().get("displayID");
        if (r102 != null) goto L20;
    L30:
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyCenterDisplayIdActionGate", "bypass, " + c(this, r110, null, "missing_display_id", null, r111, 10));
        return null;
    L20:
        if (r102.length() <= 0) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == true) goto L26;
        r102 = null;
    L26:
        if (r102 == null) goto L30;
        return new a(r102);
    L22:
        r104 = false;
    L7:
        r101 = null;
        goto L9
    }

    public static String c(d r100, InternalSecurityAction r101, a r102, String r103, Long r104, String r105, int r106) {
        String r107 = null;
        if ((r106 & 2) == 0) goto L5;
        r102 = null;
    L5:
        Long r108 = r104;
        if ((r106 & 8) == 0) goto L9;
        r108 = null;
    L9:
        if ((r106 & 16) == 0) goto L11;
        r105 = "gate";
    L11:
        r100.getClass();
        if (r101 == null) goto L16;
        DecisionData.Action r109 = r101.getCurrentAction();
        if (r109 == null) goto L16;
        Map<String, String> r110 = r109.getParams();
    L17:
        if (r110 != null) goto L19;
        r110 = MapsKt.emptyMap();
    L19:
        StringBuilder r111 = new StringBuilder("userID=");
        r111.append(r100.f418442a);
        r111.append(", displayID=");
        if (r102 == null) goto L23;
        String r112 = r102.f418445a;
        if (r112 == null) goto L23;
    L26:
        r111.append(r112);
        r111.append(", traceId=");
        if (r101 == null) goto L29;
        r107 = r101.getTraceId();
    L29:
        if (r107 != null) goto L31;
        r107 = "";
    L31:
        r111.append(r107);
        r111.append(", logID=, containerType=");
        String r113 = r110.get("containerType");
        if (r113 != null) goto L34;
        r113 = "";
    L34:
        r111.append(r113);
        r111.append(", policyType=");
        String r114 = r110.get("policyType");
        if (r114 != null) goto L37;
        r114 = "";
    L37:
        r111.append(r114);
        r111.append(", challengeType=");
        String r115 = r110.get("challengeType");
        if (r115 != null) goto L40;
        r115 = "";
    L40:
        r111.append(r115);
        r111.append(", source=");
        r111.append(r105);
        r111.append(", reason=");
        r111.append(r103);
        r111.append(", coolingSeconds=");
        Object r116 = r108;
        if (r108 != null) goto L43;
        r116 = "";
    L43:
        r111.append(r116);
        return r111.toString();
    L23:
        r112 = r110.get("displayID");
        if (r112 != null) goto L26;
        r112 = "";
    L16:
        r110 = null;
        goto L17
    }
}
