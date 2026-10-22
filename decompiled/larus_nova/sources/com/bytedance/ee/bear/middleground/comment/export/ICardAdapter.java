package com.bytedance.ee.bear.middleground.comment.export;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H&J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0007H&J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/ICardAdapter;", "Lcom/bytedance/ee/util/io/NonProguard;", "getData", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "getCommentVisibility", "", "commentDetail", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "getCommentDetails", "", "setData", "", "data", "getLast3Item", "replyId", "", "findReplyIdByPosition", "position", "getPostion", "getBizParam", "", "", "getCommentId", MapController.ITEM_LAYER_TAG, "onItemVisible", SoloKtvContext.SOLO_PAGE_FIRST, "last", "getUiState", "Lcom/bytedance/ee/bear/middleground/comment/export/UiState;", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICardAdapter extends NonProguard {
    String findReplyIdByPosition(int r100);

    Map<Object, Object> getBizParam();

    List<CommentBean.CommentDetail> getCommentDetails();

    String getCommentId(CommentBean.CommentDetail r100);

    int getCommentVisibility(CommentBean.CommentDetail r100);

    CommentBean getData();

    List<CommentBean.CommentDetail> getLast3Item(String r100);

    String getPostion();

    w getUiState();

    void onItemVisible(int r100, int r101);

    void setData(CommentBean r100);
}
