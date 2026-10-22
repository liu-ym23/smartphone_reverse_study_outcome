package com.bytedance.kmp.network.cinterop;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.kmp.network.KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1;
import com.bytedance.kmp.network.NetError;
import com.bytedance.kmp.network.Protocol;
import com.bytedance.kmp.network.nqe.EffectiveConnectionType;
import com.bytedance.kmp.network.response.i;
import com.bytedance.kmp.network.util.NLog;
import com.bytedance.retrofit2.client.Request;
import com.example.interopdemo.SsHttpCall;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.MutexImpl;
import okio.Buffer;

/* JADX INFO: loaded from: classes19.dex */
public final class KmpNativeNetworkService implements com.bytedance.kmp.network.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f252487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<jd6.c, SsHttpCall> f252488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, SsHttpCall> f252489d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.kmp.network.nqe.a f252490a;

        public a(com.bytedance.kmp.network.nqe.a r100) {
            this.f252490a = r100;
        }
    }

    @Override // com.bytedance.kmp.network.c
    public final com.bytedance.kmp.network.nqe.b O2() {
        Lazy r100 = com.example.interopdemo.e.f274034a;
        ((mt7.a) r100.getValue()).f515649a.getClass();
        ((mt7.a) r100.getValue()).f515649a.getClass();
        ((mt7.a) r100.getValue()).f515649a.getClass();
        EffectiveConnectionType.Companion.getClass();
        EffectiveConnectionType[] r101 = EffectiveConnectionType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        EffectiveConnectionType r104 = r101[r103];
        if (r104.getValue() != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L12;
        r103 = r103 + 1;
    L12:
        if (r104 != null) goto L15;
        r104 = EffectiveConnectionType.UNKNOWN;
    L15:
        return new com.bytedance.kmp.network.nqe.b(r104, new com.bytedance.kmp.network.nqe.d(-1, -1, -1), new com.bytedance.kmp.network.nqe.c(-1, -1.0d, -1.0d, -1.0d, -1.0d), 4);
    L7:
        r105 = false;
        goto L8
    L11:
        r104 = null;
        goto L12
    }

    public KmpNativeNetworkService() {
        this.f252487b = kotlinx.coroutines.sync.b.a();
        this.f252488c = new LinkedHashMap();
        this.f252489d = new LinkedHashMap();
    }

    public static nt7.a k0(jd6.c r110) {
        ArrayList r100 = new ArrayList();
        String r101 = r110.f498624a;
        Intrinsics.checkNotNullParameter(r101, "url");
        String r102 = r110.f498625b;
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
        jd6.d r103 = r110.f498627d;
        if (r103 == null) goto L5;
        String r104 = r103.contentType();
        Buffer r105 = new Buffer();
        r103.writeTo(r105);
        byte[] r106 = r105.readByteArray();
        Intrinsics.checkNotNullParameter(r106, HTTP.CONTENT_RANGE_BYTES);
        int r107 = nt7.b.f520525a;
        Intrinsics.checkNotNullParameter(r106, HTTP.CONTENT_RANGE_BYTES);
        nt7.b.a r108 = new nt7.b.a(r106, r104);
    L6:
        Iterator<Map.Entry<String, String>> r109 = r110.f498626c.entrySet().iterator();
    L8:
        if (r109.hasNext() == false) goto L15;
        Map.Entry<String, String> r111 = r109.next();
        if (Intrinsics.areEqual(r111.getKey(), Request.KEY_BYPASS_TTNET_COOKIE_HEADER) == false) goto L14;
        if (Intrinsics.areEqual(r111.getValue(), "1") == false) goto L14;
        Intrinsics.checkNotNullParameter(Request.KEY_BYPASS_TTNET_COOKIE_HEADER, "key");
        Intrinsics.checkNotNullParameter("0", "value");
        r100.add(new Pair(Request.KEY_BYPASS_TTNET_COOKIE_HEADER, "0"));
    L14:
        String r112 = r111.getKey();
        String r113 = r111.getValue();
        Intrinsics.checkNotNullParameter(r112, "key");
        Intrinsics.checkNotNullParameter(r113, "value");
        r100.add(new Pair(r112, r113));
        goto L8
    L15:
        jd6.f r114 = r110.f498628e;
        int r115 = (int) r114.f498639d;
        int r116 = (int) r114.f498636a;
        int r117 = (int) r114.f498637b;
        int r118 = (int) r114.f498638c;
        boolean r119 = false;
        if (r101.length() != 0) goto L18;
        boolean r120 = true;
    L19:
        if (r120 == true) goto L38;
        if (r108 == null) goto L36;
        String r121 = r108.f520527c;
        if (r121 == null) goto L36;
        if (r100.isEmpty() == true) goto L32;
        Iterator r122 = r100.iterator();
    L28:
        if (r122.hasNext() == false) goto L32;
        if (StringsKt.equals((String) ((Pair) r122.next()).getFirst(), "Content-Type", true) == false) goto L28;
    L33:
        if (r119 == false) goto L36;
        r100.add(TuplesKt.to("Content-Type", r121));
    L32:
        r119 = true;
    L36:
        return new nt7.a(r101, r102, r100, r108, r115, r116, r117, r118);
    L38:
        throw new IllegalArgumentException("URL must not be empty");
    L18:
        r120 = false;
        goto L19
    L5:
        r108 = null;
        goto L6
    }

    public static List u(ot7.a r100) {
        List<Pair<String, String>> r101 = r100.f526682c;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Pair r104 = (Pair) r103.next();
        com.bytedance.kmp.network.b r105 = new com.bytedance.kmp.network.b();
        String r106 = (String) r104.getFirst();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f252479a = r106;
        String r107 = (String) r104.getSecond();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f252480b = r107;
        r102.add(r105);
        goto L4
    L6:
        return r102;
    }

    public static NetError z0(ot7.a r100) {
        NetError r101 = new NetError();
        r101.setCronetInternalError(r100.f526686g);
        r101.setTtnetStatusCode(r100.f526681b);
        r101.setCronetRequestLog(r100.f526685f);
        r101.setErrorMessage(r100.f526687h);
        r101.setErrorRespHeader(u(r100));
        r101.setErrorRespBody(r100.f526683d);
        return r101;
    }

    @Override // com.bytedance.kmp.network.c
    public final void Z2(com.bytedance.kmp.network.nqe.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Lazy r101 = com.example.interopdemo.e.f274034a;
        a r102 = new a(r100);
        Intrinsics.checkNotNullParameter(r102, "listener");
        System.out.println("registerNQEListener " + r102);
        mt7.a r103 = (mt7.a) com.example.interopdemo.e.f274034a.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "nativeListener");
        System.out.println("registerNQEListener " + r102);
        r103.f515649a.getClass();
        Intrinsics.checkNotNullParameter(r103, "listener");
    }

    public static com.bytedance.kmp.network.response.d H2(ot7.a r110, jd6.c r111) {
        List r100 = u(r110);
        Intrinsics.checkNotNullParameter("Content-Type", "key");
        Iterator<T> r101 = r110.f526682c.iterator();
    L3:
        boolean r102 = true;
        if (r101.hasNext() == false) goto L8;
        Object r103 = r101.next();
        if (StringsKt.equals((String) ((Pair) r103).getFirst(), "Content-Type", true) == false) goto L3;
    L9:
        Pair r104 = (Pair) r103;
        if (r104 == null) goto L12;
        String r105 = (String) r104.getSecond();
    L12:
        com.bytedance.kmp.network.cinterop.a r106 = new com.bytedance.kmp.network.cinterop.a(r110.f526683d);
        if (r110.f526686g == 0) goto L15;
    L21:
        if (r102 == false) goto L23;
        NetError r107 = z0(r110);
    L25:
        return new com.bytedance.kmp.network.response.d(r111, Protocol.UNKNOWN, r110.f526685f, r110.f526681b, r100, r106, r107, new com.bytedance.kmp.network.e());
    L23:
        r107 = null;
        goto L25
    L15:
        if (r110.f526687h.length() <= 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == true) goto L21;
        r102 = false;
        goto L21
    L17:
        r108 = false;
        goto L18
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.kmp.network.c
    public final Object Z1(jd6.c r110, Continuation<? super com.bytedance.kmp.network.response.d> r111) {
        if ((r111 instanceof KmpNativeNetworkService$execute$1) == false) goto L7;
        KmpNativeNetworkService$execute$1 r100 = (KmpNativeNetworkService$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r112 = "null";
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        int r105 = r100.I$0;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$2;
        Throwable r107 = (Throwable) r100.L$1;
        jd6.c r108 = (jd6.c) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L95:
        if (r105 <= 0) goto L84;
        SsHttpCall r109 = this.f252489d.remove(Boxing.boxInt(r105));     // Catch: Throwable -> L87
    L85:
        r106.unlock(null);
        throw r107;
    L84:
        SsHttpCall r113 = this.f252488c.remove(r108);     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r114 = r100.I$0;
        kotlinx.coroutines.sync.a r115 = (kotlinx.coroutines.sync.a) r100.L$2;
        com.bytedance.kmp.network.response.d r116 = (com.bytedance.kmp.network.response.d) r100.L$1;
        jd6.c r117 = (jd6.c) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L97:
        if (r114 <= 0) goto L69;
        SsHttpCall r118 = this.f252489d.remove(Boxing.boxInt(r114));     // Catch: Throwable -> L72
    L70:
        r115.unlock(null);
        return r116;
    L69:
        SsHttpCall r119 = this.f252488c.remove(r117);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        r115.unlock(null);
        throw th;
    L18:
        int r120 = r100.I$0;
        jd6.c r121 = (jd6.c) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L21
    L53:
        ot7.a r122 = (ot7.a) r102;     // Catch: Throwable -> L21
        NLog.Level r123 = NLog.f252570a;     // Catch: Throwable -> L21
        NLog.Level r124 = NLog.Level.DEBUG;     // Catch: Throwable -> L21
        if (r124.compareTo(NLog.f252570a) < 0) goto L62;
        String r125 = "KmpNativeNetworkService 2 execute: " + r122.f526680a + ' ' + r122.f526681b;     // Catch: Throwable -> L21
        if (r125 == null) goto L61;
        String r126 = r125.toString();     // Catch: Throwable -> L21
        if (r126 == null) goto L61;
        r112 = r126;
    L61:
        System.out.println("[" + StringsKt.first(r124.name()) + "][kmp-ttnet] " + r112);     // Catch: Throwable -> L21
    L62:
        r116 = H2(r122, r121);     // Catch: Throwable -> L21
        MutexImpl r127 = this.f252487b;
        r100.L$0 = r121;
        r100.L$1 = r116;
        r100.L$2 = r127;
        r100.I$0 = r120;
        r100.label = 3;
        if (r127.a(null, r100) != r103) goto L66;
        return r103;
    L66:
        r117 = r121;
        int r128 = r120;
        r115 = r127;
        r114 = r128;
    L21:
        th = move-exception;
        r107 = th;
        r105 = r120;
    L78:
        r106 = this.f252487b;
        r100.L$0 = r121;
        r100.L$1 = r107;
        r100.L$2 = r106;
        r100.L$3 = null;
        r100.I$0 = r105;
        r100.label = 4;
        if (r106.a(null, r100) != r103) goto L81;
        return r103;
    L81:
        r108 = r121;
        goto L95
    L23:
        int r129 = r100.I$0;
        kotlinx.coroutines.sync.a r130 = (kotlinx.coroutines.sync.a) r100.L$3;
        SsHttpCall r131 = (SsHttpCall) r100.L$2;
        nt7.a r132 = (nt7.a) r100.L$1;
        jd6.c r133 = (jd6.c) r100.L$0;
        ResultKt.throwOnFailure(r102);
        kotlinx.coroutines.sync.a r134 = r130;
        int r135 = r129;
    L101:
        if (r135 <= 0) goto L38;
        this.f252489d.put(Boxing.boxInt(r135), r131);     // Catch: Throwable -> L90
    L39:
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L90
        r134.unlock(null);
        NLog.Level r137 = NLog.f252570a;     // Catch: Throwable -> L76
        NLog.Level r138 = NLog.Level.DEBUG;     // Catch: Throwable -> L76
        if (r138.compareTo(NLog.f252570a) < 0) goto L49;
        String r139 = "KmpNativeNetworkService 1 execute: " + r132.f520517a;     // Catch: Throwable -> L76
        if (r139 == null) goto L47;
        String r140 = r139.toString();     // Catch: Throwable -> L76
        if (r140 == null) goto L47;
    L48:
        System.out.println("[" + StringsKt.first(r138.name()) + "][kmp-ttnet] " + r140);     // Catch: Throwable -> L76
    L47:
        r140 = "null";
    L49:
        r100.L$0 = r133;     // Catch: Throwable -> L76
        r100.L$1 = null;     // Catch: Throwable -> L76
        r100.L$2 = null;     // Catch: Throwable -> L76
        r100.L$3 = null;     // Catch: Throwable -> L76
        r100.I$0 = r135;     // Catch: Throwable -> L76
        r100.label = 2;     // Catch: Throwable -> L76
        r102 = r131.b(r132, r100);     // Catch: Throwable -> L76
        if (r102 != r103) goto L52;
        return r103;
    L52:
        r120 = r135;
        r121 = r133;
    L76:
        th = move-exception;
        r107 = th;
        r105 = r135;
        r121 = r133;
        goto L78
    L38:
        this.f252488c.put(r133, r131);     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        r134.unlock(null);
        throw th;
    L24:
        ResultKt.throwOnFailure(r102);
        NLog.Level r141 = NLog.f252570a;
        NLog.Level r142 = NLog.Level.DEBUG;
        if (r142.compareTo(NLog.f252570a) < 0) goto L32;
        String r143 = "KmpNativeNetworkService 0 execute: " + r110.f498624a;
        if (r143 == null) goto L30;
        String r144 = r143.toString();
        if (r144 == null) goto L30;
    L31:
        System.out.println("[" + StringsKt.first(r142.name()) + "][kmp-ttnet] " + r144);
    L30:
        r144 = "null";
    L32:
        r132 = k0(r110);
        Lazy r145 = com.example.interopdemo.e.f274034a;
        SsHttpCall r146 = new SsHttpCall();
        r135 = r110.f498628e.f498642g;
        MutexImpl r147 = this.f252487b;
        r100.L$0 = r110;
        r100.L$1 = r132;
        r100.L$2 = r146;
        r100.L$3 = r147;
        r100.I$0 = r135;
        r100.label = 1;
        if (r147.a(null, r100) != r103) goto L35;
        return r103;
    L35:
        r131 = r146;
        r134 = r147;
        r133 = r110;
    L7:
        r100 = new KmpNativeNetworkService$execute$1(this, r111);
        goto L8
    }

    @Override // com.bytedance.kmp.network.c
    public final Object L(jd6.c r110, KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 r111, Continuation r112) {
        if ((r112 instanceof KmpNativeNetworkService$executeStream$1) == false) goto L7;
        KmpNativeNetworkService$executeStream$1 r100 = (KmpNativeNetworkService$executeStream$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r113 = "null";
        if (r104 == 0) goto L17;
        if (r104 == 1) goto L16;
        if (r104 != 2) goto L15;
        ResultKt.throwOnFailure(r102);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r105 = r100.I$0;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$4;
        SsHttpCall r107 = (SsHttpCall) r100.L$3;
        nt7.a r108 = (nt7.a) r100.L$2;
        i r114 = (i) r100.L$1;
        jd6.c r115 = (jd6.c) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L77:
        if (r105 <= 0) goto L47;
        this.f252489d.put(Boxing.boxInt(r105), r107);     // Catch: Throwable -> L74
    L48:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L74
        r106.unlock(null);
        NLog.Level r116 = NLog.f252570a;
        NLog.Level r117 = NLog.Level.DEBUG;
        if (r117.compareTo(NLog.f252570a) < 0) goto L72;
        StringBuilder r118 = new StringBuilder("KmpNativeNetworkService 3 start call executeStream: ");
        r118.append(r108.f520517a);
        r118.append(" body type : ");
        nt7.b r119 = r108.f520520d;
        if (r119 == null) goto L54;
        String r120 = r119.b();
    L55:
        r118.append(r120);
        r118.append(" body length:   ");
        nt7.b r121 = r108.f520520d;
        if (r121 == null) goto L60;
        byte[] r122 = r121.a();
        if (r122 == null) goto L60;
        Integer r123 = Boxing.boxInt(r122.length);
    L61:
        r118.append(r123);
        r118.append("body : ");
        nt7.b r124 = r108.f520520d;
        if (r124 == null) goto L64;
        byte[] r125 = r124.a();
    L65:
        r118.append(r125);
        String r126 = r118.toString();
        if (r126 == null) goto L71;
        String r127 = r126.toString();
        if (r127 == null) goto L71;
        r113 = r127;
    L71:
        System.out.println("[" + StringsKt.first(r117.name()) + "][kmp-ttnet] " + r113);
        goto L72
    L64:
        r125 = null;
    L60:
        r123 = null;
        goto L61
    L54:
        r120 = null;
    L72:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.label = 2;
        r107.getClass();
        SsHttpCall.a(r108);
        r107.f274030a.getClass();
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    L47:
        this.f252488c.put(r115, r107);     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L17:
        ResultKt.throwOnFailure(r102);
        NLog.Level r128 = NLog.f252570a;
        NLog.Level r129 = NLog.Level.DEBUG;
        NLog.Level r130 = NLog.f252570a;
        if (r129.compareTo(r130) < 0) goto L33;
        StringBuilder r131 = new StringBuilder("KmpNativeNetworkService 1 executeStream: ");
        r131.append(r110.f498624a);
        r131.append(" body type : ");
        jd6.d r132 = r110.f498627d;
        if (r132 == null) goto L22;
        String r133 = r132.contentType();
    L23:
        r131.append(r133);
        r131.append("body length: ");
        jd6.d r134 = r110.f498627d;
        if (r134 == null) goto L26;
        Long r135 = Boxing.boxLong(r134.contentLength());
    L27:
        r131.append(r135);
        r131.append(" body : ");
        r131.append(r110.f498627d);
        String r136 = r131.toString();
        if (r136 == null) goto L31;
        String r137 = r136.toString();
        if (r137 == null) goto L31;
    L32:
        System.out.println("[" + StringsKt.first(r129.name()) + "][kmp-ttnet] " + r137);
    L31:
        r137 = "null";
        goto L32
    L26:
        r135 = null;
        goto L27
    L22:
        r133 = null;
    L33:
        nt7.a r138 = k0(r110);
        if (r129.compareTo(r130) < 0) goto L41;
        String r139 = "KmpNativeNetworkService 2 executeStream: " + r138.f520517a + " body: " + r138.f520520d;
        if (r139 == null) goto L39;
        String r140 = r139.toString();
        if (r140 == null) goto L39;
    L40:
        System.out.println("[" + StringsKt.first(r129.name()) + "][kmp-ttnet] " + r140);
    L39:
        r140 = "null";
    L41:
        Lazy r141 = com.example.interopdemo.e.f274034a;
        r107 = new SsHttpCall();
        int r142 = r110.f498628e.f498642g;
        MutexImpl r143 = this.f252487b;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r138;
        r100.L$3 = r107;
        r100.L$4 = r143;
        r100.I$0 = r142;
        r100.label = 1;
        if (r143.a(null, r100) != r103) goto L44;
        return r103;
    L44:
        r108 = r138;
        r106 = r143;
        r115 = r110;
        r105 = r142;
    L7:
        r100 = new KmpNativeNetworkService$executeStream$1(this, r112);
        goto L8
    }
}
