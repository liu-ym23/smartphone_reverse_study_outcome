package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012¨\u0006("}, d2 = {"Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;", "Ljava/io/Serializable;", "clientControl", "Lcom/larus/livetutor/api/idl/ControlAction;", "jumpToTutorPartId", "", "pauseLocation", "Lcom/larus/livetutor/api/idl/PauseLocation;", "controlReason", "<init>", "(Lcom/larus/livetutor/api/idl/ControlAction;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/PauseLocation;Ljava/lang/Long;)V", "getClientControl", "()Lcom/larus/livetutor/api/idl/ControlAction;", "setClientControl", "(Lcom/larus/livetutor/api/idl/ControlAction;)V", "getJumpToTutorPartId", "()Ljava/lang/Long;", "setJumpToTutorPartId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPauseLocation", "()Lcom/larus/livetutor/api/idl/PauseLocation;", "setPauseLocation", "(Lcom/larus/livetutor/api/idl/PauseLocation;)V", "getControlReason", "setControlReason", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/livetutor/api/idl/ControlAction;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/PauseLocation;Ljava/lang/Long;)Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorClientControlMsg implements Serializable {

    @SerializedName("client_control")
    private ControlAction clientControl;

    @SerializedName("control_reason")
    private Long controlReason;

    @SerializedName("jump_to_tutor_part_id")
    private Long jumpToTutorPartId;

    @SerializedName("pause_location")
    private PauseLocation pauseLocation;

    public LiveTutorClientControlMsg() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ LiveTutorClientControlMsg copy$default(LiveTutorClientControlMsg r100, ControlAction r101, Long r102, PauseLocation r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.clientControl;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.jumpToTutorPartId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.pauseLocation;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.controlReason;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ControlAction component1() {
        return this.clientControl;
    }

    public final Long component2() {
        return this.jumpToTutorPartId;
    }

    public final PauseLocation component3() {
        return this.pauseLocation;
    }

    public final Long component4() {
        return this.controlReason;
    }

    public final LiveTutorClientControlMsg copy(ControlAction r100, Long r101, PauseLocation r102, Long r103) {
        return new LiveTutorClientControlMsg(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorClientControlMsg) == true) goto L8;
        return false;
    L8:
        LiveTutorClientControlMsg r101 = (LiveTutorClientControlMsg) r100;
        if (this.clientControl == r101.clientControl) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpToTutorPartId, r101.jumpToTutorPartId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pauseLocation, r101.pauseLocation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.controlReason, r101.controlReason) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        ControlAction r100 = this.clientControl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.jumpToTutorPartId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PauseLocation r107 = this.pauseLocation;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.controlReason;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "LiveTutorClientControlMsg(clientControl=" + this.clientControl + ", jumpToTutorPartId=" + this.jumpToTutorPartId + ", pauseLocation=" + this.pauseLocation + ", controlReason=" + this.controlReason + ')';
    }

    public final ControlAction getClientControl() {
        return this.clientControl;
    }

    public final Long getControlReason() {
        return this.controlReason;
    }

    public final Long getJumpToTutorPartId() {
        return this.jumpToTutorPartId;
    }

    public final PauseLocation getPauseLocation() {
        return this.pauseLocation;
    }

    public final void setClientControl(ControlAction r100) {
        this.clientControl = r100;
    }

    public final void setControlReason(Long r100) {
        this.controlReason = r100;
    }

    public final void setJumpToTutorPartId(Long r100) {
        this.jumpToTutorPartId = r100;
    }

    public final void setPauseLocation(PauseLocation r100) {
        this.pauseLocation = r100;
    }

    public LiveTutorClientControlMsg(ControlAction r100, Long r101, PauseLocation r102, Long r103) {
        this.clientControl = r100;
        this.jumpToTutorPartId = r101;
        this.pauseLocation = r102;
        this.controlReason = r103;
    }

    public /* synthetic */ LiveTutorClientControlMsg(ControlAction r100, Long r101, PauseLocation r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
