package com.bytedance.android.shopping.ligo.container.event;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/ligo/container/event/LiveLigoListFloatBottomHeightEventData;", "Ljava/io/Serializable;", "height", "", "(I)V", "getHeight", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLigoListFloatBottomHeightEventData implements Serializable {

    @SerializedName("height")
    private final int height;

    public static /* synthetic */ LiveLigoListFloatBottomHeightEventData copy$default(LiveLigoListFloatBottomHeightEventData r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.height;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.height;
    }

    public final LiveLigoListFloatBottomHeightEventData copy(int r2) {
        return new LiveLigoListFloatBottomHeightEventData(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof LiveLigoListFloatBottomHeightEventData) == true) goto L6;
        return false;
    L6:
        if (this.height == ((LiveLigoListFloatBottomHeightEventData) r2).height) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.height;
    }

    public String toString() {
        return "LiveLigoListFloatBottomHeightEventData(height=" + this.height + ")";
    }

    public final int getHeight() {
        return this.height;
    }

    public LiveLigoListFloatBottomHeightEventData(int r1) {
        this.height = r1;
    }
}
