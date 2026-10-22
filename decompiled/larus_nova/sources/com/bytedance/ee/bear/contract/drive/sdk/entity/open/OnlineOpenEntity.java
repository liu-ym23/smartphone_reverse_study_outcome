package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public class OnlineOpenEntity extends BaseOpenEntity {
    public static final Parcelable.Creator<OnlineOpenEntity> CREATOR = null;
    private String authExtra;
    private Long chatID;
    private Long chatType;
    private boolean isEncryptedFile;
    private String mountPoint;
    private String msgId;
    private int noPermissionTipsStringRes;
    private boolean restrictDownloadUsage;

    public class a implements Parcelable.Creator<OnlineOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OnlineOpenEntity createFromParcel(Parcel r100) {
            return new OnlineOpenEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final OnlineOpenEntity[] newArray(int r100) {
            return new OnlineOpenEntity[r100];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getAuthExtra() {
        return this.authExtra;
    }

    public Long getChatID() {
        return this.chatID;
    }

    public Long getChatType() {
        return this.chatType;
    }

    public boolean getEncryptedFile() {
        return this.isEncryptedFile;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity
    public String getMountPoint() {
        return this.mountPoint;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public int getNoPermissionTipsStringRes() {
        return this.noPermissionTipsStringRes;
    }

    public boolean isRestrictDownloadUsage() {
        return this.restrictDownloadUsage;
    }

    public OnlineOpenEntity(Parcel r100) {
        super(r100);
        this.mountPoint = "";
        boolean r101 = false;
        this.isEncryptedFile = false;
        this.authExtra = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.restrictDownloadUsage = r102;
        this.noPermissionTipsStringRes = r100.readInt();
        this.mountPoint = r100.readString();
        if (r100.readInt() == 0) goto L9;
        r101 = true;
    L9:
        this.isEncryptedFile = r101;
        this.msgId = r100.readString();
        long r103 = r100.readLong();
        Long r104 = null;
        if (r103 != (-1)) goto L12;
        Long r105 = null;
    L13:
        this.chatID = r105;
        long r106 = r100.readLong();
        if (r106 == (-1)) goto L17;
        r104 = Long.valueOf(r106);
    L17:
        this.chatType = r104;
        return;
    L12:
        r105 = Long.valueOf(r103);
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public void setAuthExtra(String r100) {
        this.authExtra = r100;
    }

    public void setChatID(Long r100) {
        this.chatID = r100;
    }

    public void setChatType(Long r100) {
        this.chatType = r100;
    }

    public void setEncryptedFile(boolean r100) {
        this.isEncryptedFile = r100;
    }

    public void setMountPoint(String r100) {
        this.mountPoint = r100;
    }

    public void setMsgId(String r100) {
        this.msgId = r100;
    }

    public void setNoPermissionTipsStringRes(int r100) {
        this.noPermissionTipsStringRes = r100;
    }

    public void setRestrictDownloadUsage(boolean r100) {
        this.restrictDownloadUsage = r100;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.authExtra);
        r100.writeByte(this.restrictDownloadUsage ? 1 : 0);
        r100.writeInt(this.noPermissionTipsStringRes);
        r100.writeString(this.mountPoint);
        r100.writeInt(this.isEncryptedFile ? 1 : 0);
        r100.writeString(this.msgId);
        Long r102 = this.chatID;
        long r103 = -1;
        if (r102 != null) goto L5;
        long r104 = -1;
    L6:
        r100.writeLong(r104);
        Long r105 = this.chatType;
        if (r105 == null) goto L10;
        r103 = r105.longValue();
    L10:
        r100.writeLong(r103);
        return;
    L5:
        r104 = r102.longValue();
        goto L6
    }

    public OnlineOpenEntity(String r110, String r111, String r112, ArrayList<BaseMoreMenuAction> r113, String r114, String r115, boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, "", null, null);
    }

    public OnlineOpenEntity(String r100, String r101, String r110, ArrayList<BaseMoreMenuAction> r111, String r112, String r113, boolean r114, String r115, Long r116, Long r117) {
        super(r100, r112, r101, r110, r111);
        this.mountPoint = "";
        this.isEncryptedFile = false;
        this.restrictDownloadUsage = r114;
        this.authExtra = r113;
        this.msgId = r115;
        this.chatID = r116;
        this.chatType = r117;
        setBizType(3);
        setMountPoint(DocumentType.IM_FILE_NAME);
    }
}
