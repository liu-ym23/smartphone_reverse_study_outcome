package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\nHÆ\u0003J`\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/larus/platform/model/chat/AttachmentEditConfig;", "Ljava/io/Serializable;", "reeditWithAttachment", "", "keepAttachmentWhenQuote", "creationCoverFollowUp", "creationVideoCoverFollowUp", "replaceQuoteText", "enterpriseAttachmentMenuEnabled", "blockAttachmentReeditFix", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getReeditWithAttachment", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getKeepAttachmentWhenQuote", "getCreationCoverFollowUp", "getCreationVideoCoverFollowUp", "getReplaceQuoteText", "getEnterpriseAttachmentMenuEnabled", "getBlockAttachmentReeditFix", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/larus/platform/model/chat/AttachmentEditConfig;", "equals", "other", "", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentEditConfig implements Serializable {

    @SerializedName("block_attachment_reedit_fix")
    private final boolean blockAttachmentReeditFix;

    @SerializedName("creation_cover_follow_up")
    private final Integer creationCoverFollowUp;

    @SerializedName("enable_video_follow_up")
    private final Integer creationVideoCoverFollowUp;

    @SerializedName("enterprise_attachment_menu_enabled")
    private final Integer enterpriseAttachmentMenuEnabled;

    @SerializedName("keep_attachment_when_quote")
    private final Integer keepAttachmentWhenQuote;

    @SerializedName("reedit_with_attachment")
    private final Integer reeditWithAttachment;

    @SerializedName("replace_quote_text")
    private final Integer replaceQuoteText;

    public AttachmentEditConfig() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public static /* synthetic */ AttachmentEditConfig copy$default(AttachmentEditConfig r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r110, Integer r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.reeditWithAttachment;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.keepAttachmentWhenQuote;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.creationCoverFollowUp;
    L11:
        Integer r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.creationVideoCoverFollowUp;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.replaceQuoteText;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.enterpriseAttachmentMenuEnabled;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.blockAttachmentReeditFix;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.reeditWithAttachment;
    }

    public final Integer component2() {
        return this.keepAttachmentWhenQuote;
    }

    public final Integer component3() {
        return this.creationCoverFollowUp;
    }

    public final Integer component4() {
        return this.creationVideoCoverFollowUp;
    }

    public final Integer component5() {
        return this.replaceQuoteText;
    }

    public final Integer component6() {
        return this.enterpriseAttachmentMenuEnabled;
    }

    public final boolean component7() {
        return this.blockAttachmentReeditFix;
    }

    public final AttachmentEditConfig copy(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, boolean r116) {
        return new AttachmentEditConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttachmentEditConfig) == true) goto L8;
        return false;
    L8:
        AttachmentEditConfig r101 = (AttachmentEditConfig) r100;
        if (Intrinsics.areEqual(this.reeditWithAttachment, r101.reeditWithAttachment) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keepAttachmentWhenQuote, r101.keepAttachmentWhenQuote) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creationCoverFollowUp, r101.creationCoverFollowUp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creationVideoCoverFollowUp, r101.creationVideoCoverFollowUp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.replaceQuoteText, r101.replaceQuoteText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enterpriseAttachmentMenuEnabled, r101.enterpriseAttachmentMenuEnabled) == true) goto L27;
        return false;
    L27:
        if (this.blockAttachmentReeditFix == r101.blockAttachmentReeditFix) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.reeditWithAttachment;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.keepAttachmentWhenQuote;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.creationCoverFollowUp;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.creationVideoCoverFollowUp;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.replaceQuoteText;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.enterpriseAttachmentMenuEnabled;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        if (this.blockAttachmentReeditFix == false) goto L29;
        int r118 = 1231;
    L31:
        return r117 + r118;
    L29:
        r118 = 1237;
        goto L31
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
        return "AttachmentEditConfig(reeditWithAttachment=" + this.reeditWithAttachment + ", keepAttachmentWhenQuote=" + this.keepAttachmentWhenQuote + ", creationCoverFollowUp=" + this.creationCoverFollowUp + ", creationVideoCoverFollowUp=" + this.creationVideoCoverFollowUp + ", replaceQuoteText=" + this.replaceQuoteText + ", enterpriseAttachmentMenuEnabled=" + this.enterpriseAttachmentMenuEnabled + ", blockAttachmentReeditFix=" + this.blockAttachmentReeditFix + ')';
    }

    public final boolean getBlockAttachmentReeditFix() {
        return this.blockAttachmentReeditFix;
    }

    public final Integer getCreationCoverFollowUp() {
        return this.creationCoverFollowUp;
    }

    public final Integer getCreationVideoCoverFollowUp() {
        return this.creationVideoCoverFollowUp;
    }

    public final Integer getEnterpriseAttachmentMenuEnabled() {
        return this.enterpriseAttachmentMenuEnabled;
    }

    public final Integer getKeepAttachmentWhenQuote() {
        return this.keepAttachmentWhenQuote;
    }

    public final Integer getReeditWithAttachment() {
        return this.reeditWithAttachment;
    }

    public final Integer getReplaceQuoteText() {
        return this.replaceQuoteText;
    }

    public AttachmentEditConfig(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, boolean r106) {
        this.reeditWithAttachment = r100;
        this.keepAttachmentWhenQuote = r101;
        this.creationCoverFollowUp = r102;
        this.creationVideoCoverFollowUp = r103;
        this.replaceQuoteText = r104;
        this.enterpriseAttachmentMenuEnabled = r105;
        this.blockAttachmentReeditFix = r106;
    }

    public /* synthetic */ AttachmentEditConfig(Integer r100, Integer r101, Integer r102, Integer r103, Integer r110, Integer r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        Integer r104 = 0;
        if ((r113 & 1) == 0) goto L5;
        Integer r115 = r104;
    L7:
        if ((r113 & 2) == 0) goto L9;
        Integer r105 = r104;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Integer r106 = r104;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Integer r107 = r104;
    L19:
        if ((r113 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r113 & 32) == 0) goto L25;
        r111 = 1;
    L25:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L28;
        boolean r116 = true;
    L29:
        this(r115, r105, r106, r107, r104, r108, r116);
        return;
    L28:
        r116 = r112;
        goto L29
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
        r115 = r100;
        goto L7
    }
}
