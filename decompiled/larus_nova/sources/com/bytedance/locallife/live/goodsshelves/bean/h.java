package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/h;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("type")
    private final Integer type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.type, ((h) r100).type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.type;
        if (r100 == null) goto L7;
        r100.hashCode();
    L7:
        throw null;
    }

    public final String toString() {
        return "LiveLifeBFFCardClickInfo(type=" + this.type + ", param=null)";
    }

    public final Integer getType() {
        return this.type;
    }
}
