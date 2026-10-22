package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.d;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Q*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0005:\u0001QB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010L\u001a\b\u0012\u0002\b\u0003\u0018\u00010MH\u0016J\u0018\u0010N\u001a\u00020*2\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000H\u0016J\u0018\u0010P\u001a\u00020*2\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001c\u0010 \u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR\u001c\u0010#\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\u001c\u0010&\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\rR\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010,\"\u0004\bB\u0010.R\u001a\u0010C\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0011\"\u0004\bE\u0010\u0013R\u001e\u0010F\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/Notice;", "Content", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/IContent;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/MultiBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/IDiff;", "<init>", "()V", "noticeId", "", "getNoticeId", "()Ljava/lang/String;", "setNoticeId", "(Ljava/lang/String;)V", "noticeChannel", "", "getNoticeChannel", "()I", "setNoticeChannel", "(I)V", "noticeTime", "", "getNoticeTime", "()J", "setNoticeTime", "(J)V", "readStatus", "getReadStatus", "setReadStatus", "mentionId", "getMentionId", "setMentionId", "commentId", "getCommentId", "setCommentId", "commentIdForTranslate", "getCommentIdForTranslate", "setCommentIdForTranslate", "replyId", "getReplyId", "setReplyId", "canTranslate", "", "getCanTranslate", "()Z", "setCanTranslate", "(Z)V", "canCopy", "getCanCopy", "setCanCopy", "content", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/ContentWraper;", "getContent", "()Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/ContentWraper;", "setContent", "(Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/ContentWraper;)V", "clickType", "getClickType", "setClickType", "clickToast", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;", "getClickToast", "()Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;", "setClickToast", "(Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;)V", "isGlobalComment", "setGlobalComment", "commentType", "getCommentType", "setCommentType", "noticeType", "getNoticeType", "()Ljava/lang/Integer;", "setNoticeType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAdapterType", "Ljava/lang/Class;", "isSameItem", "t2", "contentSame", "Companion", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Notice<Content extends IContent> implements MultiBean, NonProguard, d<Notice<Content>> {
    public static final String CLICK_TYPE_JUMP = "jump";
    public static final String CLICK_TYPE_TOAST = "toast";
    public static final a Companion = null;
    public static final int NOTICE_CHANNEL_BOT = 1;
    public static final int NOTICE_CHANNEL_FEED = 2;
    public static final int READ_STATUS_READ = 1;
    public static final int READ_STATUS_UNREAD = 0;
    private boolean canCopy;
    private boolean canTranslate;
    private TextContext clickToast;
    private String clickType;
    private String commentId;
    private String commentIdForTranslate;
    private int commentType;
    private ContentWraper<Content> content;
    private boolean isGlobalComment;
    private String mentionId;
    private int noticeChannel;
    private String noticeId;
    private long noticeTime;
    private Integer noticeType;
    private int readStatus;
    private String replyId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean
    public Class<?> getAdapterType() {
        ContentWraper<Content> r0 = this.content;
        if (r0 == null) goto L7;
        IContent r1 = r0.getData();
        if (r1 == null) goto L7;
        return r1.getClass();
    L7:
        return null;
    }

    public Notice() {
        this.noticeId = "";
        this.noticeChannel = 2;
        this.clickType = CLICK_TYPE_JUMP;
    }

    public final boolean getCanCopy() {
        return this.canCopy;
    }

    public final boolean getCanTranslate() {
        return this.canTranslate;
    }

    public final TextContext getClickToast() {
        return this.clickToast;
    }

    public final String getClickType() {
        return this.clickType;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getCommentIdForTranslate() {
        return this.commentIdForTranslate;
    }

    public final int getCommentType() {
        return this.commentType;
    }

    public final ContentWraper<Content> getContent() {
        return this.content;
    }

    public final String getMentionId() {
        return this.mentionId;
    }

    public final int getNoticeChannel() {
        return this.noticeChannel;
    }

    public final String getNoticeId() {
        return this.noticeId;
    }

    public final long getNoticeTime() {
        return this.noticeTime;
    }

    public final Integer getNoticeType() {
        return this.noticeType;
    }

    public final int getReadStatus() {
        return this.readStatus;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final boolean isGlobalComment() {
        return this.isGlobalComment;
    }

    public boolean contentSame(Notice<Content> r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return Objects.equals(this.content, r2.content);
    }

    public boolean isSameItem(Notice<Content> r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return TextUtils.equals(this.noticeId, r2.noticeId);
    }

    public final void setCanCopy(boolean r1) {
        this.canCopy = r1;
    }

    public final void setCanTranslate(boolean r1) {
        this.canTranslate = r1;
    }

    public final void setClickToast(TextContext r1) {
        this.clickToast = r1;
    }

    public final void setClickType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clickType = r2;
    }

    public final void setCommentId(String r1) {
        this.commentId = r1;
    }

    public final void setCommentIdForTranslate(String r1) {
        this.commentIdForTranslate = r1;
    }

    public final void setCommentType(int r1) {
        this.commentType = r1;
    }

    public final void setContent(ContentWraper<Content> r1) {
        this.content = r1;
    }

    public final void setGlobalComment(boolean r1) {
        this.isGlobalComment = r1;
    }

    public final void setMentionId(String r1) {
        this.mentionId = r1;
    }

    public final void setNoticeChannel(int r1) {
        this.noticeChannel = r1;
    }

    public final void setNoticeId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.noticeId = r2;
    }

    public final void setNoticeTime(long r1) {
        this.noticeTime = r1;
    }

    public final void setNoticeType(Integer r1) {
        this.noticeType = r1;
    }

    public final void setReadStatus(int r1) {
        this.readStatus = r1;
    }

    public final void setReplyId(String r1) {
        this.replyId = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(Object r1) {
        return contentSame((Notice) r1);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(Object r1) {
        return isSameItem((Notice) r1);
    }
}
