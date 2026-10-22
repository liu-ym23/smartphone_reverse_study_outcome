package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u000234BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003JJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0017R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0017¨\u00065"}, d2 = {"Lcom/larus/im/bean/bot/MsgRegenMode;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "regenType", "", "regenText", "", "regenInstruction", "regenLightIcon", "regenDarkIcon", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRegenType$annotations", "()V", "getRegenType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRegenText$annotations", "getRegenText", "()Ljava/lang/String;", "getRegenInstruction$annotations", "getRegenInstruction", "getRegenLightIcon$annotations", "getRegenLightIcon", "getRegenDarkIcon$annotations", "getRegenDarkIcon", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/im/bean/bot/MsgRegenMode;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class MsgRegenMode implements java.io.Serializable {
    public static final b Companion = null;
    private final String regenDarkIcon;
    private final String regenInstruction;
    private final String regenLightIcon;
    private final String regenText;
    private final Integer regenType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MsgRegenMode> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346484a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346485b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(w0.f520792a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346485b;
        }

        static {
            a r100 = new a();
            f346484a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.MsgRegenMode", r100, 5);
            r101.j("regen_type", true);
            r101.j("regen_text", true);
            r101.j("regen_instruction", true);
            r101.j("regen_light_icon", true);
            r101.j("regen_dark_icon", true);
            f346485b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346485b;
            c r101 = r210.beginStructure(r100);
            Integer r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r103 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, null);
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 3, r104, null);
            Integer r110 = r103;
            String r111 = r106;
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            String r112 = r105;
            String r113 = r107;
            int r114 = 31;
        L23:
            r101.endStructure(r100);
            return new MsgRegenMode(r114, r110, r112, r111, r113, r211, null);
        L5:
            String r108 = null;
            String r115 = null;
            String r116 = null;
            String r117 = null;
            int r109 = 0;
            boolean r118 = true;
        L6:
            if (r118 == false) goto L22;
            int r119 = r101.decodeElementIndex(r100);
            if (r119 != (-1)) goto L9;
            r118 = false;
            goto L6
        L9:
            if (r119 != 0) goto L10;
            r102 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r102);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r119 != 1) goto L11;
            r108 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r108);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r119 != 2) goto L12;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r115);
            r109 = r109 | 4;
            goto L6
        L12:
            if (r119 != 3) goto L13;
            r116 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r116);
            r109 = r109 | 8;
            goto L6
        L13:
            if (r119 != 4) goto L16;
            r117 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r117);
            r109 = r109 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r119);
        L22:
            r114 = r109;
            r110 = r102;
            r112 = r108;
            r111 = r115;
            r113 = r116;
            r211 = r117;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            MsgRegenMode r102 = (MsgRegenMode) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346485b;
            muc.d r104 = r100.beginStructure(r103);
            MsgRegenMode.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<MsgRegenMode> serializer() {
            return a.f346484a;
        }
    }

    public MsgRegenMode() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MsgRegenMode copy$default(MsgRegenMode r100, Integer r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
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
        Integer r109 = r101;
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

    public final Integer component1() {
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

    public final MsgRegenMode copy(Integer r100, String r101, String r110, String r111, String r112) {
        return new MsgRegenMode(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MsgRegenMode) == true) goto L8;
        return false;
    L8:
        MsgRegenMode r101 = (MsgRegenMode) r100;
        if (Intrinsics.areEqual(this.regenType, r101.regenType) == true) goto L12;
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
        Integer r100 = this.regenType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.regenText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.regenInstruction;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.regenLightIcon;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.regenDarkIcon;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "MsgRegenMode(regenType=" + this.regenType + ", regenText=" + this.regenText + ", regenInstruction=" + this.regenInstruction + ", regenLightIcon=" + this.regenLightIcon + ", regenDarkIcon=" + this.regenDarkIcon + ')';
    }

    static {
        Companion = new b();
    }

    public final String getRegenDarkIcon() {
        return this.regenDarkIcon;
    }

    public final String getRegenInstruction() {
        return this.regenInstruction;
    }

    public final String getRegenLightIcon() {
        return this.regenLightIcon;
    }

    public final String getRegenText() {
        return this.regenText;
    }

    public final Integer getRegenType() {
        return this.regenType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(MsgRegenMode r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, w0.f520792a, r100.regenType);
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
        if (r100.regenType != null) goto L4;
        r104 = false;
        goto L9
    }

    public MsgRegenMode(Integer r100, String r101, String r102, String r103, String r104) {
        this.regenType = r100;
        this.regenText = r101;
        this.regenInstruction = r102;
        this.regenLightIcon = r103;
        this.regenDarkIcon = r104;
    }

    public MsgRegenMode(int r100, Integer r101, String r102, String r103, String r104, String r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346485b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.regenType = null;
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

    public /* synthetic */ MsgRegenMode(Integer r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Integer r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
