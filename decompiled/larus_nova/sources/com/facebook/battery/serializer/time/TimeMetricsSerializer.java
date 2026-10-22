package com.facebook.battery.serializer.time;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.time.TimeMetrics;
import com.facebook.battery.serializer.core.SystemMetricsSerializer;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class TimeMetricsSerializer extends SystemMetricsSerializer<TimeMetrics> {
    public TimeMetricsSerializer() {
    }

    public boolean deserializeContents(TimeMetrics r100, DataInput r101) throws IOException {
        r100.realtimeMs = r101.readLong();
        r100.uptimeMs = r101.readLong();
        return true;
    }

    public void serializeContents(TimeMetrics r100, DataOutput r101) throws IOException {
        r101.writeLong(r100.realtimeMs);
        r101.writeLong(r100.uptimeMs);
    }

    @Override // com.facebook.battery.serializer.core.SystemMetricsSerializer
    public /* bridge */ /* synthetic */ boolean deserializeContents(SystemMetrics r100, DataInput r101) throws IOException {
        return deserializeContents((TimeMetrics) r100, r101);
    }

    @Override // com.facebook.battery.serializer.core.SystemMetricsSerializer
    public /* bridge */ /* synthetic */ void serializeContents(SystemMetrics r100, DataOutput r101) throws IOException {
        serializeContents((TimeMetrics) r100, r101);
    }
}
