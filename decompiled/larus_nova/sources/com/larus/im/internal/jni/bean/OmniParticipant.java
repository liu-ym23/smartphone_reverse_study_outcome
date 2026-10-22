package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.tencent.open.SocialConstants;
import de9.q9;
import de9.r9;
import de9.s9;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 H2\u00060\u0001j\u0002`\u0002:\u0002GHB\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019B\u0097\u0001\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0018\u0010\u001dJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0012HÆ\u0003J\t\u00106\u001a\u00020\u0014HÆ\u0003J\t\u00107\u001a\u00020\u0016HÆ\u0003J\t\u00108\u001a\u00020\u0014HÆ\u0003J\u0099\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0014HÆ\u0001J\u0013\u0010:\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0012HÖ\u0001J\t\u0010>\u001a\u00020\u0004HÖ\u0001J%\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\bFR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u001fR\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001fR\u0016\u0010\u0017\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\u001f¨\u0006I"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniParticipant;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "participantId", "", "type", "Lcom/larus/im/internal/jni/bean/OmniUserType;", "role", "Lcom/larus/im/internal/jni/bean/OmniRoleType;", "conversationId", "name", "iconImage", "Lcom/larus/im/internal/jni/bean/OmniImage;", "voiceType", "Lcom/larus/im/internal/jni/bean/OmniSpeakerVoice;", SocialConstants.PARAM_APP_DESC, "ext", "sortOrder", "", "isVoiceMuted", "", "status", "Lcom/larus/im/internal/jni/bean/OmniParticipantStatus;", "canNotInteract", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniUserType;Lcom/larus/im/internal/jni/bean/OmniRoleType;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniImage;Lcom/larus/im/internal/jni/bean/OmniSpeakerVoice;Ljava/lang/String;Ljava/lang/String;IZLcom/larus/im/internal/jni/bean/OmniParticipantStatus;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/internal/jni/bean/OmniUserType;Lcom/larus/im/internal/jni/bean/OmniRoleType;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniImage;Lcom/larus/im/internal/jni/bean/OmniSpeakerVoice;Ljava/lang/String;Ljava/lang/String;IZLcom/larus/im/internal/jni/bean/OmniParticipantStatus;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getParticipantId$annotations", "()V", "getType$annotations", "getRole$annotations", "getConversationId$annotations", "getName$annotations", "getIconImage$annotations", "getVoiceType$annotations", "getDesc$annotations", "getExt$annotations", "getSortOrder$annotations", "isVoiceMuted$annotations", "getStatus$annotations", "getCanNotInteract$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniParticipant implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final boolean canNotInteract;
    public final String conversationId;
    public final String desc;
    public final String ext;
    public final OmniImage iconImage;
    public final boolean isVoiceMuted;
    public final String name;
    public final String participantId;
    public final OmniRoleType role;
    public final int sortOrder;
    public final OmniParticipantStatus status;
    public final OmniUserType type;
    public final OmniSpeakerVoice voiceType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniParticipant$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniParticipant;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniParticipant> serializer() {
            return OmniParticipant$$serializer.INSTANCE;
        }
    }

    public OmniParticipant() {
        this(null, null, null, null, null, null, null, null, null, 0, false, null, false, 8191, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniUserType.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return OmniRoleType.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        return OmniParticipantStatus.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$1();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniParticipant copy$default(OmniParticipant r110, String r111, OmniUserType r112, OmniRoleType r113, String r114, String r115, OmniImage r210, OmniSpeakerVoice r211, String r212, String r213, int r214, boolean r215, OmniParticipantStatus r216, boolean r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.participantId;
    L7:
        if ((r218 & 2) == 0) goto L9;
        OmniUserType r101 = r110.type;
    L11:
        if ((r218 & 4) == 0) goto L13;
        OmniRoleType r102 = r110.role;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.conversationId;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = r110.name;
    L23:
        if ((r218 & 32) == 0) goto L25;
        OmniImage r105 = r110.iconImage;
    L27:
        if ((r218 & 64) == 0) goto L29;
        OmniSpeakerVoice r106 = r110.voiceType;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.desc;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.ext;
    L39:
        if ((r218 & 512) == 0) goto L41;
        int r117 = r110.sortOrder;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        boolean r118 = r110.isVoiceMuted;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        OmniParticipantStatus r119 = r110.status;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        boolean r108 = r110.canNotInteract;
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

    @SerialName("can_not_interact")
    public static /* synthetic */ void getCanNotInteract$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName(SocialConstants.PARAM_APP_DESC)
    public static /* synthetic */ void getDesc$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("icon_image")
    public static /* synthetic */ void getIconImage$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("participant_id")
    public static /* synthetic */ void getParticipantId$annotations() {
    }

    @SerialName("role")
    public static /* synthetic */ void getRole$annotations() {
    }

    @SerialName("sort_order")
    public static /* synthetic */ void getSortOrder$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("voice_type")
    public static /* synthetic */ void getVoiceType$annotations() {
    }

    @SerialName("is_voice_muted")
    public static /* synthetic */ void isVoiceMuted$annotations() {
    }

    public final String component1() {
        return this.participantId;
    }

    public final int component10() {
        return this.sortOrder;
    }

    public final boolean component11() {
        return this.isVoiceMuted;
    }

    public final OmniParticipantStatus component12() {
        return this.status;
    }

    public final boolean component13() {
        return this.canNotInteract;
    }

    public final OmniUserType component2() {
        return this.type;
    }

    public final OmniRoleType component3() {
        return this.role;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final String component5() {
        return this.name;
    }

    public final OmniImage component6() {
        return this.iconImage;
    }

    public final OmniSpeakerVoice component7() {
        return this.voiceType;
    }

    public final String component8() {
        return this.desc;
    }

    public final String component9() {
        return this.ext;
    }

    public final OmniParticipant copy(String r110, OmniUserType r111, OmniRoleType r112, String r113, String r210, OmniImage r211, OmniSpeakerVoice r212, String r213, String r214, int r215, boolean r216, OmniParticipantStatus r217, boolean r218) {
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "role");
        Intrinsics.checkNotNullParameter(r217, "status");
        return new OmniParticipant(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniParticipant) == true) goto L8;
        return false;
    L8:
        OmniParticipant r101 = (OmniParticipant) r100;
        if (Intrinsics.areEqual(this.participantId, r101.participantId) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (this.role == r101.role) goto L18;
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
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L36;
        return false;
    L36:
        if (this.sortOrder == r101.sortOrder) goto L39;
        return false;
    L39:
        if (this.isVoiceMuted == r101.isVoiceMuted) goto L42;
        return false;
    L42:
        if (this.status == r101.status) goto L45;
        return false;
    L45:
        if (this.canNotInteract == r101.canNotInteract) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r100 = this.participantId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.type.hashCode()) * 31) + this.role.hashCode()) * 31;
        String r104 = this.conversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        OmniImage r110 = this.iconImage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        OmniSpeakerVoice r113 = this.voiceType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.desc;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.ext;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        int r120 = (((r118 + r101) * 31) + this.sortOrder) * 31;
        int r121 = 1231;
        if (this.isVoiceMuted == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (((r120 + r122) * 31) + this.status.hashCode()) * 31;
        if (this.canNotInteract == true) goto L39;
        r121 = 1237;
    L39:
        return r123 + r121;
    L33:
        r122 = 1237;
        goto L34
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
        return "OmniParticipant(participantId=" + this.participantId + ", type=" + this.type + ", role=" + this.role + ", conversationId=" + this.conversationId + ", name=" + this.name + ", iconImage=" + this.iconImage + ", voiceType=" + this.voiceType + ", desc=" + this.desc + ", ext=" + this.ext + ", sortOrder=" + this.sortOrder + ", isVoiceMuted=" + this.isVoiceMuted + ", status=" + this.status + ", canNotInteract=" + this.canNotInteract + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, LazyKt.lazy(r100, new q9()), LazyKt.lazy(r100, new r9()), null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new s9()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniParticipant r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.participantId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeSerializableElement(r102, 1, r103[1].getValue(), r100.type);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeSerializableElement(r102, 2, r103[2].getValue(), r100.role);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.conversationId);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.name);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, OmniImage$$serializer.INSTANCE, r100.iconImage);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, OmniSpeakerVoice$$serializer.INSTANCE, r100.voiceType);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.desc);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.ext);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeIntElement(r102, 9, r100.sortOrder);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeBooleanElement(r102, 10, r100.isVoiceMuted);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r101.encodeSerializableElement(r102, 11, r103[11].getValue(), r100.status);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        r104 = true;
    L116:
        if (r104 == false) goto L119;
        r101.encodeBooleanElement(r102, 12, r100.canNotInteract);
        return;
    L119:
        return;
    L114:
        if (r100.canNotInteract == false) goto L116;
    L105:
        if (r100.status != OmniParticipantStatus.STATUS_ACTIVE) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.isVoiceMuted == true) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.sortOrder != 0) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.ext != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.desc != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.voiceType != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.iconImage != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.name != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.conversationId != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.role != OmniRoleType.ROLE_TYPE_UNKNOWN) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.type != OmniUserType.UNKNOWN) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.participantId != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniParticipant(String r100, OmniUserType r101, OmniRoleType r102, String r103, String r104, OmniImage r105, OmniSpeakerVoice r106, String r107, String r110, int r111, boolean r112, OmniParticipantStatus r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "role");
        Intrinsics.checkNotNullParameter(r113, "status");
        this.participantId = r100;
        this.type = r101;
        this.role = r102;
        this.conversationId = r103;
        this.name = r104;
        this.iconImage = r105;
        this.voiceType = r106;
        this.desc = r107;
        this.ext = r110;
        this.sortOrder = r111;
        this.isVoiceMuted = r112;
        this.status = r113;
        this.canNotInteract = r114;
    }

    public /* synthetic */ OmniParticipant(int r100, String r101, OmniUserType r102, OmniRoleType r103, String r110, String r111, OmniImage r112, OmniSpeakerVoice r113, String r114, String r115, int r116, boolean r117, OmniParticipantStatus r118, boolean r119, q2 r210) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniParticipant$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.participantId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        OmniUserType r104 = OmniUserType.UNKNOWN;
    L12:
        this.type = r104;
        if ((r100 & 4) != 0) goto L15;
        OmniRoleType r105 = OmniRoleType.ROLE_TYPE_UNKNOWN;
    L16:
        this.role = r105;
        if ((r100 & 8) != 0) goto L19;
        this.conversationId = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.name = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.iconImage = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.voiceType = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.desc = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.ext = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.sortOrder = 0;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.isVoiceMuted = false;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        OmniParticipantStatus r106 = OmniParticipantStatus.STATUS_ACTIVE;
    L52:
        this.status = r106;
        if ((r100 & 4096) != 0) goto L55;
        this.canNotInteract = false;
        return;
    L55:
        this.canNotInteract = r119;
        return;
    L51:
        r106 = r118;
        goto L52
    L47:
        this.isVoiceMuted = r117;
        goto L49
    L43:
        this.sortOrder = r116;
        goto L45
    L39:
        this.ext = r115;
        goto L41
    L35:
        this.desc = r114;
        goto L37
    L31:
        this.voiceType = r113;
        goto L33
    L27:
        this.iconImage = r112;
        goto L29
    L23:
        this.name = r111;
        goto L25
    L19:
        this.conversationId = r110;
        goto L21
    L15:
        r105 = r103;
        goto L16
    L11:
        r104 = r102;
        goto L12
    L7:
        this.participantId = r101;
        goto L9
    }

    public /* synthetic */ OmniParticipant(String r110, OmniUserType r111, OmniRoleType r112, String r113, String r114, OmniImage r210, OmniSpeakerVoice r211, String r212, String r213, int r214, boolean r215, OmniParticipantStatus r216, boolean r217, int r218, DefaultConstructorMarker r219) {
        String r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        OmniUserType r102 = OmniUserType.UNKNOWN;
    L11:
        if ((r218 & 4) == 0) goto L13;
        OmniRoleType r103 = OmniRoleType.ROLE_TYPE_UNKNOWN;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        OmniImage r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        OmniSpeakerVoice r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r218 & 256) != 0) goto L38;
        r100 = r213;
    L38:
        boolean r115 = false;
        if ((r218 & 512) == 0) goto L41;
        int r116 = 0;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        boolean r117 = false;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        OmniParticipantStatus r118 = OmniParticipantStatus.STATUS_ACTIVE;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r115 = r217;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r116, r117, r118, r115);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
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
