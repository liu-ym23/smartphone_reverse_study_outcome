package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020&2\u0006\u0010+\u001a\u00020,J\u0018\u0010.\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203J \u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u00105\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u000100R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "setActive", "(Landroidx/lifecycle/MutableLiveData;)V", "showShare", "getShowShare", "setShowShare", "showLoading", "getShowLoading", "setShowLoading", "titleData", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/PreviewTitleModel;", "getTitleData", "setTitleData", "disableShareItem", "getDisableShareItem", "setDisableShareItem", "calSharePanelHeight", "getCalSharePanelHeight", "setCalSharePanelHeight", "operationType", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/ShareOperationTypeModel;", "getOperationType", "setOperationType", "delegate", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel$Delegate;)V", "onClose", "", "onSharePanelHeightChanged", "height", "", "canShareImageToExternalApp", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "onShareImageToExternalApp", "onShareTextToExternalApp", "text", "", "canCustomShareImage", "shareItem", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "doShareToCustom", "isShareText", "Delegate", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        boolean a(ShareItemModel r1);

        boolean b(ShareType r1);

        void c(ShareType r1);

        void d(ShareType r1, String r2);

        void e(int r1);

        boolean f(ShareItemModel r1, boolean r2, String r3);

        void onClose();
    }

    public final void onClose() {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.onClose();
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

    public final boolean canCustomShareImage(ShareItemModel r2) {
        Intrinsics.checkNotNullParameter(r2, "shareItem");
        a r0 = this.delegate;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.a(r2);
    }

    public final boolean canShareImageToExternalApp(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        a r0 = this.delegate;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.b(r2);
    }

    public final void onShareImageToExternalApp(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final void onSharePanelHeightChanged(int r2) {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    public final void setActive(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.active = r2;
    }

    public final void setCalSharePanelHeight(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.calSharePanelHeight = r2;
    }

    public final void setDelegate(a r1) {
        this.delegate = r1;
    }

    public final void setDisableShareItem(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.disableShareItem = r2;
    }

    public final void setOperationType(MutableLiveData<ShareOperationTypeModel> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.operationType = r2;
    }

    public final void setShowLoading(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showLoading = r2;
    }

    public final void setShowShare(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showShare = r2;
    }

    public final void setTitleData(MutableLiveData<PreviewTitleModel> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.titleData = r2;
    }

    public final void onShareTextToExternalApp(ShareType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        a r0 = this.delegate;
        if (r0 == null) goto L8;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r0.d(r2, r3);
        return;
    }

    public final boolean doShareToCustom(ShareItemModel r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "shareItem");
        a r0 = this.delegate;
        if (r0 == null) goto L7;
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        return r0.f(r2, r3, r4);
    L7:
        return false;
    }
}
