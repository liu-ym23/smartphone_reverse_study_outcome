package ld7;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AuthBridgeAccess f508730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f508731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f508732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AuthConfigType f508733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f508734f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f508729a, r101.f508729a) == true) goto L12;
        return false;
    L12:
        if (this.f508730b == r101.f508730b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508731c, r101.f508731c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f508729a.hashCode() * 31) + this.f508730b.hashCode()) * 31) + this.f508731c.hashCode();
    }

    public final String toString() {
        return "BridgeInfo(bridgeName=" + this.f508729a + ", auth=" + this.f508730b + ", params=" + this.f508731c + ')';
    }

    public e(String r100, AuthBridgeAccess r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        Intrinsics.checkNotNullParameter(r101, "auth");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f508729a = r100;
        this.f508730b = r101;
        this.f508731c = r102;
        this.f508733e = AuthConfigType.UNKNOWN;
    }
}
