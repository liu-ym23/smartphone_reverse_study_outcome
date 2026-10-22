package com.bytedance.ee.bear.document.editionmanager.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionListResult implements Serializable {
    private boolean has_more;
    private String page_token;
    protected HashMap<String, UsersBean> users;
    private LinkedList<VersionMetasBean> version_metas;

    public EditionListResult() {
    }

    public String toString() {
        return "EditionListResultData{has_more=" + this.has_more + ", page_token='" + this.page_token + "', users=" + this.users + ", version_metas=" + this.version_metas + '}';
    }

    public String getPage_token() {
        return this.page_token;
    }

    public Map<String, UsersBean> getUsers() {
        return this.users;
    }

    public List<VersionMetasBean> getVersion_metas() {
        return this.version_metas;
    }

    public boolean isHas_more() {
        return this.has_more;
    }

    public void setHas_more(boolean r1) {
        this.has_more = r1;
    }

    public void setPage_token(String r1) {
        this.page_token = r1;
    }

    public void setUsers(HashMap<String, UsersBean> r1) {
        this.users = r1;
    }

    public void setVersion_metas(LinkedList<VersionMetasBean> r1) {
        this.version_metas = r1;
    }
}
