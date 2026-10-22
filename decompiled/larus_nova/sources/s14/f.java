package s14;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Ls14/f;", "", "", "keyword", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, "getLang", "setLang", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class f {

    @SerializedName("keyword")
    private String keyword;

    @SerializedName(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL)
    private String lang;

    public f() {
    }

    public final int hashCode() {
        String r100 = this.keyword;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(r101.keyword, this.keyword) == true) goto L10;
    L12:
        return false;
    L10:
        if (Intrinsics.areEqual(r101.lang, this.lang) == false) goto L12;
        return true;
    L14:
        return false;
    }
}
