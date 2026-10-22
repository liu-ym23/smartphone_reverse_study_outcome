package com.obric.assistant.device;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/device/obricDeviceManagerDelegate;", "Lcom/obric/assistant/device/IObricDeviceManager;", "<init>", "()V", "getUuid", "", "onLogin", "", "onLogout", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class obricDeviceManagerDelegate implements IObricDeviceManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final obricDeviceManagerDelegate f389029b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricDeviceManager f389030a;

    static {
        f389029b = new obricDeviceManagerDelegate();
    }

    @Override // com.obric.assistant.device.IObricDeviceManager
    public final void a() {
        this.f389030a.a();
    }

    @Override // com.obric.assistant.device.IObricDeviceManager
    public final void b() {
        this.f389030a.b();
    }

    @Override // com.obric.assistant.device.IObricDeviceManager
    public final String getUuid() {
        return this.f389030a.getUuid();
    }

    private obricDeviceManagerDelegate() {
        this.f389030a = (IObricDeviceManager) ServiceManager.get().getService(IObricDeviceManager.class);
    }
}
