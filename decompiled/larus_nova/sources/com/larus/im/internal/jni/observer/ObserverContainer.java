package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.observer.Observer;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vt7.a;
import vt7.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0002\b\u0019H\u0004J6\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u00002\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0002\b\u0019H\u0004¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u0001¢\u0006\u0002\u0010 J\u001b\u0010\"\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010%R\u0014\u0010\u0007\u001a\u00020\bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00060\fj\u0002`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0011X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/observer/ObserverContainer;", "Key", "O", "Lcom/larus/im/internal/jni/observer/Observer;", "", "<init>", "()V", "subTag", "", "getSubTag", "()Ljava/lang/String;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "observerList", "Lcom/flow/kmp/common/collections/CopyOnWriteArraySet;", "observerMap", "Lcom/flow/kmp/common/collections/ConcurrentHashMap;", "getObserverMap", "()Lcom/flow/kmp/common/collections/ConcurrentHashMap;", "notifyAll", "", "from", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "notify", "key", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "registerGlobal", "", "observer", "(Lcom/larus/im/internal/jni/observer/Observer;)Z", "unregisterGlobal", MiPushClient.COMMAND_REGISTER, "(Ljava/lang/Object;Lcom/larus/im/internal/jni/observer/Observer;)V", MiPushClient.COMMAND_UNREGISTER, "(Ljava/lang/Object;)Lcom/larus/im/internal/jni/observer/Observer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ObserverContainer<Key, O extends Observer> {
    private final ReentrantLock lock;
    private final b<O> observerList;
    private final a<String, O> observerMap;
    private final String subTag;

    public ObserverContainer() {
        this.subTag = "ObserverContainer";
        this.lock = new ReentrantLock();
        this.observerList = new b();
        this.observerMap = new a();
    }

    public final a<String, O> getObserverMap() {
        return this.observerMap;
    }

    public String getSubTag() {
        return this.subTag;
    }

    public final boolean registerGlobal(O r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ReentrantLock r101 = this.lock;
        r101.lock();
        boolean r102 = this.observerList.add(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final O unregister(Key r100) {
        ReentrantLock r101 = this.lock;
        r101.lock();
        O r102 = this.observerMap.remove(String.valueOf(r100));     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final boolean unregisterGlobal(O r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ReentrantLock r101 = this.lock;
        r101.lock();
        boolean r102 = this.observerList.remove(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void notifyAll(String r100, Function1<? super O, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "action");
        ReentrantLock r102 = this.lock;
        r102.lock();
        com.larus.im.internal.delegate.a.f348188b.i(getSubTag(), "notifyAll from " + r100);     // Catch: Throwable -> L10
        Iterator<O> r103 = this.observerList.iterator();     // Catch: Throwable -> L10
    L5:
        if (r103.hasNext() == false) goto L7;
        r101.invoke(r103.next());     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r102.unlock();
        return;
    L10:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    public final void register(Key r100, O r101) {
        Intrinsics.checkNotNullParameter(r101, "observer");
        ReentrantLock r102 = this.lock;
        r102.lock();
        this.observerMap.put(String.valueOf(r100), r101);     // Catch: Throwable -> L6
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r102.unlock();
        return;
    L6:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    public final void notify(String r100, Key r101, Function1<? super O, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r102, "action");
        ReentrantLock r103 = this.lock;
        r103.lock();
        com.larus.im.internal.delegate.a.f348188b.i(getSubTag(), "notify " + r101 + " from " + r100);     // Catch: Throwable -> L9
        O r104 = this.observerMap.get(String.valueOf(r101));     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        r102.invoke(r104);     // Catch: Throwable -> L9
    L6:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r103.unlock();
        return;
    L9:
        th = move-exception;
        r103.unlock();
        throw th;
    }
}
