package com.bytedance.ee.bear.contract.offline;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class ModifyDocBean implements Serializable, Parcelable {
    public static final Parcelable.Creator<ModifyDocBean> CREATOR = null;
    private String fakeToken;
    private boolean isModifyFakeToken;
    private boolean isModifyFolder;

    public class a implements Parcelable.Creator<ModifyDocBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModifyDocBean createFromParcel(Parcel r100) {
            return new ModifyDocBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ModifyDocBean[] newArray(int r100) {
            return new ModifyDocBean[r100];
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
        return "ModifyDocBean{fakeToken='" + this.fakeToken + "', isModifyFakeToken=" + this.isModifyFakeToken + ", isModifyFolder=" + this.isModifyFolder + '}';
    }

    public ModifyDocBean() {
        this.isModifyFakeToken = false;
        this.isModifyFolder = false;
    }

    public String getFakeToken() {
        return this.fakeToken;
    }

    public boolean isModifyFakeToken() {
        return this.isModifyFakeToken;
    }

    public boolean isModifyFolder() {
        return this.isModifyFolder;
    }

    public ModifyDocBean(Parcel r100) {
        boolean r101 = false;
        this.isModifyFakeToken = false;
        this.isModifyFolder = false;
        this.fakeToken = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isModifyFakeToken = r102;
        if (r100.readByte() == 0) goto L9;
        r101 = true;
    L9:
        this.isModifyFolder = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setFakeToken(String r100) {
        this.fakeToken = r100;
    }

    public void setModifyFakeToken(boolean r100) {
        this.isModifyFakeToken = r100;
    }

    public void setModifyFolder(boolean r100) {
        this.isModifyFolder = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.fakeToken);
        r100.writeByte(this.isModifyFakeToken ? 1 : 0);
        r100.writeByte(this.isModifyFolder ? 1 : 0);
    }
}
