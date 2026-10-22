package com.larus.im.bean.message;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.hihonor.honorid.core.data.UserInfo;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00060\u0001j\u0002`\u0002:\u0002'(B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nBA\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\fHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0011¨\u0006)"}, d2 = {"Lcom/larus/im/bean/message/ClientControllerParam;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "answerWithSuggest", "", UserInfo.LANGUAGECODE, "", "voiceId", InstantPlayContext.NICKNAME, "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAnswerWithSuggest$annotations", "()V", "getLanguageCode$annotations", "getVoiceId$annotations", "getNickname$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ClientControllerParam implements java.io.Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public final boolean answerWithSuggest;
    public final String languageCode;
    public final String nickname;
    public final String voiceId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ClientControllerParam> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346597a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346598b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{i.f520705a, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346598b;
        }

        static {
            a r100 = new a();
            f346597a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.ClientControllerParam", r100, 4);
            r101.j("answer_with_suggest", true);
            r101.j("local_language_code", true);
            r101.j("local_voice_id", true);
            r101.j("local_nickname", true);
            f346598b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346598b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            boolean r102 = r101.decodeBooleanElement(r100, 0);
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            boolean r110 = r102;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r112 = r104;
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new ClientControllerParam(r114, r110, r112, r111, r113, null);
        L5:
            String r105 = null;
            String r106 = null;
            String r115 = null;
            boolean r107 = false;
            int r108 = 0;
            boolean r116 = true;
        L6:
            if (r116 == false) goto L20;
            int r117 = r101.decodeElementIndex(r100);
            if (r117 != (-1)) goto L9;
            r116 = false;
            goto L6
        L9:
            if (r117 != 0) goto L10;
            r107 = r101.decodeBooleanElement(r100, 0);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r117 != 1) goto L11;
            r105 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r105);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r117 != 2) goto L12;
            r106 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r106);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r117 != 3) goto L15;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r115);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r117);
        L20:
            r110 = r107;
            r114 = r108;
            r112 = r105;
            r111 = r106;
            r113 = r115;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ClientControllerParam r102 = (ClientControllerParam) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346598b;
            muc.d r104 = r100.beginStructure(r103);
            ClientControllerParam.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ClientControllerParam> serializer() {
            return a.f346597a;
        }
    }

    public ClientControllerParam() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ ClientControllerParam copy$default(ClientControllerParam r100, boolean r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.answerWithSuggest;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.languageCode;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.voiceId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.nickname;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("answer_with_suggest")
    public static /* synthetic */ void getAnswerWithSuggest$annotations() {
    }

    @SerialName("local_language_code")
    public static /* synthetic */ void getLanguageCode$annotations() {
    }

    @SerialName("local_nickname")
    public static /* synthetic */ void getNickname$annotations() {
    }

    @SerialName("local_voice_id")
    public static /* synthetic */ void getVoiceId$annotations() {
    }

    public final boolean component1() {
        return this.answerWithSuggest;
    }

    public final String component2() {
        return this.languageCode;
    }

    public final String component3() {
        return this.voiceId;
    }

    public final String component4() {
        return this.nickname;
    }

    public final ClientControllerParam copy(boolean r100, String r101, String r102, String r103) {
        return new ClientControllerParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClientControllerParam) == true) goto L8;
        return false;
    L8:
        ClientControllerParam r101 = (ClientControllerParam) r100;
        if (this.answerWithSuggest == r101.answerWithSuggest) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.languageCode, r101.languageCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.voiceId, r101.voiceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nickname, r101.nickname) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.answerWithSuggest == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.languageCode;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.voiceId;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.nickname;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ClientControllerParam(answerWithSuggest=" + this.answerWithSuggest + ", languageCode=" + this.languageCode + ", voiceId=" + this.voiceId + ", nickname=" + this.nickname + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ClientControllerParam r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.answerWithSuggest);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.languageCode);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.voiceId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.nickname);
        return;
    L38:
        return;
    L33:
        if (r100.nickname == null) goto L35;
    L24:
        if (r100.voiceId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.languageCode != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.answerWithSuggest == true) goto L4;
        r104 = false;
        goto L9
    }

    public ClientControllerParam(boolean r100, String r101, String r102, String r103) {
        this.answerWithSuggest = r100;
        this.languageCode = r101;
        this.voiceId = r102;
        this.nickname = r103;
    }

    public ClientControllerParam(int r100, boolean r101, String r102, String r103, String r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346598b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.answerWithSuggest = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.languageCode = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.voiceId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.nickname = null;
        return;
    L19:
        this.nickname = r104;
        return;
    L15:
        this.voiceId = r103;
        goto L17
    L11:
        this.languageCode = r102;
        goto L13
    L7:
        this.answerWithSuggest = r101;
        goto L9
    }

    public /* synthetic */ ClientControllerParam(boolean r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
