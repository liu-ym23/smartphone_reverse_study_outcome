package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u000fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u000f¨\u0006,"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmGetStatusResponse;", "Ljava/io/Serializable;", "objectStatus", "", "reviewStatus", "canModify", "", "objectVersion", "lastEditVersion", "summaryStatus", "agendaStatus", "speakerSummaryStatus", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getObjectStatus", "()Ljava/lang/Integer;", "setObjectStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReviewStatus", "getCanModify", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getObjectVersion", "getLastEditVersion", "getSummaryStatus", "getAgendaStatus", "getSpeakerSummaryStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmGetStatusResponse;", "equals", "other", "", "hashCode", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmGetStatusResponse implements Serializable {

    @SerializedName("agenda_status")
    private final Integer agendaStatus;

    @SerializedName("can_modify")
    private final Boolean canModify;

    @SerializedName("last_edit_version")
    private final Integer lastEditVersion;

    @SerializedName("object_status")
    private Integer objectStatus;

    @SerializedName("object_version")
    private final Integer objectVersion;

    @SerializedName("review_status")
    private final Integer reviewStatus;

    @SerializedName("speaker_ai_status")
    private final Integer speakerSummaryStatus;

    @SerializedName("summary_status")
    private final Integer summaryStatus;

    public MmGetStatusResponse() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ MmGetStatusResponse copy$default(MmGetStatusResponse r100, Integer r110, Integer r111, Boolean r112, Integer r113, Integer r114, Integer r115, Integer r116, Integer r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = r100.objectStatus;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Integer r102 = r100.reviewStatus;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Boolean r103 = r100.canModify;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = r100.objectVersion;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = r100.lastEditVersion;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = r100.summaryStatus;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r107 = r100.agendaStatus;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r108 = r100.speakerSummaryStatus;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final Integer component1() {
        return this.objectStatus;
    }

    public final Integer component2() {
        return this.reviewStatus;
    }

    public final Boolean component3() {
        return this.canModify;
    }

    public final Integer component4() {
        return this.objectVersion;
    }

    public final Integer component5() {
        return this.lastEditVersion;
    }

    public final Integer component6() {
        return this.summaryStatus;
    }

    public final Integer component7() {
        return this.agendaStatus;
    }

    public final Integer component8() {
        return this.speakerSummaryStatus;
    }

    public final MmGetStatusResponse copy(Integer r110, Integer r111, Boolean r112, Integer r113, Integer r114, Integer r115, Integer r116, Integer r117) {
        return new MmGetStatusResponse(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmGetStatusResponse) == true) goto L8;
        return false;
    L8:
        MmGetStatusResponse r101 = (MmGetStatusResponse) r100;
        if (Intrinsics.areEqual(this.objectStatus, r101.objectStatus) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reviewStatus, r101.reviewStatus) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.canModify, r101.canModify) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.objectVersion, r101.objectVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lastEditVersion, r101.lastEditVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.summaryStatus, r101.summaryStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.agendaStatus, r101.agendaStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.speakerSummaryStatus, r101.speakerSummaryStatus) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.objectStatus;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.reviewStatus;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.canModify;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.objectVersion;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.lastEditVersion;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.summaryStatus;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.agendaStatus;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.speakerSummaryStatus;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "MmGetStatusResponse(objectStatus=" + this.objectStatus + ", reviewStatus=" + this.reviewStatus + ", canModify=" + this.canModify + ", objectVersion=" + this.objectVersion + ", lastEditVersion=" + this.lastEditVersion + ", summaryStatus=" + this.summaryStatus + ", agendaStatus=" + this.agendaStatus + ", speakerSummaryStatus=" + this.speakerSummaryStatus + ')';
    }

    public final Integer getAgendaStatus() {
        return this.agendaStatus;
    }

    public final Boolean getCanModify() {
        return this.canModify;
    }

    public final Integer getLastEditVersion() {
        return this.lastEditVersion;
    }

    public final Integer getObjectStatus() {
        return this.objectStatus;
    }

    public final Integer getObjectVersion() {
        return this.objectVersion;
    }

    public final Integer getReviewStatus() {
        return this.reviewStatus;
    }

    public final Integer getSpeakerSummaryStatus() {
        return this.speakerSummaryStatus;
    }

    public final Integer getSummaryStatus() {
        return this.summaryStatus;
    }

    public final void setObjectStatus(Integer r100) {
        this.objectStatus = r100;
    }

    public MmGetStatusResponse(Integer r100, Integer r101, Boolean r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r107) {
        this.objectStatus = r100;
        this.reviewStatus = r101;
        this.canModify = r102;
        this.objectVersion = r103;
        this.lastEditVersion = r104;
        this.summaryStatus = r105;
        this.agendaStatus = r106;
        this.speakerSummaryStatus = r107;
    }

    public /* synthetic */ MmGetStatusResponse(Integer r110, Integer r111, Boolean r112, Integer r113, Integer r114, Integer r115, Integer r116, Integer r117, int r118, DefaultConstructorMarker r119) {
        Integer r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Boolean r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
