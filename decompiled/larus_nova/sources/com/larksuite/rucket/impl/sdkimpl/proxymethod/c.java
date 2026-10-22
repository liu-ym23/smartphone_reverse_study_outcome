package com.larksuite.rucket.impl.sdkimpl.proxymethod;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.core.proxymethod.BaseProxyMethod;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.compat.CallbackCompatRucketJob;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends BaseProxyMethod<SdkPush> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f286073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f286074e;

    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<SdkPush> b() {
        return SdkPush.class;
    }

    public c(l r100, Method r101) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        super(r101);
        this.f286073d = r100;
        this.f286074e = c().value();
    }

    @Override // com.larksuite.rucket.core.proxymethod.b
    public final void a(IGetDataCallback<?> r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "args");
        if ((r100 instanceof CallbackCompatRucketJob) == false) goto L7;
        new e38.b(Command.fromValue(this.f286074e), e(), this.f286073d, (CallbackCompatRucketJob) r100);
        return;
    L7:
        throw new BaseProxyMethod.GenerateProxyMethodError("Arguments Error! Callback should be subclass of CallbackCompactRucketJob");
    }
}
