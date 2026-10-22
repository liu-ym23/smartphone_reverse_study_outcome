package com.obric.assistant.interaction.impl.activityresult;

import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\bJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestStore;", "", "scheduler", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestScheduler;", "<init>", "(Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestScheduler;)V", "lock", "nextToken", "", "current", "Lcom/obric/assistant/interaction/impl/activityresult/ProxyRequest;", "install", "listener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "consume", "token", "clearIfCurrent", "", "request", "reason", "", "cancelReason", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelReason;", "resetForTest", "", "nextTokenLocked", "dispatchCancel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityProxyRequestStore {
    private ProxyRequest current;
    private final Object lock;
    private long nextToken;
    private final ActivityProxyRequestScheduler scheduler;

    public static /* synthetic */ void a(ActivityProxyRequestStore r100, long r101, Ref.ObjectRef r102) {
        install$lambda$1$lambda$0(r100, r101, r102);
    }

    public static /* synthetic */ void b(ActivityProxyCancelCallback r100, ActivityProxyCancelReason r101) {
        dispatchCancel$lambda$8(r100, r101);
    }

    private final long nextTokenLocked() {
        long r100 = this.nextToken + 1;
        this.nextToken = r100;
        if (r100 >= 1) goto L6;
        this.nextToken = 1;
    L6:
        return this.nextToken;
    }

    public final void resetForTest() {
        Object r100 = this.lock;
        monitor-enter(r100);
        ProxyRequest r101 = this.current;     // Catch: Throwable -> L9
        this.current = null;     // Catch: Throwable -> L9
        this.nextToken = 0;     // Catch: Throwable -> L9
        monitor-exit(r100);
        if (r101 == null) goto L14;
        this.scheduler.removeCallbacks(r101.getTimeoutRunnable());
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public ActivityProxyRequestStore(ActivityProxyRequestScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "scheduler");
        this.scheduler = r100;
        this.lock = new Object();
    }

    public final ActivityProxyListener consume(long r100) {
        if (r100 >= 1) goto L5;
        return null;
    L5:
        Object r101 = this.lock;
        monitor-enter(r101);
        ProxyRequest r102 = this.current;     // Catch: Throwable -> L21
        boolean r103 = false;
        if (r102 != null) goto L10;
    L12:
        if (r103 == false) goto L15;
        this.current = null;     // Catch: Throwable -> L21
    L16:
        monitor-exit(r101);
        if (r102 != null) goto L19;
        return null;
    L19:
        this.scheduler.removeCallbacks(r102.getTimeoutRunnable());
        return r102.getListener();
    L15:
        r102 = null;
        goto L16
    L10:
        if (r102.getToken() != r100) goto L12;
        r103 = true;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, com.obric.assistant.interaction.impl.activityresult.ProxyRequest] */
    public final ProxyRequest install(ActivityProxyListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        Object r102 = this.lock;
        monitor-enter(r102);
        final long r103 = nextTokenLocked();     // Catch: Throwable -> L20
        ?? r104 = new ProxyRequest(r103, r100, new a(this, r103, r101));     // Catch: Throwable -> L20
        r101.element = r104;     // Catch: Throwable -> L20
        ProxyRequest r105 = this.current;     // Catch: Throwable -> L20
        ProxyRequest r106 = (ProxyRequest) r104;     // Catch: Throwable -> L20
        this.current = r104;     // Catch: Throwable -> L20
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);
        if (r105 == null) goto L8;
        this.scheduler.removeCallbacks(r105.getTimeoutRunnable());
    L8:
        ActivityProxyRequestScheduler r108 = this.scheduler;
        T r109 = r101.element;
        if (r109 != 0) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("request");
        ProxyRequest r110 = null;
    L12:
        r108.postDelayed(r110.getTimeoutRunnable(), 10000);
        if (r105 == null) goto L15;
        dispatchCancel(r105, ActivityProxyCancelReason.START_REPLACED);
    L15:
        T r111 = r101.element;
        if (r111 != 0) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("request");
        return null;
    L19:
        return (ProxyRequest) r111;
    L11:
        r110 = (ProxyRequest) r109;
    L20:
        th = move-exception;
        throw th;
    }

    private final void dispatchCancel(ProxyRequest r100, final ActivityProxyCancelReason r101) {
        ActivityProxyListener r102 = r100.getListener();
        if ((r102 instanceof ActivityProxyCancelCallback) == false) goto L5;
        final ActivityProxyCancelCallback r103 = (ActivityProxyCancelCallback) r102;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        this.scheduler.post(new b(r103, r101));
        return;
    L5:
        r103 = null;
        goto L6
    }

    private static final void dispatchCancel$lambda$8(ActivityProxyCancelCallback r100, ActivityProxyCancelReason r101) {
        r100.onProxyCanceled(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void install$lambda$1$lambda$0(ActivityProxyRequestStore r100, long r101, Ref.ObjectRef r102) {
        T r103 = r102.element;
        if (r103 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("request");
        ProxyRequest r104 = null;
    L6:
        r100.clearIfCurrent(r101, r104, "timeout_before_on_create", ActivityProxyCancelReason.TIMEOUT_BEFORE_ON_CREATE);
        return;
    L5:
        r104 = (ProxyRequest) r103;
        goto L6
    }

    public final boolean clearIfCurrent(long r100, ProxyRequest r101, String r102, ActivityProxyCancelReason r110) {
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r100 >= 1) goto L5;
        return false;
    L5:
        Object r103 = this.lock;
        monitor-enter(r103);
        ProxyRequest r104 = this.current;     // Catch: Throwable -> L22
        if (r104 == r101) goto L10;
    L13:
        r104 = null;
    L14:
        monitor-exit(r103);
        if (r104 != null) goto L17;
        return false;
    L17:
        this.scheduler.removeCallbacks(r104.getTimeoutRunnable());
        if (r110 == null) goto L27;
        dispatchCancel(r104, r110);
        return true;
    L27:
        return true;
    L10:
        if (r104.getToken() != r100) goto L13;
        this.current = null;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
