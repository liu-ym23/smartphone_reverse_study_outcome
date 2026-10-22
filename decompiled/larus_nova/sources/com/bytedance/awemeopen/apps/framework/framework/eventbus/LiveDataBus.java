package com.bytedance.awemeopen.apps.framework.framework.eventbus;

import android.os.Handler;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class LiveDataBus {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LiveDataBus f196946c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f196947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f196948b;

    public static final class a {
        @JvmStatic
        public static BusLiveData a(Class r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Map r101 = (Map) LiveDataBus.f196946c.f196948b.getValue();
            Object r102 = r101.get(r100);
            if (r102 != null) goto L6;
            r102 = new BusLiveData(r100);
            r101.put(r100, r102);
        L6:
            return (BusLiveData) r102;
        }

        @JvmStatic
        public static void b(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            LiveDataBus r101 = LiveDataBus.f196946c;
            Class<?> r102 = r100.getClass();
            Map r103 = (Map) r101.f196948b.getValue();
            Object r104 = r103.get(r102);
            if (r104 != null) goto L5;
            r104 = new BusLiveData(r102);
            r103.put(r102, r104);
        L5:
            ((BusLiveData) r104).postValue(r100);
        }
    }

    static {
        f196946c = new LiveDataBus();
    }

    public LiveDataBus() {
        this.f196947a = new Handler();
        this.f196948b = LazyKt.lazy(LiveDataBus$mBusMap$2.INSTANCE);
    }
}
