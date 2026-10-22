package com.bytedance.locallife.adapter.impl.host.appInfo;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/adapter/impl/host/appInfo/AppContextImpl;", "Landroidx/lifecycle/LifecycleObserver;", "", "appOnResume", "appOnStop", "<init>", "()V", "locallife-adapter-impl_release"}, k = 1, mv = {1, 4, 3})
public final class AppContextImpl implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject<Boolean> f256453a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppContextImpl f256454a;

        public a(AppContextImpl r100) {
            this.f256454a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.f256454a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void appOnResume() {
        this.f256453a.onNext(Boolean.FALSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void appOnStop() {
        this.f256453a.onNext(Boolean.TRUE);
    }

    public AppContextImpl() {
        this.f256453a = PublishSubject.create();
        Handler r100 = new Handler(Looper.getMainLooper());
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        return;
    L5:
        r100.post(new a(this));
    }
}
