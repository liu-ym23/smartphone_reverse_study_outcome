package com.bytedance.ee.bear.bitable.homepage.activity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010D\u001a\u0004\u0018\u000106J\b\u0010E\u001a\u0004\u0018\u00010!R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\u001e\u0010)\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001e\u0010,\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\u001c\u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR\u001c\u00102\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\tR\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\tR\u001a\u0010>\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u0010\tR\u001a\u0010A\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0007\"\u0004\bC\u0010\t¨\u0006G"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "noticeId", "", "getNoticeId", "()Ljava/lang/String;", "setNoticeId", "(Ljava/lang/String;)V", "noticeType", "", "getNoticeType", "()Ljava/lang/Integer;", "setNoticeType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "userInfo", "Lcom/bytedance/ee/bear/bitable/homepage/activity/UserInfo;", "getUserInfo", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/UserInfo;", "setUserInfo", "(Lcom/bytedance/ee/bear/bitable/homepage/activity/UserInfo;)V", "noticeTime", "", "getNoticeTime", "()J", "setNoticeTime", "(J)V", "content", "getContent", "setContent", "contentBean", "Lcom/bytedance/ee/bear/bitable/homepage/activity/Content;", "getContentBean", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/Content;", "setContentBean", "(Lcom/bytedance/ee/bear/bitable/homepage/activity/Content;)V", "readStatus", "getReadStatus", "setReadStatus", "noticeStatus", "getNoticeStatus", "setNoticeStatus", "sourceType", "getSourceType", "setSourceType", "sourceToken", "getSourceToken", "setSourceToken", "extra", "getExtra", "setExtra", "noticeExtra", "Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeExtra;", "getNoticeExtra", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeExtra;", "setNoticeExtra", "(Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeExtra;)V", "quote", "getQuote", "setQuote", "objName", "getObjName", "setObjName", "objUrl", "getObjUrl", "setObjUrl", "parseExtra", "parseContent", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoticeInfo implements NonProguard {
    public static final int BEAR_COMMENT_ADD_REACTION = 6;
    public static final int BEAR_COMMNET_ADD_COMMENT = 1;
    public static final int BEAR_COMMNET_ADD_REPLY_NOTIFY_UPSTAIRS = 3;
    public static final int BEAR_COMMNET_FINISH_COMMENT = 4;
    public static final int BEAR_COMMNET_REOPEN_COMMENT = 5;
    public static final int BEAR_MENTION_AT_IN_COMMENT = 2002;
    public static final int BEAR_MENTION_AT_IN_CONTENT = 2001;
    public static final int BEAR_REACTION_ADD_CONTENT_REACTION = 8;
    public static final int COMMENT_DELETE = 11;
    public static final int COMMENT_FINISH = 12;
    public static final int COMMENT_REACTION_DELETE = 21;
    public static final int COMMENT_REACTION_FINISH = 13;
    public static final int CONTENT_REACTION_DELETE = 22;
    public static final int CONTENT_REACTION_FINISH = 17;
    public static final int CONTENT_REACTION_FINISH_TO_REOPEN = 18;
    public static final int CONTENT_REACTION_REOPEN_TO_FINISH = 19;
    public static final a Companion = null;
    public static final int FINISH_TO_REOPEN = 15;
    public static final String KEY_COMMENT_CONTENT_FOT_FEED = "comment_content_for_feed";
    public static final String KEY_COMMENT_ID = "comment_id";
    public static final String KEY_COMMENT_OWNER_ID = "comment_owner_id";
    public static final String KEY_COMMENT_OWNER_NAME = "comment_owner_name";
    public static final String KEY_PICTURES = "pictures";
    public static final String KEY_REACTION_KEY = "reaction_key";
    public static final String KEY_REPLY_ID = "reply_id";
    public static final int NORMAL = 0;
    public static final int PERMISSION_APPROVED = 31;
    public static final int PERMISSION_REJECTED = 32;
    public static final int READ = 1;
    public static final int REOPEN_TO_FINISH = 16;
    public static final String TAG = "NoticeInfo";
    public static final int UNREAD = 0;
    public static final int WHOLE_COMMENT_FINISH = 14;
    private String content;
    private Content contentBean;
    private String extra;
    private NoticeExtra noticeExtra;

    @JSONField(name = "noticeID")
    private String noticeId;
    private Integer noticeStatus;
    private long noticeTime;
    private Integer noticeType;
    private String objName;
    private String objUrl;
    private String quote;
    private Integer readStatus;
    private String sourceToken;
    private Integer sourceType;

    @JSONField(name = "fromUser")
    private UserInfo userInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final Content parseContent() {
        if (this.content != null) goto L6;
        return null;
    L6:
        if (this.contentBean != null) goto L15;
        this.contentBean = new Content();
        Locale r100 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        String r101 = ("_" + r100.getLanguage() + '_' + r100.getCountry()).toLowerCase();
        JSONObject r102 = new JSONObject(this.content);     // Catch: Exception -> L12
        String r103 = r102.optString("comment_id", "");     // Catch: Exception -> L12
        String r104 = r102.optString(KEY_REPLY_ID, "");     // Catch: Exception -> L12
        String r105 = r102.optString(KEY_COMMENT_OWNER_ID, "");     // Catch: Exception -> L12
        String r106 = r102.optString(KEY_REACTION_KEY, "");     // Catch: Exception -> L12
        String r110 = r102.optString(KEY_COMMENT_CONTENT_FOT_FEED + r101, "");     // Catch: Exception -> L12
        String r107 = r102.optString(KEY_COMMENT_CONTENT_FOT_FEED, "");     // Catch: Exception -> L12
        String r111 = r102.optString(KEY_COMMENT_OWNER_NAME + r101, "");     // Catch: Exception -> L12
        String r108 = r102.optString(KEY_COMMENT_OWNER_NAME, "");     // Catch: Exception -> L12
        String r109 = r102.optString(KEY_PICTURES + r101, "");     // Catch: Exception -> L12
        String r112 = r102.optString(KEY_PICTURES, "");     // Catch: Exception -> L12
        Content r113 = this.contentBean;     // Catch: Exception -> L12
        if (r113 == null) goto L15;
        Intrinsics.checkNotNull(r107);     // Catch: Exception -> L12
        r113.setCommentContentFeedDefault(r107);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L12
        r113.setCommentContentFeed(r110);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L12
        r113.setCommentOwnerNameDefault(r108);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L12
        r113.setCommentOwnerName(r111);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L12
        r113.setPicturesDefault(r112);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r109);     // Catch: Exception -> L12
        r113.setPictures(r109);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L12
        r113.setCommentId(r103);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L12
        r113.setReplyId(r104);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L12
        r113.setCommentOwnerId(r105);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L12
        r113.setReactionKey(r106);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e(TAG, "parseContent err ", e, false);
        Unit r114 = Unit.INSTANCE;
    L15:
        return this.contentBean;
    }

    public final NoticeExtra parseExtra() {
        String r100 = this.extra;
        if (r100 != null) goto L7;
        return null;
    L7:
        if (this.noticeExtra != null) goto L10;
        this.noticeExtra = (NoticeExtra) JSON.parseObject(r100, NoticeExtra.class);
    L10:
        return this.noticeExtra;
    }

    public NoticeInfo() {
        this.objName = "";
        this.objUrl = "";
    }

    public final String getContent() {
        return this.content;
    }

    public final Content getContentBean() {
        return this.contentBean;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final NoticeExtra getNoticeExtra() {
        return this.noticeExtra;
    }

    public final String getNoticeId() {
        return this.noticeId;
    }

    public final Integer getNoticeStatus() {
        return this.noticeStatus;
    }

    public final long getNoticeTime() {
        return this.noticeTime;
    }

    public final Integer getNoticeType() {
        return this.noticeType;
    }

    public final String getObjName() {
        return this.objName;
    }

    public final String getObjUrl() {
        return this.objUrl;
    }

    public final String getQuote() {
        return this.quote;
    }

    public final Integer getReadStatus() {
        return this.readStatus;
    }

    public final String getSourceToken() {
        return this.sourceToken;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setContentBean(Content r100) {
        this.contentBean = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setNoticeExtra(NoticeExtra r100) {
        this.noticeExtra = r100;
    }

    public final void setNoticeId(String r100) {
        this.noticeId = r100;
    }

    public final void setNoticeStatus(Integer r100) {
        this.noticeStatus = r100;
    }

    public final void setNoticeTime(long r100) {
        this.noticeTime = r100;
    }

    public final void setNoticeType(Integer r100) {
        this.noticeType = r100;
    }

    public final void setObjName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.objName = r100;
    }

    public final void setObjUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.objUrl = r100;
    }

    public final void setQuote(String r100) {
        this.quote = r100;
    }

    public final void setReadStatus(Integer r100) {
        this.readStatus = r100;
    }

    public final void setSourceToken(String r100) {
        this.sourceToken = r100;
    }

    public final void setSourceType(Integer r100) {
        this.sourceType = r100;
    }

    public final void setUserInfo(UserInfo r100) {
        this.userInfo = r100;
    }
}
