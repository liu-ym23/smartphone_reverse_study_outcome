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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002+,BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\rHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012¨\u0006-"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotImerseConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "bgImgAvgHue", "", "bgImgUrl", "bgImgUri", "bgVideoModel", "bgImageInfo", "Lcom/larus/im/internal/jni/bean/OmniBgImageInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniBgImageInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniBgImageInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBgImgAvgHue$annotations", "()V", "getBgImgUrl$annotations", "getBgImgUri$annotations", "getBgVideoModel$annotations", "getBgImageInfo$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBotImerseConfig implements java.io.Serializable {
    public static final Companion Companion = null;
    public final OmniBgImageInfo bgImageInfo;
    public final String bgImgAvgHue;
    public final String bgImgUri;
    public final String bgImgUrl;
    public final String bgVideoModel;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotImerseConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBotImerseConfig;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBotImerseConfig> serializer() {
            return OmniBotImerseConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniBotImerseConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OmniBotImerseConfig copy$default(OmniBotImerseConfig r100, String r101, String r102, String r103, String r104, OmniBgImageInfo r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.bgImgAvgHue;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.bgImgUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.bgImgUri;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.bgVideoModel;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.bgImageInfo;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("bg_image_info")
    public static /* synthetic */ void getBgImageInfo$annotations() {
    }

    @SerialName("bg_img_avg_hue")
    public static /* synthetic */ void getBgImgAvgHue$annotations() {
    }

    @SerialName("bg_img_uri")
    public static /* synthetic */ void getBgImgUri$annotations() {
    }

    @SerialName("bg_img_url")
    public static /* synthetic */ void getBgImgUrl$annotations() {
    }

    @SerialName("bg_video_model")
    public static /* synthetic */ void getBgVideoModel$annotations() {
    }

    public final String component1() {
        return this.bgImgAvgHue;
    }

    public final String component2() {
        return this.bgImgUrl;
    }

    public final String component3() {
        return this.bgImgUri;
    }

    public final String component4() {
        return this.bgVideoModel;
    }

    public final OmniBgImageInfo component5() {
        return this.bgImageInfo;
    }

    public final OmniBotImerseConfig copy(String r100, String r101, String r110, String r111, OmniBgImageInfo r112) {
        return new OmniBotImerseConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBotImerseConfig) == true) goto L8;
        return false;
    L8:
        OmniBotImerseConfig r101 = (OmniBotImerseConfig) r100;
        if (Intrinsics.areEqual(this.bgImgAvgHue, r101.bgImgAvgHue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgImgUrl, r101.bgImgUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImgUri, r101.bgImgUri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgVideoModel, r101.bgVideoModel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgImageInfo, r101.bgImageInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.bgImgAvgHue;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgImgUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgImgUri;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bgVideoModel;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        OmniBgImageInfo r113 = this.bgImageInfo;
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
        return "OmniBotImerseConfig(bgImgAvgHue=" + this.bgImgAvgHue + ", bgImgUrl=" + this.bgImgUrl + ", bgImgUri=" + this.bgImgUri + ", bgVideoModel=" + this.bgVideoModel + ", bgImageInfo=" + this.bgImageInfo + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBotImerseConfig r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.bgImgAvgHue);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.bgImgUrl);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.bgImgUri);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.bgVideoModel);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, OmniBgImageInfo$$serializer.INSTANCE, r100.bgImageInfo);
        return;
    L47:
        return;
    L42:
        if (r100.bgImageInfo == null) goto L44;
    L33:
        if (r100.bgVideoModel != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.bgImgUri != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.bgImgUrl != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.bgImgAvgHue != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniBotImerseConfig(String r100, String r101, String r102, String r103, OmniBgImageInfo r104) {
        this.bgImgAvgHue = r100;
        this.bgImgUrl = r101;
        this.bgImgUri = r102;
        this.bgVideoModel = r103;
        this.bgImageInfo = r104;
    }

    public /* synthetic */ OmniBotImerseConfig(int r100, String r101, String r102, String r103, String r104, OmniBgImageInfo r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBotImerseConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.bgImgAvgHue = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.bgImgUrl = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.bgImgUri = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.bgVideoModel = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.bgImageInfo = null;
        return;
    L23:
        this.bgImageInfo = r105;
        return;
    L19:
        this.bgVideoModel = r104;
        goto L21
    L15:
        this.bgImgUri = r103;
        goto L17
    L11:
        this.bgImgUrl = r102;
        goto L13
    L7:
        this.bgImgAvgHue = r101;
        goto L9
    }

    public /* synthetic */ OmniBotImerseConfig(String r100, String r101, String r102, String r103, OmniBgImageInfo r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
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
        OmniBgImageInfo r113 = null;
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
