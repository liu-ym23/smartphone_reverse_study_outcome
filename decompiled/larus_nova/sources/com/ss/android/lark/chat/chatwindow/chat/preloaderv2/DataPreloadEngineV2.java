package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import android.util.LruCache;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class DataPreloadEngineV2 implements c, r {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f413475i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f413476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> f413477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CoroutineScope f413478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f413479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f413480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f413481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f413482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lock f413483h;

    public static final class a {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    static {
        f413475i = Runtime.getRuntime().availableProcessors() + 3;
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f413476a;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        CoroutineScope r101 = this.f413478c;
        if (r101 == null) goto L5;
        CoroutineScopeKt.cancel$default(r101, null, 1, null);
    L5:
        this.f413478c = null;
    }

    @Inject
    public DataPreloadEngineV2(m r100, Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "loaders");
        this.f413476a = r100;
        this.f413477b = r101;
        r100.d(this);
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f413479d = LazyKt.lazy(r102, DataPreloadEngineV2$preloaderExecutor$2.INSTANCE);
        this.f413480e = LazyKt.lazy(r102, new DataPreloadEngineV2$dispatcher$2(this));
        this.f413481f = LazyKt.lazy(r102, DataPreloadEngineV2$preloadResultCache$2.INSTANCE);
        this.f413482g = LazyKt.lazy(r102, DataPreloadEngineV2$dataPreLoadJobPool$2.INSTANCE);
        this.f413483h = new ReentrantLock();
    }

    public final <S> void b(w3b.c<S> r110, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> r111) {
        Intrinsics.checkNotNullParameter(r110, "job");
        Intrinsics.checkNotNullParameter(r111, "loader");
        String r100 = r110.f558218a;
        ((LruCache) this.f413482g.getValue()).put(r100, r110);
        Log.i("DataPreloadEngineV2", "Execute：" + r100);
        if (this.f413478c != null) goto L5;
        this.f413478c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus((ExecutorCoroutineDispatcher) this.f413480e.getValue()));
    L5:
        CoroutineScope r101 = this.f413478c;
        if (r101 == null) goto L9;
        BuildersKt.launch$default(r101, (ExecutorCoroutineDispatcher) this.f413480e.getValue(), null, new DataPreloadEngineV2$load$1(r111, r110, this, r100, null), 2, null);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.c
    public final <S> void a(String r100, w3b.d<S> r101, Function1<? super Result<? extends S>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "task");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ((ReentrantLock) this.f413483h).lock();
        Object r103 = ((Map) this.f413481f.getValue()).remove(r100);     // Catch: Throwable -> L34
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> r104 = null;
        if ((r103 instanceof Result) == false) goto L7;
        Result r105 = (Result) r103;     // Catch: Throwable -> L34
    L9:
        if (r105 != null) goto L11;
        Object r106 = ((LruCache) this.f413482g.getValue()).get(r100);     // Catch: Throwable -> L34
        if ((r106 instanceof w3b.c) == false) goto L18;
        w3b.c r107 = (w3b.c) r106;     // Catch: Throwable -> L34
    L19:
        if (r107 == null) goto L21;
        r107.f558220c = r102;     // Catch: Throwable -> L34
    L30:
        ((ReentrantLock) this.f413483h).unlock();
        return;
    L21:
        Log.e("DataPreloadEngineV2", "Failed to find task when fetch data：" + r100);     // Catch: Throwable -> L34
        w3b.c<S> r108 = new w3b.c(r100, r101, r102);     // Catch: Throwable -> L34
        Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>> r109 = this.f413477b.get(r101.type());     // Catch: Throwable -> L34
        if (r109 == null) goto L24;
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> r110 = (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c) r109.get();     // Catch: Throwable -> L34
    L26:
        if ((r110 instanceof com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c) == false) goto L28;
        r104 = r110;
    L28:
        if (r104 != null) goto L32;
        Log.e("DataPreloaderV2", "Could not find a loader for target task");     // Catch: Throwable -> L34
        goto L30
    L32:
        b(r108, r104);     // Catch: Throwable -> L34
        goto L30
    L24:
        r110 = null;
        goto L26
    L18:
        r107 = null;
        goto L19
    L11:
        if (Result.m9456isSuccessimpl(r105.m9458unboximpl()) == false) goto L13;
        Log.i("DataPreloadEngineV2", "Task:" + r100 + " Fetch data after task finish, return result");     // Catch: Throwable -> L34
    L14:
        r102.invoke(r105);     // Catch: Throwable -> L34
        goto L30
    L13:
        Log.e("DataPreloadEngineV2", "Task: " + r100 + " Fetch data after task finish, return error:" + Result.m9452exceptionOrNullimpl(r105.m9458unboximpl()));     // Catch: Throwable -> L34
        goto L14
    L7:
        r105 = null;
    L34:
        th = move-exception;
        ((ReentrantLock) this.f413483h).unlock();
        throw th;
    }
}
