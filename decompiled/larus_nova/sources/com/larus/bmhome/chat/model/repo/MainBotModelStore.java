package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class MainBotModelStore {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<String> f307712i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f307713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoroutineScope f307714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BotServiceImpl f307715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f307716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f307717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BotModel f307718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CompletableDeferred f307719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z1 f307720h;

    public static final class a {
    }

    public static final class b implements com.larus.platform.api.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainBotModelStore f307721a;

        public b(MainBotModelStore r100) {
            this.f307721a = r100;
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            MainBotModelStore.a(this.f307721a, "account_online");
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            MainBotModelStore.a(this.f307721a, "account_offline");
        }
    }

    public static final class c implements m4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainBotModelStore f307722a;

        @Override // com.larus.platform.api.m4
        public final void S1() {
            MainBotModelStore.a(this.f307722a, "minor_mode_on");
        }

        @Override // com.larus.platform.api.m4
        public final void b1() {
            MainBotModelStore.a(this.f307722a, "minor_mode_off");
        }

        public c(MainBotModelStore r100) {
            this.f307722a = r100;
        }
    }

    static {
        f307712i = LazyKt.lazy(new y1());
    }

    public MainBotModelStore() {
        this.f307713a = new Object();
        this.f307714b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f307715c = com.larus.im.d.a();
        b r100 = new b(this);
        c r101 = new c(this);
        AccountService r102 = AccountService.f365697a;
        r102.E(r100);
        r102.H(r101);
    }

    public static final void a(MainBotModelStore r100, String r101) {
        Object r102 = r100.f307713a;
        monitor-enter(r102);
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L20
        StringBuilder r104 = new StringBuilder("clear, reason=");     // Catch: Throwable -> L20
        r104.append(r101);     // Catch: Throwable -> L20
        r104.append(", cached=");     // Catch: Throwable -> L20
        boolean r105 = false;
        if (r100.f307718f == null) goto L7;
        boolean r106 = true;
    L8:
        r104.append(r106);     // Catch: Throwable -> L20
        r104.append(", pending=");     // Catch: Throwable -> L20
        if (r100.f307719g == null) goto L11;
        r105 = true;
    L11:
        r104.append(r105);     // Catch: Throwable -> L20
        r103.i("MainBotModelStore", r104.toString());     // Catch: Throwable -> L20
        String r107 = r100.f307716d;     // Catch: Throwable -> L20
        if (r107 == null) goto L16;
        z1 r108 = r100.f307720h;     // Catch: Throwable -> L20
        if (r108 == null) goto L16;
        r100.f307715c.unregisterBotChangeListener(r107, r108);     // Catch: Throwable -> L20
    L16:
        r100.f307718f = null;     // Catch: Throwable -> L20
        r100.f307719g = null;     // Catch: Throwable -> L20
        r100.f307716d = null;     // Catch: Throwable -> L20
        r100.f307720h = null;     // Catch: Throwable -> L20
        CoroutineScope r109 = r100.f307714b;     // Catch: Throwable -> L20
        r100.f307714b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));     // Catch: Throwable -> L20
        monitor-exit(r102);
        CoroutineScopeKt.cancel$default(r109, null, 1, null);
        return;
    L7:
        r106 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public static final void b(MainBotModelStore r100, CoroutineScope r101, long r110, CompletableDeferred r111, BotModel r112) {
        Object r102 = r100.f307713a;
        monitor-enter(r102);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (r101 == r100.f307714b) goto L7;
    L29:
        FLogger.f375446a.d("MainBotModelStore", "ignore stale result, request=" + r111.hashCode());     // Catch: Throwable -> L32
        monitor-exit(r102);
        return;
    L7:
        if (r111.isActive() == false) goto L29;
        String r103 = null;
        if (r100.f307719g != r111) goto L12;
        r100.f307719g = null;     // Catch: Throwable -> L32
    L12:
        boolean r104 = true;
        if (r110 != r100.f307717e) goto L19;
        if (r112 == null) goto L17;
        r103 = r112.getBotId();     // Catch: Throwable -> L32
    L17:
        if (Intrinsics.areEqual(r103, r100.f307716d) == false) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == false) goto L22;
        r100.f307718f = r112;     // Catch: Throwable -> L32
        r100.f307717e++;     // Catch: Throwable -> L32
    L22:
        FLogger r105 = FLogger.f375446a;     // Catch: Throwable -> L32
        StringBuilder r106 = new StringBuilder("sdk read end, request=");     // Catch: Throwable -> L32
        r106.append(r111.hashCode());     // Catch: Throwable -> L32
        r106.append(", success=");     // Catch: Throwable -> L32
        if (r112 != null) goto L26;
        r104 = false;
    L26:
        r106.append(r104);     // Catch: Throwable -> L32
        r106.append(", cacheUpdated=");     // Catch: Throwable -> L32
        r106.append(r113);     // Catch: Throwable -> L32
        r105.i("MainBotModelStore", r106.toString());     // Catch: Throwable -> L32
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r102);
        r111.complete(r112);
        return;
    L19:
        r113 = false;
        goto L20
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, kotlinx.coroutines.CoroutineScope] */
    public final Object c(String r110, boolean r111, String r112, boolean r210, Continuation<? super BotModel> r211) {
        if ((r211 instanceof MainBotModelStore$findBot$1) == false) goto L7;
        MainBotModelStore$findBot$1 r100 = (MainBotModelStore$findBot$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MainBotModelStore$findBot$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r113 = false;
        BotModel r114 = null;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        int r106 = r102.I$0;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: CancellationException -> L14
    L39:
        BotModel r108 = (BotModel) r103;     // Catch: CancellationException -> L14
        Object r109 = this.f307713a;
        monitor-enter(r109);
    L51:
        th = move-exception;
        throw th;
    L43:
        if (r107.element != this.f307714b) goto L49;
        if (r106 == 0) goto L48;
        r114 = this.f307718f;     // Catch: Throwable -> L51
        goto L49
    L48:
        r114 = r108;
    L49:
        monitor-exit(r109);
        return r114;
    L14:
        e = e;
        Ref.ObjectRef r115 = r107;
    L56:
        JobKt.ensureActive(r102.getContext());
        Object r116 = this.f307713a;
        monitor-enter(r116);
        if (r115.element == this.f307714b) goto L61;
        r113 = true;
    L61:
        monitor-exit(r116);
        if (r113 == false) goto L64;
        return null;
    L64:
        throw e;
    L65:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        int r117 = !r111 ? 1 : 0;
        r115 = new Ref.ObjectRef();
        Object r118 = this.f307713a;
        monitor-enter(r118);
        r115.element = this.f307714b;     // Catch: Throwable -> L68
        if (r117 == 0) goto L30;
        BotModel r119 = this.f307718f;     // Catch: Throwable -> L68
        if (r119 == null) goto L27;
        FLogger.f375446a.d("MainBotModelStore", "cache hit, botId=" + r110 + ", scene=" + r112);     // Catch: Throwable -> L68
        monitor-exit(r118);
        return r119;
    L27:
        CompletableDeferred r120 = this.f307719g;     // Catch: Throwable -> L68
        if (r120 == null) goto L30;
        FLogger.f375446a.d("MainBotModelStore", "reuse pending, botId=" + r110 + ", request=" + r120.hashCode() + ", scene=" + r112);     // Catch: Throwable -> L68
    L34:
        monitor-exit(r118);
        r102.L$0 = r115;     // Catch: CancellationException -> L55
        r102.I$0 = r117;     // Catch: CancellationException -> L55
        r102.label = 1;     // Catch: CancellationException -> L55
        r103 = r120.await(r102);     // Catch: CancellationException -> L55
        if (r103 != r104) goto L38;
        return r104;
    L38:
        r106 = r117;
        r107 = r115;
    L55:
        e = e;
    L30:
        if (r117 == 0) goto L32;
        boolean r121 = true;
    L33:
        r120 = d(r110, r111, r112, r210, r121);     // Catch: Throwable -> L68
        goto L34
    L32:
        r121 = false;
    L68:
        th = move-exception;
        throw th;
    L7:
        r100 = new MainBotModelStore$findBot$1(this, r211);
        goto L8
    }

    public final CompletableDeferred d(String r110, boolean r210, String r211, boolean r212, boolean r213) {
        CoroutineScope r111 = this.f307714b;
        if (this.f307720h != null) goto L5;
        this.f307716d = r110;
        z1 r100 = new z1(this, r110, r111);
        this.f307715c.registerBotChangeListener(r110, r100);
        this.f307720h = r100;
    L5:
        long r101 = this.f307717e;
        CompletableDeferred r112 = CompletableDeferredKt.CompletableDeferred((Job) r111.getCoroutineContext().get(Job.Key));
        if (r213 == false) goto L8;
        this.f307719g = r112;
    L8:
        BuildersKt.launch$default(r111, null, null, new MainBotModelStore$load$3(r112, r110, r210, r212, r213, r211, this, r111, r101, null), 3, null);
        return r112;
    }
}
