package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadad.api.download.AdDownloadModel;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00060\u0001j\u0002`\u0002:\u0002./BG\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rBO\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JI\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000fHÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0014¨\u00060"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniModelItem;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "name", "", "modelType", "", "modelName", "typewriterSwitch", "", "supportWebSearchSwitch", "supportPicGenSwitch", "<init>", "(Ljava/lang/String;JLjava/lang/String;ZZZ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/lang/String;ZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getModelType$annotations", "getModelName$annotations", "getTypewriterSwitch$annotations", "getSupportWebSearchSwitch$annotations", "getSupportPicGenSwitch$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniModelItem implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String modelName;
    public final long modelType;
    public final String name;
    public final boolean supportPicGenSwitch;
    public final boolean supportWebSearchSwitch;
    public final boolean typewriterSwitch;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniModelItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniModelItem;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniModelItem> serializer() {
            return OmniModelItem$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniModelItem() {
        this(null, 0, null, false, false, false, 63, null);
    }

    public static /* synthetic */ OmniModelItem copy$default(OmniModelItem r100, String r101, long r102, String r103, boolean r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.modelType;
    L8:
        long r104 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.modelName;
    L11:
        String r115 = r103;
        if ((r113 & 8) == 0) goto L14;
        r110 = r100.typewriterSwitch;
    L14:
        boolean r105 = r110;
        if ((r113 & 16) == 0) goto L17;
        r111 = r100.supportWebSearchSwitch;
    L17:
        boolean r106 = r111;
        if ((r113 & 32) == 0) goto L20;
        r112 = r100.supportPicGenSwitch;
    L20:
        String r107 = r101;
        return r100.copy(r107, r104, r115, r105, r106, r112);
    }

    @SerialName("model_name")
    public static /* synthetic */ void getModelName$annotations() {
    }

    @SerialName(AdDownloadModel.JsonKey.MODEL_TYPE)
    public static /* synthetic */ void getModelType$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("support_pic_gen_switch")
    public static /* synthetic */ void getSupportPicGenSwitch$annotations() {
    }

    @SerialName("support_web_search_switch")
    public static /* synthetic */ void getSupportWebSearchSwitch$annotations() {
    }

    @SerialName("typewriter_switch")
    public static /* synthetic */ void getTypewriterSwitch$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final long component2() {
        return this.modelType;
    }

    public final String component3() {
        return this.modelName;
    }

    public final boolean component4() {
        return this.typewriterSwitch;
    }

    public final boolean component5() {
        return this.supportWebSearchSwitch;
    }

    public final boolean component6() {
        return this.supportPicGenSwitch;
    }

    public final OmniModelItem copy(String r110, long r111, String r112, boolean r113, boolean r114, boolean r115) {
        return new OmniModelItem(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniModelItem) == true) goto L8;
        return false;
    L8:
        OmniModelItem r101 = (OmniModelItem) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (this.modelType == r101.modelType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelName, r101.modelName) == true) goto L18;
        return false;
    L18:
        if (this.typewriterSwitch == r101.typewriterSwitch) goto L21;
        return false;
    L21:
        if (this.supportWebSearchSwitch == r101.supportWebSearchSwitch) goto L24;
        return false;
    L24:
        if (this.supportPicGenSwitch == r101.supportPicGenSwitch) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.modelType;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.modelName;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        int r106 = (r104 + r101) * 31;
        int r107 = 1231;
        if (this.typewriterSwitch == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.supportWebSearchSwitch == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.supportPicGenSwitch == true) goto L23;
        r107 = 1237;
    L23:
        return r111 + r107;
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniModelItem(name=" + this.name + ", modelType=" + this.modelType + ", modelName=" + this.modelName + ", typewriterSwitch=" + this.typewriterSwitch + ", supportWebSearchSwitch=" + this.supportWebSearchSwitch + ", supportPicGenSwitch=" + this.supportPicGenSwitch + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniModelItem r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.name);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeLongElement(r102, 1, r100.modelType);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.modelName);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeBooleanElement(r102, 3, r100.typewriterSwitch);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeBooleanElement(r102, 4, r100.supportWebSearchSwitch);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r103 = true;
    L53:
        if (r103 == false) goto L56;
        r101.encodeBooleanElement(r102, 5, r100.supportPicGenSwitch);
        return;
    L56:
        return;
    L51:
        if (r100.supportPicGenSwitch == false) goto L53;
    L42:
        if (r100.supportWebSearchSwitch == true) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.typewriterSwitch == true) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.modelName != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.modelType != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.name != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniModelItem(String r100, long r101, String r102, boolean r103, boolean r104, boolean r105) {
        this.name = r100;
        this.modelType = r101;
        this.modelName = r102;
        this.typewriterSwitch = r103;
        this.supportWebSearchSwitch = r104;
        this.supportPicGenSwitch = r105;
    }

    public /* synthetic */ OmniModelItem(int r100, String r101, long r102, String r103, boolean r104, boolean r105, boolean r110, q2 r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniModelItem$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.name = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.modelType = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.modelName = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.typewriterSwitch = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.supportWebSearchSwitch = false;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.supportPicGenSwitch = false;
        return;
    L27:
        this.supportPicGenSwitch = r110;
        return;
    L23:
        this.supportWebSearchSwitch = r105;
        goto L25
    L19:
        this.typewriterSwitch = r104;
        goto L21
    L15:
        this.modelName = r103;
        goto L17
    L11:
        this.modelType = r102;
        goto L13
    L7:
        this.name = r101;
        goto L9
    }

    public /* synthetic */ OmniModelItem(String r100, long r101, String r102, boolean r110, boolean r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        String r103 = null;
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r104 = r101;
        if ((r113 & 4) != 0) goto L14;
        r103 = r102;
    L14:
        if ((r113 & 8) == 0) goto L16;
        boolean r105 = false;
    L18:
        if ((r113 & 16) == 0) goto L20;
        boolean r106 = false;
    L22:
        if ((r113 & 32) == 0) goto L24;
        boolean r116 = false;
    L25:
        this(r115, r104, r103, r105, r106, r116);
        return;
    L24:
        r116 = r112;
        goto L25
    L20:
        r106 = r111;
        goto L22
    L16:
        r105 = r110;
        goto L18
    L5:
        r115 = r100;
        goto L7
    }
}
