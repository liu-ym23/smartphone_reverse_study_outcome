package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/p;", "", "", "frequencyKey", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "frequencyCount", "J", "b", "()J", "Lcom/bytedance/android/ec/model/ECUrlModel;", "leftIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "d", "()Lcom/bytedance/android/ec/model/ECUrlModel;", TraceCons.METRIC_BACKGROUND, "a", "num", "e", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {
    public static final /* synthetic */ int a = 0;

    @SerializedName(TraceCons.METRIC_BACKGROUND)
    private final ECUrlModel background;

    @SerializedName("frequency_count")
    private final long frequencyCount;

    @SerializedName("frequency_key")
    private final String frequencyKey;

    @SerializedName("left_icon")
    private final ECUrlModel leftIcon;

    @SerializedName("num")
    private final String num;

    public static final class a {
    }

    static {
    }

    public p() {
        this(null, 0, null, null, null);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof p) == false) goto L16;
        p r7 = (p) r6;
        if (Intrinsics.areEqual(this.frequencyKey, r7.frequencyKey) == true) goto L8;
        return false;
    L8:
        if (this.frequencyCount == r7.frequencyCount) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftIcon, r7.leftIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.background, r7.background) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.num, r7.num) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.frequencyKey;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.frequencyCount;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        ECUrlModel r5 = this.leftIcon;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        ECUrlModel r8 = this.background;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.num;
        if (r11 == null) goto L18;
        r1 = r11.hashCode();
    L18:
        return r10 + r1;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroDigitalAtmosphere(frequencyKey=" + this.frequencyKey + ", frequencyCount=" + this.frequencyCount + ", leftIcon=" + this.leftIcon + ", background=" + this.background + ", num=" + this.num + ")";
    }

    public final ECUrlModel a() {
        return this.background;
    }

    public final long b() {
        return this.frequencyCount;
    }

    public final String c() {
        return this.frequencyKey;
    }

    public final ECUrlModel d() {
        return this.leftIcon;
    }

    public final String e() {
        return this.num;
    }

    public p(String r1, long r2, ECUrlModel r4, ECUrlModel r5, String r6) {
        this.frequencyKey = r1;
        this.frequencyCount = r2;
        this.leftIcon = r4;
        this.background = r5;
        this.num = r6;
    }
}
