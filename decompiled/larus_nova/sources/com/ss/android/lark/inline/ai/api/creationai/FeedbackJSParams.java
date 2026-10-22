package com.ss.android.lark.inline.ai.api.creationai;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackJSParams;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Ljava/lang/Boolean;", "setShow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isSuccess", "setSuccess", "data", "Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackDataAboutAI;", "getData", "()Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackDataAboutAI;", "setData", "(Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackDataAboutAI;)V", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackJSParams implements Serializable {
    private FeedbackDataAboutAI data;
    private Boolean isSuccess;
    private Boolean show;

    public FeedbackJSParams() {
    }

    public String toString() {
        return "FeedbackJSParams(show=" + this.show + ", isSuccess=" + this.isSuccess + ", data=" + this.data + ')';
    }

    public final FeedbackDataAboutAI getData() {
        return this.data;
    }

    public final Boolean getShow() {
        return this.show;
    }

    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setData(FeedbackDataAboutAI r100) {
        this.data = r100;
    }

    public final void setShow(Boolean r100) {
        this.show = r100;
    }

    public final void setSuccess(Boolean r100) {
        this.isSuccess = r100;
    }
}
