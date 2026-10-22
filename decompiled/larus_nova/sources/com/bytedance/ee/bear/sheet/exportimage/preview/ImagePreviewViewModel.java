package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020&2\u0006\u0010+\u001a\u00020,J\u0018\u0010.\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203J \u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u00105\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u000100R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "setActive", "(Landroidx/lifecycle/MutableLiveData;)V", "showShare", "getShowShare", "setShowShare", DyPayConstant.KEY_SHOW_LOADING, "getShowLoading", "setShowLoading", "titleData", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/PreviewTitleModel;", "getTitleData", "setTitleData", "disableShareItem", "getDisableShareItem", "setDisableShareItem", "calSharePanelHeight", "getCalSharePanelHeight", "setCalSharePanelHeight", "operationType", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/ShareOperationTypeModel;", "getOperationType", "setOperationType", "delegate", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel$Delegate;)V", "onClose", "", "onSharePanelHeightChanged", "height", "", "canShareImageToExternalApp", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "onShareImageToExternalApp", "onShareTextToExternalApp", "text", "", "canCustomShareImage", "shareItem", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "doShareToCustom", "isShareText", "Delegate", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePreviewViewModel extends ViewModel {
    private MutableLiveData<Boolean> active;
    private MutableLiveData<Boolean> calSharePanelHeight;
    private a delegate;
    private MutableLiveData<Boolean> disableShareItem;
    private MutableLiveData<ShareOperationTypeModel> operationType;
    private MutableLiveData<Boolean> showLoading;
    private MutableLiveData<Boolean> showShare;
    private MutableLiveData<PreviewTitleModel> titleData;

    public interface a {
        boolean a(ShareItemModel r100);

        boolean b(ShareType r100);

        void c(ShareType r100);

        void d(ShareType r100, String r101);

        void e(int r100);

        boolean f(ShareItemModel r100, boolean r101, String r102);

        void onClose();
    }

    public final void onClose() {
        a r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.onClose();
        return;
    }

    public ImagePreviewViewModel() {
        this.active = new MutableLiveData();
        this.showShare = new MutableLiveData();
        this.showLoading = new MutableLiveData();
        this.titleData = new MutableLiveData();
        this.disableShareItem = new MutableLiveData();
        this.calSharePanelHeight = new MutableLiveData();
        this.operationType = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final MutableLiveData<Boolean> getCalSharePanelHeight() {
        return this.calSharePanelHeight;
    }

    public final a getDelegate() {
        return this.delegate;
    }

    public final MutableLiveData<Boolean> getDisableShareItem() {
        return this.disableShareItem;
    }

    public final MutableLiveData<ShareOperationTypeModel> getOperationType() {
        return this.operationType;
    }

    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final MutableLiveData<Boolean> getShowShare() {
        return this.showShare;
    }

    public final MutableLiveData<PreviewTitleModel> getTitleData() {
        return this.titleData;
    }

    public final boolean canCustomShareImage(ShareItemModel r100) {
        Intrinsics.checkNotNullParameter(r100, "shareItem");
        a r101 = this.delegate;
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.a(r100);
    }

    public final boolean canShareImageToExternalApp(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        a r101 = this.delegate;
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.b(r100);
    }

    public final void onShareImageToExternalApp(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public final void onSharePanelHeightChanged(int r100) {
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    public final void setActive(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.active = r100;
    }

    public final void setCalSharePanelHeight(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.calSharePanelHeight = r100;
    }

    public final void setDelegate(a r100) {
        this.delegate = r100;
    }

    public final void setDisableShareItem(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.disableShareItem = r100;
    }

    public final void setOperationType(MutableLiveData<ShareOperationTypeModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.operationType = r100;
    }

    public final void setShowLoading(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showLoading = r100;
    }

    public final void setShowShare(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showShare = r100;
    }

    public final void setTitleData(MutableLiveData<PreviewTitleModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.titleData = r100;
    }

    public final void onShareTextToExternalApp(ShareType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        a r102 = this.delegate;
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r102.d(r100, r101);
        return;
    }

    public final boolean doShareToCustom(ShareItemModel r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "shareItem");
        a r103 = this.delegate;
        if (r103 == null) goto L7;
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        return r103.f(r100, r101, r102);
    L7:
        return false;
    }
}
