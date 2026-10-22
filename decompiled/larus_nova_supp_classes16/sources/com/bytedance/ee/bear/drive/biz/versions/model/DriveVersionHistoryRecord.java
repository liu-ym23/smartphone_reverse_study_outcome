package com.bytedance.ee.bear.drive.biz.versions.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public void setCipherDeleted(boolean r1) {
            this.cipherDeleted = r1;
        }

        public void setDataVersion(String r1) {
            this.dataVersion = r1;
        }

        public void setDeleted(boolean r1) {
            this.isDeleted = r1;
        }

        public void setEditTime(long r1) {
            this.editTime = r1;
        }

        public void setEditUid(String r1) {
            this.editUid = r1;
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public void setSize(long r1) {
            this.size = r1;
        }

        public void setSourceName(String r1) {
            this.sourceName = r1;
        }

        public void setSourceTag(int r1) {
            this.sourceTag = r1;
        }

        public void setTag(int r1) {
            this.tag = r1;
        }

        public void setType(int r1) {
            this.type = r1;
        }

        public void setVersion(String r1) {
            this.version = r1;
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
        private String id;
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
            return this.id;
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

        public void setAvataUrl(String r1) {
            this.avataUrl = r1;
        }

        public void setCname(String r1) {
            this.cname = r1;
        }

        public void setEmail(String r1) {
            this.email = r1;
        }

        public void setEnName(String r1) {
            this.enName = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setMobile(String r1) {
            this.mobile = r1;
        }

        public void setSuid(String r1) {
            this.suid = r1;
        }

        public void setTanantId(String r1) {
            this.tanantId = r1;
        }

        public void setTenantName(String r1) {
            this.tenantName = r1;
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

    public void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public void setList(List<RecordBean> r1) {
        this.list = r1;
    }

    public void setUsers(Map<String, UserBean> r1) {
        this.users = r1;
    }
}
