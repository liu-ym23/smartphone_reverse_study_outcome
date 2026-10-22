package com.bytedance.timon.foundation.impl;

import com.bytedance.timon.foundation.interfaces.IEventMonitor;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timon/foundation/impl/EventMonitorDowngradeImpl;", "Lcom/bytedance/timon/foundation/interfaces/IEventMonitor;", "<init>", "()V", "timonfoundation_release"}, k = 1, mv = {1, 4, 0})
public final class EventMonitorDowngradeImpl implements IEventMonitor {
    public EventMonitorDowngradeImpl() {
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorStatusAndEvent(String r100, int r101, JSONObject r102, JSONObject r103, JSONObject r104) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public final void monitorStatusRate(String r100, int r101, JSONObject r102) {
    }
}
