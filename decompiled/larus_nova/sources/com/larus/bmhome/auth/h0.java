package com.larus.bmhome.auth;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/larus/bmhome/auth/CoreLaunchInfo;", "", "minorInfoData", "Lcom/larus/bmhome/auth/MinorInfoData;", "landingConfig", "Lcom/larus/bmhome/auth/LandingConfig;", "degradeStatus", "", "assistantBotId", "", "secUserId", "tourAbParam", "Lcom/larus/bmhome/auth/TouristModeABParam;", "conversationModeConfig", "Lcom/larus/bmhome/auth/ConversationModeConfig;", "mobileColdStartRoute", "Lcom/larus/bmhome/auth/MobileColdStartRoute;", "<init>", "(Lcom/larus/bmhome/auth/MinorInfoData;Lcom/larus/bmhome/auth/LandingConfig;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/auth/TouristModeABParam;Lcom/larus/bmhome/auth/ConversationModeConfig;Lcom/larus/bmhome/auth/MobileColdStartRoute;)V", "getMinorInfoData", "()Lcom/larus/bmhome/auth/MinorInfoData;", "getLandingConfig", "()Lcom/larus/bmhome/auth/LandingConfig;", "getDegradeStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAssistantBotId", "()Ljava/lang/String;", "getSecUserId", "getTourAbParam", "()Lcom/larus/bmhome/auth/TouristModeABParam;", "getConversationModeConfig", "()Lcom/larus/bmhome/auth/ConversationModeConfig;", "getMobileColdStartRoute", "()Lcom/larus/bmhome/auth/MobileColdStartRoute;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/larus/bmhome/auth/MinorInfoData;Lcom/larus/bmhome/auth/LandingConfig;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/auth/TouristModeABParam;Lcom/larus/bmhome/auth/ConversationModeConfig;Lcom/larus/bmhome/auth/MobileColdStartRoute;)Lcom/larus/bmhome/auth/CoreLaunchInfo;", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h0 {

    @SerializedName("assistant_bot_id")
    private final String assistantBotId;

    @SerializedName("conversation_mode_config")
    private final ConversationModeConfig conversationModeConfig;

    @SerializedName("degrade_status")
    private final Integer degradeStatus;

    @SerializedName("landing_config")
    private final LandingConfig landingConfig;

    @SerializedName("minor_info_data")
    private final MinorInfoData minorInfoData;

    @SerializedName("mobile_cold_start_route")
    private final d1 mobileColdStartRoute;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("tour_ab_param")
    private final TouristModeABParam tourAbParam;

    public h0() {
        this(null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.minorInfoData, r101.minorInfoData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.landingConfig, r101.landingConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.degradeStatus, r101.degradeStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.assistantBotId, r101.assistantBotId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.secUserId, r101.secUserId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tourAbParam, r101.tourAbParam) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.conversationModeConfig, r101.conversationModeConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mobileColdStartRoute, r101.mobileColdStartRoute) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        MinorInfoData r100 = this.minorInfoData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        LandingConfig r104 = this.landingConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.degradeStatus;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.assistantBotId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.secUserId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        TouristModeABParam r116 = this.tourAbParam;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ConversationModeConfig r119 = this.conversationModeConfig;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        d1 r122 = this.mobileColdStartRoute;
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

    public final String toString() {
        return "CoreLaunchInfo(minorInfoData=" + this.minorInfoData + ", landingConfig=" + this.landingConfig + ", degradeStatus=" + this.degradeStatus + ", assistantBotId=" + this.assistantBotId + ", secUserId=" + this.secUserId + ", tourAbParam=" + this.tourAbParam + ", conversationModeConfig=" + this.conversationModeConfig + ", mobileColdStartRoute=" + this.mobileColdStartRoute + ')';
    }

    public final String b() {
        return this.assistantBotId;
    }

    public final ConversationModeConfig c() {
        return this.conversationModeConfig;
    }

    public final Integer d() {
        return this.degradeStatus;
    }

    public final LandingConfig e() {
        return this.landingConfig;
    }

    public final MinorInfoData f() {
        return this.minorInfoData;
    }

    public final d1 g() {
        return this.mobileColdStartRoute;
    }

    public final String h() {
        return this.secUserId;
    }

    public final TouristModeABParam i() {
        return this.tourAbParam;
    }

    public static h0 a(h0 r110, String r111, ConversationModeConfig r112, int r113) {
        d1 r100 = null;
        if ((r113 & 1) == 0) goto L5;
        MinorInfoData r101 = r110.minorInfoData;
    L7:
        if ((r113 & 2) == 0) goto L9;
        LandingConfig r102 = r110.landingConfig;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Integer r103 = r110.degradeStatus;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r104 = r110.assistantBotId;
    L19:
        if ((r113 & 16) == 0) goto L21;
        r111 = r110.secUserId;
    L21:
        String r105 = r111;
        if ((r113 & 32) == 0) goto L24;
        TouristModeABParam r106 = r110.tourAbParam;
    L26:
        if ((r113 & 64) == 0) goto L28;
        r112 = r110.conversationModeConfig;
    L28:
        ConversationModeConfig r107 = r112;
        if ((r113 & 128) == 0) goto L32;
        r100 = r110.mobileColdStartRoute;
    L32:
        return new h0(r101, r102, r103, r104, r105, r106, r107, r100);
    L24:
        r106 = null;
        goto L26
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ h0(MinorInfoData r110, LandingConfig r111, Integer r112, String r113, String r114, TouristModeABParam r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        MinorInfoData r100 = null;
    L7:
        if ((r116 & 2) == 0) goto L9;
        LandingConfig r101 = null;
    L11:
        if ((r116 & 4) == 0) goto L13;
        Integer r102 = Integer.valueOf(DegradeStatus.DEFAULT.getValue());
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r116 & 32) == 0) goto L25;
        TouristModeABParam r105 = null;
    L26:
        this(r100, r101, r102, r103, r104, r105, null, null);
        return;
    L25:
        r105 = r115;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public h0(MinorInfoData r100, LandingConfig r101, Integer r102, String r103, String r104, TouristModeABParam r105, ConversationModeConfig r106, d1 r107) {
        this.minorInfoData = r100;
        this.landingConfig = r101;
        this.degradeStatus = r102;
        this.assistantBotId = r103;
        this.secUserId = r104;
        this.tourAbParam = r105;
        this.conversationModeConfig = r106;
        this.mobileColdStartRoute = r107;
    }
}
