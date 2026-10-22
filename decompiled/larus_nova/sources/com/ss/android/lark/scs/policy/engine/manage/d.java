package com.ss.android.lark.scs.policy.engine.manage;

import android.os.Looper;
import com.bytedance.lark.policy.event.EventManager;
import com.bytedance.lark.policy.model.p;
import com.bytedance.lark.policy.observer.InnerObserver;
import com.bytedance.lark.policy.utils.Logger;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.scs.policy.engine.manage.model.DeviceOSType;
import com.ss.android.lark.scs.policy.engine.manage.model.DeviceTerminalType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.EntryPointAccessors;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f439852c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f439853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public o3c.a f439854b;

    public static final class a {
        public static d a() {
            return ((b) EntryPointAccessors.fromApplication(LarkContext.getApplication(), b.class)).f();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/scs/policy/engine/manage/PolicyEngineManageModule$PolicyEngineManageModuleEntryPoint;", "", "getPolicyEngineManageModule", "Lcom/ss/android/lark/scs/policy/engine/manage/PolicyEngineManageModule;", "policy-engine-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        d f();
    }

    static {
    }

    public final o3c.a a() {
        o3c.a r100 = this.f439854b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
        return null;
    }

    public final void b() {
        if (this.f439853a.getAndSet(true) == false) goto L6;
        n3c.b.f517015a.i("PolicyEngineManage", "init skip");
        return;
    L6:
        n3c.b r100 = n3c.b.f517015a;
        r100.i("PolicyEngineManage", "init start");
        r100.i("PolicyEngineManage", "buildPolicyEngineConfig");
        p r101 = new p(new PolicyEngineManageModule$buildPolicyEngineConfig$1(this));
        ke6.d r102 = ke6.d.f503032a;
        Intrinsics.checkNotNullParameter(r101, "config");
        if (ke6.d.f503033b == true) goto L10;
        ke6.d.f503034c = r101;
        int r103 = Logger.f253883a;
        String r104 = "policy engine init start : isInit=" + ke6.d.f503033b;
        Intrinsics.checkNotNullParameter("PolicyEngine", "eventName");
        Logger.a(1, "PolicyEngine", r104);
        ke6.c r105 = new ke6.c();
        rd6.b r106 = rd6.b.f537280a;
        Intrinsics.checkNotNullParameter(r105, "proxy");
        rd6.b.f537281b = r105;
        ke6.d.f503032a.getClass();
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r107 = EventManager.f253801a;
        InnerObserver r108 = InnerObserver.f253875a;
        Intrinsics.checkNotNullParameter(r108, "eventObserver");
        EventManager.f253802b.add(r108);
        com.bytedance.lark.policy.observer.a r109 = com.bytedance.lark.policy.observer.a.f253876a;
        Intrinsics.checkNotNullParameter(r109, "eventObserver");
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r110 = EventManager.f253801a;
        r110.add(r109);
        com.bytedance.lark.policy.observer.b r111 = com.bytedance.lark.policy.observer.b.f253879a;
        Intrinsics.checkNotNullParameter(r111, "eventObserver");
        r110.add(r111);
        com.bytedance.lark.policy.observer.c r112 = com.bytedance.lark.policy.observer.c.f253881a;
        Intrinsics.checkNotNullParameter(r112, "eventObserver");
        r110.add(r112);
        ke6.a r113 = ke6.b.f503030a;
        ke6.a r114 = new ke6.a(Looper.getMainLooper());
        ke6.b.f503030a = r114;
        r114.sendEmptyMessageDelayed(100, ke6.b.f503031b);
        ke6.d.f503033b = true;
        String r115 = "policy engine init end : isInit=" + ke6.d.f503033b;
        Intrinsics.checkNotNullParameter("PolicyEngine", "eventName");
        Logger.a(1, "PolicyEngine", r115);
    L10:
        int r116 = c.f439851a;
        ke6.d.h("DEVICE_OS", Integer.valueOf(DeviceOSType.ANDROID.getCode()));
        ke6.d.h("DEVICE_TERMINAL", Integer.valueOf(DeviceTerminalType.ANDROID.getCode()));
        int r117 = g.f439856a;
        User r118 = a.a().a().getForegroundUser();
        if (r118 == null) goto L13;
        ke6.d r119 = ke6.d.f503032a;
        String r120 = r118.userId;
        String r121 = r118.getTenantId();
        r119.getClass();
        ke6.d.g(r120, r121);
        c.a(r118.userId);
        int r122 = ScsLogger.f440428a;
        ScsLogger.d("UserLifecycleObserver", "init getForegroundUser: " + r118.userId);
    L13:
        o3c.a r123 = a.a().a();
        e r124 = e.f439855a;
        r123.b();
        a.a().a().a(new f());
        ScsLogger.d("UserLifecycleObserver", "init end");
        boolean r125 = com.ss.android.lark.scs.policy.engine.manage.b.f439850a;
        AppLifecycle.a.f408803a.c(com.ss.android.lark.scs.policy.engine.manage.a.f439849a);
        r100.i("PolicyEngineManage", "init end");
    }

    @Inject
    public d() {
        this.f439853a = new AtomicBoolean(false);
    }
}
