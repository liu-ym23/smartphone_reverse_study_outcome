package com.ss.android.lark.export.entity.preview;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.tangram.base.style.Value;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010!HÆ\u0003JÎ\u0001\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\t2\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0005HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006_"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/PreviewData;", "Ljava/io/Serializable;", "string", "", "int", "", "long", "", "boolean", "", "float", "", "items", "Lcom/ss/android/lark/export/entity/preview/Items;", "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", GXTemplateKey.FLEXBOX_PADDING, "Lcom/ss/android/lark/export/entity/preview/Padding;", "imageSet", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "themeColors", "Lcom/ss/android/lark/export/entity/preview/ThemeColors;", "layoutValue", "Lcom/ss/android/lark/tangram/base/style/Value;", "chatterInfos", "Lcom/ss/android/lark/export/entity/preview/ChatterInfos;", "stringList", "Lcom/ss/android/lark/export/entity/preview/StringList;", "chatterInfo", "Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "fontLevel", "Lcom/ss/android/lark/export/entity/preview/FontLevel;", "tagList", "Lcom/ss/android/lark/export/entity/preview/TagList;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Float;Lcom/ss/android/lark/export/entity/preview/Items;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/Padding;Lcom/ss/android/lark/export/entity/preview/ImageSet;Lcom/ss/android/lark/export/entity/preview/ThemeColors;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/export/entity/preview/ChatterInfos;Lcom/ss/android/lark/export/entity/preview/StringList;Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;Lcom/ss/android/lark/export/entity/preview/FontLevel;Lcom/ss/android/lark/export/entity/preview/TagList;)V", "getString", "()Ljava/lang/String;", "getInt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLong", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBoolean", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFloat", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getItems", "()Lcom/ss/android/lark/export/entity/preview/Items;", "getThemeColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "getPadding", "()Lcom/ss/android/lark/export/entity/preview/Padding;", "getImageSet", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "getThemeColors", "()Lcom/ss/android/lark/export/entity/preview/ThemeColors;", "getLayoutValue", "()Lcom/ss/android/lark/tangram/base/style/Value;", "getChatterInfos", "()Lcom/ss/android/lark/export/entity/preview/ChatterInfos;", "getStringList", "()Lcom/ss/android/lark/export/entity/preview/StringList;", "getChatterInfo", "()Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "getFontLevel", "()Lcom/ss/android/lark/export/entity/preview/FontLevel;", "getTagList", "()Lcom/ss/android/lark/export/entity/preview/TagList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Float;Lcom/ss/android/lark/export/entity/preview/Items;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/Padding;Lcom/ss/android/lark/export/entity/preview/ImageSet;Lcom/ss/android/lark/export/entity/preview/ThemeColors;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/export/entity/preview/ChatterInfos;Lcom/ss/android/lark/export/entity/preview/StringList;Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;Lcom/ss/android/lark/export/entity/preview/FontLevel;Lcom/ss/android/lark/export/entity/preview/TagList;)Lcom/ss/android/lark/export/entity/preview/PreviewData;", "equals", "other", "", "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewData implements Serializable {

    /* JADX INFO: renamed from: boolean, reason: not valid java name */
    private final Boolean f114boolean;
    private final AvatarChatterInfo chatterInfo;
    private final ChatterInfos chatterInfos;

    /* JADX INFO: renamed from: float, reason: not valid java name */
    private final Float f115float;
    private final FontLevel fontLevel;
    private final ImageSet imageSet;

    /* JADX INFO: renamed from: int, reason: not valid java name */
    private final Integer f116int;
    private final Items items;
    private final Value layoutValue;

    /* JADX INFO: renamed from: long, reason: not valid java name */
    private final Long f117long;
    private final Padding padding;
    private final String string;
    private final StringList stringList;
    private final TagList tagList;
    private final ThemeColor themeColor;
    private final ThemeColors themeColors;

    public static /* synthetic */ PreviewData copy$default(PreviewData r110, String r111, Integer r112, Long r210, Boolean r211, Float r212, Items r213, ThemeColor r214, Padding r215, ImageSet r216, ThemeColors r217, Value r218, ChatterInfos r219, StringList r310, AvatarChatterInfo r311, FontLevel r312, TagList r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.string;
    L7:
        if ((r314 & 2) == 0) goto L9;
        Integer r101 = r110.f116int;
    L11:
        if ((r314 & 4) == 0) goto L13;
        Long r102 = r110.f117long;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Boolean r103 = r110.f114boolean;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Float r104 = r110.f115float;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Items r105 = r110.items;
    L27:
        if ((r314 & 64) == 0) goto L29;
        ThemeColor r106 = r110.themeColor;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Padding r107 = r110.padding;
    L35:
        if ((r314 & 256) == 0) goto L37;
        ImageSet r113 = r110.imageSet;
    L39:
        if ((r314 & 512) == 0) goto L41;
        ThemeColors r114 = r110.themeColors;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Value r115 = r110.layoutValue;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        ChatterInfos r116 = r110.chatterInfos;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        StringList r117 = r110.stringList;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        AvatarChatterInfo r118 = r110.chatterInfo;
    L58:
        AvatarChatterInfo r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        FontLevel r119 = r110.fontLevel;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        TagList r108 = r110.tagList;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.string;
    }

    public final ThemeColors component10() {
        return this.themeColors;
    }

    public final Value component11() {
        return this.layoutValue;
    }

    public final ChatterInfos component12() {
        return this.chatterInfos;
    }

    public final StringList component13() {
        return this.stringList;
    }

    public final AvatarChatterInfo component14() {
        return this.chatterInfo;
    }

    public final FontLevel component15() {
        return this.fontLevel;
    }

    public final TagList component16() {
        return this.tagList;
    }

    public final Integer component2() {
        return this.f116int;
    }

    public final Long component3() {
        return this.f117long;
    }

    public final Boolean component4() {
        return this.f114boolean;
    }

    public final Float component5() {
        return this.f115float;
    }

    public final Items component6() {
        return this.items;
    }

    public final ThemeColor component7() {
        return this.themeColor;
    }

    public final Padding component8() {
        return this.padding;
    }

    public final ImageSet component9() {
        return this.imageSet;
    }

    public final PreviewData copy(String r110, Integer r210, Long r211, Boolean r212, Float r213, Items r214, ThemeColor r215, Padding r216, ImageSet r217, ThemeColors r218, Value r219, ChatterInfos r310, StringList r311, AvatarChatterInfo r312, FontLevel r313, TagList r314) {
        return new PreviewData(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreviewData) == true) goto L8;
        return false;
    L8:
        PreviewData r101 = (PreviewData) r100;
        if (Intrinsics.areEqual(this.string, r101.string) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f116int, r101.f116int) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f117long, r101.f117long) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f114boolean, r101.f114boolean) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f115float, r101.f115float) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.themeColor, r101.themeColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imageSet, r101.imageSet) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.themeColors, r101.themeColors) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.layoutValue, r101.layoutValue) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.chatterInfos, r101.chatterInfos) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.stringList, r101.stringList) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.chatterInfo, r101.chatterInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.fontLevel, r101.fontLevel) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r100 = this.string;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f116int;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f117long;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f114boolean;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.f115float;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Items r116 = this.items;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ThemeColor r119 = this.themeColor;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Padding r122 = this.padding;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        ImageSet r125 = this.imageSet;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        ThemeColors r128 = this.themeColors;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Value r131 = this.layoutValue;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        ChatterInfos r134 = this.chatterInfos;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        StringList r137 = this.stringList;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        AvatarChatterInfo r140 = this.chatterInfo;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        FontLevel r143 = this.fontLevel;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        TagList r146 = this.tagList;
        if (r146 == null) goto L67;
        r101 = r146.hashCode();
    L67:
        return r145 + r101;
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "PreviewData(string=" + this.string + ", int=" + this.f116int + ", long=" + this.f117long + ", boolean=" + this.f114boolean + ", float=" + this.f115float + ", items=" + this.items + ", themeColor=" + this.themeColor + ", padding=" + this.padding + ", imageSet=" + this.imageSet + ", themeColors=" + this.themeColors + ", layoutValue=" + this.layoutValue + ", chatterInfos=" + this.chatterInfos + ", stringList=" + this.stringList + ", chatterInfo=" + this.chatterInfo + ", fontLevel=" + this.fontLevel + ", tagList=" + this.tagList + ')';
    }

    public final Boolean getBoolean() {
        return this.f114boolean;
    }

    public final AvatarChatterInfo getChatterInfo() {
        return this.chatterInfo;
    }

    public final ChatterInfos getChatterInfos() {
        return this.chatterInfos;
    }

    public final Float getFloat() {
        return this.f115float;
    }

    public final FontLevel getFontLevel() {
        return this.fontLevel;
    }

    public final ImageSet getImageSet() {
        return this.imageSet;
    }

    public final Integer getInt() {
        return this.f116int;
    }

    public final Items getItems() {
        return this.items;
    }

    public final Value getLayoutValue() {
        return this.layoutValue;
    }

    public final Long getLong() {
        return this.f117long;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final String getString() {
        return this.string;
    }

    public final StringList getStringList() {
        return this.stringList;
    }

    public final TagList getTagList() {
        return this.tagList;
    }

    public final ThemeColor getThemeColor() {
        return this.themeColor;
    }

    public final ThemeColors getThemeColors() {
        return this.themeColors;
    }

    public PreviewData(String r100, Integer r101, Long r102, Boolean r103, Float r104, Items r105, ThemeColor r106, Padding r110, ImageSet r111, ThemeColors r112, Value r113, ChatterInfos r114, StringList r115, AvatarChatterInfo r116, FontLevel r117, TagList r118) {
        this.string = r100;
        this.f116int = r101;
        this.f117long = r102;
        this.f114boolean = r103;
        this.f115float = r104;
        this.items = r105;
        this.themeColor = r106;
        this.padding = r110;
        this.imageSet = r111;
        this.themeColors = r112;
        this.layoutValue = r113;
        this.chatterInfos = r114;
        this.stringList = r115;
        this.chatterInfo = r116;
        this.fontLevel = r117;
        this.tagList = r118;
    }
}
