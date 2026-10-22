package com.bytedance.locallife.cube.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/CubeLynxError;", "", "errorCode", "", "errorMsg", "", "errorObj", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getErrorObj", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "isFatalError", "toString", "Companion", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeLynxError extends Throwable {
    public static final Companion Companion = null;
    public static final int LYNX_ERROR_CODE_LOAD_MAIN_BUNDLE = 102;
    public static final int LYNX_ERROR_CODE_LOAD_TEMPLATE = 100;
    public static final int LYNX_ERROR_CODE_TEMPLATE_PROVIDER = 103;
    private final int errorCode;
    private final String errorMsg;
    private final JSONObject errorObj;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/CubeLynxError$Companion;", "", "()V", "LYNX_ERROR_CODE_LOAD_MAIN_BUNDLE", "", "LYNX_ERROR_CODE_LOAD_TEMPLATE", "LYNX_ERROR_CODE_TEMPLATE_PROVIDER", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ CubeLynxError copy$default(CubeLynxError r100, int r101, String r102, JSONObject r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.errorCode;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errorMsg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.errorObj;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final JSONObject component3() {
        return this.errorObj;
    }

    public final CubeLynxError copy(int r100, String r101, JSONObject r102) {
        return new CubeLynxError(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CubeLynxError) == true) goto L8;
        return false;
    L8:
        CubeLynxError r101 = (CubeLynxError) r100;
        if (this.errorCode == r101.errorCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorObj, r101.errorObj) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.errorCode * 31;
        String r101 = this.errorMsg;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JSONObject r105 = this.errorObj;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final boolean isFatalError() {
        int r100 = this.errorCode;
        if (1 <= r100) goto L5;
        return false;
    L5:
        if (r100 >= 200) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CubeLynxError(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", errorObj=" + this.errorObj + ')';
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final JSONObject getErrorObj() {
        return this.errorObj;
    }

    public CubeLynxError(int r100, String r101, JSONObject r102) {
        super(r101);
        this.errorCode = r100;
        this.errorMsg = r101;
        this.errorObj = r102;
    }

    public /* synthetic */ CubeLynxError(int r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
