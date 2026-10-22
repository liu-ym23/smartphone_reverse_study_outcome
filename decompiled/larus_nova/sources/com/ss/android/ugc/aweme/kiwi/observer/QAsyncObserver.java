package com.ss.android.ugc.aweme.kiwi.observer;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.ss.android.ugc.aweme.kiwi.util.QExecutor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/observer/QAsyncObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "<init>", "()V", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public abstract class QAsyncObserver<T> implements Observer<T> {
    public QAsyncObserver() {
    }

    public abstract void a();

    @Override // androidx.lifecycle.Observer
    public final void onChanged(final T r100) {
        QExecutor.f450931c.a().post(new AnonymousClass1(this, r100));
    }
}
