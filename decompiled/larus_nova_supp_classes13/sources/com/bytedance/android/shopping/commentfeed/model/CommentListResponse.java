package com.bytedance.android.shopping.commentfeed.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.LynxCellData;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.ec.model.response.f1;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/model/CommentListResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "comments", "Ljava/util/List;", "getComments", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "", "cursor", "I", "getCursor", "()I", "setCursor", "(I)V", "Lcom/bytedance/android/ec/model/response/f1;", "surveyV2", "Lcom/bytedance/android/ec/model/response/f1;", "getSurveyV2", "()Lcom/bytedance/android/ec/model/response/f1;", "setSurveyV2", "(Lcom/bytedance/android/ec/model/response/f1;)V", "Lcom/bytedance/android/ec/model/response/LynxCellData;", "newNpsInfo", "Lcom/bytedance/android/ec/model/response/LynxCellData;", "getNewNpsInfo", "()Lcom/bytedance/android/ec/model/response/LynxCellData;", "setNewNpsInfo", "(Lcom/bytedance/android/ec/model/response/LynxCellData;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentListResponse extends CommerceBaseResponse {

    @SerializedName("comments")
    private List<PromotionProductCommentDTO> comments;

    @SerializedName("cursor")
    private int cursor;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("nps_info")
    private LynxCellData newNpsInfo;

    @SerializedName("survey_v2")
    private f1 surveyV2;

    public CommentListResponse() {
        this.comments = new ArrayList();
    }

    public final List<PromotionProductCommentDTO> getComments() {
        return this.comments;
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final LynxCellData getNewNpsInfo() {
        return this.newNpsInfo;
    }

    public final f1 getSurveyV2() {
        return this.surveyV2;
    }

    public final void setComments(List<PromotionProductCommentDTO> r1) {
        this.comments = r1;
    }

    public final void setCursor(int r1) {
        this.cursor = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setNewNpsInfo(LynxCellData r1) {
        this.newNpsInfo = r1;
    }

    public final void setSurveyV2(f1 r1) {
        this.surveyV2 = r1;
    }
}
