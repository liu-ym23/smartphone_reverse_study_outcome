package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.refactor.DefaultRustSDKDefinition;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.utils.LarkContext;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class o extends DefaultRustSDKDefinition {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<te6.b> f425704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    public x f425705c;

    @Override // com.bytedance.lark.sdk.refactor.DefaultRustSDKDefinition, com.bytedance.lark.sdk.refactor.o
    public final Executor f() {
        com.ss.android.lark.sdk.d r100 = com.ss.android.lark.sdk.i.f439882b;
        if (r100 != null) goto L5;
    L7:
        return null;
    L5:
        if (r100.d() == false) goto L7;
        return CoreThreadPool.getDefault().getScheduleThreadPool();
    }

    @Override // com.bytedance.lark.sdk.refactor.DefaultRustSDKDefinition, com.bytedance.lark.sdk.refactor.o
    public final te6.d h() {
        x r100 = this.f425705c;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("onlineResponseObserverInternal");
        return null;
    L7:
        return r100;
    }

    @Override // com.bytedance.lark.sdk.refactor.DefaultRustSDKDefinition, com.bytedance.lark.sdk.refactor.o
    public final boolean a() {
        return com.larksuite.framework.utils.z.e(LarkContext.getApplication());
    }

    @Override // com.bytedance.lark.sdk.refactor.DefaultRustSDKDefinition, com.bytedance.lark.sdk.refactor.o
    public final Set<te6.b> d() {
        return this.f425704b;
    }

    @Inject
    public o(Set<te6.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "observers");
        this.f425704b = r100;
    }

    @Override // com.bytedance.lark.sdk.refactor.DefaultRustSDKDefinition, com.bytedance.lark.sdk.refactor.o
    public final boolean e(int r100) {
        if (r100 != Command.MAKE_USER_ONLINE.getValue()) goto L5;
    L18:
        return true;
    L5:
        if (r100 == Command.MAKE_USER_OFFLINE.getValue()) goto L18;
        if (r100 == Command.SET_DEVICE.getValue()) goto L18;
        if (r100 == Command.GET_INIT_SETTINGS.getValue()) goto L18;
        if (r100 == Command.MAKE_USER_ONLINE_V2.getValue()) goto L18;
        if (r100 == Command.MAKE_USER_OFFLINE_V2.getValue()) goto L18;
        if (r100 == Command.SWITCH_USER_STATE.getValue()) goto L18;
        return false;
    }
}
