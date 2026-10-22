package io.ktor.client.plugins.observer;

import io.ktor.util.KtorDsl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
public final class ResponseObserver {

    @KtorDsl
    public static final class Config {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function2<? super io.ktor.client.statement.b, ? super Continuation<? super Unit>, ? extends Object> f491729a;

        public Config() {
            this.f491729a = new ResponseObserver$Config$responseHandler$1(null);
        }
    }
}
