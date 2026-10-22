package jf9;

import com.larus.im.internal.jni.bean.OMNIAVSessionType;
import com.larus.im.internal.trace.manager.definition.AVCommonError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends if9.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f498912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f498913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile long f498914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f498915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AVCommonError f498916o;

    public final String toString() {
        return "RTCConnectRootStep(" + c() + ", realStart=" + this.f498914m + ')';
    }

    @Override // if9.a
    public final AVCommonError j() {
        return this.f498916o;
    }

    @Override // if9.a
    public final void g(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        r100.put("session_type", OMNIAVSessionType.RTC.value);
        r100.put("used", this.f498915n ? 1 : 0);
        r100.put("is_new_conn", this.f498912k ? 1 : 0);
        if (this.f498913l == true) goto L5;
    L7:
        long r101 = m().k(this);
    L8:
        r100.put("total", r101);
        r100.put("link_total", m().k(this));
        r100.put("client_pre_connect", this.f498913l ? 1 : 0);
        return;
    L5:
        if (this.f498914m <= 0) goto L7;
        r101 = if9.a.e(this.f498914m, m().f489628c);
        goto L8
    }

    public c(long r100, boolean r101, boolean r102) {
        super("RTCConnectRootStep", r100);
        this.f498912k = r101;
        this.f498913l = r102;
        this.f498914m = -1;
        this.f498916o = AVCommonError.Connect_Timeout_Unknown;
    }
}
