package com.bytedance.helios.sdk;

import android.app.Application;
import com.bytedance.helios.api.HeliosService;
import gz5.y;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ApiMonitorService implements HeliosService {
    private final e mDetectionManager;

    @Override // fz5.a
    public void init(Application r100, Map<String, Object> r101) {
    }

    @Override // gz5.a.InterfaceC6085a
    public void onNewSettings(y r100) {
    }

    @Override // fz5.a
    public /* bridge */ /* synthetic */ void setAppLog(jz5.a r100) {
    }

    @Override // fz5.a
    public /* bridge */ /* synthetic */ void setEventMonitor(jz5.c r100) {
    }

    @Override // fz5.a
    public /* bridge */ /* synthetic */ void setExceptionMonitor(jz5.d r100) {
    }

    @Override // fz5.a
    public /* bridge */ /* synthetic */ void setLogger(jz5.e r100) {
    }

    @Override // fz5.a
    public /* bridge */ /* synthetic */ void setRuleEngine(jz5.f r100) {
    }

    @Override // fz5.a
    public /* bridge */ /* synthetic */ void setStore(jz5.g r100) {
    }

    public void stop() {
    }

    @Override // com.bytedance.helios.api.HeliosService
    public void start() {
        this.mDetectionManager.getClass();
    }

    public ApiMonitorService() {
        this.mDetectionManager = e.f245558b;
    }
}
