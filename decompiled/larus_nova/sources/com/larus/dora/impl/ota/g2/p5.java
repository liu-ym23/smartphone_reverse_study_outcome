package com.larus.dora.impl.ota.g2;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class p5 {
    private final e device;
    private final Map<String, String> fields;
    private final String name;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p5) == true) goto L8;
        return false;
    L8:
        p5 r101 = (p5) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fields, r101.fields) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.name.hashCode() * 31;
        e r101 = this.device;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.fields.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TelemetryRecord(name=" + this.name + ", device=" + this.device + ", fields=" + this.fields + ')';
    }

    public final e a() {
        return this.device;
    }

    public final Map<String, String> b() {
        return this.fields;
    }

    public final String c() {
        return this.name;
    }

    public p5(String r100, e r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_PARAMS);
        this.name = r100;
        this.device = r101;
        this.fields = r102;
    }
}
