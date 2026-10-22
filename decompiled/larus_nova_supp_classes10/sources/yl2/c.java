package yl2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lyl2/c;", "", "", "shelfFromPosition", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("shelf_from_position")
    private final String shelfFromPosition;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.shelfFromPosition, ((c) r2).shelfFromPosition) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.shelfFromPosition;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "OpenLiveLifeShelfTracker(shelfFromPosition=" + this.shelfFromPosition + ")";
    }

    public c() {
        this.shelfFromPosition = null;
    }

    public final String a() {
        return this.shelfFromPosition;
    }
}
