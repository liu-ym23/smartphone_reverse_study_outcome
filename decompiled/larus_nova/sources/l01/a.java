package l01;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Ll01/a;", "", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "secUserId", "getSecUserId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.user.CoreCurrentUserInfo")
public final class a {

    @SerializedName("sec_user_id")
    private String secUserId;

    @SerializedName("user_id")
    private String userId;

    public a() {
        this.userId = "";
        this.secUserId = "";
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secUserId = r100;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }
}
