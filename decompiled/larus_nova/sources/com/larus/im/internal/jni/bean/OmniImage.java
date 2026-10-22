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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00060\u0001j\u0002`\u0002:\u0002>?B\u0089\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012B\u0087\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u008b\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0014HÖ\u0001J\t\u00105\u001a\u00020\u0004HÖ\u0001J%\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0019R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0019R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0019¨\u0006@"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniImage;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "key", "", "imageThumb", "Lcom/larus/im/internal/jni/bean/OmniImageObj;", "imageOri", "requestId", "simpleFeedback", "", "previewImg", "image720", "tips", "creationPrompt", "rawImage", "refImage", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniImageObj;Lcom/larus/im/internal/jni/bean/OmniImageObj;Ljava/lang/String;JLcom/larus/im/internal/jni/bean/OmniImageObj;Lcom/larus/im/internal/jni/bean/OmniImageObj;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniImageObj;Lcom/larus/im/internal/jni/bean/OmniImageObj;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/internal/jni/bean/OmniImageObj;Lcom/larus/im/internal/jni/bean/OmniImageObj;Ljava/lang/String;JLcom/larus/im/internal/jni/bean/OmniImageObj;Lcom/larus/im/internal/jni/bean/OmniImageObj;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniImageObj;Lcom/larus/im/internal/jni/bean/OmniImageObj;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey$annotations", "()V", "getImageThumb$annotations", "getImageOri$annotations", "getRequestId$annotations", "getSimpleFeedback$annotations", "getPreviewImg$annotations", "getImage720$annotations", "getTips$annotations", "getCreationPrompt$annotations", "getRawImage$annotations", "getRefImage$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniImage implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String creationPrompt;
    public final OmniImageObj image720;
    public final OmniImageObj imageOri;
    public final OmniImageObj imageThumb;
    public final String key;
    public final OmniImageObj previewImg;
    public final OmniImageObj rawImage;
    public final OmniImageObj refImage;
    public final String requestId;
    public final long simpleFeedback;
    public final String tips;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniImage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniImage;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniImage> serializer() {
            return OmniImage$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniImage() {
        this(null, null, null, null, 0, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ OmniImage copy$default(OmniImage r110, String r111, OmniImageObj r112, OmniImageObj r113, String r114, long r115, OmniImageObj r210, OmniImageObj r211, String r212, String r213, OmniImageObj r214, OmniImageObj r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.key;
    L7:
        if ((r216 & 2) == 0) goto L9;
        OmniImageObj r101 = r110.imageThumb;
    L11:
        if ((r216 & 4) == 0) goto L13;
        OmniImageObj r102 = r110.imageOri;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.requestId;
    L19:
        if ((r216 & 16) == 0) goto L21;
        long r104 = r110.simpleFeedback;
    L23:
        if ((r216 & 32) == 0) goto L25;
        OmniImageObj r105 = r110.previewImg;
    L27:
        if ((r216 & 64) == 0) goto L29;
        OmniImageObj r106 = r110.image720;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r116 = r110.tips;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.creationPrompt;
    L39:
        if ((r216 & 512) == 0) goto L41;
        OmniImageObj r118 = r110.rawImage;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        OmniImageObj r107 = r110.refImage;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r116, r117, r118, r107);
    L45:
        r107 = r215;
        goto L47
    L41:
        r118 = r214;
        goto L43
    L37:
        r117 = r213;
        goto L39
    L33:
        r116 = r212;
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

    @SerialName("creation_prompt")
    public static /* synthetic */ void getCreationPrompt$annotations() {
    }

    @SerialName("image_720")
    public static /* synthetic */ void getImage720$annotations() {
    }

    @SerialName("image_ori")
    public static /* synthetic */ void getImageOri$annotations() {
    }

    @SerialName("image_thumb")
    public static /* synthetic */ void getImageThumb$annotations() {
    }

    @SerialName("key")
    public static /* synthetic */ void getKey$annotations() {
    }

    @SerialName("preview_img")
    public static /* synthetic */ void getPreviewImg$annotations() {
    }

    @SerialName("raw_image")
    public static /* synthetic */ void getRawImage$annotations() {
    }

    @SerialName("ref_image")
    public static /* synthetic */ void getRefImage$annotations() {
    }

    @SerialName("request_id")
    public static /* synthetic */ void getRequestId$annotations() {
    }

    @SerialName("simple_feedback")
    public static /* synthetic */ void getSimpleFeedback$annotations() {
    }

    @SerialName("tips")
    public static /* synthetic */ void getTips$annotations() {
    }

    public final String component1() {
        return this.key;
    }

    public final OmniImageObj component10() {
        return this.rawImage;
    }

    public final OmniImageObj component11() {
        return this.refImage;
    }

    public final OmniImageObj component2() {
        return this.imageThumb;
    }

    public final OmniImageObj component3() {
        return this.imageOri;
    }

    public final String component4() {
        return this.requestId;
    }

    public final long component5() {
        return this.simpleFeedback;
    }

    public final OmniImageObj component6() {
        return this.previewImg;
    }

    public final OmniImageObj component7() {
        return this.image720;
    }

    public final String component8() {
        return this.tips;
    }

    public final String component9() {
        return this.creationPrompt;
    }

    public final OmniImage copy(String r110, OmniImageObj r111, OmniImageObj r112, String r113, long r114, OmniImageObj r210, OmniImageObj r211, String r212, String r213, OmniImageObj r214, OmniImageObj r215) {
        return new OmniImage(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniImage) == true) goto L8;
        return false;
    L8:
        OmniImage r101 = (OmniImage) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageOri, r101.imageOri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L21;
        return false;
    L21:
        if (this.simpleFeedback == r101.simpleFeedback) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.previewImg, r101.previewImg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.image720, r101.image720) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.creationPrompt, r101.creationPrompt) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.rawImage, r101.rawImage) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.refImage, r101.refImage) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        OmniImageObj r104 = this.imageThumb;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        OmniImageObj r107 = this.imageOri;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.requestId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.simpleFeedback;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        OmniImageObj r115 = this.previewImg;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        OmniImageObj r118 = this.image720;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.tips;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.creationPrompt;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        OmniImageObj r127 = this.rawImage;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        OmniImageObj r130 = this.refImage;
        if (r130 == null) goto L43;
        r101 = r130.hashCode();
    L43:
        return r129 + r101;
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
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
        return "OmniImage(key=" + this.key + ", imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ", requestId=" + this.requestId + ", simpleFeedback=" + this.simpleFeedback + ", previewImg=" + this.previewImg + ", image720=" + this.image720 + ", tips=" + this.tips + ", creationPrompt=" + this.creationPrompt + ", rawImage=" + this.rawImage + ", refImage=" + this.refImage + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniImage r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.key);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, OmniImageObj$$serializer.INSTANCE, r100.imageThumb);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, OmniImageObj$$serializer.INSTANCE, r100.imageOri);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeNullableSerializableElement(r110, 3, v2.f520790a, r100.requestId);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeLongElement(r110, 4, r100.simpleFeedback);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeNullableSerializableElement(r110, 5, OmniImageObj$$serializer.INSTANCE, r100.previewImg);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeNullableSerializableElement(r110, 6, OmniImageObj$$serializer.INSTANCE, r100.image720);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r110, 7, v2.f520790a, r100.tips);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r110, 8, v2.f520790a, r100.creationPrompt);
    L84:
        if (r101.shouldEncodeElementDefault(r110, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r110, 9, OmniImageObj$$serializer.INSTANCE, r100.rawImage);
    L93:
        if (r101.shouldEncodeElementDefault(r110, 10) == false) goto L96;
    L94:
        r102 = true;
    L98:
        if (r102 == false) goto L101;
        r101.encodeNullableSerializableElement(r110, 10, OmniImageObj$$serializer.INSTANCE, r100.refImage);
        return;
    L101:
        return;
    L96:
        if (r100.refImage == null) goto L98;
    L87:
        if (r100.rawImage != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.creationPrompt != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.tips != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.image720 != null) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.previewImg != null) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.simpleFeedback != 0) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.requestId != null) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.imageOri != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.imageThumb != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.key != null) goto L4;
        r103 = false;
        goto L9
    }

    public OmniImage(String r100, OmniImageObj r101, OmniImageObj r102, String r103, long r104, OmniImageObj r105, OmniImageObj r106, String r107, String r110, OmniImageObj r111, OmniImageObj r112) {
        this.key = r100;
        this.imageThumb = r101;
        this.imageOri = r102;
        this.requestId = r103;
        this.simpleFeedback = r104;
        this.previewImg = r105;
        this.image720 = r106;
        this.tips = r107;
        this.creationPrompt = r110;
        this.rawImage = r111;
        this.refImage = r112;
    }

    public /* synthetic */ OmniImage(int r100, String r101, OmniImageObj r102, OmniImageObj r103, String r104, long r105, OmniImageObj r106, OmniImageObj r110, String r111, String r112, OmniImageObj r113, OmniImageObj r114, q2 r115) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniImage$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.key = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.imageThumb = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.imageOri = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.requestId = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.simpleFeedback = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.previewImg = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.image720 = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.tips = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.creationPrompt = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.rawImage = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.refImage = null;
        return;
    L47:
        this.refImage = r114;
        return;
    L43:
        this.rawImage = r113;
        goto L45
    L39:
        this.creationPrompt = r112;
        goto L41
    L35:
        this.tips = r111;
        goto L37
    L31:
        this.image720 = r110;
        goto L33
    L27:
        this.previewImg = r106;
        goto L29
    L23:
        this.simpleFeedback = r105;
        goto L25
    L19:
        this.requestId = r104;
        goto L21
    L15:
        this.imageOri = r103;
        goto L17
    L11:
        this.imageThumb = r102;
        goto L13
    L7:
        this.key = r101;
        goto L9
    }

    public /* synthetic */ OmniImage(String r110, OmniImageObj r111, OmniImageObj r112, String r113, long r114, OmniImageObj r210, OmniImageObj r211, String r212, String r213, OmniImageObj r214, OmniImageObj r215, int r216, DefaultConstructorMarker r217) {
        OmniImageObj r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        OmniImageObj r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        OmniImageObj r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        long r105 = 0;
    L23:
        if ((r216 & 32) == 0) goto L25;
        OmniImageObj r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        OmniImageObj r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        OmniImageObj r117 = null;
    L43:
        if ((r216 & 1024) != 0) goto L46;
        r100 = r215;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r100);
        return;
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r115 = r212;
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
