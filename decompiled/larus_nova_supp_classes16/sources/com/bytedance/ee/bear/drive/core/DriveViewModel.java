package com.bytedance.ee.bear.drive.core;

import android.os.Bundle;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.DefaultOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import kotlin.reflect.KClass;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveViewModel extends ViewModel {
    private final Bundle mArgs;
    private int mBizType;
    private boolean mCanRead;
    private final MutableLiveData<String> mFileName;
    private c mIFileModel;
    private boolean mIsAdminPerceiveControl;
    private boolean mIsCacPreviewControl;
    private boolean mIsDeleted;
    private boolean mIsDlpUploadControl;
    private final MutableLiveData<Boolean> mIsHistoryModel;
    private boolean mIsVcModel;
    private BaseOpenEntity mOpenEntity;
    private final MutableLiveData<Integer> mPreviewType;
    private final MutableLiveData<Boolean> mRiskFlag;
    private final MutableLiveData<String> mTitleBarSubtitleOverride;
    private WikiInfo mWikiInfo;

    public class a implements ViewModelProvider.Factory {
        public final /* synthetic */ Bundle a;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public a(Bundle r1) {
            this.a = r1;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            return new DriveViewModel(this.a);
        }
    }

    public DriveViewModel() {
        this(null);
    }

    public void clearTitleBarSubtitleOverride() {
        updateTitleBarSubtitleOverride(null);
    }

    public void enterHistoryMode() {
        tt5.a.h("DriveSdk", "enterHistoryMode()");
        this.mIsHistoryModel.postValue(Boolean.TRUE);
    }

    public boolean fromBlockPreview() {
        if (this.mOpenEntity.getPreviewType() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public String getFileId() {
        return this.mOpenEntity.getFileId();
    }

    public <FM extends w75.a> FM getFileModel() {
        c r0 = this.mIFileModel;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (FM) r0.getDetails();
    }

    public String getFileName() {
        return (String) this.mFileName.getValue();
    }

    public String getTitleBarSubtitleOverride() {
        return (String) this.mTitleBarSubtitleOverride.getValue();
    }

    public boolean isHistoryMode() {
        if (this.mIsHistoryModel.getValue() != null) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) this.mIsHistoryModel.getValue()).booleanValue() == false) goto L7;
        return true;
    }

    public boolean isHostInVcState() {
        if (((Integer) this.mPreviewType.getValue()).intValue() != 1) goto L5;
    L7:
        return false;
    L5:
        if (this.mOpenEntity.isInVc() == false) goto L7;
        return true;
    }

    public boolean isInBlockFullScreenState() {
        if (((Integer) this.mPreviewType.getValue()).intValue() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInBlockState() {
        if (((Integer) this.mPreviewType.getValue()).intValue() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInVcState() {
        if (((Integer) this.mPreviewType.getValue()).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTypeWiki() {
        WikiInfo r0 = this.mWikiInfo;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isValid() == false) goto L7;
        return true;
    }

    public boolean isVCAttachment() {
        if (this.mOpenEntity.isInVc() == true) goto L10;
        Bundle r0 = this.mArgs;
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (r0.getBoolean("vc_follow_attachment") == false) goto L9;
    L10:
        return true;
    }

    public boolean canRead() {
        return this.mCanRead;
    }

    public Bundle getArgs() {
        return this.mArgs;
    }

    public int getBizType() {
        return this.mBizType;
    }

    public <FM extends w75.a> c<FM> getIFileModel() {
        return this.mIFileModel;
    }

    public boolean getIsCacPreviewControl() {
        return this.mIsCacPreviewControl;
    }

    public boolean getIsDlpUploadControl() {
        return this.mIsDlpUploadControl;
    }

    public BaseOpenEntity getOpenEntity() {
        return this.mOpenEntity;
    }

    public WikiInfo getWikiInfo() {
        return this.mWikiInfo;
    }

    public boolean isIsAdminPerceiveControl() {
        return this.mIsAdminPerceiveControl;
    }

    public boolean isIsDeleted() {
        return this.mIsDeleted;
    }

    public boolean isVCFollowMode() {
        return this.mIsVcModel;
    }

    public LiveData<String> liveFileName() {
        return this.mFileName;
    }

    public LiveData<Boolean> liveHistoryMode() {
        return this.mIsHistoryModel;
    }

    public LiveData<Integer> livePreviewType() {
        return this.mPreviewType;
    }

    public LiveData<Boolean> liveRiskFlag() {
        return this.mRiskFlag;
    }

    public LiveData<String> liveTitleBarSubtitleOverride() {
        return this.mTitleBarSubtitleOverride;
    }

    public DriveViewModel(Bundle r4) {
        this.mFileName = new MutableLiveData();
        this.mIsHistoryModel = new MutableLiveData(Boolean.FALSE);
        this.mPreviewType = new MutableLiveData(0);
        this.mRiskFlag = new MutableLiveData();
        this.mTitleBarSubtitleOverride = new MutableLiveData(null);
        this.mIsAdminPerceiveControl = false;
        this.mIsCacPreviewControl = false;
        this.mIsDlpUploadControl = false;
        this.mIsDeleted = false;
        this.mCanRead = true;
        this.mArgs = r4;
        readArgs(r4);
    }

    public static ViewModelProvider.Factory newFactory(Bundle r1) {
        return new a(r1);
    }

    private void readArgs(Bundle r7) {
        if (r7 != null) goto L24;
        tt5.a.d("DriveComponent", "readArgs() error, args=null");
        this.mOpenEntity = new DefaultOpenEntity();
        return;
    L24:
        BaseOpenEntity r3 = (BaseOpenEntity) r7.getParcelable("extra_drive_sdk_open_entity");     // Catch: Exception -> L21
        this.mOpenEntity = r3;     // Catch: Exception -> L21
        if (r3 != null) goto L10;
    L19:
        this.mOpenEntity = new DefaultOpenEntity();     // Catch: Exception -> L21
        return;
    L10:
        if (r3.getBizType() <= 0) goto L19;
        this.mBizType = this.mOpenEntity.getBizType();     // Catch: Exception -> L21
        MutableLiveData<String> r4 = this.mFileName;     // Catch: Exception -> L21
        String r5 = this.mOpenEntity.getFileName();     // Catch: Exception -> L21
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r4.setValue(r5);     // Catch: Exception -> L21
        this.mIsVcModel = r7.getBoolean("vc_follow_mode", false);     // Catch: Exception -> L21
        Bundle r6 = this.mOpenEntity.getExtras();     // Catch: Exception -> L21
        if (r6 == null) goto L18;
        this.mIsHistoryModel.setValue(Boolean.valueOf(r6.getBoolean("history", false)));     // Catch: Exception -> L21
    L18:
        this.mWikiInfo = (WikiInfo) r7.getSerializable("wiki_info");     // Catch: Exception -> L21
        this.mPreviewType.setValue(Integer.valueOf(this.mOpenEntity.getPreviewType()));     // Catch: Exception -> L21
        tt5.a.h("DriveComponent", "readArgs() done mBizType=" + this.mBizType + " mIsVcModel=" + this.mIsVcModel + " mIsHistoryModel=" + this.mIsHistoryModel);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        tt5.a.f("DriveSdk", e, false);
    }

    private void updateTitleBarSubtitleOverride(String r3) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        this.mTitleBarSubtitleOverride.setValue(r3);
        return;
    L5:
        this.mTitleBarSubtitleOverride.postValue(r3);
    }

    public void setCanRead(boolean r1) {
        this.mCanRead = r1;
    }

    public <FM extends w75.a> void setFileModel(FM r2) {
        if (r2 != null) goto L5;
        tt5.a.d("DriveSdk", "setFileModel() is null value");
        return;
    L5:
        this.mIFileModel = f85.c.a(r2);
    }

    public void setFileName(String r2) {
        this.mFileName.postValue(r2);
    }

    public void setIsAdminPerceiveControl(boolean r1) {
        this.mIsAdminPerceiveControl = r1;
    }

    public void setIsCacPreviewControl(boolean r1) {
        this.mIsCacPreviewControl = r1;
    }

    public void setIsDeleted(boolean r1) {
        this.mIsDeleted = r1;
    }

    public void setIsDlpUploadControl(boolean r1) {
        this.mIsDlpUploadControl = r1;
    }

    public void setRiskFlag(boolean r2) {
        this.mRiskFlag.postValue(Boolean.valueOf(r2));
    }

    public void setTitleBarSubtitleOverride(String r1) {
        updateTitleBarSubtitleOverride(r1);
    }

    public void updatePreviewType(int r3) {
        tt5.a.h("DriveSdk", "updatePreviewType() value=" + r3);
        if (((Integer) this.mPreviewType.getValue()).intValue() == r3) goto L6;
        this.mPreviewType.postValue(Integer.valueOf(r3));
        return;
    }
}
