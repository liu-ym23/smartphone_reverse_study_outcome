package com.bytedance.ee.bear.document.export.net.exportV2;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CommitExportParserV2 implements NetService.c<Result<CommitExportResult>> {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/document/export/net/exportV2/CommitExportParserV2$CommitExportResult;", "Ljava/io/Serializable;", "ticket", "", "jobTimeout", "", "<init>", "(Ljava/lang/String;I)V", "getTicket", "()Ljava/lang/String;", "getJobTimeout", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommitExportResult implements Serializable {
        private final int jobTimeout;
        private final String ticket;

        public static /* synthetic */ CommitExportResult copy$default(CommitExportResult r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.ticket;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.jobTimeout;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.ticket;
        }

        public final int component2() {
            return this.jobTimeout;
        }

        public final CommitExportResult copy(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "ticket");
            return new CommitExportResult(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CommitExportResult) == true) goto L8;
            return false;
        L8:
            CommitExportResult r6 = (CommitExportResult) r5;
            if (Intrinsics.areEqual(this.ticket, r6.ticket) == true) goto L12;
            return false;
        L12:
            if (this.jobTimeout == r6.jobTimeout) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.ticket.hashCode() * 31) + this.jobTimeout;
        }

        public String toString() {
            return "CommitExportResult(ticket=" + this.ticket + ", jobTimeout=" + this.jobTimeout + ')';
        }

        public final int getJobTimeout() {
            return this.jobTimeout;
        }

        public final String getTicket() {
            return this.ticket;
        }

        public CommitExportResult(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "ticket");
            this.ticket = r2;
            this.jobTimeout = r3;
        }
    }

    public CommitExportParserV2() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<CommitExportResult> parse(String r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        JSONObject r0 = new JSONObject(r5);     // Catch: JSONException -> L7
        Result<CommitExportResult> r6 = new Result();     // Catch: JSONException -> L7
        r6.msg = r0.optString("msg");     // Catch: JSONException -> L7
        int r1 = r0.optInt("code");     // Catch: JSONException -> L7
        r6.code = r1;     // Catch: JSONException -> L7
        if (r1 != 0) goto L6;
        JSONObject r2 = new JSONObject(r0.optString("data"));     // Catch: JSONException -> L7
        r6.data = new CommitExportResult(r2.optString("ticket"), r2.optInt("job_timeout"));     // Catch: JSONException -> L7
    L6:
        return r6;
    L8:
        throw new NetService.ParseException();
    }
}
