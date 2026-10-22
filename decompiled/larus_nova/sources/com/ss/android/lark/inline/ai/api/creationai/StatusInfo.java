package com.ss.android.lark.inline.ai.api.creationai;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/StatusInfo;", "Ljava/io/Serializable;", "<init>", "()V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "text", "getText", "setText", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StatusInfo implements Serializable {
    private String status;
    private String text;

    public StatusInfo() {
    }

    public String toString() {
        return "StatusInfo(status=" + this.status + ", text=" + this.text + ')';
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getText() {
        return this.text;
    }

    public final void setStatus(String r100) {
        this.status = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
