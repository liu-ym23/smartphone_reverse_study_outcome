package com.obric.assistant.network.impl;

import com.obric.assistant.network.api.INetworkInterceptorService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/network/impl/NetworkInterceptorServiceImpl;", "Lcom/obric/assistant/network/api/INetworkInterceptorService;", "<init>", "()V", "obricStatusChangedObservers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/assistant/network/api/OnObricStatusChangedObserver;", "registerOnObricStatusChanged", "", "observer", "unregisterOnObricStatusChanged", "notifyObricStatusChanged", "isDeactive", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkInterceptorServiceImpl implements INetworkInterceptorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<uea.a> f390311a;

    public NetworkInterceptorServiceImpl() {
        this.f390311a = new CopyOnWriteArraySet();
    }

    @Override // com.obric.assistant.network.api.INetworkInterceptorService
    public final void a(boolean r100) {
        CopyOnWriteArraySet<uea.a> r101 = this.f390311a;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((uea.a) r102.next()).a(r100);
        goto L6
    L10:
        return;
    }

    @Override // com.obric.assistant.network.api.INetworkInterceptorService
    public final void b(uea.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f390311a.add(r100);
    }
}
