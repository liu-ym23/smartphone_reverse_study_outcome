package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import java.util.Map;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o0 extends v0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f405203g;

    public static final class a {
    }

    static {
    }

    public final Map<String, Object> e() {
        Map<String, Object> r100 = this.f405203g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    L6:
        return r100;
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, Object> r101 = this.f405203g;
        Boolean r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r101 = null;
    L5:
        Object r103 = r101.get(r100);
        if ((r103 instanceof Boolean) == false) goto L8;
        r102 = (Boolean) r103;
    L8:
        if (r102 != null) goto L12;
        return false;
    L12:
        return r102.booleanValue();
    }

    public final double b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, Object> r101 = this.f405203g;
        Long r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r101 = null;
    L5:
        Object r103 = r101.get(r100);
        if ((r103 instanceof Double) == false) goto L8;
        Double r104 = (Double) r103;
    L9:
        if (r104 == null) goto L13;
        return r104.doubleValue();
    L13:
        if ((r103 instanceof Float) == false) goto L15;
        Float r105 = (Float) r103;
    L16:
        if (r105 == null) goto L20;
        FloatCompanionObject r106 = FloatCompanionObject.INSTANCE;
        float r107 = r105.floatValue();
        Intrinsics.checkNotNullParameter(r106, "<this>");
        Intrinsics.checkNotNullParameter(r106, "<this>");
        return r107;
    L20:
        if ((r103 instanceof Integer) == false) goto L22;
        Integer r108 = (Integer) r103;
    L23:
        if (r108 == null) goto L27;
        int r109 = com.bytedance.rts.foundation.d.f267577a;
        return r108.intValue();
    L27:
        if ((r103 instanceof Long) == false) goto L29;
        r102 = (Long) r103;
    L29:
        if (r102 == null) goto L32;
        int r110 = com.bytedance.rts.foundation.e.f267578a;
        return r102.longValue();
    L32:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L22:
        r108 = null;
        goto L23
    L15:
        r105 = null;
        goto L16
    L8:
        r104 = null;
        goto L9
    }

    public final int c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, Object> r101 = this.f405203g;
        Double r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r101 = null;
    L5:
        Object r103 = r101.get(r100);
        if ((r103 instanceof Integer) == false) goto L8;
        Integer r104 = (Integer) r103;
    L9:
        if (r104 == null) goto L13;
        return r104.intValue();
    L13:
        if ((r103 instanceof Long) == false) goto L15;
        Long r105 = (Long) r103;
    L16:
        if (r105 == null) goto L20;
        int r106 = com.bytedance.rts.foundation.e.f267578a;
        return (int) r105.longValue();
    L20:
        if ((r103 instanceof Float) == false) goto L22;
        Float r107 = (Float) r103;
    L23:
        if (r107 == null) goto L27;
        FloatCompanionObject r108 = FloatCompanionObject.INSTANCE;
        float r109 = r107.floatValue();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        Intrinsics.checkNotNullParameter(r108, "<this>");
        return (int) r109;
    L27:
        if ((r103 instanceof Double) == false) goto L29;
        r102 = (Double) r103;
    L29:
        if (r102 == null) goto L32;
        int r110 = com.bytedance.rts.foundation.c.f267576a;
        return (int) r102.doubleValue();
    L32:
        return 0;
    L22:
        r107 = null;
        goto L23
    L15:
        r105 = null;
        goto L16
    L8:
        r104 = null;
        goto L9
    }

    public final Object d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, Object> r101 = this.f405203g;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r101 = null;
    L6:
        return r101.get(r100);
    }

    public o0(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "params");
        super(r100, EventType.CustomEvent, false, PhaseType.None);
        this.f405203g = r101;
    }
}
