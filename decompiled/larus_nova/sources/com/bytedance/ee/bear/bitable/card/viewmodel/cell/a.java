package com.bytedance.ee.bear.bitable.card.viewmodel.cell;

import androidx.lifecycle.MutableLiveData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableLiveData<BitableCardButtonLoadingStatus> f209010a;

    public a(MutableLiveData<BitableCardButtonLoadingStatus> r100) {
        this.f209010a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f209010a.setValue(BitableCardButtonLoadingStatus.Default);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
