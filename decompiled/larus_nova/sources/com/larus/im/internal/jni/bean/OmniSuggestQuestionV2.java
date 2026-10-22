package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u000234Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eBi\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jg\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0014¨\u00065"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniSuggestQuestionV2;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "suggestType", "", "content", "", "iconUrl", "iconUri", "clickUrl", "botId", "extra", "darkIconUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSuggestType$annotations", "()V", "getContent$annotations", "getIconUrl$annotations", "getIconUri$annotations", "getClickUrl$annotations", "getBotId$annotations", "getExtra$annotations", "getDarkIconUrl$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniSuggestQuestionV2 implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String botId;
    public final String clickUrl;
    public final String content;
    public final String darkIconUrl;
    public final String extra;
    public final String iconUri;
    public final String iconUrl;
    public final int suggestType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniSuggestQuestionV2$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniSuggestQuestionV2;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniSuggestQuestionV2> serializer() {
            return OmniSuggestQuestionV2$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniSuggestQuestionV2() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ OmniSuggestQuestionV2 copy$default(OmniSuggestQuestionV2 r100, int r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.suggestType;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.content;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.iconUrl;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.iconUri;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.clickUrl;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.botId;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.extra;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.darkIconUrl;
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

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("click_url")
    public static /* synthetic */ void getClickUrl$annotations() {
    }

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("dark_icon_url")
    public static /* synthetic */ void getDarkIconUrl$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("icon_uri")
    public static /* synthetic */ void getIconUri$annotations() {
    }

    @SerialName("icon_url")
    public static /* synthetic */ void getIconUrl$annotations() {
    }

    @SerialName("suggest_type")
    public static /* synthetic */ void getSuggestType$annotations() {
    }

    public final int component1() {
        return this.suggestType;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.iconUri;
    }

    public final String component5() {
        return this.clickUrl;
    }

    public final String component6() {
        return this.botId;
    }

    public final String component7() {
        return this.extra;
    }

    public final String component8() {
        return this.darkIconUrl;
    }

    public final OmniSuggestQuestionV2 copy(int r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117) {
        return new OmniSuggestQuestionV2(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniSuggestQuestionV2) == true) goto L8;
        return false;
    L8:
        OmniSuggestQuestionV2 r101 = (OmniSuggestQuestionV2) r100;
        if (this.suggestType == r101.suggestType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUri, r101.iconUri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickUrl, r101.clickUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.darkIconUrl, r101.darkIconUrl) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.suggestType * 31;
        String r101 = this.content;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.iconUrl;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.iconUri;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.clickUrl;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.botId;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.extra;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.darkIconUrl;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
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
        return "OmniSuggestQuestionV2(suggestType=" + this.suggestType + ", content=" + this.content + ", iconUrl=" + this.iconUrl + ", iconUri=" + this.iconUri + ", clickUrl=" + this.clickUrl + ", botId=" + this.botId + ", extra=" + this.extra + ", darkIconUrl=" + this.darkIconUrl + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniSuggestQuestionV2 r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.suggestType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.content);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.iconUrl);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.iconUri);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.clickUrl);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.botId);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.extra);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        r103 = true;
    L71:
        if (r103 == false) goto L74;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.darkIconUrl);
        return;
    L74:
        return;
    L69:
        if (r100.darkIconUrl == null) goto L71;
    L60:
        if (r100.extra != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.botId != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.clickUrl != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.iconUri != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.iconUrl != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.content != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.suggestType != 0) goto L4;
        r104 = false;
        goto L9
    }

    public OmniSuggestQuestionV2(int r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.suggestType = r100;
        this.content = r101;
        this.iconUrl = r102;
        this.iconUri = r103;
        this.clickUrl = r104;
        this.botId = r105;
        this.extra = r106;
        this.darkIconUrl = r107;
    }

    public /* synthetic */ OmniSuggestQuestionV2(int r100, int r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniSuggestQuestionV2$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.suggestType = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.content = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.iconUrl = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.iconUri = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.clickUrl = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.botId = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.extra = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.darkIconUrl = null;
        return;
    L35:
        this.darkIconUrl = r111;
        return;
    L31:
        this.extra = r110;
        goto L33
    L27:
        this.botId = r106;
        goto L29
    L23:
        this.clickUrl = r105;
        goto L25
    L19:
        this.iconUri = r104;
        goto L21
    L15:
        this.iconUrl = r103;
        goto L17
    L11:
        this.content = r102;
        goto L13
    L7:
        this.suggestType = r101;
        goto L9
    }

    public /* synthetic */ OmniSuggestQuestionV2(int r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        int r100 = 0;
    L6:
        String r101 = null;
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r101 = r117;
    L34:
        this(r100, r102, r103, r104, r105, r106, r107, r101);
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
        r100 = r110;
        goto L6
    }
}
