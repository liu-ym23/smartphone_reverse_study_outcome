package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;", "Ljava/io/Serializable;", "tutorId", "", "tutorRoundId", "tutorPartId", "waitTimeoutConfig", "Lcom/larus/livetutor/api/idl/WaitTimeOutConfig;", "waitButtonConfig", "Lcom/larus/livetutor/api/idl/WaitButtonConfig;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/WaitTimeOutConfig;Lcom/larus/livetutor/api/idl/WaitButtonConfig;)V", "getTutorId", "()Ljava/lang/Long;", "setTutorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTutorRoundId", "setTutorRoundId", "getTutorPartId", "setTutorPartId", "getWaitTimeoutConfig", "()Lcom/larus/livetutor/api/idl/WaitTimeOutConfig;", "setWaitTimeoutConfig", "(Lcom/larus/livetutor/api/idl/WaitTimeOutConfig;)V", "getWaitButtonConfig", "()Lcom/larus/livetutor/api/idl/WaitButtonConfig;", "setWaitButtonConfig", "(Lcom/larus/livetutor/api/idl/WaitButtonConfig;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/WaitTimeOutConfig;Lcom/larus/livetutor/api/idl/WaitButtonConfig;)Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WaitUserAnswerMsg implements Serializable {

    @SerializedName("tutor_id")
    private Long tutorId;

    @SerializedName("tutor_part_id")
    private Long tutorPartId;

    @SerializedName("tutor_round_id")
    private Long tutorRoundId;

    @SerializedName("wait_button_config")
    private WaitButtonConfig waitButtonConfig;

    @SerializedName("wait_timeout_config")
    private WaitTimeOutConfig waitTimeoutConfig;

    public WaitUserAnswerMsg() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ WaitUserAnswerMsg copy$default(WaitUserAnswerMsg r100, Long r101, Long r102, Long r103, WaitTimeOutConfig r104, WaitButtonConfig r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.tutorId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.tutorRoundId;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.tutorPartId;
    L11:
        Long r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.waitTimeoutConfig;
    L14:
        WaitTimeOutConfig r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.waitButtonConfig;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.tutorId;
    }

    public final Long component2() {
        return this.tutorRoundId;
    }

    public final Long component3() {
        return this.tutorPartId;
    }

    public final WaitTimeOutConfig component4() {
        return this.waitTimeoutConfig;
    }

    public final WaitButtonConfig component5() {
        return this.waitButtonConfig;
    }

    public final WaitUserAnswerMsg copy(Long r100, Long r101, Long r110, WaitTimeOutConfig r111, WaitButtonConfig r112) {
        return new WaitUserAnswerMsg(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WaitUserAnswerMsg) == true) goto L8;
        return false;
    L8:
        WaitUserAnswerMsg r101 = (WaitUserAnswerMsg) r100;
        if (Intrinsics.areEqual(this.tutorId, r101.tutorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tutorRoundId, r101.tutorRoundId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tutorPartId, r101.tutorPartId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.waitTimeoutConfig, r101.waitTimeoutConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.waitButtonConfig, r101.waitButtonConfig) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Long r100 = this.tutorId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.tutorRoundId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.tutorPartId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        WaitTimeOutConfig r110 = this.waitTimeoutConfig;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        WaitButtonConfig r113 = this.waitButtonConfig;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "WaitUserAnswerMsg(tutorId=" + this.tutorId + ", tutorRoundId=" + this.tutorRoundId + ", tutorPartId=" + this.tutorPartId + ", waitTimeoutConfig=" + this.waitTimeoutConfig + ", waitButtonConfig=" + this.waitButtonConfig + ')';
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public final Long getTutorPartId() {
        return this.tutorPartId;
    }

    public final Long getTutorRoundId() {
        return this.tutorRoundId;
    }

    public final WaitButtonConfig getWaitButtonConfig() {
        return this.waitButtonConfig;
    }

    public final WaitTimeOutConfig getWaitTimeoutConfig() {
        return this.waitTimeoutConfig;
    }

    public final void setTutorId(Long r100) {
        this.tutorId = r100;
    }

    public final void setTutorPartId(Long r100) {
        this.tutorPartId = r100;
    }

    public final void setTutorRoundId(Long r100) {
        this.tutorRoundId = r100;
    }

    public final void setWaitButtonConfig(WaitButtonConfig r100) {
        this.waitButtonConfig = r100;
    }

    public final void setWaitTimeoutConfig(WaitTimeOutConfig r100) {
        this.waitTimeoutConfig = r100;
    }

    public WaitUserAnswerMsg(Long r100, Long r101, Long r102, WaitTimeOutConfig r103, WaitButtonConfig r104) {
        this.tutorId = r100;
        this.tutorRoundId = r101;
        this.tutorPartId = r102;
        this.waitTimeoutConfig = r103;
        this.waitButtonConfig = r104;
    }

    public /* synthetic */ WaitUserAnswerMsg(Long r100, Long r101, Long r102, WaitTimeOutConfig r103, WaitButtonConfig r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Long r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Long r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        WaitTimeOutConfig r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        WaitButtonConfig r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
