package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\rHÆ\u0003JV\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\rHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00068"}, d2 = {"Lcom/larus/livetutor/api/idl/LiveTutorV2Params;", "Ljava/io/Serializable;", "tutorEntranceType", "", "liveTutorId", "", "doubaoSuggestQueryParams", "Lcom/larus/livetutor/api/idl/DoubaoSuggestQueryParams;", "doubaoActionbarPageQueryParams", "Lcom/larus/livetutor/api/idl/DoubaoActionbarPageQueryParams;", "userSetting", "Lcom/larus/livetutor/api/idl/UserSetting;", "enterMethod", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/DoubaoSuggestQueryParams;Lcom/larus/livetutor/api/idl/DoubaoActionbarPageQueryParams;Lcom/larus/livetutor/api/idl/UserSetting;Ljava/lang/String;)V", "getTutorEntranceType", "()Ljava/lang/Integer;", "setTutorEntranceType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLiveTutorId", "()Ljava/lang/Long;", "setLiveTutorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDoubaoSuggestQueryParams", "()Lcom/larus/livetutor/api/idl/DoubaoSuggestQueryParams;", "setDoubaoSuggestQueryParams", "(Lcom/larus/livetutor/api/idl/DoubaoSuggestQueryParams;)V", "getDoubaoActionbarPageQueryParams", "()Lcom/larus/livetutor/api/idl/DoubaoActionbarPageQueryParams;", "setDoubaoActionbarPageQueryParams", "(Lcom/larus/livetutor/api/idl/DoubaoActionbarPageQueryParams;)V", "getUserSetting", "()Lcom/larus/livetutor/api/idl/UserSetting;", "setUserSetting", "(Lcom/larus/livetutor/api/idl/UserSetting;)V", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/DoubaoSuggestQueryParams;Lcom/larus/livetutor/api/idl/DoubaoActionbarPageQueryParams;Lcom/larus/livetutor/api/idl/UserSetting;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/LiveTutorV2Params;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorV2Params implements Serializable {

    @SerializedName("doubao_actionbar_page_query_params")
    private DoubaoActionbarPageQueryParams doubaoActionbarPageQueryParams;

    @SerializedName("doubao_suggest_query_params")
    private DoubaoSuggestQueryParams doubaoSuggestQueryParams;

    @SerializedName("enter_method")
    private String enterMethod;

    @SerializedName("live_tutor_id")
    private Long liveTutorId;

    @SerializedName("tutor_entrance_type")
    private Integer tutorEntranceType;

    @SerializedName("user_setting")
    private UserSetting userSetting;

    public LiveTutorV2Params() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ LiveTutorV2Params copy$default(LiveTutorV2Params r100, Integer r101, Long r102, DoubaoSuggestQueryParams r103, DoubaoActionbarPageQueryParams r104, UserSetting r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.tutorEntranceType;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.liveTutorId;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.doubaoSuggestQueryParams;
    L11:
        DoubaoSuggestQueryParams r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.doubaoActionbarPageQueryParams;
    L14:
        DoubaoActionbarPageQueryParams r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.userSetting;
    L17:
        UserSetting r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.enterMethod;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Integer component1() {
        return this.tutorEntranceType;
    }

    public final Long component2() {
        return this.liveTutorId;
    }

    public final DoubaoSuggestQueryParams component3() {
        return this.doubaoSuggestQueryParams;
    }

    public final DoubaoActionbarPageQueryParams component4() {
        return this.doubaoActionbarPageQueryParams;
    }

    public final UserSetting component5() {
        return this.userSetting;
    }

    public final String component6() {
        return this.enterMethod;
    }

    public final LiveTutorV2Params copy(Integer r100, Long r110, DoubaoSuggestQueryParams r111, DoubaoActionbarPageQueryParams r112, UserSetting r113, String r114) {
        return new LiveTutorV2Params(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorV2Params) == true) goto L8;
        return false;
    L8:
        LiveTutorV2Params r101 = (LiveTutorV2Params) r100;
        if (Intrinsics.areEqual(this.tutorEntranceType, r101.tutorEntranceType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveTutorId, r101.liveTutorId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.doubaoSuggestQueryParams, r101.doubaoSuggestQueryParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.doubaoActionbarPageQueryParams, r101.doubaoActionbarPageQueryParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userSetting, r101.userSetting) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.tutorEntranceType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.liveTutorId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        DoubaoSuggestQueryParams r107 = this.doubaoSuggestQueryParams;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        DoubaoActionbarPageQueryParams r110 = this.doubaoActionbarPageQueryParams;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        UserSetting r113 = this.userSetting;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.enterMethod;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "LiveTutorV2Params(tutorEntranceType=" + this.tutorEntranceType + ", liveTutorId=" + this.liveTutorId + ", doubaoSuggestQueryParams=" + this.doubaoSuggestQueryParams + ", doubaoActionbarPageQueryParams=" + this.doubaoActionbarPageQueryParams + ", userSetting=" + this.userSetting + ", enterMethod=" + this.enterMethod + ')';
    }

    public final DoubaoActionbarPageQueryParams getDoubaoActionbarPageQueryParams() {
        return this.doubaoActionbarPageQueryParams;
    }

    public final DoubaoSuggestQueryParams getDoubaoSuggestQueryParams() {
        return this.doubaoSuggestQueryParams;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Long getLiveTutorId() {
        return this.liveTutorId;
    }

    public final Integer getTutorEntranceType() {
        return this.tutorEntranceType;
    }

    public final UserSetting getUserSetting() {
        return this.userSetting;
    }

    public final void setDoubaoActionbarPageQueryParams(DoubaoActionbarPageQueryParams r100) {
        this.doubaoActionbarPageQueryParams = r100;
    }

    public final void setDoubaoSuggestQueryParams(DoubaoSuggestQueryParams r100) {
        this.doubaoSuggestQueryParams = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setLiveTutorId(Long r100) {
        this.liveTutorId = r100;
    }

    public final void setTutorEntranceType(Integer r100) {
        this.tutorEntranceType = r100;
    }

    public final void setUserSetting(UserSetting r100) {
        this.userSetting = r100;
    }

    public LiveTutorV2Params(Integer r100, Long r101, DoubaoSuggestQueryParams r102, DoubaoActionbarPageQueryParams r103, UserSetting r104, String r105) {
        this.tutorEntranceType = r100;
        this.liveTutorId = r101;
        this.doubaoSuggestQueryParams = r102;
        this.doubaoActionbarPageQueryParams = r103;
        this.userSetting = r104;
        this.enterMethod = r105;
    }

    public /* synthetic */ LiveTutorV2Params(Integer r100, Long r101, DoubaoSuggestQueryParams r102, DoubaoActionbarPageQueryParams r103, UserSetting r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Integer r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Long r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        DoubaoSuggestQueryParams r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        DoubaoActionbarPageQueryParams r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        UserSetting r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
