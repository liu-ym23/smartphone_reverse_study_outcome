package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class StartImportRequesterManagerImplV2 extends com.bytedance.ee.bear.drive.biz.importfile.request.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NetService f223061j;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/importfile/request/StartImportRequesterManagerImplV2$CheckImportResult;", "Ljava/io/Serializable;", "job_status", "", "job_error_msg", "", "url", "token", "type", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJob_status", "()I", "setJob_status", "(I)V", "getJob_error_msg", "()Ljava/lang/String;", "setJob_error_msg", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getToken", "setToken", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CheckImportResult implements Serializable {
        private String job_error_msg;
        private int job_status;
        private String token;
        private String type;
        private String url;

        public static /* synthetic */ CheckImportResult copy$default(CheckImportResult r100, int r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.job_status;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.job_error_msg;
        L8:
            String r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.url;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.token;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.type;
        L17:
            int r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
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

        public final CheckImportResult copy(int r100, String r101, String r110, String r111, String r112) {
            return new CheckImportResult(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CheckImportResult) == true) goto L8;
            return false;
        L8:
            CheckImportResult r101 = (CheckImportResult) r100;
            if (this.job_status == r101.job_status) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.job_error_msg, r101.job_error_msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.token, r101.token) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L23;
            return false;
        L23:
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
            String r105 = this.url;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.token;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.type;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
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

        public final void setJob_error_msg(String r100) {
            this.job_error_msg = r100;
        }

        public final void setJob_status(int r100) {
            this.job_status = r100;
        }

        public final void setToken(String r100) {
            this.token = r100;
        }

        public final void setType(String r100) {
            this.type = r100;
        }

        public final void setUrl(String r100) {
            this.url = r100;
        }

        public CheckImportResult(int r100, String r101, String r102, String r103, String r104) {
            this.job_status = r100;
            this.job_error_msg = r101;
            this.url = r102;
            this.token = r103;
            this.type = r104;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/importfile/request/StartImportRequesterManagerImplV2$StartImportResult;", "Ljava/io/Serializable;", "ticket", "", "job_timeout", "", "<init>", "(Ljava/lang/String;I)V", "getTicket", "()Ljava/lang/String;", "setTicket", "(Ljava/lang/String;)V", "getJob_timeout", "()I", "setJob_timeout", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StartImportResult implements Serializable {
        private int job_timeout;
        private String ticket;

        public static /* synthetic */ StartImportResult copy$default(StartImportResult r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.ticket;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.job_timeout;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.ticket;
        }

        public final int component2() {
            return this.job_timeout;
        }

        public final StartImportResult copy(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "ticket");
            return new StartImportResult(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof StartImportResult) == true) goto L8;
            return false;
        L8:
            StartImportResult r101 = (StartImportResult) r100;
            if (Intrinsics.areEqual(this.ticket, r101.ticket) == true) goto L12;
            return false;
        L12:
            if (this.job_timeout == r101.job_timeout) goto L14;
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

        public final void setJob_timeout(int r100) {
            this.job_timeout = r100;
        }

        public final void setTicket(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.ticket = r100;
        }

        public StartImportResult(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "ticket");
            this.ticket = r100;
            this.job_timeout = r101;
        }
    }

    public static final class a implements NetService.c<Result<CheckImportResult>> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<CheckImportResult> parse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Result<CheckImportResult> r101 = new Result();
            JSONObject r102 = new JSONObject(r100);
            r101.code = r102.optInt("code");
            r101.msg = r102.optString("msg");
            JSONObject r103 = new JSONObject(r102.optString("data"));
            r101.data = (DATA) GsonProtectorUtils.fromJson(new Gson(), r103.optString("result"), CheckImportResult.class);
            return r101;
        }
    }

    public static final class b {
    }

    public static final class c implements NetService.c<Result<StartImportResult>> {
        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<StartImportResult> parse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Result<StartImportResult> r101 = new Result();
            JSONObject r102 = new JSONObject(r100);
            r101.msg = r102.optString("msg");
            r101.code = r102.optInt("code");
            r101.setData((StartImportResult) GsonProtectorUtils.fromJson(new Gson(), r102.optString("data"), StartImportResult.class));
            return r101;
        }
    }

    static {
    }

    public StartImportRequesterManagerImplV2() {
        this.f223061j = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
    }
}
