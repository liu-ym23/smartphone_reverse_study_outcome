package com.ss.android.lark.widget.halfscreen;

import android.view.View;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class PhotoPreviewPickerParam implements Serializable {
    private final int currentPosition;
    private final boolean isKeepOrigin;
    private int mediaType;
    private final int photoCount;
    private final List<Photo> photos;
    private final List<Photo> selectedPhotoPaths;
    private boolean sendMode;
    private final boolean showDeleteButton;
    private boolean showOriginCheckBox;
    private final View sourceView;
    private final boolean useTransitionAnim;

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public int getPhotoCount() {
        return this.photoCount;
    }

    public List<Photo> getPhotos() {
        return this.photos;
    }

    public List<Photo> getSelectedPhotoPaths() {
        return this.selectedPhotoPaths;
    }

    public View getSourceView() {
        return this.sourceView;
    }

    public boolean isKeepOrigin() {
        return this.isKeepOrigin;
    }

    public boolean isSendMode() {
        return this.sendMode;
    }

    public boolean isShowDeleteButton() {
        return this.showDeleteButton;
    }

    public boolean isShowOriginCheckBox() {
        return this.showOriginCheckBox;
    }

    public boolean isUseTransitionAnim() {
        return this.useTransitionAnim;
    }

    public static /* synthetic */ int access$002(PhotoPreviewPickerParam r100, int r101) {
        r100.mediaType = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(PhotoPreviewPickerParam r100, boolean r101) {
        r100.showOriginCheckBox = r101;
        return r101;
    }

    public PhotoPreviewPickerParam(List<Photo> r100, int r101, boolean r102, View r103, boolean r104, int r105, boolean r106, List<Photo> r107, boolean r110) {
        this.mediaType = 3;
        this.showOriginCheckBox = true;
        this.photos = r100;
        this.currentPosition = r101;
        this.showDeleteButton = r102;
        this.sourceView = r103;
        this.isKeepOrigin = r104;
        this.photoCount = r105;
        this.useTransitionAnim = r106;
        this.selectedPhotoPaths = r107;
        this.sendMode = r110;
    }
}
