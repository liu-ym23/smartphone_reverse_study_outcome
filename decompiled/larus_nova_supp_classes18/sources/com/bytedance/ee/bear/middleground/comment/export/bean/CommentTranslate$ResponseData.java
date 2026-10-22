package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$ResponseData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", WikiFolderPushPlugin.OPT, "", "getOperation", "()Ljava/lang/String;", "setOperation", "(Ljava/lang/String;)V", "identifier", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$Identifier;", "getIdentifier", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$Identifier;", "setIdentifier", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$Identifier;)V", "body", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$ResponseBody;", "getBody", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$ResponseBody;", "setBody", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$ResponseBody;)V", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentTranslate$ResponseData implements NonProguard {
    private CommentTranslate$ResponseBody body;
    private CommentTranslate$Identifier identifier;
    private String operation;

    public CommentTranslate$ResponseData() {
    }

    public final CommentTranslate$ResponseBody getBody() {
        return this.body;
    }

    public final CommentTranslate$Identifier getIdentifier() {
        return this.identifier;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final void setBody(CommentTranslate$ResponseBody r1) {
        this.body = r1;
    }

    public final void setIdentifier(CommentTranslate$Identifier r1) {
        this.identifier = r1;
    }

    public final void setOperation(String r1) {
        this.operation = r1;
    }
}
