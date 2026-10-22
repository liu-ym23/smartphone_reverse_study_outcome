package com.bytedance.ee.bear.contract.offline;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
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
        public final OfflineRenameData createFromParcel(Parcel r100) {
            return new OfflineRenameData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final OfflineRenameData[] newArray(int r100) {
            return new OfflineRenameData[r100];
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

    public OfflineRenameData(Parcel r100) {
        this.wikiToken = r100.readString();
        this.objToken = r100.readString();
        this.newName = r100.readString();
        this.editTime = r100.readString();
        this.newIconInfo = r100.readString();
    }

    public void setEditTime(String r100) {
        this.editTime = r100;
    }

    public void setNewIconInfo(String r100) {
        this.newIconInfo = r100;
    }

    public void setNewName(String r100) {
        this.newName = r100;
    }

    public void setObjToken(String r100) {
        this.objToken = r100;
    }

    public void setWikiToken(String r100) {
        this.wikiToken = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.wikiToken);
        r100.writeString(this.objToken);
        r100.writeString(this.newName);
        r100.writeString(this.editTime);
        r100.writeString(this.newIconInfo);
    }
}
