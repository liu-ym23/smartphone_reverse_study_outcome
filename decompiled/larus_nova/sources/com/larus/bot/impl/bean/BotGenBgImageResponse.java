package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JR\u0010\u001e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/larus/bot/impl/bean/BotGenBgImageResponse;", "Ljava/io/Serializable;", "bgImgList", "", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "bgImgPrompt", "", "bgImgPromptEn", "bgImgOpen", "", "bgCategoryType", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBgImgList", "()Ljava/util/List;", "getBgImgPrompt", "()Ljava/lang/String;", "getBgImgPromptEn", "getBgImgOpen", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBgCategoryType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/bot/impl/bean/BotGenBgImageResponse;", "equals", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotGenBgImageResponse implements Serializable {

    @SerializedName("bot_category_type")
    private final Integer bgCategoryType;

    @SerializedName("bg_img_list")
    private final List<BotAvatarIconData> bgImgList;

    @SerializedName("bg_img_open")
    private final Boolean bgImgOpen;

    @SerializedName("bg_img_prompt")
    private final String bgImgPrompt;

    @SerializedName("bg_img_prompt_en")
    private final String bgImgPromptEn;

    public BotGenBgImageResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotGenBgImageResponse copy$default(BotGenBgImageResponse r100, List r101, String r102, String r103, Boolean r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.bgImgList;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.bgImgPrompt;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.bgImgPromptEn;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.bgImgOpen;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.bgCategoryType;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<BotAvatarIconData> component1() {
        return this.bgImgList;
    }

    public final String component2() {
        return this.bgImgPrompt;
    }

    public final String component3() {
        return this.bgImgPromptEn;
    }

    public final Boolean component4() {
        return this.bgImgOpen;
    }

    public final Integer component5() {
        return this.bgCategoryType;
    }

    public final BotGenBgImageResponse copy(List<BotAvatarIconData> r100, String r101, String r110, Boolean r111, Integer r112) {
        return new BotGenBgImageResponse(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotGenBgImageResponse) == true) goto L8;
        return false;
    L8:
        BotGenBgImageResponse r101 = (BotGenBgImageResponse) r100;
        if (Intrinsics.areEqual(this.bgImgList, r101.bgImgList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgImgPrompt, r101.bgImgPrompt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImgPromptEn, r101.bgImgPromptEn) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgImgOpen, r101.bgImgOpen) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgCategoryType, r101.bgCategoryType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<BotAvatarIconData> r100 = this.bgImgList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgImgPrompt;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgImgPromptEn;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.bgImgOpen;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.bgCategoryType;
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
        return "BotGenBgImageResponse(bgImgList=" + this.bgImgList + ", bgImgPrompt=" + this.bgImgPrompt + ", bgImgPromptEn=" + this.bgImgPromptEn + ", bgImgOpen=" + this.bgImgOpen + ", bgCategoryType=" + this.bgCategoryType + ')';
    }

    public final Integer getBgCategoryType() {
        return this.bgCategoryType;
    }

    public final List<BotAvatarIconData> getBgImgList() {
        return this.bgImgList;
    }

    public final Boolean getBgImgOpen() {
        return this.bgImgOpen;
    }

    public final String getBgImgPrompt() {
        return this.bgImgPrompt;
    }

    public final String getBgImgPromptEn() {
        return this.bgImgPromptEn;
    }

    public BotGenBgImageResponse(List<BotAvatarIconData> r100, String r101, String r102, Boolean r103, Integer r104) {
        this.bgImgList = r100;
        this.bgImgPrompt = r101;
        this.bgImgPromptEn = r102;
        this.bgImgOpen = r103;
        this.bgCategoryType = r104;
    }

    public /* synthetic */ BotGenBgImageResponse(List r100, String r101, String r102, Boolean r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        List r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Boolean r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
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
