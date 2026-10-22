package com.bytedance.ee.bear.fileselector.api;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileSelectConfig f226780a;

        public FileSelectConfig a() {
            return new FileSelectConfig(this.f226780a, null);
        }

        public c() {
            this.f226780a = new FileSelectConfig(null);
        }
    }

    public static class d<T> extends c<T> {
        public d() {
        }
    }

    public static class e extends b<e> {
        public e() {
            this.f226780a.selectType = 2;
        }
    }

    public static class f extends c<f> {
        public f() {
            this.f226780a.selectType = 4;
        }
    }

    public static class g extends b<g> {
        @Override // com.bytedance.ee.bear.fileselector.api.FileSelectConfig.c
        public final FileSelectConfig a() {
            return new FileSelectConfig(this.f226780a, null);
        }

        public g() {
            this.f226780a.selectType = 3;
        }
    }

    public static class h extends d<h> {
        public h() {
            this.f226780a.selectType = 1;
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

    public FileSelectConfig(FileSelectConfig r100) {
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
        this.showVideo = r100.showVideo;
        this.mixSelect = r100.mixSelect;
        this.maxSelectImageNum = r100.maxSelectImageNum;
        this.totalMaxPhotoCount = r100.totalMaxPhotoCount;
        this.showSingleSelector = r100.showSingleSelector;
        this.columnCount = r100.columnCount;
        this.showGif = r100.showGif;
        ArrayList<Photo> r101 = r100.selectLocalMedias;
        if (r101 == null) goto L5;
        this.selectLocalMedias = r101;
    L5:
        this.showOrigin = r100.showOrigin;
        this.isOrigin = r100.isOrigin;
        this.actionType = r100.actionType;
        this.selectType = r100.selectType;
        this.fileSelectListener = r100.fileSelectListener;
        this.fileCheckListener = r100.fileCheckListener;
        this.heightChangeListener = r100.heightChangeListener;
        this.permissionCheckListener = r100.permissionCheckListener;
        this.backToPickerViewListener = r100.backToPickerViewListener;
        this.ccmPickViewHeight = r100.ccmPickViewHeight;
        this.minCcmPickViewHeight = r100.minCcmPickViewHeight;
        this.maxVideoSize = r100.maxVideoSize;
        this.maxImageSize = r100.maxImageSize;
        this.maxFileSize = r100.maxFileSize;
        this.imageCompressType = r100.imageCompressType;
        this.maxImageCompressSize = r100.maxImageCompressSize;
        this.adjustHeightByKeyboard = r100.adjustHeightByKeyboard;
        this.sourceType = r100.sourceType;
        this.mediaType = r100.mediaType;
        this.larkAlbumActionType = r100.larkAlbumActionType;
        this.showTakePhoto = r100.showTakePhoto;
        this.showTakeVideo = r100.showTakeVideo;
        this.camaraUse1080P = r100.camaraUse1080P;
        this.canDragView = r100.canDragView;
        this.dragView = r100.dragView;
        this.showWaterMark = r100.showWaterMark;
        this.headerViewRes = r100.headerViewRes;
        this.onDismissListener = r100.onDismissListener;
        this.isConsumeBackPress = r100.isConsumeBackPress;
        this.showFilterMenu = r100.showFilterMenu;
        this.customSendBtnTips = r100.customSendBtnTips;
        this.dialogLifecycle = r100.dialogLifecycle;
        this.autoDismiss = r100.autoDismiss;
        this.enableImageCompress = r100.enableImageCompress;
        this.showPreview = r100.showPreview;
        this.isOriginFile = r100.isOriginFile;
        this.checkedKeepOrigin = r100.checkedKeepOrigin;
        this.container = r100.container;
    }

    public static FileSelectConfig buildFileSelectConfig(FileSelectConfig r100) {
        if (r100 == null) goto L6;
        return new FileSelectConfig(r100);
    L6:
        return new FileSelectConfig();
    }

    public /* synthetic */ FileSelectConfig(a r100) {
        this();
    }

    public /* synthetic */ FileSelectConfig(FileSelectConfig r100, a r101) {
        this(r100);
    }
}
