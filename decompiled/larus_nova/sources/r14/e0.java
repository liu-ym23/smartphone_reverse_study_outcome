package r14;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R$\u0010)\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\"\u0010,\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010!\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%¨\u00061"}, d2 = {"Lr14/e0;", "Ln14/a;", "Lr14/a0;", "logPb", "Lr14/a0;", ce.f26391f, "()Lr14/a0;", "setLogPb", "(Lr14/a0;)V", "", "Lr14/c;", "items", "Ljava/util/List;", "f", "()Ljava/util/List;", "h", "(Ljava/util/List;)V", "Lr14/r;", "contentSdkFilterItems", "Lr14/r;", "e", "()Lr14/r;", "setContentSdkFilterItems", "(Lr14/r;)V", "", "requestId", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "", "refreshClear", "I", "getRefreshClear", "()I", "setRefreshClear", "(I)V", "status_code", "getStatus_code", "setStatus_code", "status_msg", "getStatus_msg", "setStatus_msg", "error_code", "getError_code", "setError_code", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class e0 extends n14.a {

    @SerializedName("content_sdk_filter_items")
    private r contentSdkFilterItems;

    @SerializedName("error_code")
    private int error_code;

    @SerializedName("aweme_list")
    private List<c> items;

    @SerializedName("log_pb")
    private a0 logPb;

    @SerializedName("refresh_clear")
    private int refreshClear;

    @SerializedName("rid")
    private String requestId;

    @SerializedName("status_code")
    private int status_code;

    @SerializedName("status_msg")
    private String status_msg;

    public e0() {
    }

    public final r e() {
        return this.contentSdkFilterItems;
    }

    public final List<c> f() {
        return this.items;
    }

    public final a0 g() {
        return this.logPb;
    }

    public final void h(List<c> r100) {
        this.items = r100;
    }
}
