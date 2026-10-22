package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "", "", "trackName", "Ljava/lang/String;", "getTrackName", "()Ljava/lang/String;", "", "trackParams", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("track_name")
    private final String trackName;

    @SerializedName("track_param")
    private final Map<String, String> trackParams;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b0) == false) goto L10;
        b0 r4 = (b0) r3;
        if (Intrinsics.areEqual(this.trackName, r4.trackName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackParams, r4.trackParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.trackName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.trackParams;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroOpenPriceTrack(trackName=" + this.trackName + ", trackParams=" + this.trackParams + ")";
    }

    public b0() {
        this.trackName = null;
        this.trackParams = null;
    }
}
