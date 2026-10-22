package com.bytedance.ee.bear.document.imageviewer;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.document.comment.bean.Per;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.document.comment.d;
import com.bytedance.ee.bear.document.imageviewer.bean.CardCommentData;
import com.bytedance.ee.bear.document.imageviewer.bean.DeleteImageData;
import com.bytedance.ee.bear.document.imageviewer.bean.ImageCardsData;
import com.bytedance.ee.bear.document.imageviewer.bean.ImageDataModel;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.h;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import sw4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImageViewerViewModel extends ViewModel {
    private static final int DEFAULT_INDEX = -1;
    private static final String TAG = "ImageViewerViewModel";
    public static final String TYPE_ADD_AREA_COMMENT = "addAreaComment";
    private static final String TYPE_COMMENT = "comment";
    private static final String TYPE_DOWNLOADIMAGE = "downloadImage";
    private static final String TYPE_EDIT = "edit";
    private static final String TYPE_EXIT = "exit";
    private static final String TYPE_LOADERROR = "loadError";
    private static final String TYPE_OPEN_SUCCESS = "openSuccess";
    private static final String TYPE_SWIPE = "swipe";
    private static AtomicInteger sCounter;
    private int currIndex;
    private MutableLiveData<Boolean> mCloseImageViewer;
    private a mDelegate;
    private MutableLiveData<DeleteImageData> mDeleteImageData;
    private MutableLiveData<ImageCardsData> mImageCardsJsData;
    private MutableLiveData<ImageDataModel> mImageData;
    private IImageViewer.ImageCommentMode mode;

    public interface a {
    }

    static {
        sCounter = new AtomicInteger(10000);
    }

    public void closeCommentCards() {
        tt5.a.h(TAG, "closeCommentCards");
        a r0 = this.mDelegate;
        if (r0 == null) goto L21;
        ImageViewerPlugin.a r1 = (ImageViewerPlugin.a) r0;
        CommentPlugin r2 = (CommentPlugin) ImageViewerPlugin.access$1000(r1.a, CommentPlugin.class);
        if (r2 != null) goto L8;
        return;
    L8:
        if (ImageViewerPlugin.access$1100(r1.a) == false) goto L18;
        h r3 = ((d) r2.getCommentStateDispatcher()).a;
        boolean r4 = true;
        if (r3 != null) goto L13;
    L16:
        if (r4 == true) goto L18;
    L19:
        r2.closeCommentCards();
        return;
    L13:
        if (r3.n0() != CommentStyle.HALF_SCREEN) goto L16;
        r4 = false;
    L18:
        if (ImageViewerPlugin.access$800(r1.a) == false) goto L19;
        return;
    }

    public LiveData<ImageCardsData> getCardsData() {
        if (this.mImageCardsJsData != null) goto L6;
        this.mImageCardsJsData = new MutableLiveData();
    L6:
        return this.mImageCardsJsData;
    }

    public LiveData<Boolean> getCloseImageViewer() {
        if (this.mCloseImageViewer != null) goto L6;
        this.mCloseImageViewer = new MutableLiveData();
    L6:
        return this.mCloseImageViewer;
    }

    public LiveData<DeleteImageData> getDeleteImageData() {
        if (this.mDeleteImageData != null) goto L6;
        this.mDeleteImageData = new MutableLiveData();
    L6:
        return this.mDeleteImageData;
    }

    public LiveData<ImageDataModel> getImageData() {
        if (this.mImageData != null) goto L6;
        this.mImageData = new MutableLiveData();
    L6:
        return this.mImageData;
    }

    public ImageViewerViewModel() {
        this.currIndex = 0;
        this.mode = IImageViewer.ImageCommentMode.EXIT;
    }

    public IImageViewer.ImageCommentMode getCommentMode() {
        return this.mode;
    }

    public int getCurrIndex() {
        return this.currIndex;
    }

    private void setImageUUIDIfNeed(ImageDataModel r5) {
        ImageData.Image r0 = r5.getImage();
        if (r5.getImageList() != null) goto L5;
        return;
    L5:
        if (r5.getImageList().isEmpty() == true) goto L27;
        if (r0 == null) goto L28;
        Iterator<ImageData.Image> r6 = r5.getImageList().iterator();
    L9:
        if (r6.hasNext() == false) goto L29;
        ImageData.Image r1 = r6.next();
        setImageUUIDIfNeed(r1);
        if (TextUtils.isEmpty(r0.getUuid()) == false) goto L9;
        if (TextUtils.equals(r1.getSrc(), r0.getSrc()) == false) goto L9;
        if (TextUtils.equals(r1.getOriginalSrc(), r0.getOriginalSrc()) == false) goto L9;
        r0.setUuid(r1.getUuid());
        goto L9
    L29:
        return;
    L28:
        return;
    }

    public void closeImageViewer(String r5) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        ImageViewerPlugin.a r1 = (ImageViewerPlugin.a) r0;
        r1.getClass();
        ((c) org.koin.java.a.a(c.class)).f(ImageViewerPlugin.access$400(r1.a), "ImageViewerPlugin");
        ImageViewerPlugin.access$500(r1.a, Boolean.FALSE);
        r1.a.dispatchBridgeMsg("window.lark.biz.util.closeImg", new JSONObject());
        ((ImageViewerPlugin.a) this.mDelegate).a("exit", r5, -1);
        return;
    }

    public void deleteImage(String r4) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        ImageViewerPlugin.a r1 = (ImageViewerPlugin.a) r0;
        r1.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("uuid", r4);
        r1.a.dispatchBridgeMsg("window.native.assetBrowser.deleteImg", r2);
        return;
    }

    public void editImage(String r4) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        ((ImageViewerPlugin.a) r0).a("edit", r4, -1);
        return;
    }

    public void openImage(ImageDataModel r1) {
        setImageUUIDIfNeed(r1);
        updateImageData(r1);
    }

    public void setCloseImageViewer(Boolean r3) {
        tt5.a.h(TAG, "setCloseImageViewer:" + r3);
        getCloseImageViewer().setValue(r3);
    }

    public void setCommentMode(IImageViewer.ImageCommentMode r1) {
        this.mode = r1;
    }

    public void setDelegate(a r1) {
        this.mDelegate = r1;
    }

    public void showCommentInput(String r7) {
        tt5.a.h(TAG, "showCommentInput");
        a r0 = this.mDelegate;
        if (r0 == null) goto L12;
        ImageViewerPlugin.a r1 = (ImageViewerPlugin.a) r0;
        CommentPlugin r2 = (CommentPlugin) ImageViewerPlugin.access$600(r1.a, CommentPlugin.class);
        if (r2 != null) goto L7;
        return;
    L7:
        if (r1.a.getDocumentMetadata() == null) goto L9;
        String r3 = r1.a.getDocumentMetadata().getUrl();
    L10:
        CommentInputRequest r4 = new CommentInputRequest();
        r4.is_whole = false;
        r4.doc_token = d25.d.d;
        r4.doc_url = r3;
        r4.type = 0;
        r4.tmpCommentId = r7;
        r4.show_voice = true;
        r4.show_insert_image = true;
        r4.show_comment_image = true;
        r4.quote = ImageViewerPlugin.access$700(r1.a).getString(2131887620);
        r2.showCommentInput(r4);
        return;
    L9:
        r3 = "";
        goto L10
    }

    public void updateCardsData(ImageCardsData r2) {
        getCardsData().setValue(r2);
    }

    public void updateDeleteImageData(DeleteImageData r2) {
        getDeleteImageData().setValue(r2);
    }

    public void updateImageData(ImageDataModel r2) {
        getImageData().setValue(r2);
    }

    private void setImageUUIDIfNeed(ImageData.Image r5) {
        if (TextUtils.isEmpty(r5.getUuid()) == false) goto L6;
        r5.setUuid(String.format(Locale.CHINA, "%d_%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(sCounter.getAndIncrement())}));
        return;
    }

    public void commentImage(String r3, int r4) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        ((ImageViewerPlugin.a) r0).a("comment", r3, r4);
        return;
    }

    public ShowCardsJsData convertImageData2CardsJsData(String r3, ImageCardsData r4) {
        ShowCardsJsData r0 = new ShowCardsJsData();
        CardCommentData r1 = r4.getData().get(r3);
        if (r1 != null) goto L5;
        List<Card> r2 = null;
    L6:
        r0.setCards(r2);
        r0.setTmpCommentId(r3);
        r0.setCur_comment_id(r4.getCur_comment_id());
        r0.setToken(d25.d.d);
        Per r5 = new Per();
        r0.permission = r5;
        r5.comment = r4.isShow_input();
        Per r6 = r0.permission;
        r6.resolve = r4.isShow_resolve();
        return r0;
    L5:
        r2 = r1.getComments();
        goto L6
    }

    public void downloadImage(String r3, int r4) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        ((ImageViewerPlugin.a) r0).a(TYPE_DOWNLOADIMAGE, r3, r4);
        return;
    }

    public void loadError(String r3, int r4) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        ((ImageViewerPlugin.a) r0).a(TYPE_LOADERROR, r3, r4);
        return;
    }

    public void openSuccess(String r3, int r4) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        ((ImageViewerPlugin.a) r0).a(TYPE_OPEN_SUCCESS, r3, r4);
        return;
    }

    public void showCommentCards(String r2, ImageCardsData r3) {
        ShowCardsJsData r4 = convertImageData2CardsJsData(r2, r3);
        tt5.a.h(TAG, "updateCommentCard(): " + r4);
        a r5 = this.mDelegate;
        if (r5 == null) goto L11;
        ImageViewerPlugin.a r6 = (ImageViewerPlugin.a) r5;
        if (ImageViewerPlugin.access$800(r6.a) == true) goto L13;
        CommentPlugin r7 = (CommentPlugin) ImageViewerPlugin.access$900(r6.a, CommentPlugin.class);
        if (r7 == null) goto L12;
        r7.showCommentCards(r4);
        return;
    L12:
        return;
    L13:
        return;
    }

    public void swipe(String r3, int r4) {
        this.currIndex = r4;
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        ((ImageViewerPlugin.a) r0).a(TYPE_SWIPE, r3, r4);
        return;
    }
}
