package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010(\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/emojichoose/choose/EmojiExtParams;", "Ljava/io/Serializable;", "()V", "awemeId", "", "getAwemeId", "()Ljava/lang/String;", "setAwemeId", "(Ljava/lang/String;)V", "commentId", "getCommentId", "setCommentId", "convId", "getConvId", "setConvId", "enterFrom", "getEnterFrom", "setEnterFrom", "enterMethod", "getEnterMethod", "setEnterMethod", "forceLandingTypeKey", "getForceLandingTypeKey", "setForceLandingTypeKey", "groupType", "getGroupType", "setGroupType", "isGroupChat", "", "()Ljava/lang/Boolean;", "setGroupChat", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "toUserId", "", "getToUserId", "()Ljava/lang/Long;", "setToUserId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getChatType", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmojiExtParams implements Serializable {
    private String awemeId;
    private String commentId;
    private String convId;
    private String enterFrom;
    private String enterMethod;
    private String forceLandingTypeKey;
    private String groupType;
    private Boolean isGroupChat;
    private Long toUserId;

    public final String getChatType() {
        Boolean r0 = this.isGroupChat;
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L6;
        return "group";
    L6:
        if (Intrinsics.areEqual(r0, Boolean.FALSE) == false) goto L8;
        return "private";
    L8:
        return "";
    }

    public EmojiExtParams() {
        this.enterFrom = "";
        this.enterMethod = "";
        this.awemeId = "";
        this.commentId = "";
        this.convId = "";
        this.forceLandingTypeKey = "";
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getConvId() {
        return this.convId;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getForceLandingTypeKey() {
        return this.forceLandingTypeKey;
    }

    public final String getGroupType() {
        return this.groupType;
    }

    public final Long getToUserId() {
        return this.toUserId;
    }

    public final Boolean isGroupChat() {
        return this.isGroupChat;
    }

    public final void setAwemeId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.awemeId = r2;
    }

    public final void setCommentId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commentId = r2;
    }

    public final void setConvId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.convId = r2;
    }

    public final void setEnterFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterFrom = r2;
    }

    public final void setEnterMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterMethod = r2;
    }

    public final void setForceLandingTypeKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.forceLandingTypeKey = r2;
    }

    public final void setGroupChat(Boolean r1) {
        this.isGroupChat = r1;
    }

    public final void setGroupType(String r1) {
        this.groupType = r1;
    }

    public final void setToUserId(Long r1) {
        this.toUserId = r1;
    }
}
