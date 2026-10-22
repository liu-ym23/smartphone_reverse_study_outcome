package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/z;", "", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPriceDescription;", "descriptions", "Ljava/util/List;", "getDescriptions", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/w;", "flips", "getFlips", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "track", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "getTrack", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("descriptions")
    private final List<IntroPriceDescription> descriptions;

    @SerializedName("flips")
    private final List<w> flips;

    @SerializedName("track")
    private final b0 track;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof z) == false) goto L12;
        z r4 = (z) r3;
        if (Intrinsics.areEqual(this.descriptions, r4.descriptions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.flips, r4.flips) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.track, r4.track) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<IntroPriceDescription> r0 = this.descriptions;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<w> r4 = this.flips;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        b0 r7 = this.track;
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
        return "IntroOpenPriceAnimationPrice(descriptions=" + this.descriptions + ", flips=" + this.flips + ", track=" + this.track + ")";
    }

    public z() {
        this.descriptions = null;
        this.flips = null;
        this.track = null;
    }
}
