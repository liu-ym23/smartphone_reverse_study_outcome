package com.bytedance.ee.bear.drive.biz.versions.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class DriveVersionHistoryRecord implements Serializable {

    @JSONField(name = "has_more")
    private boolean hasMore;
    private List<RecordBean> list;
    private Map<String, UserBean> users;

    public static class RecordBean implements Serializable {
        public static final int TYPE_DELETE_VERSION = 3;
        public static final int TYPE_RENAME = 2;
        public static final int TYPE_REVERT_VERSION = 4;
        public static final int TYPE_UPLOAD_NEW_VERSION = 1;

        @JSONField(name = "cipher_delete")
        private boolean cipherDeleted;

        @JSONField(name = "data_version")
        private String dataVersion;

        @JSONField(name = "edit_time")
        private long editTime;

        @JSONField(name = "edit_uid")
        private String editUid;

        @JSONField(name = "is_deleted")
        private boolean isDeleted;
        private String name;
        private long size;

        @JSONField(name = "source_name")
        private String sourceName;

        @JSONField(name = "source_tag")
        private int sourceTag;
        private int tag;
        private int type;
        private String version;

        public RecordBean() {
        }

        public String getDataVersion() {
            return this.dataVersion;
        }

        public long getEditTime() {
            return this.editTime;
        }

        public String getEditUid() {
            return this.editUid;
        }

        public String getName() {
            return this.name;
        }

        public long getSize() {
            return this.size;
        }

        public String getSourceName() {
            return this.sourceName;
        }

        public int getSourceTag() {
            return this.sourceTag;
        }

        public int getTag() {
            return this.tag;
        }

        public int getType() {
            return this.type;
        }

        public String getVersion() {
            return this.version;
        }

        public boolean isCipherDeleted() {
            return this.cipherDeleted;
        }

        public boolean isDeleted() {
            return this.isDeleted;
        }

        public void setCipherDeleted(boolean r100) {
            this.cipherDeleted = r100;
        }

        public void setDataVersion(String r100) {
            this.dataVersion = r100;
        }

        public void setDeleted(boolean r100) {
            this.isDeleted = r100;
        }

        public void setEditTime(long r100) {
            this.editTime = r100;
        }

        public void setEditUid(String r100) {
            this.editUid = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setSize(long r100) {
            this.size = r100;
        }

        public void setSourceName(String r100) {
            this.sourceName = r100;
        }

        public void setSourceTag(int r100) {
            this.sourceTag = r100;
        }

        public void setTag(int r100) {
            this.tag = r100;
        }

        public void setType(int r100) {
            this.type = r100;
        }

        public void setVersion(String r100) {
            this.version = r100;
        }
    }

    public static class UserBean implements Serializable {

        @JSONField(name = "avatar_url")
        private String avataUrl;

        @JSONField(name = "cn_name")
        private String cname;
        private String email;

        @JSONField(name = "en_name")
        private String enName;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f223998id;
        private String mobile;
        private String suid;

        @JSONField(name = "tanant_id")
        private String tanantId;

        @JSONField(name = "tenant_name")
        private String tenantName;

        public UserBean() {
        }

        public String getAvataUrl() {
            return this.avataUrl;
        }

        public String getCname() {
            return this.cname;
        }

        public String getEmail() {
            return this.email;
        }

        public String getEnName() {
            return this.enName;
        }

        public String getId() {
            return this.f223998id;
        }

        public String getMobile() {
            return this.mobile;
        }

        public String getSuid() {
            return this.suid;
        }

        public String getTanantId() {
            return this.tanantId;
        }

        public String getTenantName() {
            return this.tenantName;
        }

        public void setAvataUrl(String r100) {
            this.avataUrl = r100;
        }

        public void setCname(String r100) {
            this.cname = r100;
        }

        public void setEmail(String r100) {
            this.email = r100;
        }

        public void setEnName(String r100) {
            this.enName = r100;
        }

        public void setId(String r100) {
            this.f223998id = r100;
        }

        public void setMobile(String r100) {
            this.mobile = r100;
        }

        public void setSuid(String r100) {
            this.suid = r100;
        }

        public void setTanantId(String r100) {
            this.tanantId = r100;
        }

        public void setTenantName(String r100) {
            this.tenantName = r100;
        }
    }

    public DriveVersionHistoryRecord() {
    }

    public List<RecordBean> getList() {
        return this.list;
    }

    public Map<String, UserBean> getUsers() {
        return this.users;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public void setList(List<RecordBean> r100) {
        this.list = r100;
    }

    public void setUsers(Map<String, UserBean> r100) {
        this.users = r100;
    }
}
