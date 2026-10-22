package com.bytedance.ee.bear.share.export;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class OwnerInfo implements Parcelable, NonProguard {
    public static final Parcelable.Creator<OwnerInfo> CREATOR = null;
    private boolean admin_can_cross;
    private String avatar_url;
    private boolean can_apply_perm;
    private String cn_name;
    private String display_name;
    private String email;
    private String en_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f237018id;
    private String mobile;
    private String name;
    private String suid;
    private String tenant_id;
    private String tenant_name;

    public class a implements Parcelable.Creator<OwnerInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OwnerInfo createFromParcel(Parcel r100) {
            return new OwnerInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final OwnerInfo[] newArray(int r100) {
            return new OwnerInfo[r100];
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
        return this.f237018id + "";
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

    public OwnerInfo(Parcel r100) {
        this.f237018id = r100.readString();
        this.name = r100.readString();
        this.cn_name = r100.readString();
        this.en_name = r100.readString();
        this.email = r100.readString();
        this.mobile = r100.readString();
        this.suid = r100.readString();
        this.avatar_url = r100.readString();
        this.tenant_name = r100.readString();
        this.tenant_id = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.can_apply_perm = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.admin_can_cross = r101;
        this.display_name = r100.readString();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setAdmin_can_cross(boolean r100) {
        this.admin_can_cross = r100;
    }

    public void setAvatar_url(String r100) {
        this.avatar_url = r100;
    }

    public void setCan_apply_perm(boolean r100) {
        this.can_apply_perm = r100;
    }

    public void setCn_name(String r100) {
        this.cn_name = r100;
    }

    public void setDisplay_name(String r100) {
        this.display_name = r100;
    }

    public void setEmail(String r100) {
        this.email = r100;
    }

    public void setEn_name(String r100) {
        this.en_name = r100;
    }

    public void setId(String r100) {
        this.f237018id = r100;
    }

    public void setMobile(String r100) {
        this.mobile = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setSuid(String r100) {
        this.suid = r100;
    }

    public void setTenant_id(String r100) {
        this.tenant_id = r100;
    }

    public void setTenant_name(String r100) {
        this.tenant_name = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f237018id);
        r100.writeString(this.name);
        r100.writeString(this.cn_name);
        r100.writeString(this.en_name);
        r100.writeString(this.email);
        r100.writeString(this.mobile);
        r100.writeString(this.suid);
        r100.writeString(this.avatar_url);
        r100.writeString(this.tenant_name);
        r100.writeString(this.tenant_id);
        r100.writeByte(this.can_apply_perm ? 1 : 0);
        r100.writeByte(this.admin_can_cross ? 1 : 0);
        r100.writeString(this.display_name);
    }
}
