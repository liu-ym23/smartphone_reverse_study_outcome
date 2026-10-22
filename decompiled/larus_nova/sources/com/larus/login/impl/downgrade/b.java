package com.larus.login.impl.downgrade;

import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.login.api.h0;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.platform.api.r0;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f357660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<h0> f357661b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<r0> f357662c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f357663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f357664e;

    public b() {
    }

    static {
        f357660a = new b();
        f357661b = new CopyOnWriteArrayList();
        f357662c = new CopyOnWriteArrayList();
    }

    public final Object a(Continuation r110) {
        if ((r110 instanceof FlowLoginQuotaManager$refreshQuotaState$1) == false) goto L7;
        FlowLoginQuotaManager$refreshQuotaState$1 r100 = (FlowLoginQuotaManager$refreshQuotaState$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        FlowLoginQuotaManager$refreshQuotaState$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L25:
        dm9.a r112 = (dm9.a) r111;
        boolean r105 = r112 instanceof dm9.a.b;
        String r106 = "";
        int r107 = 0;
        if (r105 == false) goto L40;
        dm9.a.b r108 = (dm9.a.b) r112;
        if (r108.f469231a.isSuccess() == false) goto L40;
        QuotaStateResponse r113 = (QuotaStateResponse) r108.f469231a.getData();
        if (r113 == null) goto L34;
        Integer r114 = r113.getQuotaState();
        if (r114 == null) goto L34;
        r107 = r114.intValue();
    L34:
        f357663d = r107;
        Iterator<h0> r115 = f357661b.iterator();
    L36:
        if (r115.hasNext() == false) goto L38;
        r115.next().a(f357663d);
        goto L36
    L38:
        a.b(true, Boxing.boxInt(r107), 0, "");
    L50:
        return Unit.INSTANCE;
    L40:
        if ((r112 instanceof dm9.a.C5690a) == false) goto L42;
        dm9.a.C5690a r116 = (dm9.a.C5690a) r112;
        a.b(false, null, r116.f469228a, r116.f469229b);
    L48:
        FLogger.f375446a.e("FlowLoginQuotaManager", "refreshQuotaState error");
        goto L50
    L42:
        if (r105 == false) goto L48;
        dm9.a.b r117 = (dm9.a.b) r112;
        long r109 = r117.f469231a.getCode();
        String r118 = r117.f469231a.getMsg();
        if (r118 == null) goto L47;
        r106 = r118;
    L47:
        a.b(false, null, r109, r106);
        goto L48
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        boolean r119 = Intrinsics.areEqual(PollingConfigService.f326423a.f("login_dg"), "1");
        f357664e = r119;
        if (r119 == false) goto L22;
        Iterator<h0> r120 = f357661b.iterator();
    L18:
        if (r120.hasNext() == false) goto L21;
        r120.next().a(5);
        goto L18
    L21:
        return Unit.INSTANCE;
    L22:
        QuotaApi.a r121 = QuotaApi.f357658a;
        FlowLoginQuotaManager$refreshQuotaState$result$1 r122 = new FlowLoginQuotaManager$refreshQuotaState$result$1(null);
        r102.label = 1;
        r121.getClass();
        FlowHttpConnection r123 = FlowHttpConnection.f359975a;
        r111 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, QuotaApi.class, r122, true, null, null, null, r102, 240);
        if (r111 != r103) goto L25;
        return r103;
    L7:
        r100 = new FlowLoginQuotaManager$refreshQuotaState$1(this, r110);
        goto L8
    }
}
