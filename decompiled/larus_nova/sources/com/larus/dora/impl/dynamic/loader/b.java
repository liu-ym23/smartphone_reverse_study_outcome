package com.larus.dora.impl.dynamic.loader;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import d59.g;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f335205a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.loader.b$b, reason: collision with other inner class name */
    public interface InterfaceC4248b {
        void onFail();

        void onSuccess();
    }

    static {
    }

    public b() {
        this.f335205a = new Gson();
    }

    public static final Object a(b r100, String r101, InterfaceC4248b r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof DoraLaunchProductDataLoader$requestAndProcessData$1) == false) goto L7;
        DoraLaunchProductDataLoader$requestAndProcessData$1 r104 = (DoraLaunchProductDataLoader$requestAndProcessData$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 != 1) goto L15;
        r102 = (InterfaceC4248b) r104.L$1;
        r101 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Exception -> L25
    L20:
        g r109 = (g) r106;     // Catch: Exception -> L25
        if (r109 == null) goto L23;
        Keva r110 = g49.c.f480007a;     // Catch: Exception -> L25
        g49.c.a(r101, r100.f335205a.toJson(r109));     // Catch: Exception -> L25
        r102.onSuccess();     // Catch: Exception -> L25
    L28:
        return Unit.INSTANCE;
    L23:
        r102.onFail();     // Catch: Exception -> L25
        goto L28
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r106);
        FLogger.f375446a.e("DoraDynamicDataLoader", "Requesting data");     // Catch: Exception -> L25
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Exception -> L25
        DoraLaunchProductDataLoader$requestAndProcessData$$inlined$requestData$1 r112 = new DoraLaunchProductDataLoader$requestAndProcessData$$inlined$requestData$1(r100, null);     // Catch: Exception -> L25
        r104.L$0 = r101;     // Catch: Exception -> L25
        r104.L$1 = r102;     // Catch: Exception -> L25
        r104.label = 1;     // Catch: Exception -> L25
        r106 = BuildersKt.withContext(r111, r112, r104);     // Catch: Exception -> L25
        if (r106 != r107) goto L20;
        return r107;
    L25:
        e = move-exception;
        FLogger.f375446a.e("DoraDynamicDataLoader", "fetchData error: " + e.getMessage());
        e.getMessage();
        r102.onFail();
    L7:
        r104 = new DoraLaunchProductDataLoader$requestAndProcessData$1(r100, r103);
        goto L8
    }
}
