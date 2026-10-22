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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002-.BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0012¨\u0006/"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniTagUiKit;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "fontColorLight", "", "backgroundColorLight", "edgeColorLight", "fontColorDark", "backgroundColorDark", "edgeColorDark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFontColorLight$annotations", "()V", "getBackgroundColorLight$annotations", "getEdgeColorLight$annotations", "getFontColorDark$annotations", "getBackgroundColorDark$annotations", "getEdgeColorDark$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniTagUiKit implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String backgroundColorDark;
    public final String backgroundColorLight;
    public final String edgeColorDark;
    public final String edgeColorLight;
    public final String fontColorDark;
    public final String fontColorLight;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniTagUiKit$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniTagUiKit;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniTagUiKit> serializer() {
            return OmniTagUiKit$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniTagUiKit() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ OmniTagUiKit copy$default(OmniTagUiKit r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.fontColorLight;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.backgroundColorLight;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.edgeColorLight;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.fontColorDark;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.backgroundColorDark;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.edgeColorDark;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName("background_color_dark")
    public static /* synthetic */ void getBackgroundColorDark$annotations() {
    }

    @SerialName("background_color_light")
    public static /* synthetic */ void getBackgroundColorLight$annotations() {
    }

    @SerialName("edge_color_dark")
    public static /* synthetic */ void getEdgeColorDark$annotations() {
    }

    @SerialName("edge_color_light")
    public static /* synthetic */ void getEdgeColorLight$annotations() {
    }

    @SerialName("font_color_dark")
    public static /* synthetic */ void getFontColorDark$annotations() {
    }

    @SerialName("font_color_light")
    public static /* synthetic */ void getFontColorLight$annotations() {
    }

    public final String component1() {
        return this.fontColorLight;
    }

    public final String component2() {
        return this.backgroundColorLight;
    }

    public final String component3() {
        return this.edgeColorLight;
    }

    public final String component4() {
        return this.fontColorDark;
    }

    public final String component5() {
        return this.backgroundColorDark;
    }

    public final String component6() {
        return this.edgeColorDark;
    }

    public final OmniTagUiKit copy(String r100, String r110, String r111, String r112, String r113, String r114) {
        return new OmniTagUiKit(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniTagUiKit) == true) goto L8;
        return false;
    L8:
        OmniTagUiKit r101 = (OmniTagUiKit) r100;
        if (Intrinsics.areEqual(this.fontColorLight, r101.fontColorLight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundColorLight, r101.backgroundColorLight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.edgeColorLight, r101.edgeColorLight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fontColorDark, r101.fontColorDark) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backgroundColorDark, r101.backgroundColorDark) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.edgeColorDark, r101.edgeColorDark) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.fontColorLight;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.backgroundColorLight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.edgeColorLight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.fontColorDark;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.backgroundColorDark;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.edgeColorDark;
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
        return "OmniTagUiKit(fontColorLight=" + this.fontColorLight + ", backgroundColorLight=" + this.backgroundColorLight + ", edgeColorLight=" + this.edgeColorLight + ", fontColorDark=" + this.fontColorDark + ", backgroundColorDark=" + this.backgroundColorDark + ", edgeColorDark=" + this.edgeColorDark + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniTagUiKit r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.fontColorLight);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.backgroundColorLight);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.edgeColorLight);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.fontColorDark);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.backgroundColorDark);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r103 = true;
    L53:
        if (r103 == false) goto L56;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.edgeColorDark);
        return;
    L56:
        return;
    L51:
        if (r100.edgeColorDark == null) goto L53;
    L42:
        if (r100.backgroundColorDark != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.fontColorDark != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.edgeColorLight != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.backgroundColorLight != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.fontColorLight != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniTagUiKit(String r100, String r101, String r102, String r103, String r104, String r105) {
        this.fontColorLight = r100;
        this.backgroundColorLight = r101;
        this.edgeColorLight = r102;
        this.fontColorDark = r103;
        this.backgroundColorDark = r104;
        this.edgeColorDark = r105;
    }

    public /* synthetic */ OmniTagUiKit(int r100, String r101, String r102, String r103, String r104, String r105, String r106, q2 r107) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniTagUiKit$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.fontColorLight = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.backgroundColorLight = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.edgeColorLight = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.fontColorDark = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.backgroundColorDark = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.edgeColorDark = null;
        return;
    L27:
        this.edgeColorDark = r106;
        return;
    L23:
        this.backgroundColorDark = r105;
        goto L25
    L19:
        this.fontColorDark = r104;
        goto L21
    L15:
        this.edgeColorLight = r103;
        goto L17
    L11:
        this.backgroundColorLight = r102;
        goto L13
    L7:
        this.fontColorLight = r101;
        goto L9
    }

    public /* synthetic */ OmniTagUiKit(String r100, String r101, String r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
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
