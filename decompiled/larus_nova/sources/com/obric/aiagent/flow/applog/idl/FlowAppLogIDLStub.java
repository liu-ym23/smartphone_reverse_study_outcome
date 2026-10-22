package com.obric.aiagent.flow.applog.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010\f\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0013\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0011\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0011\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0011\u0010\u0018\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\b2\u000e\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J)\u0010\u001b\u001a\u00020\b2\u000e\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J)\u0010\u001e\u001a\u00020\b2\u000e\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u001f\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\t\u0010 \u001a\u00020\bH\u0096\u0001J!\u0010!\u001a\u00020\b2\u000e\u0010\"\u001a\n \u000b*\u0004\u0018\u00010\u00140\u00142\u0006\u0010#\u001a\u00020$H\u0096\u0001J\t\u0010%\u001a\u00020\bH\u0096\u0001J\u0019\u0010&\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010'\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010(\u001a\u00020\b2\u000e\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J7\u0010)\u001a\u00020\b2,\u0010\u001f\u001a(\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010+ \u000b*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010,¨\u0006\u00010*¨\u0006\u0001H\u0096\u0001J\u0019\u0010-\u001a\u00020\b2\u000e\u0010.\u001a\n \u000b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001¨\u0006/"}, d2 = {"Lcom/obric/aiagent/flow/applog/idl/FlowAppLogIDLStub;", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogIDL$Stub;", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "addDataObserver", "", "listener", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogDataObserverIDL;", "kotlin.jvm.PlatformType", "addEventObserver", "iEventObserver", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogEventObserverIDL;", "addSessionHook", DownloadSettingKeys.KEY_HOOK, "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogSessionObserverIDL;", "clearLaunchService", "getDid", "", "getIid", "getSsid", "getUserID", "getUserUniqueID", "onEventV3", "event", "onEventV3Bundle", "param", "Landroid/os/Bundle;", "onEventV3Json", "params", "onPause", "onResume", "activity", "hashCode", "", "onStop", "removeDataObserver", "removeEventObserver", "removeSessionHook", "setHeaderInfo", "", "", "", "setLaunchService", "launchService", "flow-applog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowAppLogIDLStub extends IFlowAppLogIDL.Stub {
    private final /* synthetic */ IFlowAppLogIDL $$delegate_0;

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addDataObserver(IFlowAppLogDataObserverIDL r100) {
        this.$$delegate_0.addDataObserver(r100);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addEventObserver(IFlowAppLogEventObserverIDL r100) {
        this.$$delegate_0.addEventObserver(r100);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addSessionHook(IFlowAppLogSessionObserverIDL r100) {
        this.$$delegate_0.addSessionHook(r100);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void clearLaunchService() {
        this.$$delegate_0.clearLaunchService();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getDid() {
        return this.$$delegate_0.getDid();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getIid() {
        return this.$$delegate_0.getIid();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getSsid() {
        return this.$$delegate_0.getSsid();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserID() {
        return this.$$delegate_0.getUserID();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserUniqueID() {
        return this.$$delegate_0.getUserUniqueID();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3(String r100) {
        this.$$delegate_0.onEventV3(r100);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Bundle(String r100, Bundle r101) {
        this.$$delegate_0.onEventV3Bundle(r100, r101);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Json(String r100, String r101) {
        this.$$delegate_0.onEventV3Json(r100, r101);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onPause() {
        this.$$delegate_0.onPause();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onResume(String r100, int r101) {
        this.$$delegate_0.onResume(r100, r101);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onStop() {
        this.$$delegate_0.onStop();
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeDataObserver(IFlowAppLogDataObserverIDL r100) {
        this.$$delegate_0.removeDataObserver(r100);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeEventObserver(IFlowAppLogEventObserverIDL r100) {
        this.$$delegate_0.removeEventObserver(r100);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeSessionHook(IFlowAppLogSessionObserverIDL r100) {
        this.$$delegate_0.removeSessionHook(r100);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setHeaderInfo(Map r100) {
        this.$$delegate_0.setHeaderInfo(r100);
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setLaunchService(String r100) {
        this.$$delegate_0.setLaunchService(r100);
    }

    public FlowAppLogIDLStub() {
        IFlowAppLogIDL r100 = (IFlowAppLogIDLSPI) ServiceManager.get().getService(IFlowAppLogIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowAppLogIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
