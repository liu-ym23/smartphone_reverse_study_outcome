package com.bytedance.ee.bear.document.export.net.exportV2;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class GetExportResultParserV2 implements NetService.c<Result<ExportResultV2>> {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017JT\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/document/export/net/exportV2/GetExportResultParserV2$ExportResultV2;", "Ljava/io/Serializable;", "job_status", "", "job_error_msg", "", "fileToken", "fileName", "fileExtension", "file_size", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getJob_status", "()I", "getJob_error_msg", "()Ljava/lang/String;", "setJob_error_msg", "(Ljava/lang/String;)V", "getFileToken", "getFileName", "getFileExtension", "getFile_size", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ee/bear/document/export/net/exportV2/GetExportResultParserV2$ExportResultV2;", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExportResultV2 implements Serializable {
        private final String fileExtension;
        private final String fileName;
        private final String fileToken;
        private final Long file_size;
        private String job_error_msg;
        private final int job_status;

        public static /* synthetic */ ExportResultV2 copy$default(ExportResultV2 r100, int r101, String r102, String r103, String r104, String r105, Long r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.job_status;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.job_error_msg;
        L8:
            String r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.fileToken;
        L11:
            String r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.fileName;
        L14:
            String r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.fileExtension;
        L17:
            String r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.file_size;
        L20:
            int r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
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

        public final ExportResultV2 copy(int r100, String r110, String r111, String r112, String r113, Long r114) {
            return new ExportResultV2(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ExportResultV2) == true) goto L8;
            return false;
        L8:
            ExportResultV2 r101 = (ExportResultV2) r100;
            if (this.job_status == r101.job_status) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.job_error_msg, r101.job_error_msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.fileToken, r101.fileToken) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.fileExtension, r101.fileExtension) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.file_size, r101.file_size) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r100 = this.job_status * 31;
            String r101 = this.job_error_msg;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.fileToken;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.fileName;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.fileExtension;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Long r114 = this.file_size;
            if (r114 == null) goto L23;
            r102 = r114.hashCode();
        L23:
            return r113 + r102;
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
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

        public final void setJob_error_msg(String r100) {
            this.job_error_msg = r100;
        }

        public ExportResultV2(int r100, String r101, String r102, String r103, String r104, Long r105) {
            this.job_status = r100;
            this.job_error_msg = r101;
            this.fileToken = r102;
            this.fileName = r103;
            this.fileExtension = r104;
            this.file_size = r105;
        }
    }

    public GetExportResultParserV2() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<ExportResultV2> parse(String r110) {
        JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L4
        Result<ExportResultV2> r111 = new Result();     // Catch: JSONException -> L4
        r111.code = r100.optInt("code");     // Catch: JSONException -> L4
        r111.msg = r100.optString("message");     // Catch: JSONException -> L4
        JSONObject r101 = new JSONObject(new JSONObject(r100.optString("data")).optString("result"));     // Catch: JSONException -> L4
        r111.data = new ExportResultV2(r101.optInt("job_status"), r101.optString("job_error_msg"), r101.optString("file_token"), r101.optString("file_name"), r101.optString("file_extension"), Long.valueOf(r101.optLong("file_size")));     // Catch: JSONException -> L4
        return r111;
    L5:
        throw new NetService.ParseException();
    }
}
