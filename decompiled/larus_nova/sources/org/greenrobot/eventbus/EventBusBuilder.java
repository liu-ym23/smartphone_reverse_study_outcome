package org.greenrobot.eventbus;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes42.dex */
public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = null;
    boolean eventInheritance;
    ExecutorService executorService;
    boolean ignoreGeneratedIndex;
    boolean logNoSubscriberMessages;
    boolean logSubscriberExceptions;
    g logger;
    h mainThreadSupport;
    ExecutorService preloadService;
    boolean sendNoSubscriberEvent;
    boolean sendSubscriberExceptionEvent;
    List<Class<?>> skipMethodVerificationForClasses;
    boolean strictMethodVerification;
    List<zvc.b> subscriberInfoIndexes;
    boolean throwSubscriberException;

    static {
        DEFAULT_EXECUTOR_SERVICE = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("EventBusBuilder"));
    }

    public EventBus build() {
        return new EventBus(this);
    }

    public g getLogger() {
        g r100 = this.logger;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (yvc.a.f569331a == false) goto L13;
        Looper r101 = Looper.getMainLooper();     // Catch: RuntimeException -> L9
    L10:
        if (r101 == null) goto L13;
        return new yvc.a();
    L9:
        r101 = null;
    L13:
        return new g.a();
    }

    public h getMainThreadSupport() {
        h r100 = this.mainThreadSupport;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (yvc.a.f569331a == false) goto L12;
        Object r101 = getAndroidMainLooperOrNull();
        if (r101 != null) goto L11;
        return null;
    L11:
        return new h.a((Looper) r101);
    L12:
        return null;
    }

    public EventBus installDefaultEventBus() {
        monitor-enter(EventBus.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (EventBus.defaultInstance != null) goto L10;
        EventBus.defaultInstance = build();     // Catch: Throwable -> L11
        EventBus r100 = EventBus.defaultInstance;     // Catch: Throwable -> L11
        monitor-exit(EventBus.class);     // Catch: Throwable -> L11
        return r100;
    L10:
        throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");     // Catch: Throwable -> L11
    }

    public EventBusBuilder() {
        this.logSubscriberExceptions = true;
        this.logNoSubscriberMessages = true;
        this.sendSubscriberExceptionEvent = true;
        this.sendNoSubscriberEvent = true;
        this.eventInheritance = true;
        this.executorService = DEFAULT_EXECUTOR_SERVICE;
        this.preloadService = null;
    }

    public static Object getAndroidMainLooperOrNull() {
        return Looper.getMainLooper();
    L4:
        return null;
    }

    public EventBusBuilder addIndex(zvc.b r100) {
        if (this.subscriberInfoIndexes != null) goto L5;
        this.subscriberInfoIndexes = new ArrayList();
    L5:
        this.subscriberInfoIndexes.add(r100);
        return this;
    }

    public EventBusBuilder eventInheritance(boolean r100) {
        this.eventInheritance = r100;
        return this;
    }

    public EventBusBuilder executorService(ExecutorService r100) {
        this.executorService = r100;
        return this;
    }

    public EventBusBuilder ignoreGeneratedIndex(boolean r100) {
        this.ignoreGeneratedIndex = r100;
        return this;
    }

    public EventBusBuilder logNoSubscriberMessages(boolean r100) {
        this.logNoSubscriberMessages = r100;
        return this;
    }

    public EventBusBuilder logSubscriberExceptions(boolean r100) {
        this.logSubscriberExceptions = r100;
        return this;
    }

    public EventBusBuilder logger(g r100) {
        this.logger = r100;
        return this;
    }

    public EventBusBuilder preloadService(ExecutorService r100) {
        this.preloadService = r100;
        return this;
    }

    public EventBusBuilder sendNoSubscriberEvent(boolean r100) {
        this.sendNoSubscriberEvent = r100;
        return this;
    }

    public EventBusBuilder sendSubscriberExceptionEvent(boolean r100) {
        this.sendSubscriberExceptionEvent = r100;
        return this;
    }

    public EventBusBuilder skipMethodVerificationFor(Class<?> r100) {
        if (this.skipMethodVerificationForClasses != null) goto L5;
        this.skipMethodVerificationForClasses = new ArrayList();
    L5:
        this.skipMethodVerificationForClasses.add(r100);
        return this;
    }

    public EventBusBuilder strictMethodVerification(boolean r100) {
        this.strictMethodVerification = r100;
        return this;
    }

    public EventBusBuilder throwSubscriberException(boolean r100) {
        this.throwSubscriberException = r100;
        return this;
    }
}
