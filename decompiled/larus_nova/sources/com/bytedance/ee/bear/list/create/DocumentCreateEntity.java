package com.bytedance.ee.bear.list.create;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes18.dex */
public class DocumentCreateEntity extends Result implements Parcelable {
    public static final Parcelable.Creator<DocumentCreateEntity> CREATOR = null;
    public boolean isShareFolder;
    public boolean isWiki;
    public String objToken;
    public int objType;
    public int ownerType;
    public String spaceId;
    public String templateToken;
    public String title;
    public String token;
    public int type;
    public String url;

    public class a implements Parcelable.Creator<DocumentCreateEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocumentCreateEntity createFromParcel(Parcel r100) {
            return new DocumentCreateEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DocumentCreateEntity[] newArray(int r100) {
            return new DocumentCreateEntity[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "DocumentCreateInfo{token='" + du5.b.g(this.token) + "', objToken='" + du5.b.g(this.objToken) + "', templateToken='" + du5.b.g(this.templateToken) + "', code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + '}';
    }

    public DocumentCreateEntity() {
    }

    public String getObjToken() {
        return this.objToken;
    }

    public int getObjType() {
        return this.objType;
    }

    public int getOwnerType() {
        return this.ownerType;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public String getTemplateToken() {
        return this.templateToken;
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

    public String getUrl() {
        return this.url;
    }

    public boolean isShareFolder() {
        return this.isShareFolder;
    }

    public boolean isWiki() {
        return this.isWiki;
    }

    public DocumentCreateEntity(Parcel r100) {
        this.token = r100.readString();
        this.objToken = r100.readString();
        this.templateToken = r100.readString();
        this.url = r100.readString();
        this.title = r100.readString();
        this.type = r100.readInt();
        this.ownerType = r100.readInt();
        boolean r101 = true;
        if (r100.readInt() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isShareFolder = r102;
        if (r100.readInt() != 0) goto L10;
        r101 = false;
    L10:
        this.isWiki = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setObjToken(String r100) {
        this.objToken = r100;
    }

    public void setObjType(int r100) {
        this.objType = r100;
    }

    public void setOwnerType(int r100) {
        this.ownerType = r100;
    }

    public void setShareFolder(boolean r100) {
        this.isShareFolder = r100;
    }

    public void setSpaceId(String r100) {
        this.spaceId = r100;
    }

    public void setTemplateToken(String r100) {
        this.templateToken = r100;
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

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setWiki(boolean r100) {
        this.isWiki = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.token);
        r100.writeString(this.objToken);
        r100.writeString(this.templateToken);
        r100.writeString(this.url);
        r100.writeString(this.title);
        r100.writeInt(this.type);
        r100.writeInt(this.ownerType);
        r100.writeInt(this.isShareFolder ? 1 : 0);
        r100.writeInt(this.isWiki ? 1 : 0);
    }
}
