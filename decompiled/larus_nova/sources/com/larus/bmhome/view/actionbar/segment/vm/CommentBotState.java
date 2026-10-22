package com.larus.bmhome.view.actionbar.segment.vm;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.comment.api.CommentHttpApi$GetCommentListData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/actionbar/segment/vm/CommentBotState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "Ljava/io/Serializable;", "showCommentButton", "", "commentCount", "", "botId", "", "draft", "preloadData", "Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "<init>", "(ZJLjava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;)V", "getShowCommentButton", "()Z", "getCommentCount", "()J", "getBotId", "()Ljava/lang/String;", "getDraft", "getPreloadData", "()Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentBotState implements w1a.b, Serializable {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("comment_count")
    private final long commentCount;

    @SerializedName("draft")
    private final String draft;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRELOAD_DATA)
    private final CommentHttpApi$GetCommentListData preloadData;

    @SerializedName("show_comment_button")
    private final boolean showCommentButton;

    public CommentBotState() {
        this(false, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ CommentBotState copy$default(CommentBotState r100, boolean r101, long r102, String r103, String r104, CommentHttpApi$GetCommentListData r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.showCommentButton;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.commentCount;
    L8:
        long r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.botId;
    L11:
        String r113 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.draft;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.preloadData;
    L17:
        boolean r107 = r101;
        return r100.copy(r107, r105, r113, r106, r110);
    }

    public final boolean component1() {
        return this.showCommentButton;
    }

    public final long component2() {
        return this.commentCount;
    }

    public final String component3() {
        return this.botId;
    }

    public final String component4() {
        return this.draft;
    }

    public final CommentHttpApi$GetCommentListData component5() {
        return this.preloadData;
    }

    public final CommentBotState copy(boolean r100, long r110, String r111, String r112, CommentHttpApi$GetCommentListData r113) {
        return new CommentBotState(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommentBotState) == true) goto L8;
        return false;
    L8:
        CommentBotState r101 = (CommentBotState) r100;
        if (this.showCommentButton == r101.showCommentButton) goto L12;
        return false;
    L12:
        if (this.commentCount == r101.commentCount) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.draft, r101.draft) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.preloadData, r101.preloadData) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.showCommentButton == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.commentCount;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.botId;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.draft;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        CommentHttpApi$GetCommentListData r110 = this.preloadData;
        if (r110 == null) goto L19;
        r104 = r110.hashCode();
    L19:
        return r109 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "CommentBotState(showCommentButton=" + this.showCommentButton + ", commentCount=" + this.commentCount + ", botId=" + this.botId + ", draft=" + this.draft + ", preloadData=" + this.preloadData + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final long getCommentCount() {
        return this.commentCount;
    }

    public final String getDraft() {
        return this.draft;
    }

    public final CommentHttpApi$GetCommentListData getPreloadData() {
        return this.preloadData;
    }

    public final boolean getShowCommentButton() {
        return this.showCommentButton;
    }

    public CommentBotState(boolean r100, long r101, String r102, String r103, CommentHttpApi$GetCommentListData r104) {
        this.showCommentButton = r100;
        this.commentCount = r101;
        this.botId = r102;
        this.draft = r103;
        this.preloadData = r104;
    }

    public /* synthetic */ CommentBotState(boolean r100, long r101, String r102, String r103, CommentHttpApi$GetCommentListData r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        long r104 = r101;
        if ((r111 & 4) == 0) goto L11;
        String r113 = null;
    L13:
        if ((r111 & 8) == 0) goto L15;
        String r105 = null;
    L17:
        if ((r111 & 16) == 0) goto L19;
        CommentHttpApi$GetCommentListData r106 = null;
    L20:
        this(r100, r104, r113, r105, r106);
        return;
    L19:
        r106 = r110;
        goto L20
    L15:
        r105 = r103;
        goto L17
    L11:
        r113 = r102;
        goto L13
    }
}
