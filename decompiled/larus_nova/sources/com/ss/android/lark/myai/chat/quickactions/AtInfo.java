package com.ss.android.lark.myai.chat.quickactions;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/myai/chat/quickactions/AtInfo;", "Ljava/io/Serializable;", "<init>", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "userId", "getUserId", "setUserId", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AtInfo implements Serializable {
    private String content;

    @SerializedName("user_id")
    private String userId;

    public AtInfo() {
    }

    public final String getContent() {
        return this.content;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
