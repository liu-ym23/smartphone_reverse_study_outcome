package com.facebook.battery.serializer.network;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.network.NetworkMetrics;
import com.facebook.battery.serializer.core.SystemMetricsSerializer;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class NetworkMetricsSerializer extends SystemMetricsSerializer<NetworkMetrics> {
    public NetworkMetricsSerializer() {
    }

    public boolean deserializeContents(NetworkMetrics r100, DataInput r101) throws IOException {
        r100.mobileBytesRx = r101.readLong();
        r100.mobileBytesTx = r101.readLong();
        r100.wifiBytesRx = r101.readLong();
        r100.wifiBytesTx = r101.readLong();
        return true;
    }

    public void serializeContents(NetworkMetrics r100, DataOutput r101) throws IOException {
        r101.writeLong(r100.mobileBytesRx);
        r101.writeLong(r100.mobileBytesTx);
        r101.writeLong(r100.wifiBytesRx);
        r101.writeLong(r100.wifiBytesTx);
    }

    @Override // com.facebook.battery.serializer.core.SystemMetricsSerializer
    public /* bridge */ /* synthetic */ boolean deserializeContents(SystemMetrics r100, DataInput r101) throws IOException {
        return deserializeContents((NetworkMetrics) r100, r101);
    }

    @Override // com.facebook.battery.serializer.core.SystemMetricsSerializer
    public /* bridge */ /* synthetic */ void serializeContents(SystemMetrics r100, DataOutput r101) throws IOException {
        serializeContents((NetworkMetrics) r100, r101);
    }
}
