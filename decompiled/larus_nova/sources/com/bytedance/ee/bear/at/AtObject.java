package com.bytedance.ee.bear.at;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.widgets.tagview.DisplayTagInfoV1;
import du5.b;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public class AtObject implements Serializable {
    private String avatarKey;
    private String avatar_url;
    private String cn_name;
    private String content;
    private String count;
    private String department;
    private String desc;
    private DisplayName display_name;
    private DisplayTagInfoV1 display_tag;
    private String edit_time;
    private String en_name;
    private HashMap<String, String> i18n_user_name;

    @JSONField(name = "icon_info")
    private String iconInfo;
    private String icon_fsunit;
    private String icon_key;
    private int icon_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f206289id;

    @JSONField(alternateNames = {"is_cross_tenant"}, name = "is_external")
    private boolean isExternal;

    @JSONField(name = "has_join_chat")
    private boolean isJoinChat;
    private String language;
    private String name;
    private boolean not_notify;
    private String owner;
    private int sequenceNum;
    private int source;
    private int sub_type;
    private String tenant_id;
    private String title;
    private String token;
    private int type;
    private String union_id;
    private String url;

    @JSONField(name = "user_type")
    private int userType;

    public String toString() {
        return "AtObject{, type=" + this.type + ", token='" + b.g(this.token) + "', url='" + b.g(this.url) + "', avatar_url='" + b.g(this.avatar_url) + "', id='" + this.f206289id + "', isExternal='" + this.isExternal + "', userType='" + this.userType + "',icon_key=" + this.icon_key + "',icon_fsunit=" + this.icon_fsunit + "',icon_type=" + this.icon_type + "',tenant_id=" + this.tenant_id + "',union_id=" + this.union_id + "',icon_info=" + this.iconInfo + "'}";
    }

    public AtObject() {
        this.f206289id = "";
        this.iconInfo = "";
        this.source = 0;
        this.userType = 0;
        this.sequenceNum = 0;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public String getCn_name() {
        return this.cn_name;
    }

    public String getContent() {
        return this.content;
    }

    public String getCount() {
        return this.count;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getDesc() {
        return this.desc;
    }

    public DisplayName getDisplay_name() {
        return this.display_name;
    }

    public DisplayTagInfoV1 getDisplay_tag() {
        return this.display_tag;
    }

    public String getEdit_time() {
        return this.edit_time;
    }

    public String getEn_name() {
        return this.en_name;
    }

    public HashMap<String, String> getI18n_user_name() {
        return this.i18n_user_name;
    }

    public String getIconInfo() {
        return this.iconInfo;
    }

    public String getIcon_fsunit() {
        return this.icon_fsunit;
    }

    public String getIcon_key() {
        return this.icon_key;
    }

    public int getIcon_type() {
        return this.icon_type;
    }

    public String getId() {
        return this.f206289id;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getSequenceNum() {
        return this.sequenceNum;
    }

    public int getSource() {
        return this.source;
    }

    public int getSub_type() {
        return this.sub_type;
    }

    public String getTenant_id() {
        return this.tenant_id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public String getUnion_id() {
        return this.union_id;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUserType() {
        return this.userType;
    }

    @JSONField(alternateNames = {"is_cross_tenant"}, name = "is_external")
    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isJoinChat() {
        return this.isJoinChat;
    }

    public boolean isNot_notify() {
        return this.not_notify;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setAvatar_url(String r100) {
        this.avatar_url = r100;
    }

    public void setCn_name(String r100) {
        this.cn_name = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setCount(String r100) {
        this.count = r100;
    }

    public void setDepartment(String r100) {
        this.department = r100;
    }

    public void setDesc(String r100) {
        this.desc = r100;
    }

    public void setDisplay_name(DisplayName r100) {
        this.display_name = r100;
    }

    public void setDisplay_tag(DisplayTagInfoV1 r100) {
        this.display_tag = r100;
    }

    public void setEdit_time(String r100) {
        this.edit_time = r100;
    }

    public void setEn_name(String r100) {
        this.en_name = r100;
    }

    @JSONField(alternateNames = {"is_cross_tenant"}, name = "is_external")
    public void setExternal(boolean r100) {
        this.isExternal = r100;
    }

    public void setI18n_user_name(HashMap<String, String> r100) {
        this.i18n_user_name = r100;
    }

    public void setIconInfo(String r100) {
        this.iconInfo = r100;
    }

    public void setIcon_fsunit(String r100) {
        this.icon_fsunit = r100;
    }

    public void setIcon_key(String r100) {
        this.icon_key = r100;
    }

    public void setIcon_type(int r100) {
        this.icon_type = r100;
    }

    public void setId(String r100) {
        this.f206289id = r100;
    }

    public void setJoinChat(boolean r100) {
        this.isJoinChat = r100;
    }

    public void setLanguage(String r100) {
        this.language = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setNot_notify(boolean r100) {
        this.not_notify = r100;
    }

    public void setOwner(String r100) {
        this.owner = r100;
    }

    public void setSequenceNum(int r100) {
        this.sequenceNum = r100;
    }

    public void setSource(int r100) {
        this.source = r100;
    }

    public void setSub_type(int r100) {
        this.sub_type = r100;
    }

    public void setTenant_id(String r100) {
        this.tenant_id = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setUnion_id(String r100) {
        this.union_id = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setUserType(int r100) {
        this.userType = r100;
    }
}
