package com.bytedance.awemeopen.apps.framework.framework.eventbus;

import android.os.Handler;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LiveDataBus {
    public static final LiveDataBus c = null;
    public final Handler a;
    public final Lazy b;

    public static final class a {
        @JvmStatic
        public static BusLiveData a(Class r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Map r0 = (Map) LiveDataBus.c.b.getValue();
            Object r1 = r0.get(r2);
            if (r1 != null) goto L6;
            r1 = new BusLiveData(r2);
            r0.put(r2, r1);
        L6:
            return (BusLiveData) r1;
        }

        @JvmStatic
        public static void b(Object r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            LiveDataBus r0 = LiveDataBus.c;
            Class<?> r1 = r3.getClass();
            Map r2 = (Map) r0.b.getValue();
            Object r4 = r2.get(r1);
            if (r4 != null) goto L5;
            r4 = new BusLiveData(r1);
            r2.put(r1, r4);
        L5:
            ((BusLiveData) r4).postValue(r3);
        }
    }

    static {
        c = new LiveDataBus();
    }

    public LiveDataBus() {
        this.a = new Handler();
        this.b = LazyKt.lazy(LiveDataBus$mBusMap$2.INSTANCE);
    }
}
