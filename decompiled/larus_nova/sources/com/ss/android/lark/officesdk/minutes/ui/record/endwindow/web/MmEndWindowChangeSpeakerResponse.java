package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowChangeSpeakerResponse;", "Ljava/io/Serializable;", "isSuccess", "", "clusterId", "", "speakerInfoType", "", "larkSpeakerInfo", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmLarkSpeakerInfoToJS;", "speakerInfo", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmNonLarkSpeakerInfoToJS;", "<init>", "(ZLjava/lang/String;ILcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmLarkSpeakerInfoToJS;Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmNonLarkSpeakerInfoToJS;)V", "()Z", "getClusterId", "()Ljava/lang/String;", "getSpeakerInfoType", "()I", "getLarkSpeakerInfo", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmLarkSpeakerInfoToJS;", "getSpeakerInfo", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmNonLarkSpeakerInfoToJS;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmEndWindowChangeSpeakerResponse implements Serializable {
    public static final a Companion = null;

    @SerializedName("cluster_id")
    private final String clusterId;

    @SerializedName("is_success")
    private final boolean isSuccess;

    @SerializedName("lark_speaker_info")
    private final MmLarkSpeakerInfoToJS larkSpeakerInfo;

    @SerializedName("speaker_info")
    private final MmNonLarkSpeakerInfoToJS speakerInfo;

    @SerializedName("speaker_info_type")
    private final int speakerInfoType;

    public static final class a {
        public static MmEndWindowChangeSpeakerResponse a() {
            return new MmEndWindowChangeSpeakerResponse(false, "", 0, null, null, 24, null);
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MmEndWindowChangeSpeakerResponse copy$default(MmEndWindowChangeSpeakerResponse r100, boolean r101, String r102, int r103, MmLarkSpeakerInfoToJS r104, MmNonLarkSpeakerInfoToJS r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.isSuccess;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.clusterId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.speakerInfoType;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.larkSpeakerInfo;
    L14:
        MmLarkSpeakerInfoToJS r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.speakerInfo;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.isSuccess;
    }

    public final String component2() {
        return this.clusterId;
    }

    public final int component3() {
        return this.speakerInfoType;
    }

    public final MmLarkSpeakerInfoToJS component4() {
        return this.larkSpeakerInfo;
    }

    public final MmNonLarkSpeakerInfoToJS component5() {
        return this.speakerInfo;
    }

    public final MmEndWindowChangeSpeakerResponse copy(boolean r100, String r101, int r110, MmLarkSpeakerInfoToJS r111, MmNonLarkSpeakerInfoToJS r112) {
        Intrinsics.checkNotNullParameter(r101, "clusterId");
        return new MmEndWindowChangeSpeakerResponse(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmEndWindowChangeSpeakerResponse) == true) goto L8;
        return false;
    L8:
        MmEndWindowChangeSpeakerResponse r101 = (MmEndWindowChangeSpeakerResponse) r100;
        if (this.isSuccess == r101.isSuccess) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clusterId, r101.clusterId) == true) goto L15;
        return false;
    L15:
        if (this.speakerInfoType == r101.speakerInfoType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.larkSpeakerInfo, r101.larkSpeakerInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.speakerInfo, r101.speakerInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.isSuccess == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.clusterId.hashCode()) * 31) + this.speakerInfoType) * 31;
        MmLarkSpeakerInfoToJS r102 = this.larkSpeakerInfo;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        MmNonLarkSpeakerInfoToJS r106 = this.speakerInfo;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "MmEndWindowChangeSpeakerResponse(isSuccess=" + this.isSuccess + ", clusterId=" + this.clusterId + ", speakerInfoType=" + this.speakerInfoType + ", larkSpeakerInfo=" + this.larkSpeakerInfo + ", speakerInfo=" + this.speakerInfo + ')';
    }

    public final String getClusterId() {
        return this.clusterId;
    }

    public final MmLarkSpeakerInfoToJS getLarkSpeakerInfo() {
        return this.larkSpeakerInfo;
    }

    public final MmNonLarkSpeakerInfoToJS getSpeakerInfo() {
        return this.speakerInfo;
    }

    public final int getSpeakerInfoType() {
        return this.speakerInfoType;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public MmEndWindowChangeSpeakerResponse(boolean r100, String r101, int r102, MmLarkSpeakerInfoToJS r103, MmNonLarkSpeakerInfoToJS r104) {
        Intrinsics.checkNotNullParameter(r101, "clusterId");
        this.isSuccess = r100;
        this.clusterId = r101;
        this.speakerInfoType = r102;
        this.larkSpeakerInfo = r103;
        this.speakerInfo = r104;
    }

    public /* synthetic */ MmEndWindowChangeSpeakerResponse(boolean r100, String r101, int r110, MmLarkSpeakerInfoToJS r111, MmNonLarkSpeakerInfoToJS r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        MmLarkSpeakerInfoToJS r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        MmNonLarkSpeakerInfoToJS r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
