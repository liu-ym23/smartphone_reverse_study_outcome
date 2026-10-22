package com.obric.assistant.applog;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.flow.applog.idl.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/applog/FlowAppLogIDLService;", "Landroid/app/Service;", "<init>", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "onUnbind", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAppLogIDLService extends Service {

    public static final class a {
    }

    static {
    }

    public FlowAppLogIDLService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        FLogger r101 = FLogger.f375446a;
        r101.d("FlowAppLogIDLService", "onBind");
        if (r100 != null) goto L6;
        return null;
    L6:
        IFlowAppLogIDL.Stub r102 = i.a(Reflection.getOrCreateKotlinClass(IFlowAppLogIDL.class));
        r101.d("FlowAppLogIDLService", "getSPIStub result: " + r102);
        return r102;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r100) {
        FLogger.f375446a.e("FlowAppLogIDLService", "onUnbind");
        return true;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        FLogger.f375446a.d("FlowAppLogIDLService", "onStartCommand, intent = " + r100 + ", flags = " + r101 + ", startId = " + r102);
        return 2;
    }
}
