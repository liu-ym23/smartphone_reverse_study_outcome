package com.ss.android.lark.flow.notification.online.process;

import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Notification;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class d extends c0c.c implements zsb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f423759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<ctb.a> f423760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f423761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CoroutineScope f423762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LruCache<String, Boolean> f423763f;

    public static final class a {
    }

    static {
    }

    @Override // c0c.c
    public final void c() {
        thb.a.b("FlowNotificationPushManager", MapMonitorConst.EVENT_DESTROY);
        this.f423761d.dispose();
        this.f423761d.clear();
        CoroutineScope r100 = this.f423762e;
        if (r100 == null) goto L5;
        CoroutineScopeKt.cancel$default(r100, null, 1, null);
    L5:
        this.f423762e = null;
    }

    @Override // c0c.c
    public final void k() {
        thb.a.b("FlowNotificationPushManager", "registerNotificationPush, userId = " + this.f21993a.getUser().userId);
        this.f423761d.add(t.g(this.f423759b.i(Command.PUSH_NOTIFICATION, Notification.ADAPTER), new FlowNotificationPushManager$registerNotificationPush$1(this), FlowNotificationPushManager$registerNotificationPush$2.INSTANCE));
        this.f423762e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @Override // zsb.a
    public final void n9(ctb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f423760c.remove(r100);
    }

    @Override // zsb.a
    public final void t4(ctb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f423760c.add(r100);
    }

    @Inject
    public d(m r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        super(r100);
        this.f423759b = r101;
        this.f423760c = new CopyOnWriteArrayList();
        this.f423761d = new CompositeDisposable();
        this.f423763f = new LruCache(100);
        s.a(this);
    }
}
