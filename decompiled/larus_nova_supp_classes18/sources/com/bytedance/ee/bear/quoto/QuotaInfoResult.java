package com.bytedance.ee.bear.quoto;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class QuotaInfoResult extends Result<DataDTO> {

    public static class DataDTO implements Serializable {
        private QuotaInfo department;
        private QuotaInfo owner;
        private QuotaInfo tenant;
        private QuotaInfo user;

        public static class ContactsDTO implements Serializable {
            private DisplayName displayName;
            private String enName;
            private String name;
            private String uid;

            public ContactsDTO() {
            }

            public String toString() {
                return "ContactsDTO{uid='" + this.uid + "', name='" + this.name + "', enName='" + this.enName + "', displayName=" + this.displayName + '}';
            }

            public DisplayName getDisplayName() {
                return this.displayName;
            }

            public String getEnName() {
                return this.enName;
            }

            public String getName() {
                return this.name;
            }

            public String getUid() {
                return this.uid;
            }

            public void setDisplayName(DisplayName r1) {
                this.displayName = r1;
            }

            public void setEnName(String r1) {
                this.enName = r1;
            }

            public void setName(String r1) {
                this.name = r1;
            }

            public void setUid(String r1) {
                this.uid = r1;
            }
        }

        public static class QuotaInfo implements Serializable {
            private List<ContactsDTO> confContacts;
            private int configType;
            private List<ContactsDTO> contacts;
            private String id;

            @JSONField(name = "is_max_limit")
            private boolean isMaxLimit;
            private long limit;
            private UrlLink urlLink;
            private long usage;

            public QuotaInfo() {
            }

            public String toString() {
                return "TenantDTO{id='" + this.id + "', usage=" + this.usage + ", limit=" + this.limit + ", contacts=" + this.contacts + '}';
            }

            public List<ContactsDTO> getConfContacts() {
                return this.confContacts;
            }

            public int getConfigType() {
                return this.configType;
            }

            public List<ContactsDTO> getContacts() {
                return this.contacts;
            }

            public String getId() {
                return this.id;
            }

            public long getLimit() {
                return this.limit;
            }

            public UrlLink getUrlLink() {
                return this.urlLink;
            }

            public long getUsage() {
                return this.usage;
            }

            public boolean isMaxLimit() {
                return this.isMaxLimit;
            }

            public void setConfContacts(List<ContactsDTO> r1) {
                this.confContacts = r1;
            }

            public void setConfigType(int r1) {
                this.configType = r1;
            }

            public void setContacts(List<ContactsDTO> r1) {
                this.contacts = r1;
            }

            public void setId(String r1) {
                this.id = r1;
            }

            public void setLimit(long r1) {
                this.limit = r1;
            }

            public void setMaxLimit(boolean r1) {
                this.isMaxLimit = r1;
            }

            public void setUrlLink(UrlLink r1) {
                this.urlLink = r1;
            }

            public void setUsage(long r1) {
                this.usage = r1;
            }
        }

        public static class UrlLink implements Serializable {
            private String title;
            private String url;

            public UrlLink() {
            }

            public String toString() {
                return "UrlLink{title='" + this.title + "', url='" + this.url + "'}";
            }

            public String getTitle() {
                return this.title;
            }

            public String getUrl() {
                return this.url;
            }

            public void setTitle(String r1) {
                this.title = r1;
            }

            public void setUrl(String r1) {
                this.url = r1;
            }
        }

        public DataDTO() {
        }

        public String toString() {
            return "DataDTO{tenant=" + this.tenant + ", user=" + this.user + ", owner=" + this.owner + ", department=" + this.department + '}';
        }

        public QuotaInfo getDepartment() {
            return this.department;
        }

        public QuotaInfo getOwner() {
            return this.owner;
        }

        public QuotaInfo getTenant() {
            return this.tenant;
        }

        public QuotaInfo getUser() {
            return this.user;
        }

        public void setDepartment(QuotaInfo r1) {
            this.department = r1;
        }

        public void setOwner(QuotaInfo r1) {
            this.owner = r1;
        }

        public void setTenant(QuotaInfo r1) {
            this.tenant = r1;
        }

        public void setUser(QuotaInfo r1) {
            this.user = r1;
        }
    }

    public QuotaInfoResult() {
    }
}
