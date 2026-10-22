package com.larus.network;

import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.reflect.TypeToken;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ApiRespInterceptedException;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.u;
import com.larus.platform.api.b2;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ouc.a0;
import ouc.d0;
import ouc.v;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowHttpConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowHttpConnection f359975a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<u> f359976b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f359977c = null;

    public FlowHttpConnection() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.network.i] */
    static {
        f359975a = new FlowHttpConnection();
        f359976b = new CopyOnWriteArrayList();
        f359977c = new i();
    }

    public static String a() {
        if (HttpExtKt.e().f360166a == false) goto L6;
        return b2.f364870a.k();
    L6:
        return b2.f364870a.l();
    }

    public static BizResponse d(String r100, juc.d r110) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        v r102 = HttpExtKt.f360122e;
        d0 r103 = ouc.k.n(r102.e(r100));
        ouc.i r104 = (ouc.i) r103.get("code");
        if (r104 == null) goto L16;
        Long r105 = ouc.k.q(ouc.k.o(r104));
        if (r105 == null) goto L16;
        long r106 = r105.longValue();
    L17:
        long r107 = r106;
        ouc.i r108 = (ouc.i) r103.get("msg");
        if (r108 == null) goto L20;
        String r109 = ouc.k.g(ouc.k.o(r108));
    L21:
        ouc.i r111 = (ouc.i) r103.get(WsConstants.KEY_PAYLOAD);
        if (r111 == null) goto L24;
        String r112 = ouc.k.g(ouc.k.o(r111));
    L25:
        ouc.i r113 = (ouc.i) r103.get("data");
        if (r113 != null) goto L28;
    L33:
        Object r114 = null;
    L35:
        return new BizResponse(r107, r109, r112, r114);
    L28:
        if ((r113 instanceof a0) == false) goto L31;
        r113 = null;
    L31:
        if (r113 == null) goto L33;
        r114 = r102.b(r110, r113);
        goto L35
    L24:
        r112 = null;
        goto L25
    L20:
        r109 = null;
    L16:
        r106 = 0;
        goto L17
    L10:
        return new BizResponse(0, null, null, null, 15, null);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static Retrofit b(String r100, List r101, Converter.Factory r102) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Object r103 = b2.f364870a.n();
        if ((r103 instanceof Client.Provider) == false) goto L5;
        Client.Provider r104 = (Client.Provider) r103;
    L6:
        if (r104 == null) goto L8;
        Retrofit r105 = RetrofitUtils.createRetrofit(r100, r101, r102, null, r104);
        Intrinsics.checkNotNull(r105);
        return r105;
    L8:
        Retrofit r106 = RetrofitUtils.createSsRetrofit(r100, r101, r102);
        Intrinsics.checkNotNull(r106);
        return r106;
    L5:
        r104 = null;
        goto L6
    }

    public static void j(dm9.a r100, long r101, String r102, Map r103) {
        long r104 = SystemClock.uptimeMillis() - r101;
        if ((r100 instanceof dm9.a.b) == false) goto L6;
        int r105 = yp9.a.f568722a;
        dm9.a.b r106 = (dm9.a.b) r100;
        yp9.a.a(Long.valueOf(r106.f469231a.getCode()), Long.valueOf(r104), r106.f469231a.getMsg(), r102, r103);
        return;
    L6:
        if ((r100 instanceof dm9.a.C5690a) == false) goto L10;
        int r107 = yp9.a.f568722a;
        dm9.a.C5690a r108 = (dm9.a.C5690a) r100;
        yp9.a.a(Long.valueOf(r108.f469228a), Long.valueOf(r104), r108.f469229b, r102, r103);
        return;
    }

    public static Object c(FlowHttpConnection r100, final String r101, Class r102, rx5.a r103, String r104, Interceptor r105, int r106) {
        List r107 = null;
        if ((r106 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r106 & 8) == 0) goto L9;
        r100.getClass();
        r104 = a();
    L9:
        if ((r106 & 16) == 0) goto L11;
        r105 = null;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "apiClazz");
        Intrinsics.checkNotNullParameter(r104, "baseUrl");
        List r108 = CollectionsKt.mutableListOf(new Interceptor[]{new j(r101), f359977c, e.f360109a});
        if (r108 == null) goto L17;
        if (r105 == null) goto L15;
        r108.add(r105);
    L15:
        r107 = r108;
    L17:
        return b(r104, r107, r103).create(r102);
    }

    public static /* synthetic */ Object i(String r110, Class r111, Function2 r112, String r113, com.obric.assistant.network.impl.m r114, String r115, Continuation r116, int r117) {
        FlowHttpConnection r100 = f359975a;
        if ((r117 & 8) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r117 & 16) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r117 & 64) == 0) goto L13;
        com.obric.assistant.network.impl.m r103 = null;
    L15:
        return r100.h(r110, r111, r112, r101, r102, null, r103, r115, r116);
    L13:
        r103 = r114;
        goto L15
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = true;
        goto L7
    }

    public final <S, T> dm9.a<T> e(String r110, Type r111, String r112, Class<S> r113, boolean r210, Map<String, ? extends Object> r211, juc.d<T> r212, Function1<? super S, SsResponse<String>> r213) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "outType");
        Intrinsics.checkNotNullParameter(r113, "apiClazz");
        Intrinsics.checkNotNullParameter(r213, NotificationCompat.CATEGORY_CALL);
        long r114 = SystemClock.uptimeMillis();
        SsResponse<String> r100 = r213.invoke((Object) c(this, r110, r113, null, null, null, 28));     // Catch: Throwable -> L23 CancellationException -> L25
        if (r100 != null) goto L6;
        dm9.a<T> r101 = new dm9.a.C5690a(-1005, "ssResponse is null", new Exception("ssResponse is null"));     // Catch: Throwable -> L23 CancellationException -> L25
    L30:
        if (r210 == false) goto L32;
        j(r101, r114, r112, r211);
    L32:
        return r101;
    L6:
        boolean r102 = false;
        if (r212 == null) goto L9;
        BizResponse<T> r103 = d(r100.body(), r212);     // Catch: Throwable -> L23 CancellationException -> L25
    L10:
        r103.setupSSResponse(r100);     // Catch: Throwable -> L23 CancellationException -> L25
        CopyOnWriteArrayList<u> r104 = f359976b;     // Catch: Throwable -> L23 CancellationException -> L25
        if ((!r104.isEmpty()) == false) goto L18;
        Iterator<u> r105 = r104.iterator();     // Catch: Throwable -> L23 CancellationException -> L25
    L14:
        if (r105.hasNext() == false) goto L18;
        if (r105.next().a(r112, r103) == false) goto L14;
        r102 = true;
    L18:
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L23 CancellationException -> L25
        ApiRespInterceptedException r106 = null;
        if (r102 == false) goto L21;
        r106 = new ApiRespInterceptedException(null, 1, null);     // Catch: Throwable -> L23 CancellationException -> L25
    L21:
        dm9.a<T> r107 = new dm9.a.b(r103, r106);     // Catch: Throwable -> L23 CancellationException -> L25
    L29:
        r101 = r107;
        goto L30
    L9:
        r103 = (BizResponse) HttpExtKt.f360123f.fromJson(r100.body(), TypeToken.getParameterized(BizResponse.class, new Type[]{r111}).getType());     // Catch: Throwable -> L23 CancellationException -> L25
    L25:
        e = move-exception;
        r107 = new dm9.a.C5690a(-1001, "", e);
    L23:
        th = move-exception;
        r101 = fm9.a.a(th);
        goto L30
    }

    public static /* synthetic */ Object g(String r110, Class r111, Function2 r112, boolean r113, String r114, String r115, Interceptor r116, Continuation r117, int r118) {
        FlowHttpConnection r100 = f359975a;
        if ((r118 & 8) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r118 & 16) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 64) == 0) goto L13;
        String r103 = a();
    L15:
        if ((r118 & 128) == 0) goto L17;
        Interceptor r104 = null;
    L19:
        return r100.f(r110, r111, r112, r101, r102, null, r103, r104, r117);
    L17:
        r104 = r116;
        goto L19
    L13:
        r103 = r115;
        goto L15
    L9:
        r102 = r114;
        goto L11
    L5:
        r101 = r113;
        goto L7
    }

    public final <S, T> Object f(String r110, Class<S> r111, Function2<? super S, ? super Continuation<? super BizResponse<T>>, ? extends Object> r112, boolean r113, String r210, Map<String, ? extends Object> r211, String r212, Interceptor r213, Continuation<? super dm9.a<? extends T>> r214) {
        if ((r214 instanceof FlowHttpConnection$safeCall$1) == false) goto L7;
        FlowHttpConnection$safeCall$1 r100 = (FlowHttpConnection$safeCall$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 != 1) goto L19;
        long r104 = r100.J$0;
        r113 = r100.Z$0;
        Map<String, ? extends Object> r105 = (Map) r100.L$1;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 CancellationException -> L16
    L31:
        BizResponse<T> r107 = (BizResponse) r102;     // Catch: Throwable -> L14 CancellationException -> L16
        if (r107 != null) goto L34;
        dm9.a r108 = new dm9.a.C5690a(-1005, "BizResponse is null", new Exception("BizResponse is null"));     // Catch: Throwable -> L14 CancellationException -> L16
    L72:
        if (r113 == false) goto L74;
        j(r108, r104, r106, r105);
    L74:
        return r108;
    L34:
        Ref.BooleanRef r109 = new Ref.BooleanRef();     // Catch: Throwable -> L14 CancellationException -> L16
        CopyOnWriteArrayList<u> r115 = f359976b;     // Catch: Throwable -> L14 CancellationException -> L16
        if ((!r115.isEmpty()) == false) goto L42;
        Iterator<u> r116 = r115.iterator();     // Catch: Throwable -> L14 CancellationException -> L16
    L38:
        if (r116.hasNext() == false) goto L42;
        if (r116.next().a(r106, r107) == false) goto L38;
        r109.element = true;     // Catch: Throwable -> L14 CancellationException -> L16
    L42:
        ApiRespInterceptedException r117 = null;
        if (r109.element == false) goto L46;
        r117 = new ApiRespInterceptedException(null, 1, null);     // Catch: Throwable -> L14 CancellationException -> L16
    L46:
        r108 = new dm9.a.b(r107, r117);     // Catch: Throwable -> L14 CancellationException -> L16
    L16:
        e = e;
        long r118 = r104;
    L70:
        r108 = new dm9.a.C5690a(-1001, "", e);
    L71:
        r104 = r118;
    L14:
        th = th;
        r118 = r104;
    L66:
        r108 = fm9.a.a(th);
        goto L71
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
        r118 = SystemClock.uptimeMillis();
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r119 = (Object) c(this, r110, r111, null, r212, r213, 4);
        String r120 = r210;
        r100.L$0 = r120;     // Catch: Throwable -> L57 CancellationException -> L60
        Map<String, ? extends Object> r121 = r211;
        r100.L$1 = r121;     // Catch: Throwable -> L53 CancellationException -> L55
        r113 = r113;
        r100.Z$0 = r113;     // Catch: Throwable -> L49 CancellationException -> L51
        r100.J$0 = r118;     // Catch: Throwable -> L49 CancellationException -> L51
        r100.label = 1;     // Catch: Throwable -> L49 CancellationException -> L51
        r102 = r112.invoke(r119, r100);     // Catch: Throwable -> L49 CancellationException -> L51
        if (r102 != r114) goto L30;
        return r114;
    L30:
        r106 = r120;
        r105 = r121;
        r104 = r118;
        goto L31
    L51:
        e = e;
    L69:
        r106 = r120;
        r105 = r121;
    L49:
        th = th;
    L65:
        r106 = r120;
        r105 = r121;
        goto L66
    L55:
        e = e;
        r113 = r113;
    L53:
        th = th;
        r113 = r113;
        goto L65
    L60:
        e = e;
    L62:
        r121 = r211;
    L57:
        th = th;
    L59:
        r121 = r211;
        goto L65
    L67:
        e = e;
        r120 = r210;
    L63:
        th = th;
        r120 = r210;
    L7:
        r100 = new FlowHttpConnection$safeCall$1(this, r214);
        goto L8
    }

    public final <S, T> Object h(String r110, Class<S> r111, Function2<? super S, ? super Continuation<? super BizResponse<T>>, ? extends Object> r112, boolean r113, String r210, Map<String, ? extends Object> r211, Interceptor r212, String r213, Continuation<? super dm9.a<? extends T>> r214) {
        if ((r214 instanceof FlowHttpConnection$safeCallReplaceBaseUrl$1) == false) goto L7;
        FlowHttpConnection$safeCallReplaceBaseUrl$1 r100 = (FlowHttpConnection$safeCallReplaceBaseUrl$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 != 1) goto L19;
        long r104 = r100.J$0;
        r113 = r100.Z$0;
        Map<String, ? extends Object> r105 = (Map) r100.L$1;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 CancellationException -> L16
    L31:
        BizResponse<T> r107 = (BizResponse) r102;     // Catch: Throwable -> L14 CancellationException -> L16
        if (r107 != null) goto L34;
        dm9.a r108 = new dm9.a.C5690a(-1005, "BizResponse is null", new Exception("BizResponse is null"));     // Catch: Throwable -> L14 CancellationException -> L16
    L72:
        if (r113 == false) goto L74;
        j(r108, r104, r106, r105);
    L74:
        return r108;
    L34:
        Ref.BooleanRef r109 = new Ref.BooleanRef();     // Catch: Throwable -> L14 CancellationException -> L16
        CopyOnWriteArrayList<u> r115 = f359976b;     // Catch: Throwable -> L14 CancellationException -> L16
        if ((!r115.isEmpty()) == false) goto L42;
        Iterator<u> r116 = r115.iterator();     // Catch: Throwable -> L14 CancellationException -> L16
    L38:
        if (r116.hasNext() == false) goto L42;
        if (r116.next().a(r106, r107) == false) goto L38;
        r109.element = true;     // Catch: Throwable -> L14 CancellationException -> L16
    L42:
        ApiRespInterceptedException r117 = null;
        if (r109.element == false) goto L46;
        r117 = new ApiRespInterceptedException(null, 1, null);     // Catch: Throwable -> L14 CancellationException -> L16
    L46:
        r108 = new dm9.a.b(r107, r117);     // Catch: Throwable -> L14 CancellationException -> L16
    L16:
        e = e;
        long r118 = r104;
    L70:
        r108 = new dm9.a.C5690a(-1001, "", e);
    L71:
        r104 = r118;
    L14:
        th = th;
        r118 = r104;
    L66:
        r108 = fm9.a.a(th);
        goto L71
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
        r118 = SystemClock.uptimeMillis();
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r119 = (Object) c(this, r110, r111, null, r213, r212, 4);
        String r120 = r210;
        r100.L$0 = r120;     // Catch: Throwable -> L57 CancellationException -> L60
        Map<String, ? extends Object> r121 = r211;
        r100.L$1 = r121;     // Catch: Throwable -> L53 CancellationException -> L55
        r113 = r113;
        r100.Z$0 = r113;     // Catch: Throwable -> L49 CancellationException -> L51
        r100.J$0 = r118;     // Catch: Throwable -> L49 CancellationException -> L51
        r100.label = 1;     // Catch: Throwable -> L49 CancellationException -> L51
        r102 = r112.invoke(r119, r100);     // Catch: Throwable -> L49 CancellationException -> L51
        if (r102 != r114) goto L30;
        return r114;
    L30:
        r106 = r120;
        r105 = r121;
        r104 = r118;
        goto L31
    L51:
        e = e;
    L69:
        r106 = r120;
        r105 = r121;
    L49:
        th = th;
    L65:
        r106 = r120;
        r105 = r121;
        goto L66
    L55:
        e = e;
        r113 = r113;
    L53:
        th = th;
        r113 = r113;
        goto L65
    L60:
        e = e;
    L62:
        r121 = r211;
    L57:
        th = th;
    L59:
        r121 = r211;
        goto L65
    L67:
        e = e;
        r120 = r210;
    L63:
        th = th;
        r120 = r210;
    L7:
        r100 = new FlowHttpConnection$safeCallReplaceBaseUrl$1(this, r214);
        goto L8
    }
}
