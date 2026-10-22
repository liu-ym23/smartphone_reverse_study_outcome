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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002*+BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bBK\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0011¨\u0006,"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniRegenMode;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "regenType", "", "regenText", "", "regenInstruction", "regenLightIcon", "regenDarkIcon", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRegenType$annotations", "()V", "getRegenText$annotations", "getRegenInstruction$annotations", "getRegenLightIcon$annotations", "getRegenDarkIcon$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniRegenMode implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String regenDarkIcon;
    public final String regenInstruction;
    public final String regenLightIcon;
    public final String regenText;
    public final int regenType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniRegenMode$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniRegenMode;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniRegenMode> serializer() {
            return OmniRegenMode$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniRegenMode() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OmniRegenMode copy$default(OmniRegenMode r100, int r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.regenType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.regenText;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.regenInstruction;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.regenLightIcon;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.regenDarkIcon;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("regen_dark_icon")
    public static /* synthetic */ void getRegenDarkIcon$annotations() {
    }

    @SerialName("regen_instruction")
    public static /* synthetic */ void getRegenInstruction$annotations() {
    }

    @SerialName("regen_light_icon")
    public static /* synthetic */ void getRegenLightIcon$annotations() {
    }

    @SerialName("regen_text")
    public static /* synthetic */ void getRegenText$annotations() {
    }

    @SerialName("regen_type")
    public static /* synthetic */ void getRegenType$annotations() {
    }

    public final int component1() {
        return this.regenType;
    }

    public final String component2() {
        return this.regenText;
    }

    public final String component3() {
        return this.regenInstruction;
    }

    public final String component4() {
        return this.regenLightIcon;
    }

    public final String component5() {
        return this.regenDarkIcon;
    }

    public final OmniRegenMode copy(int r100, String r101, String r110, String r111, String r112) {
        return new OmniRegenMode(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniRegenMode) == true) goto L8;
        return false;
    L8:
        OmniRegenMode r101 = (OmniRegenMode) r100;
        if (this.regenType == r101.regenType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.regenText, r101.regenText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.regenInstruction, r101.regenInstruction) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.regenLightIcon, r101.regenLightIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.regenDarkIcon, r101.regenDarkIcon) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.regenType * 31;
        String r101 = this.regenText;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.regenInstruction;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.regenLightIcon;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.regenDarkIcon;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "OmniRegenMode(regenType=" + this.regenType + ", regenText=" + this.regenText + ", regenInstruction=" + this.regenInstruction + ", regenLightIcon=" + this.regenLightIcon + ", regenDarkIcon=" + this.regenDarkIcon + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniRegenMode r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.regenType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.regenText);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.regenInstruction);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.regenLightIcon);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.regenDarkIcon);
        return;
    L47:
        return;
    L42:
        if (r100.regenDarkIcon == null) goto L44;
    L33:
        if (r100.regenLightIcon != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.regenInstruction != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.regenText != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.regenType != 0) goto L4;
        r104 = false;
        goto L9
    }

    public OmniRegenMode(int r100, String r101, String r102, String r103, String r104) {
        this.regenType = r100;
        this.regenText = r101;
        this.regenInstruction = r102;
        this.regenLightIcon = r103;
        this.regenDarkIcon = r104;
    }

    public /* synthetic */ OmniRegenMode(int r100, int r101, String r102, String r103, String r104, String r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniRegenMode$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.regenType = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.regenText = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.regenInstruction = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.regenLightIcon = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.regenDarkIcon = null;
        return;
    L23:
        this.regenDarkIcon = r105;
        return;
    L19:
        this.regenLightIcon = r104;
        goto L21
    L15:
        this.regenInstruction = r103;
        goto L17
    L11:
        this.regenText = r102;
        goto L13
    L7:
        this.regenType = r101;
        goto L9
    }

    public /* synthetic */ OmniRegenMode(int r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        String r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        String r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
