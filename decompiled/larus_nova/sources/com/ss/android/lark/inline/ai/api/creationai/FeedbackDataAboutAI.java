package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackDataAboutAI;", "Ljava/io/Serializable;", "<init>", "()V", DBDefinition.TASK_ID, "", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "promptType", "getPromptType", "setPromptType", "promptText", "getPromptText", "setPromptText", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackDataAboutAI implements Serializable {
    private String promptText;
    private String promptType;
    private String taskId;

    public FeedbackDataAboutAI() {
    }

    public String toString() {
        return "FeedbackDataAboutAI(taskId=" + this.taskId + ", promptType=" + this.promptType + ", promptText=" + this.promptText + ')';
    }

    public final String getPromptText() {
        return this.promptText;
    }

    public final String getPromptType() {
        return this.promptType;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setPromptText(String r100) {
        this.promptText = r100;
    }

    public final void setPromptType(String r100) {
        this.promptType = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }
}
