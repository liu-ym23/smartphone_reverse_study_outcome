package com.obric.aiagent.runtime;

import android.os.Bundle;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.applog.api.IApplog;
import com.obric.aiagent.platform.depend.ITraceDepend;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016JU\u0010\u0013\u001a\u00020\u00052K\u0010\u0014\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00050\u0015H\u0016J\u001c\u0010\u001b\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001cH\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/runtime/TraceDependImpl;", "Lcom/obric/aiagent/platform/depend/ITraceDepend;", "<init>", "()V", "report", "", "event", "", "params", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "enableETVerify", "getSessionId", "getDeviceId", "getUserID", "getInstallId", "getSsid", "getUUID", "awaitTraceId", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", a.KEY_DID, WsConstants.KEY_INSTALL_ID, "ssid", "addCommonParams", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TraceDependImpl implements ITraceDepend {
    public TraceDependImpl() {
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public final void a(Bundle r100) {
        Intrinsics.checkNotNullParameter("ipc_anomaly", "event");
        Intrinsics.checkNotNullParameter(r100, "bundleParams");
        IApplog.f287053a.b("ipc_anomaly", r100);
    }
}
