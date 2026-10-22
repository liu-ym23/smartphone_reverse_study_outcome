package com.bytedance.android.livesdk.livecommerce.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECSpecInfo;", "Ljava/io/Serializable;", "name", "", "list", "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECSpecInfoItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSpecInfo implements Serializable {

    @SerializedName("spec_items")
    private List<ECSpecInfoItem> list;

    @SerializedName("name")
    private String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECSpecInfo copy$default(ECSpecInfo r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.list;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.name;
    }

    public final List<ECSpecInfoItem> component2() {
        return this.list;
    }

    public final ECSpecInfo copy(String r2, List<ECSpecInfoItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "list");
        return new ECSpecInfo(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECSpecInfo) == false) goto L10;
        ECSpecInfo r4 = (ECSpecInfo) r3;
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.list, r4.list) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ECSpecInfoItem> r4 = this.list;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ECSpecInfo(name=" + this.name + ", list=" + this.list + ")";
    }

    public final List<ECSpecInfoItem> getList() {
        return this.list;
    }

    public final String getName() {
        return this.name;
    }

    public final void setList(List<ECSpecInfoItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.list = r2;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public ECSpecInfo(String r2, List<ECSpecInfoItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "list");
        this.name = r2;
        this.list = r3;
    }
}
