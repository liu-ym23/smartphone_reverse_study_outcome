package com.ss.android.lark.active.message.impl;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import com.ss.android.lark.passportc.api.ReturnType;
import com.ss.android.lark.passportc.api.d;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.r;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import nua.c;
import yzb.b;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class a implements mua.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGlobalActiveUserManager f408542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f408543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f408544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f408545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f408546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f408547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineDispatcher f408548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f408549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f408550i;

    /* JADX INFO: renamed from: com.ss.android.lark.active.message.impl.a$a, reason: collision with other inner class name */
    public static final class C4739a {
    }

    static {
    }

    public static void a(a r110, List r111, d r112, Function1 r113) {
        r r100 = r.f438480a;
        BuildersKt.launch$default(r110.f408549h, r110.f408547f, null, new MultiTenantMsgSwitchImpl$updateBackgroundActiveUsers$1(r110, r111, r112, r100, r113, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.ss.android.lark.active.message.impl.MultiTenantMsgSwitchImpl$shutDownMultiTenantMsgByPush$1] */
    @Inject
    public a(IGlobalActiveUserManager r100, c r101, b r102, j r103, i r104) {
        Intrinsics.checkNotNullParameter(r100, "activeUserManager");
        Intrinsics.checkNotNullParameter(r101, "multiUserFGService");
        Intrinsics.checkNotNullParameter(r102, "larkUserListService");
        Intrinsics.checkNotNullParameter(r103, "passportGlobalService");
        Intrinsics.checkNotNullParameter(r104, "onlineFG");
        this.f408542a = r100;
        this.f408543b = r101;
        this.f408544c = r102;
        this.f408545d = r103;
        this.f408546e = r104;
        this.f408547f = ExecutorsKt.from(CoreThreadPool.getDefault().getFixedThreadPool());
        CoroutineDispatcher r105 = ExecutorsKt.from(CoreThreadPool.getDefault().getUIExecutor());
        this.f408548g = r105;
        boolean r106 = true;
        this.f408549h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r105));
        this.f408550i = new d(r106, null, ReturnType.Foreground, 46);
        r101.d(new MultiTenantMsgSwitchImpl$shutDownMultiTenantMsgByPush$1(this));
    }
}
