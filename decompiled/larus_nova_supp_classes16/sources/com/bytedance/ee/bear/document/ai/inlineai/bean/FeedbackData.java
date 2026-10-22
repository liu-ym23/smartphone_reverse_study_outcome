package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/FeedbackData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "aiMessageId", "", "getAiMessageId", "()Ljava/lang/String;", "setAiMessageId", "(Ljava/lang/String;)V", "scenario", "getScenario", "setScenario", "requestRawdata", "getRequestRawdata", "setRequestRawdata", "answerRawdata", "getAnswerRawdata", "setAnswerRawdata", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackData implements NonProguard {
    private String aiMessageId;
    private String answerRawdata;
    private String requestRawdata;
    private String scenario;

    public FeedbackData() {
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("FeedbackData(aiMessageId=");
        r0.append(this.aiMessageId);
        r0.append(", scenario=");
        r0.append(this.scenario);
        r0.append(", requestRawdata=");
        r0.append(this.requestRawdata);
        r0.append(", answerRawdata.length=");
        String r1 = this.answerRawdata;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String getAiMessageId() {
        return this.aiMessageId;
    }

    public final String getAnswerRawdata() {
        return this.answerRawdata;
    }

    public final String getRequestRawdata() {
        return this.requestRawdata;
    }

    public final String getScenario() {
        return this.scenario;
    }

    public final void setAiMessageId(String r1) {
        this.aiMessageId = r1;
    }

    public final void setAnswerRawdata(String r1) {
        this.answerRawdata = r1;
    }

    public final void setRequestRawdata(String r1) {
        this.requestRawdata = r1;
    }

    public final void setScenario(String r1) {
        this.scenario = r1;
    }
}
