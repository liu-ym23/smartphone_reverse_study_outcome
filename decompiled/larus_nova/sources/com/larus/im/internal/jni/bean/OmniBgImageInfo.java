package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.r3;
import java.util.List;
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
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>B\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0013B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u008d\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0010HÖ\u0001J\t\u00104\u001a\u00020\u0004HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0019R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0019R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0019R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0019¨\u0006?"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBgImageInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "bgImgPrompt", "", "bgImgPromptEn", "aiGenBgImg", "", "bgImgDrawStyleStarlingKey", "", "bgImgOpen", "referenceBgImgUri", "referenceBgImgUrl", "referenceBgImgStyle", "referenceBgImgPrompt", "botCategoryType", "", "bgImagePromptForEnrich", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLjava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBgImgPrompt$annotations", "()V", "getBgImgPromptEn$annotations", "getAiGenBgImg$annotations", "getBgImgDrawStyleStarlingKey$annotations", "getBgImgOpen$annotations", "getReferenceBgImgUri$annotations", "getReferenceBgImgUrl$annotations", "getReferenceBgImgStyle$annotations", "getReferenceBgImgPrompt$annotations", "getBotCategoryType$annotations", "getBgImagePromptForEnrich$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBgImageInfo implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final boolean aiGenBgImg;
    public final String bgImagePromptForEnrich;
    public final List<String> bgImgDrawStyleStarlingKey;
    public final boolean bgImgOpen;
    public final String bgImgPrompt;
    public final String bgImgPromptEn;
    public final int botCategoryType;
    public final String referenceBgImgPrompt;
    public final String referenceBgImgStyle;
    public final String referenceBgImgUri;
    public final String referenceBgImgUrl;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBgImageInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBgImageInfo;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBgImageInfo> serializer() {
            return OmniBgImageInfo$$serializer.INSTANCE;
        }
    }

    public OmniBgImageInfo() {
        this(null, null, false, null, false, null, null, null, null, 0, null, 2047, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(v2.f520790a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniBgImageInfo copy$default(OmniBgImageInfo r110, String r111, String r112, boolean r113, List r114, boolean r115, String r116, String r117, String r210, String r211, int r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.bgImgPrompt;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.bgImgPromptEn;
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r102 = r110.aiGenBgImg;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List r103 = r110.bgImgDrawStyleStarlingKey;
    L19:
        if ((r214 & 16) == 0) goto L21;
        boolean r104 = r110.bgImgOpen;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.referenceBgImgUri;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.referenceBgImgUrl;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.referenceBgImgStyle;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.referenceBgImgPrompt;
    L39:
        if ((r214 & 512) == 0) goto L41;
        int r119 = r110.botCategoryType;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.bgImagePromptForEnrich;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
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

    @SerialName("ai_gen_bg_img")
    public static /* synthetic */ void getAiGenBgImg$annotations() {
    }

    @SerialName("bg_image_prompt_for_enrich")
    public static /* synthetic */ void getBgImagePromptForEnrich$annotations() {
    }

    @SerialName("bg_img_draw_style_starling_key")
    public static /* synthetic */ void getBgImgDrawStyleStarlingKey$annotations() {
    }

    @SerialName("bg_img_open")
    public static /* synthetic */ void getBgImgOpen$annotations() {
    }

    @SerialName("bg_img_prompt")
    public static /* synthetic */ void getBgImgPrompt$annotations() {
    }

    @SerialName("bg_img_prompt_en")
    public static /* synthetic */ void getBgImgPromptEn$annotations() {
    }

    @SerialName("bot_category_type")
    public static /* synthetic */ void getBotCategoryType$annotations() {
    }

    @SerialName("reference_bg_img_prompt")
    public static /* synthetic */ void getReferenceBgImgPrompt$annotations() {
    }

    @SerialName("reference_bg_img_style")
    public static /* synthetic */ void getReferenceBgImgStyle$annotations() {
    }

    @SerialName("reference_bg_img_uri")
    public static /* synthetic */ void getReferenceBgImgUri$annotations() {
    }

    @SerialName("reference_bg_img_url")
    public static /* synthetic */ void getReferenceBgImgUrl$annotations() {
    }

    public final String component1() {
        return this.bgImgPrompt;
    }

    public final int component10() {
        return this.botCategoryType;
    }

    public final String component11() {
        return this.bgImagePromptForEnrich;
    }

    public final String component2() {
        return this.bgImgPromptEn;
    }

    public final boolean component3() {
        return this.aiGenBgImg;
    }

    public final List<String> component4() {
        return this.bgImgDrawStyleStarlingKey;
    }

    public final boolean component5() {
        return this.bgImgOpen;
    }

    public final String component6() {
        return this.referenceBgImgUri;
    }

    public final String component7() {
        return this.referenceBgImgUrl;
    }

    public final String component8() {
        return this.referenceBgImgStyle;
    }

    public final String component9() {
        return this.referenceBgImgPrompt;
    }

    public final OmniBgImageInfo copy(String r110, String r111, boolean r112, List<String> r113, boolean r114, String r115, String r210, String r211, String r212, int r213, String r214) {
        return new OmniBgImageInfo(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBgImageInfo) == true) goto L8;
        return false;
    L8:
        OmniBgImageInfo r101 = (OmniBgImageInfo) r100;
        if (Intrinsics.areEqual(this.bgImgPrompt, r101.bgImgPrompt) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgImgPromptEn, r101.bgImgPromptEn) == true) goto L15;
        return false;
    L15:
        if (this.aiGenBgImg == r101.aiGenBgImg) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgImgDrawStyleStarlingKey, r101.bgImgDrawStyleStarlingKey) == true) goto L21;
        return false;
    L21:
        if (this.bgImgOpen == r101.bgImgOpen) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.referenceBgImgUri, r101.referenceBgImgUri) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.referenceBgImgUrl, r101.referenceBgImgUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.referenceBgImgStyle, r101.referenceBgImgStyle) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.referenceBgImgPrompt, r101.referenceBgImgPrompt) == true) goto L36;
        return false;
    L36:
        if (this.botCategoryType == r101.botCategoryType) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.bgImagePromptForEnrich, r101.bgImagePromptForEnrich) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.bgImgPrompt;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgImgPromptEn;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.aiGenBgImg == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.bgImgDrawStyleStarlingKey;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.bgImgOpen == true) goto L22;
        r107 = 1237;
    L22:
        int r113 = (r112 + r107) * 31;
        String r114 = this.referenceBgImgUri;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.referenceBgImgUrl;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        String r120 = this.referenceBgImgStyle;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.referenceBgImgPrompt;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (((r122 + r124) * 31) + this.botCategoryType) * 31;
        String r126 = this.bgImagePromptForEnrich;
        if (r126 == null) goto L43;
        r101 = r126.hashCode();
    L43:
        return r125 + r101;
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniBgImageInfo(bgImgPrompt=" + this.bgImgPrompt + ", bgImgPromptEn=" + this.bgImgPromptEn + ", aiGenBgImg=" + this.aiGenBgImg + ", bgImgDrawStyleStarlingKey=" + this.bgImgDrawStyleStarlingKey + ", bgImgOpen=" + this.bgImgOpen + ", referenceBgImgUri=" + this.referenceBgImgUri + ", referenceBgImgUrl=" + this.referenceBgImgUrl + ", referenceBgImgStyle=" + this.referenceBgImgStyle + ", referenceBgImgPrompt=" + this.referenceBgImgPrompt + ", botCategoryType=" + this.botCategoryType + ", bgImagePromptForEnrich=" + this.bgImagePromptForEnrich + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new r3()), null, null, null, null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBgImageInfo r100, muc.d r101, luc.f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.bgImgPrompt);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.bgImgPromptEn);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeBooleanElement(r102, 2, r100.aiGenBgImg);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.bgImgDrawStyleStarlingKey);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeBooleanElement(r102, 4, r100.bgImgOpen);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.referenceBgImgUri);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.referenceBgImgUrl);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.referenceBgImgStyle);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.referenceBgImgPrompt);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeIntElement(r102, 9, r100.botCategoryType);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        r104 = true;
    L98:
        if (r104 == false) goto L101;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.bgImagePromptForEnrich);
        return;
    L101:
        return;
    L96:
        if (r100.bgImagePromptForEnrich == null) goto L98;
    L87:
        if (r100.botCategoryType != 0) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.referenceBgImgPrompt != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.referenceBgImgStyle != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.referenceBgImgUrl != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.referenceBgImgUri != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.bgImgOpen == true) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.bgImgDrawStyleStarlingKey != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.aiGenBgImg == true) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.bgImgPromptEn != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.bgImgPrompt != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniBgImageInfo(String r100, String r101, boolean r102, List<String> r103, boolean r104, String r105, String r106, String r107, String r108, int r110, String r111) {
        this.bgImgPrompt = r100;
        this.bgImgPromptEn = r101;
        this.aiGenBgImg = r102;
        this.bgImgDrawStyleStarlingKey = r103;
        this.bgImgOpen = r104;
        this.referenceBgImgUri = r105;
        this.referenceBgImgUrl = r106;
        this.referenceBgImgStyle = r107;
        this.referenceBgImgPrompt = r108;
        this.botCategoryType = r110;
        this.bgImagePromptForEnrich = r111;
    }

    public /* synthetic */ OmniBgImageInfo(int r100, String r101, String r102, boolean r103, List r104, boolean r105, String r106, String r110, String r111, String r112, int r113, String r114, q2 r115) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBgImageInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.bgImgPrompt = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.bgImgPromptEn = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.aiGenBgImg = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.bgImgDrawStyleStarlingKey = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.bgImgOpen = false;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.referenceBgImgUri = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.referenceBgImgUrl = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.referenceBgImgStyle = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.referenceBgImgPrompt = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.botCategoryType = 0;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.bgImagePromptForEnrich = null;
        return;
    L47:
        this.bgImagePromptForEnrich = r114;
        return;
    L43:
        this.botCategoryType = r113;
        goto L45
    L39:
        this.referenceBgImgPrompt = r112;
        goto L41
    L35:
        this.referenceBgImgStyle = r111;
        goto L37
    L31:
        this.referenceBgImgUrl = r110;
        goto L33
    L27:
        this.referenceBgImgUri = r106;
        goto L29
    L23:
        this.bgImgOpen = r105;
        goto L25
    L19:
        this.bgImgDrawStyleStarlingKey = r104;
        goto L21
    L15:
        this.aiGenBgImg = r103;
        goto L17
    L11:
        this.bgImgPromptEn = r102;
        goto L13
    L7:
        this.bgImgPrompt = r101;
        goto L9
    }

    public /* synthetic */ OmniBgImageInfo(String r110, String r111, boolean r112, List r113, boolean r114, String r115, String r210, String r211, String r212, int r213, String r214, int r215, DefaultConstructorMarker r216) {
        String r100 = null;
        if ((r215 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r102 = null;
    L10:
        int r103 = 0;
        if ((r215 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r215 & 8) == 0) goto L17;
        List r105 = null;
    L19:
        if ((r215 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r215 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r215 & 64) == 0) goto L29;
        String r108 = null;
    L31:
        if ((r215 & 128) == 0) goto L33;
        String r116 = null;
    L35:
        if ((r215 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r215 & 512) != 0) goto L43;
        r103 = r213;
    L43:
        if ((r215 & 1024) != 0) goto L46;
        r100 = r214;
    L46:
        this(r101, r102, r104, r105, r106, r107, r108, r116, r117, r103, r100);
        return;
    L37:
        r117 = r212;
        goto L39
    L33:
        r116 = r211;
        goto L35
    L29:
        r108 = r210;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
