package fq7;

import android.content.Context;
import android.os.PowerManager;
import aq7.c;
import bq7.b;
import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager f478441b;

    public a(Context r100, c r101) {
        super(r100, r101);
        this.f478441b = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    }
}
