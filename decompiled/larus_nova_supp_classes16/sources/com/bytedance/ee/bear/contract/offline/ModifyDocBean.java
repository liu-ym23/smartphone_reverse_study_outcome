package com.bytedance.ee.bear.contract.offline;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ModifyDocBean implements Serializable, Parcelable {
    public static final Parcelable.Creator<ModifyDocBean> CREATOR = null;
    private String fakeToken;
    private boolean isModifyFakeToken;
    private boolean isModifyFolder;

    public class a implements Parcelable.Creator<ModifyDocBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModifyDocBean createFromParcel(Parcel r2) {
            return new ModifyDocBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ModifyDocBean[] newArray(int r1) {
            return new ModifyDocBean[r1];
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

    public ModifyDocBean(Parcel r4) {
        boolean r0 = false;
        this.isModifyFakeToken = false;
        this.isModifyFolder = false;
        this.fakeToken = r4.readString();
        if (r4.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.isModifyFakeToken = r1;
        if (r4.readByte() == 0) goto L9;
        r0 = true;
    L9:
        this.isModifyFolder = r0;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void setFakeToken(String r1) {
        this.fakeToken = r1;
    }

    public void setModifyFakeToken(boolean r1) {
        this.isModifyFakeToken = r1;
    }

    public void setModifyFolder(boolean r1) {
        this.isModifyFolder = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.fakeToken);
        r1.writeByte(this.isModifyFakeToken ? 1 : 0);
        r1.writeByte(this.isModifyFolder ? 1 : 0);
    }
}
