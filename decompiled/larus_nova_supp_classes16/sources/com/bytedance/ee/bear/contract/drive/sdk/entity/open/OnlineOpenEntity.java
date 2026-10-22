package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final OnlineOpenEntity createFromParcel(Parcel r2) {
            return new OnlineOpenEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OnlineOpenEntity[] newArray(int r1) {
            return new OnlineOpenEntity[r1];
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

    public OnlineOpenEntity(Parcel r7) {
        super(r7);
        this.mountPoint = "";
        boolean r0 = false;
        this.isEncryptedFile = false;
        this.authExtra = r7.readString();
        if (r7.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.restrictDownloadUsage = r1;
        this.noPermissionTipsStringRes = r7.readInt();
        this.mountPoint = r7.readString();
        if (r7.readInt() == 0) goto L9;
        r0 = true;
    L9:
        this.isEncryptedFile = r0;
        this.msgId = r7.readString();
        long r2 = r7.readLong();
        Long r3 = null;
        if (r2 != (-1)) goto L12;
        Long r4 = null;
    L13:
        this.chatID = r4;
        long r5 = r7.readLong();
        if (r5 == (-1)) goto L17;
        r3 = Long.valueOf(r5);
    L17:
        this.chatType = r3;
        return;
    L12:
        r4 = Long.valueOf(r2);
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public void setAuthExtra(String r1) {
        this.authExtra = r1;
    }

    public void setChatID(Long r1) {
        this.chatID = r1;
    }

    public void setChatType(Long r1) {
        this.chatType = r1;
    }

    public void setEncryptedFile(boolean r1) {
        this.isEncryptedFile = r1;
    }

    public void setMountPoint(String r1) {
        this.mountPoint = r1;
    }

    public void setMsgId(String r1) {
        this.msgId = r1;
    }

    public void setNoPermissionTipsStringRes(int r1) {
        this.noPermissionTipsStringRes = r1;
    }

    public void setRestrictDownloadUsage(boolean r1) {
        this.restrictDownloadUsage = r1;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        super.writeToParcel(r5, r6);
        r5.writeString(this.authExtra);
        r5.writeByte(this.restrictDownloadUsage ? 1 : 0);
        r5.writeInt(this.noPermissionTipsStringRes);
        r5.writeString(this.mountPoint);
        r5.writeInt(this.isEncryptedFile ? 1 : 0);
        r5.writeString(this.msgId);
        Long r7 = this.chatID;
        long r0 = -1;
        if (r7 != null) goto L5;
        long r2 = -1;
    L6:
        r5.writeLong(r2);
        Long r8 = this.chatType;
        if (r8 == null) goto L10;
        r0 = r8.longValue();
    L10:
        r5.writeLong(r0);
        return;
    L5:
        r2 = r7.longValue();
        goto L6
    }

    public OnlineOpenEntity(String r12, String r13, String r14, ArrayList<BaseMoreMenuAction> r16, String r17, String r18, boolean r19) {
        this(r12, r13, r14, r16, r17, r18, r19, "", null, null);
    }

    public OnlineOpenEntity(String r8, String r9, String r10, ArrayList<BaseMoreMenuAction> r11, String r12, String r13, boolean r14, String r16, Long r17, Long r18) {
        super(r8, r12, r9, r10, r11);
        this.mountPoint = "";
        this.isEncryptedFile = false;
        this.restrictDownloadUsage = r14;
        this.authExtra = r13;
        this.msgId = r16;
        this.chatID = r17;
        this.chatType = r18;
        setBizType(3);
        setMountPoint("im_file");
    }
}
