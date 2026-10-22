package com.bytedance.locallife.groupon.struct.undertake;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUnderTakeStatus;", "", "state", "Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUndertakeState;", "type", "Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUnderTakeType;", "(Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUndertakeState;Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUnderTakeType;)V", "getState", "()Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUndertakeState;", "setState", "(Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUndertakeState;)V", "getType", "()Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUnderTakeType;", "setType", "(Lcom/bytedance/locallife/groupon/struct/undertake/NearbyUnderTakeType;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyUnderTakeStatus {
    private NearbyUndertakeState state;
    private NearbyUnderTakeType type;

    public static /* synthetic */ NearbyUnderTakeStatus copy$default(NearbyUnderTakeStatus r100, NearbyUndertakeState r101, NearbyUnderTakeType r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.state;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final NearbyUndertakeState component1() {
        return this.state;
    }

    public final NearbyUnderTakeType component2() {
        return this.type;
    }

    public final NearbyUnderTakeStatus copy(NearbyUndertakeState r100, NearbyUnderTakeType r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "type");
        return new NearbyUnderTakeStatus(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyUnderTakeStatus) == true) goto L8;
        return false;
    L8:
        NearbyUnderTakeStatus r101 = (NearbyUnderTakeStatus) r100;
        if (this.state == r101.state) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "NearbyUnderTakeStatus(state=" + this.state + ", type=" + this.type + ')';
    }

    public final NearbyUndertakeState getState() {
        return this.state;
    }

    public final NearbyUnderTakeType getType() {
        return this.type;
    }

    public final void setState(NearbyUndertakeState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.state = r100;
    }

    public final void setType(NearbyUnderTakeType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public NearbyUnderTakeStatus(NearbyUndertakeState r100, NearbyUnderTakeType r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.state = r100;
        this.type = r101;
    }
}
