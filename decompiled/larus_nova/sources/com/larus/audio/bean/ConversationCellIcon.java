package com.larus.audio.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/audio/bean/ConversationCellIcon;", "Ljava/io/Serializable;", "enableBotId", "", "enabledInSubConversation", "", "iconUri", "iconUrl", "schema", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnableBotId", "()Ljava/lang/String;", "getEnabledInSubConversation", "()Z", "getIconUri", "getIconUrl", "getSchema", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationCellIcon implements Serializable {

    @SerializedName("enable_bot_id")
    private final String enableBotId;

    @SerializedName("enable_in_sub_conversation")
    private final boolean enabledInSubConversation;

    @SerializedName("icon_uri")
    private final String iconUri;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("schema")
    private final String schema;

    public ConversationCellIcon() {
        this(null, false, null, null, null, 31, null);
    }

    public static /* synthetic */ ConversationCellIcon copy$default(ConversationCellIcon r100, String r101, boolean r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableBotId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enabledInSubConversation;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.iconUri;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.iconUrl;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.schema;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.enableBotId;
    }

    public final boolean component2() {
        return this.enabledInSubConversation;
    }

    public final String component3() {
        return this.iconUri;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final String component5() {
        return this.schema;
    }

    public final ConversationCellIcon copy(String r100, boolean r101, String r110, String r111, String r112) {
        return new ConversationCellIcon(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationCellIcon) == true) goto L8;
        return false;
    L8:
        ConversationCellIcon r101 = (ConversationCellIcon) r100;
        if (Intrinsics.areEqual(this.enableBotId, r101.enableBotId) == true) goto L12;
        return false;
    L12:
        if (this.enabledInSubConversation == r101.enabledInSubConversation) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUri, r101.iconUri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.enableBotId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.enabledInSubConversation == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.iconUri;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.iconUrl;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.schema;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ConversationCellIcon(enableBotId=" + this.enableBotId + ", enabledInSubConversation=" + this.enabledInSubConversation + ", iconUri=" + this.iconUri + ", iconUrl=" + this.iconUrl + ", schema=" + this.schema + ')';
    }

    public final String getEnableBotId() {
        return this.enableBotId;
    }

    public final boolean getEnabledInSubConversation() {
        return this.enabledInSubConversation;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getSchema() {
        return this.schema;
    }

    public ConversationCellIcon(String r100, boolean r101, String r102, String r103, String r104) {
        this.enableBotId = r100;
        this.enabledInSubConversation = r101;
        this.iconUri = r102;
        this.iconUrl = r103;
        this.schema = r104;
    }

    public /* synthetic */ ConversationCellIcon(String r100, boolean r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
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
