package com.ss.android.lark.active.user.impl;

import com.ss.android.lark.active.message.impl.MultiTenantMsgSwitchImpl$shutDownMultiTenantMsgByPush$1;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.suite.lark.component.protocol.Biz;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class MultiUserOnlineFgRepository implements nua.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f408614f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<nua.c.b> f408615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f408616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f408617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f408618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f408619e;

    public static final class a {
    }

    static {
    }

    @Override // nua.c
    public final synchronized boolean b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f408616b == false) goto L8;
        if (f() == false) goto L8;
        boolean r100 = true;
    L9:
        monitor-exit(this);
        return r100;
    L8:
        r100 = false;
        goto L9
    }

    public final synchronized boolean f() {
        monitor-enter(this);
        boolean r100 = ((Boolean) this.f408617c.getValue()).booleanValue();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // nua.c
    public final boolean a() {
        return LarkKVStorage.j(Biz.Core, false).getBoolean("multi_tenant_msg_switch", false);
    }

    @Override // com.ss.android.lark.passportc.api.i
    public final boolean c() {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) this.f408618d.getValue()).booleanValue() == true) goto L8;
        return false;
    }

    public final com.ss.android.lark.featuregating.b e() {
        return (com.ss.android.lark.featuregating.b) this.f408619e.getValue();
    }

    @Inject
    public MultiUserOnlineFgRepository() {
        this.f408615a = Collections.synchronizedSet(new LinkedHashSet());
        this.f408616b = true;
        this.f408617c = LazyKt.lazy(new MultiUserOnlineFgRepository$enableMultipleUser$2(this));
        this.f408618d = LazyKt.lazy(new MultiUserOnlineFgRepository$userOnlineRefactorEnable$2(this));
        this.f408619e = LazyKt.lazy(MultiUserOnlineFgRepository$flashFG$2.INSTANCE);
    }

    @Override // nua.c
    public final void d(MultiTenantMsgSwitchImpl$shutDownMultiTenantMsgByPush$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f408615a.add(r100);
    }

    public final void g(boolean r100, boolean r101) {
        Log.i("MultiUserOnlineFgRepository", "updateFeatureAllowedRealtime allowed=" + r100 + " isPermanent=" + r101 + ", enableMultipleUserRealtime=" + b());
        if (b() == false) goto L9;
        if (r100 == true) goto L9;
        this.f408616b = false;
        Log.i("MultiUserOnlineFgRepository", "notifyFeatureClosed");
        Iterator<T> r102 = this.f408615a.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((nua.c.b) r102.next()).a();
    L9:
        if (r101 == false) goto L13;
        com.ss.android.lark.featuregating.b r103 = e();
        r103.getClass();
        Intrinsics.checkNotNullParameter("messenger.multiuser.allow_multiuser", "fgKey");
        com.ss.android.lark.storage.kv.flash.c r104 = r103.f420728a;
        r104.getClass();
        Intrinsics.checkNotNullParameter("messenger.multiuser.allow_multiuser", "key");
        r104.f441038a.putBoolean("messenger.multiuser.allow_multiuser", r100);
        return;
    }
}
