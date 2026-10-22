package com.larus.bmhome.chat.bean;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "old data flow")
public final class ChatConversation {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatConversation$Config;", "", "sectionTimeout", "", "profileTimeout", "firstIndex", "", "retentionIndex", "lastIndex", "readIndex", "<init>", "(JJIIII)V", "getSectionTimeout", "()J", "getProfileTimeout", "getFirstIndex", "()I", "setFirstIndex", "(I)V", "getRetentionIndex", "setRetentionIndex", "getLastIndex", "setLastIndex", "getReadIndex", "setReadIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Config {

        @SerializedName("fi")
        private int firstIndex;

        @SerializedName("li")
        private int lastIndex;

        @SerializedName(GXTemplateKey.GAIAX_PT)
        private final long profileTimeout;

        @SerializedName("ri")
        private int readIndex;

        @SerializedName("rei")
        private int retentionIndex;

        @SerializedName(Segment.JsonKey.START)
        private final long sectionTimeout;

        public Config() {
            this(0, 0, 0, 0, 0, 0, 63, null);
        }

        public static /* synthetic */ Config copy$default(Config r100, long r110, long r111, int r112, int r113, int r114, int r115, int r116, Object r117) {
            if ((r116 & 1) == 0) goto L5;
            long r101 = r100.sectionTimeout;
        L7:
            if ((r116 & 2) == 0) goto L9;
            long r102 = r100.profileTimeout;
        L11:
            if ((r116 & 4) == 0) goto L13;
            int r103 = r100.firstIndex;
        L15:
            if ((r116 & 8) == 0) goto L17;
            int r104 = r100.retentionIndex;
        L19:
            if ((r116 & 16) == 0) goto L21;
            int r105 = r100.lastIndex;
        L23:
            if ((r116 & 32) == 0) goto L25;
            int r106 = r100.readIndex;
        L27:
            return r100.copy(r101, r102, r103, r104, r105, r106);
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

        public final long component1() {
            return this.sectionTimeout;
        }

        public final long component2() {
            return this.profileTimeout;
        }

        public final int component3() {
            return this.firstIndex;
        }

        public final int component4() {
            return this.retentionIndex;
        }

        public final int component5() {
            return this.lastIndex;
        }

        public final int component6() {
            return this.readIndex;
        }

        public final Config copy(long r110, long r111, int r112, int r113, int r114, int r115) {
            return new Config(r110, r111, r112, r113, r114, r115);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Config) == true) goto L8;
            return false;
        L8:
            Config r101 = (Config) r100;
            if (this.sectionTimeout == r101.sectionTimeout) goto L12;
            return false;
        L12:
            if (this.profileTimeout == r101.profileTimeout) goto L15;
            return false;
        L15:
            if (this.firstIndex == r101.firstIndex) goto L18;
            return false;
        L18:
            if (this.retentionIndex == r101.retentionIndex) goto L21;
            return false;
        L21:
            if (this.lastIndex == r101.lastIndex) goto L24;
            return false;
        L24:
            if (this.readIndex == r101.readIndex) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            long r100 = this.sectionTimeout;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.profileTimeout;
            return ((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.firstIndex) * 31) + this.retentionIndex) * 31) + this.lastIndex) * 31) + this.readIndex;
        }

        public String toString() {
            return "Config(sectionTimeout=" + this.sectionTimeout + ", profileTimeout=" + this.profileTimeout + ", firstIndex=" + this.firstIndex + ", retentionIndex=" + this.retentionIndex + ", lastIndex=" + this.lastIndex + ", readIndex=" + this.readIndex + ')';
        }

        public final int getFirstIndex() {
            return this.firstIndex;
        }

        public final int getLastIndex() {
            return this.lastIndex;
        }

        public final long getProfileTimeout() {
            return this.profileTimeout;
        }

        public final int getReadIndex() {
            return this.readIndex;
        }

        public final int getRetentionIndex() {
            return this.retentionIndex;
        }

        public final long getSectionTimeout() {
            return this.sectionTimeout;
        }

        public final void setFirstIndex(int r100) {
            this.firstIndex = r100;
        }

        public final void setLastIndex(int r100) {
            this.lastIndex = r100;
        }

        public final void setReadIndex(int r100) {
            this.readIndex = r100;
        }

        public final void setRetentionIndex(int r100) {
            this.retentionIndex = r100;
        }

        public Config(long r100, long r101, int r102, int r103, int r104, int r105) {
            this.sectionTimeout = r100;
            this.profileTimeout = r101;
            this.firstIndex = r102;
            this.retentionIndex = r103;
            this.lastIndex = r104;
            this.readIndex = r105;
        }

        public /* synthetic */ Config(long r110, long r111, int r112, int r113, int r114, int r115, int r116, DefaultConstructorMarker r117) {
            if ((r116 & 1) == 0) goto L5;
            long r100 = Long.MAX_VALUE;
        L7:
            if ((r116 & 2) == 0) goto L9;
            long r101 = 86400000;
        L10:
            int r102 = 0;
            if ((r116 & 4) == 0) goto L13;
            int r103 = 0;
        L15:
            if ((r116 & 8) == 0) goto L17;
            int r104 = 0;
        L19:
            if ((r116 & 16) == 0) goto L21;
            int r105 = 0;
        L23:
            if ((r116 & 32) != 0) goto L26;
            r102 = r115;
        L26:
            this(r100, r101, r103, r104, r105, r102);
            return;
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
            r101 = r111;
            goto L10
        L5:
            r100 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatConversation$Prefer;", "", "tts", "", "<init>", "(Z)V", "getTts", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Prefer {

        @SerializedName("tts")
        private final boolean tts;

        public Prefer() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public static /* synthetic */ Prefer copy$default(Prefer r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.tts;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.tts;
        }

        public final Prefer copy(boolean r100) {
            return new Prefer(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Prefer) == true) goto L9;
            return false;
        L9:
            if (this.tts == ((Prefer) r100).tts) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            if (this.tts == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public String toString() {
            return "Prefer(tts=" + this.tts + ')';
        }

        public final boolean getTts() {
            return this.tts;
        }

        public Prefer(boolean r100) {
            this.tts = r100;
        }

        public /* synthetic */ Prefer(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = true;
        L5:
            this(r100);
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
        if ((r100 instanceof ChatConversation) == true) goto L8;
        return false;
    L8:
        ((ChatConversation) r100).getClass();
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
        if (Intrinsics.areEqual(null, null) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(null, null) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(null, null) == true) goto L113;
        return false;
    L113:
        return true;
    }

    public final String getType() {
        return null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ChatConversation(id=null, conversationId=null, conversationType=null, name=null, avatar=null, iconImage=null, time=null, updateTime=null, type=null, status=null, owner=null, priority=null, lastSection=null, lastMessageId=null, lastMessageTime=null, botIdList=null, lastMessageIndex=null, prefer=null, config=null, isLocal=null, recommendBotIndex=null, subtitleMessageId=null, tags=null, pinned=null, conversationPage=null, templates=null, bio=null, botStatus=null, botType=null, bgImgUrl=null, bgImgColor=null, conversationContentType=null, botContentType=null, defaultOnboarding=null, botCreatorInfo=null)";
    }
}
