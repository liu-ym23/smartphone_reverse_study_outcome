package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/ChatModeData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "objectType", "getObjectType", "setObjectType", "url", "getUrl", "setUrl", "welcomeMessageInfo", "getWelcomeMessageInfo", "setWelcomeMessageInfo", "docContext", "Lcom/bytedance/ee/bear/document/ai/myai/DocContext;", "getDocContext", "()Lcom/bytedance/ee/bear/document/ai/myai/DocContext;", "setDocContext", "(Lcom/bytedance/ee/bear/document/ai/myai/DocContext;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatModeData implements NonProguard {
    private DocContext docContext;
    private String objectId;
    private String objectType;
    private String url;
    private String welcomeMessageInfo;

    public ChatModeData() {
    }

    public String toString() {
        return "ChatModeData(objectId=" + du5.b.k(this.objectId) + ", objectType=" + this.objectType + ", url=" + du5.b.l(this.url) + ", welcomeMessageInfo=" + this.welcomeMessageInfo + ", docContext=" + this.docContext + ')';
    }

    public final DocContext getDocContext() {
        return this.docContext;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getWelcomeMessageInfo() {
        return this.welcomeMessageInfo;
    }

    public final void setDocContext(DocContext r1) {
        this.docContext = r1;
    }

    public final void setObjectId(String r1) {
        this.objectId = r1;
    }

    public final void setObjectType(String r1) {
        this.objectType = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setWelcomeMessageInfo(String r1) {
        this.welcomeMessageInfo = r1;
    }
}
