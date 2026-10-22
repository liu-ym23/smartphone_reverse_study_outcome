package com.facebook.battery.serializer.core;

import com.facebook.battery.metrics.core.SystemMetrics;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public abstract class SystemMetricsSerializer<T extends SystemMetrics<T>> {
    private static final short MAGIC = 251;
    private static final short VERSION = 1;

    public SystemMetricsSerializer() {
    }

    public abstract boolean deserializeContents(T r100, DataInput r101) throws IOException;

    public abstract void serializeContents(T r100, DataOutput r101) throws IOException;

    public final int getTag() {
        return getClass().toString().hashCode();
    }

    public final boolean deserialize(T r100, DataInput r101) throws IOException {
        if (r101.readShort() == 251) goto L5;
        return false;
    L5:
        if (r101.readShort() == 1) goto L7;
        return false;
    L7:
        if (r101.readInt() == getTag()) goto L10;
        return false;
    L10:
        return deserializeContents(r100, r101);
    }

    public final void serialize(T r100, DataOutput r101) throws IOException {
        r101.writeShort(251);
        r101.writeShort(1);
        r101.writeInt(getTag());
        serializeContents(r100, r101);
    }
}
