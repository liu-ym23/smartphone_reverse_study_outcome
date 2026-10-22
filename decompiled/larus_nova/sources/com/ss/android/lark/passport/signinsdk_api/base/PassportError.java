package com.ss.android.lark.passport.signinsdk_api.base;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0001#B/\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\n\u0010\u000bB-\b\u0012\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0003J\b\u0010\"\u001a\u00020\u0006H\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/PassportError;", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "errCode", "", "bizCode", "debugMsg", "", BaseHttpRequestInfo.KEY_EXCEPTION, "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(IILjava/lang/String;Ljava/lang/Exception;)V", "err", "Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkErrorResult;", "converter", "Lkotlin/Function1;", "(Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkErrorResult;ILkotlin/jvm/functions/Function1;)V", "rawErrorCode", "getRawErrorCode", "()I", "value", "customBizCode", "getCustomBizCode", "isNetworkError", "", "()Z", "networkError", "getNetworkError", "()Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkErrorResult;", "withBiz", "upperBizCode", "message", "getMessage", "()Ljava/lang/String;", "toString", "Companion", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PassportError extends ErrorResult {
    public static final a Companion = null;
    private int customBizCode;
    private final NetworkErrorResult networkError;
    private final int rawErrorCode;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PassportError() {
        throw null;
    }

    public final boolean isNetworkError() {
        if (this.networkError == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "PassportError(rawCode=" + this.rawErrorCode + ", isNetworkError=" + isNetworkError() + ", bizCode=" + this.customBizCode + ", debugMsg=" + getDebugMsg() + ')';
    }

    @Override // com.larksuite.framework.callback.Entity.ErrorResult, java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    public final int getCustomBizCode() {
        return this.customBizCode;
    }

    public final NetworkErrorResult getNetworkError() {
        return this.networkError;
    }

    public final int getRawErrorCode() {
        return this.rawErrorCode;
    }

    public final PassportError withBiz(int r100) {
        if (this.customBizCode != (-9999)) goto L5;
        this.customBizCode = r100;
    L5:
        return this;
    }

    @JvmStatic
    public static final PassportError bizCodeOnly(int r100, String r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, "msg");
        Exception r102 = new Exception(r101);
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, BaseHttpRequestInfo.KEY_EXCEPTION);
        return new PassportError(r100, r100, r101, r102, null);
    }

    @JvmStatic
    public static final PassportError errorCodeOnly(int r100, String r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, "msg");
        Exception r102 = new Exception(r101);
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, BaseHttpRequestInfo.KEY_EXCEPTION);
        return new PassportError(r100, -9999, r101, r102, null);
    }

    @JvmStatic
    public static final PassportError bizCodeOnly(int r100, String r101, Exception r102) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, BaseHttpRequestInfo.KEY_EXCEPTION);
        return new PassportError(r100, r100, r101, r102, null);
    }

    @JvmStatic
    public static final PassportError errorCodeOnly(int r100, String r101, Exception r102) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, BaseHttpRequestInfo.KEY_EXCEPTION);
        return new PassportError(r100, -9999, r101, r102, null);
    }

    @JvmStatic
    public static final PassportError networkError(NetworkErrorResult r100, int r101, Function1<? super NetworkErrorResult, ? extends ErrorResult> r102) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r102, "converter");
        return new PassportError(r100, r101, r102, null);
    }

    @JvmStatic
    public static final PassportError withBizInfo(int r100, int r101, String r102) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r102, "msg");
        Exception r103 = new Exception(r102);
        Intrinsics.checkNotNullParameter(r102, "msg");
        Intrinsics.checkNotNullParameter(r103, BaseHttpRequestInfo.KEY_EXCEPTION);
        return new PassportError(r100, r101, r102, r103, null);
    }

    public PassportError(NetworkErrorResult r100, int r101, Function1 r102, DefaultConstructorMarker r103) {
        super("");
        copyFrom((ErrorResult) r102.invoke(r100));
        this.rawErrorCode = r100.getRawErrorCode();
        if (r100.getBizCode() == (-9999)) goto L5;
        r101 = r100.getBizCode();
    L5:
        this.customBizCode = r101;
        this.networkError = r100;
    }

    @JvmStatic
    public static final PassportError withBizInfo(int r100, int r101, String r102, Exception r110) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r102, "msg");
        Intrinsics.checkNotNullParameter(r110, BaseHttpRequestInfo.KEY_EXCEPTION);
        return new PassportError(r100, r101, r102, r110, null);
    }

    public PassportError(int r100, int r101, String r102, Exception r110, DefaultConstructorMarker r111) {
        if (r102 != null) goto L4;
        r102 = "";
    L4:
        super(r100, r102, "", "", r110);
        this.rawErrorCode = r100;
        this.customBizCode = r101;
        this.networkError = null;
    }
}
