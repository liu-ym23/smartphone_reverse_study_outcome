package com.bytedance.android.livesdk.livecommerce.largemode.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;", "Ljava/io/Serializable;", "", "component1", "", "component2", LocationMonitorConst.TYPE, "value", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "F", "getValue", "()F", "<init>", "(Ljava/lang/String;F)V", "Companion", "a", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class LayoutSizeLargeModeConfig implements Serializable {
    public static final a Companion = null;
    public static final String TYPE_PERCENTAGE = "percentage";
    public static final String TYPE_SIZE_DP = "offset";

    @SerializedName(LocationMonitorConst.TYPE)
    private final String type;

    @SerializedName("value")
    private final float value;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ LayoutSizeLargeModeConfig copy$default(LayoutSizeLargeModeConfig r0, String r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.value;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.type;
    }

    public final float component2() {
        return this.value;
    }

    public final LayoutSizeLargeModeConfig copy(String r2, float r3) {
        return new LayoutSizeLargeModeConfig(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LayoutSizeLargeModeConfig) == false) goto L10;
        LayoutSizeLargeModeConfig r4 = (LayoutSizeLargeModeConfig) r3;
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.value, r4.value) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.type;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + Float.floatToIntBits(this.value);
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        return "LayoutSizeLargeModeConfig(type=" + this.type + ", value=" + this.value + ")";
    }

    public final String getType() {
        return this.type;
    }

    public final float getValue() {
        return this.value;
    }

    public LayoutSizeLargeModeConfig(String r1, float r2) {
        this.type = r1;
        this.value = r2;
    }

    public /* synthetic */ LayoutSizeLargeModeConfig(String r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0.0f;
    L5:
        this(r1, r2);
    }
}
