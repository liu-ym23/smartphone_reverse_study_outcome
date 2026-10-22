package com.bytedance.ee.bear.quoto;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

            public void setDisplayName(DisplayName r100) {
                this.displayName = r100;
            }

            public void setEnName(String r100) {
                this.enName = r100;
            }

            public void setName(String r100) {
                this.name = r100;
            }

            public void setUid(String r100) {
                this.uid = r100;
            }
        }

        public static class QuotaInfo implements Serializable {
            private List<ContactsDTO> confContacts;
            private int configType;
            private List<ContactsDTO> contacts;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            private String f236323id;

            @JSONField(name = "is_max_limit")
            private boolean isMaxLimit;
            private long limit;
            private UrlLink urlLink;
            private long usage;

            public QuotaInfo() {
            }

            public String toString() {
                return "TenantDTO{id='" + this.f236323id + "', usage=" + this.usage + ", limit=" + this.limit + ", contacts=" + this.contacts + '}';
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
                return this.f236323id;
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

            public void setConfContacts(List<ContactsDTO> r100) {
                this.confContacts = r100;
            }

            public void setConfigType(int r100) {
                this.configType = r100;
            }

            public void setContacts(List<ContactsDTO> r100) {
                this.contacts = r100;
            }

            public void setId(String r100) {
                this.f236323id = r100;
            }

            public void setLimit(long r100) {
                this.limit = r100;
            }

            public void setMaxLimit(boolean r100) {
                this.isMaxLimit = r100;
            }

            public void setUrlLink(UrlLink r100) {
                this.urlLink = r100;
            }

            public void setUsage(long r100) {
                this.usage = r100;
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

            public void setTitle(String r100) {
                this.title = r100;
            }

            public void setUrl(String r100) {
                this.url = r100;
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

        public void setDepartment(QuotaInfo r100) {
            this.department = r100;
        }

        public void setOwner(QuotaInfo r100) {
            this.owner = r100;
        }

        public void setTenant(QuotaInfo r100) {
            this.tenant = r100;
        }

        public void setUser(QuotaInfo r100) {
            this.user = r100;
        }
    }

    public QuotaInfoResult() {
    }
}
