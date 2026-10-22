package com.larksuite.rucket.impl.serverimpl.proxymethod;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lark.sdk.StreamDataSource;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.impl.base.request.BaseCallProxyMethod;
import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.squareup.wire.Message;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.h;
import g38.c;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends BaseCallProxyMethod<ServerCall> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f286076d;

    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<ServerCall> b() {
        return ServerCall.class;
    }

    public b(Method r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        super(r100);
        this.f286076d = ((ServerCall) c()).value();
    }

    @Override // com.larksuite.rucket.impl.base.request.BaseCallProxyMethod
    public final void f(Message r100, IGetDataCallback r101, String r102, c r103, StreamDataSource r104, h r105) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "contextId");
        Intrinsics.checkNotNullParameter(r103, "parser");
        Intrinsics.checkNotNullParameter(r105, "params");
        SdkSender.sendPassThroughRequest(Command.fromValue(this.f286076d), r100, r101, r103, r105);
    }
}
