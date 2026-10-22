package com.bytedance.timon.foundation.impl;

import android.app.Application;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.timon.foundation.interfaces.IEventMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/timon/foundation/impl/EventMonitorImp;", "Lcom/bytedance/timon/foundation/interfaces/IEventMonitor;", "timonfoundation_release"}, k = 1, mv = {1, 4, 0})
public final class EventMonitorImp implements IEventMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f270618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f270619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f270620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f270621d;

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        ((SDKMonitor) this.f270618a.getValue()).monitorDuration(r100, r101, r102);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorStatusRate(String r100, int r101, JSONObject r102) {
        ((SDKMonitor) this.f270618a.getValue()).monitorStatusRate(r100, r101, r102);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        ((SDKMonitor) this.f270618a.getValue()).monitorEvent(r100, r101, r103, r102);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
        ((SDKMonitor) this.f270618a.getValue()).monitorStatusAndDuration(r100, r101, r102, r103);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorStatusAndEvent(String r100, int r101, JSONObject r110, JSONObject r111, JSONObject r112) {
        ((SDKMonitor) this.f270618a.getValue()).monitorStatusAndEvent(r100, r101, r110, r111, r112);
    }

    public EventMonitorImp(final Application r100, final String r101, String r102, final int r103, String r104, long r105) {
        this.f270619b = r102;
        this.f270620c = r104;
        this.f270621d = r105;
        this.f270618a = LazyKt.lazy(new EventMonitorImp$monitorInstance$2(this, r103, r101, r100));
    }
}
