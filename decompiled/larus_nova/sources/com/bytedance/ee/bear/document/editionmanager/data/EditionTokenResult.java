package com.bytedance.ee.bear.document.editionmanager.data;

import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public class EditionTokenResult implements Serializable {
    protected HashMap<String, UsersBean> users;
    protected VersionMetasBean version_meta;

    public EditionTokenResult() {
    }

    public String toString() {
        return "EditionTokenResultData{users=" + this.users + ", version_meta=" + this.version_meta + '}';
    }

    public HashMap<String, UsersBean> getUsers() {
        return this.users;
    }

    public VersionMetasBean getVersion_meta() {
        return this.version_meta;
    }

    public void setUsers(HashMap<String, UsersBean> r100) {
        this.users = r100;
    }

    public void setVersion_meta(VersionMetasBean r100) {
        this.version_meta = r100;
    }
}
