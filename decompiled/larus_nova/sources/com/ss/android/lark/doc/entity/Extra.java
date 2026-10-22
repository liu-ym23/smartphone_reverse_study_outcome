package com.ss.android.lark.doc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class Extra implements Serializable, Parcelable {
    public static final Parcelable.Creator<Extra> CREATOR = null;
    public boolean owner_in_group;
    public int send_card_auth_perm;
    public int single_page_state;

    public class a implements Parcelable.Creator<Extra> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Extra createFromParcel(Parcel r100) {
            return new Extra(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Extra[] newArray(int r100) {
            return new Extra[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public boolean hasReadOrEditPer() {
        int r100 = this.send_card_auth_perm;
        if ((r100 & 1) == 0) goto L5;
    L8:
        return true;
    L5:
        if ((r100 & 4) != 0) goto L8;
        return false;
    }

    public boolean isPageStateContainer() {
        if (this.single_page_state == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isPageStateSinglePage() {
        if (this.single_page_state != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public Extra() {
        this.single_page_state = 0;
    }

    public int getSend_card_auth_perm() {
        return this.send_card_auth_perm;
    }

    public boolean isOwner_in_group() {
        return this.owner_in_group;
    }

    public Extra(Parcel r100) {
        boolean r101 = false;
        this.single_page_state = 0;
        this.send_card_auth_perm = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.owner_in_group = r101;
        this.single_page_state = r100.readInt();
    }

    public void setOwner_in_group(boolean r100) {
        this.owner_in_group = r100;
    }

    public void setSend_card_auth_perm(int r100) {
        this.send_card_auth_perm = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.send_card_auth_perm);
        r100.writeByte(this.owner_in_group ? 1 : 0);
        r100.writeInt(this.single_page_state);
    }
}
