package com.larus.im.internal.database.entity;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.internal.jni.bean.OmniParticipantStatus;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002FGB\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\u0014B\u009b\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010&J\t\u00106\u001a\u00020\u0006HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010&J¤\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0006HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010'\u001a\u0004\b\u000e\u0010&R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010'\u001a\u0004\b*\u0010&¨\u0006H"}, d2 = {"Lcom/larus/im/internal/database/entity/ParticipantEntity;", "", "participantId", "", "conversationId", "sortOrder", "", "type", "role", "name", "iconImage", "voiceType", "ext", "description", "isVoiceMuted", "", "status", "canNotInteract", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/Boolean;)V", "()V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getParticipantId", "()Ljava/lang/String;", "getConversationId", "getSortOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "getRole", "getName", "getIconImage", "getVoiceType", "getExt", "getDescription", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus", "()I", "getCanNotInteract", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/Boolean;)Lcom/larus/im/internal/database/entity/ParticipantEntity;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "Companion", "$serializer", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ParticipantEntity {
    public static final b Companion = null;
    private static final String DEFAULT_PARTICIPANT_ID = "";
    private final Boolean canNotInteract;
    private final String conversationId;
    private final String description;
    private final String ext;
    private final String iconImage;
    private final Boolean isVoiceMuted;
    private final String name;
    private final String participantId;
    private final Integer role;
    private final Integer sortOrder;
    private final int status;
    private final Integer type;
    private final String voiceType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ParticipantEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f348121a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f348122b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f348122b;
        }

        static {
            a r100 = new a();
            f348121a = r100;
            g2 r101 = new g2("com.larus.im.internal.database.entity.ParticipantEntity", r100, 13);
            r101.j("participantId", true);
            r101.j("conversationId", true);
            r101.j("sortOrder", true);
            r101.j("type", true);
            r101.j("role", true);
            r101.j("name", true);
            r101.j("iconImage", true);
            r101.j("voiceType", true);
            r101.j("ext", true);
            r101.j("description", true);
            r101.j("isVoiceMuted", true);
            r101.j("status", true);
            r101.j("canNotInteract", true);
            f348122b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            i r102 = i.f520705a;
            return new d[]{r100, r100, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), r101, kuc.a.d(r102)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f348122b;
            c r101 = r310.beginStructure(r100);
            int r102 = 9;
            int r103 = 10;
            int r110 = 11;
            Integer r104 = null;
            if (r101.decodeSequentially() == false) goto L5;
            String r105 = r101.decodeStringElement(r100, 0);
            String r111 = r101.decodeStringElement(r100, 1);
            w0 r112 = w0.f520792a;
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 2, r112, null);
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r112, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r112, null);
            v2 r115 = v2.f520790a;
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 5, r115, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 6, r115, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 7, r115, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 8, r115, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 9, r115, null);
            i r118 = i.f520705a;
            Boolean r119 = (Boolean) r101.decodeNullableSerializableElement(r100, 10, r118, null);
            int r120 = r101.decodeIntElement(r100, 11);
            Boolean r210 = (Boolean) r101.decodeNullableSerializableElement(r100, 12, r118, null);
            Integer r121 = r106;
            String r211 = r107;
            String r212 = r108;
            String r213 = r109;
            String r214 = r117;
            Boolean r215 = r119;
            int r216 = r120;
            Integer r122 = r113;
            Integer r217 = r114;
            String r218 = r116;
            String r123 = r111;
            int r124 = 8191;
            String r125 = r105;
        L33:
            r101.endStructure(r100);
            return new ParticipantEntity(r124, r125, r123, r122, r121, r217, r211, r212, r213, r218, r214, r215, r216, r210, null);
        L5:
            Integer r126 = null;
            Boolean r127 = null;
            String r128 = null;
            String r129 = null;
            Boolean r130 = null;
            String r131 = null;
            String r132 = null;
            Integer r219 = null;
            r212 = null;
            String r220 = null;
            String r221 = null;
            int r133 = 0;
            int r222 = 0;
            boolean r223 = true;
        L6:
            if (r223 == false) goto L32;
            int r134 = r101.decodeElementIndex(r100);
            switch(r134) {
                case -1: goto L31;
                case 0: goto L28;
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L23;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r134);
        L31:
            r102 = 9;
            r103 = 10;
            r110 = 11;
            r223 = false;
            goto L6
        L11:
            r127 = (Boolean) r101.decodeNullableSerializableElement(r100, 12, i.f520705a, r127);
            r133 = r133 | 4096;
            goto L6
        L12:
            r222 = r101.decodeIntElement(r100, r110);
            r133 = r133 | 2048;
            goto L6
        L13:
            r130 = (Boolean) r101.decodeNullableSerializableElement(r100, r103, i.f520705a, r130);
            r133 = r133 | 1024;
        L17:
            r212 = r212;
        L22:
            r219 = r219;
        L29:
            r212 = r212;
            r219 = r219;
            r102 = 9;
            r103 = 10;
            r110 = 11;
            goto L6
        L14:
            r128 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r128);
            r133 = r133 | 512;
            goto L17
        L15:
            r131 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r131);
            r133 = r133 | 256;
            goto L17
        L16:
            r129 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r129);
            r133 = r133 | 128;
            goto L17
        L18:
            r212 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r212);
            r133 = r133 | 64;
            goto L22
        L20:
            r212 = r212;
            r132 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r132);
            r133 = r133 | 32;
            goto L22
        L21:
            r212 = r212;
            r219 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r219);
            r133 = r133 | 16;
            goto L22
        L23:
            r219 = r219;
            r212 = r212;
            r126 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r126);
            r133 = r133 | 8;
            goto L29
        L25:
            r104 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, r104);
            r133 = r133 | 4;
            goto L29
        L26:
            r220 = r101.decodeStringElement(r100, 1);
            r133 = r133 | 2;
            goto L29
        L28:
            r219 = r219;
            r212 = r212;
            r133 = r133 | 1;
            r221 = r101.decodeStringElement(r100, 0);
            goto L29
        L32:
            r121 = r126;
            r122 = r104;
            r210 = r127;
            r213 = r129;
            r217 = r219;
            r211 = r132;
            r123 = r220;
            r125 = r221;
            r216 = r222;
            r214 = r128;
            r124 = r133;
            r215 = r130;
            r218 = r131;
            goto L33
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ParticipantEntity r102 = (ParticipantEntity) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f348122b;
            muc.d r104 = r100.beginStructure(r103);
            ParticipantEntity.write$Self$omnisdk_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ParticipantEntity> serializer() {
            return a.f348121a;
        }
    }

    public static /* synthetic */ ParticipantEntity copy$default(ParticipantEntity r110, String r111, String r112, Integer r113, Integer r114, Integer r115, String r210, String r211, String r212, String r213, String r214, Boolean r215, int r216, Boolean r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.participantId;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.conversationId;
    L11:
        if ((r218 & 4) == 0) goto L13;
        Integer r102 = r110.sortOrder;
    L15:
        if ((r218 & 8) == 0) goto L17;
        Integer r103 = r110.type;
    L19:
        if ((r218 & 16) == 0) goto L21;
        Integer r104 = r110.role;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.name;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r106 = r110.iconImage;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.voiceType;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.ext;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r117 = r110.description;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Boolean r118 = r110.isVoiceMuted;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        int r119 = r110.status;
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

    public final String component10() {
        return this.description;
    }

    public final Boolean component11() {
        return this.isVoiceMuted;
    }

    public final int component12() {
        return this.status;
    }

    public final Boolean component13() {
        return this.canNotInteract;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final Integer component3() {
        return this.sortOrder;
    }

    public final Integer component4() {
        return this.type;
    }

    public final Integer component5() {
        return this.role;
    }

    public final String component6() {
        return this.name;
    }

    public final String component7() {
        return this.iconImage;
    }

    public final String component8() {
        return this.voiceType;
    }

    public final String component9() {
        return this.ext;
    }

    public final ParticipantEntity copy(String r110, String r111, Integer r112, Integer r113, Integer r210, String r211, String r212, String r213, String r214, String r215, Boolean r216, int r217, Boolean r218) {
        Intrinsics.checkNotNullParameter(r110, "participantId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        return new ParticipantEntity(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ParticipantEntity) == true) goto L8;
        return false;
    L8:
        ParticipantEntity r101 = (ParticipantEntity) r100;
        if (Intrinsics.areEqual(this.participantId, r101.participantId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sortOrder, r101.sortOrder) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.role, r101.role) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.iconImage, r101.iconImage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.voiceType, r101.voiceType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isVoiceMuted, r101.isVoiceMuted) == true) goto L42;
        return false;
    L42:
        if (this.status == r101.status) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.canNotInteract, r101.canNotInteract) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.participantId.hashCode() * 31) + this.conversationId.hashCode()) * 31;
        Integer r101 = this.sortOrder;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.type;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.role;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.name;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.iconImage;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.voiceType;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.ext;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.description;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Boolean r126 = this.isVoiceMuted;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (((r125 + r127) * 31) + this.status) * 31;
        Boolean r129 = this.canNotInteract;
        if (r129 == null) goto L43;
        r102 = r129.hashCode();
    L43:
        return r128 + r102;
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
        return "ParticipantEntity(participantId=" + this.participantId + ", conversationId=" + this.conversationId + ", sortOrder=" + this.sortOrder + ", type=" + this.type + ", role=" + this.role + ", name=" + this.name + ", iconImage=" + this.iconImage + ", voiceType=" + this.voiceType + ", ext=" + this.ext + ", description=" + this.description + ", isVoiceMuted=" + this.isVoiceMuted + ", status=" + this.status + ", canNotInteract=" + this.canNotInteract + ')';
    }

    static {
        Companion = new b();
    }

    public ParticipantEntity() {
        this("", null, null, null, null, null, null, null, null, null, null, 0, null, 8190, null);
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

    public final String getIconImage() {
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

    public final int getStatus() {
        return this.status;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getVoiceType() {
        return this.voiceType;
    }

    public final Boolean isVoiceMuted() {
        return this.isVoiceMuted;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(ParticipantEntity r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeStringElement(r102, 0, r100.participantId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeStringElement(r102, 1, r100.conversationId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, w0.f520792a, r100.sortOrder);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, w0.f520792a, r100.type);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.role);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.name);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.iconImage);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.voiceType);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.ext);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.description);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, i.f520705a, r100.isVoiceMuted);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeIntElement(r102, 11, r100.status);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        r103 = true;
    L116:
        if (r103 == false) goto L119;
        r101.encodeNullableSerializableElement(r102, 12, i.f520705a, r100.canNotInteract);
        return;
    L119:
        return;
    L114:
        if (Intrinsics.areEqual(r100.canNotInteract, Boolean.FALSE) == true) goto L116;
    L105:
        if (r100.status != OmniParticipantStatus.STATUS_ACTIVE.value) goto L103;
        r115 = false;
        goto L108
    L96:
        if (Intrinsics.areEqual(r100.isVoiceMuted, Boolean.TRUE) == false) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.description != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.ext != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.voiceType != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.iconImage != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.name != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.role != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.type != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.sortOrder != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.conversationId, "") == false) goto L13;
        r105 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.participantId, "") == false) goto L4;
        r104 = false;
        goto L9
    }

    public ParticipantEntity(String r100, String r101, Integer r102, Integer r103, Integer r104, String r105, String r106, String r107, String r110, String r111, Boolean r112, int r113, Boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "participantId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.participantId = r100;
        this.conversationId = r101;
        this.sortOrder = r102;
        this.type = r103;
        this.role = r104;
        this.name = r105;
        this.iconImage = r106;
        this.voiceType = r107;
        this.ext = r110;
        this.description = r111;
        this.isVoiceMuted = r112;
        this.status = r113;
        this.canNotInteract = r114;
    }

    public ParticipantEntity(int r100, String r101, String r102, Integer r103, Integer r110, Integer r111, String r112, String r113, String r114, String r115, String r116, Boolean r117, int r118, Boolean r119, q2 r210) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f348122b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.participantId = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.conversationId = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.sortOrder = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.type = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.role = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.name = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.iconImage = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.voiceType = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.ext = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.description = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        Boolean r104 = Boolean.TRUE;
    L48:
        this.isVoiceMuted = r104;
        if ((r100 & 2048) != 0) goto L51;
        int r105 = OmniParticipantStatus.STATUS_ACTIVE.value;
    L52:
        this.status = r105;
        if ((r100 & 4096) != 0) goto L55;
        Boolean r106 = Boolean.FALSE;
    L56:
        this.canNotInteract = r106;
        return;
    L55:
        r106 = r119;
        goto L56
    L51:
        r105 = r118;
        goto L52
    L47:
        r104 = r117;
        goto L48
    L43:
        this.description = r116;
        goto L45
    L39:
        this.ext = r115;
        goto L41
    L35:
        this.voiceType = r114;
        goto L37
    L31:
        this.iconImage = r113;
        goto L33
    L27:
        this.name = r112;
        goto L29
    L23:
        this.role = r111;
        goto L25
    L19:
        this.type = r110;
        goto L21
    L15:
        this.sortOrder = r103;
        goto L17
    L11:
        this.conversationId = r102;
        goto L13
    L7:
        this.participantId = r101;
        goto L9
    }

    public /* synthetic */ ParticipantEntity(String r110, String r111, Integer r112, Integer r113, Integer r114, String r115, String r210, String r211, String r212, String r213, Boolean r214, int r215, Boolean r216, int r217, DefaultConstructorMarker r218) {
        String r100 = "";
        if ((r217 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r217 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        String r102 = null;
        if ((r217 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r217 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r217 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r217 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r217 & 512) != 0) goto L43;
        r102 = r213;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        Boolean r117 = Boolean.TRUE;
    L47:
        if ((r217 & 2048) == 0) goto L49;
        int r118 = OmniParticipantStatus.STATUS_ACTIVE.value;
    L51:
        if ((r217 & 4096) == 0) goto L53;
        Boolean r109 = Boolean.FALSE;
    L54:
        this(r101, r100, r103, r104, r105, r106, r107, r108, r116, r102, r117, r118, r109);
        return;
    L53:
        r109 = r216;
        goto L54
    L49:
        r118 = r215;
        goto L51
    L45:
        r117 = r214;
        goto L47
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
    L5:
        r101 = r110;
        goto L7
    }
}
