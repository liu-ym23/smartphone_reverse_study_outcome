package com.facebook.battery.serializer.composite;

import android.util.SparseArray;
import androidx.collection.SimpleArrayMap;
import com.facebook.battery.metrics.composite.CompositeMetrics;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.serializer.core.SystemMetricsSerializer;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class CompositeMetricsSerializer extends SystemMetricsSerializer<CompositeMetrics> {
    private final SparseArray<Class<? extends SystemMetrics<?>>> mDeserializerClasses;
    private final SparseArray<SystemMetricsSerializer<? extends SystemMetrics<?>>> mDeserializers;
    private final SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetricsSerializer<?>> mSerializers;

    public CompositeMetricsSerializer() {
        this.mSerializers = new SimpleArrayMap();
        this.mDeserializers = new SparseArray();
        this.mDeserializerClasses = new SparseArray();
    }

    public <T extends SystemMetrics<T>> CompositeMetricsSerializer addMetricsSerializer(Class<T> r100, SystemMetricsSerializer<T> r101) {
        this.mSerializers.put(r100, r101);
        this.mDeserializers.put(r101.getTag(), r101);
        this.mDeserializerClasses.put(r101.getTag(), r100);
        return this;
    }

    public boolean deserializeContents(CompositeMetrics r100, DataInput r101) throws IOException {
        SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetrics> r102 = r100.getMetrics();
        int r103 = r100.getMetrics().size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.setIsValid(r102.keyAt(r104), false);
        r104 = r104 + 1;
        goto L3
    L5:
        int r105 = r101.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L17;
        int r107 = r101.readInt();
        SystemMetricsSerializer<? extends SystemMetrics<?>> r108 = this.mDeserializers.get(r107);
        Class<? extends SystemMetrics<?>> r109 = this.mDeserializerClasses.get(r107);
        if (r108 == null) goto L16;
        if (r109 == null) goto L16;
        if (r108.deserializeContents(r100.getMetric(r109), r101) == false) goto L14;
        r100.setIsValid(r109, true);
        r106 = r106 + 1;
        goto L7
    L14:
        return false;
    L16:
        return false;
    L17:
        return true;
    }

    public void serializeContents(CompositeMetrics r100, DataOutput r101) throws IOException {
        int r102 = this.mSerializers.size();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L8;
        if (r100.isValid(this.mSerializers.keyAt(r104)) == false) goto L7;
        r105 = r105 + 1;
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        r101.writeInt(r105);
    L9:
        if (r103 >= r102) goto L14;
        Class<? extends SystemMetrics> r106 = this.mSerializers.keyAt(r103);
        if (r100.isValid(r106) == false) goto L13;
        SystemMetricsSerializer<?> r107 = this.mSerializers.valueAt(r103);
        r101.writeInt(r107.getTag());
        r107.serializeContents(r100.getMetric(r106), r101);
    L13:
        r103 = r103 + 1;
        goto L9
    }

    @Override // com.facebook.battery.serializer.core.SystemMetricsSerializer
    public /* bridge */ /* synthetic */ boolean deserializeContents(SystemMetrics r100, DataInput r101) throws IOException {
        return deserializeContents((CompositeMetrics) r100, r101);
    }

    @Override // com.facebook.battery.serializer.core.SystemMetricsSerializer
    public /* bridge */ /* synthetic */ void serializeContents(SystemMetrics r100, DataOutput r101) throws IOException {
        serializeContents((CompositeMetrics) r100, r101);
    }
}
