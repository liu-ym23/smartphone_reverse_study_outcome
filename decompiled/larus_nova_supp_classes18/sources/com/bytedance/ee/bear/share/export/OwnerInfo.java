package com.bytedance.ee.bear.share.export;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OwnerInfo implements Parcelable, NonProguard {
    public static final Parcelable.Creator<OwnerInfo> CREATOR = null;
    private boolean admin_can_cross;
    private String avatar_url;
    private boolean can_apply_perm;
    private String cn_name;
    private String display_name;
    private String email;
    private String en_name;
    private String id;
    private String mobile;
    private String name;
    private String suid;
    private String tenant_id;
    private String tenant_name;

    public class a implements Parcelable.Creator<OwnerInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OwnerInfo createFromParcel(Parcel r2) {
            return new OwnerInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OwnerInfo[] newArray(int r1) {
            return new OwnerInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getId() {
        return this.id + "";
    }

    public String toString() {
        return "OwnerInfo{admin_can_cross=" + this.admin_can_cross + '}';
    }

    public OwnerInfo() {
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public String getCn_name() {
        return this.cn_name;
    }

    public String getDisplay_name() {
        return this.display_name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEn_name() {
        return this.en_name;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public String getSuid() {
        return this.suid;
    }

    public String getTenant_id() {
        return this.tenant_id;
    }

    public String getTenant_name() {
        return this.tenant_name;
    }

    public boolean isAdmin_can_cross() {
        return this.admin_can_cross;
    }

    public boolean isCan_apply_perm() {
        return this.can_apply_perm;
    }

    public OwnerInfo(Parcel r4) {
        this.id = r4.readString();
        this.name = r4.readString();
        this.cn_name = r4.readString();
        this.en_name = r4.readString();
        this.email = r4.readString();
        this.mobile = r4.readString();
        this.suid = r4.readString();
        this.avatar_url = r4.readString();
        this.tenant_name = r4.readString();
        this.tenant_id = r4.readString();
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.can_apply_perm = r0;
        if (r4.readByte() != 0) goto L10;
        r1 = false;
    L10:
        this.admin_can_cross = r1;
        this.display_name = r4.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setAdmin_can_cross(boolean r1) {
        this.admin_can_cross = r1;
    }

    public void setAvatar_url(String r1) {
        this.avatar_url = r1;
    }

    public void setCan_apply_perm(boolean r1) {
        this.can_apply_perm = r1;
    }

    public void setCn_name(String r1) {
        this.cn_name = r1;
    }

    public void setDisplay_name(String r1) {
        this.display_name = r1;
    }

    public void setEmail(String r1) {
        this.email = r1;
    }

    public void setEn_name(String r1) {
        this.en_name = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setMobile(String r1) {
        this.mobile = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setSuid(String r1) {
        this.suid = r1;
    }

    public void setTenant_id(String r1) {
        this.tenant_id = r1;
    }

    public void setTenant_name(String r1) {
        this.tenant_name = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.id);
        r1.writeString(this.name);
        r1.writeString(this.cn_name);
        r1.writeString(this.en_name);
        r1.writeString(this.email);
        r1.writeString(this.mobile);
        r1.writeString(this.suid);
        r1.writeString(this.avatar_url);
        r1.writeString(this.tenant_name);
        r1.writeString(this.tenant_id);
        r1.writeByte(this.can_apply_perm ? 1 : 0);
        r1.writeByte(this.admin_can_cross ? 1 : 0);
        r1.writeString(this.display_name);
    }
}
