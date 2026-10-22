package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PreviewViewModel extends ViewModel {
    private static final String TAG = "PreviewViewModel";
    private int bizType;
    public final MutableLiveData<Integer> currentPageLiveData;
    private boolean isBlockViewChanging;
    private boolean isVCFollowMode;
    private final MutableLiveData<String> liveCreatorTenantId;
    private final MutableLiveData<Boolean> liveInnerAreaCommentActive;
    private final MutableLiveData<Boolean> liveInnerAreaCommentEnableState;
    private final MutableLiveData<a> liveInnerChangeTipsState;
    private final MutableLiveData<Void> liveInnerClosePage;
    private final MutableLiveData<CommentRectF> liveInnerCommentSelected;
    private final MutableLiveData<Boolean> liveInnerCreateNewComment;
    private final MutableLiveData<Integer> liveInnerDowngrade;
    private final MutableLiveData<IDownloader.ICallback> liveInnerDownloadCompleteFile;
    private final MutableLiveData<Integer> liveInnerEditModeSwitchAction;
    private final MutableLiveData<Boolean> liveInnerEditModeSwitchActive;
    private final MutableLiveData<Boolean> liveInnerExtraViewVisible;
    private final MutableLiveData<String> liveInnerFileNameChanged;
    private final MutableLiveData<Boolean> liveInnerForceFullScreen;
    public final MutableLiveData<Boolean> liveInnerForcePortrait;
    private final MutableLiveData<Boolean> liveInnerInterceptMaskClick;
    private final MutableLiveData<Boolean> liveInnerIsPresentationMode;
    private final MutableLiveData<Boolean> liveInnerIsWPSPresentationMode;
    private final MutableLiveData<Boolean> liveInnerKeepScreenOn;
    private final MutableLiveData<Integer> liveInnerMemoryOverLimit;
    private final MutableLiveData<Boolean> liveInnerOnPreviewContentReady;
    private final MutableLiveData<Void> liveInnerOpenExternal;
    public final MutableLiveData<Boolean> liveInnerPasswordEncrypted;
    private final MutableLiveData<String> liveInnerPasswordProtected;
    private final MutableLiveData<Integer> liveInnerPreviewShowStatus;
    private final MutableLiveData<Void> liveInnerReload;
    private final t85.g<a0> liveInnerReportMsg;
    private final MutableLiveData<String> liveInnerRoute;
    private final MutableLiveData<Integer> liveInnerSearchResultCount;
    private final MutableLiveData<Boolean> liveInnerSetSwipeEnable;
    private final MutableLiveData<Boolean> liveInnerShowPresentationAction;
    private final MutableLiveData<Void> liveInnerShowPreviewFailedPage;
    private final MutableLiveData<Void> liveInnerShowRetryPage;
    private final MutableLiveData<Boolean> liveInnerShowSearchBar;
    private final MutableLiveData<Boolean> liveInnerShowWPSPresentationAction;
    private final MutableLiveData<String> liveInnerSimilarFileOpen;
    private final MutableLiveData<Void> liveInnerSingleTap;
    private final MutableLiveData<Object> liveInnerStreamingDone;
    private final MutableLiveData<Boolean> liveInnerThumbVisibleState;
    private final MutableLiveData<String> liveInnerToggleFullScreen;
    private final MutableLiveData<String> liveInnerUnsupprtPreview;
    private final MutableLiveData<Boolean> liveInnerVideoFullScreen;
    private final MutableLiveData<Boolean> liveInnerWPSEditModeAvailable;
    private final MutableLiveData<Integer> liveInnerWPSViewPaddingChanged;
    private final MutableLiveData<y<Boolean>> liveOuterCommentCardVisible;
    private final MutableLiveData<Boolean> liveOuterCommentable;
    private final MutableLiveData<Boolean> liveOuterDisableShowComment;
    private final MutableLiveData<Integer> liveOuterDlpCode;
    private final MutableLiveData<Boolean> liveOuterEditableFromSecret;
    private final MutableLiveData<Void> liveOuterEnterPresentationMode;
    private final MutableLiveData<Boolean> liveOuterExportVisible;
    private final MutableLiveData<Boolean> liveOuterNetState;
    private final MutableLiveData<y<Integer>> liveOuterNotPreviewContentHeight;
    private final MutableLiveData<Object> liveOuterSearchStatus;
    private final MutableLiveData<Boolean> liveOuterSupportAreaComment;
    private final MutableLiveData<EncryptData> livenEncryptData;

    public static class a {
        public String a;
        public int b;
        public boolean c;
        public int d;
        public String e;
        public View.OnClickListener f;

        public a() {
        }

        public int getType() {
            return this.b;
        }
    }

    public PreviewViewModel() {
        this.bizType = 2;
        this.liveInnerToggleFullScreen = new MutableLiveData();
        this.liveInnerRoute = new MutableLiveData();
        this.liveInnerSetSwipeEnable = new MutableLiveData();
        this.liveInnerAreaCommentEnableState = new MutableLiveData();
        Boolean r1 = Boolean.FALSE;
        this.liveInnerAreaCommentActive = new MutableLiveData(r1);
        this.liveInnerShowRetryPage = new MutableLiveData();
        this.liveInnerClosePage = new MutableLiveData();
        this.liveInnerShowPreviewFailedPage = new MutableLiveData();
        this.liveInnerKeepScreenOn = new MutableLiveData();
        this.liveInnerShowSearchBar = new MutableLiveData();
        this.liveInnerForceFullScreen = new MutableLiveData();
        this.liveInnerCommentSelected = new MutableLiveData();
        this.liveInnerOnPreviewContentReady = new MutableLiveData();
        this.liveInnerThumbVisibleState = new MutableLiveData();
        this.liveInnerCreateNewComment = new MutableLiveData();
        this.liveInnerExtraViewVisible = new MutableLiveData();
        this.liveInnerSearchResultCount = new MutableLiveData();
        this.liveInnerSingleTap = new MutableLiveData();
        this.liveInnerInterceptMaskClick = new MutableLiveData();
        this.liveInnerVideoFullScreen = new MutableLiveData();
        this.liveInnerReload = new MutableLiveData();
        this.liveInnerPasswordProtected = new MutableLiveData();
        this.liveInnerReportMsg = new t85.g();
        this.liveInnerPreviewShowStatus = new MutableLiveData();
        this.liveInnerStreamingDone = new MutableLiveData();
        this.liveInnerOpenExternal = new MutableLiveData();
        this.liveInnerSimilarFileOpen = new MutableLiveData();
        this.liveInnerWPSEditModeAvailable = new MutableLiveData(r1);
        this.liveInnerEditModeSwitchActive = new MutableLiveData();
        this.liveInnerEditModeSwitchAction = new MutableLiveData();
        this.liveInnerWPSViewPaddingChanged = new MutableLiveData();
        this.liveInnerMemoryOverLimit = new MutableLiveData();
        this.liveInnerFileNameChanged = new MutableLiveData();
        this.liveInnerDownloadCompleteFile = new MutableLiveData();
        this.liveInnerDowngrade = new MutableLiveData();
        this.liveInnerShowPresentationAction = new MutableLiveData();
        this.liveInnerShowWPSPresentationAction = new MutableLiveData();
        this.liveInnerIsPresentationMode = new MutableLiveData();
        this.liveInnerIsWPSPresentationMode = new MutableLiveData();
        this.liveInnerUnsupprtPreview = new MutableLiveData();
        this.liveInnerChangeTipsState = new MutableLiveData();
        this.liveOuterDisableShowComment = new MutableLiveData();
        this.liveOuterExportVisible = new MutableLiveData();
        this.liveOuterSearchStatus = new MutableLiveData();
        this.liveOuterCommentable = new MutableLiveData();
        this.liveOuterEditableFromSecret = new MutableLiveData();
        this.liveOuterDlpCode = new MutableLiveData();
        this.liveOuterCommentCardVisible = new MutableLiveData();
        this.liveOuterNotPreviewContentHeight = new MutableLiveData();
        this.liveOuterNetState = new MutableLiveData();
        this.liveOuterSupportAreaComment = new MutableLiveData();
        this.liveOuterEnterPresentationMode = new MutableLiveData();
        this.livenEncryptData = new MutableLiveData();
        this.currentPageLiveData = new MutableLiveData();
        this.liveInnerForcePortrait = new MutableLiveData();
        this.liveInnerPasswordEncrypted = new MutableLiveData();
        this.liveCreatorTenantId = new MutableLiveData();
        this.isVCFollowMode = false;
        this.isBlockViewChanging = false;
    }

    public int getBizType() {
        return this.bizType;
    }

    public LiveData<String> getLiveCreatorTenantId() {
        return this.liveCreatorTenantId;
    }

    public MutableLiveData<a> getLiveInnerChangeTipsState() {
        return this.liveInnerChangeTipsState;
    }

    public MutableLiveData<Integer> getLiveInnerDowngrade() {
        return this.liveInnerDowngrade;
    }

    public MutableLiveData<Void> getLiveInnerShowPreviewFailedPage() {
        return this.liveInnerShowPreviewFailedPage;
    }

    public MutableLiveData<Integer> getLiveOuterDlpCode() {
        return this.liveOuterDlpCode;
    }

    public boolean isBlockViewChanging() {
        return this.isBlockViewChanging;
    }

    public boolean isVCFollowMode() {
        return this.isVCFollowMode;
    }

    public MutableLiveData<Boolean> liveInnerAreaCommentActive() {
        return this.liveInnerAreaCommentActive;
    }

    public MutableLiveData<Boolean> liveInnerAreaCommentEnableState() {
        return this.liveInnerAreaCommentEnableState;
    }

    public MutableLiveData<Void> liveInnerClosePage() {
        return this.liveInnerClosePage;
    }

    public MutableLiveData<CommentRectF> liveInnerCommentSelected() {
        return this.liveInnerCommentSelected;
    }

    public MutableLiveData<Boolean> liveInnerCreateNewComment() {
        return this.liveInnerCreateNewComment;
    }

    public MutableLiveData<IDownloader.ICallback> liveInnerDownloadCompleteFile() {
        return this.liveInnerDownloadCompleteFile;
    }

    public MutableLiveData<Integer> liveInnerEditModeSwitchAction() {
        return this.liveInnerEditModeSwitchAction;
    }

    public MutableLiveData<Boolean> liveInnerEditModeSwitchActive() {
        return this.liveInnerEditModeSwitchActive;
    }

    public MutableLiveData<Boolean> liveInnerExtraViewVisible() {
        return this.liveInnerExtraViewVisible;
    }

    public MutableLiveData<String> liveInnerFileNameChanged() {
        return this.liveInnerFileNameChanged;
    }

    public MutableLiveData<Boolean> liveInnerForceFullScreen() {
        return this.liveInnerForceFullScreen;
    }

    public MutableLiveData<Boolean> liveInnerInterceptMaskClick() {
        return this.liveInnerInterceptMaskClick;
    }

    public MutableLiveData<Boolean> liveInnerIsPresentationMode() {
        return this.liveInnerIsPresentationMode;
    }

    public MutableLiveData<Boolean> liveInnerIsWPSPresentationMode() {
        return this.liveInnerIsWPSPresentationMode;
    }

    public MutableLiveData<Boolean> liveInnerKeepScreenOn() {
        return this.liveInnerKeepScreenOn;
    }

    public MutableLiveData<Integer> liveInnerMemoryOverLimit() {
        return this.liveInnerMemoryOverLimit;
    }

    public MutableLiveData<Boolean> liveInnerOnPreviewContentReady() {
        return this.liveInnerOnPreviewContentReady;
    }

    public MutableLiveData<Void> liveInnerOpenExternal() {
        return this.liveInnerOpenExternal;
    }

    public MutableLiveData<String> liveInnerPasswordProtected() {
        return this.liveInnerPasswordProtected;
    }

    public MutableLiveData<Integer> liveInnerPreviewShowStatus() {
        return this.liveInnerPreviewShowStatus;
    }

    public MutableLiveData<Void> liveInnerReload() {
        return this.liveInnerReload;
    }

    public t85.g<a0> liveInnerReportMsg() {
        return this.liveInnerReportMsg;
    }

    public MutableLiveData<String> liveInnerRoute() {
        return this.liveInnerRoute;
    }

    public MutableLiveData<Object> liveInnerSaveCache() {
        return this.liveInnerStreamingDone;
    }

    public MutableLiveData<Integer> liveInnerSearchCount() {
        return this.liveInnerSearchResultCount;
    }

    public MutableLiveData<Boolean> liveInnerSetSwipeEnable() {
        return this.liveInnerSetSwipeEnable;
    }

    public MutableLiveData<Boolean> liveInnerShowPresentationAction() {
        return this.liveInnerShowPresentationAction;
    }

    public MutableLiveData<Void> liveInnerShowRetryPage() {
        return this.liveInnerShowRetryPage;
    }

    public MutableLiveData<Boolean> liveInnerShowSearchBar() {
        return this.liveInnerShowSearchBar;
    }

    public MutableLiveData<Boolean> liveInnerShowWPSPresentationAction() {
        return this.liveInnerShowWPSPresentationAction;
    }

    public MutableLiveData<String> liveInnerSimilarFileOpen() {
        return this.liveInnerSimilarFileOpen;
    }

    public MutableLiveData<Void> liveInnerSingleTap() {
        return this.liveInnerSingleTap;
    }

    public MutableLiveData<Boolean> liveInnerThumbVisibleState() {
        return this.liveInnerThumbVisibleState;
    }

    public MutableLiveData<String> liveInnerToggleFullScreen() {
        return this.liveInnerToggleFullScreen;
    }

    public MutableLiveData<String> liveInnerUnsupprtPreview() {
        return this.liveInnerUnsupprtPreview;
    }

    public MutableLiveData<Boolean> liveInnerVideoFullScreen() {
        return this.liveInnerVideoFullScreen;
    }

    public MutableLiveData<Boolean> liveInnerWPSEditModeAvailable() {
        return this.liveInnerWPSEditModeAvailable;
    }

    public MutableLiveData<Integer> liveInnerWPSViewPaddingChanged() {
        return this.liveInnerWPSViewPaddingChanged;
    }

    public MutableLiveData<y<Boolean>> liveOuterCommentCardVisible() {
        return this.liveOuterCommentCardVisible;
    }

    public MutableLiveData<Boolean> liveOuterCommentable() {
        return this.liveOuterCommentable;
    }

    public MutableLiveData<Boolean> liveOuterDisableShowComment() {
        return this.liveOuterDisableShowComment;
    }

    public MutableLiveData<Boolean> liveOuterEditableFromSecret() {
        return this.liveOuterEditableFromSecret;
    }

    public MutableLiveData<EncryptData> liveOuterEncryptId() {
        return this.livenEncryptData;
    }

    public MutableLiveData<Void> liveOuterEnterPresentationMode() {
        return this.liveOuterEnterPresentationMode;
    }

    public MutableLiveData<Boolean> liveOuterExportVisible() {
        return this.liveOuterExportVisible;
    }

    public MutableLiveData<Boolean> liveOuterNetState() {
        return this.liveOuterNetState;
    }

    public MutableLiveData<y<Integer>> liveOuterNotPreviewContentHeight() {
        return this.liveOuterNotPreviewContentHeight;
    }

    public MutableLiveData<Object> liveOuterSearchStatus() {
        return this.liveOuterSearchStatus;
    }

    public MutableLiveData<Boolean> liveOuterSupportAreaComment() {
        return this.liveOuterSupportAreaComment;
    }

    public void postLiveCreatorTenantId(String r2) {
        this.liveCreatorTenantId.postValue(r2);
    }

    public void setBizType(int r1) {
        this.bizType = r1;
    }

    public void setBlockViewChanging(boolean r1) {
        this.isBlockViewChanging = r1;
    }

    public void setVCFollowMode(boolean r1) {
        this.isVCFollowMode = r1;
    }
}
