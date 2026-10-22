package com.larus.suggest.impl.wcb.request;

import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.common.apphost.AppHost;
import com.larus.suggest.impl.wcb.policy.y;
import com.larus.suggest.impl.wcb.policy.z;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f370091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f370092b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<a, Deferred<e>> f370093c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f370095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f370096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f370097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f370098e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f370094a, r101.f370094a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f370095b, r101.f370095b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f370096c, r101.f370096c) == true) goto L18;
            return false;
        L18:
            if (this.f370097d == r101.f370097d) goto L21;
            return false;
        L21:
            if (this.f370098e == r101.f370098e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f370094a.hashCode() * 31) + this.f370095b.hashCode()) * 31) + this.f370096c.hashCode()) * 31) + this.f370097d) * 31) + this.f370098e;
        }

        public final String toString() {
            return "RequestKey(userId=" + this.f370094a + ", scope=" + this.f370095b + ", botId=" + this.f370096c + ", scene=" + this.f370097d + ", requestScene=" + this.f370098e + ')';
        }

        public a(String r100, String r101, String r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, "scope");
            Intrinsics.checkNotNullParameter(r102, "botId");
            this.f370094a = r100;
            this.f370095b = r101;
            this.f370096c = r102;
            this.f370097d = r103;
            this.f370098e = r104;
        }
    }

    public b() {
    }

    static {
        f370091a = new b();
        f370092b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        f370093c = new LinkedHashMap();
    }

    public static a c(f r100) {
        return new a(r100.f370113a, r100.f370118f.f370099a.h().j(r100), r100.f370115c, r100.f370118f.f370099a.getScene(), r100.f370118f.f370104f);
    }

    public static final void b(f r100, e r101) {
        y r102 = r100.f370118f.f370099a.h();
        NexPulseResponseData r103 = r101.getResponse();
        e.c r104 = null;
        if (r103 == null) goto L5;
        NexPulseConf r105 = r103.getConf();
    L6:
        r102.d(r100, r105);
        if ((r101 instanceof e.c) == false) goto L9;
        r104 = (e.c) r101;
    L9:
        if (r104 == null) goto L26;
        NexPulseResponseData r106 = r104.f370112a;
        if (r106 == null) goto L28;
        long r107 = AppHost.f326268a.getAppClock().currentTimeMillis() / 1000;
        if (r106.isValid() == false) goto L27;
        NexPulseConf r108 = r106.getConf();
        if (r108 == null) goto L20;
        Long r109 = r108.getExpireTime();
        if (r109 == null) goto L20;
        long r110 = r109.longValue();
    L22:
        if (r110 <= r107) goto L29;
        r102.a(r100, r106, System.currentTimeMillis());
        FLogger.f375446a.d("WcbLog", "[network] cached scene=" + r100.f370118f.f370099a.getScene() + " exec=" + r100.f370117e);
        return;
    L29:
        return;
    L20:
        r110 = 0;
        goto L22
    L27:
        return;
    L28:
        return;
    L26:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static final Object a(b r110, f r111, long r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof WcbNetworkRequester$fetch$1) == false) goto L7;
        WcbNetworkRequester$fetch$1 r100 = (WcbNetworkRequester$fetch$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        r111 = (f) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L17:
        Pair r116 = (Pair) r114;
        NexPulseResponseData r117 = (NexPulseResponseData) r116.component1();
        com.larus.suggest.impl.repo.a.C4499a r118 = (com.larus.suggest.impl.repo.a.C4499a) r116.component2();
        if (r118 == null) goto L20;
        r115 = new e.b(r118, r117);
    L24:
        FLogger.f375446a.d("WcbLog", "[pipeline] network.end chat=" + r111.f370116d + " exec=" + r111.f370117e + " result=" + r115.getClass().getSimpleName());
    L25:
        return r115;
    L20:
        if (r117 == null) goto L22;
        Object r119 = new e.c(r117);
    L23:
        r115 = r119;
        goto L24
    L22:
        r119 = e.a.f370109a;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        z r120 = r111.f370118f.f370099a;
        r120.h().h(r111, r112, System.currentTimeMillis());
        FLogger.f375446a.d("WcbLog", "[pipeline] network.start chat=" + r111.f370116d + " exec=" + r111.f370117e);
        CoroutineDispatcher r121 = Dispatchers.getIO();
        WcbNetworkRequester$fetch$2 r122 = new WcbNetworkRequester$fetch$2(r111, r120, null);
        r100.L$0 = r111;
        r100.label = 1;
        r114 = BuildersKt.withContext(r121, r122, r100);
        if (r114 != r115) goto L17;
    L7:
        r100 = new WcbNetworkRequester$fetch$1(r110, r113);
        goto L8
    }
}
