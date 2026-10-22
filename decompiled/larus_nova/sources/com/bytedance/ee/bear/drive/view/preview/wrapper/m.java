package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.res.Configuration;
import android.view.View;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public interface m extends c95.d {
    String getCommentQuote();

    View getView();

    CommentRectF hideCreateComment();

    boolean isPreviewSupported();

    boolean onAreaClick();

    boolean onBackPressed();

    void onCommentInputPanelClose(boolean r100);

    void onCommentInputPanelOpen();

    void onCommentListPanelClose();

    void onCommentListPanelOpen();

    void onNewConfiguration(Configuration r100);

    void onSetup(ViewOwner r100, ViewOwner r101);

    void setUserAbility(a95.a r100);

    void show();

    void showSelectedComment(String r100);

    void showThumbnailPreview();

    void updateComment(ArrayList<CommentRectF> r100);
}
