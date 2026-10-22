package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "old link data")
public final class ChatBot {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013JN\u0010\u001b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatBot$Config;", "", "modelList", "", "Lcom/larus/im/bean/bot/ModelItem;", "voiceList", "Lcom/larus/im/bean/bot/SpeakerVoice;", "editPos", "", "muted", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "getModelList", "()Ljava/util/List;", "getVoiceList", "getEditPos", "()Ljava/lang/String;", "getMuted", "()Ljava/lang/Boolean;", "setMuted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/bean/ChatBot$Config;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Config {

        @SerializedName("e")
        private final String editPos;

        @SerializedName("ml")
        private final List<ModelItem> modelList;

        @SerializedName("mu")
        private Boolean muted;

        @SerializedName("vl")
        private final List<SpeakerVoice> voiceList;

        public Config() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Config copy$default(Config r100, List r101, List r102, String r103, Boolean r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.modelList;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.voiceList;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.editPos;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.muted;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final List<ModelItem> component1() {
            return this.modelList;
        }

        public final List<SpeakerVoice> component2() {
            return this.voiceList;
        }

        public final String component3() {
            return this.editPos;
        }

        public final Boolean component4() {
            return this.muted;
        }

        public final Config copy(List<ModelItem> r100, List<SpeakerVoice> r101, String r102, Boolean r103) {
            return new Config(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Config) == true) goto L8;
            return false;
        L8:
            Config r101 = (Config) r100;
            if (Intrinsics.areEqual(this.modelList, r101.modelList) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.voiceList, r101.voiceList) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.editPos, r101.editPos) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.muted, r101.muted) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            List<ModelItem> r100 = this.modelList;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<SpeakerVoice> r104 = this.voiceList;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.editPos;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Boolean r110 = this.muted;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
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
            return "Config(modelList=" + this.modelList + ", voiceList=" + this.voiceList + ", editPos=" + this.editPos + ", muted=" + this.muted + ')';
        }

        public final String getEditPos() {
            return this.editPos;
        }

        public final List<ModelItem> getModelList() {
            return this.modelList;
        }

        public final Boolean getMuted() {
            return this.muted;
        }

        public final List<SpeakerVoice> getVoiceList() {
            return this.voiceList;
        }

        public final void setMuted(Boolean r100) {
            this.muted = r100;
        }

        public Config(List<ModelItem> r100, List<SpeakerVoice> r101, String r102, Boolean r103) {
            this.modelList = r100;
            this.voiceList = r101;
            this.editPos = r102;
            this.muted = r103;
        }

        public /* synthetic */ Config(List r100, List r101, String r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = Boolean.FALSE;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatBot$Prefer;", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/im/bean/bot/ModelItem;", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "<init>", "(Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;)V", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "getVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Prefer {

        @SerializedName("m")
        private final ModelItem model;

        @SerializedName(BaseSwitches.V)
        private final SpeakerVoice voice;

        /* JADX WARN: Multi-variable type inference failed */
        public Prefer() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Prefer copy$default(Prefer r100, ModelItem r101, SpeakerVoice r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.model;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.voice;
        L9:
            return r100.copy(r101, r102);
        }

        public final ModelItem component1() {
            return this.model;
        }

        public final SpeakerVoice component2() {
            return this.voice;
        }

        public final Prefer copy(ModelItem r100, SpeakerVoice r101) {
            return new Prefer(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Prefer) == true) goto L8;
            return false;
        L8:
            Prefer r101 = (Prefer) r100;
            if (Intrinsics.areEqual(this.model, r101.model) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.voice, r101.voice) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            ModelItem r100 = this.model;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            SpeakerVoice r104 = this.voice;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Prefer(model=" + this.model + ", voice=" + this.voice + ')';
        }

        public final ModelItem getModel() {
            return this.model;
        }

        public final SpeakerVoice getVoice() {
            return this.voice;
        }

        public Prefer(ModelItem r100, SpeakerVoice r101) {
            this.model = r100;
            this.voice = r101;
        }

        public /* synthetic */ Prefer(ModelItem r100, SpeakerVoice r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatBot) == true) goto L8;
        return false;
    L8:
        ((ChatBot) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(null, null) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(null, null) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(null, null) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(null, null) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(null, null) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(null, null) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(null, null) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(null, null) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(null, null) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(null, null) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(null, null) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(null, null) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(null, null) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(null, null) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(null, null) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(null, null) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(null, null) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(null, null) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(null, null) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(null, null) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(null, null) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(null, null) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(null, null) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(null, null) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(null, null) == true) goto L107;
        return false;
    L107:
        return true;
    }

    public final String getContext() {
        return null;
    }

    public final String getType() {
        return null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ChatBot(id=null, botId=null, botType=null, botFeatureLabel=null, botMode=null, botConf=null, owner=null, name=null, avatar=null, iconImage=null, iconPrompt=null, desc=null, context=null, time=0, updateTime=null, type=null, status=null, messagePush=null, privateStatus=null, prefer=null, config=null, shareInfo=null, botCreatorInfo=null, conversationPage=null, answerActions=null, menuActions=null, streamingAnswerActions=null, botSwitchConfInfo=null, callerName=null, callerNameSetting=null, bgImgUrl=null, bgImgColor=null, digitalHumanData=null, firstMet=null)";
    }
}
