package com.ss.android.lark.inline.ai.creationai.editor;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/editor/LoggerMessage;", "Ljava/io/Serializable;", "<init>", "()V", "logMessage", "", "getLogMessage", "()Ljava/lang/String;", "setLogMessage", "(Ljava/lang/String;)V", "toString", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoggerMessage implements Serializable {
    private String logMessage;

    public LoggerMessage() {
    }

    public String toString() {
        return "LoggerMessage(logMessage=" + this.logMessage + ')';
    }

    public final String getLogMessage() {
        return this.logMessage;
    }

    public final void setLogMessage(String r100) {
        this.logMessage = r100;
    }
}
