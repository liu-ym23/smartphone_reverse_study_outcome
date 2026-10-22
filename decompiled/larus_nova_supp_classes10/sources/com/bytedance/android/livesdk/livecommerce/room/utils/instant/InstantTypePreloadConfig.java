package com.bytedance.android.livesdk.livecommerce.room.utils.instant;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/utils/instant/InstantTypePreloadConfig;", "Ljava/io/Serializable;", "instantType", "", "channels", "", "", "(ILjava/util/List;)V", "getChannels", "()Ljava/util/List;", "getInstantType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InstantTypePreloadConfig implements Serializable {

    @SerializedName("channels")
    private final List<String> channels;

    @SerializedName("instant_type")
    private final int instantType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstantTypePreloadConfig copy$default(InstantTypePreloadConfig r0, int r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.instantType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.channels;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.instantType;
    }

    public final List<String> component2() {
        return this.channels;
    }

    public final InstantTypePreloadConfig copy(int r2, List<String> r3) {
        return new InstantTypePreloadConfig(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof InstantTypePreloadConfig) == false) goto L10;
        InstantTypePreloadConfig r4 = (InstantTypePreloadConfig) r3;
        if (this.instantType == r4.instantType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.channels, r4.channels) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = this.instantType * 31;
        List<String> r1 = this.channels;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "InstantTypePreloadConfig(instantType=" + this.instantType + ", channels=" + this.channels + ")";
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final int getInstantType() {
        return this.instantType;
    }

    public InstantTypePreloadConfig(int r1, List<String> r2) {
        this.instantType = r1;
        this.channels = r2;
    }
}
