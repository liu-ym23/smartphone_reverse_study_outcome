package xw;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lxw/a;", "Lxw/e;", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "", "flags", "I", "b", "()I", "d", "(I)V", "<init>", "()V", "runtime"}, k = 1, mv = {1, 4, 0})
public final class a extends e {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("flags")
    private int flags;

    public a() {
        this.channelId = "";
    }

    public final String a() {
        return this.channelId;
    }

    public final int b() {
        return this.flags;
    }

    public final void c(String r100) {
        this.channelId = r100;
    }

    public final void d(int r100) {
        this.flags = r100;
    }
}
