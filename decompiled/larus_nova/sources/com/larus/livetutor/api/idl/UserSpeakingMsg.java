package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/livetutor/api/idl/UserSpeakingMsg;", "Ljava/io/Serializable;", "action", "Lcom/larus/livetutor/api/idl/UserSpeakingAction;", "pauseLocation", "Lcom/larus/livetutor/api/idl/PauseLocation;", "clientUuid", "", "<init>", "(Lcom/larus/livetutor/api/idl/UserSpeakingAction;Lcom/larus/livetutor/api/idl/PauseLocation;Ljava/lang/String;)V", "getAction", "()Lcom/larus/livetutor/api/idl/UserSpeakingAction;", "setAction", "(Lcom/larus/livetutor/api/idl/UserSpeakingAction;)V", "getPauseLocation", "()Lcom/larus/livetutor/api/idl/PauseLocation;", "setPauseLocation", "(Lcom/larus/livetutor/api/idl/PauseLocation;)V", "getClientUuid", "()Ljava/lang/String;", "setClientUuid", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSpeakingMsg implements Serializable {

    @SerializedName("action")
    private UserSpeakingAction action;

    @SerializedName("client_uuid")
    private String clientUuid;

    @SerializedName("pause_location")
    private PauseLocation pauseLocation;

    public UserSpeakingMsg() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UserSpeakingMsg copy$default(UserSpeakingMsg r100, UserSpeakingAction r101, PauseLocation r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.action;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.pauseLocation;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.clientUuid;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final UserSpeakingAction component1() {
        return this.action;
    }

    public final PauseLocation component2() {
        return this.pauseLocation;
    }

    public final String component3() {
        return this.clientUuid;
    }

    public final UserSpeakingMsg copy(UserSpeakingAction r100, PauseLocation r101, String r102) {
        return new UserSpeakingMsg(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserSpeakingMsg) == true) goto L8;
        return false;
    L8:
        UserSpeakingMsg r101 = (UserSpeakingMsg) r100;
        if (this.action == r101.action) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pauseLocation, r101.pauseLocation) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clientUuid, r101.clientUuid) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        UserSpeakingAction r100 = this.action;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PauseLocation r104 = this.pauseLocation;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.clientUuid;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UserSpeakingMsg(action=" + this.action + ", pauseLocation=" + this.pauseLocation + ", clientUuid=" + this.clientUuid + ')';
    }

    public final UserSpeakingAction getAction() {
        return this.action;
    }

    public final String getClientUuid() {
        return this.clientUuid;
    }

    public final PauseLocation getPauseLocation() {
        return this.pauseLocation;
    }

    public final void setAction(UserSpeakingAction r100) {
        this.action = r100;
    }

    public final void setClientUuid(String r100) {
        this.clientUuid = r100;
    }

    public final void setPauseLocation(PauseLocation r100) {
        this.pauseLocation = r100;
    }

    public UserSpeakingMsg(UserSpeakingAction r100, PauseLocation r101, String r102) {
        this.action = r100;
        this.pauseLocation = r101;
        this.clientUuid = r102;
    }

    public /* synthetic */ UserSpeakingMsg(UserSpeakingAction r100, PauseLocation r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
