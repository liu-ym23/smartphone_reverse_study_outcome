package com.bytedance.awemeopen.apps.framework.comment.api.statistics;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001PB\u000f\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR0\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020E\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006Q"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/api/statistics/CommentMobParameters;", "Ljava/io/Serializable;", "", "clickType", "Ljava/lang/String;", "getClickType", "()Ljava/lang/String;", "setClickType", "(Ljava/lang/String;)V", "enterFrom", "getEnterFrom", "setEnterFrom", "groupId", "getGroupId", "setGroupId", "authorOpenId", "getAuthorOpenId", "setAuthorOpenId", "imprId", "getImprId", "setImprId", "commentCategory", "getCommentCategory", "setCommentCategory", "relationTag", "getRelationTag", "setRelationTag", "relationTagReply", "getRelationTagReply", "setRelationTagReply", "accountType", "getAccountType", "setAccountType", "closeMethod", "getCloseMethod", "setCloseMethod", "typeContent", "getTypeContent", "setTypeContent", "emojiToKeyboardMethod", "getEmojiToKeyboardMethod", "setEmojiToKeyboardMethod", "commentId", "getCommentId", "setCommentId", "", "emojiTimes", "I", "getEmojiTimes", "()I", "setEmojiTimes", "(I)V", "awemeType", "getAwemeType", "setAwemeType", "previousPage", "getPreviousPage", "setPreviousPage", "Lorg/json/JSONObject;", "hostExtraParams", "Lorg/json/JSONObject;", "getHostExtraParams", "()Lorg/json/JSONObject;", "setHostExtraParams", "(Lorg/json/JSONObject;)V", "replyToOpenId", "getReplyToOpenId", "setReplyToOpenId", "", "", "extraParams", "Ljava/util/Map;", "getExtraParams", "()Ljava/util/Map;", "setExtraParams", "(Ljava/util/Map;)V", "Lcom/bytedance/awemeopen/apps/framework/comment/api/statistics/CommentMobParameters$a;", "builder", "<init>", "(Lcom/bytedance/awemeopen/apps/framework/comment/api/statistics/CommentMobParameters$a;)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentMobParameters implements Serializable {
    private String accountType;
    private String authorOpenId;
    private int awemeType;
    private String clickType;
    private String closeMethod;
    private String commentCategory;
    private String commentId;
    private int emojiTimes;
    private String emojiToKeyboardMethod;
    private String enterFrom;
    private Map<String, Object> extraParams;
    private String groupId;
    private JSONObject hostExtraParams;
    private String imprId;
    private String previousPage;
    private String relationTag;
    private String relationTagReply;
    private String replyToOpenId;
    private String typeContent;

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public int k;
        public String l;
        public JSONObject m;
        public String n;
        public Map<String, Object> o;

        public a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.j = "";
            this.l = "";
            this.n = "";
        }
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getAuthorOpenId() {
        return this.authorOpenId;
    }

    public final int getAwemeType() {
        return this.awemeType;
    }

    public final String getClickType() {
        return this.clickType;
    }

    public final String getCloseMethod() {
        return this.closeMethod;
    }

    public final String getCommentCategory() {
        return this.commentCategory;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final int getEmojiTimes() {
        return this.emojiTimes;
    }

    public final String getEmojiToKeyboardMethod() {
        return this.emojiToKeyboardMethod;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final JSONObject getHostExtraParams() {
        return this.hostExtraParams;
    }

    public final String getImprId() {
        return this.imprId;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getRelationTag() {
        return this.relationTag;
    }

    public final String getRelationTagReply() {
        return this.relationTagReply;
    }

    public final String getReplyToOpenId() {
        return this.replyToOpenId;
    }

    public final String getTypeContent() {
        return this.typeContent;
    }

    public CommentMobParameters(a r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        this.clickType = "";
        this.enterFrom = "";
        this.groupId = "";
        this.authorOpenId = "";
        this.imprId = "";
        this.commentCategory = "";
        this.relationTag = "";
        this.relationTagReply = "";
        this.accountType = "";
        this.commentId = "";
        this.awemeType = -2;
        this.replyToOpenId = "";
        this.clickType = r4.a;
        this.enterFrom = r4.b;
        this.groupId = r4.c;
        this.authorOpenId = r4.d;
        this.imprId = r4.e;
        this.commentCategory = r4.f;
        this.relationTag = "";
        this.relationTagReply = "";
        this.accountType = "";
        this.closeMethod = r4.g;
        this.typeContent = r4.h;
        this.emojiToKeyboardMethod = r4.i;
        this.commentId = r4.j;
        this.emojiTimes = r4.k;
        this.awemeType = -2;
        this.previousPage = r4.l;
        this.hostExtraParams = r4.m;
        this.replyToOpenId = r4.n;
        this.extraParams = r4.o;
    }

    public final void setAccountType(String r1) {
        this.accountType = r1;
    }

    public final void setAuthorOpenId(String r1) {
        this.authorOpenId = r1;
    }

    public final void setAwemeType(int r1) {
        this.awemeType = r1;
    }

    public final void setClickType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clickType = r2;
    }

    public final void setCloseMethod(String r1) {
        this.closeMethod = r1;
    }

    public final void setCommentCategory(String r1) {
        this.commentCategory = r1;
    }

    public final void setCommentId(String r1) {
        this.commentId = r1;
    }

    public final void setEmojiTimes(int r1) {
        this.emojiTimes = r1;
    }

    public final void setEmojiToKeyboardMethod(String r1) {
        this.emojiToKeyboardMethod = r1;
    }

    public final void setEnterFrom(String r1) {
        this.enterFrom = r1;
    }

    public final void setExtraParams(Map<String, Object> r1) {
        this.extraParams = r1;
    }

    public final void setGroupId(String r1) {
        this.groupId = r1;
    }

    public final void setHostExtraParams(JSONObject r1) {
        this.hostExtraParams = r1;
    }

    public final void setImprId(String r1) {
        this.imprId = r1;
    }

    public final void setPreviousPage(String r1) {
        this.previousPage = r1;
    }

    public final void setRelationTag(String r1) {
        this.relationTag = r1;
    }

    public final void setRelationTagReply(String r1) {
        this.relationTagReply = r1;
    }

    public final void setReplyToOpenId(String r1) {
        this.replyToOpenId = r1;
    }

    public final void setTypeContent(String r1) {
        this.typeContent = r1;
    }
}
