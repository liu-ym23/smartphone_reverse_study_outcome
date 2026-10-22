package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import du5.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BaseOpenEntity implements NonProguard, Parcelable {
    protected static final String TAG = "DriveSdk#BaseOpenEntity";
    private String apiExtra;
    private String appId;
    private DriveBizScene bizScene;
    private int bizType;
    private String downloadFrom;
    private String encryptId;
    private Bundle extras;
    private String fileExt;
    private String fileId;
    private String fileName;
    private String fromModule;
    private HostDocumentInfo hostDocumentInfo;
    private boolean inBlock;
    private boolean inVc;
    private BinderOpenLifecycle mBinderOpenLifecycle;
    private ArrayList<BaseMoreMenuAction> mMoreMenuActions;
    private String mimeType;
    private String originToken;
    private BinderPermissionCallback permissionCallback;
    private String previewFrom;
    private int previewType;
    private Long senderTenantID;
    private Long senderUserId;
    private boolean tintWhiteBgInDarkMode;
    private String uniqueId;
    private boolean useLarkPreview;
    private DriveWatermarkScene watermarkScene;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLocalPath() {
        return "";
    }

    public String getMountPoint() {
        return null;
    }

    public String getFileId() {
        String r0 = this.fileId;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public Long getSenderTenantID() {
        Long r0 = this.senderTenantID;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return -1L;
    }

    public String toString() {
        return "BaseOpenEntity{appId='" + this.appId + "', fileId='" + b.i(this.fileId) + "', fileName='" + b.g(this.fileName) + "', uniqueId='" + b.g(this.uniqueId) + "', mMoreMenuActions=" + this.mMoreMenuActions + ", mBinderOpenLifecycle=" + this.mBinderOpenLifecycle + ", bizType=" + this.bizType + ", previewFrom=" + this.previewFrom + ", fileExt=" + this.fileExt + ", previewType=" + this.previewType + ", inVc=" + this.inVc + ", originToken=" + this.originToken + ", driveBizScene=" + this.bizScene + ", driveWatermarkScene=" + this.watermarkScene + '}';
    }

    public String getApiExtra() {
        return this.apiExtra;
    }

    public String getAppId() {
        return this.appId;
    }

    public BinderOpenLifecycle getBinderOpenLifecycle() {
        return this.mBinderOpenLifecycle;
    }

    public DriveBizScene getBizScene() {
        return this.bizScene;
    }

    public int getBizType() {
        return this.bizType;
    }

    public String getDownloadFrom() {
        return this.downloadFrom;
    }

    public String getEncryptId() {
        return this.encryptId;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public String getFileExt() {
        return this.fileExt;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFromModule() {
        return this.fromModule;
    }

    public HostDocumentInfo getHostDocumentInfo() {
        return this.hostDocumentInfo;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public ArrayList<BaseMoreMenuAction> getMoreMenuActions() {
        return this.mMoreMenuActions;
    }

    public String getOriginToken() {
        return this.originToken;
    }

    public BinderPermissionCallback getPermissionCallback() {
        return this.permissionCallback;
    }

    public String getPreviewFrom() {
        return this.previewFrom;
    }

    public int getPreviewType() {
        return this.previewType;
    }

    public Long getSenderUserID() {
        return this.senderUserId;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public DriveWatermarkScene getWatermarkScene() {
        return this.watermarkScene;
    }

    public boolean isInBlock() {
        return this.inBlock;
    }

    public boolean isInVc() {
        return this.inVc;
    }

    public boolean isTintWhiteBgInDarkMode() {
        return this.tintWhiteBgInDarkMode;
    }

    public boolean isUseLarkPreview() {
        return this.useLarkPreview;
    }

    public BaseOpenEntity(Parcel r9) {
        this.appId = "";
        this.fileId = "";
        this.fileName = "";
        this.uniqueId = "";
        this.fileExt = "";
        this.previewType = 0;
        this.useLarkPreview = false;
        this.downloadFrom = "unknown";
        this.senderTenantID = -1L;
        this.appId = r9.readString();     // Catch: Throwable -> L33
        this.fileId = r9.readString();     // Catch: Throwable -> L33
        this.fileName = r9.readString();     // Catch: Throwable -> L33
        this.uniqueId = r9.readString();     // Catch: Throwable -> L33
        ArrayList<BaseMoreMenuAction> r3 = new ArrayList();     // Catch: Throwable -> L33
        this.mMoreMenuActions = r3;     // Catch: Throwable -> L33
        r9.readList(r3, BaseMoreMenuAction.class.getClassLoader());     // Catch: Throwable -> L33
        this.mBinderOpenLifecycle = BinderOpenLifecycle.Stub.asInterface(r9.readStrongBinder());     // Catch: Throwable -> L33
        this.bizType = r9.readInt();     // Catch: Throwable -> L33
        this.apiExtra = r9.readString();     // Catch: Throwable -> L33
        this.previewFrom = r9.readString();     // Catch: Throwable -> L33
        this.fromModule = r9.readString();     // Catch: Throwable -> L33
        this.fileExt = r9.readString();     // Catch: Throwable -> L33
        this.extras = r9.readBundle();     // Catch: Throwable -> L33
        this.previewType = r9.readInt();     // Catch: Throwable -> L33
        boolean r4 = true;
        if (r9.readByte() == 0) goto L6;
        boolean r5 = true;
    L7:
        this.inVc = r5;     // Catch: Throwable -> L33
        this.originToken = r9.readString();     // Catch: Throwable -> L33
        this.encryptId = r9.readString();     // Catch: Throwable -> L33
        if (r9.readByte() == 0) goto L10;
        boolean r6 = true;
    L11:
        this.inBlock = r6;     // Catch: Throwable -> L33
        if (r9.readByte() == 0) goto L14;
        boolean r7 = true;
    L15:
        this.useLarkPreview = r7;     // Catch: Throwable -> L33
        this.downloadFrom = r9.readString();     // Catch: Throwable -> L33
        this.senderTenantID = Long.valueOf(r9.readLong());     // Catch: Throwable -> L33
        long r8 = r9.readLong();     // Catch: Throwable -> L33
        DriveWatermarkScene r10 = null;
        if (r8 != (-1)) goto L18;
        Long r1 = null;
    L19:
        this.senderUserId = r1;     // Catch: Throwable -> L33
        this.permissionCallback = BinderPermissionCallback.Stub.asInterface(r9.readStrongBinder());     // Catch: Throwable -> L33
        this.hostDocumentInfo = (HostDocumentInfo) r9.readSerializable();     // Catch: Throwable -> L33
        this.mimeType = r9.readString();     // Catch: Throwable -> L33
        int r2 = r9.readInt();     // Catch: Throwable -> L33
        if (r2 != (-1)) goto L22;
        DriveBizScene r11 = null;
    L23:
        this.bizScene = r11;     // Catch: Throwable -> L33
        int r12 = r9.readInt();     // Catch: Throwable -> L33
        if (r12 == (-1)) goto L27;
        r10 = DriveWatermarkScene.fromValue(r12);     // Catch: Throwable -> L33
    L27:
        this.watermarkScene = r10;     // Catch: Throwable -> L33
        if (r9.readByte() != 0) goto L31;
        r4 = false;
    L31:
        this.tintWhiteBgInDarkMode = r4;     // Catch: Throwable -> L33
        return;
    L22:
        r11 = DriveBizScene.fromValue(r2);     // Catch: Throwable -> L33
        goto L23
    L18:
        r1 = Long.valueOf(r8);     // Catch: Throwable -> L33
        goto L19
    L14:
        r7 = false;
        goto L15
    L10:
        r6 = false;
        goto L11
    L6:
        r5 = false;
    L33:
        th = move-exception;
        tt5.a.e(TAG, "BaseOpenEntity#BaseOpenEntity(Parcel) error=", th, false);
    }

    private void setDriveSceneParamsWithAppId(String r3) {
        if (c.a.a.h("admin.watermark.filewatermark.remaining") == false) goto L84;
        int r0 = rf5.c.a;
        if (TextUtils.isEmpty(r3) == false) goto L7;
        DriveBizScene r4 = DriveBizScene.DriveBizScene_UNKNOWN;
    L82:
        this.bizScene = r4;
        this.watermarkScene = DriveWatermarkScene.DriveWatermarkScene_UNKNOWN;
        return;
    L7:
        if (r3 == null) goto L81;
        int r1 = r3.hashCode();
        if (r1 == 50) goto L78;
        if (r1 == 1567) goto L74;
        if (r1 == 1576) goto L71;
        if (r1 == 1697) goto L68;
        if (r1 == 1756) goto L64;
        if (r1 == 449676720) goto L60;
        if (r1 == 1603) goto L56;
        if (r1 == 1604) goto L53;
        if (r1 == 1664) goto L50;
        if (r1 == 1665) goto L47;
        switch(r1) {
            case 1507424: goto L43;
            case 1507425: goto L39;
            case 1507426: goto L35;
            case 1507427: goto L31;
            default: goto L81;
        };
    L31:
        if (r3.equals("1004") == false) goto L81;
        r4 = DriveBizScene.DriveBizScene_WORKFLOW;
        goto L82
    L35:
        if (r3.equals("1003") == false) goto L81;
        r4 = DriveBizScene.DriveBizScene_IM;
        goto L82
    L39:
        if (r3.equals("1002") == false) goto L81;
        r4 = DriveBizScene.DriveBizScene_MINI_APP;
        goto L82
    L43:
        if (r3.equals("1001") == false) goto L81;
        r4 = DriveBizScene.DriveBizScene_IM;
        goto L82
    L47:
        if (r3.equals("45") == false) goto L81;
    L80:
        r4 = DriveBizScene.DriveBizScene_CCM;
        goto L82
    L50:
        if (r3.equals("44") == true) goto L80;
    L53:
        if (r3.equals("26") == false) goto L81;
    L62:
        r4 = DriveBizScene.DriveBizScene_BASE;
        goto L82
    L56:
        if (r3.equals("25") == false) goto L81;
        r4 = DriveBizScene.DriveBizScene_CALENDAR;
        goto L82
    L60:
        if (r3.equals("26_local") == true) goto L62;
    L64:
        if (r3.equals("73") == false) goto L81;
        r4 = DriveBizScene.DriveBizScene_TASK;
        goto L82
    L68:
        if (r3.equals("56") == true) goto L80;
    L71:
        if (r3.equals("19") == true) goto L80;
    L74:
        if (r3.equals("10") == false) goto L81;
        r4 = DriveBizScene.DriveBizScene_MAIL;
        goto L82
    L78:
        if (r3.equals("2") == true) goto L80;
    L81:
        r4 = DriveBizScene.DriveBizScene_UNKNOWN;
        goto L82
    }

    public void setApiExtra(String r1) {
        this.apiExtra = r1;
    }

    public void setAppId(String r1) {
        this.appId = r1;
        setDriveSceneParamsWithAppId(r1);
    }

    public BaseOpenEntity setBinderOpenLifecycle(BinderOpenLifecycle r1) {
        this.mBinderOpenLifecycle = r1;
        return this;
    }

    public void setBizScene(DriveBizScene r1) {
        this.bizScene = r1;
    }

    public void setBizType(int r1) {
        this.bizType = r1;
    }

    public void setDownloadFrom(String r1) {
        this.downloadFrom = r1;
    }

    public void setEncryptId(String r1) {
        this.encryptId = r1;
    }

    public void setExtras(Bundle r1) {
        this.extras = r1;
    }

    public void setFileExt(String r1) {
        this.fileExt = r1;
    }

    public void setFileId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.fileId = r1;
    }

    public void setFileName(String r1) {
        this.fileName = r1;
    }

    public void setFromModule(String r1) {
        this.fromModule = r1;
    }

    public void setHostDocumentInfo(HostDocumentInfo r1) {
        this.hostDocumentInfo = r1;
    }

    public void setInBlock(boolean r1) {
        this.inBlock = r1;
    }

    public void setInVc(boolean r1) {
        this.inVc = r1;
    }

    public void setMimeType(String r1) {
        this.mimeType = r1;
    }

    public void setMoreMenuActions(ArrayList<BaseMoreMenuAction> r1) {
        this.mMoreMenuActions = r1;
    }

    public void setOriginToken(String r1) {
        this.originToken = r1;
    }

    public void setPermissionCallback(BinderPermissionCallback r1) {
        this.permissionCallback = r1;
    }

    public void setPreviewFrom(String r1) {
        this.previewFrom = r1;
    }

    public void setPreviewType(int r1) {
        this.previewType = r1;
    }

    public void setSenderTenantID(Long r1) {
        this.senderTenantID = r1;
    }

    public void setSenderUserID(Long r1) {
        this.senderUserId = r1;
    }

    public void setTintWhiteBgInDarkMode(boolean r1) {
        this.tintWhiteBgInDarkMode = r1;
    }

    public void setUniqueId(String r1) {
        this.uniqueId = r1;
    }

    public void setUseLarkPreview(boolean r1) {
        this.useLarkPreview = r1;
    }

    public void setWatermarkScene(DriveWatermarkScene r1) {
        this.watermarkScene = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r9) {
        r8.writeString(this.appId);     // Catch: Throwable -> L45
        r8.writeString(this.fileId);     // Catch: Throwable -> L45
        r8.writeString(this.fileName);     // Catch: Throwable -> L45
        r8.writeString(this.uniqueId);     // Catch: Throwable -> L45
        r8.writeList(this.mMoreMenuActions);     // Catch: Throwable -> L45
        BinderOpenLifecycle r0 = this.mBinderOpenLifecycle;     // Catch: Throwable -> L45
        IBinder r1 = null;
        if (r0 != null) goto L6;
        IBinder r2 = null;
    L7:
        r8.writeStrongBinder(r2);     // Catch: Throwable -> L45
        r8.writeInt(this.bizType);     // Catch: Throwable -> L45
        r8.writeString(this.apiExtra);     // Catch: Throwable -> L45
        r8.writeString(this.previewFrom);     // Catch: Throwable -> L45
        r8.writeString(this.fromModule);     // Catch: Throwable -> L45
        r8.writeString(this.fileExt);     // Catch: Throwable -> L45
        r8.writeBundle(this.extras);     // Catch: Throwable -> L45
        r8.writeInt(this.previewType);     // Catch: Throwable -> L45
        byte r3 = 1;
        if (this.inVc == false) goto L10;
        byte r4 = 1;
    L11:
        r8.writeByte(r4);     // Catch: Throwable -> L45
        r8.writeString(this.originToken);     // Catch: Throwable -> L45
        r8.writeString(this.encryptId);     // Catch: Throwable -> L45
        if (this.inBlock == false) goto L14;
        byte r5 = 1;
    L15:
        r8.writeByte(r5);     // Catch: Throwable -> L45
        if (this.useLarkPreview == false) goto L18;
        byte r6 = 1;
    L19:
        r8.writeByte(r6);     // Catch: Throwable -> L45
        r8.writeString(this.downloadFrom);     // Catch: Throwable -> L45
        Long r7 = this.senderTenantID;     // Catch: Throwable -> L45
        long r10 = -1;
        if (r7 != null) goto L22;
        long r11 = -1;
    L23:
        r8.writeLong(r11);     // Catch: Throwable -> L45
        Long r12 = this.senderUserId;     // Catch: Throwable -> L45
        if (r12 == null) goto L27;
        r10 = r12.longValue();     // Catch: Throwable -> L45
    L27:
        r8.writeLong(r10);     // Catch: Throwable -> L45
        BinderPermissionCallback r13 = this.permissionCallback;     // Catch: Throwable -> L45
        if (r13 == null) goto L31;
        r1 = r13.asBinder();     // Catch: Throwable -> L45
    L31:
        r8.writeStrongBinder(r1);     // Catch: Throwable -> L45
        r8.writeSerializable(this.hostDocumentInfo);     // Catch: Throwable -> L45
        r8.writeString(this.mimeType);     // Catch: Throwable -> L45
        DriveBizScene r14 = this.bizScene;     // Catch: Throwable -> L45
        int r16 = -1;
        if (r14 != null) goto L34;
        int r17 = -1;
    L35:
        r8.writeInt(r17);     // Catch: Throwable -> L45
        DriveWatermarkScene r18 = this.watermarkScene;     // Catch: Throwable -> L45
        if (r18 == null) goto L39;
        r16 = r18.getValue();     // Catch: Throwable -> L45
    L39:
        r8.writeInt(r16);     // Catch: Throwable -> L45
        if (this.tintWhiteBgInDarkMode == true) goto L43;
        r3 = 0;
    L43:
        r8.writeByte(r3);     // Catch: Throwable -> L45
        return;
    L34:
        r17 = r14.getValue();     // Catch: Throwable -> L45
        goto L35
    L22:
        r11 = r7.longValue();     // Catch: Throwable -> L45
        goto L23
    L18:
        r6 = 0;
        goto L19
    L14:
        r5 = 0;
        goto L15
    L10:
        r4 = 0;
        goto L11
    L6:
        r2 = r0.asBinder();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        tt5.a.e(TAG, "BaseOpenEntity#writeToParcel() error=", th, false);
    }

    public BaseOpenEntity(String r8, String r9, String r10, String r11, ArrayList<BaseMoreMenuAction> r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    public BaseOpenEntity(String r3, String r4, String r5, String r6, ArrayList<BaseMoreMenuAction> r7, BinderOpenLifecycle r8) {
        this.appId = "";
        this.fileId = "";
        this.fileName = "";
        this.uniqueId = "";
        this.fileExt = "";
        this.previewType = 0;
        this.useLarkPreview = false;
        this.downloadFrom = "unknown";
        this.senderTenantID = -1L;
        this.appId = r3;
        this.fileId = r4;
        this.fileName = r5;
        this.uniqueId = r6;
        this.mMoreMenuActions = r7;
        this.mBinderOpenLifecycle = r8;
        setDriveSceneParamsWithAppId(r3);
    }
}
