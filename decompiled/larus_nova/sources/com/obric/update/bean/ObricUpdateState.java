package com.obric.update.bean;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/update/bean/ObricUpdateState;", "", "currentState", "Lcom/obric/update/bean/ObricUpdateStateType;", "updatePackageInfo", "Lcom/obric/update/bean/ObricUpdatePackageInfo;", "ext", "", "", "<init>", "(Lcom/obric/update/bean/ObricUpdateStateType;Lcom/obric/update/bean/ObricUpdatePackageInfo;Ljava/util/Map;)V", "getCurrentState", "()Lcom/obric/update/bean/ObricUpdateStateType;", "getUpdatePackageInfo", "()Lcom/obric/update/bean/ObricUpdatePackageInfo;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateState {
    private final ObricUpdateStateType currentState;
    private final Map<String, Object> ext;
    private final ObricUpdatePackageInfo updatePackageInfo;

    public ObricUpdateState() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricUpdateState copy$default(ObricUpdateState r100, ObricUpdateStateType r101, ObricUpdatePackageInfo r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.currentState;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.updatePackageInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ext;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ObricUpdateStateType component1() {
        return this.currentState;
    }

    public final ObricUpdatePackageInfo component2() {
        return this.updatePackageInfo;
    }

    public final Map<String, Object> component3() {
        return this.ext;
    }

    public final ObricUpdateState copy(ObricUpdateStateType r100, ObricUpdatePackageInfo r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        Intrinsics.checkNotNullParameter(r102, "ext");
        return new ObricUpdateState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricUpdateState) == true) goto L8;
        return false;
    L8:
        ObricUpdateState r101 = (ObricUpdateState) r100;
        if (this.currentState == r101.currentState) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updatePackageInfo, r101.updatePackageInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.currentState.hashCode() * 31;
        ObricUpdatePackageInfo r101 = this.updatePackageInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.ext.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ObricUpdateState(currentState=" + this.currentState + ", updatePackageInfo=" + this.updatePackageInfo + ", ext=" + this.ext + ')';
    }

    public final ObricUpdateStateType getCurrentState() {
        return this.currentState;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final ObricUpdatePackageInfo getUpdatePackageInfo() {
        return this.updatePackageInfo;
    }

    public ObricUpdateState(ObricUpdateStateType r100, ObricUpdatePackageInfo r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        Intrinsics.checkNotNullParameter(r102, "ext");
        this.currentState = r100;
        this.updatePackageInfo = r101;
        this.ext = r102;
    }

    public /* synthetic */ ObricUpdateState(ObricUpdateStateType r100, ObricUpdatePackageInfo r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = ObricUpdateStateType.UPDATE_NOT_AVAILABLE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = MapsKt.emptyMap();
    L11:
        this(r100, r101, r102);
    }
}
