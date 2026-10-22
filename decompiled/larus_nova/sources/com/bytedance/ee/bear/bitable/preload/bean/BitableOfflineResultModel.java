package com.bytedance.ee.bear.bitable.preload.bean;

import android.text.TextUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\tB-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\fJ\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0006\u0010\"\u001a\u00020\u0007J\u0012\u0010#\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0002R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/preload/bean/BitableOfflineResultModel;", "Ljava/io/Serializable;", "<init>", "()V", "success", "", "message", "", "resValue", "(ZLjava/lang/String;Ljava/lang/String;)V", "isNetClientVars", "data", "(ZZLjava/lang/String;Ljava/lang/String;)V", "code", "", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getData", "setData", "getResValue", "setResValue", "()Ljava/lang/Boolean;", "setNetClientVars", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "toString", "escapeJson", "value", "printAndGetFieldsLengthInfo", "getFieldLength", "field", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableOfflineResultModel implements Serializable {
    public static final int CODE_FAILED = 1;
    public static final int CODE_SUCCESS = 0;
    public static final a Companion = null;
    private int code;
    private String data;
    private Boolean isNetClientVars;
    private String message;
    private String resValue;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String printAndGetFieldsLengthInfo() {
        StringBuilder r100 = new StringBuilder("code: ");
        r100.append(this.code);
        r100.append("--message length: ");
        String r101 = this.message;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.length();
    L6:
        r100.append(r103);
        r100.append("--resValue length: ");
        String r104 = this.resValue;
        if (r104 == null) goto L9;
        int r105 = r104.length();
    L10:
        r100.append(r105);
        r100.append("--resValue length: ");
        String r106 = this.data;
        if (r106 == null) goto L13;
        r102 = r106.length();
    L13:
        r100.append(r102);
        return r100.toString();
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        String r100 = this.message;
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        String r103 = "";
    L26:
        StringBuilder r104 = new StringBuilder("{\"code\": ");
        r104.append(this.code);
        r104.append(",\"message\": \"");
        r104.append(r103);
        r104.append("\",\"resValue\": ");
        Object r105 = "\"\"";
        if (TextUtils.isEmpty(this.resValue) == false) goto L29;
        String r106 = "\"\"";
    L30:
        r104.append(r106);
        r104.append(",\"data\": ");
        if (TextUtils.isEmpty(this.data) == false) goto L33;
        String r107 = "\"\"";
    L34:
        r104.append(r107);
        r104.append(",\"isNetClientVars\": ");
        if (Intrinsics.areEqual(this.isNetClientVars, Boolean.TRUE) == false) goto L38;
        r105 = this.isNetClientVars;
    L38:
        r104.append(r105);
        r104.append('}');
        return r104.toString();
    L33:
        r107 = this.data;
        goto L34
    L29:
        r106 = this.resValue;
        goto L30
    L8:
        StringBuilder r108 = new StringBuilder(r100.length());
        int r109 = r100.length();
    L9:
        if (r101 >= r109) goto L25;
        char r110 = r100.charAt(r101);
        if (r110 != '\r') goto L13;
        r108.append("\\r");
    L24:
        r101 = r101 + 1;
        goto L9
    L13:
        if (r110 != '\"') goto L15;
        r108.append("\\\"");
        goto L24
    L15:
        if (r110 == '\\') goto L21;
        switch(r110) {
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L17;
        };
    L17:
        r108.append(r110);
        goto L24
    L18:
        r108.append("\\n");
        goto L24
    L19:
        r108.append("\\t");
        goto L24
    L20:
        r108.append("\\b");
        goto L24
    L21:
        r108.append("\\\\");
        goto L24
    L25:
        r103 = r108.toString();
        goto L26
    L5:
        r102 = false;
        goto L6
    }

    public BitableOfflineResultModel() {
        this.code = 1;
        this.message = "";
    }

    public final int getCode() {
        return this.code;
    }

    public final String getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getResValue() {
        return this.resValue;
    }

    public final Boolean isNetClientVars() {
        return this.isNetClientVars;
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setData(String r100) {
        this.data = r100;
    }

    public final void setMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.message = r100;
    }

    public final void setNetClientVars(Boolean r100) {
        this.isNetClientVars = r100;
    }

    public final void setResValue(String r100) {
        this.resValue = r100;
    }

    public BitableOfflineResultModel(boolean r100, String r101, String r102) {
        this();
        this.code = !r100 ? 1 : 0;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.message = r101;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        this.resValue = r102;
    }

    public BitableOfflineResultModel(boolean r100, boolean r101, String r102, String r103) {
        this();
        this.code = !r100 ? 1 : 0;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this.message = r102;
        this.isNetClientVars = Boolean.valueOf(r101);
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.data = r103;
    }
}
