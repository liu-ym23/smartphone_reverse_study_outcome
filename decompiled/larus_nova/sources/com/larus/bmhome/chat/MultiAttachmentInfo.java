package com.larus.bmhome.chat;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/MultiAttachmentInfo;", "Ljava/io/Serializable;", "localMsgId", "", "fromScene", "enterMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocalMsgId", "()Ljava/lang/String;", "getFromScene", "getEnterMethod", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiAttachmentInfo implements Serializable {
    private final String enterMethod;
    private final String fromScene;
    private final String localMsgId;

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    public MultiAttachmentInfo(String r100, String r101, String r102) {
        this.localMsgId = r100;
        this.fromScene = r101;
        this.enterMethod = r102;
    }
}
