package com.larus.im.bean.conversation;

import com.larus.im.bean.bot.SpeakerVoice;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u009f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00104\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00106\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010&J¨\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0006HÖ\u0001J\t\u0010=\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001aR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010'\u001a\u0004\b\u0011\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b(\u0010\u001aR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010'\u001a\u0004\b)\u0010&¨\u0006>"}, d2 = {"Lcom/larus/im/bean/conversation/ParticipantModel;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "participantId", "", "type", "", "role", "conversationId", "name", "iconImage", "Lcom/larus/im/bean/conversation/IconImage;", "voiceType", "Lcom/larus/im/bean/bot/SpeakerVoice;", "description", "ext", "sortOrder", "isVoiceMuted", "", "status", "canNotInteract", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/IconImage;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getParticipantId", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRole", "getConversationId", "getName", "getIconImage", "()Lcom/larus/im/bean/conversation/IconImage;", "getVoiceType", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "getDescription", "getExt", "getSortOrder", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus", "getCanNotInteract", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/IconImage;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/im/bean/conversation/ParticipantModel;", "equals", "other", "", "hashCode", "toString", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ParticipantModel implements Serializable {
    private final Boolean canNotInteract;
    private final String conversationId;
    private final String description;
    private final String ext;
    private final IconImage iconImage;
    private final Boolean isVoiceMuted;
    private final String name;
    private final String participantId;
    private final Integer role;
    private final Integer sortOrder;
    private final Integer status;
    private final Integer type;
    private final SpeakerVoice voiceType;

    public static /* synthetic */ ParticipantModel copy$default(ParticipantModel r110, String r111, Integer r112, Integer r113, String r114, String r115, IconImage r210, SpeakerVoice r211, String r212, String r213, Integer r214, Boolean r215, Integer r216, Boolean r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.participantId;
    L7:
        if ((r218 & 2) == 0) goto L9;
        Integer r101 = r110.type;
    L11:
        if ((r218 & 4) == 0) goto L13;
        Integer r102 = r110.role;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.conversationId;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = r110.name;
    L23:
        if ((r218 & 32) == 0) goto L25;
        IconImage r105 = r110.iconImage;
    L27:
        if ((r218 & 64) == 0) goto L29;
        SpeakerVoice r106 = r110.voiceType;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.description;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.ext;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Integer r117 = r110.sortOrder;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Boolean r118 = r110.isVoiceMuted;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Integer r119 = r110.status;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        Boolean r108 = r110.canNotInteract;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.participantId;
    }

    public final Integer component10() {
        return this.sortOrder;
    }

    public final Boolean component11() {
        return this.isVoiceMuted;
    }

    public final Integer component12() {
        return this.status;
    }

    public final Boolean component13() {
        return this.canNotInteract;
    }

    public final Integer component2() {
        return this.type;
    }

    public final Integer component3() {
        return this.role;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final String component5() {
        return this.name;
    }

    public final IconImage component6() {
        return this.iconImage;
    }

    public final SpeakerVoice component7() {
        return this.voiceType;
    }

    public final String component8() {
        return this.description;
    }

    public final String component9() {
        return this.ext;
    }

    public final ParticipantModel copy(String r110, @UserType Integer r111, @RoleType Integer r112, String r113, String r210, IconImage r211, SpeakerVoice r212, String r213, String r214, Integer r215, Boolean r216, @ParticipantStatus Integer r217, Boolean r218) {
        Intrinsics.checkNotNullParameter(r110, "participantId");
        return new ParticipantModel(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ParticipantModel) == true) goto L8;
        return false;
    L8:
        ParticipantModel r101 = (ParticipantModel) r100;
        if (Intrinsics.areEqual(this.participantId, r101.participantId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.role, r101.role) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconImage, r101.iconImage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.voiceType, r101.voiceType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sortOrder, r101.sortOrder) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isVoiceMuted, r101.isVoiceMuted) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.canNotInteract, r101.canNotInteract) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r100 = this.participantId.hashCode() * 31;
        Integer r101 = this.type;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.role;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.conversationId;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.name;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        IconImage r114 = this.iconImage;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        SpeakerVoice r117 = this.voiceType;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.description;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.ext;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.sortOrder;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Boolean r129 = this.isVoiceMuted;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Integer r132 = this.status;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        Boolean r135 = this.canNotInteract;
        if (r135 == null) goto L51;
        r102 = r135.hashCode();
    L51:
        return r134 + r102;
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ParticipantModel(participantId=" + this.participantId + ", type=" + this.type + ", role=" + this.role + ", conversationId=" + this.conversationId + ", name=" + this.name + ", iconImage=" + this.iconImage + ", voiceType=" + this.voiceType + ", description=" + this.description + ", ext=" + this.ext + ", sortOrder=" + this.sortOrder + ", isVoiceMuted=" + this.isVoiceMuted + ", status=" + this.status + ", canNotInteract=" + this.canNotInteract + ')';
    }

    public final Boolean getCanNotInteract() {
        return this.canNotInteract;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getExt() {
        return this.ext;
    }

    public final IconImage getIconImage() {
        return this.iconImage;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParticipantId() {
        return this.participantId;
    }

    public final Integer getRole() {
        return this.role;
    }

    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getType() {
        return this.type;
    }

    public final SpeakerVoice getVoiceType() {
        return this.voiceType;
    }

    public final Boolean isVoiceMuted() {
        return this.isVoiceMuted;
    }

    public ParticipantModel(String r100, @UserType Integer r101, @RoleType Integer r102, String r103, String r104, IconImage r105, SpeakerVoice r106, String r107, String r110, Integer r111, Boolean r112, @ParticipantStatus Integer r113, Boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "participantId");
        this.participantId = r100;
        this.type = r101;
        this.role = r102;
        this.conversationId = r103;
        this.name = r104;
        this.iconImage = r105;
        this.voiceType = r106;
        this.description = r107;
        this.ext = r110;
        this.sortOrder = r111;
        this.isVoiceMuted = r112;
        this.status = r113;
        this.canNotInteract = r114;
    }

    public /* synthetic */ ParticipantModel(String r110, Integer r111, Integer r112, String r113, String r114, IconImage r115, SpeakerVoice r210, String r211, String r212, Integer r213, Boolean r214, Integer r215, Boolean r216, int r217, DefaultConstructorMarker r218) {
        Integer r100 = null;
        if ((r217 & 2) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r217 & 4) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r217 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r217 & 16) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r217 & 32) == 0) goto L21;
        IconImage r105 = null;
    L23:
        if ((r217 & 64) == 0) goto L25;
        SpeakerVoice r106 = null;
    L27:
        if ((r217 & 128) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r217 & 256) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r217 & 512) == 0) goto L37;
        Integer r116 = null;
    L39:
        if ((r217 & 1024) == 0) goto L41;
        Boolean r117 = Boolean.TRUE;
    L43:
        if ((r217 & 2048) != 0) goto L47;
        r100 = r215;
    L47:
        if ((r217 & 4096) == 0) goto L49;
        Boolean r109 = Boolean.FALSE;
    L50:
        this(r110, r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r100, r109);
        return;
    L49:
        r109 = r216;
        goto L50
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r115;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
