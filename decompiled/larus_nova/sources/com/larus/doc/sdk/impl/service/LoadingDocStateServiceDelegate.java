package com.larus.doc.sdk.impl.service;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n39.k;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u0017\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/doc/sdk/impl/service/LoadingDocStateServiceDelegate;", "Lcom/larus/doc/sdk/api/ILoadingDocStateService;", "<init>", "()V", "getRealImpl", "id", "", "loadingDocServices", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addLoadingDocService", "", "loadingDocService", "removeLoadingDocService", "onUpdateState", "state", "", "(Ljava/lang/Integer;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingDocStateServiceDelegate implements k {
    private CopyOnWriteArrayList<k> loadingDocServices;

    @Override // com.larus.office.base.service.a
    public Function0<String> getIdGetter() {
        return null;
    }

    public LoadingDocStateServiceDelegate() {
        this.loadingDocServices = new CopyOnWriteArrayList();
    }

    public final void addLoadingDocService(k r100) {
        this.loadingDocServices.add(r100);
    }

    /* JADX INFO: renamed from: getRealImpl, reason: collision with other method in class */
    public k m8552getRealImpl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        CopyOnWriteArrayList<k> r101 = this.loadingDocServices;
        ListIterator<k> r102 = r101.listIterator(r101.size());
    L3:
        String r103 = null;
        if (r102.hasPrevious() == false) goto L12;
        k r104 = r102.previous();
        Function0<String> r105 = r104.getIdGetter();
        if (r105 == null) goto L9;
        r103 = r105.invoke();
    L9:
        if (Intrinsics.areEqual(r103, r100) == false) goto L3;
        r103 = r104;
    L12:
        return (k) r103;
    }

    @Override // n39.k
    public void onUpdateState(Integer r100) {
        Iterator<T> r101 = this.loadingDocServices.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((k) r101.next()).onUpdateState(r100);
        goto L4
    }

    public final void removeLoadingDocService(k r100) {
        this.loadingDocServices.remove(r100);
    }

    public /* bridge */ /* synthetic */ Object getRealImpl(String r100) {
        return m8552getRealImpl(r100);
    }
}
