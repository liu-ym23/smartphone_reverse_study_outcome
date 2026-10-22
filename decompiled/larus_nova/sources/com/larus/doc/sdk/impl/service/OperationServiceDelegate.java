package com.larus.doc.sdk.impl.service;

import com.larus.doc.sdk.api.SyncedDocInfoSource;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/doc/sdk/impl/service/OperationServiceDelegate;", "Lcom/larus/doc/sdk/api/ICommonOperationService;", "<init>", "()V", "getRealImpl", "id", "", "operationServices", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addOperationService", "", "operationService", "removeOperationService", "notifyDocLoadSuccess", "notifyInterruptConversation", "onSyncedDocInfo", "source", "Lcom/larus/doc/sdk/api/SyncedDocInfoSource;", "getCreateDocResp", "notifyOfflineCreateState", "state", "", "offlineCreateFail", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperationServiceDelegate implements n39.d {
    private CopyOnWriteArrayList<n39.d> operationServices;

    @Override // com.larus.office.base.service.a
    public Function0<String> getIdGetter() {
        return null;
    }

    @Override // n39.d
    public String getCreateDocResp() {
        n39.d r100 = (n39.d) CollectionsKt.lastOrNull(this.operationServices);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCreateDocResp();
    }

    @Override // n39.d
    public void notifyDocLoadSuccess() {
        Iterator<T> r100 = this.operationServices.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((n39.d) r100.next()).notifyDocLoadSuccess();
        goto L4
    }

    @Override // n39.d
    public void notifyInterruptConversation() {
        Iterator<T> r100 = this.operationServices.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((n39.d) r100.next()).notifyInterruptConversation();
        goto L4
    }

    @Override // n39.d
    public void offlineCreateFail() {
        n39.d r100 = (n39.d) CollectionsKt.lastOrNull(this.operationServices);
        if (r100 == null) goto L6;
        r100.offlineCreateFail();
        return;
    }

    public OperationServiceDelegate() {
        this.operationServices = new CopyOnWriteArrayList();
    }

    public final void addOperationService(n39.d r100) {
        this.operationServices.add(r100);
    }

    /* JADX INFO: renamed from: getRealImpl, reason: collision with other method in class */
    public n39.d m8554getRealImpl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        CopyOnWriteArrayList<n39.d> r101 = this.operationServices;
        ListIterator<n39.d> r102 = r101.listIterator(r101.size());
    L3:
        String r103 = null;
        if (r102.hasPrevious() == false) goto L12;
        n39.d r104 = r102.previous();
        Function0<String> r105 = r104.getIdGetter();
        if (r105 == null) goto L9;
        r103 = r105.invoke();
    L9:
        if (Intrinsics.areEqual(r103, r100) == false) goto L3;
        r103 = r104;
    L12:
        return (n39.d) r103;
    }

    @Override // n39.d
    public void notifyOfflineCreateState(int r100) {
        n39.d r101 = (n39.d) CollectionsKt.lastOrNull(this.operationServices);
        if (r101 == null) goto L6;
        r101.notifyOfflineCreateState(r100);
        return;
    }

    @Override // n39.d
    public void onSyncedDocInfo(SyncedDocInfoSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        n39.d r101 = (n39.d) CollectionsKt.lastOrNull(this.operationServices);
        if (r101 == null) goto L6;
        r101.onSyncedDocInfo(r100);
        return;
    }

    public final void removeOperationService(n39.d r100) {
        this.operationServices.remove(r100);
    }

    public /* bridge */ /* synthetic */ Object getRealImpl(String r100) {
        return m8554getRealImpl(r100);
    }
}
