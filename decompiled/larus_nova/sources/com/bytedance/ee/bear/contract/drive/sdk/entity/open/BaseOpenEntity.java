package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.tencent.connect.common.Constants;
import du5.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
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
        String r100 = this.fileId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public Long getSenderTenantID() {
        Long r100 = this.senderTenantID;
        if (r100 == null) goto L5;
        return r100;
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

    public BaseOpenEntity(Parcel r100) {
        this.appId = "";
        this.fileId = "";
        this.fileName = "";
        this.uniqueId = "";
        this.fileExt = "";
        this.previewType = 0;
        this.useLarkPreview = false;
        this.downloadFrom = "unknown";
        this.senderTenantID = -1L;
        this.appId = r100.readString();     // Catch: Throwable -> L33
        this.fileId = r100.readString();     // Catch: Throwable -> L33
        this.fileName = r100.readString();     // Catch: Throwable -> L33
        this.uniqueId = r100.readString();     // Catch: Throwable -> L33
        ArrayList<BaseMoreMenuAction> r101 = new ArrayList();     // Catch: Throwable -> L33
        this.mMoreMenuActions = r101;     // Catch: Throwable -> L33
        r100.readList(r101, BaseMoreMenuAction.class.getClassLoader());     // Catch: Throwable -> L33
        this.mBinderOpenLifecycle = BinderOpenLifecycle.Stub.asInterface(r100.readStrongBinder());     // Catch: Throwable -> L33
        this.bizType = r100.readInt();     // Catch: Throwable -> L33
        this.apiExtra = r100.readString();     // Catch: Throwable -> L33
        this.previewFrom = r100.readString();     // Catch: Throwable -> L33
        this.fromModule = r100.readString();     // Catch: Throwable -> L33
        this.fileExt = r100.readString();     // Catch: Throwable -> L33
        this.extras = r100.readBundle();     // Catch: Throwable -> L33
        this.previewType = r100.readInt();     // Catch: Throwable -> L33
        boolean r102 = true;
        if (r100.readByte() == 0) goto L6;
        boolean r103 = true;
    L7:
        this.inVc = r103;     // Catch: Throwable -> L33
        this.originToken = r100.readString();     // Catch: Throwable -> L33
        this.encryptId = r100.readString();     // Catch: Throwable -> L33
        if (r100.readByte() == 0) goto L10;
        boolean r104 = true;
    L11:
        this.inBlock = r104;     // Catch: Throwable -> L33
        if (r100.readByte() == 0) goto L14;
        boolean r105 = true;
    L15:
        this.useLarkPreview = r105;     // Catch: Throwable -> L33
        this.downloadFrom = r100.readString();     // Catch: Throwable -> L33
        this.senderTenantID = Long.valueOf(r100.readLong());     // Catch: Throwable -> L33
        long r106 = r100.readLong();     // Catch: Throwable -> L33
        DriveWatermarkScene r107 = null;
        if (r106 != (-1)) goto L18;
        Long r108 = null;
    L19:
        this.senderUserId = r108;     // Catch: Throwable -> L33
        this.permissionCallback = BinderPermissionCallback.Stub.asInterface(r100.readStrongBinder());     // Catch: Throwable -> L33
        this.hostDocumentInfo = (HostDocumentInfo) r100.readSerializable();     // Catch: Throwable -> L33
        this.mimeType = r100.readString();     // Catch: Throwable -> L33
        int r109 = r100.readInt();     // Catch: Throwable -> L33
        if (r109 != (-1)) goto L22;
        DriveBizScene r110 = null;
    L23:
        this.bizScene = r110;     // Catch: Throwable -> L33
        int r111 = r100.readInt();     // Catch: Throwable -> L33
        if (r111 == (-1)) goto L27;
        r107 = DriveWatermarkScene.fromValue(r111);     // Catch: Throwable -> L33
    L27:
        this.watermarkScene = r107;     // Catch: Throwable -> L33
        if (r100.readByte() != 0) goto L31;
        r102 = false;
    L31:
        this.tintWhiteBgInDarkMode = r102;     // Catch: Throwable -> L33
        return;
    L22:
        r110 = DriveBizScene.fromValue(r109);     // Catch: Throwable -> L33
        goto L23
    L18:
        r108 = Long.valueOf(r106);     // Catch: Throwable -> L33
        goto L19
    L14:
        r105 = false;
        goto L15
    L10:
        r104 = false;
        goto L11
    L6:
        r103 = false;
    L33:
        th = move-exception;
        tt5.a.e(TAG, "BaseOpenEntity#BaseOpenEntity(Parcel) error=", th, false);
    }

    private void setDriveSceneParamsWithAppId(String r100) {
        if (c.a.f206237a.h("admin.watermark.filewatermark.remaining") == false) goto L84;
        int r101 = rf5.c.f537614a;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        DriveBizScene r102 = DriveBizScene.DriveBizScene_UNKNOWN;
    L82:
        this.bizScene = r102;
        this.watermarkScene = DriveWatermarkScene.DriveWatermarkScene_UNKNOWN;
        return;
    L7:
        if (r100 == null) goto L81;
        int r103 = r100.hashCode();
        if (r103 == 50) goto L78;
        if (r103 == 1567) goto L74;
        if (r103 == 1576) goto L71;
        if (r103 == 1697) goto L68;
        if (r103 == 1756) goto L64;
        if (r103 == 449676720) goto L60;
        if (r103 == 1603) goto L56;
        if (r103 == 1604) goto L53;
        if (r103 == 1664) goto L50;
        if (r103 == 1665) goto L47;
        switch(r103) {
            case 1507424: goto L43;
            case 1507425: goto L39;
            case 1507426: goto L35;
            case 1507427: goto L31;
            default: goto L81;
        };
    L31:
        if (r100.equals("1004") == false) goto L81;
        r102 = DriveBizScene.DriveBizScene_WORKFLOW;
        goto L82
    L35:
        if (r100.equals("1003") == false) goto L81;
        r102 = DriveBizScene.DriveBizScene_IM;
        goto L82
    L39:
        if (r100.equals(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M) == false) goto L81;
        r102 = DriveBizScene.DriveBizScene_MINI_APP;
        goto L82
    L43:
        if (r100.equals(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF) == false) goto L81;
        r102 = DriveBizScene.DriveBizScene_IM;
        goto L82
    L47:
        if (r100.equals("45") == false) goto L81;
    L80:
        r102 = DriveBizScene.DriveBizScene_CCM;
        goto L82
    L50:
        if (r100.equals(BDLocationException.ERROR_BYTE_DISABLE_USE_WIFI) == true) goto L80;
    L53:
        if (r100.equals("26") == false) goto L81;
    L62:
        r102 = DriveBizScene.DriveBizScene_BASE;
        goto L82
    L56:
        if (r100.equals(Constants.VIA_REPORT_TYPE_CHAT_AUDIO) == false) goto L81;
        r102 = DriveBizScene.DriveBizScene_CALENDAR;
        goto L82
    L60:
        if (r100.equals("26_local") == true) goto L62;
    L64:
        if (r100.equals("73") == false) goto L81;
        r102 = DriveBizScene.DriveBizScene_TASK;
        goto L82
    L68:
        if (r100.equals(BDLocationException.ERROR_SHAKE_UPLOAD) == true) goto L80;
    L71:
        if (r100.equals(Constants.VIA_ACT_TYPE_NINETEEN) == true) goto L80;
    L74:
        if (r100.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) == false) goto L81;
        r102 = DriveBizScene.DriveBizScene_MAIL;
        goto L82
    L78:
        if (r100.equals("2") == true) goto L80;
    L81:
        r102 = DriveBizScene.DriveBizScene_UNKNOWN;
        goto L82
    }

    public void setApiExtra(String r100) {
        this.apiExtra = r100;
    }

    public void setAppId(String r100) {
        this.appId = r100;
        setDriveSceneParamsWithAppId(r100);
    }

    public BaseOpenEntity setBinderOpenLifecycle(BinderOpenLifecycle r100) {
        this.mBinderOpenLifecycle = r100;
        return this;
    }

    public void setBizScene(DriveBizScene r100) {
        this.bizScene = r100;
    }

    public void setBizType(int r100) {
        this.bizType = r100;
    }

    public void setDownloadFrom(String r100) {
        this.downloadFrom = r100;
    }

    public void setEncryptId(String r100) {
        this.encryptId = r100;
    }

    public void setExtras(Bundle r100) {
        this.extras = r100;
    }

    public void setFileExt(String r100) {
        this.fileExt = r100;
    }

    public void setFileId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.fileId = r100;
    }

    public void setFileName(String r100) {
        this.fileName = r100;
    }

    public void setFromModule(String r100) {
        this.fromModule = r100;
    }

    public void setHostDocumentInfo(HostDocumentInfo r100) {
        this.hostDocumentInfo = r100;
    }

    public void setInBlock(boolean r100) {
        this.inBlock = r100;
    }

    public void setInVc(boolean r100) {
        this.inVc = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setMoreMenuActions(ArrayList<BaseMoreMenuAction> r100) {
        this.mMoreMenuActions = r100;
    }

    public void setOriginToken(String r100) {
        this.originToken = r100;
    }

    public void setPermissionCallback(BinderPermissionCallback r100) {
        this.permissionCallback = r100;
    }

    public void setPreviewFrom(String r100) {
        this.previewFrom = r100;
    }

    public void setPreviewType(int r100) {
        this.previewType = r100;
    }

    public void setSenderTenantID(Long r100) {
        this.senderTenantID = r100;
    }

    public void setSenderUserID(Long r100) {
        this.senderUserId = r100;
    }

    public void setTintWhiteBgInDarkMode(boolean r100) {
        this.tintWhiteBgInDarkMode = r100;
    }

    public void setUniqueId(String r100) {
        this.uniqueId = r100;
    }

    public void setUseLarkPreview(boolean r100) {
        this.useLarkPreview = r100;
    }

    public void setWatermarkScene(DriveWatermarkScene r100) {
        this.watermarkScene = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.appId);     // Catch: Throwable -> L45
        r100.writeString(this.fileId);     // Catch: Throwable -> L45
        r100.writeString(this.fileName);     // Catch: Throwable -> L45
        r100.writeString(this.uniqueId);     // Catch: Throwable -> L45
        r100.writeList(this.mMoreMenuActions);     // Catch: Throwable -> L45
        BinderOpenLifecycle r102 = this.mBinderOpenLifecycle;     // Catch: Throwable -> L45
        IBinder r103 = null;
        if (r102 != null) goto L6;
        IBinder r104 = null;
    L7:
        r100.writeStrongBinder(r104);     // Catch: Throwable -> L45
        r100.writeInt(this.bizType);     // Catch: Throwable -> L45
        r100.writeString(this.apiExtra);     // Catch: Throwable -> L45
        r100.writeString(this.previewFrom);     // Catch: Throwable -> L45
        r100.writeString(this.fromModule);     // Catch: Throwable -> L45
        r100.writeString(this.fileExt);     // Catch: Throwable -> L45
        r100.writeBundle(this.extras);     // Catch: Throwable -> L45
        r100.writeInt(this.previewType);     // Catch: Throwable -> L45
        byte r105 = 1;
        if (this.inVc == false) goto L10;
        byte r106 = 1;
    L11:
        r100.writeByte(r106);     // Catch: Throwable -> L45
        r100.writeString(this.originToken);     // Catch: Throwable -> L45
        r100.writeString(this.encryptId);     // Catch: Throwable -> L45
        if (this.inBlock == false) goto L14;
        byte r107 = 1;
    L15:
        r100.writeByte(r107);     // Catch: Throwable -> L45
        if (this.useLarkPreview == false) goto L18;
        byte r108 = 1;
    L19:
        r100.writeByte(r108);     // Catch: Throwable -> L45
        r100.writeString(this.downloadFrom);     // Catch: Throwable -> L45
        Long r109 = this.senderTenantID;     // Catch: Throwable -> L45
        long r110 = -1;
        if (r109 != null) goto L22;
        long r111 = -1;
    L23:
        r100.writeLong(r111);     // Catch: Throwable -> L45
        Long r112 = this.senderUserId;     // Catch: Throwable -> L45
        if (r112 == null) goto L27;
        r110 = r112.longValue();     // Catch: Throwable -> L45
    L27:
        r100.writeLong(r110);     // Catch: Throwable -> L45
        BinderPermissionCallback r113 = this.permissionCallback;     // Catch: Throwable -> L45
        if (r113 == null) goto L31;
        r103 = r113.asBinder();     // Catch: Throwable -> L45
    L31:
        r100.writeStrongBinder(r103);     // Catch: Throwable -> L45
        r100.writeSerializable(this.hostDocumentInfo);     // Catch: Throwable -> L45
        r100.writeString(this.mimeType);     // Catch: Throwable -> L45
        DriveBizScene r114 = this.bizScene;     // Catch: Throwable -> L45
        int r115 = -1;
        if (r114 != null) goto L34;
        int r116 = -1;
    L35:
        r100.writeInt(r116);     // Catch: Throwable -> L45
        DriveWatermarkScene r117 = this.watermarkScene;     // Catch: Throwable -> L45
        if (r117 == null) goto L39;
        r115 = r117.getValue();     // Catch: Throwable -> L45
    L39:
        r100.writeInt(r115);     // Catch: Throwable -> L45
        if (this.tintWhiteBgInDarkMode == true) goto L43;
        r105 = 0;
    L43:
        r100.writeByte(r105);     // Catch: Throwable -> L45
        return;
    L34:
        r116 = r114.getValue();     // Catch: Throwable -> L45
        goto L35
    L22:
        r111 = r109.longValue();     // Catch: Throwable -> L45
        goto L23
    L18:
        r108 = 0;
        goto L19
    L14:
        r107 = 0;
        goto L15
    L10:
        r106 = 0;
        goto L11
    L6:
        r104 = r102.asBinder();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        tt5.a.e(TAG, "BaseOpenEntity#writeToParcel() error=", th, false);
    }

    public BaseOpenEntity(String r100, String r101, String r110, String r111, ArrayList<BaseMoreMenuAction> r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public BaseOpenEntity(String r100, String r101, String r102, String r103, ArrayList<BaseMoreMenuAction> r104, BinderOpenLifecycle r105) {
        this.appId = "";
        this.fileId = "";
        this.fileName = "";
        this.uniqueId = "";
        this.fileExt = "";
        this.previewType = 0;
        this.useLarkPreview = false;
        this.downloadFrom = "unknown";
        this.senderTenantID = -1L;
        this.appId = r100;
        this.fileId = r101;
        this.fileName = r102;
        this.uniqueId = r103;
        this.mMoreMenuActions = r104;
        this.mBinderOpenLifecycle = r105;
        setDriveSceneParamsWithAppId(r100);
    }
}
