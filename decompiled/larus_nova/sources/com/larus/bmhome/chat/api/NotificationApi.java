package com.larus.bmhome.chat.api;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class NotificationApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<NotificationApi> f297173a = null;

    public static final class a {
    }

    public NotificationApi() {
    }

    static {
        f297173a = LazyKt.lazy(new s0());
    }

    public static Object a(List r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$deleteNotification$2(r100, null), r101);
    }

    public static Object d(List r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$requireUnreadNotificationCount$2(r100, r101, null), r102);
    }

    public static Object c(long r110, boolean r111, DowngradeSource r112, boolean r113, Continuation r114) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$requireNotificationList$2(0, r110, 20, r111, r113, r112, null), r114);
    }

    public static Object e(int r100, Long r101, Long r110, Integer r111, Continuation r112) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$updateReadNotification$2(r100, r101, r110, r111, null), r112);
    }

    public static Object b(long r110, boolean r210, long r211, long r212, long r213, String r214, Continuation r215) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NotificationApi$requireAggNotificationList$2(0, r110, 20, r214, r210, r211, r212, r213, null), r215);
    }
}
