package com.larus.avlink.plugins;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.settings.value.e10;
import com.larus.settings.value.zo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes25.dex */
public final class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Function1<Boolean, Unit>, k4> f294117a = null;

    public x2() {
    }

    static {
        f294117a = new LinkedHashMap();
    }

    public static int a() {
        e10 r100 = e10.f368561a;
        int r101 = com.larus.utils.l0.f375430a;
        Integer r102 = Integer.valueOf(((Number) com.larus.utils.l0.a(45, new zo())).intValue());
        if (r102.intValue() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 != null) goto L11;
        return 45;
    L11:
        return r102.intValue();
    L5:
        r103 = false;
        goto L6
    }

    public static v2 b() {
        e10 r100 = e10.f368561a;
        nu9.r r101 = e10.P();
        return new v2(r101.e(), r101.d(), r101.f());
    }

    public static IDoraService c() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    public static void d(k4 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IDoraService r101 = c();
        if (r101 == null) goto L8;
        SessionService r102 = r101.d();
        if (r102 == null) goto L9;
        r102.i(r100);
        return;
    L9:
        return;
    }

    public static void f(int r100) {
        IDoraService r101 = c();
        if (r101 == null) goto L8;
        DeviceService r102 = r101.device();
        if (r102 == null) goto L9;
        r102.E0(r100);
        return;
    L9:
        return;
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IDoraService r101 = c();
        if (r101 == null) goto L8;
        SessionService r102 = r101.d();
        if (r102 == null) goto L9;
        r102.t(r100, null);
        return;
    L9:
        return;
    }

    public static void k(k4 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IDoraService r101 = c();
        if (r101 == null) goto L8;
        SessionService r102 = r101.d();
        if (r102 == null) goto L9;
        r102.x(r100);
        return;
    L9:
        return;
    }

    public static void e(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        IDoraService r102 = c();
        if (r102 == null) goto L6;
        r102.A0(r100, r101);
        return;
    }

    public static void i(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter("RESET", "event");
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        IDoraService r102 = c();
        if (r102 == null) goto L8;
        SessionService r103 = r102.d();
        if (r103 == null) goto L9;
        r103.u("RESET", r100, Integer.valueOf(r101));
        return;
    L9:
        return;
    }

    public static void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IDoraService r102 = c();
        if (r102 == null) goto L8;
        SessionService r103 = r102.d();
        if (r103 == null) goto L9;
        r103.v(r100, r101);
        return;
    L9:
        return;
    }

    public static void g(int r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "params");
        IDoraService r103 = c();
        if (r103 == null) goto L12;
        SessionService r104 = r103.d();
        if (r104 != null) goto L8;
        return;
    L8:
        if (r102.isEmpty() == false) goto L10;
        r104.r(r100, r101);
        return;
    L10:
        r104.s(r100, r102, r101);
        return;
    }

    public static Object l(int r100, int r101, boolean r102, Continuation r103) {
        IDoraService r104 = c();
        if (r104 == null) goto L12;
        SessionService r105 = r104.d();
        if (r105 == null) goto L12;
        Deferred<Integer> r106 = r105.y(r100, r101, r102);
        if (r106 == null) goto L12;
        Object r107 = r106.await(r103);
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r107;
    L14:
        return (Integer) r107;
    L12:
        return null;
    }
}
