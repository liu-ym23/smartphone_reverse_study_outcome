package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes25.dex */
public final class n1 implements IIMCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f307843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred<Boolean> f307844b;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f307844b.complete(Boolean.FALSE);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Boolean r100) {
        boolean r101 = r100.booleanValue();
        if (r101 == false) goto L8;
        Iterator<T> r102 = this.f307843a.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        com.larus.bmhome.chat.adapter.p0.f297111a.a(r103);
    L8:
        this.f307844b.complete(Boolean.valueOf(r101));
    }

    public n1(List<String> r100, CompletableDeferred<Boolean> r101) {
        this.f307843a = r100;
        this.f307844b = r101;
    }
}
