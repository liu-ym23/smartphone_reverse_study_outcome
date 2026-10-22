package com.larus.doc.sdk.impl.service;

import com.larus.doc.sdk.api.model.DocMode;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n39.g;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/sdk/impl/service/DocModeServiceDelegate;", "Lcom/larus/doc/sdk/api/IDocModeService;", "<init>", "()V", "getRealImpl", "id", "", "docModeServices", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getDocModeServices", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "docModeServices$delegate", "Lkotlin/Lazy;", "onDocModeChanged", "", "docMode", "Lcom/larus/doc/sdk/api/model/DocMode;", "addDocModeService", "docModeService", "removeDocModeService", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocModeServiceDelegate implements g {
    private final Lazy docModeServices$delegate;

    public static /* synthetic */ CopyOnWriteArrayList g() {
        return docModeServices_delegate$lambda$1();
    }

    @Override // com.larus.office.base.service.a
    public Function0<String> getIdGetter() {
        return null;
    }

    private static final CopyOnWriteArrayList docModeServices_delegate$lambda$1() {
        return new CopyOnWriteArrayList();
    }

    private final CopyOnWriteArrayList<g> getDocModeServices() {
        return (CopyOnWriteArrayList) this.docModeServices$delegate.getValue();
    }

    public DocModeServiceDelegate() {
        this.docModeServices$delegate = LazyKt.lazy(new a());
    }

    public final void addDocModeService(g r100) {
        if (r100 == null) goto L5;
        getDocModeServices().add(r100);
        return;
    }

    /* JADX INFO: renamed from: getRealImpl, reason: collision with other method in class */
    public g m8551getRealImpl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        CopyOnWriteArrayList<g> r101 = getDocModeServices();
        ListIterator<g> r102 = r101.listIterator(r101.size());
    L3:
        String r103 = null;
        if (r102.hasPrevious() == false) goto L12;
        g r104 = r102.previous();
        Function0<String> r105 = r104.getIdGetter();
        if (r105 == null) goto L9;
        r103 = r105.invoke();
    L9:
        if (Intrinsics.areEqual(r103, r100) == false) goto L3;
        r103 = r104;
    L12:
        return (g) r103;
    }

    @Override // n39.g
    public void onDocModeChanged(DocMode r100) {
        Intrinsics.checkNotNullParameter(r100, "docMode");
        Iterator<T> r101 = getDocModeServices().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((g) r101.next()).onDocModeChanged(r100);
        goto L4
    }

    public final void removeDocModeService(g r100) {
        if (r100 == null) goto L5;
        getDocModeServices().remove(r100);
        return;
    }

    public /* bridge */ /* synthetic */ Object getRealImpl(String r100) {
        return m8551getRealImpl(r100);
    }
}
