package com.ss.android.lark.doc.entity;

import android.text.TextUtils;
import java.io.Serializable;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class Doc implements Serializable, b<Doc> {
    private String abstractUrl;
    private long createTime;
    private DocType docType;
    private Icon icon;
    private String iconKey;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f420489id;
    private String name;
    private String ownerId;
    private String ownerName;
    private ThumbnailDetail thumbnailDetail;
    private long updateTime;
    private String url;

    public Doc() {
    }

    public int hashCode() {
        String r100 = this.f420489id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.abstractUrl;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.f420489id);
    }

    public String getAbstract() {
        return this.abstractUrl;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public DocType getDocType() {
        return this.docType;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public String getId() {
        return this.f420489id;
    }

    public String getName() {
        return this.name;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public ThumbnailDetail getThumbnaimDetail() {
        return this.thumbnailDetail;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L33:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L33;
        Doc r101 = (Doc) r100;
        String r102 = this.f420489id;
        if (r102 == null) goto L16;
        if (r102.equals(r101.f420489id) == false) goto L17;
    L18:
        String r103 = this.url;
        if (r103 == null) goto L24;
        if (r103.equals(r101.url) == false) goto L25;
    L26:
        String r104 = this.abstractUrl;
        String r105 = r101.abstractUrl;
        if (r104 != null) goto L34;
        if (r105 == null) goto L35;
        return false;
    L35:
        return true;
    L34:
        return r104.equals(r105);
    L25:
        return false;
    L24:
        if (r101.url == null) goto L26;
    L17:
        return false;
    L16:
        if (r101.f420489id == null) goto L18;
        goto L17
    }

    public boolean isContentSame(Doc r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.ownerName, r100.getOwnerName()) == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(this.url, r100.getUrl()) == true) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.name, r100.getName()) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(this.abstractUrl, r100.getAbstract()) == true) goto L18;
        return false;
    L18:
        if (this.updateTime == r100.getUpdateTime()) goto L20;
        return false;
    L20:
        return true;
    }

    public boolean isItemSame(Doc r100) {
        String r101 = this.f420489id;
        if (r100 != null) goto L5;
        String r102 = "";
    L7:
        return TextUtils.equals(r101, r102);
    L5:
        r102 = r100.getId();
        goto L7
    }

    public void setAbstract(String r100) {
        this.abstractUrl = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setDocType(DocType r100) {
        this.docType = r100;
    }

    public void setIcon(Icon r100) {
        this.icon = r100;
    }

    public void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public void setId(String r100) {
        this.f420489id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public void setOwnerName(String r100) {
        this.ownerName = r100;
    }

    public void setThumbnaimDetail(ThumbnailDetail r100) {
        this.thumbnailDetail = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Doc) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Doc) r100);
    }
}
