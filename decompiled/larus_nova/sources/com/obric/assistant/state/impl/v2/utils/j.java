package com.obric.assistant.state.impl.v2.utils;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f393225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f393226b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f393227c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f393228d = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e("ObricStateMachine", r101.getMessage());
        }
    }

    static {
        f393225a = LazyKt.lazy(new g());
        f393226b = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new h()));
        f393227c = new a(CoroutineExceptionHandler.Key);
        f393228d = LazyKt.lazy(new i());
    }
}
