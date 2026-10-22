package com.larus.audio.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.bot.IconItem;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0018\u00010\n\u0012\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0003\u0018\u00010\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0017\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nHÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003J\u001d\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0018\u00010\nHÆ\u0003J\u001d\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0003\u0018\u00010\nHÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003JÅ\u0001\u00106\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0018\u00010\n2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0003\u0018\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\r2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001J\u0013\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u000bHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001bR&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R2\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R*\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0016\u0010\u0014\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#¨\u0006="}, d2 = {"Lcom/larus/audio/bean/AudioUserConfig;", "Ljava/io/Serializable;", "voiceList", "", "Lcom/larus/im/bean/bot/ModelItem;", "newVoiceList", "Lcom/larus/im/bean/bot/SpeakerVoice;", "ugcVoiceIconList", "Lcom/larus/im/bean/bot/IconItem;", "asrModelMap", "", "", "hasUgcVoiceRecord", "", "voiceTalkList", "tabMap", "Lcom/larus/audio/bean/VoiceListTabInfo;", "active", "ttsFeedbackItemList", "Lcom/larus/audio/bean/TtsFeedbackItem;", "supportRealtimeCallBot", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;ZLjava/util/Map;Ljava/util/Map;ZLjava/util/List;Z)V", "getVoiceList", "()Ljava/util/List;", "getNewVoiceList", "setNewVoiceList", "(Ljava/util/List;)V", "getUgcVoiceIconList", "setUgcVoiceIconList", "getAsrModelMap", "()Ljava/util/Map;", "setAsrModelMap", "(Ljava/util/Map;)V", "getHasUgcVoiceRecord", "()Z", "setHasUgcVoiceRecord", "(Z)V", "getVoiceTalkList", "setVoiceTalkList", "getTabMap", "getActive", "getTtsFeedbackItemList", "getSupportRealtimeCallBot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioUserConfig implements Serializable {

    @SerializedName("active")
    private final boolean active;

    @SerializedName("asr_model_map")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private Map<String, ModelItem> asrModelMap;

    @SerializedName("has_ugc_voice_record")
    private boolean hasUgcVoiceRecord;

    @SerializedName("new_voice_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<SpeakerVoice> newVoiceList;

    @SerializedName("hit_call_direct")
    private final boolean supportRealtimeCallBot;

    @SerializedName("voice_list_tab_info")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, List<VoiceListTabInfo>> tabMap;

    @SerializedName("audio_voice_feedback_item_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<TtsFeedbackItem> ttsFeedbackItemList;

    @SerializedName("ugc_voice_icon_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<IconItem> ugcVoiceIconList;

    @SerializedName("voice_list")
    private final List<ModelItem> voiceList;

    @SerializedName("ugc_voice_freetalk_list_by_language")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private Map<String, ? extends List<String>> voiceTalkList;

    public AudioUserConfig() {
        this(null, null, null, null, false, null, null, false, null, false, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AudioUserConfig copy$default(AudioUserConfig r110, List r111, List r112, List r113, Map r114, boolean r115, Map r116, Map r117, boolean r118, List r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        List r100 = r110.voiceList;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r101 = r110.newVoiceList;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r102 = r110.ugcVoiceIconList;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Map r103 = r110.asrModelMap;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = r110.hasUgcVoiceRecord;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Map r105 = r110.voiceTalkList;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Map r106 = r110.tabMap;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.active;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r119 = r110.ttsFeedbackItemList;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.supportRealtimeCallBot;
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

    public final List<ModelItem> component1() {
        return this.voiceList;
    }

    public final boolean component10() {
        return this.supportRealtimeCallBot;
    }

    public final List<SpeakerVoice> component2() {
        return this.newVoiceList;
    }

    public final List<IconItem> component3() {
        return this.ugcVoiceIconList;
    }

    public final Map<String, ModelItem> component4() {
        return this.asrModelMap;
    }

    public final boolean component5() {
        return this.hasUgcVoiceRecord;
    }

    public final Map<String, List<String>> component6() {
        return this.voiceTalkList;
    }

    public final Map<String, List<VoiceListTabInfo>> component7() {
        return this.tabMap;
    }

    public final boolean component8() {
        return this.active;
    }

    public final List<TtsFeedbackItem> component9() {
        return this.ttsFeedbackItemList;
    }

    public final AudioUserConfig copy(List<ModelItem> r110, List<SpeakerVoice> r111, List<IconItem> r112, Map<String, ModelItem> r113, boolean r114, Map<String, ? extends List<String>> r115, Map<String, ? extends List<VoiceListTabInfo>> r116, boolean r210, List<TtsFeedbackItem> r211, boolean r212) {
        return new AudioUserConfig(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioUserConfig) == true) goto L8;
        return false;
    L8:
        AudioUserConfig r101 = (AudioUserConfig) r100;
        if (Intrinsics.areEqual(this.voiceList, r101.voiceList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.newVoiceList, r101.newVoiceList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ugcVoiceIconList, r101.ugcVoiceIconList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.asrModelMap, r101.asrModelMap) == true) goto L21;
        return false;
    L21:
        if (this.hasUgcVoiceRecord == r101.hasUgcVoiceRecord) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.voiceTalkList, r101.voiceTalkList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tabMap, r101.tabMap) == true) goto L30;
        return false;
    L30:
        if (this.active == r101.active) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ttsFeedbackItemList, r101.ttsFeedbackItemList) == true) goto L36;
        return false;
    L36:
        if (this.supportRealtimeCallBot == r101.supportRealtimeCallBot) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        List<ModelItem> r100 = this.voiceList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<SpeakerVoice> r104 = this.newVoiceList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<IconItem> r107 = this.ugcVoiceIconList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, ModelItem> r110 = this.asrModelMap;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.hasUgcVoiceRecord == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, ? extends List<String>> r116 = this.voiceTalkList;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, List<VoiceListTabInfo>> r119 = this.tabMap;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        if (this.active == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (r121 + r122) * 31;
        List<TtsFeedbackItem> r124 = this.ttsFeedbackItemList;
        if (r124 == null) goto L38;
        r101 = r124.hashCode();
    L38:
        int r125 = (r123 + r101) * 31;
        if (this.supportRealtimeCallBot == true) goto L43;
        r113 = 1237;
    L43:
        return r125 + r113;
    L33:
        r122 = 1237;
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = 1237;
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
        return "AudioUserConfig(voiceList=" + this.voiceList + ", newVoiceList=" + this.newVoiceList + ", ugcVoiceIconList=" + this.ugcVoiceIconList + ", asrModelMap=" + this.asrModelMap + ", hasUgcVoiceRecord=" + this.hasUgcVoiceRecord + ", voiceTalkList=" + this.voiceTalkList + ", tabMap=" + this.tabMap + ", active=" + this.active + ", ttsFeedbackItemList=" + this.ttsFeedbackItemList + ", supportRealtimeCallBot=" + this.supportRealtimeCallBot + ')';
    }

    public final boolean getActive() {
        return this.active;
    }

    public final Map<String, ModelItem> getAsrModelMap() {
        return this.asrModelMap;
    }

    public final boolean getHasUgcVoiceRecord() {
        return this.hasUgcVoiceRecord;
    }

    public final List<SpeakerVoice> getNewVoiceList() {
        return this.newVoiceList;
    }

    public final boolean getSupportRealtimeCallBot() {
        return this.supportRealtimeCallBot;
    }

    public final Map<String, List<VoiceListTabInfo>> getTabMap() {
        return this.tabMap;
    }

    public final List<TtsFeedbackItem> getTtsFeedbackItemList() {
        return this.ttsFeedbackItemList;
    }

    public final List<IconItem> getUgcVoiceIconList() {
        return this.ugcVoiceIconList;
    }

    public final List<ModelItem> getVoiceList() {
        return this.voiceList;
    }

    public final Map<String, List<String>> getVoiceTalkList() {
        return this.voiceTalkList;
    }

    public final void setAsrModelMap(Map<String, ModelItem> r100) {
        this.asrModelMap = r100;
    }

    public final void setHasUgcVoiceRecord(boolean r100) {
        this.hasUgcVoiceRecord = r100;
    }

    public final void setNewVoiceList(List<SpeakerVoice> r100) {
        this.newVoiceList = r100;
    }

    public final void setUgcVoiceIconList(List<IconItem> r100) {
        this.ugcVoiceIconList = r100;
    }

    public final void setVoiceTalkList(Map<String, ? extends List<String>> r100) {
        this.voiceTalkList = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioUserConfig(List<ModelItem> r100, List<SpeakerVoice> r101, List<IconItem> r102, Map<String, ModelItem> r103, boolean r104, Map<String, ? extends List<String>> r105, Map<String, ? extends List<VoiceListTabInfo>> r106, boolean r107, List<TtsFeedbackItem> r108, boolean r110) {
        this.voiceList = r100;
        this.newVoiceList = r101;
        this.ugcVoiceIconList = r102;
        this.asrModelMap = r103;
        this.hasUgcVoiceRecord = r104;
        this.voiceTalkList = r105;
        this.tabMap = r106;
        this.active = r107;
        this.ttsFeedbackItemList = r108;
        this.supportRealtimeCallBot = r110;
    }

    public /* synthetic */ AudioUserConfig(List r110, List r111, List r112, Map r113, boolean r114, Map r115, Map r116, boolean r210, List r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        List r100 = null;
        if ((r213 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r213 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r213 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r213 & 8) == 0) goto L17;
        Map r104 = null;
    L19:
        if ((r213 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r213 & 32) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r213 & 64) == 0) goto L29;
        Map r107 = null;
    L30:
        boolean r117 = false;
        if ((r213 & 128) == 0) goto L33;
        boolean r108 = false;
    L35:
        if ((r213 & 256) != 0) goto L39;
        r100 = r211;
    L39:
        if ((r213 & 512) != 0) goto L42;
        r117 = r212;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r117);
        return;
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L30
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
