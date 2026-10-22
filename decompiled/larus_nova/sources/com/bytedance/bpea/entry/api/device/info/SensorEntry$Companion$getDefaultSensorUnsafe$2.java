package com.bytedance.bpea.entry.api.device.info;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/hardware/Sensor;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class SensorEntry$Companion$getDefaultSensorUnsafe$2 extends Lambda implements Function0<Sensor> {
    final /* synthetic */ SensorManager $this_getDefaultSensorUnsafe;
    final /* synthetic */ int $type;
    final /* synthetic */ boolean $wakeup;

    public SensorEntry$Companion$getDefaultSensorUnsafe$2(SensorManager r100, int r101, boolean r102) {
        this.$this_getDefaultSensorUnsafe = r100;
        this.$type = r101;
        this.$wakeup = r102;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Sensor invoke() {
        return this.$this_getDefaultSensorUnsafe.getDefaultSensor(this.$type, this.$wakeup);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Sensor invoke() {
        return invoke();
    }
}
