package com.ss.android.ugc.route_monitor.impl.route_out;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/AppLifecycleListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onAppForeground", "onAppBackground", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class AppLifecycleListener implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject<Boolean> f454592a;

    public static final class a {
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onAppBackground() {
        this.f454592a.onNext(Boolean.TRUE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onAppForeground() {
        this.f454592a.onNext(Boolean.FALSE);
    }

    private AppLifecycleListener() {
        this.f454592a = PublishSubject.create();
    }
}
