package com.bytedance.ee.bear.document.export.net.exportV2;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class GetExportResultParserV2 implements NetService.c<Result<ExportResultV2>> {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017JT\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/document/export/net/exportV2/GetExportResultParserV2$ExportResultV2;", "Ljava/io/Serializable;", "job_status", "", "job_error_msg", "", "fileToken", "fileName", "fileExtension", "file_size", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getJob_status", "()I", "getJob_error_msg", "()Ljava/lang/String;", "setJob_error_msg", "(Ljava/lang/String;)V", "getFileToken", "getFileName", "getFileExtension", "getFile_size", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ee/bear/document/export/net/exportV2/GetExportResultParserV2$ExportResultV2;", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExportResultV2 implements Serializable {
        private final String fileExtension;
        private final String fileName;
        private final String fileToken;
        private final Long file_size;
        private String job_error_msg;
        private final int job_status;

        public static /* synthetic */ ExportResultV2 copy$default(ExportResultV2 r4, int r5, String r6, String r7, String r8, String r9, Long r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.job_status;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.job_error_msg;
        L8:
            String r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.fileToken;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.fileName;
        L14:
            String r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.fileExtension;
        L17:
            String r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.file_size;
        L20:
            int r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final int component1() {
            return this.job_status;
        }

        public final String component2() {
            return this.job_error_msg;
        }

        public final String component3() {
            return this.fileToken;
        }

        public final String component4() {
            return this.fileName;
        }

        public final String component5() {
            return this.fileExtension;
        }

        public final Long component6() {
            return this.file_size;
        }

        public final ExportResultV2 copy(int r9, String r10, String r11, String r12, String r13, Long r14) {
            return new ExportResultV2(r9, r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ExportResultV2) == true) goto L8;
            return false;
        L8:
            ExportResultV2 r6 = (ExportResultV2) r5;
            if (this.job_status == r6.job_status) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.job_error_msg, r6.job_error_msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.fileToken, r6.fileToken) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.fileExtension, r6.fileExtension) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.file_size, r6.file_size) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = this.job_status * 31;
            String r1 = this.job_error_msg;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.fileToken;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.fileName;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.fileExtension;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Long r14 = this.file_size;
            if (r14 == null) goto L23;
            r2 = r14.hashCode();
        L23:
            return r13 + r2;
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ExportResultV2(job_status=" + this.job_status + ", job_error_msg=" + this.job_error_msg + ", fileToken=" + this.fileToken + ", fileName=" + this.fileName + ", fileExtension=" + this.fileExtension + ", file_size=" + this.file_size + ')';
        }

        public final String getFileExtension() {
            return this.fileExtension;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final String getFileToken() {
            return this.fileToken;
        }

        public final Long getFile_size() {
            return this.file_size;
        }

        public final String getJob_error_msg() {
            return this.job_error_msg;
        }

        public final int getJob_status() {
            return this.job_status;
        }

        public final void setJob_error_msg(String r1) {
            this.job_error_msg = r1;
        }

        public ExportResultV2(int r1, String r2, String r3, String r4, String r5, Long r6) {
            this.job_status = r1;
            this.job_error_msg = r2;
            this.fileToken = r3;
            this.fileName = r4;
            this.fileExtension = r5;
            this.file_size = r6;
        }
    }

    public GetExportResultParserV2() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<ExportResultV2> parse(String r11) {
        JSONObject r0 = new JSONObject(r11);     // Catch: JSONException -> L4
        Result<ExportResultV2> r12 = new Result();     // Catch: JSONException -> L4
        r12.code = r0.optInt("code");     // Catch: JSONException -> L4
        r12.msg = r0.optString("message");     // Catch: JSONException -> L4
        JSONObject r1 = new JSONObject(new JSONObject(r0.optString("data")).optString(TipCallBackData.RESULT));     // Catch: JSONException -> L4
        r12.data = new ExportResultV2(r1.optInt("job_status"), r1.optString("job_error_msg"), r1.optString("file_token"), r1.optString("file_name"), r1.optString("file_extension"), Long.valueOf(r1.optLong("file_size")));     // Catch: JSONException -> L4
        return r12;
    L5:
        throw new NetService.ParseException();
    }
}
