package com.larus.dora.impl.resource;

import com.facebook.keyframes.model.KFImage;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraFeatureResourceClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraFeatureResourceClient f337814a = null;

    static {
        f337814a = new DoraFeatureResourceClient();
    }

    public DoraFeatureResourceClient() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(Continuation<? super h> r110) {
        if ((r110 instanceof DoraFeatureResourceClient$fetchSnapshot$1) == false) goto L7;
        DoraFeatureResourceClient$fetchSnapshot$1 r100 = (DoraFeatureResourceClient$fetchSnapshot$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraFeatureResourceClient$fetchSnapshot$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L21
    L19:
        Object r112 = Result.m9449constructorimpl((com.larus.network.http.a) r111);     // Catch: Throwable -> L21
    L23:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r112);
        if (r105 != null) goto L47;
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;
        String r106 = null;
        if ((r113 instanceof com.larus.network.http.y) == false) goto L38;
        com.larus.network.http.y r114 = (com.larus.network.http.y) r113;
        JsonObject r107 = (JsonObject) r114.f360135b;
        if (r107 == null) goto L30;
        r106 = r107.toString();
    L30:
        if (r106 == null) goto L36;
        f.f337867a.getClass();
        g r108 = f.a(r106);
        if (r108 == null) goto L36;
        return new h.c(r108, r106, r114.f360136c);
    L36:
        return new h.a(r114.f360205g, r114.f360204f, r106, r114.f360136c);
    L38:
        if ((r113 instanceof com.larus.network.http.f) == false) goto L45;
        com.larus.network.http.f r115 = (com.larus.network.http.f) r113;
        Long r109 = Boxing.boxLong(r115.f360157d.getCode());
        Throwable r116 = r115.f360157d.getCause();
        if (r116 == null) goto L42;
        String r117 = r116.getClass().getSimpleName();
    L43:
        Intrinsics.checkNotNull(r117);
        return new h.b(r109, r117, r115.f360157d);
    L42:
        r117 = r115.f360157d.getClass().getSimpleName();
        goto L43
    L45:
        return new h.b(r113.getClass().getSimpleName(), null, 5);
    L47:
        return new h.b(r105.getClass().getSimpleName(), r105, 1);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L21
        com.larus.dora.api.network.a r119 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L21
        JSONObject r120 = new JSONObject().put(KFImage.FEATURES_JSON_FIELD, new JSONArray(a.f337836a));     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        r111 = com.larus.dora.api.network.a.c(r119, JsonObject.class, "https://api-normal.doubao.com/alice/w/starweave/feature-visibility/batch/resource", r120, null, r102, 248);     // Catch: Throwable -> L21
        if (r111 != r103) goto L19;
        return r103;
    L21:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new DoraFeatureResourceClient$fetchSnapshot$1(this, r110);
        goto L8
    }
}
