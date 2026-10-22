package com.ss.android.lark.widget.halfscreen;

import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class PhotoPickerParam implements Serializable {
    private final String actionTxt;
    private final int columnCount;
    private final boolean ensureSelection;
    private final boolean fullScreen;
    private final List<Photo> imagesUri;
    private final boolean isFaceFront;
    private final boolean isImageVideoExclusive;
    private final boolean isKeepOrigin;
    private final boolean isSend;
    private final boolean isShown;
    private final int onlyCameraType;
    private final int photoCount;
    private final boolean previewEnabled;
    private final boolean receiveCancelEvent;
    private final boolean showCamera;
    private final boolean showGif;
    private final boolean showVideo;
    private boolean singleShowSelector;
    private final boolean singleVideo;
    private final boolean standAloneWindow;
    private boolean toastTotalMaxCount;
    private boolean totalHasVideo;
    private final int totalMaxCount;
    private final boolean useLarkCamera;

    public static /* synthetic */ class a {
    }

    public PhotoPickerParam() {
        throw null;
    }

    public String getActionTxt() {
        return this.actionTxt;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public List<Photo> getImagesUri() {
        return this.imagesUri;
    }

    public int getOnlyCameraType() {
        return this.onlyCameraType;
    }

    public int getPhotoCount() {
        return this.photoCount;
    }

    public int getTotalCount() {
        return this.totalMaxCount;
    }

    public boolean isEnsureSelection() {
        return this.ensureSelection;
    }

    public boolean isFaceFront() {
        return this.isFaceFront;
    }

    public boolean isFullScreen() {
        return this.fullScreen;
    }

    public boolean isImageVideoExclusive() {
        return this.isImageVideoExclusive;
    }

    public boolean isKeepOrigin() {
        return this.isKeepOrigin;
    }

    public boolean isPreviewEnabled() {
        return this.previewEnabled;
    }

    public boolean isReceiveCancelEvent() {
        return this.receiveCancelEvent;
    }

    public boolean isSend() {
        return this.isSend;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    public boolean isShowGif() {
        return this.showGif;
    }

    public boolean isShowVideo() {
        return this.showVideo;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public boolean isSingleShowSelector() {
        return this.singleShowSelector;
    }

    public boolean isSingleVideo() {
        return this.singleVideo;
    }

    public boolean isStandAloneWindow() {
        return this.standAloneWindow;
    }

    public boolean isToastTotalMaxCount() {
        return this.toastTotalMaxCount;
    }

    public boolean isTotalHasVideo() {
        return this.totalHasVideo;
    }

    public boolean isUseLarkCamera() {
        return this.useLarkCamera;
    }

    public PhotoPickerParam(boolean r100, boolean r101, boolean r102, int r103, int r104, boolean r105, int r106, boolean r110, boolean r111, boolean r112, List r113, boolean r114, boolean r115, int r116, String r117, boolean r118, boolean r119, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, a r217) {
        this.isFaceFront = r100;
        this.useLarkCamera = r101;
        this.ensureSelection = r102;
        this.photoCount = r103;
        this.totalMaxCount = r104;
        this.singleVideo = r105;
        this.columnCount = r106;
        this.showGif = r110;
        this.showVideo = r111;
        this.showCamera = r112;
        this.imagesUri = r113;
        this.isKeepOrigin = r114;
        this.previewEnabled = r115;
        this.onlyCameraType = r116;
        this.actionTxt = r117;
        this.fullScreen = r118;
        this.isShown = r119;
        this.isSend = r210;
        this.receiveCancelEvent = r211;
        this.standAloneWindow = r212;
        this.totalHasVideo = r213;
        this.singleShowSelector = r214;
        this.toastTotalMaxCount = r215;
        this.isImageVideoExclusive = r216;
    }
}
