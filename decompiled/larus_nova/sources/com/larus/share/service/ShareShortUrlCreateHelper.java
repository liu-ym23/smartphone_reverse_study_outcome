package com.larus.share.service;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class ShareShortUrlCreateHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShareShortUrlCreateHelper f368890a = null;

    static {
        f368890a = new ShareShortUrlCreateHelper();
    }

    public ShareShortUrlCreateHelper() {
    }

    public static /* synthetic */ Object b(String r100, Continuation r101) {
        return f368890a.a(r100, true, null, z2.f365865a.getSaasShareConfig().i(), r101);
    }

    public final Object a(String r210, boolean r211, JSONObject r212, long r213, Continuation<? super j> r214) {
        if ((r214 instanceof ShareShortUrlCreateHelper$createShortUrl$1) == false) goto L7;
        ShareShortUrlCreateHelper$createShortUrl$1 r100 = (ShareShortUrlCreateHelper$createShortUrl$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 != 1) goto L19;
        long r105 = r100.J$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L48
    L41:
        goto L46
    L55:
        return (j) r102;
    L46:
        FLogger.f375446a.w("ShareShortUrlCreateHelper", "create short url timeout, timeoutMs=" + r105);
        return new j.c(r105);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
        Long r106 = null;
        if (StringsKt.isBlank(r210) == true) goto L23;
        Long r107 = Boxing.boxLong(r213);
        if (r107.longValue() <= 0) goto L27;
        boolean r108 = true;
    L28:
        if (r108 == false) goto L30;
        r106 = r107;
    L30:
        if (r106 == null) goto L32;
        long r109 = r106.longValue();
    L51:
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        if (r211 == false) goto L36;
        boolean r111 = true;
    L37:
        ShareShortUrlCreateHelper$createShortUrl$2 r112 = new ShareShortUrlCreateHelper$createShortUrl$2(r109, r210, r111, r212, null);     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        r100.J$0 = r109;     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        r100.label = 1;     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        r102 = BuildersKt.withContext(r110, r112, r100);     // Catch: Throwable -> L14 CancellationException -> L16 TimeoutCancellationException -> L45
        if (r102 != r103) goto L40;
        return r103;
    L40:
        r105 = r109;
        goto L41
    L36:
        r111 = false;
    L45:
        r105 = r109;
        goto L46
    L32:
        r109 = 5000;
        goto L51
    L27:
        r108 = false;
        goto L28
    L23:
        return new j.a("long url is empty", null, 5);
    L16:
        e = move-exception;
        throw e;
    L14:
        th = move-exception;
        FLogger.f375446a.e("ShareShortUrlCreateHelper", "create short url exception", th);
        return new j.a(th.getMessage(), th, 1);
    L7:
        r100 = new ShareShortUrlCreateHelper$createShortUrl$1(this, r214);
        goto L8
    }
}
