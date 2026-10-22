package com.obric.assistant.remote_card_container.manager;

import android.app.Application;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: classes33.dex */
public final class CardProviderServices {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CardProviderServices f391269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Pair<ICardProviderService, a>> f391270b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Job> f391271c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f391272d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Deferred<? extends ICardProviderService> f391273e;

    public static abstract class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f391274a;

        public a() {
            this.f391274a = new AtomicBoolean(false);
        }
    }

    public CardProviderServices() {
    }

    static {
        f391269a = new CardProviderServices();
        f391270b = new LinkedHashMap();
        f391271c = new LinkedHashMap();
        f391272d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(w1.a(1, "CardProviderServices")));
    }

    public static final void a(String r100) {
        p9a.e r101 = p9a.b.f528329a;
        p9a.b.a("CardProviderServices", "cancel connection " + r100);
        Pair<ICardProviderService, a> r102 = f391270b.remove(r100);
        if (r102 == null) goto L31;
        ICardProviderService r103 = r102.component1();
        a r104 = r102.component2();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        Bundle r106 = new Bundle();     // Catch: Throwable -> L7
        r106.putBinder("host_api", null);     // Catch: Throwable -> L7
        r103.setHostApi(r106);     // Catch: Throwable -> L7
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L13;
        p9a.e r109 = p9a.b.f528329a;
        p9a.b.c("CardProviderServices", "clear host api failed: " + r100 + ", " + r108.getMessage(), r108);
    L13:
        if (Result.m9456isSuccessimpl(r107) == false) goto L27;
        Unit r110 = (Unit) r107;
        p9a.e r111 = p9a.b.f528329a;
        p9a.b.a("CardProviderServices", "clear host api succeed " + r100);
    L27:
        p9a.e r112 = p9a.b.f528329a;     // Catch: Throwable -> L17
        p9a.b.a("CardProviderServices", "unbindService " + r100);     // Catch: Throwable -> L17
        AppHost.f326268a.getApplication().unbindService(r104);     // Catch: Throwable -> L17
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L23;
        p9a.e r115 = p9a.b.f528329a;
        p9a.b.c("CardProviderServices", "unbindService failed: " + r100 + ", " + r114.getMessage(), r114);
    L23:
        if (Result.m9456isSuccessimpl(r113) == false) goto L25;
        Unit r116 = (Unit) r113;
        p9a.e r117 = p9a.b.f528329a;
        p9a.b.a("CardProviderServices", "unbindService success: " + r100);
    L25:
        Result.m9448boximpl(r113);
        return;
    L17:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static void d(String r110) {
        Map<String, Job> r100 = f391271c;
        if (r100 == null) goto L7;
        Job r101 = r100.remove(r110);
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L7:
        p9a.e r102 = p9a.b.f528329a;
        p9a.b.a("CardProviderServices", "keep bind with " + r110 + " for 60000 ms");
        r100.put(r110, BuildersKt.launch$default(f391272d, null, null, new CardProviderServices$setTimeoutJob$1(r110, null), 3, null));
    }

    public final Object c(Context r110, String r111, Continuation<? super ICardProviderService> r112) {
        if ((r112 instanceof CardProviderServices$getCardProviderService$1) == false) goto L7;
        CardProviderServices$getCardProviderService$1 r100 = (CardProviderServices$getCardProviderService$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L26:
        ICardProviderService r106 = (ICardProviderService) r102;
        d(r105);
        return r102;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        p9a.e r107 = p9a.b.f528329a;
        p9a.b.a("CardProviderServices", "getCardProviderService " + r111);
        Uri r108 = UriProtector.parse(r111);
        String r109 = p9a.f.b(r108);
        if (r109.length() != 0) goto L17;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L22;
        p9a.b.b("CardProviderServices", "providerPkgName is null or empty");
        return null;
    L22:
        Deferred r114 = BuildersKt.async$default(f391272d, null, null, new CardProviderServices$getCardProviderService$2(r109, r110, r108, null), 3, null);
        r100.L$0 = r109;
        r100.label = 1;
        r102 = r114.await(r100);
        if (r102 != r103) goto L25;
        return r103;
    L25:
        r105 = r109;
        goto L26
    L17:
        r113 = false;
    L7:
        r100 = new CardProviderServices$getCardProviderService$1(this, r112);
        goto L8
    }

    public static final Object b(CardProviderServices r110, Context r111, Uri r112, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof CardProviderServices$createConnection$1) == false) goto L7;
        CardProviderServices$createConnection$1 r100 = (CardProviderServices$createConnection$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Deferred<? extends ICardProviderService> r105 = (Deferred) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L18:
        ICardProviderService r106 = (ICardProviderService) r102;
        if (Intrinsics.areEqual(r105, f391273e) == false) goto L21;
        p9a.b.a("CardProviderServices", "last job done, set lastJob to null");
        f391273e = null;
    L21:
        p9a.e r107 = p9a.b.f528329a;
        p9a.b.a("CardProviderServices", "createConnection wait connect done. result = " + r106);
        return r102;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        p9a.e r108 = p9a.b.f528329a;
        p9a.b.a("CardProviderServices", "createConnection " + r112);
        Context r109 = r111.getApplicationContext();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.app.Application");
        String r113 = p9a.f.b(r112);
        Deferred<? extends ICardProviderService> r114 = f391273e;
        Deferred<? extends ICardProviderService> r115 = BuildersKt.async$default(f391272d, null, CoroutineStart.LAZY, new CardProviderServices$createConnection$connectingJob$1(r114, r113, (Application) r109, r112, null), 1, null);
        f391273e = r115;
        p9a.b.a("CardProviderServices", "createConnection wait connect");
        r100.L$0 = r115;
        r100.label = 1;
        Object r116 = r115.await(r100);
        if (r116 == r103) goto L23;
        r105 = r115;
        r102 = r116;
        goto L18
    L23:
        return r103;
    L7:
        r100 = new CardProviderServices$createConnection$1(r110, r210);
        goto L8
    }
}
