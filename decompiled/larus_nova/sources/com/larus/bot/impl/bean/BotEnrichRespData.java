package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007HÆ\u0003Ja\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R(\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006*"}, d2 = {"Lcom/larus/bot/impl/bean/BotEnrichRespData;", "", "botName", "", "descriptionForHuman", "prologue", "suggests", "", "voiceId", "data", "Lcom/larus/bot/impl/bean/EnrichBotData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getBotName", "()Ljava/lang/String;", "setBotName", "(Ljava/lang/String;)V", "getDescriptionForHuman", "setDescriptionForHuman", "getPrologue", "setPrologue", "getSuggests", "()Ljava/util/List;", "setSuggests", "(Ljava/util/List;)V", "getVoiceId", "setVoiceId", "getData", "setData", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEnrichRespData {

    @SerializedName("bot_name")
    private String botName;

    @SerializedName("data")
    private List<EnrichBotData> data;

    @SerializedName("description_for_human")
    private String descriptionForHuman;

    @SerializedName("prologue")
    private String prologue;

    @SerializedName("suggest")
    private List<String> suggests;

    @SerializedName("voice_id")
    private String voiceId;

    public BotEnrichRespData() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotEnrichRespData copy$default(BotEnrichRespData r100, String r101, String r102, String r103, List r104, String r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.botName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.descriptionForHuman;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.prologue;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.suggests;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.voiceId;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.data;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.botName;
    }

    public final String component2() {
        return this.descriptionForHuman;
    }

    public final String component3() {
        return this.prologue;
    }

    public final List<String> component4() {
        return this.suggests;
    }

    public final String component5() {
        return this.voiceId;
    }

    public final List<EnrichBotData> component6() {
        return this.data;
    }

    public final BotEnrichRespData copy(String r100, String r110, String r111, List<String> r112, String r113, List<EnrichBotData> r114) {
        return new BotEnrichRespData(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotEnrichRespData) == true) goto L8;
        return false;
    L8:
        BotEnrichRespData r101 = (BotEnrichRespData) r100;
        if (Intrinsics.areEqual(this.botName, r101.botName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.descriptionForHuman, r101.descriptionForHuman) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.prologue, r101.prologue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.suggests, r101.suggests) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.voiceId, r101.voiceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.botName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.descriptionForHuman;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.prologue;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.suggests;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.voiceId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<EnrichBotData> r116 = this.data;
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
        return "BotEnrichRespData(botName=" + this.botName + ", descriptionForHuman=" + this.descriptionForHuman + ", prologue=" + this.prologue + ", suggests=" + this.suggests + ", voiceId=" + this.voiceId + ", data=" + this.data + ')';
    }

    public final String getBotName() {
        return this.botName;
    }

    public final List<EnrichBotData> getData() {
        return this.data;
    }

    public final String getDescriptionForHuman() {
        return this.descriptionForHuman;
    }

    public final String getPrologue() {
        return this.prologue;
    }

    public final List<String> getSuggests() {
        return this.suggests;
    }

    public final String getVoiceId() {
        return this.voiceId;
    }

    public final void setBotName(String r100) {
        this.botName = r100;
    }

    public final void setData(List<EnrichBotData> r100) {
        this.data = r100;
    }

    public final void setDescriptionForHuman(String r100) {
        this.descriptionForHuman = r100;
    }

    public final void setPrologue(String r100) {
        this.prologue = r100;
    }

    public final void setSuggests(List<String> r100) {
        this.suggests = r100;
    }

    public final void setVoiceId(String r100) {
        this.voiceId = r100;
    }

    public BotEnrichRespData(String r100, String r101, String r102, List<String> r103, String r104, List<EnrichBotData> r105) {
        this.botName = r100;
        this.descriptionForHuman = r101;
        this.prologue = r102;
        this.suggests = r103;
        this.voiceId = r104;
        this.data = r105;
    }

    public /* synthetic */ BotEnrichRespData(String r100, String r101, String r102, List r103, String r104, List r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        List r108 = null;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = CollectionsKt.emptyList();
    L25:
        this(r113, r106, r107, r108, r105, r110);
        return;
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
