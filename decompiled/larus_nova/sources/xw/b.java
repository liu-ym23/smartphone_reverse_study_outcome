package xw;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lxw/b;", "Lxw/e;", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "interfaceId", "c", ce.f26391f, "methodId", "d", "h", "contentType", "b", "f", "<init>", "()V", "runtime"}, k = 1, mv = {1, 4, 0})
public final class b extends e {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("content_type")
    private String contentType;

    @SerializedName("interface_id")
    private String interfaceId;

    @SerializedName("method_id")
    private String methodId;

    public final void f() {
        this.contentType = "application/json";
    }

    public b() {
        this.channelId = "";
        this.interfaceId = "";
        this.methodId = "";
        this.contentType = "";
    }

    public final String a() {
        return this.channelId;
    }

    public final String b() {
        return this.contentType;
    }

    public final String c() {
        return this.interfaceId;
    }

    public final String d() {
        return this.methodId;
    }

    public final void e(String r100) {
        this.channelId = r100;
    }

    public final void g(String r100) {
        this.interfaceId = r100;
    }

    public final void h(String r100) {
        this.methodId = r100;
    }
}
