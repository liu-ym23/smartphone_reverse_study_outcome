package com.larus.community.impl.detail.loading;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/detail/loading/CreationLoadingState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "creationId", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "state", "", "<init>", "(Ljava/lang/String;Lcom/larus/platform/api/creation/UserCreation;I)V", "getCreationId", "()Ljava/lang/String;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "getState", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLoadingState implements w1a.b {

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("state")
    private final int state;

    @SerializedName("creation")
    private final UserCreation userCreation;

    public CreationLoadingState() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ CreationLoadingState copy$default(CreationLoadingState r100, String r101, UserCreation r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.creationId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.userCreation;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.state;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.creationId;
    }

    public final UserCreation component2() {
        return this.userCreation;
    }

    public final int component3() {
        return this.state;
    }

    public final CreationLoadingState copy(String r100, UserCreation r101, @CreationOperateType int r102) {
        return new CreationLoadingState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationLoadingState) == true) goto L8;
        return false;
    L8:
        CreationLoadingState r101 = (CreationLoadingState) r100;
        if (Intrinsics.areEqual(this.creationId, r101.creationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userCreation, r101.userCreation) == true) goto L15;
        return false;
    L15:
        if (this.state == r101.state) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.creationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UserCreation r104 = this.userCreation;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.state;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationLoadingState(creationId=" + this.creationId + ", userCreation=" + this.userCreation + ", state=" + this.state + ')';
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final int getState() {
        return this.state;
    }

    public final UserCreation getUserCreation() {
        return this.userCreation;
    }

    public CreationLoadingState(String r100, UserCreation r101, @CreationOperateType int r102) {
        this.creationId = r100;
        this.userCreation = r101;
        this.state = r102;
    }

    public /* synthetic */ CreationLoadingState(String r100, UserCreation r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
