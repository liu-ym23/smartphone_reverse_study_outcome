package io.ktor.utils.io;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements Job {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f492054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f492055b;

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.o attachChild(kotlinx.coroutines.q r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return this.f492054a.attachChild(r100);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ void cancel() {
        this.f492054a.cancel();
    }

    @Override // kotlinx.coroutines.Job
    public final void cancel(CancellationException r100) {
        this.f492054a.cancel(r100);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable r100) {
        return this.f492054a.cancel(r100);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        return (R) this.f492054a.fold(r100, r101);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (E) this.f492054a.get(r100);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        return this.f492054a.getCancellationException();
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> getChildren() {
        return this.f492054a.getChildren();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return this.f492054a.getKey();
    }

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.selects.e getOnJoin() {
        return this.f492054a.getOnJoin();
    }

    @Override // kotlinx.coroutines.Job
    public final Job getParent() {
        return this.f492054a.getParent();
    }

    @Override // kotlinx.coroutines.Job
    public final m0 invokeOnCompletion(Function1<? super Throwable, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        return this.f492054a.invokeOnCompletion(r100);
    }

    @Override // kotlinx.coroutines.Job
    public final m0 invokeOnCompletion(boolean r100, boolean r101, Function1<? super Throwable, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "handler");
        return this.f492054a.invokeOnCompletion(r100, r101, r102);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isActive() {
        return this.f492054a.isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        return this.f492054a.isCancelled();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return this.f492054a.isCompleted();
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> r100) {
        return this.f492054a.join(r100);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f492054a.minusKey(r100);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f492054a.plus(r100);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public final Job plus(Job r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return this.f492054a.plus(r100);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        return this.f492054a.start();
    }

    public final String toString() {
        return "ChannelJob[" + this.f492054a + ']';
    }

    public f(Job r100, ByteBufferChannel r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "channel");
        this.f492054a = r100;
        this.f492055b = r101;
    }
}
