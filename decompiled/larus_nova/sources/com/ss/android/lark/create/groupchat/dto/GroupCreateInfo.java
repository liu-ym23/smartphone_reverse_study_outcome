package com.ss.android.lark.create.groupchat.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001PBu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010)J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÂ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003Jw\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010J\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020NHÖ\u0001J\t\u0010O\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0012\"\u0004\b%\u0010\u0014R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001a\u0010-\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001a\u00100\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u001a\u00103\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R\u001a\u00106\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014R\u001c\u00108\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001c¨\u0006Q"}, d2 = {"Lcom/ss/android/lark/create/groupchat/dto/GroupCreateInfo;", "Ljava/io/Serializable;", "isOpenChat", "", "mode", "Lcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;", "isPublicInner", "name", "", "description", "fromChatId", "showGroupTypeSelector", "isCreateTopicGroup", "isCrossTenant", "isCrossWithKa", "needBadge", "<init>", "(ZLcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZ)V", "()Z", "setOpenChat", "(Z)V", "getMode", "()Lcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;", "setMode", "(Lcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getFromChatId", "setFromChatId", "getShowGroupTypeSelector", "setShowGroupTypeSelector", "setCreateTopicGroup", "setCrossTenant", "setCrossWithKa", "getNeedBadge", "setNeedBadge", "onTypeChangeListener", "Lcom/ss/android/lark/create/groupchat/dto/GroupCreateInfo$OnTypeChangeListener;", "value", "isPublic", "setPublic", "enableCreateSecretGroup", "getEnableCreateSecretGroup", "setEnableCreateSecretGroup", "enableCreatePrivateModeChat", "getEnableCreatePrivateModeChat", "setEnableCreatePrivateModeChat", "hasMultiEntity", "getHasMultiEntity", "setHasMultiEntity", "isEnableChatPreview", "setEnableChatPreview", "linkedUrl", "getLinkedUrl", "setLinkedUrl", "setTypeChangeListener", "", "listener", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "", "toString", "OnTypeChangeListener", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupCreateInfo implements Serializable {
    private String description;
    private boolean enableCreatePrivateModeChat;
    private boolean enableCreateSecretGroup;
    private String fromChatId;
    private boolean hasMultiEntity;
    private boolean isCreateTopicGroup;
    private boolean isCrossTenant;
    private boolean isCrossWithKa;
    private boolean isEnableChatPreview;
    private boolean isOpenChat;
    private boolean isPublic;
    private boolean isPublicInner;
    private String linkedUrl;
    private CreateGroupMode mode;
    private String name;
    private boolean needBadge;
    private boolean showGroupTypeSelector;

    public interface a {
    }

    public GroupCreateInfo() {
        this(false, null, false, null, null, null, false, false, false, false, false, 2047, null);
    }

    public static /* synthetic */ GroupCreateInfo copy$default(GroupCreateInfo r110, boolean r111, CreateGroupMode r112, boolean r113, String r114, String r115, String r116, boolean r117, boolean r210, boolean r211, boolean r212, boolean r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        boolean r100 = r110.isOpenChat;
    L7:
        if ((r214 & 2) == 0) goto L9;
        CreateGroupMode r101 = r110.mode;
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r102 = r110.isPublicInner;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.name;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.description;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.fromChatId;
    L27:
        if ((r214 & 64) == 0) goto L29;
        boolean r106 = r110.showGroupTypeSelector;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r107 = r110.isCreateTopicGroup;
    L35:
        if ((r214 & 256) == 0) goto L37;
        boolean r118 = r110.isCrossTenant;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r119 = r110.isCrossWithKa;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        boolean r108 = r110.needBadge;
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

    public final boolean component1() {
        return this.isOpenChat;
    }

    public final boolean component10() {
        return this.isCrossWithKa;
    }

    public final boolean component11() {
        return this.needBadge;
    }

    public final CreateGroupMode component2() {
        return this.mode;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.fromChatId;
    }

    public final boolean component7() {
        return this.showGroupTypeSelector;
    }

    public final boolean component8() {
        return this.isCreateTopicGroup;
    }

    public final boolean component9() {
        return this.isCrossTenant;
    }

    public final GroupCreateInfo copy(boolean r110, CreateGroupMode r111, boolean r112, String r113, String r114, String r115, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r111, "mode");
        Intrinsics.checkNotNullParameter(r113, "name");
        Intrinsics.checkNotNullParameter(r114, "description");
        Intrinsics.checkNotNullParameter(r115, "fromChatId");
        return new GroupCreateInfo(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GroupCreateInfo) == true) goto L8;
        return false;
    L8:
        GroupCreateInfo r101 = (GroupCreateInfo) r100;
        if (this.isOpenChat == r101.isOpenChat) goto L12;
        return false;
    L12:
        if (this.mode == r101.mode) goto L15;
        return false;
    L15:
        if (this.isPublicInner == r101.isPublicInner) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fromChatId, r101.fromChatId) == true) goto L27;
        return false;
    L27:
        if (this.showGroupTypeSelector == r101.showGroupTypeSelector) goto L30;
        return false;
    L30:
        if (this.isCreateTopicGroup == r101.isCreateTopicGroup) goto L33;
        return false;
    L33:
        if (this.isCrossTenant == r101.isCrossTenant) goto L36;
        return false;
    L36:
        if (this.isCrossWithKa == r101.isCrossWithKa) goto L39;
        return false;
    L39:
        if (this.needBadge == r101.needBadge) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isOpenChat == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.mode.hashCode()) * 31;
        if (this.isPublicInner == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((((r102 + r103) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.fromChatId.hashCode()) * 31;
        if (this.showGroupTypeSelector == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.isCreateTopicGroup == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.isCrossTenant == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.isCrossWithKa == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.needBadge == true) goto L31;
        r100 = 1237;
    L31:
        return r112 + r100;
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final void setTypeChangeListener(a r100) {
    }

    public String toString() {
        return "GroupCreateInfo(isOpenChat=" + this.isOpenChat + ", mode=" + this.mode + ", isPublicInner=" + this.isPublicInner + ", name=" + this.name + ", description=" + this.description + ", fromChatId=" + this.fromChatId + ", showGroupTypeSelector=" + this.showGroupTypeSelector + ", isCreateTopicGroup=" + this.isCreateTopicGroup + ", isCrossTenant=" + this.isCrossTenant + ", isCrossWithKa=" + this.isCrossWithKa + ", needBadge=" + this.needBadge + ')';
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getEnableCreatePrivateModeChat() {
        return this.enableCreatePrivateModeChat;
    }

    public final boolean getEnableCreateSecretGroup() {
        return this.enableCreateSecretGroup;
    }

    public final String getFromChatId() {
        return this.fromChatId;
    }

    public final boolean getHasMultiEntity() {
        return this.hasMultiEntity;
    }

    public final String getLinkedUrl() {
        return this.linkedUrl;
    }

    public final CreateGroupMode getMode() {
        return this.mode;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedBadge() {
        return this.needBadge;
    }

    public final boolean getShowGroupTypeSelector() {
        return this.showGroupTypeSelector;
    }

    public final boolean isCreateTopicGroup() {
        return this.isCreateTopicGroup;
    }

    public final boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public final boolean isCrossWithKa() {
        return this.isCrossWithKa;
    }

    public final boolean isEnableChatPreview() {
        return this.isEnableChatPreview;
    }

    public final boolean isOpenChat() {
        return this.isOpenChat;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final void setCreateTopicGroup(boolean r100) {
        this.isCreateTopicGroup = r100;
    }

    public final void setCrossTenant(boolean r100) {
        this.isCrossTenant = r100;
    }

    public final void setCrossWithKa(boolean r100) {
        this.isCrossWithKa = r100;
    }

    public final void setDescription(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.description = r100;
    }

    public final void setEnableChatPreview(boolean r100) {
        this.isEnableChatPreview = r100;
    }

    public final void setEnableCreatePrivateModeChat(boolean r100) {
        this.enableCreatePrivateModeChat = r100;
    }

    public final void setEnableCreateSecretGroup(boolean r100) {
        this.enableCreateSecretGroup = r100;
    }

    public final void setFromChatId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fromChatId = r100;
    }

    public final void setHasMultiEntity(boolean r100) {
        this.hasMultiEntity = r100;
    }

    public final void setLinkedUrl(String r100) {
        this.linkedUrl = r100;
    }

    public final void setMode(CreateGroupMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mode = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setNeedBadge(boolean r100) {
        this.needBadge = r100;
    }

    public final void setOpenChat(boolean r100) {
        this.isOpenChat = r100;
    }

    public final void setPublic(boolean r100) {
        this.isPublic = r100;
        this.isPublicInner = r100;
    }

    public final void setShowGroupTypeSelector(boolean r100) {
        this.showGroupTypeSelector = r100;
    }

    public GroupCreateInfo(boolean r100, CreateGroupMode r101, boolean r102, String r103, String r104, String r105, boolean r106, boolean r107, boolean r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r101, "mode");
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r104, "description");
        Intrinsics.checkNotNullParameter(r105, "fromChatId");
        this.isOpenChat = r100;
        this.mode = r101;
        this.isPublicInner = r102;
        this.name = r103;
        this.description = r104;
        this.fromChatId = r105;
        this.showGroupTypeSelector = r106;
        this.isCreateTopicGroup = r107;
        this.isCrossTenant = r110;
        this.isCrossWithKa = r111;
        this.needBadge = r112;
        this.isPublic = r102;
        this.enableCreateSecretGroup = true;
    }

    public /* synthetic */ GroupCreateInfo(boolean r110, CreateGroupMode r111, boolean r112, String r113, String r114, String r115, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, int r215, DefaultConstructorMarker r216) {
        boolean r100 = true;
        if ((r215 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r215 & 2) == 0) goto L9;
        CreateGroupMode r102 = CreateGroupMode.CONVERSATION_MODE;
    L10:
        boolean r103 = false;
        if ((r215 & 4) == 0) goto L13;
        boolean r104 = false;
    L14:
        String r105 = "";
        if ((r215 & 8) == 0) goto L17;
        String r106 = "";
    L19:
        if ((r215 & 16) == 0) goto L21;
        String r107 = "";
    L23:
        if ((r215 & 32) != 0) goto L27;
        r105 = r115;
    L27:
        if ((r215 & 64) == 0) goto L29;
        boolean r108 = false;
    L31:
        if ((r215 & 128) == 0) goto L33;
        boolean r116 = false;
    L35:
        if ((r215 & 256) == 0) goto L37;
        boolean r117 = false;
    L39:
        if ((r215 & 512) != 0) goto L43;
        r103 = r213;
    L43:
        if ((r215 & 1024) != 0) goto L46;
        r100 = r214;
    L46:
        this(r101, r102, r104, r106, r107, r105, r108, r116, r117, r103, r100);
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
    L21:
        r107 = r114;
        goto L23
    L17:
        r106 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
