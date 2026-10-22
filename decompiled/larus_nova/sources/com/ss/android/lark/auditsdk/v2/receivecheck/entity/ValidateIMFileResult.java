package com.ss.android.lark.auditsdk.v2.receivecheck.entity;

import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR1\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/ValidateIMFileResult;", "Ljava/io/Serializable;", "resultType", "Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/IMFileResult;", "validateResult", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;", "resultMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/IMFileResult;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;Ljava/util/HashMap;)V", "getResultType", "()Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/IMFileResult;", "getValidateResult", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;", "getResultMap", "()Ljava/util/HashMap;", "isResultNeedReCheck", "", "isRemoteValidResult", "Companion", "ValidateResultJudge", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ValidateIMFileResult implements Serializable {
    public static final a Companion = null;
    private final HashMap<String, ValidateIMFileResult> resultMap;
    private final IMFileResult resultType;
    private final ValidateResult validateResult;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ValidateIMFileResult a(ValidateIMFileResult r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
            return r100;
        L11:
            HashMap<String, ValidateIMFileResult> r103 = r100.getResultMap();
            if (r103 == null) goto L18;
            ValidateIMFileResult r104 = r103.get(r101);
            if (r104 != null) goto L17;
            return r100;
        L17:
            return r104;
        L18:
            return r100;
        L5:
            if (r101.length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        @JvmStatic
        public static ValidateIMFileResult b(ValidateResult r100, b r101, AuthorityParam.AuthorityExtraParam r102) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "judge");
            Intrinsics.checkNotNullParameter(r102, "authorityExtraParam");
            IMFileResult.a r103 = IMFileResult.Companion;
            ResultType r104 = r100.getResult();
            boolean r105 = r100.isCredible();
            r103.getClass();
            return new ValidateIMFileResult(IMFileResult.a.b(r104, r101, r105, r102), r100, null, 4, null);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f409683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f409684b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f409683a == r101.f409683a) goto L12;
            return false;
        L12:
            if (this.f409684b == r101.f409684b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f409683a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f409684b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "ValidateResultJudge(isRemote=" + this.f409683a + ", hasAsyncResult=" + this.f409684b + ')';
        }

        public b(boolean r100, boolean r101) {
            this.f409683a = r100;
            this.f409684b = r101;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final ValidateIMFileResult getResultByFileKey(ValidateIMFileResult r100, String r101) {
        Companion.getClass();
        return a.a(r100, r101);
    }

    @JvmStatic
    public static final ValidateIMFileResult toIMResult(ValidateResult r100, b r101, AuthorityParam.AuthorityExtraParam r102) {
        Companion.getClass();
        return a.b(r100, r101, r102);
    }

    @JvmStatic
    public static final ValidateResult defaultValidateResult() {
        Companion.getClass();
        return new ValidateResult(ResultType.UNKNOWN);
    }

    public final boolean isRemoteValidResult() {
        IMFileResult r100 = this.resultType;
        if (r100 != IMFileResult.ALLOW) goto L5;
    L8:
        return true;
    L5:
        if (r100 == IMFileResult.DENY) goto L8;
        return false;
    }

    public final boolean isResultNeedReCheck() {
        return !this.validateResult.isCredible();
    }

    public final HashMap<String, ValidateIMFileResult> getResultMap() {
        return this.resultMap;
    }

    public final IMFileResult getResultType() {
        return this.resultType;
    }

    public final ValidateResult getValidateResult() {
        return this.validateResult;
    }

    public ValidateIMFileResult(IMFileResult r100, ValidateResult r101, HashMap<String, ValidateIMFileResult> r102) {
        Intrinsics.checkNotNullParameter(r100, "resultType");
        Intrinsics.checkNotNullParameter(r101, "validateResult");
        this.resultType = r100;
        this.validateResult = r101;
        this.resultMap = r102;
    }

    public /* synthetic */ ValidateIMFileResult(IMFileResult r100, ValidateResult r101, HashMap r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
