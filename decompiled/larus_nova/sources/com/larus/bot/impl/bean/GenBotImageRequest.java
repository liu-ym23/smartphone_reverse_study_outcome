package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u008e\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u00061"}, d2 = {"Lcom/larus/bot/impl/bean/GenBotImageRequest;", "Ljava/io/Serializable;", "botName", "", "botDescriptionForHuman", "bgImgPromptEn", "referenceBgImgUri", "referenceBgImStyle", "referenceBgImPrompt", "bgImgDrawStyleStarlingKey", "", "userBotGenderStarlingKey", "userBotTypeStarlingKey", "onlyGenImagePrompt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBotName", "()Ljava/lang/String;", "getBotDescriptionForHuman", "getBgImgPromptEn", "getReferenceBgImgUri", "getReferenceBgImStyle", "getReferenceBgImPrompt", "getBgImgDrawStyleStarlingKey", "()Ljava/util/List;", "getUserBotGenderStarlingKey", "getUserBotTypeStarlingKey", "getOnlyGenImagePrompt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bot/impl/bean/GenBotImageRequest;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenBotImageRequest implements Serializable {

    @SerializedName("bg_img_draw_style_starling_key")
    private final List<String> bgImgDrawStyleStarlingKey;

    @SerializedName("bg_img_prompt_en")
    private final String bgImgPromptEn;

    @SerializedName("bot_description_for_human")
    private final String botDescriptionForHuman;

    @SerializedName("bot_name")
    private final String botName;

    @SerializedName("only_gen_image_prompt")
    private final Boolean onlyGenImagePrompt;

    @SerializedName("reference_bg_img_prompt")
    private final String referenceBgImPrompt;

    @SerializedName("reference_bg_img_style")
    private final String referenceBgImStyle;

    @SerializedName("reference_bg_img_uri")
    private final String referenceBgImgUri;

    @SerializedName("user_bot_gender_starling_key")
    private final String userBotGenderStarlingKey;

    @SerializedName("user_bot_type_starling_key")
    private final String userBotTypeStarlingKey;

    public GenBotImageRequest() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GenBotImageRequest copy$default(GenBotImageRequest r110, String r111, String r112, String r113, String r114, String r115, String r116, List r117, String r118, String r210, Boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.botName;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.botDescriptionForHuman;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.bgImgPromptEn;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.referenceBgImgUri;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.referenceBgImStyle;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.referenceBgImPrompt;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r106 = r110.bgImgDrawStyleStarlingKey;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.userBotGenderStarlingKey;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.userBotTypeStarlingKey;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Boolean r108 = r110.onlyGenImagePrompt;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
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

    public final String component1() {
        return this.botName;
    }

    public final Boolean component10() {
        return this.onlyGenImagePrompt;
    }

    public final String component2() {
        return this.botDescriptionForHuman;
    }

    public final String component3() {
        return this.bgImgPromptEn;
    }

    public final String component4() {
        return this.referenceBgImgUri;
    }

    public final String component5() {
        return this.referenceBgImStyle;
    }

    public final String component6() {
        return this.referenceBgImPrompt;
    }

    public final List<String> component7() {
        return this.bgImgDrawStyleStarlingKey;
    }

    public final String component8() {
        return this.userBotGenderStarlingKey;
    }

    public final String component9() {
        return this.userBotTypeStarlingKey;
    }

    public final GenBotImageRequest copy(String r110, String r111, String r112, String r113, String r114, String r115, List<String> r116, String r210, String r211, Boolean r212) {
        return new GenBotImageRequest(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GenBotImageRequest) == true) goto L8;
        return false;
    L8:
        GenBotImageRequest r101 = (GenBotImageRequest) r100;
        if (Intrinsics.areEqual(this.botName, r101.botName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botDescriptionForHuman, r101.botDescriptionForHuman) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImgPromptEn, r101.bgImgPromptEn) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.referenceBgImgUri, r101.referenceBgImgUri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.referenceBgImStyle, r101.referenceBgImStyle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.referenceBgImPrompt, r101.referenceBgImPrompt) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bgImgDrawStyleStarlingKey, r101.bgImgDrawStyleStarlingKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.userBotGenderStarlingKey, r101.userBotGenderStarlingKey) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.userBotTypeStarlingKey, r101.userBotTypeStarlingKey) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.onlyGenImagePrompt, r101.onlyGenImagePrompt) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.botName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.botDescriptionForHuman;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgImgPromptEn;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.referenceBgImgUri;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.referenceBgImStyle;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.referenceBgImPrompt;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.bgImgDrawStyleStarlingKey;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.userBotGenderStarlingKey;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.userBotTypeStarlingKey;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.onlyGenImagePrompt;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "GenBotImageRequest(botName=" + this.botName + ", botDescriptionForHuman=" + this.botDescriptionForHuman + ", bgImgPromptEn=" + this.bgImgPromptEn + ", referenceBgImgUri=" + this.referenceBgImgUri + ", referenceBgImStyle=" + this.referenceBgImStyle + ", referenceBgImPrompt=" + this.referenceBgImPrompt + ", bgImgDrawStyleStarlingKey=" + this.bgImgDrawStyleStarlingKey + ", userBotGenderStarlingKey=" + this.userBotGenderStarlingKey + ", userBotTypeStarlingKey=" + this.userBotTypeStarlingKey + ", onlyGenImagePrompt=" + this.onlyGenImagePrompt + ')';
    }

    public final List<String> getBgImgDrawStyleStarlingKey() {
        return this.bgImgDrawStyleStarlingKey;
    }

    public final String getBgImgPromptEn() {
        return this.bgImgPromptEn;
    }

    public final String getBotDescriptionForHuman() {
        return this.botDescriptionForHuman;
    }

    public final String getBotName() {
        return this.botName;
    }

    public final Boolean getOnlyGenImagePrompt() {
        return this.onlyGenImagePrompt;
    }

    public final String getReferenceBgImPrompt() {
        return this.referenceBgImPrompt;
    }

    public final String getReferenceBgImStyle() {
        return this.referenceBgImStyle;
    }

    public final String getReferenceBgImgUri() {
        return this.referenceBgImgUri;
    }

    public final String getUserBotGenderStarlingKey() {
        return this.userBotGenderStarlingKey;
    }

    public final String getUserBotTypeStarlingKey() {
        return this.userBotTypeStarlingKey;
    }

    public GenBotImageRequest(String r100, String r101, String r102, String r103, String r104, String r105, List<String> r106, String r107, String r108, Boolean r110) {
        this.botName = r100;
        this.botDescriptionForHuman = r101;
        this.bgImgPromptEn = r102;
        this.referenceBgImgUri = r103;
        this.referenceBgImStyle = r104;
        this.referenceBgImPrompt = r105;
        this.bgImgDrawStyleStarlingKey = r106;
        this.userBotGenderStarlingKey = r107;
        this.userBotTypeStarlingKey = r108;
        this.onlyGenImagePrompt = r110;
    }

    public /* synthetic */ GenBotImageRequest(String r110, String r111, String r112, String r113, String r114, String r115, List r116, String r117, String r210, Boolean r211, int r212, DefaultConstructorMarker r213) {
        Boolean r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
}
