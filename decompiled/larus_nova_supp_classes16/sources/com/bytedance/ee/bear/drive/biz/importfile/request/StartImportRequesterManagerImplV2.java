package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class StartImportRequesterManagerImplV2 extends com.bytedance.ee.bear.drive.biz.importfile.request.b {
    public final NetService j;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/importfile/request/StartImportRequesterManagerImplV2$CheckImportResult;", "Ljava/io/Serializable;", "job_status", "", "job_error_msg", "", "url", "token", "type", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJob_status", "()I", "setJob_status", "(I)V", "getJob_error_msg", "()Ljava/lang/String;", "setJob_error_msg", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getToken", "setToken", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CheckImportResult implements Serializable {
        private String job_error_msg;
        private int job_status;
        private String token;
        private String type;
        private String url;

        public static /* synthetic */ CheckImportResult copy$default(CheckImportResult r3, int r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.job_status;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.job_error_msg;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.url;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.token;
        L14:
            String r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.type;
        L17:
            int r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final int component1() {
            return this.job_status;
        }

        public final String component2() {
            return this.job_error_msg;
        }

        public final String component3() {
            return this.url;
        }

        public final String component4() {
            return this.token;
        }

        public final String component5() {
            return this.type;
        }

        public final CheckImportResult copy(int r8, String r9, String r10, String r11, String r12) {
            return new CheckImportResult(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CheckImportResult) == true) goto L8;
            return false;
        L8:
            CheckImportResult r6 = (CheckImportResult) r5;
            if (this.job_status == r6.job_status) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.job_error_msg, r6.job_error_msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.url, r6.url) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.token, r6.token) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L23;
            return false;
        L23:
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
            String r5 = this.url;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.token;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.type;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
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
            return "CheckImportResult(job_status=" + this.job_status + ", job_error_msg=" + this.job_error_msg + ", url=" + this.url + ", token=" + this.token + ", type=" + this.type + ')';
        }

        public final String getJob_error_msg() {
            return this.job_error_msg;
        }

        public final int getJob_status() {
            return this.job_status;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setJob_error_msg(String r1) {
            this.job_error_msg = r1;
        }

        public final void setJob_status(int r1) {
            this.job_status = r1;
        }

        public final void setToken(String r1) {
            this.token = r1;
        }

        public final void setType(String r1) {
            this.type = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }

        public CheckImportResult(int r1, String r2, String r3, String r4, String r5) {
            this.job_status = r1;
            this.job_error_msg = r2;
            this.url = r3;
            this.token = r4;
            this.type = r5;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/importfile/request/StartImportRequesterManagerImplV2$StartImportResult;", "Ljava/io/Serializable;", "ticket", "", "job_timeout", "", "<init>", "(Ljava/lang/String;I)V", "getTicket", "()Ljava/lang/String;", "setTicket", "(Ljava/lang/String;)V", "getJob_timeout", "()I", "setJob_timeout", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StartImportResult implements Serializable {
        private int job_timeout;
        private String ticket;

        public static /* synthetic */ StartImportResult copy$default(StartImportResult r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.ticket;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.job_timeout;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.ticket;
        }

        public final int component2() {
            return this.job_timeout;
        }

        public final StartImportResult copy(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "ticket");
            return new StartImportResult(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StartImportResult) == true) goto L8;
            return false;
        L8:
            StartImportResult r6 = (StartImportResult) r5;
            if (Intrinsics.areEqual(this.ticket, r6.ticket) == true) goto L12;
            return false;
        L12:
            if (this.job_timeout == r6.job_timeout) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.ticket.hashCode() * 31) + this.job_timeout;
        }

        public String toString() {
            return "StartImportResult(ticket=" + this.ticket + ", job_timeout=" + this.job_timeout + ')';
        }

        public final int getJob_timeout() {
            return this.job_timeout;
        }

        public final String getTicket() {
            return this.ticket;
        }

        public final void setJob_timeout(int r1) {
            this.job_timeout = r1;
        }

        public final void setTicket(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.ticket = r2;
        }

        public StartImportResult(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "ticket");
            this.ticket = r2;
            this.job_timeout = r3;
        }
    }

    public static final class a implements NetService.c<Result<CheckImportResult>> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<CheckImportResult> parse(String r4) {
            Intrinsics.checkNotNullParameter(r4, "json");
            Result<CheckImportResult> r0 = new Result();
            JSONObject r1 = new JSONObject(r4);
            r0.code = r1.optInt("code");
            r0.msg = r1.optString("msg");
            JSONObject r5 = new JSONObject(r1.optString("data"));
            r0.data = (DATA) GsonProtectorUtils.fromJson(new Gson(), r5.optString(TipCallBackData.RESULT), CheckImportResult.class);
            return r0;
        }
    }

    public static final class b {
    }

    public static final class c implements NetService.c<Result<StartImportResult>> {
        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<StartImportResult> parse(String r4) {
            Intrinsics.checkNotNullParameter(r4, "json");
            Result<StartImportResult> r0 = new Result();
            JSONObject r1 = new JSONObject(r4);
            r0.msg = r1.optString("msg");
            r0.code = r1.optInt("code");
            r0.setData((StartImportResult) GsonProtectorUtils.fromJson(new Gson(), r1.optString("data"), StartImportResult.class));
            return r0;
        }
    }

    static {
    }

    public StartImportRequesterManagerImplV2() {
        this.j = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
    }
}
