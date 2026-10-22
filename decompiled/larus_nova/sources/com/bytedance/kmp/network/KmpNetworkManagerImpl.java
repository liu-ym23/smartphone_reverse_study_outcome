package com.bytedance.kmp.network;

import com.bytedance.kmp.network.cinterop.KmpNativeNetworkService;
import com.bytedance.kmp.network.p009public.BizInterceptorManager;
import com.bytedance.kmp.network.response.h;
import com.bytedance.kmp.network.util.NLog;
import com.bytedance.retrofit2.client.Request;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes19.dex */
public final class KmpNetworkManagerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f252469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final buc.c f252470b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252471a = null;

        static {
            int[] r100 = new int[Protocol.values().length];
            r100[Protocol.HTTP_1_0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Protocol.HTTP_1_1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Protocol.HTTP_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Protocol.QUIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f252471a = r100;
        }
    }

    public KmpNetworkManagerImpl(c r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f252469a = r100;
        this.f252470b = buc.b.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(com.bytedance.kmp.network.response.d r100, Continuation<? super com.bytedance.kmp.network.response.d> r101) {
        if ((r101 instanceof KmpNetworkManagerImpl$postProcessResponse$1) == false) goto L7;
        KmpNetworkManagerImpl$postProcessResponse$1 r102 = (KmpNetworkManagerImpl$postProcessResponse$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 != 0) goto L11;
        ResultKt.throwOnFailure(r104);
        r100.f252563a.f498628e.getClass();
        return r100;
    L11:
        if (r106 != 1) goto L22;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r102.L$2;
        Iterator r108 = (Iterator) r102.L$1;
        Ref.ObjectRef r109 = (Ref.ObjectRef) r102.L$0;
        ResultKt.throwOnFailure(r104);
        T r110 = r104;
    L13:
        r107.element = r110;
        if (r108.hasNext() == false) goto L19;
        com.bytedance.kmp.network.response.c r111 = (com.bytedance.kmp.network.response.c) r108.next();
        h r112 = (h) r109.element;
        r102.L$0 = r109;
        r102.L$1 = r108;
        r102.L$2 = r109;
        r102.label = 1;
        Object r113 = r111.intercept();
        if (r113 == r105) goto L17;
        r107 = r109;
        r110 = r113;
        goto L13
    L17:
        return r105;
    L19:
        ((h) r109.element).getClass();
        throw new IllegalArgumentException("Request cannot be null".toString());
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r102 = new KmpNetworkManagerImpl$postProcessResponse$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, jd6.e] */
    public final Object c(jd6.c r210, Continuation<? super jd6.c> r211) {
        jd6.c r100 = r210;
        if ((r211 instanceof KmpNetworkManagerImpl$preprocessRequest$1) == false) goto L7;
        KmpNetworkManagerImpl$preprocessRequest$1 r101 = (KmpNetworkManagerImpl$preprocessRequest$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        String r107 = "1";
        if (r105 == 0) goto L22;
        if (r105 == 1) goto L21;
        if (r105 != 2) goto L20;
        Ref.ObjectRef r108 = (Ref.ObjectRef) r101.L$2;
        Iterator r109 = (Iterator) r101.L$1;
        Ref.ObjectRef r110 = (Ref.ObjectRef) r101.L$0;
        ResultKt.throwOnFailure(r103);
        T r111 = r103;
    L13:
        r108.element = r111;
        if (r109.hasNext() == false) goto L71;
        jd6.b r112 = (jd6.b) r109.next();
        jd6.e r113 = (jd6.e) r110.element;
        r101.L$0 = r110;
        r101.L$1 = r109;
        r101.L$2 = r110;
        r101.label = 2;
        Object r114 = r112.intercept();
        if (r114 == r104) goto L17;
        r108 = r110;
        r111 = r114;
        goto L13
    L17:
        return r104;
    L71:
        return ((jd6.e) r110.element).a();
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r100 = (jd6.c) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r115 = r103;
    L30:
        jd6.c r116 = (jd6.c) r115;
        jd6.c r117 = r100;
        r100 = r116;
    L32:
        Ref.ObjectRef r118 = new Ref.ObjectRef();
        r100.getClass();
        r118.element = new jd6.e(r100);
        Map<String, String> r119 = MapsKt.toMutableMap(r100.f498626c);
        jd6.e r120 = (jd6.e) r118.element;
        int r121 = com.bytedance.kmp.network.p009public.c.f252560a;
        r117.f498628e.getClass();
        Protocol r122 = r117.f498628e.f498643h;
        if (r122 == Protocol.UNKNOWN) goto L45;
        int r123 = a.f252471a[r122.ordinal()];
        if (r123 == 1) goto L43;
        if (r123 == 2) goto L43;
        if (r123 != 3) goto L39;
        r107 = "2";
        goto L43
    L39:
        if (r123 == 4) goto L41;
        r107 = null;
        goto L43
    L41:
        r107 = "3";
    L43:
        if (r107 == null) goto L45;
        r119.put(DownloadHelper.TTNET_PROTO_TYPE, r107);
    L45:
        r120.getClass();
        Intrinsics.checkNotNullParameter(r119, "headers");
        r120.f498632c = r119;
        r100.f498628e.getClass();
        String r124 = r100.f498628e.f498641f;
        if (r124.length() != 0) goto L48;
        boolean r125 = true;
    L49:
        if (r125 == false) goto L53;
        return ((jd6.e) r118.element).a();
    L53:
        if (r124.length() > 0) goto L56;
        r106 = false;
    L56:
        if (r106 == false) goto L69;
        jd6.e r126 = (jd6.e) r118.element;
        String r127 = r100.f498624a;
        int r128 = StringsKt.indexOf$default(r127, "://", 0, false, 6, null);
        String r129 = "";
        if (r128 == (-1)) goto L60;
        String r130 = r127.substring(0, r128 + 3);
    L61:
        int r131 = StringsKt.indexOf$default(r127, '/', r130.length(), false, 4, null);
        if (r131 == (-1)) goto L65;
        r129 = r127.substring(r131);
    L65:
        if (StringsKt.contains$default(r124, "http", false, 2, null) == false) goto L67;
        String r132 = r124 + r129;
    L68:
        r126.getClass();
        Intrinsics.checkNotNullParameter(r132, "url");
        r126.f498630a = r132;
        goto L69
    L67:
        r132 = r130 + r124 + r129;
        goto L68
    L60:
        r130 = "";
    L69:
        r110 = r118;
        goto L71
    L48:
        r125 = false;
        goto L49
    L22:
        ResultKt.throwOnFailure(r103);
        jd6.f r133 = r100.f498628e;
        r133.f498642g = this.f252470b.c();
        if ((this.f252469a instanceof KmpNativeNetworkService) == false) goto L25;
        r133.f498644i = true;
    L25:
        Lazy r134 = KmpNetworkUtils.f252474a;
        Intrinsics.checkNotNullParameter(r100, "request");
        if (Intrinsics.areEqual(r100.f498626c.get(Request.KEY_BYPASS_TTNET_FEATURES), "1") == true) goto L31;
        BizInterceptorManager r135 = BizInterceptorManager.f252555a;
        r101.L$0 = r100;
        r101.label = 1;
        Object r136 = r135.a(r100, r101);
        r115 = r136;
        if (r136 != r104) goto L30;
        return r104;
    L31:
        r117 = r100;
    L7:
        r101 = new KmpNetworkManagerImpl$preprocessRequest$1(this, r211);
        goto L8
    }

    public final Object a(jd6.c r100, boolean r101, Continuation<? super com.bytedance.kmp.network.response.d> r102) {
        NLog.Level r103 = NLog.f252570a;
        NLog.Level r104 = NLog.Level.DEBUG;
        if (r104.compareTo(NLog.f252570a) < 0) goto L9;
        String r105 = "network_service execute".toString();
        if (r105 != null) goto L7;
        r105 = "null";
    L7:
        System.out.println("[" + StringsKt.first(r104.name()) + "][kmp-ttnet] " + r105);
    L9:
        return BuildersKt.withContext(Dispatchers.getIO(), new KmpNetworkManagerImpl$execute$3(r100, this, r101, null), r102);
    }
}
