package com.larus.dora.impl.onboarding;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.im.bean.bot.BotModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes27.dex */
public final class OnboardingAvatarProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OnboardingAvatarProvider f336596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutexImpl f336597b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f336598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CompletableDeferred<String> f336599d;

    public OnboardingAvatarProvider() {
    }

    static {
        f336596a = new OnboardingAvatarProvider();
        f336597b = kotlinx.coroutines.sync.b.a();
    }

    public final Object a(Continuation<? super String> r110) {
        if ((r110 instanceof OnboardingAvatarProvider$getAvatarUrl$1) == false) goto L7;
        OnboardingAvatarProvider$getAvatarUrl$1 r100 = (OnboardingAvatarProvider$getAvatarUrl$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r100.L$2;
        String r106 = (String) r100.L$1;
        CompletableDeferred<String> r107 = (CompletableDeferred) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L57:
        if (r106 != null) goto L77;
    L63:
        r104 = true;
    L64:
        if (r104 == true) goto L67;
        f336598c = r106;     // Catch: Throwable -> L61
    L67:
        if (f336599d != r107) goto L69;
        f336599d = null;     // Catch: Throwable -> L61
    L69:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L61
        r105.unlock(null);
        r107.complete(r106);
        return r106;
    L61:
        th = move-exception;
        r105.unlock(null);
        throw th;
    L77:
        if (r106.length() != 0) goto L64;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        CompletableDeferred<String> r108 = (CompletableDeferred) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L53:
        String r113 = (String) r111;
        MutexImpl r109 = f336597b;
        r100.L$0 = r108;
        r100.L$1 = r113;
        r100.L$2 = r109;
        r100.label = 4;
        if (r109.a(null, r100) != r102) goto L56;
        return r102;
    L56:
        r107 = r108;
        r105 = r109;
        r106 = r113;
        goto L57
    L18:
        ResultKt.throwOnFailure(r111);
    L49:
        return r111;
    L19:
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L79:
        String r115 = f336598c;     // Catch: Throwable -> L74
        if (r115 != null) goto L29;
    L32:
        boolean r116 = true;
    L33:
        if (r116 == true) goto L35;
        CompletableDeferred r117 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L74
        r117.complete(r115);     // Catch: Throwable -> L74
        Pair r118 = TuplesKt.to(r117, Boxing.boxBoolean(false));     // Catch: Throwable -> L74
    L44:
        r114.unlock(null);
        r108 = (CompletableDeferred) r118.component1();
        if (((Boolean) r118.component2()).booleanValue() == true) goto L50;
        r100.L$0 = null;
        r100.label = 2;
        r111 = r108.await(r100);
        if (r111 != r102) goto L49;
        return r102;
    L50:
        r100.L$0 = r108;
        r100.label = 3;
        r111 = b(r100);
        if (r111 != r102) goto L53;
        return r102;
    L35:
        CompletableDeferred<String> r119 = f336599d;     // Catch: Throwable -> L74
        if (r119 != null) goto L38;
    L40:
        r119 = null;
    L41:
        if (r119 == null) goto L43;
        r118 = TuplesKt.to(r119, Boxing.boxBoolean(false));     // Catch: Throwable -> L74
        goto L44
    L43:
        CompletableDeferred<String> r120 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L74
        f336599d = r120;     // Catch: Throwable -> L74
        r118 = TuplesKt.to(r120, Boxing.boxBoolean(true));     // Catch: Throwable -> L74
        goto L44
    L38:
        if (r119.isActive() == false) goto L40;
    L29:
        if (r115.length() == 0) goto L32;
        r116 = false;
    L74:
        th = move-exception;
        r114.unlock(null);
        throw th;
    L20:
        ResultKt.throwOnFailure(r111);
        String r121 = f336598c;
        if (r121 == null) goto L23;
        return r121;
    L23:
        r114 = f336597b;
        r100.L$0 = r114;
        r100.label = 1;
        if (r114.a(null, r100) != r102) goto L79;
        return r102;
    L7:
        r100 = new OnboardingAvatarProvider$getAvatarUrl$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    public final Object b(Continuation<? super String> r110) {
        if ((r110 instanceof OnboardingAvatarProvider$requestAvatarUrl$1) == false) goto L7;
        OnboardingAvatarProvider$requestAvatarUrl$1 r100 = (OnboardingAvatarProvider$requestAvatarUrl$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Ref.ObjectRef r104 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r111);
        Object r112 = ((Result) r111).m9458unboximpl();
    L19:
        if (Result.m9456isSuccessimpl(r112) == false) goto L63;
        com.larus.dora.impl.network.e0 r105 = (com.larus.dora.impl.network.e0) r112;
        StringBuilder r106 = new StringBuilder("userLaunch success: ");
        List<com.larus.dora.impl.network.c> r107 = r105.a();
        T r108 = 0;
        if (r107 == null) goto L23;
        Integer r109 = Boxing.boxInt(r107.size());
    L24:
        r106.append(r109);
        g49.d.d("OnboardingAvatarProvider", r106.toString());
        Object r113 = ServiceManager.get().getService(IDoraService.class);
        if ((r113 instanceof DoraServiceImpl) == false) goto L27;
        DoraServiceImpl r114 = (DoraServiceImpl) r113;
    L28:
        if (r114 == null) goto L30;
        BotModel r115 = r114.F;
    L31:
        if (r115 == null) goto L37;
        String r116 = r115.getBotIconMappedAppIcon();
        if (r116 == null) goto L37;
        Integer r117 = StringsKt.toIntOrNull(r116);
        if (r117 == null) goto L37;
        int r118 = r117.intValue();
    L38:
        List<com.larus.dora.impl.network.c> r119 = r105.a();
        if (r119 == null) goto L56;
        Iterator<T> r120 = r119.iterator();
    L42:
        if (r120.hasNext() == false) goto L53;
        Object r121 = r120.next();
        com.larus.dora.impl.network.c r122 = (com.larus.dora.impl.network.c) r121;
        boolean r123 = false;
        if (r122 == null) goto L51;
        Integer r124 = r122.a();
        if (r124 == null) goto L51;
        if (r124.intValue() != r118) goto L51;
        r123 = true;
    L51:
        if (r123 == false) goto L42;
    L54:
        com.larus.dora.impl.network.c r125 = (com.larus.dora.impl.network.c) r121;
        if (r125 == null) goto L56;
    L60:
        if (r125 == null) goto L62;
        r108 = r125.b();
    L62:
        r104.element = r108;
        goto L63
    L53:
        r121 = null;
    L56:
        List<com.larus.dora.impl.network.c> r126 = r105.a();
        if (r126 == null) goto L59;
        r125 = (com.larus.dora.impl.network.c) CollectionsKt.firstOrNull(r126);
        goto L60
    L59:
        r125 = null;
    L37:
        r118 = 1;
        goto L38
    L30:
        r115 = null;
        goto L31
    L27:
        r114 = null;
        goto L28
    L23:
        r109 = null;
    L63:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r112);
        if (r127 == null) goto L67;
        g49.d.c("OnboardingAvatarProvider", "userLaunch failure", r127);
    L67:
        return r104.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        Ref.ObjectRef r128 = new Ref.ObjectRef();
        DoraNetworkApi r129 = DoraNetworkApi.f336157a;
        r100.L$0 = r128;
        r100.label = 1;
        Object r130 = r129.M(r100);
        if (r130 != r102) goto L17;
        return r102;
    L17:
        r104 = r128;
        r112 = r130;
    L7:
        r100 = new OnboardingAvatarProvider$requestAvatarUrl$1(this, r110);
        goto L8
    }
}
