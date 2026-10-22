package js4;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u0019\u0010\u001a\u001a\u0002H\u001b\"\f\b\u0001\u0010\u001b*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u0002H\u001b\"\f\b\u0001\u0010\u001b*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J!\u0010!\u001a\u0002H\u001b\"\f\b\u0001\u0010\u001b*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/base/ChartBaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "code", "", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isSuccess", "", "defaultError", "V", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/base/ChartBaseResponse;", "fromRequestError", "error", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "(Lcom/larksuite/framework/callback/Entity/ErrorResult;)Lcom/bytedance/ee/bear/bitable/homepage/chart/base/ChartBaseResponse;", "fromThrowable", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/Throwable;)Lcom/bytedance/ee/bear/bitable/homepage/chart/base/ChartBaseResponse;", "NoData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class a<T> {

    @SerializedName("code")
    private Integer code;

    @SerializedName("data")
    private T data;

    @SerializedName("msg")
    private String msg;

    /* JADX INFO: renamed from: js4.a$a, reason: collision with other inner class name */
    public static final class C6483a extends a<Unit> {
        public C6483a() {
        }
    }

    public a() {
    }

    public final void a() {
        this.code = -1;
        this.msg = "internal error";
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type V of com.bytedance.ee.bear.bitable.homepage.chart.base.ChartBaseResponse.defaultError");
    }

    public final boolean g() {
        Integer r100 = this.code;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 0) goto L8;
        return true;
    }

    public final Integer d() {
        return this.code;
    }

    public final T e() {
        return this.data;
    }

    public final String f() {
        return this.msg;
    }

    public final void b(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.code = Integer.valueOf(r100.getCode());
        this.msg = r100.getDebugMsg();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type V of com.bytedance.ee.bear.bitable.homepage.chart.base.ChartBaseResponse.fromRequestError");
    }

    public final void c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        this.code = -1;
        this.msg = r100.getMessage();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type V of com.bytedance.ee.bear.bitable.homepage.chart.base.ChartBaseResponse.fromThrowable");
    }
}
