package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lrc/m;", "", "", "page", "Ljava/lang/String;", "getPage", "()Ljava/lang/String;", "setPage", "(Ljava/lang/String;)V", "", "bstReportEnable", "Z", "getBstReportEnable", "()Z", "setBstReportEnable", "(Z)V", "originReportEnable", "getOriginReportEnable", "setOriginReportEnable", "btm", "getBtm", "setBtm", "platform", "getPlatform", "setPlatform", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class m {

    @SerializedName("bst_report_enable")
    private boolean bstReportEnable;

    @SerializedName("btm")
    private String btm;

    @SerializedName("origin_report_enable")
    private boolean originReportEnable;

    @SerializedName("page")
    private String page;

    @SerializedName("platform")
    private String platform;

    public final int hashCode() {
        return (this.btm.hashCode() * 31) + this.platform.hashCode();
    }

    public m() {
        this.page = "";
        this.btm = "";
        this.platform = "native";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(m.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        m r102 = (m) r100;
        if ((!Intrinsics.areEqual(this.btm, r102.btm)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.platform, r102.platform)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.bst.api.config.PageControl");
    L8:
        r101 = null;
        goto L10
    }
}
