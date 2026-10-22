package com.bytedance.android.livesdk.lifecycle;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycle;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleForSaas;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleInterceptor;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleObserver;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0010\u001f\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J(\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J*\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000e2\u0018\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J)\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001d2\u0006\u0010\u001e\u001a\u0002H\u000fH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/lifecycle/LifeCycleService;", "Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycle;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/lifecycle/ILifeCycleAware;", "()V", "mObservers", "", "Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleObserver;", "addObserver", "", "observer", "checkMainThread", "dumpClassNames", "", "", "T", "", "c", "", "onEndSession", "roomId", "map", "Ljava/util/HashMap;", "onEnterLiveRoomSuccess", "anchorId", "onInteractionFragmentDestroy", "onShowLiveEnd", "removeInCollection", "", "", "o", "(Ljava/util/Collection;Ljava/lang/Object;)I", "removeObserver", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LifeCycleService implements ILiveLifecycle, IService, ILifeCycleAware {
    private final List<ILiveLifecycleObserver> mObservers;

    public final /* synthetic */ void addInterceptor(ILiveLifecycleInterceptor r1) {
        ILiveLifecycleForSaas.-CC.$default$addInterceptor(this, r1);
    }

    public final /* synthetic */ void removeInterceptor(ILiveLifecycleInterceptor r1) {
        ILiveLifecycleForSaas.-CC.$default$removeInterceptor(this, r1);
    }

    public LifeCycleService() {
        this.mObservers = new LinkedList();
        k.l(ILifeCycleAware.class, this);
    }

    private final void checkMainThread() {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == true) goto L5;
        return;
    L5:
        if (Logger.debug() == true) goto L8;
        return;
    L8:
        throw new IllegalThreadStateException("Must call in main thread");
    }

    private final <T> List<String> dumpClassNames(Collection<? extends T> r3) {
        Iterator<? extends T> r0 = r3.iterator();
        ArrayList r1 = new ArrayList(r3.size());
    L4:
        if (r0.hasNext() == false) goto L6;
        r1.add(r0.next().getClass().getName());
        goto L4
    L6:
        return r1;
    }

    public void addObserver(ILiveLifecycleObserver r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        checkMainThread();
        this.mObservers.add(r3);
        if (Logger.debug() == true) goto L5;
        return;
    L5:
        if (this.mObservers.size() <= 10) goto L9;
        Logger.alertErrorInfo("too many observers:" + TextUtils.join(",", dumpClassNames(this.mObservers)));
        return;
    }

    @Override // com.bytedance.android.livesdk.lifecycle.ILifeCycleAware
    public void onEndSession(String r5) {
        Intrinsics.checkNotNullParameter(r5, "roomId");
        Iterator r0 = new ArrayList(this.mObservers).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ILiveLifecycleObserver) r0.next()).onLifecycleEvent(ILiveLifecycleObserver.Event.EndSession, r5, MapsKt.emptyMap());
        goto L4
    }

    @Override // com.bytedance.android.livesdk.lifecycle.ILifeCycleAware
    public void onInteractionFragmentDestroy(String r5) {
        Intrinsics.checkNotNullParameter(r5, "roomId");
        Iterator r0 = new ArrayList(this.mObservers).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ILiveLifecycleObserver) r0.next()).onLifecycleEvent(ILiveLifecycleObserver.Event.InteractionFragmentDestroy, r5, MapsKt.emptyMap());
        goto L4
    }

    @Override // com.bytedance.android.livesdk.lifecycle.ILifeCycleAware
    public void onShowLiveEnd(String r5) {
        Intrinsics.checkNotNullParameter(r5, "roomId");
        Iterator r0 = new ArrayList(this.mObservers).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ILiveLifecycleObserver) r0.next()).onLifecycleEvent(ILiveLifecycleObserver.Event.ShowLiveEnd, r5, MapsKt.emptyMap());
        goto L4
    }

    public void removeObserver(ILiveLifecycleObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        checkMainThread();
        removeInCollection(this.mObservers, r2);
    }

    private final <T> int removeInCollection(Collection<T> r3, T r4) {
        Iterator<T> r5 = r3.iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r5.next() != r4) goto L4;
        r5.remove();
        r0 = r0 + 1;
        goto L4
    L8:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.lifecycle.ILifeCycleAware
    public void onEndSession(String r4, HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Iterator r0 = new ArrayList(this.mObservers).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ILiveLifecycleObserver) r0.next()).onLifecycleEvent(ILiveLifecycleObserver.Event.EndSession, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.lifecycle.ILifeCycleAware
    public void onEnterLiveRoomSuccess(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        Intrinsics.checkNotNullParameter(r6, "roomId");
        Iterator r0 = new ArrayList(this.mObservers).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ILiveLifecycleObserver) r0.next()).onLifecycleEvent(ILiveLifecycleObserver.Event.EnterLiveRoomSuccess, r6, MapsKt.mapOf(TuplesKt.to("roomOwnerId", r5)));
        goto L4
    }
}
