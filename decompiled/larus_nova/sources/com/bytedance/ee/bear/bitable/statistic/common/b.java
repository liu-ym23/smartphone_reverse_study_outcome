package com.bytedance.ee.bear.bitable.statistic.common;

import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Debug;
import com.bytedance.ee.bear.bitable.statistic.h;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.inner.BitableFpsTracer;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f215614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f215615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Serializable> f215616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Serializable> f215617d;

    public abstract boolean b();

    public boolean c() {
        return this instanceof com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.c;
    }

    public abstract String e();

    public abstract String f();

    public b() {
        HashMap<String, Serializable> r100 = new HashMap();
        r100.put("is_on_demand", Boolean.FALSE);
        this.f215616c = r100;
        HashMap<String, Serializable> r101 = new HashMap();
        r101.put("attach_table_count", 0);
        r101.put("total_attach_table_count", 0);
        this.f215617d = r101;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.h
    public final void a(i r100, BitableFpsTracer r101, double r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "agent");
        Intrinsics.checkNotNullParameter(r101, "trace");
        if (c() == false) goto L6;
        this.f215615b += r102 * r103;
        this.f215614a += r103;
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.h
    public final boolean d(i r110, BitableFpsTracer r111, HashMap r112, HashMap r113, HashMap r210, boolean r211, com.bytedance.ee.bear.bitable.statistic.a r212) {
        Intrinsics.checkNotNullParameter(r110, "agent");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "dropFrames");
        Intrinsics.checkNotNullParameter(r113, "dropStateRatio");
        Intrinsics.checkNotNullParameter(r210, "dropDurRatio");
        Intrinsics.checkNotNullParameter(r212, "eventContext");
        if (((Boolean) BitableStatisticConstant$Debug.f215589b.getValue()).booleanValue() == true) goto L5;
        if (r211 == true) goto L5;
    L7:
        if (r112.isEmpty() == false) goto L10;
        return false;
    L10:
        if (b() == false) goto L13;
        if (r211 == true) goto L13;
        return false;
    L13:
        Float r100 = (Float) r210.get("hitch_dur_ratio");
        if (r100 == null) goto L16;
        float r101 = r100.floatValue();
    L17:
        Map<String, ? extends Serializable> r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", e()), TuplesKt.to("drop_frame", r112), TuplesKt.to("drop_state_ratio", r113), TuplesKt.to("drop_dur_ratio", r210), TuplesKt.to("hitch_dur_ratio", Float.valueOf(r101)), TuplesKt.to("device_max_refresh_rate", Integer.valueOf(r212.f215600a)), TuplesKt.to("refresh_rate", Integer.valueOf(r212.f215601b))});
        r102.putAll(this.f215616c);
        r102.put("extra", this.f215617d);
        Unit r114 = Unit.INSTANCE;
        r110.d(r111, "base_mobile_performance_drop_frame_info", r102);
        if (c() == false) goto L22;
        double r103 = this.f215615b;
        long r104 = this.f215614a;
        double r105 = r103 / r104;
        this.f215614a = 0;
        this.f215615b = AudioStats.AUDIO_AMPLITUDE_NONE;
        tt5.a.h(f(), "totalFPS: " + r105 + ", duration: " + r104 + ", scene: " + e());
        Map<String, ? extends Serializable> r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", e()), TuplesKt.to("fps", Double.valueOf(r105)), TuplesKt.to("device_max_refresh_rate", Integer.valueOf(r212.f215600a)), TuplesKt.to("refresh_rate", Integer.valueOf(r212.f215601b))});
        r106.putAll(this.f215616c);
        r106.put("extra", this.f215617d);
        r110.d(r111, "base_mobile_performance_fps_info", r106);
        return true;
    L22:
        return true;
    L16:
        r101 = 0.0f;
    L5:
        int r107 = e.f215628a;
        tt5.a.h("BitableStatistic", f() + ' ' + ("isForceStop:" + r211));
        goto L7
    }
}
