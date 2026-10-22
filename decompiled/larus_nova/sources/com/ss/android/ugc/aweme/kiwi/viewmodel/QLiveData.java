package com.ss.android.ugc.aweme.kiwi.viewmodel;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.ss.android.ugc.aweme.kiwi.Q;
import com.ss.android.ugc.aweme.kiwi.util.QExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "Companion", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public class QLiveData<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f450945c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Thread f450946d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f450947e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QArchLiveData<T> f450948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f450949b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData$Companion;", "", "<init>", "()V", "kiwi_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        f450947e = new Companion(0);
        f450945c = new Object();
        f450946d = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
    }

    public T a() {
        T r100 = (T) this.f450949b;
        if (r100 != f450945c) goto L7;
        return null;
    L7:
        return r100;
    }

    public QLiveData() {
        this.f450948a = new QArchLiveData();
        this.f450949b = f450945c;
    }

    public void d(Observer<T> r100) {
        this.f450948a.observeForever(r100);
    }

    public void e(final T r100) {
        QExecutor.f450931c.a().post(new QLiveData$postValue$1(this, r100));
    }

    public void f(Observer<T> r100) {
        this.f450948a.removeObserver(r100);
    }

    public void g(final T r100) {
        Q.f450885b.getClass();
        if (Q.f450884a.equals("local_test") == true) goto L5;
    L9:
        this.f450949b = r100;
        QExecutor.f450931c.a().post(new QLiveData$setValue$1(this, r100));
        return;
    L5:
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), f450946d)) == false) goto L9;
        throw new IllegalStateException("Cannot invoke  setValue  on a background thread");
    }

    public void b(LifecycleOwner r100, Observer<T> r101) {
        this.f450948a.observe(r100, r101);
    }

    public void c(LifecycleOwner r100, Observer<T> r101, boolean r102) {
        this.f450948a.observe(r100, r101, r102);
    }
}
