package tw0;

import com.bytedance.android.live.recharge.order.aio.OrderResultCode;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Ltw0/h;", "", "", "resultCode", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setResultCode", "(I)V", "errorCode", "getErrorCode", "b", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "errorPrompt", "getErrorPrompt", "d", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.order.BuyDiamondResponse")
public final class h {

    @SerializedName("error_code")
    private int errorCode;

    @SerializedName("error_message")
    private String errorMessage;

    @SerializedName("error_prompt")
    private String errorPrompt;

    @SerializedName("result_code")
    private int resultCode;

    public h() {
        this.errorMessage = "";
        this.errorPrompt = "";
    }

    public final int a() {
        return this.resultCode;
    }

    public final void b(int r100) {
        this.errorCode = r100;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorMessage = r100;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorPrompt = r100;
    }

    public final void e(OrderResultCode r100) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        this.resultCode = r100.getValue();
    }
}
