package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n;", "", "", "startTime", "J", "d", "()J", "endTime", "b", "Lcom/bytedance/android/ec/model/ECUrlModel;", "leftIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", TraceCons.METRIC_BACKGROUND, "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {
    public static final /* synthetic */ int a = 0;

    @SerializedName(TraceCons.METRIC_BACKGROUND)
    private final ECUrlModel background;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("left_icon")
    private final ECUrlModel leftIcon;

    @SerializedName("start_time")
    private final long startTime;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof n) == false) goto L14;
        n r7 = (n) r6;
        if (this.startTime == r7.startTime) goto L8;
        return false;
    L8:
        if (this.endTime == r7.endTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftIcon, r7.leftIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.background, r7.background) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.startTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.endTime;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        ECUrlModel r4 = this.leftIcon;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        ECUrlModel r8 = this.background;
        if (r8 == null) goto L10;
        r5 = r8.hashCode();
    L10:
        return r7 + r5;
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroCountdownAtmosphere(startTime=" + this.startTime + ", endTime=" + this.endTime + ", leftIcon=" + this.leftIcon + ", background=" + this.background + ")";
    }

    public n() {
        this(0, 0, null, null);
    }

    public final ECUrlModel a() {
        return this.background;
    }

    public final long b() {
        return this.endTime;
    }

    public final ECUrlModel c() {
        return this.leftIcon;
    }

    public final long d() {
        return this.startTime;
    }

    public n(long r1, long r3, ECUrlModel r5, ECUrlModel r6) {
        this.startTime = r1;
        this.endTime = r3;
        this.leftIcon = r5;
        this.background = r6;
    }
}
