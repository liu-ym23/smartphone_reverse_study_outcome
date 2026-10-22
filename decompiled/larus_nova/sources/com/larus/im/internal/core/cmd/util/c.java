package com.larus.im.internal.core.cmd.util;

import com.flow.kmp.common.util.ReentrantMutex;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f347537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f347538b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f347539c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReentrantMutex f347540d = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            com.larus.im.internal.delegate.a.f348188b.e("CmdCoroutineScope", r101.getMessage());
        }
    }

    static {
        f347537a = new a(CoroutineExceptionHandler.Key);
        f347538b = LazyKt.lazy(new com.larus.im.internal.core.cmd.util.a());
        f347539c = LazyKt.lazy(new b());
        f347540d = new ReentrantMutex(null);
    }

    public static final void a(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        BuildersKt.launch$default((CoroutineScope) f347539c.getValue(), null, null, new CmdCoroutineScopeKt$cmdContext$1(r100, null), 3, null);
    }
}
