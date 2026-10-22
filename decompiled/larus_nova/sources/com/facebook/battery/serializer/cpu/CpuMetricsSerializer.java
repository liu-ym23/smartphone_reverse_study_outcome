package com.facebook.battery.serializer.cpu;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.cpu.CpuMetrics;
import com.facebook.battery.serializer.core.SystemMetricsSerializer;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class CpuMetricsSerializer extends SystemMetricsSerializer<CpuMetrics> {
    public CpuMetricsSerializer() {
    }

    public boolean deserializeContents(CpuMetrics r100, DataInput r101) throws IOException {
        r100.userTimeS = r101.readDouble();
        r100.systemTimeS = r101.readDouble();
        r100.childUserTimeS = r101.readDouble();
        r100.childSystemTimeS = r101.readDouble();
        return true;
    }

    public void serializeContents(CpuMetrics r100, DataOutput r101) throws IOException {
        r101.writeDouble(r100.userTimeS);
        r101.writeDouble(r100.systemTimeS);
        r101.writeDouble(r100.childUserTimeS);
        r101.writeDouble(r100.childSystemTimeS);
    }

    @Override // com.facebook.battery.serializer.core.SystemMetricsSerializer
    public /* bridge */ /* synthetic */ boolean deserializeContents(SystemMetrics r100, DataInput r101) throws IOException {
        return deserializeContents((CpuMetrics) r100, r101);
    }

    @Override // com.facebook.battery.serializer.core.SystemMetricsSerializer
    public /* bridge */ /* synthetic */ void serializeContents(SystemMetrics r100, DataOutput r101) throws IOException {
        serializeContents((CpuMetrics) r100, r101);
    }
}
