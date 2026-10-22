package com.bytedance.ee.bear.drive.biz.comment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentArea;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\rR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u000e\u0010&\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/comment/DriveCommentVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mCommentPanelShadowHeight", "", "MAX_COMMENT_PANEL_DEFAULT_HEIGHT", "MIN_COMMENT_PANEL_DEFAULT_HEIGHT", "liveCommentData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "getLiveCommentData", "()Landroidx/lifecycle/MutableLiveData;", "liveCommentEntryDisplayState", "Lcom/bytedance/ee/bear/drive/biz/comment/DriveCommentEntryDisplayState;", "getLiveCommentEntryDisplayState", "liveFeedSelectedComment", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectF;", "getLiveFeedSelectedComment", "commentDataManger", "Lcom/bytedance/ee/bear/drive/biz/comment/data/DriveCommentDataManager;", "getCommentDataManger", "()Lcom/bytedance/ee/bear/drive/biz/comment/data/DriveCommentDataManager;", "commentPanelShowing", "", "getCommentPanelShowing", "liveCreatingCommentText", "", "getLiveCreatingCommentText", "liveCreatingCommentRect", "getLiveCreatingCommentRect", "liveTranslateSetting", "Lcom/ss/android/lark/chat/entity/translate/TranslateLanguageSetting;", "getLiveTranslateSetting", "liveInnerCommentMarkType", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentArea$Type;", "getLiveInnerCommentMarkType", "mCommentPanelDefaultHeight", "setCommentPanelDefaultHeight", "", "height", "(Ljava/lang/Integer;)V", "getCommentPanelDefaultHeight", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveCommentVM extends ViewModel {
    private final int MAX_COMMENT_PANEL_DEFAULT_HEIGHT;
    private final int MIN_COMMENT_PANEL_DEFAULT_HEIGHT;
    private final com.bytedance.ee.bear.drive.biz.comment.data.m commentDataManger;
    private final MutableLiveData<Boolean> commentPanelShowing;
    private final MutableLiveData<List<CommentBean>> liveCommentData;
    private final MutableLiveData<g> liveCommentEntryDisplayState;
    private final MutableLiveData<CommentRectF> liveCreatingCommentRect;
    private final MutableLiveData<CharSequence> liveCreatingCommentText;
    private final MutableLiveData<CommentRectF> liveFeedSelectedComment;
    private final MutableLiveData<CommentArea.Type> liveInnerCommentMarkType;
    private final MutableLiveData<TranslateLanguageSetting> liveTranslateSetting;
    private int mCommentPanelDefaultHeight;
    private final int mCommentPanelShadowHeight;

    public final int getCommentPanelDefaultHeight() {
        int r100 = this.mCommentPanelDefaultHeight;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        return ((int) (com.bytedance.ee.util.ui.n.t() * com.bytedance.ee.bear.facade.common.widget.d.f226584q)) - this.mCommentPanelShadowHeight;
    }

    public DriveCommentVM() {
        this.mCommentPanelShadowHeight = com.bytedance.ee.util.ui.n.d(18);
        this.MAX_COMMENT_PANEL_DEFAULT_HEIGHT = (int) ((com.bytedance.ee.util.ui.n.t() * 4) / 5.0f);
        this.MIN_COMMENT_PANEL_DEFAULT_HEIGHT = (int) ((com.bytedance.ee.util.ui.n.t() * 2) / 5.0f);
        this.liveCommentData = new MutableLiveData();
        this.liveCommentEntryDisplayState = new MutableLiveData();
        this.liveFeedSelectedComment = new MutableLiveData();
        this.commentDataManger = new com.bytedance.ee.bear.drive.biz.comment.data.m();
        this.commentPanelShowing = new MutableLiveData();
        this.liveCreatingCommentText = new MutableLiveData();
        this.liveCreatingCommentRect = new MutableLiveData();
        this.liveTranslateSetting = new MutableLiveData();
        this.liveInnerCommentMarkType = new MutableLiveData();
    }

    public final com.bytedance.ee.bear.drive.biz.comment.data.m getCommentDataManger() {
        return this.commentDataManger;
    }

    public final MutableLiveData<Boolean> getCommentPanelShowing() {
        return this.commentPanelShowing;
    }

    public final MutableLiveData<List<CommentBean>> getLiveCommentData() {
        return this.liveCommentData;
    }

    public final MutableLiveData<g> getLiveCommentEntryDisplayState() {
        return this.liveCommentEntryDisplayState;
    }

    public final MutableLiveData<CommentRectF> getLiveCreatingCommentRect() {
        return this.liveCreatingCommentRect;
    }

    public final MutableLiveData<CharSequence> getLiveCreatingCommentText() {
        return this.liveCreatingCommentText;
    }

    public final MutableLiveData<CommentRectF> getLiveFeedSelectedComment() {
        return this.liveFeedSelectedComment;
    }

    public final MutableLiveData<CommentArea.Type> getLiveInnerCommentMarkType() {
        return this.liveInnerCommentMarkType;
    }

    public final MutableLiveData<TranslateLanguageSetting> getLiveTranslateSetting() {
        return this.liveTranslateSetting;
    }

    public final void setCommentPanelDefaultHeight(Integer r100) {
        if (this.mCommentPanelDefaultHeight > 0) goto L11;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.intValue() > this.MIN_COMMENT_PANEL_DEFAULT_HEIGHT) goto L8;
        return;
    L8:
        if (r100.intValue() >= this.MAX_COMMENT_PANEL_DEFAULT_HEIGHT) goto L14;
        this.mCommentPanelDefaultHeight = r100.intValue() - this.mCommentPanelShadowHeight;
        return;
    L14:
        return;
    }
}
