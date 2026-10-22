package com.obric.assistant.security.provision.check.bean;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0007H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/security/provision/check/bean/ProvisionResult;", "", "code", "", "data", "Lcom/obric/assistant/security/provision/check/bean/Data;", "msg", "", "clientCode", "<init>", "(ILcom/obric/assistant/security/provision/check/bean/Data;Ljava/lang/String;I)V", "getCode", "()I", "getData", "()Lcom/obric/assistant/security/provision/check/bean/Data;", "getMsg", "()Ljava/lang/String;", "getClientCode", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProvisionResult {
    public static final int CODE_CLIENT_BIND_ERROR = 1002;
    public static final int CODE_CLIENT_CALL_API_EXCEPTION = 1003;
    public static final int CODE_CLIENT_PARSE_ERROR = 1001;
    public static final int CODE_DEFAULT = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final a Companion = null;
    private static final String KEY_CODE = "code";
    private static final String KEY_DATA = "data";
    private static final String KEY_LOG_ID = "log_id";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_MSG = "msg";
    private static final String TAG = "ProvisionResult";
    private final int clientCode;
    private final int code;
    private final Data data;
    private final String msg;

    public static final class a {
        public a() {
        }

        public static ProvisionResult a(Bundle r110) {
            String r100 = "";
            Intrinsics.checkNotNullParameter(r110, "bundle");
            Bundle r101 = r110.getBundle("data");     // Catch: Exception -> L20
            if (r101 == null) goto L13;
            int r102 = r101.getInt("code", -1000);     // Catch: Exception -> L20
            String r103 = r101.getString("log_id");     // Catch: Exception -> L20
            if (r103 != null) goto L9;
            r103 = "";
        L9:
            String r104 = r101.getString("message");     // Catch: Exception -> L20
            if (r104 != null) goto L12;
            r104 = "";
        L12:
            Data r105 = new Data(r102, r103, r104);     // Catch: Exception -> L20
        L14:
            Data r106 = r105;
            int r107 = r110.getInt("code", -1000);     // Catch: Exception -> L20
            String r108 = r110.getString("msg");     // Catch: Exception -> L20
            if (r108 != null) goto L17;
            String r109 = "";
        L18:
            return new ProvisionResult(r107, r106, r109, 0, 8, null);
        L17:
            r109 = r108;
            goto L18
        L13:
            r105 = null;
        L20:
            e = move-exception;
            FLogger r111 = FLogger.f375446a;
            StringBuilder r112 = new StringBuilder("fromBundle() bundle=");
            int r113 = xfa.a.f563551a;
            Intrinsics.checkNotNullParameter(r110, "bundle");
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L24
            r100 = xfa.a.b(r110, 0);     // Catch: Throwable -> L24
        L26:
            r112.append(r100);
            r112.append(", e.msg=");
            r112.append(e.getMessage());
            r111.e(ProvisionResult.TAG, r112.toString(), e);
            return new ProvisionResult(0, null, "parse bundle exception", 1001, 3, null);
        L24:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L26
        }
    }

    static {
        Companion = new a();
    }

    public ProvisionResult() {
        this(0, null, null, 0, 15, null);
    }

    public static /* synthetic */ ProvisionResult copy$default(ProvisionResult r100, int r101, Data r102, String r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.data;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.msg;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.clientCode;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.code;
    }

    public final Data component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final int component4() {
        return this.clientCode;
    }

    public final ProvisionResult copy(int r100, Data r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        return new ProvisionResult(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProvisionResult) == true) goto L8;
        return false;
    L8:
        ProvisionResult r101 = (ProvisionResult) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L18;
        return false;
    L18:
        if (this.clientCode == r101.clientCode) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        Data r101 = this.data;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.msg.hashCode()) * 31) + this.clientCode;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "{code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", clientCode=" + this.clientCode + '}';
    }

    public final int getClientCode() {
        return this.clientCode;
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public ProvisionResult(int r100, Data r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        this.code = r100;
        this.data = r101;
        this.msg = r102;
        this.clientCode = r103;
    }

    public /* synthetic */ ProvisionResult(int r100, Data r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = -1000;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = -1000;
    L14:
        this(r100, r101, r102, r103);
    }
}
