package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.execution.JobResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/capability/schedulekit/JobResultWrapper;", "", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "", "result", "replyForSvr", "", "jobResult", "Lcom/obric/capabilitykit/common/execution/JobResult;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/obric/capabilitykit/common/execution/JobResult;)V", "getJobResult", "()Lcom/obric/capabilitykit/common/execution/JobResult;", "getQuestion", "()Ljava/lang/String;", "getReplyForSvr", "()Z", "getResult", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JobResultWrapper {
    private final JobResult jobResult;
    private final String question;
    private final boolean replyForSvr;
    private final String result;

    public static /* synthetic */ JobResultWrapper copy$default(JobResultWrapper r100, String r101, String r102, boolean r103, JobResult r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.question;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.result;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.replyForSvr;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.jobResult;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.question;
    }

    public final String component2() {
        return this.result;
    }

    public final boolean component3() {
        return this.replyForSvr;
    }

    public final JobResult component4() {
        return this.jobResult;
    }

    public final JobResultWrapper copy(String r100, String r101, boolean r102, JobResult r103) {
        return new JobResultWrapper(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JobResultWrapper) == true) goto L8;
        return false;
    L8:
        JobResultWrapper r101 = (JobResultWrapper) r100;
        if (Intrinsics.areEqual(this.question, r101.question) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.result, r101.result) == true) goto L15;
        return false;
    L15:
        if (this.replyForSvr == r101.replyForSvr) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.jobResult, r101.jobResult) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String r100 = this.question;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.result;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.replyForSvr;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        JobResult r110 = this.jobResult;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "JobResultWrapper(question=" + this.question + ", result=" + this.result + ", replyForSvr=" + this.replyForSvr + ", jobResult=" + this.jobResult + ')';
    }

    public final JobResult getJobResult() {
        return this.jobResult;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final boolean getReplyForSvr() {
        return this.replyForSvr;
    }

    public final String getResult() {
        return this.result;
    }

    public JobResultWrapper(String r100, String r101, boolean r102, JobResult r103) {
        this.question = r100;
        this.result = r101;
        this.replyForSvr = r102;
        this.jobResult = r103;
    }
}
