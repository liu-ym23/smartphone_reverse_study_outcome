package lc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Llc6/q;", "", "", "resourceId", "J", "getResourceId", "()J", "d", "(J)V", "", "path", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "", "errorCode", "I", "getErrorCode", "()I", "b", "(I)V", "assetsType", "getAssetsType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.RequireAssetsResult")
public final class q {

    @SerializedName("assets_type")
    private int assetsType;

    @SerializedName("error_code")
    private int errorCode;

    @SerializedName("path")
    private String path;

    @SerializedName("resource_id")
    private long resourceId;

    public q() {
        this.path = "";
    }

    public final void a(int r100) {
        this.assetsType = r100;
    }

    public final void b(int r100) {
        this.errorCode = r100;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.path = r100;
    }

    public final void d(long r100) {
        this.resourceId = r100;
    }
}
