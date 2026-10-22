package com.bytedance.ee.bear.contract.offline;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfflineRenameData implements Serializable, Parcelable {
    public static final Parcelable.Creator<OfflineRenameData> CREATOR = null;
    private String editTime;
    private String newIconInfo;
    private String newName;
    private String objToken;
    private String wikiToken;

    public class a implements Parcelable.Creator<OfflineRenameData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OfflineRenameData createFromParcel(Parcel r2) {
            return new OfflineRenameData(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OfflineRenameData[] newArray(int r1) {
            return new OfflineRenameData[r1];
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
        return "OfflineRenameData{, editTime='" + this.editTime + "'}";
    }

    public OfflineRenameData() {
    }

    public String getEditTime() {
        return this.editTime;
    }

    public String getNewIconInfo() {
        return this.newIconInfo;
    }

    public String getNewName() {
        return this.newName;
    }

    public String getObjToken() {
        return this.objToken;
    }

    public String getWikiToken() {
        return this.wikiToken;
    }

    public OfflineRenameData(Parcel r2) {
        this.wikiToken = r2.readString();
        this.objToken = r2.readString();
        this.newName = r2.readString();
        this.editTime = r2.readString();
        this.newIconInfo = r2.readString();
    }

    public void setEditTime(String r1) {
        this.editTime = r1;
    }

    public void setNewIconInfo(String r1) {
        this.newIconInfo = r1;
    }

    public void setNewName(String r1) {
        this.newName = r1;
    }

    public void setObjToken(String r1) {
        this.objToken = r1;
    }

    public void setWikiToken(String r1) {
        this.wikiToken = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.wikiToken);
        r1.writeString(this.objToken);
        r1.writeString(this.newName);
        r1.writeString(this.editTime);
        r1.writeString(this.newIconInfo);
    }
}
