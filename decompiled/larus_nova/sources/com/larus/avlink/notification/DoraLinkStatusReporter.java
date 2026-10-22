package com.larus.avlink.notification;

import com.larus.applog.api.IApplog;
import com.larus.avlink.n1;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes25.dex */
public final class DoraLinkStatusReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraLinkStatusReporter f293453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f293454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f293455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f293456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MutexImpl f293457e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f293458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f293459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f293460c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f293458a == r101.f293458a) goto L12;
            return false;
        L12:
            if (this.f293459b == r101.f293459b) goto L15;
            return false;
        L15:
            if (this.f293460c == r101.f293460c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f293458a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f293459b) * 31) + this.f293460c;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "LinkStatus(link=" + this.f293458a + ", idleState=" + this.f293459b + ", currentIdleState=" + this.f293460c + ')';
        }

        public a(boolean r100, int r101, int r102) {
            this.f293458a = r100;
            this.f293459b = r101;
            this.f293460c = r102;
        }
    }

    public DoraLinkStatusReporter() {
    }

    static {
        f293453a = new DoraLinkStatusReporter();
        f293457e = kotlinx.coroutines.sync.b.a();
    }

    public static void b(boolean r100) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraLinkStatusReporter$reportMicOccupyStatus$1(r100, null), 2, null);
    }

    public static void c(boolean r100, Integer r101, Integer r102) {
        IApplog.Companion r103 = IApplog.f287053a;
        boolean r104 = false;
        if (r103.getUserID().length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        return;
    L8:
        if (r103.getDeviceId().length() != 0) goto L10;
        r104 = true;
    L10:
        if (r104 == true) goto L21;
        if (r101 != null) goto L14;
        return;
    L14:
        int r106 = r101.intValue();
        if (r102 == null) goto L17;
        int r107 = r102.intValue();
    L18:
        a r108 = new a(r100, r106, r107);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraLinkStatusReporter$reportStatus$1(r108, null), 2, null);
        return;
    L17:
        r107 = -1;
        goto L18
    L21:
        return;
    L5:
        r105 = false;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0176 -> B:13:0x0046). Please report as a decompilation issue!!! */
    public static final Object a(DoraLinkStatusReporter r210, boolean r211, int r212, int r213, int r214, Continuation r215) {
        r210.getClass();
        if ((r215 instanceof DoraLinkStatusReporter$doReport$1) == false) goto L7;
        DoraLinkStatusReporter$doReport$1 r100 = (DoraLinkStatusReporter$doReport$1) r215;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "DoraLinkStatusReporter";
        if (r104 == 0) goto L21;
        if (r104 == 1) goto L16;
        if (r104 != 2) goto L15;
        int r106 = r100.I$2;
        int r107 = r100.I$1;
        int r110 = r100.I$0;
        b r111 = (b) r100.L$1;
        BizResponse r112 = (BizResponse) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L13:
        String r113 = r105;
        int r108 = r110;
        b r114 = r111;
        BizResponse r115 = r112;
        if (r106 == 0) goto L68;
    L71:
        DoraLinkApi.a r109 = DoraLinkApi.f293451a;     // Catch: Exception -> L55
        DoraLinkStatusReporter$doReport$response$1 r116 = new DoraLinkStatusReporter$doReport$response$1(r114, null);     // Catch: Exception -> L55
        r100.L$0 = r115;     // Catch: Exception -> L55
        r100.L$1 = r114;     // Catch: Exception -> L55
        r100.I$0 = r108;     // Catch: Exception -> L55
        r100.I$1 = r107;     // Catch: Exception -> L55
        r100.label = 1;     // Catch: Exception -> L55
        r109.getClass();     // Catch: Exception -> L55
        DoraLinkApi.a r117 = DoraLinkApi.a.f293452a;     // Catch: Exception -> L55
        FlowHttpConnection r118 = FlowHttpConnection.f359975a;     // Catch: Exception -> L55
        BizResponse r119 = r115;
        b r216 = r114;
        Object r120 = FlowHttpConnection.g(ServiceType.AUDIO, DoraLinkApi.class, r116, false, null, null, null, r100, 248);     // Catch: Exception -> L53
        if (r120 == r103) goto L76;
        r110 = r108;
        r105 = r113;
        r112 = r119;
        r111 = r216;
        r102 = r120;
    L46:
        dm9.a r121 = (dm9.a) r102;     // Catch: Exception -> L19
        if ((r121 instanceof dm9.a.b) == false) goto L49;
        r112 = ((dm9.a.b) r121).f469231a;     // Catch: Exception -> L19
    L61:
        r106 = 0;
        if (0 == 0) goto L13;
        r107 = r107 + 1;
        r100.L$0 = r112;
        r100.L$1 = r111;
        r100.I$0 = r110;
        r100.I$1 = r107;
        r100.I$2 = 0;
        r100.label = 2;
        if (DelayKt.delay(1000, r100) != r103) goto L13;
        return r103;
    L49:
        StringBuilder r122 = new StringBuilder();     // Catch: Exception -> L19
        r122.append("Request failed with code: ");     // Catch: Exception -> L19
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type com.larus.network.bean.HttpDataResult.Error");     // Catch: Exception -> L19
        r122.append(((dm9.a.C5690a) r121).f469230c);     // Catch: Exception -> L19
        n1.b(r105, r122.toString());     // Catch: Exception -> L19
        if (r107 >= r110) goto L61;
    L60:
        r106 = 1;
        if (1 == 0) goto L13;
    L19:
        Exception e100 = e;
        r108 = r110;
        b r123 = r111;
        BizResponse r124 = r112;
    L58:
        n1.b(r105, "Network request failed: " + e100.getMessage());
        r110 = r108;
        r112 = r124;
        r111 = r123;
        if (r107 >= r108) goto L61;
    L76:
        return r103;
    L53:
        e100 = e;
    L57:
        r105 = r113;
        r124 = r119;
        r123 = r216;
    L55:
        e100 = e;
        r119 = r115;
        r216 = r114;
        goto L57
    L68:
        return r115;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r107 = r100.I$1;
        r110 = r100.I$0;
        r111 = (b) r100.L$1;
        r112 = (BizResponse) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L19
        goto L46
    L21:
        ResultKt.throwOnFailure(r102);
        IApplog.Companion r125 = IApplog.f287053a;
        String r126 = r125.getUserID();
        String r127 = r125.getDeviceId();
        Boolean r128 = Boxing.boxBoolean(r211);
        if ((r212 & 1) == 0) goto L24;
        boolean r129 = true;
    L25:
        Boolean r130 = Boxing.boxBoolean(r129);
        if ((r212 & 2) == 0) goto L28;
        boolean r131 = true;
    L29:
        Boolean r132 = Boxing.boxBoolean(r131);
        Boolean r133 = Boxing.boxBoolean(false);
        if (r213 != (-1)) goto L32;
    L34:
        boolean r134 = false;
    L35:
        Boolean r217 = Boxing.boxBoolean(r134);
        if (r213 == (-1)) goto L38;
        boolean r135 = true;
    L39:
        b r136 = new b(r126, r127, r128, r130, r132, r133, r217, Boxing.boxBoolean(r135));
        n1.d("DoraLinkStatusReporter", "doReport post:" + r136);
        r114 = r136;
        r115 = null;
        r113 = "DoraLinkStatusReporter";
        r107 = 0;
        r108 = r214;
        goto L71
    L38:
        r135 = false;
        goto L39
    L32:
        if ((r213 & 1) == 0) goto L34;
        r134 = true;
        goto L35
    L28:
        r131 = false;
        goto L29
    L24:
        r129 = false;
    L7:
        r100 = new DoraLinkStatusReporter$doReport$1(r210, r215);
        goto L8
    }
}
