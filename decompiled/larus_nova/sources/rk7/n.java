package rk7;

import android.app.Application;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f538362b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<gk7.c> f538363a;

    public static final class a {
    }

    static {
        f538362b = new n();
    }

    public static void a() {
        Application r100 = m.f538347a;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCheckCrossManager", "notifyAllListeners call, 端上没有接入, 不会对端上发任何通知");
    }

    public n() {
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.f538363a = new CopyOnWriteArrayList();
        new AtomicBoolean(false);
    }
}
