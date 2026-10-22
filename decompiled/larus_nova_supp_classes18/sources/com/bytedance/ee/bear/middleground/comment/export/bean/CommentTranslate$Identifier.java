package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$Identifier;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "service", "", "getService", "()Ljava/lang/String;", "setService", "(Ljava/lang/String;)V", ResourceData.KEY_TOKEN, "getToken", "setToken", ResourceData.KEY_TYPE, "", "getType", "()I", "setType", "(I)V", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentTranslate$Identifier implements NonProguard {
    private String service;
    private String token;
    private int type;

    public CommentTranslate$Identifier() {
        this.type = -1;
    }

    public final String getService() {
        return this.service;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getType() {
        return this.type;
    }

    public final void setService(String r1) {
        this.service = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}
