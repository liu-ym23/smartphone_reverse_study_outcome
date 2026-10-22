package com.larus.dora.impl.ota.g;

import com.google.gson.reflect.TypeToken;
import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.request.v2.DoraRequestXV2;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraGOTAFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraGOTAFetcher f337488a = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<h69.a> {
        public a() {
        }
    }

    static {
        f337488a = new DoraGOTAFetcher();
    }

    public DoraGOTAFetcher() {
    }

    public final Object a(Continuation<? super e49.a> r110) {
        if ((r110 instanceof DoraGOTAFetcher$getPeripheralResponse$1) == false) goto L7;
        DoraGOTAFetcher$getPeripheralResponse$1 r100 = (DoraGOTAFetcher$getPeripheralResponse$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        w39.a r104 = (w39.a) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L25:
        com.larus.dora.impl.core.request.v2.a r112 = (com.larus.dora.impl.core.request.v2.a) r111;
        if ((r112 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L100;
        g49.d.b("DoraRequestXV2", "request<T>: failed, " + r112);
        Result.Companion r105 = Result.Companion;
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(new Exception("Request failed: " + r112)));
    L36:
        if (Result.m9455isFailureimpl(r113) == false) goto L38;
        r113 = null;
    L38:
        h69.a r114 = (h69.a) r113;
        StringBuilder r106 = new StringBuilder("getPeripheralResponse: status=");
        if (r114 == null) goto L41;
        Integer r107 = r114.c();
    L42:
        r106.append(r107);
        g49.d.d("DoraGOTAFetcher", r106.toString());
        StringBuilder r108 = new StringBuilder("getPeripheralResponse: message=");
        if (r114 == null) goto L45;
        String r109 = r114.b();
    L46:
        r108.append(r109);
        g49.d.d("DoraGOTAFetcher", r108.toString());
        if (r114 == null) goto L51;
        h69.b r115 = r114.a();
        if (r115 == null) goto L51;
        z39.a r116 = r115.a();
    L52:
        StringBuilder r117 = new StringBuilder("getPeripheralResponse: packageCount=");
        if (r116 == null) goto L57;
        List<OTAUpdatePackage> r118 = r116.b();
        if (r118 == null) goto L57;
        int r119 = r118.size();
    L58:
        r117.append(r119);
        r117.append(", hasMeta=");
        if (r116 == null) goto L61;
        OTAUpdateMeta r120 = r116.a();
    L62:
        if (r120 == null) goto L64;
        boolean r121 = true;
    L65:
        r117.append(r121);
        r117.append(", hasTrace=");
        if (r116 == null) goto L68;
        String r122 = r116.d();
    L69:
        if (r122 != null) goto L71;
    L74:
        boolean r123 = true;
    L75:
        r117.append(!r123);
        r117.append(", hasTaskId=");
        if (r116 == null) goto L78;
        String r124 = r116.c();
    L79:
        if (r124 != null) goto L81;
    L84:
        boolean r125 = true;
    L85:
        r117.append(!r125);
        g49.d.d("DoraGOTAFetcher", r117.toString());
        if (r114 == null) goto L93;
        Integer r126 = r114.c();
        if (r126 == null) goto L93;
        if (r126.intValue() != 0) goto L93;
        boolean r127 = true;
    L94:
        if (r127 == false) goto L98;
        if (r116 == null) goto L98;
        return new e49.a(r116, false, true, 2);
    L98:
        return null;
    L93:
        r127 = false;
        goto L94
    L81:
        if (StringsKt.isBlank(r124) == true) goto L84;
        r125 = false;
        goto L85
    L78:
        r124 = null;
        goto L79
    L71:
        if (StringsKt.isBlank(r122) == true) goto L74;
        r123 = false;
        goto L75
    L68:
        r122 = null;
        goto L69
    L64:
        r121 = false;
        goto L65
    L61:
        r120 = null;
    L57:
        r119 = 0;
    L51:
        r116 = null;
        goto L52
    L45:
        r109 = null;
        goto L46
    L41:
        r107 = null;
        goto L42
    L100:
        Type r128 = new a().getType();     // Catch: Throwable -> L32
        byte[] r129 = ((com.larus.dora.impl.core.request.v2.a.b) r112).f332256a;     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r128);     // Catch: Throwable -> L32
        Object r130 = r104.a(r129, r128);     // Catch: Throwable -> L32
        if (r130 != null) goto L30;
        g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L32
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L32
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L32
    L99:
        goto L36
    L30:
        r113 = Result.m9449constructorimpl(r130);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        g49.d.c("DoraRequestXV2", "request<T>: parse error", th);
        Result.Companion r132 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
    L20:
        if (((Boolean) r111).booleanValue() == false) goto L98;
        DoraRequestXV2 r133 = DoraRequestXV2.f332240a;
        gk4.a r134 = new gk4.a();
        Lazy<w39.d> r135 = w39.d.f558188b;
        w39.d r136 = w39.d.a.a();
        r100.L$0 = r136;
        r100.label = 2;
        r111 = r133.a(r134, 5000, r100);
        if (r111 != r102) goto L24;
        return r102;
    L24:
        r104 = r136;
        goto L25
    L16:
        ResultKt.throwOnFailure(r111);
        sk4.e r137 = o0.f332223a;
        r100.label = 1;
        r111 = o0.f();
        if (r111 != r102) goto L20;
        return r102;
    L7:
        r100 = new DoraGOTAFetcher$getPeripheralResponse$1(this, r110);
        goto L8
    }
}
