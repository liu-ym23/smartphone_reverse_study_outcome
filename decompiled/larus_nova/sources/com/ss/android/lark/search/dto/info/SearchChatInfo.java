package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.basic.v1.Tag;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class SearchChatInfo extends SearchBaseInfo {
    private static final long serialVersionUID = 8132510517498607897L;
    private ChatDisplayModeSetting chatDisplayModeSetting;
    private Chat.ChatMode chatMode;
    private Chat.Type chatType;
    private String description;
    private String enterpriseMailAddress;
    private boolean isCountLightStyle;
    private boolean isDelayed;
    private boolean isDepartment;
    private boolean isEnabledEmail;
    private boolean isInTeam;
    private boolean isMeeting;
    private boolean isMember;
    private boolean isOfficialOnCall;
    private boolean isPublic;
    private boolean isSecretChat;
    private boolean isShield;
    private boolean isTenant;
    private boolean isUserCountVisible;
    private int lastMessagePosition;
    private int memberCount;
    private List<Tag> tags;
    private int userCount;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "groups";
    }

    public SearchChatInfo() {
        this.isUserCountVisible = true;
        this.isMember = true;
        this.isCountLightStyle = false;
        this.isEnabledEmail = false;
        this.isShield = false;
        this.lastMessagePosition = -1;
        this.description = "";
        this.isInTeam = false;
        this.type = 2;
    }

    public boolean isThread() {
        if (getChatMode() != Chat.ChatMode.THREAD_V2) goto L5;
    L8:
        return true;
    L5:
        if (getChatMode() == Chat.ChatMode.THREAD) goto L8;
        return false;
    }

    public ChatDisplayModeSetting getChatDisplayModeSetting() {
        return this.chatDisplayModeSetting;
    }

    public Chat.ChatMode getChatMode() {
        return this.chatMode;
    }

    public Chat.Type getChatType() {
        return this.chatType;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEnterpriseMailAddress() {
        return this.enterpriseMailAddress;
    }

    public int getLastMessagePosition() {
        return this.lastMessagePosition;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public boolean isCountLightStyle() {
        return this.isCountLightStyle;
    }

    public boolean isDelayed() {
        return this.isDelayed;
    }

    public boolean isDepartment() {
        return this.isDepartment;
    }

    public boolean isEnabledEmail() {
        return this.isEnabledEmail;
    }

    public boolean isInTeam() {
        return this.isInTeam;
    }

    public boolean isMeeting() {
        return this.isMeeting;
    }

    public boolean isMember() {
        return this.isMember;
    }

    public boolean isOfficialOnCall() {
        return this.isOfficialOnCall;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean isSecretChat() {
        return this.isSecretChat;
    }

    public boolean isShield() {
        return this.isShield;
    }

    public boolean isTenant() {
        return this.isTenant;
    }

    public boolean isUserCountVisible() {
        return this.isUserCountVisible;
    }

    public void setChatDisplayModeSetting(ChatDisplayModeSetting r100) {
        this.chatDisplayModeSetting = r100;
    }

    public void setChatMode(Chat.ChatMode r100) {
        this.chatMode = r100;
    }

    public void setChatType(Chat.Type r100) {
        this.chatType = r100;
    }

    public void setCountLightStyle(boolean r100) {
        this.isCountLightStyle = r100;
    }

    public void setDelayed(boolean r100) {
        this.isDelayed = r100;
    }

    public void setDepartment(boolean r100) {
        this.isDepartment = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setEnabledEmail(boolean r100) {
        this.isEnabledEmail = r100;
    }

    public void setEnterpriseMailAddress(String r100) {
        this.enterpriseMailAddress = r100;
    }

    public void setInTeam(boolean r100) {
        this.isInTeam = r100;
    }

    public void setLastMessagePosition(int r100) {
        this.lastMessagePosition = r100;
    }

    public void setMeeting(boolean r100) {
        this.isMeeting = r100;
    }

    public void setMember(boolean r100) {
        this.isMember = r100;
    }

    public void setMemberCount(int r100) {
        this.memberCount = r100;
    }

    public void setOfficialOnCall(boolean r100) {
        this.isOfficialOnCall = r100;
    }

    public void setPublic(boolean r100) {
        this.isPublic = r100;
    }

    public void setSecretChat(boolean r100) {
        this.isSecretChat = r100;
    }

    public void setShield(boolean r100) {
        this.isShield = r100;
    }

    public void setTags(List<Tag> r100) {
        this.tags = r100;
    }

    public void setTenant(boolean r100) {
        this.isTenant = r100;
    }

    public void setUserCount(int r100) {
        this.userCount = r100;
    }

    public void setUserCountVisible(boolean r100) {
        this.isUserCountVisible = r100;
    }
}
