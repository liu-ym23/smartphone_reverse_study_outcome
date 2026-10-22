package vn6;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static void a(Object r100) {
        EventBus.getDefault().post(r100);
    }

    public static void b(Object r100) {
        if (EventBus.getDefault().isRegistered(r100) == true) goto L14;
        EventBus.getDefault().register(r100);     // Catch: EventBusException -> L6
        return;
    L6:
        e = move-exception;
        if (HostServiceUtilsKt.u().c() == false) goto L10;
        new Handler(Looper.getMainLooper()).post(new a(e));
        return;
    L10:
        HostServiceUtilsKt.c().log(6, "EventBus", "register error:" + e);
        return;
    }

    public static void c(Object r100) {
        if (EventBus.getDefault().isRegistered(r100) == false) goto L6;
        EventBus.getDefault().unregister(r100);
        return;
    }
}
