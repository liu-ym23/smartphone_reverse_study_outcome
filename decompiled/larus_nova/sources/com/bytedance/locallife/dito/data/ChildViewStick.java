package com.bytedance.locallife.dito.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/dito/data/ChildViewStick;", "Ljava/io/Serializable;", "isStick", "", "stickNodeId", "", "stickNodeContainerId", "stickUntilComponentId", "stickUntilNodeIdInThisCard", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getStickNodeContainerId", "()Ljava/lang/String;", "getStickNodeId", "getStickUntilComponentId", "getStickUntilNodeIdInThisCard", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ChildViewStick implements Serializable {

    @SerializedName("isStick")
    private final boolean isStick;

    @SerializedName("stickNodeContainerId")
    private final String stickNodeContainerId;

    @SerializedName("stickNodeId")
    private final String stickNodeId;

    @SerializedName("stickUntilComponentId")
    private final String stickUntilComponentId;

    @SerializedName("stickUntilNodeIdInThisCard")
    private final String stickUntilNodeIdInThisCard;

    public static /* synthetic */ ChildViewStick copy$default(ChildViewStick r100, boolean r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.isStick;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.stickNodeId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.stickNodeContainerId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.stickUntilComponentId;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.stickUntilNodeIdInThisCard;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.isStick;
    }

    public final String component2() {
        return this.stickNodeId;
    }

    public final String component3() {
        return this.stickNodeContainerId;
    }

    public final String component4() {
        return this.stickUntilComponentId;
    }

    public final String component5() {
        return this.stickUntilNodeIdInThisCard;
    }

    public final ChildViewStick copy(boolean r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "stickNodeId");
        Intrinsics.checkNotNullParameter(r110, "stickNodeContainerId");
        Intrinsics.checkNotNullParameter(r111, "stickUntilComponentId");
        Intrinsics.checkNotNullParameter(r112, "stickUntilNodeIdInThisCard");
        return new ChildViewStick(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChildViewStick) == true) goto L8;
        return false;
    L8:
        ChildViewStick r101 = (ChildViewStick) r100;
        if (this.isStick == r101.isStick) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stickNodeId, r101.stickNodeId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.stickNodeContainerId, r101.stickNodeContainerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.stickUntilComponentId, r101.stickUntilComponentId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.stickUntilNodeIdInThisCard, r101.stickUntilNodeIdInThisCard) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.isStick == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((((r100 * 31) + this.stickNodeId.hashCode()) * 31) + this.stickNodeContainerId.hashCode()) * 31) + this.stickUntilComponentId.hashCode()) * 31) + this.stickUntilNodeIdInThisCard.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "ChildViewStick(isStick=" + this.isStick + ", stickNodeId=" + this.stickNodeId + ", stickNodeContainerId=" + this.stickNodeContainerId + ", stickUntilComponentId=" + this.stickUntilComponentId + ", stickUntilNodeIdInThisCard=" + this.stickUntilNodeIdInThisCard + ')';
    }

    public final String getStickNodeContainerId() {
        return this.stickNodeContainerId;
    }

    public final String getStickNodeId() {
        return this.stickNodeId;
    }

    public final String getStickUntilComponentId() {
        return this.stickUntilComponentId;
    }

    public final String getStickUntilNodeIdInThisCard() {
        return this.stickUntilNodeIdInThisCard;
    }

    public final boolean isStick() {
        return this.isStick;
    }

    public ChildViewStick(boolean r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "stickNodeId");
        Intrinsics.checkNotNullParameter(r102, "stickNodeContainerId");
        Intrinsics.checkNotNullParameter(r103, "stickUntilComponentId");
        Intrinsics.checkNotNullParameter(r104, "stickUntilNodeIdInThisCard");
        this.isStick = r100;
        this.stickNodeId = r101;
        this.stickNodeContainerId = r102;
        this.stickUntilComponentId = r103;
        this.stickUntilNodeIdInThisCard = r104;
    }
}
