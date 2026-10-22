package com.bytedance.ee.bear.fileselector.api;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileSelectConfig implements Serializable {
    public int actionType;
    public boolean adjustHeightByKeyboard;
    public boolean autoDismiss;
    public bb5.a backToPickerViewListener;
    public boolean camaraUse1080P;
    public boolean canDragView;
    public int ccmPickViewHeight;
    public boolean checkedKeepOrigin;
    public int columnCount;
    public transient ViewGroup container;
    public String customSendBtnTips;
    public bb5.b dialogLifecycle;
    public View dragView;
    public boolean enableImageCompress;
    public bb5.c fileCheckListener;
    public za5.a fileSelectListener;
    public bb5.d getContentViewListener;
    public View headView;
    public int headerViewRes;
    public bb5.e heightChangeListener;
    public int imageCompressType;
    public boolean isConsumeBackPress;
    public boolean isOrigin;
    public boolean isOriginFile;
    public int larkAlbumActionType;
    public long maxFileSize;
    public int maxImageCompressSize;
    public int maxImageSize;
    public int maxSelectImageNum;
    public long maxVideoSize;
    public int mediaType;
    public int minCcmPickViewHeight;
    public boolean mixSelect;
    public bb5.h onDismissListener;
    public bb5.f permissionCheckListener;
    public ArrayList<Photo> selectLocalMedias;
    public int selectType;
    public boolean showFilterMenu;
    public boolean showGif;
    public boolean showOrigin;
    public boolean showPreview;
    public boolean showSingleSelector;
    public boolean showTakePhoto;
    public boolean showTakeVideo;
    public boolean showVideo;
    public boolean showWaterMark;
    public int sourceType;
    public int totalMaxPhotoCount;

    public static /* synthetic */ class a {
    }

    public static class b<T> extends d<T> {
        public b() {
        }
    }

    public static class c<T> {
        public final FileSelectConfig a;

        public FileSelectConfig a() {
            return new FileSelectConfig(this.a, null);
        }

        public c() {
            this.a = new FileSelectConfig(null);
        }
    }

    public static class d<T> extends c<T> {
        public d() {
        }
    }

    public static class e extends b<e> {
        public e() {
            this.a.selectType = 2;
        }
    }

    public static class f extends c<f> {
        public f() {
            this.a.selectType = 4;
        }
    }

    public static class g extends b<g> {
        @Override // com.bytedance.ee.bear.fileselector.api.FileSelectConfig.c
        public final FileSelectConfig a() {
            return new FileSelectConfig(this.a, null);
        }

        public g() {
            this.a.selectType = 3;
        }
    }

    public static class h extends d<h> {
        public h() {
            this.a.selectType = 1;
        }
    }

    public static e ccmAlbumBuilder() {
        return new e();
    }

    public static f filePickerBuilder() {
        return new f();
    }

    public static g fullScreenAlbumBuilder() {
        return new g();
    }

    public static h larkCamaraBuilder() {
        return new h();
    }

    private FileSelectConfig() {
        this.showVideo = true;
        this.mixSelect = false;
        this.maxSelectImageNum = 9;
        this.totalMaxPhotoCount = -1;
        this.showSingleSelector = true;
        this.columnCount = 4;
        this.showGif = false;
        this.showOrigin = true;
        this.actionType = 0;
        this.selectLocalMedias = new ArrayList();
        this.canDragView = false;
        this.isConsumeBackPress = false;
        this.selectType = 0;
        this.imageCompressType = 4;
        this.maxImageCompressSize = 2048;
        this.adjustHeightByKeyboard = false;
        this.enableImageCompress = true;
        this.headerViewRes = -1;
        this.headView = null;
        this.showWaterMark = false;
        this.autoDismiss = true;
        this.showPreview = true;
        this.showTakePhoto = true;
        this.showTakeVideo = false;
        this.camaraUse1080P = false;
        this.showFilterMenu = true;
        this.customSendBtnTips = "";
        this.isOriginFile = false;
        this.checkedKeepOrigin = false;
    }

    public FileSelectConfig(FileSelectConfig r6) {
        this.showVideo = true;
        this.mixSelect = false;
        this.maxSelectImageNum = 9;
        this.totalMaxPhotoCount = -1;
        this.showSingleSelector = true;
        this.columnCount = 4;
        this.showGif = false;
        this.showOrigin = true;
        this.actionType = 0;
        this.selectLocalMedias = new ArrayList();
        this.canDragView = false;
        this.isConsumeBackPress = false;
        this.selectType = 0;
        this.imageCompressType = 4;
        this.maxImageCompressSize = 2048;
        this.adjustHeightByKeyboard = false;
        this.enableImageCompress = true;
        this.headerViewRes = -1;
        this.headView = null;
        this.showWaterMark = false;
        this.autoDismiss = true;
        this.showPreview = true;
        this.showTakePhoto = true;
        this.showTakeVideo = false;
        this.camaraUse1080P = false;
        this.showFilterMenu = true;
        this.customSendBtnTips = "";
        this.isOriginFile = false;
        this.checkedKeepOrigin = false;
        this.showVideo = r6.showVideo;
        this.mixSelect = r6.mixSelect;
        this.maxSelectImageNum = r6.maxSelectImageNum;
        this.totalMaxPhotoCount = r6.totalMaxPhotoCount;
        this.showSingleSelector = r6.showSingleSelector;
        this.columnCount = r6.columnCount;
        this.showGif = r6.showGif;
        ArrayList<Photo> r0 = r6.selectLocalMedias;
        if (r0 == null) goto L5;
        this.selectLocalMedias = r0;
    L5:
        this.showOrigin = r6.showOrigin;
        this.isOrigin = r6.isOrigin;
        this.actionType = r6.actionType;
        this.selectType = r6.selectType;
        this.fileSelectListener = r6.fileSelectListener;
        this.fileCheckListener = r6.fileCheckListener;
        this.heightChangeListener = r6.heightChangeListener;
        this.permissionCheckListener = r6.permissionCheckListener;
        this.backToPickerViewListener = r6.backToPickerViewListener;
        this.ccmPickViewHeight = r6.ccmPickViewHeight;
        this.minCcmPickViewHeight = r6.minCcmPickViewHeight;
        this.maxVideoSize = r6.maxVideoSize;
        this.maxImageSize = r6.maxImageSize;
        this.maxFileSize = r6.maxFileSize;
        this.imageCompressType = r6.imageCompressType;
        this.maxImageCompressSize = r6.maxImageCompressSize;
        this.adjustHeightByKeyboard = r6.adjustHeightByKeyboard;
        this.sourceType = r6.sourceType;
        this.mediaType = r6.mediaType;
        this.larkAlbumActionType = r6.larkAlbumActionType;
        this.showTakePhoto = r6.showTakePhoto;
        this.showTakeVideo = r6.showTakeVideo;
        this.camaraUse1080P = r6.camaraUse1080P;
        this.canDragView = r6.canDragView;
        this.dragView = r6.dragView;
        this.showWaterMark = r6.showWaterMark;
        this.headerViewRes = r6.headerViewRes;
        this.onDismissListener = r6.onDismissListener;
        this.isConsumeBackPress = r6.isConsumeBackPress;
        this.showFilterMenu = r6.showFilterMenu;
        this.customSendBtnTips = r6.customSendBtnTips;
        this.dialogLifecycle = r6.dialogLifecycle;
        this.autoDismiss = r6.autoDismiss;
        this.enableImageCompress = r6.enableImageCompress;
        this.showPreview = r6.showPreview;
        this.isOriginFile = r6.isOriginFile;
        this.checkedKeepOrigin = r6.checkedKeepOrigin;
        this.container = r6.container;
    }

    public static FileSelectConfig buildFileSelectConfig(FileSelectConfig r1) {
        if (r1 == null) goto L6;
        return new FileSelectConfig(r1);
    L6:
        return new FileSelectConfig();
    }

    public /* synthetic */ FileSelectConfig(a r1) {
        this();
    }

    public /* synthetic */ FileSelectConfig(FileSelectConfig r1, a r2) {
        this(r1);
    }
}
