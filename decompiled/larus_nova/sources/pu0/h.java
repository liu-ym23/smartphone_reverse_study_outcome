package pu0;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lpu0/h;", "", "", "left", FaceService.girlLabel, "getLeft", "()F", "b", "(F)V", "top", "getTop", "d", "right", "getRight", "c", "bottom", "getBottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.live_pet.NormalizedRect")
public final class h {

    @SerializedName("bottom")
    private float bottom;

    @SerializedName("left")
    private float left;

    @SerializedName("right")
    private float right;

    @SerializedName("top")
    private float top;

    public h() {
    }

    public final void a(float r100) {
        this.bottom = r100;
    }

    public final void b(float r100) {
        this.left = r100;
    }

    public final void c(float r100) {
        this.right = r100;
    }

    public final void d(float r100) {
        this.top = r100;
    }
}
