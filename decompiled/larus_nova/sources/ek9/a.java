package ek9;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f472951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f472952b = null;

    static {
        f472951a = new AtomicBoolean(false);
        f472952b = new AtomicBoolean(false);
    }

    public static void a() {
        AtomicBoolean r100 = f472951a;
        boolean r101 = r100.get();
        FLogger.f375446a.i("LuckyDogModel", "write isNewUserAcquisition from " + r101 + " to true");
        r100.set(true);
    }

    public static void b() {
        AtomicBoolean r100 = f472952b;
        boolean r101 = r100.get();
        FLogger.f375446a.i("LuckyDogModel", "write isUserReactivation from " + r101 + " to true");
        r100.set(true);
    }
}
