package com.ss.android.lark.doc.entity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class DocFeed implements Serializable {
    private long createTime;
    private List<String> docMessageIds;
    private String iconKey;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f420490id;
    private boolean isCrossTenant;
    private boolean isRemind;
    private String lastMessageId;
    private int newMessageCount;
    private String ownerId;
    private String title;
    private DocType type;
    private long updateTime;
    private String url;

    public DocFeed() {
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public List<String> getDocMessageIds() {
        return this.docMessageIds;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public String getId() {
        return this.f420490id;
    }

    public String getLastMessageId() {
        return this.lastMessageId;
    }

    public int getNewMessageCount() {
        return this.newMessageCount;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getTitle() {
        return this.title;
    }

    public DocType getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public boolean isRemind() {
        return this.isRemind;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((r100 instanceof DocFeed) == true) goto L11;
        return false;
    L11:
        DocFeed r101 = (DocFeed) r100;
        String r102 = this.f420490id;
        if (r102 == null) goto L14;
        boolean r103 = r102.equals(r101.getId());
    L18:
        if (r103 == true) goto L20;
        return false;
    L20:
        DocType r104 = this.type;
        DocType r105 = r101.getType();
        if (r104 != null) goto L25;
        if (r105 != null) goto L26;
        return true;
    L26:
        return false;
    L25:
        return r104.equals(r105);
    L14:
        if (r101.getId() != null) goto L16;
        r103 = true;
        goto L18
    L16:
        r103 = false;
        goto L18
    }

    public boolean exactlyCompare(DocFeed r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        String r101 = this.f420490id;
        if (r101 == null) goto L11;
        boolean r102 = r101.equals(r100.getId());
    L15:
        if (r102 == true) goto L18;
        return false;
    L18:
        if (this.updateTime != r100.updateTime) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == true) goto L24;
        return false;
    L24:
        if (this.newMessageCount != r100.getNewMessageCount()) goto L26;
        boolean r104 = true;
    L27:
        if (r104 == true) goto L29;
        return false;
    L29:
        if (r104 == true) goto L31;
    L33:
        boolean r105 = false;
    L34:
        if (r105 == false) goto L43;
        DocType r106 = this.type;
        DocType r107 = r100.getType();
        if (r106 != null) goto L40;
        if (r107 != null) goto L44;
    L41:
        return true;
    L44:
        return false;
    L40:
        if (r106.equals(r107) == true) goto L41;
        return false;
    L43:
        return false;
    L31:
        if (this.isRemind != r100.isRemind) goto L33;
        r105 = true;
        goto L34
    L26:
        r104 = false;
        goto L27
    L20:
        r103 = false;
        goto L21
    L11:
        if (r100.getId() != null) goto L13;
        r102 = true;
        goto L15
    L13:
        r102 = false;
        goto L15
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setCrossTenant(boolean r100) {
        this.isCrossTenant = r100;
    }

    public void setDocMessageIds(List<String> r100) {
        this.docMessageIds = r100;
    }

    public void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public void setId(String r100) {
        this.f420490id = r100;
    }

    public void setLastMessageId(String r100) {
        this.lastMessageId = r100;
    }

    public void setNewMessageCount(int r100) {
        this.newMessageCount = r100;
    }

    public void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public void setRemind(boolean r100) {
        this.isRemind = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setType(DocType r100) {
        this.type = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
