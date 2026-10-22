package com.bytedance.ee.bear.sheet.exportimage.alert;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.document.share.ShareItem;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020&J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "imageAlertData", "Lcom/bytedance/ee/bear/sheet/exportimage/alert/ImageAlertModel;", "getImageAlertData", "imageBitmap", "Ljava/io/File;", "getImageBitmap", "watermarkedImageBitmap", "getWatermarkedImageBitmap", "()Ljava/io/File;", "setWatermarkedImageBitmap", "(Ljava/io/File;)V", "shareUrl", "", "getShareUrl", "()Ljava/lang/String;", "setShareUrl", "(Ljava/lang/String;)V", "delegete", "Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertViewModel$Delegete;", "getDelegete", "()Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertViewModel$Delegete;", "setDelegete", "(Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertViewModel$Delegete;)V", "close", "", "onClickSaveBtn", "onClickShareBtn", "onShareToExternalApp", "type", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "onShareSuccess", "doShareToCustom", "shareItem", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", ShareItem.SHARE_IMAGE, "Delegete", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenshotImageAlertViewModel extends ViewModel {
    private final MutableLiveData<Boolean> active;
    private a delegete;
    private final MutableLiveData<ImageAlertModel> imageAlertData;
    private final MutableLiveData<File> imageBitmap;
    private String shareUrl;
    private File watermarkedImageBitmap;

    public interface a {
        void a();

        boolean b(ShareItemModel r100, File r101);

        void c();

        void d(ShareType r100);

        void e(ShareType r100);

        void onClose();
    }

    public final void close() {
        a r100 = this.delegete;
        if (r100 == null) goto L6;
        r100.onClose();
        return;
    }

    public final void onClickSaveBtn() {
        a r100 = this.delegete;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void onClickShareBtn() {
        a r100 = this.delegete;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public ScreenshotImageAlertViewModel() {
        this.active = new MutableLiveData();
        this.imageAlertData = new MutableLiveData();
        this.imageBitmap = new MutableLiveData();
        this.shareUrl = "";
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final a getDelegete() {
        return this.delegete;
    }

    public final MutableLiveData<ImageAlertModel> getImageAlertData() {
        return this.imageAlertData;
    }

    public final MutableLiveData<File> getImageBitmap() {
        return this.imageBitmap;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final File getWatermarkedImageBitmap() {
        return this.watermarkedImageBitmap;
    }

    public final void onShareSuccess(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        a r101 = this.delegete;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public final void onShareToExternalApp(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        a r101 = this.delegete;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    public final void setDelegete(a r100) {
        this.delegete = r100;
    }

    public final void setShareUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shareUrl = r100;
    }

    public final void setWatermarkedImageBitmap(File r100) {
        this.watermarkedImageBitmap = r100;
    }

    public final boolean doShareToCustom(ShareItemModel r100, File r101) {
        Intrinsics.checkNotNullParameter(r100, "shareItem");
        Intrinsics.checkNotNullParameter(r101, ShareItem.SHARE_IMAGE);
        a r102 = this.delegete;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.b(r100, r101);
    }
}
