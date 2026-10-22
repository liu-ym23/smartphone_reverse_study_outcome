package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class DataPreloadManagerV2 implements d, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f413484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> f413485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>> f413486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f413487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CoroutineScope f413488e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f413487d;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        CoroutineScope r101 = this.f413488e;
        if (r101 == null) goto L5;
        CoroutineScopeKt.cancel$default(r101, null, 1, null);
    L5:
        this.f413488e = null;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f413488e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d
    public final <S> Object B6(w3b.d<S> r100, Continuation<? super Result<? extends S>> r101) {
        if ((r101 instanceof DataPreloadManagerV2$fetchData$1) == false) goto L7;
        DataPreloadManagerV2$fetchData$1 r102 = (DataPreloadManagerV2$fetchData$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        w3b.d r107 = (w3b.d) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L30:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        final j r108 = new j(IntrinsicsKt.intercepted(r102), 1);
        r108.C();
        Provider<v3b.d<? extends w3b.d<?>, ?>> r109 = this.f413486c.get(r100.type());
        v3b.d<? extends w3b.d<?>, ?> r110 = null;
        if (r109 == null) goto L17;
        v3b.d<? extends w3b.d<?>, ?> r111 = r109.get();
    L19:
        if ((r111 instanceof v3b.d) == false) goto L21;
        r110 = r111;
    L21:
        if (r110 != null) goto L23;
        Log.e("DataPreloaderV2", "Could not find a keyProvider for target task");
        Result.Companion r112 = Result.Companion;
        r108.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new Exception("Could not find a keyProvider for target task"))));
    L24:
        r104 = r108.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L27:
        if (r104 != r105) goto L30;
        return r105;
    L23:
        this.f413484a.a(r110.a(r100), r100, new DataPreloadManagerV2$fetchData$2$1(r108));
        goto L24
    L17:
        r111 = null;
    L7:
        r102 = new DataPreloadManagerV2$fetchData$1(this, r101);
        goto L8
    }

    @Inject
    public DataPreloadManagerV2(c r100, Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> r101, Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>> r102, m r103) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        Intrinsics.checkNotNullParameter(r101, "loaders");
        Intrinsics.checkNotNullParameter(r102, "keyProviders");
        Intrinsics.checkNotNullParameter(r103, "passport");
        this.f413484a = r100;
        this.f413485b = r101;
        this.f413486c = r102;
        this.f413487d = r103;
        r103.d(this);
    }
}
