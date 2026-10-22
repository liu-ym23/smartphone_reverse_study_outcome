package xw;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lxw/g;", "Lxw/e;", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "data", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "e", "(Ljava/lang/Object;)V", "Lxw/c;", "error", "Lxw/c;", "c", "()Lxw/c;", "f", "(Lxw/c;)V", "<init>", "()V", "runtime"}, k = 1, mv = {1, 4, 0})
public final class g extends e {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("data")
    private Object data;

    @SerializedName("error")
    private c error;

    public g() {
        this.channelId = "";
    }

    public final String a() {
        return this.channelId;
    }

    public final Object b() {
        return this.data;
    }

    public final c c() {
        return this.error;
    }

    public final void d(String r100) {
        this.channelId = r100;
    }

    public final void e(Object r100) {
        this.data = r100;
    }

    public final void f(c r100) {
        this.error = r100;
    }
}
