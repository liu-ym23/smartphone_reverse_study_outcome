package com.ss.android.lark.message.lynxcard.monitor;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.SetUniversalCardRenderStatusRequest;
import com.bytedance.lark.pb.openplatform.v1.SetUniversalCardRenderStatusResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class LynxCardMonitorServiceImpl implements com.ss.android.lark.message.lynxcard.monitor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f432221a;

    public static final class a {
    }

    static {
    }

    @Inject
    public LynxCardMonitorServiceImpl(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f432221a = r100;
    }

    @Override // com.ss.android.lark.message.lynxcard.monitor.a
    public final void z6(String r110, String r111) {
        SetUniversalCardRenderStatusRequest.Builder r100 = new SetUniversalCardRenderStatusRequest.Builder().biz_id(r110).card_id(r111);
        l r112 = this.f432221a;
        Intrinsics.checkNotNull(r100);
        t.g(r112.h(new com.bytedance.lark.rustclient.api.d(r100, SetUniversalCardRenderStatusResponse.ADAPTER, Command.SET_UNIVERSAL_CARD_RENDER_STATUS, null, null, null, null, 248)).a(), LynxCardMonitorServiceImpl$syncRenderStatusToSdk$d$1.INSTANCE, LynxCardMonitorServiceImpl$syncRenderStatusToSdk$d$2.INSTANCE);
    }
}
