package com.bytedance.ies.commerce.common_utils.event;

import com.bytedance.ies.commerce.common_utils.event.api.ISubscriber;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class EventCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f248346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f248347b = null;

    static {
        f248346a = LazyKt.lazy(EventCenter$eventSubscribers$2.INSTANCE);
        f248347b = LazyKt.lazy(EventCenter$eventSubscribersWithSessionId$2.INSTANCE);
    }

    public static void a(String r100, String r101, JSONObject r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (a.a(r100) == null) goto L23;
        if (r101 != null) goto L8;
        return;
    L8:
        if (a.a(r101) == null) goto L24;
        ISubscriber r103 = (ISubscriber) ((ConcurrentHashMap) f248346a.getValue()).get(r101);
        if (r103 == null) goto L13;
        r103.onEvent(r100, r101, r102);
    L13:
        ConcurrentHashMap r104 = (ConcurrentHashMap) ((ConcurrentHashMap) f248347b.getValue()).get(r100);
        if (r104 == null) goto L21;
        ISubscriber r105 = (ISubscriber) r104.get(r101);
        if (r105 == null) goto L22;
        r105.onEvent(r100, r101, r102);
        return;
    L22:
        return;
    L21:
        return;
    L24:
        return;
    }
}
