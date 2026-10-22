package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroNumAtmosphere;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "leftIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", TraceCons.METRIC_BACKGROUND, "a", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "", "num", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroNumAtmosphere {
    public static final /* synthetic */ int a = 0;

    @SerializedName(TraceCons.METRIC_BACKGROUND)
    private final ECUrlModel background;

    @SerializedName("left_icon")
    private final ECUrlModel leftIcon;

    @SerializedName("num")
    private final String num;

    @SerializedName(LocationMonitorConst.TYPE)
    private final int type;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroNumAtmosphere$Companion$IntroNumAtmosphereType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroNumAtmosphereType {
        }
    }

    static {
    }

    public IntroNumAtmosphere() {
        this(null, null, 0, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof IntroNumAtmosphere) == false) goto L14;
        IntroNumAtmosphere r4 = (IntroNumAtmosphere) r3;
        if (Intrinsics.areEqual(this.leftIcon, r4.leftIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.background, r4.background) == true) goto L10;
        return false;
    L10:
        if (this.type == r4.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.num, r4.num) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.leftIcon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.background;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.type) * 31;
        String r7 = this.num;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroNumAtmosphere(leftIcon=" + this.leftIcon + ", background=" + this.background + ", type=" + this.type + ", num=" + this.num + ")";
    }

    public final ECUrlModel a() {
        return this.background;
    }

    public final ECUrlModel b() {
        return this.leftIcon;
    }

    public final String c() {
        return this.num;
    }

    public final int getType() {
        return this.type;
    }

    public IntroNumAtmosphere(ECUrlModel r1, ECUrlModel r2, int r3, String r4) {
        this.leftIcon = r1;
        this.background = r2;
        this.type = r3;
        this.num = r4;
    }
}
