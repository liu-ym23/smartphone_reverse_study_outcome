package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class SearchChatterInfo extends SearchBaseInfo {
    private static final long serialVersionUID = -7571314980887695999L;
    private int botExtType;
    private String botId;
    private boolean canJoinGroup;
    private ChatterDescription chatterDescription;
    private Chatter.ChatterType chatterType;
    private String cryptoChatterId;
    private int deniedReason;
    private ArrayList<DeniedReason> deniedReasons;
    private List<ActionType> denied_permissions;
    private Map<Integer, DeniedReason> denied_reason;
    private String enterpriseMailAddress;
    private boolean fromOrganization;
    private boolean hasOUPermission;
    private boolean hasSecretPermission;
    private HashMap<String, String> i18nNames;
    private boolean inChat;
    private List<String> inChatIds;
    private boolean inContacts;
    private boolean isAgent;
    private boolean isBlockedFromLocalSearch;
    private boolean isInTeam;
    private boolean isP2pCryptoChat;
    private boolean isP2pShieldChat;
    private boolean isRegistered;
    private boolean isResigned;
    private boolean mIsCustomer;
    private boolean mIsInZenMode;
    private String mailAddress;
    private String name;
    private String p2pChatId;
    private List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> statusList;
    private String tenantId;
    private String timeZoneId;
    private WorkStatus workStatus;
    private long zenModeEndTime;

    public String getAvatarId() {
        if (this.isP2pCryptoChat == false) goto L7;
        return this.cryptoChatterId;
    L7:
        return getId();
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        Chatter.ChatterType r100 = this.chatterType;
        if (r100 != Chatter.ChatterType.BOT) goto L7;
        return INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE_BOT;
    L7:
        if (this.isP2pShieldChat == false) goto L11;
        return "shield_p2p_chat";
    L11:
        if (this.isP2pCryptoChat == false) goto L15;
        return "crypto_p2p_chat";
    L15:
        if (r100 != Chatter.ChatterType.AI) goto L18;
        return "myai";
    L18:
        return "contacts";
    }

    public boolean isBeBlocked() {
        if (this.deniedReason != DeniedReason.BE_BLOCKED.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBlock() {
        if (this.deniedReason != DeniedReason.BLOCKED.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNotContact() {
        if (this.deniedReason != DeniedReason.NO_FRIENDSHIP.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public SearchChatterInfo() {
        this.isRegistered = true;
        this.hasOUPermission = true;
        this.hasSecretPermission = true;
        this.fromOrganization = false;
        this.isP2pCryptoChat = false;
        this.isP2pShieldChat = false;
        this.isInTeam = false;
        this.type = 1;
    }

    public boolean isBlockOrBeBlocked() {
        if (isBlock() == false) goto L5;
    L8:
        return true;
    L5:
        if (isBeBlocked() == true) goto L8;
        return false;
    }

    public int getBotExtType() {
        return this.botExtType;
    }

    public String getBotId() {
        return this.botId;
    }

    public ChatterDescription getChatterDescription() {
        return this.chatterDescription;
    }

    public Chatter.ChatterType getChatterType() {
        return this.chatterType;
    }

    public String getCryptoChatterId() {
        return this.cryptoChatterId;
    }

    public int getDeniedReason() {
        return this.deniedReason;
    }

    public List<DeniedReason> getDeniedReasons() {
        return this.deniedReasons;
    }

    public List<ActionType> getDenied_permissions() {
        return this.denied_permissions;
    }

    public Map<Integer, DeniedReason> getDenied_reason() {
        return this.denied_reason;
    }

    public String getEnterpriseMailAddress() {
        return this.enterpriseMailAddress;
    }

    public HashMap<String, String> getI18nNames() {
        return this.i18nNames;
    }

    public List<String> getInChatIds() {
        return this.inChatIds;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public String getName() {
        return this.name;
    }

    public String getP2pChatId() {
        return this.p2pChatId;
    }

    public List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> getStatusList() {
        return this.statusList;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTimeZoneId() {
        return this.timeZoneId;
    }

    public WorkStatus getWorkStatus() {
        return this.workStatus;
    }

    public long getZenModeEndTime() {
        return this.zenModeEndTime;
    }

    public boolean isAgent() {
        return this.isAgent;
    }

    public boolean isBlockedFromLocalSearch() {
        return this.isBlockedFromLocalSearch;
    }

    public boolean isCanJoinGroup() {
        return this.canJoinGroup;
    }

    public boolean isCustomer() {
        return this.mIsCustomer;
    }

    public boolean isFromOrganization() {
        return this.fromOrganization;
    }

    public boolean isHasOUPermission() {
        return this.hasOUPermission;
    }

    public boolean isHasSecretPermission() {
        return this.hasSecretPermission;
    }

    public boolean isInChat() {
        return this.inChat;
    }

    public boolean isInContacts() {
        return this.inContacts;
    }

    public boolean isInTeam() {
        return this.isInTeam;
    }

    public boolean isInZenMode() {
        return this.mIsInZenMode;
    }

    public boolean isP2pCryptoChat() {
        return this.isP2pCryptoChat;
    }

    public boolean isP2pShieldChat() {
        return this.isP2pShieldChat;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public boolean isResigned() {
        return this.isResigned;
    }

    public void customer(boolean r100) {
        this.mIsCustomer = r100;
    }

    public void setAgent(boolean r100) {
        this.isAgent = r100;
    }

    public void setBlockedFromLocalSearch(boolean r100) {
        this.isBlockedFromLocalSearch = r100;
    }

    public void setBotExtType(int r100) {
        this.botExtType = r100;
    }

    public void setBotId(String r100) {
        this.botId = r100;
    }

    public void setCanJoinGroup(boolean r100) {
        this.canJoinGroup = r100;
    }

    public void setChatterDescription(ChatterDescription r100) {
        this.chatterDescription = r100;
    }

    public void setChatterType(Chatter.ChatterType r100) {
        this.chatterType = r100;
    }

    public void setCryptoChatterId(String r100) {
        this.cryptoChatterId = r100;
    }

    public void setDeniedReason(int r100) {
        this.deniedReason = r100;
    }

    public void setDeniedReasons(List<DeniedReason> r100) {
        if (r100 != null) goto L4;
        this.deniedReasons = null;
        return;
    L4:
        this.deniedReasons = new ArrayList(r100);
    }

    public void setDenied_permissions(List<ActionType> r100) {
        this.denied_permissions = r100;
    }

    public void setDenied_reason(Map<Integer, DeniedReason> r100) {
        this.denied_reason = r100;
    }

    public void setEnterpriseMailAddress(String r100) {
        this.enterpriseMailAddress = r100;
    }

    public void setFromOrganization(boolean r100) {
        this.fromOrganization = r100;
    }

    public void setHasOUPermission(boolean r100) {
        this.hasOUPermission = r100;
    }

    public void setHasSecretPermission(boolean r100) {
        this.hasSecretPermission = r100;
    }

    public void setI18nNames(HashMap<String, String> r100) {
        this.i18nNames = r100;
    }

    public void setInChat(boolean r100) {
        this.inChat = r100;
    }

    public void setInChatIds(List<String> r100) {
        this.inChatIds = r100;
    }

    public void setInContacts(boolean r100) {
        this.inContacts = r100;
    }

    public void setInTeam(boolean r100) {
        this.isInTeam = r100;
    }

    public void setMailAddress(String r100) {
        this.mailAddress = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setP2pChatId(String r100) {
        this.p2pChatId = r100;
    }

    public void setP2pCryptoChat(boolean r100) {
        this.isP2pCryptoChat = r100;
    }

    public void setP2pShieldChat(boolean r100) {
        this.isP2pShieldChat = r100;
    }

    public void setRegistered(boolean r100) {
        this.isRegistered = r100;
    }

    public void setResigned(boolean r100) {
        this.isResigned = r100;
    }

    public void setStatusList(List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r100) {
        this.statusList = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setTimeZoneId(String r100) {
        this.timeZoneId = r100;
    }

    public void setWorkStatus(WorkStatus r100) {
        this.workStatus = r100;
    }

    public void setZenModeEndTime(long r100) {
        this.zenModeEndTime = r100;
    }

    public void zenMode(boolean r100) {
        this.mIsInZenMode = r100;
    }
}
