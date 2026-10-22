package com.bytedance.ee.bear.list.create;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        public final DocumentCreateEntity createFromParcel(Parcel r2) {
            return new DocumentCreateEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DocumentCreateEntity[] newArray(int r1) {
            return new DocumentCreateEntity[r1];
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
        return "DocumentCreateInfo{token='" + du5.b.g(this.token) + "', objToken='" + du5.b.g(this.objToken) + "', templateToken='" + du5.b.g(this.templateToken) + "', code=" + ((Result) this).code + ", msg='" + ((Result) this).msg + "', data=" + ((Result) this).data + '}';
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

    public DocumentCreateEntity(Parcel r4) {
        this.token = r4.readString();
        this.objToken = r4.readString();
        this.templateToken = r4.readString();
        this.url = r4.readString();
        this.title = r4.readString();
        this.type = r4.readInt();
        this.ownerType = r4.readInt();
        boolean r1 = true;
        if (r4.readInt() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.isShareFolder = r0;
        if (r4.readInt() != 0) goto L10;
        r1 = false;
    L10:
        this.isWiki = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setObjToken(String r1) {
        this.objToken = r1;
    }

    public void setObjType(int r1) {
        this.objType = r1;
    }

    public void setOwnerType(int r1) {
        this.ownerType = r1;
    }

    public void setShareFolder(boolean r1) {
        this.isShareFolder = r1;
    }

    public void setSpaceId(String r1) {
        this.spaceId = r1;
    }

    public void setTemplateToken(String r1) {
        this.templateToken = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public void setWiki(boolean r1) {
        this.isWiki = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.token);
        r1.writeString(this.objToken);
        r1.writeString(this.templateToken);
        r1.writeString(this.url);
        r1.writeString(this.title);
        r1.writeInt(this.type);
        r1.writeInt(this.ownerType);
        r1.writeInt(this.isShareFolder ? 1 : 0);
        r1.writeInt(this.isWiki ? 1 : 0);
    }
}
