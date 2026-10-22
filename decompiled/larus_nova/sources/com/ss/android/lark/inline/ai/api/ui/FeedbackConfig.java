package com.ss.android.lark.inline.ai.api.ui;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/FeedbackConfig;", "Ljava/io/Serializable;", "aiMessageId", "", "scenario", "requestRawdata", "answerRawdata", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAiMessageId", "()Ljava/lang/String;", "setAiMessageId", "(Ljava/lang/String;)V", "getScenario", "setScenario", "getRequestRawdata", "setRequestRawdata", "getAnswerRawdata", "setAnswerRawdata", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackConfig implements Serializable {
    private String aiMessageId;
    private String answerRawdata;
    private String requestRawdata;
    private String scenario;

    public FeedbackConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FeedbackConfig copy$default(FeedbackConfig r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.aiMessageId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.scenario;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.requestRawdata;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.answerRawdata;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.aiMessageId;
    }

    public final String component2() {
        return this.scenario;
    }

    public final String component3() {
        return this.requestRawdata;
    }

    public final String component4() {
        return this.answerRawdata;
    }

    public final FeedbackConfig copy(String r100, String r101, String r102, String r103) {
        return new FeedbackConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedbackConfig) == true) goto L8;
        return false;
    L8:
        FeedbackConfig r101 = (FeedbackConfig) r100;
        if (Intrinsics.areEqual(this.aiMessageId, r101.aiMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scenario, r101.scenario) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.requestRawdata, r101.requestRawdata) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.answerRawdata, r101.answerRawdata) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.aiMessageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.scenario;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.requestRawdata;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.answerRawdata;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("FeedbackConfig(aiMessageId=");
        r100.append(this.aiMessageId);
        r100.append(", scenario=");
        r100.append(this.scenario);
        r100.append(", requestRawdata=");
        r100.append(this.requestRawdata);
        r100.append(", answerRawdata.length=");
        String r101 = this.answerRawdata;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.length());
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
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

    public final void setAiMessageId(String r100) {
        this.aiMessageId = r100;
    }

    public final void setAnswerRawdata(String r100) {
        this.answerRawdata = r100;
    }

    public final void setRequestRawdata(String r100) {
        this.requestRawdata = r100;
    }

    public final void setScenario(String r100) {
        this.scenario = r100;
    }

    public FeedbackConfig(String r100, String r101, String r102, String r103) {
        this.aiMessageId = r100;
        this.scenario = r101;
        this.requestRawdata = r102;
        this.answerRawdata = r103;
    }

    public /* synthetic */ FeedbackConfig(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
