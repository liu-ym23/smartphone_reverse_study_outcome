package com.larus.livetutor.impl.tutor.data;

import com.larus.livetutor.api.idl.ControlReason;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/livetutor/impl/tutor/data/LiveTutorPauseEvent;", "", "pauseStatus", "", "autoResume", "pauseReason", "Lcom/larus/livetutor/api/idl/ControlReason;", "containsProactive", "withAnim", "<init>", "(ZZLcom/larus/livetutor/api/idl/ControlReason;ZZ)V", "getPauseStatus", "()Z", "getAutoResume", "getPauseReason", "()Lcom/larus/livetutor/api/idl/ControlReason;", "getContainsProactive", "setContainsProactive", "(Z)V", "getWithAnim", "setWithAnim", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorPauseEvent {
    private final boolean autoResume;
    private boolean containsProactive;
    private final ControlReason pauseReason;
    private final boolean pauseStatus;
    private boolean withAnim;

    public static /* synthetic */ LiveTutorPauseEvent copy$default(LiveTutorPauseEvent r100, boolean r101, boolean r102, ControlReason r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.pauseStatus;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.autoResume;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.pauseReason;
    L11:
        ControlReason r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.containsProactive;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.withAnim;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.pauseStatus;
    }

    public final boolean component2() {
        return this.autoResume;
    }

    public final ControlReason component3() {
        return this.pauseReason;
    }

    public final boolean component4() {
        return this.containsProactive;
    }

    public final boolean component5() {
        return this.withAnim;
    }

    public final LiveTutorPauseEvent copy(boolean r100, boolean r101, ControlReason r110, boolean r111, boolean r112) {
        return new LiveTutorPauseEvent(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorPauseEvent) == true) goto L8;
        return false;
    L8:
        LiveTutorPauseEvent r101 = (LiveTutorPauseEvent) r100;
        if (this.pauseStatus == r101.pauseStatus) goto L12;
        return false;
    L12:
        if (this.autoResume == r101.autoResume) goto L15;
        return false;
    L15:
        if (this.pauseReason == r101.pauseReason) goto L18;
        return false;
    L18:
        if (this.containsProactive == r101.containsProactive) goto L21;
        return false;
    L21:
        if (this.withAnim == r101.withAnim) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.pauseStatus == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.autoResume == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        ControlReason r105 = this.pauseReason;
        if (r105 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r104 + r106) * 31;
        if (this.containsProactive == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.withAnim == true) goto L23;
        r100 = 1237;
    L23:
        return r109 + r100;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "LiveTutorPauseEvent(pauseStatus=" + this.pauseStatus + ", autoResume=" + this.autoResume + ", pauseReason=" + this.pauseReason + ", containsProactive=" + this.containsProactive + ", withAnim=" + this.withAnim + ')';
    }

    public final boolean getAutoResume() {
        return this.autoResume;
    }

    public final boolean getContainsProactive() {
        return this.containsProactive;
    }

    public final ControlReason getPauseReason() {
        return this.pauseReason;
    }

    public final boolean getPauseStatus() {
        return this.pauseStatus;
    }

    public final boolean getWithAnim() {
        return this.withAnim;
    }

    public final void setContainsProactive(boolean r100) {
        this.containsProactive = r100;
    }

    public final void setWithAnim(boolean r100) {
        this.withAnim = r100;
    }

    public LiveTutorPauseEvent(boolean r100, boolean r101, ControlReason r102, boolean r103, boolean r104) {
        this.pauseStatus = r100;
        this.autoResume = r101;
        this.pauseReason = r102;
        this.containsProactive = r103;
        this.withAnim = r104;
    }

    public /* synthetic */ LiveTutorPauseEvent(boolean r100, boolean r101, ControlReason r110, boolean r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r113 & 4) == 0) goto L9;
        r110 = null;
    L9:
        ControlReason r103 = r110;
        if ((r113 & 8) == 0) goto L12;
        boolean r104 = false;
    L14:
        if ((r113 & 16) == 0) goto L16;
        boolean r105 = false;
    L17:
        this(r100, r102, r103, r104, r105);
        return;
    L16:
        r105 = r112;
        goto L17
    L12:
        r104 = r111;
        goto L14
    L5:
        r102 = r101;
        goto L7
    }
}
