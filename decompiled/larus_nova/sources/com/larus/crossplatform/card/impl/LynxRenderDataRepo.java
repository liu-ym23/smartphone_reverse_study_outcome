package com.larus.crossplatform.card.impl;

import com.larus.common.apphost.AppHost;
import com.larus.utils.cache.DiskCache;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.ExceptionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class LynxRenderDataRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f330484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DiskCache f330485b = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            String r102 = ExceptionsKt.stackTraceToString(r101);
            FLogger r103 = FLogger.f375446a;
            CoroutineScope r104 = LynxRenderDataRepo.f330484a;
            r103.e("LynxRenderDataRepo", "exception=" + r102);
            if (AppHost.f326268a.isTestChannel() == true) goto L5;
            return;
        L5:
            throw r101;
        }
    }

    public LynxRenderDataRepo() {
    }

    static {
        a r100 = new a(CoroutineExceptionHandler.Key);
        f330484a = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new f())).plus(r100));
        f330485b = new DiskCache("plugin-data-ivy");
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        BuildersKt.launch$default(f330484a, Dispatchers.getIO(), null, new LynxRenderDataRepo$deletePluginViewCacheData$1(r100, null, null), 2, null);
    }

    public static void c(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BuildersKt.launch$default(f330484a, Dispatchers.getIO(), null, new LynxRenderDataRepo$readPluginViewCacheData$1(r100, r101, null), 2, null);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "data");
        BuildersKt.launch$default(f330484a, Dispatchers.getIO(), null, new LynxRenderDataRepo$savePluginViewCacheData$1(r100, r101, null), 2, null);
    }

    public static void b(String r110, String r111, Function2 r112) {
        Intrinsics.checkNotNullParameter(r110, "dataUrl");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r112, "c");
        Ref.LongRef r100 = new Ref.LongRef();
        BuildersKt.launch$default(f330484a, Dispatchers.getIO(), null, new LynxRenderDataRepo$loadLynxData$1(r110, r111, r100, r112, null), 2, null);
    }
}
