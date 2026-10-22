package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;

/* JADX INFO: loaded from: classes38.dex */
public class SearchSecretP2PChatInfo extends SearchBaseInfo {
    private static final long serialVersionUID = 2201107773829679779L;
    private boolean canJoinGroup;
    private ChatterDescription chatterDescription;
    private String chatterId;
    private Chatter.ChatterType chatterType;
    private boolean inContacts;
    private boolean isRegistered;
    private String tenantId;
    private String withBotTag;

    public SearchSecretP2PChatInfo() {
        this.type = 11;
    }

    public ChatterDescription getChatterDescription() {
        return this.chatterDescription;
    }

    public String getChatterId() {
        return this.chatterId;
    }

    public Chatter.ChatterType getChatterType() {
        return this.chatterType;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getWithBotTag() {
        return this.withBotTag;
    }

    public boolean isCanJoinGroup() {
        return this.canJoinGroup;
    }

    public boolean isInContacts() {
        return this.inContacts;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setCanJoinGroup(boolean r100) {
        this.canJoinGroup = r100;
    }

    public void setChatterDescription(ChatterDescription r100) {
        this.chatterDescription = r100;
    }

    public void setChatterId(String r100) {
        this.chatterId = r100;
    }

    public void setChatterType(Chatter.ChatterType r100) {
        this.chatterType = r100;
    }

    public void setInContacts(boolean r100) {
        this.inContacts = r100;
    }

    public void setRegistered(boolean r100) {
        this.isRegistered = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setWithBotTag(String r100) {
        this.withBotTag = r100;
    }
}
