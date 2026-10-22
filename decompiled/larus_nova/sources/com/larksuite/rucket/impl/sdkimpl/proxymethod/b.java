package com.larksuite.rucket.impl.sdkimpl.proxymethod;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.StreamDataSource;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.impl.base.request.BaseCallProxyMethod;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.squareup.wire.Message;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.h;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends BaseCallProxyMethod<SdkCall> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f286072d;

    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<SdkCall> b() {
        return SdkCall.class;
    }

    public b(Method r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        super(r100);
        this.f286072d = ((SdkCall) c()).value();
    }

    @Override // com.larksuite.rucket.impl.base.request.BaseCallProxyMethod
    public final void f(Message r110, IGetDataCallback r111, String r112, g38.c r113, StreamDataSource r114, h r115) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "contextId");
        Intrinsics.checkNotNullParameter(r113, "parser");
        Intrinsics.checkNotNullParameter(r115, "params");
        SdkSender.asynSendRequestNonWrap(Command.fromValue(this.f286072d), r110.encode(), r111, false, r112, r113, r114, r115);
    }
}
