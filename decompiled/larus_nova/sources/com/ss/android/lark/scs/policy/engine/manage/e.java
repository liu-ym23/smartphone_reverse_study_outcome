package com.ss.android.lark.scs.policy.engine.manage;

import com.bytedance.lark.policy.event.Event;
import com.bytedance.lark.policy.event.EventManager;
import com.bytedance.lark.policy.utils.Logger;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements o3c.a.InterfaceC7009a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f439855a = null;

    static {
        f439855a = new e();
    }

    public e() {
    }

    @Override // o3c.a.InterfaceC7009a
    public final void a(int r100) {
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("UserLifecycleObserver", "init registerLoginStatusListener: " + r100);
        if (r100 != 0) goto L5;
        ke6.d.f503032a.getClass();
        boolean r102 = com.bytedance.lark.policy.manager.d.f253827a;
        Logger.c("UserManager", "logout()");
        com.bytedance.lark.policy.manager.d.f253828b = "-404";
        com.bytedance.lark.policy.manager.d.f253829c = "-404";
        com.bytedance.lark.policy.manager.d.f253827a = false;
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r103 = EventManager.f253801a;
        EventManager.a(Event.EVENT_LOGOUT);
        int r104 = c.f439851a;
        Intrinsics.checkNotNullParameter("USER_ID", "key");
        ConcurrentHashMap<String, Object> r105 = re6.b.f537431a;
        Intrinsics.checkNotNullParameter("USER_ID", "name");
        ConcurrentHashMap<String, Object> r106 = re6.b.f537431a;
        monitor-enter(r106);
        r106.remove("USER_ID");     // Catch: Throwable -> L16
        monitor-exit(r106);
        ScsLogger.d("UserLifecycleObserver", "init registerLoginStatusListener: " + r100);
        return;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r100 != 1) goto L23;
        int r107 = g.f439856a;
        int r108 = d.f439852c;
        User r109 = d.a.a().a().getForegroundUser();
        if (r109 == null) goto L21;
        ke6.d r110 = ke6.d.f503032a;
        String r111 = r109.userId;
        String r112 = r109.getTenantId();
        r110.getClass();
        ke6.d.g(r111, r112);
        int r113 = c.f439851a;
        c.a(r109.userId);
        ScsLogger.d("UserLifecycleObserver", "init registerLoginStatusListener NORMAL");
        return;
    L21:
        return;
    }
}
